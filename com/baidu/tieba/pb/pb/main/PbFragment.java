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
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.r0.a0.d;
import d.a.r0.b1.m.f;
import d.a.r0.h.a;
import d.a.r0.r.f0.f;
import d.a.r0.r.q.c1;
import d.a.r0.r.s.a;
import d.a.r0.r.s.b;
import d.a.r0.r.s.l;
import d.a.s0.h2.i.c;
import d.a.s0.h2.k.e.c1.b;
import d.a.s0.h2.k.e.e0;
import d.a.s0.h2.k.e.q;
import d.a.s0.h2.p.e;
import d.a.s0.h3.j0.a;
import d.a.s0.i0.a;
import d.a.s0.i0.b;
import d.a.s0.u0.f2.a.c;
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
public class PbFragment extends BaseFragment implements d.a.r0.b1.m.h, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a.e, TbRichTextView.r, TbPageContextSupport, d.a.s0.h2.o.b, e.b {
    public static /* synthetic */ Interceptable $ic;
    public static final AntiHelper.k D2;
    public static final b.InterfaceC1500b E2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public d.a.s0.h2.k.e.t0 A0;
    public View.OnClickListener A1;
    public int A2;
    public long B;
    public boolean B0;
    public CustomMessageListener B1;
    public String B2;
    public int C;
    public boolean C0;
    public CustomMessageListener C1;
    public d.a.r0.r.q.u C2;
    public String D;
    public boolean D0;
    public CustomMessageListener D1;
    public d.a.c.e.k.b<TextView> E;
    public d.a.s0.h2.k.e.v0 E0;
    public SuggestEmotionModel.c E1;
    public d.a.c.e.k.b<TbImageView> F;
    public d.a.r0.r.s.j F0;
    public CustomMessageListener F1;
    public d.a.c.e.k.b<ImageView> G;
    public d.a.r0.r.s.l G0;
    public GetSugMatchWordsModel.b G1;
    public d.a.c.e.k.b<View> H;
    public String H0;
    public boolean H1;
    public d.a.c.e.k.b<LinearLayout> I;
    public boolean I0;
    public PraiseModel I1;
    public d.a.c.e.k.b<RelativeLayout> J;
    public boolean J0;
    public b.h J1;
    public boolean K;
    public boolean K0;
    public CustomMessageListener K1;
    public boolean L;
    public boolean L0;
    public d.a.r0.f0.i L1;
    public boolean M;
    public boolean M0;
    public CheckRealNameModel.b M1;
    public d.a.c.e.k.b<GifView> N;
    public d.a.s0.h3.h0.f N0;
    public d.a.s0.h2.i.c N1;
    public String O;
    public d.a.r0.w.w.g O0;
    public CustomMessageListener O1;
    public boolean P;
    public d.a.r0.w.w.e P0;
    public CustomMessageListener P1;
    public boolean Q;
    public boolean Q0;
    public CustomMessageListener Q1;
    public String R;
    public PermissionJudgePolicy R0;
    public CustomMessageListener R1;
    public d.a.s0.h2.k.e.b1.f.a S;
    public ReplyPrivacyCheckController S0;
    public CustomMessageListener S1;
    public LikeModel T;
    public d.a.s0.u0.f2.a.c T0;
    public a.e T1;
    public View U;
    public d.a.s0.u0.f2.a.c U0;
    public l.e U1;
    public View V;
    public EmotionImageData V0;
    public SortSwitchButton.f V1;
    public View W;
    public d.a.r0.w.w.c W0;
    public final View.OnClickListener W1;
    public View X;
    public d.a.r0.w.w.b X0;
    public CustomMessageListener X1;
    public String Y;
    public d.a.r0.w.w.b Y0;
    public final NewWriteModel.g Y1;
    public int Z;
    public int Z0;
    public NewWriteModel.g Z1;
    public boolean a0;
    public Object a1;
    public d.a.c.c.g.a a2;
    public int[] b0;
    public d.a.c.a.f b1;
    public final PbModel.g b2;
    public int c0;
    public d.a.r0.r.f0.c c1;
    public CustomMessageListener c2;
    public BdUniqueId d1;
    public HttpMessageListener d2;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19180e;
    public Runnable e1;
    public final a.InterfaceC1243a e2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19181f;
    public d.a.s0.h2.k.e.x0 f1;
    public final AbsListView.OnScrollListener f2;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19182g;
    public d.a.c.k.d.a g1;
    public final d.a.c.a.e g2;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.i0.b f19183h;
    public String h1;
    public final t2 h2;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.h2.k.e.c1.b f19184i;
    public int i0;
    public TbRichTextMemeInfo i1;
    public final f.g i2;
    public boolean j;
    public int j0;
    public boolean j1;
    public boolean j2;
    public boolean k;
    public d.a.r0.r.q.l1 k0;
    public int k1;
    public final BdListView.p k2;
    public boolean l;
    public BdUniqueId l0;
    public int l1;
    public int l2;
    public boolean m;
    public d.a.r0.r.b0.a m0;
    public List<r2> m1;
    public final TbRichTextView.x m2;
    public boolean n;
    public boolean n0;
    public int n1;
    public boolean n2;
    public VoiceManager o;
    public d.a.s0.h3.h0.e o0;
    public String o1;
    public PostData o2;
    public int p;
    public boolean p0;
    public d.a.s0.z.a p1;
    public final b.c p2;
    public d.a.r0.r.s.b q;
    public d.a.s0.h2.k.e.e1.a q0;
    public final r2 q1;
    public final b.c q2;
    public long r;
    public PbInterviewStatusView.f r0;
    public final e0.b r1;
    public final AdapterView.OnItemClickListener r2;
    public long s;
    public final Handler s0;
    public final CustomMessageListener s1;
    public final View.OnLongClickListener s2;
    public long t;
    public PbModel t0;
    public CustomMessageListener t1;
    public final View.OnClickListener t2;
    public long u;
    public d.a.s0.h2.k.f.a u0;
    public CustomMessageListener u1;
    public final ItemCardHelper.b u2;
    public long v;
    public d.a.r0.h.a v0;
    public CustomMessageListener v1;
    public final NoNetworkView.b v2;
    public boolean w;
    public ForumManageModel w0;
    public CustomMessageListener w1;
    public View.OnTouchListener w2;
    public boolean x;
    public d.a.r0.s.e.a x0;
    public CustomMessageListener x1;
    public a.b x2;
    public d.a.r0.m0.b y;
    public d.a.s0.h2.h.s y0;
    public CustomMessageListener y1;
    public final q.b y2;
    public long z;
    public ShareSuccessReplyToServerModel z0;
    public final CustomMessageListener z1;
    public int z2;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19185a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbFragment pbFragment, int i2) {
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
            this.f19185a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.r0.t.n)) {
                this.f19185a.t0.d2((d.a.r0.t.n) customResponsedMessage.getData());
                if (this.f19185a.A0 != null && this.f19185a.t0 != null) {
                    this.f19185a.A0.d2(this.f19185a.t0.D0(), this.f19185a.t0.R0(), this.f19185a.t0.N0(), this.f19185a.A0.R0());
                }
                if (this.f19185a.A0 == null || this.f19185a.A0.l0() == null) {
                    return;
                }
                this.f19185a.A0.l0().V();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19186a;

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
            this.f19186a = pbFragment;
        }

        @Override // d.a.r0.r.s.b.c
        public void a(d.a.r0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f19186a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.f19186a;
                    pbFragment.H0 = pbFragment.H0.trim();
                    UtilHelper.callPhone(this.f19186a.getPageContext().getPageActivity(), this.f19186a.H0);
                    new d.a.s0.h2.k.e.d(this.f19186a.t0.T0(), this.f19186a.H0, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f19186a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    PbFragment pbFragment2 = this.f19186a;
                    pbFragment2.H0 = pbFragment2.H0.trim();
                    UtilHelper.smsPhone(this.f19186a.getPageContext().getPageActivity(), this.f19186a.H0);
                    new d.a.s0.h2.k.e.d(this.f19186a.t0.T0(), this.f19186a.H0, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    PbFragment pbFragment3 = this.f19186a;
                    pbFragment3.H0 = pbFragment3.H0.trim();
                    UtilHelper.startBaiDuBar(this.f19186a.getPageContext().getPageActivity(), this.f19186a.H0);
                    bVar.e();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f19187e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19188f;

        public a1(PbFragment pbFragment, MetaData metaData) {
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
            this.f19188f = pbFragment;
            this.f19187e = metaData;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f19187e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                this.f19188f.x0.m(!this.f19187e.hadConcerned(), this.f19187e.getPortrait(), this.f19187e.getUserId(), this.f19187e.isGod(), "6", this.f19188f.getPageContext().getUniqueId(), this.f19188f.t0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19189e;

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
            this.f19189e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.h(this.f19189e.getContext(), this.f19189e.getUniqueId(), view, (ViewGroup) this.f19189e.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19190a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbFragment pbFragment, int i2) {
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
            this.f19190a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (this.f19190a.A0 == null) {
                return;
            }
            if (booleanValue) {
                this.f19190a.A0.p3();
            } else {
                this.f19190a.A0.d1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19191a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(PbFragment pbFragment, int i2) {
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
            this.f19191a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f19191a.d1) {
                this.f19191a.A0.b1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                d.a.s0.h2.h.e D0 = this.f19191a.t0.D0();
                if (D0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    D0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f19191a.c1.c(this.f19191a.b1.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f19191a.b1.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.f19191a.h6(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f19191a.c6();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.a.c.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f19191a.b1.getResources().getString(R.string.mute_fail);
                    }
                    this.f19191a.c1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19192e;

        public b1(PbFragment pbFragment) {
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
            this.f19192e = pbFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            ArrayList<PostData> E;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || this.f19192e.t0 == null || this.f19192e.t0.D0() == null || this.f19192e.A0 == null || this.f19192e.A0.l0() == null) {
                return;
            }
            this.f19192e.A0.P1(absListView, i2, i3, i4);
            if (this.f19192e.f19184i != null) {
                this.f19192e.f19184i.q(absListView, i2, i3, i4);
            }
            if (!this.f19192e.t0.d1() || (E = this.f19192e.t0.D0().E()) == null || E.isEmpty()) {
                return;
            }
            int w = ((i2 + i3) - this.f19192e.A0.l0().w()) - 1;
            d.a.s0.h2.h.e D0 = this.f19192e.t0.D0();
            if (D0 == null) {
                return;
            }
            if (D0.C() != null && D0.C().C0()) {
                w--;
            }
            if (D0.D() != null && D0.D().C0()) {
                w--;
            }
            int size = E.size();
            if (w < 0 || w >= size) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                PbFragment pbFragment = this.f19192e;
                if (!pbFragment.k5(pbFragment.Z0) && this.f19192e.k5(i2)) {
                    if (this.f19192e.A0 != null) {
                        this.f19192e.A0.a0();
                        if (this.f19192e.P0 != null && !this.f19192e.A0.p1()) {
                            this.f19192e.A0.q2(this.f19192e.P0.C());
                        }
                        if (!this.f19192e.L) {
                            this.f19192e.A0.j2();
                        }
                    }
                    if (!this.f19192e.x) {
                        this.f19192e.x = true;
                    }
                }
                if (this.f19192e.A0 != null) {
                    this.f19192e.A0.Q1(absListView, i2);
                }
                if (this.f19192e.f19184i != null) {
                    this.f19192e.f19184i.r(absListView, i2);
                }
                if (this.f19192e.y == null) {
                    this.f19192e.y = new d.a.r0.m0.b();
                    this.f19192e.y.a(1001);
                }
                if (i2 == 0) {
                    this.f19192e.y.e();
                } else {
                    this.f19192e.y.d();
                }
                this.f19192e.Z0 = i2;
                if (i2 == 0) {
                    this.f19192e.M5(false, null);
                    d.a.s0.g3.c.g().h(this.f19192e.getUniqueId(), true);
                    this.f19192e.X3(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b2 implements ItemCardHelper.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19193a;

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
            this.f19193a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.q(this.f19193a.getContext(), ItemCardHelper.OrderTipStatus.FAIL, (ViewGroup) this.f19193a.getView());
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.b
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.q(this.f19193a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.f19193a.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19194a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbFragment pbFragment, int i2) {
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
            this.f19194a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.f19194a.P0 != null) {
                this.f19194a.A0.q2(this.f19194a.P0.C());
            }
            this.f19194a.A0.Y2(false);
        }
    }

    /* loaded from: classes5.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19195a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(PbFragment pbFragment, int i2) {
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
            this.f19195a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f19195a.d1) {
                this.f19195a.A0.b1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f19195a.c1.c(this.f19195a.b1.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.a.c.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f19195a.b1.getResources().getString(R.string.un_mute_fail);
                }
                this.f19195a.c1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements d.a.r0.w.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19196a;

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
            this.f19196a = pbFragment;
        }

        @Override // d.a.r0.w.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.s0.h2.k.e.v0 v0Var = this.f19196a.E0;
                if (v0Var == null || v0Var.e() == null || !this.f19196a.E0.e().d()) {
                    return !this.f19196a.c4(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.f19196a;
                pbFragment.showToast(pbFragment.E0.e().c());
                if (this.f19196a.P0 != null && (this.f19196a.P0.B() || this.f19196a.P0.D())) {
                    this.f19196a.P0.z(false, this.f19196a.E0.h());
                }
                this.f19196a.E0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c2 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19197e;

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
            this.f19197e = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.f19197e.k && z && !this.f19197e.t0.t0()) {
                    this.f19197e.H5();
                }
                PbFragment pbFragment = this.f19197e;
                pbFragment.setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(pbFragment.getContext(), R.dimen.ds360));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19198a;

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
            this.f19198a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.a.s0.h2.e eVar = (d.a.s0.h2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                this.f19198a.G5((d.a.s0.h2.h.r) eVar.a());
            } else if (b2 == 1) {
                this.f19198a.o4((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    this.f19198a.F5(false, null);
                } else {
                    this.f19198a.F5(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19199a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(PbFragment pbFragment, int i2) {
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
            this.f19199a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.s0.s3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f19199a.d1) {
                d.a.s0.s3.a aVar = (d.a.s0.s3.a) customResponsedMessage.getData();
                this.f19199a.A0.b1();
                SparseArray<Object> sparseArray = (SparseArray) this.f19199a.a1;
                DataRes dataRes = aVar.f65437a;
                if (aVar.f65439c == 0 && dataRes != null) {
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
                    this.f19199a.d6(r2, sparseArray);
                } else if (intValue == 1) {
                    this.f19199a.A0.V1(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements Comparator<d.a.r0.t.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19200e;

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
            this.f19200e = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a.r0.t.a aVar, d.a.r0.t.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) ? aVar.compareTo(aVar2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d2 implements d.a.c.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19201a;

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
            this.f19201a = pbFragment;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.f19201a.getPageContext().getPageActivity());
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

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19202a;

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
            this.f19202a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19202a.A0 == null || this.f19202a.A0.l0() == null) {
                return;
            }
            this.f19202a.A0.l0().V();
        }
    }

    /* loaded from: classes5.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19203a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(PbFragment pbFragment, int i2) {
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
            this.f19203a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f19203a.A0.p1() && (customResponsedMessage.getData() instanceof Integer)) {
                this.f19203a.l4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19204a;

        public e1(PbFragment pbFragment) {
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
            this.f19204a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e2 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19205e;

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
            this.f19205e = pbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                FrameLayout frameLayout = (FrameLayout) this.f19205e.getPageContext().getPageActivity().getWindow().getDecorView();
                for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                    View childAt = frameLayout.getChildAt(i2);
                    if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                        break;
                    }
                }
                this.f19205e.f19183h.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19206a;

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
            this.f19206a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                d.a.r0.b1.m.f.c(this.f19206a.getPageContext(), this.f19206a, aVar.f55046a, aVar.f55047b, aVar.f55048c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19207a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(PbFragment pbFragment, int i2) {
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
            this.f19207a = pbFragment;
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
            this.f19207a.j1 = true;
        }
    }

    /* loaded from: classes5.dex */
    public class f1 extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19208a;

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
            this.f19208a = pbFragment;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.f19208a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.f19208a.w0.getLoadDataMode()) {
                        case 0:
                            this.f19208a.t0.Z0();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.f19208a.o4(bVar, (bVar.f21137e != 1002 || bVar.f21138f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.f19208a.A0.i0(1, dVar.f21140a, dVar.f21141b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.f19208a;
                            pbFragment.p4(pbFragment.w0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.f19208a.A0.i0(this.f19208a.w0.getLoadDataMode(), gVar.f21154a, gVar.f21155b, false);
                            this.f19208a.A0.R1(gVar.f21156c);
                            return;
                        default:
                            return;
                    }
                }
                this.f19208a.A0.i0(this.f19208a.w0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f2 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f19209a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19210b;

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
            this.f19210b = pbFragment;
            this.f19209a = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds98);
        }

        @Override // d.a.s0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || !e(i3) || this.f19210b.A0 == null || this.f19210b.f19184i == null) {
                return;
            }
            this.f19210b.f19184i.u(true);
            if (Math.abs(i3) > this.f19209a) {
                this.f19210b.f19184i.l();
            }
            if (this.f19210b.D4()) {
                this.f19210b.A0.c1();
                this.f19210b.A0.l2();
            }
        }

        @Override // d.a.s0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || !e(i3) || this.f19210b.A0 == null || this.f19210b.f19184i == null) {
                return;
            }
            this.f19210b.A0.n3();
            this.f19210b.f19184i.u(false);
            this.f19210b.f19184i.x();
        }

        @Override // d.a.s0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // d.a.s0.i0.a.b
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

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19211a;

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
            this.f19211a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19211a.k) {
                return;
            }
            this.f19211a.j6();
        }
    }

    /* loaded from: classes5.dex */
    public static class g0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g0() {
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
        public void onNavigationButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19212e;

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
            this.f19212e = pbFragment;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class g2 implements b.InterfaceC1500b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g2() {
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

        @Override // d.a.s0.i0.b.InterfaceC1500b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    d.a.s0.h2.i.b.d();
                } else {
                    d.a.s0.h2.i.b.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19213e;

        public h(PbFragment pbFragment) {
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
            this.f19213e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PbFragment pbFragment = this.f19213e;
                pbFragment.showToast(pbFragment.D);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19214e;

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
            this.f19214e = pbFragment;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19214e.Z4();
                d.a.r0.r.q.a1 B0 = this.f19214e.t0.B0();
                int H0 = this.f19214e.A0.H0();
                if (H0 <= 0) {
                    this.f19214e.showToast(R.string.pb_page_error);
                } else if (B0 == null || H0 <= B0.h()) {
                    this.f19214e.A0.a0();
                    this.f19214e.m6();
                    this.f19214e.A0.M2();
                    if (d.a.c.e.p.j.z()) {
                        this.f19214e.t0.V1(this.f19214e.A0.H0());
                        if (this.f19214e.f19184i != null) {
                            this.f19214e.f19184i.x();
                        }
                    } else {
                        this.f19214e.showToast(R.string.neterror);
                    }
                    aVar.dismiss();
                } else {
                    this.f19214e.showToast(R.string.pb_page_error);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements t2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19215a;

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
            this.f19215a = pbFragment;
        }
    }

    /* loaded from: classes5.dex */
    public class h2 implements q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19216a;

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
            this.f19216a = pbFragment;
        }

        @Override // d.a.s0.h2.k.e.q.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i2 == 0) {
                        this.f19216a.showToast(R.string.upgrage_toast_dialog);
                    } else {
                        this.f19216a.showToast(R.string.neterror);
                    }
                } else if (i2 != 0 && !TextUtils.isEmpty(str2)) {
                    this.f19216a.A0.Y(str);
                } else {
                    this.f19216a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19217a;

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
            this.f19217a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.r0.r.q.j0)) {
                d.a.r0.r.q.j0 j0Var = (d.a.r0.r.q.j0) customResponsedMessage.getData();
                c1.a aVar = new c1.a();
                int i2 = j0Var.f55981a;
                String str = j0Var.f55982b;
                aVar.f55894a = j0Var.f55984d;
                d.a.s0.h2.h.e D0 = this.f19217a.t0.D0();
                if (D0 == null) {
                    return;
                }
                if (this.f19217a.t0.h0() != null && this.f19217a.t0.h0().getUserIdLong() == j0Var.p) {
                    this.f19217a.A0.c2(j0Var.l, this.f19217a.t0.D0(), this.f19217a.t0.R0(), this.f19217a.t0.N0());
                }
                if (D0.E() == null || D0.E().size() < 1 || D0.E().get(0) == null) {
                    return;
                }
                long f2 = d.a.c.e.m.b.f(D0.E().get(0).E(), 0L);
                long f3 = d.a.c.e.m.b.f(this.f19217a.t0.T0(), 0L);
                if (f2 == j0Var.n && f3 == j0Var.m) {
                    d.a.r0.r.q.c1 D = D0.E().get(0).D();
                    if (D == null) {
                        D = new d.a.r0.r.q.c1();
                    }
                    ArrayList<c1.a> a2 = D.a();
                    if (a2 == null) {
                        a2 = new ArrayList<>();
                    }
                    a2.add(0, aVar);
                    D.e(D.b() + j0Var.l);
                    D.d(a2);
                    D0.E().get(0).k0(D);
                    this.f19217a.A0.l0().V();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19218e;

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
            this.f19218e = pbFragment;
        }

        @Override // d.a.r0.r.s.l.e
        public void onItemClick(d.a.r0.r.s.l lVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (this.f19218e.F0 != null) {
                    this.f19218e.F0.dismiss();
                }
                this.f19218e.p6(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                        this.f19218e.D5(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                        this.f19218e.D5(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        if (view4 != null) {
                            AgreeView agreeView = (AgreeView) view4;
                            this.f19218e.D5(view4);
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
                            this.f19218e.D5(view5);
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
                        if (this.f19218e.g1 == null || TextUtils.isEmpty(this.f19218e.h1)) {
                            return;
                        }
                        if (this.f19218e.i1 == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f19218e.h1));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f54736a = this.f19218e.h1;
                            String str = "";
                            if (this.f19218e.i1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f19218e.i1.memeInfo.pck_id;
                            }
                            aVar.f54737b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f19218e.g1 = null;
                        this.f19218e.h1 = null;
                        return;
                    case 2:
                        if (this.f19218e.g1 == null || TextUtils.isEmpty(this.f19218e.h1)) {
                            return;
                        }
                        if (this.f19218e.R0 == null) {
                            this.f19218e.R0 = new PermissionJudgePolicy();
                        }
                        this.f19218e.R0.clearRequestPermissionList();
                        this.f19218e.R0.appendRequestPermission(this.f19218e.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (this.f19218e.R0.startRequestPermission(this.f19218e.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f19218e.f1 == null) {
                            PbFragment pbFragment = this.f19218e;
                            pbFragment.f1 = new d.a.s0.h2.k.e.x0(pbFragment.getPageContext());
                        }
                        this.f19218e.f1.b(this.f19218e.h1, this.f19218e.g1.n());
                        this.f19218e.g1 = null;
                        this.f19218e.h1 = null;
                        return;
                    case 3:
                        PbFragment pbFragment2 = this.f19218e;
                        PostData postData = pbFragment2.o2;
                        if (postData != null) {
                            postData.h0(pbFragment2.getPageContext().getPageActivity());
                            this.f19218e.o2 = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f19218e.checkUpIsLogin()) {
                            this.f19218e.u5(view);
                            if (this.f19218e.t0.D0().N() == null || this.f19218e.t0.D0().N().H() == null || this.f19218e.t0.D0().N().H().getUserId() == null || this.f19218e.v0 == null) {
                                return;
                            }
                            PbFragment pbFragment3 = this.f19218e;
                            int S4 = pbFragment3.S4(pbFragment3.t0.D0());
                            d.a.r0.r.q.b2 N = this.f19218e.t0.D0().N();
                            if (N.E1()) {
                                i3 = 2;
                            } else if (N.H1()) {
                                i3 = 3;
                            } else if (!N.F1()) {
                                i3 = N.G1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f19218e.t0.f19381e).param("obj_locate", 2).param("obj_id", this.f19218e.t0.D0().N().H().getUserId()).param("obj_type", !this.f19218e.v0.e()).param("obj_source", S4).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!d.a.c.e.p.j.z()) {
                            this.f19218e.showToast(R.string.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f19218e.X4((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.f19218e.a4(sparseArray2);
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
                            boolean isHost = this.f19218e.z().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f19218e.X5(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f19218e.A0.U1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f19218e.X5(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f19218e.A0.S1(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!d.a.c.e.p.j.z()) {
                            this.f19218e.showToast(R.string.network_not_available);
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
                                this.f19218e.A0.S1(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.tag_from, 1);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f19218e.a4(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f19218e.A0.W1(view);
                            return;
                        }
                    case 8:
                        if (this.f19218e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.f19218e.d4(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.f19218e.checkUpIsLogin() || this.f19218e.t0 == null || this.f19218e.t0.D0() == null) {
                            return;
                        }
                        this.f19218e.f19180e.showBlockDialog(d.a.s0.r3.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19219e;

        public i1(PbFragment pbFragment) {
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
            this.f19219e = pbFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f19219e.D4()) {
                    this.f19219e.f19180e.finish();
                }
                if (!this.f19219e.t0.p1(true)) {
                    this.f19219e.A0.h0();
                } else {
                    TiebaStatic.eventStat(this.f19219e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19220e;

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
            this.f19220e = pbFragment;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.f19220e.b1).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f19220e.b1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19221a;

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
            this.f19221a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19221a.t0 == null || this.f19221a.t0.D0() == null) {
                return;
            }
            this.f19221a.t0.D0().a();
            this.f19221a.t0.Z0();
            if (this.f19221a.A0.l0() != null) {
                this.f19221a.A0.n1(this.f19221a.t0.D0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f19223f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f19224g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19225h;

        public j0(PbFragment pbFragment, SparseArray sparseArray, int i2, boolean z) {
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
            this.f19225h = pbFragment;
            this.f19222e = sparseArray;
            this.f19223f = i2;
            this.f19224g = z;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f19225h.k4(((Integer) this.f19222e.get(R.id.tag_del_post_type)).intValue(), (String) this.f19222e.get(R.id.tag_del_post_id), this.f19223f, this.f19224g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19226e;

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
            this.f19226e = pbFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19226e.j2 && this.f19226e.D4()) {
                    this.f19226e.n5();
                }
                if (this.f19226e.mIsLogin) {
                    if (!this.f19226e.n0 && this.f19226e.A0 != null && this.f19226e.A0.S() && this.f19226e.t0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.f19226e.t0.T0());
                        statisticItem.param("fid", this.f19226e.t0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i2 = 5;
                        if (this.f19226e.t0.j0()) {
                            i2 = 4;
                        } else if (this.f19226e.t0.k0()) {
                            i2 = 3;
                        } else if (this.f19226e.t0.m0()) {
                            i2 = 1;
                        }
                        statisticItem.param("obj_type", i2);
                        TiebaStatic.log(statisticItem);
                        this.f19226e.n0 = true;
                    }
                    if (this.f19226e.t0.l1(false)) {
                        this.f19226e.A0.N2();
                        TiebaStatic.eventStat(this.f19226e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if (this.f19226e.q0 == null || !this.f19226e.q0.d()) {
                        if (this.f19226e.t0.D0() != null) {
                            this.f19226e.A0.f2();
                        }
                    } else {
                        this.f19226e.A0.N2();
                    }
                    this.f19226e.j2 = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j2 implements e0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19227a;

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
            this.f19227a = pbFragment;
        }

        @Override // d.a.s0.h2.k.e.e0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f19227a.A0.u3(str);
        }

        @Override // d.a.s0.h2.k.e.e0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements PbInterviewStatusView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19228a;

        public k(PbFragment pbFragment) {
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
            this.f19228a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.view.PbInterviewStatusView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f19228a.A0.r3(!this.f19228a.P);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19229e;

        public k0(PbFragment pbFragment) {
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
            this.f19229e = pbFragment;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19230e;

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
            this.f19230e = pbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19230e.t0 == null) {
                return;
            }
            this.f19230e.t0.LoadData();
        }
    }

    /* loaded from: classes5.dex */
    public class k2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19231e;

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
            this.f19231e = pbFragment;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19232a;

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
            this.f19232a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19232a.t0 == null || this.f19232a.t0.D0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.f19232a.h4(str);
            this.f19232a.t0.Z0();
            if (!TextUtils.isEmpty(str) && this.f19232a.t0.D0().E() != null) {
                ArrayList<PostData> E = this.f19232a.t0.D0().E();
                d.a.s0.h3.h0.o oVar = null;
                Iterator<PostData> it = E.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof d.a.s0.h3.h0.o) {
                        d.a.s0.h3.h0.o oVar2 = (d.a.s0.h3.h0.o) next;
                        if (str.equals(oVar2.D0())) {
                            oVar = oVar2;
                            break;
                        }
                    }
                }
                if (oVar != null) {
                    E.remove(oVar);
                    if (this.f19232a.A0.l0() != null && this.f19232a.A0.l0().s() != null) {
                        this.f19232a.A0.l0().s().remove(oVar);
                    }
                    if (this.f19232a.A0.B0() != null && this.f19232a.A0.B0().getData() != null) {
                        this.f19232a.A0.B0().getData().remove(oVar);
                    }
                    if (this.f19232a.A0.l0() != null) {
                        this.f19232a.A0.l0().V();
                        return;
                    }
                }
            }
            if (this.f19232a.A0.l0() != null) {
                this.f19232a.A0.n1(this.f19232a.t0.D0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19233a;

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
            this.f19233a = pbFragment;
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f19233a.P0 != null && this.f19233a.P0.a() != null) {
                    this.f19233a.P0.a().A(new d.a.r0.w.a(45, 27, null));
                }
                this.f19233a.A0.T();
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19234a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f19235e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ l1 f19236f;

            public a(l1 l1Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l1Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19236f = l1Var;
                this.f19235e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d.a.s0.h2.j.c.a(this.f19236f.f19234a.getPageContext(), this.f19235e).show();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19234a = pbFragment;
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
                d.a.c.e.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19237e;

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
            this.f19237e = pbFragment;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements SuggestEmotionModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19238a;

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
            this.f19238a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(d.a.s0.h2.k.e.b1.e.a aVar) {
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

    /* loaded from: classes5.dex */
    public class m0 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19239a;

        public m0(PbFragment pbFragment) {
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
            this.f19239a = pbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f19239a.A0.a0();
                boolean z = false;
                if (d.a.c.e.p.j.z()) {
                    if (this.f19239a.t0 != null && !this.f19239a.t0.isLoading) {
                        this.f19239a.m6();
                        this.f19239a.A0.M2();
                        z = true;
                        if (this.f19239a.t0.D0() != null && this.f19239a.t0.D0().f60142f != null && this.f19239a.t0.D0().f60142f.size() > i2) {
                            int intValue = this.f19239a.t0.D0().f60142f.get(i2).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.f19239a.t0.U0()).param("fid", this.f19239a.t0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.f19239a.t0.b2(intValue)) {
                                this.f19239a.m = true;
                                this.f19239a.A0.A2(true);
                            }
                        }
                    }
                    return z;
                }
                this.f19239a.showToast(R.string.network_not_available);
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

    /* loaded from: classes5.dex */
    public class m1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19240e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f19241f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f19242g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19243h;

        public m1(PbFragment pbFragment, MarkData markData, MarkData markData2, d.a.r0.r.s.a aVar) {
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
            this.f19243h = pbFragment;
            this.f19240e = markData;
            this.f19241f = markData2;
            this.f19242g = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f19243h.v0 != null) {
                    if (this.f19243h.v0.e()) {
                        this.f19243h.v0.d();
                        this.f19243h.v0.h(false);
                    }
                    this.f19243h.v0.i(this.f19240e);
                    this.f19243h.v0.h(true);
                    this.f19243h.v0.a();
                }
                this.f19241f.setPostId(this.f19240e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19241f);
                this.f19243h.f19180e.setResult(-1, intent);
                this.f19242g.dismiss();
                this.f19243h.n6();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f19244e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19245f;

        public m2(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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
            this.f19245f = pbFragment;
            this.f19244e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f19245f.A0.f3();
                MessageManager.getInstance().sendMessage(this.f19244e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19246a;

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
            this.f19246a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue() || this.f19246a.A0 == null || this.f19246a.t0 == null) {
                return;
            }
            this.f19246a.A0.U(false);
            if (this.f19246a.t0.l1(false)) {
                this.f19246a.A0.N2();
            } else if (this.f19246a.t0.D0() != null) {
                this.f19246a.A0.f2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f19247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f19248f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19249g;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ n0 f19250e;

            public a(n0 n0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19250e = n0Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.a.s0.h2.k.e.v0 v0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19250e.f19249g.E0) == null || v0Var.g() == null) {
                    return;
                }
                if (!this.f19250e.f19249g.E0.g().e()) {
                    this.f19250e.f19249g.E0.b(false);
                }
                this.f19250e.f19249g.E0.g().l(false);
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

        public n0(PbFragment pbFragment, String str, String str2) {
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
            this.f19249g = pbFragment;
            this.f19247e = str;
            this.f19248f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = d.a.c.e.p.l.i(this.f19249g.f19180e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = d.a.c.e.p.l.g(this.f19249g.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = d.a.c.e.p.l.g(this.f19249g.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                PbFragment pbFragment = this.f19249g;
                boolean z = true;
                pbFragment.P4().B0().smoothScrollBy((pbFragment.b0[1] + pbFragment.c0) - i4, 50);
                if (this.f19249g.P4().K0() != null) {
                    this.f19249g.P0.a().setVisibility(8);
                    this.f19249g.P4().K0().n(this.f19247e, this.f19248f, this.f19249g.P4().N0(), (this.f19249g.t0 == null || this.f19249g.t0.D0() == null || this.f19249g.t0.D0().N() == null || !this.f19249g.t0.D0().N().I1()) ? false : false);
                    d.a.r0.w.w.h b2 = this.f19249g.P4().K0().b();
                    if (b2 != null && this.f19249g.t0 != null && this.f19249g.t0.D0() != null) {
                        b2.E(this.f19249g.t0.D0().d());
                        b2.X(this.f19249g.t0.D0().N());
                    }
                    if (this.f19249g.E0.f() == null && this.f19249g.P4().K0().b().s() != null) {
                        this.f19249g.P4().K0().b().s().g(new a(this));
                        PbFragment pbFragment2 = this.f19249g;
                        pbFragment2.E0.n(pbFragment2.P4().K0().b().s().i());
                        this.f19249g.P4().K0().b().K(this.f19249g.Y0);
                    }
                }
                this.f19249g.P4().X0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements d.a.r0.w.w.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19251a;

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
            this.f19251a = pbFragment;
        }

        @Override // d.a.r0.w.w.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.s0.h2.k.e.v0 v0Var = this.f19251a.E0;
                if (v0Var == null || v0Var.g() == null || !this.f19251a.E0.g().d()) {
                    return !this.f19251a.c4(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.f19251a;
                pbFragment.showToast(pbFragment.E0.g().c());
                if (this.f19251a.A0 != null && this.f19251a.A0.K0() != null && this.f19251a.A0.K0().b() != null && this.f19251a.A0.K0().b().v()) {
                    this.f19251a.A0.K0().b().t(this.f19251a.E0.h());
                }
                this.f19251a.E0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class n2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19252e;

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
            this.f19252e = pbFragment;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements GetSugMatchWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19253a;

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
            this.f19253a = pbFragment;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.f19253a.A0 == null) {
                return;
            }
            this.f19253a.A0.T2(list);
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f19254a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19255b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19256c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o0 f19257e;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$o0$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0231a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f19258e;

                public C0231a(a aVar) {
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
                    this.f19258e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    d.a.s0.h2.k.e.v0 v0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f19258e.f19257e.f19256c.E0) == null || v0Var.g() == null) {
                        return;
                    }
                    if (!this.f19258e.f19257e.f19256c.E0.g().e()) {
                        this.f19258e.f19257e.f19256c.E0.b(false);
                    }
                    this.f19258e.f19257e.f19256c.E0.g().l(false);
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

            public a(o0 o0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19257e = o0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = d.a.c.e.p.l.i(this.f19257e.f19256c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i2 = i3 / 2;
                        g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i4 = i3 - (i2 + g2);
                    PbFragment pbFragment = this.f19257e.f19256c;
                    boolean z = true;
                    pbFragment.P4().B0().smoothScrollBy((pbFragment.b0[1] + pbFragment.c0) - i4, 50);
                    if (this.f19257e.f19256c.P4().K0() != null) {
                        this.f19257e.f19256c.P0.a().setVisibility(8);
                        z = (this.f19257e.f19256c.t0 == null || this.f19257e.f19256c.t0.D0() == null || this.f19257e.f19256c.t0.D0().N() == null || !this.f19257e.f19256c.t0.D0().N().I1()) ? false : false;
                        d.a.s0.h2.k.e.u K0 = this.f19257e.f19256c.P4().K0();
                        o0 o0Var = this.f19257e;
                        K0.n(o0Var.f19254a, o0Var.f19255b, o0Var.f19256c.P4().N0(), z);
                        d.a.r0.w.w.h b2 = this.f19257e.f19256c.P4().K0().b();
                        if (b2 != null && this.f19257e.f19256c.t0 != null && this.f19257e.f19256c.t0.D0() != null) {
                            b2.E(this.f19257e.f19256c.t0.D0().d());
                            b2.X(this.f19257e.f19256c.t0.D0().N());
                        }
                        if (this.f19257e.f19256c.E0.f() == null && this.f19257e.f19256c.P4().K0().b().s() != null) {
                            this.f19257e.f19256c.P4().K0().b().s().g(new C0231a(this));
                            PbFragment pbFragment2 = this.f19257e.f19256c;
                            pbFragment2.E0.n(pbFragment2.P4().K0().b().s().i());
                            this.f19257e.f19256c.P4().K0().b().K(this.f19257e.f19256c.Y0);
                        }
                    }
                    this.f19257e.f19256c.P4().X0();
                }
            }
        }

        public o0(PbFragment pbFragment, String str, String str2) {
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
            this.f19256c = pbFragment;
            this.f19254a = str;
            this.f19255b = str2;
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                d.a.c.e.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f19260f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19261g;

        public o1(PbFragment pbFragment, MarkData markData, d.a.r0.r.s.a aVar) {
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
            this.f19261g = pbFragment;
            this.f19259e = markData;
            this.f19260f = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f19259e);
                this.f19261g.f19180e.setResult(-1, intent);
                this.f19260f.dismiss();
                this.f19261g.n6();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o2 extends d.a.r0.z0.f0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19262a;

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
            this.f19262a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return d.a.s0.h2.k.e.f1.b.c(this.f19262a.getContext(), this.f19262a.s4(), ShareSwitch.isOn() ? 1 : 6, this.f19262a.t0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p implements PraiseModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19263a;

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
            this.f19263a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f19263a.H1 = false;
                if (this.f19263a.I1 == null) {
                    return;
                }
                d.a.s0.h2.h.e D0 = this.f19263a.t0.D0();
                if (D0.N().G0().getIsLike() == 1) {
                    this.f19263a.s6(0);
                } else {
                    this.f19263a.s6(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, D0.N()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f19263a.H1 = false;
                if (this.f19263a.I1 == null || str == null) {
                    return;
                }
                if (AntiHelper.m(i2, str)) {
                    AntiHelper.u(this.f19263a.getPageContext().getPageActivity(), str);
                } else {
                    this.f19263a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19264e;

        /* loaded from: classes5.dex */
        public class a implements l.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.r0.r.s.j f19265e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ View f19266f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ p0 f19267g;

            public a(p0 p0Var, d.a.r0.r.s.j jVar, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p0Var, jVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19267g = p0Var;
                this.f19265e = jVar;
                this.f19266f = view;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.f19267g.f19264e.t0.Q0() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // d.a.r0.r.s.l.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(d.a.r0.r.s.l lVar, int i2, View view) {
                boolean b2;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, lVar, i2, view) != null) {
                    return;
                }
                this.f19265e.dismiss();
                int i3 = 3;
                if (this.f19267g.f19264e.t0.Q0() != 1 || i2 != 1) {
                    if (this.f19267g.f19264e.t0.Q0() == 2 && i2 == 0) {
                        i3 = 1;
                    } else if (this.f19267g.f19264e.t0.Q0() == 3 && i2 != 2) {
                        i3 = 2;
                    } else if (i2 == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f19266f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                    if (this.f19267g.f19264e.t0.D0().f60142f != null && this.f19267g.f19264e.t0.D0().f60142f.size() > i2) {
                        i2 = this.f19267g.f19264e.t0.D0().f60142f.get(i2).sort_type.intValue();
                    }
                    b2 = this.f19267g.f19264e.t0.b2(i2);
                    this.f19266f.setTag(Integer.valueOf(this.f19267g.f19264e.t0.P0()));
                    if (b2) {
                        return;
                    }
                    this.f19267g.f19264e.m = true;
                    this.f19267g.f19264e.A0.A2(true);
                    return;
                }
                i3 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f19266f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f19267g.f19264e.t0.D0().f60142f != null) {
                    i2 = this.f19267g.f19264e.t0.D0().f60142f.get(i2).sort_type.intValue();
                }
                b2 = this.f19267g.f19264e.t0.b2(i2);
                this.f19266f.setTag(Integer.valueOf(this.f19267g.f19264e.t0.P0()));
                if (b2) {
                }
            }
        }

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
            this.f19264e = pbFragment;
        }

        /* JADX WARN: Code restructure failed: missing block: B:838:0x1d99, code lost:
            if (r36.f19264e.A0.Q0.f60717c.a().getTop() <= ((r36.f19264e.A0.L0() == null || r36.f19264e.A0.L0().c() == null) ? 0 : r36.f19264e.A0.L0().c().getBottom())) goto L787;
         */
        /* JADX WARN: Code restructure failed: missing block: B:839:0x1d9b, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:841:0x1da4, code lost:
            if (r0 >= r36.f19264e.t4()) goto L787;
         */
        /* JADX WARN: Code restructure failed: missing block: B:863:0x1e4b, code lost:
            if ((r36.f19264e.A0.Q0.f60717c.a().getTop() - r36.f19264e.A0.f60675h.f60557a.getBottom()) < (r36.f19264e.A0.Q0.f60717c.f19422g.getHeight() + 10)) goto L787;
         */
        /* JADX WARN: Removed duplicated region for block: B:1106:0x26ea  */
        /* JADX WARN: Removed duplicated region for block: B:1107:0x26ff  */
        /* JADX WARN: Removed duplicated region for block: B:1110:0x2738  */
        /* JADX WARN: Removed duplicated region for block: B:285:0x091d  */
        /* JADX WARN: Removed duplicated region for block: B:286:0x0922  */
        /* JADX WARN: Removed duplicated region for block: B:289:0x0930  */
        /* JADX WARN: Removed duplicated region for block: B:324:0x09e7  */
        /* JADX WARN: Removed duplicated region for block: B:327:0x09fa  */
        /* JADX WARN: Removed duplicated region for block: B:330:0x0a0c  */
        /* JADX WARN: Removed duplicated region for block: B:332:0x0a14  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            d.a.r0.r.s.h hVar;
            d.a.r0.r.s.h hVar2;
            d.a.r0.r.s.h hVar3;
            PbFragment pbFragment;
            int i2;
            boolean z;
            d.a.r0.r.s.h hVar4;
            d.a.r0.r.s.h hVar5;
            d.a.r0.r.s.h hVar6;
            String name;
            int i3;
            boolean z2;
            int fixedNavHeight;
            int i4;
            d.a.r0.r.q.g2 g2Var;
            String[] strArr;
            d.a.s0.h2.h.e D0;
            int i5;
            int i6;
            boolean a2;
            int i7;
            int i8;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f19264e.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == this.f19264e.A0.F0()) {
                        if (this.f19264e.m) {
                            return;
                        }
                        if (this.f19264e.t0.l1(true)) {
                            this.f19264e.m = true;
                            this.f19264e.A0.N2();
                        }
                    } else if (this.f19264e.A0.f60675h.g() == null || view != this.f19264e.A0.f60675h.g().l()) {
                        if (this.f19264e.A0.f60675h.g() == null || view != this.f19264e.A0.f60675h.g().d()) {
                            if (view == this.f19264e.A0.f60675h.f60562f) {
                                if (this.f19264e.A0.R(this.f19264e.t0.r0())) {
                                    this.f19264e.m6();
                                    return;
                                }
                                this.f19264e.n = false;
                                this.f19264e.j = false;
                                d.a.c.e.p.l.x(this.f19264e.f19180e, this.f19264e.A0.f60675h.f60562f);
                                this.f19264e.f19180e.finish();
                            } else if (view != this.f19264e.A0.n0() && (this.f19264e.A0.f60675h.g() == null || (view != this.f19264e.A0.f60675h.g().m() && view != this.f19264e.A0.f60675h.g().n()))) {
                                if (view == this.f19264e.A0.v0()) {
                                    if (this.f19264e.t0 != null) {
                                        d.a.r0.l.a.l(this.f19264e.getPageContext().getPageActivity(), this.f19264e.t0.D0().N().q1().b());
                                    }
                                } else if (view != this.f19264e.A0.f60675h.f60559c) {
                                    if (view == this.f19264e.A0.f60675h.f60560d) {
                                        if (d.a.r0.z0.l.a()) {
                                            return;
                                        }
                                        if (this.f19264e.t0 != null && this.f19264e.t0.D0() != null) {
                                            ArrayList<PostData> E = this.f19264e.t0.D0().E();
                                            if ((E == null || E.size() <= 0) && this.f19264e.t0.R0()) {
                                                d.a.c.e.p.l.M(this.f19264e.getPageContext().getPageActivity(), this.f19264e.getPageContext().getString(R.string.pb_no_data_tips));
                                                return;
                                            }
                                            TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f19264e.t0.T0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f19264e.t0.getForumId()));
                                            if (!this.f19264e.A0.z1()) {
                                                this.f19264e.A0.j2();
                                            }
                                            this.f19264e.z5();
                                        } else {
                                            d.a.c.e.p.l.M(this.f19264e.getPageContext().getPageActivity(), this.f19264e.getPageContext().getString(R.string.pb_no_data_tips));
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_god_user_tip_content) {
                                        if (d.a.c.e.p.j.z()) {
                                            this.f19264e.A0.x2(true);
                                            this.f19264e.A0.j2();
                                            if (this.f19264e.m) {
                                                return;
                                            }
                                            this.f19264e.m = true;
                                            this.f19264e.A0.p3();
                                            this.f19264e.m6();
                                            this.f19264e.A0.M2();
                                            this.f19264e.t0.Z1(this.f19264e.y4());
                                            TiebaStatic.eventStat(this.f19264e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                        } else {
                                            this.f19264e.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    } else if (view.getId() != R.id.pb_editor_tool_collection) {
                                        if ((this.f19264e.A0.f60675h.g() == null || view != this.f19264e.A0.f60675h.g().i()) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                                            if (this.f19264e.A0.f60675h.g() != null && view == this.f19264e.A0.f60675h.g().e()) {
                                                this.f19264e.A0.f60675h.e();
                                            } else if (view.getId() == R.id.share_num_container) {
                                                if (!this.f19264e.Z3(11009)) {
                                                    return;
                                                }
                                                this.f19264e.b5(3);
                                            } else if (view.getId() != R.id.pb_editor_tool_share) {
                                                if (this.f19264e.A0.f60675h.g() == null || view != this.f19264e.A0.f60675h.g().k()) {
                                                    if (this.f19264e.A0.f60675h.g() == null || view != this.f19264e.A0.f60675h.g().r()) {
                                                        if (this.f19264e.A0.f60675h.g() == null || view != this.f19264e.A0.f60675h.g().q()) {
                                                            if (this.f19264e.A0.f60675h.g() == null || view != this.f19264e.A0.f60675h.g().o()) {
                                                                if (this.f19264e.A0.y0() == view) {
                                                                    if (this.f19264e.A0.y0().getIndicateStatus()) {
                                                                        d.a.s0.h2.h.e D02 = this.f19264e.t0.D0();
                                                                        if (D02 != null && D02.N() != null && D02.N().e1() != null) {
                                                                            String d2 = D02.N().e1().d();
                                                                            if (StringUtils.isNull(d2)) {
                                                                                d2 = D02.N().e1().f();
                                                                            }
                                                                            TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d2));
                                                                        }
                                                                    } else {
                                                                        d.a.s0.h3.j0.a.d("c10725", null);
                                                                    }
                                                                    this.f19264e.U4();
                                                                } else if (this.f19264e.A0.f60675h.g() == null || view != this.f19264e.A0.f60675h.g().h()) {
                                                                    if (this.f19264e.A0.f60675h.g() != null && view == this.f19264e.A0.f60675h.g().f()) {
                                                                        if (d.a.c.e.p.j.z()) {
                                                                            SparseArray<Object> C0 = this.f19264e.A0.C0(this.f19264e.t0.D0(), this.f19264e.t0.R0(), 1);
                                                                            if (C0 != null) {
                                                                                if (StringUtils.isNull((String) C0.get(R.id.tag_del_multi_forum))) {
                                                                                    this.f19264e.A0.S1(((Integer) C0.get(R.id.tag_del_post_type)).intValue(), (String) C0.get(R.id.tag_del_post_id), ((Integer) C0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) C0.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                } else {
                                                                                    this.f19264e.A0.T1(((Integer) C0.get(R.id.tag_del_post_type)).intValue(), (String) C0.get(R.id.tag_del_post_id), ((Integer) C0.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) C0.get(R.id.tag_del_post_is_self)).booleanValue(), (String) C0.get(R.id.tag_del_multi_forum));
                                                                                }
                                                                            }
                                                                            this.f19264e.A0.f60675h.e();
                                                                        } else {
                                                                            this.f19264e.showToast(R.string.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText) {
                                                                        if (view.getId() == R.id.pb_post_reply_count) {
                                                                            if (this.f19264e.t0 == null) {
                                                                                return;
                                                                            }
                                                                            StatisticItem statisticItem2 = new StatisticItem("c13398");
                                                                            statisticItem2.param("tid", this.f19264e.t0.T0());
                                                                            statisticItem2.param("fid", this.f19264e.t0.getForumId());
                                                                            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            statisticItem2.param("obj_locate", 5);
                                                                            TiebaStatic.log(statisticItem2);
                                                                            if (view.getId() == R.id.pb_post_reply_count && !DialogLoginHelper.checkUpIsLogin(new d.a.r0.r.q.s0(this.f19264e.getActivity(), "pb_chakanhuifu"))) {
                                                                                this.f19264e.V = view;
                                                                                return;
                                                                            } else if (!this.f19264e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
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
                                                                                if (this.f19264e.t0 == null || this.f19264e.t0.D0() == null) {
                                                                                    return;
                                                                                }
                                                                                String T0 = this.f19264e.t0.T0();
                                                                                String E2 = postData.E();
                                                                                int U = this.f19264e.t0.D0() != null ? this.f19264e.t0.D0().U() : 0;
                                                                                PbActivity.e C5 = this.f19264e.C5(E2);
                                                                                if (C5 == null) {
                                                                                    return;
                                                                                }
                                                                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f19264e.getPageContext().getPageActivity()).createSubPbActivityConfig(T0, E2, "pb", true, null, false, null, U, postData.O(), this.f19264e.t0.D0().d(), false, postData.t().getIconInfo()).addBigImageData(C5.f19136a, C5.f19137b, C5.f19142g, C5.j);
                                                                                addBigImageData.setKeyPageStartFrom(this.f19264e.t0.C0());
                                                                                addBigImageData.setFromFrsForumId(this.f19264e.t0.getFromForumId());
                                                                                addBigImageData.setKeyFromForumId(this.f19264e.t0.getForumId());
                                                                                addBigImageData.setBjhData(this.f19264e.t0.Y());
                                                                                if (this.f19264e.t0.D0().p() != null) {
                                                                                    addBigImageData.setHasForumRule(this.f19264e.t0.D0().p().has_forum_rule.intValue());
                                                                                }
                                                                                if (this.f19264e.t0.D0().T() != null) {
                                                                                    addBigImageData.setIsManager(this.f19264e.t0.D0().T().getIs_manager());
                                                                                }
                                                                                if (this.f19264e.t0.D0().m().getDeletedReasonInfo() != null) {
                                                                                    addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.f19264e.t0.D0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                    addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.f19264e.t0.D0().m().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                }
                                                                                if (this.f19264e.t0.D0().m() != null) {
                                                                                    addBigImageData.setForumHeadUrl(this.f19264e.t0.D0().m().getImage_url());
                                                                                    addBigImageData.setUserLevel(this.f19264e.t0.D0().m().getUser_level());
                                                                                }
                                                                                if (this.f19264e.A0 != null) {
                                                                                    addBigImageData.setMainPostMaskVisibly(this.f19264e.A0.t0(this.f19264e.t0.I, this.f19264e.t0.R0()).S || postData.S);
                                                                                }
                                                                                this.f19264e.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                            }
                                                                        } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                                            if (this.f19264e.t0 == null) {
                                                                                return;
                                                                            }
                                                                            if (view.getId() == R.id.pb_post_reply) {
                                                                                StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                                                statisticItem4.param("tid", this.f19264e.t0.T0());
                                                                                statisticItem4.param("fid", this.f19264e.t0.getForumId());
                                                                                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                statisticItem4.param("obj_locate", 6);
                                                                                TiebaStatic.log(statisticItem4);
                                                                            }
                                                                            if (view.getId() == R.id.post_info_commont_img) {
                                                                                if (!DialogLoginHelper.checkUpIsLogin(new d.a.r0.r.q.s0(this.f19264e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                    this.f19264e.W = view;
                                                                                    return;
                                                                                }
                                                                            } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new d.a.r0.r.q.s0(this.f19264e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                this.f19264e.W = view;
                                                                                return;
                                                                            }
                                                                            if (!this.f19264e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
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
                                                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f19264e.t0.U0()).param("fid", this.f19264e.t0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                                                            }
                                                                            if (this.f19264e.t0 == null || this.f19264e.t0.D0() == null || this.f19264e.P4().J0() == null || postData2.t() == null || postData2.A() == 1) {
                                                                                return;
                                                                            }
                                                                            if (this.f19264e.P4().K0() != null) {
                                                                                this.f19264e.P4().K0().c();
                                                                            }
                                                                            if (this.f19264e.p0 && postData2.M() != null && postData2.M().size() != 0) {
                                                                                this.f19264e.l6(postData2, true);
                                                                            } else {
                                                                                d.a.s0.h2.h.r rVar = new d.a.s0.h2.h.r();
                                                                                rVar.A(this.f19264e.t0.D0().m());
                                                                                rVar.E(this.f19264e.t0.D0().N());
                                                                                rVar.C(postData2);
                                                                                this.f19264e.P4().J0().I(rVar);
                                                                                this.f19264e.P4().J0().setPostId(postData2.E());
                                                                                this.f19264e.r5(view, postData2.t().getUserId(), "", postData2);
                                                                                if (this.f19264e.P0 != null) {
                                                                                    this.f19264e.A0.q2(this.f19264e.P0.C());
                                                                                }
                                                                            }
                                                                        } else if (view.getId() != R.id.pb_floor_feedback) {
                                                                            if (view != this.f19264e.A0.x0()) {
                                                                                if (view == this.f19264e.A0.f60675h.h()) {
                                                                                    this.f19264e.A0.W2();
                                                                                } else if (this.f19264e.A0.f60675h.g() != null && view == this.f19264e.A0.f60675h.g().p()) {
                                                                                    this.f19264e.A0.f60675h.f();
                                                                                    this.f19264e.A0.m3(this.f19264e.r2);
                                                                                } else {
                                                                                    int id = view.getId();
                                                                                    if (id == R.id.pb_u9_text_view) {
                                                                                        if (!this.f19264e.checkUpIsLogin() || (g2Var = (d.a.r0.r.q.g2) view.getTag()) == null || StringUtils.isNull(g2Var.C0())) {
                                                                                            return;
                                                                                        }
                                                                                        TiebaStatic.eventStat(this.f19264e.getPageContext().getPageActivity(), "info_click", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                        UrlManager.getInstance().dealOneLink(this.f19264e.getPageContext(), new String[]{g2Var.C0()});
                                                                                    } else if (id != R.id.replybtn && id != R.id.cover_reply_content && id != R.id.replybtn_top_right && id != R.id.cover_reply_content_top_right) {
                                                                                        if (id == R.id.pb_act_btn) {
                                                                                            if (this.f19264e.t0.D0() != null && this.f19264e.t0.D0().N() != null && this.f19264e.t0.D0().N().t() != null) {
                                                                                                d.a.r0.l.a.l(this.f19264e.getActivity(), this.f19264e.t0.D0().N().t());
                                                                                                if (this.f19264e.t0.D0().N().q() != 1) {
                                                                                                    if (this.f19264e.t0.D0().N().q() == 2) {
                                                                                                        TiebaStatic.eventStat(this.f19264e.getPageContext().getPageActivity(), "show_picture", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                    }
                                                                                                } else {
                                                                                                    TiebaStatic.eventStat(this.f19264e.getPageContext().getPageActivity(), "lottery", PrefetchEvent.STATE_CLICK, 1, "page", "pb");
                                                                                                }
                                                                                            }
                                                                                        } else if (id == R.id.lottery_tail) {
                                                                                            if (view.getTag(R.id.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                String str = (String) view.getTag(R.id.tag_pb_lottery_tail_link);
                                                                                                TiebaStatic.log(new StatisticItem("c10912").param("fid", this.f19264e.t0.D0().n()).param("tid", this.f19264e.t0.D0().P()).param("lotterytail", StringUtils.string(str, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                if (this.f19264e.t0.D0().P().equals(str)) {
                                                                                                    this.f19264e.A0.Q2(0);
                                                                                                } else {
                                                                                                    this.f19264e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f19264e.getActivity()).createNormalCfg(str, (String) null, (String) null, (String) null)));
                                                                                                }
                                                                                            }
                                                                                        } else if (id == R.id.pb_item_tail_content) {
                                                                                            if (ViewHelper.checkUpIsLogin(this.f19264e.getPageContext().getPageActivity())) {
                                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                                String p = d.a.r0.r.d0.b.j().p("tail_link", "");
                                                                                                if (!StringUtils.isNull(p)) {
                                                                                                    TiebaStatic.log("c10056");
                                                                                                    d.a.r0.l.a.o(view.getContext(), string, p, true, true, true);
                                                                                                }
                                                                                                this.f19264e.A0.j2();
                                                                                            }
                                                                                        } else if (id == R.id.join_vote_tv) {
                                                                                            if (view != null) {
                                                                                                d.a.r0.l.a.l(this.f19264e.getActivity(), (String) view.getTag());
                                                                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                if (this.f19264e.s4() == 1 && this.f19264e.t0 != null && this.f19264e.t0.D0() != null) {
                                                                                                    TiebaStatic.log(new StatisticItem("c10397").param("fid", this.f19264e.t0.D0().n()).param("tid", this.f19264e.t0.D0().P()).param("uid", currentAccount));
                                                                                                }
                                                                                            }
                                                                                        } else if (id == R.id.look_all_tv) {
                                                                                            if (view != null) {
                                                                                                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                d.a.r0.l.a.l(this.f19264e.getActivity(), (String) view.getTag());
                                                                                                if (this.f19264e.s4() == 1 && this.f19264e.t0 != null && this.f19264e.t0.D0() != null) {
                                                                                                    TiebaStatic.log(new StatisticItem("c10507").param("fid", this.f19264e.t0.D0().n()).param("tid", this.f19264e.t0.D0().P()).param("uid", currentAccount2));
                                                                                                }
                                                                                            }
                                                                                        } else if (id == R.id.manga_prev_btn) {
                                                                                            this.f19264e.q5();
                                                                                        } else if (id == R.id.manga_next_btn) {
                                                                                            this.f19264e.n5();
                                                                                        } else if (id == R.id.yule_head_img_img) {
                                                                                            if (this.f19264e.t0 != null && this.f19264e.t0.D0() != null && this.f19264e.t0.D0().z() != null) {
                                                                                                d.a.s0.h2.h.e D03 = this.f19264e.t0.D0();
                                                                                                TiebaStatic.log(new StatisticItem("c11679").param("fid", D03.n()));
                                                                                                UrlManager.getInstance().dealOneLink(this.f19264e.getPageContext(), new String[]{D03.z().b()});
                                                                                            }
                                                                                        } else if (id == R.id.yule_head_img_all_rank) {
                                                                                            if (this.f19264e.t0 != null && this.f19264e.t0.D0() != null && this.f19264e.t0.D0().z() != null) {
                                                                                                d.a.s0.h2.h.e D04 = this.f19264e.t0.D0();
                                                                                                TiebaStatic.log(new StatisticItem("c11678").param("fid", D04.n()));
                                                                                                UrlManager.getInstance().dealOneLink(this.f19264e.getPageContext(), new String[]{D04.z().b()});
                                                                                            }
                                                                                        } else if (id == R.id.tv_pb_reply_more) {
                                                                                            if (this.f19264e.k1 >= 0) {
                                                                                                if (this.f19264e.t0 != null) {
                                                                                                    this.f19264e.t0.H1();
                                                                                                }
                                                                                                if (this.f19264e.t0 == null || this.f19264e.A0.l0() == null) {
                                                                                                    i4 = 0;
                                                                                                } else {
                                                                                                    i4 = 0;
                                                                                                    this.f19264e.A0.l0().a0(this.f19264e.t0.D0(), false);
                                                                                                }
                                                                                                this.f19264e.k1 = i4;
                                                                                                if (this.f19264e.t0 != null) {
                                                                                                    this.f19264e.A0.B0().setSelection(this.f19264e.t0.w0());
                                                                                                    this.f19264e.t0.L1(0, 0);
                                                                                                }
                                                                                            }
                                                                                        } else if (id == R.id.qq_share_container) {
                                                                                            if (!this.f19264e.Z3(11009)) {
                                                                                                return;
                                                                                            }
                                                                                            this.f19264e.b5(8);
                                                                                        } else if (id == R.id.new_sub_pb_list_richText) {
                                                                                            SparseArray sparseArray4 = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                                                                                            if (sparseArray4 == null) {
                                                                                                return;
                                                                                            }
                                                                                            this.f19264e.k6(sparseArray4);
                                                                                        } else if (id == R.id.pb_editor_tool_comment_icon) {
                                                                                            if (this.f19264e.A0.B0() == null || this.f19264e.t0 == null || this.f19264e.t0.D0() == null) {
                                                                                                return;
                                                                                            }
                                                                                            int firstVisiblePosition = this.f19264e.A0.B0().getFirstVisiblePosition();
                                                                                            View childAt = this.f19264e.A0.B0().getChildAt(0);
                                                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                                                            boolean l0 = this.f19264e.t0.D0().l0();
                                                                                            boolean z3 = this.f19264e.A0.L0() != null && this.f19264e.A0.L0().g();
                                                                                            boolean x1 = this.f19264e.A0.x1();
                                                                                            boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                            if (!l0 || this.f19264e.A0.L0() == null || this.f19264e.A0.L0().c() == null) {
                                                                                                i3 = 0;
                                                                                            } else {
                                                                                                int k = ((int) (d.a.c.e.p.l.k(this.f19264e.getContext()) * 0.5625d)) - this.f19264e.A0.L0().e();
                                                                                                i3 = k;
                                                                                                z4 = firstVisiblePosition == 0 && (top == k || top == this.f19264e.A0.L0().c().getHeight() - this.f19264e.A0.L0().e());
                                                                                            }
                                                                                            this.f19264e.n4(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                            if ((this.f19264e.t0.D0().N() != null && this.f19264e.t0.D0().N().P0() <= 0) || (x1 && z4)) {
                                                                                                if (!this.f19264e.checkUpIsLogin()) {
                                                                                                    return;
                                                                                                }
                                                                                                this.f19264e.B5();
                                                                                                if (this.f19264e.t0.D0().N().H() != null) {
                                                                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19264e.t0.f19381e).param("fid", this.f19264e.t0.D0().n()).param("obj_locate", 2).param("uid", this.f19264e.t0.D0().N().H().getUserId()));
                                                                                                }
                                                                                            } else {
                                                                                                int i9 = (int) (d.a.c.e.p.l.i(this.f19264e.getContext()) * 0.6d);
                                                                                                if (l0) {
                                                                                                    if (this.f19264e.A0.Q0 != null && this.f19264e.A0.Q0.f60717c != null && this.f19264e.A0.Q0.f60717c.a() != null) {
                                                                                                        if (this.f19264e.A0.Q0.f60717c.a().getParent() != null) {
                                                                                                        }
                                                                                                    }
                                                                                                    z2 = false;
                                                                                                } else {
                                                                                                    if (this.f19264e.A0.I0() != null) {
                                                                                                        z2 = this.f19264e.A0.I0().getVisibility() == 0;
                                                                                                        if (!z2 && this.f19264e.A0.Q0 != null && this.f19264e.A0.Q0.f60717c != null && this.f19264e.A0.Q0.f60717c.a() != null && this.f19264e.A0.Q0.f60717c.a().getParent() != null && this.f19264e.A0.f60675h != null && this.f19264e.A0.f60675h.f60557a != null) {
                                                                                                        }
                                                                                                    }
                                                                                                    z2 = false;
                                                                                                }
                                                                                                if (z2 || x1) {
                                                                                                    this.f19264e.i0 = firstVisiblePosition;
                                                                                                    this.f19264e.j0 = top;
                                                                                                    if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i9))) {
                                                                                                        this.f19264e.A0.B0().setSelectionFromTop(0, i3 - i9);
                                                                                                        this.f19264e.A0.B0().smoothScrollBy(-i9, 500);
                                                                                                    } else {
                                                                                                        this.f19264e.A0.B0().E(0, i3, 500);
                                                                                                    }
                                                                                                } else if (this.f19264e.i0 > 0) {
                                                                                                    if (this.f19264e.A0.B0().getChildAt(this.f19264e.i0) != null) {
                                                                                                        this.f19264e.A0.B0().E(this.f19264e.i0, this.f19264e.j0, 200);
                                                                                                    } else {
                                                                                                        this.f19264e.A0.B0().setSelectionFromTop(this.f19264e.i0, this.f19264e.j0 + i9);
                                                                                                        this.f19264e.A0.B0().smoothScrollBy(i9, 500);
                                                                                                    }
                                                                                                } else {
                                                                                                    int t4 = this.f19264e.t4();
                                                                                                    if (this.f19264e.w4() != -1) {
                                                                                                        t4--;
                                                                                                    }
                                                                                                    int g2 = d.a.c.e.p.l.g(this.f19264e.getContext(), R.dimen.tbds100);
                                                                                                    if (t4 < 0) {
                                                                                                        t4 = (ListUtils.getCount(this.f19264e.A0.B0().getData()) - 1) + this.f19264e.A0.B0().getHeaderViewsCount();
                                                                                                        g2 = 0;
                                                                                                    }
                                                                                                    if (!z3) {
                                                                                                        if (!l0 || this.f19264e.A0.L0() == null) {
                                                                                                            if (this.f19264e.A0.f60675h != null && this.f19264e.A0.f60675h.f60557a != null) {
                                                                                                                fixedNavHeight = this.f19264e.A0.f60675h.f60557a.getFixedNavHeight() - 10;
                                                                                                            }
                                                                                                            if (this.f19264e.A0.Q0 != null || this.f19264e.A0.Q0.f60717c == null || this.f19264e.A0.Q0.f60717c.a() == null || this.f19264e.A0.Q0.f60717c.a().getParent() == null) {
                                                                                                                this.f19264e.A0.B0().setSelectionFromTop(t4, g2 + i9);
                                                                                                                this.f19264e.A0.B0().smoothScrollBy(i9, 500);
                                                                                                            } else if (!z3) {
                                                                                                                this.f19264e.A0.B0().E(t4, g2, 200);
                                                                                                            } else {
                                                                                                                this.f19264e.A0.B0().smoothScrollBy(this.f19264e.A0.Q0.f60717c.a().getTop() - ((int) (d.a.c.e.p.l.k(this.f19264e.getContext()) * 0.5625d)), 500);
                                                                                                            }
                                                                                                        } else {
                                                                                                            fixedNavHeight = this.f19264e.A0.L0().d();
                                                                                                        }
                                                                                                    } else {
                                                                                                        fixedNavHeight = (int) (d.a.c.e.p.l.k(this.f19264e.getContext()) * 0.5625d);
                                                                                                    }
                                                                                                    g2 += fixedNavHeight;
                                                                                                    if (this.f19264e.A0.Q0 != null) {
                                                                                                    }
                                                                                                    this.f19264e.A0.B0().setSelectionFromTop(t4, g2 + i9);
                                                                                                    this.f19264e.A0.B0().smoothScrollBy(i9, 500);
                                                                                                }
                                                                                            }
                                                                                            if (this.f19264e.t0.D0().N() != null && this.f19264e.t0.D0().N().H() != null) {
                                                                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19264e.t0.f19381e).param("fid", this.f19264e.t0.D0().n()).param("obj_locate", 2).param("uid", this.f19264e.t0.D0().N().H().getUserId()));
                                                                                            }
                                                                                        } else if (id == R.id.pb_nav_title_forum_image || id == R.id.pb_nav_title_forum_name) {
                                                                                            if (this.f19264e.t0 == null || this.f19264e.t0.D0() == null || this.f19264e.t0.D0().m() == null || d.a.c.e.p.k.isEmpty(this.f19264e.t0.D0().m().getName())) {
                                                                                                return;
                                                                                            }
                                                                                            if (this.f19264e.t0.getErrorNo() == 4) {
                                                                                                if (!StringUtils.isNull(this.f19264e.t0.f0()) || this.f19264e.t0.V() == null) {
                                                                                                    this.f19264e.f19180e.finish();
                                                                                                    return;
                                                                                                }
                                                                                                name = this.f19264e.t0.V().f60132b;
                                                                                            } else {
                                                                                                name = this.f19264e.t0.D0().m().getName();
                                                                                            }
                                                                                            if (StringUtils.isNull(name)) {
                                                                                                this.f19264e.f19180e.finish();
                                                                                                return;
                                                                                            }
                                                                                            String f0 = this.f19264e.t0.f0();
                                                                                            if (this.f19264e.t0.j0() && f0 != null && f0.equals(name)) {
                                                                                                this.f19264e.f19180e.finish();
                                                                                            } else {
                                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19264e.getActivity()).createNormalCfg(this.f19264e.t0.D0().m().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                            }
                                                                                            StatisticItem statisticItem5 = new StatisticItem("c13401");
                                                                                            statisticItem5.param("tid", this.f19264e.t0.T0());
                                                                                            statisticItem5.param("fid", this.f19264e.t0.getForumId());
                                                                                            statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                            if (this.f19264e.t0.D0().N() != null) {
                                                                                                statisticItem5.param("nid", this.f19264e.t0.D0().N().A0());
                                                                                            }
                                                                                            TiebaStatic.log(statisticItem5);
                                                                                        } else if (id != R.id.forum_name_text && id != R.id.forum_enter_button_one && id != R.id.forum_enter_button_two && id != R.id.forum_enter_button_three) {
                                                                                            if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                                if (this.f19264e.t0 == null) {
                                                                                                    return;
                                                                                                }
                                                                                                StatisticItem statisticItem6 = new StatisticItem("c13398");
                                                                                                statisticItem6.param("tid", this.f19264e.t0.T0());
                                                                                                statisticItem6.param("fid", this.f19264e.t0.getForumId());
                                                                                                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                statisticItem6.param("obj_locate", 2);
                                                                                                TiebaStatic.log(statisticItem6);
                                                                                            } else if (id == R.id.pb_thread_post_button) {
                                                                                                if (this.f19264e.t0 == null || this.f19264e.t0.D0() == null) {
                                                                                                    return;
                                                                                                }
                                                                                                d.a.s0.h2.h.e D05 = this.f19264e.t0.D0();
                                                                                                if (this.f19264e.y0 == null) {
                                                                                                    PbFragment pbFragment2 = this.f19264e;
                                                                                                    pbFragment2.y0 = new d.a.s0.h2.h.s(pbFragment2.getPageContext());
                                                                                                }
                                                                                                long f2 = d.a.c.e.m.b.f(D05.P(), 0L);
                                                                                                long f3 = d.a.c.e.m.b.f(D05.n(), 0L);
                                                                                                new StatisticItem("c13446").param("forum_id", f3).eventStat();
                                                                                                PbFragment pbFragment3 = this.f19264e;
                                                                                                pbFragment3.registerListener(pbFragment3.a2);
                                                                                                this.f19264e.y0.a(f2, f3);
                                                                                            } else if (id == R.id.pb_video_thread_smart_app_layout) {
                                                                                                if (view.getTag() instanceof SmartApp) {
                                                                                                    SmartApp smartApp = (SmartApp) view.getTag();
                                                                                                    if (!d.a.s0.u.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                        if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        d.a.r0.l.a.l(this.f19264e.getActivity(), smartApp.h5_url);
                                                                                                    }
                                                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.f19264e.t0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", "PB_card").param("tid", this.f19264e.t0.T0()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                }
                                                                                            } else if (id == R.id.id_pb_business_promotion_wrapper) {
                                                                                                if (!(view.getTag() instanceof d.a.r0.r.q.b2)) {
                                                                                                    return;
                                                                                                }
                                                                                                d.a.r0.r.q.b2 b2Var = (d.a.r0.r.q.b2) view.getTag();
                                                                                                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f19264e.getActivity()).createNormalCfg(b2Var.W(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                createNormalCfg.setCallFrom(14);
                                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", b2Var.Q()).param("tid", b2Var.c0()).param("thread_type", b2Var.j1()).param(TiebaStatic.Params.IS_ZP, b2Var.u2() ? 1 : 0));
                                                                                            } else if (id == R.id.id_pb_business_promotion_attention) {
                                                                                                if (!(view.getTag() instanceof d.a.r0.r.q.b2) || !this.f19264e.checkUpIsLogin()) {
                                                                                                    return;
                                                                                                }
                                                                                                d.a.r0.r.q.b2 b2Var2 = (d.a.r0.r.q.b2) view.getTag();
                                                                                                if (this.f19264e.T != null) {
                                                                                                    this.f19264e.T.L(b2Var2.W(), String.valueOf(b2Var2.Q()));
                                                                                                }
                                                                                                TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", b2Var2.Q()).param("tid", b2Var2.c0()).param("thread_type", b2Var2.j1()).param(TiebaStatic.Params.IS_ZP, b2Var2.u2() ? 1 : 0));
                                                                                            } else if (id == R.id.pb_floor_right_top_feedback || id == R.id.pb_post_op_more) {
                                                                                                StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                statisticItem7.param("tid", this.f19264e.t0.T0());
                                                                                                statisticItem7.param("fid", this.f19264e.t0.getForumId());
                                                                                                statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                statisticItem7.param("obj_locate", 7);
                                                                                                TiebaStatic.log(statisticItem7);
                                                                                                PbFragment pbFragment4 = this.f19264e;
                                                                                                pbFragment4.f19181f = false;
                                                                                                pbFragment4.f4(view);
                                                                                            }
                                                                                        } else if (!(view.getTag() instanceof d.a.r0.r.q.b2)) {
                                                                                            return;
                                                                                        } else {
                                                                                            d.a.r0.r.q.b2 b2Var3 = (d.a.r0.r.q.b2) view.getTag();
                                                                                            if (this.f19264e.t0.C0() == 3 && this.f19264e.isSimpleForum() && this.f19264e.t0.D0() != null && ListUtils.isEmpty(this.f19264e.t0.D0().q())) {
                                                                                                this.f19264e.f19180e.finish();
                                                                                            } else {
                                                                                                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.f19264e.getActivity()).createNormalCfg(b2Var3.W(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                createNormalCfg2.setCallFrom(14);
                                                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                            }
                                                                                            StatisticItem statisticItem8 = new StatisticItem("c13399");
                                                                                            statisticItem8.param("tid", b2Var3.c0());
                                                                                            statisticItem8.param("fid", b2Var3.Q());
                                                                                            statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                            statisticItem8.param("nid", b2Var3.A0());
                                                                                            TiebaStatic.log(statisticItem8);
                                                                                        }
                                                                                    } else {
                                                                                        d.a.r0.r.s.h hVar7 = null;
                                                                                        if (!this.f19264e.checkUpIsLogin()) {
                                                                                            return;
                                                                                        }
                                                                                        TiebaStatic.log(new StatisticItem("c11740"));
                                                                                        if (view != null && view.getTag() != null) {
                                                                                            SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                            PostData postData3 = (PostData) sparseArray5.get(R.id.tag_load_sub_data);
                                                                                            if (id == R.id.replybtn_top_right || id == R.id.cover_reply_content_top_right) {
                                                                                                TiebaStatic.log(new StatisticItem("c12006").param("tid", this.f19264e.t0.f19381e));
                                                                                            }
                                                                                            if (this.f19264e.G0 == null) {
                                                                                                PbFragment pbFragment5 = this.f19264e;
                                                                                                pbFragment5.G0 = new d.a.r0.r.s.l(pbFragment5.getContext());
                                                                                                this.f19264e.G0.n(this.f19264e.U1);
                                                                                            }
                                                                                            ArrayList arrayList = new ArrayList();
                                                                                            this.f19264e.i5(view);
                                                                                            if (this.f19264e.i5(view) && this.f19264e.g1 != null) {
                                                                                                this.f19264e.g1.t();
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
                                                                                                    d.a.r0.r.s.h hVar8 = new d.a.r0.r.s.h(3, this.f19264e.getString(R.string.copy), this.f19264e.G0);
                                                                                                    SparseArray sparseArray6 = new SparseArray();
                                                                                                    sparseArray6.put(R.id.tag_clip_board, postData3);
                                                                                                    hVar8.f56178d.setTag(sparseArray6);
                                                                                                    arrayList.add(hVar8);
                                                                                                }
                                                                                                this.f19264e.o2 = postData3;
                                                                                            }
                                                                                            if (this.f19264e.t0.D0().s()) {
                                                                                                String u = this.f19264e.t0.D0().u();
                                                                                                if (postData3 != null && !d.a.c.e.p.k.isEmpty(u) && u.equals(postData3.E())) {
                                                                                                    z = true;
                                                                                                    if (!z) {
                                                                                                        hVar4 = new d.a.r0.r.s.h(4, this.f19264e.getString(R.string.remove_mark), this.f19264e.G0);
                                                                                                    } else {
                                                                                                        hVar4 = new d.a.r0.r.s.h(4, this.f19264e.getString(R.string.mark), this.f19264e.G0);
                                                                                                    }
                                                                                                    SparseArray sparseArray7 = new SparseArray();
                                                                                                    sparseArray7.put(R.id.tag_clip_board, this.f19264e.o2);
                                                                                                    sparseArray7.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                                    hVar4.f56178d.setTag(sparseArray7);
                                                                                                    arrayList.add(hVar4);
                                                                                                    if (this.f19264e.mIsLogin) {
                                                                                                        if (d.a.s0.h2.k.e.f1.a.h(this.f19264e.t0) || booleanValue3 || !booleanValue2) {
                                                                                                            if (this.f19264e.l5(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                d.a.r0.r.s.h hVar9 = new d.a.r0.r.s.h(5, this.f19264e.getString(R.string.report_text), this.f19264e.G0);
                                                                                                                hVar9.f56178d.setTag(str2);
                                                                                                                arrayList.add(hVar9);
                                                                                                            }
                                                                                                        } else {
                                                                                                            d.a.r0.r.s.h hVar10 = new d.a.r0.r.s.h(5, this.f19264e.getString(R.string.mute_option), this.f19264e.G0);
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
                                                                                                            hVar4.f56178d.setTag(sparseArray8);
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
                                                                                                                hVar7 = new d.a.r0.r.s.h(6, this.f19264e.getString(R.string.delete), this.f19264e.G0);
                                                                                                                hVar7.f56178d.setTag(sparseArray9);
                                                                                                            } else {
                                                                                                                sparseArray9.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                                            }
                                                                                                            hVar5 = new d.a.r0.r.s.h(7, this.f19264e.getString(R.string.bar_manager), this.f19264e.G0);
                                                                                                            hVar5.f56178d.setTag(sparseArray9);
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
                                                                                                            if (this.f19264e.t0.D0().U() == 1002 && !booleanValue) {
                                                                                                                hVar6 = new d.a.r0.r.s.h(6, this.f19264e.getString(R.string.report_text), this.f19264e.G0);
                                                                                                            } else {
                                                                                                                hVar6 = new d.a.r0.r.s.h(6, this.f19264e.getString(R.string.delete), this.f19264e.G0);
                                                                                                            }
                                                                                                            hVar6.f56178d.setTag(sparseArray10);
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
                                                                                                    this.f19264e.G0.k(arrayList);
                                                                                                    this.f19264e.F0 = new d.a.r0.r.s.j(this.f19264e.getPageContext(), this.f19264e.G0);
                                                                                                    this.f19264e.F0.l();
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (!z) {
                                                                                            }
                                                                                            SparseArray sparseArray72 = new SparseArray();
                                                                                            sparseArray72.put(R.id.tag_clip_board, this.f19264e.o2);
                                                                                            sparseArray72.put(R.id.tag_is_subpb, Boolean.FALSE);
                                                                                            hVar4.f56178d.setTag(sparseArray72);
                                                                                            arrayList.add(hVar4);
                                                                                            if (this.f19264e.mIsLogin) {
                                                                                            }
                                                                                            this.f19264e.G0.k(arrayList);
                                                                                            this.f19264e.F0 = new d.a.r0.r.s.j(this.f19264e.getPageContext(), this.f19264e.G0);
                                                                                            this.f19264e.F0.l();
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                this.f19264e.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.f19264e.getPageContext().getPageActivity(), 24008, d.a.c.e.m.b.f(this.f19264e.t0.D0().n(), 0L), d.a.c.e.m.b.f(this.f19264e.t0.T0(), 0L), d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.f19264e.t0.D0().N().J0())));
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
                                                                            if (this.f19264e.G0 == null) {
                                                                                PbFragment pbFragment6 = this.f19264e;
                                                                                pbFragment6.G0 = new d.a.r0.r.s.l(pbFragment6.getContext());
                                                                                this.f19264e.G0.n(this.f19264e.U1);
                                                                            }
                                                                            ArrayList arrayList2 = new ArrayList();
                                                                            boolean z5 = this.f19264e.y().D0() != null && this.f19264e.y().D0().e0();
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
                                                                                        pbFragment = this.f19264e;
                                                                                        i2 = R.string.action_cancel_dislike;
                                                                                    } else {
                                                                                        pbFragment = this.f19264e;
                                                                                        i2 = R.string.action_dislike;
                                                                                    }
                                                                                    d.a.r0.r.s.h hVar11 = new d.a.r0.r.s.h(8, pbFragment.getString(i2), this.f19264e.G0);
                                                                                    SparseArray sparseArray11 = new SparseArray();
                                                                                    sparseArray11.put(R.id.tag_clip_board, postData4);
                                                                                    hVar11.f56178d.setTag(sparseArray11);
                                                                                    arrayList2.add(hVar11);
                                                                                }
                                                                                if (this.f19264e.mIsLogin) {
                                                                                    if (d.a.s0.h2.k.e.f1.a.h(this.f19264e.t0) || booleanValue8 || !booleanValue7) {
                                                                                        if ((this.f19264e.l5(booleanValue6) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                            d.a.r0.r.s.h hVar12 = new d.a.r0.r.s.h(5, this.f19264e.getString(R.string.report_text), this.f19264e.G0);
                                                                                            hVar12.f56178d.setTag(str3);
                                                                                            arrayList2.add(hVar12);
                                                                                        }
                                                                                    } else {
                                                                                        d.a.r0.r.s.h hVar13 = new d.a.r0.r.s.h(5, this.f19264e.getString(R.string.mute_option), this.f19264e.G0);
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
                                                                                        hVar13.f56178d.setTag(sparseArray12);
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
                                                                                            hVar2 = new d.a.r0.r.s.h(6, this.f19264e.getString(R.string.delete), this.f19264e.G0);
                                                                                            hVar2.f56178d.setTag(sparseArray13);
                                                                                        } else {
                                                                                            sparseArray13.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                                                                                            hVar2 = null;
                                                                                        }
                                                                                        hVar = new d.a.r0.r.s.h(7, this.f19264e.getString(R.string.bar_manager), this.f19264e.G0);
                                                                                        hVar.f56178d.setTag(sparseArray13);
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
                                                                                        if (this.f19264e.t0.D0().U() == 1002 && !booleanValue6) {
                                                                                            hVar3 = new d.a.r0.r.s.h(6, this.f19264e.getString(R.string.report_text), this.f19264e.G0);
                                                                                        } else {
                                                                                            hVar3 = new d.a.r0.r.s.h(6, this.f19264e.getString(R.string.delete), this.f19264e.G0);
                                                                                        }
                                                                                        hVar3.f56178d.setTag(sparseArray14);
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
                                                                                this.f19264e.G0.k(arrayList2);
                                                                                this.f19264e.F0 = new d.a.r0.r.s.j(this.f19264e.getPageContext(), this.f19264e.G0);
                                                                                this.f19264e.F0.l();
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                                                            StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                                            statisticItem9.param("tid", this.f19264e.t0.T0());
                                                                            statisticItem9.param("fid", this.f19264e.t0.getForumId());
                                                                            statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            statisticItem9.param("obj_locate", 4);
                                                                            TiebaStatic.log(statisticItem9);
                                                                        }
                                                                        if (view.getId() == R.id.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new d.a.r0.r.q.s0(this.f19264e.getActivity(), "pb_chakanhuifu"))) {
                                                                            this.f19264e.V = view;
                                                                            return;
                                                                        } else if (this.f19264e.checkUpIsLogin()) {
                                                                            if (this.f19264e.t0 == null || this.f19264e.t0.D0() == null) {
                                                                                return;
                                                                            }
                                                                            this.f19264e.A0.a0();
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
                                                                            String T02 = this.f19264e.t0.T0();
                                                                            String E3 = postData5.E();
                                                                            String E4 = postData6 != null ? postData6.E() : "";
                                                                            int U2 = this.f19264e.t0.D0() != null ? this.f19264e.t0.D0().U() : 0;
                                                                            this.f19264e.m6();
                                                                            if (view.getId() == R.id.replybtn) {
                                                                                PbActivity.e C52 = this.f19264e.C5(E3);
                                                                                if (this.f19264e.t0 == null || this.f19264e.t0.D0() == null || C52 == null) {
                                                                                    return;
                                                                                }
                                                                                SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.f19264e.getPageContext().getPageActivity()).createSubPbActivityConfig(T02, E3, "pb", true, null, true, null, U2, postData5.O(), this.f19264e.t0.D0().d(), false, postData5.t().getIconInfo()).addBigImageData(C52.f19136a, C52.f19137b, C52.f19142g, C52.j);
                                                                                addBigImageData2.setKeyPageStartFrom(this.f19264e.t0.C0());
                                                                                addBigImageData2.setFromFrsForumId(this.f19264e.t0.getFromForumId());
                                                                                addBigImageData2.setKeyFromForumId(this.f19264e.t0.getForumId());
                                                                                addBigImageData2.setBjhData(this.f19264e.t0.Y());
                                                                                this.f19264e.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                            } else {
                                                                                TiebaStatic.log("c11742");
                                                                                PbActivity.e C53 = this.f19264e.C5(E3);
                                                                                if (postData5 == null || this.f19264e.t0 == null || this.f19264e.t0.D0() == null || C53 == null) {
                                                                                    return;
                                                                                }
                                                                                SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.f19264e.getPageContext().getPageActivity()).createSubPbActivityConfig(T02, E3, "pb", true, null, false, E4, U2, postData5.O(), this.f19264e.t0.D0().d(), false, postData5.t().getIconInfo()).addBigImageData(C53.f19136a, C53.f19137b, C53.f19142g, C53.j);
                                                                                if (!d.a.c.e.p.k.isEmpty(E4)) {
                                                                                    addBigImageData3.setHighLightPostId(E4);
                                                                                    addBigImageData3.setKeyIsUseSpid(true);
                                                                                }
                                                                                addBigImageData3.setKeyFromForumId(this.f19264e.t0.getForumId());
                                                                                addBigImageData3.setBjhData(this.f19264e.t0.Y());
                                                                                addBigImageData3.setKeyPageStartFrom(this.f19264e.t0.C0());
                                                                                addBigImageData3.setFromFrsForumId(this.f19264e.t0.getFromForumId());
                                                                                if (this.f19264e.A0 != null) {
                                                                                    addBigImageData3.setMainPostMaskVisibly(this.f19264e.A0.t0(this.f19264e.t0.I, this.f19264e.t0.R0()).S || postData5.S);
                                                                                }
                                                                                this.f19264e.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                            }
                                                                        } else {
                                                                            TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f19264e.t0.D0().n()));
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (d.a.c.e.p.j.z()) {
                                                                    this.f19264e.A0.a0();
                                                                    SparseArray<Object> C02 = this.f19264e.A0.C0(this.f19264e.t0.D0(), this.f19264e.t0.R0(), 1);
                                                                    if (C02 == null) {
                                                                        return;
                                                                    }
                                                                    this.f19264e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f19264e.getPageContext().getPageActivity(), this.f19264e.t0.D0().m().getId(), this.f19264e.t0.D0().m().getName(), this.f19264e.t0.D0().N().c0(), String.valueOf(this.f19264e.t0.D0().T().getUserId()), (String) C02.get(R.id.tag_forbid_user_name), (String) C02.get(R.id.tag_forbid_user_name_show), (String) C02.get(R.id.tag_forbid_user_post_id), (String) C02.get(R.id.tag_forbid_user_portrait))));
                                                                } else {
                                                                    this.f19264e.showToast(R.string.network_not_available);
                                                                    return;
                                                                }
                                                            } else {
                                                                int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                if (skinType == 1) {
                                                                    this.f19264e.onChangeSkinType(skinType);
                                                                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                                                } else if (skinType == 0 || skinType == 4) {
                                                                    UtilHelper.showSkinChangeAnimation(this.f19264e.getActivity());
                                                                    this.f19264e.onChangeSkinType(skinType);
                                                                    UtilHelper.setNavigationBarBackground(this.f19264e.getActivity(), this.f19264e.getResources().getColor(R.color.CAM_X0201_1));
                                                                    TbadkCoreApplication.getInst().setSkinType(1);
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                                                }
                                                                this.f19264e.A0.f60675h.f();
                                                            }
                                                        } else if (this.f19264e.t0 == null || this.f19264e.t0.D0() == null || this.f19264e.t0.D0().N() == null) {
                                                            return;
                                                        } else {
                                                            this.f19264e.A0.f60675h.e();
                                                            TiebaStatic.log(new StatisticItem("c13062"));
                                                            PbFragment pbFragment7 = this.f19264e;
                                                            pbFragment7.X4(pbFragment7.t0.D0().N().T());
                                                        }
                                                    } else {
                                                        this.f19264e.A0.a0();
                                                        if (d.a.c.e.p.j.z()) {
                                                            if (this.f19264e.m) {
                                                                view.setTag(Integer.valueOf(this.f19264e.t0.P0()));
                                                                return;
                                                            }
                                                            this.f19264e.m6();
                                                            this.f19264e.A0.M2();
                                                            d.a.r0.r.s.j jVar = new d.a.r0.r.s.j(this.f19264e.getPageContext());
                                                            if (this.f19264e.t0.D0().f60142f == null || this.f19264e.t0.D0().f60142f.size() <= 0) {
                                                                strArr = new String[]{this.f19264e.getResources().getString(R.string.sort_type_new), this.f19264e.getResources().getString(R.string.sort_type_old)};
                                                            } else {
                                                                strArr = new String[this.f19264e.t0.D0().f60142f.size()];
                                                                for (int i64 = 0; i64 < this.f19264e.t0.D0().f60142f.size(); i64++) {
                                                                    strArr[i64] = this.f19264e.t0.D0().f60142f.get(i64).sort_name + this.f19264e.getResources().getString(R.string.sort_static);
                                                                }
                                                            }
                                                            jVar.i(null, strArr, new a(this, jVar, view));
                                                            jVar.l();
                                                        } else {
                                                            this.f19264e.showToast(R.string.network_not_available);
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    this.f19264e.A0.a0();
                                                    if (this.f19264e.y().D0().f60143g != 2) {
                                                        if (this.f19264e.t0.B0() != null) {
                                                            this.f19264e.A0.q3(this.f19264e.t0.B0(), this.f19264e.T1);
                                                        }
                                                        TiebaStatic.eventStat(this.f19264e.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                    } else {
                                                        this.f19264e.showToast(R.string.hot_sort_jump_hint);
                                                        return;
                                                    }
                                                }
                                            } else if (!(ShareSwitch.isOn() || this.f19264e.checkUpIsLogin()) || (D0 = this.f19264e.t0.D0()) == null) {
                                                return;
                                            } else {
                                                d.a.r0.r.q.b2 N = D0.N();
                                                if (N != null && N.H() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19264e.t0.f19381e).param("fid", D0.n()).param("obj_locate", 4).param("uid", N.H().getUserId()));
                                                }
                                                if (N != null) {
                                                    if (N.E1()) {
                                                        i5 = 2;
                                                    } else if (N.H1()) {
                                                        i5 = 3;
                                                    } else if (N.F1()) {
                                                        i5 = 4;
                                                    } else if (N.G1()) {
                                                        i5 = 5;
                                                    }
                                                    StatisticItem statisticItem11 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem11.param("tid", this.f19264e.t0.T0());
                                                    statisticItem11.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem11.param("fid", this.f19264e.t0.getForumId());
                                                    if (view.getId() != R.id.share_num_container) {
                                                        statisticItem11.param("obj_locate", 5);
                                                    } else {
                                                        statisticItem11.param("obj_locate", 6);
                                                    }
                                                    statisticItem11.param("obj_name", i5);
                                                    statisticItem11.param("obj_type", 1);
                                                    if (N != null) {
                                                        if (N.E1()) {
                                                            statisticItem11.param("obj_type", 10);
                                                        } else if (N.H1()) {
                                                            statisticItem11.param("obj_type", 9);
                                                        } else if (N.G1()) {
                                                            statisticItem11.param("obj_type", 8);
                                                        } else if (N.F1()) {
                                                            statisticItem11.param("obj_type", 7);
                                                        } else if (N.v1) {
                                                            statisticItem11.param("obj_type", 6);
                                                        } else {
                                                            int i65 = N.Z;
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
                                                        statisticItem11.param("card_type", N.L0());
                                                        statisticItem11.param("recom_source", N.T0);
                                                        statisticItem11.param("ab_tag", N.V0);
                                                        statisticItem11.param("weight", N.U0);
                                                        statisticItem11.param("extra", N.W0);
                                                        statisticItem11.param("nid", N.A0());
                                                        if (N.J() != null && !d.a.c.e.p.k.isEmpty(N.J().oriUgcVid)) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_PARAM6, N.J().oriUgcVid);
                                                        }
                                                    }
                                                    if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                        statisticItem11.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                    }
                                                    if (this.f19264e.z() != null) {
                                                        d.a.r0.j0.c.e(this.f19264e.z(), statisticItem11);
                                                    }
                                                    TiebaStatic.log(statisticItem11);
                                                    if (d.a.c.e.p.l.D()) {
                                                        this.f19264e.showToast(R.string.neterror);
                                                        return;
                                                    } else if (D0 != null) {
                                                        ArrayList<PostData> E5 = this.f19264e.t0.D0().E();
                                                        if ((E5 != null && E5.size() > 0) || !this.f19264e.t0.R0()) {
                                                            this.f19264e.A0.a0();
                                                            this.f19264e.m6();
                                                            if (D0.z() != null && !StringUtils.isNull(D0.z().a(), true)) {
                                                                TiebaStatic.log(new StatisticItem("c11678").param("fid", this.f19264e.t0.D0().n()));
                                                            }
                                                            TiebaStatic.log(new StatisticItem("c11939"));
                                                            if (AntiHelper.e(this.f19264e.getContext(), N)) {
                                                                return;
                                                            }
                                                            if (this.f19264e.A0 != null) {
                                                                this.f19264e.A0.c0();
                                                                this.f19264e.A0.C3(D0);
                                                            }
                                                            if (!ShareSwitch.isOn()) {
                                                                this.f19264e.A0.f3();
                                                                this.f19264e.t0.a0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                            } else {
                                                                if (view.getId() == R.id.pb_editor_tool_share) {
                                                                    i6 = 2;
                                                                } else {
                                                                    i6 = view.getId() == R.id.share_num_container ? 1 : 6;
                                                                }
                                                                this.f19264e.g6(i6);
                                                            }
                                                        } else {
                                                            d.a.c.e.p.l.M(this.f19264e.getPageContext().getPageActivity(), this.f19264e.getPageContext().getString(R.string.pb_no_data_tips));
                                                            return;
                                                        }
                                                    } else {
                                                        d.a.c.e.p.l.M(this.f19264e.getPageContext().getPageActivity(), this.f19264e.getPageContext().getString(R.string.pb_no_data_tips));
                                                        return;
                                                    }
                                                }
                                                i5 = 1;
                                                StatisticItem statisticItem112 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                statisticItem112.param("tid", this.f19264e.t0.T0());
                                                statisticItem112.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem112.param("fid", this.f19264e.t0.getForumId());
                                                if (view.getId() != R.id.share_num_container) {
                                                }
                                                statisticItem112.param("obj_name", i5);
                                                statisticItem112.param("obj_type", 1);
                                                if (N != null) {
                                                }
                                                if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                }
                                                if (this.f19264e.z() != null) {
                                                }
                                                TiebaStatic.log(statisticItem112);
                                                if (d.a.c.e.p.l.D()) {
                                                }
                                            }
                                        } else if (d.a.c.e.p.j.z()) {
                                            this.f19264e.A0.a0();
                                            if (this.f19264e.A0.f60675h.g() != null && view == this.f19264e.A0.f60675h.g().i() && !this.f19264e.A0.z1()) {
                                                this.f19264e.A0.j2();
                                            }
                                            if (!this.f19264e.m) {
                                                this.f19264e.m6();
                                                this.f19264e.A0.M2();
                                                if (view.getId() == R.id.floor_owner_reply) {
                                                    a2 = this.f19264e.t0.a2(true, this.f19264e.y4());
                                                } else {
                                                    a2 = view.getId() == R.id.reply_title ? this.f19264e.t0.a2(false, this.f19264e.y4()) : this.f19264e.t0.Z1(this.f19264e.y4());
                                                }
                                                view.setTag(Boolean.valueOf(a2));
                                                if (a2) {
                                                    i7 = 1;
                                                    this.f19264e.A0.x2(true);
                                                    this.f19264e.A0.p3();
                                                    this.f19264e.m = true;
                                                    this.f19264e.A0.A2(true);
                                                } else {
                                                    i7 = 1;
                                                }
                                                TiebaStatic.eventStat(this.f19264e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                            } else {
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else {
                                            this.f19264e.showToast(R.string.network_not_available);
                                            view.setTag(Boolean.FALSE);
                                            return;
                                        }
                                    } else if (d.a.c.e.p.j.z()) {
                                        this.f19264e.A0.a0();
                                        if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new d.a.r0.r.q.s0(this.f19264e.getActivity(), "pb_shoucang"))) {
                                            if (!this.f19264e.Z3(11009) || this.f19264e.t0.W(this.f19264e.A0.A0()) == null) {
                                                return;
                                            }
                                            this.f19264e.t5();
                                            if (this.f19264e.t0.D0() != null && this.f19264e.t0.D0().N() != null && this.f19264e.t0.D0().N().H() != null) {
                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f19264e.t0.f19381e).param("fid", this.f19264e.t0.D0().n()).param("obj_locate", 3).param("uid", this.f19264e.t0.D0().N().H().getUserId()));
                                            }
                                            if (this.f19264e.t0.D0().N() != null && this.f19264e.t0.D0().N().H() != null && this.f19264e.t0.D0().N().H().getUserId() != null && this.f19264e.v0 != null) {
                                                PbFragment pbFragment8 = this.f19264e;
                                                int S4 = pbFragment8.S4(pbFragment8.t0.D0());
                                                d.a.r0.r.q.b2 N2 = this.f19264e.t0.D0().N();
                                                if (N2.E1()) {
                                                    i8 = 2;
                                                } else if (N2.H1()) {
                                                    i8 = 3;
                                                } else if (N2.F1()) {
                                                    i8 = 4;
                                                } else {
                                                    i8 = N2.G1() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f19264e.t0.f19381e).param("obj_locate", 1).param("obj_id", this.f19264e.t0.D0().N().H().getUserId()).param("obj_type", !this.f19264e.v0.e()).param("obj_source", S4).param("obj_param1", i8));
                                            }
                                        } else {
                                            this.f19264e.X = view;
                                            return;
                                        }
                                    } else {
                                        this.f19264e.showToast(R.string.network_not_available);
                                        return;
                                    }
                                } else {
                                    TiebaStatic.eventStat(this.f19264e.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                    if (this.f19264e.t0.D0() != null && this.f19264e.t0.D0().N() != null && this.f19264e.t0.D0().N().q2() && this.f19264e.t0.D0().N().l1() != null) {
                                        TiebaStatic.log(new StatisticItem("c11922"));
                                    }
                                    if (this.f19264e.t0.getErrorNo() == 4) {
                                        if (!StringUtils.isNull(this.f19264e.t0.f0()) || this.f19264e.t0.V() == null) {
                                            this.f19264e.f19180e.finish();
                                            return;
                                        }
                                        name2 = this.f19264e.t0.V().f60132b;
                                    } else {
                                        name2 = this.f19264e.t0.D0().m().getName();
                                    }
                                    if (StringUtils.isNull(name2)) {
                                        this.f19264e.f19180e.finish();
                                        return;
                                    }
                                    String f02 = this.f19264e.t0.f0();
                                    FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.f19264e.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                    if (this.f19264e.t0.j0() && f02 != null && f02.equals(name2)) {
                                        this.f19264e.f19180e.finish();
                                    } else {
                                        this.f19264e.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                    }
                                }
                            } else if (d.a.c.e.p.j.z()) {
                                if (this.f19264e.t0.D0() == null || this.f19264e.w0.O()) {
                                    return;
                                }
                                this.f19264e.A0.a0();
                                int i66 = (this.f19264e.A0.f60675h.g() == null || view != this.f19264e.A0.f60675h.g().n()) ? (this.f19264e.A0.f60675h.g() == null || view != this.f19264e.A0.f60675h.g().m()) ? view == this.f19264e.A0.n0() ? 2 : 0 : this.f19264e.t0.D0().N().l0() == 1 ? 3 : 6 : this.f19264e.t0.D0().N().m0() == 1 ? 5 : 4;
                                ForumData m = this.f19264e.t0.D0().m();
                                String name3 = m.getName();
                                String id2 = m.getId();
                                String c0 = this.f19264e.t0.D0().N().c0();
                                this.f19264e.A0.w3();
                                this.f19264e.w0.S(id2, name3, c0, i66, this.f19264e.A0.o0());
                            } else {
                                this.f19264e.showToast(R.string.network_not_available);
                                return;
                            }
                        } else {
                            this.f19264e.A0.f60675h.f();
                            if (this.f19264e.t0 != null) {
                                this.f19264e.p1.f(this.f19264e.t0.T0());
                            }
                            if (this.f19264e.t0 == null || !this.f19264e.t0.isPrivacy()) {
                                this.f19264e.p1.b();
                                int i67 = (TbSingleton.getInstance().mCanCallFans || this.f19264e.y() == null || this.f19264e.y().D0() == null || this.f19264e.y().D0().P() == null || !this.f19264e.y().D0().P().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                if (this.f19264e.y() != null && this.f19264e.y().D0() != null) {
                                    this.f19264e.p1.d(3, i67, this.f19264e.y().D0().P());
                                }
                            } else {
                                this.f19264e.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                if (this.f19264e.y() == null || this.f19264e.y().D0() == null) {
                                    return;
                                }
                                this.f19264e.p1.d(3, 3, this.f19264e.y().D0().P());
                                return;
                            }
                        }
                    } else if (d.a.c.e.p.j.z()) {
                        this.f19264e.A0.a0();
                        this.f19264e.m6();
                        this.f19264e.A0.M2();
                        this.f19264e.A0.f3();
                        if (this.f19264e.A0.I0() != null) {
                            this.f19264e.A0.I0().setVisibility(8);
                        }
                        this.f19264e.t0.V1(1);
                        if (this.f19264e.f19184i != null) {
                            this.f19264e.f19184i.x();
                        }
                    } else {
                        this.f19264e.showToast(R.string.network_not_available);
                        return;
                    }
                    if (this.f19264e.getPageContext().getString(R.string.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == R.id.reply_god_title_group) {
                        String x4 = this.f19264e.x4();
                        if (TextUtils.isEmpty(x4)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.f19264e.getPageContext(), new String[]{x4});
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem12 = new StatisticItem("c13398");
                statisticItem12.param("tid", this.f19264e.t0.T0());
                statisticItem12.param("fid", this.f19264e.t0.getForumId());
                statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem12.param("obj_locate", 1);
                TiebaStatic.log(statisticItem12);
                if (this.f19264e.A) {
                    this.f19264e.A = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (this.f19264e.t0 == null || this.f19264e.t0.D0() == null || this.f19264e.P4().J0() == null || postData7.t() == null || postData7.A() == 1 || !this.f19264e.checkUpIsLogin()) {
                            return;
                        }
                        if (this.f19264e.P4().K0() != null) {
                            this.f19264e.P4().K0().c();
                        }
                        d.a.s0.h2.h.r rVar2 = new d.a.s0.h2.h.r();
                        rVar2.A(this.f19264e.t0.D0().m());
                        rVar2.E(this.f19264e.t0.D0().N());
                        rVar2.C(postData7);
                        this.f19264e.P4().J0().I(rVar2);
                        this.f19264e.P4().J0().setPostId(postData7.E());
                        this.f19264e.r5(view, postData7.t().getUserId(), "", postData7);
                        TiebaStatic.log("c11743");
                        d.a.s0.h2.m.a.b(this.f19264e.t0.D0(), postData7, postData7.i0, 8, 1);
                        if (this.f19264e.P0 != null) {
                            this.f19264e.A0.q2(this.f19264e.P0.C());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f19268e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f19269f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19270g;

        public p1(PbFragment pbFragment, MarkData markData, d.a.r0.r.s.a aVar) {
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
            this.f19270g = pbFragment;
            this.f19268e = markData;
            this.f19269f = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.f19270g.A0 != null && this.f19270g.A0.V0() != null) {
                    this.f19270g.A0.V0().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.f19268e);
                    this.f19270g.f19180e.setResult(-1, intent);
                    this.f19269f.dismiss();
                    this.f19270g.n6();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p2 implements d.a.r0.z0.n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19271a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19272b;

        public p2(PbFragment pbFragment, int i2) {
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
            this.f19272b = pbFragment;
            this.f19271a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f19272b.getContext(), this.f19271a, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements b.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19273a;

        public q(PbFragment pbFragment) {
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
            this.f19273a = pbFragment;
        }

        @Override // d.a.s0.h2.k.e.c1.b.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f19273a.P5(z);
                if (this.f19273a.A0.y0() != null && z) {
                    this.f19273a.A0.r3(false);
                }
                this.f19273a.A0.M1(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19274a;

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
            this.f19274a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f19274a.t0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.f19274a.t0.f19381e)) {
                this.f19274a.f6((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q1 implements d.a.c.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19275a;

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
            this.f19275a = pbFragment;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (d.a.r0.r.k.c().g()) {
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
        @Override // d.a.c.e.k.c
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f19275a.getPageContext().getPageActivity());
                boolean g2 = d.a.r0.r.k.c().g();
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.I();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class q2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19276a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q2(PbFragment pbFragment, int i2) {
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
            this.f19276a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f19276a.t0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.f19276a.P0 != null) {
                this.f19276a.A0.q2(this.f19276a.P0.C());
            }
            this.f19276a.A0.j2();
            this.f19276a.A0.a0();
        }
    }

    /* loaded from: classes5.dex */
    public class r implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f19277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f19278f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f19279g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f19280h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19281i;

        public r(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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
            this.f19281i = pbFragment;
            this.f19277e = sparseArray;
            this.f19278f = z;
            this.f19279g = str;
            this.f19280h = str2;
        }

        @Override // d.a.r0.r.s.l.e
        public void onItemClick(d.a.r0.r.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (this.f19281i.F0 != null) {
                    this.f19281i.F0.dismiss();
                }
                if (i2 == 0) {
                    this.f19281i.A0.S1(((Integer) this.f19277e.get(R.id.tag_del_post_type)).intValue(), (String) this.f19277e.get(R.id.tag_del_post_id), ((Integer) this.f19277e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f19277e.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f19277e.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.f19277e.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.f19277e.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f19278f, this.f19279g, str, str2, str3, 1, this.f19280h, this.f19281i.d1);
                    userMuteAddAndDelCustomMessage.setTag(this.f19281i.d1);
                    this.f19281i.i6(this.f19278f, userMuteAddAndDelCustomMessage, this.f19280h, str, (String) this.f19277e.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements d.a.r0.w.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19282a;

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
            this.f19282a = pbFragment;
        }

        @Override // d.a.r0.w.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19282a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r1 implements d.a.c.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19283a;

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
            this.f19283a = pbFragment;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (d.a.r0.r.k.c().g()) {
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
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.c0();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.f19283a.getPageContext().getPageActivity());
                boolean g2 = d.a.r0.r.k.c().g();
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
                gifView.g0();
                gifView.c0();
                gifView.setImageDrawable(null);
                gifView.h0();
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
    public interface r2 {
        boolean onBackPressed();
    }

    /* loaded from: classes5.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19284a;

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
            this.f19284a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f12802c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.f19284a.getUniqueId() || AntiHelper.t(this.f19284a.getActivity(), updateAttentionMessage.getData().l, PbFragment.D2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().f12800a) {
                    if (this.f19284a.u4().t() != null && this.f19284a.u4().t().getGodUserData() != null) {
                        this.f19284a.u4().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.f19284a.t0 == null || this.f19284a.t0.D0() == null || this.f19284a.t0.D0().N() == null || this.f19284a.t0.D0().N().H() == null) {
                        return;
                    }
                    this.f19284a.t0.D0().N().H().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19285a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19286e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ s0 f19287f;

            public a(s0 s0Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {s0Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19287f = s0Var;
                this.f19286e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19287f.f19285a.A0 == null || this.f19286e == null) {
                    return;
                }
                this.f19287f.f19285a.A0.x3();
                this.f19287f.f19285a.A0.X1(this.f19286e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(s0 s0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {s0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s0 f19288e;

            public c(s0 s0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {s0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19288e = s0Var;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19288e.f19285a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19288e.f19285a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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
            this.f19285a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.r0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f19285a.t0.D0() != null) {
                        statisticItem.param("fid", this.f19285a.t0.D0().n());
                    }
                    statisticItem.param("tid", this.f19285a.t0.T0());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.f19285a.m6();
                this.f19285a.A0.K2(z, postWriteCallBackData);
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                boolean z2 = false;
                if (z) {
                    this.f19285a.f6(postWriteCallBackData);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.f19285a.V5(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (this.f19285a.t0.i0()) {
                            d.a.s0.h2.h.e D0 = this.f19285a.t0.D0();
                            if (D0 != null && D0.N() != null && D0.N().H() != null && (userId = D0.N().H().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.f19285a.t0.Y1()) {
                                this.f19285a.A0.M2();
                            }
                        } else if (!PbReplySwitch.getInOn() && this.f19285a.t0.Y1()) {
                            this.f19285a.A0.M2();
                        }
                    } else if (floor != null) {
                        this.f19285a.A0.n1(this.f19285a.t0.D0());
                    }
                    if (this.f19285a.t0.l0()) {
                        TiebaStatic.log(new StatisticItem("c10369").param("tid", this.f19285a.t0.T0()));
                    }
                    if (postWriteCallBackData.getmAdverSegmentData() != null) {
                        d.a.c.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    PbFragment pbFragment = this.f19285a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    pbFragment.V3(z2);
                } else if (i2 == 220015) {
                    this.f19285a.showToast(str);
                    if (this.f19285a.P0.B() || this.f19285a.P0.D()) {
                        this.f19285a.P0.z(false, postWriteCallBackData);
                    }
                    this.f19285a.E0.k(postWriteCallBackData);
                } else if (i2 == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f19285a.S0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.f19285a.getActivity(), this.f19285a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.f19285a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f19285a.getActivity());
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f19285a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f19285a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (d.a.s0.r3.a.c(i2) || i0Var != null || i2 == 227001) {
                } else {
                    this.f19285a.U5(i2, antiData, str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements d.a.c.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19289a;

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
            this.f19289a = pbFragment;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
                ((PlayVoiceBntNew) view).m();
                return view;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).l();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f19289a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f19289a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }

        public View h(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                ((PlayVoiceBntNew) view).l();
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface s2 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public class t extends d.a.r0.f0.i<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19290c;

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
            this.f19290c = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.f0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.f19290c.f19180e.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.s(this.f19290c.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19291a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f19292e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ t0 f19293f;

            public a(t0 t0Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t0Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19293f = t0Var;
                this.f19292e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19293f.f19291a.A0 == null || this.f19292e == null) {
                    return;
                }
                this.f19293f.f19291a.A0.x3();
                this.f19293f.f19291a.A0.X1(this.f19292e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(t0 t0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ t0 f19294e;

            public c(t0 t0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19294e = t0Var;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f19294e.f19291a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f19294e.f19291a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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
            this.f19291a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.r0.s.c.i0 i0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) {
                if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f19291a.t0 != null && this.f19291a.t0.D0() != null) {
                        statisticItem.param("fid", this.f19291a.t0.D0().n());
                    }
                    if (this.f19291a.t0 != null) {
                        statisticItem.param("tid", this.f19291a.t0.T0());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    d.a.s0.h2.k.e.v0 v0Var = this.f19291a.E0;
                    if (v0Var != null) {
                        v0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        d.a.r0.s.h.b.a(this.f19291a.getPageContext(), postWriteCallBackData);
                    }
                    if (postWriteCallBackData.getmAdverSegmentData() != null) {
                        d.a.c.e.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.f19291a.S0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.f19291a.getActivity(), this.f19291a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.f19291a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f19291a.getActivity());
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f19291a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c(this));
                    aVar.create(this.f19291a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.f19291a;
                if (pbFragment.E0 == null) {
                    return;
                }
                if (pbFragment.A0 != null && this.f19291a.A0.K0() != null && this.f19291a.A0.K0().b() != null && this.f19291a.A0.K0().b().v()) {
                    this.f19291a.A0.K0().b().t(postWriteCallBackData);
                }
                this.f19291a.E0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements d.a.c.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19295a;

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
            this.f19295a = pbFragment;
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f19295a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface t2 {
    }

    /* loaded from: classes5.dex */
    public class u implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f19296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19297f;

        public u(PbFragment pbFragment, Intent intent) {
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
            this.f19297f = pbFragment;
            this.f19296e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.s0.h2.k.e.t0 t0Var = this.f19297f.A0;
                t0Var.P2(TNCManager.TNC_PROBE_HEADER_SECEPTOR + this.f19296e.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19298a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(PbFragment pbFragment, int i2, int i3) {
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
            this.f19298a = pbFragment;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView T0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.f19298a.f19180e.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.thread_distribute_success);
                    if (this.f19298a.A0 == null || (T0 = this.f19298a.A0.T0()) == null || this.f19298a.A0.B0() == null) {
                        return;
                    }
                    this.f19298a.A0.B0().removeHeaderView(T0);
                    return;
                }
                d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements TbRichTextView.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19299a;

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
            this.f19299a = pbFragment;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.x
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            d.a.s0.h2.k.e.i l0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view.getTag() instanceof TbRichText) && str == null) {
                        if (this.f19299a.checkUpIsLogin()) {
                            this.f19299a.A0.J1((TbRichText) view.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.f19299a.t0.T0());
                    statisticItem.param("fid", this.f19299a.t0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.f19299a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        if (this.f19299a.t0.I.e0()) {
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
                            this.f19299a.q4(rect);
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i3);
                            bVar.C(false);
                            bVar.F(this.f19299a.t0.O0());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.f19299a.h5());
                            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
                            if (this.f19299a.t0 != null) {
                                bVar.A(this.f19299a.t0.getFromForumId());
                                if (this.f19299a.t0.D0() != null) {
                                    bVar.N(this.f19299a.t0.D0().N());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.f19299a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.f19299a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        PbActivity.e eVar = new PbActivity.e();
                        this.f19299a.A5(str, i2, eVar);
                        if (eVar.f19143h) {
                            TbRichText t6 = this.f19299a.t6(str, i2);
                            if (t6 != null && this.f19299a.l2 >= 0 && this.f19299a.l2 < t6.y().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a2 = d.a.s0.h2.h.f.a(t6.y().get(this.f19299a.l2));
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= eVar.f19136a.size()) {
                                        break;
                                    } else if (eVar.f19136a.get(i7).equals(a2)) {
                                        eVar.j = i7;
                                        arrayList2.add(a2);
                                        break;
                                    } else {
                                        i7++;
                                    }
                                }
                                if (t6.getPostId() != 0 && (l0 = this.f19299a.A0.l0()) != null) {
                                    ArrayList<d.a.c.k.e.n> s = l0.s();
                                    if (ListUtils.getCount(s) > 0) {
                                        Iterator<d.a.c.k.e.n> it = s.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            d.a.c.k.e.n next = it.next();
                                            if ((next instanceof PostData) && t6.getPostId() == d.a.c.e.m.b.f(((PostData) next).E(), 0L)) {
                                                d.a.s0.h2.m.a.b(this.f19299a.t0.D0(), (PostData) next, ((PostData) next).i0, t6.getPostId() == d.a.c.e.m.b.f(this.f19299a.t0.e0(), 0L) ? 1 : 8, 3);
                                            }
                                        }
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.f19137b.get(str2));
                                }
                                Rect rect2 = new Rect();
                                view.getGlobalVisibleRect(rect2);
                                this.f19299a.q4(rect2);
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.f19138c);
                                bVar2.y(eVar.f19139d);
                                bVar2.O(eVar.f19140e);
                                bVar2.C(eVar.f19142g);
                                bVar2.H(true);
                                bVar2.J(eVar.f19144i);
                                bVar2.F(this.f19299a.t0.O0());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.f19299a.h5());
                                bVar2.L(eVar.f19141f);
                                bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                                if (this.f19299a.t0 != null) {
                                    bVar2.A(this.f19299a.t0.getFromForumId());
                                    if (this.f19299a.t0.D0() != null) {
                                        bVar2.N(this.f19299a.t0.D0().N());
                                    }
                                }
                                ImageViewerConfig v2 = bVar2.v(this.f19299a.getPageContext().getPageActivity());
                                v2.getIntent().putExtra("from", "pb");
                                this.f19299a.sendMessage(new CustomMessage(2010000, v2));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                                return;
                            }
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(eVar.f19136a, 0));
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList3)) {
                            String str3 = (String) arrayList3.get(0);
                            concurrentHashMap3.put(str3, eVar.f19137b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.f19138c);
                        bVar3.y(eVar.f19139d);
                        bVar3.O(eVar.f19140e);
                        bVar3.C(eVar.f19142g);
                        bVar3.H(true);
                        bVar3.J(eVar.f19136a.get(0));
                        bVar3.F(this.f19299a.t0.O0());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.f19299a.h5());
                        bVar3.L(eVar.f19141f);
                        bVar3.D(false);
                        if (this.f19299a.t0 != null) {
                            bVar3.A(this.f19299a.t0.getFromForumId());
                            if (this.f19299a.t0.D0() != null) {
                                bVar3.N(this.f19299a.t0.D0().N());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.f19299a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.f19299a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    boolean w = ((TbImageView) view).w();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.f19299a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.f19299a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                    }
                    this.f19299a.U = view;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19300e;

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
            this.f19300e = pbFragment;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.f19300e.t0 != null && this.f19300e.t0.p0()) {
                    this.f19300e.s5();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v0 implements PbModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19301a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19302e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f19303f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ v0 f19304g;

            public a(v0 v0Var, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {v0Var, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19304g = v0Var;
                this.f19302e = i2;
                this.f19303f = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19304g.f19301a.getListView() == null) {
                    return;
                }
                this.f19304g.f19301a.getListView().setSelectionFromTop(this.f19302e, this.f19303f);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19305e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f19306f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f19307g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ v0 f19308h;

            public b(v0 v0Var, int i2, boolean z, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {v0Var, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19308h = v0Var;
                this.f19305e = i2;
                this.f19306f = z;
                this.f19307g = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19305e == -1 || this.f19308h.f19301a.getListView() == null) {
                    return;
                }
                if (this.f19306f) {
                    this.f19308h.f19301a.A0.R2(this.f19305e, this.f19307g);
                } else {
                    this.f19308h.f19301a.A0.R2(this.f19305e - 1, this.f19307g);
                }
            }
        }

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
            this.f19301a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) && d.a.r0.m0.k.d().g()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.f19301a.r : j;
                if (this.f19301a.s == 0) {
                    this.f19301a.s = currentTimeMillis;
                }
                long j3 = currentTimeMillis;
                d.a.r0.m0.h hVar = new d.a.r0.m0.h(i2, z, responsedMessage, this.f19301a.v, this.f19301a.u, this.f19301a.s, z2, 0L, 0L, j3);
                this.f19301a.u = 0L;
                this.f19301a.v = 0L;
                hVar.c();
                if (z2) {
                    j2 = j3;
                    hVar.B = j2;
                    hVar.e(true);
                } else {
                    j2 = j3;
                }
                if (z2 || this.f19301a.t0 == null || this.f19301a.t0.D0() == null || this.f19301a.t0.D0().N() == null) {
                    return;
                }
                int j1 = this.f19301a.t0.D0().N().j1();
                if (j1 == 0 || j1 == 40) {
                    if (!StringHelper.equals(this.f19301a.O, PbActivityConfig.KEY_FROM_PERSONALIZE)) {
                        if (StringHelper.equals(this.f19301a.O, "from_frs")) {
                            d.a.r0.m0.h hVar2 = new d.a.r0.m0.h();
                            hVar2.a(1000);
                            hVar2.D = j2;
                            hVar2.d(j1);
                            return;
                        }
                        return;
                    }
                    d.a.r0.m0.d dVar = new d.a.r0.m0.d();
                    dVar.F = 1;
                    dVar.a(1005);
                    dVar.D = j2;
                    dVar.d(j1);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.a.s0.h2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                this.f19301a.A0.n1(eVar);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, d.a.s0.h2.h.e eVar, String str, int i5) {
            d.a.r0.w.h m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), eVar, str, Integer.valueOf(i5)}) == null) {
                if (!z || eVar == null || eVar.V() != null || ListUtils.getCount(eVar.E()) >= 1) {
                    this.f19301a.l = true;
                    this.f19301a.A0.L2();
                    if (eVar == null || !eVar.i0()) {
                        PbFragment pbFragment = this.f19301a;
                        pbFragment.hideLoadingView(pbFragment.A0.V0());
                    }
                    this.f19301a.A0.d1();
                    if (this.f19301a.L || this.f19301a.A0.z1()) {
                        this.f19301a.A0.X0();
                    } else if (!this.f19301a.A0.s1()) {
                        this.f19301a.A0.Y2(false);
                    }
                    if (this.f19301a.m) {
                        this.f19301a.m = false;
                    }
                    if (i5 == 0 && eVar != null) {
                        this.f19301a.I0 = true;
                    }
                    if (eVar != null) {
                        PbFragment pbFragment2 = this.f19301a;
                        pbFragment2.hideNetRefreshView(pbFragment2.A0.V0());
                        this.f19301a.A0.V2();
                    }
                    ArrayList<PostData> arrayList = null;
                    String N0 = null;
                    arrayList = null;
                    if (z && eVar != null) {
                        d.a.r0.r.q.b2 N = eVar.N();
                        if (N != null && N.p2()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.f19301a;
                            pbFragment3.Q5(pbFragment3.O0);
                        }
                        this.f19301a.A0.K0().l(eVar);
                        this.f19301a.A0.e3();
                        if (N != null && N.K() != null) {
                            this.f19301a.r6(N.K());
                        }
                        if (this.f19301a.P0 != null) {
                            this.f19301a.A0.q2(this.f19301a.P0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(eVar.T().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.T().getBimg_end_time());
                        if (eVar.E() != null && eVar.E().size() >= 1 && eVar.E().get(0) != null) {
                            this.f19301a.t0.M1(eVar.E().get(0).E());
                        } else if (eVar.V() != null) {
                            this.f19301a.t0.M1(eVar.V().E());
                        }
                        if (this.f19301a.P0 != null) {
                            this.f19301a.P0.M(eVar.d());
                            this.f19301a.P0.N(eVar.m(), eVar.T());
                            this.f19301a.P0.r0(N);
                            this.f19301a.P0.O(this.f19301a.t0.h0(), this.f19301a.t0.T0(), this.f19301a.t0.e0());
                            if (N != null) {
                                this.f19301a.P0.h0(N.b2());
                            }
                        }
                        if (this.f19301a.v0 != null) {
                            this.f19301a.v0.h(eVar.s());
                        }
                        if (eVar.t() == 1) {
                            this.f19301a.w = true;
                        } else {
                            this.f19301a.w = false;
                        }
                        if (eVar.e0()) {
                            this.f19301a.w = true;
                        }
                        this.f19301a.A0.r2(this.f19301a.w);
                        this.f19301a.A0.i3(eVar, i3, i4, this.f19301a.t0.R0(), i5, this.f19301a.t0.n0());
                        this.f19301a.A0.t3(eVar, this.f19301a.t0.R0());
                        this.f19301a.A0.z3(this.f19301a.t0.i0());
                        AntiData d2 = eVar.d();
                        if (d2 != null) {
                            this.f19301a.D = d2.getVoice_message();
                            if (!StringUtils.isNull(this.f19301a.D) && this.f19301a.P0 != null && this.f19301a.P0.a() != null && (m = this.f19301a.P0.a().m(6)) != null && !TextUtils.isEmpty(this.f19301a.D)) {
                                ((View) m).setOnClickListener(this.f19301a.A1);
                            }
                        }
                        if (this.f19301a.K0) {
                            this.f19301a.K0 = false;
                            int w4 = this.f19301a.w4();
                            if (!eVar.l0()) {
                                this.f19301a.A0.S2(w4);
                            } else {
                                d.a.c.e.m.e.a().post(new a(this, w4, (int) (d.a.c.e.p.l.k(this.f19301a.getContext()) * 0.5625d)));
                            }
                        }
                        if (!this.f19301a.a0 && !ListUtils.isEmpty(this.f19301a.t0.D0().E()) && !this.f19301a.t0.c1()) {
                            this.f19301a.a0 = true;
                            this.f19301a.X3(false);
                        }
                        if (this.f19301a.L0) {
                            this.f19301a.L0 = false;
                            int w42 = this.f19301a.w4();
                            boolean z2 = w42 != -1;
                            if (!z2) {
                                w42 = this.f19301a.t4();
                            }
                            if (this.f19301a.A0 != null) {
                                if (!eVar.l0()) {
                                    this.f19301a.A0.S2(w42);
                                } else {
                                    d.a.c.e.m.e.a().post(new b(this, w42, z2, (int) (d.a.c.e.p.l.k(this.f19301a.getContext()) * 0.5625d)));
                                    this.f19301a.A0.s2(true);
                                    this.f19301a.A0.Y2(false);
                                }
                            }
                        } else if (this.f19301a.M0) {
                            this.f19301a.M0 = false;
                            this.f19301a.A0.R2(0, 0);
                        } else {
                            this.f19301a.A0.d3();
                        }
                        this.f19301a.t0.k1(eVar.m(), this.f19301a.E1);
                        this.f19301a.t0.q1(this.f19301a.G1);
                        if (this.f19301a.S0 != null && N != null && N.H() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(N.H());
                            this.f19301a.S0.setLikeUserData(attentionHostData);
                        }
                        if (this.f19301a.t0 == null || !this.f19301a.t0.b1()) {
                            if (this.f19301a.A0 != null) {
                                N0 = this.f19301a.A0.N0();
                            }
                        } else {
                            N0 = this.f19301a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                        }
                        if (!StringUtils.isNull(N0)) {
                            this.f19301a.P0.k0(TbSingleton.getInstance().getAdVertiComment(eVar.g0(), eVar.h0(), N0));
                        }
                    } else if (str != null) {
                        if (this.f19301a.I0 || i5 != 1) {
                            this.f19301a.showToast(str);
                        } else if (i3 == 3 || i3 == 4 || i3 == 6) {
                            if (i2 == 4) {
                                if (this.f19301a.t0.V() != null && !StringUtils.isNull(this.f19301a.t0.V().f60133c)) {
                                    this.f19301a.A0.B3(this.f19301a.t0.V());
                                } else {
                                    PbFragment pbFragment4 = this.f19301a;
                                    pbFragment4.showNetRefreshView(pbFragment4.A0.V0(), this.f19301a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                                    PbFragment pbFragment5 = this.f19301a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(pbFragment5.getContext(), R.dimen.ds360));
                                }
                            } else {
                                PbFragment pbFragment6 = this.f19301a;
                                pbFragment6.showNetRefreshView(pbFragment6.A0.V0(), this.f19301a.getPageContext().getResources().getString(R.string.net_error_text, str, Integer.valueOf(i2)), true);
                                PbFragment pbFragment7 = this.f19301a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(d.a.c.e.p.l.g(pbFragment7.getContext(), R.dimen.ds360));
                            }
                            this.f19301a.A0.X0();
                            this.f19301a.A0.W0();
                        }
                        if (i2 == 4 || i2 == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.f19301a.t0.T0());
                                jSONObject.put("fid", this.f19301a.t0.getForumId());
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
                            if (this.f19301a.t0 != null && this.f19301a.t0.D0() != null) {
                                arrayList = this.f19301a.t0.D0().E();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.f19301a.A0.n2(this.f19301a.getResources().getString(R.string.list_no_more_new));
                            } else {
                                if (this.f19301a.h5()) {
                                    this.f19301a.A0.o2(this.f19301a.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    this.f19301a.A0.o2(this.f19301a.getResources().getString(R.string.pb_no_replay));
                                }
                                this.f19301a.A0.n1(this.f19301a.t0.D0());
                            }
                        } else {
                            this.f19301a.A0.n2("");
                        }
                        this.f19301a.A0.g0();
                    }
                    if (eVar != null && eVar.m && this.f19301a.s == 0) {
                        this.f19301a.s = System.currentTimeMillis() - this.f19301a.r;
                    }
                    if (this.f19301a.y().R0() && this.f19301a.y().D0().x().c() == 0 && !this.f19301a.y().a1()) {
                        return;
                    }
                    this.f19301a.Q0 = true;
                    return;
                }
                this.f19301a.t0.V1(1);
                if (this.f19301a.f19184i != null) {
                    this.f19301a.f19184i.x();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f19301a.t0 == null) {
                return;
            }
            if (this.f19301a.P0 == null || !this.f19301a.P0.z) {
                d.a.r0.w.w.d dVar = new d.a.r0.w.w.d();
                this.f19301a.Q5(dVar);
                PbFragment pbFragment = this.f19301a;
                pbFragment.P0 = (d.a.r0.w.w.e) dVar.a(pbFragment.getContext());
                this.f19301a.P0.e0(this.f19301a.f19180e.getPageContext());
                this.f19301a.P0.n0(this.f19301a.Y1);
                this.f19301a.P0.o0(this.f19301a.W0);
                this.f19301a.P0.F(this.f19301a.f19180e.getPageContext(), this.f19301a.f19180e.getIntent() == null ? null : this.f19301a.f19180e.getIntent().getExtras());
                this.f19301a.P0.a().C(true);
                this.f19301a.A0.m2(this.f19301a.P0.a());
                if (!this.f19301a.t0.r0()) {
                    this.f19301a.P0.s(this.f19301a.t0.T0());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.f19301a.P0.k0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.f19301a.t0.b1()) {
                    this.f19301a.P0.k0(this.f19301a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else if (this.f19301a.A0 != null) {
                    this.f19301a.P0.k0(this.f19301a.A0.N0());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19309a;

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
            this.f19309a = pbFragment;
        }

        @Override // d.a.r0.r.s.b.c
        public void a(d.a.r0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                PbFragment pbFragment = this.f19309a;
                PostData postData = pbFragment.o2;
                if (postData != null) {
                    if (i2 == 0) {
                        postData.h0(pbFragment.getPageContext().getPageActivity());
                        this.f19309a.o2 = null;
                    } else if (i2 == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.f19309a;
                        pbFragment2.v5(pbFragment2.o2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19310a;

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
            this.f19310a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.f19310a.P0.L(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.f19310a.A0 != null && this.f19310a.A0.K0() != null && this.f19310a.A0.K0().b() != null) {
                    this.f19310a.A0.K0().b().D();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.f19310a;
                    pbFragment.K5(pbFragment.V0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19311a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(PbFragment pbFragment, int i2) {
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
            this.f19311a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f19311a.q6();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19312a;

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
            this.f19312a = pbFragment;
        }

        @Override // d.a.r0.r.s.b.c
        public void a(d.a.r0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.f19312a.g1 == null || TextUtils.isEmpty(this.f19312a.h1)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f19312a.i1 == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f19312a.h1));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f54736a = this.f19312a.h1;
                        String str = "";
                        if (this.f19312a.i1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f19312a.i1.memeInfo.pck_id;
                        }
                        aVar.f54737b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f19312a.R0 == null) {
                        this.f19312a.R0 = new PermissionJudgePolicy();
                    }
                    this.f19312a.R0.clearRequestPermissionList();
                    this.f19312a.R0.appendRequestPermission(this.f19312a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (this.f19312a.R0.startRequestPermission(this.f19312a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f19312a.f1 == null) {
                        PbFragment pbFragment = this.f19312a;
                        pbFragment.f1 = new d.a.s0.h2.k.e.x0(pbFragment.getPageContext());
                    }
                    this.f19312a.f1.b(this.f19312a.h1, this.f19312a.g1.n());
                }
                this.f19312a.g1 = null;
                this.f19312a.h1 = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements CheckRealNameModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19313a;

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
            this.f19313a = pbFragment;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i2, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, obj}) == null) {
                this.f19313a.A0.b1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i2 == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.f19313a.g6(num.intValue());
                    } else if (i2 == 1990055) {
                        TiebaStatic.log("c12142");
                        d.a.s0.b1.a.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.f19313a.getResources().getString(R.string.neterror);
                        }
                        this.f19313a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19314a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(PbFragment pbFragment, int i2, boolean z) {
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
            this.f19314a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f19314a.A0 != null) {
                    PbFragment pbFragment = this.f19314a;
                    pbFragment.hideLoadingView(pbFragment.A0.V0());
                    this.f19314a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.f19314a.getContext());
                            bdTopToast.i(true);
                            bdTopToast.h(this.f19314a.getString(R.string.block_user_success));
                            bdTopToast.j((ViewGroup) this.f19314a.getView());
                            this.f19314a.R5(type);
                            return;
                        }
                        String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f19314a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString();
                        BdTopToast bdTopToast2 = new BdTopToast(this.f19314a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(string);
                        bdTopToast2.j((ViewGroup) this.f19314a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19315e;

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
            this.f19315e = pbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f19315e.t0 == null || this.f19315e.t0.M0() == i2 + 1) {
                return;
            }
            PbFragment pbFragment = this.f19315e;
            pbFragment.O5(pbFragment.N4(i2));
        }
    }

    /* loaded from: classes5.dex */
    public class y implements s2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19316a;

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
            this.f19316a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.s2
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!d.a.c.e.p.j.z()) {
                    this.f19316a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f19316a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f19316a.getPageContext().getPageActivity(), this.f19316a.t0.D0().m().getId(), this.f19316a.t0.D0().m().getName(), this.f19316a.t0.D0().N().c0(), String.valueOf(this.f19316a.t0.D0().T().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y0 implements a.InterfaceC1243a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19317a;

        public y0(PbFragment pbFragment) {
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
            this.f19317a = pbFragment;
        }

        @Override // d.a.r0.h.a.InterfaceC1243a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.f19317a.A0.L2();
                if (z) {
                    if (this.f19317a.v0 != null) {
                        this.f19317a.v0.h(z2);
                    }
                    this.f19317a.t0.X1(z2);
                    if (this.f19317a.t0.p0()) {
                        this.f19317a.s5();
                    } else {
                        this.f19317a.A0.n1(this.f19317a.t0.D0());
                    }
                    if (z2) {
                        if (this.f19317a.v0 != null) {
                            if (this.f19317a.v0.f() == null || this.f19317a.t0 == null || this.f19317a.t0.D0() == null || this.f19317a.t0.D0().N() == null || this.f19317a.t0.D0().N().H() == null) {
                                return;
                            }
                            MarkData f2 = this.f19317a.v0.f();
                            MetaData H = this.f19317a.t0.D0().N().H();
                            if (f2 != null && H != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), H.getUserId()) && !H.hadConcerned()) {
                                    this.f19317a.b6(H);
                                } else {
                                    this.f19317a.showToast(R.string.add_mark_on_pb);
                                    if (d.a.r0.s.h.a.e(this.f19317a.getContext(), 0)) {
                                        d.a.r0.s.h.a.g(this.f19317a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment pbFragment = this.f19317a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.add_mark));
                            }
                        }
                        this.f19317a.U3();
                        return;
                    }
                    PbFragment pbFragment2 = this.f19317a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                PbFragment pbFragment3 = this.f19317a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements r2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19318a;

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
            this.f19318a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.r2
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f19318a.A0 != null && this.f19318a.A0.K0() != null) {
                    d.a.s0.h2.k.e.u K0 = this.f19318a.A0.K0();
                    if (K0.f()) {
                        K0.d();
                        return true;
                    }
                }
                if (this.f19318a.A0 == null || !this.f19318a.A0.B1()) {
                    return false;
                }
                this.f19318a.A0.f1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19319a;

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
            this.f19319a = pbFragment;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f19319a.isAdded()) {
                    if (view != null) {
                        if (view.getId() == R.id.richText) {
                            if (this.f19319a.J5(view)) {
                                return true;
                            }
                        } else if (view.getId() == R.id.pb_floor_item_layout) {
                            if (view.getTag(R.id.tag_from) instanceof SparseArray) {
                                this.f19319a.k6((SparseArray) view.getTag(R.id.tag_from));
                            }
                        } else if (!(view instanceof TbRichTextView) && view.getId() != R.id.pb_post_header_layout) {
                            if (this.f19319a.A0.u1() && view.getId() == R.id.pb_head_user_info_root) {
                                if (view.getTag(R.id.tag_user_id) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view.getTag(R.id.tag_user_id)));
                                }
                                if (this.f19319a.getEventController() != null && this.f19319a.getEventController().f60414b != null) {
                                    this.f19319a.getEventController().f60414b.onClick(view);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.f19319a.k6(sparseArray);
                        }
                    }
                    if (this.f19319a.P0 != null) {
                        this.f19319a.A0.q2(this.f19319a.P0.C());
                    }
                    this.f19319a.A0.j2();
                    this.f19319a.A0.a0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.s0.h2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.f19319a.isAdded()) {
                    this.f19319a.l4();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f19320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19321f;

        public z0(PbFragment pbFragment, MetaData metaData) {
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
            this.f19321f = pbFragment;
            this.f19320e = metaData;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f19320e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19322e;

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
            this.f19322e = pbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                PbFragment pbFragment = this.f19322e;
                pbFragment.f19181f = true;
                return pbFragment.f4(view);
            }
            return invokeL.booleanValue;
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
        D2 = new g0();
        E2 = new g2();
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
        this.f19181f = true;
        this.f19182g = false;
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
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = "";
        this.P = true;
        this.Q = false;
        this.R = "";
        this.Z = 3;
        this.b0 = new int[2];
        this.i0 = -1;
        this.j0 = -1;
        this.l0 = BdUniqueId.gen();
        this.n0 = false;
        this.p0 = d.a.r0.b.d.W();
        this.r0 = new k(this);
        this.s0 = new Handler(new v(this));
        this.t0 = null;
        this.v0 = null;
        this.w0 = null;
        this.x0 = null;
        this.y0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = false;
        this.C0 = false;
        this.D0 = false;
        this.I0 = false;
        this.K0 = false;
        this.L0 = false;
        this.M0 = false;
        this.W0 = new r0(this);
        this.X0 = new c1(this);
        this.Y0 = new n1(this);
        this.Z0 = 0;
        this.j1 = false;
        this.k1 = 0;
        this.l1 = -1;
        this.n1 = 0;
        this.q1 = new y1(this);
        this.r1 = new j2(this);
        this.s1 = new q2(this, 2004016);
        this.t1 = new a(this, 2016485);
        this.u1 = new b(this, 2001269);
        this.v1 = new c(this, 2004008);
        this.w1 = new d(this, 2004007);
        this.x1 = new e(this, 2004005);
        this.y1 = new f(this, 2001332);
        this.z1 = new g(this, 2921391);
        this.A1 = new h(this);
        this.B1 = new i(this, 2001369);
        this.C1 = new j(this, 2016488);
        this.D1 = new l(this, 2016331);
        this.E1 = new m(this);
        this.F1 = new n(this, 2921509);
        this.G1 = new o(this);
        this.I1 = new PraiseModel(getPageContext(), new p(this));
        this.J1 = new q(this);
        this.K1 = new s(this, 2001115);
        this.L1 = new t(this);
        this.M1 = new x(this);
        this.N1 = new d.a.s0.h2.i.c(new z(this));
        this.O1 = new b0(this, 2001427);
        this.P1 = new c0(this, 2001428);
        this.Q1 = new d0(this, 2001426);
        this.R1 = new e0(this, 2004021);
        this.S1 = new f0(this, 2921033);
        this.T1 = new h0(this);
        this.U1 = new i0(this);
        this.V1 = new m0(this);
        this.W1 = new p0(this);
        this.X1 = new q0(this, 2921480);
        this.Y1 = new s0(this);
        this.Z1 = new t0(this);
        this.a2 = new u0(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.b2 = new v0(this);
        this.c2 = new w0(this, 2016450);
        this.d2 = new x0(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.e2 = new y0(this);
        this.f2 = new b1(this);
        this.g2 = new f1(this);
        this.h2 = new h1(this);
        this.i2 = new i1(this);
        this.k2 = new j1(this);
        this.l2 = 0;
        this.m2 = new u1(this);
        this.n2 = false;
        this.o2 = null;
        this.p2 = new v1(this);
        this.q2 = new w1(this);
        this.r2 = new x1(this);
        this.s2 = new z1(this);
        this.t2 = new a2(this);
        this.u2 = new b2(this);
        this.v2 = new c2(this);
        this.w2 = new e2(this);
        this.x2 = new f2(this);
        this.y2 = new h2(this);
        this.z2 = -1;
        this.A2 = -1;
    }

    public static PbFragment x5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65700, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public final int A4(TbRichText tbRichText, TbRichText tbRichText2, int i3, int i4, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i3), Integer.valueOf(i4), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.n2 = true;
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
                            String a3 = d.a.s0.h2.h.f.a(tbRichTextData);
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
                                    imageUrlData.originalUrl = J4(tbRichTextData);
                                    imageUrlData.originalSize = K4(tbRichTextData);
                                    imageUrlData.mIsShowOrigonButton = E4(tbRichTextData);
                                    imageUrlData.isLongPic = C4(tbRichTextData);
                                    imageUrlData.postId = tbRichText.getPostId();
                                    imageUrlData.threadId = d.a.c.e.m.b.f(this.t0.T0(), -1L);
                                    imageUrlData.mIsReserver = this.t0.O0();
                                    imageUrlData.mIsSeeHost = this.t0.i0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a3, imageUrlData);
                                    }
                                }
                            }
                            if (!this.n2) {
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

    public final void A5(String str, int i3, PbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i3, eVar) == null) || eVar == null) {
            return;
        }
        d.a.s0.h2.h.e D0 = this.t0.D0();
        TbRichText t6 = t6(str, i3);
        if (t6 == null || (tbRichTextData = t6.y().get(this.l2)) == null) {
            return;
        }
        eVar.f19141f = String.valueOf(t6.getPostId());
        eVar.f19136a = new ArrayList<>();
        eVar.f19137b = new ConcurrentHashMap<>();
        if (!tbRichTextData.B().D()) {
            eVar.f19143h = false;
            String a3 = d.a.s0.h2.h.f.a(tbRichTextData);
            eVar.f19136a.add(a3);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                imageUrlData.urlType = this.w ? 17 : 18;
            }
            imageUrlData.originalUrl = J4(tbRichTextData);
            imageUrlData.originalUrl = J4(tbRichTextData);
            imageUrlData.originalSize = K4(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = E4(tbRichTextData);
            imageUrlData.isLongPic = C4(tbRichTextData);
            imageUrlData.postId = t6.getPostId();
            imageUrlData.mIsReserver = this.t0.O0();
            imageUrlData.mIsSeeHost = this.t0.i0();
            eVar.f19137b.put(a3, imageUrlData);
            if (D0 != null) {
                if (D0.m() != null) {
                    eVar.f19138c = D0.m().getName();
                    eVar.f19139d = D0.m().getId();
                }
                if (D0.N() != null) {
                    eVar.f19140e = D0.N().c0();
                }
                eVar.f19142g = D0.t() == 1;
            }
            imageUrlData.threadId = d.a.c.e.m.b.f(eVar.f19140e, -1L);
            return;
        }
        eVar.f19143h = true;
        int size = D0.E().size();
        this.n2 = false;
        eVar.j = -1;
        int A4 = D0.j() != null ? A4(D0.j().K(), t6, i3, i3, eVar.f19136a, eVar.f19137b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = D0.E().get(i4);
            if (postData.E() == null || D0.j() == null || D0.j().E() == null || !postData.E().equals(D0.j().E())) {
                A4 = A4(postData.K(), t6, A4, i3, eVar.f19136a, eVar.f19137b);
            }
        }
        if (eVar.f19136a.size() > 0) {
            ArrayList<String> arrayList = eVar.f19136a;
            eVar.f19144i = arrayList.get(arrayList.size() - 1);
        }
        if (D0 != null) {
            if (D0.m() != null) {
                eVar.f19138c = D0.m().getName();
                eVar.f19139d = D0.m().getId();
            }
            if (D0.N() != null) {
                eVar.f19140e = D0.N().c0();
            }
            eVar.f19142g = D0.t() == 1;
        }
        eVar.j = A4;
    }

    public PbInterviewStatusView.f B4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public void B5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || !checkUpIsLogin() || (pbModel = this.t0) == null || pbModel.D0() == null || this.t0.D0().m() == null || Y3()) {
            return;
        }
        if (this.t0.D0().e0()) {
            this.A0.T();
            return;
        }
        if (this.T0 == null) {
            d.a.s0.u0.f2.a.c cVar = new d.a.s0.u0.f2.a.c(getPageContext());
            this.T0 = cVar;
            cVar.k(0);
            this.T0.j(new l0(this));
        }
        this.T0.h(this.t0.D0().m().getId(), d.a.c.e.m.b.f(this.t0.T0(), 0L));
    }

    @Override // d.a.s0.h2.o.b
    public PbFragment C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    public final boolean C4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return false;
            }
            return tbRichTextData.B().E();
        }
        return invokeL.booleanValue;
    }

    public final PbActivity.e C5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            String str2 = null;
            if (this.t0.D0() != null && this.t0.D0().E() != null && this.t0.D0().E().size() != 0 && !StringUtils.isNull(str)) {
                PbActivity.e eVar = new PbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.t0.D0().E().size()) {
                        i3 = 0;
                        break;
                    } else if (str.equals(this.t0.D0().E().get(i3).E())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                PostData postData = this.t0.D0().E().get(i3);
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
                    A5(str2, 0, eVar);
                    d.a.s0.h2.h.f.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (PbActivity.e) invokeL.objValue;
    }

    public boolean D4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (!this.f19182g && this.z2 == -1 && this.A2 == -1) ? false : true : invokeV.booleanValue;
    }

    public final void D5(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.f19181f ? 2 : 3));
        view.setTag(sparseArray);
    }

    public final boolean E4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return false;
            }
            return tbRichTextData.B().F();
        }
        return invokeL.booleanValue;
    }

    public void E5(d.a.s0.h2.h.r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rVar) == null) {
            String E = rVar.i().E();
            List<PostData> list = this.t0.D0().S().f60195a;
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
            if (this.t0.n0()) {
                return;
            }
            this.A0.n1(this.t0.D0());
        }
    }

    public boolean F4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public void F5(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z2, markData) == null) {
            this.A0.L2();
            this.t0.X1(z2);
            d.a.r0.h.a aVar = this.v0;
            if (aVar != null) {
                aVar.h(z2);
                if (markData != null) {
                    this.v0.i(markData);
                }
            }
            if (this.t0.p0()) {
                s5();
            } else {
                this.A0.n1(this.t0.D0());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.r0.b1.m.h
    /* renamed from: G4 */
    public BdListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d.a.s0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var == null) {
                return null;
            }
            return t0Var.B0();
        }
        return (BdListView) invokeV.objValue;
    }

    public void G5(d.a.s0.h2.h.r rVar) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, rVar) == null) || rVar.i() == null) {
            return;
        }
        String E = rVar.i().E();
        ArrayList<PostData> E3 = this.t0.D0().E();
        int i3 = 0;
        while (true) {
            z2 = true;
            if (i3 >= E3.size()) {
                break;
            }
            PostData postData = E3.get(i3);
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
                            next.z0(getPageContext(), this.t0.j1(metaData.getUserId()));
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
        if (!this.t0.n0() && z2) {
            this.A0.n1(this.t0.D0());
        }
        if (z2) {
            E5(rVar);
        }
    }

    public int H4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.A2 : invokeV.intValue;
    }

    public final void H5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            hideNetRefreshView(this.A0.V0());
            e6();
            if (this.t0.r1()) {
                this.A0.M2();
            }
            this.A0.V2();
        }
    }

    public int I4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.z2 : invokeV.intValue;
    }

    public void I5(r2 r2Var) {
        List<r2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, r2Var) == null) || r2Var == null || (list = this.m1) == null) {
            return;
        }
        list.remove(r2Var);
    }

    public final String J4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return null;
            }
            return tbRichTextData.B().A();
        }
        return (String) invokeL.objValue;
    }

    public final boolean J5(View view) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.w0 && !TextUtils.isEmpty(postData.u()) && d.a.r0.r.k.c().g()) {
                        return w5(postData.E());
                    }
                    if (checkUpIsLogin() && (pbModel = this.t0) != null && pbModel.D0() != null) {
                        if (P4().K0() != null) {
                            P4().K0().c();
                        }
                        d.a.s0.h2.h.r rVar = new d.a.s0.h2.h.r();
                        rVar.A(this.t0.D0().m());
                        rVar.E(this.t0.D0().N());
                        rVar.C(postData);
                        P4().J0().I(rVar);
                        P4().J0().setPostId(postData.E());
                        r5(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        d.a.r0.w.w.e eVar = this.P0;
                        if (eVar != null) {
                            this.A0.q2(eVar.C());
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

    public final long K4(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.B() == null) {
                return 0L;
            }
            return tbRichTextData.B().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final void K5(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.S == null) {
            d.a.s0.h2.k.e.b1.f.a aVar = new d.a.s0.h2.k.e.b1.f.a(this.f19180e);
            this.S = aVar;
            aVar.n(this.W0);
            this.S.m(this.Y1);
        }
        this.S.k(emotionImageData, y(), y().D0());
    }

    public d.a.r0.w.w.e L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.P0 : (d.a.r0.w.w.e) invokeV.objValue;
    }

    public final void L5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (pbModel = this.t0) == null || pbModel.D0() == null || this.t0.D0().N() == null || !this.t0.D0().N().q2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public d.a.s0.h2.k.e.c1.b M4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f19184i : (d.a.s0.h2.k.e.c1.b) invokeV.objValue;
    }

    public final void M5(boolean z2, PostData postData) {
        d.a.r0.s.c.d adAdSense;
        d.a.s0.h2.k.e.t0 t0Var;
        d.a.s0.h2.k.e.i l02;
        ArrayList<PostData> E;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048602, this, z2, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.h() || (t0Var = this.A0) == null || (l02 = t0Var.l0()) == null || (E = l02.E()) == null) {
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
            String E3 = next.E();
            i3++;
            if (z2) {
                if (next == postData) {
                    a.c cVar = new a.c();
                    cVar.f61294b = E3;
                    cVar.f61295c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.E == 1 && !TextUtils.isEmpty(E3)) {
                next.E = 2;
                a.c cVar2 = new a.c();
                cVar2.f61294b = E3;
                cVar2.f61295c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.t0;
            if (pbModel == null || pbModel.D0() == null || this.t0.D0().m() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.t0.D0().m().getFirst_class();
                str2 = this.t0.D0().m().getSecond_class();
                str3 = this.t0.D0().m().getId();
                str4 = this.t0.T0();
                str = first_class;
            }
            d.a.s0.w2.x.v(z2, str, str2, str3, str4, arrayList, adAdSense.j());
        }
    }

    public final int N4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i3)) == null) {
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

    public final void N5() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (pbModel = this.t0) == null || pbModel.D0() == null || this.t0.D0().N() == null || !this.t0.D0().N().q2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    public d.a.s0.h2.k.e.e1.a O4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.q0 : (d.a.s0.h2.k.e.e1.a) invokeV.objValue;
    }

    public final void O5(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048606, this, i3) == null) || this.t0 == null) {
            return;
        }
        e6();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
        privacySettingMessage.setTid(this.t0.f19381e);
        sendMessage(privacySettingMessage);
    }

    public d.a.s0.h2.k.e.t0 P4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.A0 : (d.a.s0.h2.k.e.t0) invokeV.objValue;
    }

    public void P5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z2) == null) {
            this.P = z2;
        }
    }

    public d.a.r0.r.q.l1 Q4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.k0 : (d.a.r0.r.q.l1) invokeV.objValue;
    }

    public final void Q5(d.a.r0.w.w.g gVar) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, gVar) == null) || gVar == null || (pbModel = this.t0) == null) {
            return;
        }
        gVar.o(pbModel.f0());
        if (this.t0.D0() != null && this.t0.D0().m() != null) {
            gVar.n(this.t0.D0().m());
        }
        gVar.p("pb");
        gVar.q(this.t0);
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.r
    public void R(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048611, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (d.a.r0.b1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d.a.r0.b1.m.f.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (d.a.s0.h2.k.e.y0.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new d.a.r0.b1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public String R4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public final void R5(int i3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048613, this, i3) == null) || (pbModel = this.t0) == null) {
            return;
        }
        int M0 = pbModel.M0();
        if (i3 == 5) {
            this.t0.U1(2);
        } else if (i3 == 6) {
            this.t0.U1(3);
        } else if (i3 != 7) {
            this.t0.U1(1);
        } else {
            this.t0.U1(4);
        }
        int M02 = this.t0.M0();
        if (M0 == 4 || M02 == 4) {
            y5();
        }
    }

    public void S3(r2 r2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, r2Var) == null) || r2Var == null) {
            return;
        }
        if (this.m1 == null) {
            this.m1 = new ArrayList();
        }
        if (this.m1.contains(r2Var)) {
            return;
        }
        this.m1.add(r2Var);
    }

    public final int S4(d.a.s0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null) {
                return 0;
            }
            if (eVar.N().j1() == 0) {
                return 1;
            }
            if (eVar.N().j1() == 54) {
                return 2;
            }
            return eVar.N().j1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void S5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            this.M = z2;
        }
    }

    public void T3(r2 r2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, r2Var) == null) || r2Var == null) {
            return;
        }
        if (this.m1 == null) {
            this.m1 = new ArrayList();
        }
        if (this.m1.contains(r2Var)) {
            return;
        }
        this.m1.add(0, r2Var);
    }

    public String T4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.R : (String) invokeV.objValue;
    }

    public final void T5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            this.P0.f0(z2);
            this.P0.i0(z2);
            this.P0.p0(z2);
        }
    }

    public final void U3() {
        PbModel pbModel;
        d.a.s0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (pbModel = this.t0) == null || (eVar = pbModel.I) == null || eVar.N() == null) {
            return;
        }
        d.a.r0.r.q.b2 N = this.t0.I.N();
        N.V0 = this.t0.I0();
        N.U0 = this.t0.L0();
        N.T0 = this.t0.K0();
        N.W0 = this.t0.J0();
        N.D2 = this.t0.r0();
        if (N.Q() == 0) {
            N.l3(d.a.c.e.m.b.f(this.t0.getForumId(), 0L));
        }
        StatisticItem i3 = d.a.r0.j0.c.i(getContext(), N, "c13562");
        TbPageTag l3 = d.a.r0.j0.c.l(getContext());
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

    public void U4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.k) {
                this.Q = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.t0.D0() == null || this.t0.D0().N() == null || this.t0.D0().N().e1() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.t0.D0().N().e1().g(), this.t0.D0().N().e1().f(), this.t0.D0().N().e1().b(), this.t0.D0().N().e1().c(), this.t0.D0().N().m0(), this.t0.D0().N().l0())));
                this.f19180e.finish();
            }
        }
    }

    public final void U5(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048622, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new e1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                h6(str);
            } else {
                this.A0.u3(str);
            }
        }
    }

    public final void V3(boolean z2) {
        PbModel pbModel;
        d.a.s0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) || (pbModel = this.t0) == null || (eVar = pbModel.I) == null || eVar.N() == null) {
            return;
        }
        d.a.r0.r.q.b2 N = this.t0.I.N();
        N.V0 = this.t0.I0();
        N.U0 = this.t0.L0();
        N.T0 = this.t0.K0();
        N.W0 = this.t0.J0();
        if (N.Q() == 0) {
            N.l3(d.a.c.e.m.b.f(this.t0.getForumId(), 0L));
        }
        StatisticItem i3 = d.a.r0.j0.c.i(getContext(), N, "c13563");
        TbPageTag l3 = d.a.r0.j0.c.l(getContext());
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
            d.a.r0.i0.c k3 = TbPageExtraHelper.k(getContext());
            if (k3 != null) {
                i3.param(TiebaStatic.Params.OBJ_CUR_PAGE, k3.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i3.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i3);
        }
    }

    public final void V4(int i3, Intent intent) {
        d.a.r0.w.n nVar;
        d.a.r0.w.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048624, this, i3, intent) == null) {
            if (i3 == 0) {
                this.A0.Z0();
                this.A0.K0().c();
                this.A0.Y2(false);
            }
            this.A0.j2();
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
                    if (editorType != 1 || this.A0.K0() == null || this.A0.K0().b() == null) {
                        return;
                    }
                    d.a.r0.w.w.h b3 = this.A0.K0().b();
                    b3.X(this.t0.D0().N());
                    b3.z(writeData);
                    b3.Y(pbEditorData.getVoiceModel());
                    d.a.r0.w.m n3 = b3.a().n(6);
                    if (n3 != null && (nVar2 = n3.k) != null) {
                        nVar2.onAction(new d.a.r0.w.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        b3.D();
                        return;
                    }
                    return;
                }
                this.P0.S();
                this.P0.t0(pbEditorData.getVoiceModel());
                this.P0.G(writeData);
                d.a.r0.w.m n4 = this.P0.a().n(6);
                if (n4 != null && (nVar = n4.k) != null) {
                    nVar.onAction(new d.a.r0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    this.P0.L(null, null);
                }
            }
        }
    }

    public final void V5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048625, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (P4() != null) {
                String errorString = postWriteCallBackData.getErrorString();
                String preMsg = postWriteCallBackData.getPreMsg();
                String colorMsg = postWriteCallBackData.getColorMsg();
                if (postWriteCallBackData.getIconStampData() != null) {
                    d.a.r0.s.h.b.a(getPageContext(), postWriteCallBackData);
                    return;
                } else {
                    d.a.s0.h3.q0.g.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.t0.r0()) {
            antiData.setBlock_forum_name(this.t0.D0().m().getName());
            antiData.setBlock_forum_id(this.t0.D0().m().getId());
            antiData.setUser_name(this.t0.D0().T().getUserName());
            antiData.setUser_id(this.t0.D0().T().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void W3(d.a.s0.h2.h.e eVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048626, this, eVar, arrayList) == null) || eVar == null || eVar.S() == null || eVar.S().f60195a == null || (list = eVar.S().f60195a) == null || arrayList == null) {
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

    public void W4(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.d1);
            userMuteAddAndDelCustomMessage.setTag(this.d1);
            i6(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public final void W5(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            d.a.s0.h2.k.e.f1.b.j(this, j3, str, j4);
        }
    }

    public void X3(boolean z2) {
        d.a.s0.h2.k.e.t0 t0Var;
        int w2;
        int w3;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) || (t0Var = this.A0) == null || t0Var.B0() == null) {
            return;
        }
        int firstVisiblePosition = this.A0.B0().getFirstVisiblePosition();
        int lastVisiblePosition = this.A0.B0().getLastVisiblePosition();
        d.a.s0.h2.k.e.i l02 = this.A0.l0();
        if (l02 == null || this.t0.D0() == null) {
            return;
        }
        if (lastVisiblePosition <= l02.w()) {
            w2 = 0;
            w3 = 1;
        } else {
            w2 = firstVisiblePosition > l02.w() ? firstVisiblePosition - l02.w() : 0;
            w3 = (lastVisiblePosition - l02.w()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (w3 > w2) {
            while (w2 < w3) {
                if (this.A0.B0().G(w2) != null && (this.A0.B0().G(w2) instanceof PostData) && (postData = (PostData) this.A0.B0().G(w2)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.t0.D0().E(), postData.A() - 1);
                    if (postData.p() == null && postData2 != null) {
                        postData.f0(postData2.p());
                    }
                    if (postData.p() != null) {
                        postData.p().j(postData.A());
                        arrayList.add(postData.p());
                    }
                }
                w2++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new d1(this));
            if (((d.a.r0.t.a) ListUtils.getItem(arrayList, 0)).c() != 1) {
                this.A0.x3();
                this.A0.X1((d.a.r0.t.a) ListUtils.getItem(arrayList, 0), 1);
            } else if (z2) {
            } else {
                this.A0.x3();
                this.A0.X1((d.a.r0.t.a) ListUtils.getItem(arrayList, 0), 0);
            }
        }
    }

    public final void X4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            PbModel pbModel = this.t0;
            if (pbModel != null && pbModel.D0() != null && this.t0.D0().e0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.t0.T0(), str);
                d.a.r0.r.q.b2 N = this.t0.D0().N();
                if (N.E1()) {
                    format = format + "&channelid=33833";
                } else if (N.J1()) {
                    format = format + "&channelid=33842";
                } else if (N.H1()) {
                    format = format + "&channelid=33840";
                }
                m5(format);
                return;
            }
            this.u0.i(str);
        }
    }

    public final void X5(SparseArray<Object> sparseArray, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{sparseArray, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            d.a.s0.h2.k.e.f1.a.d(getActivity(), getPageContext(), new j0(this, sparseArray, i3, z2), new k0(this));
        }
    }

    @Override // d.a.s0.h2.o.b
    public PbModel.g Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.b2 : (PbModel.g) invokeV.objValue;
    }

    public final boolean Y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null || pbModel.D0() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.t0.D0().N()) || AntiHelper.d(getPageContext(), this.t0.D0().d());
        }
        return invokeV.booleanValue;
    }

    public final void Y4(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, intent) == null) {
            d.a.s0.h2.k.e.f1.b.i(this, intent);
        }
    }

    public final boolean Y5(boolean z2) {
        InterceptResult invokeZ;
        d.a.r0.r.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048635, this, z2)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null || pbModel.D0() == null) {
                return false;
            }
            d.a.s0.h2.h.e D0 = this.t0.D0();
            d.a.r0.r.q.b2 N = D0.N();
            if (N != null) {
                if (N.E1() || N.H1()) {
                    return false;
                }
                if (N.F1() || N.G1()) {
                    return z2;
                }
            }
            if (z2) {
                return true;
            }
            if (N == null || N.H() == null || !N.H().isForumBusinessAccount() || d.a.s0.u0.v0.isOn()) {
                if (D0.m() == null || !D0.m().isBlockBawuDelete) {
                    if (D0.U() != 0) {
                        return D0.U() != 3;
                    }
                    List<d.a.r0.r.q.x1> q3 = D0.q();
                    if (ListUtils.getCount(q3) > 0) {
                        for (d.a.r0.r.q.x1 x1Var : q3) {
                            if (x1Var != null && (e0Var = x1Var.f56101g) != null && e0Var.f55926a && !e0Var.f55928c && ((i3 = e0Var.f55927b) == 1 || i3 == 2)) {
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
        return invokeZ.booleanValue;
    }

    public final boolean Z3(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i3)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i3)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void Z4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || this.f19180e == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.f19180e.getCurrentFocus() == null) {
            return;
        }
        d.a.c.e.p.l.x(getPageContext().getPageActivity(), this.f19180e.getCurrentFocus());
    }

    public final boolean Z5(boolean z2) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z2)) == null) {
            if (z2 || (pbModel = this.t0) == null || pbModel.D0() == null || (this.t0.D0().m() != null && this.t0.D0().m().isBlockBawuDelete)) {
                return false;
            }
            d.a.s0.h2.h.e D0 = this.t0.D0();
            return ((D0.N() != null && D0.N().H() != null && D0.N().H().isForumBusinessAccount() && !d.a.s0.u0.v0.isOn()) || this.t0.D0().U() == 0 || this.t0.D0().U() == 3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public void a4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.A0.f3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = d.a.c.e.m.b.f(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = d.a.c.e.m.b.f((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.d1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.a1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void a5() {
        d.a.s0.h2.k.e.t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || (t0Var = this.A0) == null) {
            return;
        }
        t0Var.Z0();
        Z4();
    }

    public final boolean a6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel != null && pbModel.R0()) {
                return this.t0.B0() == null || this.t0.B0().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if ((this.t0.D0() != null && (this.t0.D0().e0() || ThreadCardUtils.isSelf(this.t0.D0().N()))) || this.S0 == null || this.t0.D0() == null || this.t0.D0().d() == null) {
                return true;
            }
            return this.S0.checkPrivacyBeforeInvokeEditor(this.t0.D0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void b5(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i3) == null) {
            d.a.r0.z0.i0.b(new o2(this), new p2(this, i3));
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

    public final void b6(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048644, this, metaData) == null) || metaData == null) {
            return;
        }
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(getActivity());
        aVar.setTitle(getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(getResources().getString(R.string.mark_like_cancel), new z0(this, metaData));
        aVar.setPositiveButton(getResources().getString(R.string.mark_like_confirm), new a1(this, metaData));
        aVar.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public boolean c4(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048645, this, i3)) == null) {
            if (this.S0 == null || this.t0.D0() == null || ThreadCardUtils.isSelf(this.t0.D0().N()) || this.t0.D0().d() == null) {
                return true;
            }
            return this.S0.checkPrivacyBeforeSend(this.t0.D0().d().replyPrivateFlag, i3);
        }
        return invokeI.booleanValue;
    }

    public final void c5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, bundle) == null) {
            d.a.r0.h.a c3 = d.a.r0.h.a.c(this.f19180e);
            this.v0 = c3;
            if (c3 != null) {
                c3.j(this.e2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f19180e);
            this.w0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.g2);
            this.x0 = new d.a.r0.s.e.a(getPageContext());
            this.I1.setUniqueId(getUniqueId());
            this.I1.registerListener();
        }
    }

    public final void c6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new i2(this));
            aVar.setNegativeButton(R.string.cancel, new k2(this));
            aVar.create(this.b1).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d4(AgreeData agreeData) {
        d.a.r0.i0.c k3;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048648, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.m0 == null) {
            this.m0 = new d.a.r0.r.b0.a();
        }
        if (this.o0 == null) {
            d.a.s0.h3.h0.e eVar = new d.a.s0.h3.h0.e();
            this.o0 = eVar;
            eVar.f61215a = getUniqueId();
        }
        d.a.r0.r.q.f fVar = new d.a.r0.r.q.f();
        fVar.f55932b = 5;
        fVar.f55938h = 8;
        fVar.f55937g = 2;
        if (y() != null) {
            fVar.f55936f = y().C0();
        }
        fVar.f55931a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f55939i = 0;
                k3 = TbPageExtraHelper.k(getContext());
                if (k3 != null) {
                    agreeData.objSource = k3.a();
                }
                this.m0.c(agreeData, i3, getUniqueId(), false);
                this.m0.d(agreeData, this.o0);
                pbModel = this.t0;
                if (pbModel != null || pbModel.D0() == null) {
                }
                this.m0.b(z(), fVar, agreeData, this.t0.D0().N());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f55939i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f55939i = 1;
        }
        i3 = 0;
        k3 = TbPageExtraHelper.k(getContext());
        if (k3 != null) {
        }
        this.m0.c(agreeData, i3, getUniqueId(), false);
        this.m0.d(agreeData, this.o0);
        pbModel = this.t0;
        if (pbModel != null) {
        }
    }

    public final void d5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.T = new LikeModel(getPageContext());
        }
    }

    public final void d6(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048650, this, z2, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            d.a.r0.r.s.j jVar = this.F0;
            if (jVar != null && jVar.isShowing()) {
                this.F0.dismiss();
                this.F0 = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                d.a.r0.r.s.l lVar = new d.a.r0.r.s.l(getContext());
                lVar.n(new r(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new d.a.r0.r.s.h(0, getResources().getString(R.string.delete), lVar));
                }
                if (z2) {
                    arrayList.add(new d.a.r0.r.s.h(1, getResources().getString(R.string.un_mute), lVar));
                } else {
                    arrayList.add(new d.a.r0.r.s.h(1, getResources().getString(R.string.mute), lVar));
                }
                lVar.k(arrayList);
                d.a.r0.r.s.j jVar2 = new d.a.r0.r.s.j(getPageContext(), lVar);
                this.F0 = jVar2;
                jVar2.l();
            }
        }
    }

    public final void e4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            if (this.t0.j0() || this.t0.m0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.t0.T0());
                this.f19180e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.t0.T0()));
            if (o6()) {
                this.f19180e.finish();
            }
        }
    }

    public final void e5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && this.q == null) {
            this.q = new d.a.r0.r.s.b(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(R.string.call_phone), getPageContext().getString(R.string.sms_phone), getPageContext().getString(R.string.search_in_baidu)};
            d.a.r0.r.s.b bVar = this.q;
            bVar.j(strArr, new a0(this));
            bVar.g(b.C1266b.f56148a);
            bVar.h(17);
            bVar.c(getPageContext());
        }
    }

    public final void e6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            showLoadingView(this.A0.V0(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds400));
            View i3 = getLoadingView().i();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) i3.getLayoutParams();
            layoutParams.addRule(3, this.A0.U0().getId());
            i3.setLayoutParams(layoutParams);
        }
    }

    public final boolean f4(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        List<d.a.r0.r.s.h> b3;
        d.a.r0.r.s.h hVar;
        d.a.r0.r.s.h hVar2;
        d.a.r0.r.s.h hVar3;
        d.a.r0.r.s.h hVar4;
        d.a.c.k.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, view)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                d.a.s0.h2.k.e.t0 t0Var = this.A0;
                if (t0Var != null) {
                    if (t0Var.r1()) {
                        return true;
                    }
                    this.A0.j0();
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e3) {
                    e3.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    if (i5(view)) {
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
                            this.A0.k3(this.q2, this.g1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                this.o2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.A() == 1 && i5(view)) {
                    this.A0.k3(this.q2, this.g1.t());
                    return true;
                }
                d.a.r0.h.a aVar2 = this.v0;
                if (aVar2 == null) {
                    return true;
                }
                boolean z4 = aVar2.e() && this.o2.E() != null && this.o2.E().equals(this.t0.y0());
                boolean z5 = y().D0() != null && y().D0().e0();
                if (this.o2.A() == 1) {
                    if (!z5) {
                        this.A0.l3(this.p2, z4, false);
                    }
                    return true;
                }
                if (this.G0 == null) {
                    d.a.r0.r.s.l lVar = new d.a.r0.r.s.l(getContext());
                    this.G0 = lVar;
                    lVar.n(this.U1);
                }
                ArrayList arrayList = new ArrayList();
                if (view == null || sparseArray == null) {
                    return true;
                }
                boolean z6 = i5(view) && !z5;
                boolean z7 = (!i5(view) || (aVar = this.g1) == null || aVar.t()) ? false : true;
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
                    arrayList.add(new d.a.r0.r.s.h(1, getString(R.string.save_to_emotion), this.G0));
                } else {
                    z2 = booleanValue5;
                    z3 = booleanValue6;
                }
                if (z7) {
                    arrayList.add(new d.a.r0.r.s.h(2, getString(R.string.save_to_local), this.G0));
                }
                if (!z6 && !z7) {
                    d.a.r0.r.s.h hVar5 = new d.a.r0.r.s.h(3, getString(R.string.copy), this.G0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, this.o2);
                    hVar5.f56178d.setTag(sparseArray3);
                    arrayList.add(hVar5);
                }
                if (!booleanValue && !z5) {
                    if (z4) {
                        hVar4 = new d.a.r0.r.s.h(4, getString(R.string.remove_mark), this.G0);
                    } else {
                        hVar4 = new d.a.r0.r.s.h(4, getString(R.string.mark), this.G0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, this.o2);
                    sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                    hVar4.f56178d.setTag(sparseArray4);
                    arrayList.add(hVar4);
                }
                if (this.mIsLogin && !this.p0) {
                    if (!d.a.s0.h2.k.e.f1.a.h(this.t0) && !booleanValue4 && booleanValue3) {
                        d.a.r0.r.s.h hVar6 = new d.a.r0.r.s.h(5, getString(R.string.mute_option), this.G0);
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
                        hVar6.f56178d.setTag(sparseArray5);
                        arrayList.add(hVar6);
                    } else {
                        if ((l5(booleanValue2) && TbadkCoreApplication.isLogin()) && !z5) {
                            d.a.r0.r.s.h hVar7 = new d.a.r0.r.s.h(5, getString(R.string.report_text), this.G0);
                            hVar7.f56178d.setTag(str);
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
                        if (!d.a.s0.h2.k.e.f1.a.h(this.t0) && z2) {
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
                            hVar2 = new d.a.r0.r.s.h(6, getString(R.string.delete), this.G0);
                            hVar2.f56178d.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                            hVar2 = null;
                        }
                        hVar = new d.a.r0.r.s.h(7, getString(R.string.bar_manager), this.G0);
                        hVar.f56178d.setTag(sparseArray6);
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
                        if (this.t0.D0().U() == 1002 && !booleanValue2) {
                            hVar3 = new d.a.r0.r.s.h(6, getString(R.string.report_text), this.G0);
                        } else {
                            hVar3 = new d.a.r0.r.s.h(6, getString(R.string.delete), this.G0);
                        }
                        hVar3.f56178d.setTag(sparseArray7);
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
                    d.a.s0.h2.k.e.f1.a.a(arrayList, this.G0, this.o2, this.t0);
                }
                if (d.a.r0.b.d.z()) {
                    b3 = d.a.s0.h2.k.e.f1.a.c(arrayList, this.o2.q(), sparseArray, this.G0);
                } else {
                    b3 = d.a.s0.h2.k.e.f1.a.b(arrayList, this.o2.q(), sparseArray, this.G0);
                }
                d.a.s0.h2.k.e.f1.a.k(b3, this.f19181f);
                d.a.s0.h2.k.e.f1.a.e(b3);
                this.G0.o(d.a.s0.h2.k.e.f1.a.f(this.o2));
                if (d.a.r0.b.d.z()) {
                    this.G0.l(b3, false);
                } else {
                    this.G0.l(b3, true);
                }
                d.a.r0.r.s.j jVar = new d.a.r0.r.s.j(getPageContext(), this.G0);
                this.F0 = jVar;
                jVar.l();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.t0.f19381e).param("fid", this.t0.getForumId()).param("uid", this.t0.D0().N().H().getUserId()).param("post_id", this.t0.w()).param("obj_source", booleanValue ? 2 : 1));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean f5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel != null) {
                return pbModel.j0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f6(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, postWriteCallBackData) == null) {
            if (PbReplySwitch.getInOn() && y() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                y().O(postWriteCallBackData.getPostId());
                int p02 = this.A0.p0();
                this.k1 = p02;
                this.t0.L1(p02, this.A0.w0());
            }
            this.A0.a0();
            this.E0.c();
            d.a.r0.w.w.e eVar = this.P0;
            if (eVar != null) {
                this.A0.q2(eVar.C());
            }
            this.A0.Z0();
            this.A0.Y2(true);
            this.t0.Z0();
        }
    }

    @Override // d.a.s0.h2.o.b
    public void finish() {
        d.a.s0.h2.k.e.t0 t0Var;
        CardHListViewData r3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            d.a.s0.h2.k.e.t0 t0Var2 = this.A0;
            if (t0Var2 != null) {
                t0Var2.a0();
            }
            PbModel pbModel = this.t0;
            if (pbModel != null && pbModel.D0() != null && !this.t0.D0().e0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.t0.D0().N().c0();
                if (this.t0.isShareThread() && this.t0.D0().N().u1 != null) {
                    historyMessage.threadName = this.t0.D0().N().u1.f12231b;
                } else {
                    historyMessage.threadName = this.t0.D0().N().getTitle();
                }
                if (this.t0.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.t0.D0().m().getName();
                }
                ArrayList<PostData> E = this.t0.D0().E();
                d.a.s0.h2.k.e.t0 t0Var3 = this.A0;
                int s02 = t0Var3 != null ? t0Var3.s0() : 0;
                if (E != null && s02 >= 0 && s02 < E.size()) {
                    historyMessage.postID = E.get(s02).E();
                }
                historyMessage.isHostOnly = this.t0.i0();
                historyMessage.isSquence = this.t0.R0();
                historyMessage.isShareThread = this.t0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            d.a.r0.w.w.e eVar = this.P0;
            if (eVar != null) {
                eVar.I();
            }
            if (this.n && P4() != null) {
                P4().f0();
            }
            PbModel pbModel2 = this.t0;
            if (pbModel2 != null && (pbModel2.j0() || this.t0.m0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.t0.T0());
                if (this.B0) {
                    if (this.D0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.t0.s0());
                    }
                    if (this.C0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.t0.o0());
                    }
                }
                if (this.t0.D0() != null && System.currentTimeMillis() - this.t >= 40000 && (r3 = this.t0.D0().r()) != null && !ListUtils.isEmpty(r3.getDataList())) {
                    intent.putExtra("guess_like_data", r3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.l1);
                }
                this.f19180e.setResult(-1, intent);
            }
            if (o6()) {
                if (this.t0 != null && (t0Var = this.A0) != null && t0Var.B0() != null) {
                    d.a.s0.h2.h.e D0 = this.t0.D0();
                    if (D0 != null) {
                        if (D0.T() != null) {
                            D0.T().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!D0.i0() && !this.K && D0.f60144h == null) {
                            d.a.s0.h2.k.e.m0.b().n(this.t0.E0(), this.A0.B0().onSaveInstanceState(), this.t0.R0(), this.t0.i0(), this.A0.I0() != null && this.A0.I0().getVisibility() == 0);
                            if (this.k1 >= 0 || this.t0.V0() != null) {
                                d.a.s0.h2.k.e.m0.b().q(this.t0.V0());
                                d.a.s0.h2.k.e.m0.b().r(this.t0.W0());
                                d.a.s0.h2.k.e.m0.b().o(this.t0.w0());
                            }
                        }
                    }
                } else {
                    d.a.s0.h2.k.e.m0.b().m();
                }
                n6();
            }
        }
    }

    public void g4(ForumManageModel.b bVar, d.a.s0.h2.k.e.t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, bVar, t0Var) == null) {
            List<PostData> list = this.t0.D0().S().f60195a;
            int size = list.size();
            boolean z2 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).M().size()) {
                        break;
                    } else if (bVar.f21139g.equals(list.get(i3).M().get(i4).E())) {
                        list.get(i3).M().remove(i4);
                        list.get(i3).l();
                        z2 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).n(bVar.f21139g);
            }
            if (z2) {
                t0Var.n1(this.t0.D0());
            }
        }
    }

    public final boolean g5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            PostData c3 = d.a.s0.h2.h.f.c(this.t0.D0(), this.t0.R0(), this.t0.N0());
            return (c3 == null || c3.t() == null || c3.t().getGodUserData() == null || c3.t().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void g6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i3) == null) {
            d.a.s0.h2.k.e.f1.b.m(this, s4(), i3);
        }
    }

    public d.a.s0.h2.k.e.c1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.f19180e.getEventController() : (d.a.s0.h2.k.e.c1.a) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if (this.N == null) {
                this.N = new d.a.c.e.k.b<>(new r1(this), 20, 0);
            }
            return this.N;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.G == null) {
                this.G = new d.a.c.e.k.b<>(new q1(this), 8, 0);
            }
            return this.G;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            d.a.c.e.k.b<RelativeLayout> bVar = new d.a.c.e.k.b<>(new t1(this), 10, 0);
            this.J = bVar;
            return bVar;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            d.a.s0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var == null) {
                return 0;
            }
            return t0Var.P0();
        }
        return invokeV.intValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (this.E == null) {
                this.E = TbRichTextView.y(getPageContext().getPageActivity(), 8);
            }
            return this.E;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.I == null) {
                this.I = new d.a.c.e.k.b<>(new d2(this), 15, 0);
            }
            return this.I;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.a.c.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            if (this.F == null) {
                this.F = UserIconBox.c(getPageContext().getPageActivity(), 8);
            }
            return this.F;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.o : (VoiceManager) invokeV.objValue;
    }

    @Override // d.a.r0.b1.m.h
    public d.a.c.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (this.H == null) {
                this.H = new d.a.c.e.k.b<>(new s1(this), 8, 0);
            }
            return this.H;
        }
        return (d.a.c.e.k.b) invokeV.objValue;
    }

    public final void h4(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048673, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d.a.s0.h3.h0.o y2 = this.t0.D0().y();
        if (y2 != null && str.equals(y2.D0())) {
            if (y2.getAdvertAppInfo() != null) {
                y2.getAdvertAppInfo().T3 = null;
            }
            this.t0.D0().b();
        }
        d.a.s0.h3.h0.o Z = this.t0.Z();
        if (Z == null || !str.equals(Z.D0())) {
            return;
        }
        this.t0.N();
    }

    public boolean h5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel != null) {
                return pbModel.i0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h6(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, str) == null) {
            if (str == null) {
                str = "";
            }
            d.a.c.a.f fVar = this.b1;
            if (fVar == null) {
                return;
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(fVar.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new l2(this));
            aVar.create(this.b1).show();
        }
    }

    public void i4(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048676, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(d.a.s0.h2.k.e.t0.Y1)).intValue();
            if (intValue == d.a.s0.h2.k.e.t0.Z1) {
                if (this.w0.O()) {
                    return;
                }
                this.A0.w3();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                if (jSONArray != null) {
                    this.w0.Q(StringHelper.JsonArrayToString(jSONArray));
                }
                this.w0.R(this.t0.D0().m().getId(), this.t0.D0().m().getName(), this.t0.D0().N().c0(), str, intValue3, intValue2, booleanValue, this.t0.D0().N().J());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == d.a.s0.h2.k.e.t0.a2 || intValue == d.a.s0.h2.k.e.t0.c2) {
                if (this.t0.b0() != null) {
                    this.t0.b0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == d.a.s0.h2.k.e.t0.a2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public boolean i5(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public final void i6(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048678, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.A0.f3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.b1.getPageActivity());
            if (d.a.c.e.p.k.isEmpty(str)) {
                aVar.setMessage(this.b1.getResources().getString(R.string.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new m2(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new n2(this));
            aVar.create(this.b1).show();
        }
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.i1();
        }
        return invokeV.booleanValue;
    }

    public void j4(d.a.r0.r.s.a aVar, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048680, this, aVar, jSONArray) == null) {
            aVar.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (aVar.getYesButtonTag() instanceof SparseArray) {
                    i4((SparseArray) aVar.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean j5(int i3) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048681, this, i3)) == null) {
            if (i3 == 1) {
                return true;
            }
            if (this.t0.D0().T() != null && (forumToolAuth = this.t0.D0().T().getForumToolAuth()) != null) {
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

    public final void j6() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048682, this) == null) || (pbModel = this.t0) == null || d.a.c.e.p.k.isEmpty(pbModel.T0())) {
            return;
        }
        d.a.r0.a.d.y().P(d.a.r0.a.c.W, d.a.c.e.m.b.f(this.t0.T0(), 0L));
    }

    public void k4(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048683, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(d.a.s0.h2.k.e.t0.Y1, Integer.valueOf(d.a.s0.h2.k.e.t0.Z1));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                i4(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final boolean k5(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048684, this, i3)) == null) ? i3 == 2 || i3 == 1 : invokeI.booleanValue;
    }

    public final void k6(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048685, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(R.id.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            l6(postData, false);
        }
    }

    public void l4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            TiebaStatic.log("c12181");
            d.a.s0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var == null || this.t0 == null) {
                return;
            }
            if ((t0Var != null && !t0Var.p1()) || this.t0.D0() == null || this.t0.D0().R() == null) {
                return;
            }
            d.a.s0.h2.k.e.t0 t0Var2 = this.A0;
            if (t0Var2 == null || t0Var2.r0() == null || !this.A0.r0().c()) {
                d.a.s0.h2.h.p R = this.t0.D0().R();
                if (checkUpIsLogin()) {
                    if ((!R.e() || R.b() != 2) && this.A0.l0() != null && this.A0.l0().z() != null) {
                        this.A0.l0().z().i0(this.t0.T0());
                    }
                    if (System.currentTimeMillis() - this.B > 2000) {
                        new PbFullScreenFloatingHuajiAninationView(getActivity()).f(false);
                        this.B = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public final boolean l5(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048687, this, z2)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel != null && pbModel.D0() != null) {
                return ((this.t0.D0().U() != 0) || this.t0.D0().N() == null || this.t0.D0().N().H() == null || TextUtils.equals(this.t0.D0().N().H().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void l6(PostData postData, boolean z2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048688, this, postData, z2) == null) || postData == null || (pbModel = this.t0) == null || pbModel.D0() == null || postData.A() == 1) {
            return;
        }
        String T0 = this.t0.T0();
        String E = postData.E();
        int U = this.t0.D0() != null ? this.t0.D0().U() : 0;
        PbActivity.e C5 = C5(E);
        if (C5 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(T0, E, "pb", true, null, false, null, U, postData.O(), this.t0.D0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null).addBigImageData(C5.f19136a, C5.f19137b, C5.f19142g, C5.j);
        addBigImageData.setKeyPageStartFrom(this.t0.C0());
        addBigImageData.setFromFrsForumId(this.t0.getFromForumId());
        addBigImageData.setKeyFromForumId(this.t0.getForumId());
        addBigImageData.setBjhData(this.t0.Y());
        addBigImageData.setIsOpenEditor(z2);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    @Override // d.a.s0.h2.p.e.b
    public void m0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z2) == null) {
            this.J0 = z2;
        }
    }

    public void m4() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048690, this) == null) || this.A0 == null || (pbModel = this.t0) == null) {
            return;
        }
        if ((pbModel.D0() == null && this.t0.D0().R() == null) || !checkUpIsLogin() || this.A0.l0() == null || this.A0.l0().z() == null) {
            return;
        }
        this.A0.l0().z().i0(this.t0.T0());
    }

    public final void m5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void m6() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.stopPlay();
            }
            PbActivity pbActivity = this.f19180e;
            if (pbActivity != null) {
                pbActivity.stopVoice();
            }
        }
    }

    public final void n4(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048693, this, str) == null) || (pbModel = this.t0) == null || pbModel.D0() == null || this.t0.D0().N() == null || !this.t0.D0().N().p2()) {
            return;
        }
        d.a.r0.r.q.b2 N = this.t0.D0().N();
        int i3 = 0;
        if (N.E1()) {
            i3 = 1;
        } else if (N.H1()) {
            i3 = 2;
        } else if (N.F1()) {
            i3 = 3;
        } else if (N.G1()) {
            i3 = 4;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_source", 4);
        statisticItem.param("obj_type", i3);
        TiebaStatic.log(statisticItem);
    }

    public final void n5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048694, this) == null) || this.C2 == null) {
            return;
        }
        if (this.A2 == -1) {
            showToast(R.string.pb_manga_not_next_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.C2.a(), this.A2, 0)));
            this.f19180e.finish();
        }
    }

    public final void n6() {
        PbActivity pbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048695, this) == null) || (pbActivity = this.f19180e) == null) {
            return;
        }
        pbActivity.superCloseActivity();
    }

    public final void o4(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048696, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f21134b) ? bVar.f21134b : getString(R.string.delete_fail);
            int i3 = 0;
            if (bVar.f21135c == 1211066) {
                hideProgressBar();
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(R.string.dialog_known, new g1(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else {
                this.A0.i0(0, bVar.f21133a, bVar.f21134b, z2);
            }
            if (bVar.f21133a) {
                int i4 = bVar.f21136d;
                if (i4 == 1) {
                    ArrayList<PostData> E = this.t0.D0().E();
                    int size = E.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.f21139g.equals(E.get(i3).E())) {
                            E.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.t0.D0().N().R3(this.t0.D0().N().P0() - 1);
                    this.A0.n1(this.t0.D0());
                } else if (i4 == 0) {
                    e4();
                } else if (i4 == 2) {
                    ArrayList<PostData> E3 = this.t0.D0().E();
                    int size2 = E3.size();
                    boolean z3 = false;
                    for (int i5 = 0; i5 < size2 && !z3; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= E3.get(i5).M().size()) {
                                break;
                            } else if (bVar.f21139g.equals(E3.get(i5).M().get(i6).E())) {
                                E3.get(i5).M().remove(i6);
                                E3.get(i5).l();
                                z3 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        E3.get(i5).n(bVar.f21139g);
                    }
                    if (z3) {
                        this.A0.n1(this.t0.D0());
                    }
                    g4(bVar, this.A0);
                }
            }
        }
    }

    public void o5(String str) {
        d.a.s0.h2.k.e.t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048697, this, str) == null) || this.t0 == null || StringUtils.isNull(str) || (t0Var = this.A0) == null) {
            return;
        }
        t0Var.v2(true);
        this.t0.n1(str);
        this.K = true;
        this.A0.a0();
        this.A0.X0();
    }

    public final boolean o6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.D0() == null || !this.t0.D0().e0()) {
                if (this.t0.p0()) {
                    MarkData c02 = this.t0.c0();
                    if (c02 != null && this.t0.n0()) {
                        MarkData W = this.t0.W(this.A0.s0());
                        if (W == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", c02);
                            this.f19180e.setResult(-1, intent);
                            return true;
                        } else if (W.getPostId() != null && !W.getPostId().equals(c02.getPostId())) {
                            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(getPageContext().getPageActivity());
                            aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                            aVar.setPositiveButton(R.string.confirm, new m1(this, W, c02, aVar));
                            aVar.setNegativeButton(R.string.cancel, new o1(this, c02, aVar));
                            aVar.setOnCalcelListener(new p1(this, c02, aVar));
                            aVar.create(getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", c02);
                            this.f19180e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.t0.D0() != null && this.t0.D0().E() != null && this.t0.D0().E().size() > 0 && this.t0.n0()) {
                    this.f19180e.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
            this.b2.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).d(), "", 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        EmotionImageData emotionImageData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048700, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.P0.H(i3, i4, intent);
            d.a.s0.h2.k.e.b1.f.a aVar = this.S;
            if (aVar != null) {
                aVar.i(i3, i4, intent);
            }
            if (P4().K0() != null) {
                P4().K0().g(i3, i4, intent);
            }
            if (i3 == 25035) {
                V4(i4, intent);
            }
            if (i4 == -1) {
                if (i3 == 11009) {
                    t5();
                } else if (i3 == 13008) {
                    d.a.s0.h2.k.e.m0.b().m();
                    this.s0.postDelayed(new k1(this), 1000L);
                } else if (i3 == 13011) {
                    d.a.s0.v2.a.g().m(getPageContext());
                } else if (i3 == 23003) {
                    if (intent == null || this.t0 == null) {
                        return;
                    }
                    W5(intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                } else if (i3 == 23007) {
                    Y4(intent);
                } else if (i3 == 25012) {
                    intent.getLongExtra(VideoListActivityConfig.KEY_FORUM_ID, 0L);
                    intent.getStringExtra("KEY_FORUM_NAME");
                } else if (i3 == 25016 || i3 == 25023) {
                    Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                    if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                        return;
                    }
                    this.V0 = emotionImageData;
                    if (c4(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        K5(emotionImageData);
                    }
                } else if (i3 == 25033) {
                    View view = this.U;
                    if (view != null) {
                        this.A0.c3(view);
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
                        d.a.s0.v2.a.g().m(getPageContext());
                        q6();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.z0;
                        if (shareSuccessReplyToServerModel == null || shareItem == null || (str = shareItem.t) == null) {
                            return;
                        }
                        shareSuccessReplyToServerModel.w(str, intExtra, new l1(this));
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
                            d.a.s0.h2.k.e.t0 t0Var = this.A0;
                            if (t0Var == null || t0Var.m0() == null) {
                                return;
                            }
                            this.A0.m0().performClick();
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
                    this.A0.O2(false);
                    if (this.t0.D0() == null || this.t0.D0().N() == null || this.t0.D0().N().J0() == null) {
                        return;
                    }
                    this.t0.D0().N().J0().setStatus(2);
                }
            }
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048701, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.A = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, context) == null) {
            super.onAttach(context);
            this.f19180e = (PbActivity) context;
        }
    }

    public void onBackPressed() {
        List<r2> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048703, this) == null) || (list = this.m1) == null || list.isEmpty()) {
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
        if (!(interceptable == null || interceptable.invokeI(1048704, this, i3) == null) || this.Z == i3) {
            return;
        }
        super.onChangeSkinType(i3);
        this.A0.G1(i3);
        d.a.r0.w.w.e eVar = this.P0;
        if (eVar != null && eVar.a() != null) {
            this.P0.a().w(i3);
        }
        if (this.A0.a() != null) {
            this.A0.a().c(getPageContext(), i3);
        }
        this.E0.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), R.color.CAM_X0201));
        this.Z = i3;
        m6();
    }

    @Override // d.a.r0.r.s.a.e
    public void onClick(d.a.r0.r.s.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, aVar) == null) {
            j4(aVar, null);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, configuration) == null) {
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
            d.a.s0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var != null) {
                t0Var.H1(configuration);
            }
            d.a.r0.r.s.j jVar = this.F0;
            if (jVar != null) {
                jVar.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        d.a.s0.h2.k.e.t0 t0Var;
        d.a.s0.h2.k.e.t0 t0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            this.t = System.currentTimeMillis();
            this.b1 = getPageContext();
            Intent intent = this.f19180e.getIntent();
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
                this.z2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.A2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.B2 = intent.getStringExtra("key_manga_title");
                this.K0 = intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.L0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.M0 = intent.getBooleanExtra(PbActivityConfig.KEY_JUMP_TO_TOP_AREA, false);
                if (D4()) {
                    this.f19180e.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.R = stringExtra;
                this.R = d.a.c.e.p.k.isEmpty(stringExtra) ? "" : this.R;
                this.l1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                d.a.r0.r.q.l1 l1Var = new d.a.r0.r.q.l1();
                this.k0 = l1Var;
                l1Var.a(intent);
                int intExtra = intent.getIntExtra(PbActivityConfig.KEY_BJH_FROM, 0);
                this.n1 = intExtra;
                if (intExtra == 0) {
                    this.n1 = intent.getIntExtra("key_start_from", 0);
                }
                this.o1 = intent.getStringExtra(PbActivityConfig.KEY_LAST_TID);
            } else {
                this.r = System.currentTimeMillis();
            }
            this.v = this.t - this.r;
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            this.p = 0;
            p5(bundle);
            if (this.t0.D0() != null) {
                this.t0.D0().F0(this.R);
            }
            d5();
            if (intent != null && (t0Var2 = this.A0) != null) {
                t0Var2.f60669b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.e1 == null) {
                        this.e1 = new u(this, intent);
                    }
                    d.a.c.e.m.e.a().postDelayed(this.e1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_PRE_LOAD);
                if (!TextUtils.isEmpty(stringExtra2) && this.t0.D0() != null) {
                    this.t0.S1(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.o = voiceManager;
            voiceManager.onCreate(getPageContext());
            c5(bundle);
            d.a.r0.w.w.g gVar = new d.a.r0.w.w.g();
            this.O0 = gVar;
            Q5(gVar);
            d.a.r0.w.w.e eVar = (d.a.r0.w.w.e) this.O0.a(getActivity());
            this.P0 = eVar;
            eVar.e0(this.f19180e.getPageContext());
            this.P0.n0(this.Y1);
            this.P0.o0(this.W0);
            this.P0.g0(1);
            this.P0.F(this.f19180e.getPageContext(), bundle);
            this.P0.a().b(new d.a.r0.w.k(getActivity()));
            this.P0.a().C(true);
            T5(true);
            this.P0.O(this.t0.h0(), this.t0.T0(), this.t0.e0());
            registerListener(this.v1);
            if (!this.t0.r0()) {
                this.P0.s(this.t0.T0());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.P0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.t0.b1()) {
                this.P0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                d.a.s0.h2.k.e.t0 t0Var3 = this.A0;
                if (t0Var3 != null) {
                    this.P0.k0(t0Var3.N0());
                }
            }
            registerListener(this.u1);
            registerListener(this.w1);
            registerListener(this.x1);
            registerListener(this.t1);
            registerListener(this.R1);
            registerListener(this.d2);
            registerListener(this.s1);
            d.a.s0.h3.h0.f fVar = new d.a.s0.h3.h0.f("pb", d.a.s0.h3.h0.f.f61218d);
            this.N0 = fVar;
            fVar.d();
            registerListener(this.B1);
            registerListener(this.K1);
            this.t0.u1();
            registerListener(this.c2);
            registerListener(this.S1);
            registerListener(this.X1);
            registerListener(this.F1);
            d.a.s0.h2.k.e.t0 t0Var4 = this.A0;
            if (t0Var4 != null && t0Var4.U0() != null && this.A0.S0() != null) {
                d.a.s0.h2.k.e.c1.b bVar = new d.a.s0.h2.k.e.c1.b(getActivity(), this.A0.U0(), this.A0.S0(), this.A0.I0());
                this.f19184i = bVar;
                bVar.t(this.J1);
            }
            if (this.f19182g && (t0Var = this.A0) != null && t0Var.S0() != null) {
                this.A0.S0().setVisibility(8);
            }
            d.a.r0.r.f0.c cVar = new d.a.r0.r.f0.c();
            this.c1 = cVar;
            cVar.f55627a = 1000L;
            registerListener(this.Q1);
            registerListener(this.O1);
            registerListener(this.P1);
            registerListener(this.D1);
            registerListener(this.z1);
            this.C1.setSelfListener(true);
            this.C1.setTag(this.f19180e.getUniqueId());
            this.C1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.C1);
            registerResponsedEventListener(TipEvent.class, this.L1);
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
            this.t0.a0().A(this.M1);
            this.E0 = new d.a.s0.h2.k.e.v0();
            if (this.P0.v() != null) {
                this.E0.m(this.P0.v().i());
            }
            this.P0.d0(this.X0);
            this.z0 = new ShareSuccessReplyToServerModel();
            S3(this.q1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.S0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new w(this));
            d.a.s0.h2.k.f.a aVar = new d.a.s0.h2.k.f.a(getContext());
            this.u0 = aVar;
            aVar.a(getUniqueId());
            d.a.s0.g3.c.g().i(getUniqueId());
            d.a.r0.r.o.a.b().l("3", "");
            this.p1 = new d.a.s0.z.a(getPageContext());
            this.q0 = new d.a.s0.h2.k.e.e1.a(this, getUniqueId(), this.A0, this.t0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && d.a.c.e.p.j.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2004611));
            }
            this.u = System.currentTimeMillis() - this.t;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048708, this, layoutInflater, viewGroup, bundle)) == null) {
            this.A0 = new d.a.s0.h2.k.e.t0(this, this.W1, this.N1);
            d.a.s0.i0.b bVar = new d.a.s0.i0.b(getActivity());
            this.f19183h = bVar;
            bVar.i(E2);
            this.f19183h.d(this.x2);
            this.A0.F2(this.f2);
            this.A0.E2(this.k2);
            this.A0.y2(this.i2);
            this.A0.w2(d.a.r0.r.k.c().g());
            this.A0.C2(this.m2);
            this.A0.I2(this.s2);
            this.A0.G2(this.t2);
            this.A0.D2(this.v2);
            this.A0.B2(this.h2);
            this.A0.A3(this.mIsLogin);
            if (this.f19180e.getIntent() != null) {
                this.A0.u2(this.f19180e.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.A0.J0().setFromForumId(this.t0.getFromForumId());
            this.A0.m2(this.P0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.P0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.P0.k0(this.A0.N0());
            }
            this.A0.p2(new y(this));
            this.A0.t2(this.t0.m0());
            this.A0.H2(this.t0.C0());
            this.q0.f(this.A0, this.t0);
            return this.A0.V0();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        d.a.s0.h2.k.e.g1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048709, this) == null) {
            d.a.s0.g3.c.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.t0.D0().n());
                statisticItem.param("tid", this.t0.T0());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.x && this.A0 != null) {
                this.x = true;
                M5(false, null);
            }
            PbModel pbModel = this.t0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.t0.destory();
                if (this.t0.z0() != null) {
                    this.t0.z0().d();
                }
            }
            d.a.r0.w.w.e eVar = this.P0;
            if (eVar != null) {
                eVar.I();
            }
            ForumManageModel forumManageModel = this.w0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.T;
            if (likeModel != null) {
                likeModel.I();
            }
            d.a.s0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var != null) {
                t0Var.I1();
                d.a.s0.h2.k.e.g1.c cVar2 = this.A0.f60675h;
                if (cVar2 != null) {
                    cVar2.p();
                }
            }
            d.a.r0.m0.b bVar = this.y;
            if (bVar != null) {
                bVar.c();
            }
            d.a.s0.h2.k.e.c1.b bVar2 = this.f19184i;
            if (bVar2 != null) {
                bVar2.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            d.a.s0.h2.k.e.t0 t0Var2 = this.A0;
            if (t0Var2 != null) {
                t0Var2.a0();
            }
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.Q1);
            MessageManager.getInstance().unRegisterListener(this.d1);
            MessageManager.getInstance().unRegisterListener(this.R1);
            MessageManager.getInstance().unRegisterListener(this.S1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.F1);
            this.b1 = null;
            this.c1 = null;
            d.a.s0.w2.g0.a.e().g();
            if (this.e1 != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.e1);
            }
            d.a.s0.h2.k.e.b1.f.a aVar = this.S;
            if (aVar != null) {
                aVar.f();
            }
            d.a.s0.h2.k.e.t0 t0Var3 = this.A0;
            if (t0Var3 != null && (cVar = t0Var3.f60675h) != null) {
                cVar.j();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.z0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            d.a.s0.h2.k.e.v0 v0Var = this.E0;
            if (v0Var != null) {
                v0Var.j();
            }
            PbModel pbModel2 = this.t0;
            if (pbModel2 != null && pbModel2.T() != null) {
                this.t0.T().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.S0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            d.a.s0.h2.k.e.t0 t0Var4 = this.A0;
            if (t0Var4 != null) {
                t0Var4.x3();
            }
            d.a.s0.h2.k.e.e1.a aVar2 = this.q0;
            if (aVar2 != null) {
                aVar2.e();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            super.onDestroyView();
            MessageManager.getInstance().unRegisterListener(this.l0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public d.a.c.k.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (d.a.c.k.e.q) invokeV.objValue;
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        d.a.s0.h2.k.e.t0 t0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048712, this, i3, keyEvent)) == null) ? (keyEvent == null || (t0Var = this.A0) == null || !t0Var.K1(i3)) ? false : true : invokeIL.booleanValue;
    }

    @Override // d.a.r0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048713, this, context, str) == null) {
            this.A = true;
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048714, this, context, str, z2) == null) {
            if (d.a.s0.h2.k.e.y0.c(str) && (pbModel = this.t0) != null && pbModel.T0() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.t0.T0()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    d.a.r0.t.m mVar = new d.a.r0.t.m();
                    mVar.f56722a = str;
                    mVar.f56723b = 3;
                    mVar.f56724c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, mVar));
                }
            } else {
                d.a.s0.h2.k.e.y0.a().e(getPageContext(), str);
            }
            this.A = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            H5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
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
            d.a.s0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var != null) {
                t0Var.N1();
            }
            if (!this.t0.r0()) {
                this.P0.U(this.t0.T0());
            }
            PbModel pbModel = this.t0;
            if (pbModel != null) {
                pbModel.t1();
            }
            d.a.r0.a.d.y().E();
            MessageManager.getInstance().unRegisterListener(this.y1);
            L5();
            MessageManager.getInstance().unRegisterListener(this.O1);
            MessageManager.getInstance().unRegisterListener(this.P1);
            MessageManager.getInstance().unRegisterListener(this.Q1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048717, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.H0 = str;
        if (this.q == null) {
            e5();
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            this.k = false;
            super.onResume();
            if (this.Q) {
                this.Q = false;
                U4();
            }
            if (g5()) {
                this.z = System.currentTimeMillis();
            } else {
                this.z = -1L;
            }
            d.a.s0.h2.k.e.t0 t0Var = this.A0;
            if (t0Var != null && t0Var.V0() != null) {
                if (!this.l) {
                    e6();
                } else {
                    hideLoadingView(this.A0.V0());
                }
                this.A0.O1();
            }
            if (this.p == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            d.a.s0.h2.k.e.t0 t0Var2 = this.A0;
            NoNetworkView a3 = t0Var2 != null ? t0Var2.a() : null;
            if (a3 != null && a3.getVisibility() == 0 && d.a.c.e.p.j.z()) {
                a3.e(false);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.y1);
            this.J0 = false;
            N5();
            registerListener(this.O1);
            registerListener(this.P1);
            registerListener(this.Q1);
            if (this.j1) {
                H5();
                this.j1 = false;
            }
            j6();
            ItemCardHelper.p(this.u2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.t0.I1(bundle);
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.P0.K(bundle);
        }
    }

    @Override // d.a.r0.b1.m.h
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
            VoiceManager voiceManager = this.o;
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
            if (this.z > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.z;
                StatisticItem statisticItem = new StatisticItem("c10804");
                TiebaStatic.log(statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis + ""));
                this.z = 0L;
            }
            if (P4().K0() != null) {
                P4().K0().i();
            }
            d.a.s0.h2.k.e.g1.c cVar = this.A0.f60675h;
            if (cVar != null && !cVar.l()) {
                this.A0.f60675h.p();
            }
            PbModel pbModel = this.t0;
            if (pbModel != null && pbModel.D0() != null && this.t0.D0().m() != null && this.t0.D0().N() != null) {
                d.a.r0.u.a.k().y(getPageContext().getPageActivity(), "pb", this.t0.D0().m().getId(), d.a.c.e.m.b.f(this.t0.D0().N().c0(), 0L));
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            d.a.s0.g3.c.g().h(getUniqueId(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048724, this, view, motionEvent)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z2) == null) {
            super.onUserChanged(z2);
            this.A0.A3(z2);
            d.a.r0.r.s.j jVar = this.F0;
            if (jVar != null) {
                jVar.dismiss();
            }
            if (z2 && this.J0) {
                this.A0.N2();
                this.t0.l1(true);
            }
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048726, this, context, str) == null) {
            d.a.s0.h2.k.e.y0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.A = true;
        }
    }

    @Override // d.a.r0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048727, this, context, str) == null) {
        }
    }

    public final void p4(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048728, this, i3, gVar) == null) || gVar == null) {
            return;
        }
        this.A0.i0(this.w0.getLoadDataMode(), gVar.f21154a, gVar.f21155b, false);
        if (gVar.f21154a) {
            this.B0 = true;
            if (i3 == 2 || i3 == 3) {
                this.C0 = true;
                this.D0 = false;
            } else if (i3 == 4 || i3 == 5) {
                this.C0 = false;
                this.D0 = true;
            }
            if (i3 == 2) {
                this.t0.D0().N().C3(1);
                this.t0.N1(1);
            } else if (i3 == 3) {
                this.t0.D0().N().C3(0);
                this.t0.N1(0);
            } else if (i3 == 4) {
                this.t0.D0().N().D3(1);
                this.t0.O1(1);
            } else if (i3 == 5) {
                this.t0.D0().N().D3(0);
                this.t0.O1(0);
            }
            this.A0.D3(this.t0.D0(), this.t0.R0());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f21155b)) {
            string = gVar.f21155b;
        } else {
            string = getString(R.string.operation_failed);
        }
        d.a.c.e.p.l.M(getPageContext().getPageActivity(), string);
    }

    public final void p5(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, bundle) == null) {
            PbModel pbModel = this.f19180e.getPbModel();
            this.t0 = pbModel;
            if (pbModel.b0() != null) {
                this.t0.b0().c(this.y2);
            }
            if (this.t0.z0() != null) {
                this.t0.z0().f(this.r1);
            }
            if (StringUtils.isNull(this.t0.T0())) {
                this.f19180e.finish();
            } else if (!"from_tieba_kuang".equals(this.O) || this.O == null) {
            } else {
                this.t0.R1(6);
            }
        }
    }

    public final void p6(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048730, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.t0.f19381e).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(d.a.s0.h2.k.e.f1.a.m(i3))));
        }
    }

    public final void q4(Rect rect) {
        d.a.s0.h2.k.e.t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048731, this, rect) == null) || rect == null || (t0Var = this.A0) == null || t0Var.U0() == null || rect.top > this.A0.U0().getHeight()) {
            return;
        }
        rect.top += this.A0.U0().getHeight() - rect.top;
    }

    public final void q5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048732, this) == null) || this.C2 == null) {
            return;
        }
        if (this.z2 == -1) {
            showToast(R.string.pb_manga_not_prev_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.C2.a(), this.z2, 0)));
            this.f19180e.finish();
        }
    }

    public final void q6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048733, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.B(this.t0.getForumId()) && this.t0.D0() != null && this.t0.D0().m() != null) {
            if (this.t0.D0().m().isLike() == 1) {
                this.t0.T().A(this.t0.getForumId(), this.t0.T0());
            }
        }
    }

    public AntiData r4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null || pbModel.D0() == null) {
                return null;
            }
            return this.t0.D0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public final void r5(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048735, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || Y3() || !b4()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.b0);
            this.c0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (P4().K0() != null && postData != null) {
            P4().K0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
        }
        if (this.t0.D0() != null && this.t0.D0().e0()) {
            d.a.c.e.m.e.a().postDelayed(new n0(this, str, str2), 0L);
            return;
        }
        if (this.U0 == null) {
            d.a.s0.u0.f2.a.c cVar = new d.a.s0.u0.f2.a.c(getPageContext());
            this.U0 = cVar;
            cVar.k(1);
            this.U0.j(new o0(this, str, str2));
        }
        PbModel pbModel = this.t0;
        if (pbModel == null || pbModel.D0() == null || this.t0.D0().m() == null) {
            return;
        }
        this.U0.h(this.t0.D0().m().getId(), d.a.c.e.m.b.f(this.t0.T0(), 0L));
    }

    public final void r6(d.a.r0.r.q.u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048736, this, uVar) == null) || uVar == null) {
            return;
        }
        this.C2 = uVar;
        this.f19182g = true;
        this.A0.g2();
        this.A0.z2(this.B2);
    }

    public final int s4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            if (this.t0.D0() == null || this.t0.D0().N() == null) {
                return -1;
            }
            return this.t0.D0().N().q();
        }
        return invokeV.intValue;
    }

    public final void s5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            d.a.s0.h2.h.e D0 = this.t0.D0();
            this.t0.X1(true);
            d.a.r0.h.a aVar = this.v0;
            if (aVar != null) {
                D0.w0(aVar.g());
            }
            this.A0.n1(D0);
        }
    }

    public final void s6(int i3) {
        PbModel pbModel;
        d.a.r0.r.q.b2 N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048739, this, i3) == null) || (pbModel = this.t0) == null || pbModel.D0() == null || (N = this.t0.D0().N()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData G0 = N.G0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (G0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i3);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    N.Q3(praiseData);
                } else {
                    N.G0().getUser().add(0, metaData);
                    N.G0().setNum(N.G0().getNum() + 1);
                    N.G0().setIsLike(i3);
                }
            }
            if (N.G0() != null) {
                if (N.G0().getNum() < 1) {
                    getResources().getString(R.string.zan);
                } else {
                    StringHelper.numFormatOver10000(N.G0().getNum());
                }
            }
        } else if (N.G0() != null) {
            N.G0().setIsLike(i3);
            N.G0().setNum(N.G0().getNum() - 1);
            ArrayList<MetaData> user = N.G0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        N.G0().getUser().remove(next);
                        break;
                    }
                }
            }
            if (N.G0().getNum() < 1) {
                getResources().getString(R.string.zan);
            } else {
                String str = N.G0().getNum() + "";
            }
        }
        if (this.t0.R0()) {
            this.A0.l0().V();
        } else {
            this.A0.F3(this.t0.D0());
        }
    }

    public final int t4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            if (P4() != null && P4().B0() != null) {
                BdTypeListView B0 = P4().B0();
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
        return invokeV.intValue;
    }

    public final void t5() {
        MarkData W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || this.v0 == null) {
            return;
        }
        if (this.t0.D0() != null && this.t0.D0().e0()) {
            W = this.t0.W(0);
        } else {
            W = this.t0.W(this.A0.A0());
        }
        if (W == null) {
            return;
        }
        if (W.isApp() && (W = this.t0.W(this.A0.A0() + 1)) == null) {
            return;
        }
        this.A0.M2();
        this.v0.i(W);
        if (!this.v0.e()) {
            this.v0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.v0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    public final TbRichText t6(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048742, this, str, i3)) == null) {
            PbModel pbModel = this.t0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.D0() == null || str == null || i3 < 0) {
                return null;
            }
            d.a.s0.h2.h.e D0 = this.t0.D0();
            if (D0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(D0.j());
                tbRichText = z4(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> E = D0.E();
                W3(D0, E);
                return z4(E, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public PostData u4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            d.a.s0.h2.k.e.t0 t0Var = this.A0;
            PbModel pbModel = this.t0;
            return t0Var.t0(pbModel.I, pbModel.R0());
        }
        return (PostData) invokeV.objValue;
    }

    public final void u5(View view) {
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
            v5(postData);
        }
    }

    @Override // d.a.s0.h2.o.b
    public VideoPbFragment v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            return null;
        }
        return (VideoPbFragment) invokeV.objValue;
    }

    public String v4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) ? this.O : (String) invokeV.objValue;
    }

    public void v5(PostData postData) {
        PostData u4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048747, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (postData.E() != null && postData.E().equals(this.t0.y0())) {
            z2 = true;
        }
        MarkData x02 = this.t0.x0(postData);
        if (this.t0.D0() != null && this.t0.D0().e0() && (u4 = u4()) != null) {
            x02 = this.t0.x0(u4);
        }
        if (x02 == null) {
            return;
        }
        this.A0.M2();
        d.a.r0.h.a aVar = this.v0;
        if (aVar != null) {
            aVar.i(x02);
            if (!z2) {
                this.v0.a();
            } else {
                this.v0.d();
            }
        }
    }

    public int w4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            if (P4() != null && P4().B0() != null) {
                BdTypeListView B0 = P4().B0();
                List<d.a.c.k.e.n> data = B0.getData();
                int headerViewsCount = B0.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d.a.c.k.e.n nVar = data.get(i3);
                        if ((nVar instanceof d.a.s0.h2.h.o) && ((d.a.s0.h2.h.o) nVar).f60175f == d.a.s0.h2.h.o.m) {
                            return i3 + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean w5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048749, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p3 = d.a.r0.r.d0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    d.a.r0.l.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p3 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String x4() {
        InterceptResult invokeV;
        d.a.s0.h2.h.e D0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null || (D0 = pbModel.D0()) == null) {
                return null;
            }
            return D0.S().f60197c;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.s0.h2.o.b
    public PbModel y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) ? this.t0 : (PbModel) invokeV.objValue;
    }

    public final String y4() {
        InterceptResult invokeV;
        ArrayList<PostData> E;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            PbModel pbModel = this.t0;
            if (pbModel == null || pbModel.D0() == null || this.t0.D0().E() == null || (count = ListUtils.getCount((E = this.t0.D0().E()))) == 0) {
                return "";
            }
            if (this.t0.O0()) {
                Iterator<PostData> it = E.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.E();
                    }
                }
            }
            int s02 = this.A0.s0();
            PostData postData = (PostData) ListUtils.getItem(E, s02);
            if (postData != null && postData.t() != null) {
                if (this.t0.j1(postData.t().getUserId())) {
                    return postData.E();
                }
                for (int i3 = s02 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(E, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (this.t0.j1(postData2.t().getUserId())) {
                        return postData2.E();
                    }
                }
                for (int i4 = s02 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(E, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (this.t0.j1(postData3.t().getUserId())) {
                        return postData3.E();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            if (!d.a.c.e.p.j.z()) {
                showToast(R.string.network_not_available);
                return;
            }
            this.A0.a0();
            if (this.m) {
                return;
            }
            m6();
            this.A0.M2();
            if (this.t0.LoadData()) {
                this.A0.p3();
            }
        }
    }

    @Override // d.a.s0.h2.o.b
    public PbActivity z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) ? this.f19180e : (PbActivity) invokeV.objValue;
    }

    public final TbRichText z4(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> y2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048755, this, arrayList, str, i3)) == null) {
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
                                    this.l2 = i6;
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

    public void z5() {
        PbModel pbModel;
        d.a.s0.h2.h.e D0;
        d.a.r0.r.q.b2 N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048756, this) == null) || (pbModel = this.t0) == null || pbModel.D0() == null || (N = (D0 = this.t0.D0()).N()) == null || N.H() == null) {
            return;
        }
        this.A0.Z0();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), N.H().getUserId());
        d.a.s0.h2.k.e.g0 g0Var = new d.a.s0.h2.k.e.g0();
        int U = this.t0.D0().U();
        if (U != 1 && U != 3) {
            g0Var.f60536g = false;
        } else {
            g0Var.f60536g = true;
            g0Var.q = N.m0() == 1;
        }
        if (j5(U)) {
            g0Var.f60537h = true;
            g0Var.p = N.l0() == 1;
        } else {
            g0Var.f60537h = false;
        }
        if (U == 1002 && !equals) {
            g0Var.r = true;
        }
        g0Var.f60534e = Y5(equals);
        g0Var.f60538i = a6();
        g0Var.f60535f = Z5(equals);
        g0Var.k = equals && D0.T() != null && D0.T().showPbPrivate();
        g0Var.o = this.t0.R0();
        g0Var.f60531b = true;
        g0Var.f60530a = l5(equals);
        if (equals) {
            this.A0.o1();
        }
        g0Var.n = TbadkCoreApplication.getInst().getSkinType() == 1;
        g0Var.j = true;
        g0Var.m = this.t0.i0();
        g0Var.f60533d = true;
        if (N.l1() == null) {
            g0Var.f60532c = true;
        } else {
            g0Var.f60532c = false;
        }
        if (D0.e0()) {
            g0Var.f60531b = false;
            g0Var.f60533d = false;
            g0Var.f60532c = false;
            g0Var.f60536g = false;
            g0Var.f60537h = false;
        }
        g0Var.s = TbSingleton.getInstance().mShowCallFans && equals && !D0.e0();
        d.a.s0.h2.k.e.t0 t0Var = this.A0;
        if (t0Var != null) {
            PbModel pbModel2 = this.t0;
            PostData t02 = t0Var.t0(pbModel2.I, pbModel2.R0());
            g0Var.t = t02 != null ? t02.S : false;
        }
        g0Var.l = true;
        if (d.a.r0.c1.b.e.d()) {
            g0Var.f60533d = false;
            g0Var.f60531b = false;
            g0Var.f60532c = false;
            g0Var.l = false;
        }
        this.A0.f60675h.w(g0Var);
    }
}
