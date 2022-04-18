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
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
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
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.ThreadPublishHttpResMeesage;
import com.baidu.tieba.pb.data.ThreadPublishSocketResMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
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
import com.repackage.a9;
import com.repackage.ad5;
import com.repackage.aq4;
import com.repackage.as8;
import com.repackage.ax7;
import com.repackage.ay7;
import com.repackage.b05;
import com.repackage.b9;
import com.repackage.bn4;
import com.repackage.bs7;
import com.repackage.by4;
import com.repackage.cl8;
import com.repackage.cr4;
import com.repackage.cs7;
import com.repackage.ct7;
import com.repackage.cu4;
import com.repackage.cv7;
import com.repackage.dd5;
import com.repackage.dg;
import com.repackage.dj8;
import com.repackage.ds8;
import com.repackage.dt7;
import com.repackage.dy7;
import com.repackage.eg;
import com.repackage.en8;
import com.repackage.er4;
import com.repackage.ey7;
import com.repackage.fc5;
import com.repackage.ff5;
import com.repackage.fo;
import com.repackage.fr7;
import com.repackage.gt7;
import com.repackage.gw7;
import com.repackage.gx7;
import com.repackage.hl8;
import com.repackage.hr7;
import com.repackage.hv4;
import com.repackage.hw4;
import com.repackage.hx7;
import com.repackage.hz4;
import com.repackage.i05;
import com.repackage.i35;
import com.repackage.ic5;
import com.repackage.if5;
import com.repackage.iw7;
import com.repackage.j25;
import com.repackage.j85;
import com.repackage.jr4;
import com.repackage.jt6;
import com.repackage.jz7;
import com.repackage.k08;
import com.repackage.k25;
import com.repackage.ko4;
import com.repackage.kw7;
import com.repackage.kx7;
import com.repackage.l25;
import com.repackage.l36;
import com.repackage.l85;
import com.repackage.lr4;
import com.repackage.lu7;
import com.repackage.lw7;
import com.repackage.lx7;
import com.repackage.m25;
import com.repackage.m36;
import com.repackage.m98;
import com.repackage.mg;
import com.repackage.mi;
import com.repackage.ml4;
import com.repackage.mn4;
import com.repackage.na8;
import com.repackage.ni;
import com.repackage.ni4;
import com.repackage.nq4;
import com.repackage.nr4;
import com.repackage.o25;
import com.repackage.oi;
import com.repackage.oi4;
import com.repackage.p05;
import com.repackage.p25;
import com.repackage.p55;
import com.repackage.p75;
import com.repackage.p85;
import com.repackage.pg;
import com.repackage.pp4;
import com.repackage.ps7;
import com.repackage.qn6;
import com.repackage.qu7;
import com.repackage.qv7;
import com.repackage.qx4;
import com.repackage.qy4;
import com.repackage.rp4;
import com.repackage.rs7;
import com.repackage.rt4;
import com.repackage.rw5;
import com.repackage.s05;
import com.repackage.sk8;
import com.repackage.sv7;
import com.repackage.sy4;
import com.repackage.tc8;
import com.repackage.tk8;
import com.repackage.tq4;
import com.repackage.ts7;
import com.repackage.u05;
import com.repackage.u75;
import com.repackage.ud5;
import com.repackage.ul4;
import com.repackage.ul5;
import com.repackage.uo;
import com.repackage.uo4;
import com.repackage.uy4;
import com.repackage.v05;
import com.repackage.vn4;
import com.repackage.vt4;
import com.repackage.wa;
import com.repackage.we6;
import com.repackage.wx7;
import com.repackage.wz4;
import com.repackage.xo;
import com.repackage.yu7;
import com.repackage.yv7;
import com.repackage.yx7;
import com.repackage.yy7;
import com.repackage.yz4;
import com.repackage.zo4;
import com.repackage.zt4;
import com.repackage.zx7;
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
public class PbFragment extends BaseFragment implements if5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, cr4.e, TbRichTextView.s, TbPageContextSupport, jz7, k08.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k K2;
    public static final m36.b L2;
    public transient /* synthetic */ FieldHolder $fh;
    public dg<TextView> A;
    public ts7 A0;
    public CustomMessageListener A1;
    public final View.OnClickListener A2;
    public dg<TbImageView> B;
    public ShareSuccessReplyToServerModel B0;
    public final CustomMessageListener B1;
    public final ItemCardHelper.c B2;
    public dg<ImageView> C;
    public gw7 C0;
    public CustomMessageListener C1;
    public final NoNetworkView.b C2;
    public dg<View> D;
    public boolean D0;
    public CustomMessageListener D1;
    public View.OnTouchListener D2;
    public dg<TiebaPlusRecommendCard> E;
    public boolean E0;
    public View.OnClickListener E1;
    public l36.b E2;
    public dg<LinearLayout> F;
    public boolean F0;
    public CustomMessageListener F1;
    public final yu7.b F2;
    public dg<RelativeLayout> G;
    public iw7 G0;
    public CustomMessageListener G1;
    public int G2;
    public dg<ItemCardView> H;
    public lr4 H0;
    public CustomMessageListener H1;
    public int H2;
    public boolean I;
    public nr4 I0;
    public SuggestEmotionModel.c I1;
    public String I2;
    public boolean J;
    public String J0;
    public CustomMessageListener J1;
    public ko4 J2;
    public boolean K;
    public boolean K0;
    public GetSugMatchWordsModel.b K1;
    public dg<GifView> L;
    public boolean L0;
    public boolean L1;
    public String M;
    public boolean M0;
    public PraiseModel M1;
    public boolean N;
    public String N0;
    public lx7.h N1;
    public boolean O;
    public boolean O0;
    public CustomMessageListener O1;
    public String P;
    public tk8 P0;
    public p55 P1;
    public hx7 Q;
    public o25 Q0;
    public CheckRealNameModel.b Q1;
    public LikeModel R;
    public m25 R0;
    public dt7 R1;
    public View S;
    public boolean S0;
    public CustomMessageListener S1;
    public View T;
    public PermissionJudgePolicy T0;
    public CustomMessageListener T1;
    public View U;
    public ReplyPrivacyCheckController U0;
    public CustomMessageListener U1;
    public View V;
    public qn6 V0;
    public CustomMessageListener V1;
    public String W;
    public qn6 W0;
    public CustomMessageListener W1;
    public int X;
    public EmotionImageData X0;
    public CustomMessageListener X1;
    public boolean Y;
    public k25 Y0;
    public CustomMessageListener Y1;
    public int[] Z;
    public j25 Z0;
    public cr4.e Z1;
    public AbsPbActivity a;
    public j25 a1;
    public nr4.e a2;
    public boolean b;
    public int b1;
    public SortSwitchButton.f b2;
    public boolean c;
    public Object c1;
    public final View.OnClickListener c2;
    public m36 d;
    public b9 d1;
    public CustomMessageListener d2;
    public lx7 e;
    public zt4 e1;
    public final NewWriteModel.g e2;
    public boolean f;
    public BdUniqueId f1;
    public NewWriteModel.g f2;
    public boolean g;
    public int g0;
    public Runnable g1;
    public wa g2;
    public boolean h;
    public int h0;
    public kw7 h1;
    public final PbModel.g h2;
    public boolean i;
    public int i0;
    public fo i1;
    public CustomMessageListener i2;
    public boolean j;
    public aq4 j0;
    public String j1;
    public HttpMessageListener j2;
    public VoiceManager k;
    public BdUniqueId k0;
    public TbRichTextMemeInfo k1;
    public final ml4.a k2;
    public int l;
    public rt4 l0;
    public boolean l1;
    public final AbsListView.OnScrollListener l2;
    public er4 m;
    public boolean m0;
    public int m1;
    public final a9 m2;
    public long n;
    public boolean n0;
    public int n1;
    public final e3 n2;
    public long o;
    public Object o0;
    public List<c3> o1;
    public final cu4.g o2;
    public long p;
    public sk8 p0;
    public int p1;
    public final View.OnClickListener p2;
    public long q;
    public boolean q0;
    public String q1;
    public boolean q2;
    public long r;
    @NonNull
    public TiePlusEventController.f r0;
    public rw5 r1;
    public final BdListView.p r2;
    public boolean s;
    public wx7 s0;
    public final c3 s1;
    public int s2;
    public boolean t;
    public PbInterviewStatusView.f t0;
    public final qv7.b t1;
    public final TbRichTextView.y t2;
    public j85 u;
    public final Handler u0;
    public final CustomMessageListener u1;
    public boolean u2;
    public long v;
    public PbModel v0;
    public CustomMessageListener v1;
    public PostData v2;
    public boolean w;
    public ey7 w0;
    public CustomMessageListener w1;
    public final er4.c w2;
    public long x;
    public ml4 x0;
    public CustomMessageListener x1;
    public final er4.c x2;
    public int y;
    public ForumManageModel y0;
    public CustomMessageListener y1;
    public final AdapterView.OnItemClickListener y2;
    public String z;
    public by4 z0;
    public CustomMessageListener z1;
    public final View.OnLongClickListener z2;

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
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements lx7.h {
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

        @Override // com.repackage.lx7.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.W5(z);
                if (this.a.C0.I0() != null && z) {
                    this.a.C0.T3(false);
                }
                this.a.C0.c2(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public a1(PbFragment pbFragment) {
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
                this.a.C0.i0();
                boolean z = false;
                if (mi.z()) {
                    if (this.a.v0 != null && !this.a.v0.isLoading) {
                        this.a.u6();
                        this.a.C0.i3();
                        z = true;
                        if (this.a.v0.T0() != null && this.a.v0.T0().f != null && this.a.v0.T0().f.size() > i) {
                            int intValue = this.a.v0.T0().f.get(i).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.v0.m1()).param("fid", this.a.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.a.v0.K2(intValue)) {
                                this.a.i = true;
                                this.a.C0.W2(true);
                            }
                        }
                    }
                    return z;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
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
    public class a2 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ a2 b;

            public a(a2 a2Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a2Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = a2Var;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    gt7.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

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
                pg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a3 implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ PbFragment b;

        public b(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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
                this.b.C0.E3();
                MessageManager.getInstance().sendMessage(this.a);
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ PbFragment e;

        public b0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                if (this.e.H0 != null) {
                    this.e.H0.dismiss();
                }
                if (i == 0) {
                    this.e.C0.i2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e58), ((Integer) this.a.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091e59)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f091ea8);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f091eaa);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f091ea9);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.f1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.f1);
                    this.e.q6(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f091ea6));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes3.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b1 a;

            public a(b1 b1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = b1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                iw7 iw7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (iw7Var = this.a.c.G0) == null || iw7Var.g() == null) {
                    return;
                }
                if (!this.a.c.G0.g().e()) {
                    this.a.c.G0.b(false);
                }
                this.a.c.G0.g().l(false);
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

        public b1(PbFragment pbFragment, String str, String str2) {
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
                int i2 = oi.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = oi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = oi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                PbFragment pbFragment = this.c;
                boolean z = true;
                pbFragment.P4().L0().smoothScrollBy((pbFragment.Z[1] + pbFragment.g0) - i3, 50);
                if (this.c.P4().V0() != null) {
                    this.c.R0.a().setVisibility(8);
                    this.c.P4().V0().o(this.a, this.b, this.c.P4().Y0(), (this.c.v0 == null || this.c.v0.T0() == null || this.c.v0.T0().O() == null || !this.c.v0.T0().O().isBjh()) ? false : false);
                    p25 b = this.c.P4().V0().b();
                    if (b != null && this.c.v0 != null && this.c.v0.T0() != null) {
                        b.G(this.c.v0.T0().d());
                        b.c0(this.c.v0.T0().O());
                    }
                    if (this.c.G0.f() == null && this.c.P4().V0().b().t() != null) {
                        this.c.P4().V0().b().t().f(new a(this));
                        PbFragment pbFragment2 = this.c;
                        pbFragment2.G0.n(pbFragment2.P4().V0().b().t().h());
                        this.c.P4().V0().b().M(this.c.a1);
                    }
                }
                this.c.P4().i1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b2 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ cr4 c;
        public final /* synthetic */ PbFragment d;

        public b2(PbFragment pbFragment, MarkData markData, MarkData markData2, cr4 cr4Var) {
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
                if (this.d.x0 != null) {
                    if (this.d.x0.e()) {
                        this.d.x0.d();
                        this.d.x0.h(false);
                    }
                    this.d.x0.i(this.a);
                    this.d.x0.h(true);
                    this.d.x0.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.v6();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b3 implements qv7.b {
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

        @Override // com.repackage.qv7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.C0.W3(str);
        }

        @Override // com.repackage.qv7.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
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
    public class c0 implements PbInterviewStatusView.f {
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

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.C0.T3(!this.a.N);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c1 implements qn6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$c1$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0223a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0223a(a aVar) {
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
                    iw7 iw7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (iw7Var = this.a.a.c.G0) == null || iw7Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.c.G0.g().e()) {
                        this.a.a.c.G0.b(false);
                    }
                    this.a.a.c.G0.g().l(false);
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

            public a(c1 c1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = oi.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    PbFragment pbFragment = this.a.c;
                    boolean z = true;
                    pbFragment.P4().L0().smoothScrollBy((pbFragment.Z[1] + pbFragment.g0) - i3, 50);
                    if (this.a.c.P4().V0() != null) {
                        this.a.c.R0.a().setVisibility(8);
                        z = (this.a.c.v0 == null || this.a.c.v0.T0() == null || this.a.c.v0.T0().O() == null || !this.a.c.v0.T0().O().isBjh()) ? false : false;
                        cv7 V0 = this.a.c.P4().V0();
                        c1 c1Var = this.a;
                        V0.o(c1Var.a, c1Var.b, c1Var.c.P4().Y0(), z);
                        p25 b = this.a.c.P4().V0().b();
                        if (b != null && this.a.c.v0 != null && this.a.c.v0.T0() != null) {
                            b.G(this.a.c.v0.T0().d());
                            b.c0(this.a.c.v0.T0().O());
                        }
                        if (this.a.c.G0.f() == null && this.a.c.P4().V0().b().t() != null) {
                            this.a.c.P4().V0().b().t().f(new C0223a(this));
                            PbFragment pbFragment2 = this.a.c;
                            pbFragment2.G0.n(pbFragment2.P4().V0().b().t().h());
                            this.a.c.P4().V0().b().M(this.a.c.a1);
                        }
                    }
                    this.a.c.P4().i1();
                }
            }
        }

        public c1(PbFragment pbFragment, String str, String str2) {
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

        @Override // com.repackage.qn6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.qn6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                pg.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.repackage.qn6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c2 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ cr4 b;
        public final /* synthetic */ PbFragment c;

        public c2(PbFragment pbFragment, MarkData markData, cr4 cr4Var) {
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
                this.c.v6();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c3 {
        boolean onBackPressed();
    }

    /* loaded from: classes3.dex */
    public class d extends ad5<ShareItem> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ad5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return zx7.d(this.a.u4(), ShareSwitch.isOn() ? 1 : 6, this.a.v0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(PbFragment pbFragment, int i) {
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
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.a.getUniqueId() || AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, PbFragment.K2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().a) {
                    if (this.a.v4().s() != null && this.a.v4().s().getGodUserData() != null) {
                        this.a.v4().s().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.v0 == null || this.a.v0.T0() == null || this.a.v0.T0().O() == null || this.a.v0.T0().O().getAuthor() == null) {
                        return;
                    }
                    this.a.v0.T0().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements nr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ lr4 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ d1 c;

            public a(d1 d1Var, lr4 lr4Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {d1Var, lr4Var, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = d1Var;
                this.a = lr4Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.v0.i1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.repackage.nr4.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(nr4 nr4Var, int i, View view2) {
                boolean K2;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, nr4Var, i, view2) != null) {
                    return;
                }
                this.a.dismiss();
                int i2 = 3;
                if (this.c.a.v0.i1() != 1 || i != 1) {
                    if (this.c.a.v0.i1() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.v0.i1() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091721 ? 1 : 0).param("obj_type", i2));
                    if (this.c.a.v0.T0().f != null && this.c.a.v0.T0().f.size() > i) {
                        i = this.c.a.v0.T0().f.get(i).sort_type.intValue();
                    }
                    K2 = this.c.a.v0.K2(i);
                    this.b.setTag(Integer.valueOf(this.c.a.v0.h1()));
                    if (K2) {
                        return;
                    }
                    this.c.a.i = true;
                    this.c.a.C0.W2(true);
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091721 ? 1 : 0).param("obj_type", i2));
                if (this.c.a.v0.T0().f != null) {
                    i = this.c.a.v0.T0().f.get(i).sort_type.intValue();
                }
                K2 = this.c.a.v0.K2(i);
                this.b.setTag(Integer.valueOf(this.c.a.v0.h1()));
                if (K2) {
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

        /* JADX WARN: Code restructure failed: missing block: B:902:0x2145, code lost:
            if (r38.a.C0.Y0.c.b().getTop() <= ((r38.a.C0.W0() == null || r38.a.C0.W0().c() == null) ? 0 : r38.a.C0.W0().c().getBottom())) goto L843;
         */
        /* JADX WARN: Code restructure failed: missing block: B:903:0x2147, code lost:
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:905:0x2154, code lost:
            if (r0 >= com.repackage.ax7.d(r38.a.G4())) goto L843;
         */
        /* JADX WARN: Code restructure failed: missing block: B:927:0x21fb, code lost:
            if ((r38.a.C0.Y0.c.b().getTop() - r38.a.C0.h.a.getBottom()) < (r38.a.C0.Y0.c.g.getHeight() + 10)) goto L843;
         */
        /* JADX WARN: Removed duplicated region for block: B:1173:0x2ae3  */
        /* JADX WARN: Removed duplicated region for block: B:1174:0x2af9  */
        /* JADX WARN: Removed duplicated region for block: B:1177:0x2b35  */
        /* JADX WARN: Removed duplicated region for block: B:302:0x0a15  */
        /* JADX WARN: Removed duplicated region for block: B:303:0x0a19  */
        /* JADX WARN: Removed duplicated region for block: B:306:0x0a26  */
        /* JADX WARN: Removed duplicated region for block: B:341:0x0ada  */
        /* JADX WARN: Removed duplicated region for block: B:344:0x0aef  */
        /* JADX WARN: Removed duplicated region for block: B:347:0x0b00  */
        /* JADX WARN: Removed duplicated region for block: B:350:0x0b18  */
        /* JADX WARN: Removed duplicated region for block: B:352:0x0b21  */
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
            tq4 tq4Var;
            String jumpUrlWithTid;
            String[] strArr;
            bs7 T0;
            int i4;
            int i5;
            boolean J2;
            int i6;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.C0.O0() && this.a.getPageContext().getPageActivity() != null && this.a.v0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v0.l1(), this.a.v0.B1(), this.a.v0.A1())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.v0.getForumId());
                        statisticItem2.param("fname", this.a.v0.s0());
                        statisticItem2.param("tid", this.a.v0.l1());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.C0.Q0()) {
                        if (this.a.i) {
                            return;
                        }
                        if (this.a.v0.M1(true)) {
                            this.a.i = true;
                            this.a.C0.j3();
                        }
                    } else if (view2 != this.a.C0.h.m()) {
                        if (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().m()) {
                            int i7 = 3;
                            if (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().f()) {
                                if (view2 == this.a.C0.h.f) {
                                    if (this.a.C0.Y(this.a.v0.G0())) {
                                        this.a.u6();
                                        return;
                                    }
                                    this.a.j = false;
                                    this.a.f = false;
                                    oi.w(this.a.a, this.a.C0.h.f);
                                    this.a.a.finish();
                                } else if (view2 != this.a.C0.w0() && (this.a.C0.h.n() == null || (view2 != this.a.C0.h.n().n() && view2 != this.a.C0.h.n().o()))) {
                                    if (view2 == this.a.C0.E0()) {
                                        if (this.a.v0 != null) {
                                            ul4.m(this.a.getPageContext().getPageActivity(), this.a.v0.T0().O().getTopicData().b());
                                        }
                                    } else if (view2 != this.a.C0.h.c) {
                                        if (view2 == this.a.C0.h.d) {
                                            if (fc5.a()) {
                                                return;
                                            }
                                            if (this.a.v0 != null && this.a.v0.T0() != null) {
                                                ArrayList<PostData> F = this.a.v0.T0().F();
                                                if ((F == null || F.size() <= 0) && this.a.v0.j1()) {
                                                    oi.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0db0));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.v0.l1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.v0.getForumId()));
                                                if (!this.a.C0.L1()) {
                                                    this.a.C0.D2();
                                                }
                                                this.a.G5();
                                            } else {
                                                oi.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0db0));
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0916c3) {
                                            if (mi.z()) {
                                                this.a.C0.S2(true);
                                                this.a.C0.D2();
                                                if (this.a.i) {
                                                    return;
                                                }
                                                this.a.i = true;
                                                this.a.C0.O3();
                                                this.a.u6();
                                                this.a.C0.i3();
                                                this.a.v0.I2(this.a.y4());
                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                                return;
                                            }
                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f0916a0) {
                                            if ((this.a.C0.h.n() == null || view2 != this.a.C0.h.n().k()) && view2.getId() != R.id.obfuscated_res_0x7f0909e8 && view2.getId() != R.id.obfuscated_res_0x7f091a5d) {
                                                if (this.a.C0.h.n() != null && view2 == this.a.C0.h.n().g()) {
                                                    this.a.C0.h.k();
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cba) {
                                                    if (!this.a.b4(11009)) {
                                                        return;
                                                    }
                                                    this.a.d5(3);
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f0916a6) {
                                                    if (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().l()) {
                                                        if (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().t()) {
                                                            if (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().s()) {
                                                                if (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().p()) {
                                                                    if (this.a.C0.I0() == view2) {
                                                                        if (this.a.C0.I0().getIndicateStatus()) {
                                                                            bs7 T02 = this.a.v0.T0();
                                                                            if (T02 != null && T02.O() != null && T02.O().getTaskInfoData() != null) {
                                                                                String d = T02.O().getTaskInfoData().d();
                                                                                if (StringUtils.isNull(d)) {
                                                                                    d = T02.O().getTaskInfoData().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                                            }
                                                                        } else {
                                                                            hl8.d("c10725", null);
                                                                        }
                                                                        this.a.V4();
                                                                    } else if (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().i()) {
                                                                        if (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().e()) {
                                                                            if (this.a.C0.h.n() != null && view2 == this.a.C0.h.n().h()) {
                                                                                if (mi.z()) {
                                                                                    SparseArray<Object> M0 = this.a.C0.M0(this.a.v0.T0(), this.a.v0.j1(), 1);
                                                                                    if (M0 != null) {
                                                                                        if (StringUtils.isNull((String) M0.get(R.id.obfuscated_res_0x7f091e57))) {
                                                                                            this.a.C0.i2(((Integer) M0.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) M0.get(R.id.obfuscated_res_0x7f091e58), ((Integer) M0.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) M0.get(R.id.obfuscated_res_0x7f091e59)).booleanValue());
                                                                                        } else {
                                                                                            this.a.C0.j2(((Integer) M0.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) M0.get(R.id.obfuscated_res_0x7f091e58), ((Integer) M0.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) M0.get(R.id.obfuscated_res_0x7f091e59)).booleanValue(), (String) M0.get(R.id.obfuscated_res_0x7f091e57));
                                                                                        }
                                                                                    }
                                                                                    this.a.C0.h.k();
                                                                                } else {
                                                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                                                                    return;
                                                                                }
                                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f091db3 && view2.getId() != R.id.obfuscated_res_0x7f091db1 && view2.getId() != R.id.obfuscated_res_0x7f0916b3 && view2.getId() != R.id.obfuscated_res_0x7f091559) {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f091713) {
                                                                                    if (this.a.v0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                                                                                    statisticItem3.param("tid", this.a.v0.l1());
                                                                                    statisticItem3.param("fid", this.a.v0.getForumId());
                                                                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem3.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem3);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091713 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                        this.a.T = view2;
                                                                                        return;
                                                                                    } else if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                                        if (!(sparseArray2.get(R.id.obfuscated_res_0x7f091e72) instanceof PostData)) {
                                                                                            return;
                                                                                        }
                                                                                        PostData postData = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091e72);
                                                                                        StatisticItem statisticItem4 = postData.i0;
                                                                                        if (statisticItem4 != null) {
                                                                                            StatisticItem copy = statisticItem4.copy();
                                                                                            copy.delete("obj_locate");
                                                                                            copy.param("obj_locate", 8);
                                                                                            TiebaStatic.log(copy);
                                                                                        }
                                                                                        if (this.a.v0 == null || this.a.v0.T0() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String l1 = this.a.v0.l1();
                                                                                        String I = postData.I();
                                                                                        int V = this.a.v0.T0() != null ? this.a.v0.T0().V() : 0;
                                                                                        AbsPbActivity.e J5 = this.a.J5(I);
                                                                                        if (J5 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(l1, I, "pb", true, false, null, false, null, V, postData.U(), this.a.v0.T0().d(), false, postData.s().getIconInfo(), 5).addBigImageData(J5.a, J5.b, J5.g, J5.j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.a.v0.S0());
                                                                                        addBigImageData.setFromFrsForumId(this.a.v0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.a.v0.q1());
                                                                                        addBigImageData.setKeyFromForumId(this.a.v0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.a.v0.H(), this.a.v0.D(), this.a.v0.E(), this.a.v0.C(), this.a.v0.I());
                                                                                        addBigImageData.setBjhData(this.a.v0.l0());
                                                                                        if (this.a.v0.T0().o() != null) {
                                                                                            addBigImageData.setHasForumRule(this.a.v0.T0().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.a.v0.T0().U() != null) {
                                                                                            addBigImageData.setIsManager(this.a.v0.T0().U().getIs_manager());
                                                                                        }
                                                                                        if (this.a.v0.T0().l().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.v0.T0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.v0.T0().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.a.v0.T0().l() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.a.v0.T0().l().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.a.v0.T0().l().getUser_level());
                                                                                        }
                                                                                        if (this.a.C0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.a.C0.C0(this.a.v0.G, this.a.v0.j1()).Q || postData.Q);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091711 || view2.getId() == R.id.obfuscated_res_0x7f0918a6 || view2.getId() == R.id.obfuscated_res_0x7f0916ad) {
                                                                                    if (this.a.v0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091711) {
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                                                        statisticItem5.param("tid", this.a.v0.l1());
                                                                                        statisticItem5.param("fid", this.a.v0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem5.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918a6) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                            this.a.U = view2;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091711 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                        this.a.U = view2;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                                                                    if (!(sparseArray3.get(R.id.obfuscated_res_0x7f091e72) instanceof PostData)) {
                                                                                        return;
                                                                                    }
                                                                                    PostData postData2 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e72);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091711 && (statisticItem = postData2.i0) != null) {
                                                                                        StatisticItem copy2 = statisticItem.copy();
                                                                                        copy2.delete("obj_locate");
                                                                                        copy2.param("obj_locate", 8);
                                                                                        TiebaStatic.log(copy2);
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0918a6 || view2.getId() == R.id.obfuscated_res_0x7f0916ad) {
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.v0.m1()).param("fid", this.a.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.I()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.a.v0 == null || this.a.v0.T0() == null || this.a.P4().U0() == null || postData2.s() == null || postData2.A() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.P4().V0() != null) {
                                                                                        this.a.P4().V0().c();
                                                                                    }
                                                                                    if (this.a.q0 && postData2.R() != null && postData2.R().size() != 0) {
                                                                                        this.a.t6(postData2, true);
                                                                                    } else {
                                                                                        rs7 rs7Var = new rs7();
                                                                                        rs7Var.A(this.a.v0.T0().l());
                                                                                        rs7Var.E(this.a.v0.T0().O());
                                                                                        rs7Var.C(postData2);
                                                                                        this.a.P4().U0().U(rs7Var);
                                                                                        this.a.P4().U0().setPostId(postData2.I());
                                                                                        this.a.v5(view2, postData2.s().getUserId(), "", postData2);
                                                                                        if (this.a.R0 != null) {
                                                                                            this.a.C0.L2(this.a.R0.C());
                                                                                        }
                                                                                    }
                                                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f0916b1) {
                                                                                    if (view2 != this.a.C0.G0()) {
                                                                                        if (view2 == this.a.C0.h.o()) {
                                                                                            this.a.C0.s3();
                                                                                        } else if (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().r()) {
                                                                                            if (this.a.C0.h.n() != null && view2 == this.a.C0.h.n().j()) {
                                                                                                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.v0.l1())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                                                    this.a.C0.h.k();
                                                                                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                                                                }
                                                                                            } else {
                                                                                                int id = view2.getId();
                                                                                                if (id == R.id.obfuscated_res_0x7f091730) {
                                                                                                    if (!this.a.checkUpIsLogin() || (tq4Var = (tq4) view2.getTag()) == null || StringUtils.isNull(tq4Var.M0())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{tq4Var.M0()});
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091a60 || id == R.id.obfuscated_res_0x7f090716 || id == R.id.obfuscated_res_0x7f091a61 || id == R.id.obfuscated_res_0x7f090717) {
                                                                                                    if (!this.a.checkUpIsLogin()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view2 != null && view2.getTag() != null) {
                                                                                                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f091e72);
                                                                                                        if (id == R.id.obfuscated_res_0x7f091a61 || id == R.id.obfuscated_res_0x7f090717) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.v0.b));
                                                                                                        }
                                                                                                        if (this.a.I0 == null) {
                                                                                                            PbFragment pbFragment2 = this.a;
                                                                                                            pbFragment2.I0 = new nr4(pbFragment2.getContext());
                                                                                                            this.a.I0.n(this.a.a2);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.a.l5(view2);
                                                                                                        if (this.a.l5(view2) && this.a.i1 != null) {
                                                                                                            this.a.i1.t();
                                                                                                        }
                                                                                                        if (sparseArray4.get(R.id.obfuscated_res_0x7f091e6f) instanceof Boolean) {
                                                                                                            ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6f)).booleanValue();
                                                                                                        }
                                                                                                        boolean booleanValue = sparseArray4.get(R.id.obfuscated_res_0x7f091e59) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e59)).booleanValue() : false;
                                                                                                        boolean booleanValue2 = sparseArray4.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
                                                                                                        boolean booleanValue3 = sparseArray4.get(R.id.obfuscated_res_0x7f091e98) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e98)).booleanValue() : false;
                                                                                                        boolean booleanValue4 = sparseArray4.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
                                                                                                        boolean booleanValue5 = sparseArray4.get(R.id.obfuscated_res_0x7f091e96) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e96)).booleanValue() : false;
                                                                                                        String str = sparseArray4.get(R.id.obfuscated_res_0x7f091e66) instanceof String ? (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e66) : null;
                                                                                                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e6e) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6e)).booleanValue() : false;
                                                                                                        if (postData3 != null) {
                                                                                                            if (postData3.P() != null && postData3.P().toString().length() > 0) {
                                                                                                                jr4 jr4Var8 = new jr4(3, this.a.getString(R.string.obfuscated_res_0x7f0f043c), this.a.I0);
                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                sparseArray5.put(R.id.obfuscated_res_0x7f091e56, postData3);
                                                                                                                jr4Var8.d.setTag(sparseArray5);
                                                                                                                arrayList.add(jr4Var8);
                                                                                                            }
                                                                                                            this.a.v2 = postData3;
                                                                                                        }
                                                                                                        if (this.a.v0.T0().r()) {
                                                                                                            String u = this.a.v0.T0().u();
                                                                                                            if (postData3 != null && !ni.isEmpty(u) && u.equals(postData3.I())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    jr4Var4 = new jr4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0f84), this.a.I0);
                                                                                                                } else {
                                                                                                                    jr4Var4 = new jr4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0a81), this.a.I0);
                                                                                                                }
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f091e56, this.a.v2);
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f091e6f, Boolean.FALSE);
                                                                                                                jr4Var4.d.setTag(sparseArray6);
                                                                                                                arrayList.add(jr4Var4);
                                                                                                                if (this.a.mIsLogin) {
                                                                                                                    if (yx7.h(this.a.v0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.a.p5(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            jr4 jr4Var9 = new jr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fa8), this.a.I0);
                                                                                                                            jr4Var9.d.setTag(str);
                                                                                                                            arrayList.add(jr4Var9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        jr4 jr4Var10 = new jr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b18), this.a.I0);
                                                                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e6d, sparseArray4.get(R.id.obfuscated_res_0x7f091e6d));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ea7, sparseArray4.get(R.id.obfuscated_res_0x7f091ea7));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ea8, sparseArray4.get(R.id.obfuscated_res_0x7f091ea8));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ea6, sparseArray4.get(R.id.obfuscated_res_0x7f091ea6));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091ea9, sparseArray4.get(R.id.obfuscated_res_0x7f091ea9));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091eaa, sparseArray4.get(R.id.obfuscated_res_0x7f091eaa));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e59, sparseArray4.get(R.id.obfuscated_res_0x7f091e59));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e5a, sparseArray4.get(R.id.obfuscated_res_0x7f091e5a));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e58, sparseArray4.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091e75, sparseArray4.get(R.id.obfuscated_res_0x7f091e75));
                                                                                                                        jr4Var4.d.setTag(sparseArray7);
                                                                                                                        arrayList.add(jr4Var10);
                                                                                                                    }
                                                                                                                    if (booleanValue3) {
                                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e98, Boolean.TRUE);
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e75, sparseArray4.get(R.id.obfuscated_res_0x7f091e75));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e63, sparseArray4.get(R.id.obfuscated_res_0x7f091e63));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e64, sparseArray4.get(R.id.obfuscated_res_0x7f091e64));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e65, sparseArray4.get(R.id.obfuscated_res_0x7f091e65));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091e66, str);
                                                                                                                        if (booleanValue4) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e6d, sparseArray4.get(R.id.obfuscated_res_0x7f091e6d));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea7, sparseArray4.get(R.id.obfuscated_res_0x7f091ea7));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea8, sparseArray4.get(R.id.obfuscated_res_0x7f091ea8));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea6, sparseArray4.get(R.id.obfuscated_res_0x7f091ea6));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ea9, sparseArray4.get(R.id.obfuscated_res_0x7f091ea9));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091eaa, sparseArray4.get(R.id.obfuscated_res_0x7f091eaa));
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        if (booleanValue5) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(booleanValue));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e58, sparseArray4.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e5a, sparseArray4.get(R.id.obfuscated_res_0x7f091e5a));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e6a, sparseArray4.get(R.id.obfuscated_res_0x7f091e6a));
                                                                                                                            if (booleanValue6) {
                                                                                                                                jr4 jr4Var11 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0495), this.a.I0);
                                                                                                                                jr4Var11.d.setTag(sparseArray8);
                                                                                                                                jr4Var6 = jr4Var11;
                                                                                                                                jr4Var5 = new jr4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d4), this.a.I0);
                                                                                                                                jr4Var5.d.setTag(sparseArray8);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091e96, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        jr4Var6 = null;
                                                                                                                        jr4Var5 = new jr4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d4), this.a.I0);
                                                                                                                        jr4Var5.d.setTag(sparseArray8);
                                                                                                                    } else if (booleanValue5) {
                                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e98, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e75, sparseArray4.get(R.id.obfuscated_res_0x7f091e75));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(booleanValue));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e58, sparseArray4.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e5a, sparseArray4.get(R.id.obfuscated_res_0x7f091e5a));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091e6a, sparseArray4.get(R.id.obfuscated_res_0x7f091e6a));
                                                                                                                        if (this.a.v0.T0().V() == 1002 && !booleanValue) {
                                                                                                                            jr4Var7 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fa8), this.a.I0);
                                                                                                                        } else {
                                                                                                                            jr4Var7 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0495), this.a.I0);
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
                                                                                                                this.a.I0.j(arrayList);
                                                                                                                this.a.H0 = new lr4(this.a.getPageContext(), this.a.I0);
                                                                                                                this.a.H0.m();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray62 = new SparseArray();
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f091e56, this.a.v2);
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f091e6f, Boolean.FALSE);
                                                                                                        jr4Var4.d.setTag(sparseArray62);
                                                                                                        arrayList.add(jr4Var4);
                                                                                                        if (this.a.mIsLogin) {
                                                                                                        }
                                                                                                        this.a.I0.j(arrayList);
                                                                                                        this.a.H0 = new lr4(this.a.getPageContext(), this.a.I0);
                                                                                                        this.a.H0.m();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091685) {
                                                                                                    if (this.a.v0.T0() != null && this.a.v0.T0().O() != null && this.a.v0.T0().O().getActUrl() != null) {
                                                                                                        ul4.m(this.a.getActivity(), this.a.v0.T0().O().getActUrl());
                                                                                                        if (this.a.v0.T0().O().getActInfoType() != 1) {
                                                                                                            if (this.a.v0.T0().O().getActInfoType() == 2) {
                                                                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                            }
                                                                                                        } else {
                                                                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09133e) {
                                                                                                    if (view2.getTag(R.id.obfuscated_res_0x7f091e81) instanceof String) {
                                                                                                        String str2 = (String) view2.getTag(R.id.obfuscated_res_0x7f091e81);
                                                                                                        TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.v0.T0().m()).param("tid", this.a.v0.T0().Q()).param("lotterytail", StringUtils.string(str2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                        if (this.a.v0.T0().Q().equals(str2)) {
                                                                                                            this.a.C0.m3(0);
                                                                                                        } else {
                                                                                                            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0916db) {
                                                                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1341);
                                                                                                        String q = vt4.k().q("tail_link", "");
                                                                                                        if (!StringUtils.isNull(q)) {
                                                                                                            TiebaStatic.log("c10056");
                                                                                                            ul4.q(view2.getContext(), string, q, true, true, true);
                                                                                                        }
                                                                                                        this.a.C0.D2();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f090ff5) {
                                                                                                    if (view2 != null) {
                                                                                                        ul4.m(this.a.getActivity(), (String) view2.getTag());
                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                        if (this.a.u4() == 1 && this.a.v0 != null && this.a.v0.T0() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10397").param("fid", this.a.v0.T0().m()).param("tid", this.a.v0.T0().Q()).param("uid", currentAccount));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091331) {
                                                                                                    if (view2 != null) {
                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                        ul4.m(this.a.getActivity(), (String) view2.getTag());
                                                                                                        if (this.a.u4() == 1 && this.a.v0 != null && this.a.v0.T0() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10507").param("fid", this.a.v0.T0().m()).param("tid", this.a.v0.T0().Q()).param("uid", currentAccount2));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091389) {
                                                                                                    this.a.u5();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091388) {
                                                                                                    this.a.r5();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0924a4) {
                                                                                                    if (this.a.v0 != null && this.a.v0.T0() != null && this.a.v0.T0().A() != null) {
                                                                                                        bs7 T03 = this.a.v0.T0();
                                                                                                        TiebaStatic.log(new StatisticItem("c11679").param("fid", T03.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{T03.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0924a1) {
                                                                                                    if (this.a.v0 != null && this.a.v0.T0() != null && this.a.v0.T0().A() != null) {
                                                                                                        bs7 T04 = this.a.v0.T0();
                                                                                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", T04.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{T04.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0921ce) {
                                                                                                    if (this.a.m1 >= 0) {
                                                                                                        if (this.a.v0 != null) {
                                                                                                            this.a.v0.l2();
                                                                                                        }
                                                                                                        if (this.a.v0 == null || this.a.C0.u0() == null) {
                                                                                                            i3 = 0;
                                                                                                        } else {
                                                                                                            i3 = 0;
                                                                                                            this.a.C0.u0().g0(this.a.v0.T0(), false);
                                                                                                        }
                                                                                                        this.a.m1 = i3;
                                                                                                        if (this.a.v0 != null) {
                                                                                                            this.a.C0.L0().setSelection(this.a.v0.M0());
                                                                                                            this.a.v0.p2(0, 0);
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091983) {
                                                                                                    if (!this.a.b4(11009)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.d5(8);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091559) {
                                                                                                    SparseArray sparseArray10 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                                                    if (sparseArray10 == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.s6(sparseArray10);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0916a2) {
                                                                                                    if (this.a.C0.L0() == null || this.a.v0 == null || this.a.v0.T0() == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    int firstVisiblePosition = this.a.C0.L0().getFirstVisiblePosition();
                                                                                                    View childAt = this.a.C0.L0().getChildAt(0);
                                                                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                                                                    boolean r0 = this.a.v0.T0().r0();
                                                                                                    boolean z3 = this.a.C0.W0() != null && this.a.C0.W0().g();
                                                                                                    boolean J1 = this.a.C0.J1();
                                                                                                    boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                    if (!r0 || this.a.C0.W0() == null || this.a.C0.W0().c() == null) {
                                                                                                        i2 = 0;
                                                                                                    } else {
                                                                                                        int k = ((int) (oi.k(this.a.getContext()) * 0.5625d)) - this.a.C0.W0().e();
                                                                                                        i2 = k;
                                                                                                        z4 = firstVisiblePosition == 0 && (top == k || top == this.a.C0.W0().c().getHeight() - this.a.C0.W0().e());
                                                                                                    }
                                                                                                    this.a.p4(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                    if ((this.a.v0.T0().O() != null && this.a.v0.T0().O().getReply_num() <= 0) || (J1 && z4)) {
                                                                                                        if (!this.a.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.I5();
                                                                                                        if (this.a.v0.T0().O().getAuthor() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", this.a.v0.T0().m()).param("obj_locate", 2).param("uid", this.a.v0.T0().O().getAuthor().getUserId()));
                                                                                                        }
                                                                                                    } else {
                                                                                                        int i8 = (int) (oi.i(this.a.getContext()) * 0.6d);
                                                                                                        if (r0) {
                                                                                                            if (this.a.C0.Y0 != null && this.a.C0.Y0.c != null && this.a.C0.Y0.c.b() != null) {
                                                                                                                if (this.a.C0.Y0.c.b().getParent() != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        } else {
                                                                                                            if (this.a.C0.T0() != null) {
                                                                                                                z2 = this.a.C0.T0().getVisibility() == 0;
                                                                                                                if (!z2 && this.a.C0.Y0 != null && this.a.C0.Y0.c != null && this.a.C0.Y0.c.b() != null && this.a.C0.Y0.c.b().getParent() != null && this.a.C0.h != null && this.a.C0.h.a != null) {
                                                                                                                }
                                                                                                            }
                                                                                                            z2 = false;
                                                                                                        }
                                                                                                        if (z2 || J1) {
                                                                                                            this.a.h0 = firstVisiblePosition;
                                                                                                            this.a.i0 = top;
                                                                                                            if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i8))) {
                                                                                                                this.a.C0.L0().setSelectionFromTop(0, i2 - i8);
                                                                                                                this.a.C0.L0().smoothScrollBy(-i8, 500);
                                                                                                            } else {
                                                                                                                this.a.C0.L0().E(0, i2, 500);
                                                                                                            }
                                                                                                        } else if (this.a.h0 > 0) {
                                                                                                            if (this.a.C0.L0().getChildAt(this.a.h0) != null) {
                                                                                                                this.a.C0.L0().E(this.a.h0, this.a.i0, 200);
                                                                                                            } else {
                                                                                                                this.a.C0.L0().setSelectionFromTop(this.a.h0, this.a.i0 + i8);
                                                                                                                this.a.C0.L0().smoothScrollBy(i8, 500);
                                                                                                            }
                                                                                                        } else {
                                                                                                            int d2 = ax7.d(this.a.getListView());
                                                                                                            if (ax7.e(this.a.getListView()) != -1) {
                                                                                                                d2--;
                                                                                                            }
                                                                                                            int f = oi.f(this.a.getContext(), R.dimen.tbds100);
                                                                                                            if (d2 < 0) {
                                                                                                                d2 = (ListUtils.getCount(this.a.C0.L0().getData()) - 1) + this.a.C0.L0().getHeaderViewsCount();
                                                                                                                f = 0;
                                                                                                            }
                                                                                                            if (!z3) {
                                                                                                                if (!r0 || this.a.C0.W0() == null) {
                                                                                                                    if (this.a.C0.h != null && this.a.C0.h.a != null) {
                                                                                                                        fixedNavHeight = this.a.C0.h.a.getFixedNavHeight() - 10;
                                                                                                                    }
                                                                                                                    if (this.a.C0.Y0 != null || this.a.C0.Y0.c == null || this.a.C0.Y0.c.b() == null || this.a.C0.Y0.c.b().getParent() == null) {
                                                                                                                        this.a.C0.L0().setSelectionFromTop(d2, f + i8);
                                                                                                                        this.a.C0.L0().smoothScrollBy(i8, 500);
                                                                                                                    } else if (!z3) {
                                                                                                                        this.a.C0.L0().E(d2, f, 200);
                                                                                                                    } else {
                                                                                                                        this.a.C0.L0().smoothScrollBy(this.a.C0.Y0.c.b().getTop() - ((int) (oi.k(this.a.getContext()) * 0.5625d)), 500);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = this.a.C0.W0().d();
                                                                                                                }
                                                                                                            } else {
                                                                                                                fixedNavHeight = (int) (oi.k(this.a.getContext()) * 0.5625d);
                                                                                                            }
                                                                                                            f += fixedNavHeight;
                                                                                                            if (this.a.C0.Y0 != null) {
                                                                                                            }
                                                                                                            this.a.C0.L0().setSelectionFromTop(d2, f + i8);
                                                                                                            this.a.C0.L0().smoothScrollBy(i8, 500);
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.a.v0.T0().O() != null && this.a.v0.T0().O().getAuthor() != null) {
                                                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", this.a.v0.T0().m()).param("obj_locate", 2).param("uid", this.a.v0.T0().O().getAuthor().getUserId()));
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0916ff || id == R.id.obfuscated_res_0x7f091700) {
                                                                                                    if (this.a.v0 == null || this.a.v0.T0() == null || this.a.v0.T0().l() == null || ni.isEmpty(this.a.v0.T0().l().getName())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    if (this.a.v0.getErrorNo() == 4) {
                                                                                                        if (!StringUtils.isNull(this.a.v0.s0()) || this.a.v0.i0() == null) {
                                                                                                            this.a.a.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        name = this.a.v0.i0().b;
                                                                                                    } else {
                                                                                                        name = this.a.v0.T0().l().getName();
                                                                                                    }
                                                                                                    if (StringUtils.isNull(name)) {
                                                                                                        this.a.a.finish();
                                                                                                        return;
                                                                                                    }
                                                                                                    String s0 = this.a.v0.s0();
                                                                                                    if (this.a.v0.y0() && s0 != null && s0.equals(name)) {
                                                                                                        this.a.a.finish();
                                                                                                    } else {
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.v0.T0().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                    }
                                                                                                    StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                                                    statisticItem6.param("tid", this.a.v0.l1());
                                                                                                    statisticItem6.param("fid", this.a.v0.getForumId());
                                                                                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    if (this.a.v0.T0().O() != null) {
                                                                                                        statisticItem6.param("nid", this.a.v0.T0().O().getNid());
                                                                                                    }
                                                                                                    TiebaStatic.log(statisticItem6);
                                                                                                } else if (id != R.id.obfuscated_res_0x7f090a6b && id != R.id.obfuscated_res_0x7f090a42 && id != R.id.obfuscated_res_0x7f090a44 && id != R.id.obfuscated_res_0x7f090a43) {
                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                        if (this.a.v0 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                        statisticItem7.param("tid", this.a.v0.l1());
                                                                                                        statisticItem7.param("fid", this.a.v0.getForumId());
                                                                                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem7.param("obj_locate", 2);
                                                                                                        TiebaStatic.log(statisticItem7);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f091726) {
                                                                                                        if (this.a.v0 == null || this.a.v0.T0() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        bs7 T05 = this.a.v0.T0();
                                                                                                        if (this.a.A0 == null) {
                                                                                                            PbFragment pbFragment3 = this.a;
                                                                                                            pbFragment3.A0 = new ts7(pbFragment3.getPageContext());
                                                                                                        }
                                                                                                        long g = mg.g(T05.Q(), 0L);
                                                                                                        long g2 = mg.g(T05.m(), 0L);
                                                                                                        new StatisticItem("c13446").param("forum_id", g2).eventStat();
                                                                                                        PbFragment pbFragment4 = this.a;
                                                                                                        pbFragment4.registerListener(pbFragment4.g2);
                                                                                                        this.a.A0.a(g, g2);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f091749) {
                                                                                                        if (view2.getTag() instanceof SmartApp) {
                                                                                                            SmartApp smartApp = (SmartApp) view2.getTag();
                                                                                                            if (!ul5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                    return;
                                                                                                                }
                                                                                                                ul4.m(this.a.getActivity(), smartApp.h5_url);
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.v0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.v0.l1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                        }
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090e37) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData = (ThreadData) view2.getTag();
                                                                                                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090e34) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                                                        if (this.a.R != null) {
                                                                                                            this.a.R.P(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                                                        }
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f0916b5 || id == R.id.obfuscated_res_0x7f09170b) {
                                                                                                        StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                                                        statisticItem8.param("tid", this.a.v0.l1());
                                                                                                        statisticItem8.param("fid", this.a.v0.getForumId());
                                                                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem8.param("obj_locate", 7);
                                                                                                        TiebaStatic.log(statisticItem8);
                                                                                                        PbFragment pbFragment5 = this.a;
                                                                                                        pbFragment5.b = false;
                                                                                                        pbFragment5.h4(view2);
                                                                                                    }
                                                                                                } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                    return;
                                                                                                } else {
                                                                                                    ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                                                    if (this.a.v0.S0() == 3 && this.a.isSimpleForum() && this.a.v0.T0() != null && ListUtils.isEmpty(this.a.v0.T0().p())) {
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
                                                                                            this.a.C0.h.l();
                                                                                            this.a.C0.L3(this.a.y2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, mg.g(this.a.v0.T0().m(), 0L), mg.g(this.a.v0.l1(), 0L), mg.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.v0.T0().O().getPushStatusData())));
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        sparseArray = (SparseArray) view2.getTag();
                                                                                    } catch (ClassCastException e) {
                                                                                        e.printStackTrace();
                                                                                        sparseArray = null;
                                                                                    }
                                                                                    PostData postData4 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e56);
                                                                                    if (postData4 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.I0 == null) {
                                                                                        PbFragment pbFragment6 = this.a;
                                                                                        pbFragment6.I0 = new nr4(pbFragment6.getContext());
                                                                                        this.a.I0.n(this.a.a2);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.a.w().T0() != null && this.a.w().T0().g0();
                                                                                    if (view2 != null && sparseArray != null) {
                                                                                        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).booleanValue() : false;
                                                                                        boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
                                                                                        boolean booleanValue9 = sparseArray.get(R.id.obfuscated_res_0x7f091e98) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e98)).booleanValue() : false;
                                                                                        boolean booleanValue10 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
                                                                                        boolean booleanValue11 = sparseArray.get(R.id.obfuscated_res_0x7f091e96) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e96)).booleanValue() : false;
                                                                                        String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091e66) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e66) : null;
                                                                                        boolean booleanValue12 = sparseArray.get(R.id.obfuscated_res_0x7f091e6e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6e)).booleanValue() : false;
                                                                                        if (postData4.q() != null) {
                                                                                            boolean z6 = postData4.q().hasAgree;
                                                                                            int r = postData4.r();
                                                                                            if (z6 && r == 5) {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0083;
                                                                                            } else {
                                                                                                pbFragment = this.a;
                                                                                                i = R.string.obfuscated_res_0x7f0f0085;
                                                                                            }
                                                                                            jr4 jr4Var12 = new jr4(8, pbFragment.getString(i), this.a.I0);
                                                                                            SparseArray sparseArray11 = new SparseArray();
                                                                                            sparseArray11.put(R.id.obfuscated_res_0x7f091e56, postData4);
                                                                                            jr4Var12.d.setTag(sparseArray11);
                                                                                            arrayList2.add(jr4Var12);
                                                                                        }
                                                                                        if (this.a.mIsLogin) {
                                                                                            if (yx7.h(this.a.v0) || booleanValue9 || !booleanValue8) {
                                                                                                if ((this.a.p5(booleanValue7) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    jr4 jr4Var13 = new jr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fa8), this.a.I0);
                                                                                                    jr4Var13.d.setTag(str3);
                                                                                                    arrayList2.add(jr4Var13);
                                                                                                }
                                                                                            } else {
                                                                                                jr4 jr4Var14 = new jr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b18), this.a.I0);
                                                                                                SparseArray sparseArray12 = new SparseArray();
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                sparseArray12.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                                                                                                jr4Var14.d.setTag(sparseArray12);
                                                                                                arrayList2.add(jr4Var14);
                                                                                            }
                                                                                            if (booleanValue9) {
                                                                                                SparseArray sparseArray13 = new SparseArray();
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e98, Boolean.TRUE);
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e65, sparseArray.get(R.id.obfuscated_res_0x7f091e65));
                                                                                                sparseArray13.put(R.id.obfuscated_res_0x7f091e66, str3);
                                                                                                if (booleanValue10) {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                                                                                                } else {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                                                                                                }
                                                                                                if (booleanValue11) {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(booleanValue7));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e6a, sparseArray.get(R.id.obfuscated_res_0x7f091e6a));
                                                                                                    if (booleanValue12) {
                                                                                                        jr4 jr4Var15 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0495), this.a.I0);
                                                                                                        jr4Var15.d.setTag(sparseArray13);
                                                                                                        jr4Var2 = jr4Var15;
                                                                                                        jr4Var = new jr4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d4), this.a.I0);
                                                                                                        jr4Var.d.setTag(sparseArray13);
                                                                                                    }
                                                                                                } else {
                                                                                                    sparseArray13.put(R.id.obfuscated_res_0x7f091e96, Boolean.FALSE);
                                                                                                }
                                                                                                jr4Var2 = null;
                                                                                                jr4Var = new jr4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d4), this.a.I0);
                                                                                                jr4Var.d.setTag(sparseArray13);
                                                                                            } else if (booleanValue11) {
                                                                                                SparseArray sparseArray14 = new SparseArray();
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e98, Boolean.FALSE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(booleanValue7));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091e6a, sparseArray.get(R.id.obfuscated_res_0x7f091e6a));
                                                                                                if (this.a.v0.T0().V() == 1002 && !booleanValue7) {
                                                                                                    jr4Var3 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fa8), this.a.I0);
                                                                                                } else {
                                                                                                    jr4Var3 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0495), this.a.I0);
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
                                                                                        this.a.I0.j(arrayList2);
                                                                                        this.a.H0 = new lr4(this.a.getPageContext(), this.a.I0);
                                                                                        this.a.H0.m();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f091559) {
                                                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                                                    statisticItem10.param("tid", this.a.v0.l1());
                                                                                    statisticItem10.param("fid", this.a.v0.getForumId());
                                                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem10.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem10);
                                                                                }
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f0916b3 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                    this.a.T = view2;
                                                                                    return;
                                                                                } else if (this.a.checkUpIsLogin()) {
                                                                                    if (this.a.v0 == null || this.a.v0.T0() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.a.C0.i0();
                                                                                    SparseArray sparseArray15 = (SparseArray) view2.getTag();
                                                                                    PostData postData5 = (PostData) sparseArray15.get(R.id.obfuscated_res_0x7f091e72);
                                                                                    PostData postData6 = (PostData) sparseArray15.get(R.id.obfuscated_res_0x7f091e73);
                                                                                    View view3 = (View) sparseArray15.get(R.id.obfuscated_res_0x7f091e74);
                                                                                    if (postData5 == null || view3 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (postData5.E() == 1) {
                                                                                        TiebaStatic.log(new StatisticItem("c12630"));
                                                                                    }
                                                                                    StatisticItem statisticItem11 = postData5.i0;
                                                                                    if (statisticItem11 != null) {
                                                                                        StatisticItem copy3 = statisticItem11.copy();
                                                                                        copy3.delete("obj_locate");
                                                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091559) {
                                                                                            copy3.param("obj_locate", 6);
                                                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0916b3) {
                                                                                            copy3.param("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(copy3);
                                                                                    }
                                                                                    String l12 = this.a.v0.l1();
                                                                                    String I2 = postData5.I();
                                                                                    String I3 = postData6 != null ? postData6.I() : "";
                                                                                    int V2 = this.a.v0.T0() != null ? this.a.v0.T0().V() : 0;
                                                                                    this.a.u6();
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091a60) {
                                                                                        AbsPbActivity.e J52 = this.a.J5(I2);
                                                                                        if (this.a.v0 == null || this.a.v0.T0() == null || J52 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(l12, I2, "pb", true, false, null, true, null, V2, postData5.U(), this.a.v0.T0().d(), false, postData5.s().getIconInfo(), 5).addBigImageData(J52.a, J52.b, J52.g, J52.j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.a.v0.S0());
                                                                                        addBigImageData2.setFromFrsForumId(this.a.v0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.a.v0.q1());
                                                                                        addBigImageData2.setKeyFromForumId(this.a.v0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.a.v0.l0());
                                                                                        addBigImageData2.setTiebaPlusData(this.a.v0.H(), this.a.v0.D(), this.a.v0.E(), this.a.v0.C(), this.a.v0.I());
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e J53 = this.a.J5(I2);
                                                                                        if (postData5 == null || this.a.v0 == null || this.a.v0.T0() == null || J53 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(l12, I2, "pb", true, false, null, false, I3, V2, postData5.U(), this.a.v0.T0().d(), false, postData5.s().getIconInfo(), 5).addBigImageData(J53.a, J53.b, J53.g, J53.j);
                                                                                        if (!ni.isEmpty(I3)) {
                                                                                            addBigImageData3.setHighLightPostId(I3);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.a.v0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.a.v0.H(), this.a.v0.D(), this.a.v0.E(), this.a.v0.C(), this.a.v0.I());
                                                                                        addBigImageData3.setBjhData(this.a.v0.l0());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.a.v0.S0());
                                                                                        addBigImageData3.setFromFrsForumId(this.a.v0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.a.v0.q1());
                                                                                        if (this.a.C0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.a.C0.C0(this.a.v0.G, this.a.v0.j1()).Q || postData5.Q);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.v0.T0().m()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (mi.z()) {
                                                                            SparseArray<Object> M02 = this.a.C0.M0(this.a.v0.T0(), this.a.v0.j1(), 1);
                                                                            if (M02 != null) {
                                                                                this.a.C0.l2(((Integer) M02.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) M02.get(R.id.obfuscated_res_0x7f091e58), ((Integer) M02.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) M02.get(R.id.obfuscated_res_0x7f091e59)).booleanValue());
                                                                            }
                                                                            this.a.C0.h.k();
                                                                            if (this.a.w() != null && this.a.w().T0() != null && this.a.w().T0().O() != null) {
                                                                                ThreadData O = this.a.w().T0().O();
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
                                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                                                            return;
                                                                        }
                                                                    } else if (mi.z()) {
                                                                        this.a.C0.i0();
                                                                        SparseArray<Object> M03 = this.a.C0.M0(this.a.v0.T0(), this.a.v0.j1(), 1);
                                                                        if (M03 == null) {
                                                                            return;
                                                                        }
                                                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v0.T0().l().getId(), this.a.v0.T0().l().getName(), this.a.v0.T0().O().getId(), String.valueOf(this.a.v0.T0().U().getUserId()), (String) M03.get(R.id.obfuscated_res_0x7f091e63), (String) M03.get(R.id.obfuscated_res_0x7f091e64), (String) M03.get(R.id.obfuscated_res_0x7f091e66), (String) M03.get(R.id.obfuscated_res_0x7f091e65))));
                                                                    } else {
                                                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
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
                                                                    this.a.C0.h.l();
                                                                }
                                                            } else if (this.a.v0 == null || this.a.v0.T0() == null || this.a.v0.T0().O() == null) {
                                                                return;
                                                            } else {
                                                                this.a.C0.h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.a;
                                                                pbFragment7.Y4(pbFragment7.v0.T0().O().getFirstPostId());
                                                            }
                                                        } else {
                                                            this.a.C0.i0();
                                                            if (mi.z()) {
                                                                if (this.a.i) {
                                                                    view2.setTag(Integer.valueOf(this.a.v0.h1()));
                                                                    return;
                                                                }
                                                                this.a.u6();
                                                                this.a.C0.i3();
                                                                lr4 lr4Var = new lr4(this.a.getPageContext());
                                                                if (this.a.v0.T0().f == null || this.a.v0.T0().f.size() <= 0) {
                                                                    strArr = new String[]{this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1191), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1192)};
                                                                } else {
                                                                    strArr = new String[this.a.v0.T0().f.size()];
                                                                    for (int i9 = 0; i9 < this.a.v0.T0().f.size(); i9++) {
                                                                        strArr[i9] = this.a.v0.T0().f.get(i9).sort_name + this.a.getResources().getString(R.string.obfuscated_res_0x7f0f118f);
                                                                    }
                                                                }
                                                                lr4Var.j(null, strArr, new a(this, lr4Var, view2));
                                                                lr4Var.m();
                                                            } else {
                                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.a.C0.i0();
                                                        if (this.a.w().T0().g != 2) {
                                                            if (this.a.v0.R0() != null) {
                                                                this.a.C0.S3(this.a.v0.R0(), this.a.Z1);
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f085e);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.a.checkUpIsLogin()) || (T0 = this.a.v0.T0()) == null) {
                                                    return;
                                                } else {
                                                    ThreadData O2 = T0.O();
                                                    if (O2 != null && O2.getAuthor() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", T0.m()).param("obj_locate", 4).param("uid", O2.getAuthor().getUserId()));
                                                    }
                                                    if (O2 != null) {
                                                        if (O2.isBJHArticleThreadType()) {
                                                            i4 = 2;
                                                        } else if (O2.isBJHVideoThreadType()) {
                                                            i4 = 3;
                                                        } else if (O2.isBJHNormalThreadType()) {
                                                            i4 = 4;
                                                        } else if (O2.isBJHVideoDynamicThreadType()) {
                                                            i4 = 5;
                                                        }
                                                        StatisticItem statisticItem14 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                        statisticItem14.param("tid", this.a.v0.l1());
                                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem14.param("fid", this.a.v0.getForumId());
                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091cba) {
                                                            statisticItem14.param("obj_locate", 5);
                                                        } else {
                                                            statisticItem14.param("obj_locate", 6);
                                                        }
                                                        statisticItem14.param("obj_name", i4);
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
                                                                int i10 = O2.threadType;
                                                                if (i10 == 0) {
                                                                    statisticItem14.param("obj_type", 1);
                                                                } else if (i10 == 40) {
                                                                    statisticItem14.param("obj_type", 2);
                                                                } else if (i10 == 49) {
                                                                    statisticItem14.param("obj_type", 3);
                                                                } else if (i10 == 54) {
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
                                                            if (O2.getBaijiahaoData() != null && !ni.isEmpty(O2.getBaijiahaoData().oriUgcVid)) {
                                                                statisticItem14.param(TiebaStatic.Params.OBJ_PARAM6, O2.getBaijiahaoData().oriUgcVid);
                                                            }
                                                        }
                                                        if (!ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem14.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.a.x() != null) {
                                                            u75.e(this.a.x(), statisticItem14);
                                                        }
                                                        if (this.a.C0 != null) {
                                                            statisticItem14.param("obj_param1", this.a.C0.H0());
                                                        }
                                                        TiebaStatic.log(statisticItem14);
                                                        if (oi.C()) {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                                                            return;
                                                        } else if (T0 != null) {
                                                            ArrayList<PostData> F2 = this.a.v0.T0().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.a.v0.j1()) {
                                                                this.a.C0.i0();
                                                                this.a.u6();
                                                                if (T0.A() != null && !StringUtils.isNull(T0.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.v0.T0().m()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.a.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.a.C0 != null) {
                                                                    this.a.C0.k0();
                                                                    this.a.C0.d4(T0);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.a.C0.E3();
                                                                    this.a.v0.n0().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0916a6) {
                                                                        i5 = 2;
                                                                    } else {
                                                                        i5 = view2.getId() == R.id.obfuscated_res_0x7f091cba ? 1 : 6;
                                                                    }
                                                                    if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.a.C0.N1() && !T0.j0()) {
                                                                        int H0 = this.a.C0.H0();
                                                                        this.a.C0.X();
                                                                        this.a.c5(qy4.a(), H0);
                                                                    } else {
                                                                        this.a.o6(i5);
                                                                    }
                                                                }
                                                            } else {
                                                                oi.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0db0));
                                                                return;
                                                            }
                                                        } else {
                                                            oi.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0db0));
                                                            return;
                                                        }
                                                    }
                                                    i4 = 1;
                                                    StatisticItem statisticItem142 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem142.param("tid", this.a.v0.l1());
                                                    statisticItem142.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem142.param("fid", this.a.v0.getForumId());
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091cba) {
                                                    }
                                                    statisticItem142.param("obj_name", i4);
                                                    statisticItem142.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.a.x() != null) {
                                                    }
                                                    if (this.a.C0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem142);
                                                    if (oi.C()) {
                                                    }
                                                }
                                            } else if (mi.z()) {
                                                this.a.C0.i0();
                                                if (this.a.C0.h.n() != null && view2 == this.a.C0.h.n().k() && !this.a.C0.L1()) {
                                                    this.a.C0.D2();
                                                }
                                                if (!this.a.i) {
                                                    this.a.u6();
                                                    this.a.C0.i3();
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0909e8) {
                                                        J2 = this.a.v0.J2(true, this.a.y4());
                                                    } else {
                                                        J2 = view2.getId() == R.id.obfuscated_res_0x7f091a5d ? this.a.v0.J2(false, this.a.y4()) : this.a.v0.I2(this.a.y4());
                                                    }
                                                    view2.setTag(Boolean.valueOf(J2));
                                                    if (J2) {
                                                        i6 = 1;
                                                        this.a.C0.S2(true);
                                                        this.a.C0.O3();
                                                        this.a.i = true;
                                                        this.a.C0.W2(true);
                                                    } else {
                                                        i6 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i6, new Object[0]);
                                                } else {
                                                    view2.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                                view2.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (mi.z()) {
                                            this.a.C0.i0();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0916a0 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.b4(11009) || this.a.v0.j0(this.a.C0.K0()) == null) {
                                                    return;
                                                }
                                                this.a.y5();
                                                if (this.a.v0.T0() != null && this.a.v0.T0().O() != null && this.a.v0.T0().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v0.b).param("fid", this.a.v0.T0().m()).param("obj_locate", 3).param("uid", this.a.v0.T0().O().getAuthor().getUserId()));
                                                }
                                                if (this.a.v0.T0().O() != null && this.a.v0.T0().O().getAuthor() != null && this.a.v0.T0().O().getAuthor().getUserId() != null && this.a.x0 != null) {
                                                    PbFragment pbFragment8 = this.a;
                                                    int S4 = pbFragment8.S4(pbFragment8.v0.T0());
                                                    ThreadData O3 = this.a.v0.T0().O();
                                                    if (O3.isBJHArticleThreadType()) {
                                                        i7 = 2;
                                                    } else if (!O3.isBJHVideoThreadType()) {
                                                        if (O3.isBJHNormalThreadType()) {
                                                            i7 = 4;
                                                        } else {
                                                            i7 = O3.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                        }
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.v0.b).param("obj_locate", 1).param("obj_id", this.a.v0.T0().O().getAuthor().getUserId()).param("obj_type", !this.a.x0.e()).param("obj_source", S4).param("obj_param1", i7));
                                                }
                                            } else {
                                                this.a.V = view2;
                                                return;
                                            }
                                        } else {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.a.v0.T0() != null && this.a.v0.T0().O() != null && this.a.v0.T0().O().isVideoThreadType() && this.a.v0.T0().O().getThreadVideoInfo() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.a.v0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.a.v0.s0()) || this.a.v0.i0() == null) {
                                                this.a.a.finish();
                                                return;
                                            }
                                            name2 = this.a.v0.i0().b;
                                        } else {
                                            name2 = this.a.v0.T0().l().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.a.a.finish();
                                            return;
                                        }
                                        String s02 = this.a.v0.s0();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.a.v0.y0() && s02 != null && s02.equals(name2)) {
                                            this.a.a.finish();
                                        } else {
                                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (mi.z()) {
                                    if (this.a.v0.T0() == null || this.a.y0.R()) {
                                        return;
                                    }
                                    this.a.C0.i0();
                                    int i11 = (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().o()) ? (this.a.C0.h.n() == null || view2 != this.a.C0.h.n().n()) ? view2 == this.a.C0.w0() ? 2 : 0 : this.a.v0.T0().O().getIs_good() == 1 ? 3 : 6 : this.a.v0.T0().O().getIs_top() == 1 ? 5 : 4;
                                    ForumData l = this.a.v0.T0().l();
                                    String name3 = l.getName();
                                    String id2 = l.getId();
                                    String id3 = this.a.v0.T0().O().getId();
                                    this.a.C0.X3();
                                    this.a.y0.V(id2, name3, id3, i11, this.a.C0.x0());
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                    return;
                                }
                            } else {
                                this.a.C0.h.l();
                                if (this.a.v0 != null) {
                                    this.a.r1.f(this.a.v0.l1());
                                }
                                if (this.a.v0 == null || !this.a.v0.isPrivacy()) {
                                    this.a.r1.b();
                                    int i12 = (TbSingleton.getInstance().mCanCallFans || this.a.w() == null || this.a.w().T0() == null || this.a.w().T0().Q() == null || !this.a.w().T0().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.a.w() != null && this.a.w().T0() != null) {
                                        this.a.r1.d(3, i12, this.a.w().T0().Q());
                                    }
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ecc);
                                    if (this.a.w() == null || this.a.w().T0() == null) {
                                        return;
                                    }
                                    this.a.r1.d(3, 3, this.a.w().T0().Q());
                                    return;
                                }
                            }
                        } else if (mi.z()) {
                            this.a.C0.i0();
                            this.a.u6();
                            this.a.C0.i3();
                            this.a.C0.E3();
                            if (this.a.C0.T0() != null) {
                                this.a.C0.T0().setVisibility(8);
                            }
                            this.a.v0.E2(1);
                            if (this.a.e != null) {
                                this.a.e.x();
                            }
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                            return;
                        }
                    } else {
                        String str4 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a6a);
                        String str5 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a53);
                        String str6 = (String) view2.getTag(R.id.obfuscated_res_0x7f091f95);
                        if (this.a.R != null) {
                            this.a.R.P(str4, str5);
                        }
                        TbPageTag l2 = u75.l(this.a.getContext());
                        ay7.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l2 != null ? l2.locatePage : "");
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0da0).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091a50) {
                        String x4 = this.a.x4();
                        if (TextUtils.isEmpty(x4)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{x4});
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.a.v0.l1());
                statisticItem15.param("fid", this.a.v0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                if (this.a.w) {
                    this.a.w = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091e56);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (this.a.v0 == null || this.a.v0.T0() == null || this.a.P4().U0() == null || postData7.s() == null || postData7.A() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.P4().V0() != null) {
                            this.a.P4().V0().c();
                        }
                        rs7 rs7Var2 = new rs7();
                        rs7Var2.A(this.a.v0.T0().l());
                        rs7Var2.E(this.a.v0.T0().O());
                        rs7Var2.C(postData7);
                        this.a.P4().U0().U(rs7Var2);
                        this.a.P4().U0().setPostId(postData7.I());
                        this.a.v5(view2, postData7.s().getUserId(), "", postData7);
                        TiebaStatic.log("c11743");
                        yy7.b(this.a.v0.T0(), postData7, postData7.h0, 8, 1);
                        if (this.a.R0 != null) {
                            this.a.C0.L2(this.a.R0.C());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ cr4 b;
        public final /* synthetic */ PbFragment c;

        public d2(PbFragment pbFragment, MarkData markData, cr4 cr4Var) {
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
                if (this.c.C0 != null && this.c.C0.g1() != null) {
                    this.c.C0.g1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.a);
                    this.c.a.setResult(-1, intent);
                    this.b.dismiss();
                    this.c.v6();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d3 {
        void a(Object obj);
    }

    /* loaded from: classes3.dex */
    public class e implements ic5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public e(PbFragment pbFragment, int i) {
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
        @Override // com.repackage.ic5
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
    public class e0 extends p55<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment c;

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
            this.c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.i55
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
    public class e1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e1(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.v0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.v0.b)) {
                this.a.n6((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e2 implements eg<ImageView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
                    if (bn4.c().g()) {
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
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = bn4.c().g();
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
                    foreDrawableImageView.G();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface e3 {
    }

    /* loaded from: classes3.dex */
    public class f extends ad5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFragment b;

        public f(PbFragment pbFragment, int i) {
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
        @Override // com.repackage.ad5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel w = this.b.w();
                if (w != null) {
                    w.s2(this.a);
                }
                return zx7.d(this.b.u4(), 2, w);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ PbFragment b;

        public f0(PbFragment pbFragment, Intent intent) {
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
                gw7 gw7Var = this.b.C0;
                gw7Var.l3("@" + this.a.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ f1 b;

            public a(f1 f1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = f1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.C0 == null || this.a == null) {
                    return;
                }
                this.b.a.C0.p2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(f1 f1Var) {
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
            public final /* synthetic */ f1 a;

            public c(f1 f1Var) {
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

        public f1(PbFragment pbFragment) {
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qx4 qx4Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qx4Var, writeData, antiData}) == null) {
                if (!ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.v0.T0() != null) {
                        statisticItem.param("fid", this.a.v0.T0().m());
                    }
                    statisticItem.param("tid", this.a.v0.l1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (ni.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.u6();
                this.a.C0.g3(z, postWriteCallBackData);
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
                        if (this.a.R0.B() || this.a.R0.D()) {
                            this.a.R0.z(false, postWriteCallBackData);
                        }
                        this.a.G0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.U0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (ni.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0466), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        cr4 cr4Var = new cr4(this.a.getActivity());
                        if (ni.isEmpty(postWriteCallBackData.getErrorString())) {
                            cr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cc9));
                        } else {
                            cr4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new b(this));
                        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ccb, new c(this));
                        cr4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (as8.c(i) || qx4Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.b6(i, antiData, str);
                        return;
                    }
                }
                this.a.n6(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.c6(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.v0.w0()) {
                        bs7 T0 = this.a.v0.T0();
                        if (T0 != null && T0.O() != null && T0.O().getAuthor() != null && (userId = T0.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.v0.H2()) {
                            this.a.C0.i3();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.v0.H2()) {
                        this.a.C0.i3();
                    }
                } else if (floor != null) {
                    this.a.C0.z1(this.a.v0.T0());
                }
                if (this.a.v0.A0()) {
                    TiebaStatic.log(new StatisticItem("c10369").param("tid", this.a.v0.l1()));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    pg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                PbFragment pbFragment = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                pbFragment.X3(z2);
                if (writeData != null) {
                    hv4.b(writeData.getContent(), "1");
                }
                if (this.a.i5()) {
                    this.a.x6();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f2 implements j25 {
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

        @Override // com.repackage.j25
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                iw7 iw7Var = this.a.G0;
                if (iw7Var == null || iw7Var.g() == null || !this.a.G0.g().d()) {
                    return !this.a.e4(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.G0.g().c());
                if (this.a.C0 != null && this.a.C0.V0() != null && this.a.C0.V0().b() != null && this.a.C0.V0().b().x()) {
                    this.a.C0.V0().b().v(this.a.G0.h());
                }
                this.a.G0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ic5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbFragment c;

        public g(PbFragment pbFragment, int i, int i2) {
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
        @Override // com.repackage.ic5
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
    public class g0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
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

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.R0.L(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.C0 != null && this.a.C0.V0() != null && this.a.C0.V0().b() != null) {
                    this.a.C0.V0().b().F();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.a;
                    pbFragment.R5(pbFragment.X0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ g1 b;

            public a(g1 g1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {g1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = g1Var;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.C0 == null || this.a == null) {
                    return;
                }
                this.b.a.C0.p2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(g1 g1Var) {
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
            public final /* synthetic */ g1 a;

            public c(g1 g1Var) {
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qx4 qx4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qx4Var, writeData, antiData}) == null) {
                if (!ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.v0 != null && this.a.v0.T0() != null) {
                        statisticItem.param("fid", this.a.v0.T0().m());
                    }
                    if (this.a.v0 != null) {
                        statisticItem.param("tid", this.a.v0.l1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    iw7 iw7Var = this.a.G0;
                    if (iw7Var != null) {
                        iw7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        uy4.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        hv4.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        pg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.i5()) {
                        this.a.x6();
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.U0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (ni.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0466), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    cr4 cr4Var = new cr4(this.a.getActivity());
                    if (ni.isEmpty(postWriteCallBackData.getErrorString())) {
                        cr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cc9));
                    } else {
                        cr4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new b(this));
                    cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ccb, new c(this));
                    cr4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.a;
                if (pbFragment.G0 == null) {
                    return;
                }
                if (pbFragment.C0 != null && this.a.C0.V0() != null && this.a.C0.V0().b() != null && this.a.C0.V0().b().x()) {
                    this.a.C0.V0().b().v(postWriteCallBackData);
                }
                this.a.G0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g2 implements eg<GifView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
                if (bn4.c().g()) {
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.Z();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = bn4.c().g();
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
                gifView.c0();
                gifView.Z();
                gifView.setImageDrawable(null);
                gifView.d0();
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
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PbFragment pbFragment, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.v0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.R0 != null) {
                this.a.C0.L2(this.a.R0.C());
            }
            this.a.C0.D2();
            this.a.C0.i0();
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, str2, obj}) == null) {
                this.a.C0.m1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.a.o6(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        jt6.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        }
                        this.a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h1 extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h1(PbFragment pbFragment, int i, int i2) {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView e1;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    oi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f139d);
                    if (this.a.C0 == null || (e1 = this.a.C0.e1()) == null || this.a.C0.L0() == null) {
                        return;
                    }
                    this.a.C0.L0().removeHeaderView(e1);
                    return;
                }
                oi.N(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h2 implements eg<TiebaPlusRecommendCard> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.p();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
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
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PbFragment pbFragment, int i) {
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
                this.a.v0.M2((UserPendantData) customResponsedMessage.getData());
                if (this.a.C0 != null && this.a.v0 != null) {
                    this.a.C0.w2(this.a.v0.T0(), this.a.v0.j1(), this.a.v0.d1(), this.a.C0.c1());
                }
                if (this.a.C0 == null || this.a.C0.u0() == null) {
                    return;
                }
                this.a.C0.u0().Z();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i0 extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public i0(PbFragment pbFragment) {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i1 implements PbModel.g {
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

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.a.n : j;
                if (this.a.o == 0) {
                    this.a.o = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                p85 p85Var = new p85(i, z, responsedMessage, this.a.r, this.a.q, this.a.o, z2, 0L, 0L, j3);
                this.a.q = 0L;
                this.a.r = 0L;
                p85Var.c();
                if (z2) {
                    j2 = j3;
                    p85Var.B = j2;
                    p85Var.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || this.a.v0 == null || this.a.v0.T0() == null || this.a.v0.T0().O() == null) {
                    return;
                }
                int threadType = this.a.v0.T0().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (!StringHelper.equals(this.a.M, "from_personalize")) {
                        if (StringHelper.equals(this.a.M, "from_frs")) {
                            p85 p85Var2 = new p85();
                            p85Var2.a(1000);
                            p85Var2.D = j2;
                            p85Var2.d(threadType);
                            return;
                        }
                        return;
                    }
                    l85 l85Var = new l85();
                    l85Var.F = 1;
                    l85Var.a(1005);
                    l85Var.D = j2;
                    l85Var.d(threadType);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(bs7 bs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bs7Var) == null) {
                this.a.C0.z1(bs7Var);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i, int i2, int i3, bs7 bs7Var, String str, int i4) {
            p05 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bs7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906d2));
                }
                if (!z || bs7Var == null || bs7Var.W() != null || ListUtils.getCount(bs7Var.F()) >= 1) {
                    if (!this.a.n0) {
                        this.a.n0 = true;
                    } else if (this.a.w() != null) {
                        this.a.w().a0();
                    }
                    this.a.h = true;
                    this.a.C0.h3();
                    if (bs7Var == null || !bs7Var.m0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.C0.g1());
                    }
                    this.a.C0.o1();
                    if (this.a.J || this.a.C0.L1()) {
                        this.a.C0.i1();
                    } else if (!this.a.C0.E1()) {
                        this.a.C0.w3(false);
                    }
                    if (this.a.i) {
                        this.a.i = false;
                    }
                    if (i4 == 0 && bs7Var != null) {
                        this.a.K0 = true;
                    }
                    if (bs7Var != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.C0.g1());
                        this.a.C0.r3();
                    }
                    ArrayList<PostData> arrayList = null;
                    String Y0 = null;
                    arrayList = null;
                    if (z && bs7Var != null) {
                        ThreadData O = bs7Var.O();
                        if (O != null && O.isUgcThreadType()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.X5(pbFragment3.Q0);
                        }
                        this.a.C0.V0().m(bs7Var);
                        this.a.C0.D3();
                        if (O != null && O.getCartoonThreadData() != null) {
                            this.a.B6(O.getCartoonThreadData());
                        }
                        if (this.a.R0 != null) {
                            this.a.C0.L2(this.a.R0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(bs7Var.U().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(bs7Var.U().getBimg_end_time());
                        if (bs7Var.F() != null && bs7Var.F().size() >= 1 && bs7Var.F().get(0) != null) {
                            this.a.v0.q2(bs7Var.F().get(0).I());
                        } else if (bs7Var.W() != null) {
                            this.a.v0.q2(bs7Var.W().I());
                        }
                        if (this.a.R0 != null) {
                            this.a.R0.M(bs7Var.d());
                            this.a.R0.N(bs7Var.l(), bs7Var.U());
                            this.a.R0.r0(O);
                            this.a.R0.O(this.a.v0.v0(), this.a.v0.l1(), this.a.v0.r0());
                            if (O != null) {
                                this.a.R0.h0(O.isMutiForumThread());
                            }
                        }
                        if (this.a.x0 != null) {
                            this.a.x0.h(bs7Var.r());
                        }
                        if (bs7Var.s() == 1) {
                            this.a.s = true;
                        } else {
                            this.a.s = false;
                        }
                        if (bs7Var.g0()) {
                            this.a.s = true;
                        }
                        this.a.C0.M2(this.a.s);
                        if (this.a.s0.f.size() > 0) {
                            bs7Var.L0(this.a.s0.f);
                        }
                        this.a.C0.H3(bs7Var, i2, i3, this.a.v0.j1(), i4, this.a.v0.C0());
                        this.a.C0.V3(bs7Var, this.a.v0.j1());
                        this.a.C0.a4(this.a.v0.w0());
                        AntiData d = bs7Var.d();
                        if (d != null) {
                            this.a.z = d.getVoice_message();
                            if (!StringUtils.isNull(this.a.z) && this.a.R0 != null && this.a.R0.a() != null && (m = this.a.R0.a().m(6)) != null && !TextUtils.isEmpty(this.a.z)) {
                                ((View) m).setOnClickListener(this.a.E1);
                            }
                        }
                        if (!this.a.Y && !ListUtils.isEmpty(this.a.v0.T0().F()) && !this.a.v0.C1()) {
                            this.a.Y = true;
                            this.a.Z3(false);
                        }
                        if (TextUtils.isEmpty(this.a.N0)) {
                            if (this.a.M0) {
                                this.a.M0 = false;
                                ax7.g(this.a.getListView());
                            } else if (this.a.O0) {
                                this.a.O0 = false;
                                ax7.j(this.a.getListView());
                            } else if (!TextUtils.isEmpty(this.a.v0.J0())) {
                                ax7.f(this.a.getListView(), this.a.v0.J0());
                                this.a.v0.K1();
                            } else {
                                this.a.C0.C3();
                            }
                        } else {
                            ax7.i(this.a.v0.S0(), this.a.getListView(), this.a.N0);
                            this.a.N0 = null;
                        }
                        this.a.v0.L1(bs7Var.l(), this.a.I1);
                        this.a.v0.R1(this.a.K1);
                        if (this.a.U0 != null && O != null && O.getAuthor() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.getAuthor());
                            this.a.U0.setLikeUserData(attentionHostData);
                        }
                        if (this.a.v0 == null || !this.a.v0.z1()) {
                            if (this.a.C0 != null) {
                                Y0 = this.a.C0.Y0();
                            }
                        } else {
                            Y0 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dc0);
                        }
                        if (!StringUtils.isNull(Y0)) {
                            this.a.R0.k0(TbSingleton.getInstance().getAdVertiComment(bs7Var.k0(), bs7Var.l0(), Y0));
                        }
                    } else if (str != null) {
                        if (this.a.K0 || i4 != 1) {
                            this.a.showToast(str);
                        } else if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.v0.i0() != null && !StringUtils.isNull(this.a.v0.i0().c)) {
                                    this.a.C0.c4(this.a.v0.i0());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.C0.g1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c16, str, Integer.valueOf(i)), true);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(oi.f(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702ad));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.C0.g1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c16, str, Integer.valueOf(i)), true);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(oi.f(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702ad));
                            }
                            this.a.C0.i1();
                            this.a.C0.h1();
                        }
                        if (i == 4 || i == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.v0.l1());
                                jSONObject.put("fid", this.a.v0.getForumId());
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
                            if (this.a.v0 != null && this.a.v0.T0() != null) {
                                arrayList = this.a.v0.T0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.C0.H2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e9));
                            } else {
                                if (this.a.k5()) {
                                    this.a.C0.I2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0db1));
                                } else {
                                    this.a.C0.I2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0db2));
                                }
                                this.a.C0.z1(this.a.v0.T0());
                            }
                        } else {
                            this.a.C0.H2("");
                        }
                        this.a.C0.o0();
                    }
                    if (bs7Var != null && bs7Var.m && this.a.o == 0) {
                        this.a.o = System.currentTimeMillis() - this.a.n;
                    }
                    if (!this.a.w().j1() || this.a.w().T0().y().c() != 0 || this.a.w().w1()) {
                        this.a.S0 = true;
                    }
                    if (this.a.a instanceof PbActivity) {
                        ((PbActivity) this.a.a).logOnPbDataSet(bs7Var != null ? bs7Var.g() : 0);
                        return;
                    }
                    return;
                }
                this.a.v0.E2(1);
                if (this.a.e != null) {
                    this.a.e.x();
                }
                if (this.a.C0 != null) {
                    this.a.C0.P3();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.v0 == null) {
                return;
            }
            if (this.a.R0 == null || !this.a.R0.v) {
                l25 l25Var = new l25();
                this.a.X5(l25Var);
                PbFragment pbFragment = this.a;
                pbFragment.R0 = (m25) l25Var.a(pbFragment.getContext());
                this.a.R0.e0(this.a.a.getPageContext());
                this.a.R0.n0(this.a.e2);
                this.a.R0.o0(this.a.Y0);
                this.a.R0.F(this.a.a.getPageContext(), this.a.a.getIntent() == null ? null : this.a.a.getIntent().getExtras());
                this.a.R0.a().C(true);
                this.a.C0.G2(this.a.R0.a());
                if (!this.a.v0.G0()) {
                    this.a.R0.s(this.a.v0.l1());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.a.R0.k0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.a.v0.z1()) {
                    this.a.R0.k0(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dc0));
                } else if (this.a.C0 != null) {
                    this.a.R0.k0(this.a.C0.Y0());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i2 implements eg<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.getVoiceManager());
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.a.C0 == null) {
                return;
            }
            if (booleanValue) {
                this.a.C0.O3();
            } else {
                this.a.C0.o1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j0 implements d3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.d3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!mi.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v0.T0().l().getId(), this.a.v0.T0().l().getName(), this.a.v0.T0().O().getId(), String.valueOf(this.a.v0.T0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j1 implements k25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // com.repackage.k25
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j2 implements eg<RelativeLayout> {
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
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.R0 != null) {
                this.a.C0.L2(this.a.R0.C());
            }
            this.a.C0.w3(false);
        }
    }

    /* loaded from: classes3.dex */
    public class k0 implements dt7.a {
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

        @Override // com.repackage.dt7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091a7a) {
                            if (this.a.Q5(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0916b2) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f091e69) instanceof SparseArray) {
                                this.a.s6((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091e69));
                            }
                        } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.obfuscated_res_0x7f09170a) {
                            if (this.a.C0.G1() && view2.getId() == R.id.obfuscated_res_0x7f0916d0) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f091ea4) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.obfuscated_res_0x7f091ea4)));
                                }
                                if (this.a.getEventController() != null && this.a.getEventController().b != null) {
                                    this.a.getEventController().b.onClick(view2);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.s6(sparseArray);
                        }
                    }
                    if (this.a.R0 != null) {
                        this.a.C0.L2(this.a.R0.C());
                    }
                    this.a.C0.D2();
                    this.a.C0.i0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    this.a.n4((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class k1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k1(PbFragment pbFragment, int i) {
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
                this.a.A6();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k2 implements eg<ItemCardView> {
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
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            hr7 hr7Var = (hr7) customResponsedMessage.getData();
            int type = hr7Var.getType();
            if (type == 0) {
                this.a.N5((rs7) hr7Var.a());
            } else if (type == 1) {
                this.a.q4((ForumManageModel.b) hr7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (hr7Var.a() == null) {
                    this.a.M5(false, null);
                } else {
                    this.a.M5(true, (MarkData) hr7Var.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l0 implements er4.c {
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

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.J0 = pbFragment.J0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.J0);
                    new lu7(this.a.v0.l1(), this.a.J0, "1").start();
                    er4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.J0 = pbFragment2.J0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.J0);
                    new lu7(this.a.v0.l1(), this.a.J0, "2").start();
                    er4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.J0 = pbFragment3.J0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.J0);
                    er4Var.e();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l1(PbFragment pbFragment, int i, boolean z) {
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
                if (this.a.C0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.C0.g1());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.i(true);
                            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0314));
                            bdTopToast.j((ViewGroup) this.a.getView());
                            this.a.Y5(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c17) : httpResponsedMessage.getErrorString();
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
    public class l2 implements TbRichTextView.y {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            qu7 u0;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.C0.Z1((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.v0.l1());
                    statisticItem.param("fid", this.a.v0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view2.getTag(R.id.obfuscated_res_0x7f091e8c) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091e8c) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
                        if (this.a.v0.G.g0()) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            TbRichTextView tbRichTextView = null;
                            if (view2.getParent() instanceof TbRichTextView) {
                                tbRichTextView = (TbRichTextView) view2.getParent();
                            } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                                tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                            }
                            int i3 = -1;
                            if (tbRichTextView == null || tbRichTextView.getRichText() == null || tbRichTextView.getRichText().C() == null) {
                                i2 = -1;
                            } else {
                                ArrayList<TbRichTextImageInfo> C = tbRichTextView.getRichText().C();
                                int i4 = 0;
                                int i5 = -1;
                                while (i4 < C.size()) {
                                    if (C.get(i4) != null) {
                                        arrayList.add(C.get(i4).D());
                                        if (i5 == i3 && str != null && (str.equals(C.get(i4).D()) || str.equals(C.get(i4).A()) || str.equals(C.get(i4).y()) || str.equals(C.get(i4).z()) || str.equals(C.get(i4).C()))) {
                                            i5 = i4;
                                        }
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        imageUrlData.imageUrl = C.get(i4).D();
                                        imageUrlData.originalUrl = C.get(i4).D();
                                        imageUrlData.isLongPic = C.get(i4).G();
                                        concurrentHashMap.put(C.get(i4).D(), imageUrlData);
                                    }
                                    i4++;
                                    i3 = -1;
                                }
                                i2 = i5;
                            }
                            Rect rect = new Rect();
                            view2.getGlobalVisibleRect(rect);
                            this.a.s4(rect);
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i2);
                            bVar.C(false);
                            bVar.F(this.a.v0.e1());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.a.k5());
                            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view2));
                            if (this.a.v0 != null) {
                                bVar.A(this.a.v0.getFromForumId());
                                if (this.a.v0.T0() != null) {
                                    bVar.N(this.a.v0.T0().O());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.H5(str, i, eVar);
                        if (eVar.h) {
                            TbRichText D6 = this.a.D6(str, i);
                            if (D6 != null && this.a.s2 >= 0 && this.a.s2 < D6.A().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = cs7.a(D6.A().get(this.a.s2));
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
                                if (D6.getPostId() != 0 && (u0 = this.a.C0.u0()) != null) {
                                    ArrayList<uo> s = u0.s();
                                    if (ListUtils.getCount(s) > 0) {
                                        Iterator<uo> it = s.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            uo next = it.next();
                                            if ((next instanceof PostData) && D6.getPostId() == mg.g(((PostData) next).I(), 0L)) {
                                                yy7.b(this.a.v0.T0(), (PostData) next, ((PostData) next).h0, D6.getPostId() == mg.g(this.a.v0.r0(), 0L) ? 1 : 8, 3);
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
                                this.a.s4(rect2);
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.c);
                                bVar2.y(eVar.d);
                                bVar2.O(eVar.e);
                                bVar2.C(eVar.g);
                                bVar2.H(true);
                                bVar2.J(eVar.i);
                                bVar2.F(this.a.v0.e1());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.a.k5());
                                bVar2.L(eVar.f);
                                bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                                if (this.a.v0 != null) {
                                    bVar2.A(this.a.v0.getFromForumId());
                                    if (this.a.v0.T0() != null) {
                                        bVar2.N(this.a.v0.T0().O());
                                    }
                                }
                                ImageViewerConfig v2 = bVar2.v(this.a.getPageContext().getPageActivity());
                                v2.getIntent().putExtra("from", "pb");
                                this.a.sendMessage(new CustomMessage(2010000, v2));
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
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.c);
                        bVar3.y(eVar.d);
                        bVar3.O(eVar.e);
                        bVar3.C(eVar.g);
                        bVar3.H(true);
                        bVar3.J(eVar.a.get(0));
                        bVar3.F(this.a.v0.e1());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.a.k5());
                        bVar3.L(eVar.f);
                        bVar3.D(false);
                        if (this.a.v0 != null) {
                            bVar3.A(this.a.v0.getFromForumId());
                            if (this.a.v0.T0() != null) {
                                bVar3.N(this.a.v0.T0().O());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8c);
                    boolean x = ((TbImageView) view2).x();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, x)));
                    }
                    this.a.S = view2;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.C0 == null || this.a.C0.u0() == null) {
                return;
            }
            this.a.C0.u0().Z();
        }
    }

    /* loaded from: classes3.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                this.a.C0.m1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                bs7 T0 = this.a.v0.T0();
                if (T0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    T0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.e1.c(this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0b19));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0b15);
                    }
                    this.a.p6(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.k6();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ni.isEmpty(errorString2)) {
                        errorString2 = this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0b16);
                    }
                    this.a.e1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m1 implements ml4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public m1(PbFragment pbFragment) {
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

        @Override // com.repackage.ml4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.C0.h3();
                if (z) {
                    if (this.a.x0 != null) {
                        this.a.x0.h(z2);
                    }
                    this.a.v0.G2(z2);
                    if (this.a.v0.E0()) {
                        this.a.w5();
                    } else {
                        this.a.C0.z1(this.a.v0.T0());
                    }
                    if (z2) {
                        boolean j0 = this.a.v0.T0().j0();
                        if (this.a.x0 != null && !j0) {
                            if (this.a.x0.f() == null || this.a.v0 == null || this.a.v0.T0() == null || this.a.v0.T0().O() == null || this.a.v0.T0().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.x0.f();
                            MetaData author = this.a.v0.T0().O().getAuthor();
                            if (f != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.j6(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00ce);
                                    if (sy4.e(this.a.getContext(), 0)) {
                                        sy4.g(this.a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment pbFragment = this.a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00cd));
                            }
                        }
                        this.a.W3();
                        return;
                    }
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f84));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f148d));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m2 implements er4.c {
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

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                if (er4Var != null) {
                    er4Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.v2;
                if (postData != null) {
                    if (i == 0) {
                        postData.o0();
                        this.a.v2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.A5(pbFragment2.v2);
                    }
                }
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ff5.a)) {
                ff5.a aVar = (ff5.a) customResponsedMessage.getData();
                ff5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements Handler.Callback {
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

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.a.v0 != null && this.a.v0.E0()) {
                    this.a.w5();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class n1 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public n1(PbFragment pbFragment, MetaData metaData) {
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
    public class n2 implements er4.c {
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

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                if (er4Var != null) {
                    er4Var.e();
                }
                if (this.a.i1 == null || TextUtils.isEmpty(this.a.j1)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.k1 == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.j1));
                    } else {
                        i35.a aVar = new i35.a();
                        aVar.a = this.a.j1;
                        String str = "";
                        if (this.a.k1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.k1.memeInfo.pck_id;
                        }
                        aVar.b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (this.a.T0 == null) {
                        this.a.T0 = new PermissionJudgePolicy();
                    }
                    this.a.T0.clearRequestPermissionList();
                    this.a.T0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.T0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.a.h1 == null) {
                        PbFragment pbFragment = this.a;
                        pbFragment.h1 = new kw7(pbFragment.getPageContext());
                    }
                    this.a.h1.b(this.a.j1, this.a.i1.n());
                }
                this.a.i1 = null;
                this.a.j1 = null;
            }
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.g) {
                return;
            }
            this.a.r6();
        }
    }

    /* loaded from: classes3.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                this.a.C0.m1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.e1.c(this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f1469));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ni.isEmpty(muteMessage)) {
                    muteMessage = this.a.d1.getResources().getString(R.string.obfuscated_res_0x7f0f1468);
                }
                this.a.e1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o1 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PbFragment b;

        public o1(PbFragment pbFragment, MetaData metaData) {
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
                this.b.z0.l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.v0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o2 implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.v0 == null || this.a.v0.c1() == i + 1) {
                return;
            }
            PbFragment pbFragment = this.a;
            pbFragment.V5(pbFragment.N4(i));
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                bdTopToast.i(false);
                bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0c9b));
                bdTopToast.j((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(PbFragment pbFragment, int i) {
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
                if (!this.a.i5() || this.a.a == null || this.a.a.getPbModel() == null || !str.equals(this.a.a.getPbModel().getTopicId())) {
                    return;
                }
                this.a.y6(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            ArrayList<PostData> F;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) || this.a.v0 == null || this.a.v0.T0() == null || this.a.C0 == null || this.a.C0.u0() == null) {
                return;
            }
            this.a.C0.f2(absListView, i, i2, i3);
            if (this.a.e != null) {
                this.a.e.q(absListView, i, i2, i3);
            }
            if (!this.a.v0.D1() || (F = this.a.v0.T0().F()) == null || F.isEmpty()) {
                return;
            }
            int w = ((i + i2) - this.a.C0.u0().w()) - 1;
            bs7 T0 = this.a.v0.T0();
            if (T0 == null) {
                return;
            }
            if (T0.D() != null && T0.D().M0()) {
                w--;
            }
            if (T0.E() != null && T0.E().M0()) {
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
                if (!pbFragment.o5(pbFragment.b1) && this.a.o5(i)) {
                    if (this.a.C0 != null) {
                        this.a.C0.i0();
                        if (this.a.R0 != null && !this.a.C0.B1()) {
                            this.a.C0.L2(this.a.R0.C());
                        }
                        if (!this.a.J) {
                            this.a.C0.D2();
                        }
                    }
                    if (!this.a.t) {
                        this.a.t = true;
                    }
                }
                if (this.a.C0 != null) {
                    this.a.C0.g2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.u == null) {
                    this.a.u = new j85();
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
                this.a.b1 = i;
                if (i == 0) {
                    this.a.T5(false, null);
                    dj8.g().h(this.a.getUniqueId(), true);
                    this.a.Z3(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p2 implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                PbFragment pbFragment = this.a;
                pbFragment.b = true;
                return pbFragment.h4(view2);
            }
            return invokeL.booleanValue;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921658) {
                int error = customResponsedMessage.getError();
                if (customResponsedMessage.getData() instanceof Boolean) {
                    boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                    if (error == 0 && booleanValue && TbadkCoreApplication.isLogin() && this.a.x0 != null && !this.a.x0.e()) {
                        this.a.y5();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(PbFragment pbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ds8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.f1) {
                ds8 ds8Var = (ds8) customResponsedMessage.getData();
                this.a.C0.m1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.c1;
                DataRes dataRes = ds8Var.a;
                if (ds8Var.c == 0 && dataRes != null) {
                    int e = mg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (ni.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ea5, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ea5, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e69)).intValue();
                if (intValue == 0) {
                    this.a.l6(r3, sparseArray);
                } else if (intValue == 1) {
                    this.a.C0.m2(sparseArray, r3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q1 implements Comparator<hz4> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(hz4 hz4Var, hz4 hz4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hz4Var, hz4Var2)) == null) ? hz4Var.compareTo(hz4Var2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class q2 implements c3 {
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

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.c3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.C0 != null && this.a.C0.V0() != null) {
                    cv7 V0 = this.a.C0.V0();
                    if (V0.f()) {
                        V0.d();
                        return true;
                    }
                }
                if (this.a.C0 == null || !this.a.C0.O1()) {
                    return false;
                }
                this.a.C0.q1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class r implements TiePlusEventController.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public r(PbFragment pbFragment) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.C0.B1() && (customResponsedMessage.getData() instanceof MotionEvent)) {
                MotionEvent motionEvent = (MotionEvent) customResponsedMessage.getData();
                this.a.n4((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
    public class r2 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ItemCardHelper.l(this.a.getContext(), this.a.getUniqueId(), view2, (ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public s(PbFragment pbFragment) {
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
            sk8 sk8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof sk8) || (sk8Var = (sk8) customResponsedMessage.getData()) == null || (agreeData = sk8Var.b) == null) {
                return;
            }
            if (this.a.C0 != null) {
                this.a.C0.V1(sk8Var);
            }
            if (agreeData.agreeType != 2 || this.a.C0 == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || zx7.k(this.a.v0.b)) {
                return;
            }
            this.a.C0.R3();
            zx7.b(this.a.v0.b);
        }
    }

    /* loaded from: classes3.dex */
    public class s1 extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public s1(PbFragment pbFragment) {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.a.y0.getLoadDataMode()) {
                        case 0:
                            this.a.v0.u1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.q4(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.C0.q0(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.a;
                            pbFragment.r4(pbFragment.y0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.a.C0.q0(this.a.y0.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.C0.h2(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                this.a.C0.q0(this.a.y0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s2 implements ItemCardHelper.c {
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

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.x(this.a.getContext(), ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.a.getView(), 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.x(this.a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.getView(), j);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zo4)) {
                zo4 zo4Var = (zo4) customResponsedMessage.getData();
                rp4.a aVar = new rp4.a();
                int i = zo4Var.a;
                String str = zo4Var.b;
                aVar.a = zo4Var.d;
                bs7 T0 = this.a.v0.T0();
                if (T0 == null) {
                    return;
                }
                if (this.a.v0.v0() != null && this.a.v0.v0().getUserIdLong() == zo4Var.p) {
                    this.a.C0.v2(zo4Var.l, this.a.v0.T0(), this.a.v0.j1(), this.a.v0.d1());
                }
                if (T0.F() == null || T0.F().size() < 1 || T0.F().get(0) == null) {
                    return;
                }
                long g = mg.g(T0.F().get(0).I(), 0L);
                long g2 = mg.g(this.a.v0.l1(), 0L);
                if (g == zo4Var.n && g2 == zo4Var.m) {
                    rp4 H = T0.F().get(0).H();
                    if (H == null) {
                        H = new rp4();
                    }
                    ArrayList<rp4.a> a = H.a();
                    if (a == null) {
                        a = new ArrayList<>();
                    }
                    a.add(0, aVar);
                    H.e(H.b() + zo4Var.l);
                    H.d(a);
                    T0.F().get(0).t0(H);
                    this.a.C0.u0().Z();
                }
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof String) || TextUtils.isEmpty((String) data)) {
                return;
            }
            this.a.l1 = true;
        }
    }

    /* loaded from: classes3.dex */
    public class t1 implements cr4.e {
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
    public class t2 implements NoNetworkView.b {
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

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.g && z && !this.a.v0.I0()) {
                    this.a.O5();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(oi.f(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702ad));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.v0 == null || this.a.v0.T0() == null) {
                return;
            }
            this.a.v0.T0().a();
            this.a.v0.u1();
            if (this.a.C0.u0() != null) {
                this.a.C0.z1(this.a.v0.T0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
    public class u0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public u0(PbFragment pbFragment) {
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
                this.a.a5();
                pp4 R0 = this.a.v0.R0();
                int S0 = this.a.C0.S0();
                if (S0 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0db4);
                } else if (R0 == null || S0 <= R0.h()) {
                    this.a.C0.i0();
                    this.a.u6();
                    this.a.C0.i3();
                    if (mi.z()) {
                        this.a.v0.E2(this.a.C0.S0());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                    }
                    cr4Var.dismiss();
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0db4);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u1 implements j25 {
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

        @Override // com.repackage.j25
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                iw7 iw7Var = this.a.G0;
                if (iw7Var == null || iw7Var.e() == null || !this.a.G0.e().d()) {
                    return !this.a.e4(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.G0.e().c());
                if (this.a.R0 != null && (this.a.R0.B() || this.a.R0.D())) {
                    this.a.R0.z(false, this.a.G0.h());
                }
                this.a.G0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class u2 implements eg<LinearLayout> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f091725);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.v0 == null || this.a.v0.T0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.a.j4(str);
            this.a.v0.u1();
            if (!TextUtils.isEmpty(str) && this.a.v0.T0().F() != null) {
                ArrayList<PostData> F = this.a.v0.T0().F();
                cl8 cl8Var = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof cl8) {
                        cl8 cl8Var2 = (cl8) next;
                        if (str.equals(cl8Var2.N0())) {
                            cl8Var = cl8Var2;
                            break;
                        }
                    }
                }
                if (cl8Var != null) {
                    F.remove(cl8Var);
                    if (this.a.C0.u0() != null && this.a.C0.u0().s() != null) {
                        this.a.C0.u0().s().remove(cl8Var);
                    }
                    if (this.a.C0.L0() != null && this.a.C0.L0().getData() != null) {
                        this.a.C0.L0().getData().remove(cl8Var);
                    }
                    if (this.a.C0.u0() != null) {
                        this.a.C0.u0().Z();
                        return;
                    }
                }
            }
            if (this.a.C0.u0() != null) {
                this.a.C0.z1(this.a.v0.T0());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public v0(PbFragment pbFragment) {
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
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                if (this.a.H0 != null) {
                    this.a.H0.dismiss();
                }
                this.a.z6(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091699);
                        this.a.K5(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091698);
                        this.a.K5(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09169b);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.K5(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09169b);
                        if (view6 != null) {
                            this.a.K5(view6);
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
                        if (this.a.i1 == null || TextUtils.isEmpty(this.a.j1)) {
                            return;
                        }
                        if (this.a.k1 == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.j1));
                        } else {
                            i35.a aVar = new i35.a();
                            aVar.a = this.a.j1;
                            String str = "";
                            if (this.a.k1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.k1.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.a.i1 = null;
                        this.a.j1 = null;
                        return;
                    case 2:
                        if (this.a.i1 == null || TextUtils.isEmpty(this.a.j1)) {
                            return;
                        }
                        if (this.a.T0 == null) {
                            this.a.T0 = new PermissionJudgePolicy();
                        }
                        this.a.T0.clearRequestPermissionList();
                        this.a.T0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.T0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.h1 == null) {
                            PbFragment pbFragment = this.a;
                            pbFragment.h1 = new kw7(pbFragment.getPageContext());
                        }
                        this.a.h1.b(this.a.j1, this.a.i1.n());
                        this.a.i1 = null;
                        this.a.j1 = null;
                        return;
                    case 3:
                        PostData postData = this.a.v2;
                        if (postData != null) {
                            postData.o0();
                            this.a.v2 = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.checkUpIsLogin()) {
                            this.a.z5(view2);
                            if (this.a.v0.T0().O() == null || this.a.v0.T0().O().getAuthor() == null || this.a.v0.T0().O().getAuthor().getUserId() == null || this.a.x0 == null) {
                                return;
                            }
                            PbFragment pbFragment2 = this.a;
                            int S4 = pbFragment2.S4(pbFragment2.v0.T0());
                            ThreadData O = this.a.v0.T0().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.v0.b).param("obj_locate", 2).param("obj_id", this.a.v0.T0().O().getAuthor().getUserId()).param("obj_type", !this.a.x0.e()).param("obj_source", S4).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!mi.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                            return;
                        }
                        Object tag = view2.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.Y4((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091eab)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e69, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e52, 2);
                                this.a.c4(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091e5a) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e58) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e75) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e59) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e6a) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e59)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e75)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e6a)).booleanValue();
                            boolean isHost = this.a.x().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.a.e6(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.C0.k2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e58), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.e6(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.C0.i2(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e58), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!mi.z()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e98)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e96)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eab)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e6e) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6e)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.C0.i2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e58), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e59)).booleanValue());
                                return;
                            }
                            return;
                        } else if (!booleanValue5) {
                            if (booleanValue6) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091e52, 2);
                            }
                            this.a.C0.n2(view2);
                            return;
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e69, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e52, 2);
                            this.a.c4(sparseArray4);
                            return;
                        }
                    case 8:
                        if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e56);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.a.f4(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.a.checkUpIsLogin() || this.a.v0 == null || this.a.v0.T0() == null) {
                            return;
                        }
                        this.a.a.showBlockDialog(as8.b(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v1 implements e3 {
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
    }

    /* loaded from: classes3.dex */
    public class v2 implements View.OnTouchListener {
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

    /* loaded from: classes3.dex */
    public class w implements SuggestEmotionModel.c {
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

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(gx7 gx7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, gx7Var) == null) || gx7Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, gx7Var.c()));
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
    public class w0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PbFragment d;

        public w0(PbFragment pbFragment, SparseArray sparseArray, int i, boolean z) {
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
                this.d.m4(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e58), this.b, this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w1 implements cu4.g {
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

        @Override // com.repackage.cu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.D4()) {
                    this.a.a.finish();
                }
                if (!this.a.v0.Q1(true)) {
                    this.a.C0.p0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w2 implements l36.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ PbFragment b;

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
            this.b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f070282);
        }

        @Override // com.repackage.l36.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || !e(i2) || this.b.C0 == null || this.b.e == null) {
                return;
            }
            this.b.e.u(true);
            if (Math.abs(i2) > this.a) {
                this.b.e.l();
            }
            if (this.b.D4()) {
                this.b.C0.n1();
                this.b.C0.F2();
            }
        }

        @Override // com.repackage.l36.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || !e(i2) || this.b.C0 == null || this.b.e == null) {
                return;
            }
            this.b.C0.M3();
            this.b.e.u(false);
            this.b.e.x();
        }

        @Override // com.repackage.l36.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.l36.b
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.a.C0 == null || this.a.v0 == null) {
                return;
            }
            this.a.C0.c0(false);
            if (this.a.v0.M1(false)) {
                this.a.C0.j3();
            } else if (this.a.v0.T0() != null) {
                this.a.C0.y2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public x0(PbFragment pbFragment) {
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
    public class x1 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.D4()) {
                    this.a.a.finish();
                }
                if (!this.a.v0.Q1(true)) {
                    this.a.C0.p0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class x2 implements m36.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x2() {
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

        @Override // com.repackage.m36.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    ct7.d();
                } else {
                    ct7.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y implements GetSugMatchWordsModel.b {
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.a.C0 == null) {
                return;
            }
            this.a.C0.n3(list);
        }
    }

    /* loaded from: classes3.dex */
    public static class y0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public y0() {
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
    public class y1 implements BdListView.p {
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

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.q2 && this.a.D4()) {
                    this.a.r5();
                }
                if (this.a.mIsLogin) {
                    if (!this.a.m0 && this.a.C0 != null && this.a.C0.Z() && this.a.v0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.a.v0.l1());
                        statisticItem.param("fid", this.a.v0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i = 5;
                        if (this.a.v0.y0()) {
                            i = 4;
                        } else if (this.a.v0.z0()) {
                            i = 3;
                        } else if (this.a.v0.B0()) {
                            i = 1;
                        }
                        statisticItem.param("obj_type", i);
                        TiebaStatic.log(statisticItem);
                        this.a.m0 = true;
                    }
                    if (this.a.v0.M1(false)) {
                        this.a.C0.j3();
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if ((this.a.s0 == null || !this.a.v0.G1() || !this.a.s0.d()) && this.a.v0.T0() != null) {
                        this.a.C0.y2();
                    }
                    this.a.q2 = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y2 implements yu7.b {
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

        @Override // com.repackage.yu7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f1497);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.C0.g0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        public z(PbFragment pbFragment) {
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
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.L1 = false;
                if (this.a.M1 == null) {
                    return;
                }
                bs7 T0 = this.a.v0.T0();
                if (T0.O().getPraise().getIsLike() == 1) {
                    this.a.C6(0);
                } else {
                    this.a.C6(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, T0.O()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.a.L1 = false;
                if (this.a.M1 == null || str == null) {
                    return;
                }
                if (AntiHelper.m(i, str)) {
                    AntiHelper.u(this.a.getPageContext().getPageActivity(), str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z0 implements qn6.d {
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

        @Override // com.repackage.qn6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.qn6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.R0 != null && this.a.R0.a() != null) {
                    this.a.R0.a().A(new i05(45, 27, null));
                }
                this.a.C0.b0();
            }
        }

        @Override // com.repackage.qn6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z1 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.v0 == null) {
                return;
            }
            this.a.v0.loadData();
        }
    }

    /* loaded from: classes3.dex */
    public class z2 implements cr4.e {
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    cr4Var.dismiss();
                    ((TbPageContext) this.a.d1).showToast(R.string.obfuscated_res_0x7f0f06f2);
                    return;
                }
                TiebaStatic.log("c10025");
                cr4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.d1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
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
        K2 = new y0();
        L2 = new x2();
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
        this.r0 = new r(this);
        this.t0 = new c0(this);
        this.u0 = new Handler(new n0(this));
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
        this.K0 = false;
        this.M0 = false;
        this.O0 = false;
        this.Y0 = new j1(this);
        this.Z0 = new u1(this);
        this.a1 = new f2(this);
        this.b1 = 0;
        this.l1 = false;
        this.m1 = 0;
        this.n1 = -1;
        this.p1 = 0;
        this.s1 = new q2(this);
        this.t1 = new b3(this);
        this.u1 = new h(this, 2004016);
        this.v1 = new i(this, 2016485);
        this.w1 = new j(this, 2001269);
        this.x1 = new k(this, 2004008);
        this.y1 = new l(this, 2004007);
        this.z1 = new m(this, 2004005);
        this.A1 = new n(this, 2001332);
        this.B1 = new o(this, 2921391);
        this.C1 = new p(this, 2921606);
        this.D1 = new q(this, 2921658);
        this.E1 = new s(this);
        this.F1 = new t(this, 2001369);
        this.G1 = new u(this, 2016488);
        this.H1 = new v(this, 2016331);
        this.I1 = new w(this);
        this.J1 = new x(this, 2921509);
        this.K1 = new y(this);
        this.M1 = new PraiseModel(getPageContext(), new z(this));
        this.N1 = new a0(this);
        this.O1 = new d0(this, 2001115);
        this.P1 = new e0(this);
        this.Q1 = new h0(this);
        this.R1 = new dt7(new k0(this));
        this.S1 = new m0(this, 2001427);
        this.T1 = new o0(this, 2001428);
        this.U1 = new p0(this, 2921634);
        this.V1 = new q0(this, 2001426);
        this.W1 = new r0(this, 2004021);
        this.X1 = new s0(this, 2016528);
        this.Y1 = new t0(this, 2921033);
        this.Z1 = new u0(this);
        this.a2 = new v0(this);
        this.b2 = new a1(this);
        this.c2 = new d1(this);
        this.d2 = new e1(this, 2921480);
        this.e2 = new f1(this);
        this.f2 = new g1(this);
        this.g2 = new h1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.h2 = new i1(this);
        this.i2 = new k1(this, 2016450);
        this.j2 = new l1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.k2 = new m1(this);
        this.l2 = new p1(this);
        this.m2 = new s1(this);
        this.n2 = new v1(this);
        this.o2 = new w1(this);
        this.p2 = new x1(this);
        this.r2 = new y1(this);
        this.s2 = 0;
        this.t2 = new l2(this);
        this.u2 = false;
        this.v2 = null;
        this.w2 = new m2(this);
        this.x2 = new n2(this);
        this.y2 = new o2(this);
        this.z2 = new p2(this);
        this.A2 = new r2(this);
        this.B2 = new s2(this);
        this.C2 = new t2(this);
        this.D2 = new v2(this);
        this.E2 = new w2(this);
        this.F2 = new y2(this);
        this.G2 = -1;
        this.H2 = -1;
    }

    public static PbFragment C5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public final int A4(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.u2 = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.A().size();
                int i5 = i3;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.A().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int h3 = (int) oi.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.E().getWidth() * h3;
                        int height = tbRichTextData.E().getHeight() * h3;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.E().F()) {
                            if (tbRichText == tbRichText2) {
                                if (i6 <= i4) {
                                    i5--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a4 = cs7.a(tbRichTextData);
                            if (!TextUtils.isEmpty(a4)) {
                                arrayList.add(a4);
                                if (tbRichTextData != null && (E = tbRichTextData.E()) != null) {
                                    String A = E.A();
                                    ImageUrlData imageUrlData = new ImageUrlData();
                                    if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                        imageUrlData.urlType = 38;
                                        A = E.B();
                                    } else {
                                        imageUrlData.urlType = this.s ? 17 : 18;
                                    }
                                    imageUrlData.imageUrl = A;
                                    imageUrlData.originalUrl = J4(tbRichTextData);
                                    imageUrlData.originalSize = K4(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = E4(tbRichTextData);
                                    imageUrlData.isLongPic = C4(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = mg.g(this.v0.l1(), -1L);
                                    imageUrlData.mIsReserver = this.v0.e1();
                                    imageUrlData.mIsSeeHost = this.v0.w0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a4, imageUrlData);
                                    }
                                }
                            }
                            if (!this.u2) {
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

    public void A5(PostData postData) {
        PostData v4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.I() != null && postData.I().equals(this.v0.O0())) {
            z3 = true;
        }
        MarkData N0 = this.v0.N0(postData);
        if (this.v0.T0() != null && this.v0.T0().g0() && (v4 = v4()) != null) {
            N0 = this.v0.N0(v4);
        }
        if (N0 == null) {
            return;
        }
        this.C0.i3();
        ml4 ml4Var = this.x0;
        if (ml4Var != null) {
            ml4Var.i(N0);
            if (!z3) {
                this.x0.a();
            } else {
                this.x0.d();
            }
        }
    }

    public final void A6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.D(this.v0.getForumId()) && this.v0.T0() != null && this.v0.T0().l() != null) {
            if (this.v0.T0().l().isLike() == 1) {
                this.v0.g0().C(this.v0.getForumId(), this.v0.l1());
            }
        }
    }

    public PbInterviewStatusView.f B4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public final boolean B5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q3 = vt4.k().q("bubble_link", "");
                if (StringUtils.isNull(q3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    ul4.q(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0528), q3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void B6(ko4 ko4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ko4Var) == null) || ko4Var == null) {
            return;
        }
        this.J2 = ko4Var;
        this.c = true;
        this.C0.A2();
        this.C0.V2(this.I2);
    }

    public final boolean C4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return false;
            }
            return tbRichTextData.E().G();
        }
        return invokeL.booleanValue;
    }

    public final void C6(int i3) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i3) == null) || (pbModel = this.v0) == null || pbModel.T0() == null || (O = this.v0.T0().O()) == null) {
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
                    getResources().getString(R.string.obfuscated_res_0x7f0f15e6);
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
                getResources().getString(R.string.obfuscated_res_0x7f0f15e6);
            } else {
                String str = O.getPraise().getNum() + "";
            }
        }
        if (this.v0.j1()) {
            this.C0.u0().Z();
        } else {
            this.C0.g4(this.v0.T0());
        }
    }

    public boolean D4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (!this.c && this.G2 == -1 && this.H2 == -1) ? false : true : invokeV.booleanValue;
    }

    public void D5() {
        List<c3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (list = this.o1) == null || list.isEmpty()) {
            return;
        }
        int size = this.o1.size();
        while (true) {
            size--;
            if (size <= -1 || this.o1.get(size).onBackPressed()) {
                return;
            }
        }
    }

    public final TbRichText D6(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i3)) == null) {
            PbModel pbModel = this.v0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.T0() == null || str == null || i3 < 0) {
                return null;
            }
            bs7 T0 = this.v0.T0();
            if (T0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(T0.j());
                tbRichText = z4(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = T0.F();
                Y3(T0, F);
                return z4(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public final boolean E4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return false;
            }
            return tbRichTextData.E().H();
        }
        return invokeL.booleanValue;
    }

    public boolean E5(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        gw7 gw7Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i3, keyEvent)) == null) ? (keyEvent == null || (gw7Var = this.C0) == null || !gw7Var.a2(i3)) ? false : true : invokeIL.booleanValue;
    }

    public boolean F4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.K : invokeV.booleanValue;
    }

    public final void F5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!mi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c18);
                return;
            }
            this.C0.i0();
            if (this.i) {
                return;
            }
            u6();
            this.C0.i3();
            if (this.v0.loadData()) {
                this.C0.O3();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.if5
    /* renamed from: G4 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            gw7 gw7Var = this.C0;
            if (gw7Var == null) {
                return null;
            }
            return gw7Var.L0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void G5() {
        PbModel pbModel;
        bs7 T0;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (pbModel = this.v0) == null || pbModel.T0() == null || (O = (T0 = this.v0.T0()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.C0.k1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        sv7 sv7Var = new sv7();
        int V = this.v0.T0().V();
        if (V != 1 && V != 3) {
            sv7Var.g = false;
        } else {
            sv7Var.g = true;
            sv7Var.s = O.getIs_top() == 1;
        }
        if (m5(V)) {
            sv7Var.h = true;
            sv7Var.r = O.getIs_good() == 1;
        } else {
            sv7Var.h = false;
        }
        if (V == 1002 && !equals) {
            sv7Var.u = true;
        }
        sv7Var.n = h6(O.isBlocked(), T0.i0(), equals, V, O.isWorksInfo(), O.isScoreThread());
        sv7Var.e = f6(equals, T0.i0());
        sv7Var.i = i6();
        sv7Var.f = g6(equals);
        sv7Var.k = equals && T0.U() != null && T0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            sv7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        sv7Var.t = equals;
        sv7Var.q = this.v0.j1();
        sv7Var.b = true;
        sv7Var.a = p5(equals);
        if (equals) {
            this.C0.A1();
        }
        sv7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        sv7Var.j = true;
        sv7Var.o = this.v0.w0();
        sv7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            sv7Var.c = true;
        } else {
            sv7Var.c = false;
        }
        if (T0.g0()) {
            sv7Var.b = false;
            sv7Var.d = false;
            sv7Var.c = false;
            sv7Var.g = false;
            sv7Var.h = false;
        }
        sv7Var.v = TbSingleton.getInstance().mShowCallFans && equals && !T0.g0();
        gw7 gw7Var = this.C0;
        if (gw7Var != null) {
            PbModel pbModel2 = this.v0;
            PostData C0 = gw7Var.C0(pbModel2.G, pbModel2.j1());
            sv7Var.w = C0 != null ? C0.Q : false;
        }
        sv7Var.m = true;
        if (O.isBlocked()) {
            sv7Var.n = false;
            sv7Var.g = false;
            sv7Var.h = false;
        }
        this.C0.h.E(sv7Var);
    }

    public int H4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.H2 : invokeV.intValue;
    }

    public final void H5(String str, int i3, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048594, this, str, i3, eVar) == null) || eVar == null) {
            return;
        }
        bs7 T0 = this.v0.T0();
        TbRichText D6 = D6(str, i3);
        if (D6 == null || (tbRichTextData = D6.A().get(this.s2)) == null) {
            return;
        }
        eVar.f = String.valueOf(D6.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.E().F()) {
            eVar.h = false;
            String a4 = cs7.a(tbRichTextData);
            eVar.a.add(a4);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.s ? 17 : 18;
            }
            imageUrlData.originalUrl = J4(tbRichTextData);
            imageUrlData.originalUrl = J4(tbRichTextData);
            imageUrlData.originalSize = K4(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = E4(tbRichTextData);
            imageUrlData.isLongPic = C4(tbRichTextData);
            imageUrlData.postId = D6.getPostId();
            imageUrlData.mIsReserver = this.v0.e1();
            imageUrlData.mIsSeeHost = this.v0.w0();
            eVar.b.put(a4, imageUrlData);
            if (T0 != null) {
                if (T0.l() != null) {
                    eVar.c = T0.l().getName();
                    eVar.d = T0.l().getId();
                }
                if (T0.O() != null) {
                    eVar.e = T0.O().getId();
                }
                eVar.g = T0.s() == 1;
            }
            imageUrlData.threadId = mg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = T0.F().size();
        this.u2 = false;
        eVar.j = -1;
        int A4 = T0.j() != null ? A4(T0.j().P(), D6, i3, i3, eVar.a, eVar.b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = T0.F().get(i4);
            if (postData.I() == null || T0.j() == null || T0.j().I() == null || !postData.I().equals(T0.j().I())) {
                A4 = A4(postData.P(), D6, A4, i3, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (T0 != null) {
            if (T0.l() != null) {
                eVar.c = T0.l().getName();
                eVar.d = T0.l().getId();
            }
            if (T0.O() != null) {
                eVar.e = T0.O().getId();
            }
            eVar.g = T0.s() == 1;
        }
        eVar.j = A4;
    }

    public int I4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.G2 : invokeV.intValue;
    }

    public void I5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || !checkUpIsLogin() || (pbModel = this.v0) == null || pbModel.T0() == null || this.v0.T0().l() == null || a4()) {
            return;
        }
        if (this.v0.T0().g0()) {
            this.C0.b0();
            return;
        }
        if (this.V0 == null) {
            qn6 qn6Var = new qn6(getPageContext());
            this.V0 = qn6Var;
            qn6Var.j(0);
            this.V0.i(new z0(this));
        }
        this.V0.g(this.v0.T0().l().getId(), mg.g(this.v0.l1(), 0L));
    }

    public final String J4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return null;
            }
            return tbRichTextData.E().C();
        }
        return (String) invokeL.objValue;
    }

    public final AbsPbActivity.e J5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            String str2 = null;
            if (this.v0.T0() != null && this.v0.T0().F() != null && this.v0.T0().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.v0.T0().F().size()) {
                        i3 = 0;
                        break;
                    } else if (str.equals(this.v0.T0().F().get(i3).I())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                PostData postData = this.v0.T0().F().get(i3);
                if (postData.P() != null && postData.P().A() != null) {
                    Iterator<TbRichTextData> it = postData.P().A().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TbRichTextData next = it.next();
                        if (next != null && next.getType() == 8) {
                            if (next.E() != null) {
                                str2 = next.E().A();
                            }
                        }
                    }
                    H5(str2, 0, eVar);
                    cs7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final long K4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.E() == null) {
                return 0L;
            }
            return tbRichTextData.E().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void K5(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09172f, Integer.valueOf(this.b ? 2 : 3));
        view2.setTag(sparseArray);
    }

    public m25 L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.R0 : (m25) invokeV.objValue;
    }

    public void L5(rs7 rs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, rs7Var) == null) {
            String I = rs7Var.i().I();
            List<PostData> list = this.v0.T0().T().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i3);
                if (postData.I() == null || !postData.I().equals(I)) {
                    i3++;
                } else {
                    ArrayList<PostData> k3 = rs7Var.k();
                    postData.D0(rs7Var.m());
                    if (postData.R() != null) {
                        postData.R().clear();
                        postData.R().addAll(k3);
                    }
                }
            }
            if (this.v0.C0()) {
                return;
            }
            this.C0.z1(this.v0.T0());
        }
    }

    public lx7 M4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.e : (lx7) invokeV.objValue;
    }

    public void M5(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048604, this, z3, markData) == null) {
            this.C0.h3();
            this.v0.G2(z3);
            ml4 ml4Var = this.x0;
            if (ml4Var != null) {
                ml4Var.h(z3);
                if (markData != null) {
                    this.x0.i(markData);
                }
            }
            if (this.v0.E0()) {
                w5();
            } else {
                this.C0.z1(this.v0.T0());
            }
        }
    }

    public final int N4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i3)) == null) {
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

    public void N5(rs7 rs7Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, rs7Var) == null) || rs7Var.i() == null) {
            return;
        }
        String I = rs7Var.i().I();
        ArrayList<PostData> F = this.v0.T0().F();
        int i3 = 0;
        while (true) {
            if (i3 >= F.size()) {
                break;
            }
            PostData postData = F.get(i3);
            if (postData.I() == null || !postData.I().equals(I)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = rs7Var.k();
                postData.D0(rs7Var.m());
                if (postData.R() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.Y() != null && next != null && next.s() != null && (metaData = postData.Y().get(next.s().getUserId())) != null) {
                            next.n0(metaData);
                            next.x0(true);
                            next.J0(getPageContext(), this.v0.J1(metaData.getUserId()));
                        }
                    }
                    z3 = k3.size() != postData.R().size();
                    if (!postData.c0(false)) {
                        postData.R().clear();
                        postData.R().addAll(k3);
                    }
                }
                if (postData.x() != null) {
                    postData.l0();
                }
            }
        }
        if (!this.v0.C0() && z3) {
            this.C0.z1(this.v0.T0());
        }
        if (z3) {
            L5(rs7Var);
        }
    }

    public wx7 O4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.s0 : (wx7) invokeV.objValue;
    }

    public final void O5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            hideNetRefreshView(this.C0.g1());
            m6();
            if (this.v0.S1()) {
                this.C0.i3();
            }
            this.C0.r3();
        }
    }

    public gw7 P4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.C0 : (gw7) invokeV.objValue;
    }

    public void P5(c3 c3Var) {
        List<c3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, c3Var) == null) || c3Var == null || (list = this.o1) == null) {
            return;
        }
        list.remove(c3Var);
    }

    public aq4 Q4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.j0 : (aq4) invokeV.objValue;
    }

    public final boolean Q5(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091e56);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.z0 && !TextUtils.isEmpty(postData.u()) && bn4.c().g()) {
                        return B5(postData.I());
                    }
                    if (checkUpIsLogin() && (pbModel = this.v0) != null && pbModel.T0() != null) {
                        if (P4().V0() != null) {
                            P4().V0().c();
                        }
                        rs7 rs7Var = new rs7();
                        rs7Var.A(this.v0.T0().l());
                        rs7Var.E(this.v0.T0().O());
                        rs7Var.C(postData);
                        P4().U0().U(rs7Var);
                        P4().U0().setPostId(postData.I());
                        v5(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        m25 m25Var = this.R0;
                        if (m25Var != null) {
                            this.C0.L2(m25Var.C());
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

    public String R4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public final void R5(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.Q == null) {
            hx7 hx7Var = new hx7(this.a);
            this.Q = hx7Var;
            hx7Var.n(this.Y0);
            this.Q.m(this.e2);
        }
        this.Q.k(emotionImageData, w(), w().T0());
    }

    public final int S4(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.O() == null) {
                return 0;
            }
            if (bs7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (bs7Var.O().getThreadType() == 54) {
                return 2;
            }
            return bs7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public final void S5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (pbModel = this.v0) == null || pbModel.T0() == null || this.v0.T0().O() == null || !this.v0.T0().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jz7
    /* renamed from: T4 */
    public VideoPbFragment t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public final void T5(boolean z3, PostData postData) {
        hw4 adAdSense;
        gw7 gw7Var;
        qu7 u02;
        ArrayList<PostData> E;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048618, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g() || (gw7Var = this.C0) == null || (u02 = gw7Var.u0()) == null || (E = u02.E()) == null) {
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
            String I = next.I();
            i3++;
            if (z3) {
                if (next == postData) {
                    hl8.c cVar = new hl8.c();
                    cVar.b = I;
                    cVar.c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.C == 1 && !TextUtils.isEmpty(I)) {
                next.C = 2;
                hl8.c cVar2 = new hl8.c();
                cVar2.b = I;
                cVar2.c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.T0() == null || this.v0.T0().l() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.v0.T0().l().getFirst_class();
                str2 = this.v0.T0().l().getSecond_class();
                str3 = this.v0.T0().l().getId();
                str4 = this.v0.l1();
                str = first_class;
            }
            na8.w(z3, str, str2, str3, str4, arrayList, adAdSense.i());
        }
    }

    @Override // com.repackage.jz7
    public PbModel.g U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.h2 : (PbModel.g) invokeV.objValue;
    }

    public void U3(c3 c3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, c3Var) == null) || c3Var == null) {
            return;
        }
        if (this.o1 == null) {
            this.o1 = new ArrayList();
        }
        if (this.o1.contains(c3Var)) {
            return;
        }
        this.o1.add(c3Var);
    }

    public String U4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public final void U5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (pbModel = this.v0) == null || pbModel.T0() == null || this.v0.T0().O() == null || !this.v0.T0().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public void V3(c3 c3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, c3Var) == null) || c3Var == null) {
            return;
        }
        if (this.o1 == null) {
            this.o1 = new ArrayList();
        }
        if (this.o1.contains(c3Var)) {
            return;
        }
        this.o1.add(0, c3Var);
    }

    public void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.g) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.v0.T0() == null || this.v0.T0().O() == null || this.v0.T0().O().getTaskInfoData() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.v0.T0().O().getTaskInfoData().g(), this.v0.T0().O().getTaskInfoData().f(), this.v0.T0().O().getTaskInfoData().b(), this.v0.T0().O().getTaskInfoData().c(), this.v0.T0().O().getIs_top(), this.v0.T0().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void V5(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i3) == null) || this.v0 == null) {
            return;
        }
        m6();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
        privacySettingMessage.setTid(this.v0.b);
        sendMessage(privacySettingMessage);
    }

    public final void W3() {
        PbModel pbModel;
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (pbModel = this.v0) == null || (bs7Var = pbModel.G) == null || bs7Var.O() == null) {
            return;
        }
        ThreadData O = this.v0.G.O();
        O.mRecomAbTag = this.v0.Y0();
        O.mRecomWeight = this.v0.b1();
        O.mRecomSource = this.v0.a1();
        O.mRecomExtra = this.v0.Z0();
        O.isSubPb = this.v0.G0();
        if (O.getFid() == 0) {
            O.setFid(mg.g(this.v0.getForumId(), 0L));
        }
        StatisticItem i3 = u75.i(getContext(), O, "c13562");
        TbPageTag l3 = u75.l(getContext());
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

    public final void W4(int i3, Intent intent) {
        v05 v05Var;
        v05 v05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048627, this, i3, intent) == null) {
            if (i3 == 0) {
                this.C0.k1();
                this.C0.V0().c();
                this.C0.w3(false);
            }
            this.C0.D2();
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
                    if (editorType != 1 || this.C0.V0() == null || this.C0.V0().b() == null) {
                        return;
                    }
                    p25 b4 = this.C0.V0().b();
                    b4.c0(this.v0.T0().O());
                    b4.B(writeData);
                    b4.d0(pbEditorData.getVoiceModel());
                    u05 n3 = b4.a().n(6);
                    if (n3 != null && (v05Var2 = n3.k) != null) {
                        v05Var2.onAction(new i05(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        b4.F();
                        return;
                    }
                    return;
                }
                this.R0.S();
                this.R0.t0(pbEditorData.getVoiceModel());
                this.R0.G(writeData);
                u05 n4 = this.R0.a().n(6);
                if (n4 != null && (v05Var = n4.k) != null) {
                    v05Var.onAction(new i05(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    this.R0.L(null, null);
                }
            }
        }
    }

    public void W5(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z3) == null) {
            this.N = z3;
        }
    }

    public final void X3(boolean z3) {
        PbModel pbModel;
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048629, this, z3) == null) || (pbModel = this.v0) == null || (bs7Var = pbModel.G) == null || bs7Var.O() == null) {
            return;
        }
        ThreadData O = this.v0.G.O();
        O.mRecomAbTag = this.v0.Y0();
        O.mRecomWeight = this.v0.b1();
        O.mRecomSource = this.v0.a1();
        O.mRecomExtra = this.v0.Z0();
        if (O.getFid() == 0) {
            O.setFid(mg.g(this.v0.getForumId(), 0L));
        }
        StatisticItem i3 = u75.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l3 = u75.l(getContext());
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
            p75 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(i3);
        }
    }

    public void X4(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091ea8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea8) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091eaa) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea9) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091ea5) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea5) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091ea6) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.f1);
            userMuteAddAndDelCustomMessage.setTag(this.f1);
            q6(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void X5(o25 o25Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, o25Var) == null) || o25Var == null || (pbModel = this.v0) == null) {
            return;
        }
        o25Var.p(pbModel.s0());
        if (this.v0.T0() != null && this.v0.T0().l() != null) {
            o25Var.o(this.v0.T0().l());
        }
        o25Var.q("pb");
        o25Var.r(this.v0);
    }

    public final void Y3(bs7 bs7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048632, this, bs7Var, arrayList) == null) || bs7Var == null || bs7Var.T() == null || bs7Var.T().a == null || (list = bs7Var.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.I()) && !TextUtils.isEmpty(postData.I()) && next.I().equals(postData.I())) {
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

    public final void Y4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.T0() != null && this.v0.T0().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.v0.l1(), str);
                ThreadData O = this.v0.T0().O();
                if (O.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (O.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (O.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                q5(format);
                return;
            }
            this.w0.a(str);
        }
    }

    public final void Y5(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048634, this, i3) == null) || (pbModel = this.v0) == null) {
            return;
        }
        int c12 = pbModel.c1();
        if (i3 == 5) {
            this.v0.A2(2);
        } else if (i3 == 6) {
            this.v0.A2(3);
        } else if (i3 != 7) {
            this.v0.A2(1);
        } else {
            this.v0.A2(4);
        }
        int c13 = this.v0.c1();
        if (c12 == 4 || c13 == 4) {
            F5();
        }
    }

    public void Z3(boolean z3) {
        gw7 gw7Var;
        int w3;
        int w4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048635, this, z3) == null) || (gw7Var = this.C0) == null || gw7Var.L0() == null) {
            return;
        }
        int firstVisiblePosition = this.C0.L0().getFirstVisiblePosition();
        int lastVisiblePosition = this.C0.L0().getLastVisiblePosition();
        qu7 u02 = this.C0.u0();
        if (u02 == null || this.v0.T0() == null) {
            return;
        }
        if (lastVisiblePosition <= u02.w()) {
            w3 = 0;
            w4 = 1;
        } else {
            w3 = firstVisiblePosition > u02.w() ? firstVisiblePosition - u02.w() : 0;
            w4 = (lastVisiblePosition - u02.w()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (w4 > w3) {
            while (w3 < w4) {
                if (this.C0.L0().G(w3) != null && (this.C0.L0().G(w3) instanceof PostData) && (postData = (PostData) this.C0.L0().G(w3)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.v0.T0().F(), postData.A() - 1);
                    if (postData.p() == null && postData2 != null) {
                        postData.m0(postData2.p());
                    }
                    if (postData.p() != null) {
                        postData.p().q(postData.A());
                        arrayList.add(postData.p());
                    }
                }
                w3++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new q1(this));
            hz4 hz4Var = (hz4) ListUtils.getItem(arrayList, 0);
            if (hz4Var == null || hz4Var.e() != 1) {
                this.C0.p2(hz4Var, 1);
            } else if (z3) {
            } else {
                this.C0.p2(hz4Var, 0);
            }
        }
    }

    public final void Z4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, intent) == null) {
            zx7.j(this, intent);
        }
    }

    public void Z5(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z3) == null) {
            this.K = z3;
        }
    }

    public final boolean a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.T0() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.v0.T0().O()) || AntiHelper.d(getPageContext(), this.v0.T0().d());
        }
        return invokeV.booleanValue;
    }

    public void a5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || this.a == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.a.getCurrentFocus() == null) {
            return;
        }
        oi.w(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public final void a6(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z3) == null) {
            this.R0.f0(z3);
            this.R0.i0(z3);
            this.R0.p0(z3);
        }
    }

    public final boolean b4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i3)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void b5() {
        gw7 gw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (gw7Var = this.C0) == null) {
            return;
        }
        gw7Var.k1();
        a5();
    }

    public final void b6(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048643, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new r1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                p6(str);
            } else {
                this.C0.W3(str);
            }
        }
    }

    public void c4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.C0.E3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = mg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = mg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091ea7), 0L);
            BdUniqueId bdUniqueId = this.f1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.c1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void c5(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048645, this, i3, i4) == null) {
            dd5.b(new f(this, i4), new g(this, i4, i3));
        }
    }

    public final void c6(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048646, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null || getPageContext() == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (P4() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    uy4.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                } else {
                    en8.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.v0.G0()) {
            antiData.setBlock_forum_name(this.v0.T0().l().getName());
            antiData.setBlock_forum_id(this.v0.T0().l().getId());
            antiData.setUser_name(this.v0.T0().U().getUserName());
            antiData.setUser_id(this.v0.T0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public boolean d4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if ((this.v0.T0() != null && (this.v0.T0().g0() || ThreadCardUtils.isSelf(this.v0.T0().O()))) || this.U0 == null || this.v0.T0() == null || this.v0.T0().d() == null) {
                return true;
            }
            return this.U0.checkPrivacyBeforeInvokeEditor(this.v0.T0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void d5(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i3) == null) {
            dd5.b(new d(this), new e(this, i3));
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

    public final void d6(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048649, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            zx7.l(this, j3, str, j4);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048650, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (ff5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ff5.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (lw7.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new ud5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public boolean e4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048651, this, i3)) == null) {
            if (this.U0 == null || this.v0.T0() == null || ThreadCardUtils.isSelf(this.v0.T0().O()) || this.v0.T0().d() == null) {
                return true;
            }
            return this.U0.checkPrivacyBeforeSend(this.v0.T0().d().replyPrivateFlag, i3);
        }
        return invokeI.booleanValue;
    }

    public final void e5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, bundle) == null) {
            ml4 c4 = ml4.c(this.a);
            this.x0 = c4;
            if (c4 != null) {
                c4.j(this.k2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.y0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.m2);
            this.z0 = new by4(getPageContext());
            this.M1.setUniqueId(getUniqueId());
            this.M1.registerListener();
        }
    }

    public final void e6(SparseArray<Object> sparseArray, int i3, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) {
            yx7.d(getActivity(), getPageContext(), new w0(this, sparseArray, i3, z3), new x0(this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f4(AgreeData agreeData) {
        p75 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048654, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.l0 == null) {
            this.l0 = new rt4();
        }
        if (this.p0 == null) {
            sk8 sk8Var = new sk8();
            this.p0 = sk8Var;
            sk8Var.a = getUniqueId();
        }
        vn4 vn4Var = new vn4();
        vn4Var.b = 5;
        vn4Var.h = 8;
        vn4Var.g = 2;
        if (w() != null) {
            vn4Var.f = w().S0();
        }
        vn4Var.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                vn4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l0.c(agreeData, i3, getUniqueId(), false);
                this.l0.d(agreeData, this.p0);
                pbModel = this.v0;
                if (pbModel != null || pbModel.T0() == null) {
                }
                this.l0.b(x(), vn4Var, agreeData, this.v0.T0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            vn4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            vn4Var.i = 1;
        }
        i3 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
        if (currentVisiblePageExtra != null) {
        }
        this.l0.c(agreeData, i3, getUniqueId(), false);
        this.l0.d(agreeData, this.p0);
        pbModel = this.v0;
        if (pbModel != null) {
        }
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.R = likeModel;
            likeModel.setLoadDataCallBack(new i0(this));
        }
    }

    public final boolean f6(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        uo4 uo4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048656, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.T0() == null) {
                return false;
            }
            bs7 T0 = this.v0.T0();
            ThreadData O = T0.O();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !we6.isOn()) || this.v0.G() || O.isWorksInfo() || O.isScoreThread() || z4) {
                return false;
            }
            if (T0.l() == null || !T0.l().isBlockBawuDelete) {
                if (T0.O() == null || !T0.O().isBlocked()) {
                    if (T0.V() != 0) {
                        return T0.V() != 3;
                    }
                    List<nq4> p3 = T0.p();
                    if (ListUtils.getCount(p3) > 0) {
                        for (nq4 nq4Var : p3) {
                            if (nq4Var != null && (uo4Var = nq4Var.g) != null && uo4Var.a && !uo4Var.c && ((i3 = uo4Var.b) == 1 || i3 == 2)) {
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

    @Override // com.repackage.jz7
    public void finish() {
        gw7 gw7Var;
        CardHListViewData q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            gw7 gw7Var2 = this.C0;
            if (gw7Var2 != null) {
                gw7Var2.i0();
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.T0() != null && !this.v0.T0().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.v0.T0().O().getId();
                if (this.v0.isShareThread() && this.v0.T0().O().originalThreadData != null) {
                    historyMessage.threadName = this.v0.T0().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.v0.T0().O().getTitle();
                }
                if (this.v0.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.v0.T0().l().getName();
                }
                ArrayList<PostData> F = this.v0.T0().F();
                gw7 gw7Var3 = this.C0;
                int B0 = gw7Var3 != null ? gw7Var3.B0() : 0;
                if (F != null && B0 >= 0 && B0 < F.size()) {
                    historyMessage.postID = F.get(B0).I();
                }
                historyMessage.isHostOnly = this.v0.w0();
                historyMessage.isSquence = this.v0.j1();
                historyMessage.isShareThread = this.v0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            m25 m25Var = this.R0;
            if (m25Var != null) {
                m25Var.I();
            }
            if (this.j && P4() != null) {
                P4().n0();
            }
            PbModel pbModel2 = this.v0;
            if (pbModel2 != null && (pbModel2.y0() || this.v0.B0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.v0.l1());
                if (this.D0) {
                    if (this.F0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.v0.H0());
                    }
                    if (this.E0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.v0.D0());
                    }
                }
                if (this.v0.T0() != null && System.currentTimeMillis() - this.p >= 40000 && (q3 = this.v0.T0().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.n1);
                }
                this.a.setResult(-1, intent);
            }
            if (w6()) {
                if (this.v0 != null && (gw7Var = this.C0) != null && gw7Var.L0() != null) {
                    bs7 T0 = this.v0.T0();
                    if (T0 != null) {
                        if (T0.U() != null) {
                            T0.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!T0.m0() && !this.I && T0.h == null) {
                            yv7.b().n(this.v0.U0(), this.C0.L0().onSaveInstanceState(), this.v0.j1(), this.v0.w0(), this.C0.T0() != null && this.C0.T0().getVisibility() == 0);
                            if (this.m1 >= 0 || this.v0.n1() != null) {
                                yv7.b().q(this.v0.n1());
                                yv7.b().r(this.v0.o1());
                                yv7.b().o(this.v0.M0());
                            }
                        }
                    }
                } else {
                    yv7.b().m();
                }
                v6();
            }
        }
    }

    public final void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            if (this.v0.y0() || this.v0.B0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.v0.l1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.v0.l1()));
            if (w6()) {
                this.a.finish();
            }
        }
    }

    public final void g5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048659, this) == null) && this.m == null) {
            this.m = new er4(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f0363), getPageContext().getString(R.string.obfuscated_res_0x7f0f118b), getPageContext().getString(R.string.obfuscated_res_0x7f0f10a0)};
            er4 er4Var = this.m;
            er4Var.j(strArr, new l0(this));
            er4Var.g(er4.b.obfuscated_res_0x7f1003a4);
            er4Var.h(17);
            er4Var.c(getPageContext());
        }
    }

    public final boolean g6(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048660, this, z3)) == null) {
            if (z3 || (pbModel = this.v0) == null || pbModel.T0() == null || (this.v0.T0().l() != null && this.v0.T0().l().isBlockBawuDelete)) {
                return false;
            }
            bs7 T0 = this.v0.T0();
            if ((T0.O() == null || T0.O().getAuthor() == null || !T0.O().getAuthor().isForumBusinessAccount() || we6.isOn()) && !this.v0.G()) {
                return ((T0.O() != null && T0.O().isBlocked()) || this.v0.T0().V() == 0 || this.v0.T0().V() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public kx7 getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.a.getEventController() : (kx7) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if (this.L == null) {
                this.L = new dg<>(new g2(this), 20, 0);
            }
            return this.L;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.C == null) {
                this.C = new dg<>(new e2(this), 8, 0);
            }
            return this.C;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (this.H == null) {
                this.H = new dg<>(new k2(this), 10, 0);
            }
            return this.H;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.repackage.if5
    public dg<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            dg<RelativeLayout> dgVar = new dg<>(new j2(this), 10, 0);
            this.G = dgVar;
            return dgVar;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            gw7 gw7Var = this.C0;
            if (gw7Var == null) {
                return 0;
            }
            return gw7Var.a1();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.if5
    public dg<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.A == null) {
                this.A = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            if (this.F == null) {
                this.F = new dg<>(new u2(this), 15, 0);
            }
            return this.F;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (this.E == null) {
                this.E = new dg<>(new h2(this), 5, 0);
            }
            return this.E;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public dg<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (this.B == null) {
                this.B = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.B;
        }
        return (dg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.k : (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public dg<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            if (this.D == null) {
                this.D = new dg<>(new i2(this), 8, 0);
            }
            return this.D;
        }
        return (dg) invokeV.objValue;
    }

    public final boolean h4(View view2) {
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
        fo foVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048675, this, view2)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                gw7 gw7Var = this.C0;
                if (gw7Var != null) {
                    if (gw7Var.D1()) {
                        return true;
                    }
                    this.C0.r0();
                }
                try {
                    sparseArray = (SparseArray) view2.getTag();
                } catch (ClassCastException e4) {
                    e4.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (l5(view2)) {
                        if (view2 instanceof TbImageView) {
                            TbImageView tbImageView = (TbImageView) view2;
                            this.i1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.j1 = url;
                            if (this.i1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f091e8c) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8c) instanceof TbRichTextImageInfo)) {
                                this.k1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8c);
                            } else {
                                this.k1 = null;
                            }
                        } else if (view2 instanceof GifView) {
                            GifView gifView = (GifView) view2;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.i1 = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                                this.j1 = gifView.getBdImage().q();
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f091e8c) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8c) instanceof TbRichTextImageInfo)) {
                                this.k1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8c);
                            } else {
                                this.k1 = null;
                            }
                        } else if (view2 instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.i1 = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                    this.j1 = tbMemeImageView.getBdImage().q();
                                }
                                if (view2.getTag(R.id.obfuscated_res_0x7f091e8c) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8c) instanceof TbRichTextImageInfo)) {
                                    this.k1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8c);
                                } else {
                                    this.k1 = null;
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
                            this.C0.J3(this.x2, this.i1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e56);
                this.v2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.A() == 1 && l5(view2)) {
                    this.C0.J3(this.x2, this.i1.t());
                    return true;
                }
                ml4 ml4Var = this.x0;
                if (ml4Var == null) {
                    return true;
                }
                boolean z6 = ml4Var.e() && this.v2.I() != null && this.v2.I().equals(this.v0.O0());
                boolean z7 = w().T0() != null && w().T0().g0();
                boolean z8 = w().T0() != null && w().T0().j0();
                if (this.v2.A() == 1) {
                    if (!z7) {
                        this.C0.K3(this.w2, z6, false, z8);
                    }
                    return true;
                }
                if (this.I0 == null) {
                    nr4 nr4Var = new nr4(getContext());
                    this.I0 = nr4Var;
                    nr4Var.n(this.a2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 == null || sparseArray == null) {
                    return true;
                }
                boolean z9 = l5(view2) && !z7;
                boolean z10 = (!l5(view2) || (foVar = this.i1) == null || foVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e6f) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6f)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091e98) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e98)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091e96) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e96)).booleanValue() : false;
                String str = sparseArray.get(R.id.obfuscated_res_0x7f091e66) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e66) : null;
                boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e6e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6e)).booleanValue() : false;
                if (z9) {
                    z3 = booleanValue7;
                    z5 = booleanValue6;
                    z4 = booleanValue5;
                    arrayList.add(new jr4(1, getString(R.string.obfuscated_res_0x7f0f106e), this.I0));
                } else {
                    z3 = booleanValue7;
                    z4 = booleanValue5;
                    z5 = booleanValue6;
                }
                if (z10) {
                    arrayList.add(new jr4(2, getString(R.string.obfuscated_res_0x7f0f106f), this.I0));
                }
                if (!z9 && !z10) {
                    jr4 jr4Var5 = new jr4(3, getString(R.string.obfuscated_res_0x7f0f043c), this.I0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e56, this.v2);
                    jr4Var5.d.setTag(sparseArray3);
                    arrayList.add(jr4Var5);
                }
                if (!booleanValue && !z7) {
                    if (z6) {
                        jr4Var4 = new jr4(4, getString(R.string.obfuscated_res_0x7f0f0f84), this.I0);
                    } else {
                        jr4Var4 = new jr4(4, getString(R.string.obfuscated_res_0x7f0f0a81), this.I0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e56, this.v2);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e6f, Boolean.FALSE);
                    jr4Var4.d.setTag(sparseArray4);
                    arrayList.add(jr4Var4);
                }
                if (this.mIsLogin && !this.q0) {
                    if (!yx7.h(this.v0) && !booleanValue4 && booleanValue3) {
                        jr4 jr4Var6 = new jr4(5, getString(R.string.obfuscated_res_0x7f0f0b18), this.I0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                        jr4Var6.d.setTag(sparseArray5);
                        arrayList.add(jr4Var6);
                    } else {
                        if ((p5(booleanValue2) && TbadkCoreApplication.isLogin()) && !z7) {
                            jr4 jr4Var7 = new jr4(5, getString(R.string.obfuscated_res_0x7f0f0fa8), this.I0);
                            jr4Var7.d.setTag(str);
                            arrayList.add(jr4Var7);
                        }
                    }
                    if (booleanValue4) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e98, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e65, sparseArray.get(R.id.obfuscated_res_0x7f091e65));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e66, str);
                        if (!yx7.h(this.v0) && z4) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                        }
                        if (z5) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(booleanValue2));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e6a, sparseArray.get(R.id.obfuscated_res_0x7f091e6a));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e6e, Boolean.valueOf(z3));
                            if (z3) {
                                jr4 jr4Var8 = new jr4(6, getString(R.string.obfuscated_res_0x7f0f0495), this.I0);
                                jr4Var8.d.setTag(sparseArray6);
                                jr4Var2 = jr4Var8;
                                jr4Var = new jr4(7, getString(R.string.obfuscated_res_0x7f0f02d4), this.I0);
                                jr4Var.d.setTag(sparseArray6);
                            }
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f091e96, Boolean.FALSE);
                        }
                        jr4Var2 = null;
                        jr4Var = new jr4(7, getString(R.string.obfuscated_res_0x7f0f02d4), this.I0);
                        jr4Var.d.setTag(sparseArray6);
                    } else if (z5) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e98, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(booleanValue2));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091e6a, sparseArray.get(R.id.obfuscated_res_0x7f091e6a));
                        if (this.v0.T0().V() == 1002 && !booleanValue2) {
                            jr4Var3 = new jr4(6, getString(R.string.obfuscated_res_0x7f0f0fa8), this.I0);
                        } else {
                            jr4Var3 = new jr4(6, getString(R.string.obfuscated_res_0x7f0f0495), this.I0);
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
                    yx7.a(arrayList, this.I0, this.v2, this.v0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    b4 = yx7.c(arrayList, this.v2.q(), sparseArray, this.I0);
                } else {
                    b4 = yx7.b(arrayList, this.v2.q(), sparseArray, this.I0);
                }
                yx7.k(b4, this.b);
                yx7.e(b4);
                this.I0.o(yx7.f(this.v2));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.I0.k(b4, false);
                } else {
                    this.I0.k(b4, true);
                }
                lr4 lr4Var = new lr4(getPageContext(), this.I0);
                this.H0 = lr4Var;
                lr4Var.m();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.v0.b).param("fid", this.v0.getForumId()).param("uid", this.v0.T0().O().getAuthor().getUserId()).param("post_id", this.v0.A()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean h5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                return pbModel.y0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean h6(boolean z3, boolean z4, boolean z5, int i3, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048677, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i3), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
            if (z3) {
                return false;
            }
            if (z6 || z7) {
                return true;
            }
            return z4 && (z5 || n5(i3));
        }
        return invokeCommon.booleanValue;
    }

    public void i4(ForumManageModel.b bVar, gw7 gw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048678, this, bVar, gw7Var) == null) {
            List<PostData> list = this.v0.T0().T().a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).R().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i3).R().get(i4).I())) {
                        list.get(i3).R().remove(i4);
                        list.get(i3).k();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).m(bVar.g);
            }
            if (z3) {
                gw7Var.z1(this.v0.T0());
            }
        }
    }

    public final boolean i5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return (absPbActivity == null || absPbActivity.getPbModel() == null || this.a.getPbModel().S0() != 17) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.j1()) {
                return this.v0.R0() == null || this.v0.R0().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.I1();
        }
        return invokeV.booleanValue;
    }

    public final void j4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048682, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        cl8 z3 = this.v0.T0().z();
        if (z3 != null && str.equals(z3.N0())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().i = null;
            }
            this.v0.T0().b();
        }
        cl8 m02 = this.v0.m0();
        if (m02 == null || !str.equals(m02.N0())) {
            return;
        }
        this.v0.Y();
    }

    public final boolean j5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            PostData c4 = cs7.c(this.v0.T0(), this.v0.j1(), this.v0.d1());
            return (c4 == null || c4.s() == null || c4.s().getGodUserData() == null || c4.s().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void j6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048684, this, metaData) == null) || metaData == null) {
            return;
        }
        cr4 cr4Var = new cr4(getActivity());
        cr4Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0a82));
        cr4Var.setTitleShowCenter(true);
        cr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0a83));
        cr4Var.setMessageShowCenter(true);
        cr4Var.setCancelable(false);
        cr4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a84), new n1(this, metaData));
        cr4Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a85), new o1(this, metaData));
        cr4Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void k4(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048685, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(gw7.e2)).intValue();
            if (intValue == gw7.f2) {
                if (this.y0.R()) {
                    return;
                }
                this.C0.X3();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e58);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e75)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e5a)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e6c) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false;
                if (jSONArray != null) {
                    this.y0.T(StringHelper.JsonArrayToString(jSONArray));
                }
                this.y0.U(this.v0.T0().l().getId(), this.v0.T0().l().getName(), this.v0.T0().O().getId(), str, intValue3, intValue2, booleanValue, this.v0.T0().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == gw7.g2 || intValue == gw7.i2) {
                if (this.v0.o0() != null) {
                    this.v0.o0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == gw7.g2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public boolean k5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                return pbModel.w0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void k6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
            cr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b17));
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ccb, new z2(this));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new a3(this));
            cr4Var.create(this.d1).show();
        }
    }

    @Override // com.repackage.k08.b
    public void l0(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048688, this, z3) == null) {
            this.L0 = z3;
        }
    }

    public void l4(cr4 cr4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048689, this, cr4Var, jSONArray) == null) {
            cr4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (cr4Var.getYesButtonTag() instanceof SparseArray) {
                    k4((SparseArray) cr4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean l5(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048690, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public final void l6(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048691, this, z3, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f091ea7) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091e52) instanceof Integer)) {
            lr4 lr4Var = this.H0;
            if (lr4Var != null && lr4Var.isShowing()) {
                this.H0.dismiss();
                this.H0 = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea5);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea7);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue()) {
                nr4 nr4Var = new nr4(getContext());
                nr4Var.n(new b0(this, sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e52) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e52)).intValue() : -1) == 1) {
                    arrayList.add(new jr4(0, getResources().getString(R.string.obfuscated_res_0x7f0f0495), nr4Var));
                }
                if (z3) {
                    arrayList.add(new jr4(1, getResources().getString(R.string.obfuscated_res_0x7f0f1467), nr4Var));
                } else {
                    arrayList.add(new jr4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0b14), nr4Var));
                }
                nr4Var.j(arrayList);
                lr4 lr4Var2 = new lr4(getPageContext(), nr4Var);
                this.H0 = lr4Var2;
                lr4Var2.m();
            }
        }
    }

    public void m4(int i3, String str, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048692, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e5a, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(z3));
            sparseArray.put(gw7.e2, Integer.valueOf(gw7.f2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                k4(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public boolean m5(int i3) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048693, this, i3)) == null) {
            if (i3 == 1) {
                return true;
            }
            if (this.v0.T0().U() != null && (forumToolAuth = this.v0.T0().U().getForumToolAuth()) != null) {
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

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            showLoadingView(this.C0.g1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702be));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.C0.f1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public void n4(int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048695, this, i3, i4) == null) {
            TiebaStatic.log("c12181");
            gw7 gw7Var = this.C0;
            if (gw7Var == null || this.v0 == null) {
                return;
            }
            if ((gw7Var != null && !gw7Var.B1()) || this.v0.T0() == null || this.v0.T0().S() == null) {
                return;
            }
            gw7 gw7Var2 = this.C0;
            if (gw7Var2 == null || gw7Var2.A0() == null || !this.C0.A0().o()) {
                ps7 S = this.v0.T0().S();
                if (checkUpIsLogin()) {
                    if ((!S.f() || S.a() != 2) && this.C0.u0() != null && this.C0.u0().z() != null) {
                        this.C0.u0().z().c0(this.v0.l1(), this.v0.getFromForumId());
                    }
                    if (UbsABTestHelper.isLikeModifyTestA() && i3 > -1 && i4 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        fr7 fr7Var = new fr7(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.v0;
                        fr7Var.k(findViewById, i3, i4, pbModel.b, pbModel.getForumId());
                    } else if (System.currentTimeMillis() - this.x > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.x = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public boolean n5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048696, this, i3)) == null) ? i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 : invokeI.booleanValue;
    }

    public final void n6(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && w() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                w().b0(postWriteCallBackData.getPostId());
                int y02 = this.C0.y0();
                this.m1 = y02;
                this.v0.p2(y02, this.C0.F0());
            }
            this.C0.i0();
            this.G0.c();
            m25 m25Var = this.R0;
            if (m25Var != null) {
                this.C0.L2(m25Var.C());
            }
            this.C0.k1();
            this.C0.w3(true);
            this.v0.u1();
        }
    }

    public void o4() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048698, this) == null) || this.C0 == null || (pbModel = this.v0) == null) {
            return;
        }
        if ((pbModel.T0() == null && this.v0.T0().S() == null) || !checkUpIsLogin() || this.C0.u0() == null || this.C0.u0().z() == null) {
            return;
        }
        this.C0.u0().z().c0(this.v0.l1(), this.v0.getFromForumId());
    }

    public final boolean o5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048699, this, i3)) == null) ? i3 == 2 || i3 == 1 : invokeI.booleanValue;
    }

    public final void o6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048700, this, i3) == null) {
            zx7.o(this, u4(), i3);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906d2));
            this.h2.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d(), "", 1);
            this.a.getTiePlusEventController().l(this.r0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        EmotionImageData emotionImageData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048702, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.R0.H(i3, i4, intent);
            hx7 hx7Var = this.Q;
            if (hx7Var != null) {
                hx7Var.i(i3, i4, intent);
            }
            if (P4().V0() != null) {
                P4().V0().g(i3, i4, intent);
            }
            if (i3 == 25035) {
                W4(i4, intent);
            }
            if (i4 == -1) {
                if (i3 == 11009) {
                    y5();
                } else if (i3 == 13008) {
                    yv7.b().m();
                    this.u0.postDelayed(new z1(this), 1000L);
                } else if (i3 == 13011) {
                    m98.g().m(getPageContext());
                } else if (i3 == 23003) {
                    if (intent == null || this.v0 == null) {
                        return;
                    }
                    d6(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i3 == 23007) {
                    Z4(intent);
                } else if (i3 == 25012) {
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                } else if (i3 == 25016 || i3 == 25023) {
                    Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                    if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                        return;
                    }
                    this.X0 = emotionImageData;
                    if (e4(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        R5(emotionImageData);
                    }
                } else if (i3 == 25033) {
                    View view2 = this.S;
                    if (view2 != null) {
                        this.C0.B3(view2);
                    }
                } else if (i3 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        m98.g().m(getPageContext());
                        A6();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.B0;
                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.t) != null) {
                            shareSuccessReplyToServerModel.y(str, intExtra, new a2(this));
                        }
                        if (i5()) {
                            y6(true);
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
                            gw7 gw7Var = this.C0;
                            if (gw7Var == null || gw7Var.v0() == null) {
                                return;
                            }
                            this.C0.v0().performClick();
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
                    this.C0.k3(false);
                    if (this.v0.T0() == null || this.v0.T0().O() == null || this.v0.T0().O().getPushStatusData() == null) {
                        return;
                    }
                    this.v0.T0().O().getPushStatusData().setStatus(2);
                }
            }
        }
    }

    @Override // com.repackage.if5
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048703, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.w = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048705, this, i3) == null) || this.X == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.C0.W1(i3);
        m25 m25Var = this.R0;
        if (m25Var != null && m25Var.a() != null) {
            this.R0.a().w(i3);
        }
        if (this.C0.a() != null) {
            this.C0.a().c(getPageContext(), i3);
        }
        this.G0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.X = i3;
        u6();
    }

    @Override // com.repackage.cr4.e
    public void onClick(cr4 cr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, cr4Var) == null) {
            l4(cr4Var, null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, configuration) == null) {
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
            gw7 gw7Var = this.C0;
            if (gw7Var != null) {
                gw7Var.X1(configuration);
            }
            lr4 lr4Var = this.H0;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        gw7 gw7Var;
        gw7 gw7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            this.p = System.currentTimeMillis();
            this.d1 = getPageContext();
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
                this.G2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.H2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.I2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.M0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.N0 = intent.getStringExtra("high_light_post_id");
                this.O0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (D4()) {
                    this.a.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.P = stringExtra;
                this.P = ni.isEmpty(stringExtra) ? "" : this.P;
                this.n1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                aq4 aq4Var = new aq4();
                this.j0 = aq4Var;
                aq4Var.a(intent);
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.p1 = intExtra;
                if (intExtra == 0) {
                    this.p1 = intent.getIntExtra("key_start_from", 0);
                }
                this.q1 = intent.getStringExtra("last_tid");
            } else {
                this.n = System.currentTimeMillis();
            }
            this.r = this.p - this.n;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.l = 0;
            t5(bundle);
            if (this.v0.T0() != null) {
                this.v0.T0().N0(this.P);
            }
            f5();
            if (intent != null && (gw7Var2 = this.C0) != null) {
                gw7Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.g1 == null) {
                        this.g1 = new f0(this, intent);
                    }
                    pg.a().postDelayed(this.g1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.v0.T0() != null) {
                    this.v0.y2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.k = voiceManager;
            voiceManager.onCreate(getPageContext());
            e5(bundle);
            o25 o25Var = new o25();
            this.Q0 = o25Var;
            X5(o25Var);
            m25 m25Var = (m25) this.Q0.a(getActivity());
            this.R0 = m25Var;
            m25Var.e0(this.a.getPageContext());
            this.R0.n0(this.e2);
            this.R0.o0(this.Y0);
            this.R0.g0(1);
            this.R0.F(this.a.getPageContext(), bundle);
            this.R0.a().b(new s05(getActivity()));
            this.R0.a().C(true);
            a6(true);
            this.R0.O(this.v0.v0(), this.v0.l1(), this.v0.r0());
            registerListener(this.x1);
            if (!this.v0.G0()) {
                this.R0.s(this.v0.l1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.R0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.v0.z1()) {
                this.R0.k0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dc0));
            } else {
                gw7 gw7Var3 = this.C0;
                if (gw7Var3 != null) {
                    this.R0.k0(gw7Var3.Y0());
                }
            }
            registerListener(this.w1);
            registerListener(this.y1);
            registerListener(this.z1);
            registerListener(this.v1);
            registerListener(this.W1);
            registerListener(this.X1);
            registerListener(this.j2);
            registerListener(this.u1);
            tk8 tk8Var = new tk8("pb", tk8.d);
            this.P0 = tk8Var;
            tk8Var.d();
            registerListener(this.F1);
            registerListener(this.O1);
            this.v0.V1();
            registerListener(this.i2);
            registerListener(this.Y1);
            registerListener(this.d2);
            registerListener(this.J1);
            gw7 gw7Var4 = this.C0;
            if (gw7Var4 != null && gw7Var4.f1() != null && this.C0.d1() != null) {
                lx7 lx7Var = new lx7(getActivity(), this.C0.f1(), this.C0.d1(), this.C0.T0());
                this.e = lx7Var;
                lx7Var.t(this.N1);
            }
            if (this.c && (gw7Var = this.C0) != null && gw7Var.d1() != null) {
                this.C0.d1().setVisibility(8);
            }
            zt4 zt4Var = new zt4();
            this.e1 = zt4Var;
            zt4Var.a = 1000L;
            registerListener(this.V1);
            registerListener(this.U1);
            registerListener(this.S1);
            registerListener(this.T1);
            registerListener(this.H1);
            registerListener(this.B1);
            registerListener(this.C1);
            registerListener(this.D1);
            this.G1.setSelfListener(true);
            this.G1.setTag(this.a.getUniqueId());
            this.G1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.G1);
            registerResponsedEventListener(TipEvent.class, this.P1);
            this.f1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.f1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.f1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.v0.n0().C(this.Q1);
            this.G0 = new iw7();
            if (this.R0.v() != null) {
                this.G0.m(this.R0.v().h());
            }
            this.R0.d0(this.Z0);
            this.B0 = new ShareSuccessReplyToServerModel();
            U3(this.s1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.U0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new g0(this));
            ey7 ey7Var = new ey7(getContext());
            this.w0 = ey7Var;
            ey7Var.b(getUniqueId());
            dj8.g().i(getUniqueId());
            mn4.b().l("3", "");
            this.r1 = new rw5(getPageContext());
            this.s0 = new wx7(this, getUniqueId(), this.C0, this.v0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && mi.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.q = System.currentTimeMillis() - this.p;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048709, this, layoutInflater, viewGroup, bundle)) == null) {
            this.C0 = new gw7(this, this.c2, this.R1);
            m36 m36Var = new m36(getActivity());
            this.d = m36Var;
            m36Var.i(L2);
            this.d.d(this.E2);
            this.C0.b3(this.l2);
            this.C0.a3(this.r2);
            this.C0.T2(this.o2);
            this.C0.U2(this.p2);
            this.C0.R2(bn4.c().g());
            this.C0.Y2(this.t2);
            this.C0.e3(this.z2);
            this.C0.c3(this.A2);
            this.C0.Z2(this.C2);
            this.C0.X2(this.n2);
            this.C0.b4(this.mIsLogin);
            this.C0.O2(this.v0.x1());
            if (this.a.getIntent() != null) {
                this.C0.P2(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.C0.U0().setFromForumId(this.v0.getFromForumId());
            this.C0.G2(this.R0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.R0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.R0.k0(this.C0.Y0());
            }
            this.C0.K2(new j0(this));
            this.C0.N2(this.v0.B0());
            this.C0.d3(this.v0.S0());
            this.s0.f(this.C0, this.v0);
            return this.C0.g1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        dy7 dy7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            dj8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!ni.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.v0.T0().m());
                statisticItem.param("tid", this.v0.l1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.t && this.C0 != null) {
                this.t = true;
                T5(false, null);
            }
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.v0.destory();
                if (this.v0.P0() != null) {
                    this.v0.P0().d();
                }
            }
            m25 m25Var = this.R0;
            if (m25Var != null) {
                m25Var.I();
            }
            ForumManageModel forumManageModel = this.y0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.R;
            if (likeModel != null) {
                likeModel.L();
            }
            gw7 gw7Var = this.C0;
            if (gw7Var != null) {
                gw7Var.Y1();
                dy7 dy7Var2 = this.C0.h;
                if (dy7Var2 != null) {
                    dy7Var2.x();
                }
            }
            j85 j85Var = this.u;
            if (j85Var != null) {
                j85Var.c();
            }
            lx7 lx7Var = this.e;
            if (lx7Var != null) {
                lx7Var.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            gw7 gw7Var2 = this.C0;
            if (gw7Var2 != null) {
                gw7Var2.i0();
            }
            MessageManager.getInstance().unRegisterListener(this.S1);
            MessageManager.getInstance().unRegisterListener(this.T1);
            MessageManager.getInstance().unRegisterListener(this.V1);
            MessageManager.getInstance().unRegisterListener(this.f1);
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.X1);
            MessageManager.getInstance().unRegisterListener(this.Y1);
            MessageManager.getInstance().unRegisterListener(this.H1);
            MessageManager.getInstance().unRegisterListener(this.g2);
            MessageManager.getInstance().unRegisterListener(this.G1);
            MessageManager.getInstance().unRegisterListener(this.J1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            this.d1 = null;
            this.e1 = null;
            tc8.e().g();
            if (this.g1 != null) {
                pg.a().removeCallbacks(this.g1);
            }
            hx7 hx7Var = this.Q;
            if (hx7Var != null) {
                hx7Var.f();
            }
            gw7 gw7Var3 = this.C0;
            if (gw7Var3 != null && (dy7Var = gw7Var3.h) != null) {
                dy7Var.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.B0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            iw7 iw7Var = this.G0;
            if (iw7Var != null) {
                iw7Var.j();
            }
            PbModel pbModel2 = this.v0;
            if (pbModel2 != null && pbModel2.g0() != null) {
                this.v0.g0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.U0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            gw7 gw7Var4 = this.C0;
            if (gw7Var4 != null) {
                gw7Var4.Y3();
            }
            wx7 wx7Var = this.s0;
            if (wx7Var != null) {
                wx7Var.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048711, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.k0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public xo onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (xo) invokeV.objValue;
    }

    @Override // com.repackage.if5
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048713, this, context, str) == null) {
            this.w = true;
        }
    }

    @Override // com.repackage.if5
    public void onLinkClicked(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048714, this, context, str, z3) == null) {
            if (lw7.c(str) && (pbModel = this.v0) != null && pbModel.l1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.v0.l1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    wz4 wz4Var = new wz4();
                    wz4Var.a = str;
                    wz4Var.b = 3;
                    wz4Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, wz4Var));
                }
            } else {
                lw7.a().e(getPageContext(), str);
            }
            this.w = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            O5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
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
            gw7 gw7Var = this.C0;
            if (gw7Var != null) {
                gw7Var.d2();
            }
            if (!this.v0.G0()) {
                this.R0.U(this.v0.l1());
            }
            PbModel pbModel = this.v0;
            if (pbModel != null) {
                pbModel.U1();
            }
            oi4.y().G();
            MessageManager.getInstance().unRegisterListener(this.A1);
            S5();
            MessageManager.getInstance().unRegisterListener(this.S1);
            MessageManager.getInstance().unRegisterListener(this.T1);
            MessageManager.getInstance().unRegisterListener(this.V1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.v(null);
        }
    }

    @Override // com.repackage.if5
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048717, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.J0 = str;
        if (this.m == null) {
            g5();
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

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.e9
    public void onPreLoad(xo xoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, xoVar) == null) {
            PreLoadImageHelper.load(xoVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(xoVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            this.g = false;
            super.onResume();
            if (this.O) {
                this.O = false;
                V4();
            }
            if (j5()) {
                this.v = System.currentTimeMillis();
            } else {
                this.v = -1L;
            }
            gw7 gw7Var = this.C0;
            if (gw7Var != null && gw7Var.g1() != null) {
                if (!this.h) {
                    m6();
                } else {
                    hideLoadingView(this.C0.g1());
                }
                this.C0.e2();
            }
            if (this.l == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            gw7 gw7Var2 = this.C0;
            NoNetworkView a4 = gw7Var2 != null ? gw7Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && mi.z()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.A1);
            this.L0 = false;
            U5();
            registerListener(this.S1);
            registerListener(this.T1);
            registerListener(this.V1);
            if (this.l1) {
                O5();
                this.l1 = false;
            }
            r6();
            ItemCardHelper.v(this.B2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                b05.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.v0.m2(bundle);
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.R0.K(bundle);
        }
    }

    @Override // com.repackage.if5
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048721, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            super.onStop();
            if (this.v > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.v;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.v = 0L;
            }
            if (P4().V0() != null) {
                P4().V0().i();
            }
            dy7 dy7Var = this.C0.h;
            if (dy7Var != null && !dy7Var.t()) {
                this.C0.h.x();
            }
            PbModel pbModel = this.v0;
            if (pbModel != null && pbModel.T0() != null && this.v0.T0().l() != null && this.v0.T0().O() != null) {
                yz4.k().y(getPageContext().getPageActivity(), "pb", this.v0.T0().l().getId(), mg.g(this.v0.T0().O().getId(), 0L));
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            dj8.g().h(getUniqueId(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048724, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z3) == null) {
            super.onUserChanged(z3);
            this.C0.b4(z3);
            lr4 lr4Var = this.H0;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
            if (z3 && this.L0) {
                this.C0.j3();
                this.v0.M1(true);
            }
            if (this.C0.u0() != null) {
                this.C0.u0().c0(z3);
            }
        }
    }

    @Override // com.repackage.if5
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048726, this, context, str) == null) {
            lw7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.w = true;
        }
    }

    @Override // com.repackage.if5
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048727, this, context, str) == null) {
        }
    }

    public final void p4(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048728, this, str) == null) || (pbModel = this.v0) == null || pbModel.T0() == null || this.v0.T0().O() == null || !this.v0.T0().O().isUgcThreadType()) {
            return;
        }
        ThreadData O = this.v0.T0().O();
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

    public final boolean p5(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048729, this, z3)) == null) {
            PbModel pbModel = this.v0;
            return (pbModel == null || pbModel.T0() == null || this.v0.T0().O() == null || this.v0.T0().O().getAuthor() == null || TextUtils.equals(this.v0.T0().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final void p6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, str) == null) {
            if (str == null) {
                str = "";
            }
            b9 b9Var = this.d1;
            if (b9Var == null) {
                return;
            }
            cr4 cr4Var = new cr4(b9Var.getPageActivity());
            cr4Var.setMessage(str);
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new a(this));
            cr4Var.create(this.d1).show();
        }
    }

    public final void q4(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048731, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f049a);
            int i3 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                cr4 cr4Var = new cr4(getPageContext().getPageActivity());
                cr4Var.setMessage(string);
                cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04db, new t1(this));
                cr4Var.setCancelable(true);
                cr4Var.create(getPageContext());
                cr4Var.show();
            } else if (bVar.d != 0) {
                this.C0.q0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.d;
                if (i4 == 1) {
                    ArrayList<PostData> F = this.v0.T0().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i3).I())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.v0.T0().O().setReply_num(this.v0.T0().O().getReply_num() - 1);
                    this.C0.z1(this.v0.T0());
                } else if (i4 == 0) {
                    g4();
                } else if (i4 == 2) {
                    ArrayList<PostData> F2 = this.v0.T0().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).R().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i5).R().get(i6).I())) {
                                F2.get(i5).R().remove(i6);
                                F2.get(i5).k();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).m(bVar.g);
                    }
                    if (z4) {
                        this.C0.z1(this.v0.T0());
                    }
                    i4(bVar, this.C0);
                }
            }
        }
    }

    public final void q5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void q6(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048733, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.C0.E3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            cr4 cr4Var = new cr4(this.d1.getPageActivity());
            if (ni.isEmpty(str)) {
                cr4Var.setMessage(this.d1.getResources().getString(R.string.obfuscated_res_0x7f0f0310, str3));
            } else {
                cr4Var.setMessage(str);
            }
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0421, new b(this, userMuteAddAndDelCustomMessage));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new c(this));
            cr4Var.create(this.d1).show();
        }
    }

    public final void r4(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048734, this, i3, gVar) == null) || gVar == null) {
            return;
        }
        this.C0.q0(this.y0.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.D0 = true;
            if (i3 == 2 || i3 == 3) {
                this.E0 = true;
                this.F0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.E0 = false;
                this.F0 = true;
            }
            if (i3 == 2) {
                this.v0.T0().O().setIs_good(1);
                this.v0.t2(1);
            } else if (i3 == 3) {
                this.v0.T0().O().setIs_good(0);
                this.v0.t2(0);
            } else if (i3 == 4) {
                this.v0.T0().O().setIs_top(1);
                this.v0.u2(1);
            } else if (i3 == 5) {
                this.v0.T0().O().setIs_top(0);
                this.v0.u2(0);
            }
            this.C0.e4(this.v0.T0(), this.v0.j1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f0cdb);
        }
        oi.N(getPageContext().getPageActivity(), string);
    }

    public final void r5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048735, this) == null) || this.J2 == null) {
            return;
        }
        if (this.H2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0dae);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.J2.a(), this.H2, 0)));
            this.a.finish();
        }
    }

    public final void r6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (pbModel = this.v0) == null || ni.isEmpty(pbModel.l1())) {
            return;
        }
        oi4.y().R(ni4.X, mg.g(this.v0.l1(), 0L));
    }

    public final void s4(Rect rect) {
        gw7 gw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048737, this, rect) == null) || rect == null || (gw7Var = this.C0) == null || gw7Var.f1() == null || rect.top > this.C0.f1().getHeight()) {
            return;
        }
        rect.top += this.C0.f1().getHeight() - rect.top;
    }

    public void s5(String str) {
        gw7 gw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048738, this, str) == null) || this.v0 == null || StringUtils.isNull(str) || (gw7Var = this.C0) == null) {
            return;
        }
        gw7Var.Q2(true);
        this.v0.O1(str);
        this.I = true;
        this.C0.i0();
        this.C0.i1();
    }

    public final void s6(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048739, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f091e56) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e56)) != null) {
            t6(postData, false);
        }
    }

    public AntiData t4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.T0() == null) {
                return null;
            }
            return this.v0.T0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void t5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, bundle) == null) {
            PbModel pbModel = this.a.getPbModel();
            this.v0 = pbModel;
            if (pbModel.o0() != null) {
                this.v0.o0().c(this.F2);
            }
            if (this.v0.P0() != null) {
                this.v0.P0().f(this.t1);
            }
            if (StringUtils.isNull(this.v0.l1())) {
                this.a.finish();
            } else if (!"from_tieba_kuang".equals(this.M) || this.M == null) {
            } else {
                this.v0.x2(6);
            }
        }
    }

    public final void t6(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048743, this, postData, z3) == null) || postData == null || (pbModel = this.v0) == null || pbModel.T0() == null || postData.A() == 1) {
            return;
        }
        String l12 = this.v0.l1();
        String I = postData.I();
        int V = this.v0.T0() != null ? this.v0.T0().V() : 0;
        AbsPbActivity.e J5 = J5(I);
        if (J5 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(l12, I, "pb", true, false, null, false, null, V, postData.U(), this.v0.T0().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(J5.a, J5.b, J5.g, J5.j);
        addBigImageData.setKeyPageStartFrom(this.v0.S0());
        addBigImageData.setFromFrsForumId(this.v0.getFromForumId());
        addBigImageData.setWorksInfoData(this.v0.q1());
        addBigImageData.setKeyFromForumId(this.v0.getForumId());
        addBigImageData.setBjhData(this.v0.l0());
        addBigImageData.setIsOpenEditor(z3);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || (pbModel = this.v0) == null || ni.isEmpty(pbModel.l1())) {
            return;
        }
        super.taskStart();
    }

    public final int u4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            if (this.v0.T0() == null || this.v0.T0().O() == null) {
                return -1;
            }
            return this.v0.T0().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void u5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048747, this) == null) || this.J2 == null) {
            return;
        }
        if (this.G2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0daf);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.J2.a(), this.G2, 0)));
            this.a.finish();
        }
    }

    public final void u6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity != null) {
                absPbActivity.stopVoice();
            }
        }
    }

    public PostData v4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            gw7 gw7Var = this.C0;
            PbModel pbModel = this.v0;
            return gw7Var.C0(pbModel.G, pbModel.j1());
        }
        return (PostData) invokeV.objValue;
    }

    public final void v5(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048750, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || a4() || !d4()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.Z);
            this.g0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (P4().V0() != null && postData != null) {
            P4().V0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f9e), postData.s().getName_show(), postData.P() != null ? postData.P().toString() : ""));
        }
        if (this.v0.T0() != null && this.v0.T0().g0()) {
            pg.a().postDelayed(new b1(this, str, str2), 0L);
            return;
        }
        if (this.W0 == null) {
            qn6 qn6Var = new qn6(getPageContext());
            this.W0 = qn6Var;
            qn6Var.j(1);
            this.W0.i(new c1(this, str, str2));
        }
        PbModel pbModel = this.v0;
        if (pbModel == null || pbModel.T0() == null || this.v0.T0().l() == null) {
            return;
        }
        this.W0.g(this.v0.T0().l().getId(), mg.g(this.v0.l1(), 0L));
    }

    public final void v6() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    @Override // com.repackage.jz7
    public PbModel w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) ? this.v0 : (PbModel) invokeV.objValue;
    }

    public String w4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) ? this.M : (String) invokeV.objValue;
    }

    public final void w5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048754, this) == null) {
            bs7 T0 = this.v0.T0();
            this.v0.G2(true);
            ml4 ml4Var = this.x0;
            if (ml4Var != null) {
                T0.E0(ml4Var.g());
            }
            this.C0.z1(T0);
        }
    }

    public final boolean w6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.T0() == null || !this.v0.T0().g0()) {
                if (this.v0.E0()) {
                    MarkData p02 = this.v0.p0();
                    if (p02 != null && this.v0.C0()) {
                        MarkData j02 = this.v0.j0(this.C0.B0());
                        if (j02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", p02);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (j02.getPostId() != null && !j02.getPostId().equals(p02.getPostId())) {
                            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
                            cr4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f025c));
                            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0421, new b2(this, j02, p02, cr4Var));
                            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new c2(this, p02, cr4Var));
                            cr4Var.setOnCalcelListener(new d2(this, p02, cr4Var));
                            cr4Var.create(getPageContext());
                            cr4Var.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", p02);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.v0.T0() != null && this.v0.T0().F() != null && this.v0.T0().F().size() > 0 && this.v0.C0()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.jz7
    public AbsPbActivity x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    @Override // com.repackage.jz7
    public PbFragment x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    public final String x4() {
        InterceptResult invokeV;
        bs7 T0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || (T0 = pbModel.T0()) == null) {
                return null;
            }
            return T0.T().c;
        }
        return (String) invokeV.objValue;
    }

    public void x5() {
        gw7 gw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048759, this) == null) || (gw7Var = this.C0) == null) {
            return;
        }
        gw7Var.T1();
    }

    public final void x6() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048760, this) == null) || (absPbActivity = this.a) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.getPbModel().l1()).param("topic_id", this.a.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.getPbModel().p1()));
    }

    public final String y4() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            PbModel pbModel = this.v0;
            if (pbModel == null || pbModel.T0() == null || this.v0.T0().F() == null || (count = ListUtils.getCount((F = this.v0.T0().F()))) == 0) {
                return "";
            }
            if (this.v0.e1()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.I();
                    }
                }
            }
            int B0 = this.C0.B0();
            PostData postData = (PostData) ListUtils.getItem(F, B0);
            if (postData != null && postData.s() != null) {
                if (this.v0.J1(postData.s().getUserId())) {
                    return postData.I();
                }
                for (int i3 = B0 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (this.v0.J1(postData2.s().getUserId())) {
                        return postData2.I();
                    }
                }
                for (int i4 = B0 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (this.v0.J1(postData3.s().getUserId())) {
                        return postData3.I();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void y5() {
        MarkData j02;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048762, this) == null) || this.x0 == null) {
            return;
        }
        if (this.v0.T0() != null && this.v0.T0().g0()) {
            j02 = this.v0.j0(0);
        } else {
            j02 = this.v0.j0(this.C0.K0());
        }
        if (j02 == null) {
            return;
        }
        if (j02.isApp() && (j02 = this.v0.j0(this.C0.K0() + 1)) == null) {
            return;
        }
        this.C0.i3();
        this.x0.i(j02);
        if (!this.x0.e()) {
            if (this.C0 != null && this.v0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !zx7.k(this.v0.b)) {
                this.C0.R3();
                zx7.b(this.v0.b);
            }
            this.x0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.x0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final void y6(boolean z3) {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048763, this, z3) == null) || (absPbActivity = this.a) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(!z3 ? "c14397" : "c14398").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.getPbModel().l1()).param("topic_id", this.a.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.getPbModel().p1()));
    }

    public final TbRichText z4(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048764, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText P = arrayList.get(i4).P();
                    if (P != null && (A = P.A()) != null) {
                        int size = A.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (A.get(i6) != null && A.get(i6).getType() == 8) {
                                i5++;
                                if (A.get(i6).E().A().equals(str) || A.get(i6).E().B().equals(str)) {
                                    int h3 = (int) oi.h(TbadkCoreApplication.getInst());
                                    int width = A.get(i6).E().getWidth() * h3;
                                    int height = A.get(i6).E().getHeight() * h3;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.s2 = i6;
                                    return P;
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

    public final void z5(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048765, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e56)) == null) {
                return;
            }
            A5(postData);
        }
    }

    public final void z6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048766, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.v0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(yx7.m(i3))));
        }
    }
}
