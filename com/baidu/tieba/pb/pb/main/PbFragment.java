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
import com.repackage.a25;
import com.repackage.ab;
import com.repackage.ap4;
import com.repackage.av4;
import com.repackage.az4;
import com.repackage.bl8;
import com.repackage.bm4;
import com.repackage.bs4;
import com.repackage.c9;
import com.repackage.cb8;
import com.repackage.cf5;
import com.repackage.cj4;
import com.repackage.co4;
import com.repackage.cx7;
import com.repackage.d9;
import com.repackage.dj4;
import com.repackage.dj8;
import com.repackage.ds4;
import com.repackage.dw7;
import com.repackage.dz7;
import com.repackage.e05;
import com.repackage.er4;
import com.repackage.fg;
import com.repackage.fs4;
import com.repackage.ft7;
import com.repackage.fz7;
import com.repackage.g05;
import com.repackage.ge5;
import com.repackage.gf5;
import com.repackage.gg;
import com.repackage.gg6;
import com.repackage.gi5;
import com.repackage.gq4;
import com.repackage.gt7;
import com.repackage.gu7;
import com.repackage.gz7;
import com.repackage.h05;
import com.repackage.h25;
import com.repackage.h45;
import com.repackage.hl8;
import com.repackage.ho5;
import com.repackage.hu7;
import com.repackage.hw7;
import com.repackage.hz7;
import com.repackage.i05;
import com.repackage.i08;
import com.repackage.i45;
import com.repackage.ia5;
import com.repackage.id8;
import com.repackage.iq4;
import com.repackage.is7;
import com.repackage.iv4;
import com.repackage.iy7;
import com.repackage.iz7;
import com.repackage.j05;
import com.repackage.j45;
import com.repackage.j55;
import com.repackage.j87;
import com.repackage.je5;
import com.repackage.ji5;
import com.repackage.jm4;
import com.repackage.jv4;
import com.repackage.k45;
import com.repackage.ka5;
import com.repackage.kp4;
import com.repackage.ks7;
import com.repackage.ku7;
import com.repackage.l05;
import com.repackage.lo4;
import com.repackage.lr4;
import com.repackage.ls7;
import com.repackage.m45;
import com.repackage.m87;
import com.repackage.my7;
import com.repackage.n56;
import com.repackage.nu4;
import com.repackage.nw4;
import com.repackage.nx4;
import com.repackage.nx7;
import com.repackage.ny7;
import com.repackage.nz7;
import com.repackage.o25;
import com.repackage.o45;
import com.repackage.o56;
import com.repackage.o95;
import com.repackage.oa5;
import com.repackage.og;
import com.repackage.oi;
import com.repackage.on;
import com.repackage.oz7;
import com.repackage.p75;
import com.repackage.pi;
import com.repackage.pp4;
import com.repackage.pz4;
import com.repackage.qi;
import com.repackage.qo6;
import com.repackage.qv7;
import com.repackage.qx7;
import com.repackage.r25;
import com.repackage.rg;
import com.repackage.rn4;
import com.repackage.rq4;
import com.repackage.ru4;
import com.repackage.ry7;
import com.repackage.s15;
import com.repackage.s25;
import com.repackage.sk8;
import com.repackage.sn;
import com.repackage.sx7;
import com.repackage.sy7;
import com.repackage.t08;
import com.repackage.t25;
import com.repackage.t95;
import com.repackage.tk8;
import com.repackage.tt7;
import com.repackage.tx7;
import com.repackage.u18;
import com.repackage.u97;
import com.repackage.ur4;
import com.repackage.ur8;
import com.repackage.uw7;
import com.repackage.vt7;
import com.repackage.vv7;
import com.repackage.wr4;
import com.repackage.wu4;
import com.repackage.ww7;
import com.repackage.x15;
import com.repackage.xr8;
import com.repackage.xt6;
import com.repackage.xt7;
import com.repackage.yf5;
import com.repackage.z05;
import com.repackage.zm;
import com.repackage.zy5;
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
public class PbFragment extends BaseFragment implements ji5, VoiceManager.j, UserIconBox.c, View.OnTouchListener, ur4.e, TbRichTextView.s, TbPageContextSupport, t08, u18.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k T2;
    public static final o56.b U2;
    public transient /* synthetic */ FieldHolder $fh;
    public fg<TextView> A;
    public bm4 A0;
    public CustomMessageListener A1;
    public final BdListView.p A2;
    public fg<TbImageView> B;
    public ForumManageModel B0;
    public CustomMessageListener B1;
    public int B2;
    public fg<ImageView> C;
    public pz4 C0;
    public CustomMessageListener C1;
    public final TbRichTextView.y C2;
    public fg<View> D;
    public xt7 D0;
    public CustomMessageListener D1;
    public boolean D2;
    public fg<TiebaPlusRecommendCard> E;
    public PollingModel E0;
    public CustomMessageListener E1;
    public PostData E2;
    public fg<LinearLayout> F;
    public ShareSuccessReplyToServerModel F0;
    public CustomMessageListener F1;
    public final wr4.c F2;
    public fg<RelativeLayout> G;
    public nx7 G0;
    public final CustomMessageListener G1;
    public final wr4.c G2;
    public fg<ItemCardView> H;
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
    public qx7 K0;
    public CustomMessageListener K1;
    public final ItemCardHelper.c K2;
    public fg<GifView> L;
    public ds4 L0;
    public CustomMessageListener L1;
    public final NoNetworkView.b L2;
    public String M;
    public fs4 M0;
    public CustomMessageListener M1;
    public View.OnTouchListener M2;
    public boolean N;
    public String N0;
    public SuggestEmotionModel.c N1;
    public n56.b N2;
    public boolean O;
    public boolean O0;
    public CustomMessageListener O1;
    public final dw7.b O2;
    public String P;
    public boolean P0;
    public CustomMessageListener P1;
    public int P2;
    public ny7 Q;
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
    public ap4 S2;
    public View T;
    public tk8 T0;
    public sy7.h T1;
    public View U;
    public m45 U0;
    public CustomMessageListener U1;
    public View V;
    public k45 V0;
    public p75 V1;
    public String W;
    public boolean W0;
    public CheckRealNameModel.b W1;
    public int X;
    public PermissionJudgePolicy X0;
    public hu7 X1;
    public boolean Y;
    public ReplyPrivacyCheckController Y0;
    public final Runnable Y1;
    public int[] Z;
    public qo6 Z0;
    public CustomMessageListener Z1;
    public AbsPbActivity a;
    public int a0;
    public qo6 a1;
    public CustomMessageListener a2;
    public boolean b;
    public int b0;
    public EmotionImageData b1;
    public CustomMessageListener b2;
    public boolean c;
    public int c0;
    public i45 c1;
    public CustomMessageListener c2;
    public o56 d;
    public rq4 d0;
    public h45 d1;
    public CustomMessageListener d2;
    public sy7 e;
    public BdUniqueId e0;
    public h45 e1;
    public CustomMessageListener e2;
    public boolean f;
    public nu4 f0;
    public int f1;
    public CustomMessageListener f2;
    public boolean g;
    public boolean g0;
    public Object g1;
    public CustomMessageListener g2;
    public boolean h;
    public boolean h0;
    public d9 h1;
    public ur4.e h2;
    public boolean i;
    public Object i0;
    public wu4 i1;
    public fs4.e i2;
    public boolean j;
    public sk8 j0;
    public BdUniqueId j1;
    public SortSwitchButton.f j2;
    public VoiceManager k;
    public Runnable k1;
    public final View.OnClickListener k2;
    public int l;
    public sx7 l1;
    public CustomMessageListener l2;
    public wr4 m;
    public zm m1;
    public final NewWriteModel.e m2;
    public long n;
    public String n1;
    public Boolean n2;
    public long o;
    public TbRichTextImageInfo o1;
    public NewWriteModel.e o2;
    public long p;
    public TbRichTextMemeInfo p1;
    public ab p2;
    public long q;
    public boolean q0;
    public boolean q1;
    public final PbModel.h q2;
    public long r;
    public i05 r0;
    public int r1;
    public CustomMessageListener r2;
    public boolean s;
    public boolean s0;
    public int s1;
    public HttpMessageListener s2;
    public boolean t;
    public boolean t0;
    public List<g3> t1;
    public final bm4.a t2;
    public ia5 u;
    @NonNull
    public TiePlusEventController.f u0;
    public int u1;
    public final AbsListView.OnScrollListener u2;
    public long v;
    public dz7 v0;
    public String v1;
    public final c9 v2;
    public boolean w;
    public PbInterviewStatusView.f w0;
    public zy5 w1;
    public final i3 w2;
    public long x;
    public final Handler x0;
    public final g3 x1;
    public final av4.g x2;
    public int y;
    public PbModel y0;
    public final uw7.b y1;
    public final View.OnClickListener y2;
    public String z;
    public oz7 z0;
    public final CustomMessageListener z1;
    public boolean z2;

    /* loaded from: classes3.dex */
    public static class a implements o56.b {
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

        @Override // com.repackage.o56.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    gu7.d();
                } else {
                    gu7.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void a(my7 my7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, my7Var) == null) || my7Var == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001444, my7Var.c()));
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
            this.a.S5().o2();
        }
    }

    /* loaded from: classes3.dex */
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
        public void onNavigationButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements dw7.b {
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

        @Override // com.repackage.dw7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i == 0) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f14ca);
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c3c);
                    }
                } else if (i != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.G0.k0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (this.a.y0.J2(false)) {
                this.a.G0.v3();
            } else if (this.a.y0.Q1() != null) {
                this.a.G0.L2();
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.a.B0.getLoadDataMode()) {
                        case 0:
                            this.a.y0.r2();
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
                            this.a.G0.t2(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                this.a.G0.w0(this.a.B0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (!this.a.g && z && !this.a.y0.F1()) {
                    this.a.U6();
                }
                PbFragment pbFragment = this.a;
                pbFragment.setNetRefreshViewEmotionMarginTop(qi.f(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    ur4Var.dismiss();
                    ((TbPageContext) this.a.h1).showToast(R.string.obfuscated_res_0x7f0f070c);
                    return;
                }
                TiebaStatic.log("c10025");
                ur4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.h1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.L6();
            } else {
                this.a.W6();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void onNavigationButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c2 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) || ur4Var == null) {
                return;
            }
            ur4Var.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class c3 implements gg<LinearLayout> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f091847);
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
    public class d implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            this.a.G0.z3(list);
        }
    }

    /* loaded from: classes3.dex */
    public class d1 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.a.e6();
                gq4 O1 = this.a.y0.O1();
                int Y0 = this.a.G0.Y0();
                if (Y0 <= 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0de0);
                } else if (O1 == null || Y0 <= O1.h()) {
                    this.a.G0.m0();
                    this.a.G7();
                    this.a.G0.u3();
                    if (oi.z()) {
                        this.a.y0.B3(this.a.G0.Y0());
                        if (this.a.e != null) {
                            this.a.e.x();
                        }
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c3c);
                    }
                    ur4Var.dismiss();
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0de0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class e implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                ft7 Q1 = this.a.y0.Q1();
                if (Q1.O().getPraise().getIsLike() == 1) {
                    this.a.O7(0);
                } else {
                    this.a.O7(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, Q1.O()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e1 implements fs4.e {
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

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                if (this.a.L0 != null) {
                    this.a.L0.dismiss();
                }
                this.a.L7(i);
                if (i == -4) {
                    View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b7);
                    this.a.Q6(view3);
                    if (view3 != null) {
                        view3.performClick();
                    }
                } else if (i == -3) {
                    SparseArray sparseArray2 = (SparseArray) view2.getTag();
                    View view4 = (View) sparseArray2.get(R.id.obfuscated_res_0x7f0917b6);
                    this.a.Q6(view4);
                    if (view4 != null) {
                        if (sparseArray2 != null && (sparseArray2.get(R.id.obfuscated_res_0x7f092002) instanceof Boolean)) {
                            if (((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092002)).booleanValue()) {
                                this.a.d7(true);
                            } else {
                                this.a.d7(false);
                            }
                        }
                        view4.performClick();
                    }
                } else if (i == -2) {
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b9);
                    if (view5 != null) {
                        AgreeView agreeView = (AgreeView) view5;
                        this.a.Q6(view5);
                        if (agreeView.getImgDisagree() != null) {
                            agreeView.getImgDisagree().performClick();
                        }
                    }
                } else if (i == -1) {
                    View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b9);
                    if (view6 != null) {
                        this.a.Q6(view6);
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
                                j55.a aVar = new j55.a();
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
                                pbFragment.l1 = new sx7(pbFragment.getPageContext());
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
                                this.a.D6(view2);
                                if (this.a.y0.Q1().O() == null || this.a.y0.Q1().O().getAuthor() == null || this.a.y0.Q1().O().getAuthor().getUserId() == null || this.a.A0 == null) {
                                    return;
                                }
                                PbFragment pbFragment2 = this.a;
                                int W5 = pbFragment2.W5(pbFragment2.y0.Q1());
                                ThreadData O = this.a.y0.Q1().O();
                                if (O.isBJHArticleThreadType()) {
                                    i2 = 2;
                                } else if (O.isBJHVideoThreadType()) {
                                    i2 = 3;
                                } else if (!O.isBJHNormalThreadType()) {
                                    i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                                }
                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.y0.b).param("obj_locate", 2).param("obj_id", this.a.y0.Q1().O().getAuthor().getUserId()).param("obj_type", !this.a.A0.e()).param("obj_source", W5).param("obj_param1", i2));
                                return;
                            }
                            return;
                        case 5:
                            if (!oi.z()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
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
                                if ((sparseArray3.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean) && ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092044)).booleanValue()) {
                                    sparseArray3.put(R.id.obfuscated_res_0x7f091ffb, 0);
                                    sparseArray3.put(R.id.obfuscated_res_0x7f091fe4, 2);
                                    this.a.e5(sparseArray3);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        case 6:
                            SparseArray sparseArray4 = (SparseArray) view2.getTag();
                            if (sparseArray4 != null && (sparseArray4.get(R.id.obfuscated_res_0x7f091fec) instanceof Integer) && (sparseArray4.get(R.id.obfuscated_res_0x7f091fea) instanceof String) && (sparseArray4.get(R.id.obfuscated_res_0x7f092008) instanceof Integer) && (sparseArray4.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean) && (sparseArray4.get(R.id.obfuscated_res_0x7f091ffc) instanceof Boolean)) {
                                boolean booleanValue = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091feb)).booleanValue();
                                int intValue = ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092008)).intValue();
                                boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ffc)).booleanValue();
                                boolean E = this.a.P().E(TbadkCoreApplication.getCurrentAccount());
                                if (E) {
                                    if (!booleanValue2) {
                                        this.a.o7(sparseArray4, intValue, booleanValue);
                                        return;
                                    } else {
                                        this.a.G0.w2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091fea), intValue, booleanValue, null, E);
                                        return;
                                    }
                                } else if (booleanValue && !booleanValue2) {
                                    this.a.o7(sparseArray4, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.G0.u2(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091fea), intValue, booleanValue);
                                    return;
                                }
                            }
                            return;
                        case 7:
                            if (!oi.z()) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                                return;
                            }
                            SparseArray<Object> sparseArray5 = (SparseArray) view2.getTag();
                            if (sparseArray5 == null) {
                                return;
                            }
                            boolean booleanValue3 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092030)).booleanValue();
                            boolean booleanValue4 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f09202e)).booleanValue();
                            boolean booleanValue5 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092044)).booleanValue();
                            boolean booleanValue6 = sparseArray5.get(R.id.obfuscated_res_0x7f092000) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f092000)).booleanValue() : false;
                            if (!booleanValue3) {
                                if (booleanValue4) {
                                    this.a.G0.u2(((Integer) sparseArray5.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray5.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray5.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                                    return;
                                }
                                return;
                            } else if (!booleanValue5) {
                                if (booleanValue6) {
                                    sparseArray5.put(R.id.obfuscated_res_0x7f091fe4, 2);
                                }
                                this.a.G0.z2(view2);
                                return;
                            } else {
                                sparseArray5.put(R.id.obfuscated_res_0x7f091ffb, 1);
                                sparseArray5.put(R.id.obfuscated_res_0x7f091fe4, 2);
                                this.a.e5(sparseArray5);
                                return;
                            }
                        case 8:
                            if (this.a.checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
                                PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8);
                                if (postData2.q() == null) {
                                    return;
                                }
                                this.a.h5(postData2.q());
                                return;
                            }
                            return;
                        case 9:
                            if (!this.a.checkUpIsLogin() || this.a.y0 == null || this.a.y0.Q1() == null) {
                                return;
                            }
                            this.a.a.o1(ur8.c(view2));
                            return;
                        default:
                            return;
                    }
                } else if (!this.a.checkUpIsLogin() || this.a.y0 == null || this.a.y0.Q1() == null) {
                } else {
                    this.a.G0.s4(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e2 implements av4.g {
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

        @Override // com.repackage.av4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.a.F5()) {
                    this.a.a.finish();
                }
                if (!this.a.y0.N2(true)) {
                    this.a.G0.v0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e3 implements n56.b {
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

        @Override // com.repackage.n56.b
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
                this.b.G0.S2();
            }
        }

        @Override // com.repackage.n56.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) || !e(i2) || this.b.G0 == null || this.b.e == null) {
                return;
            }
            this.b.G0.X3();
            this.b.e.u(false);
            this.b.e.x();
        }

        @Override // com.repackage.n56.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.n56.b
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
    public class f implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.b.G0.P3();
                MessageManager.getInstance().sendMessage(this.a);
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements sy7.h {
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

        @Override // com.repackage.sy7.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.f7(z);
                if (this.a.G0.O0() != null && z) {
                    this.a.G0.e4(false);
                }
                this.a.G0.l2(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f1 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                if (ur4Var != null) {
                    ur4Var.dismiss();
                }
                this.d.o5(((Integer) this.a.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091fea), this.b, this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (!this.a.y0.N2(true)) {
                    this.a.G0.v0();
                } else {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f3 implements uw7.b {
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

        @Override // com.repackage.uw7.b
        public void a(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.G0.h4(str);
        }

        @Override // com.repackage.uw7.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.G0.e4(!this.a.N);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g1 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                        statisticItem.param("tid", this.a.y0.i2());
                        statisticItem.param("fid", this.a.y0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i = 5;
                        if (this.a.y0.v1()) {
                            i = 4;
                        } else if (this.a.y0.w1()) {
                            i = 3;
                        } else if (this.a.y0.y1()) {
                            i = 1;
                        }
                        statisticItem.param("obj_type", i);
                        TiebaStatic.log(statisticItem);
                        this.a.g0 = true;
                    }
                    if (this.a.y0.J2(false)) {
                        this.a.G0.v3();
                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if ((this.a.v0 == null || !this.a.y0.D2() || !this.a.v0.d()) && this.a.y0.Q1() != null) {
                        this.a.G0.L2();
                    }
                    this.a.z2 = true;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g3 {
        boolean onBackPressed();
    }

    /* loaded from: classes3.dex */
    public class h extends cf5<ShareItem> {
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
        @Override // com.repackage.cf5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return hz7.d(this.a.w5(), ShareSwitch.isOn() ? 1 : 6, this.a.y0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements fs4.e {
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

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                if (this.e.L0 != null) {
                    this.e.L0.dismiss();
                }
                if (i == 0) {
                    this.e.G0.u2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091fea), ((Integer) this.a.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f092041);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f092043);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f092042);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.j1);
                    userMuteAddAndDelCustomMessage.setTag(this.e.j1);
                    this.e.C7(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f09203f));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h1 implements qo6.d {
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

        @Override // com.repackage.qo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.qo6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", z ? 5 : 6).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (z) {
                    if (this.a.V0 != null && this.a.V0.a() != null) {
                        this.a.V0.a().A(new h25(45, 27, null));
                    }
                    this.a.G0.f0();
                }
            }
        }

        @Override // com.repackage.qo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public interface h3 {
        void a(Object obj);
    }

    /* loaded from: classes3.dex */
    public class i implements je5<ShareItem> {
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
        @Override // com.repackage.je5
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
                    if (this.a.y0 == null || this.a.y0.Q1() == null || this.a.y0.Q1().O() == null || this.a.y0.Q1().O().getAuthor() == null) {
                        return;
                    }
                    this.a.y0.Q1().O().getAuthor().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (oi.z()) {
                    if (this.a.y0 != null && !this.a.y0.isLoading) {
                        this.a.G7();
                        this.a.G0.u3();
                        z = true;
                        if (this.a.y0.Q1() != null && this.a.y0.Q1().f != null && this.a.y0.Q1().f.size() > i) {
                            int intValue = this.a.y0.Q1().f.get(i).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.y0.j2()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.a.y0.H3(intValue)) {
                                this.a.i = true;
                                this.a.G0.i3(true);
                            }
                        }
                    }
                    return z;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
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
    public class i2 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
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
                    ku7.a(this.b.a.getPageContext(), this.a).show();
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
                rg.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface i3 {
    }

    /* loaded from: classes3.dex */
    public class j extends cf5<ShareItem> {
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
        @Override // com.repackage.cf5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel K = this.b.K();
                if (K != null) {
                    K.p3(this.a);
                }
                return hz7.d(this.b.w5(), 2, K);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class j0 extends p75<TipEvent> {
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
        @Override // com.repackage.i75
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
    public class j1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes3.dex */
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
                qx7 qx7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qx7Var = this.a.c.K0) == null || qx7Var.g() == null) {
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
                int i2 = qi.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = qi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = qi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                PbFragment pbFragment = this.c;
                boolean z = true;
                pbFragment.S5().R0().smoothScrollBy((pbFragment.Z[1] + pbFragment.a0) - i3, 50);
                if (this.c.S5().b1() != null) {
                    this.c.V0.a().setVisibility(8);
                    this.c.S5().b1().o(this.a, this.b, this.c.S5().e1(), (this.c.y0 == null || this.c.y0.Q1() == null || this.c.y0.Q1().O() == null || !this.c.y0.Q1().O().isBjh()) ? false : false);
                    o45 b = this.c.S5().b1().b();
                    if (b != null && this.c.y0 != null && this.c.y0.Q1() != null) {
                        b.G(this.c.y0.Q1().d());
                        b.c0(this.c.y0.Q1().O());
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

    /* loaded from: classes3.dex */
    public class j2 implements h45 {
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

        @Override // com.repackage.h45
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qx7 qx7Var = this.a.K0;
                if (qx7Var == null || qx7Var.g() == null || !this.a.K0.g().d()) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.y0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.V0 != null) {
                this.a.G0.Y2(this.a.V0.C());
            }
            this.a.G0.Q2();
            this.a.G0.m0();
        }
    }

    /* loaded from: classes3.dex */
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
                nx7 nx7Var = this.b.G0;
                nx7Var.x3("@" + this.a.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k1 implements qo6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ PbFragment c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k1 a;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$k1$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0247a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0247a(a aVar) {
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
                    qx7 qx7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qx7Var = this.a.a.c.K0) == null || qx7Var.g() == null) {
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
                    int i2 = qi.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    PbFragment pbFragment = this.a.c;
                    boolean z = true;
                    pbFragment.S5().R0().smoothScrollBy((pbFragment.Z[1] + pbFragment.a0) - i3, 50);
                    if (this.a.c.S5().b1() != null) {
                        this.a.c.V0.a().setVisibility(8);
                        z = (this.a.c.y0 == null || this.a.c.y0.Q1() == null || this.a.c.y0.Q1().O() == null || !this.a.c.y0.Q1().O().isBjh()) ? false : false;
                        hw7 b1 = this.a.c.S5().b1();
                        k1 k1Var = this.a;
                        b1.o(k1Var.a, k1Var.b, k1Var.c.S5().e1(), z);
                        o45 b = this.a.c.S5().b1().b();
                        if (b != null && this.a.c.y0 != null && this.a.c.y0.Q1() != null) {
                            b.G(this.a.c.y0.Q1().d());
                            b.c0(this.a.c.y0.Q1().O());
                        }
                        if (this.a.c.K0.f() == null && this.a.c.S5().b1().b().t() != null) {
                            this.a.c.S5().b1().b().t().g(new C0247a(this));
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

        @Override // com.repackage.qo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.qo6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", z ? 5 : 6).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (z) {
                    rg.a().postDelayed(new a(this), 200L);
                }
            }
        }

        @Override // com.repackage.qo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k2 implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ ur4 c;
        public final /* synthetic */ PbFragment d;

        public k2(PbFragment pbFragment, MarkData markData, MarkData markData2, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, markData2, ur4Var};
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
            this.c = ur4Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
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
                this.d.H7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements je5<ShareItem> {
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
        @Override // com.repackage.je5
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
                    pbFragment.Y6(pbFragment.b1);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
        public class a implements fs4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ds4 a;
            public final /* synthetic */ View b;
            public final /* synthetic */ l1 c;

            public a(l1 l1Var, ds4 ds4Var, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var, ds4Var, view2};
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
                this.a = ds4Var;
                this.b = view2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.c.a.y0.f2() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // com.repackage.fs4.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void i0(fs4 fs4Var, int i, View view2) {
                boolean H3;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, fs4Var, i, view2) != null) {
                    return;
                }
                this.a.dismiss();
                int i2 = 3;
                if (this.c.a.y0.f2() != 1 || i != 1) {
                    if (this.c.a.y0.f2() == 2 && i == 0) {
                        i2 = 1;
                    } else if (this.c.a.y0.f2() == 3 && i != 2) {
                        i2 = 2;
                    } else if (i == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091843 ? 1 : 0).param("obj_type", i2));
                    if (this.c.a.y0.Q1().f != null && this.c.a.y0.Q1().f.size() > i) {
                        i = this.c.a.y0.Q1().f.get(i).sort_type.intValue();
                    }
                    H3 = this.c.a.y0.H3(i);
                    this.b.setTag(Integer.valueOf(this.c.a.y0.e2()));
                    if (H3) {
                        return;
                    }
                    this.c.a.i = true;
                    this.c.a.G0.i3(true);
                    return;
                }
                i2 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091843 ? 1 : 0).param("obj_type", i2));
                if (this.c.a.y0.Q1().f != null) {
                    i = this.c.a.y0.Q1().f.get(i).sort_type.intValue();
                }
                H3 = this.c.a.y0.H3(i);
                this.b.setTag(Integer.valueOf(this.c.a.y0.e2()));
                if (H3) {
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
            if (r0 >= com.repackage.iy7.d(r32.a.J5())) goto L886;
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
            bs4 bs4Var;
            bs4 bs4Var2;
            bs4 bs4Var3;
            PbFragment pbFragment;
            int i;
            boolean z;
            bs4 bs4Var4;
            bs4 bs4Var5;
            bs4 bs4Var6;
            bs4 bs4Var7;
            String name;
            int i2;
            boolean z2;
            int fixedNavHeight;
            int i3;
            int i4;
            lr4 lr4Var;
            String jumpUrlWithTid;
            String[] strArr;
            ft7 Q1;
            int i5;
            int i6;
            boolean G3;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (this.a.t0 && (view2 == this.a.G0.h.c || view2 == this.a.G0.h.d || view2.getId() == R.id.obfuscated_res_0x7f091822 || view2.getId() == R.id.obfuscated_res_0x7f0909f4 || view2.getId() == R.id.obfuscated_res_0x7f091bb4 || view2.getId() == R.id.obfuscated_res_0x7f0917c3)) {
                    return;
                }
                if (!(view2 instanceof TbListTextView) || !(view2.getParent() instanceof TbRichTextView)) {
                    if (view2 == this.a.G0.U0() && this.a.getPageContext().getPageActivity() != null && this.a.y0 != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.i2(), this.a.y0.y2(), this.a.y0.x2())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.a.y0.getForumId());
                        statisticItem2.param("fname", this.a.y0.p1());
                        statisticItem2.param("tid", this.a.y0.i2());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view2 == this.a.G0.W0()) {
                        if (this.a.i) {
                            return;
                        }
                        if (this.a.y0.J2(true)) {
                            this.a.i = true;
                            this.a.G0.v3();
                        }
                    } else if (view2 != this.a.G0.h.m()) {
                        if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().r()) {
                            if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().k()) {
                                if (view2 == this.a.G0.h.f) {
                                    if (this.a.G0.c0(this.a.y0.D1())) {
                                        this.a.G7();
                                        return;
                                    }
                                    this.a.j = false;
                                    this.a.f = false;
                                    qi.x(this.a.a, this.a.G0.h.f);
                                    this.a.a.finish();
                                } else if (view2 != this.a.G0.C0() && (this.a.G0.h.n() == null || (view2 != this.a.G0.h.n().s() && view2 != this.a.G0.h.n().t()))) {
                                    if (view2 == this.a.G0.K0()) {
                                        if (this.a.y0 != null) {
                                            jm4.o(this.a.getPageContext().getPageActivity(), this.a.y0.Q1().O().getTopicData().b());
                                        }
                                    } else if (view2 != this.a.G0.h.c) {
                                        if (view2 == this.a.G0.h.d) {
                                            if (ge5.a()) {
                                                return;
                                            }
                                            if (this.a.y0 != null && this.a.y0.Q1() != null) {
                                                ArrayList<PostData> F = this.a.y0.Q1().F();
                                                if ((F == null || F.size() <= 0) && this.a.y0.g2()) {
                                                    qi.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ddc));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.y0.i2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.y0.getForumId()));
                                                if (!this.a.G0.R1()) {
                                                    this.a.G0.Q2();
                                                }
                                                this.a.K6();
                                            } else {
                                                qi.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ddc));
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0917e3) {
                                            if (oi.z()) {
                                                this.a.G0.e3(true);
                                                this.a.G0.Q2();
                                                if (this.a.i) {
                                                    return;
                                                }
                                                this.a.i = true;
                                                this.a.G0.Z3();
                                                this.a.G7();
                                                this.a.G0.u3();
                                                this.a.y0.F3(this.a.A5());
                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                                                return;
                                            }
                                        } else if (view2.getId() != R.id.obfuscated_res_0x7f0917be) {
                                            if ((this.a.G0.h.n() == null || view2 != this.a.G0.h.n().p()) && view2.getId() != R.id.obfuscated_res_0x7f0909f4 && view2.getId() != R.id.obfuscated_res_0x7f091bb4) {
                                                if (this.a.G0.h.n() != null && view2 == this.a.G0.h.n().l()) {
                                                    this.a.G0.h.k();
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e43) {
                                                    if (!this.a.d5(11009)) {
                                                        return;
                                                    }
                                                    this.a.h6(3);
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f0917c3) {
                                                    if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().q()) {
                                                        if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().x()) {
                                                            if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().w()) {
                                                                if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().u()) {
                                                                    if (this.a.G0.O0() == view2) {
                                                                        if (this.a.G0.O0().getIndicateStatus()) {
                                                                            ft7 Q12 = this.a.y0.Q1();
                                                                            if (Q12 != null && Q12.O() != null && Q12.O().getTaskInfoData() != null) {
                                                                                String d = Q12.O().getTaskInfoData().d();
                                                                                if (StringUtils.isNull(d)) {
                                                                                    d = Q12.O().getTaskInfoData().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d));
                                                                            }
                                                                        } else {
                                                                            hl8.d("c10725", null);
                                                                        }
                                                                        this.a.Z5();
                                                                    } else if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().n()) {
                                                                        if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().j()) {
                                                                            if (this.a.G0.h.n() != null && view2 == this.a.G0.h.n().m()) {
                                                                                if (oi.z()) {
                                                                                    SparseArray<Object> S0 = this.a.G0.S0(this.a.y0.Q1(), this.a.y0.g2(), 1);
                                                                                    if (S0 != null) {
                                                                                        if (StringUtils.isNull((String) S0.get(R.id.obfuscated_res_0x7f091fe9))) {
                                                                                            this.a.G0.u2(((Integer) S0.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) S0.get(R.id.obfuscated_res_0x7f091fea), ((Integer) S0.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) S0.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                                                                                        } else {
                                                                                            this.a.G0.v2(((Integer) S0.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) S0.get(R.id.obfuscated_res_0x7f091fea), ((Integer) S0.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) S0.get(R.id.obfuscated_res_0x7f091feb)).booleanValue(), (String) S0.get(R.id.obfuscated_res_0x7f091fe9));
                                                                                        }
                                                                                    }
                                                                                    this.a.G0.h.k();
                                                                                } else {
                                                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                                                                                    return;
                                                                                }
                                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f091f4a && view2.getId() != R.id.obfuscated_res_0x7f091f48 && view2.getId() != R.id.obfuscated_res_0x7f0917d3 && view2.getId() != R.id.obfuscated_res_0x7f091668) {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f091835) {
                                                                                    if (this.a.y0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                                                                                    statisticItem3.param("tid", this.a.y0.i2());
                                                                                    statisticItem3.param("fid", this.a.y0.getForumId());
                                                                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem3.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem3);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091835 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                        this.a.T = view2;
                                                                                        return;
                                                                                    } else if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                                        if (!(sparseArray2.get(R.id.obfuscated_res_0x7f092005) instanceof PostData)) {
                                                                                            return;
                                                                                        }
                                                                                        PostData postData = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f092005);
                                                                                        StatisticItem statisticItem4 = postData.c0;
                                                                                        if (statisticItem4 != null) {
                                                                                            StatisticItem copy = statisticItem4.copy();
                                                                                            copy.delete("obj_locate");
                                                                                            copy.param("obj_locate", 8);
                                                                                            TiebaStatic.log(copy);
                                                                                        }
                                                                                        if (this.a.y0 == null || this.a.y0.Q1() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String i22 = this.a.y0.i2();
                                                                                        String K = postData.K();
                                                                                        int W = this.a.y0.Q1() != null ? this.a.y0.Q1().W() : 0;
                                                                                        AbsPbActivity.e O6 = this.a.O6(K);
                                                                                        if (O6 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(i22, K, "pb", true, false, null, false, null, W, postData.b0(), this.a.y0.Q1().d(), false, postData.s().getIconInfo(), 5).addBigImageData(O6.a, O6.b, O6.g, O6.j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.a.y0.P1());
                                                                                        addBigImageData.setFromFrsForumId(this.a.y0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.a.y0.n2());
                                                                                        addBigImageData.setKeyFromForumId(this.a.y0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.a.y0.I(), this.a.y0.E(), this.a.y0.F(), this.a.y0.D(), this.a.y0.J());
                                                                                        addBigImageData.setBjhData(this.a.y0.i1());
                                                                                        if (this.a.y0.Q1().o() != null) {
                                                                                            addBigImageData.setHasForumRule(this.a.y0.Q1().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.a.y0.Q1().V() != null) {
                                                                                            addBigImageData.setIsManager(this.a.y0.Q1().V().getIs_manager());
                                                                                        }
                                                                                        if (this.a.y0.Q1().l().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.a.y0.Q1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.a.y0.Q1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.a.y0.Q1().l() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.a.y0.Q1().l().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.a.y0.Q1().l().getUser_level());
                                                                                        }
                                                                                        if (this.a.G0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.a.G0.I0(this.a.y0.G, this.a.y0.g2()).Q || postData.Q);
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091833 || view2.getId() == R.id.obfuscated_res_0x7f091a01 || view2.getId() == R.id.obfuscated_res_0x7f0917cd) {
                                                                                    if (this.a.y0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091833) {
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                                                        statisticItem5.param("tid", this.a.y0.i2());
                                                                                        statisticItem5.param("fid", this.a.y0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem5.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    }
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091a01) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                            this.a.U = view2;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091833 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                                                        this.a.U = view2;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.a.checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                                                                    if (!(sparseArray3.get(R.id.obfuscated_res_0x7f092005) instanceof PostData)) {
                                                                                        return;
                                                                                    }
                                                                                    PostData postData2 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f092005);
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091833 && (statisticItem = postData2.c0) != null) {
                                                                                        StatisticItem copy2 = statisticItem.copy();
                                                                                        copy2.delete("obj_locate");
                                                                                        copy2.param("obj_locate", 8);
                                                                                        TiebaStatic.log(copy2);
                                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091a01 || view2.getId() == R.id.obfuscated_res_0x7f0917cd) {
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.y0.j2()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.K()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.a.y0 == null || this.a.y0.Q1() == null || this.a.S5().a1() == null || postData2.s() == null || postData2.B() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.S5().b1() != null) {
                                                                                        this.a.S5().b1().c();
                                                                                    }
                                                                                    if (this.a.q0 && postData2.Y() != null && postData2.Y().size() != 0) {
                                                                                        this.a.F7(postData2, true);
                                                                                    } else {
                                                                                        vt7 vt7Var = new vt7();
                                                                                        vt7Var.A(this.a.y0.Q1().l());
                                                                                        vt7Var.E(this.a.y0.Q1().O());
                                                                                        vt7Var.C(postData2);
                                                                                        this.a.S5().a1().V(vt7Var);
                                                                                        this.a.S5().a1().setPostId(postData2.K());
                                                                                        this.a.z6(view2, postData2.s().getUserId(), "", postData2);
                                                                                        if (this.a.V0 != null) {
                                                                                            this.a.G0.Y2(this.a.V0.C());
                                                                                        }
                                                                                    }
                                                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f0917d1) {
                                                                                    if (view2 != this.a.G0.M0()) {
                                                                                        if (view2 == this.a.G0.h.o()) {
                                                                                            this.a.G0.D3();
                                                                                        } else if (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().v()) {
                                                                                            if (this.a.G0.h.n() != null && view2 == this.a.G0.h.n().o()) {
                                                                                                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.y0.i2())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                                                                                    this.a.G0.h.k();
                                                                                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                                                                                }
                                                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f09076e && view2.getId() != R.id.obfuscated_res_0x7f0909f1) {
                                                                                                int id = view2.getId();
                                                                                                if (id == R.id.obfuscated_res_0x7f091853) {
                                                                                                    if (!this.a.checkUpIsLogin() || (lr4Var = (lr4) view2.getTag()) == null || StringUtils.isNull(lr4Var.i1())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{lr4Var.i1()});
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091bb7 || id == R.id.obfuscated_res_0x7f090705 || id == R.id.obfuscated_res_0x7f091bb8 || id == R.id.obfuscated_res_0x7f090706) {
                                                                                                    if (!this.a.checkUpIsLogin()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view2 != null && view2.getTag() != null) {
                                                                                                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f092005);
                                                                                                        if (id == R.id.obfuscated_res_0x7f091bb8 || id == R.id.obfuscated_res_0x7f090706) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.a.y0.b));
                                                                                                        }
                                                                                                        if (this.a.M0 == null) {
                                                                                                            PbFragment pbFragment2 = this.a;
                                                                                                            pbFragment2.M0 = new fs4(pbFragment2.getContext());
                                                                                                            this.a.M0.n(this.a.i2);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.a.p6(view2);
                                                                                                        if (this.a.p6(view2) && this.a.m1 != null) {
                                                                                                            this.a.m1.t();
                                                                                                        }
                                                                                                        if (sparseArray4.get(R.id.obfuscated_res_0x7f092001) instanceof Boolean) {
                                                                                                            ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092001)).booleanValue();
                                                                                                        }
                                                                                                        boolean booleanValue = sparseArray4.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091feb)).booleanValue() : false;
                                                                                                        boolean booleanValue2 = sparseArray4.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
                                                                                                        boolean booleanValue3 = sparseArray4.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
                                                                                                        boolean booleanValue4 = sparseArray4.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
                                                                                                        boolean booleanValue5 = sparseArray4.get(R.id.obfuscated_res_0x7f09202e) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f09202e)).booleanValue() : false;
                                                                                                        String str = sparseArray4.get(R.id.obfuscated_res_0x7f091ff8) instanceof String ? (String) sparseArray4.get(R.id.obfuscated_res_0x7f091ff8) : null;
                                                                                                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f092000) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092000)).booleanValue() : false;
                                                                                                        if (postData3 != null) {
                                                                                                            if (postData3.V() != null && postData3.V().toString().length() > 0) {
                                                                                                                bs4 bs4Var8 = new bs4(3, this.a.getString(R.string.obfuscated_res_0x7f0f044d), this.a.M0);
                                                                                                                SparseArray sparseArray5 = new SparseArray();
                                                                                                                sparseArray5.put(R.id.obfuscated_res_0x7f091fe8, postData3);
                                                                                                                bs4Var8.d.setTag(sparseArray5);
                                                                                                                arrayList.add(bs4Var8);
                                                                                                            }
                                                                                                            this.a.E2 = postData3;
                                                                                                        }
                                                                                                        if (this.a.y0.Q1().r()) {
                                                                                                            String u = this.a.y0.Q1().u();
                                                                                                            if (postData3 != null && !pi.isEmpty(u) && u.equals(postData3.K())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    bs4Var4 = new bs4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0fd1), this.a.M0);
                                                                                                                } else {
                                                                                                                    bs4Var4 = new bs4(4, this.a.getString(R.string.obfuscated_res_0x7f0f0a90), this.a.M0);
                                                                                                                }
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f091fe8, this.a.E2);
                                                                                                                sparseArray6.put(R.id.obfuscated_res_0x7f092001, Boolean.FALSE);
                                                                                                                bs4Var4.d.setTag(sparseArray6);
                                                                                                                arrayList.add(bs4Var4);
                                                                                                                if (this.a.mIsLogin) {
                                                                                                                    if (fz7.i(this.a.y0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.a.t6(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            bs4 bs4Var9 = new bs4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0ff6), this.a.M0);
                                                                                                                            bs4Var9.d.setTag(str);
                                                                                                                            arrayList.add(bs4Var9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        bs4 bs4Var10 = new bs4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b33), this.a.M0);
                                                                                                                        SparseArray sparseArray7 = new SparseArray();
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091fff, sparseArray4.get(R.id.obfuscated_res_0x7f091fff));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092040, sparseArray4.get(R.id.obfuscated_res_0x7f092040));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092041, sparseArray4.get(R.id.obfuscated_res_0x7f092041));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f09203f, sparseArray4.get(R.id.obfuscated_res_0x7f09203f));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092042, sparseArray4.get(R.id.obfuscated_res_0x7f092042));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092043, sparseArray4.get(R.id.obfuscated_res_0x7f092043));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091feb, sparseArray4.get(R.id.obfuscated_res_0x7f091feb));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091fec, sparseArray4.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f091fea, sparseArray4.get(R.id.obfuscated_res_0x7f091fea));
                                                                                                                        sparseArray7.put(R.id.obfuscated_res_0x7f092008, sparseArray4.get(R.id.obfuscated_res_0x7f092008));
                                                                                                                        bs4Var4.d.setTag(sparseArray7);
                                                                                                                        arrayList.add(bs4Var10);
                                                                                                                    }
                                                                                                                    if (booleanValue3) {
                                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f092008, sparseArray4.get(R.id.obfuscated_res_0x7f092008));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091ff5, sparseArray4.get(R.id.obfuscated_res_0x7f091ff5));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091ff6, sparseArray4.get(R.id.obfuscated_res_0x7f091ff6));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091ff7, sparseArray4.get(R.id.obfuscated_res_0x7f091ff7));
                                                                                                                        sparseArray8.put(R.id.obfuscated_res_0x7f091ff8, str);
                                                                                                                        if (booleanValue4) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091fff, sparseArray4.get(R.id.obfuscated_res_0x7f091fff));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092040, sparseArray4.get(R.id.obfuscated_res_0x7f092040));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092041, sparseArray4.get(R.id.obfuscated_res_0x7f092041));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f09203f, sparseArray4.get(R.id.obfuscated_res_0x7f09203f));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092042, sparseArray4.get(R.id.obfuscated_res_0x7f092042));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092043, sparseArray4.get(R.id.obfuscated_res_0x7f092043));
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        if (booleanValue5) {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091fea, sparseArray4.get(R.id.obfuscated_res_0x7f091fea));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091fec, sparseArray4.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091ffc, sparseArray4.get(R.id.obfuscated_res_0x7f091ffc));
                                                                                                                            if (booleanValue6) {
                                                                                                                                bs4 bs4Var11 = new bs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.a.M0);
                                                                                                                                bs4Var11.d.setTag(sparseArray8);
                                                                                                                                bs4Var6 = bs4Var11;
                                                                                                                                bs4Var5 = new bs4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e3), this.a.M0);
                                                                                                                                bs4Var5.d.setTag(sparseArray8);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            sparseArray8.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        bs4Var6 = null;
                                                                                                                        bs4Var5 = new bs4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e3), this.a.M0);
                                                                                                                        bs4Var5.d.setTag(sparseArray8);
                                                                                                                    } else if (booleanValue5) {
                                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f092008, sparseArray4.get(R.id.obfuscated_res_0x7f092008));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091fea, sparseArray4.get(R.id.obfuscated_res_0x7f091fea));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091fec, sparseArray4.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                                        sparseArray9.put(R.id.obfuscated_res_0x7f091ffc, sparseArray4.get(R.id.obfuscated_res_0x7f091ffc));
                                                                                                                        if (this.a.y0.Q1().W() == 1002 && !booleanValue) {
                                                                                                                            bs4Var7 = new bs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0ff6), this.a.M0);
                                                                                                                        } else {
                                                                                                                            bs4Var7 = new bs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.a.M0);
                                                                                                                        }
                                                                                                                        bs4Var7.d.setTag(sparseArray9);
                                                                                                                        bs4Var6 = bs4Var7;
                                                                                                                        bs4Var5 = null;
                                                                                                                    } else {
                                                                                                                        bs4Var5 = null;
                                                                                                                        bs4Var6 = null;
                                                                                                                    }
                                                                                                                    if (bs4Var6 != null) {
                                                                                                                        arrayList.add(bs4Var6);
                                                                                                                    }
                                                                                                                    if (bs4Var5 != null) {
                                                                                                                        arrayList.add(bs4Var5);
                                                                                                                    }
                                                                                                                }
                                                                                                                this.a.M0.j(arrayList);
                                                                                                                this.a.L0 = new ds4(this.a.getPageContext(), this.a.M0);
                                                                                                                this.a.L0.k();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray62 = new SparseArray();
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f091fe8, this.a.E2);
                                                                                                        sparseArray62.put(R.id.obfuscated_res_0x7f092001, Boolean.FALSE);
                                                                                                        bs4Var4.d.setTag(sparseArray62);
                                                                                                        arrayList.add(bs4Var4);
                                                                                                        if (this.a.mIsLogin) {
                                                                                                        }
                                                                                                        this.a.M0.j(arrayList);
                                                                                                        this.a.L0 = new ds4(this.a.getPageContext(), this.a.M0);
                                                                                                        this.a.L0.k();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0917a1) {
                                                                                                    if (this.a.y0.Q1() != null && this.a.y0.Q1().O() != null && this.a.y0.Q1().O().getActUrl() != null) {
                                                                                                        jm4.o(this.a.getActivity(), this.a.y0.Q1().O().getActUrl());
                                                                                                        if (this.a.y0.Q1().O().getActInfoType() != 1) {
                                                                                                            if (this.a.y0.Q1().O().getActInfoType() == 2) {
                                                                                                                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                            }
                                                                                                        } else {
                                                                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09142c) {
                                                                                                    if (view2.getTag(R.id.obfuscated_res_0x7f092017) instanceof String) {
                                                                                                        String str2 = (String) view2.getTag(R.id.obfuscated_res_0x7f092017);
                                                                                                        TiebaStatic.log(new StatisticItem("c10912").param("fid", this.a.y0.Q1().m()).param("tid", this.a.y0.Q1().Q()).param("lotterytail", StringUtils.string(str2, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                        if (this.a.y0.Q1().Q().equals(str2)) {
                                                                                                            this.a.G0.y3(0);
                                                                                                        } else {
                                                                                                            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(str2, (String) null, (String) null, (String) null)));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0917fd) {
                                                                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1366);
                                                                                                        String q = ru4.k().q("tail_link", "");
                                                                                                        if (!StringUtils.isNull(q)) {
                                                                                                            TiebaStatic.log("c10056");
                                                                                                            jm4.s(view2.getContext(), string, q, true, true, true);
                                                                                                        }
                                                                                                        this.a.G0.Q2();
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091010) {
                                                                                                    if (view2 != null) {
                                                                                                        jm4.o(this.a.getActivity(), (String) view2.getTag());
                                                                                                        String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                        if (this.a.w5() == 1 && this.a.y0 != null && this.a.y0.Q1() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10397").param("fid", this.a.y0.Q1().m()).param("tid", this.a.y0.Q1().Q()).param("uid", currentAccount));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09141f) {
                                                                                                    if (view2 != null) {
                                                                                                        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                        jm4.o(this.a.getActivity(), (String) view2.getTag());
                                                                                                        if (this.a.w5() == 1 && this.a.y0 != null && this.a.y0.Q1() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c10507").param("fid", this.a.y0.Q1().m()).param("tid", this.a.y0.Q1().Q()).param("uid", currentAccount2));
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09147e) {
                                                                                                    this.a.y6();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f09147d) {
                                                                                                    this.a.v6();
                                                                                                } else if (id == R.id.obfuscated_res_0x7f092684) {
                                                                                                    if (this.a.y0 != null && this.a.y0.Q1() != null && this.a.y0.Q1().A() != null) {
                                                                                                        ft7 Q13 = this.a.y0.Q1();
                                                                                                        TiebaStatic.log(new StatisticItem("c11679").param("fid", Q13.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{Q13.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f092681) {
                                                                                                    if (this.a.y0 != null && this.a.y0.Q1() != null && this.a.y0.Q1().A() != null) {
                                                                                                        ft7 Q14 = this.a.y0.Q1();
                                                                                                        TiebaStatic.log(new StatisticItem("c11678").param("fid", Q14.m()));
                                                                                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{Q14.A().b()});
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f092379) {
                                                                                                    if (this.a.r1 >= 0) {
                                                                                                        if (this.a.y0 != null) {
                                                                                                            this.a.y0.i3();
                                                                                                        }
                                                                                                        if (this.a.y0 == null || this.a.G0.A0() == null) {
                                                                                                            i4 = 0;
                                                                                                        } else {
                                                                                                            i4 = 0;
                                                                                                            this.a.G0.A0().i0(this.a.y0.Q1(), false);
                                                                                                        }
                                                                                                        this.a.r1 = i4;
                                                                                                        if (this.a.y0 != null) {
                                                                                                            this.a.G0.R0().setSelection(this.a.y0.J1());
                                                                                                            this.a.y0.m3(0, 0);
                                                                                                        }
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091ade) {
                                                                                                    if (!this.a.d5(11009)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.h6(8);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091668) {
                                                                                                    SparseArray sparseArray10 = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
                                                                                                    if (sparseArray10 == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.E7(sparseArray10);
                                                                                                } else if (id == R.id.obfuscated_res_0x7f0917c0) {
                                                                                                    if (this.a.G0.R0() == null || this.a.y0 == null || this.a.y0.Q1() == null) {
                                                                                                        return;
                                                                                                    }
                                                                                                    int firstVisiblePosition = this.a.G0.R0().getFirstVisiblePosition();
                                                                                                    View childAt = this.a.G0.R0().getChildAt(0);
                                                                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                                                                    boolean u0 = this.a.y0.Q1().u0();
                                                                                                    boolean z3 = this.a.G0.c1() != null && this.a.G0.c1().g();
                                                                                                    boolean P1 = this.a.G0.P1();
                                                                                                    boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                    if (!u0 || this.a.G0.c1() == null || this.a.G0.c1().c() == null) {
                                                                                                        i2 = 0;
                                                                                                    } else {
                                                                                                        int k = ((int) (qi.k(this.a.getContext()) * 0.5625d)) - this.a.G0.c1().e();
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
                                                                                                    if ((this.a.y0.Q1().O() != null && this.a.y0.Q1().O().getReply_num() <= 0) || (P1 && z4)) {
                                                                                                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                                                        if (!this.a.checkUpIsLogin()) {
                                                                                                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.N6();
                                                                                                        if (this.a.y0.Q1().O().getAuthor() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.Q1().m()).param("obj_locate", 2).param("uid", this.a.y0.Q1().O().getAuthor().getUserId()));
                                                                                                        }
                                                                                                    } else {
                                                                                                        int i10 = (int) (qi.i(this.a.getContext()) * 0.6d);
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
                                                                                                            int d2 = iy7.d(this.a.getListView());
                                                                                                            if (iy7.e(this.a.getListView()) != -1) {
                                                                                                                d2--;
                                                                                                            }
                                                                                                            int f = qi.f(this.a.getContext(), R.dimen.tbds100);
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
                                                                                                                        this.a.G0.R0().smoothScrollBy(this.a.G0.d1.c.getView().getTop() - ((int) (qi.k(this.a.getContext()) * 0.5625d)), 500);
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = this.a.G0.c1().d();
                                                                                                                }
                                                                                                            } else {
                                                                                                                fixedNavHeight = (int) (qi.k(this.a.getContext()) * 0.5625d);
                                                                                                            }
                                                                                                            f += fixedNavHeight;
                                                                                                            if (this.a.G0.d1 != null) {
                                                                                                            }
                                                                                                            this.a.G0.R0().setSelectionFromTop(d2, f + i10);
                                                                                                            this.a.G0.R0().smoothScrollBy(i10, 500);
                                                                                                        }
                                                                                                    }
                                                                                                    if (this.a.y0.Q1().O() != null && this.a.y0.Q1().O().getAuthor() != null) {
                                                                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.Q1().m()).param("obj_locate", 2).param("uid", this.a.y0.Q1().O().getAuthor().getUserId()));
                                                                                                    }
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091821 || id == R.id.obfuscated_res_0x7f091822) {
                                                                                                    if (this.a.y0 == null || this.a.y0.Q1() == null || this.a.y0.Q1().l() == null || pi.isEmpty(this.a.y0.Q1().l().getName())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    if (this.a.y0.getErrorNo() == 4) {
                                                                                                        if (!StringUtils.isNull(this.a.y0.p1()) || this.a.y0.f1() == null) {
                                                                                                            this.a.a.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        name = this.a.y0.f1().b;
                                                                                                    } else {
                                                                                                        name = this.a.y0.Q1().l().getName();
                                                                                                    }
                                                                                                    if (StringUtils.isNull(name)) {
                                                                                                        this.a.a.finish();
                                                                                                        return;
                                                                                                    }
                                                                                                    String p1 = this.a.y0.p1();
                                                                                                    if (this.a.y0.v1() && p1 != null && p1.equals(name)) {
                                                                                                        this.a.a.finish();
                                                                                                    } else {
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getActivity()).createNormalCfg(this.a.y0.Q1().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                    }
                                                                                                    StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                                                    statisticItem6.param("tid", this.a.y0.i2());
                                                                                                    statisticItem6.param("fid", this.a.y0.getForumId());
                                                                                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                    if (this.a.y0.Q1().O() != null) {
                                                                                                        statisticItem6.param("nid", this.a.y0.Q1().O().getNid());
                                                                                                    }
                                                                                                    TiebaStatic.log(statisticItem6);
                                                                                                } else if (id != R.id.obfuscated_res_0x7f090a74 && id != R.id.obfuscated_res_0x7f090a4d && id != R.id.obfuscated_res_0x7f090a4f && id != R.id.obfuscated_res_0x7f090a4e) {
                                                                                                    if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                                                        if (this.a.y0 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                        statisticItem7.param("tid", this.a.y0.i2());
                                                                                                        statisticItem7.param("fid", this.a.y0.getForumId());
                                                                                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem7.param("obj_locate", 2);
                                                                                                        TiebaStatic.log(statisticItem7);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f091848) {
                                                                                                        if (this.a.y0 == null || this.a.y0.Q1() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ft7 Q15 = this.a.y0.Q1();
                                                                                                        if (this.a.D0 == null) {
                                                                                                            PbFragment pbFragment3 = this.a;
                                                                                                            pbFragment3.D0 = new xt7(pbFragment3.getPageContext());
                                                                                                        }
                                                                                                        long g = og.g(Q15.Q(), 0L);
                                                                                                        long g2 = og.g(Q15.m(), 0L);
                                                                                                        new StatisticItem("c13446").param("forum_id", g2).eventStat();
                                                                                                        PbFragment pbFragment4 = this.a;
                                                                                                        pbFragment4.registerListener(pbFragment4.p2);
                                                                                                        this.a.D0.a(g, g2);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f09186c) {
                                                                                                        if (view2.getTag() instanceof SmartApp) {
                                                                                                            SmartApp smartApp = (SmartApp) view2.getTag();
                                                                                                            if (!ho5.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                    return;
                                                                                                                }
                                                                                                                jm4.o(this.a.getActivity(), smartApp.h5_url);
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.a.y0.i2()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                        }
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090e2d) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData = (ThreadData) view2.getTag();
                                                                                                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.getActivity()).createNormalCfg(threadData.getForum_name(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                        createNormalCfg.setCallFrom(14);
                                                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", threadData.getFid()).param("tid", threadData.getId()).param("thread_type", threadData.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f090e2a) {
                                                                                                        if (!(view2.getTag() instanceof ThreadData) || !this.a.checkUpIsLogin()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        ThreadData threadData2 = (ThreadData) view2.getTag();
                                                                                                        if (this.a.R != null) {
                                                                                                            this.a.R.Q(threadData2.getForum_name(), String.valueOf(threadData2.getFid()));
                                                                                                        }
                                                                                                        TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", threadData2.getFid()).param("tid", threadData2.getId()).param("thread_type", threadData2.getThreadType()).param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0));
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f0917d5 || id == R.id.obfuscated_res_0x7f09182d) {
                                                                                                        if (this.a.t0) {
                                                                                                            return;
                                                                                                        }
                                                                                                        StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                                                        statisticItem8.param("tid", this.a.y0.i2());
                                                                                                        statisticItem8.param("fid", this.a.y0.getForumId());
                                                                                                        statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem8.param("obj_locate", 7);
                                                                                                        TiebaStatic.log(statisticItem8);
                                                                                                        SparseArray sparseArray11 = (SparseArray) view2.getTag();
                                                                                                        if (sparseArray11 != null && (sparseArray11.get(R.id.obfuscated_res_0x7f092002) instanceof Boolean) && ((Boolean) sparseArray11.get(R.id.obfuscated_res_0x7f092002)).booleanValue()) {
                                                                                                            i08.o(6);
                                                                                                        }
                                                                                                        PbFragment pbFragment5 = this.a;
                                                                                                        pbFragment5.b = false;
                                                                                                        pbFragment5.j5(view2);
                                                                                                    } else if (id == R.id.obfuscated_res_0x7f092397) {
                                                                                                        if (view2.getTag(R.id.obfuscated_res_0x7f092002) instanceof Boolean) {
                                                                                                            i08.o(5);
                                                                                                        }
                                                                                                        this.a.d7(false);
                                                                                                        this.a.F7((PostData) view2.getTag(R.id.obfuscated_res_0x7f092018), false);
                                                                                                    }
                                                                                                } else if (!(view2.getTag() instanceof ThreadData)) {
                                                                                                    return;
                                                                                                } else {
                                                                                                    ThreadData threadData3 = (ThreadData) view2.getTag();
                                                                                                    if (this.a.y0.P1() == 3 && this.a.u0() && this.a.y0.Q1() != null && ListUtils.isEmpty(this.a.y0.Q1().p())) {
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
                                                                                                if (sparseArray12 == null || !(sparseArray12.get(R.id.obfuscated_res_0x7f092005) instanceof PostData)) {
                                                                                                    return;
                                                                                                }
                                                                                                PostData postData4 = (PostData) sparseArray12.get(R.id.obfuscated_res_0x7f092005);
                                                                                                View view3 = (View) sparseArray12.get(R.id.obfuscated_res_0x7f092007);
                                                                                                if (postData4 == null || view3 == null) {
                                                                                                    return;
                                                                                                }
                                                                                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09076f);
                                                                                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090770);
                                                                                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f0909f1);
                                                                                                if (postData4.p0()) {
                                                                                                    postData4.P0(false);
                                                                                                    gz7.e(postData4);
                                                                                                } else if (this.a.K() != null ? gz7.c(this.a.K().Q1(), postData4) : false) {
                                                                                                    postData4.P0(true);
                                                                                                }
                                                                                                SkinManager.setBackgroundColor(findViewById, postData4.p0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                                                SkinManager.setViewTextColor(eMTextView, postData4.p0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                                                WebPManager.setPureDrawable(imageView, postData4.p0() ? R.drawable.obfuscated_res_0x7f080964 : R.drawable.obfuscated_res_0x7f080963, postData4.p0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                                            }
                                                                                        } else {
                                                                                            this.a.G0.h.l();
                                                                                            this.a.G0.W3(this.a.H2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.a.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.a.getPageContext().getPageActivity(), 24008, og.g(this.a.y0.Q1().m(), 0L), og.g(this.a.y0.i2(), 0L), og.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.a.y0.Q1().O().getPushStatusData())));
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        sparseArray = (SparseArray) view2.getTag();
                                                                                    } catch (ClassCastException e) {
                                                                                        e.printStackTrace();
                                                                                        sparseArray = null;
                                                                                    }
                                                                                    PostData postData5 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8);
                                                                                    if (postData5 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.a.M0 == null) {
                                                                                        PbFragment pbFragment6 = this.a;
                                                                                        pbFragment6.M0 = new fs4(pbFragment6.getContext());
                                                                                        this.a.M0.n(this.a.i2);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.a.K().Q1() != null && this.a.K().Q1().i0();
                                                                                    if (view2 != null && sparseArray != null) {
                                                                                        boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue() : false;
                                                                                        boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
                                                                                        boolean booleanValue9 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
                                                                                        boolean booleanValue10 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
                                                                                        boolean booleanValue11 = sparseArray.get(R.id.obfuscated_res_0x7f09202e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09202e)).booleanValue() : false;
                                                                                        String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091ff8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ff8) : null;
                                                                                        boolean booleanValue12 = sparseArray.get(R.id.obfuscated_res_0x7f092000) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092000)).booleanValue() : false;
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
                                                                                            bs4 bs4Var12 = new bs4(8, pbFragment.getString(i), this.a.M0);
                                                                                            SparseArray sparseArray13 = new SparseArray();
                                                                                            sparseArray13.put(R.id.obfuscated_res_0x7f091fe8, postData5);
                                                                                            bs4Var12.d.setTag(sparseArray13);
                                                                                            arrayList2.add(bs4Var12);
                                                                                        }
                                                                                        if (this.a.mIsLogin) {
                                                                                            if (fz7.i(this.a.y0) || booleanValue9 || !booleanValue8) {
                                                                                                if ((this.a.t6(booleanValue7) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    bs4 bs4Var13 = new bs4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0ff6), this.a.M0);
                                                                                                    bs4Var13.d.setTag(str3);
                                                                                                    arrayList2.add(bs4Var13);
                                                                                                }
                                                                                            } else {
                                                                                                bs4 bs4Var14 = new bs4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b33), this.a.M0);
                                                                                                SparseArray sparseArray14 = new SparseArray();
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091feb, sparseArray.get(R.id.obfuscated_res_0x7f091feb));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                                                                                                sparseArray14.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                                                                                                bs4Var14.d.setTag(sparseArray14);
                                                                                                arrayList2.add(bs4Var14);
                                                                                            }
                                                                                            if (booleanValue9) {
                                                                                                SparseArray sparseArray15 = new SparseArray();
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f091ff5, sparseArray.get(R.id.obfuscated_res_0x7f091ff5));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f091ff6, sparseArray.get(R.id.obfuscated_res_0x7f091ff6));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                                                                                                sparseArray15.put(R.id.obfuscated_res_0x7f091ff8, str3);
                                                                                                if (booleanValue10) {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                                                                                                } else {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                                                                                                }
                                                                                                if (booleanValue11) {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue7));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                                                                                                    if (booleanValue12) {
                                                                                                        bs4 bs4Var15 = new bs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.a.M0);
                                                                                                        bs4Var15.d.setTag(sparseArray15);
                                                                                                        bs4Var2 = bs4Var15;
                                                                                                        bs4Var = new bs4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e3), this.a.M0);
                                                                                                        bs4Var.d.setTag(sparseArray15);
                                                                                                    }
                                                                                                } else {
                                                                                                    sparseArray15.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                                                                                                }
                                                                                                bs4Var2 = null;
                                                                                                bs4Var = new bs4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02e3), this.a.M0);
                                                                                                bs4Var.d.setTag(sparseArray15);
                                                                                            } else if (booleanValue11) {
                                                                                                SparseArray sparseArray16 = new SparseArray();
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue7));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                                                                                                sparseArray16.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                                                                                                if (this.a.y0.Q1().W() == 1002 && !booleanValue7) {
                                                                                                    bs4Var3 = new bs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0ff6), this.a.M0);
                                                                                                } else {
                                                                                                    bs4Var3 = new bs4(6, this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.a.M0);
                                                                                                }
                                                                                                bs4Var3.d.setTag(sparseArray16);
                                                                                                bs4Var2 = bs4Var3;
                                                                                                bs4Var = null;
                                                                                            } else {
                                                                                                bs4Var = null;
                                                                                                bs4Var2 = null;
                                                                                            }
                                                                                            if (bs4Var2 != null) {
                                                                                                arrayList2.add(bs4Var2);
                                                                                            }
                                                                                            if (bs4Var != null) {
                                                                                                arrayList2.add(bs4Var);
                                                                                            }
                                                                                        }
                                                                                        this.a.M0.j(arrayList2);
                                                                                        this.a.L0 = new ds4(this.a.getPageContext(), this.a.M0);
                                                                                        this.a.L0.k();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f091668) {
                                                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                                                    statisticItem10.param("tid", this.a.y0.i2());
                                                                                    statisticItem10.param("fid", this.a.y0.getForumId());
                                                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem10.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem10);
                                                                                }
                                                                                if (view2.getId() == R.id.obfuscated_res_0x7f0917d3 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                                                                    this.a.T = view2;
                                                                                    return;
                                                                                } else if (this.a.checkUpIsLogin()) {
                                                                                    if (this.a.y0 == null || this.a.y0.Q1() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.a.G0.m0();
                                                                                    SparseArray sparseArray17 = (SparseArray) view2.getTag();
                                                                                    PostData postData6 = (PostData) sparseArray17.get(R.id.obfuscated_res_0x7f092005);
                                                                                    PostData postData7 = (PostData) sparseArray17.get(R.id.obfuscated_res_0x7f092006);
                                                                                    View view4 = (View) sparseArray17.get(R.id.obfuscated_res_0x7f092007);
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
                                                                                        if (view2.getId() == R.id.obfuscated_res_0x7f091668) {
                                                                                            copy3.param("obj_locate", 6);
                                                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d3) {
                                                                                            copy3.param("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(copy3);
                                                                                    }
                                                                                    String i23 = this.a.y0.i2();
                                                                                    String K2 = postData6.K();
                                                                                    String K3 = postData7 != null ? postData7.K() : "";
                                                                                    int W2 = this.a.y0.Q1() != null ? this.a.y0.Q1().W() : 0;
                                                                                    this.a.G7();
                                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091bb7) {
                                                                                        AbsPbActivity.e O62 = this.a.O6(K2);
                                                                                        if (this.a.y0 == null || this.a.y0.Q1() == null || O62 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(i23, K2, "pb", true, false, null, true, null, W2, postData6.b0(), this.a.y0.Q1().d(), false, postData6.s().getIconInfo(), 5).addBigImageData(O62.a, O62.b, O62.g, O62.j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.a.y0.P1());
                                                                                        addBigImageData2.setFromFrsForumId(this.a.y0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.a.y0.n2());
                                                                                        addBigImageData2.setKeyFromForumId(this.a.y0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.a.y0.i1());
                                                                                        addBigImageData2.setTiebaPlusData(this.a.y0.I(), this.a.y0.E(), this.a.y0.F(), this.a.y0.D(), this.a.y0.J());
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e O63 = this.a.O6(K2);
                                                                                        if (postData6 == null || this.a.y0 == null || this.a.y0.Q1() == null || O63 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(i23, K2, "pb", true, false, null, false, K3, W2, postData6.b0(), this.a.y0.Q1().d(), false, postData6.s().getIconInfo(), 5).addBigImageData(O63.a, O63.b, O63.g, O63.j);
                                                                                        if (!pi.isEmpty(K3)) {
                                                                                            addBigImageData3.setHighLightPostId(K3);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.a.y0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.a.y0.I(), this.a.y0.E(), this.a.y0.F(), this.a.y0.D(), this.a.y0.J());
                                                                                        addBigImageData3.setBjhData(this.a.y0.i1());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.a.y0.P1());
                                                                                        addBigImageData3.setFromFrsForumId(this.a.y0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.a.y0.n2());
                                                                                        if (this.a.G0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.a.G0.I0(this.a.y0.G, this.a.y0.g2()).Q || postData6.Q);
                                                                                        }
                                                                                        if (this.a.y0.Q1() != null && this.a.y0.Q1().o() != null) {
                                                                                            addBigImageData3.setHasForumRule(this.a.y0.Q1().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.y0.Q1().m()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (oi.z()) {
                                                                            SparseArray<Object> S02 = this.a.G0.S0(this.a.y0.Q1(), this.a.y0.g2(), 1);
                                                                            if (S02 != null) {
                                                                                this.a.G0.x2(((Integer) S02.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) S02.get(R.id.obfuscated_res_0x7f091fea), ((Integer) S02.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) S02.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                                                                            }
                                                                            this.a.G0.h.k();
                                                                            if (this.a.K() != null && this.a.K().Q1() != null && this.a.K().Q1().O() != null) {
                                                                                ThreadData O = this.a.K().Q1().O();
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
                                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                                                                            return;
                                                                        }
                                                                    } else if (oi.z()) {
                                                                        this.a.G0.m0();
                                                                        SparseArray<Object> S03 = this.a.G0.S0(this.a.y0.Q1(), this.a.y0.g2(), 1);
                                                                        if (S03 == null) {
                                                                            return;
                                                                        }
                                                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.Q1().l().getId(), this.a.y0.Q1().l().getName(), this.a.y0.Q1().O().getId(), String.valueOf(this.a.y0.Q1().V().getUserId()), (String) S03.get(R.id.obfuscated_res_0x7f091ff5), (String) S03.get(R.id.obfuscated_res_0x7f091ff6), (String) S03.get(R.id.obfuscated_res_0x7f091ff8), (String) S03.get(R.id.obfuscated_res_0x7f091ff7))));
                                                                    } else {
                                                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
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
                                                            } else if (this.a.y0 == null || this.a.y0.Q1() == null || this.a.y0.Q1().O() == null) {
                                                                return;
                                                            } else {
                                                                this.a.G0.h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.a;
                                                                pbFragment7.c6(pbFragment7.y0.Q1().O().getFirstPostId());
                                                            }
                                                        } else {
                                                            this.a.G0.m0();
                                                            if (oi.z()) {
                                                                if (this.a.i) {
                                                                    view2.setTag(Integer.valueOf(this.a.y0.e2()));
                                                                    return;
                                                                }
                                                                this.a.G7();
                                                                this.a.G0.u3();
                                                                ds4 ds4Var = new ds4(this.a.getPageContext());
                                                                if (this.a.y0.Q1().f == null || this.a.y0.Q1().f.size() <= 0) {
                                                                    strArr = new String[]{this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11af), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11b0)};
                                                                } else {
                                                                    strArr = new String[this.a.y0.Q1().f.size()];
                                                                    for (int i11 = 0; i11 < this.a.y0.Q1().f.size(); i11++) {
                                                                        strArr[i11] = this.a.y0.Q1().f.get(i11).sort_name + this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11ad);
                                                                    }
                                                                }
                                                                ds4Var.i(null, strArr, new a(this, ds4Var, view2));
                                                                ds4Var.k();
                                                            } else {
                                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.a.G0.m0();
                                                        if (this.a.K().Q1().g != 2) {
                                                            if (this.a.y0.O1() != null) {
                                                                this.a.G0.d4(this.a.y0.O1(), this.a.h2);
                                                            }
                                                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0871);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.a.checkUpIsLogin()) || (Q1 = this.a.y0.Q1()) == null) {
                                                    return;
                                                } else {
                                                    ThreadData O2 = Q1.O();
                                                    if (O2 != null && O2.getAuthor() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", Q1.m()).param("obj_locate", 4).param("uid", O2.getAuthor().getUserId()));
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
                                                        statisticItem14.param("tid", this.a.y0.i2());
                                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem14.param("fid", this.a.y0.getForumId());
                                                        if (view2.getId() != R.id.obfuscated_res_0x7f091e43) {
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
                                                            if (O2.getBaijiahaoData() != null && !pi.isEmpty(O2.getBaijiahaoData().oriUgcVid)) {
                                                                statisticItem14.param(TiebaStatic.Params.OBJ_PARAM6, O2.getBaijiahaoData().oriUgcVid);
                                                            }
                                                        }
                                                        if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem14.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.a.P() != null) {
                                                            t95.e(this.a.P(), statisticItem14);
                                                        }
                                                        if (this.a.G0 != null) {
                                                            statisticItem14.param("obj_param1", this.a.G0.N0());
                                                        }
                                                        TiebaStatic.log(statisticItem14);
                                                        if (qi.D()) {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c3c);
                                                            return;
                                                        } else if (Q1 != null) {
                                                            ArrayList<PostData> F2 = this.a.y0.Q1().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.a.y0.g2()) {
                                                                this.a.G0.m0();
                                                                this.a.G7();
                                                                if (Q1.A() != null && !StringUtils.isNull(Q1.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.a.y0.Q1().m()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.a.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.a.G0 != null) {
                                                                    this.a.G0.o0();
                                                                    this.a.G0.p4(Q1);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.a.G0.P3();
                                                                    this.a.y0.k1().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0917c3) {
                                                                        i6 = 2;
                                                                    } else {
                                                                        i6 = view2.getId() == R.id.obfuscated_res_0x7f091e43 ? 1 : 6;
                                                                    }
                                                                    if ((!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) || !this.a.G0.T1() || Q1.m0()) {
                                                                        this.a.A7(i6);
                                                                    } else if (UbsABTestHelper.isPbSharePathTestA()) {
                                                                        this.a.A7(i6);
                                                                    } else if (e05.c() > 0) {
                                                                        this.a.k7();
                                                                    } else {
                                                                        int N0 = this.a.G0.N0();
                                                                        this.a.G0.b0();
                                                                        this.a.g6(e05.a(), N0);
                                                                    }
                                                                }
                                                            } else {
                                                                qi.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ddc));
                                                                return;
                                                            }
                                                        } else {
                                                            qi.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ddc));
                                                            return;
                                                        }
                                                    }
                                                    i5 = 1;
                                                    StatisticItem statisticItem142 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem142.param("tid", this.a.y0.i2());
                                                    statisticItem142.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem142.param("fid", this.a.y0.getForumId());
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091e43) {
                                                    }
                                                    statisticItem142.param("obj_name", i5);
                                                    statisticItem142.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.a.P() != null) {
                                                    }
                                                    if (this.a.G0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem142);
                                                    if (qi.D()) {
                                                    }
                                                }
                                            } else if (oi.z()) {
                                                this.a.G0.m0();
                                                if (this.a.G0.h.n() != null && view2 == this.a.G0.h.n().p() && !this.a.G0.R1()) {
                                                    this.a.G0.Q2();
                                                }
                                                if (!this.a.i) {
                                                    this.a.G7();
                                                    this.a.G0.u3();
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0909f4) {
                                                        G3 = this.a.y0.G3(true, this.a.A5());
                                                    } else {
                                                        G3 = view2.getId() == R.id.obfuscated_res_0x7f091bb4 ? this.a.y0.G3(false, this.a.A5()) : this.a.y0.F3(this.a.A5());
                                                    }
                                                    view2.setTag(Boolean.valueOf(G3));
                                                    if (G3) {
                                                        i7 = 1;
                                                        this.a.G0.e3(true);
                                                        this.a.G0.Z3();
                                                        this.a.i = true;
                                                        this.a.G0.i3(true);
                                                    } else {
                                                        i7 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                                } else {
                                                    view2.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                                                view2.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (oi.z()) {
                                            this.a.G0.m0();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0917be || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.d5(11009) || this.a.y0.g1(this.a.G0.Q0()) == null) {
                                                    return;
                                                }
                                                this.a.C6();
                                                if (this.a.y0.Q1() != null && this.a.y0.Q1().O() != null && this.a.y0.Q1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.y0.b).param("fid", this.a.y0.Q1().m()).param("obj_locate", 3).param("uid", this.a.y0.Q1().O().getAuthor().getUserId()));
                                                }
                                                if (this.a.y0.Q1().O() != null && this.a.y0.Q1().O().getAuthor() != null && this.a.y0.Q1().O().getAuthor().getUserId() != null && this.a.A0 != null) {
                                                    PbFragment pbFragment8 = this.a;
                                                    int W5 = pbFragment8.W5(pbFragment8.y0.Q1());
                                                    ThreadData O3 = this.a.y0.Q1().O();
                                                    if (O3.isBJHArticleThreadType()) {
                                                        i8 = 2;
                                                    } else if (O3.isBJHVideoThreadType()) {
                                                        i8 = 3;
                                                    } else if (O3.isBJHNormalThreadType()) {
                                                        i8 = 4;
                                                    } else {
                                                        i8 = O3.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.y0.b).param("obj_locate", 1).param("obj_id", this.a.y0.Q1().O().getAuthor().getUserId()).param("obj_type", !this.a.A0.e()).param("obj_source", W5).param("obj_param1", i8));
                                                }
                                            } else {
                                                this.a.V = view2;
                                                return;
                                            }
                                        } else {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.a.y0.Q1() != null && this.a.y0.Q1().O() != null && this.a.y0.Q1().O().isVideoThreadType() && this.a.y0.Q1().O().getThreadVideoInfo() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.a.y0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.a.y0.p1()) || this.a.y0.f1() == null) {
                                                this.a.a.finish();
                                                return;
                                            }
                                            name2 = this.a.y0.f1().b;
                                        } else {
                                            name2 = this.a.y0.Q1().l().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.a.a.finish();
                                            return;
                                        }
                                        String p12 = this.a.y0.p1();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.a.y0.v1() && p12 != null && p12.equals(name2)) {
                                            this.a.a.finish();
                                        } else {
                                            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (oi.z()) {
                                    if (this.a.y0.Q1() == null || this.a.B0.S()) {
                                        return;
                                    }
                                    this.a.G0.m0();
                                    int i13 = (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().t()) ? (this.a.G0.h.n() == null || view2 != this.a.G0.h.n().s()) ? view2 == this.a.G0.C0() ? 2 : 0 : this.a.y0.Q1().O().getIs_good() == 1 ? 3 : 6 : this.a.y0.Q1().O().getIs_top() == 1 ? 5 : 4;
                                    ForumData l = this.a.y0.Q1().l();
                                    String name3 = l.getName();
                                    String id2 = l.getId();
                                    String id3 = this.a.y0.Q1().O().getId();
                                    this.a.G0.i4();
                                    this.a.B0.W(id2, name3, id3, i13, this.a.G0.D0());
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                                    return;
                                }
                            } else {
                                this.a.G0.h.l();
                                if (this.a.y0 != null) {
                                    this.a.w1.f(this.a.y0.i2());
                                }
                                if (this.a.y0 == null || !this.a.y0.isPrivacy()) {
                                    this.a.w1.b();
                                    int i14 = (TbSingleton.getInstance().mCanCallFans || this.a.K() == null || this.a.K().Q1() == null || this.a.K().Q1().Q() == null || !this.a.K().Q1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.a.K() != null && this.a.K().Q1() != null) {
                                        this.a.w1.d(3, i14, this.a.K().Q1().Q());
                                    }
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0f0b);
                                    if (this.a.K() == null || this.a.K().Q1() == null) {
                                        return;
                                    }
                                    this.a.w1.d(3, 3, this.a.K().Q1().Q());
                                    return;
                                }
                            }
                        } else if (oi.z()) {
                            this.a.G0.m0();
                            this.a.G7();
                            this.a.G0.u3();
                            this.a.G0.P3();
                            if (this.a.G0.Z0() != null) {
                                this.a.G0.Z0().setVisibility(8);
                            }
                            this.a.y0.B3(1);
                            if (this.a.e != null) {
                                this.a.e.x();
                            }
                        } else {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                            return;
                        }
                    } else {
                        String str4 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a73);
                        String str5 = (String) view2.getTag(R.id.obfuscated_res_0x7f090a5e);
                        String str6 = (String) view2.getTag(R.id.obfuscated_res_0x7f09213a);
                        if (this.a.R != null) {
                            this.a.R.Q(str4, str5);
                        }
                        TbPageTag l2 = t95.l(this.a.getContext());
                        iz7.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l2 != null ? l2.locatePage : "");
                    }
                    if (this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dcd).equals(view2.getTag()) && view2.getId() == R.id.obfuscated_res_0x7f091ba7) {
                        String z52 = this.a.z5();
                        if (TextUtils.isEmpty(z52)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{z52});
                    }
                } else if (!this.a.t0) {
                    StatisticItem statisticItem15 = new StatisticItem("c13398");
                    statisticItem15.param("tid", this.a.y0.i2());
                    statisticItem15.param("fid", this.a.y0.getForumId());
                    statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem15.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem15);
                    SparseArray sparseArray18 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                    if (sparseArray18 != null && (sparseArray18.get(R.id.obfuscated_res_0x7f092002) instanceof Boolean) && ((Boolean) sparseArray18.get(R.id.obfuscated_res_0x7f092002)).booleanValue()) {
                        i08.o(2);
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
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091fe8);
                    if (!(obj instanceof PostData)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return;
                    }
                    PostData postData8 = (PostData) obj;
                    if (this.a.y0 != null && this.a.y0.Q1() != null && this.a.S5().a1() != null && postData8.s() != null && postData8.B() != 1) {
                        if (!this.a.checkUpIsLogin()) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        }
                        if (this.a.S5().b1() != null) {
                            this.a.S5().b1().c();
                        }
                        vt7 vt7Var2 = new vt7();
                        vt7Var2.A(this.a.y0.Q1().l());
                        vt7Var2.E(this.a.y0.Q1().O());
                        vt7Var2.C(postData8);
                        this.a.S5().a1().V(vt7Var2);
                        this.a.S5().a1().setPostId(postData8.K());
                        this.a.z6(view2, postData8.s().getUserId(), "", postData8);
                        TiebaStatic.log("c11743");
                        i08.b(this.a.y0.Q1(), postData8, postData8.b0, 8, 1);
                        if (this.a.V0 != null) {
                            this.a.G0.Y2(this.a.V0.C());
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l2 implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ ur4 b;
        public final /* synthetic */ PbFragment c;

        public l2(PbFragment pbFragment, MarkData markData, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, ur4Var};
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
            this.b = ur4Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.H7();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.a.y0.J3((UserPendantData) customResponsedMessage.getData());
                if (this.a.G0 != null && this.a.y0 != null) {
                    this.a.G0.J2(this.a.y0.Q1(), this.a.y0.g2(), this.a.y0.a2(), this.a.G0.i1());
                }
                if (this.a.G0 == null || this.a.G0.A0() == null) {
                    return;
                }
                this.a.G0.A0().a0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                        this.a.A7(num.intValue());
                    } else if (i == 1990055) {
                        TiebaStatic.log("c12142");
                        xt6.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c3c);
                        }
                        this.a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.z7((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ ur4 b;
        public final /* synthetic */ PbFragment c;

        public m2(PbFragment pbFragment, MarkData markData, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFragment, markData, ur4Var};
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
            this.b = ur4Var;
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
                    this.c.H7();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.a.G0 == null) {
                return;
            }
            if (booleanValue) {
                this.a.G0.Z3();
            } else {
                this.a.G0.u1();
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n1 implements i45 {
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

        @Override // com.repackage.i45
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n2 implements gg<ImageView> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
                    if (rn4.c().g()) {
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
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = rn4.c().g();
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
                this.a.G0.Y2(this.a.V0.C());
            }
            this.a.G0.H3(false);
        }
    }

    /* loaded from: classes3.dex */
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
                if (!oi.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c3d);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.Q1().l().getId(), this.a.y0.Q1().l().getName(), this.a.y0.Q1().O().getId(), String.valueOf(this.a.y0.Q1().V().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o1 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
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
                this.b.a.G0.C2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, az4Var, writeData, antiData}) == null) {
                if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0.Q1() != null) {
                        statisticItem.param("fid", this.a.y0.Q1().m());
                    }
                    statisticItem.param("tid", this.a.y0.i2());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (pi.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.G7();
                this.a.G0.s3(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (this.a.E0 != null) {
                    this.a.E0.L(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
                    rg.a().postDelayed(this.a.Y1, 300000L);
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
                        if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f047b), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        ur4 ur4Var = new ur4(this.a.getActivity());
                        if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                            ur4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cf3));
                        } else {
                            ur4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new b(this));
                        ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf5, new c(this));
                        ur4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    } else if (ur8.d(i) || az4Var != null || i == 227001) {
                        return;
                    } else {
                        this.a.l7(i, antiData, str);
                        return;
                    }
                }
                this.a.z7(postWriteCallBackData);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.m7(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.y0.t1()) {
                        ft7 Q1 = this.a.y0.Q1();
                        if (Q1 != null && Q1.O() != null && Q1.O().getAuthor() != null && (userId = Q1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.y0.E3()) {
                            this.a.G0.u3();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.y0.E3()) {
                        this.a.G0.u3();
                    }
                } else if (floor != null) {
                    this.a.G0.F1(this.a.y0.Q1());
                }
                if (this.a.y0.x1()) {
                    TiebaStatic.log(new StatisticItem("c10369").param("tid", this.a.y0.i2()));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    rg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                PbFragment pbFragment = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                pbFragment.Z4(z2);
                if (writeData != null) {
                    nw4.b(writeData.getContent(), "1");
                }
                if (this.a.m6()) {
                    this.a.J7();
                }
                this.a.x7();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o2 implements gg<GifView> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
                if (rn4.c().g()) {
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
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = rn4.c().g();
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
            ls7 ls7Var = (ls7) customResponsedMessage.getData();
            int type = ls7Var.getType();
            if (type == 0) {
                this.a.T6((vt7) ls7Var.a());
            } else if (type == 1) {
                this.a.s5((ForumManageModel.b) ls7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (ls7Var.a() == null) {
                    this.a.S6(false, null);
                } else {
                    this.a.S6(true, (MarkData) ls7Var.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p0 implements is7.d {
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

        @Override // com.repackage.is7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p1 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
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
                this.b.a.G0.C2(this.a.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, az4Var, writeData, antiData}) == null) {
                if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0 != null && this.a.y0.Q1() != null) {
                        statisticItem.param("fid", this.a.y0.Q1().m());
                    }
                    if (this.a.y0 != null) {
                        statisticItem.param("tid", this.a.y0.i2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    if (this.a.H5()) {
                        this.a.d7(false);
                        ks7.e(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1208));
                    }
                    qx7 qx7Var = this.a.K0;
                    if (qx7Var != null) {
                        qx7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        l05.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (writeData != null) {
                        nw4.b(writeData.getContent(), "4");
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        rg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.m6()) {
                        this.a.J7();
                    }
                    this.a.x7();
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
                    if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f047b), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    ur4 ur4Var = new ur4(this.a.getActivity());
                    if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                        ur4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cf3));
                    } else {
                        ur4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new b(this));
                    ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf5, new c(this));
                    ur4Var.create(this.a.getPageContext()).show();
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

    /* loaded from: classes3.dex */
    public class p2 implements gg<TiebaPlusRecommendCard> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.p();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
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

    /* loaded from: classes3.dex */
    public class q0 implements hu7.a {
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

        @Override // com.repackage.hu7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    if (view2 != null) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f091bd2) {
                            if (this.a.X6(view2)) {
                                return true;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d2) {
                            if (view2.getTag(R.id.obfuscated_res_0x7f091ffb) instanceof SparseArray) {
                                this.a.E7((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091ffb));
                            }
                        } else if (!(view2 instanceof TbRichTextView) && view2.getId() != R.id.obfuscated_res_0x7f09182c) {
                            if (this.a.G0.M1() && view2.getId() == R.id.obfuscated_res_0x7f0917f1) {
                                if (view2.getTag(R.id.obfuscated_res_0x7f09203d) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view2.getTag(R.id.obfuscated_res_0x7f09203d)));
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
                            this.a.E7(sparseArray);
                        }
                    }
                    if (this.a.V0 != null) {
                        this.a.G0.Y2(this.a.V0.C());
                    }
                    this.a.G0.Q2();
                    this.a.G0.m0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
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

    /* loaded from: classes3.dex */
    public class q1 extends ab {
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

        @Override // com.repackage.ab
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView k1;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.a.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    qi.N(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f13c6);
                    if (this.a.G0 == null || (k1 = this.a.G0.k1()) == null || this.a.G0.R0() == null) {
                        return;
                    }
                    this.a.G0.R0().removeHeaderView(k1);
                    return;
                }
                qi.O(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q2 implements gg<View> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gi5.a)) {
                gi5.a aVar = (gi5.a) customResponsedMessage.getData();
                gi5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (message.what == 2 && this.a.y0 != null && this.a.y0.B1()) {
                    this.a.A6();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class r1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes3.dex */
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
                iv4 iv4Var = new iv4();
                iv4Var.b = R.raw.obfuscated_res_0x7f110027;
                iv4Var.a = BreatheTipWidget.PointType.LOTTIE;
                iv4Var.c = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds130);
                jv4 jv4Var = new jv4();
                jv4Var.a = this.a.a.getString(R.string.obfuscated_res_0x7f0f04fa);
                jv4Var.b = this.a.a.getString(R.string.obfuscated_res_0x7f0f00e9);
                jv4Var.e = R.drawable.pic_guidecard;
                jv4Var.f = qi.f(this.a.a.getContext(), R.dimen.tbds156);
                jv4Var.g = qi.f(this.a.a.getContext(), R.dimen.tbds489);
                jv4Var.h = qi.f(this.a.a.getContext(), R.dimen.tbds286);
                if (this.a.a.a.findViewById(this.a.a.G0.g1()) == null) {
                    return;
                }
                BreatheTipWidget breatheTipWidget = new BreatheTipWidget(this.a.a.getContext());
                breatheTipWidget.g(this.a.a.a.findViewById(this.a.a.G0.g1()));
                breatheTipWidget.f(jv4Var, iv4Var);
                if (breatheTipWidget.h((Activity) this.a.a.getContext())) {
                    ru4 k = ru4.k();
                    k.u("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), true);
                    h05.a("c14828");
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
                oa5 oa5Var = new oa5(i, z, responsedMessage, this.a.r, this.a.q, this.a.o, z2, 0L, 0L, j3);
                this.a.q = 0L;
                this.a.r = 0L;
                oa5Var.c();
                if (z2) {
                    j2 = j3;
                    oa5Var.B = j2;
                    oa5Var.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || this.a.y0 == null || this.a.y0.Q1() == null || this.a.y0.Q1().O() == null) {
                    return;
                }
                int threadType = this.a.y0.Q1().O().getThreadType();
                if (threadType == 0 || threadType == 40) {
                    if (!StringHelper.equals(this.a.M, "from_personalize")) {
                        if (StringHelper.equals(this.a.M, "from_frs")) {
                            oa5 oa5Var2 = new oa5();
                            oa5Var2.a(1000);
                            oa5Var2.D = j2;
                            oa5Var2.d(threadType);
                            return;
                        }
                        return;
                    }
                    ka5 ka5Var = new ka5();
                    ka5Var.F = 1;
                    ka5Var.a(1005);
                    ka5Var.D = j2;
                    ka5Var.d(threadType);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(ft7 ft7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ft7Var) == null) {
                this.a.G0.F1(ft7Var);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, ft7 ft7Var, String str, int i4) {
            o25 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ft7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906bd));
                }
                if (!z || ft7Var == null || ft7Var.X() != null || ListUtils.getCount(ft7Var.F()) >= 1) {
                    if (!this.a.h0) {
                        this.a.h0 = true;
                    } else if (this.a.K() != null) {
                        this.a.K().X0();
                    }
                    this.a.h = true;
                    if (this.a.G0 == null) {
                        return;
                    }
                    this.a.G0.t3();
                    if (ft7Var == null || !ft7Var.p0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.G0.m1());
                    }
                    this.a.G0.u1();
                    if (this.a.J || this.a.G0.R1()) {
                        this.a.G0.o1();
                    } else if (!this.a.G0.K1()) {
                        this.a.G0.H3(false);
                    }
                    if (this.a.i) {
                        this.a.i = false;
                    }
                    if (i4 == 0 && ft7Var != null) {
                        this.a.O0 = true;
                    }
                    if (ft7Var != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.G0.m1());
                        this.a.G0.C3();
                    }
                    ArrayList<PostData> arrayList = null;
                    String e1 = null;
                    arrayList = null;
                    if (z && ft7Var != null) {
                        ThreadData O = ft7Var.O();
                        if (O != null && O.isUgcThreadType()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.g7(pbFragment3.U0);
                        }
                        this.a.G0.b1().m(ft7Var);
                        this.a.G0.O3();
                        if (O != null && O.getCartoonThreadData() != null) {
                            this.a.N7(O.getCartoonThreadData());
                        }
                        if (this.a.V0 != null) {
                            this.a.G0.Y2(this.a.V0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(ft7Var.V().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(ft7Var.V().getBimg_end_time());
                        if (ft7Var.F() != null && ft7Var.F().size() >= 1 && ft7Var.F().get(0) != null) {
                            this.a.y0.n3(ft7Var.F().get(0).K());
                        } else if (ft7Var.X() != null) {
                            this.a.y0.n3(ft7Var.X().K());
                        }
                        if (this.a.V0 != null) {
                            this.a.V0.N(ft7Var.d());
                            this.a.V0.O(ft7Var.l(), ft7Var.V());
                            this.a.V0.u0(O);
                            this.a.V0.P(this.a.y0.s1(), this.a.y0.i2(), this.a.y0.o1());
                            if (O != null) {
                                this.a.V0.j0(O.isMutiForumThread());
                            }
                        }
                        if (this.a.A0 != null) {
                            this.a.A0.h(ft7Var.r());
                        }
                        if (ft7Var.s() == 1) {
                            this.a.s = true;
                        } else {
                            this.a.s = false;
                        }
                        if (ft7Var.i0()) {
                            this.a.s = true;
                        }
                        this.a.G0.Z2(this.a.s);
                        if (this.a.v0.f.size() > 0) {
                            ft7Var.O0(this.a.v0.f);
                        }
                        this.a.G0.S3(ft7Var, i2, i3, this.a.y0.g2(), i4, this.a.y0.z1());
                        this.a.G0.g4(ft7Var, this.a.y0.g2());
                        this.a.G0.l4(this.a.y0.t1());
                        AntiData d = ft7Var.d();
                        if (d != null) {
                            this.a.z = d.getVoice_message();
                            if (!StringUtils.isNull(this.a.z) && this.a.V0 != null && this.a.V0.a() != null && (m = this.a.V0.a().m(6)) != null && !TextUtils.isEmpty(this.a.z)) {
                                ((View) m).setOnClickListener(this.a.J1);
                            }
                        }
                        if (!this.a.Y && !ListUtils.isEmpty(this.a.y0.Q1().F()) && !this.a.y0.z2()) {
                            this.a.Y = true;
                            this.a.b5(false);
                        }
                        if (TextUtils.isEmpty(this.a.R0)) {
                            if (this.a.Q0) {
                                this.a.Q0 = false;
                                iy7.g(this.a.getListView());
                            } else if (this.a.S0) {
                                this.a.S0 = false;
                                iy7.j(this.a.getListView());
                            } else if (!TextUtils.isEmpty(this.a.y0.G1())) {
                                iy7.f(this.a.getListView(), this.a.y0.G1());
                                this.a.y0.H2();
                            } else {
                                this.a.G0.N3();
                            }
                        } else {
                            iy7.i(this.a.y0.P1(), this.a.getListView(), this.a.R0);
                            this.a.R0 = null;
                        }
                        this.a.y0.I2(ft7Var.l(), this.a.N1);
                        this.a.y0.O2(this.a.Q1);
                        if (this.a.Y0 != null && O != null && O.getAuthor() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.getAuthor());
                            this.a.Y0.setLikeUserData(attentionHostData);
                        }
                        if (this.a.y0 == null || !this.a.y0.w2()) {
                            if (this.a.G0 != null) {
                                e1 = this.a.G0.e1();
                            }
                        } else {
                            e1 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dec);
                        }
                        if (!StringUtils.isNull(e1)) {
                            this.a.V0.m0(TbSingleton.getInstance().getAdVertiComment(ft7Var.n0(), ft7Var.o0(), e1));
                        }
                    } else if (str != null) {
                        if (this.a.O0 || i4 != 1) {
                            this.a.showToast(str);
                        } else if (i2 == 3 || i2 == 4 || i2 == 6) {
                            if (i == 4) {
                                if (this.a.y0.f1() != null && !StringUtils.isNull(this.a.y0.f1().c)) {
                                    this.a.G0.n4(this.a.y0.f1());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.G0.m1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c3b, str, Integer.valueOf(i)), true);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(qi.f(pbFragment5.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.G0.m1(), this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c3b, str, Integer.valueOf(i)), true);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(qi.f(pbFragment7.getContext(), R.dimen.obfuscated_res_0x7f0702aa));
                            }
                            this.a.G0.o1();
                            this.a.G0.n1();
                        }
                        if (i == 4 || i == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.y0.i2());
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
                            if (this.a.y0 != null && this.a.y0.Q1() != null) {
                                arrayList = this.a.y0.Q1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).B() != 1)) {
                                this.a.G0.U2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09eb));
                            } else {
                                if (this.a.o6()) {
                                    this.a.G0.V2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ddd));
                                } else {
                                    this.a.G0.V2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dde));
                                }
                                this.a.G0.F1(this.a.y0.Q1());
                            }
                        } else {
                            this.a.G0.U2("");
                        }
                        this.a.G0.u0();
                    }
                    if (ft7Var != null && ft7Var.m && this.a.o == 0) {
                        this.a.o = System.currentTimeMillis() - this.a.n;
                    }
                    if (!this.a.K().g2() || this.a.K().Q1().y().c() != 0 || this.a.K().t2()) {
                        this.a.W0 = true;
                    }
                    if (this.a.a instanceof PbActivity) {
                        ((PbActivity) this.a.a).u1(ft7Var != null ? ft7Var.g() : 0, this.a.G0);
                    }
                    e();
                    return;
                }
                this.a.y0.B3(1);
                if (this.a.e != null) {
                    this.a.e.x();
                }
                if (this.a.G0 != null) {
                    this.a.G0.a4();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.y0 == null) {
                return;
            }
            if (this.a.V0 == null || !this.a.V0.v) {
                j45 j45Var = new j45();
                this.a.g7(j45Var);
                PbFragment pbFragment = this.a;
                pbFragment.V0 = (k45) j45Var.a(pbFragment.getContext());
                this.a.V0.f0(this.a.a.getPageContext());
                this.a.V0.p0(this.a.m2);
                this.a.V0.q0(this.a.c1);
                this.a.V0.F(this.a.a.getPageContext(), this.a.a.getIntent() == null ? null : this.a.a.getIntent().getExtras());
                this.a.V0.a().C(true);
                this.a.G0.T2(this.a.V0.a());
                if (!this.a.y0.D1()) {
                    this.a.V0.s(this.a.y0.i2());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.a.V0.m0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.a.y0.w2()) {
                    this.a.V0.m0(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dec));
                } else if (this.a.G0 != null) {
                    this.a.V0.m0(this.a.G0.e1());
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                ru4 k = ru4.k();
                if (k.h("key_pb_double_click_agree_" + TbadkCoreApplication.getCurrentAccount(), false)) {
                    return;
                }
                rg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r2 implements gg<RelativeLayout> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
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
            this.a.D7();
        }
    }

    /* loaded from: classes3.dex */
    public class s0 implements wr4.c {
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

        @Override // com.repackage.wr4.c
        public void a(wr4 wr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wr4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.N0 = pbFragment.N0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.N0);
                    new qv7(this.a.y0.i2(), this.a.N0, "1").start();
                    wr4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.N0 = pbFragment2.N0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.N0);
                    new qv7(this.a.y0.i2(), this.a.N0, "2").start();
                    wr4Var.e();
                } else if (i == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.N0 = pbFragment3.N0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.N0);
                    wr4Var.e();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.M7();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class s2 implements gg<ItemCardView> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
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
                bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0cc2));
                bdTopToast.i((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
                            bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0322));
                            bdTopToast.i((ViewGroup) this.a.getView());
                            this.a.h7(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c3c) : httpResponsedMessage.getErrorString();
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.h(false);
                        bdTopToast2.g(string);
                        bdTopToast2.i((ViewGroup) this.a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            vv7 A0;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.G0.i2((TbRichText) view2.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.y0.i2());
                    statisticItem.param("fid", this.a.y0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view2.getTag(R.id.obfuscated_res_0x7f092024) == null || !(view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
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
                            builder.G(this.a.y0.b2());
                            builder.x(concurrentHashMap);
                            builder.I(true);
                            builder.L(false);
                            builder.H(this.a.o6());
                            builder.N(rect, UtilHelper.fixedDrawableRect(rect, view2));
                            if (this.a.y0 != null) {
                                builder.B(this.a.y0.getFromForumId());
                                if (this.a.y0.Q1() != null) {
                                    builder.O(this.a.y0.Q1().O());
                                }
                            }
                            ImageViewerConfig w = builder.w(this.a.getPageContext().getPageActivity());
                            w.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, w));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.M6(str, i, eVar);
                        if (eVar.h) {
                            TbRichText P7 = this.a.P7(str, i);
                            if (P7 != null && this.a.B2 >= 0 && this.a.B2 < P7.B().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = gt7.a(P7.B().get(this.a.B2));
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
                                if (P7.getPostId() != 0 && (A0 = this.a.G0.A0()) != null) {
                                    ArrayList<on> t = A0.t();
                                    if (ListUtils.getCount(t) > 0) {
                                        Iterator<on> it = t.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            on next = it.next();
                                            if ((next instanceof PostData) && P7.getPostId() == og.g(((PostData) next).K(), 0L)) {
                                                i08.b(this.a.y0.Q1(), (PostData) next, ((PostData) next).b0, P7.getPostId() == og.g(this.a.y0.o1(), 0L) ? 1 : 8, 3);
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
                                builder2.G(this.a.y0.b2());
                                builder2.x(concurrentHashMap2);
                                builder2.L(false);
                                builder2.H(this.a.o6());
                                builder2.M(eVar.f);
                                builder2.N(rect2, UtilHelper.fixedDrawableRect(rect2, view2));
                                if (this.a.y0 != null) {
                                    builder2.B(this.a.y0.getFromForumId());
                                    if (this.a.y0.Q1() != null) {
                                        builder2.O(this.a.y0.Q1().O());
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
                        builder3.G(this.a.y0.b2());
                        builder3.x(concurrentHashMap3);
                        builder3.L(false);
                        builder3.H(this.a.o6());
                        builder3.M(eVar.f);
                        builder3.E(false);
                        if (this.a.y0 != null) {
                            builder3.B(this.a.y0.getFromForumId());
                            if (this.a.y0.Q1() != null) {
                                builder3.O(this.a.y0.Q1().O());
                            }
                        }
                        ImageViewerConfig w3 = builder3.w(this.a.getPageContext().getPageActivity());
                        w3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, w3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
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
                        this.a.C6();
                    }
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                this.a.G0.s1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                ft7 Q1 = this.a.y0.Q1();
                if (Q1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    Q1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.c(this.a.h1.getResources().getString(R.string.obfuscated_res_0x7f0f0b34));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.h1.getResources().getString(R.string.obfuscated_res_0x7f0f0b30);
                    }
                    this.a.B7(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.u7();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (pi.isEmpty(errorString2)) {
                        errorString2 = this.a.h1.getResources().getString(R.string.obfuscated_res_0x7f0f0b31);
                    }
                    this.a.i1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u1 implements bm4.a {
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

        @Override // com.repackage.bm4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.G0.t3();
                if (z) {
                    if (this.a.A0 != null) {
                        this.a.A0.h(z2);
                    }
                    this.a.y0.D3(z2);
                    if (this.a.y0.B1()) {
                        this.a.A6();
                    } else {
                        this.a.G0.F1(this.a.y0.Q1());
                    }
                    if (z2) {
                        boolean m0 = this.a.y0.Q1().m0();
                        if (this.a.A0 != null && !m0) {
                            if (this.a.A0.f() == null || this.a.y0 == null || this.a.y0.Q1() == null || this.a.y0.Q1().O() == null || this.a.y0.Q1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.A0.f();
                            MetaData author = this.a.y0.Q1().O().getAuthor();
                            if (f != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.t7(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d1);
                                    this.a.y7();
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
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fd1));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14c0));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    hw7 b1 = this.a.G0.b1();
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                this.a.G0.s1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.i1.c(this.a.h1.getResources().getString(R.string.obfuscated_res_0x7f0f1499));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (pi.isEmpty(muteMessage)) {
                    muteMessage = this.a.h1.getResources().getString(R.string.obfuscated_res_0x7f0f1498);
                }
                this.a.i1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v1 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v2 implements wr4.c {
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

        @Override // com.repackage.wr4.c
        public void a(wr4 wr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wr4Var, i, view2) == null) {
                if (wr4Var != null) {
                    wr4Var.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.E2;
                if (postData != null) {
                    if (i == 0) {
                        postData.B0();
                        this.a.E2 = null;
                    } else if (i == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.E6(pbFragment2.E2);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.a.m6() || this.a.a == null || this.a.a.b1() == null || !str.equals(this.a.a.b1().getTopicId())) {
                    return;
                }
                this.a.K7(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w1 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                ur4Var.dismiss();
                this.b.C0.l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.getPageContext().getUniqueId(), this.b.y0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w2 implements wr4.c {
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

        @Override // com.repackage.wr4.c
        public void a(wr4 wr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wr4Var, i, view2) == null) {
                if (wr4Var != null) {
                    wr4Var.e();
                }
                if (this.a.m1 == null || TextUtils.isEmpty(this.a.n1)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.p1 == null) {
                        this.a.Y4();
                    } else {
                        j55.a aVar = new j55.a();
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
                        pbFragment.l1 = new sx7(pbFragment.getPageContext());
                    }
                    this.a.l1.b(this.a.n1, this.a.m1.n());
                }
                this.a.m1 = null;
                this.a.n1 = null;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pp4)) {
                pp4 pp4Var = (pp4) customResponsedMessage.getData();
                iq4.a aVar = new iq4.a();
                int i = pp4Var.a;
                String str = pp4Var.b;
                aVar.a = pp4Var.d;
                ft7 Q1 = this.a.y0.Q1();
                if (Q1 == null) {
                    return;
                }
                if (this.a.y0.s1() != null && this.a.y0.s1().getUserIdLong() == pp4Var.p) {
                    this.a.G0.I2(pp4Var.l, this.a.y0.Q1(), this.a.y0.g2(), this.a.y0.a2());
                }
                if (Q1.F() == null || Q1.F().size() < 1 || Q1.F().get(0) == null) {
                    return;
                }
                long g = og.g(Q1.F().get(0).K(), 0L);
                long g2 = og.g(this.a.y0.i2(), 0L);
                if (g == pp4Var.n && g2 == pp4Var.m) {
                    iq4 I = Q1.F().get(0).I();
                    if (I == null) {
                        I = new iq4();
                    }
                    ArrayList<iq4.a> a = I.a();
                    if (a == null) {
                        a = new ArrayList<>();
                    }
                    a.add(0, aVar);
                    I.e(I.b() + pp4Var.l);
                    I.d(a);
                    Q1.F().get(0).G0(I);
                    this.a.G0.A0().a0();
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof xr8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.j1) {
                xr8 xr8Var = (xr8) customResponsedMessage.getData();
                this.a.G0.s1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.g1;
                DataRes dataRes = xr8Var.a;
                if (xr8Var.c == 0 && dataRes != null) {
                    int e = og.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (pi.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f09203e, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f09203e, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ffb)).intValue();
                if (intValue == 0) {
                    this.a.v7(r3, sparseArray);
                } else if (intValue == 1) {
                    this.a.G0.y2(sparseArray, r3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) || this.a.y0 == null || this.a.y0.Q1() == null || this.a.G0 == null || this.a.G0.A0() == null) {
                return;
            }
            this.a.G0.r2(absListView, i, i2, i3);
            if (this.a.e != null) {
                this.a.e.q(absListView, i, i2, i3);
            }
            if (!this.a.y0.A2() || (F = this.a.y0.Q1().F()) == null || F.isEmpty()) {
                return;
            }
            int w = ((i + i2) - this.a.G0.A0().w()) - 1;
            ft7 Q1 = this.a.y0.Q1();
            if (Q1 == null) {
                return;
            }
            if (Q1.D() != null && Q1.D().i1()) {
                w--;
            }
            if (Q1.E() != null && Q1.E().i1()) {
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
                            this.a.G0.Y2(this.a.V0.C());
                        }
                        if (!this.a.J) {
                            this.a.s0 = true;
                            this.a.G0.Q2();
                        }
                    }
                    if (!this.a.t) {
                        this.a.t = true;
                    }
                }
                if (this.a.G0 != null) {
                    this.a.G0.s2(absListView, i);
                }
                if (this.a.e != null) {
                    this.a.e.r(absListView, i);
                }
                if (this.a.u == null) {
                    this.a.u = new ia5();
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
                    this.a.a7(false, null);
                    dj8.g().h(this.a.getUniqueId(), true);
                    this.a.b5(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.y0 == null || this.a.y0.Z1() == i + 1) {
                return;
            }
            PbFragment pbFragment = this.a;
            pbFragment.c7(pbFragment.Q5(i));
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.y0 == null || this.a.y0.Q1() == null) {
                return;
            }
            this.a.y0.Q1().a();
            this.a.y0.r2();
            if (this.a.G0.A0() != null) {
                this.a.G0.F1(this.a.y0.Q1());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class y1 implements h45 {
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

        @Override // com.repackage.h45
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qx7 qx7Var = this.a.K0;
                if (qx7Var == null || qx7Var.e() == null || !this.a.K0.e().d()) {
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.y0 == null || this.a.y0.Q1() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.a.l5(str);
            this.a.y0.r2();
            if (!TextUtils.isEmpty(str) && this.a.y0.Q1().F() != null) {
                ArrayList<PostData> F = this.a.y0.Q1().F();
                bl8 bl8Var = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof bl8) {
                        bl8 bl8Var2 = (bl8) next;
                        if (str.equals(bl8Var2.j1())) {
                            bl8Var = bl8Var2;
                            break;
                        }
                    }
                }
                if (bl8Var != null) {
                    F.remove(bl8Var);
                    if (this.a.G0.A0() != null && this.a.G0.A0().t() != null) {
                        this.a.G0.A0().t().remove(bl8Var);
                    }
                    if (this.a.G0.R0() != null && this.a.G0.R0().getData() != null) {
                        this.a.G0.R0().getData().remove(bl8Var);
                    }
                    if (this.a.G0.A0() != null) {
                        this.a.G0.A0().a0();
                        return;
                    }
                }
            }
            if (this.a.G0.A0() != null) {
                this.a.G0.F1(this.a.y0.Q1());
            }
        }
    }

    /* loaded from: classes3.dex */
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
            sk8 sk8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof sk8) || (sk8Var = (sk8) customResponsedMessage.getData()) == null || (agreeData = sk8Var.b) == null) {
                return;
            }
            if (this.a.G0 != null) {
                this.a.G0.e2(sk8Var);
            }
            if (agreeData.agreeType != 2 || this.a.G0 == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || hz7.k(this.a.y0.b)) {
                return;
            }
            this.a.G0.c4();
            hz7.b(this.a.y0.b);
        }
    }

    /* loaded from: classes3.dex */
    public class z1 implements Comparator<z05> {
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
        public int compare(z05 z05Var, z05 z05Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, z05Var, z05Var2)) == null) ? z05Var.compareTo(z05Var2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
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
        this.X1 = new hu7(new q0(this));
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

    public static PbFragment G6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public final String A5() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.Q1() == null || this.y0.Q1().F() == null || (count = ListUtils.getCount((F = this.y0.Q1().F()))) == 0) {
                return "";
            }
            if (this.y0.b2()) {
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
                if (this.y0.G2(postData.s().getUserId())) {
                    return postData.K();
                }
                for (int i4 = H0 - 1; i4 != 0; i4--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i4);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (this.y0.G2(postData2.s().getUserId())) {
                        return postData2.K();
                    }
                }
                for (int i5 = H0 + 1; i5 < count; i5++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i5);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (this.y0.G2(postData3.s().getUserId())) {
                        return postData3.K();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void A6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ft7 Q1 = this.y0.Q1();
            this.y0.D3(true);
            bm4 bm4Var = this.A0;
            if (bm4Var != null) {
                Q1.H0(bm4Var.g());
            }
            this.G0.F1(Q1);
        }
    }

    public final void A7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i4) == null) {
            hz7.o(this, w5(), i4);
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
                                    int h4 = (int) qi.h(TbadkCoreApplication.getInst());
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

    public void B6() {
        nx7 nx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (nx7Var = this.G0) == null) {
            return;
        }
        nx7Var.b2();
    }

    public final void B7(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str == null) {
                str = "";
            }
            d9 d9Var = this.h1;
            if (d9Var == null) {
                return;
            }
            ur4 ur4Var = new ur4(d9Var.getPageActivity());
            ur4Var.setMessage(str);
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09a0, new e(this));
            ur4Var.create(this.h1).show();
        }
    }

    @Override // com.repackage.ji5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            nx7 nx7Var = this.G0;
            if (nx7Var == null) {
                return 0;
            }
            return nx7Var.g1();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.t08
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
                        int h4 = (int) qi.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * h4;
                        int height = tbRichTextData.F().getHeight() * h4;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.F().H()) {
                            if (tbRichText == tbRichText2) {
                                if (i7 <= i5) {
                                    i6--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a4 = gt7.a(tbRichTextData);
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
                                    imageUrlData.threadId = og.g(this.y0.i2(), -1L);
                                    imageUrlData.mIsReserver = this.y0.b2();
                                    imageUrlData.mIsSeeHost = this.y0.t1();
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

    public final void C6() {
        MarkData g12;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.A0 == null) {
            return;
        }
        if (this.y0.Q1() != null && this.y0.Q1().i0()) {
            g12 = this.y0.g1(0);
        } else {
            g12 = this.y0.g1(this.G0.Q0());
        }
        if (g12 == null) {
            return;
        }
        if (g12.isApp() && (g12 = this.y0.g1(this.G0.Q0() + 1)) == null) {
            return;
        }
        this.G0.u3();
        this.A0.i(g12);
        if (!this.A0.e()) {
            if (this.G0 != null && this.y0 != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !hz7.k(this.y0.b)) {
                this.G0.c4();
                hz7.b(this.y0.b);
            }
            this.A0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.A0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final void C7(boolean z3, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z3), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z3) {
                this.G0.P3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            ur4 ur4Var = new ur4(this.h1.getPageActivity());
            if (pi.isEmpty(str)) {
                ur4Var.setMessage(this.h1.getResources().getString(R.string.obfuscated_res_0x7f0f031e, str3));
            } else {
                ur4Var.setMessage(str);
            }
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0431, new f(this, userMuteAddAndDelCustomMessage));
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new g(this));
            ur4Var.create(this.h1).show();
        }
    }

    public PbInterviewStatusView.f D5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.w0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public final void D6(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e4) {
                e4.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8)) == null) {
                return;
            }
            E6(postData);
        }
    }

    public final void D7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbModel = this.y0) == null || pi.isEmpty(pbModel.i2())) {
            return;
        }
        dj4.w().P(cj4.Z, og.g(this.y0.i2(), 0L));
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

    public void E6(PostData postData) {
        PostData x5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.K() != null && postData.K().equals(this.y0.L1())) {
            z3 = true;
        }
        MarkData K1 = this.y0.K1(postData);
        if (this.y0.Q1() != null && this.y0.Q1().i0() && (x5 = x5()) != null) {
            K1 = this.y0.K1(x5);
        }
        if (K1 == null) {
            return;
        }
        this.G0.u3();
        bm4 bm4Var = this.A0;
        if (bm4Var != null) {
            bm4Var.i(K1);
            if (!z3) {
                this.A0.a();
            } else {
                this.A0.d();
            }
        }
    }

    public final void E7(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f091fe8) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8)) != null) {
            F7(postData, false);
        }
    }

    @Override // com.repackage.ji5
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

    public final boolean F6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q3 = ru4.k().q("bubble_link", "");
                if (StringUtils.isNull(q3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    jm4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f053d), q3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void F7(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, postData, z3) == null) {
            d7(false);
            if (postData == null || (pbModel = this.y0) == null || pbModel.Q1() == null || postData.B() == 1) {
                return;
            }
            String i22 = this.y0.i2();
            String K = postData.K();
            int W = this.y0.Q1() != null ? this.y0.Q1().W() : 0;
            AbsPbActivity.e O6 = O6(K);
            if (O6 == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(i22, K, "pb", true, false, null, false, null, W, postData.b0(), this.y0.Q1().d(), false, postData.s() != null ? postData.s().getIconInfo() : null, 5).addBigImageData(O6.a, O6.b, O6.g, O6.j);
            addBigImageData.setKeyPageStartFrom(this.y0.P1());
            addBigImageData.setFromFrsForumId(this.y0.getFromForumId());
            addBigImageData.setWorksInfoData(this.y0.n2());
            addBigImageData.setKeyFromForumId(this.y0.getForumId());
            addBigImageData.setBjhData(this.y0.i1());
            addBigImageData.setIsOpenEditor(z3);
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public fg<TbImageView> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.B == null) {
                this.B = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.B;
        }
        return (fg) invokeV.objValue;
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

    public final void G7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
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

    @Override // com.repackage.ji5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, str) == null) {
            tx7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.w = true;
        }
    }

    public boolean H5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.n2.booleanValue() : invokeV.booleanValue;
    }

    public void H6() {
        List<g3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (list = this.t1) == null || list.isEmpty()) {
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

    public final void H7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.q1();
    }

    public boolean I5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.K : invokeV.booleanValue;
    }

    public boolean I6(int i4, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        nx7 nx7Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i4, keyEvent)) == null) ? (keyEvent == null || (nx7Var = this.G0) == null || !nx7Var.j2(i4)) ? false : true : invokeIL.booleanValue;
    }

    public final boolean I7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.Q1() == null || !this.y0.Q1().i0()) {
                if (this.y0.B1()) {
                    MarkData m12 = this.y0.m1();
                    if (m12 != null && this.y0.z1()) {
                        MarkData g12 = this.y0.g1(this.G0.H0());
                        if (g12 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", m12);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (g12.getPostId() != null && !g12.getPostId().equals(m12.getPostId())) {
                            ur4 ur4Var = new ur4(getPageContext().getPageActivity());
                            ur4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0264));
                            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0431, new k2(this, g12, m12, ur4Var));
                            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new l2(this, m12, ur4Var));
                            ur4Var.setOnCalcelListener(new m2(this, m12, ur4Var));
                            ur4Var.create(getPageContext());
                            ur4Var.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", m12);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.y0.Q1() != null && this.y0.Q1().F() != null && this.y0.Q1().F().size() > 0 && this.y0.z1()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ji5
    /* renamed from: J5 */
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            nx7 nx7Var = this.G0;
            if (nx7Var == null) {
                return null;
            }
            return nx7Var.R0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public final void J6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (!oi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c3d);
                return;
            }
            this.G0.m0();
            if (this.i) {
                return;
            }
            G7();
            this.G0.u3();
            if (this.y0.loadData()) {
                this.G0.Z3();
            }
        }
    }

    public final void J7() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (absPbActivity = this.a) == null || absPbActivity.b1() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.b1().i2()).param("topic_id", this.a.b1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.b1().m2()));
    }

    @Override // com.repackage.t08
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

    public void K6() {
        PbModel pbModel;
        ft7 Q1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (pbModel = this.y0) == null || pbModel.Q1() == null || (O = (Q1 = this.y0.Q1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.G0.q1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        ww7 ww7Var = new ww7();
        int W = this.y0.Q1().W();
        if (W != 1 && W != 3) {
            ww7Var.g = false;
        } else {
            ww7Var.g = true;
            ww7Var.s = O.getIs_top() == 1;
        }
        if (q6(W)) {
            ww7Var.h = true;
            ww7Var.r = O.getIs_good() == 1;
        } else {
            ww7Var.h = false;
        }
        if (W == 1002 && !equals) {
            ww7Var.u = true;
        }
        ww7Var.n = r7(O.isBlocked(), Q1.k0(), equals, W, O.isWorksInfo(), O.isScoreThread());
        ww7Var.e = p7(equals, Q1.k0());
        ww7Var.i = s7();
        ww7Var.f = q7(equals);
        ww7Var.k = equals && Q1.V() != null && Q1.V().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            ww7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        ww7Var.t = equals;
        ww7Var.q = this.y0.g2();
        ww7Var.b = true;
        ww7Var.a = t6(equals);
        if (equals) {
            this.G0.G1();
        }
        ww7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        ww7Var.j = true;
        ww7Var.o = this.y0.t1();
        ww7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            ww7Var.c = true;
        } else {
            ww7Var.c = false;
        }
        if (Q1.i0()) {
            ww7Var.b = false;
            ww7Var.d = false;
            ww7Var.c = false;
            ww7Var.g = false;
            ww7Var.h = false;
        }
        ww7Var.v = TbSingleton.getInstance().mShowCallFans && equals && !Q1.i0();
        nx7 nx7Var = this.G0;
        if (nx7Var != null) {
            PbModel pbModel2 = this.y0;
            PostData I0 = nx7Var.I0(pbModel2.G, pbModel2.g2());
            ww7Var.w = I0 != null ? I0.Q : false;
        }
        ww7Var.m = true;
        if (O.isBlocked()) {
            ww7Var.n = false;
            ww7Var.g = false;
            ww7Var.h = false;
        }
        this.G0.h.E(ww7Var);
    }

    public final void K7(boolean z3) {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z3) == null) || (absPbActivity = this.a) == null || absPbActivity.b1() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(!z3 ? "c14397" : "c14398").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.b1().i2()).param("topic_id", this.a.b1().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.a.b1().m2()));
    }

    @Override // com.repackage.ji5
    public fg<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            fg<RelativeLayout> fgVar = new fg<>(new r2(this), 10, 0);
            this.G = fgVar;
            return fgVar;
        }
        return (fg) invokeV.objValue;
    }

    public int L5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.P2 : invokeV.intValue;
    }

    public void L6() {
        i05 i05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (i05Var = this.r0) == null) {
            return;
        }
        i05Var.q();
    }

    public final void L7(int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i4) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.y0.b).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(fz7.m(i4))));
        }
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

    public final void M6(String str, int i4, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048620, this, str, i4, eVar) == null) || eVar == null) {
            return;
        }
        ft7 Q1 = this.y0.Q1();
        TbRichText P7 = P7(str, i4);
        if (P7 == null || (tbRichTextData = P7.B().get(this.B2)) == null) {
            return;
        }
        eVar.f = String.valueOf(P7.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a4 = gt7.a(tbRichTextData);
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
            imageUrlData.postId = P7.getPostId();
            imageUrlData.mIsReserver = this.y0.b2();
            imageUrlData.mIsSeeHost = this.y0.t1();
            eVar.b.put(a4, imageUrlData);
            if (Q1 != null) {
                if (Q1.l() != null) {
                    eVar.c = Q1.l().getName();
                    eVar.d = Q1.l().getId();
                }
                if (Q1.O() != null) {
                    eVar.e = Q1.O().getId();
                }
                eVar.g = Q1.s() == 1;
            }
            imageUrlData.threadId = og.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = Q1.F().size();
        this.D2 = false;
        eVar.j = -1;
        int C5 = Q1.j() != null ? C5(Q1.j().V(), P7, i4, i4, eVar.a, eVar.b) : i4;
        for (int i5 = 0; i5 < size; i5++) {
            PostData postData = Q1.F().get(i5);
            if (postData.K() == null || Q1.j() == null || Q1.j().K() == null || !postData.K().equals(Q1.j().K())) {
                C5 = C5(postData.V(), P7, C5, i4, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (Q1 != null) {
            if (Q1.l() != null) {
                eVar.c = Q1.l().getName();
                eVar.d = Q1.l().getId();
            }
            if (Q1.O() != null) {
                eVar.e = Q1.O().getId();
            }
            eVar.g = Q1.s() == 1;
        }
        eVar.j = C5;
    }

    public final void M7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.E(this.y0.getForumId()) && this.y0.Q1() != null && this.y0.Q1().l() != null) {
            if (this.y0.Q1().l().isLike() == 1) {
                this.y0.d1().D(this.y0.getForumId(), this.y0.i2());
            }
        }
    }

    @Override // com.repackage.ji5
    public fg<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.C == null) {
                this.C = new fg<>(new n2(this), 8, 0);
            }
            return this.C;
        }
        return (fg) invokeV.objValue;
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

    public void N6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (!checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.Q1() != null && this.y0.Q1().l() != null) {
                if (c5()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 3).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                } else if (this.y0.Q1().i0()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 7).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.G0.f0();
                    return;
                } else {
                    if (this.Z0 == null) {
                        qo6 qo6Var = new qo6(getPageContext());
                        this.Z0 = qo6Var;
                        qo6Var.j(0);
                        this.Z0.i(new h1(this));
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.Z0.g(this.y0.Q1().l().getId(), og.g(this.y0.i2(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void N7(ap4 ap4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, ap4Var) == null) || ap4Var == null) {
            return;
        }
        this.S2 = ap4Var;
        this.c = true;
        this.G0.N2();
        this.G0.h3(this.R2);
    }

    @Override // com.repackage.ji5
    public fg<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.D == null) {
                this.D = new fg<>(new q2(this), 8, 0);
            }
            return this.D;
        }
        return (fg) invokeV.objValue;
    }

    public k45 O5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.V0 : (k45) invokeV.objValue;
    }

    public final AbsPbActivity.e O6(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
            String str2 = null;
            if (this.y0.Q1() != null && this.y0.Q1().F() != null && this.y0.Q1().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i4 = 0;
                while (true) {
                    if (i4 >= this.y0.Q1().F().size()) {
                        i4 = 0;
                        break;
                    } else if (str.equals(this.y0.Q1().F().get(i4).K())) {
                        break;
                    } else {
                        i4++;
                    }
                }
                PostData postData = this.y0.Q1().F().get(i4);
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
                    M6(str2, 0, eVar);
                    gt7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    public final void O7(int i4) {
        PbModel pbModel;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048629, this, i4) == null) || (pbModel = this.y0) == null || pbModel.Q1() == null || (O = this.y0.Q1().O()) == null) {
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
                    getResources().getString(R.string.obfuscated_res_0x7f0f1631);
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
                getResources().getString(R.string.obfuscated_res_0x7f0f1631);
            } else {
                String str = O.getPraise().getNum() + "";
            }
        }
        if (this.y0.g2()) {
            this.G0.A0().a0();
        } else {
            this.G0.t4(this.y0.Q1());
        }
    }

    @Override // com.repackage.t08
    public AbsPbActivity P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public sy7 P5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.e : (sy7) invokeV.objValue;
    }

    public boolean P6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            i05 i05Var = this.r0;
            return i05Var != null && i05Var.t();
        }
        return invokeV.booleanValue;
    }

    public final TbRichText P7(String str, int i4) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048633, this, str, i4)) == null) {
            PbModel pbModel = this.y0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.Q1() == null || str == null || i4 < 0) {
                return null;
            }
            ft7 Q1 = this.y0.Q1();
            if (Q1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(Q1.j());
                tbRichText = B5(arrayList, str, i4);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = Q1.F();
                a5(Q1, F);
                return B5(F, str, i4);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // com.repackage.ji5
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

    public final void Q6(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, view2) == null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091852, Integer.valueOf(this.b ? 2 : 3));
        view2.setTag(sparseArray);
    }

    @Override // com.repackage.ji5
    public void R(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048637, this, context, str, z3) == null) {
            if (tx7.c(str) && (pbModel = this.y0) != null && pbModel.i2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.y0.i2()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    s15 s15Var = new s15();
                    s15Var.a = str;
                    s15Var.b = 3;
                    s15Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, s15Var));
                }
            } else {
                tx7.a().e(getPageContext(), str);
            }
            this.w = true;
        }
    }

    public dz7 R5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.v0 : (dz7) invokeV.objValue;
    }

    public void R6(vt7 vt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, vt7Var) == null) {
            String K = vt7Var.i().K();
            List<PostData> list = this.y0.Q1().T().a;
            int i4 = 0;
            while (true) {
                if (i4 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i4);
                if (postData.K() == null || !postData.K().equals(K)) {
                    i4++;
                } else {
                    ArrayList<PostData> k3 = vt7Var.k();
                    postData.W0(vt7Var.m());
                    if (postData.Y() != null) {
                        postData.Y().clear();
                        postData.Y().addAll(k3);
                    }
                }
            }
            if (this.y0.z1()) {
                return;
            }
            this.G0.F1(this.y0.Q1());
        }
    }

    public nx7 S5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.G0 : (nx7) invokeV.objValue;
    }

    public void S6(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048641, this, z3, markData) == null) {
            this.G0.t3();
            this.y0.D3(z3);
            bm4 bm4Var = this.A0;
            if (bm4Var != null) {
                bm4Var.h(z3);
                if (markData != null) {
                    this.A0.i(markData);
                }
            }
            if (this.y0.B1()) {
                A6();
            } else {
                this.G0.F1(this.y0.Q1());
            }
        }
    }

    public final void T5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            if (this.E0 == null) {
                this.E0 = new PollingModel(getPageContext(), getUniqueId());
            }
            this.E0.L(PollingModel.POLLING_TYPE_LEVEL_ICON_LIVE);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            rg.a().postDelayed(this.Y1, 10000L);
        }
    }

    public void T6(vt7 vt7Var) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, vt7Var) == null) || vt7Var.i() == null) {
            return;
        }
        String K = vt7Var.i().K();
        ArrayList<PostData> F = this.y0.Q1().F();
        int i4 = 0;
        while (true) {
            if (i4 >= F.size()) {
                break;
            }
            PostData postData = F.get(i4);
            if (postData.K() == null || !postData.K().equals(K)) {
                i4++;
            } else {
                ArrayList<PostData> k3 = vt7Var.k();
                postData.W0(vt7Var.m());
                if (postData.Y() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.f0() != null && next != null && next.s() != null && (metaData = postData.f0().get(next.s().getUserId())) != null) {
                            next.A0(metaData);
                            next.M0(true);
                            next.f1(getPageContext(), this.y0.G2(metaData.getUserId()));
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
        if (!this.y0.z1() && z3) {
            this.G0.F1(this.y0.Q1());
        }
        if (z3) {
            R6(vt7Var);
        }
    }

    public rq4 U5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.d0 : (rq4) invokeV.objValue;
    }

    public final void U6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            hideNetRefreshView(this.G0.m1());
            w7();
            if (this.y0.P2()) {
                this.G0.u3();
            }
            this.G0.C3();
        }
    }

    @Override // com.repackage.ji5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048646, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
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
        if (!(interceptable == null || interceptable.invokeL(1048647, this, g3Var) == null) || g3Var == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public void V6(g3 g3Var) {
        List<g3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048649, this, g3Var) == null) || g3Var == null || (list = this.t1) == null) {
            return;
        }
        list.remove(g3Var);
    }

    @Override // com.repackage.u18.b
    public void W0(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z3) == null) {
            this.P0 = z3;
        }
    }

    public void W4(g3 g3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048651, this, g3Var) == null) || g3Var == null) {
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

    public final int W5(ft7 ft7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, ft7Var)) == null) {
            if (ft7Var == null || ft7Var.O() == null) {
                return 0;
            }
            if (ft7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (ft7Var.O().getThreadType() == 54) {
                return 2;
            }
            return ft7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void W6() {
        i05 i05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || (i05Var = this.r0) == null) {
            return;
        }
        i05Var.x();
    }

    public final void X4() {
        PbModel pbModel;
        ft7 ft7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || (pbModel = this.y0) == null || (ft7Var = pbModel.G) == null || ft7Var.O() == null) {
            return;
        }
        ThreadData O = this.y0.G.O();
        O.mRecomAbTag = this.y0.V1();
        O.mRecomWeight = this.y0.Y1();
        O.mRecomSource = this.y0.X1();
        O.mRecomExtra = this.y0.W1();
        O.isSubPb = this.y0.D1();
        if (O.getFid() == 0) {
            O.setFid(og.g(this.y0.getForumId(), 0L));
        }
        StatisticItem i4 = t95.i(getContext(), O, "c13562");
        TbPageTag l3 = t95.l(getContext());
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
    @Override // com.repackage.t08
    /* renamed from: X5 */
    public VideoPbFragment B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public final boolean X6(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091fe8);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.N0 && !TextUtils.isEmpty(postData.t()) && rn4.c().g()) {
                        return F6(postData.K());
                    }
                    if (!checkUpIsLogin()) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        return true;
                    }
                    PbModel pbModel = this.y0;
                    if (pbModel != null && pbModel.Q1() != null) {
                        if (S5().b1() != null) {
                            S5().b1().c();
                        }
                        vt7 vt7Var = new vt7();
                        vt7Var.A(this.y0.Q1().l());
                        vt7Var.E(this.y0.Q1().O());
                        vt7Var.C(postData);
                        S5().a1().V(vt7Var);
                        S5().a1().setPostId(postData.K());
                        z6(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        k45 k45Var = this.V0;
                        if (k45Var != null) {
                            this.G0.Y2(k45Var.C());
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

    @Override // com.repackage.ji5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, context, str) == null) {
            this.w = true;
        }
    }

    @Override // com.repackage.ji5
    public fg<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if (this.A == null) {
                this.A = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (fg) invokeV.objValue;
    }

    public final void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            if (this.o1 != null) {
                j55.b bVar = new j55.b();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public final void Y6(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.Q == null) {
            ny7 ny7Var = new ny7(this.a);
            this.Q = ny7Var;
            ny7Var.n(this.c1);
            this.Q.m(this.m2);
        }
        this.Q.k(emotionImageData, K(), K().Q1());
    }

    public final void Z4(boolean z3) {
        PbModel pbModel;
        ft7 ft7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048662, this, z3) == null) || (pbModel = this.y0) == null || (ft7Var = pbModel.G) == null || ft7Var.O() == null) {
            return;
        }
        ThreadData O = this.y0.G.O();
        O.mRecomAbTag = this.y0.V1();
        O.mRecomWeight = this.y0.Y1();
        O.mRecomSource = this.y0.X1();
        O.mRecomExtra = this.y0.W1();
        if (O.getFid() == 0) {
            O.setFid(og.g(this.y0.getForumId(), 0L));
        }
        StatisticItem i4 = t95.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l3 = t95.l(getContext());
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
            o95 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i4.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i4.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(i4);
        }
    }

    public void Z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            if (this.g) {
                this.O = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.y0.Q1() == null || this.y0.Q1().O() == null || this.y0.Q1().O().getTaskInfoData() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.y0.Q1().O().getTaskInfoData().g(), this.y0.Q1().O().getTaskInfoData().f(), this.y0.Q1().O().getTaskInfoData().b(), this.y0.Q1().O().getTaskInfoData().c(), this.y0.Q1().O().getIs_top(), this.y0.Q1().O().getIs_good())));
                this.a.finish();
            }
        }
    }

    public final void Z6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048664, this) == null) || (pbModel = this.y0) == null || pbModel.Q1() == null || this.y0.Q1().O() == null || !this.y0.Q1().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public final void a5(ft7 ft7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048665, this, ft7Var, arrayList) == null) || ft7Var == null || ft7Var.T() == null || ft7Var.T().a == null || (list = ft7Var.T().a) == null || arrayList == null) {
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
        t25 t25Var;
        t25 t25Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048666, this, i4, intent) == null) {
            if (i4 == 0) {
                this.G0.q1();
                this.G0.b1().c();
                this.G0.H3(false);
            }
            this.G0.Q2();
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
                    o45 b4 = this.G0.b1().b();
                    b4.c0(this.y0.Q1().O());
                    b4.B(writeData);
                    b4.d0(pbEditorData.getVoiceModel());
                    s25 n3 = b4.a().n(6);
                    if (n3 != null && (t25Var2 = n3.m) != null) {
                        t25Var2.A(new h25(52, 0, pbEditorData.getVoiceModel()));
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
                s25 n4 = this.V0.a().n(6);
                if (n4 != null && (t25Var = n4.m) != null) {
                    t25Var.A(new h25(52, 0, pbEditorData.getVoiceModel()));
                }
                this.V0.r0(pbEditorData.isShowCustomFigure());
                if (i4 == -1) {
                    this.V0.M(null, null);
                }
            }
        }
    }

    public final void a7(boolean z3, PostData postData) {
        nx4 adAdSense;
        nx7 nx7Var;
        vv7 A0;
        ArrayList<PostData> E;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048667, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.e() || (nx7Var = this.G0) == null || (A0 = nx7Var.A0()) == null || (E = A0.E()) == null) {
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
                    arrayList.add(new hl8.c());
                    break;
                }
            } else if (next.C == 1 && !TextUtils.isEmpty(K)) {
                next.C = 2;
                arrayList.add(new hl8.c());
            }
        }
        if (arrayList.size() <= 0 || (pbModel = this.y0) == null || pbModel.Q1() == null || this.y0.Q1().l() == null) {
            return;
        }
        this.y0.Q1().l().getFirst_class();
        this.y0.Q1().l().getSecond_class();
        this.y0.Q1().l().getId();
        this.y0.i2();
    }

    public void b5(boolean z3) {
        nx7 nx7Var;
        int w3;
        int w4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048668, this, z3) == null) || (nx7Var = this.G0) == null || nx7Var.R0() == null) {
            return;
        }
        int firstVisiblePosition = this.G0.R0().getFirstVisiblePosition();
        int lastVisiblePosition = this.G0.R0().getLastVisiblePosition();
        vv7 A0 = this.G0.A0();
        if (A0 == null || this.y0.Q1() == null) {
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
                    PostData postData2 = (PostData) ListUtils.getItem(this.y0.Q1().F(), postData.B() - 1);
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
            z05 z05Var = (z05) ListUtils.getItem(arrayList, 0);
            if (z05Var == null || z05Var.e() != 1) {
                this.G0.C2(z05Var, 1);
            } else if (z3) {
            } else {
                this.G0.C2(z05Var, 0);
            }
        }
    }

    public void b6(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048669, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092041) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092041) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092043) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092043) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092042) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092042) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f09203e) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f09203f) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09203f) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.j1);
            userMuteAddAndDelCustomMessage.setTag(this.j1);
            C7(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void b7() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048670, this) == null) || (pbModel = this.y0) == null || pbModel.Q1() == null || this.y0.Q1().O() == null || !this.y0.Q1().O().isVideoThreadType()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public final boolean c5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.Q1() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.y0.Q1().O()) || AntiHelper.d(getPageContext(), this.y0.Q1().d());
        }
        return invokeV.booleanValue;
    }

    public final void c6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, str) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.Q1() != null && this.y0.Q1().i0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.y0.i2(), str);
                ThreadData O = this.y0.Q1().O();
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

    public final void c7(int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048673, this, i4) == null) || this.y0 == null) {
            return;
        }
        w7();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i4);
        privacySettingMessage.setTid(this.y0.b);
        sendMessage(privacySettingMessage);
    }

    public final boolean d5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048674, this, i4)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048675, this, intent) == null) {
            hz7.j(this, intent);
        }
    }

    public void d7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z3) == null) {
            this.n2 = Boolean.valueOf(z3);
        }
    }

    @Override // com.repackage.ji5
    public fg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            if (this.H == null) {
                this.H = new fg<>(new s2(this), 10, 0);
            }
            return this.H;
        }
        return (fg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048678, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public void e5(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.G0.P3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = og.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = og.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092040), 0L);
            BdUniqueId bdUniqueId = this.j1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.g1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void e6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048680, this) == null) || this.a == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.a.getCurrentFocus() == null) {
            return;
        }
        qi.x(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public void e7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048681, this, z3) == null) {
            this.t0 = z3;
        }
    }

    public boolean f5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            if ((this.y0.Q1() != null && (this.y0.Q1().i0() || ThreadCardUtils.isSelf(this.y0.Q1().O()))) || this.Y0 == null || this.y0.Q1() == null || this.y0.Q1().d() == null) {
                return true;
            }
            return this.Y0.checkPrivacyBeforeInvokeEditor(this.y0.Q1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void f6() {
        nx7 nx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048683, this) == null) || (nx7Var = this.G0) == null) {
            return;
        }
        nx7Var.q1();
        e6();
    }

    public void f7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z3) == null) {
            this.N = z3;
        }
    }

    @Override // com.repackage.t08
    public void finish() {
        nx7 nx7Var;
        CardHListViewData q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            nx7 nx7Var2 = this.G0;
            if (nx7Var2 != null) {
                nx7Var2.m0();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.Q1() != null && !this.y0.Q1().i0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.y0.Q1().O().getId();
                if (this.y0.isShareThread() && this.y0.Q1().O().originalThreadData != null) {
                    historyMessage.threadName = this.y0.Q1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = this.y0.Q1().O().getTitle();
                }
                if (this.y0.isShareThread() && !u0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.y0.Q1().l().getName();
                }
                ArrayList<PostData> F = this.y0.Q1().F();
                nx7 nx7Var3 = this.G0;
                int H0 = nx7Var3 != null ? nx7Var3.H0() : 0;
                if (F != null && H0 >= 0 && H0 < F.size()) {
                    historyMessage.postID = F.get(H0).K();
                }
                historyMessage.isHostOnly = this.y0.t1();
                historyMessage.isSquence = this.y0.g2();
                historyMessage.isShareThread = this.y0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            k45 k45Var = this.V0;
            if (k45Var != null) {
                k45Var.I();
            }
            if (this.j && S5() != null) {
                S5().r0();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && (pbModel2.v1() || this.y0.y1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.y0.i2());
                if (this.H0) {
                    if (this.J0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.y0.E1());
                    }
                    if (this.I0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.y0.A1());
                    }
                }
                if (this.y0.Q1() != null && System.currentTimeMillis() - this.p >= 40000 && (q3 = this.y0.Q1().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.s1);
                }
                this.a.setResult(-1, intent);
            }
            if (I7()) {
                if (this.y0 != null && (nx7Var = this.G0) != null && nx7Var.R0() != null) {
                    ft7 Q1 = this.y0.Q1();
                    if (Q1 != null) {
                        if (Q1.V() != null) {
                            Q1.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!Q1.p0() && !this.I && Q1.h == null) {
                            cx7.b().n(this.y0.R1(), this.G0.R0().onSaveInstanceState(), this.y0.g2(), this.y0.t1(), this.G0.Z0() != null && this.G0.Z0().getVisibility() == 0);
                            if (this.r1 >= 0 || this.y0.k2() != null) {
                                cx7.b().q(this.y0.k2());
                                cx7.b().r(this.y0.l2());
                                cx7.b().o(this.y0.J1());
                            }
                        }
                    }
                } else {
                    cx7.b().m();
                }
                H7();
            }
        }
    }

    @Override // com.repackage.ji5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048686, this, context, str) == null) {
        }
    }

    public boolean g5(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048687, this, i4)) == null) {
            if (this.Y0 == null || this.y0.Q1() == null || ThreadCardUtils.isSelf(this.y0.Q1().O()) || this.y0.Q1().d() == null) {
                return true;
            }
            return this.Y0.checkPrivacyBeforeSend(this.y0.Q1().d().replyPrivateFlag, i4);
        }
        return invokeI.booleanValue;
    }

    public final void g6(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048688, this, i4, i5) == null) {
            gf5.b(new j(this, i5), new l(this, i5, i4));
        }
    }

    public final void g7(m45 m45Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048689, this, m45Var) == null) || m45Var == null || (pbModel = this.y0) == null) {
            return;
        }
        m45Var.p(pbModel.p1());
        if (this.y0.Q1() != null && this.y0.Q1().l() != null) {
            m45Var.o(this.y0.Q1().l());
        }
        m45Var.q("pb");
        m45Var.r(this.y0);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h5(AgreeData agreeData) {
        o95 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048691, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.f0 == null) {
            this.f0 = new nu4();
        }
        if (this.j0 == null) {
            sk8 sk8Var = new sk8();
            this.j0 = sk8Var;
            sk8Var.a = getUniqueId();
        }
        lo4 lo4Var = new lo4();
        lo4Var.b = 5;
        lo4Var.h = 8;
        lo4Var.g = 2;
        if (K() != null) {
            lo4Var.f = K().P1();
        }
        lo4Var.a = 2;
        int i4 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                lo4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.f0.c(agreeData, i4, getUniqueId(), false);
                this.f0.d(agreeData, this.j0);
                pbModel = this.y0;
                if (pbModel != null || pbModel.Q1() == null) {
                }
                this.f0.b(P(), lo4Var, agreeData, this.y0.Q1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            lo4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            lo4Var.i = 1;
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
        if (interceptable == null || interceptable.invokeI(1048692, this, i4) == null) {
            gf5.b(new h(this), new i(this, i4));
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

    public final void h7(int i4) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048693, this, i4) == null) || (pbModel = this.y0) == null) {
            return;
        }
        int Z1 = pbModel.Z1();
        if (i4 == 5) {
            this.y0.x3(2);
        } else if (i4 == 6) {
            this.y0.x3(3);
        } else if (i4 != 7) {
            this.y0.x3(1);
        } else {
            this.y0.x3(4);
        }
        int Z12 = this.y0.Z1();
        if (Z1 == 4 || Z12 == 4) {
            J6();
        }
    }

    public final void i5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            if (this.y0.v1() || this.y0.y1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.y0.i2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.y0.i2()));
            if (I7()) {
                this.a.finish();
            }
        }
    }

    public final void i6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, bundle) == null) {
            bm4 c4 = bm4.c(this.a);
            this.A0 = c4;
            if (c4 != null) {
                c4.j(this.t2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.B0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.v2);
            this.C0 = new pz4(getPageContext());
            T5();
            this.S1.setUniqueId(getUniqueId());
            this.S1.registerListener();
        }
    }

    public void i7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z3) == null) {
            this.K = z3;
        }
    }

    public final boolean j5(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        boolean z5;
        List<bs4> c4;
        bs4 bs4Var;
        bs4 bs4Var2;
        bs4 bs4Var3;
        bs4 bs4Var4;
        bs4 bs4Var5;
        bs4 bs4Var6;
        zm zmVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048697, this, view2)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                nx7 nx7Var = this.G0;
                if (nx7Var != null) {
                    if (nx7Var.J1()) {
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f092023) != null && (view2.getTag(R.id.obfuscated_res_0x7f092023) instanceof TbRichTextImageInfo)) {
                                this.o1 = (TbRichTextImageInfo) view2.getTag(R.id.obfuscated_res_0x7f092023);
                            } else {
                                this.o1 = null;
                            }
                            if (view2.getTag(R.id.obfuscated_res_0x7f092024) != null && (view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextImageInfo)) {
                                this.p1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f092024) != null && (view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextImageInfo)) {
                                this.p1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
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
                                if (view2.getTag(R.id.obfuscated_res_0x7f092024) != null && (view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextImageInfo)) {
                                    this.p1 = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
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
                            this.G0.U3(this.G2, this.m1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8);
                this.E2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.B() == 1 && p6(view2)) {
                    this.G0.U3(this.G2, this.m1.t());
                    return true;
                }
                bm4 bm4Var = this.A0;
                if (bm4Var == null) {
                    return true;
                }
                boolean z6 = bm4Var.e() && this.E2.K() != null && this.E2.K().equals(this.y0.L1());
                boolean z7 = K().Q1() != null && K().Q1().i0();
                boolean z8 = K().Q1() != null && K().Q1().m0();
                boolean z9 = K().Q1() != null && K().Q1().l0();
                if (this.E2.B() == 1) {
                    if (!z7) {
                        this.G0.V3(this.F2, z6, false, z8, z9);
                    }
                    return true;
                }
                if (this.M0 == null) {
                    fs4 fs4Var = new fs4(getContext());
                    this.M0 = fs4Var;
                    fs4Var.n(this.i2);
                }
                ArrayList arrayList = new ArrayList();
                if (view2 == null || sparseArray == null) {
                    return true;
                }
                boolean z10 = p6(view2) && !z7;
                boolean z11 = (!p6(view2) || (zmVar = this.m1) == null || zmVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092001) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092001)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f09202e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09202e)).booleanValue() : false;
                String str = sparseArray.get(R.id.obfuscated_res_0x7f091ff8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ff8) : null;
                boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092000) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092000)).booleanValue() : false;
                boolean booleanValue8 = sparseArray.get(R.id.obfuscated_res_0x7f092009) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092009)).booleanValue() : false;
                if (z10) {
                    z3 = booleanValue8;
                    z5 = booleanValue6;
                    z4 = booleanValue5;
                    arrayList.add(new bs4(1, getString(R.string.obfuscated_res_0x7f0f108d), this.M0));
                } else {
                    z3 = booleanValue8;
                    z4 = booleanValue5;
                    z5 = booleanValue6;
                }
                if (z11) {
                    arrayList.add(new bs4(2, getString(R.string.obfuscated_res_0x7f0f108e), this.M0));
                }
                if (!z10 && !z11) {
                    bs4 bs4Var7 = new bs4(3, getString(R.string.obfuscated_res_0x7f0f044d), this.M0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fe8, this.E2);
                    bs4Var7.d.setTag(sparseArray3);
                    arrayList.add(bs4Var7);
                }
                if (!booleanValue && !z7) {
                    if (z6) {
                        bs4Var6 = new bs4(4, getString(R.string.obfuscated_res_0x7f0f0fd1), this.M0);
                    } else {
                        bs4Var6 = new bs4(4, getString(R.string.obfuscated_res_0x7f0f0a90), this.M0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091fe8, this.E2);
                    sparseArray4.put(R.id.obfuscated_res_0x7f092001, Boolean.FALSE);
                    bs4Var6.d.setTag(sparseArray4);
                    arrayList.add(bs4Var6);
                }
                if (this.mIsLogin && !this.q0) {
                    if (!fz7.i(this.y0) && !booleanValue4 && booleanValue3) {
                        bs4 bs4Var8 = new bs4(5, getString(R.string.obfuscated_res_0x7f0f0b33), this.M0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                        sparseArray5.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                        sparseArray5.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091feb, sparseArray.get(R.id.obfuscated_res_0x7f091feb));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray5.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                        sparseArray5.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                        bs4Var8.d.setTag(sparseArray5);
                        arrayList.add(bs4Var8);
                    } else {
                        if ((t6(booleanValue2) && TbadkCoreApplication.isLogin()) && !z7) {
                            bs4 bs4Var9 = new bs4(5, getString(R.string.obfuscated_res_0x7f0f0ff6), this.M0);
                            bs4Var9.d.setTag(str);
                            arrayList.add(bs4Var9);
                        }
                    }
                    if (booleanValue4) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ff5, sparseArray.get(R.id.obfuscated_res_0x7f091ff5));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ff6, sparseArray.get(R.id.obfuscated_res_0x7f091ff6));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ff8, str);
                        sparseArray6.put(R.id.obfuscated_res_0x7f092009, sparseArray.get(R.id.obfuscated_res_0x7f092009));
                        if (!fz7.i(this.y0) && z4) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091fff, sparseArray.get(R.id.obfuscated_res_0x7f091fff));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                            sparseArray6.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                        }
                        if (z5) {
                            sparseArray6.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                            sparseArray6.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue2));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                            sparseArray6.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                            sparseArray6.put(R.id.obfuscated_res_0x7f092000, Boolean.valueOf(booleanValue7));
                            if (booleanValue7) {
                                bs4Var5 = new bs4(6, getString(R.string.obfuscated_res_0x7f0f04ab), this.M0);
                                bs4Var5.d.setTag(sparseArray6);
                                bs4Var2 = new bs4(7, getString(R.string.obfuscated_res_0x7f0f02e3), this.M0);
                                bs4Var2.d.setTag(sparseArray6);
                                bs4Var3 = bs4Var5;
                                bs4Var = null;
                            }
                        } else {
                            sparseArray6.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                        }
                        bs4Var5 = null;
                        bs4Var2 = new bs4(7, getString(R.string.obfuscated_res_0x7f0f02e3), this.M0);
                        bs4Var2.d.setTag(sparseArray6);
                        bs4Var3 = bs4Var5;
                        bs4Var = null;
                    } else if (z5) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                        sparseArray7.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue2));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray7.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                        if (this.y0.Q1().W() == 1002 && !booleanValue2) {
                            bs4Var4 = new bs4(6, getString(R.string.obfuscated_res_0x7f0f0ff6), this.M0);
                        } else {
                            bs4Var4 = new bs4(6, getString(R.string.obfuscated_res_0x7f0f04ab), this.M0);
                        }
                        bs4Var4.d.setTag(sparseArray7);
                        if (z3) {
                            bs4Var = new bs4(13, getString(R.string.obfuscated_res_0x7f0f0b23), this.M0);
                            bs4Var3 = bs4Var4;
                        } else {
                            bs4Var3 = bs4Var4;
                            bs4Var = null;
                        }
                        bs4Var2 = null;
                    } else {
                        bs4Var = null;
                        bs4Var2 = null;
                        bs4Var3 = null;
                    }
                    if (bs4Var3 != null) {
                        arrayList.add(bs4Var3);
                    }
                    if (bs4Var != null) {
                        arrayList.add(bs4Var);
                    }
                    if (bs4Var2 != null) {
                        arrayList.add(bs4Var2);
                    }
                    fz7.b(arrayList, this.M0, this.E2, this.y0);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c4 = fz7.d(arrayList, this.E2.q(), sparseArray, this.M0);
                } else {
                    c4 = fz7.c(arrayList, this.E2.q(), sparseArray, this.M0);
                }
                fz7.l(c4, this.b);
                fz7.f(c4);
                this.M0.o(fz7.g(this.E2));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.M0.k(c4, false);
                } else {
                    this.M0.k(c4, true);
                }
                ds4 ds4Var = new ds4(getPageContext(), this.M0);
                this.L0 = ds4Var;
                ds4Var.k();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.y0.b).param("fid", this.y0.getForumId()).param("uid", this.y0.Q1().O().getAuthor().getUserId()).param("post_id", this.y0.B()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.R = likeModel;
            likeModel.setLoadDataCallBack(new n0(this));
        }
    }

    public final void j7(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z3) == null) {
            this.V0.g0(z3);
            this.V0.k0(z3);
            this.V0.s0(z3);
        }
    }

    public void k5(ForumManageModel.b bVar, nx7 nx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048700, this, bVar, nx7Var) == null) {
            List<PostData> list = this.y0.Q1().T().a;
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
                nx7Var.F1(this.y0.Q1());
            }
        }
    }

    public final void k6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && this.m == null) {
            this.m = new wr4(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.obfuscated_res_0x7f0f0365), getPageContext().getString(R.string.obfuscated_res_0x7f0f11a9), getPageContext().getString(R.string.obfuscated_res_0x7f0f10bf)};
            wr4 wr4Var = this.m;
            wr4Var.j(strArr, new s0(this));
            wr4Var.g(wr4.b.obfuscated_res_0x7f1003ac);
            wr4Var.h(17);
            wr4Var.c(getPageContext());
        }
    }

    public final void k7() {
        PbModel pbModel;
        ImMessageCenterPojo i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048702, this) == null) || (pbModel = this.y0) == null || pbModel.G == null) {
            return;
        }
        long c4 = e05.c();
        if (c4 <= 0 || (i4 = m87.o().i(String.valueOf(c4), 2)) == null || j87.a(getContext())) {
            return;
        }
        MetaData metaData = new MetaData();
        metaData.setUserIdLong(c4);
        metaData.setUserName(i4.getGroup_name());
        metaData.setName_show(i4.getNameShow());
        metaData.setPortrait(i4.getGroup_head());
        metaData.setIsMyFriend(i4.getIsFriend() != 1 ? 0 : 1);
        u97 u97Var = new u97(getContext());
        u97Var.o(this.y0.G.O(), metaData);
        u97Var.p();
    }

    @Override // com.repackage.t08
    public PbFragment l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    public final void l5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048704, this, str) == null) || TextUtils.isEmpty(str) || (pbModel = this.y0) == null || pbModel.Q1() == null) {
            return;
        }
        bl8 z3 = this.y0.Q1().z();
        if (z3 != null && str.equals(z3.j1())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().h = null;
            }
            this.y0.Q1().b();
        }
        bl8 j12 = this.y0.j1();
        if (j12 == null || !str.equals(j12.j1())) {
            return;
        }
        this.y0.V0();
    }

    public boolean l6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l7(int i4, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048706, this, i4, antiData, str) == null) {
            if (AntiHelper.m(i4, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i4, new a2(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i4 == 230277) {
                B7(str);
            } else {
                this.G0.h4(str);
            }
        }
    }

    public void m5(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048707, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(nx7.k2)).intValue();
            if (intValue == nx7.l2) {
                if (this.B0.S()) {
                    return;
                }
                this.G0.i4();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ffe) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ffe)).booleanValue() : false;
                if (jSONArray != null) {
                    this.B0.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.B0.V(this.y0.Q1().l().getId(), this.y0.Q1().l().getName(), this.y0.Q1().O().getId(), str, intValue3, intValue2, booleanValue, this.y0.Q1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == nx7.m2 || intValue == nx7.o2) {
                PbModel pbModel = this.y0;
                if (pbModel != null && pbModel.l1() != null) {
                    this.y0.l1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == nx7.m2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final boolean m6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            AbsPbActivity absPbActivity = this.a;
            return (absPbActivity == null || absPbActivity.b1() == null || this.a.b1().P1() != 17) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void m7(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048709, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
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
                    l05.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg) && !StringUtils.isNull(questionMsg) && !StringUtils.isNull(questionExp)) {
                    ks7.g(errorString + " " + preMsg, colorMsg, questionMsg, questionExp);
                    return;
                } else if (!StringUtils.isNull(preMsg) && !StringUtils.isNull(colorMsg)) {
                    ks7.f(errorString + " " + preMsg, colorMsg);
                    return;
                } else if (StringUtils.isNull(errorString)) {
                    ks7.e(getResources().getString(R.string.obfuscated_res_0x7f0f1208));
                    return;
                } else {
                    ks7.e(errorString);
                    return;
                }
            }
            return;
        }
        if (!this.y0.D1()) {
            antiData.setBlock_forum_name(this.y0.Q1().l().getName());
            antiData.setBlock_forum_id(this.y0.Q1().l().getId());
            antiData.setUser_name(this.y0.Q1().V().getUserName());
            antiData.setUser_id(this.y0.Q1().V().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void n5(ur4 ur4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048710, this, ur4Var, jSONArray) == null) {
            ur4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (ur4Var.getYesButtonTag() instanceof SparseArray) {
                    m5((SparseArray) ur4Var.getYesButtonTag(), jSONArray);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            PostData c4 = gt7.c(this.y0.Q1(), this.y0.g2(), this.y0.a2());
            return (c4 == null || c4.s() == null || c4.s().getGodUserData() == null || c4.s().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void n7(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048712, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            hz7.l(this, j3, str, j4);
        }
    }

    public void o5(int i4, String str, int i5, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048713, this, new Object[]{Integer.valueOf(i4), str, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fea, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i5));
            sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z3));
            sparseArray.put(nx7.k2, Integer.valueOf(nx7.l2));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.t1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void o7(SparseArray<Object> sparseArray, int i4, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048715, this, new Object[]{sparseArray, Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) {
            fz7.e(getActivity(), getPageContext(), new f1(this, sparseArray, i4, z3), new g1(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeIIL(1048717, this, i4, i5, intent) == null) {
            super.onActivityResult(i4, i5, intent);
            this.V0.H(i4, i5, intent);
            ny7 ny7Var = this.Q;
            if (ny7Var != null) {
                ny7Var.i(i4, i5, intent);
            }
            if (S5().b1() != null) {
                S5().b1().g(i4, i5, intent);
            }
            if (i4 == 25035) {
                a6(i5, intent);
            }
            if (i5 == -1) {
                if (i4 == 11009) {
                    C6();
                } else if (i4 == 13008) {
                    cx7.b().m();
                    this.x0.postDelayed(new h2(this), 1000L);
                } else if (i4 == 13011) {
                    cb8.g().m(getPageContext());
                } else if (i4 == 23003) {
                    if (intent == null || this.y0 == null) {
                        return;
                    }
                    n7(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i4 == 23007) {
                    d6(intent);
                } else if (i4 == 25012) {
                    intent.getLongExtra("KEY_FORUM_ID", 0L);
                    intent.getStringExtra(ForumUserLiveActiivtyConfig.KEY_FORUM_NAME);
                } else if (i4 == 25033) {
                    View view2 = this.S;
                    if (view2 != null) {
                        this.G0.M3(view2);
                    }
                } else if (i4 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        cb8.g().m(getPageContext());
                        M7();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.F0;
                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.w) != null) {
                            shareSuccessReplyToServerModel.z(str, intExtra, new i2(this));
                        }
                        if (m6()) {
                            K7(true);
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
                            nx7 nx7Var = this.G0;
                            if (nx7Var == null || nx7Var.B0() == null) {
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
                    this.G0.w3(false);
                    if (this.y0.Q1() == null || this.y0.Q1().O() == null || this.y0.Q1().O().getPushStatusData() == null) {
                        return;
                    }
                    this.y0.Q1().O().getPushStatusData().setStatus(2);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048719, this, i4) == null) || this.X == i4) {
            return;
        }
        super.onChangeSkinType(i4);
        this.G0.f2(i4);
        k45 k45Var = this.V0;
        if (k45Var != null && k45Var.a() != null) {
            this.V0.a().w(i4);
        }
        if (this.G0.a() != null) {
            this.G0.a().d(getPageContext(), i4);
        }
        this.K0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i4, getResources(), R.color.CAM_X0201));
        this.X = i4;
        G7();
        i05 i05Var = this.r0;
        if (i05Var != null) {
            i05Var.w();
        }
    }

    @Override // com.repackage.ur4.e
    public void onClick(ur4 ur4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, ur4Var) == null) {
            n5(ur4Var, null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, configuration) == null) {
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
            nx7 nx7Var = this.G0;
            if (nx7Var != null) {
                nx7Var.g2(configuration);
            }
            ds4 ds4Var = this.L0;
            if (ds4Var != null) {
                ds4Var.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        nx7 nx7Var;
        nx7 nx7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
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
                this.P = pi.isEmpty(stringExtra) ? "" : this.P;
                this.s1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                rq4 rq4Var = new rq4();
                this.d0 = rq4Var;
                rq4Var.a(intent);
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
            if (this.y0.Q1() != null) {
                this.y0.Q1().Q0(this.P);
            }
            j6();
            if (intent != null && (nx7Var2 = this.G0) != null) {
                nx7Var2.b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.k1 == null) {
                        this.k1 = new k0(this, intent);
                    }
                    rg.a().postDelayed(this.k1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.y0.Q1() != null) {
                    this.y0.v3(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.k = voiceManager;
            voiceManager.onCreate(getPageContext());
            i6(bundle);
            m45 m45Var = new m45();
            this.U0 = m45Var;
            g7(m45Var);
            k45 k45Var = (k45) this.U0.a(getActivity());
            this.V0 = k45Var;
            k45Var.f0(this.a.getPageContext());
            this.V0.p0(this.m2);
            this.V0.q0(this.c1);
            this.V0.i0(1);
            this.V0.F(this.a.getPageContext(), bundle);
            this.V0.a().b(new r25(getActivity()));
            this.V0.a().C(true);
            j7(true);
            this.V0.P(this.y0.s1(), this.y0.i2(), this.y0.o1());
            registerListener(this.C1);
            if (!this.y0.D1()) {
                this.V0.s(this.y0.i2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.V0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.y0.w2()) {
                this.V0.m0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dec));
            } else {
                nx7 nx7Var3 = this.G0;
                if (nx7Var3 != null) {
                    this.V0.m0(nx7Var3.e1());
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
            tk8 tk8Var = new tk8("pb", tk8.d);
            this.T0 = tk8Var;
            tk8Var.d();
            registerListener(this.K1);
            registerListener(this.U1);
            this.y0.S2();
            registerListener(this.r2);
            registerListener(this.g2);
            registerListener(this.l2);
            registerListener(this.O1);
            registerListener(this.P1);
            registerListener(this.f2);
            nx7 nx7Var4 = this.G0;
            if (nx7Var4 != null && nx7Var4.l1() != null && this.G0.j1() != null) {
                sy7 sy7Var = new sy7(getActivity(), this.G0.l1(), this.G0.j1(), this.G0.Z0());
                this.e = sy7Var;
                sy7Var.t(this.T1);
            }
            if (this.c && (nx7Var = this.G0) != null && nx7Var.j1() != null) {
                this.G0.j1().setVisibility(8);
            }
            wu4 wu4Var = new wu4();
            this.i1 = wu4Var;
            wu4Var.a = 1000L;
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
            this.y0.k1().D(this.W1);
            this.K0 = new qx7();
            if (this.V0.v() != null) {
                this.K0.m(this.V0.v().i());
            }
            this.V0.e0(this.d1);
            this.F0 = new ShareSuccessReplyToServerModel();
            V4(this.x1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.Y0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new l0(this));
            oz7 oz7Var = new oz7(getContext());
            this.z0 = oz7Var;
            oz7Var.b(getUniqueId());
            dj8.g().i(getUniqueId());
            co4.b().l("3", "");
            this.w1 = new zy5(getPageContext());
            this.v0 = new dz7(this, getUniqueId(), this.G0, this.y0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && oi.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.q = System.currentTimeMillis() - this.p;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048723, this, layoutInflater, viewGroup, bundle)) == null) {
            this.G0 = new nx7(this, this.k2, this.X1);
            o56 o56Var = new o56(getActivity());
            this.d = o56Var;
            o56Var.i(U2);
            this.d.d(this.N2);
            this.G0.n3(this.u2);
            this.G0.m3(this.A2);
            this.G0.f3(this.x2);
            this.G0.g3(this.y2);
            this.G0.d3(rn4.c().g());
            this.G0.k3(this.C2);
            this.G0.q3(this.I2);
            this.G0.o3(this.J2);
            this.G0.l3(this.L2);
            this.G0.j3(this.w2);
            this.G0.m4(this.mIsLogin);
            if (this.a.getIntent() != null) {
                this.G0.b3(this.a.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.G0.a1().setFromForumId(this.y0.getFromForumId());
            this.G0.T2(this.V0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.V0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.V0.m0(this.G0.e1());
            }
            this.G0.X2(new o0(this));
            this.G0.a3(this.y0.y1());
            this.G0.p3(this.y0.P1());
            this.v0.f(this.G0, this.y0);
            if ("1".equals(K().showReplyPanel)) {
                this.G0.o2();
            }
            return this.G0.m1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        nz7 nz7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            dj8.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.y0.Q1().m());
                statisticItem.param("tid", this.y0.i2());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.t && this.G0 != null) {
                this.t = true;
                a7(false, null);
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.y0.destory();
                if (this.y0.M1() != null) {
                    this.y0.M1().d();
                }
            }
            k45 k45Var = this.V0;
            if (k45Var != null) {
                k45Var.I();
            }
            ForumManageModel forumManageModel = this.B0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.R;
            if (likeModel != null) {
                likeModel.M();
            }
            nx7 nx7Var = this.G0;
            if (nx7Var != null) {
                nx7Var.h2();
                nz7 nz7Var2 = this.G0.h;
                if (nz7Var2 != null) {
                    nz7Var2.x();
                }
            }
            ia5 ia5Var = this.u;
            if (ia5Var != null) {
                ia5Var.c();
            }
            sy7 sy7Var = this.e;
            if (sy7Var != null) {
                sy7Var.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            nx7 nx7Var2 = this.G0;
            if (nx7Var2 != null) {
                nx7Var2.m0();
            }
            if (this.Y1 != null) {
                rg.a().removeCallbacks(this.Y1);
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
            id8.e().g();
            if (this.k1 != null) {
                rg.a().removeCallbacks(this.k1);
            }
            ny7 ny7Var = this.Q;
            if (ny7Var != null) {
                ny7Var.f();
            }
            nx7 nx7Var3 = this.G0;
            if (nx7Var3 != null && (nz7Var = nx7Var3.h) != null) {
                nz7Var.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.F0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            qx7 qx7Var = this.K0;
            if (qx7Var != null) {
                qx7Var.j();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && pbModel2.d1() != null) {
                this.y0.d1().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.Y0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            nx7 nx7Var4 = this.G0;
            if (nx7Var4 != null) {
                nx7Var4.j4();
            }
            dz7 dz7Var = this.v0;
            if (dz7Var != null) {
                dz7Var.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.e0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public sn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (sn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            U6();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            if (TbadkCoreApplication.getInst().isReadMenuDialogOnTop()) {
                this.g = false;
            } else {
                this.g = true;
            }
            super.onPause();
            gz7.a();
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
            nx7 nx7Var = this.G0;
            if (nx7Var != null) {
                nx7Var.m2();
            }
            if (!this.y0.D1()) {
                this.V0.V(this.y0.i2());
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.R2();
            }
            dj4.w().E();
            MessageManager.getInstance().unRegisterListener(this.F1);
            Z6();
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.c2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.v(null);
            i05 i05Var = this.r0;
            if (i05Var != null) {
                i05Var.q();
                this.r0.p();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.g9
    public void onPreLoad(sn snVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, snVar) == null) {
            PreLoadImageHelper.load(snVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(snVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
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
            nx7 nx7Var = this.G0;
            if (nx7Var != null && nx7Var.m1() != null) {
                if (!this.h) {
                    w7();
                } else {
                    hideLoadingView(this.G0.m1());
                }
                this.G0.p2();
            }
            if (this.l == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            nx7 nx7Var2 = this.G0;
            NoNetworkView a4 = nx7Var2 != null ? nx7Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && oi.z()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.k;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.F1);
            this.P0 = false;
            b7();
            registerListener(this.Z1);
            registerListener(this.a2);
            registerListener(this.c2);
            if (this.q1) {
                U6();
                this.q1 = false;
            }
            D7();
            ItemCardHelper.v(this.K2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                a25.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.y0.j3(bundle);
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
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
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
            nz7 nz7Var = this.G0.h;
            if (nz7Var != null && !nz7Var.t()) {
                this.G0.h.x();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.Q1() != null && this.y0.Q1().l() != null && this.y0.Q1().O() != null) {
                x15.j().x(getPageContext().getPageActivity(), "pb", this.y0.Q1().l().getId(), og.g(this.y0.Q1().O().getId(), 0L));
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048734, this, view2, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z3) == null) {
            super.onUserChanged(z3);
            this.G0.m4(z3);
            ds4 ds4Var = this.L0;
            if (ds4Var != null) {
                ds4Var.dismiss();
            }
            if (z3 && this.P0) {
                this.G0.v3();
                this.y0.J2(true);
            }
            if (this.G0.A0() != null) {
                this.G0.A0().e0(z3);
            }
        }
    }

    public void p5(int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048736, this, i4, i5) == null) {
            TiebaStatic.log("c12181");
            nx7 nx7Var = this.G0;
            if (nx7Var == null || this.y0 == null) {
                return;
            }
            if ((nx7Var != null && !nx7Var.H1()) || this.y0.Q1() == null || this.y0.Q1().S() == null) {
                return;
            }
            nx7 nx7Var2 = this.G0;
            if (nx7Var2 == null || nx7Var2.G0() == null || !this.G0.G0().r()) {
                tt7 S = this.y0.Q1().S();
                if (checkUpIsLogin()) {
                    if ((!S.f() || S.a() != 2) && this.G0.A0() != null && this.G0.A0().z() != null) {
                        this.G0.A0().z().v(this.y0.i2(), this.y0.getFromForumId());
                    }
                    if (i4 > -1 && i5 > -1) {
                        if (getActivity() == null) {
                            return;
                        }
                        is7 is7Var = new is7(getActivity());
                        View findViewById = getActivity().findViewById(16908290);
                        PbModel pbModel = this.y0;
                        is7Var.m(findViewById, i4, i5, pbModel.b, pbModel.getForumId());
                        is7Var.l(new p0(this));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048737, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public final boolean p7(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        kp4 kp4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048738, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.Q1() == null) {
                return false;
            }
            ft7 Q1 = this.y0.Q1();
            ThreadData O = Q1.O();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !gg6.isOn()) || this.y0.H() || O.isWorksInfo() || O.isScoreThread() || z4) {
                return false;
            }
            if (Q1.l() == null || !Q1.l().isBlockBawuDelete) {
                if (Q1.O() == null || !Q1.O().isBlocked()) {
                    if (Q1.W() != 0) {
                        return Q1.W() != 3;
                    }
                    List<er4> p3 = Q1.p();
                    if (ListUtils.getCount(p3) > 0) {
                        for (er4 er4Var : p3) {
                            if (er4Var != null && (kp4Var = er4Var.g) != null && kp4Var.a && !kp4Var.c && ((i4 = kp4Var.b) == 1 || i4 == 2)) {
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

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void q0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048739, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (gi5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), gi5.class);
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (tx7.c(objArr[i4].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new yf5(drawable), 0, 33, 33);
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
        if (!(interceptable == null || interceptable.invokeV(1048740, this) == null) || this.G0 == null || (pbModel = this.y0) == null) {
            return;
        }
        if ((pbModel.Q1() == null && this.y0.Q1().S() == null) || !checkUpIsLogin() || this.G0.A0() == null || this.G0.A0().z() == null) {
            return;
        }
        this.G0.A0().z().v(this.y0.i2(), this.y0.getFromForumId());
    }

    public boolean q6(int i4) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048741, this, i4)) == null) {
            if (i4 == 1) {
                return true;
            }
            if (this.y0.Q1().V() != null && (forumToolAuth = this.y0.Q1().V().getForumToolAuth()) != null) {
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

    public final boolean q7(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048742, this, z3)) == null) {
            if (z3 || (pbModel = this.y0) == null || pbModel.Q1() == null || (this.y0.Q1().l() != null && this.y0.Q1().l().isBlockBawuDelete)) {
                return false;
            }
            ft7 Q1 = this.y0.Q1();
            if ((Q1.O() == null || Q1.O().getAuthor() == null || !Q1.O().getAuthor().isForumBusinessAccount() || gg6.isOn()) && !this.y0.H()) {
                return ((Q1.O() != null && Q1.O().isBlocked()) || this.y0.Q1().W() == 0 || this.y0.Q1().W() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) ? this.t0 : invokeV.booleanValue;
    }

    public final void r5(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048744, this, str) == null) || (pbModel = this.y0) == null || pbModel.Q1() == null || this.y0.Q1().O() == null || !this.y0.Q1().O().isUgcThreadType()) {
            return;
        }
        ThreadData O = this.y0.Q1().O();
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048745, this, i4)) == null) ? i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 : invokeI.booleanValue;
    }

    public final boolean r7(boolean z3, boolean z4, boolean z5, int i4, boolean z6, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048746, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i4), Boolean.valueOf(z6), Boolean.valueOf(z7)})) == null) {
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

    public final void s5(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048747, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04b0);
            int i4 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                ur4 ur4Var = new ur4(getPageContext().getPageActivity());
                ur4Var.setMessage(string);
                ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04ec, new c2(this));
                ur4Var.setCancelable(true);
                ur4Var.create(getPageContext());
                ur4Var.show();
            } else if (bVar.d != 0) {
                this.G0.w0(0, bVar.a, bVar.b, z3);
            }
            if (bVar.a) {
                int i5 = bVar.d;
                if (i5 == 1) {
                    ArrayList<PostData> F = this.y0.Q1().F();
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
                    this.y0.Q1().O().setReply_num(this.y0.Q1().O().getReply_num() - 1);
                    this.G0.F1(this.y0.Q1());
                } else if (i5 == 0) {
                    i5();
                } else if (i5 == 2) {
                    ArrayList<PostData> F2 = this.y0.Q1().F();
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
                        this.G0.F1(this.y0.Q1());
                    }
                    k5(bVar, this.G0);
                }
            }
        }
    }

    public final boolean s6(int i4) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048748, this, i4)) == null) ? i4 == 2 || i4 == 1 : invokeI.booleanValue;
    }

    public final boolean s7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.g2()) {
                return this.y0.O1() == null || this.y0.O1().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) ? this.k : (VoiceManager) invokeV.objValue;
    }

    public final void t5(int i4, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048751, this, i4, gVar) == null) || gVar == null) {
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
                this.y0.Q1().O().setIs_good(1);
                this.y0.q3(1);
            } else if (i4 == 3) {
                this.y0.Q1().O().setIs_good(0);
                this.y0.q3(0);
            } else if (i4 == 4) {
                this.y0.Q1().O().setIs_top(1);
                this.y0.r3(1);
            } else if (i4 == 5) {
                this.y0.Q1().O().setIs_top(0);
                this.y0.r3(0);
            }
            this.G0.q4(this.y0.Q1(), this.y0.g2());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
            string = gVar.b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f0d04);
        }
        qi.O(getPageContext().getPageActivity(), string);
    }

    public final boolean t6(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048752, this, z3)) == null) {
            PbModel pbModel = this.y0;
            return (pbModel == null || pbModel.Q1() == null || this.y0.Q1().O() == null || this.y0.Q1().O().getAuthor() == null || TextUtils.equals(this.y0.Q1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final void t7(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048753, this, metaData) == null) || metaData == null) {
            return;
        }
        ur4 ur4Var = new ur4(getActivity());
        ur4Var.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0a92));
        ur4Var.setTitleShowCenter(true);
        ur4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0a93));
        ur4Var.setMessageShowCenter(true);
        ur4Var.setCancelable(false);
        ur4Var.setNegativeButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a94), new v1(this, metaData));
        ur4Var.setPositiveButton(getResources().getString(R.string.obfuscated_res_0x7f0f0a95), new w1(this, metaData));
        ur4Var.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048755, this) == null) || (pbModel = this.y0) == null || pi.isEmpty(pbModel.i2())) {
            return;
        }
        super.taskStart();
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.F2();
        }
        return invokeV.booleanValue;
    }

    public final void u5(Rect rect) {
        nx7 nx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048757, this, rect) == null) || rect == null || (nx7Var = this.G0) == null || nx7Var.l1() == null || rect.top > this.G0.l1().getHeight()) {
            return;
        }
        rect.top += this.G0.l1().getHeight() - rect.top;
    }

    public final void u6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void u7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            ur4 ur4Var = new ur4(getPageContext().getPageActivity());
            ur4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b32));
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf5, new c(this));
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new d(this));
            ur4Var.create(this.h1).show();
        }
    }

    @Override // com.repackage.ji5
    public fg<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            if (this.L == null) {
                this.L = new fg<>(new o2(this), 20, 0);
            }
            return this.L;
        }
        return (fg) invokeV.objValue;
    }

    public AntiData v5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.Q1() == null) {
                return null;
            }
            return this.y0.Q1().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void v6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048762, this) == null) || this.S2 == null) {
            return;
        }
        if (this.Q2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0dda);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.Q2, 0)));
            this.a.finish();
        }
    }

    public final void v7(boolean z3, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048763, this, z3, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091fe4) instanceof Integer)) {
            ds4 ds4Var = this.L0;
            if (ds4Var != null && ds4Var.isShowing()) {
                this.L0.dismiss();
                this.L0 = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092040);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue()) {
                fs4 fs4Var = new fs4(getContext());
                fs4Var.n(new h0(this, sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091fe4) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fe4)).intValue() : -1) == 1) {
                    arrayList.add(new bs4(0, getResources().getString(R.string.obfuscated_res_0x7f0f04ab), fs4Var));
                }
                if (z3) {
                    arrayList.add(new bs4(1, getResources().getString(R.string.obfuscated_res_0x7f0f1497), fs4Var));
                } else {
                    arrayList.add(new bs4(1, getResources().getString(R.string.obfuscated_res_0x7f0f0b2f), fs4Var));
                }
                fs4Var.j(arrayList);
                ds4 ds4Var2 = new ds4(getPageContext(), fs4Var);
                this.L0 = ds4Var2;
                ds4Var2.k();
            }
        }
    }

    public final int w5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048764, this)) == null) {
            if (this.y0.Q1() == null || this.y0.Q1().O() == null) {
                return -1;
            }
            return this.y0.Q1().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public void w6(String str) {
        nx7 nx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048765, this, str) == null) || this.y0 == null || StringUtils.isNull(str) || (nx7Var = this.G0) == null) {
            return;
        }
        nx7Var.c3(true);
        this.y0.L2(str);
        this.I = true;
        this.G0.m0();
        this.G0.o1();
    }

    public final void w7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048766, this) == null) {
            showLoadingView(this.G0.m1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bb));
            View j3 = getLoadingView().j();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) j3.getLayoutParams();
            layoutParams.addRule(3, this.G0.l1().getId());
            j3.setLayoutParams(layoutParams);
        }
    }

    public PostData x5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            nx7 nx7Var = this.G0;
            PbModel pbModel = this.y0;
            return nx7Var.I0(pbModel.G, pbModel.g2());
        }
        return (PostData) invokeV.objValue;
    }

    public final void x6(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048768, this, bundle) == null) {
            PbModel b12 = this.a.b1();
            this.y0 = b12;
            if (b12 != null) {
                if (b12.l1() != null) {
                    this.y0.l1().c(this.O2);
                }
                if (this.y0.M1() != null) {
                    this.y0.M1().f(this.y1);
                }
                if (StringUtils.isNull(this.y0.i2())) {
                    this.a.finish();
                } else if (!"from_tieba_kuang".equals(this.M) || this.M == null) {
                } else {
                    this.y0.u3(6);
                }
            }
        }
    }

    public final void x7() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048769, this) == null) && UbsABTestHelper.isPushOpenNewStyle() && j05.g(TbadkCoreApplication.getInst(), 0) && !this.G0.B2()) {
            this.r0 = j05.i(getPageContext(), "reply_pb", 0L);
        }
    }

    @Override // com.repackage.ji5
    public fg<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048770, this)) == null) {
            if (this.F == null) {
                this.F = new fg<>(new c3(this), 15, 0);
            }
            return this.F;
        }
        return (fg) invokeV.objValue;
    }

    @Override // com.repackage.ji5
    public fg<TiebaPlusRecommendCard> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            if (this.E == null) {
                this.E = new fg<>(new p2(this), 5, 0);
            }
            return this.E;
        }
        return (fg) invokeV.objValue;
    }

    public String y5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) ? this.M : (String) invokeV.objValue;
    }

    public final void y6() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048773, this) == null) || this.S2 == null) {
            return;
        }
        if (this.P2 == -1) {
            showToast(R.string.obfuscated_res_0x7f0f0ddb);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.S2.a(), this.P2, 0)));
            this.a.finish();
        }
    }

    public final void y7() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048774, this) == null) {
            if (UbsABTestHelper.isPushOpenNewStyle()) {
                if (NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() || !j05.g(TbadkCoreApplication.getInst(), 0) || this.G0.B2()) {
                    return;
                }
                this.r0 = j05.i(getPageContext(), "collect", 0L);
            } else if (g05.g(getContext(), 0)) {
                g05.i(getPageContext(), 6, 2000L);
            }
        }
    }

    public ry7 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048775, this)) == null) ? this.a.z0() : (ry7) invokeV.objValue;
    }

    public final String z5() {
        InterceptResult invokeV;
        ft7 Q1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || (Q1 = pbModel.Q1()) == null) {
                return null;
            }
            return Q1.T().c;
        }
        return (String) invokeV.objValue;
    }

    public final void z6(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048777, this, view2, str, str2, postData) == null) {
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
                        S5().b1().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fec), postData.s().getName_show(), postData.V() != null ? postData.V().toString() : ""));
                    }
                    if (this.y0.Q1() != null && this.y0.Q1().i0()) {
                        rg.a().postDelayed(new j1(this, str, str2), 0L);
                        return;
                    }
                    if (this.a1 == null) {
                        qo6 qo6Var = new qo6(getPageContext());
                        this.a1 = qo6Var;
                        qo6Var.j(1);
                        this.a1.i(new k1(this, str, str2));
                    }
                    PbModel pbModel = this.y0;
                    if (pbModel == null || pbModel.Q1() == null || this.y0.Q1().l() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 4).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.a1.g(this.y0.Q1().l().getId(), og.g(this.y0.i2(), 0L));
                    return;
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void z7(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && K() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                K().Y0(postWriteCallBackData.getPostId());
                int E0 = this.G0.E0();
                this.r1 = E0;
                this.y0.m3(E0, this.G0.L0());
            }
            this.G0.m0();
            this.K0.c();
            k45 k45Var = this.V0;
            if (k45Var != null) {
                this.G0.Y2(k45Var.C());
            }
            this.G0.q1();
            this.G0.H3(true);
            this.y0.r2();
        }
    }
}
