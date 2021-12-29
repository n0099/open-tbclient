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
import c.a.s0.c0.d;
import c.a.s0.g1.n.f;
import c.a.s0.i.a;
import c.a.s0.s.i0.f;
import c.a.s0.s.q.d1;
import c.a.s0.s.s.a;
import c.a.s0.s.s.c;
import c.a.s0.s.s.j;
import c.a.t0.d1.r2.a.c;
import c.a.t0.q0.a;
import c.a.t0.q0.b;
import c.a.t0.s2.s.c;
import c.a.t0.s2.u.f.d0;
import c.a.t0.s2.u.f.d1.b;
import c.a.t0.s2.u.f.p;
import c.a.t0.s2.z.f;
import c.a.t0.w3.l0.a;
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
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
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
/* loaded from: classes12.dex */
public class PbFragment extends BaseFragment implements c.a.s0.g1.n.i, VoiceManager.j, UserIconBox.c, View.OnTouchListener, a.e, TbRichTextView.s, TbPageContextSupport, c.a.t0.s2.y.b, f.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final AntiHelper.k C2;
    public static final int CHECK_MUTE_FROM_DIALOG = 2;

    /* renamed from: CHECK_MUTE_FROM＿FLOOR  reason: contains not printable characters */
    public static final int f4CHECK_MUTE_FROMFLOOR = 1;
    public static final b.InterfaceC1322b D2;
    public static final String GOD_CALL_URL = "http://tieba.baidu.com/mo/q/god/call/?";
    public static final String PHONE = "2";
    public static final int UPDATE_TYPE_DELETE = 1;
    public static final int UPDATE_TYPE_MARK = 2;
    public static final int UPDATE_TYPE_WRITE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public c.a.s0.i.a A0;
    public final CustomMessageListener A1;
    public String A2;
    public long B;
    public ForumManageModel B0;
    public CustomMessageListener B1;
    public c.a.s0.s.q.u B2;
    public int C;
    public c.a.s0.t.e.a C0;
    public CustomMessageListener C1;
    public String D;
    public c.a.t0.s2.r.v D0;
    public View.OnClickListener D1;
    public c.a.d.f.k.b<TextView> E;
    public ShareSuccessReplyToServerModel E0;
    public CustomMessageListener E1;
    public c.a.d.f.k.b<TbImageView> F;
    public c.a.t0.s2.u.f.t0 F0;
    public CustomMessageListener F1;
    public c.a.d.f.k.b<ImageView> G;
    public boolean G0;
    public CustomMessageListener G1;
    public c.a.d.f.k.b<View> H;
    public boolean H0;
    public SuggestEmotionModel.c H1;
    public c.a.d.f.k.b<TiebaPlusRecommendCard> I;
    public boolean I0;
    public CustomMessageListener I1;
    public c.a.d.f.k.b<LinearLayout> J;
    public PopupDialog J0;
    public GetSugMatchWordsModel.b J1;
    public c.a.d.f.k.b<RelativeLayout> K;
    public c.a.s0.s.s.j K0;
    public boolean K1;
    public c.a.d.f.k.b<ItemCardView> L;
    public String L0;
    public PraiseModel L1;
    public boolean M;
    public boolean M0;
    public b.h M1;
    public boolean N;
    public boolean N0;
    public CustomMessageListener N1;
    public boolean O;
    public boolean O0;
    public c.a.s0.k0.i O1;
    public c.a.d.f.k.b<GifView> P;
    public String P0;
    public CheckRealNameModel.b P1;
    public String Q;
    public boolean Q0;
    public c.a.t0.s2.s.c Q1;
    public boolean R;
    public c.a.t0.w3.j0.f R0;
    public CustomMessageListener R1;
    public boolean S;
    public c.a.s0.x.y.g S0;
    public CustomMessageListener S1;
    public String T;
    public c.a.s0.x.y.e T0;
    public CustomMessageListener T1;
    public c.a.t0.s2.u.f.c1.f.a U;
    public boolean U0;
    public CustomMessageListener U1;
    public LikeModel V;
    public PermissionJudgePolicy V0;
    public CustomMessageListener V1;
    public View W;
    public c.a.t0.d1.r2.a.c W0;
    public CustomMessageListener W1;
    public View X;
    public c.a.t0.d1.r2.a.c X0;
    public j.e X1;
    public View Y;
    public EmotionImageData Y0;
    public CustomMessageListener Y1;
    public View Z;
    public c.a.s0.x.y.c Z0;
    public final NewWriteModel.g Z1;
    public String a0;
    public c.a.s0.x.y.b a1;
    public c.a.d.c.g.a a2;
    public int b0;
    public c.a.s0.x.y.b b1;
    public final PbModel.g b2;
    public int bjhFrom;
    public boolean c0;
    public int c1;
    public CustomMessageListener c2;
    public int[] d0;
    public Object d1;
    public HttpMessageListener d2;

    /* renamed from: e  reason: collision with root package name */
    public AbsPbActivity f48262e;
    public int e0;
    public c.a.d.a.f e1;
    public final a.InterfaceC0841a e2;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48263f;
    public int f0;
    public c.a.s0.s.i0.c f1;
    public final AbsListView.OnScrollListener f2;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48264g;
    public int g0;
    public BdUniqueId g1;
    public final c.a.d.a.e g2;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.q0.b f48265h;
    public c.a.s0.s.q.n1 h0;
    public Runnable h1;
    public final d3 h2;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.s2.u.f.d1.b f48266i;
    public c.a.s0.s.e0.a i0;
    public c.a.t0.s2.u.f.x0 i1;
    public final f.g i2;

    /* renamed from: j  reason: collision with root package name */
    public boolean f48267j;
    public c.a.d.n.d.a j1;
    public boolean j2;

    /* renamed from: k  reason: collision with root package name */
    public boolean f48268k;
    public boolean k0;
    public String k1;
    public final BdListView.p k2;
    public boolean l;
    public TbRichTextMemeInfo l1;
    public int l2;
    public String lastTid;
    public boolean m;
    public boolean m1;
    public final TbRichTextView.y m2;
    public final View.OnClickListener mCommonOnClickListener;
    public c.a.t0.s2.u.f.v0 mContentProcessController;
    public a.e mDialogClickListener;
    public CustomMessageListener mFirstFloorPraiseListener;
    public boolean mKeyboardIsVisible;
    public NewWriteModel.g mOnFloorPostWriteNewCallback;
    public View.OnTouchListener mOnTouchListener;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public boolean n;
    public int n1;
    public boolean n2;
    public VoiceManager o;
    public int o1;
    public PostData o2;
    public SortSwitchButton.f onSwitchChangeListener;
    public int p;
    public List<b3> p1;
    public final c.InterfaceC0871c p2;
    public c.a.s0.s.s.c q;
    public boolean q0;
    public c.a.t0.f0.a q1;
    public final c.InterfaceC0871c q2;
    public long r;
    public Object r0;
    public final b3 r1;
    public final AdapterView.OnItemClickListener r2;
    public long s;
    public c.a.t0.w3.j0.e s0;
    public final d0.b s1;
    public final View.OnLongClickListener s2;
    public BdUniqueId sortSwitchId;
    public long t;
    public boolean t0;
    public final CustomMessageListener t1;
    public final View.OnClickListener t2;
    public long u;
    @NonNull
    public TiePlusEventController.f u0;
    public CustomMessageListener u1;
    public final ItemCardHelper.c u2;
    public long v;
    public c.a.t0.s2.u.f.f1.a v0;
    public CustomMessageListener v1;
    public final NoNetworkView.b v2;
    public boolean w;
    public PbInterviewStatusView.f w0;
    public CustomMessageListener w1;
    public a.b w2;
    public boolean x;
    public final Handler x0;
    public CustomMessageListener x1;
    public final p.b x2;
    public c.a.s0.s0.b y;
    public PbModel y0;
    public CustomMessageListener y1;
    public int y2;
    public long z;
    public c.a.t0.s2.u.g.a z0;
    public CustomMessageListener z1;
    public int z2;

    /* loaded from: classes12.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f48269e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48270f;

        public a(PbFragment pbFragment, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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
            this.f48270f = pbFragment;
            this.f48269e = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f48270f.F0.k3();
                MessageManager.getInstance().sendMessage(this.f48269e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a0 implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f48271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f48272f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48273g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48274h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48275i;

        public a0(PbFragment pbFragment, SparseArray sparseArray, boolean z, String str, String str2) {
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
            this.f48275i = pbFragment;
            this.f48271e = sparseArray;
            this.f48272f = z;
            this.f48273g = str;
            this.f48274h = str2;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(c.a.s0.s.s.j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                if (this.f48275i.J0 != null) {
                    this.f48275i.J0.dismiss();
                }
                if (i2 == 0) {
                    this.f48275i.F0.W1(((Integer) this.f48271e.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) this.f48271e.get(c.a.t0.s2.i.tag_del_post_id), ((Integer) this.f48271e.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) this.f48271e.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f48271e.get(c.a.t0.s2.i.tag_user_mute_mute_username);
                    String str2 = (String) this.f48271e.get(c.a.t0.s2.i.tag_user_mute_thread_id);
                    String str3 = (String) this.f48271e.get(c.a.t0.s2.i.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f48272f, this.f48273g, str, str2, str3, 1, this.f48274h, this.f48275i.g1);
                    userMuteAddAndDelCustomMessage.setTag(this.f48275i.g1);
                    this.f48275i.T3(this.f48272f, userMuteAddAndDelCustomMessage, this.f48274h, str, (String) this.f48271e.get(c.a.t0.s2.i.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48276e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48277f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48278g;

        /* loaded from: classes12.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a1 f48279e;

            public a(a1 a1Var) {
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
                this.f48279e = a1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                c.a.t0.s2.u.f.v0 v0Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f48279e.f48278g.mContentProcessController) == null || v0Var.g() == null) {
                    return;
                }
                if (!this.f48279e.f48278g.mContentProcessController.g().e()) {
                    this.f48279e.f48278g.mContentProcessController.b(false);
                }
                this.f48279e.f48278g.mContentProcessController.g().l(false);
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

        public a1(PbFragment pbFragment, String str, String str2) {
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
            this.f48278g = pbFragment;
            this.f48276e = str;
            this.f48277f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i3 = c.a.d.f.p.n.i(this.f48278g.f48262e.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f2 = c.a.d.f.p.n.f(this.f48278g.getPageContext().getPageActivity(), c.a.t0.s2.g.tbds256);
                } else {
                    i2 = i3 / 2;
                    f2 = c.a.d.f.p.n.f(this.f48278g.getPageContext().getPageActivity(), c.a.t0.s2.g.tbds256);
                }
                int i4 = i3 - (i2 + f2);
                PbFragment pbFragment = this.f48278g;
                boolean z = true;
                pbFragment.getPbView().E0().smoothScrollBy((pbFragment.d0[1] + pbFragment.e0) - i4, 50);
                if (this.f48278g.getPbView().O0() != null) {
                    this.f48278g.T0.a().setVisibility(8);
                    this.f48278g.getPbView().O0().o(this.f48276e, this.f48277f, this.f48278g.getPbView().R0(), (this.f48278g.y0 == null || this.f48278g.y0.R0() == null || this.f48278g.y0.R0().O() == null || !this.f48278g.y0.R0().O().T1()) ? false : false);
                    c.a.s0.x.y.h b2 = this.f48278g.getPbView().O0().b();
                    if (b2 != null && this.f48278g.y0 != null && this.f48278g.y0.R0() != null) {
                        b2.G(this.f48278g.y0.R0().d());
                        b2.b0(this.f48278g.y0.R0().O());
                    }
                    if (this.f48278g.mContentProcessController.f() == null && this.f48278g.getPbView().O0().b().t() != null) {
                        this.f48278g.getPbView().O0().b().t().f(new a(this));
                        PbFragment pbFragment2 = this.f48278g;
                        pbFragment2.mContentProcessController.n(pbFragment2.getPbView().O0().b().t().h());
                        this.f48278g.getPbView().O0().b().M(this.f48278g.b1);
                    }
                }
                this.f48278g.getPbView().c1();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f48280e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f48281f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48282g;

        public a2(PbFragment pbFragment, MarkData markData, c.a.s0.s.s.a aVar) {
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
            this.f48282g = pbFragment;
            this.f48280e = markData;
            this.f48281f = aVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.f48280e);
                this.f48282g.f48262e.setResult(-1, intent);
                this.f48281f.dismiss();
                this.f48282g.X3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a3 implements d0.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.t0.s2.u.f.d0.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.F0.A3(str);
        }

        @Override // c.a.t0.s2.u.f.d0.b
        public void onSuccess(List<PostData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48283e;

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
            this.f48283e = pbFragment;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b0 implements PbInterviewStatusView.f {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.F0.x3(!this.a.R);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b1 implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48284b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48285c;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b1 f48286e;

            /* renamed from: com.baidu.tieba.pb.pb.main.PbFragment$b1$a$a  reason: collision with other inner class name */
            /* loaded from: classes12.dex */
            public class C1930a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f48287e;

                public C1930a(a aVar) {
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
                    this.f48287e = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    c.a.t0.s2.u.f.v0 v0Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (v0Var = this.f48287e.f48286e.f48285c.mContentProcessController) == null || v0Var.g() == null) {
                        return;
                    }
                    if (!this.f48287e.f48286e.f48285c.mContentProcessController.g().e()) {
                        this.f48287e.f48286e.f48285c.mContentProcessController.b(false);
                    }
                    this.f48287e.f48286e.f48285c.mContentProcessController.g().l(false);
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

            public a(b1 b1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48286e = b1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int f2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i3 = c.a.d.f.p.n.i(this.f48286e.f48285c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds410);
                    } else {
                        i2 = i3 / 2;
                        f2 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.t0.s2.g.tbds410);
                    }
                    int i4 = i3 - (i2 + f2);
                    PbFragment pbFragment = this.f48286e.f48285c;
                    boolean z = true;
                    pbFragment.getPbView().E0().smoothScrollBy((pbFragment.d0[1] + pbFragment.e0) - i4, 50);
                    if (this.f48286e.f48285c.getPbView().O0() != null) {
                        this.f48286e.f48285c.T0.a().setVisibility(8);
                        z = (this.f48286e.f48285c.y0 == null || this.f48286e.f48285c.y0.R0() == null || this.f48286e.f48285c.y0.R0().O() == null || !this.f48286e.f48285c.y0.R0().O().T1()) ? false : false;
                        c.a.t0.s2.u.f.t O0 = this.f48286e.f48285c.getPbView().O0();
                        b1 b1Var = this.f48286e;
                        O0.o(b1Var.a, b1Var.f48284b, b1Var.f48285c.getPbView().R0(), z);
                        c.a.s0.x.y.h b2 = this.f48286e.f48285c.getPbView().O0().b();
                        if (b2 != null && this.f48286e.f48285c.y0 != null && this.f48286e.f48285c.y0.R0() != null) {
                            b2.G(this.f48286e.f48285c.y0.R0().d());
                            b2.b0(this.f48286e.f48285c.y0.R0().O());
                        }
                        if (this.f48286e.f48285c.mContentProcessController.f() == null && this.f48286e.f48285c.getPbView().O0().b().t() != null) {
                            this.f48286e.f48285c.getPbView().O0().b().t().f(new C1930a(this));
                            PbFragment pbFragment2 = this.f48286e.f48285c;
                            pbFragment2.mContentProcessController.n(pbFragment2.getPbView().O0().b().t().h());
                            this.f48286e.f48285c.getPbView().O0().b().M(this.f48286e.f48285c.b1);
                        }
                    }
                    this.f48286e.f48285c.getPbView().c1();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48285c = pbFragment;
            this.a = str;
            this.f48284b = str2;
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                c.a.d.f.m.e.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b2 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f48288e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f48289f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48290g;

        public b2(PbFragment pbFragment, MarkData markData, c.a.s0.s.s.a aVar) {
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
            this.f48290g = pbFragment;
            this.f48288e = markData;
            this.f48289f = aVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
                int[] iArr = new int[2];
                if (this.f48290g.F0 != null && this.f48290g.F0.a1() != null) {
                    this.f48290g.F0.a1().getLocationOnScreen(iArr);
                }
                if (iArr[0] > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", this.f48288e);
                    this.f48290g.f48262e.setResult(-1, intent);
                    this.f48289f.dismiss();
                    this.f48290g.X3();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b3 {
        boolean onBackPressed();
    }

    /* loaded from: classes12.dex */
    public class c extends c.a.s0.e1.k0<ShareItem> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.t0.s2.u.f.g1.b.d(this.a.L2(), ShareSwitch.isOn() ? 1 : 6, this.a.y0);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f42213c == null) {
                    return;
                }
                if (updateAttentionMessage.getData().l != null) {
                    if (updateAttentionMessage.getOrginalMessage().getTag() != this.a.getUniqueId() || AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, PbFragment.C2) == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                } else if (updateAttentionMessage.getData().a) {
                    if (this.a.getFirstPostData().t() != null && this.a.getFirstPostData().t().getGodUserData() != null) {
                        this.a.getFirstPostData().t().getGodUserData().setIsLike(updateAttentionMessage.isAttention());
                    }
                    if (this.a.y0 == null || this.a.y0.R0() == null || this.a.y0.R0().O() == null || this.a.y0.R0().O().J() == null) {
                        return;
                    }
                    this.a.y0.R0().O().J().setHadConcerned(updateAttentionMessage.isAttention());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48291e;

        /* loaded from: classes12.dex */
        public class a implements j.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PopupDialog f48292e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ View f48293f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c1 f48294g;

            public a(c1 c1Var, PopupDialog popupDialog, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1Var, popupDialog, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48294g = c1Var;
                this.f48292e = popupDialog;
                this.f48293f = view;
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
                if (r4.f48294g.f48291e.y0.e1() != 3) goto L7;
             */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
            /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
            @Override // c.a.s0.s.s.j.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onItemClick(c.a.s0.s.s.j jVar, int i2, View view) {
                boolean B2;
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeLIL(1048576, this, jVar, i2, view) != null) {
                    return;
                }
                this.f48292e.dismiss();
                int i3 = 3;
                if (this.f48294g.f48291e.y0.e1() != 1 || i2 != 1) {
                    if (this.f48294g.f48291e.y0.e1() == 2 && i2 == 0) {
                        i3 = 1;
                    } else if (this.f48294g.f48291e.y0.e1() == 3 && i2 != 2) {
                        i3 = 2;
                    } else if (i2 == 2) {
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f48293f.getId() != c.a.t0.s2.i.pb_sort ? 1 : 0).param("obj_type", i3));
                    if (this.f48294g.f48291e.y0.R0().f23038f != null && this.f48294g.f48291e.y0.R0().f23038f.size() > i2) {
                        i2 = this.f48294g.f48291e.y0.R0().f23038f.get(i2).sort_type.intValue();
                    }
                    B2 = this.f48294g.f48291e.y0.B2(i2);
                    this.f48293f.setTag(Integer.valueOf(this.f48294g.f48291e.y0.d1()));
                    if (B2) {
                        return;
                    }
                    this.f48294g.f48291e.m = true;
                    this.f48294g.f48291e.F0.E2(true);
                    return;
                }
                i3 = 0;
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f48293f.getId() != c.a.t0.s2.i.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f48294g.f48291e.y0.R0().f23038f != null) {
                    i2 = this.f48294g.f48291e.y0.R0().f23038f.get(i2).sort_type.intValue();
                }
                B2 = this.f48294g.f48291e.y0.B2(i2);
                this.f48293f.setTag(Integer.valueOf(this.f48294g.f48291e.y0.d1()));
                if (B2) {
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
            this.f48291e = pbFragment;
        }

        /* JADX WARN: Code restructure failed: missing block: B:901:0x20bb, code lost:
            if (r32.f48291e.F0.S0.f23714c.getView().getTop() <= ((r32.f48291e.F0.P0() == null || r32.f48291e.F0.P0().c() == null) ? 0 : r32.f48291e.F0.P0().c().getBottom())) goto L841;
         */
        /* JADX WARN: Code restructure failed: missing block: B:902:0x20bd, code lost:
            r14 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:904:0x20ca, code lost:
            if (r0 >= c.a.t0.s2.u.f.b1.k.c(r32.f48291e.getListView())) goto L841;
         */
        /* JADX WARN: Code restructure failed: missing block: B:926:0x2171, code lost:
            if ((r32.f48291e.F0.S0.f23714c.getView().getTop() - r32.f48291e.F0.f23665h.a.getBottom()) < (r32.f48291e.F0.S0.f23714c.mDivideLineTop.getHeight() + 10)) goto L841;
         */
        /* JADX WARN: Removed duplicated region for block: B:1173:0x2a29  */
        /* JADX WARN: Removed duplicated region for block: B:1174:0x2a3e  */
        /* JADX WARN: Removed duplicated region for block: B:1177:0x2a77  */
        /* JADX WARN: Removed duplicated region for block: B:301:0x0a0c  */
        /* JADX WARN: Removed duplicated region for block: B:302:0x0a11  */
        /* JADX WARN: Removed duplicated region for block: B:305:0x0a20  */
        /* JADX WARN: Removed duplicated region for block: B:340:0x0ad7  */
        /* JADX WARN: Removed duplicated region for block: B:343:0x0aea  */
        /* JADX WARN: Removed duplicated region for block: B:346:0x0afb  */
        /* JADX WARN: Removed duplicated region for block: B:349:0x0b13  */
        /* JADX WARN: Removed duplicated region for block: B:351:0x0b1b  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            c.a.s0.s.s.g gVar;
            c.a.s0.s.s.g gVar2;
            c.a.s0.s.s.g gVar3;
            PbFragment pbFragment;
            int i2;
            boolean z;
            c.a.s0.s.s.g gVar4;
            c.a.s0.s.s.g gVar5;
            c.a.s0.s.s.g gVar6;
            c.a.s0.s.s.g gVar7;
            String name;
            int i3;
            boolean z2;
            int fixedNavHeight;
            int i4;
            c.a.s0.s.q.i2 i2Var;
            String d2;
            String[] strArr;
            c.a.t0.s2.r.f R0;
            int i5;
            int i6;
            boolean A2;
            int i7;
            String name2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && this.f48291e.isAdded()) {
                if (!(view instanceof TbListTextView) || !(view.getParent() instanceof TbRichTextView)) {
                    if (view == this.f48291e.F0.H0() && this.f48291e.getPageContext().getPageActivity() != null && this.f48291e.y0 != null) {
                        this.f48291e.sendMessage(new CustomMessage(2002001, new FoldCommentActivityConfig(this.f48291e.getPageContext().getPageActivity(), this.f48291e.y0.h1(), this.f48291e.y0.v1(), this.f48291e.y0.u1())));
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.f48291e.y0.getForumId());
                        statisticItem2.param("fname", this.f48291e.y0.r0());
                        statisticItem2.param("tid", this.f48291e.y0.h1());
                        TiebaStatic.log(statisticItem2);
                    }
                    if (view == this.f48291e.F0.J0()) {
                        if (this.f48291e.m) {
                            return;
                        }
                        if (this.f48291e.y0.F1(true)) {
                            this.f48291e.m = true;
                            this.f48291e.F0.R2();
                        }
                    } else if (view != this.f48291e.F0.f23665h.m()) {
                        if (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().k()) {
                            int i8 = 3;
                            if (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().d()) {
                                if (view == this.f48291e.F0.f23665h.f23573f) {
                                    if (this.f48291e.F0.S(this.f48291e.y0.F0())) {
                                        this.f48291e.stopVoice();
                                        return;
                                    }
                                    this.f48291e.n = false;
                                    this.f48291e.f48267j = false;
                                    c.a.d.f.p.n.w(this.f48291e.f48262e, this.f48291e.F0.f23665h.f23573f);
                                    this.f48291e.f48262e.finish();
                                } else if (view != this.f48291e.F0.p0() && (this.f48291e.F0.f23665h.n() == null || (view != this.f48291e.F0.f23665h.n().l() && view != this.f48291e.F0.f23665h.n().m()))) {
                                    if (view == this.f48291e.F0.x0()) {
                                        if (this.f48291e.y0 != null) {
                                            c.a.s0.m.a.m(this.f48291e.getPageContext().getPageActivity(), this.f48291e.y0.R0().O().z1().b());
                                        }
                                    } else if (view != this.f48291e.F0.f23665h.f23570c) {
                                        if (view == this.f48291e.F0.f23665h.f23571d) {
                                            if (c.a.s0.e1.q.a()) {
                                                return;
                                            }
                                            if (this.f48291e.y0 != null && this.f48291e.y0.R0() != null) {
                                                ArrayList<PostData> F = this.f48291e.y0.R0().F();
                                                if ((F == null || F.size() <= 0) && this.f48291e.y0.f1()) {
                                                    c.a.d.f.p.n.M(this.f48291e.getPageContext().getPageActivity(), this.f48291e.getPageContext().getString(c.a.t0.s2.l.pb_no_data_tips));
                                                    return;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.f48291e.y0.h1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f48291e.y0.getForumId()));
                                                if (!this.f48291e.F0.F1()) {
                                                    this.f48291e.F0.o2();
                                                }
                                                this.f48291e.openMore();
                                            } else {
                                                c.a.d.f.p.n.M(this.f48291e.getPageContext().getPageActivity(), this.f48291e.getPageContext().getString(c.a.t0.s2.l.pb_no_data_tips));
                                                return;
                                            }
                                        } else if (view.getId() == c.a.t0.s2.i.pb_god_user_tip_content) {
                                            if (c.a.d.f.p.l.z()) {
                                                this.f48291e.F0.B2(true);
                                                this.f48291e.F0.o2();
                                                if (this.f48291e.m) {
                                                    return;
                                                }
                                                this.f48291e.m = true;
                                                this.f48291e.F0.u3();
                                                this.f48291e.stopVoice();
                                                this.f48291e.F0.Q2();
                                                this.f48291e.y0.z2(this.f48291e.N2());
                                                TiebaStatic.eventStat(this.f48291e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                                            } else {
                                                this.f48291e.showToast(c.a.t0.s2.l.network_not_available);
                                                return;
                                            }
                                        } else if (view.getId() != c.a.t0.s2.i.pb_editor_tool_collection) {
                                            if ((this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().i()) && view.getId() != c.a.t0.s2.i.floor_owner_reply && view.getId() != c.a.t0.s2.i.reply_title) {
                                                if (this.f48291e.F0.f23665h.n() != null && view == this.f48291e.F0.f23665h.n().e()) {
                                                    this.f48291e.F0.f23665h.k();
                                                } else if (view.getId() == c.a.t0.s2.i.share_num_container) {
                                                    if (!this.f48291e.C2(11009)) {
                                                        return;
                                                    }
                                                    this.f48291e.a3(3);
                                                } else if (view.getId() != c.a.t0.s2.i.pb_editor_tool_share) {
                                                    if (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().j()) {
                                                        if (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().q()) {
                                                            if (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().p()) {
                                                                if (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().n()) {
                                                                    if (this.f48291e.F0.B0() == view) {
                                                                        if (this.f48291e.F0.B0().getIndicateStatus()) {
                                                                            c.a.t0.s2.r.f R02 = this.f48291e.y0.R0();
                                                                            if (R02 != null && R02.O() != null && R02.O().m1() != null) {
                                                                                String d3 = R02.O().m1().d();
                                                                                if (StringUtils.isNull(d3)) {
                                                                                    d3 = R02.O().m1().f();
                                                                                }
                                                                                TiebaStatic.log(new StatisticItem("c11107").param("obj_id", d3));
                                                                            }
                                                                        } else {
                                                                            c.a.t0.w3.l0.a.d("c10725", null);
                                                                        }
                                                                        this.f48291e.goInterviewLivePage();
                                                                    } else if (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().g()) {
                                                                        if (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().c()) {
                                                                            if (this.f48291e.F0.f23665h.n() != null && view == this.f48291e.F0.f23665h.n().f()) {
                                                                                if (c.a.d.f.p.l.z()) {
                                                                                    SparseArray<Object> F0 = this.f48291e.F0.F0(this.f48291e.y0.R0(), this.f48291e.y0.f1(), 1);
                                                                                    if (F0 != null) {
                                                                                        if (StringUtils.isNull((String) F0.get(c.a.t0.s2.i.tag_del_multi_forum))) {
                                                                                            this.f48291e.F0.W1(((Integer) F0.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) F0.get(c.a.t0.s2.i.tag_del_post_id), ((Integer) F0.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) F0.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue());
                                                                                        } else {
                                                                                            this.f48291e.F0.X1(((Integer) F0.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) F0.get(c.a.t0.s2.i.tag_del_post_id), ((Integer) F0.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) F0.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue(), (String) F0.get(c.a.t0.s2.i.tag_del_multi_forum));
                                                                                        }
                                                                                    }
                                                                                    this.f48291e.F0.f23665h.k();
                                                                                } else {
                                                                                    this.f48291e.showToast(c.a.t0.s2.l.network_not_available);
                                                                                    return;
                                                                                }
                                                                            } else if (view.getId() != c.a.t0.s2.i.sub_pb_more && view.getId() != c.a.t0.s2.i.sub_pb_item && view.getId() != c.a.t0.s2.i.pb_floor_reply_more && view.getId() != c.a.t0.s2.i.new_sub_pb_list_richText) {
                                                                                if (view.getId() == c.a.t0.s2.i.pb_post_reply_count) {
                                                                                    if (this.f48291e.y0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    StatisticItem statisticItem3 = new StatisticItem("c13398");
                                                                                    statisticItem3.param("tid", this.f48291e.y0.h1());
                                                                                    statisticItem3.param("fid", this.f48291e.y0.getForumId());
                                                                                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem3.param("obj_locate", 5);
                                                                                    TiebaStatic.log(statisticItem3);
                                                                                    if (view.getId() == c.a.t0.s2.i.pb_post_reply_count && !DialogLoginHelper.checkUpIsLogin(new c.a.s0.s.q.t0(this.f48291e.getActivity(), "pb_chakanhuifu"))) {
                                                                                        this.f48291e.X = view;
                                                                                        return;
                                                                                    } else if (!this.f48291e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                                        if (!(sparseArray2.get(c.a.t0.s2.i.tag_load_sub_data) instanceof PostData)) {
                                                                                            return;
                                                                                        }
                                                                                        PostData postData = (PostData) sparseArray2.get(c.a.t0.s2.i.tag_load_sub_data);
                                                                                        StatisticItem statisticItem4 = postData.g0;
                                                                                        if (statisticItem4 != null) {
                                                                                            StatisticItem copy = statisticItem4.copy();
                                                                                            copy.delete("obj_locate");
                                                                                            copy.param("obj_locate", 8);
                                                                                            TiebaStatic.log(copy);
                                                                                        }
                                                                                        if (this.f48291e.y0 == null || this.f48291e.y0.R0() == null) {
                                                                                            return;
                                                                                        }
                                                                                        String h1 = this.f48291e.y0.h1();
                                                                                        String G = postData.G();
                                                                                        int V = this.f48291e.y0.R0() != null ? this.f48291e.y0.R0().V() : 0;
                                                                                        AbsPbActivity.e t3 = this.f48291e.t3(G);
                                                                                        if (t3 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.f48291e.getPageContext().getPageActivity()).createSubPbActivityConfig(h1, G, "pb", true, false, null, false, null, V, postData.S(), this.f48291e.y0.R0().d(), false, postData.t().getIconInfo(), 5).addBigImageData(t3.a, t3.f48229b, t3.f48234g, t3.f48237j);
                                                                                        addBigImageData.setKeyPageStartFrom(this.f48291e.y0.Q0());
                                                                                        addBigImageData.setFromFrsForumId(this.f48291e.y0.getFromForumId());
                                                                                        addBigImageData.setWorksInfoData(this.f48291e.y0.m1());
                                                                                        addBigImageData.setKeyFromForumId(this.f48291e.y0.getForumId());
                                                                                        addBigImageData.setTiebaPlusData(this.f48291e.y0.F(), this.f48291e.y0.B(), this.f48291e.y0.C(), this.f48291e.y0.A(), this.f48291e.y0.G());
                                                                                        addBigImageData.setBjhData(this.f48291e.y0.k0());
                                                                                        if (this.f48291e.y0.R0().o() != null) {
                                                                                            addBigImageData.setHasForumRule(this.f48291e.y0.R0().o().has_forum_rule.intValue());
                                                                                        }
                                                                                        if (this.f48291e.y0.R0().U() != null) {
                                                                                            addBigImageData.setIsManager(this.f48291e.y0.R0().U().getIs_manager());
                                                                                        }
                                                                                        if (this.f48291e.y0.R0().l().getDeletedReasonInfo() != null) {
                                                                                            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(this.f48291e.y0.R0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                                                                                            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(this.f48291e.y0.R0().l().getDeletedReasonInfo().is_boomgrow.intValue());
                                                                                        }
                                                                                        if (this.f48291e.y0.R0().l() != null) {
                                                                                            addBigImageData.setForumHeadUrl(this.f48291e.y0.R0().l().getImage_url());
                                                                                            addBigImageData.setUserLevel(this.f48291e.y0.R0().l().getUser_level());
                                                                                        }
                                                                                        if (this.f48291e.F0 != null) {
                                                                                            addBigImageData.setMainPostMaskVisibly(this.f48291e.F0.v0(this.f48291e.y0.K, this.f48291e.y0.f1()).U || postData.U);
                                                                                        }
                                                                                        this.f48291e.sendMessage(new CustomMessage(2002001, addBigImageData));
                                                                                    }
                                                                                } else if (view.getId() == c.a.t0.s2.i.pb_post_reply || view.getId() == c.a.t0.s2.i.post_info_commont_img || view.getId() == c.a.t0.s2.i.pb_floor_comment_container) {
                                                                                    if (this.f48291e.y0 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (view.getId() == c.a.t0.s2.i.pb_post_reply) {
                                                                                        StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                                                        statisticItem5.param("tid", this.f48291e.y0.h1());
                                                                                        statisticItem5.param("fid", this.f48291e.y0.getForumId());
                                                                                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                        statisticItem5.param("obj_locate", 6);
                                                                                        TiebaStatic.log(statisticItem5);
                                                                                    }
                                                                                    if (view.getId() == c.a.t0.s2.i.post_info_commont_img) {
                                                                                        if (!DialogLoginHelper.checkUpIsLogin(new c.a.s0.s.q.t0(this.f48291e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                            this.f48291e.Y = view;
                                                                                            return;
                                                                                        }
                                                                                    } else if (view.getId() == c.a.t0.s2.i.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new c.a.s0.s.q.t0(this.f48291e.getActivity(), "pb_huifu_louzhonglou"))) {
                                                                                        this.f48291e.Y = view;
                                                                                        return;
                                                                                    }
                                                                                    if (!this.f48291e.checkUpIsLogin() || !(view.getTag() instanceof SparseArray)) {
                                                                                        return;
                                                                                    }
                                                                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                                                                    if (!(sparseArray3.get(c.a.t0.s2.i.tag_load_sub_data) instanceof PostData)) {
                                                                                        return;
                                                                                    }
                                                                                    PostData postData2 = (PostData) sparseArray3.get(c.a.t0.s2.i.tag_load_sub_data);
                                                                                    if (view.getId() == c.a.t0.s2.i.pb_post_reply && (statisticItem = postData2.g0) != null) {
                                                                                        StatisticItem copy2 = statisticItem.copy();
                                                                                        copy2.delete("obj_locate");
                                                                                        copy2.param("obj_locate", 8);
                                                                                        TiebaStatic.log(copy2);
                                                                                    } else if (view.getId() == c.a.t0.s2.i.post_info_commont_img || view.getId() == c.a.t0.s2.i.pb_floor_comment_container) {
                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f48291e.y0.i1()).param("fid", this.f48291e.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.G()).param("obj_source", 1).param("obj_type", 3));
                                                                                    }
                                                                                    if (this.f48291e.y0 == null || this.f48291e.y0.R0() == null || this.f48291e.getPbView().N0() == null || postData2.t() == null || postData2.A() == 1) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.f48291e.getPbView().O0() != null) {
                                                                                        this.f48291e.getPbView().O0().c();
                                                                                    }
                                                                                    if (this.f48291e.t0 && postData2.P() != null && postData2.P().size() != 0) {
                                                                                        this.f48291e.W3(postData2, true);
                                                                                    } else {
                                                                                        c.a.t0.s2.r.t tVar = new c.a.t0.s2.r.t();
                                                                                        tVar.A(this.f48291e.y0.R0().l());
                                                                                        tVar.E(this.f48291e.y0.R0().O());
                                                                                        tVar.C(postData2);
                                                                                        this.f48291e.getPbView().N0().S(tVar);
                                                                                        this.f48291e.getPbView().N0().setPostId(postData2.G());
                                                                                        this.f48291e.m3(view, postData2.t().getUserId(), "", postData2);
                                                                                        if (this.f48291e.T0 != null) {
                                                                                            this.f48291e.F0.v2(this.f48291e.T0.C());
                                                                                        }
                                                                                    }
                                                                                } else if (view.getId() != c.a.t0.s2.i.pb_floor_feedback) {
                                                                                    if (view != this.f48291e.F0.z0()) {
                                                                                        if (view == this.f48291e.F0.f23665h.o()) {
                                                                                            this.f48291e.F0.Y2();
                                                                                        } else if (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().o()) {
                                                                                            if (this.f48291e.F0.f23665h.n() != null && view == this.f48291e.F0.f23665h.n().h()) {
                                                                                                c.a.s0.t.c.k0 tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                                                                                if (tiebaPlusConfigData != null && (d2 = tiebaPlusConfigData.d(this.f48291e.y0.h1())) != null) {
                                                                                                    UrlManager.getInstance().dealOneLink(this.f48291e.getPageContext(), new String[]{d2});
                                                                                                    this.f48291e.F0.f23665h.k();
                                                                                                    c.a.s0.t.c.k0.a(3);
                                                                                                }
                                                                                            } else {
                                                                                                int id = view.getId();
                                                                                                if (id == c.a.t0.s2.i.pb_u9_text_view) {
                                                                                                    if (!this.f48291e.checkUpIsLogin() || (i2Var = (c.a.s0.s.q.i2) view.getTag()) == null || StringUtils.isNull(i2Var.J0())) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.eventStat(this.f48291e.getPageContext().getPageActivity(), "info_click", "click", 1, "page", "pb");
                                                                                                    UrlManager.getInstance().dealOneLink(this.f48291e.getPageContext(), new String[]{i2Var.J0()});
                                                                                                } else if (id != c.a.t0.s2.i.replybtn && id != c.a.t0.s2.i.cover_reply_content && id != c.a.t0.s2.i.replybtn_top_right && id != c.a.t0.s2.i.cover_reply_content_top_right) {
                                                                                                    if (id == c.a.t0.s2.i.pb_act_btn) {
                                                                                                        if (this.f48291e.y0.R0() != null && this.f48291e.y0.R0().O() != null && this.f48291e.y0.R0().O().x() != null) {
                                                                                                            c.a.s0.m.a.m(this.f48291e.getActivity(), this.f48291e.y0.R0().O().x());
                                                                                                            if (this.f48291e.y0.R0().O().w() != 1) {
                                                                                                                if (this.f48291e.y0.R0().O().w() == 2) {
                                                                                                                    TiebaStatic.eventStat(this.f48291e.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "pb");
                                                                                                                }
                                                                                                            } else {
                                                                                                                TiebaStatic.eventStat(this.f48291e.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "pb");
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == c.a.t0.s2.i.lottery_tail) {
                                                                                                        if (view.getTag(c.a.t0.s2.i.tag_pb_lottery_tail_link) instanceof String) {
                                                                                                            String str = (String) view.getTag(c.a.t0.s2.i.tag_pb_lottery_tail_link);
                                                                                                            TiebaStatic.log(new StatisticItem("c10912").param("fid", this.f48291e.y0.R0().m()).param("tid", this.f48291e.y0.R0().Q()).param("lotterytail", StringUtils.string(str, "_", TbadkCoreApplication.getCurrentAccount())));
                                                                                                            if (this.f48291e.y0.R0().Q().equals(str)) {
                                                                                                                this.f48291e.F0.U2(0);
                                                                                                            } else {
                                                                                                                this.f48291e.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f48291e.getActivity()).createNormalCfg(str, (String) null, (String) null, (String) null)));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == c.a.t0.s2.i.pb_item_tail_content) {
                                                                                                        if (ViewHelper.checkUpIsLogin(this.f48291e.getPageContext().getPageActivity())) {
                                                                                                            String string = TbadkCoreApplication.getInst().getString(c.a.t0.s2.l.tail_web_view_title);
                                                                                                            String p = c.a.s0.s.g0.b.j().p("tail_link", "");
                                                                                                            if (!StringUtils.isNull(p)) {
                                                                                                                TiebaStatic.log("c10056");
                                                                                                                c.a.s0.m.a.q(view.getContext(), string, p, true, true, true);
                                                                                                            }
                                                                                                            this.f48291e.F0.o2();
                                                                                                        }
                                                                                                    } else if (id == c.a.t0.s2.i.join_vote_tv) {
                                                                                                        if (view != null) {
                                                                                                            c.a.s0.m.a.m(this.f48291e.getActivity(), (String) view.getTag());
                                                                                                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                                                                            if (this.f48291e.L2() == 1 && this.f48291e.y0 != null && this.f48291e.y0.R0() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c10397").param("fid", this.f48291e.y0.R0().m()).param("tid", this.f48291e.y0.R0().Q()).param("uid", currentAccount));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == c.a.t0.s2.i.look_all_tv) {
                                                                                                        if (view != null) {
                                                                                                            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                                                                                                            c.a.s0.m.a.m(this.f48291e.getActivity(), (String) view.getTag());
                                                                                                            if (this.f48291e.L2() == 1 && this.f48291e.y0 != null && this.f48291e.y0.R0() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c10507").param("fid", this.f48291e.y0.R0().m()).param("tid", this.f48291e.y0.R0().Q()).param("uid", currentAccount2));
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == c.a.t0.s2.i.manga_prev_btn) {
                                                                                                        this.f48291e.l3();
                                                                                                    } else if (id == c.a.t0.s2.i.manga_next_btn) {
                                                                                                        this.f48291e.j3();
                                                                                                    } else if (id == c.a.t0.s2.i.yule_head_img_img) {
                                                                                                        if (this.f48291e.y0 != null && this.f48291e.y0.R0() != null && this.f48291e.y0.R0().A() != null) {
                                                                                                            c.a.t0.s2.r.f R03 = this.f48291e.y0.R0();
                                                                                                            TiebaStatic.log(new StatisticItem("c11679").param("fid", R03.m()));
                                                                                                            UrlManager.getInstance().dealOneLink(this.f48291e.getPageContext(), new String[]{R03.A().b()});
                                                                                                        }
                                                                                                    } else if (id == c.a.t0.s2.i.yule_head_img_all_rank) {
                                                                                                        if (this.f48291e.y0 != null && this.f48291e.y0.R0() != null && this.f48291e.y0.R0().A() != null) {
                                                                                                            c.a.t0.s2.r.f R04 = this.f48291e.y0.R0();
                                                                                                            TiebaStatic.log(new StatisticItem("c11678").param("fid", R04.m()));
                                                                                                            UrlManager.getInstance().dealOneLink(this.f48291e.getPageContext(), new String[]{R04.A().b()});
                                                                                                        }
                                                                                                    } else if (id == c.a.t0.s2.i.tv_pb_reply_more) {
                                                                                                        if (this.f48291e.n1 >= 0) {
                                                                                                            if (this.f48291e.y0 != null) {
                                                                                                                this.f48291e.y0.d2();
                                                                                                            }
                                                                                                            if (this.f48291e.y0 == null || this.f48291e.F0.n0() == null) {
                                                                                                                i4 = 0;
                                                                                                            } else {
                                                                                                                i4 = 0;
                                                                                                                this.f48291e.F0.n0().e0(this.f48291e.y0.R0(), false);
                                                                                                            }
                                                                                                            this.f48291e.n1 = i4;
                                                                                                            if (this.f48291e.y0 != null) {
                                                                                                                this.f48291e.F0.E0().setSelection(this.f48291e.y0.K0());
                                                                                                                this.f48291e.y0.h2(0, 0);
                                                                                                            }
                                                                                                        }
                                                                                                    } else if (id == c.a.t0.s2.i.qq_share_container) {
                                                                                                        if (!this.f48291e.C2(11009)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.f48291e.a3(8);
                                                                                                    } else if (id == c.a.t0.s2.i.new_sub_pb_list_richText) {
                                                                                                        SparseArray sparseArray4 = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                                                                                                        if (sparseArray4 == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.f48291e.V3(sparseArray4);
                                                                                                    } else if (id == c.a.t0.s2.i.pb_editor_tool_comment_icon) {
                                                                                                        if (this.f48291e.F0.E0() == null || this.f48291e.y0 == null || this.f48291e.y0.R0() == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        int firstVisiblePosition = this.f48291e.F0.E0().getFirstVisiblePosition();
                                                                                                        View childAt = this.f48291e.F0.E0().getChildAt(0);
                                                                                                        int top = childAt == null ? 0 : childAt.getTop();
                                                                                                        boolean r0 = this.f48291e.y0.R0().r0();
                                                                                                        boolean z3 = this.f48291e.F0.P0() != null && this.f48291e.F0.P0().g();
                                                                                                        boolean D1 = this.f48291e.F0.D1();
                                                                                                        boolean z4 = firstVisiblePosition == 0 && top == 0;
                                                                                                        if (!r0 || this.f48291e.F0.P0() == null || this.f48291e.F0.P0().c() == null) {
                                                                                                            i3 = 0;
                                                                                                        } else {
                                                                                                            int k2 = ((int) (c.a.d.f.p.n.k(this.f48291e.getContext()) * 0.5625d)) - this.f48291e.F0.P0().e();
                                                                                                            i3 = k2;
                                                                                                            z4 = firstVisiblePosition == 0 && (top == k2 || top == this.f48291e.F0.P0().c().getHeight() - this.f48291e.F0.P0().e());
                                                                                                        }
                                                                                                        this.f48291e.H2(TbadkCoreStatisticKey.KEY_COMMENT_BTN_CLICK);
                                                                                                        if ((this.f48291e.y0.R0().O() != null && this.f48291e.y0.R0().O().V0() <= 0) || (D1 && z4)) {
                                                                                                            if (!this.f48291e.checkUpIsLogin()) {
                                                                                                                return;
                                                                                                            }
                                                                                                            this.f48291e.processProfessionPermission();
                                                                                                            if (this.f48291e.y0.R0().O().J() != null) {
                                                                                                                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f48291e.y0.f48398f).param("fid", this.f48291e.y0.R0().m()).param("obj_locate", 2).param("uid", this.f48291e.y0.R0().O().J().getUserId()));
                                                                                                            }
                                                                                                        } else {
                                                                                                            int i9 = (int) (c.a.d.f.p.n.i(this.f48291e.getContext()) * 0.6d);
                                                                                                            if (r0) {
                                                                                                                if (this.f48291e.F0.S0 != null && this.f48291e.F0.S0.f23714c != null && this.f48291e.F0.S0.f23714c.getView() != null) {
                                                                                                                    if (this.f48291e.F0.S0.f23714c.getView().getParent() != null) {
                                                                                                                    }
                                                                                                                }
                                                                                                                z2 = false;
                                                                                                            } else {
                                                                                                                if (this.f48291e.F0.M0() != null) {
                                                                                                                    z2 = this.f48291e.F0.M0().getVisibility() == 0;
                                                                                                                    if (!z2 && this.f48291e.F0.S0 != null && this.f48291e.F0.S0.f23714c != null && this.f48291e.F0.S0.f23714c.getView() != null && this.f48291e.F0.S0.f23714c.getView().getParent() != null && this.f48291e.F0.f23665h != null && this.f48291e.F0.f23665h.a != null) {
                                                                                                                    }
                                                                                                                }
                                                                                                                z2 = false;
                                                                                                            }
                                                                                                            if (z2 || D1) {
                                                                                                                this.f48291e.f0 = firstVisiblePosition;
                                                                                                                this.f48291e.g0 = top;
                                                                                                                if (firstVisiblePosition > 3 || (firstVisiblePosition == 3 && top < (-i9))) {
                                                                                                                    this.f48291e.F0.E0().setSelectionFromTop(0, i3 - i9);
                                                                                                                    this.f48291e.F0.E0().smoothScrollBy(-i9, 500);
                                                                                                                } else {
                                                                                                                    this.f48291e.F0.E0().smoothScrollToPosition(0, i3, 500);
                                                                                                                }
                                                                                                            } else if (this.f48291e.f0 > 0) {
                                                                                                                if (this.f48291e.F0.E0().getChildAt(this.f48291e.f0) != null) {
                                                                                                                    this.f48291e.F0.E0().smoothScrollToPosition(this.f48291e.f0, this.f48291e.g0, 200);
                                                                                                                } else {
                                                                                                                    this.f48291e.F0.E0().setSelectionFromTop(this.f48291e.f0, this.f48291e.g0 + i9);
                                                                                                                    this.f48291e.F0.E0().smoothScrollBy(i9, 500);
                                                                                                                }
                                                                                                            } else {
                                                                                                                int c2 = c.a.t0.s2.u.f.b1.k.c(this.f48291e.getListView());
                                                                                                                if (c.a.t0.s2.u.f.b1.k.d(this.f48291e.getListView()) != -1) {
                                                                                                                    c2--;
                                                                                                                }
                                                                                                                int f2 = c.a.d.f.p.n.f(this.f48291e.getContext(), c.a.t0.s2.g.tbds100);
                                                                                                                if (c2 < 0) {
                                                                                                                    c2 = (ListUtils.getCount(this.f48291e.F0.E0().getData()) - 1) + this.f48291e.F0.E0().getHeaderViewsCount();
                                                                                                                    f2 = 0;
                                                                                                                }
                                                                                                                if (!z3) {
                                                                                                                    if (!r0 || this.f48291e.F0.P0() == null) {
                                                                                                                        if (this.f48291e.F0.f23665h != null && this.f48291e.F0.f23665h.a != null) {
                                                                                                                            fixedNavHeight = this.f48291e.F0.f23665h.a.getFixedNavHeight() - 10;
                                                                                                                        }
                                                                                                                        if (this.f48291e.F0.S0 != null || this.f48291e.F0.S0.f23714c == null || this.f48291e.F0.S0.f23714c.getView() == null || this.f48291e.F0.S0.f23714c.getView().getParent() == null) {
                                                                                                                            this.f48291e.F0.E0().setSelectionFromTop(c2, f2 + i9);
                                                                                                                            this.f48291e.F0.E0().smoothScrollBy(i9, 500);
                                                                                                                        } else if (!z3) {
                                                                                                                            this.f48291e.F0.E0().smoothScrollToPosition(c2, f2, 200);
                                                                                                                        } else {
                                                                                                                            this.f48291e.F0.E0().smoothScrollBy(this.f48291e.F0.S0.f23714c.getView().getTop() - ((int) (c.a.d.f.p.n.k(this.f48291e.getContext()) * 0.5625d)), 500);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        fixedNavHeight = this.f48291e.F0.P0().d();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    fixedNavHeight = (int) (c.a.d.f.p.n.k(this.f48291e.getContext()) * 0.5625d);
                                                                                                                }
                                                                                                                f2 += fixedNavHeight;
                                                                                                                if (this.f48291e.F0.S0 != null) {
                                                                                                                }
                                                                                                                this.f48291e.F0.E0().setSelectionFromTop(c2, f2 + i9);
                                                                                                                this.f48291e.F0.E0().smoothScrollBy(i9, 500);
                                                                                                            }
                                                                                                        }
                                                                                                        if (this.f48291e.y0.R0().O() != null && this.f48291e.y0.R0().O().J() != null) {
                                                                                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f48291e.y0.f48398f).param("fid", this.f48291e.y0.R0().m()).param("obj_locate", 2).param("uid", this.f48291e.y0.R0().O().J().getUserId()));
                                                                                                        }
                                                                                                    } else if (id == c.a.t0.s2.i.pb_nav_title_forum_image || id == c.a.t0.s2.i.pb_nav_title_forum_name) {
                                                                                                        if (this.f48291e.y0 == null || this.f48291e.y0.R0() == null || this.f48291e.y0.R0().l() == null || c.a.d.f.p.m.isEmpty(this.f48291e.y0.R0().l().getName())) {
                                                                                                            return;
                                                                                                        }
                                                                                                        if (this.f48291e.y0.getErrorNo() == 4) {
                                                                                                            if (!StringUtils.isNull(this.f48291e.y0.r0()) || this.f48291e.y0.h0() == null) {
                                                                                                                this.f48291e.f48262e.finish();
                                                                                                                return;
                                                                                                            }
                                                                                                            name = this.f48291e.y0.h0().f23029b;
                                                                                                        } else {
                                                                                                            name = this.f48291e.y0.R0().l().getName();
                                                                                                        }
                                                                                                        if (StringUtils.isNull(name)) {
                                                                                                            this.f48291e.f48262e.finish();
                                                                                                            return;
                                                                                                        }
                                                                                                        String r02 = this.f48291e.y0.r0();
                                                                                                        if (this.f48291e.y0.x0() && r02 != null && r02.equals(name)) {
                                                                                                            this.f48291e.f48262e.finish();
                                                                                                        } else {
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f48291e.getActivity()).createNormalCfg(this.f48291e.y0.R0().l().getName(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                                                                                                        }
                                                                                                        StatisticItem statisticItem6 = new StatisticItem("c13401");
                                                                                                        statisticItem6.param("tid", this.f48291e.y0.h1());
                                                                                                        statisticItem6.param("fid", this.f48291e.y0.getForumId());
                                                                                                        statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        if (this.f48291e.y0.R0().O() != null) {
                                                                                                            statisticItem6.param("nid", this.f48291e.y0.R0().O().G0());
                                                                                                        }
                                                                                                        TiebaStatic.log(statisticItem6);
                                                                                                    } else if (id != c.a.t0.s2.i.forum_name_text && id != c.a.t0.s2.i.forum_enter_button_one && id != c.a.t0.s2.i.forum_enter_button_two && id != c.a.t0.s2.i.forum_enter_button_three) {
                                                                                                        if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                                                                            if (this.f48291e.y0 == null) {
                                                                                                                return;
                                                                                                            }
                                                                                                            StatisticItem statisticItem7 = new StatisticItem("c13398");
                                                                                                            statisticItem7.param("tid", this.f48291e.y0.h1());
                                                                                                            statisticItem7.param("fid", this.f48291e.y0.getForumId());
                                                                                                            statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                            statisticItem7.param("obj_locate", 2);
                                                                                                            TiebaStatic.log(statisticItem7);
                                                                                                        } else if (id == c.a.t0.s2.i.pb_thread_post_button) {
                                                                                                            if (this.f48291e.y0 == null || this.f48291e.y0.R0() == null) {
                                                                                                                return;
                                                                                                            }
                                                                                                            c.a.t0.s2.r.f R05 = this.f48291e.y0.R0();
                                                                                                            if (this.f48291e.D0 == null) {
                                                                                                                PbFragment pbFragment2 = this.f48291e;
                                                                                                                pbFragment2.D0 = new c.a.t0.s2.r.v(pbFragment2.getPageContext());
                                                                                                            }
                                                                                                            long g2 = c.a.d.f.m.b.g(R05.Q(), 0L);
                                                                                                            long g3 = c.a.d.f.m.b.g(R05.m(), 0L);
                                                                                                            new StatisticItem("c13446").param("forum_id", g3).eventStat();
                                                                                                            PbFragment pbFragment3 = this.f48291e;
                                                                                                            pbFragment3.registerListener(pbFragment3.a2);
                                                                                                            this.f48291e.D0.a(g2, g3);
                                                                                                        } else if (id == c.a.t0.s2.i.pb_video_thread_smart_app_layout) {
                                                                                                            if (view.getTag() instanceof SmartApp) {
                                                                                                                SmartApp smartApp = (SmartApp) view.getTag();
                                                                                                                if (!c.a.t0.z.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
                                                                                                                    if (StringUtils.isNull(smartApp.h5_url)) {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    c.a.s0.m.a.m(this.f48291e.getActivity(), smartApp.h5_url);
                                                                                                                }
                                                                                                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.f48291e.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", smartApp.name).param("obj_id", smartApp.swan_app_id.longValue()).param("obj_source", AppletsCellView.PB_SHARE_CARD_LITE_PROGRAM_FROM).param("tid", this.f48291e.y0.h1()).param("obj_param1", smartApp.is_game.intValue()));
                                                                                                            }
                                                                                                        } else if (id == c.a.t0.s2.i.id_pb_business_promotion_wrapper) {
                                                                                                            if (!(view.getTag() instanceof c.a.s0.s.q.d2)) {
                                                                                                                return;
                                                                                                            }
                                                                                                            c.a.s0.s.q.d2 d2Var = (c.a.s0.s.q.d2) view.getTag();
                                                                                                            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f48291e.getActivity()).createNormalCfg(d2Var.a0(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                            createNormalCfg.setCallFrom(14);
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 9).param("obj_locate", 9).param("obj_id", d2Var.U()).param("tid", d2Var.g0()).param("thread_type", d2Var.r1()).param(TiebaStatic.Params.IS_ZP, d2Var.M2() ? 1 : 0));
                                                                                                        } else if (id == c.a.t0.s2.i.id_pb_business_promotion_attention) {
                                                                                                            if (!(view.getTag() instanceof c.a.s0.s.q.d2) || !this.f48291e.checkUpIsLogin()) {
                                                                                                                return;
                                                                                                            }
                                                                                                            c.a.s0.s.q.d2 d2Var2 = (c.a.s0.s.q.d2) view.getTag();
                                                                                                            if (this.f48291e.V != null) {
                                                                                                                this.f48291e.V.L(d2Var2.a0(), String.valueOf(d2Var2.U()));
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem("common_click").param("page_type", "a005").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param(TiebaStatic.Params.OBJ_AD_LOCATE, 10).param("obj_locate", 11).param("obj_id", d2Var2.U()).param("tid", d2Var2.g0()).param("thread_type", d2Var2.r1()).param(TiebaStatic.Params.IS_ZP, d2Var2.M2() ? 1 : 0));
                                                                                                        } else if (id == c.a.t0.s2.i.pb_floor_right_top_feedback || id == c.a.t0.s2.i.pb_post_op_more) {
                                                                                                            StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                                                            statisticItem8.param("tid", this.f48291e.y0.h1());
                                                                                                            statisticItem8.param("fid", this.f48291e.y0.getForumId());
                                                                                                            statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                            statisticItem8.param("obj_locate", 7);
                                                                                                            TiebaStatic.log(statisticItem8);
                                                                                                            PbFragment pbFragment4 = this.f48291e;
                                                                                                            pbFragment4.f48263f = false;
                                                                                                            pbFragment4.F2(view);
                                                                                                        }
                                                                                                    } else if (!(view.getTag() instanceof c.a.s0.s.q.d2)) {
                                                                                                        return;
                                                                                                    } else {
                                                                                                        c.a.s0.s.q.d2 d2Var3 = (c.a.s0.s.q.d2) view.getTag();
                                                                                                        if (this.f48291e.y0.Q0() == 3 && this.f48291e.isSimpleForum() && this.f48291e.y0.R0() != null && ListUtils.isEmpty(this.f48291e.y0.R0().p())) {
                                                                                                            this.f48291e.f48262e.finish();
                                                                                                        } else {
                                                                                                            FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.f48291e.getActivity()).createNormalCfg(d2Var3.a0(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                                                                                                            createNormalCfg2.setCallFrom(14);
                                                                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg2));
                                                                                                        }
                                                                                                        StatisticItem statisticItem9 = new StatisticItem("c13399");
                                                                                                        statisticItem9.param("tid", d2Var3.g0());
                                                                                                        statisticItem9.param("fid", d2Var3.U());
                                                                                                        statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                                        statisticItem9.param("nid", d2Var3.G0());
                                                                                                        TiebaStatic.log(statisticItem9);
                                                                                                    }
                                                                                                } else if (!this.f48291e.checkUpIsLogin()) {
                                                                                                    return;
                                                                                                } else {
                                                                                                    TiebaStatic.log(new StatisticItem("c11740"));
                                                                                                    if (view != null && view.getTag() != null) {
                                                                                                        SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                                                        PostData postData3 = (PostData) sparseArray5.get(c.a.t0.s2.i.tag_load_sub_data);
                                                                                                        if (id == c.a.t0.s2.i.replybtn_top_right || id == c.a.t0.s2.i.cover_reply_content_top_right) {
                                                                                                            TiebaStatic.log(new StatisticItem("c12006").param("tid", this.f48291e.y0.f48398f));
                                                                                                        }
                                                                                                        if (this.f48291e.K0 == null) {
                                                                                                            PbFragment pbFragment5 = this.f48291e;
                                                                                                            pbFragment5.K0 = new c.a.s0.s.s.j(pbFragment5.getContext());
                                                                                                            this.f48291e.K0.m(this.f48291e.X1);
                                                                                                        }
                                                                                                        ArrayList arrayList = new ArrayList();
                                                                                                        this.f48291e.isImage(view);
                                                                                                        if (this.f48291e.isImage(view) && this.f48291e.j1 != null) {
                                                                                                            this.f48291e.j1.t();
                                                                                                        }
                                                                                                        if (sparseArray5.get(c.a.t0.s2.i.tag_is_subpb) instanceof Boolean) {
                                                                                                            ((Boolean) sparseArray5.get(c.a.t0.s2.i.tag_is_subpb)).booleanValue();
                                                                                                        }
                                                                                                        boolean booleanValue = sparseArray5.get(c.a.t0.s2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray5.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue() : false;
                                                                                                        boolean booleanValue2 = sparseArray5.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue() : false;
                                                                                                        boolean booleanValue3 = sparseArray5.get(c.a.t0.s2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(c.a.t0.s2.i.tag_should_manage_visible)).booleanValue() : false;
                                                                                                        boolean booleanValue4 = sparseArray5.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue() : false;
                                                                                                        boolean booleanValue5 = sparseArray5.get(c.a.t0.s2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(c.a.t0.s2.i.tag_should_delete_visible)).booleanValue() : false;
                                                                                                        String str2 = sparseArray5.get(c.a.t0.s2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray5.get(c.a.t0.s2.i.tag_forbid_user_post_id) : null;
                                                                                                        boolean booleanValue6 = sparseArray5.get(c.a.t0.s2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray5.get(c.a.t0.s2.i.tag_is_self_post)).booleanValue() : false;
                                                                                                        if (postData3 != null) {
                                                                                                            if (postData3.N() != null && postData3.N().toString().length() > 0) {
                                                                                                                c.a.s0.s.s.g gVar8 = new c.a.s0.s.s.g(3, this.f48291e.getString(c.a.t0.s2.l.copy), this.f48291e.K0);
                                                                                                                SparseArray sparseArray6 = new SparseArray();
                                                                                                                sparseArray6.put(c.a.t0.s2.i.tag_clip_board, postData3);
                                                                                                                gVar8.f13917d.setTag(sparseArray6);
                                                                                                                arrayList.add(gVar8);
                                                                                                            }
                                                                                                            this.f48291e.o2 = postData3;
                                                                                                        }
                                                                                                        if (this.f48291e.y0.R0().r()) {
                                                                                                            String u = this.f48291e.y0.R0().u();
                                                                                                            if (postData3 != null && !c.a.d.f.p.m.isEmpty(u) && u.equals(postData3.G())) {
                                                                                                                z = true;
                                                                                                                if (!z) {
                                                                                                                    gVar4 = new c.a.s0.s.s.g(4, this.f48291e.getString(c.a.t0.s2.l.remove_mark), this.f48291e.K0);
                                                                                                                } else {
                                                                                                                    gVar4 = new c.a.s0.s.s.g(4, this.f48291e.getString(c.a.t0.s2.l.mark), this.f48291e.K0);
                                                                                                                }
                                                                                                                SparseArray sparseArray7 = new SparseArray();
                                                                                                                sparseArray7.put(c.a.t0.s2.i.tag_clip_board, this.f48291e.o2);
                                                                                                                sparseArray7.put(c.a.t0.s2.i.tag_is_subpb, Boolean.FALSE);
                                                                                                                gVar4.f13917d.setTag(sparseArray7);
                                                                                                                arrayList.add(gVar4);
                                                                                                                if (this.f48291e.mIsLogin) {
                                                                                                                    if (c.a.t0.s2.u.f.g1.a.h(this.f48291e.y0) || booleanValue3 || !booleanValue2) {
                                                                                                                        if (this.f48291e.h3(booleanValue) && TbadkCoreApplication.isLogin()) {
                                                                                                                            c.a.s0.s.s.g gVar9 = new c.a.s0.s.s.g(5, this.f48291e.getString(c.a.t0.s2.l.report_text), this.f48291e.K0);
                                                                                                                            gVar9.f13917d.setTag(str2);
                                                                                                                            arrayList.add(gVar9);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        c.a.s0.s.s.g gVar10 = new c.a.s0.s.s.g(5, this.f48291e.getString(c.a.t0.s2.l.mute_option), this.f48291e.K0);
                                                                                                                        SparseArray sparseArray8 = new SparseArray();
                                                                                                                        sparseArray8.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                                                                                                                        int i10 = c.a.t0.s2.i.tag_is_mem;
                                                                                                                        sparseArray8.put(i10, sparseArray5.get(i10));
                                                                                                                        int i11 = c.a.t0.s2.i.tag_user_mute_mute_userid;
                                                                                                                        sparseArray8.put(i11, sparseArray5.get(i11));
                                                                                                                        int i12 = c.a.t0.s2.i.tag_user_mute_mute_username;
                                                                                                                        sparseArray8.put(i12, sparseArray5.get(i12));
                                                                                                                        int i13 = c.a.t0.s2.i.tag_user_mute_mute_nameshow;
                                                                                                                        sparseArray8.put(i13, sparseArray5.get(i13));
                                                                                                                        int i14 = c.a.t0.s2.i.tag_user_mute_post_id;
                                                                                                                        sparseArray8.put(i14, sparseArray5.get(i14));
                                                                                                                        int i15 = c.a.t0.s2.i.tag_user_mute_thread_id;
                                                                                                                        sparseArray8.put(i15, sparseArray5.get(i15));
                                                                                                                        int i16 = c.a.t0.s2.i.tag_del_post_is_self;
                                                                                                                        sparseArray8.put(i16, sparseArray5.get(i16));
                                                                                                                        int i17 = c.a.t0.s2.i.tag_del_post_type;
                                                                                                                        sparseArray8.put(i17, sparseArray5.get(i17));
                                                                                                                        int i18 = c.a.t0.s2.i.tag_del_post_id;
                                                                                                                        sparseArray8.put(i18, sparseArray5.get(i18));
                                                                                                                        int i19 = c.a.t0.s2.i.tag_manage_user_identity;
                                                                                                                        sparseArray8.put(i19, sparseArray5.get(i19));
                                                                                                                        gVar4.f13917d.setTag(sparseArray8);
                                                                                                                        arrayList.add(gVar10);
                                                                                                                    }
                                                                                                                    if (booleanValue3) {
                                                                                                                        SparseArray sparseArray9 = new SparseArray();
                                                                                                                        sparseArray9.put(c.a.t0.s2.i.tag_should_manage_visible, Boolean.TRUE);
                                                                                                                        int i20 = c.a.t0.s2.i.tag_manage_user_identity;
                                                                                                                        sparseArray9.put(i20, sparseArray5.get(i20));
                                                                                                                        int i21 = c.a.t0.s2.i.tag_forbid_user_name;
                                                                                                                        sparseArray9.put(i21, sparseArray5.get(i21));
                                                                                                                        int i22 = c.a.t0.s2.i.tag_forbid_user_name_show;
                                                                                                                        sparseArray9.put(i22, sparseArray5.get(i22));
                                                                                                                        int i23 = c.a.t0.s2.i.tag_forbid_user_portrait;
                                                                                                                        sparseArray9.put(i23, sparseArray5.get(i23));
                                                                                                                        sparseArray9.put(c.a.t0.s2.i.tag_forbid_user_post_id, str2);
                                                                                                                        if (booleanValue4) {
                                                                                                                            sparseArray9.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                                                                                                                            int i24 = c.a.t0.s2.i.tag_is_mem;
                                                                                                                            sparseArray9.put(i24, sparseArray5.get(i24));
                                                                                                                            int i25 = c.a.t0.s2.i.tag_user_mute_mute_userid;
                                                                                                                            sparseArray9.put(i25, sparseArray5.get(i25));
                                                                                                                            int i26 = c.a.t0.s2.i.tag_user_mute_mute_username;
                                                                                                                            sparseArray9.put(i26, sparseArray5.get(i26));
                                                                                                                            int i27 = c.a.t0.s2.i.tag_user_mute_mute_nameshow;
                                                                                                                            sparseArray9.put(i27, sparseArray5.get(i27));
                                                                                                                            int i28 = c.a.t0.s2.i.tag_user_mute_post_id;
                                                                                                                            sparseArray9.put(i28, sparseArray5.get(i28));
                                                                                                                            int i29 = c.a.t0.s2.i.tag_user_mute_thread_id;
                                                                                                                            sparseArray9.put(i29, sparseArray5.get(i29));
                                                                                                                        } else {
                                                                                                                            sparseArray9.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        if (booleanValue5) {
                                                                                                                            sparseArray9.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.TRUE);
                                                                                                                            sparseArray9.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                                                                            int i30 = c.a.t0.s2.i.tag_del_post_id;
                                                                                                                            sparseArray9.put(i30, sparseArray5.get(i30));
                                                                                                                            int i31 = c.a.t0.s2.i.tag_del_post_type;
                                                                                                                            sparseArray9.put(i31, sparseArray5.get(i31));
                                                                                                                            int i32 = c.a.t0.s2.i.tag_has_sub_post;
                                                                                                                            sparseArray9.put(i32, sparseArray5.get(i32));
                                                                                                                            if (booleanValue6) {
                                                                                                                                c.a.s0.s.s.g gVar11 = new c.a.s0.s.s.g(6, this.f48291e.getString(c.a.t0.s2.l.delete), this.f48291e.K0);
                                                                                                                                gVar11.f13917d.setTag(sparseArray9);
                                                                                                                                gVar6 = gVar11;
                                                                                                                                gVar5 = new c.a.s0.s.s.g(7, this.f48291e.getString(c.a.t0.s2.l.bar_manager), this.f48291e.K0);
                                                                                                                                gVar5.f13917d.setTag(sparseArray9);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            sparseArray9.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.FALSE);
                                                                                                                        }
                                                                                                                        gVar6 = null;
                                                                                                                        gVar5 = new c.a.s0.s.s.g(7, this.f48291e.getString(c.a.t0.s2.l.bar_manager), this.f48291e.K0);
                                                                                                                        gVar5.f13917d.setTag(sparseArray9);
                                                                                                                    } else if (booleanValue5) {
                                                                                                                        SparseArray sparseArray10 = new SparseArray();
                                                                                                                        sparseArray10.put(c.a.t0.s2.i.tag_should_manage_visible, Boolean.FALSE);
                                                                                                                        sparseArray10.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                                                                                                                        sparseArray10.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.TRUE);
                                                                                                                        int i33 = c.a.t0.s2.i.tag_manage_user_identity;
                                                                                                                        sparseArray10.put(i33, sparseArray5.get(i33));
                                                                                                                        sparseArray10.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                                                                                                                        int i34 = c.a.t0.s2.i.tag_del_post_id;
                                                                                                                        sparseArray10.put(i34, sparseArray5.get(i34));
                                                                                                                        int i35 = c.a.t0.s2.i.tag_del_post_type;
                                                                                                                        sparseArray10.put(i35, sparseArray5.get(i35));
                                                                                                                        int i36 = c.a.t0.s2.i.tag_has_sub_post;
                                                                                                                        sparseArray10.put(i36, sparseArray5.get(i36));
                                                                                                                        if (this.f48291e.y0.R0().V() == 1002 && !booleanValue) {
                                                                                                                            gVar7 = new c.a.s0.s.s.g(6, this.f48291e.getString(c.a.t0.s2.l.report_text), this.f48291e.K0);
                                                                                                                        } else {
                                                                                                                            gVar7 = new c.a.s0.s.s.g(6, this.f48291e.getString(c.a.t0.s2.l.delete), this.f48291e.K0);
                                                                                                                        }
                                                                                                                        gVar7.f13917d.setTag(sparseArray10);
                                                                                                                        gVar6 = gVar7;
                                                                                                                        gVar5 = null;
                                                                                                                    } else {
                                                                                                                        gVar5 = null;
                                                                                                                        gVar6 = null;
                                                                                                                    }
                                                                                                                    if (gVar6 != null) {
                                                                                                                        arrayList.add(gVar6);
                                                                                                                    }
                                                                                                                    if (gVar5 != null) {
                                                                                                                        arrayList.add(gVar5);
                                                                                                                    }
                                                                                                                }
                                                                                                                this.f48291e.K0.j(arrayList);
                                                                                                                this.f48291e.J0 = new PopupDialog(this.f48291e.getPageContext(), this.f48291e.K0);
                                                                                                                this.f48291e.J0.showDialog();
                                                                                                            }
                                                                                                        }
                                                                                                        z = false;
                                                                                                        if (!z) {
                                                                                                        }
                                                                                                        SparseArray sparseArray72 = new SparseArray();
                                                                                                        sparseArray72.put(c.a.t0.s2.i.tag_clip_board, this.f48291e.o2);
                                                                                                        sparseArray72.put(c.a.t0.s2.i.tag_is_subpb, Boolean.FALSE);
                                                                                                        gVar4.f13917d.setTag(sparseArray72);
                                                                                                        arrayList.add(gVar4);
                                                                                                        if (this.f48291e.mIsLogin) {
                                                                                                        }
                                                                                                        this.f48291e.K0.j(arrayList);
                                                                                                        this.f48291e.J0 = new PopupDialog(this.f48291e.getPageContext(), this.f48291e.K0);
                                                                                                        this.f48291e.J0.showDialog();
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            this.f48291e.F0.f23665h.l();
                                                                                            this.f48291e.F0.r3(this.f48291e.r2);
                                                                                        }
                                                                                    } else if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                                                                                        this.f48291e.sendMessage(new CustomMessage(2002001, new PushThreadActivityConfig(this.f48291e.getPageContext().getPageActivity(), 24008, c.a.d.f.m.b.g(this.f48291e.y0.R0().m(), 0L), c.a.d.f.m.b.g(this.f48291e.y0.h1(), 0L), c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccountInfo().getID(), 0L), this.f48291e.y0.R0().O().P0())));
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        sparseArray = (SparseArray) view.getTag();
                                                                                    } catch (ClassCastException e2) {
                                                                                        e2.printStackTrace();
                                                                                        sparseArray = null;
                                                                                    }
                                                                                    PostData postData4 = (PostData) sparseArray.get(c.a.t0.s2.i.tag_clip_board);
                                                                                    if (postData4 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (this.f48291e.K0 == null) {
                                                                                        PbFragment pbFragment6 = this.f48291e;
                                                                                        pbFragment6.K0 = new c.a.s0.s.s.j(pbFragment6.getContext());
                                                                                        this.f48291e.K0.m(this.f48291e.X1);
                                                                                    }
                                                                                    ArrayList arrayList2 = new ArrayList();
                                                                                    boolean z5 = this.f48291e.getPbModel().R0() != null && this.f48291e.getPbModel().R0().g0();
                                                                                    if (view != null && sparseArray != null) {
                                                                                        boolean booleanValue7 = sparseArray.get(c.a.t0.s2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue() : false;
                                                                                        boolean booleanValue8 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue() : false;
                                                                                        boolean booleanValue9 = sparseArray.get(c.a.t0.s2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_should_manage_visible)).booleanValue() : false;
                                                                                        boolean booleanValue10 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue() : false;
                                                                                        boolean booleanValue11 = sparseArray.get(c.a.t0.s2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_should_delete_visible)).booleanValue() : false;
                                                                                        String str3 = sparseArray.get(c.a.t0.s2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_forbid_user_post_id) : null;
                                                                                        boolean booleanValue12 = sparseArray.get(c.a.t0.s2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_is_self_post)).booleanValue() : false;
                                                                                        if (postData4.q() != null) {
                                                                                            boolean z6 = postData4.q().hasAgree;
                                                                                            int s = postData4.s();
                                                                                            if (z6 && s == 5) {
                                                                                                pbFragment = this.f48291e;
                                                                                                i2 = c.a.t0.s2.l.action_cancel_dislike;
                                                                                            } else {
                                                                                                pbFragment = this.f48291e;
                                                                                                i2 = c.a.t0.s2.l.action_dislike;
                                                                                            }
                                                                                            c.a.s0.s.s.g gVar12 = new c.a.s0.s.s.g(8, pbFragment.getString(i2), this.f48291e.K0);
                                                                                            SparseArray sparseArray11 = new SparseArray();
                                                                                            sparseArray11.put(c.a.t0.s2.i.tag_clip_board, postData4);
                                                                                            gVar12.f13917d.setTag(sparseArray11);
                                                                                            arrayList2.add(gVar12);
                                                                                        }
                                                                                        if (this.f48291e.mIsLogin) {
                                                                                            if (c.a.t0.s2.u.f.g1.a.h(this.f48291e.y0) || booleanValue9 || !booleanValue8) {
                                                                                                if ((this.f48291e.h3(booleanValue7) && TbadkCoreApplication.isLogin()) && !z5) {
                                                                                                    c.a.s0.s.s.g gVar13 = new c.a.s0.s.s.g(5, this.f48291e.getString(c.a.t0.s2.l.report_text), this.f48291e.K0);
                                                                                                    gVar13.f13917d.setTag(str3);
                                                                                                    arrayList2.add(gVar13);
                                                                                                }
                                                                                            } else {
                                                                                                c.a.s0.s.s.g gVar14 = new c.a.s0.s.s.g(5, this.f48291e.getString(c.a.t0.s2.l.mute_option), this.f48291e.K0);
                                                                                                SparseArray sparseArray12 = new SparseArray();
                                                                                                sparseArray12.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                                                                                                int i37 = c.a.t0.s2.i.tag_is_mem;
                                                                                                sparseArray12.put(i37, sparseArray.get(i37));
                                                                                                int i38 = c.a.t0.s2.i.tag_user_mute_mute_userid;
                                                                                                sparseArray12.put(i38, sparseArray.get(i38));
                                                                                                int i39 = c.a.t0.s2.i.tag_user_mute_mute_username;
                                                                                                sparseArray12.put(i39, sparseArray.get(i39));
                                                                                                int i40 = c.a.t0.s2.i.tag_user_mute_mute_nameshow;
                                                                                                sparseArray12.put(i40, sparseArray.get(i40));
                                                                                                int i41 = c.a.t0.s2.i.tag_user_mute_post_id;
                                                                                                sparseArray12.put(i41, sparseArray.get(i41));
                                                                                                int i42 = c.a.t0.s2.i.tag_user_mute_thread_id;
                                                                                                sparseArray12.put(i42, sparseArray.get(i42));
                                                                                                int i43 = c.a.t0.s2.i.tag_del_post_is_self;
                                                                                                sparseArray12.put(i43, sparseArray.get(i43));
                                                                                                int i44 = c.a.t0.s2.i.tag_del_post_type;
                                                                                                sparseArray12.put(i44, sparseArray.get(i44));
                                                                                                int i45 = c.a.t0.s2.i.tag_del_post_id;
                                                                                                sparseArray12.put(i45, sparseArray.get(i45));
                                                                                                int i46 = c.a.t0.s2.i.tag_manage_user_identity;
                                                                                                sparseArray12.put(i46, sparseArray.get(i46));
                                                                                                gVar14.f13917d.setTag(sparseArray12);
                                                                                                arrayList2.add(gVar14);
                                                                                            }
                                                                                            if (booleanValue9) {
                                                                                                SparseArray sparseArray13 = new SparseArray();
                                                                                                sparseArray13.put(c.a.t0.s2.i.tag_should_manage_visible, Boolean.TRUE);
                                                                                                int i47 = c.a.t0.s2.i.tag_manage_user_identity;
                                                                                                sparseArray13.put(i47, sparseArray.get(i47));
                                                                                                int i48 = c.a.t0.s2.i.tag_forbid_user_name;
                                                                                                sparseArray13.put(i48, sparseArray.get(i48));
                                                                                                int i49 = c.a.t0.s2.i.tag_forbid_user_name_show;
                                                                                                sparseArray13.put(i49, sparseArray.get(i49));
                                                                                                int i50 = c.a.t0.s2.i.tag_forbid_user_portrait;
                                                                                                sparseArray13.put(i50, sparseArray.get(i50));
                                                                                                sparseArray13.put(c.a.t0.s2.i.tag_forbid_user_post_id, str3);
                                                                                                if (booleanValue10) {
                                                                                                    sparseArray13.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                                                                                                    int i51 = c.a.t0.s2.i.tag_is_mem;
                                                                                                    sparseArray13.put(i51, sparseArray.get(i51));
                                                                                                    int i52 = c.a.t0.s2.i.tag_user_mute_mute_userid;
                                                                                                    sparseArray13.put(i52, sparseArray.get(i52));
                                                                                                    int i53 = c.a.t0.s2.i.tag_user_mute_mute_username;
                                                                                                    sparseArray13.put(i53, sparseArray.get(i53));
                                                                                                    int i54 = c.a.t0.s2.i.tag_user_mute_mute_nameshow;
                                                                                                    sparseArray13.put(i54, sparseArray.get(i54));
                                                                                                    int i55 = c.a.t0.s2.i.tag_user_mute_post_id;
                                                                                                    sparseArray13.put(i55, sparseArray.get(i55));
                                                                                                    int i56 = c.a.t0.s2.i.tag_user_mute_thread_id;
                                                                                                    sparseArray13.put(i56, sparseArray.get(i56));
                                                                                                } else {
                                                                                                    sparseArray13.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                                                                                                }
                                                                                                if (booleanValue11) {
                                                                                                    sparseArray13.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.TRUE);
                                                                                                    sparseArray13.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue7));
                                                                                                    int i57 = c.a.t0.s2.i.tag_del_post_id;
                                                                                                    sparseArray13.put(i57, sparseArray.get(i57));
                                                                                                    int i58 = c.a.t0.s2.i.tag_del_post_type;
                                                                                                    sparseArray13.put(i58, sparseArray.get(i58));
                                                                                                    int i59 = c.a.t0.s2.i.tag_has_sub_post;
                                                                                                    sparseArray13.put(i59, sparseArray.get(i59));
                                                                                                    if (booleanValue12) {
                                                                                                        c.a.s0.s.s.g gVar15 = new c.a.s0.s.s.g(6, this.f48291e.getString(c.a.t0.s2.l.delete), this.f48291e.K0);
                                                                                                        gVar15.f13917d.setTag(sparseArray13);
                                                                                                        gVar2 = gVar15;
                                                                                                        gVar = new c.a.s0.s.s.g(7, this.f48291e.getString(c.a.t0.s2.l.bar_manager), this.f48291e.K0);
                                                                                                        gVar.f13917d.setTag(sparseArray13);
                                                                                                    }
                                                                                                } else {
                                                                                                    sparseArray13.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.FALSE);
                                                                                                }
                                                                                                gVar2 = null;
                                                                                                gVar = new c.a.s0.s.s.g(7, this.f48291e.getString(c.a.t0.s2.l.bar_manager), this.f48291e.K0);
                                                                                                gVar.f13917d.setTag(sparseArray13);
                                                                                            } else if (booleanValue11) {
                                                                                                SparseArray sparseArray14 = new SparseArray();
                                                                                                sparseArray14.put(c.a.t0.s2.i.tag_should_manage_visible, Boolean.FALSE);
                                                                                                sparseArray14.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                                                                                                sparseArray14.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.TRUE);
                                                                                                int i60 = c.a.t0.s2.i.tag_manage_user_identity;
                                                                                                sparseArray14.put(i60, sparseArray.get(i60));
                                                                                                sparseArray14.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue7));
                                                                                                int i61 = c.a.t0.s2.i.tag_del_post_id;
                                                                                                sparseArray14.put(i61, sparseArray.get(i61));
                                                                                                int i62 = c.a.t0.s2.i.tag_del_post_type;
                                                                                                sparseArray14.put(i62, sparseArray.get(i62));
                                                                                                int i63 = c.a.t0.s2.i.tag_has_sub_post;
                                                                                                sparseArray14.put(i63, sparseArray.get(i63));
                                                                                                if (this.f48291e.y0.R0().V() == 1002 && !booleanValue7) {
                                                                                                    gVar3 = new c.a.s0.s.s.g(6, this.f48291e.getString(c.a.t0.s2.l.report_text), this.f48291e.K0);
                                                                                                } else {
                                                                                                    gVar3 = new c.a.s0.s.s.g(6, this.f48291e.getString(c.a.t0.s2.l.delete), this.f48291e.K0);
                                                                                                }
                                                                                                gVar3.f13917d.setTag(sparseArray14);
                                                                                                gVar2 = gVar3;
                                                                                                gVar = null;
                                                                                            } else {
                                                                                                gVar = null;
                                                                                                gVar2 = null;
                                                                                            }
                                                                                            if (gVar2 != null) {
                                                                                                arrayList2.add(gVar2);
                                                                                            }
                                                                                            if (gVar != null) {
                                                                                                arrayList2.add(gVar);
                                                                                            }
                                                                                        }
                                                                                        this.f48291e.K0.j(arrayList2);
                                                                                        this.f48291e.J0 = new PopupDialog(this.f48291e.getPageContext(), this.f48291e.K0);
                                                                                        this.f48291e.J0.showDialog();
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                if (view.getId() == c.a.t0.s2.i.new_sub_pb_list_richText) {
                                                                                    StatisticItem statisticItem10 = new StatisticItem("c13398");
                                                                                    statisticItem10.param("tid", this.f48291e.y0.h1());
                                                                                    statisticItem10.param("fid", this.f48291e.y0.getForumId());
                                                                                    statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                                    statisticItem10.param("obj_locate", 4);
                                                                                    TiebaStatic.log(statisticItem10);
                                                                                }
                                                                                if (view.getId() == c.a.t0.s2.i.pb_floor_reply_more && !DialogLoginHelper.checkUpIsLogin(new c.a.s0.s.q.t0(this.f48291e.getActivity(), "pb_chakanhuifu"))) {
                                                                                    this.f48291e.X = view;
                                                                                    return;
                                                                                } else if (this.f48291e.checkUpIsLogin()) {
                                                                                    if (this.f48291e.y0 == null || this.f48291e.y0.R0() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.f48291e.F0.c0();
                                                                                    SparseArray sparseArray15 = (SparseArray) view.getTag();
                                                                                    PostData postData5 = (PostData) sparseArray15.get(c.a.t0.s2.i.tag_load_sub_data);
                                                                                    PostData postData6 = (PostData) sparseArray15.get(c.a.t0.s2.i.tag_load_sub_reply_data);
                                                                                    View view2 = (View) sparseArray15.get(c.a.t0.s2.i.tag_load_sub_view);
                                                                                    if (postData5 == null || view2 == null) {
                                                                                        return;
                                                                                    }
                                                                                    if (postData5.E() == 1) {
                                                                                        TiebaStatic.log(new StatisticItem("c12630"));
                                                                                    }
                                                                                    StatisticItem statisticItem11 = postData5.g0;
                                                                                    if (statisticItem11 != null) {
                                                                                        StatisticItem copy3 = statisticItem11.copy();
                                                                                        copy3.delete("obj_locate");
                                                                                        if (view.getId() == c.a.t0.s2.i.new_sub_pb_list_richText) {
                                                                                            copy3.param("obj_locate", 6);
                                                                                        } else if (view.getId() == c.a.t0.s2.i.pb_floor_reply_more) {
                                                                                            copy3.param("obj_locate", 8);
                                                                                        }
                                                                                        TiebaStatic.log(copy3);
                                                                                    }
                                                                                    String h12 = this.f48291e.y0.h1();
                                                                                    String G2 = postData5.G();
                                                                                    String G3 = postData6 != null ? postData6.G() : "";
                                                                                    int V2 = this.f48291e.y0.R0() != null ? this.f48291e.y0.R0().V() : 0;
                                                                                    this.f48291e.stopVoice();
                                                                                    if (view.getId() == c.a.t0.s2.i.replybtn) {
                                                                                        AbsPbActivity.e t32 = this.f48291e.t3(G2);
                                                                                        if (this.f48291e.y0 == null || this.f48291e.y0.R0() == null || t32 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.f48291e.getPageContext().getPageActivity()).createSubPbActivityConfig(h12, G2, "pb", true, false, null, true, null, V2, postData5.S(), this.f48291e.y0.R0().d(), false, postData5.t().getIconInfo(), 5).addBigImageData(t32.a, t32.f48229b, t32.f48234g, t32.f48237j);
                                                                                        addBigImageData2.setKeyPageStartFrom(this.f48291e.y0.Q0());
                                                                                        addBigImageData2.setFromFrsForumId(this.f48291e.y0.getFromForumId());
                                                                                        addBigImageData2.setWorksInfoData(this.f48291e.y0.m1());
                                                                                        addBigImageData2.setKeyFromForumId(this.f48291e.y0.getForumId());
                                                                                        addBigImageData2.setBjhData(this.f48291e.y0.k0());
                                                                                        addBigImageData2.setTiebaPlusData(this.f48291e.y0.F(), this.f48291e.y0.B(), this.f48291e.y0.C(), this.f48291e.y0.A(), this.f48291e.y0.G());
                                                                                        this.f48291e.sendMessage(new CustomMessage(2002001, addBigImageData2));
                                                                                    } else {
                                                                                        TiebaStatic.log("c11742");
                                                                                        AbsPbActivity.e t33 = this.f48291e.t3(G2);
                                                                                        if (postData5 == null || this.f48291e.y0 == null || this.f48291e.y0.R0() == null || t33 == null) {
                                                                                            return;
                                                                                        }
                                                                                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.f48291e.getPageContext().getPageActivity()).createSubPbActivityConfig(h12, G2, "pb", true, false, null, false, G3, V2, postData5.S(), this.f48291e.y0.R0().d(), false, postData5.t().getIconInfo(), 5).addBigImageData(t33.a, t33.f48229b, t33.f48234g, t33.f48237j);
                                                                                        if (!c.a.d.f.p.m.isEmpty(G3)) {
                                                                                            addBigImageData3.setHighLightPostId(G3);
                                                                                            addBigImageData3.setKeyIsUseSpid(true);
                                                                                        }
                                                                                        addBigImageData3.setKeyFromForumId(this.f48291e.y0.getForumId());
                                                                                        addBigImageData3.setTiebaPlusData(this.f48291e.y0.F(), this.f48291e.y0.B(), this.f48291e.y0.C(), this.f48291e.y0.A(), this.f48291e.y0.G());
                                                                                        addBigImageData3.setBjhData(this.f48291e.y0.k0());
                                                                                        addBigImageData3.setKeyPageStartFrom(this.f48291e.y0.Q0());
                                                                                        addBigImageData3.setFromFrsForumId(this.f48291e.y0.getFromForumId());
                                                                                        addBigImageData3.setWorksInfoData(this.f48291e.y0.m1());
                                                                                        if (this.f48291e.F0 != null) {
                                                                                            addBigImageData3.setMainPostMaskVisibly(this.f48291e.F0.v0(this.f48291e.y0.K, this.f48291e.y0.f1()).U || postData5.U);
                                                                                        }
                                                                                        this.f48291e.sendMessage(new CustomMessage(2002001, addBigImageData3));
                                                                                    }
                                                                                } else {
                                                                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.f48291e.y0.R0().m()));
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (c.a.d.f.p.l.z()) {
                                                                            SparseArray<Object> F02 = this.f48291e.F0.F0(this.f48291e.y0.R0(), this.f48291e.y0.f1(), 1);
                                                                            if (F02 != null) {
                                                                                this.f48291e.F0.Z1(((Integer) F02.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) F02.get(c.a.t0.s2.i.tag_del_post_id), ((Integer) F02.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) F02.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue());
                                                                            }
                                                                            this.f48291e.F0.f23665h.k();
                                                                            if (this.f48291e.getPbModel() != null && this.f48291e.getPbModel().R0() != null && this.f48291e.getPbModel().R0().O() != null) {
                                                                                c.a.s0.s.q.d2 O = this.f48291e.getPbModel().R0().O();
                                                                                StatisticItem statisticItem12 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                                                                statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                                                statisticItem12.param("tid", O.g0());
                                                                                statisticItem12.param("fid", O.U());
                                                                                statisticItem12.param("fname", O.a0());
                                                                                TiebaStatic.log(statisticItem12);
                                                                                StatisticItem statisticItem13 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                                                                statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                                                                statisticItem13.param("tid", O.g0());
                                                                                statisticItem13.param("fid", O.U());
                                                                                statisticItem13.param("fname", O.a0());
                                                                                statisticItem13.param("obj_source", 3);
                                                                                TiebaStatic.log(statisticItem13);
                                                                            }
                                                                        } else {
                                                                            this.f48291e.showToast(c.a.t0.s2.l.network_not_available);
                                                                            return;
                                                                        }
                                                                    } else if (c.a.d.f.p.l.z()) {
                                                                        this.f48291e.F0.c0();
                                                                        SparseArray<Object> F03 = this.f48291e.F0.F0(this.f48291e.y0.R0(), this.f48291e.y0.f1(), 1);
                                                                        if (F03 == null) {
                                                                            return;
                                                                        }
                                                                        this.f48291e.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f48291e.getPageContext().getPageActivity(), this.f48291e.y0.R0().l().getId(), this.f48291e.y0.R0().l().getName(), this.f48291e.y0.R0().O().g0(), String.valueOf(this.f48291e.y0.R0().U().getUserId()), (String) F03.get(c.a.t0.s2.i.tag_forbid_user_name), (String) F03.get(c.a.t0.s2.i.tag_forbid_user_name_show), (String) F03.get(c.a.t0.s2.i.tag_forbid_user_post_id), (String) F03.get(c.a.t0.s2.i.tag_forbid_user_portrait))));
                                                                    } else {
                                                                        this.f48291e.showToast(c.a.t0.s2.l.network_not_available);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                                                                    if (skinType == 1) {
                                                                        this.f48291e.onChangeSkinType(skinType);
                                                                        SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                                                    } else if (skinType == 0 || skinType == 4) {
                                                                        UtilHelper.showSkinChangeAnimation(this.f48291e.getActivity());
                                                                        this.f48291e.onChangeSkinType(skinType);
                                                                        UtilHelper.setNavigationBarBackground(this.f48291e.getActivity(), this.f48291e.getResources().getColor(c.a.t0.s2.f.CAM_X0201_1));
                                                                        TbadkCoreApplication.getInst().setSkinType(1);
                                                                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                                                    }
                                                                    this.f48291e.F0.f23665h.l();
                                                                }
                                                            } else if (this.f48291e.y0 == null || this.f48291e.y0.R0() == null || this.f48291e.y0.R0().O() == null) {
                                                                return;
                                                            } else {
                                                                this.f48291e.F0.f23665h.k();
                                                                TiebaStatic.log(new StatisticItem("c13062"));
                                                                PbFragment pbFragment7 = this.f48291e;
                                                                pbFragment7.X2(pbFragment7.y0.R0().O().X());
                                                            }
                                                        } else {
                                                            this.f48291e.F0.c0();
                                                            if (c.a.d.f.p.l.z()) {
                                                                if (this.f48291e.m) {
                                                                    view.setTag(Integer.valueOf(this.f48291e.y0.d1()));
                                                                    return;
                                                                }
                                                                this.f48291e.stopVoice();
                                                                this.f48291e.F0.Q2();
                                                                PopupDialog popupDialog = new PopupDialog(this.f48291e.getPageContext());
                                                                if (this.f48291e.y0.R0().f23038f == null || this.f48291e.y0.R0().f23038f.size() <= 0) {
                                                                    strArr = new String[]{this.f48291e.getResources().getString(c.a.t0.s2.l.sort_type_new), this.f48291e.getResources().getString(c.a.t0.s2.l.sort_type_old)};
                                                                } else {
                                                                    strArr = new String[this.f48291e.y0.R0().f23038f.size()];
                                                                    for (int i64 = 0; i64 < this.f48291e.y0.R0().f23038f.size(); i64++) {
                                                                        strArr[i64] = this.f48291e.y0.R0().f23038f.get(i64).sort_name + this.f48291e.getResources().getString(c.a.t0.s2.l.sort_static);
                                                                    }
                                                                }
                                                                popupDialog.setDefaultContentView(null, strArr, new a(this, popupDialog, view));
                                                                popupDialog.showDialog();
                                                            } else {
                                                                this.f48291e.showToast(c.a.t0.s2.l.network_not_available);
                                                                return;
                                                            }
                                                        }
                                                    } else {
                                                        this.f48291e.F0.c0();
                                                        if (this.f48291e.getPbModel().R0().f23039g != 2) {
                                                            if (this.f48291e.y0.P0() != null) {
                                                                this.f48291e.F0.w3(this.f48291e.y0.P0(), this.f48291e.mDialogClickListener);
                                                            }
                                                            TiebaStatic.eventStat(this.f48291e.getPageContext().getPageActivity(), "pb_skip_page", "pbclick", 1, new Object[0]);
                                                        } else {
                                                            this.f48291e.showToast(c.a.t0.s2.l.hot_sort_jump_hint);
                                                            return;
                                                        }
                                                    }
                                                } else if (!(ShareSwitch.isOn() || this.f48291e.checkUpIsLogin()) || (R0 = this.f48291e.y0.R0()) == null) {
                                                    return;
                                                } else {
                                                    c.a.s0.s.q.d2 O2 = R0.O();
                                                    if (O2 != null && O2.J() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f48291e.y0.f48398f).param("fid", R0.m()).param("obj_locate", 4).param("uid", O2.J().getUserId()));
                                                    }
                                                    if (O2 != null) {
                                                        if (O2.P1()) {
                                                            i5 = 2;
                                                        } else if (O2.S1()) {
                                                            i5 = 3;
                                                        } else if (O2.Q1()) {
                                                            i5 = 4;
                                                        } else if (O2.R1()) {
                                                            i5 = 5;
                                                        }
                                                        StatisticItem statisticItem14 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                        statisticItem14.param("tid", this.f48291e.y0.h1());
                                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem14.param("fid", this.f48291e.y0.getForumId());
                                                        if (view.getId() != c.a.t0.s2.i.share_num_container) {
                                                            statisticItem14.param("obj_locate", 5);
                                                        } else {
                                                            statisticItem14.param("obj_locate", 6);
                                                        }
                                                        statisticItem14.param("obj_name", i5);
                                                        statisticItem14.param("obj_type", 1);
                                                        if (O2 != null) {
                                                            if (O2.P1()) {
                                                                statisticItem14.param("obj_type", 10);
                                                            } else if (O2.S1()) {
                                                                statisticItem14.param("obj_type", 9);
                                                            } else if (O2.R1()) {
                                                                statisticItem14.param("obj_type", 8);
                                                            } else if (O2.Q1()) {
                                                                statisticItem14.param("obj_type", 7);
                                                            } else if (O2.B1) {
                                                                statisticItem14.param("obj_type", 6);
                                                            } else {
                                                                int i65 = O2.d0;
                                                                if (i65 == 0) {
                                                                    statisticItem14.param("obj_type", 1);
                                                                } else if (i65 == 40) {
                                                                    statisticItem14.param("obj_type", 2);
                                                                } else if (i65 == 49) {
                                                                    statisticItem14.param("obj_type", 3);
                                                                } else if (i65 == 54) {
                                                                    statisticItem14.param("obj_type", 4);
                                                                } else {
                                                                    statisticItem14.param("obj_type", 5);
                                                                }
                                                            }
                                                            statisticItem14.param("card_type", O2.R0());
                                                            statisticItem14.param("recom_source", O2.Z0);
                                                            statisticItem14.param("ab_tag", O2.b1);
                                                            statisticItem14.param("weight", O2.a1);
                                                            statisticItem14.param("extra", O2.c1);
                                                            statisticItem14.param("nid", O2.G0());
                                                            if (O2.L() != null && !c.a.d.f.p.m.isEmpty(O2.L().oriUgcVid)) {
                                                                statisticItem14.param(TiebaStatic.Params.OBJ_PARAM6, O2.L().oriUgcVid);
                                                            }
                                                        }
                                                        if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                            statisticItem14.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                                        }
                                                        if (this.f48291e.getPbActivity() != null) {
                                                            c.a.s0.p0.c.e(this.f48291e.getPbActivity(), statisticItem14);
                                                        }
                                                        if (this.f48291e.F0 != null) {
                                                            statisticItem14.param("obj_param1", this.f48291e.F0.A0());
                                                        }
                                                        TiebaStatic.log(statisticItem14);
                                                        if (c.a.d.f.p.n.C()) {
                                                            this.f48291e.showToast(c.a.t0.s2.l.neterror);
                                                            return;
                                                        } else if (R0 != null) {
                                                            ArrayList<PostData> F2 = this.f48291e.y0.R0().F();
                                                            if ((F2 != null && F2.size() > 0) || !this.f48291e.y0.f1()) {
                                                                this.f48291e.F0.c0();
                                                                this.f48291e.stopVoice();
                                                                if (R0.A() != null && !StringUtils.isNull(R0.A().a(), true)) {
                                                                    TiebaStatic.log(new StatisticItem("c11678").param("fid", this.f48291e.y0.R0().m()));
                                                                }
                                                                TiebaStatic.log(new StatisticItem("c11939"));
                                                                if (AntiHelper.e(this.f48291e.getContext(), O2)) {
                                                                    return;
                                                                }
                                                                if (this.f48291e.F0 != null) {
                                                                    this.f48291e.F0.e0();
                                                                    this.f48291e.F0.H3(R0);
                                                                }
                                                                if (!ShareSwitch.isOn()) {
                                                                    this.f48291e.F0.k3();
                                                                    this.f48291e.y0.m0().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                                                                } else {
                                                                    if (view.getId() == c.a.t0.s2.i.pb_editor_tool_share) {
                                                                        i6 = 2;
                                                                    } else {
                                                                        i6 = view.getId() == c.a.t0.s2.i.share_num_container ? 1 : 6;
                                                                    }
                                                                    if ((c.a.s0.b.d.Z() || c.a.s0.b.d.a0()) && this.f48291e.F0.H1() && !R0.j0()) {
                                                                        int A0 = this.f48291e.F0.A0();
                                                                        this.f48291e.F0.R();
                                                                        this.f48291e.Z2(c.a.s0.t.g.f.a(), A0);
                                                                    } else {
                                                                        this.f48291e.R3(i6);
                                                                    }
                                                                }
                                                            } else {
                                                                c.a.d.f.p.n.M(this.f48291e.getPageContext().getPageActivity(), this.f48291e.getPageContext().getString(c.a.t0.s2.l.pb_no_data_tips));
                                                                return;
                                                            }
                                                        } else {
                                                            c.a.d.f.p.n.M(this.f48291e.getPageContext().getPageActivity(), this.f48291e.getPageContext().getString(c.a.t0.s2.l.pb_no_data_tips));
                                                            return;
                                                        }
                                                    }
                                                    i5 = 1;
                                                    StatisticItem statisticItem142 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                                                    statisticItem142.param("tid", this.f48291e.y0.h1());
                                                    statisticItem142.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem142.param("fid", this.f48291e.y0.getForumId());
                                                    if (view.getId() != c.a.t0.s2.i.share_num_container) {
                                                    }
                                                    statisticItem142.param("obj_name", i5);
                                                    statisticItem142.param("obj_type", 1);
                                                    if (O2 != null) {
                                                    }
                                                    if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                                    }
                                                    if (this.f48291e.getPbActivity() != null) {
                                                    }
                                                    if (this.f48291e.F0 != null) {
                                                    }
                                                    TiebaStatic.log(statisticItem142);
                                                    if (c.a.d.f.p.n.C()) {
                                                    }
                                                }
                                            } else if (c.a.d.f.p.l.z()) {
                                                this.f48291e.F0.c0();
                                                if (this.f48291e.F0.f23665h.n() != null && view == this.f48291e.F0.f23665h.n().i() && !this.f48291e.F0.F1()) {
                                                    this.f48291e.F0.o2();
                                                }
                                                if (!this.f48291e.m) {
                                                    this.f48291e.stopVoice();
                                                    this.f48291e.F0.Q2();
                                                    if (view.getId() == c.a.t0.s2.i.floor_owner_reply) {
                                                        A2 = this.f48291e.y0.A2(true, this.f48291e.N2());
                                                    } else {
                                                        A2 = view.getId() == c.a.t0.s2.i.reply_title ? this.f48291e.y0.A2(false, this.f48291e.N2()) : this.f48291e.y0.z2(this.f48291e.N2());
                                                    }
                                                    view.setTag(Boolean.valueOf(A2));
                                                    if (A2) {
                                                        i7 = 1;
                                                        this.f48291e.F0.B2(true);
                                                        this.f48291e.F0.u3();
                                                        this.f48291e.m = true;
                                                        this.f48291e.F0.E2(true);
                                                    } else {
                                                        i7 = 1;
                                                    }
                                                    TiebaStatic.eventStat(this.f48291e.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i7, new Object[0]);
                                                } else {
                                                    view.setTag(Boolean.FALSE);
                                                    return;
                                                }
                                            } else {
                                                this.f48291e.showToast(c.a.t0.s2.l.network_not_available);
                                                view.setTag(Boolean.FALSE);
                                                return;
                                            }
                                        } else if (c.a.d.f.p.l.z()) {
                                            this.f48291e.F0.c0();
                                            if (view.getId() != c.a.t0.s2.i.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new c.a.s0.s.q.t0(this.f48291e.getActivity(), "pb_shoucang"))) {
                                                if (!this.f48291e.C2(11009) || this.f48291e.y0.i0(this.f48291e.F0.D0()) == null) {
                                                    return;
                                                }
                                                this.f48291e.o3();
                                                if (this.f48291e.y0.R0() != null && this.f48291e.y0.R0().O() != null && this.f48291e.y0.R0().O().J() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f48291e.y0.f48398f).param("fid", this.f48291e.y0.R0().m()).param("obj_locate", 3).param("uid", this.f48291e.y0.R0().O().J().getUserId()));
                                                }
                                                if (this.f48291e.y0.R0().O() != null && this.f48291e.y0.R0().O().J() != null && this.f48291e.y0.R0().O().J().getUserId() != null && this.f48291e.A0 != null) {
                                                    PbFragment pbFragment8 = this.f48291e;
                                                    int V22 = pbFragment8.V2(pbFragment8.y0.R0());
                                                    c.a.s0.s.q.d2 O3 = this.f48291e.y0.R0().O();
                                                    if (O3.P1()) {
                                                        i8 = 2;
                                                    } else if (!O3.S1()) {
                                                        if (O3.Q1()) {
                                                            i8 = 4;
                                                        } else {
                                                            i8 = O3.R1() ? 5 : 1;
                                                        }
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f48291e.y0.f48398f).param("obj_locate", 1).param("obj_id", this.f48291e.y0.R0().O().J().getUserId()).param("obj_type", !this.f48291e.A0.e()).param("obj_source", V22).param("obj_param1", i8));
                                                }
                                            } else {
                                                this.f48291e.Z = view;
                                                return;
                                            }
                                        } else {
                                            this.f48291e.showToast(c.a.t0.s2.l.network_not_available);
                                            return;
                                        }
                                    } else {
                                        TiebaStatic.eventStat(this.f48291e.getPageContext().getPageActivity(), "pb_header_forum_name", "pbclick", 1, new Object[0]);
                                        if (this.f48291e.y0.R0() != null && this.f48291e.y0.R0().O() != null && this.f48291e.y0.R0().O().H2() && this.f48291e.y0.R0().O().t1() != null) {
                                            TiebaStatic.log(new StatisticItem("c11922"));
                                        }
                                        if (this.f48291e.y0.getErrorNo() == 4) {
                                            if (!StringUtils.isNull(this.f48291e.y0.r0()) || this.f48291e.y0.h0() == null) {
                                                this.f48291e.f48262e.finish();
                                                return;
                                            }
                                            name2 = this.f48291e.y0.h0().f23029b;
                                        } else {
                                            name2 = this.f48291e.y0.R0().l().getName();
                                        }
                                        if (StringUtils.isNull(name2)) {
                                            this.f48291e.f48262e.finish();
                                            return;
                                        }
                                        String r03 = this.f48291e.y0.r0();
                                        FrsActivityConfig createNormalCfg3 = new FrsActivityConfig(this.f48291e.getPageContext().getPageActivity()).createNormalCfg(name2, FrsActivityConfig.FRS_FROM_PB);
                                        if (this.f48291e.y0.x0() && r03 != null && r03.equals(name2)) {
                                            this.f48291e.f48262e.finish();
                                        } else {
                                            this.f48291e.sendMessage(new CustomMessage(2003000, createNormalCfg3));
                                        }
                                    }
                                } else if (c.a.d.f.p.l.z()) {
                                    if (this.f48291e.y0.R0() == null || this.f48291e.B0.P()) {
                                        return;
                                    }
                                    this.f48291e.F0.c0();
                                    int i66 = (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().m()) ? (this.f48291e.F0.f23665h.n() == null || view != this.f48291e.F0.f23665h.n().l()) ? view == this.f48291e.F0.p0() ? 2 : 0 : this.f48291e.y0.R0().O().r0() == 1 ? 3 : 6 : this.f48291e.y0.R0().O().s0() == 1 ? 5 : 4;
                                    ForumData l = this.f48291e.y0.R0().l();
                                    String name3 = l.getName();
                                    String id2 = l.getId();
                                    String g0 = this.f48291e.y0.R0().O().g0();
                                    this.f48291e.F0.B3();
                                    this.f48291e.B0.T(id2, name3, g0, i66, this.f48291e.F0.q0());
                                } else {
                                    this.f48291e.showToast(c.a.t0.s2.l.network_not_available);
                                    return;
                                }
                            } else {
                                this.f48291e.F0.f23665h.l();
                                if (this.f48291e.y0 != null) {
                                    this.f48291e.q1.f(this.f48291e.y0.h1());
                                }
                                if (this.f48291e.y0 == null || !this.f48291e.y0.isPrivacy()) {
                                    this.f48291e.q1.b();
                                    int i67 = (TbSingleton.getInstance().mCanCallFans || this.f48291e.getPbModel() == null || this.f48291e.getPbModel().R0() == null || this.f48291e.getPbModel().R0().Q() == null || !this.f48291e.getPbModel().R0().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                    if (this.f48291e.getPbModel() != null && this.f48291e.getPbModel().R0() != null) {
                                        this.f48291e.q1.d(3, i67, this.f48291e.getPbModel().R0().Q());
                                    }
                                } else {
                                    this.f48291e.showToast(c.a.t0.s2.l.privacy_thread_can_not_use_call_fans);
                                    if (this.f48291e.getPbModel() == null || this.f48291e.getPbModel().R0() == null) {
                                        return;
                                    }
                                    this.f48291e.q1.d(3, 3, this.f48291e.getPbModel().R0().Q());
                                    return;
                                }
                            }
                        } else if (c.a.d.f.p.l.z()) {
                            this.f48291e.F0.c0();
                            this.f48291e.stopVoice();
                            this.f48291e.F0.Q2();
                            this.f48291e.F0.k3();
                            if (this.f48291e.F0.M0() != null) {
                                this.f48291e.F0.M0().setVisibility(8);
                            }
                            this.f48291e.y0.v2(1);
                            if (this.f48291e.f48266i != null) {
                                this.f48291e.f48266i.x();
                            }
                        } else {
                            this.f48291e.showToast(c.a.t0.s2.l.network_not_available);
                            return;
                        }
                    } else {
                        String str4 = (String) view.getTag(c.a.t0.s2.i.forum_name);
                        String str5 = (String) view.getTag(c.a.t0.s2.i.forum_id);
                        String str6 = (String) view.getTag(c.a.t0.s2.i.thread_id);
                        if (this.f48291e.V != null) {
                            this.f48291e.V.L(str4, str5);
                        }
                        TbPageTag l2 = c.a.s0.p0.c.l(this.f48291e.getContext());
                        c.a.t0.s2.u.f.g1.c.a("c14278", str5, str6, TbadkCoreApplication.getCurrentAccount(), l2 != null ? l2.locatePage : "");
                    }
                    if (this.f48291e.getPageContext().getString(c.a.t0.s2.l.pb_god_reply_title_tag).equals(view.getTag()) && view.getId() == c.a.t0.s2.i.reply_god_title_group) {
                        String M2 = this.f48291e.M2();
                        if (TextUtils.isEmpty(M2)) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.f48291e.getPageContext(), new String[]{M2});
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem15 = new StatisticItem("c13398");
                statisticItem15.param("tid", this.f48291e.y0.h1());
                statisticItem15.param("fid", this.f48291e.y0.getForumId());
                statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem15.param("obj_locate", 1);
                TiebaStatic.log(statisticItem15);
                if (this.f48291e.A) {
                    this.f48291e.A = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(c.a.t0.s2.i.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData7 = (PostData) obj;
                        if (this.f48291e.y0 == null || this.f48291e.y0.R0() == null || this.f48291e.getPbView().N0() == null || postData7.t() == null || postData7.A() == 1 || !this.f48291e.checkUpIsLogin()) {
                            return;
                        }
                        if (this.f48291e.getPbView().O0() != null) {
                            this.f48291e.getPbView().O0().c();
                        }
                        c.a.t0.s2.r.t tVar2 = new c.a.t0.s2.r.t();
                        tVar2.A(this.f48291e.y0.R0().l());
                        tVar2.E(this.f48291e.y0.R0().O());
                        tVar2.C(postData7);
                        this.f48291e.getPbView().N0().S(tVar2);
                        this.f48291e.getPbView().N0().setPostId(postData7.G());
                        this.f48291e.m3(view, postData7.t().getUserId(), "", postData7);
                        TiebaStatic.log("c11743");
                        c.a.t0.s2.w.a.b(this.f48291e.y0.R0(), postData7, postData7.f0, 8, 1);
                        if (this.f48291e.T0 != null) {
                            this.f48291e.F0.v2(this.f48291e.T0.C());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c2 implements c.a.d.f.k.c<ImageView> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
                    if (c.a.s0.s.k.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(c.a.t0.s2.h.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
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
                    foreDrawableImageView.setDefaultBgResource(c.a.t0.s2.f.common_color_10220);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g2 = c.a.s0.s.k.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(c.a.t0.s2.f.common_color_10220));
                if (g2) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(c.a.t0.s2.h.icon_click);
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
                    foreDrawableImageView.setDefaultBgResource(c.a.t0.s2.f.common_color_10220);
                    foreDrawableImageView.reset();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public interface c3 {
        void a(Object obj);
    }

    /* loaded from: classes12.dex */
    public class d implements c.a.s0.e1.s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48295b;

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
            this.f48295b = pbFragment;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 2);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f48295b.getContext(), this.a, shareItem, false));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d0 extends c.a.s0.k0.i<TipEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48296g;

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
            this.f48296g = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.k0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tipEvent)) == null) {
                if (tipEvent.pageId <= 0 || this.f48296g.f48262e.getPageId() != tipEvent.pageId) {
                    return true;
                }
                DefaultNavigationBarCoverTip.makeText(this.f48296g.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class d1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.y0 != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.y0.f48398f)) {
                this.a.Q3((PostWriteCallBackData) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d2 implements c.a.d.f.k.c<GifView> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
                if (c.a.s0.s.k.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(c.a.t0.s2.h.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(c.a.t0.s2.f.common_color_10220);
                gifView.onDestroy();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g2 = c.a.s0.s.k.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(c.a.t0.s2.f.common_color_10220));
                if (g2) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(c.a.t0.s2.h.icon_click);
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
                gifView.setDefaultBgResource(c.a.t0.s2.f.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public interface d3 {
    }

    /* loaded from: classes12.dex */
    public class e extends c.a.s0.e1.k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48297b;

        public e(PbFragment pbFragment, int i2) {
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
            this.f48297b = pbFragment;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel pbModel = this.f48297b.getPbModel();
                if (pbModel != null) {
                    pbModel.k2(this.a);
                }
                return c.a.t0.s2.u.f.g1.b.d(this.f48297b.L2(), 2, pbModel);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class e0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f48298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48299f;

        public e0(PbFragment pbFragment, Intent intent) {
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
            this.f48299f = pbFragment;
            this.f48298e = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.t0.s2.u.f.t0 t0Var = this.f48299f.F0;
                t0Var.T2("@" + this.f48298e.getStringExtra("big_pic_type") + " ");
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f48300e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e1 f48301f;

            public a(e1 e1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48301f = e1Var;
                this.f48300e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48301f.a.F0 == null || this.f48300e == null) {
                    return;
                }
                this.f48301f.a.F0.c2(this.f48300e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes12.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e1 e1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes12.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e1 f48302e;

            public c(e1 e1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48302e = e1Var;
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f48302e.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f48302e.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

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
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.s0.t.c.m0 m0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0.R0() != null) {
                        statisticItem.param("fid", this.a.y0.R0().m());
                    }
                    statisticItem.param("tid", this.a.y0.h1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    if (writeData != null) {
                        if (c.a.d.f.p.m.isEmpty(writeData.getAtUidListString())) {
                            statisticItem.param("obj_param1", "0");
                        } else {
                            statisticItem.param("obj_param1", "1");
                            statisticItem.param(TiebaStatic.Params.FRIEND_UID, writeData.getAtUidListString());
                        }
                    }
                    TiebaStatic.log(statisticItem);
                }
                this.a.stopVoice();
                this.a.F0.O2(z, postWriteCallBackData);
                int i2 = -1;
                if (postWriteCallBackData != null) {
                    i2 = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                boolean z2 = false;
                if (z) {
                    this.a.Q3(postWriteCallBackData);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.F3(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData == null || writeData.getType() != 2) {
                        if (this.a.y0.v0()) {
                            c.a.t0.s2.r.f R0 = this.a.y0.R0();
                            if (R0 != null && R0.O() != null && R0.O().J() != null && (userId = R0.O().J().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.y0.y2()) {
                                this.a.F0.Q2();
                            }
                        } else if (!PbReplySwitch.getInOn() && this.a.y0.y2()) {
                            this.a.F0.Q2();
                        }
                    } else if (floor != null) {
                        this.a.F0.t1(this.a.y0.R0());
                    }
                    if (this.a.y0.z0()) {
                        TiebaStatic.log(new StatisticItem("c10369").param("tid", this.a.y0.h1()));
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        c.a.d.f.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    PbFragment pbFragment = this.a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    pbFragment.z2(z2);
                    if (this.a.e3()) {
                        this.a.Z3();
                    }
                } else if (i2 == 220015) {
                    this.a.showToast(str);
                    if (this.a.T0.B() || this.a.T0.D()) {
                        this.a.T0.z(false, postWriteCallBackData);
                    }
                    this.a.mContentProcessController.k(postWriteCallBackData);
                } else if (i2 == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.a.getActivity(), this.a.getActivity().getString(c.a.t0.s2.l.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getActivity());
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.a.getActivity().getString(c.a.t0.s2.l.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(c.a.t0.s2.l.cancel, new b(this));
                    aVar.setPositiveButton(c.a.t0.s2.l.open_now, new c(this));
                    aVar.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (c.a.t0.g4.a.c(i2) || m0Var != null || i2 == 227001) {
                } else {
                    this.a.E3(i2, antiData, str);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e2 implements c.a.s0.x.y.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.s0.x.y.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.t0.s2.u.f.v0 v0Var = this.a.mContentProcessController;
                if (v0Var == null || v0Var.g() == null || !this.a.mContentProcessController.g().d()) {
                    return !this.a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.mContentProcessController.g().c());
                if (this.a.F0 != null && this.a.F0.O0() != null && this.a.F0.O0().b() != null && this.a.F0.O0().b().x()) {
                    this.a.F0.O0().b().v(this.a.mContentProcessController.h());
                }
                this.a.mContentProcessController.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class f implements c.a.s0.e1.s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f48303b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48304c;

        public f(PbFragment pbFragment, int i2, int i3) {
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
            this.f48304c = pbFragment;
            this.a = i2;
            this.f48303b = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.e1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.k(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f48304c.getContext(), this.f48303b, shareItem, false));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.T0.L(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.F0 != null && this.a.F0.O0() != null && this.a.F0.O0().b() != null) {
                    this.a.F0.O0().b().F();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    PbFragment pbFragment = this.a;
                    pbFragment.w3(pbFragment.Y0);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f1 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f48305e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f1 f48306f;

            public a(f1 f1Var, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f1Var, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48306f = f1Var;
                this.f48305e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48306f.a.F0 == null || this.f48305e == null) {
                    return;
                }
                this.f48306f.a.F0.c2(this.f48305e.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes12.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(f1 f1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes12.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f1 f48307e;

            public c(f1 f1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48307e = f1Var;
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f48307e.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f48307e.a.getActivity(), 0, 26, 2)));
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.s0.t.c.m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.y0 != null && this.a.y0.R0() != null) {
                        statisticItem.param("fid", this.a.y0.R0().m());
                    }
                    if (this.a.y0 != null) {
                        statisticItem.param("tid", this.a.y0.h1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    c.a.t0.s2.u.f.v0 v0Var = this.a.mContentProcessController;
                    if (v0Var != null) {
                        v0Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        c.a.s0.t.h.b.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        c.a.d.f.m.e.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    if (this.a.e3()) {
                        this.a.Z3();
                        return;
                    }
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.mReplyPrivacyController;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.a.getActivity(), this.a.getActivity().getString(c.a.t0.s2.l.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.a.getActivity());
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.a.getActivity().getString(c.a.t0.s2.l.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(c.a.t0.s2.l.cancel, new b(this));
                    aVar.setPositiveButton(c.a.t0.s2.l.open_now, new c(this));
                    aVar.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                PbFragment pbFragment = this.a;
                if (pbFragment.mContentProcessController == null) {
                    return;
                }
                if (pbFragment.F0 != null && this.a.F0.O0() != null && this.a.F0.O0().b() != null && this.a.F0.O0().b().x()) {
                    this.a.F0.O0().b().v(postWriteCallBackData);
                }
                this.a.mContentProcessController.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f2 implements c.a.d.f.k.c<TiebaPlusRecommendCard> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TiebaPlusRecommendCard a(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            TiebaPlusRecommendCard tiebaPlusRecommendCard2 = tiebaPlusRecommendCard;
            e(tiebaPlusRecommendCard2);
            return tiebaPlusRecommendCard2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(TiebaPlusRecommendCard tiebaPlusRecommendCard) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tiebaPlusRecommendCard) == null) {
                tiebaPlusRecommendCard.resetData();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
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
                tiebaPlusRecommendCard.resetData();
                return tiebaPlusRecommendCard;
            }
            return (TiebaPlusRecommendCard) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.y0 == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.T0 != null) {
                this.a.F0.v2(this.a.T0.C());
            }
            this.a.F0.o2();
            this.a.F0.c0();
        }
    }

    /* loaded from: classes12.dex */
    public class g0 implements CheckRealNameModel.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.model.CheckRealNameModel.b
        public void a(int i2, String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, obj}) == null) {
                this.a.F0.g1();
                if (CheckRealNameModel.TYPE_PB_SHARE.equals(str2)) {
                    if (i2 == 0) {
                        Integer num = 0;
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        }
                        this.a.R3(num.intValue());
                    } else if (i2 == 1990055) {
                        TiebaStatic.log("c12142");
                        c.a.t0.k1.a.d();
                    } else {
                        if (StringUtils.isNull(str)) {
                            str = this.a.getResources().getString(c.a.t0.s2.l.neterror);
                        }
                        this.a.showToast(str);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g1 extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g1(PbFragment pbFragment, int i2, int i3) {
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
            this.a = pbFragment;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            PbThreadPostView X0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ThreadPublishHttpResMeesage) || (responsedMessage instanceof ThreadPublishSocketResMessage)) && responsedMessage.getOrginalMessage().getTag() != null && responsedMessage.getOrginalMessage().getTag().getId() == this.a.f48262e.getPageId()) {
                if (responsedMessage.getError() == 0) {
                    c.a.d.f.p.n.L(TbadkCoreApplication.getInst(), c.a.t0.s2.l.thread_distribute_success);
                    if (this.a.F0 == null || (X0 = this.a.F0.X0()) == null || this.a.F0.E0() == null) {
                        return;
                    }
                    this.a.F0.E0().removeHeaderView(X0);
                    return;
                }
                c.a.d.f.p.n.M(TbadkCoreApplication.getInst(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g2 implements c.a.d.f.k.c<View> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).reset();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(c.a.t0.s2.g.fontsize28);
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

    /* loaded from: classes12.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                this.a.y0.D2((UserPendantData) customResponsedMessage.getData());
                if (this.a.F0 != null && this.a.y0 != null) {
                    this.a.F0.i2(this.a.y0.R0(), this.a.y0.f1(), this.a.y0.b1(), this.a.F0.V0());
                }
                if (this.a.F0 == null || this.a.F0.n0() == null) {
                    return;
                }
                this.a.F0.n0().X();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h0 extends c.a.d.a.e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h1 implements PbModel.g {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2) {
            long j3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j2)}) == null) && c.a.s0.s0.k.d().g()) {
                long currentTimeMillis = !z2 ? System.currentTimeMillis() - this.a.r : j2;
                if (this.a.s == 0) {
                    this.a.s = currentTimeMillis;
                }
                long j4 = currentTimeMillis;
                c.a.s0.s0.h hVar = new c.a.s0.s0.h(i2, z, responsedMessage, this.a.v, this.a.u, this.a.s, z2, 0L, 0L, j4);
                this.a.u = 0L;
                this.a.v = 0L;
                hVar.c();
                if (z2) {
                    j3 = j4;
                    hVar.B = j3;
                    hVar.e(true);
                } else {
                    j3 = j4;
                }
                if (z2 || this.a.y0 == null || this.a.y0.R0() == null || this.a.y0.R0().O() == null) {
                    return;
                }
                int r1 = this.a.y0.R0().O().r1();
                if (r1 == 0 || r1 == 40) {
                    if (!StringHelper.equals(this.a.Q, "from_personalize")) {
                        if (StringHelper.equals(this.a.Q, "from_frs")) {
                            c.a.s0.s0.h hVar2 = new c.a.s0.s0.h();
                            hVar2.a(1000);
                            hVar2.D = j3;
                            hVar2.d(r1);
                            return;
                        }
                        return;
                    }
                    c.a.s0.s0.d dVar = new c.a.s0.s0.d();
                    dVar.F = 1;
                    dVar.a(1005);
                    dVar.D = j3;
                    dVar.d(r1);
                }
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(c.a.t0.s2.r.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
                this.a.F0.t1(fVar);
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, c.a.t0.s2.r.f fVar, String str, int i5) {
            c.a.s0.x.h findLauncherById;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fVar, str, Integer.valueOf(i5)}) == null) {
                if (!z || fVar == null || fVar.W() != null || ListUtils.getCount(fVar.F()) >= 1) {
                    if (!this.a.q0) {
                        this.a.q0 = true;
                    } else if (this.a.getPbModel() != null) {
                        this.a.getPbModel().Y();
                    }
                    this.a.l = true;
                    this.a.F0.P2();
                    if (fVar == null || !fVar.m0()) {
                        PbFragment pbFragment = this.a;
                        pbFragment.hideLoadingView(pbFragment.F0.a1());
                    }
                    this.a.F0.i1();
                    if (this.a.N || this.a.F0.F1()) {
                        this.a.F0.c1();
                    } else if (!this.a.F0.y1()) {
                        this.a.F0.c3(false);
                    }
                    if (this.a.m) {
                        this.a.m = false;
                    }
                    if (i5 == 0 && fVar != null) {
                        this.a.M0 = true;
                    }
                    if (fVar != null) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.hideNetRefreshView(pbFragment2.F0.a1());
                        this.a.F0.X2();
                    }
                    ArrayList<PostData> arrayList = null;
                    String R0 = null;
                    arrayList = null;
                    if (z && fVar != null) {
                        c.a.s0.s.q.d2 O = fVar.O();
                        if (O != null && O.G2()) {
                            d();
                        } else {
                            PbFragment pbFragment3 = this.a;
                            pbFragment3.B3(pbFragment3.S0);
                        }
                        this.a.F0.O0().m(fVar);
                        this.a.F0.j3();
                        if (O != null && O.M() != null) {
                            this.a.d4(O.M());
                        }
                        if (this.a.T0 != null) {
                            this.a.F0.v2(this.a.T0.C());
                        }
                        TbadkCoreApplication.getInst().setDefaultBubble(fVar.U().getBimg_url());
                        TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.U().getBimg_end_time());
                        if (fVar.F() != null && fVar.F().size() >= 1 && fVar.F().get(0) != null) {
                            this.a.y0.i2(fVar.F().get(0).G());
                        } else if (fVar.W() != null) {
                            this.a.y0.i2(fVar.W().G());
                        }
                        if (this.a.T0 != null) {
                            this.a.T0.M(fVar.d());
                            this.a.T0.N(fVar.l(), fVar.U());
                            this.a.T0.r0(O);
                            this.a.T0.O(this.a.y0.u0(), this.a.y0.h1(), this.a.y0.q0());
                            if (O != null) {
                                this.a.T0.h0(O.o2());
                            }
                        }
                        if (this.a.A0 != null) {
                            this.a.A0.h(fVar.r());
                        }
                        if (fVar.s() == 1) {
                            this.a.w = true;
                        } else {
                            this.a.w = false;
                        }
                        if (fVar.g0()) {
                            this.a.w = true;
                        }
                        this.a.F0.w2(this.a.w);
                        this.a.F0.n3(fVar, i3, i4, this.a.y0.f1(), i5, this.a.y0.B0());
                        this.a.F0.z3(fVar, this.a.y0.f1());
                        this.a.F0.E3(this.a.y0.v0());
                        AntiData d2 = fVar.d();
                        if (d2 != null) {
                            this.a.D = d2.getVoice_message();
                            if (!StringUtils.isNull(this.a.D) && this.a.T0 != null && this.a.T0.a() != null && (findLauncherById = this.a.T0.a().findLauncherById(6)) != null && !TextUtils.isEmpty(this.a.D)) {
                                ((View) findLauncherById).setOnClickListener(this.a.D1);
                            }
                        }
                        if (!this.a.c0 && !ListUtils.isEmpty(this.a.y0.R0().F()) && !this.a.y0.w1()) {
                            this.a.c0 = true;
                            this.a.checkEasterEgg(false);
                        }
                        if (!TextUtils.isEmpty(this.a.P0)) {
                            c.a.t0.s2.u.f.b1.k.f(this.a.getListView(), this.a.P0);
                            this.a.P0 = null;
                        } else if (this.a.O0) {
                            this.a.O0 = false;
                            c.a.t0.s2.u.f.b1.k.e(this.a.getListView());
                        } else if (this.a.Q0) {
                            this.a.Q0 = false;
                            c.a.t0.s2.u.f.b1.k.g(this.a.getListView());
                        } else {
                            this.a.F0.i3();
                        }
                        this.a.y0.E1(fVar.l(), this.a.H1);
                        this.a.y0.K1(this.a.J1);
                        if (this.a.mReplyPrivacyController != null && O != null && O.J() != null) {
                            AttentionHostData attentionHostData = new AttentionHostData();
                            attentionHostData.parserWithMetaData(O.J());
                            this.a.mReplyPrivacyController.setLikeUserData(attentionHostData);
                        }
                        if (this.a.y0 == null || !this.a.y0.t1()) {
                            if (this.a.F0 != null) {
                                R0 = this.a.F0.R0();
                            }
                        } else {
                            R0 = this.a.getPageContext().getString(c.a.t0.s2.l.pb_reply_hint_from_smart_frs);
                        }
                        if (!StringUtils.isNull(R0)) {
                            this.a.T0.k0(TbSingleton.getInstance().getAdVertiComment(fVar.k0(), fVar.l0(), R0));
                        }
                    } else if (str != null) {
                        if (this.a.M0 || i5 != 1) {
                            this.a.showToast(str);
                        } else if (i3 == 3 || i3 == 4 || i3 == 6) {
                            if (i2 == 4) {
                                if (this.a.y0.h0() != null && !StringUtils.isNull(this.a.y0.h0().f23030c)) {
                                    this.a.F0.G3(this.a.y0.h0());
                                } else {
                                    PbFragment pbFragment4 = this.a;
                                    pbFragment4.showNetRefreshView(pbFragment4.F0.a1(), this.a.getPageContext().getResources().getString(c.a.t0.s2.l.net_error_text, str, Integer.valueOf(i2)), true);
                                    PbFragment pbFragment5 = this.a;
                                    pbFragment5.setNetRefreshViewEmotionMarginTop(c.a.d.f.p.n.f(pbFragment5.getContext(), c.a.t0.s2.g.ds360));
                                }
                            } else {
                                PbFragment pbFragment6 = this.a;
                                pbFragment6.showNetRefreshView(pbFragment6.F0.a1(), this.a.getPageContext().getResources().getString(c.a.t0.s2.l.net_error_text, str, Integer.valueOf(i2)), true);
                                PbFragment pbFragment7 = this.a;
                                pbFragment7.setNetRefreshViewEmotionMarginTop(c.a.d.f.p.n.f(pbFragment7.getContext(), c.a.t0.s2.g.ds360));
                            }
                            this.a.F0.c1();
                            this.a.F0.b1();
                        }
                        if (i2 == 4 || i2 == 350008) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("tid", this.a.y0.h1());
                                jSONObject.put("fid", this.a.y0.getForumId());
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
                            if (this.a.y0 != null && this.a.y0.R0() != null) {
                                arrayList = this.a.y0.R0().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.F0.s2(this.a.getResources().getString(c.a.t0.s2.l.list_no_more_new));
                            } else {
                                if (this.a.isHostOnlyMode()) {
                                    this.a.F0.t2(this.a.getResources().getString(c.a.t0.s2.l.pb_no_host_reply));
                                } else {
                                    this.a.F0.t2(this.a.getResources().getString(c.a.t0.s2.l.pb_no_replay));
                                }
                                this.a.F0.t1(this.a.y0.R0());
                            }
                        } else {
                            this.a.F0.s2("");
                        }
                        this.a.F0.i0();
                    }
                    if (fVar != null && fVar.m && this.a.s == 0) {
                        this.a.s = System.currentTimeMillis() - this.a.r;
                    }
                    if (this.a.getPbModel().f1() && this.a.getPbModel().R0().y().c() == 0 && !this.a.getPbModel().s1()) {
                        return;
                    }
                    this.a.U0 = true;
                    return;
                }
                this.a.y0.v2(1);
                if (this.a.f48266i != null) {
                    this.a.f48266i.x();
                }
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.y0 == null) {
                return;
            }
            if (this.a.T0 == null || !this.a.T0.z) {
                c.a.s0.x.y.d dVar = new c.a.s0.x.y.d();
                this.a.B3(dVar);
                PbFragment pbFragment = this.a;
                pbFragment.T0 = (c.a.s0.x.y.e) dVar.a(pbFragment.getContext());
                this.a.T0.e0(this.a.f48262e.getPageContext());
                this.a.T0.n0(this.a.Z1);
                this.a.T0.o0(this.a.Z0);
                this.a.T0.F(this.a.f48262e.getPageContext(), this.a.f48262e.getIntent() == null ? null : this.a.f48262e.getIntent().getExtras());
                this.a.T0.a().showLinePositionBottom(true);
                this.a.F0.r2(this.a.T0.a());
                if (!this.a.y0.F0()) {
                    this.a.T0.s(this.a.y0.h1());
                }
                if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                    this.a.T0.k0(TbSingleton.getInstance().getAdVertiComment());
                } else if (this.a.y0.t1()) {
                    this.a.T0.k0(this.a.getPageContext().getString(c.a.t0.s2.l.pb_reply_hint_from_smart_frs));
                } else if (this.a.F0 != null) {
                    this.a.T0.k0(this.a.F0.R0());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h2 implements c.a.d.f.k.c<RelativeLayout> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
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

    /* loaded from: classes12.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
                this.a.F0.u3();
            } else {
                this.a.F0.i1();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i0 implements c3 {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.c3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!c.a.d.f.p.l.z()) {
                    this.a.showToast(c.a.t0.s2.l.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.y0.R0().l().getId(), this.a.y0.R0().l().getName(), this.a.y0.R0().O().g0(), String.valueOf(this.a.y0.R0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i1 implements c.a.s0.x.y.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.s0.x.y.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i2 implements c.a.d.f.k.c<ItemCardView> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ItemCardView a(ItemCardView itemCardView) {
            ItemCardView itemCardView2 = itemCardView;
            e(itemCardView2);
            return itemCardView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(ItemCardView itemCardView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, itemCardView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
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
                itemCardView.reset();
                return itemCardView;
            }
            return (ItemCardView) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.T0 != null) {
                this.a.F0.v2(this.a.T0.C());
            }
            this.a.F0.c3(false);
        }
    }

    /* loaded from: classes12.dex */
    public class j0 implements c.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    if (view != null) {
                        if (view.getId() == c.a.t0.s2.i.richText) {
                            if (this.a.richTextHandleSingleTap(view)) {
                                return true;
                            }
                        } else if (view.getId() == c.a.t0.s2.i.pb_floor_item_layout) {
                            if (view.getTag(c.a.t0.s2.i.tag_from) instanceof SparseArray) {
                                this.a.V3((SparseArray) view.getTag(c.a.t0.s2.i.tag_from));
                            }
                        } else if (!(view instanceof TbRichTextView) && view.getId() != c.a.t0.s2.i.pb_post_header_layout) {
                            if (this.a.F0.A1() && view.getId() == c.a.t0.s2.i.pb_head_user_info_root) {
                                if (view.getTag(c.a.t0.s2.i.tag_user_id) instanceof String) {
                                    TiebaStatic.log(new StatisticItem("c10630").param("obj_id", (String) view.getTag(c.a.t0.s2.i.tag_user_id)));
                                }
                                if (this.a.getEventController() != null && this.a.getEventController().f23414b != null) {
                                    this.a.getEventController().f23414b.onClick(view);
                                }
                            }
                        } else {
                            SparseArray sparseArray = view.getTag() instanceof SparseArray ? (SparseArray) view.getTag() : null;
                            if (sparseArray == null) {
                                return false;
                            }
                            this.a.V3(sparseArray);
                        }
                    }
                    if (this.a.T0 != null) {
                        this.a.F0.v2(this.a.T0.C());
                    }
                    this.a.F0.o2();
                    this.a.F0.c0();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.t0.s2.s.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.a.isAdded()) {
                    this.a.doDoubleClick();
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class j1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j1(PbFragment pbFragment, int i2) {
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.c4();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j2 implements TbRichTextView.y {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            c.a.t0.s2.u.f.h n0;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view.getTag() instanceof TbRichText) && str == null) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.F0.N1((TbRichText) view.getTag());
                            TiebaStatic.log(new StatisticItem("c12490"));
                            return;
                        }
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13398");
                    statisticItem.param("tid", this.a.y0.h1());
                    statisticItem.param("fid", this.a.y0.getForumId());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_locate", 3);
                    statisticItem.param("obj_type", z2 ? 1 : 2);
                    TiebaStatic.log(statisticItem);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pic_pb", "");
                    if (view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info) == null || !(view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        if (this.a.y0.K.g0()) {
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
                            this.a.K2(rect);
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList);
                            bVar.B(i3);
                            bVar.C(false);
                            bVar.F(this.a.y0.c1());
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(this.a.isHostOnlyMode());
                            bVar.M(rect, UtilHelper.fixedDrawableRect(rect, view));
                            if (this.a.y0 != null) {
                                bVar.A(this.a.y0.getFromForumId());
                                if (this.a.y0.R0() != null) {
                                    bVar.N(this.a.y0.R0().O());
                                }
                            }
                            ImageViewerConfig v = bVar.v(this.a.getPageContext().getPageActivity());
                            v.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, v));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                            return;
                        }
                        AbsPbActivity.e eVar = new AbsPbActivity.e();
                        this.a.s3(str, i2, eVar);
                        if (eVar.f48235h) {
                            TbRichText f4 = this.a.f4(str, i2);
                            if (f4 != null && this.a.l2 >= 0 && this.a.l2 < f4.y().size()) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                String a = c.a.t0.s2.r.g.a(f4.y().get(this.a.l2));
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= eVar.a.size()) {
                                        break;
                                    } else if (eVar.a.get(i7).equals(a)) {
                                        eVar.f48237j = i7;
                                        arrayList2.add(a);
                                        break;
                                    } else {
                                        i7++;
                                    }
                                }
                                if (f4.getPostId() != 0 && (n0 = this.a.F0.n0()) != null) {
                                    ArrayList<c.a.d.n.e.n> s = n0.s();
                                    if (ListUtils.getCount(s) > 0) {
                                        Iterator<c.a.d.n.e.n> it = s.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            c.a.d.n.e.n next = it.next();
                                            if ((next instanceof PostData) && f4.getPostId() == c.a.d.f.m.b.g(((PostData) next).G(), 0L)) {
                                                c.a.t0.s2.w.a.b(this.a.y0.R0(), (PostData) next, ((PostData) next).f0, f4.getPostId() == c.a.d.f.m.b.g(this.a.y0.q0(), 0L) ? 1 : 8, 3);
                                            }
                                        }
                                    }
                                }
                                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2 = new ConcurrentHashMap<>();
                                if (!ListUtils.isEmpty(arrayList2)) {
                                    String str2 = arrayList2.get(0);
                                    concurrentHashMap2.put(str2, eVar.f48229b.get(str2));
                                }
                                Rect rect2 = new Rect();
                                view.getGlobalVisibleRect(rect2);
                                this.a.K2(rect2);
                                ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                                bVar2.x(arrayList2);
                                bVar2.z(eVar.f48230c);
                                bVar2.y(eVar.f48231d);
                                bVar2.O(eVar.f48232e);
                                bVar2.C(eVar.f48234g);
                                bVar2.H(true);
                                bVar2.J(eVar.f48236i);
                                bVar2.F(this.a.y0.c1());
                                bVar2.w(concurrentHashMap2);
                                bVar2.K(false);
                                bVar2.G(this.a.isHostOnlyMode());
                                bVar2.L(eVar.f48233f);
                                bVar2.M(rect2, UtilHelper.fixedDrawableRect(rect2, view));
                                if (this.a.y0 != null) {
                                    bVar2.A(this.a.y0.getFromForumId());
                                    if (this.a.y0.R0() != null) {
                                        bVar2.N(this.a.y0.R0().O());
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
                            concurrentHashMap3.put(str3, eVar.f48229b.get(str3));
                        }
                        ImageViewerConfig.b bVar3 = new ImageViewerConfig.b();
                        bVar3.x(arrayList3);
                        bVar3.z(eVar.f48230c);
                        bVar3.y(eVar.f48231d);
                        bVar3.O(eVar.f48232e);
                        bVar3.C(eVar.f48234g);
                        bVar3.H(true);
                        bVar3.J(eVar.a.get(0));
                        bVar3.F(this.a.y0.c1());
                        bVar3.w(concurrentHashMap3);
                        bVar3.K(false);
                        bVar3.G(this.a.isHostOnlyMode());
                        bVar3.L(eVar.f48233f);
                        bVar3.D(false);
                        if (this.a.y0 != null) {
                            bVar3.A(this.a.y0.getFromForumId());
                            if (this.a.y0.R0() != null) {
                                bVar3.N(this.a.y0.R0().O());
                            }
                        }
                        ImageViewerConfig v3 = bVar3.v(this.a.getPageContext().getPageActivity());
                        v3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, v3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                    this.a.W = view;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            c.a.t0.s2.o oVar = (c.a.t0.s2.o) customResponsedMessage.getData();
            int type = oVar.getType();
            if (type == 0) {
                this.a.refreshWrite((c.a.t0.s2.r.t) oVar.a());
            } else if (type == 1) {
                this.a.I2((ForumManageModel.b) oVar.a(), false);
            } else if (type != 2) {
            } else {
                if (oVar.a() == null) {
                    this.a.refreshMark(false, null);
                } else {
                    this.a.refreshMark(true, (MarkData) oVar.a());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k0 implements c.InterfaceC0871c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.s0.s.s.c.InterfaceC0871c
        public void a(c.a.s0.s.s.c cVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    PbFragment pbFragment = this.a;
                    pbFragment.L0 = pbFragment.L0.trim();
                    UtilHelper.callPhone(this.a.getPageContext().getPageActivity(), this.a.L0);
                    new c.a.t0.s2.u.f.c(this.a.y0.h1(), this.a.L0, "1").start();
                    cVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.L0 = pbFragment2.L0.trim();
                    UtilHelper.smsPhone(this.a.getPageContext().getPageActivity(), this.a.L0);
                    new c.a.t0.s2.u.f.c(this.a.y0.h1(), this.a.L0, "2").start();
                    cVar.e();
                } else if (i2 == 2) {
                    PbFragment pbFragment3 = this.a;
                    pbFragment3.L0 = pbFragment3.L0.trim();
                    UtilHelper.startBaiDuBar(this.a.getPageContext().getPageActivity(), this.a.L0);
                    cVar.e();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k1 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k1(PbFragment pbFragment, int i2, boolean z) {
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.a.F0 != null) {
                    PbFragment pbFragment = this.a;
                    pbFragment.hideLoadingView(pbFragment.F0.a1());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            new BdTopToast(this.a.getContext()).setIcon(true).setContent(this.a.getString(c.a.t0.s2.l.block_user_success)).show((ViewGroup) this.a.getView());
                            this.a.C3(type);
                            return;
                        }
                        new BdTopToast(this.a.getContext()).setIcon(false).setContent(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(c.a.t0.s2.l.neterror) : httpResponsedMessage.getErrorString()).show((ViewGroup) this.a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k2 implements c.InterfaceC0871c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.s0.s.s.c.InterfaceC0871c
        public void a(c.a.s0.s.s.c cVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, view) == null) {
                if (cVar != null) {
                    cVar.e();
                }
                PbFragment pbFragment = this.a;
                PostData postData = pbFragment.o2;
                if (postData != null) {
                    if (i2 == 0) {
                        postData.m0();
                        this.a.o2 = null;
                    } else if (i2 == 1 && pbFragment.checkUpIsLogin()) {
                        PbFragment pbFragment2 = this.a;
                        pbFragment2.markFloor(pbFragment2.o2);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.F0 == null || this.a.F0.n0() == null) {
                return;
            }
            this.a.F0.n0().X();
        }
    }

    /* loaded from: classes12.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                this.a.F0.g1();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                c.a.t0.s2.r.f R0 = this.a.y0.R0();
                if (R0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    R0.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.c(this.a.e1.getResources().getString(c.a.t0.s2.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.e1.getResources().getString(c.a.t0.s2.l.mute_error_beyond_limit);
                    }
                    this.a.S3(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.N3();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (c.a.d.f.p.m.isEmpty(errorString2)) {
                        errorString2 = this.a.e1.getResources().getString(c.a.t0.s2.l.mute_fail);
                    }
                    this.a.f1.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l1 implements a.InterfaceC0841a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.s0.i.a.InterfaceC0841a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.F0.P2();
                if (z) {
                    if (this.a.A0 != null) {
                        this.a.A0.h(z2);
                    }
                    this.a.y0.x2(z2);
                    if (this.a.y0.D0()) {
                        this.a.n3();
                    } else {
                        this.a.F0.t1(this.a.y0.R0());
                    }
                    if (z2) {
                        if (this.a.A0 != null) {
                            if (this.a.A0.f() == null || this.a.y0 == null || this.a.y0.R0() == null || this.a.y0.R0().O() == null || this.a.y0.R0().O().J() == null) {
                                return;
                            }
                            MarkData f2 = this.a.A0.f();
                            MetaData J = this.a.y0.R0().O().J();
                            if (f2 != null && J != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), J.getUserId()) && !J.hadConcerned()) {
                                    this.a.M3(J);
                                } else {
                                    this.a.showToast(c.a.t0.s2.l.add_mark_on_pb);
                                    if (c.a.s0.t.h.a.e(this.a.getContext(), 0)) {
                                        c.a.s0.t.h.a.g(this.a.getPageContext(), 6, 2000L);
                                    }
                                }
                            } else {
                                PbFragment pbFragment = this.a;
                                pbFragment.showToast(pbFragment.getPageContext().getString(c.a.t0.s2.l.add_mark));
                            }
                        }
                        this.a.y2();
                        return;
                    }
                    PbFragment pbFragment2 = this.a;
                    pbFragment2.showToast(pbFragment2.getPageContext().getString(c.a.t0.s2.l.remove_mark));
                    return;
                }
                PbFragment pbFragment3 = this.a;
                pbFragment3.showToast(pbFragment3.getPageContext().getString(c.a.t0.s2.l.update_mark_failed));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l2 implements c.InterfaceC0871c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.s0.s.s.c.InterfaceC0871c
        public void a(c.a.s0.s.s.c cVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, view) == null) {
                if (cVar != null) {
                    cVar.e();
                }
                if (this.a.j1 == null || TextUtils.isEmpty(this.a.k1)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.a.l1 == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.k1));
                    } else {
                        d.a aVar = new d.a();
                        aVar.a = this.a.k1;
                        String str = "";
                        if (this.a.l1.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.l1.memeInfo.pck_id;
                        }
                        aVar.f12569b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.a.V0 == null) {
                        this.a.V0 = new PermissionJudgePolicy();
                    }
                    this.a.V0.clearRequestPermissionList();
                    this.a.V0.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.V0.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.a.i1 == null) {
                        PbFragment pbFragment = this.a;
                        pbFragment.i1 = new c.a.t0.s2.u.f.x0(pbFragment.getPageContext());
                    }
                    this.a.i1.b(this.a.k1, this.a.j1.n());
                }
                this.a.j1 = null;
                this.a.k1 = null;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                c.a.s0.g1.n.f.c(this.a.getPageContext(), this.a, aVar.a, aVar.f12990b, aVar.f12991c);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class m0 implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48308e;

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
            this.f48308e = pbFragment;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 2 && this.f48308e.y0 != null && this.f48308e.y0.D0()) {
                    this.f48308e.n3();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class m1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f48309e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48310f;

        public m1(PbFragment pbFragment, MetaData metaData) {
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
            this.f48310f = pbFragment;
            this.f48309e = metaData;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f48309e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class m2 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48311e;

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
            this.f48311e = pbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f48311e.y0 == null || this.f48311e.y0.a1() == i2 + 1) {
                return;
            }
            PbFragment pbFragment = this.f48311e;
            pbFragment.A3(pbFragment.U2(i2));
        }
    }

    /* loaded from: classes12.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f48268k) {
                return;
            }
            this.a.U3();
        }
    }

    /* loaded from: classes12.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                this.a.F0.g1();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.f1.c(this.a.e1.getResources().getString(c.a.t0.s2.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (c.a.d.f.p.m.isEmpty(muteMessage)) {
                    muteMessage = this.a.e1.getResources().getString(c.a.t0.s2.l.un_mute_fail);
                }
                this.a.f1.b(muteMessage);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f48312e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48313f;

        public n1(PbFragment pbFragment, MetaData metaData) {
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
            this.f48313f = pbFragment;
            this.f48312e = metaData;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f48312e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                this.f48313f.C0.l(!this.f48312e.hadConcerned(), this.f48312e.getPortrait(), this.f48312e.getUserId(), this.f48312e.isGod(), "6", this.f48313f.getPageContext().getUniqueId(), this.f48313f.y0.getForumId(), "0");
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n2 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48314e;

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
            this.f48314e = pbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                PbFragment pbFragment = this.f48314e;
                pbFragment.f48263f = true;
                return pbFragment.F2(view);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                new BdTopToast(this.a.getContext()).setIcon(false).setContent(this.a.getString(c.a.t0.s2.l.novel_thread_mask_click_tip)).show((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!this.a.e3() || this.a.f48262e == null || this.a.f48262e.getPbModel() == null || !str.equals(this.a.f48262e.getPbModel().getTopicId())) {
                    return;
                }
                this.a.a4(false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class o1 implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48315e;

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
            this.f48315e = pbFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            ArrayList<PostData> F;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) || this.f48315e.y0 == null || this.f48315e.y0.R0() == null || this.f48315e.F0 == null || this.f48315e.F0.n0() == null) {
                return;
            }
            this.f48315e.F0.T1(absListView, i2, i3, i4);
            if (this.f48315e.f48266i != null) {
                this.f48315e.f48266i.q(absListView, i2, i3, i4);
            }
            if (!this.f48315e.y0.x1() || (F = this.f48315e.y0.R0().F()) == null || F.isEmpty()) {
                return;
            }
            int w = ((i2 + i3) - this.f48315e.F0.n0().w()) - 1;
            c.a.t0.s2.r.f R0 = this.f48315e.y0.R0();
            if (R0 == null) {
                return;
            }
            if (R0.D() != null && R0.D().J0()) {
                w--;
            }
            if (R0.E() != null && R0.E().J0()) {
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
                PbFragment pbFragment = this.f48315e;
                if (!pbFragment.g3(pbFragment.c1) && this.f48315e.g3(i2)) {
                    if (this.f48315e.F0 != null) {
                        this.f48315e.F0.c0();
                        if (this.f48315e.T0 != null && !this.f48315e.F0.v1()) {
                            this.f48315e.F0.v2(this.f48315e.T0.C());
                        }
                        if (!this.f48315e.N) {
                            this.f48315e.F0.o2();
                        }
                    }
                    if (!this.f48315e.x) {
                        this.f48315e.x = true;
                    }
                }
                if (this.f48315e.F0 != null) {
                    this.f48315e.F0.U1(absListView, i2);
                }
                if (this.f48315e.f48266i != null) {
                    this.f48315e.f48266i.r(absListView, i2);
                }
                if (this.f48315e.y == null) {
                    this.f48315e.y = new c.a.s0.s0.b();
                    this.f48315e.y.a(1001);
                }
                if (i2 == 0) {
                    this.f48315e.y.e();
                    if (this.f48315e.r0 != null) {
                        BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(this.f48315e.r0);
                        this.f48315e.r0 = null;
                    }
                } else {
                    if (this.f48315e.r0 == null) {
                        this.f48315e.r0 = BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect("pb", "1", "scroll");
                    }
                    this.f48315e.y.d();
                }
                this.f48315e.c1 = i2;
                if (i2 == 0) {
                    this.f48315e.y3(false, null);
                    c.a.t0.v3.c.g().h(this.f48315e.getUniqueId(), true);
                    this.f48315e.checkEasterEgg(true);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class o2 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48316e;

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
            this.f48316e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ItemCardHelper.l(this.f48316e.getContext(), this.f48316e.getUniqueId(), view, (ViewGroup) this.f48316e.getView());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
                    if (error == 0 && booleanValue && TbadkCoreApplication.isLogin()) {
                        this.a.o3();
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.t0.h4.a) && customResponsedMessage.getOrginalMessage().getTag() == this.a.g1) {
                c.a.t0.h4.a aVar = (c.a.t0.h4.a) customResponsedMessage.getData();
                this.a.F0.g1();
                SparseArray<Object> sparseArray = (SparseArray) this.a.d1;
                DataRes dataRes = aVar.a;
                if (aVar.f18609c == 0 && dataRes != null) {
                    int e2 = c.a.d.f.m.b.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = e2 == 1;
                    if (c.a.d.f.p.m.isEmpty(str)) {
                        sparseArray.put(c.a.t0.s2.i.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(c.a.t0.s2.i.tag_user_mute_msg, str);
                    }
                    sparseArray.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                } else {
                    sparseArray.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(c.a.t0.s2.i.tag_from)).intValue();
                if (intValue == 0) {
                    this.a.O3(r2, sparseArray);
                } else if (intValue == 1) {
                    this.a.F0.a2(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class p1 implements Comparator<c.a.s0.u.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48317e;

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
            this.f48317e = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c.a.s0.u.a aVar, c.a.s0.u.a aVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, aVar2)) == null) ? aVar.compareTo(aVar2) : invokeLL.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public class p2 implements b3 {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.b3
        public boolean onBackPressed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.F0 != null && this.a.F0.O0() != null) {
                    c.a.t0.s2.u.f.t O0 = this.a.F0.O0();
                    if (O0.f()) {
                        O0.d();
                        return true;
                    }
                }
                if (this.a.F0 == null || !this.a.F0.I1()) {
                    return false;
                }
                this.a.F0.k1();
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class q implements TiePlusEventController.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.f
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A = true;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.F0.v1() && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.doDoubleClick();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q1 implements AntiHelper.k {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q2 implements ItemCardHelper.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                ItemCardHelper.x(this.a.getContext(), ItemCardHelper.OrderTipStatus.SUCCESS, (ViewGroup) this.a.getView(), j2);
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

    /* loaded from: classes12.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48318e;

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
            this.f48318e = pbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                PbFragment pbFragment = this.f48318e;
                pbFragment.showToast(pbFragment.D);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(PbFragment pbFragment, int i2) {
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.a.t0.w3.j0.e eVar;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c.a.t0.w3.j0.e) || (eVar = (c.a.t0.w3.j0.e) customResponsedMessage.getData()) == null || (agreeData = eVar.f25551b) == null || agreeData.agreeType != 2 || this.a.F0 == null || !c.a.s0.b.d.a0() || c.a.t0.s2.u.f.g1.b.k(this.a.y0.f48398f)) {
                return;
            }
            this.a.F0.v3();
            c.a.t0.s2.u.f.g1.b.b(this.a.y0.f48398f);
        }
    }

    /* loaded from: classes12.dex */
    public class r1 extends c.a.d.a.e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.a.isAdded()) {
                boolean z = false;
                if (obj != null) {
                    switch (this.a.B0.getLoadDataMode()) {
                        case 0:
                            this.a.y0.q1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.I2(bVar, (bVar.f50069e != 1002 || bVar.f50070f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.F0.k0(1, dVar.a, dVar.f50073b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            PbFragment pbFragment = this.a;
                            pbFragment.J2(pbFragment.B0.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            this.a.F0.k0(this.a.B0.getLoadDataMode(), gVar.a, gVar.f50084b, false);
                            this.a.F0.V1(gVar.f50085c);
                            return;
                        default:
                            return;
                    }
                }
                this.a.F0.k0(this.a.B0.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class r2 implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48319e;

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
            this.f48319e = pbFragment;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.f48319e.f48268k && z && !this.f48319e.y0.H0()) {
                    this.f48319e.v3();
                }
                PbFragment pbFragment = this.f48319e;
                pbFragment.setNetRefreshViewEmotionMarginTop(c.a.d.f.p.n.f(pbFragment.getContext(), c.a.t0.s2.g.ds360));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.s0.s.q.j0)) {
                c.a.s0.s.q.j0 j0Var = (c.a.s0.s.q.j0) customResponsedMessage.getData();
                d1.a aVar = new d1.a();
                int i2 = j0Var.a;
                String str = j0Var.f13734b;
                aVar.a = j0Var.f13736d;
                c.a.t0.s2.r.f R0 = this.a.y0.R0();
                if (R0 == null) {
                    return;
                }
                if (this.a.y0.u0() != null && this.a.y0.u0().getUserIdLong() == j0Var.p) {
                    this.a.F0.h2(j0Var.l, this.a.y0.R0(), this.a.y0.f1(), this.a.y0.b1());
                }
                if (R0.F() == null || R0.F().size() < 1 || R0.F().get(0) == null) {
                    return;
                }
                long g2 = c.a.d.f.m.b.g(R0.F().get(0).G(), 0L);
                long g3 = c.a.d.f.m.b.g(this.a.y0.h1(), 0L);
                if (g2 == j0Var.n && g3 == j0Var.m) {
                    c.a.s0.s.q.d1 F = R0.F().get(0).F();
                    if (F == null) {
                        F = new c.a.s0.s.q.d1();
                    }
                    ArrayList<d1.a> a = F.a();
                    if (a == null) {
                        a = new ArrayList<>();
                    }
                    a.add(0, aVar);
                    F.e(F.b() + j0Var.l);
                    F.d(a);
                    R0.F().get(0).q0(F);
                    this.a.F0.n0().X();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class s0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s0(PbFragment pbFragment, int i2) {
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
            this.a.m1 = true;
        }
    }

    /* loaded from: classes12.dex */
    public class s1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48320e;

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
            this.f48320e = pbFragment;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes12.dex */
    public class s2 implements c.a.d.f.k.c<LinearLayout> {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(c.a.t0.s2.i.pb_text_voice_layout);
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

    /* loaded from: classes12.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(PbFragment pbFragment, int i2) {
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.y0 == null || this.a.y0.R0() == null) {
                return;
            }
            this.a.y0.R0().a();
            this.a.y0.q1();
            if (this.a.F0.n0() != null) {
                this.a.F0.t1(this.a.y0.R0());
            }
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes12.dex */
    public class t0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48321e;

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
            this.f48321e = pbFragment;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f48321e.hideKeyBroad();
                c.a.s0.s.q.b1 P0 = this.f48321e.y0.P0();
                int L0 = this.f48321e.F0.L0();
                if (L0 <= 0) {
                    this.f48321e.showToast(c.a.t0.s2.l.pb_page_error);
                } else if (P0 == null || L0 <= P0.h()) {
                    this.f48321e.F0.c0();
                    this.f48321e.stopVoice();
                    this.f48321e.F0.Q2();
                    if (c.a.d.f.p.l.z()) {
                        this.f48321e.y0.v2(this.f48321e.F0.L0());
                        if (this.f48321e.f48266i != null) {
                            this.f48321e.f48266i.x();
                        }
                    } else {
                        this.f48321e.showToast(c.a.t0.s2.l.neterror);
                    }
                    aVar.dismiss();
                } else {
                    this.f48321e.showToast(c.a.t0.s2.l.pb_page_error);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class t1 implements c.a.s0.x.y.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.s0.x.y.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.t0.s2.u.f.v0 v0Var = this.a.mContentProcessController;
                if (v0Var == null || v0Var.e() == null || !this.a.mContentProcessController.e().d()) {
                    return !this.a.checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                PbFragment pbFragment = this.a;
                pbFragment.showToast(pbFragment.mContentProcessController.e().c());
                if (this.a.T0 != null && (this.a.T0.B() || this.a.T0.D())) {
                    this.a.T0.z(false, this.a.mContentProcessController.h());
                }
                this.a.mContentProcessController.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class t2 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48322e;

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
            this.f48322e = pbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                FrameLayout frameLayout = (FrameLayout) this.f48322e.getPageContext().getPageActivity().getWindow().getDecorView();
                for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                    View childAt = frameLayout.getChildAt(i2);
                    if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag()) && ((FrameLayout) childAt).getChildCount() <= 0) {
                        break;
                    }
                }
                this.f48322e.f48265h.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.y0 == null || this.a.y0.R0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.a.G2(str);
            this.a.y0.q1();
            if (!TextUtils.isEmpty(str) && this.a.y0.R0().F() != null) {
                ArrayList<PostData> F = this.a.y0.R0().F();
                c.a.t0.w3.j0.p pVar = null;
                Iterator<PostData> it = F.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next instanceof c.a.t0.w3.j0.p) {
                        c.a.t0.w3.j0.p pVar2 = (c.a.t0.w3.j0.p) next;
                        if (str.equals(pVar2.K0())) {
                            pVar = pVar2;
                            break;
                        }
                    }
                }
                if (pVar != null) {
                    F.remove(pVar);
                    if (this.a.F0.n0() != null && this.a.F0.n0().s() != null) {
                        this.a.F0.n0().s().remove(pVar);
                    }
                    if (this.a.F0.E0() != null && this.a.F0.E0().getData() != null) {
                        this.a.F0.E0().getData().remove(pVar);
                    }
                    if (this.a.F0.n0() != null) {
                        this.a.F0.n0().X();
                        return;
                    }
                }
            }
            if (this.a.F0.n0() != null) {
                this.a.F0.t1(this.a.y0.R0());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class u0 implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48323e;

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
            this.f48323e = pbFragment;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(c.a.s0.s.s.j jVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                if (this.f48323e.J0 != null) {
                    this.f48323e.J0.dismiss();
                }
                this.f48323e.b4(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(c.a.t0.s2.i.pb_dialog_item_share);
                        this.f48323e.u3(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(c.a.t0.s2.i.pb_dialog_item_reply);
                        this.f48323e.u3(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(c.a.t0.s2.i.pb_dialog_item_zan_2);
                        if (view4 != null) {
                            AgreeView agreeView = (AgreeView) view4;
                            this.f48323e.u3(view4);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(c.a.t0.s2.i.pb_dialog_item_zan_2);
                        if (view5 != null) {
                            this.f48323e.u3(view5);
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
                        if (this.f48323e.j1 == null || TextUtils.isEmpty(this.f48323e.k1)) {
                            return;
                        }
                        if (this.f48323e.l1 == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f48323e.k1));
                        } else {
                            d.a aVar = new d.a();
                            aVar.a = this.f48323e.k1;
                            String str = "";
                            if (this.f48323e.l1.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f48323e.l1.memeInfo.pck_id;
                            }
                            aVar.f12569b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f48323e.j1 = null;
                        this.f48323e.k1 = null;
                        return;
                    case 2:
                        if (this.f48323e.j1 == null || TextUtils.isEmpty(this.f48323e.k1)) {
                            return;
                        }
                        if (this.f48323e.V0 == null) {
                            this.f48323e.V0 = new PermissionJudgePolicy();
                        }
                        this.f48323e.V0.clearRequestPermissionList();
                        this.f48323e.V0.appendRequestPermission(this.f48323e.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f48323e.V0.startRequestPermission(this.f48323e.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f48323e.i1 == null) {
                            PbFragment pbFragment = this.f48323e;
                            pbFragment.i1 = new c.a.t0.s2.u.f.x0(pbFragment.getPageContext());
                        }
                        this.f48323e.i1.b(this.f48323e.k1, this.f48323e.j1.n());
                        this.f48323e.j1 = null;
                        this.f48323e.k1 = null;
                        return;
                    case 3:
                        PostData postData = this.f48323e.o2;
                        if (postData != null) {
                            postData.m0();
                            this.f48323e.o2 = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f48323e.checkUpIsLogin()) {
                            this.f48323e.p3(view);
                            if (this.f48323e.y0.R0().O() == null || this.f48323e.y0.R0().O().J() == null || this.f48323e.y0.R0().O().J().getUserId() == null || this.f48323e.A0 == null) {
                                return;
                            }
                            PbFragment pbFragment2 = this.f48323e;
                            int V2 = pbFragment2.V2(pbFragment2.y0.R0());
                            c.a.s0.s.q.d2 O = this.f48323e.y0.R0().O();
                            if (O.P1()) {
                                i3 = 2;
                            } else if (O.S1()) {
                                i3 = 3;
                            } else if (!O.Q1()) {
                                i3 = O.R1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f48323e.y0.f48398f).param("obj_locate", 2).param("obj_id", this.f48323e.y0.R0().O().J().getUserId()).param("obj_type", !this.f48323e.A0.e()).param("obj_source", V2).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!c.a.d.f.p.l.z()) {
                            this.f48323e.showToast(c.a.t0.s2.l.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f48323e.X2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(c.a.t0.s2.i.tag_from, 0);
                                sparseArray2.put(c.a.t0.s2.i.tag_check_mute_from, 2);
                                this.f48323e.checkMuteState(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(c.a.t0.s2.i.tag_del_post_type) instanceof Integer) && (sparseArray3.get(c.a.t0.s2.i.tag_del_post_id) instanceof String) && (sparseArray3.get(c.a.t0.s2.i.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(c.a.t0.s2.i.tag_del_post_is_self) instanceof Boolean) && (sparseArray3.get(c.a.t0.s2.i.tag_has_sub_post) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(c.a.t0.s2.i.tag_has_sub_post)).booleanValue();
                            boolean isHost = this.f48323e.getPbActivity().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f48323e.H3(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f48323e.F0.Y1(((Integer) sparseArray3.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(c.a.t0.s2.i.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f48323e.H3(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f48323e.F0.W1(((Integer) sparseArray3.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray3.get(c.a.t0.s2.i.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!c.a.d.f.p.l.z()) {
                            this.f48323e.showToast(c.a.t0.s2.l.network_not_available);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(c.a.t0.s2.i.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(c.a.t0.s2.i.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(c.a.t0.s2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray4.get(c.a.t0.s2.i.tag_is_self_post)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.f48323e.F0.W1(((Integer) sparseArray4.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) sparseArray4.get(c.a.t0.s2.i.tag_del_post_id), ((Integer) sparseArray4.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (!booleanValue5) {
                            if (booleanValue6) {
                                sparseArray4.put(c.a.t0.s2.i.tag_check_mute_from, 2);
                            }
                            this.f48323e.F0.b2(view);
                            return;
                        } else {
                            sparseArray4.put(c.a.t0.s2.i.tag_from, 1);
                            sparseArray4.put(c.a.t0.s2.i.tag_check_mute_from, 2);
                            this.f48323e.checkMuteState(sparseArray4);
                            return;
                        }
                    case 8:
                        if (this.f48323e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(c.a.t0.s2.i.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            this.f48323e.D2(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        if (!this.f48323e.checkUpIsLogin() || this.f48323e.y0 == null || this.f48323e.y0.R0() == null) {
                            return;
                        }
                        this.f48323e.f48262e.showBlockDialog(c.a.t0.g4.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class u1 implements d3 {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }
    }

    /* loaded from: classes12.dex */
    public class u2 implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48324b;

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
            this.f48324b = pbFragment;
            this.a = (int) TbadkCoreApplication.getInst().getResources().getDimension(c.a.t0.s2.g.ds98);
        }

        @Override // c.a.t0.q0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || !e(i3) || this.f48324b.F0 == null || this.f48324b.f48266i == null) {
                return;
            }
            this.f48324b.f48266i.u(true);
            if (Math.abs(i3) > this.a) {
                this.f48324b.f48266i.l();
            }
            if (this.f48324b.getIsMangaThread()) {
                this.f48324b.F0.h1();
                this.f48324b.F0.q2();
            }
        }

        @Override // c.a.t0.q0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || !e(i3) || this.f48324b.F0 == null || this.f48324b.f48266i == null) {
                return;
            }
            this.f48324b.F0.s3();
            this.f48324b.f48266i.u(false);
            this.f48324b.f48266i.x();
        }

        @Override // c.a.t0.q0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.t0.q0.a.b
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

    /* loaded from: classes12.dex */
    public class v implements SuggestEmotionModel.c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.c
        public void a(c.a.t0.s2.u.f.c1.e.a aVar) {
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

    /* loaded from: classes12.dex */
    public class v0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f48325e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48326f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f48327g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48328h;

        public v0(PbFragment pbFragment, SparseArray sparseArray, int i2, boolean z) {
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
            this.f48328h = pbFragment;
            this.f48325e = sparseArray;
            this.f48326f = i2;
            this.f48327g = z;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f48328h.deleteThreadDirect(((Integer) this.f48325e.get(c.a.t0.s2.i.tag_del_post_type)).intValue(), (String) this.f48325e.get(c.a.t0.s2.i.tag_del_post_id), this.f48326f, this.f48327g);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class v1 implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48329e;

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
            this.f48329e = pbFragment;
        }

        @Override // c.a.s0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (this.f48329e.getIsMangaThread()) {
                    this.f48329e.f48262e.finish();
                }
                if (!this.f48329e.y0.J1(true)) {
                    this.f48329e.F0.j0();
                } else {
                    TiebaStatic.eventStat(this.f48329e.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class v2 implements b.InterfaceC1322b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public v2() {
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

        @Override // c.a.t0.q0.b.InterfaceC1322b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    c.a.t0.s2.s.b.d();
                } else {
                    c.a.t0.s2.s.b.c();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(PbFragment pbFragment, int i2) {
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
            this.a = pbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || this.a.F0 == null || this.a.y0 == null) {
                return;
            }
            this.a.F0.W(false);
            if (this.a.y0.F1(false)) {
                this.a.F0.R2();
            } else if (this.a.y0.R0() != null) {
                this.a.F0.k2();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class w0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48330e;

        public w0(PbFragment pbFragment) {
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
            this.f48330e = pbFragment;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class w1 implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48331e;

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
            this.f48331e = pbFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48331e.j2 && this.f48331e.getIsMangaThread()) {
                    this.f48331e.j3();
                }
                if (this.f48331e.mIsLogin) {
                    if (!this.f48331e.k0 && this.f48331e.F0 != null && this.f48331e.F0.T() && this.f48331e.y0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13999");
                        statisticItem.param("tid", this.f48331e.y0.h1());
                        statisticItem.param("fid", this.f48331e.y0.getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        int i2 = 5;
                        if (this.f48331e.y0.x0()) {
                            i2 = 4;
                        } else if (this.f48331e.y0.y0()) {
                            i2 = 3;
                        } else if (this.f48331e.y0.A0()) {
                            i2 = 1;
                        }
                        statisticItem.param("obj_type", i2);
                        TiebaStatic.log(statisticItem);
                        this.f48331e.k0 = true;
                    }
                    if (this.f48331e.y0.F1(false)) {
                        this.f48331e.F0.R2();
                        TiebaStatic.eventStat(this.f48331e.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    } else if (this.f48331e.v0 == null || !this.f48331e.v0.d()) {
                        if (this.f48331e.y0.R0() != null) {
                            this.f48331e.F0.k2();
                        }
                    } else {
                        this.f48331e.F0.R2();
                    }
                    this.f48331e.j2 = true;
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class w2 implements p.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.t0.s2.u.f.p.b
        public void a(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) {
                if (StringUtils.isNull(str)) {
                    if (i2 == 0) {
                        this.a.showToast(c.a.t0.s2.l.upgrage_toast_dialog);
                    } else {
                        this.a.showToast(c.a.t0.s2.l.neterror);
                    }
                } else if (i2 != 0 && !TextUtils.isEmpty(str2)) {
                    this.a.F0.a0(str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class x implements GetSugMatchWordsModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

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
            this.a = pbFragment;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list) || this.a.F0 == null) {
                return;
            }
            this.a.F0.V2(list);
        }
    }

    /* loaded from: classes12.dex */
    public static class x0 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x0() {
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
        public void onNavigationButtonClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class x1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48332e;

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
            this.f48332e = pbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48332e.y0 == null) {
                return;
            }
            this.f48332e.y0.loadData();
        }
    }

    /* loaded from: classes12.dex */
    public class x2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48333e;

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
            this.f48333e = pbFragment;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.f48333e.e1).showToast(c.a.t0.s2.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f48333e.e1.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class y implements PraiseModel.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.K1 = false;
                if (this.a.L1 == null) {
                    return;
                }
                c.a.t0.s2.r.f R0 = this.a.y0.R0();
                if (R0.O().M0().getIsLike() == 1) {
                    this.a.e4(0);
                } else {
                    this.a.e4(1);
                }
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004004, R0.O()));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.PraiseModel.b
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.a.K1 = false;
                if (this.a.L1 == null || str == null) {
                    return;
                }
                if (AntiHelper.m(i2, str)) {
                    AntiHelper.u(this.a.getPageContext().getPageActivity(), str);
                } else {
                    this.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class y0 implements c.d {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.T0 != null && this.a.T0.a() != null) {
                    this.a.T0.a().sendAction(new c.a.s0.x.a(45, 27, null));
                }
                this.a.F0.V();
            }
        }

        @Override // c.a.t0.d1.r2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class y1 implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomDialogData f48334e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ y1 f48335f;

            public a(y1 y1Var, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {y1Var, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48335f = y1Var;
                this.f48334e = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.t0.s2.t.c.a(this.f48335f.a.getPageContext(), this.f48334e).show();
                }
            }
        }

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
                c.a.d.f.m.e.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class y2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48336e;

        public y2(PbFragment pbFragment) {
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
            this.f48336e = pbFragment;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class z implements b.h {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // c.a.t0.s2.u.f.d1.b.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.setNavigationBarShowFlag(z);
                if (this.a.F0.B0() != null && z) {
                    this.a.F0.x3(false);
                }
                this.a.F0.Q1(z);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class z0 implements SortSwitchButton.f {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.a.F0.c0();
                boolean z = false;
                if (c.a.d.f.p.l.z()) {
                    if (this.a.y0 != null && !this.a.y0.isLoading) {
                        this.a.stopVoice();
                        this.a.F0.Q2();
                        z = true;
                        if (this.a.y0.R0() != null && this.a.y0.R0().f23038f != null && this.a.y0.R0().f23038f.size() > i2) {
                            int intValue = this.a.y0.R0().f23038f.get(i2).sort_type.intValue();
                            TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.y0.i1()).param("fid", this.a.y0.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                            if (this.a.y0.B2(intValue)) {
                                this.a.m = true;
                                this.a.F0.E2(true);
                            }
                        }
                    }
                    return z;
                }
                this.a.showToast(c.a.t0.s2.l.network_not_available);
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

    /* loaded from: classes12.dex */
    public class z1 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f48337e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f48338f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f48339g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48340h;

        public z1(PbFragment pbFragment, MarkData markData, MarkData markData2, c.a.s0.s.s.a aVar) {
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
            this.f48340h = pbFragment;
            this.f48337e = markData;
            this.f48338f = markData2;
            this.f48339g = aVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f48340h.A0 != null) {
                    if (this.f48340h.A0.e()) {
                        this.f48340h.A0.d();
                        this.f48340h.A0.h(false);
                    }
                    this.f48340h.A0.i(this.f48337e);
                    this.f48340h.A0.h(true);
                    this.f48340h.A0.a();
                }
                this.f48338f.setPostId(this.f48337e.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.f48338f);
                this.f48340h.f48262e.setResult(-1, intent);
                this.f48339g.dismiss();
                this.f48340h.X3();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class z2 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbFragment f48341e;

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
            this.f48341e = pbFragment;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
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
        C2 = new x0();
        D2 = new v2();
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
        this.f48263f = true;
        this.f48264g = false;
        this.f48268k = false;
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
        this.d0 = new int[2];
        this.f0 = -1;
        this.g0 = -1;
        this.sortSwitchId = BdUniqueId.gen();
        this.k0 = false;
        this.t0 = c.a.s0.b.d.x0();
        this.u0 = new q(this);
        this.w0 = new b0(this);
        this.x0 = new Handler(new m0(this));
        this.y0 = null;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.G0 = false;
        this.H0 = false;
        this.I0 = false;
        this.M0 = false;
        this.O0 = false;
        this.Q0 = false;
        this.mKeyboardIsVisible = false;
        this.Z0 = new i1(this);
        this.a1 = new t1(this);
        this.b1 = new e2(this);
        this.c1 = 0;
        this.m1 = false;
        this.n1 = 0;
        this.o1 = -1;
        this.bjhFrom = 0;
        this.r1 = new p2(this);
        this.s1 = new a3(this);
        this.t1 = new g(this, 2004016);
        this.u1 = new h(this, 2016485);
        this.v1 = new i(this, 2001269);
        this.w1 = new j(this, 2004008);
        this.x1 = new k(this, 2004007);
        this.y1 = new l(this, 2004005);
        this.z1 = new m(this, 2001332);
        this.A1 = new n(this, 2921391);
        this.B1 = new o(this, 2921606);
        this.C1 = new p(this, 2921658);
        this.D1 = new r(this);
        this.E1 = new s(this, 2001369);
        this.F1 = new t(this, 2016488);
        this.G1 = new u(this, 2016331);
        this.H1 = new v(this);
        this.I1 = new w(this, 2921509);
        this.J1 = new x(this);
        this.L1 = new PraiseModel(getPageContext(), new y(this));
        this.M1 = new z(this);
        this.N1 = new c0(this, 2001115);
        this.O1 = new d0(this);
        this.P1 = new g0(this);
        this.Q1 = new c.a.t0.s2.s.c(new j0(this));
        this.R1 = new l0(this, 2001427);
        this.S1 = new n0(this, 2001428);
        this.T1 = new o0(this, 2921634);
        this.U1 = new p0(this, 2001426);
        this.mFirstFloorPraiseListener = new q0(this, 2004021);
        this.V1 = new r0(this, 2016528);
        this.W1 = new s0(this, 2921033);
        this.mDialogClickListener = new t0(this);
        this.X1 = new u0(this);
        this.onSwitchChangeListener = new z0(this);
        this.mCommonOnClickListener = new c1(this);
        this.Y1 = new d1(this, 2921480);
        this.Z1 = new e1(this);
        this.mOnFloorPostWriteNewCallback = new f1(this);
        this.a2 = new g1(this, CmdConfigHttp.CMD_VOTE_THREAD_PULISH, 309644);
        this.b2 = new h1(this);
        this.c2 = new j1(this, 2016450);
        this.d2 = new k1(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.e2 = new l1(this);
        this.f2 = new o1(this);
        this.g2 = new r1(this);
        this.h2 = new u1(this);
        this.i2 = new v1(this);
        this.k2 = new w1(this);
        this.l2 = 0;
        this.m2 = new j2(this);
        this.n2 = false;
        this.o2 = null;
        this.p2 = new k2(this);
        this.q2 = new l2(this);
        this.r2 = new m2(this);
        this.s2 = new n2(this);
        this.t2 = new o2(this);
        this.u2 = new q2(this);
        this.v2 = new r2(this);
        this.mOnTouchListener = new t2(this);
        this.w2 = new u2(this);
        this.x2 = new w2(this);
        this.y2 = -1;
        this.z2 = -1;
    }

    public static PbFragment newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65667, null)) == null) ? new PbFragment() : (PbFragment) invokeV.objValue;
    }

    public final void A2(c.a.t0.s2.r.f fVar, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, arrayList) == null) || fVar == null || fVar.T() == null || fVar.T().a == null || (list = fVar.T().a) == null || arrayList == null) {
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
                    if (postData != null && !TextUtils.isEmpty(next.G()) && !TextUtils.isEmpty(postData.G()) && next.G().equals(postData.G())) {
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
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3) == null) || this.y0 == null) {
            return;
        }
        P3();
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i3);
        privacySettingMessage.setTid(this.y0.f48398f);
        sendMessage(privacySettingMessage);
    }

    public final boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.R0() == null) {
                return false;
            }
            return AntiHelper.b(getPageContext(), this.y0.R0().O()) || AntiHelper.d(getPageContext(), this.y0.R0().d());
        }
        return invokeV.booleanValue;
    }

    public final void B3(c.a.s0.x.y.g gVar) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || gVar == null || (pbModel = this.y0) == null) {
            return;
        }
        gVar.p(pbModel.r0());
        if (this.y0.R0() != null && this.y0.R0().l() != null) {
            gVar.o(this.y0.R0().l());
        }
        gVar.q("pb");
        gVar.r(this.y0);
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
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i3) == null) || (pbModel = this.y0) == null) {
            return;
        }
        int a12 = pbModel.a1();
        if (i3 == 5) {
            this.y0.s2(2);
        } else if (i3 == 6) {
            this.y0.s2(3);
        } else if (i3 != 7) {
            this.y0.s2(1);
        } else {
            this.y0.s2(4);
        }
        int a13 = this.y0.a1();
        if (a12 == 4 || a13 == 4) {
            r3();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D2(AgreeData agreeData) {
        c.a.s0.o0.c k3;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.i0 == null) {
            this.i0 = new c.a.s0.s.e0.a();
        }
        if (this.s0 == null) {
            c.a.t0.w3.j0.e eVar = new c.a.t0.w3.j0.e();
            this.s0 = eVar;
            eVar.a = getUniqueId();
        }
        c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
        fVar.f13685b = 5;
        fVar.f13691h = 8;
        fVar.f13690g = 2;
        if (getPbModel() != null) {
            fVar.f13689f = getPbModel().Q0();
        }
        fVar.a = 2;
        int i3 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f13692i = 0;
                k3 = TbPageExtraHelper.k(getContext());
                if (k3 != null) {
                    agreeData.objSource = k3.a();
                }
                this.i0.c(agreeData, i3, getUniqueId(), false);
                this.i0.d(agreeData, this.s0);
                pbModel = this.y0;
                if (pbModel != null || pbModel.R0() == null) {
                }
                this.i0.b(getPbActivity(), fVar, agreeData, this.y0.R0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f13692i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f13692i = 1;
        }
        i3 = 0;
        k3 = TbPageExtraHelper.k(getContext());
        if (k3 != null) {
        }
        this.i0.c(agreeData, i3, getUniqueId(), false);
        this.i0.d(agreeData, this.s0);
        pbModel = this.y0;
        if (pbModel != null) {
        }
    }

    public final void D3(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z3) == null) {
            this.T0.f0(z3);
            this.T0.i0(z3);
            this.T0.p0(z3);
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.y0.x0() || this.y0.A0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.y0.h1());
                this.f48262e.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.y0.h1()));
            if (Y3()) {
                this.f48262e.finish();
            }
        }
    }

    public final void E3(int i3, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i3, antiData, str) == null) {
            if (AntiHelper.m(i3, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i3, new q1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i3 == 230277) {
                S3(str);
            } else {
                this.F0.A3(str);
            }
        }
    }

    public final boolean F2(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z3;
        boolean z4;
        boolean z5;
        List<c.a.s0.s.s.g> b4;
        c.a.s0.s.s.g gVar;
        c.a.s0.s.s.g gVar2;
        c.a.s0.s.s.g gVar3;
        c.a.s0.s.s.g gVar4;
        c.a.d.n.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) {
            if (isAdded() && !FullBrowseHelper.checkAndShowFullBrowseModeDialog(getPageContext(), null)) {
                c.a.t0.s2.u.f.t0 t0Var = this.F0;
                if (t0Var != null) {
                    if (t0Var.x1()) {
                        return true;
                    }
                    this.F0.l0();
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
                            this.j1 = tbImageView.getBdImage();
                            String url = tbImageView.getUrl();
                            this.k1 = url;
                            if (this.j1 == null || TextUtils.isEmpty(url)) {
                                return true;
                            }
                            if (view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info) != null && (view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.l1 = (TbRichTextMemeInfo) view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info);
                            } else {
                                this.l1 = null;
                            }
                        } else if (view instanceof GifView) {
                            GifView gifView = (GifView) view;
                            if (gifView.getBdImage() == null) {
                                return true;
                            }
                            this.j1 = gifView.getBdImage();
                            if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                                this.k1 = gifView.getBdImage().q();
                            }
                            if (view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info) != null && (view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.l1 = (TbRichTextMemeInfo) view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info);
                            } else {
                                this.l1 = null;
                            }
                        } else if (view instanceof TbMemeImageView) {
                            TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                            if (tbMemeImageView.getBdImage() != null) {
                                this.j1 = tbMemeImageView.getBdImage();
                                if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                    this.k1 = tbMemeImageView.getBdImage().q();
                                }
                                if (view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info) != null && (view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                    this.l1 = (TbRichTextMemeInfo) view.getTag(c.a.t0.s2.i.tag_rich_text_meme_info);
                                } else {
                                    this.l1 = null;
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
                            this.F0.p3(this.q2, this.j1.t());
                        }
                        sparseArray = sparseArray2;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                }
                PostData postData = (PostData) sparseArray.get(c.a.t0.s2.i.tag_clip_board);
                this.o2 = postData;
                if (postData == null) {
                    return true;
                }
                if (postData.A() == 1 && isImage(view)) {
                    this.F0.p3(this.q2, this.j1.t());
                    return true;
                }
                c.a.s0.i.a aVar2 = this.A0;
                if (aVar2 == null) {
                    return true;
                }
                boolean z6 = aVar2.e() && this.o2.G() != null && this.o2.G().equals(this.y0.M0());
                boolean z7 = getPbModel().R0() != null && getPbModel().R0().g0();
                boolean z8 = getPbModel().R0() != null && getPbModel().R0().j0();
                if (this.o2.A() == 1) {
                    if (!z7) {
                        this.F0.q3(this.p2, z6, false, z8);
                    }
                    return true;
                }
                if (this.K0 == null) {
                    c.a.s0.s.s.j jVar = new c.a.s0.s.s.j(getContext());
                    this.K0 = jVar;
                    jVar.m(this.X1);
                }
                ArrayList arrayList = new ArrayList();
                if (view == null || sparseArray == null) {
                    return true;
                }
                boolean z9 = isImage(view) && !z7;
                boolean z10 = (!isImage(view) || (aVar = this.j1) == null || aVar.t()) ? false : true;
                boolean booleanValue = sparseArray.get(c.a.t0.s2.i.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_is_subpb)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(c.a.t0.s2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue4 = sparseArray.get(c.a.t0.s2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue5 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue6 = sparseArray.get(c.a.t0.s2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_should_delete_visible)).booleanValue() : false;
                String str = sparseArray.get(c.a.t0.s2.i.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_forbid_user_post_id) : null;
                boolean booleanValue7 = sparseArray.get(c.a.t0.s2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_is_self_post)).booleanValue() : false;
                if (z9) {
                    z3 = booleanValue7;
                    z5 = booleanValue6;
                    z4 = booleanValue5;
                    arrayList.add(new c.a.s0.s.s.g(1, getString(c.a.t0.s2.l.save_to_emotion), this.K0));
                } else {
                    z3 = booleanValue7;
                    z4 = booleanValue5;
                    z5 = booleanValue6;
                }
                if (z10) {
                    arrayList.add(new c.a.s0.s.s.g(2, getString(c.a.t0.s2.l.save_to_local), this.K0));
                }
                if (!z9 && !z10) {
                    c.a.s0.s.s.g gVar5 = new c.a.s0.s.s.g(3, getString(c.a.t0.s2.l.copy), this.K0);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(c.a.t0.s2.i.tag_clip_board, this.o2);
                    gVar5.f13917d.setTag(sparseArray3);
                    arrayList.add(gVar5);
                }
                if (!booleanValue && !z7) {
                    if (z6) {
                        gVar4 = new c.a.s0.s.s.g(4, getString(c.a.t0.s2.l.remove_mark), this.K0);
                    } else {
                        gVar4 = new c.a.s0.s.s.g(4, getString(c.a.t0.s2.l.mark), this.K0);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(c.a.t0.s2.i.tag_clip_board, this.o2);
                    sparseArray4.put(c.a.t0.s2.i.tag_is_subpb, Boolean.FALSE);
                    gVar4.f13917d.setTag(sparseArray4);
                    arrayList.add(gVar4);
                }
                if (this.mIsLogin && !this.t0) {
                    if (!c.a.t0.s2.u.f.g1.a.h(this.y0) && !booleanValue4 && booleanValue3) {
                        c.a.s0.s.s.g gVar6 = new c.a.s0.s.s.g(5, getString(c.a.t0.s2.l.mute_option), this.K0);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                        int i3 = c.a.t0.s2.i.tag_is_mem;
                        sparseArray5.put(i3, sparseArray.get(i3));
                        int i4 = c.a.t0.s2.i.tag_user_mute_mute_userid;
                        sparseArray5.put(i4, sparseArray.get(i4));
                        int i5 = c.a.t0.s2.i.tag_user_mute_mute_username;
                        sparseArray5.put(i5, sparseArray.get(i5));
                        int i6 = c.a.t0.s2.i.tag_user_mute_mute_nameshow;
                        sparseArray5.put(i6, sparseArray.get(i6));
                        int i7 = c.a.t0.s2.i.tag_user_mute_post_id;
                        sparseArray5.put(i7, sparseArray.get(i7));
                        int i8 = c.a.t0.s2.i.tag_user_mute_thread_id;
                        sparseArray5.put(i8, sparseArray.get(i8));
                        int i9 = c.a.t0.s2.i.tag_del_post_is_self;
                        sparseArray5.put(i9, sparseArray.get(i9));
                        int i10 = c.a.t0.s2.i.tag_del_post_type;
                        sparseArray5.put(i10, sparseArray.get(i10));
                        int i11 = c.a.t0.s2.i.tag_del_post_id;
                        sparseArray5.put(i11, sparseArray.get(i11));
                        int i12 = c.a.t0.s2.i.tag_manage_user_identity;
                        sparseArray5.put(i12, sparseArray.get(i12));
                        gVar6.f13917d.setTag(sparseArray5);
                        arrayList.add(gVar6);
                    } else {
                        if ((h3(booleanValue2) && TbadkCoreApplication.isLogin()) && !z7) {
                            c.a.s0.s.s.g gVar7 = new c.a.s0.s.s.g(5, getString(c.a.t0.s2.l.report_text), this.K0);
                            gVar7.f13917d.setTag(str);
                            arrayList.add(gVar7);
                        }
                    }
                    if (booleanValue4) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(c.a.t0.s2.i.tag_should_manage_visible, Boolean.TRUE);
                        int i13 = c.a.t0.s2.i.tag_manage_user_identity;
                        sparseArray6.put(i13, sparseArray.get(i13));
                        int i14 = c.a.t0.s2.i.tag_forbid_user_name;
                        sparseArray6.put(i14, sparseArray.get(i14));
                        int i15 = c.a.t0.s2.i.tag_forbid_user_name_show;
                        sparseArray6.put(i15, sparseArray.get(i15));
                        int i16 = c.a.t0.s2.i.tag_forbid_user_portrait;
                        sparseArray6.put(i16, sparseArray.get(i16));
                        sparseArray6.put(c.a.t0.s2.i.tag_forbid_user_post_id, str);
                        if (!c.a.t0.s2.u.f.g1.a.h(this.y0) && z4) {
                            sparseArray6.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.TRUE);
                            int i17 = c.a.t0.s2.i.tag_is_mem;
                            sparseArray6.put(i17, sparseArray.get(i17));
                            int i18 = c.a.t0.s2.i.tag_user_mute_mute_userid;
                            sparseArray6.put(i18, sparseArray.get(i18));
                            int i19 = c.a.t0.s2.i.tag_user_mute_mute_username;
                            sparseArray6.put(i19, sparseArray.get(i19));
                            int i20 = c.a.t0.s2.i.tag_user_mute_mute_nameshow;
                            sparseArray6.put(i20, sparseArray.get(i20));
                            int i21 = c.a.t0.s2.i.tag_user_mute_post_id;
                            sparseArray6.put(i21, sparseArray.get(i21));
                            int i22 = c.a.t0.s2.i.tag_user_mute_thread_id;
                            sparseArray6.put(i22, sparseArray.get(i22));
                        } else {
                            sparseArray6.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                        }
                        if (z5) {
                            sparseArray6.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray6.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                            int i23 = c.a.t0.s2.i.tag_del_post_id;
                            sparseArray6.put(i23, sparseArray.get(i23));
                            int i24 = c.a.t0.s2.i.tag_del_post_type;
                            sparseArray6.put(i24, sparseArray.get(i24));
                            int i25 = c.a.t0.s2.i.tag_has_sub_post;
                            sparseArray6.put(i25, sparseArray.get(i25));
                            sparseArray6.put(c.a.t0.s2.i.tag_is_self_post, Boolean.valueOf(z3));
                            if (z3) {
                                c.a.s0.s.s.g gVar8 = new c.a.s0.s.s.g(6, getString(c.a.t0.s2.l.delete), this.K0);
                                gVar8.f13917d.setTag(sparseArray6);
                                gVar2 = gVar8;
                                gVar = new c.a.s0.s.s.g(7, getString(c.a.t0.s2.l.bar_manager), this.K0);
                                gVar.f13917d.setTag(sparseArray6);
                            }
                        } else {
                            sparseArray6.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.FALSE);
                        }
                        gVar2 = null;
                        gVar = new c.a.s0.s.s.g(7, getString(c.a.t0.s2.l.bar_manager), this.K0);
                        gVar.f13917d.setTag(sparseArray6);
                    } else if (z5) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(c.a.t0.s2.i.tag_should_manage_visible, Boolean.FALSE);
                        sparseArray7.put(c.a.t0.s2.i.tag_user_mute_visible, Boolean.FALSE);
                        sparseArray7.put(c.a.t0.s2.i.tag_should_delete_visible, Boolean.TRUE);
                        int i26 = c.a.t0.s2.i.tag_manage_user_identity;
                        sparseArray7.put(i26, sparseArray.get(i26));
                        sparseArray7.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i27 = c.a.t0.s2.i.tag_del_post_id;
                        sparseArray7.put(i27, sparseArray.get(i27));
                        int i28 = c.a.t0.s2.i.tag_del_post_type;
                        sparseArray7.put(i28, sparseArray.get(i28));
                        int i29 = c.a.t0.s2.i.tag_has_sub_post;
                        sparseArray7.put(i29, sparseArray.get(i29));
                        if (this.y0.R0().V() == 1002 && !booleanValue2) {
                            gVar3 = new c.a.s0.s.s.g(6, getString(c.a.t0.s2.l.report_text), this.K0);
                        } else {
                            gVar3 = new c.a.s0.s.s.g(6, getString(c.a.t0.s2.l.delete), this.K0);
                        }
                        gVar3.f13917d.setTag(sparseArray7);
                        gVar2 = gVar3;
                        gVar = null;
                    } else {
                        gVar = null;
                        gVar2 = null;
                    }
                    if (gVar2 != null) {
                        arrayList.add(gVar2);
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                    c.a.t0.s2.u.f.g1.a.a(arrayList, this.K0, this.o2, this.y0);
                }
                if (c.a.s0.b.d.N()) {
                    b4 = c.a.t0.s2.u.f.g1.a.c(arrayList, this.o2.q(), sparseArray, this.K0);
                } else {
                    b4 = c.a.t0.s2.u.f.g1.a.b(arrayList, this.o2.q(), sparseArray, this.K0);
                }
                c.a.t0.s2.u.f.g1.a.k(b4, this.f48263f);
                c.a.t0.s2.u.f.g1.a.e(b4);
                this.K0.n(c.a.t0.s2.u.f.g1.a.f(this.o2));
                if (c.a.s0.b.d.N()) {
                    this.K0.k(b4, false);
                } else {
                    this.K0.k(b4, true);
                }
                PopupDialog popupDialog = new PopupDialog(getPageContext(), this.K0);
                this.J0 = popupDialog;
                popupDialog.showDialog();
                TiebaStatic.log(new StatisticItem("c13272").param("tid", this.y0.f48398f).param("fid", this.y0.getForumId()).param("uid", this.y0.R0().O().J().getUserId()).param("post_id", this.y0.y()).param("obj_source", booleanValue ? 2 : 1));
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
                    c.a.s0.t.h.b.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                } else {
                    c.a.t0.w3.s0.m.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                    return;
                }
            }
            return;
        }
        if (!this.y0.F0()) {
            antiData.setBlock_forum_name(this.y0.R0().l().getName());
            antiData.setBlock_forum_id(this.y0.R0().l().getId());
            antiData.setUser_name(this.y0.R0().U().getUserName());
            antiData.setUser_id(this.y0.R0().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void G2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        c.a.t0.w3.j0.p z3 = this.y0.R0().z();
        if (z3 != null && str.equals(z3.K0())) {
            if (z3.getAdvertAppInfo() != null) {
                z3.getAdvertAppInfo().n4 = null;
            }
            this.y0.R0().b();
        }
        c.a.t0.w3.j0.p l02 = this.y0.l0();
        if (l02 == null || !str.equals(l02.K0())) {
            return;
        }
        this.y0.W();
    }

    public final void G3(long j3, String str, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
            c.a.t0.s2.u.f.g1.b.l(this, j3, str, j4);
        }
    }

    public final void H2(String str) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (pbModel = this.y0) == null || pbModel.R0() == null || this.y0.R0().O() == null || !this.y0.R0().O().G2()) {
            return;
        }
        c.a.s0.s.q.d2 O = this.y0.R0().O();
        int i3 = 0;
        if (O.P1()) {
            i3 = 1;
        } else if (O.S1()) {
            i3 = 2;
        } else if (O.Q1()) {
            i3 = 3;
        } else if (O.R1()) {
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
            c.a.t0.s2.u.f.g1.a.d(getActivity(), getPageContext(), new v0(this, sparseArray, i3, z3), new w0(this));
        }
    }

    public final void I2(ForumManageModel.b bVar, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048592, this, bVar, z3) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.f50066b) ? bVar.f50066b : getString(c.a.t0.s2.l.delete_fail);
            int i3 = 0;
            if (bVar.f50067c == 1211066) {
                hideProgressBar();
                c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getPageContext().getPageActivity());
                aVar.setMessage(string);
                aVar.setPositiveButton(c.a.t0.s2.l.dialog_known, new s1(this));
                aVar.setCancelable(true);
                aVar.create(getPageContext());
                aVar.show();
            } else if (bVar.f50068d != 0) {
                this.F0.k0(0, bVar.a, bVar.f50066b, z3);
            }
            if (bVar.a) {
                int i4 = bVar.f50068d;
                if (i4 == 1) {
                    ArrayList<PostData> F = this.y0.R0().F();
                    int size = F.size();
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (bVar.f50071g.equals(F.get(i3).G())) {
                            F.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    this.y0.R0().O().r4(this.y0.R0().O().V0() - 1);
                    this.F0.t1(this.y0.R0());
                } else if (i4 == 0) {
                    E2();
                } else if (i4 == 2) {
                    ArrayList<PostData> F2 = this.y0.R0().F();
                    int size2 = F2.size();
                    boolean z4 = false;
                    for (int i5 = 0; i5 < size2 && !z4; i5++) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= F2.get(i5).P().size()) {
                                break;
                            } else if (bVar.f50071g.equals(F2.get(i5).P().get(i6).G())) {
                                F2.get(i5).P().remove(i6);
                                F2.get(i5).l();
                                z4 = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        F2.get(i5).n(bVar.f50071g);
                    }
                    if (z4) {
                        this.F0.t1(this.y0.R0());
                    }
                    delGodReplyFloor(bVar, this.F0);
                }
            }
        }
    }

    public final boolean I3(boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        c.a.s0.s.q.e0 e0Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.R0() == null) {
                return false;
            }
            c.a.t0.s2.r.f R0 = this.y0.R0();
            c.a.s0.s.q.d2 O = R0.O();
            if (O != null) {
                if (O.P1() || O.S1()) {
                    return false;
                }
                if (O.Q1() || O.R1()) {
                    return z3;
                }
            }
            if (z3) {
                return true;
            }
            if ((O != null && O.J() != null && O.J().isForumBusinessAccount() && !c.a.t0.d1.w0.isOn()) || this.y0.E() || O.M2() || O.v2() || z4) {
                return false;
            }
            if (R0.l() == null || !R0.l().isBlockBawuDelete) {
                if (R0.O() == null || !R0.O().V1()) {
                    if (R0.V() != 0) {
                        return R0.V() != 3;
                    }
                    List<c.a.s0.s.q.z1> p3 = R0.p();
                    if (ListUtils.getCount(p3) > 0) {
                        for (c.a.s0.s.q.z1 z1Var : p3) {
                            if (z1Var != null && (e0Var = z1Var.f13869g) != null && e0Var.a && !e0Var.f13674c && ((i3 = e0Var.f13673b) == 1 || i3 == 2)) {
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

    public final void J2(int i3, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048594, this, i3, gVar) == null) || gVar == null) {
            return;
        }
        this.F0.k0(this.B0.getLoadDataMode(), gVar.a, gVar.f50084b, false);
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
                this.y0.R0().O().b4(1);
                this.y0.l2(1);
            } else if (i3 == 3) {
                this.y0.R0().O().b4(0);
                this.y0.l2(0);
            } else if (i3 == 4) {
                this.y0.R0().O().c4(1);
                this.y0.m2(1);
            } else if (i3 == 5) {
                this.y0.R0().O().c4(0);
                this.y0.m2(0);
            }
            this.F0.I3(this.y0.R0(), this.y0.f1());
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f50084b)) {
            string = gVar.f50084b;
        } else {
            string = getString(c.a.t0.s2.l.operation_failed);
        }
        c.a.d.f.p.n.M(getPageContext().getPageActivity(), string);
    }

    public final boolean J3(boolean z3) {
        InterceptResult invokeZ;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z3)) == null) {
            if (z3 || (pbModel = this.y0) == null || pbModel.R0() == null || (this.y0.R0().l() != null && this.y0.R0().l().isBlockBawuDelete)) {
                return false;
            }
            c.a.t0.s2.r.f R0 = this.y0.R0();
            if ((R0.O() == null || R0.O().J() == null || !R0.O().J().isForumBusinessAccount() || c.a.t0.d1.w0.isOn()) && !this.y0.E()) {
                return ((R0.O() != null && R0.O().V1()) || this.y0.R0().V() == 0 || this.y0.R0().V() == 3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void K2(Rect rect) {
        c.a.t0.s2.u.f.t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, rect) == null) || rect == null || (t0Var = this.F0) == null || t0Var.Y0() == null || rect.top > this.F0.Y0().getHeight()) {
            return;
        }
        rect.top += this.F0.Y0().getHeight() - rect.top;
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
            if (this.y0.R0() == null || this.y0.R0().O() == null) {
                return -1;
            }
            return this.y0.R0().O().w();
        }
        return invokeV.intValue;
    }

    public final boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.f1()) {
                return this.y0.P0() == null || this.y0.P0().c() != 0;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String M2() {
        InterceptResult invokeV;
        c.a.t0.s2.r.f R0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || (R0 = pbModel.R0()) == null) {
                return null;
            }
            return R0.T().f23101c;
        }
        return (String) invokeV.objValue;
    }

    public final void M3(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, metaData) == null) || metaData == null) {
            return;
        }
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getActivity());
        aVar.setTitle(getResources().getString(c.a.t0.s2.l.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(getResources().getString(c.a.t0.s2.l.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(getResources().getString(c.a.t0.s2.l.mark_like_cancel), new m1(this, metaData));
        aVar.setPositiveButton(getResources().getString(c.a.t0.s2.l.mark_like_confirm), new n1(this, metaData));
        aVar.create(getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public final String N2() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.R0() == null || this.y0.R0().F() == null || (count = ListUtils.getCount((F = this.y0.R0().F()))) == 0) {
                return "";
            }
            if (this.y0.c1()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.G();
                    }
                }
            }
            int u02 = this.F0.u0();
            PostData postData = (PostData) ListUtils.getItem(F, u02);
            if (postData != null && postData.t() != null) {
                if (this.y0.D1(postData.t().getUserId())) {
                    return postData.G();
                }
                for (int i3 = u02 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                        break;
                    } else if (this.y0.D1(postData2.t().getUserId())) {
                        return postData2.G();
                    }
                }
                for (int i4 = u02 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                        break;
                    } else if (this.y0.D1(postData3.t().getUserId())) {
                        return postData3.G();
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
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(c.a.t0.s2.l.mute_is_super_member_function));
            aVar.setPositiveButton(c.a.t0.s2.l.open_now, new x2(this));
            aVar.setNegativeButton(c.a.t0.s2.l.cancel, new y2(this));
            aVar.create(this.e1).show();
        }
    }

    public final TbRichText O2(ArrayList<PostData> arrayList, String str, int i3) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> y3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048604, this, arrayList, str, i3)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    TbRichText N = arrayList.get(i4).N();
                    if (N != null && (y3 = N.y()) != null) {
                        int size = y3.size();
                        int i5 = -1;
                        for (int i6 = 0; i6 < size; i6++) {
                            if (y3.get(i6) != null && y3.get(i6).getType() == 8) {
                                i5++;
                                if (y3.get(i6).C().y().equals(str) || y3.get(i6).C().z().equals(str)) {
                                    int h3 = (int) c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
                                    int width = y3.get(i6).C().getWidth() * h3;
                                    int height = y3.get(i6).C().getHeight() * h3;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.l2 = i6;
                                    return N;
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
        if ((interceptable == null || interceptable.invokeZL(1048605, this, z3, sparseArray) == null) && (sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(c.a.t0.s2.i.tag_check_mute_from) instanceof Integer)) {
            PopupDialog popupDialog = this.J0;
            if (popupDialog != null && popupDialog.isShowing()) {
                this.J0.dismiss();
                this.J0 = null;
            }
            String str = (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(c.a.t0.s2.i.tag_user_mute_visible)).booleanValue()) {
                c.a.s0.s.s.j jVar = new c.a.s0.s.s.j(getContext());
                jVar.m(new a0(this, sparseArray, z3, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(c.a.t0.s2.i.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(c.a.t0.s2.i.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new c.a.s0.s.s.g(0, getResources().getString(c.a.t0.s2.l.delete), jVar));
                }
                if (z3) {
                    arrayList.add(new c.a.s0.s.s.g(1, getResources().getString(c.a.t0.s2.l.un_mute), jVar));
                } else {
                    arrayList.add(new c.a.s0.s.s.g(1, getResources().getString(c.a.t0.s2.l.mute), jVar));
                }
                jVar.j(arrayList);
                PopupDialog popupDialog2 = new PopupDialog(getPageContext(), jVar);
                this.J0 = popupDialog2;
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
                        int h3 = (int) c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.C().getWidth() * h3;
                        int height = tbRichTextData.C().getHeight() * h3;
                        if ((width < 80 || height < 80 || width * height < 10000) || !tbRichTextData.C().D()) {
                            if (tbRichText == tbRichText2) {
                                if (i6 <= i4) {
                                    i5--;
                                }
                            }
                        } else if (tbRichTextData.getType() != 20) {
                            String a4 = c.a.t0.s2.r.g.a(tbRichTextData);
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
                                    imageUrlData.threadId = c.a.d.f.m.b.g(this.y0.h1(), -1L);
                                    imageUrlData.mIsReserver = this.y0.c1();
                                    imageUrlData.mIsSeeHost = this.y0.v0();
                                    if (concurrentHashMap != null) {
                                        concurrentHashMap.put(a4, imageUrlData);
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

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            showLoadingView(this.F0.a1(), false, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.t0.s2.g.ds400));
            View i3 = getLoadingView().i();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) i3.getLayoutParams();
            layoutParams.addRule(3, this.F0.Y0().getId());
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
                getPbModel().Z(postWriteCallBackData.getPostId());
                int r02 = this.F0.r0();
                this.n1 = r02;
                this.y0.h2(r02, this.F0.y0());
            }
            this.F0.c0();
            this.mContentProcessController.c();
            c.a.s0.x.y.e eVar = this.T0;
            if (eVar != null) {
                this.F0.v2(eVar.C());
            }
            this.F0.e1();
            this.F0.c3(true);
            this.y0.q1();
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
            c.a.t0.s2.u.f.g1.b.o(this, L2(), i3);
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
            c.a.d.a.f fVar = this.e1;
            if (fVar == null) {
                return;
            }
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(fVar.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(c.a.t0.s2.l.know, new z2(this));
            aVar.create(this.e1).show();
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
                this.F0.k3();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.e1.getPageActivity());
            if (c.a.d.f.p.m.isEmpty(str)) {
                aVar.setMessage(this.e1.getResources().getString(c.a.t0.s2.l.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(c.a.t0.s2.l.confirm, new a(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(c.a.t0.s2.l.cancel, new b(this));
            aVar.create(this.e1).show();
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
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (pbModel = this.y0) == null || c.a.d.f.p.m.isEmpty(pbModel.h1())) {
            return;
        }
        c.a.s0.a.d.y().R(c.a.s0.a.c.X, c.a.d.f.m.b.g(this.y0.h1(), 0L));
    }

    public final int V2(c.a.t0.s2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, fVar)) == null) {
            if (fVar == null || fVar.O() == null) {
                return 0;
            }
            if (fVar.O().r1() == 0) {
                return 1;
            }
            if (fVar.O().r1() == 54) {
                return 2;
            }
            return fVar.O().r1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public final void V3(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, sparseArray) == null) && checkUpIsLogin() && sparseArray != null && (sparseArray.get(c.a.t0.s2.i.tag_clip_board) instanceof PostData) && (postData = (PostData) sparseArray.get(c.a.t0.s2.i.tag_clip_board)) != null) {
            W3(postData, false);
        }
    }

    public final void W2(int i3, Intent intent) {
        c.a.s0.x.n nVar;
        c.a.s0.x.n nVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048620, this, i3, intent) == null) {
            if (i3 == 0) {
                this.F0.e1();
                this.F0.O0().c();
                this.F0.c3(false);
            }
            this.F0.o2();
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
                    if (editorType != 1 || this.F0.O0() == null || this.F0.O0().b() == null) {
                        return;
                    }
                    c.a.s0.x.y.h b4 = this.F0.O0().b();
                    b4.b0(this.y0.R0().O());
                    b4.B(writeData);
                    b4.c0(pbEditorData.getVoiceModel());
                    c.a.s0.x.m findToolById = b4.a().findToolById(6);
                    if (findToolById != null && (nVar2 = findToolById.f14538k) != null) {
                        nVar2.onAction(new c.a.s0.x.a(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i3 == -1) {
                        b4.F();
                        return;
                    }
                    return;
                }
                this.T0.S();
                this.T0.t0(pbEditorData.getVoiceModel());
                this.T0.G(writeData);
                c.a.s0.x.m findToolById2 = this.T0.a().findToolById(6);
                if (findToolById2 != null && (nVar = findToolById2.f14538k) != null) {
                    nVar.onAction(new c.a.s0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i3 == -1) {
                    this.T0.L(null, null);
                }
            }
        }
    }

    public final void W3(PostData postData, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048621, this, postData, z3) == null) || postData == null || (pbModel = this.y0) == null || pbModel.R0() == null || postData.A() == 1) {
            return;
        }
        String h12 = this.y0.h1();
        String G = postData.G();
        int V = this.y0.R0() != null ? this.y0.R0().V() : 0;
        AbsPbActivity.e t3 = t3(G);
        if (t3 == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(h12, G, "pb", true, false, null, false, null, V, postData.S(), this.y0.R0().d(), false, postData.t() != null ? postData.t().getIconInfo() : null, 5).addBigImageData(t3.a, t3.f48229b, t3.f48234g, t3.f48237j);
        addBigImageData.setKeyPageStartFrom(this.y0.Q0());
        addBigImageData.setFromFrsForumId(this.y0.getFromForumId());
        addBigImageData.setWorksInfoData(this.y0.m1());
        addBigImageData.setKeyFromForumId(this.y0.getForumId());
        addBigImageData.setBjhData(this.y0.k0());
        addBigImageData.setIsOpenEditor(z3);
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public final void X2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.R0() != null && this.y0.R0().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.y0.h1(), str);
                c.a.s0.s.q.d2 O = this.y0.R0().O();
                if (O.P1()) {
                    format = format + "&channelid=33833";
                } else if (O.U1()) {
                    format = format + "&channelid=33842";
                } else if (O.S1()) {
                    format = format + "&channelid=33840";
                }
                i3(format);
                return;
            }
            this.z0.a(str);
        }
    }

    public final void X3() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (absPbActivity = this.f48262e) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public final void Y2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, intent) == null) {
            c.a.t0.s2.u.f.g1.b.j(this, intent);
        }
    }

    public final boolean Y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel == null) {
                return true;
            }
            if (pbModel.R0() == null || !this.y0.R0().g0()) {
                if (this.y0.D0()) {
                    MarkData o02 = this.y0.o0();
                    if (o02 != null && this.y0.B0()) {
                        MarkData i02 = this.y0.i0(this.F0.u0());
                        if (i02 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", o02);
                            this.f48262e.setResult(-1, intent);
                            return true;
                        } else if (i02.getPostId() != null && !i02.getPostId().equals(o02.getPostId())) {
                            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getPageContext().getPageActivity());
                            aVar.setMessage(getPageContext().getString(c.a.t0.s2.l.alert_update_mark));
                            aVar.setPositiveButton(c.a.t0.s2.l.confirm, new z1(this, i02, o02, aVar));
                            aVar.setNegativeButton(c.a.t0.s2.l.cancel, new a2(this, o02, aVar));
                            aVar.setOnCalcelListener(new b2(this, o02, aVar));
                            aVar.create(getPageContext());
                            aVar.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", o02);
                            this.f48262e.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (this.y0.R0() != null && this.y0.R0().F() != null && this.y0.R0().F().size() > 0 && this.y0.B0()) {
                    this.f48262e.setResult(1);
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
            c.a.s0.e1.n0.b(new e(this, i4), new f(this, i4, i3));
        }
    }

    public final void Z3() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absPbActivity = this.f48262e) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c14396").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f48262e.getPbModel().h1()).param("topic_id", this.f48262e.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.f48262e.getPbModel().l1()));
    }

    public final void a3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i3) == null) {
            c.a.s0.e1.n0.b(new c(this), new d(this, i3));
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
        if (!(interceptable == null || interceptable.invokeZ(1048629, this, z3) == null) || (absPbActivity = this.f48262e) == null || absPbActivity.getPbModel() == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(!z3 ? "c14397" : "c14398").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f48262e.getPbModel().h1()).param("topic_id", this.f48262e.getPbModel().getTopicId()).param(TiebaStatic.Params.TOPIC_TYPE, this.f48262e.getPbModel().l1()));
    }

    public void addBackInterceptor(b3 b3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, b3Var) == null) || b3Var == null) {
            return;
        }
        if (this.p1 == null) {
            this.p1 = new ArrayList();
        }
        if (this.p1.contains(b3Var)) {
            return;
        }
        this.p1.add(b3Var);
    }

    public void addBackInterceptorAtFirst(b3 b3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, b3Var) == null) || b3Var == null) {
            return;
        }
        if (this.p1 == null) {
            this.p1 = new ArrayList();
        }
        if (this.p1.contains(b3Var)) {
            return;
        }
        this.p1.add(0, b3Var);
    }

    public final void b3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bundle) == null) {
            c.a.s0.i.a c4 = c.a.s0.i.a.c(this.f48262e);
            this.A0 = c4;
            if (c4 != null) {
                c4.j(this.e2);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f48262e);
            this.B0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.g2);
            this.C0 = new c.a.s0.t.e.a(getPageContext());
            this.L1.setUniqueId(getUniqueId());
            this.L1.registerListener();
        }
    }

    public final void b4(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i3) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.y0.f48398f).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(c.a.t0.s2.u.f.g1.a.m(i3))));
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            LikeModel likeModel = new LikeModel(getPageContext());
            this.V = likeModel;
            likeModel.setLoadDataCallBack(new h0(this));
        }
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.B(this.y0.getForumId()) && this.y0.R0() != null && this.y0.R0().l() != null) {
            if (this.y0.R0().l().isLike() == 1) {
                this.y0.f0().A(this.y0.getForumId(), this.y0.h1());
            }
        }
    }

    public void checkEasterEgg(boolean z3) {
        c.a.t0.s2.u.f.t0 t0Var;
        int w3;
        int w4;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048636, this, z3) == null) || (t0Var = this.F0) == null || t0Var.E0() == null) {
            return;
        }
        int firstVisiblePosition = this.F0.E0().getFirstVisiblePosition();
        int lastVisiblePosition = this.F0.E0().getLastVisiblePosition();
        c.a.t0.s2.u.f.h n02 = this.F0.n0();
        if (n02 == null || this.y0.R0() == null) {
            return;
        }
        if (lastVisiblePosition <= n02.w()) {
            w3 = 0;
            w4 = 1;
        } else {
            w3 = firstVisiblePosition > n02.w() ? firstVisiblePosition - n02.w() : 0;
            w4 = (lastVisiblePosition - n02.w()) + 1;
        }
        ArrayList arrayList = new ArrayList();
        if (w4 > w3) {
            while (w3 < w4) {
                if (this.F0.E0().getItem(w3) != null && (this.F0.E0().getItem(w3) instanceof PostData) && (postData = (PostData) this.F0.E0().getItem(w3)) != null) {
                    PostData postData2 = (PostData) ListUtils.getItem(this.y0.R0().F(), postData.A() - 1);
                    if (postData.p() == null && postData2 != null) {
                        postData.k0(postData2.p());
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
            Collections.sort(arrayList, new p1(this));
            c.a.s0.u.a aVar = (c.a.s0.u.a) ListUtils.getItem(arrayList, 0);
            if (aVar == null || aVar.e() != 1) {
                this.F0.c2(aVar, 1);
            } else if (z3) {
            } else {
                this.F0.c2(aVar, 0);
            }
        }
    }

    public void checkMuteState(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.F0.k3();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = c.a.d.f.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.d.f.m.b.g((String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.g1;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.d1 = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean checkPrivacyBeforeInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if ((this.y0.R0() != null && (this.y0.R0().g0() || ThreadCardUtils.isSelf(this.y0.R0().O()))) || this.mReplyPrivacyController == null || this.y0.R0() == null || this.y0.R0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.y0.R0().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public boolean checkPrivacyBeforePost(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i3)) == null) {
            if (this.mReplyPrivacyController == null || this.y0.R0() == null || ThreadCardUtils.isSelf(this.y0.R0().O()) || this.y0.R0().d() == null) {
                return true;
            }
            return this.mReplyPrivacyController.checkPrivacyBeforeSend(this.y0.R0().d().replyPrivateFlag, i3);
        }
        return invokeI.booleanValue;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && this.q == null) {
            this.q = new c.a.s0.s.s.c(getPageContext().getPageActivity());
            String[] strArr = {getPageContext().getString(c.a.t0.s2.l.call_phone), getPageContext().getString(c.a.t0.s2.l.sms_phone), getPageContext().getString(c.a.t0.s2.l.search_in_baidu)};
            c.a.s0.s.s.c cVar = this.q;
            cVar.j(strArr, new k0(this));
            cVar.g(c.b.a);
            cVar.h(17);
            cVar.c(getPageContext());
        }
    }

    public final void d4(c.a.s0.s.q.u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, uVar) == null) || uVar == null) {
            return;
        }
        this.B2 = uVar;
        this.f48264g = true;
        this.F0.l2();
        this.F0.D2(this.A2);
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048642, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (c.a.s0.g1.n.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), c.a.s0.g1.n.f.class);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (c.a.t0.s2.u.f.y0.c(objArr[i3].d()) && (drawable = SkinManager.getDrawable(c.a.t0.s2.h.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new c.a.s0.g1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i3], spannableStringBuilder.getSpanStart(objArr[i3]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void delGodReplyFloor(ForumManageModel.b bVar, c.a.t0.s2.u.f.t0 t0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, bVar, t0Var) == null) {
            List<PostData> list = this.y0.R0().T().a;
            int size = list.size();
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.get(i3).P().size()) {
                        break;
                    } else if (bVar.f50071g.equals(list.get(i3).P().get(i4).G())) {
                        list.get(i3).P().remove(i4);
                        list.get(i3).l();
                        z3 = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                list.get(i3).n(bVar.f50071g);
            }
            if (z3) {
                t0Var.t1(this.y0.R0());
            }
        }
    }

    public void deleteThread(c.a.s0.s.s.a aVar, JSONArray jSONArray) {
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
            sparseArray.put(c.a.t0.s2.i.tag_del_post_id, str);
            sparseArray.put(c.a.t0.s2.i.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(c.a.t0.s2.i.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(c.a.t0.s2.i.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(c.a.t0.s2.u.f.t0.X1, Integer.valueOf(c.a.t0.s2.u.f.t0.Y1));
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
            c.a.t0.s2.u.f.t0 t0Var = this.F0;
            if (t0Var == null || this.y0 == null) {
                return;
            }
            if ((t0Var != null && !t0Var.v1()) || this.y0.R0() == null || this.y0.R0().S() == null) {
                return;
            }
            c.a.t0.s2.u.f.t0 t0Var2 = this.F0;
            if (t0Var2 == null || t0Var2.t0() == null || !this.F0.t0().isFalling()) {
                c.a.t0.s2.r.r S = this.y0.R0().S();
                if (checkUpIsLogin()) {
                    if ((!S.g() || S.a() != 2) && this.F0.n0() != null && this.F0.n0().z() != null) {
                        this.F0.n0().z().c0(this.y0.h1(), this.y0.getFromForumId());
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
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || this.F0 == null || (pbModel = this.y0) == null) {
            return;
        }
        if ((pbModel.R0() == null && this.y0.R0().S() == null) || !checkUpIsLogin() || this.F0.n0() == null || this.F0.n0().z() == null) {
            return;
        }
        this.F0.n0().z().c0(this.y0.h1(), this.y0.getFromForumId());
    }

    public final boolean e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            AbsPbActivity absPbActivity = this.f48262e;
            return (absPbActivity == null || absPbActivity.getPbModel() == null || this.f48262e.getPbModel().Q0() != 17) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void e4(int i3) {
        PbModel pbModel;
        c.a.s0.s.q.d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048650, this, i3) == null) || (pbModel = this.y0) == null || pbModel.R0() == null || (O = this.y0.R0().O()) == null) {
            return;
        }
        if (i3 == 1) {
            PraiseData M0 = O.M0();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (M0 == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i3);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    O.q4(praiseData);
                } else {
                    O.M0().getUser().add(0, metaData);
                    O.M0().setNum(O.M0().getNum() + 1);
                    O.M0().setIsLike(i3);
                }
            }
            if (O.M0() != null) {
                if (O.M0().getNum() < 1) {
                    getResources().getString(c.a.t0.s2.l.zan);
                } else {
                    StringHelper.numFormatOver10000(O.M0().getNum());
                }
            }
        } else if (O.M0() != null) {
            O.M0().setIsLike(i3);
            O.M0().setNum(O.M0().getNum() - 1);
            ArrayList<MetaData> user = O.M0().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        O.M0().getUser().remove(next);
                        break;
                    }
                }
            }
            if (O.M0().getNum() < 1) {
                getResources().getString(c.a.t0.s2.l.zan);
            } else {
                String str = O.M0().getNum() + "";
            }
        }
        if (this.y0.f1()) {
            this.F0.n0().X();
        } else {
            this.F0.K3(this.y0.R0());
        }
    }

    public final boolean f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            PostData c4 = c.a.t0.s2.r.g.c(this.y0.R0(), this.y0.f1(), this.y0.b1());
            return (c4 == null || c4.t() == null || c4.t().getGodUserData() == null || c4.t().getGodUserData().getType() != 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final TbRichText f4(String str, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048652, this, str, i3)) == null) {
            PbModel pbModel = this.y0;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.R0() == null || str == null || i3 < 0) {
                return null;
            }
            c.a.t0.s2.r.f R0 = this.y0.R0();
            if (R0.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(R0.j());
                tbRichText = O2(arrayList, str, i3);
            }
            if (tbRichText == null) {
                ArrayList<PostData> F = R0.F();
                A2(R0, F);
                return O2(F, str, i3);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // c.a.t0.s2.y.b
    public void finish() {
        c.a.t0.s2.u.f.t0 t0Var;
        CardHListViewData q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            c.a.t0.s2.u.f.t0 t0Var2 = this.F0;
            if (t0Var2 != null) {
                t0Var2.c0();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.R0() != null && !this.y0.R0().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = this.y0.R0().O().g0();
                if (this.y0.isShareThread() && this.y0.R0().O().A1 != null) {
                    historyMessage.threadName = this.y0.R0().O().A1.f41550b;
                } else {
                    historyMessage.threadName = this.y0.R0().O().getTitle();
                }
                if (this.y0.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = this.y0.R0().l().getName();
                }
                ArrayList<PostData> F = this.y0.R0().F();
                c.a.t0.s2.u.f.t0 t0Var3 = this.F0;
                int u02 = t0Var3 != null ? t0Var3.u0() : 0;
                if (F != null && u02 >= 0 && u02 < F.size()) {
                    historyMessage.postID = F.get(u02).G();
                }
                historyMessage.isHostOnly = this.y0.v0();
                historyMessage.isSquence = this.y0.f1();
                historyMessage.isShareThread = this.y0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            c.a.s0.x.y.e eVar = this.T0;
            if (eVar != null) {
                eVar.I();
            }
            if (this.n && getPbView() != null) {
                getPbView().h0();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && (pbModel2.x0() || this.y0.A0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", this.y0.h1());
                if (this.G0) {
                    if (this.I0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", this.y0.G0());
                    }
                    if (this.H0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", this.y0.C0());
                    }
                }
                if (this.y0.R0() != null && System.currentTimeMillis() - this.t >= 40000 && (q3 = this.y0.R0().q()) != null && !ListUtils.isEmpty(q3.getDataList())) {
                    intent.putExtra("guess_like_data", q3);
                    intent.putExtra("KEY_SMART_FRS_POSITION", this.o1);
                }
                this.f48262e.setResult(-1, intent);
            }
            if (Y3()) {
                if (this.y0 != null && (t0Var = this.F0) != null && t0Var.E0() != null) {
                    c.a.t0.s2.r.f R0 = this.y0.R0();
                    if (R0 != null) {
                        if (R0.U() != null) {
                            R0.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!R0.m0() && !this.M && R0.f23040h == null) {
                            c.a.t0.s2.u.f.l0.b().n(this.y0.S0(), this.F0.E0().onSaveInstanceState(), this.y0.f1(), this.y0.v0(), this.F0.M0() != null && this.F0.M0().getVisibility() == 0);
                            if (this.n1 >= 0 || this.y0.j1() != null) {
                                c.a.t0.s2.u.f.l0.b().q(this.y0.j1());
                                c.a.t0.s2.u.f.l0.b().r(this.y0.k1());
                                c.a.t0.s2.u.f.l0.b().o(this.y0.K0());
                            }
                        }
                    }
                } else {
                    c.a.t0.s2.u.f.l0.b().m();
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
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.R0() == null) {
                return null;
            }
            return this.y0.R0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public c.a.t0.s2.u.f.d1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.f48262e.getEventController() : (c.a.t0.s2.u.f.d1.a) invokeV.objValue;
    }

    public PostData getFirstPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            c.a.t0.s2.u.f.t0 t0Var = this.F0;
            PbModel pbModel = this.y0;
            return t0Var.v0(pbModel.K, pbModel.f1());
        }
        return (PostData) invokeV.objValue;
    }

    public String getFromWhere() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            if (this.P == null) {
                this.P = new c.a.d.f.k.b<>(new d2(this), 20, 0);
            }
            return this.P;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (this.G == null) {
                this.G = new c.a.d.f.k.b<>(new c2(this), 8, 0);
            }
            return this.G;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public PbInterviewStatusView.f getInterviewStatusCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.w0 : (PbInterviewStatusView.f) invokeV.objValue;
    }

    public boolean getIsMangaThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? (!this.f48264g && this.y2 == -1 && this.z2 == -1) ? false : true : invokeV.booleanValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.L == null) {
                this.L = new c.a.d.f.k.b<>(new i2(this), 10, 0);
            }
            return this.L;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public boolean getLinkGoodsMoreShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.O : invokeV.booleanValue;
    }

    public int getMangaNextChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.z2 : invokeV.intValue;
    }

    public int getMangaPrevChapterId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.y2 : invokeV.intValue;
    }

    @Override // c.a.t0.s2.y.b
    public AbsPbActivity getPbActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.f48262e : (AbsPbActivity) invokeV.objValue;
    }

    public c.a.s0.x.y.e getPbEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.T0 : (c.a.s0.x.y.e) invokeV.objValue;
    }

    @Override // c.a.t0.s2.y.b
    public PbFragment getPbFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this : (PbFragment) invokeV.objValue;
    }

    @Override // c.a.t0.s2.y.b
    public PbModel.g getPbFragmentDataCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.b2 : (PbModel.g) invokeV.objValue;
    }

    @Override // c.a.t0.s2.y.b
    public PbModel getPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.y0 : (PbModel) invokeV.objValue;
    }

    public c.a.t0.s2.u.f.d1.b getPbNavigationAnimDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.f48266i : (c.a.t0.s2.u.f.d1.b) invokeV.objValue;
    }

    public c.a.t0.s2.u.f.f1.a getPbRecThreadController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.v0 : (c.a.t0.s2.u.f.f1.a) invokeV.objValue;
    }

    public c.a.t0.s2.u.f.t0 getPbView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.F0 : (c.a.t0.s2.u.f.t0) invokeV.objValue;
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

    public c.a.s0.s.q.n1 getRecomStatisticData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.h0 : (c.a.s0.s.q.n1) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            c.a.d.f.k.b<RelativeLayout> bVar = new c.a.d.f.k.b<>(new h2(this), 10, 0);
            this.K = bVar;
            return bVar;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            c.a.t0.s2.u.f.t0 t0Var = this.F0;
            if (t0Var == null) {
                return 0;
            }
            return t0Var.T0();
        }
        return invokeV.intValue;
    }

    public String getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.a0 : (String) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if (this.E == null) {
                this.E = TbRichTextView.createTextViewPool(getPageContext().getPageActivity(), 8);
            }
            return this.E;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            if (this.J == null) {
                this.J = new c.a.d.f.k.b<>(new s2(this), 15, 0);
            }
            return this.J;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (this.I == null) {
                this.I = new c.a.d.f.k.b<>(new f2(this), 5, 0);
            }
            return this.I;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public c.a.d.f.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            if (this.F == null) {
                this.F = UserIconBox.createUserIconPool(getPageContext().getPageActivity(), 8);
            }
            return this.F;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            c.a.t0.s2.u.f.t0 t0Var = this.F0;
            if (t0Var == null) {
                return 0;
            }
            return t0Var.Z0();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.s2.y.b
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

    @Override // c.a.s0.g1.n.i
    public c.a.d.f.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            if (this.H == null) {
                this.H = new c.a.d.f.k.b<>(new g2(this), 8, 0);
            }
            return this.H;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public void goInterviewLivePage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            if (this.f48268k) {
                this.S = true;
            } else if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null || this.y0.R0() == null || this.y0.R0().O() == null || this.y0.R0().O().m1() == null) {
            } else {
                sendMessage(new CustomMessage(2002001, new InterviewLiveActivityConfig(getPageContext().getPageActivity()).createNormalCfg(this.y0.R0().O().m1().g(), this.y0.R0().O().m1().f(), this.y0.R0().O().m1().b(), this.y0.R0().O().m1().c(), this.y0.R0().O().s0(), this.y0.R0().O().r0())));
                this.f48262e.finish();
            }
        }
    }

    public final boolean h3(boolean z3) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048694, this, z3)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.R0() != null) {
                return ((this.y0.R0().V() != 0) || this.y0.R0().O() == null || this.y0.R0().O().J() == null || TextUtils.equals(this.y0.R0().O().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z3) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void handleMuteClick(boolean z3, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048695, this, new Object[]{Boolean.valueOf(z3), str, sparseArray}) == null) {
            String str2 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(c.a.t0.s2.i.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z3, str, str2, str3, str4, 1, str5, this.g1);
            userMuteAddAndDelCustomMessage.setTag(this.g1);
            T3(z3, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void hideKeyBroad() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048696, this) == null) || this.f48262e == null || getPageContext() == null || getPageContext().getPageActivity() == null || this.f48262e.getCurrentFocus() == null) {
            return;
        }
        c.a.d.f.p.n.w(getPageContext().getPageActivity(), this.f48262e.getCurrentFocus());
    }

    public void hideKeyboardAndEditor() {
        c.a.t0.s2.u.f.t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048697, this) == null) || (t0Var = this.F0) == null) {
            return;
        }
        t0Var.e1();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? this.f48268k : invokeV.booleanValue;
    }

    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.x0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isHostOnlyMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                return pbModel.v0();
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
            if (this.y0.R0().U() != null && (forumToolAuth = this.y0.R0().U().getForumToolAuth()) != null) {
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
            PbModel pbModel = this.y0;
            if (pbModel == null) {
                return false;
            }
            return pbModel.C1();
        }
        return invokeV.booleanValue;
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048706, this) == null) || this.B2 == null) {
            return;
        }
        if (this.z2 == -1) {
            showToast(c.a.t0.s2.l.pb_manga_not_next_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.B2.a(), this.z2, 0)));
            this.f48262e.finish();
        }
    }

    public final void k3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, bundle) == null) {
            PbModel pbModel = this.f48262e.getPbModel();
            this.y0 = pbModel;
            if (pbModel.n0() != null) {
                this.y0.n0().c(this.x2);
            }
            if (this.y0.N0() != null) {
                this.y0.N0().f(this.s1);
            }
            if (StringUtils.isNull(this.y0.h1())) {
                this.f48262e.finish();
            } else if (!"from_tieba_kuang".equals(this.Q) || this.Q == null) {
            } else {
                this.y0.p2(6);
            }
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048708, this) == null) || this.B2 == null) {
            return;
        }
        if (this.y2 == -1) {
            showToast(c.a.t0.s2.l.pb_manga_not_prev_exist);
        } else if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            ViewHelper.skipToLoginActivity(getActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MangaBrowserActivityConfig(getPageContext().getPageActivity(), this.B2.a(), this.y2, 0)));
            this.f48262e.finish();
        }
    }

    public void loadNextVideoPb(String str) {
        c.a.t0.s2.u.f.t0 t0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048709, this, str) == null) || this.y0 == null || StringUtils.isNull(str) || (t0Var = this.F0) == null) {
            return;
        }
        t0Var.z2(true);
        this.y0.H1(str);
        this.M = true;
        this.F0.c0();
        this.F0.c1();
    }

    public final void m3(View view, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048710, this, view, str, str2, postData) == null) || view == null || str == null || str2 == null || B2() || !checkPrivacyBeforeInput()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.d0);
            this.e0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (getPbView().O0() != null && postData != null) {
            getPbView().O0().j(String.format(TbadkCoreApplication.getInst().getResources().getString(c.a.t0.s2.l.reply_title), postData.t().getName_show(), postData.N() != null ? postData.N().toString() : ""));
        }
        if (this.y0.R0() != null && this.y0.R0().g0()) {
            c.a.d.f.m.e.a().postDelayed(new a1(this, str, str2), 0L);
            return;
        }
        if (this.X0 == null) {
            c.a.t0.d1.r2.a.c cVar = new c.a.t0.d1.r2.a.c(getPageContext());
            this.X0 = cVar;
            cVar.j(1);
            this.X0.i(new b1(this, str, str2));
        }
        PbModel pbModel = this.y0;
        if (pbModel == null || pbModel.R0() == null || this.y0.R0().l() == null) {
            return;
        }
        this.X0.g(this.y0.R0().l().getId(), c.a.d.f.m.b.g(this.y0.h1(), 0L));
    }

    public void markFloor(PostData postData) {
        PostData firstPostData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048711, this, postData) == null) || postData == null) {
            return;
        }
        boolean z3 = false;
        if (postData.G() != null && postData.G().equals(this.y0.M0())) {
            z3 = true;
        }
        MarkData L0 = this.y0.L0(postData);
        if (this.y0.R0() != null && this.y0.R0().g0() && (firstPostData = getFirstPostData()) != null) {
            L0 = this.y0.L0(firstPostData);
        }
        if (L0 == null) {
            return;
        }
        this.F0.Q2();
        c.a.s0.i.a aVar = this.A0;
        if (aVar != null) {
            aVar.i(L0);
            if (!z3) {
                this.A0.a();
            } else {
                this.A0.d();
            }
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            c.a.t0.s2.r.f R0 = this.y0.R0();
            this.y0.x2(true);
            c.a.s0.i.a aVar = this.A0;
            if (aVar != null) {
                R0.E0(aVar.g());
            }
            this.F0.t1(R0);
        }
    }

    public final void o3() {
        MarkData i02;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048713, this) == null) || this.A0 == null) {
            return;
        }
        if (this.y0.R0() != null && this.y0.R0().g0()) {
            i02 = this.y0.i0(0);
        } else {
            i02 = this.y0.i0(this.F0.D0());
        }
        if (i02 == null) {
            return;
        }
        if (i02.isApp() && (i02 = this.y0.i0(this.F0.D0() + 1)) == null) {
            return;
        }
        this.F0.Q2();
        this.A0.i(i02);
        if (!this.A0.e()) {
            if (this.F0 != null && this.y0 != null && c.a.s0.b.d.a0() && !c.a.t0.s2.u.f.g1.b.k(this.y0.f48398f)) {
                this.F0.v3();
                c.a.t0.s2.u.f.g1.b.b(this.y0.f48398f);
            }
            this.A0.a();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
            return;
        }
        this.A0.d();
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(c.a.t0.s2.i.container));
            this.b2.c(true, 0, 3, 0, ((VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class)).getFirstLoadData(), "", 1);
            this.f48262e.getTiePlusEventController().addEventAckedCallbackWeaked(this.u0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        EmotionImageData emotionImageData;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048715, this, i3, i4, intent) == null) {
            super.onActivityResult(i3, i4, intent);
            this.T0.H(i3, i4, intent);
            c.a.t0.s2.u.f.c1.f.a aVar = this.U;
            if (aVar != null) {
                aVar.i(i3, i4, intent);
            }
            if (getPbView().O0() != null) {
                getPbView().O0().g(i3, i4, intent);
            }
            if (i3 == 25035) {
                W2(i4, intent);
            }
            if (i4 == -1) {
                if (i3 == 11009) {
                    o3();
                } else if (i3 == 13008) {
                    c.a.t0.s2.u.f.l0.b().m();
                    this.x0.postDelayed(new x1(this), 1000L);
                } else if (i3 == 13011) {
                    c.a.t0.i3.a.g().m(getPageContext());
                } else if (i3 == 23003) {
                    if (intent == null || this.y0 == null) {
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
                    this.Y0 = emotionImageData;
                    if (checkPrivacyBeforePost(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                        w3(emotionImageData);
                    }
                } else if (i3 == 25033) {
                    View view = this.W;
                    if (view != null) {
                        this.F0.h3(view);
                    }
                } else if (i3 == 24007) {
                    int intExtra = intent.getIntExtra("extra_show_channel", 1);
                    if (intent.getIntExtra("extra_share_status", 2) == 1) {
                        c.a.t0.i3.a.g().m(getPageContext());
                        c4();
                        ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                        ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.E0;
                        if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.t) != null) {
                            shareSuccessReplyToServerModel.w(str, intExtra, new y1(this));
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
                            c.a.t0.s2.u.f.t0 t0Var = this.F0;
                            if (t0Var == null || t0Var.o0() == null) {
                                return;
                            }
                            this.F0.o0().performClick();
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
                    this.F0.S2(false);
                    if (this.y0.R0() == null || this.y0.R0().O() == null || this.y0.R0().O().P0() == null) {
                        return;
                    }
                    this.y0.R0().O().P0().setStatus(2);
                }
            }
        }
    }

    @Override // c.a.s0.g1.n.i
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
            this.f48262e = (AbsPbActivity) context;
        }
    }

    public void onBackPressed() {
        List<b3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048718, this) == null) || (list = this.p1) == null || list.isEmpty()) {
            return;
        }
        int size = this.p1.size();
        while (true) {
            size--;
            if (size <= -1 || this.p1.get(size).onBackPressed()) {
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
        this.F0.K1(i3);
        c.a.s0.x.y.e eVar = this.T0;
        if (eVar != null && eVar.a() != null) {
            this.T0.a().onChangeSkinType(i3);
        }
        if (this.F0.a() != null) {
            this.F0.a().onChangeSkinType(getPageContext(), i3);
        }
        this.mContentProcessController.i();
        UtilHelper.setNavigationBarBackgroundForVivoX20(getActivity(), SkinManager.getColor(i3, getResources(), c.a.t0.s2.f.CAM_X0201));
        this.b0 = i3;
        stopVoice();
    }

    @Override // c.a.s0.s.s.a.e
    public void onClick(c.a.s0.s.s.a aVar) {
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
            c.a.t0.s2.u.f.t0 t0Var = this.F0;
            if (t0Var != null) {
                t0Var.L1(configuration);
            }
            PopupDialog popupDialog = this.J0;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921420, configuration));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        c.a.t0.s2.u.f.t0 t0Var;
        c.a.t0.s2.u.f.t0 t0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
            this.t = System.currentTimeMillis();
            this.e1 = getPageContext();
            Intent intent = this.f48262e.getIntent();
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
                this.y2 = intent.getIntExtra("key_manga_prev_chapter", -1);
                this.z2 = intent.getIntExtra("key_manga_next_chapter", -1);
                this.A2 = intent.getStringExtra("key_manga_title");
                intent.getBooleanExtra("key_jump_to_god_reply", false);
                this.O0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
                this.P0 = intent.getStringExtra("high_light_post_id");
                this.Q0 = intent.getBooleanExtra("key_jump_to_top", false);
                if (getIsMangaThread()) {
                    this.f48262e.setUseStyleImmersiveSticky(false);
                }
                String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.T = stringExtra;
                this.T = c.a.d.f.p.m.isEmpty(stringExtra) ? "" : this.T;
                this.o1 = intent.getIntExtra("KEY_SMART_FRS_POSITION", -1);
                c.a.s0.s.q.n1 n1Var = new c.a.s0.s.q.n1();
                this.h0 = n1Var;
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
            if (this.y0.R0() != null) {
                this.y0.R0().N0(this.T);
            }
            c3();
            if (intent != null && (t0Var2 = this.F0) != null) {
                t0Var2.f23659b = intent.getIntExtra("praise_data", -1);
                if (!StringUtils.isNull(intent.getStringExtra("big_pic_type"))) {
                    if (this.h1 == null) {
                        this.h1 = new e0(this, intent);
                    }
                    c.a.d.f.m.e.a().postDelayed(this.h1, 1500L);
                }
                String stringExtra2 = intent.getStringExtra("lego_pre_load_data");
                if (!TextUtils.isEmpty(stringExtra2) && this.y0.R0() != null) {
                    this.y0.q2(stringExtra2);
                }
            }
            VoiceManager voiceManager = new VoiceManager();
            this.o = voiceManager;
            voiceManager.onCreate(getPageContext());
            b3(bundle);
            c.a.s0.x.y.g gVar = new c.a.s0.x.y.g();
            this.S0 = gVar;
            B3(gVar);
            c.a.s0.x.y.e eVar = (c.a.s0.x.y.e) this.S0.a(getActivity());
            this.T0 = eVar;
            eVar.e0(this.f48262e.getPageContext());
            this.T0.n0(this.Z1);
            this.T0.o0(this.Z0);
            this.T0.g0(1);
            this.T0.F(this.f48262e.getPageContext(), bundle);
            this.T0.a().addHideLauncher(new c.a.s0.x.k(getActivity()));
            this.T0.a().showLinePositionBottom(true);
            D3(true);
            this.T0.O(this.y0.u0(), this.y0.h1(), this.y0.q0());
            registerListener(this.w1);
            if (!this.y0.F0()) {
                this.T0.s(this.y0.h1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.T0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.y0.t1()) {
                this.T0.k0(getPageContext().getString(c.a.t0.s2.l.pb_reply_hint_from_smart_frs));
            } else {
                c.a.t0.s2.u.f.t0 t0Var3 = this.F0;
                if (t0Var3 != null) {
                    this.T0.k0(t0Var3.R0());
                }
            }
            registerListener(this.v1);
            registerListener(this.x1);
            registerListener(this.y1);
            registerListener(this.u1);
            registerListener(this.mFirstFloorPraiseListener);
            registerListener(this.V1);
            registerListener(this.d2);
            registerListener(this.t1);
            c.a.t0.w3.j0.f fVar = new c.a.t0.w3.j0.f("pb", c.a.t0.w3.j0.f.f25553d);
            this.R0 = fVar;
            fVar.d();
            registerListener(this.E1);
            registerListener(this.N1);
            this.y0.O1();
            registerListener(this.c2);
            registerListener(this.W1);
            registerListener(this.Y1);
            registerListener(this.I1);
            c.a.t0.s2.u.f.t0 t0Var4 = this.F0;
            if (t0Var4 != null && t0Var4.Y0() != null && this.F0.W0() != null) {
                c.a.t0.s2.u.f.d1.b bVar = new c.a.t0.s2.u.f.d1.b(getActivity(), this.F0.Y0(), this.F0.W0(), this.F0.M0());
                this.f48266i = bVar;
                bVar.t(this.M1);
            }
            if (this.f48264g && (t0Var = this.F0) != null && t0Var.W0() != null) {
                this.F0.W0().setVisibility(8);
            }
            c.a.s0.s.i0.c cVar = new c.a.s0.s.i0.c();
            this.f1 = cVar;
            cVar.a = 1000L;
            registerListener(this.U1);
            registerListener(this.T1);
            registerListener(this.R1);
            registerListener(this.S1);
            registerListener(this.G1);
            registerListener(this.A1);
            registerListener(this.B1);
            registerListener(this.C1);
            this.F1.setSelfListener(true);
            this.F1.setTag(this.f48262e.getUniqueId());
            this.F1.setPriority(-1);
            MessageManager.getInstance().registerListener(this.F1);
            registerResponsedEventListener(TipEvent.class, this.O1);
            this.g1 = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.g1;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.g1;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            this.y0.m0().A(this.P1);
            this.mContentProcessController = new c.a.t0.s2.u.f.v0();
            if (this.T0.v() != null) {
                this.mContentProcessController.m(this.T0.v().h());
            }
            this.T0.d0(this.a1);
            this.E0 = new ShareSuccessReplyToServerModel();
            addBackInterceptor(this.r1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new f0(this));
            c.a.t0.s2.u.g.a aVar = new c.a.t0.s2.u.g.a(getContext());
            this.z0 = aVar;
            aVar.b(getUniqueId());
            c.a.t0.v3.c.g().i(getUniqueId());
            c.a.s0.s.o.a.b().l("3", "");
            this.q1 = new c.a.t0.f0.a(getPageContext());
            this.v0 = new c.a.t0.s2.u.f.f1.a(this, getUniqueId(), this.F0, this.y0);
            if (!TbSingleton.getInstance().hasDownloadEmotion() && c.a.d.f.p.l.H() && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getInst().checkInterrupt()) {
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
            this.F0 = new c.a.t0.s2.u.f.t0(this, this.mCommonOnClickListener, this.Q1);
            c.a.t0.q0.b bVar = new c.a.t0.q0.b(getActivity());
            this.f48265h = bVar;
            bVar.i(D2);
            this.f48265h.d(this.w2);
            this.F0.J2(this.f2);
            this.F0.I2(this.k2);
            this.F0.C2(this.i2);
            this.F0.A2(c.a.s0.s.k.c().g());
            this.F0.G2(this.m2);
            this.F0.M2(this.s2);
            this.F0.K2(this.t2);
            this.F0.H2(this.v2);
            this.F0.F2(this.h2);
            this.F0.F3(this.mIsLogin);
            if (this.f48262e.getIntent() != null) {
                this.F0.y2(this.f48262e.getIntent().getBooleanExtra("KEY_IS_INTERVIEW_LIVE", false));
            }
            this.F0.N0().setFromForumId(this.y0.getFromForumId());
            this.F0.r2(this.T0.a());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.T0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.T0.k0(this.F0.R0());
            }
            this.F0.u2(new i0(this));
            this.F0.x2(this.y0.A0());
            this.F0.L2(this.y0.Q0());
            this.v0.f(this.F0, this.y0);
            return this.F0.a1();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        c.a.t0.s2.u.f.h1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            c.a.t0.v3.c.g().k(getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004014);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2004014, getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!c.a.d.f.p.m.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13266");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.y0.R0().m());
                statisticItem.param("tid", this.y0.h1());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
                TbadkCoreApplication.getInst().setTaskId("");
            }
            if (!this.x && this.F0 != null) {
                this.x = true;
                y3(false, null);
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.cancelLoadData();
                this.y0.destory();
                if (this.y0.N0() != null) {
                    this.y0.N0().d();
                }
            }
            c.a.s0.x.y.e eVar = this.T0;
            if (eVar != null) {
                eVar.I();
            }
            ForumManageModel forumManageModel = this.B0;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            LikeModel likeModel = this.V;
            if (likeModel != null) {
                likeModel.I();
            }
            c.a.t0.s2.u.f.t0 t0Var = this.F0;
            if (t0Var != null) {
                t0Var.M1();
                c.a.t0.s2.u.f.h1.c cVar2 = this.F0.f23665h;
                if (cVar2 != null) {
                    cVar2.x();
                }
            }
            c.a.s0.s0.b bVar = this.y;
            if (bVar != null) {
                bVar.c();
            }
            c.a.t0.s2.u.f.d1.b bVar2 = this.f48266i;
            if (bVar2 != null) {
                bVar2.k();
            }
            super.onDestroy();
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            c.a.t0.s2.u.f.t0 t0Var2 = this.F0;
            if (t0Var2 != null) {
                t0Var2.c0();
            }
            MessageManager.getInstance().unRegisterListener(this.R1);
            MessageManager.getInstance().unRegisterListener(this.S1);
            MessageManager.getInstance().unRegisterListener(this.U1);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.mFirstFloorPraiseListener);
            MessageManager.getInstance().unRegisterListener(this.V1);
            MessageManager.getInstance().unRegisterListener(this.W1);
            MessageManager.getInstance().unRegisterListener(this.G1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            MessageManager.getInstance().unRegisterListener(this.F1);
            MessageManager.getInstance().unRegisterListener(this.I1);
            MessageManager.getInstance().unRegisterListener(this.B1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            this.e1 = null;
            this.f1 = null;
            c.a.t0.j3.j0.a.e().g();
            if (this.h1 != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.h1);
            }
            c.a.t0.s2.u.f.c1.f.a aVar = this.U;
            if (aVar != null) {
                aVar.f();
            }
            c.a.t0.s2.u.f.t0 t0Var3 = this.F0;
            if (t0Var3 != null && (cVar = t0Var3.f23665h) != null) {
                cVar.q();
            }
            ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.E0;
            if (shareSuccessReplyToServerModel != null) {
                shareSuccessReplyToServerModel.cancelLoadData();
            }
            c.a.t0.s2.u.f.v0 v0Var = this.mContentProcessController;
            if (v0Var != null) {
                v0Var.j();
            }
            PbModel pbModel2 = this.y0;
            if (pbModel2 != null && pbModel2.f0() != null) {
                this.y0.f0().onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.mReplyPrivacyController;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            c.a.t0.s2.u.f.t0 t0Var4 = this.F0;
            if (t0Var4 != null) {
                t0Var4.C3();
            }
            c.a.t0.s2.u.f.f1.a aVar2 = this.v0;
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
    public c.a.d.n.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            if (getListView() == null) {
                return null;
            }
            return getListView().getPreLoadHandle();
        }
        return (c.a.d.n.e.q) invokeV.objValue;
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        c.a.t0.s2.u.f.t0 t0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048727, this, i3, keyEvent)) == null) ? (keyEvent == null || (t0Var = this.F0) == null || !t0Var.O1(i3)) ? false : true : invokeIL.booleanValue;
    }

    @Override // c.a.s0.g1.n.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048728, this, context, str) == null) {
            this.A = true;
        }
    }

    @Override // c.a.s0.g1.n.i
    public void onLinkClicked(Context context, String str, boolean z3) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048729, this, context, str, z3) == null) {
            if (c.a.t0.s2.u.f.y0.c(str) && (pbModel = this.y0) != null && pbModel.h1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", this.y0.h1()));
            }
            if (z3) {
                if (!TextUtils.isEmpty(str)) {
                    c.a.s0.u.p pVar = new c.a.s0.u.p();
                    pVar.a = str;
                    pVar.f14493b = 3;
                    pVar.f14494c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, pVar));
                }
            } else {
                c.a.t0.s2.u.f.y0.a().e(getPageContext(), str);
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
                this.f48268k = false;
            } else {
                this.f48268k = true;
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
            c.a.t0.s2.u.f.t0 t0Var = this.F0;
            if (t0Var != null) {
                t0Var.R1();
            }
            if (!this.y0.F0()) {
                this.T0.U(this.y0.h1());
            }
            PbModel pbModel = this.y0;
            if (pbModel != null) {
                pbModel.N1();
            }
            c.a.s0.a.d.y().G();
            MessageManager.getInstance().unRegisterListener(this.z1);
            x3();
            MessageManager.getInstance().unRegisterListener(this.R1);
            MessageManager.getInstance().unRegisterListener(this.S1);
            MessageManager.getInstance().unRegisterListener(this.U1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004012));
            ItemCardHelper.v(null);
        }
    }

    @Override // c.a.s0.g1.n.i
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048732, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.L0 = str;
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

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.d.a.i
    public void onPreLoad(c.a.d.n.e.q qVar) {
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
            this.f48268k = false;
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
            c.a.t0.s2.u.f.t0 t0Var = this.F0;
            if (t0Var != null && t0Var.a1() != null) {
                if (!this.l) {
                    P3();
                } else {
                    hideLoadingView(this.F0.a1());
                }
                this.F0.S1();
            }
            if (this.p == 1) {
                CompatibleUtile.getInstance().closeViewGpu(getListView());
            }
            c.a.t0.s2.u.f.t0 t0Var2 = this.F0;
            NoNetworkView a4 = t0Var2 != null ? t0Var2.a() : null;
            if (a4 != null && a4.getVisibility() == 0 && c.a.d.f.p.l.z()) {
                a4.update(false);
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.z1);
            this.N0 = false;
            z3();
            registerListener(this.R1);
            registerListener(this.S1);
            registerListener(this.U1);
            if (this.m1) {
                v3();
                this.m1 = false;
            }
            U3();
            ItemCardHelper.v(this.u2);
            if (MessageManager.getInstance().hasListener(2001118)) {
                DownloadData downloadData = new DownloadData();
                downloadData.setStatus(21);
                c.a.s0.w.c.q().w(downloadData);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.y0.e2(bundle);
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
            this.T0.K(bundle);
        }
    }

    @Override // c.a.s0.g1.n.i
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
            if (getPbView().O0() != null) {
                getPbView().O0().i();
            }
            c.a.t0.s2.u.f.h1.c cVar = this.F0.f23665h;
            if (cVar != null && !cVar.t()) {
                this.F0.f23665h.x();
            }
            PbModel pbModel = this.y0;
            if (pbModel != null && pbModel.R0() != null && this.y0.R0().l() != null && this.y0.R0().O() != null) {
                c.a.s0.v.a.k().y(getPageContext().getPageActivity(), "pb", this.y0.R0().l().getId(), c.a.d.f.m.b.g(this.y0.R0().O().g0(), 0L));
            }
            VoiceManager voiceManager = this.o;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            c.a.t0.v3.c.g().h(getUniqueId(), false);
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
            this.F0.F3(z3);
            PopupDialog popupDialog = this.J0;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            if (z3 && this.N0) {
                this.F0.R2();
                this.y0.F1(true);
            }
            if (this.F0.n0() != null) {
                this.F0.n0().a0(z3);
            }
        }
    }

    @Override // c.a.s0.g1.n.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048741, this, context, str) == null) {
            c.a.t0.s2.u.f.y0.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.A = true;
        }
    }

    @Override // c.a.s0.g1.n.i
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048742, this, context, str) == null) {
        }
    }

    public void openMore() {
        PbModel pbModel;
        c.a.t0.s2.r.f R0;
        c.a.s0.s.q.d2 O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048743, this) == null) || (pbModel = this.y0) == null || pbModel.R0() == null || (O = (R0 = this.y0.R0()).O()) == null || O.J() == null) {
            return;
        }
        this.F0.e1();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.J().getUserId());
        c.a.t0.s2.u.f.f0 f0Var = new c.a.t0.s2.u.f.f0();
        int V = this.y0.R0().V();
        if (V != 1 && V != 3) {
            f0Var.f23506g = false;
        } else {
            f0Var.f23506g = true;
            f0Var.s = O.s0() == 1;
        }
        if (isMakeGoodsShowing(V)) {
            f0Var.f23507h = true;
            f0Var.r = O.r0() == 1;
        } else {
            f0Var.f23507h = false;
        }
        if (V == 1002 && !equals) {
            f0Var.u = true;
        }
        f0Var.n = K3(O.V1(), R0.i0(), equals, V, O.M2(), O.v2());
        f0Var.f23504e = I3(equals, R0.i0());
        f0Var.f23508i = L3();
        f0Var.f23505f = J3(equals);
        f0Var.f23510k = equals && R0.U() != null && R0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            f0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().f();
        }
        f0Var.t = equals;
        f0Var.q = this.y0.f1();
        f0Var.f23501b = true;
        f0Var.a = h3(equals);
        if (equals) {
            this.F0.u1();
        }
        f0Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        f0Var.f23509j = true;
        f0Var.o = this.y0.v0();
        f0Var.f23503d = true;
        if (O.t1() == null) {
            f0Var.f23502c = true;
        } else {
            f0Var.f23502c = false;
        }
        if (R0.g0()) {
            f0Var.f23501b = false;
            f0Var.f23503d = false;
            f0Var.f23502c = false;
            f0Var.f23506g = false;
            f0Var.f23507h = false;
        }
        f0Var.v = TbSingleton.getInstance().mShowCallFans && equals && !R0.g0();
        c.a.t0.s2.u.f.t0 t0Var = this.F0;
        if (t0Var != null) {
            PbModel pbModel2 = this.y0;
            PostData v02 = t0Var.v0(pbModel2.K, pbModel2.f1());
            f0Var.w = v02 != null ? v02.U : false;
        }
        f0Var.m = true;
        if (c.a.s0.h1.b.c.d()) {
            f0Var.f23503d = false;
            f0Var.f23501b = false;
            f0Var.f23502c = false;
            f0Var.m = false;
        }
        if (O.V1()) {
            f0Var.n = false;
            f0Var.f23506g = false;
            f0Var.f23507h = false;
        }
        this.F0.f23665h.E(f0Var);
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(c.a.t0.s2.i.tag_clip_board)) == null) {
                return;
            }
            markFloor(postData);
        }
    }

    public void processProfessionPermission() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || !checkUpIsLogin() || (pbModel = this.y0) == null || pbModel.R0() == null || this.y0.R0().l() == null || B2()) {
            return;
        }
        if (this.y0.R0().g0()) {
            this.F0.V();
            return;
        }
        if (this.W0 == null) {
            c.a.t0.d1.r2.a.c cVar = new c.a.t0.d1.r2.a.c(getPageContext());
            this.W0 = cVar;
            cVar.j(0);
            this.W0.i(new y0(this));
        }
        this.W0.g(this.y0.R0().l().getId(), c.a.d.f.m.b.g(this.y0.h1(), 0L));
    }

    public final boolean q3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048746, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String p3 = c.a.s0.s.g0.b.j().p("bubble_link", "");
                if (StringUtils.isNull(p3)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    c.a.s0.m.a.q(getPageContext().getPageActivity(), getResources().getString(c.a.t0.s2.l.editor_privilege), p3 + "?props_id=" + str, true, true, true);
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
            if (!c.a.d.f.p.l.z()) {
                showToast(c.a.t0.s2.l.network_not_available);
                return;
            }
            this.F0.c0();
            if (this.m) {
                return;
            }
            stopVoice();
            this.F0.Q2();
            if (this.y0.loadData()) {
                this.F0.u3();
            }
        }
    }

    public void refGodReplyFloor(c.a.t0.s2.r.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, tVar) == null) {
            String G = tVar.i().G();
            List<PostData> list = this.y0.R0().T().a;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                PostData postData = list.get(i3);
                if (postData.G() == null || !postData.G().equals(G)) {
                    i3++;
                } else {
                    ArrayList<PostData> k3 = tVar.k();
                    postData.A0(tVar.m());
                    if (postData.P() != null) {
                        postData.P().clear();
                        postData.P().addAll(k3);
                    }
                }
            }
            if (this.y0.B0()) {
                return;
            }
            this.F0.t1(this.y0.R0());
        }
    }

    public void refreshMark(boolean z3, MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048749, this, z3, markData) == null) {
            this.F0.P2();
            this.y0.x2(z3);
            c.a.s0.i.a aVar = this.A0;
            if (aVar != null) {
                aVar.h(z3);
                if (markData != null) {
                    this.A0.i(markData);
                }
            }
            if (this.y0.D0()) {
                n3();
            } else {
                this.F0.t1(this.y0.R0());
            }
        }
    }

    public void refreshWrite(c.a.t0.s2.r.t tVar) {
        boolean z3;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048750, this, tVar) == null) || tVar.i() == null) {
            return;
        }
        String G = tVar.i().G();
        ArrayList<PostData> F = this.y0.R0().F();
        int i3 = 0;
        while (true) {
            if (i3 >= F.size()) {
                break;
            }
            PostData postData = F.get(i3);
            if (postData.G() == null || !postData.G().equals(G)) {
                i3++;
            } else {
                ArrayList<PostData> k3 = tVar.k();
                postData.A0(tVar.m());
                if (postData.P() != null && k3 != null) {
                    Iterator<PostData> it = k3.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.W() != null && next != null && next.t() != null && (metaData = postData.W().get(next.t().getUserId())) != null) {
                            next.l0(metaData);
                            next.u0(true);
                            next.G0(getPageContext(), this.y0.D1(metaData.getUserId()));
                        }
                    }
                    z3 = k3.size() != postData.P().size();
                    if (!postData.a0(false)) {
                        postData.P().clear();
                        postData.P().addAll(k3);
                    }
                }
                if (postData.x() != null) {
                    postData.j0();
                }
            }
        }
        if (!this.y0.B0() && z3) {
            this.F0.t1(this.y0.R0());
        }
        if (z3) {
            refGodReplyFloor(tVar);
        }
    }

    public void removeBackInterceptor(b3 b3Var) {
        List<b3> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048751, this, b3Var) == null) || b3Var == null || (list = this.p1) == null) {
            return;
        }
        list.remove(b3Var);
    }

    @Override // c.a.t0.s2.z.f.b
    public void resetLoadMoreFlag(boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048752, this, z3) == null) {
            this.N0 = z3;
        }
    }

    public final boolean richTextHandleSingleTap(View view) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048753, this, view)) == null) {
            if (view != null && (view.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view.getTag()).get(c.a.t0.s2.i.tag_clip_board);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (postData.getType() != PostData.C0 && !TextUtils.isEmpty(postData.u()) && c.a.s0.s.k.c().g()) {
                        return q3(postData.G());
                    }
                    if (checkUpIsLogin() && (pbModel = this.y0) != null && pbModel.R0() != null) {
                        if (getPbView().O0() != null) {
                            getPbView().O0().c();
                        }
                        c.a.t0.s2.r.t tVar = new c.a.t0.s2.r.t();
                        tVar.A(this.y0.R0().l());
                        tVar.E(this.y0.R0().O());
                        tVar.C(postData);
                        getPbView().N0().S(tVar);
                        getPbView().N0().setPostId(postData.G());
                        m3(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        c.a.s0.x.y.e eVar = this.T0;
                        if (eVar != null) {
                            this.F0.v2(eVar.C());
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
        c.a.t0.s2.r.f R0 = this.y0.R0();
        TbRichText f4 = f4(str, i3);
        if (f4 == null || (tbRichTextData = f4.y().get(this.l2)) == null) {
            return;
        }
        eVar.f48233f = String.valueOf(f4.getPostId());
        eVar.a = new ArrayList<>();
        eVar.f48229b = new ConcurrentHashMap<>();
        if (!tbRichTextData.C().D()) {
            eVar.f48235h = false;
            String a4 = c.a.t0.s2.r.g.a(tbRichTextData);
            eVar.a.add(a4);
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
            imageUrlData.mIsReserver = this.y0.c1();
            imageUrlData.mIsSeeHost = this.y0.v0();
            eVar.f48229b.put(a4, imageUrlData);
            if (R0 != null) {
                if (R0.l() != null) {
                    eVar.f48230c = R0.l().getName();
                    eVar.f48231d = R0.l().getId();
                }
                if (R0.O() != null) {
                    eVar.f48232e = R0.O().g0();
                }
                eVar.f48234g = R0.s() == 1;
            }
            imageUrlData.threadId = c.a.d.f.m.b.g(eVar.f48232e, -1L);
            return;
        }
        eVar.f48235h = true;
        int size = R0.F().size();
        this.n2 = false;
        eVar.f48237j = -1;
        int P2 = R0.j() != null ? P2(R0.j().N(), f4, i3, i3, eVar.a, eVar.f48229b) : i3;
        for (int i4 = 0; i4 < size; i4++) {
            PostData postData = R0.F().get(i4);
            if (postData.G() == null || R0.j() == null || R0.j().G() == null || !postData.G().equals(R0.j().G())) {
                P2 = P2(postData.N(), f4, P2, i3, eVar.a, eVar.f48229b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.f48236i = arrayList.get(arrayList.size() - 1);
        }
        if (R0 != null) {
            if (R0.l() != null) {
                eVar.f48230c = R0.l().getName();
                eVar.f48231d = R0.l().getId();
            }
            if (R0.O() != null) {
                eVar.f48232e = R0.O().g0();
            }
            eVar.f48234g = R0.s() == 1;
        }
        eVar.f48237j = P2;
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
            AbsPbActivity absPbActivity = this.f48262e;
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
            if (this.y0.R0() != null && this.y0.R0().F() != null && this.y0.R0().F().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.y0.R0().F().size()) {
                        i3 = 0;
                        break;
                    } else if (str.equals(this.y0.R0().F().get(i3).G())) {
                        break;
                    } else {
                        i3++;
                    }
                }
                PostData postData = this.y0.R0().F().get(i3);
                if (postData.N() != null && postData.N().y() != null) {
                    Iterator<TbRichTextData> it = postData.N().y().iterator();
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
                    c.a.t0.s2.r.g.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048760, this) == null) || (pbModel = this.y0) == null || c.a.d.f.p.m.isEmpty(pbModel.h1())) {
            return;
        }
        super.taskStart();
    }

    public final void u3(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048761, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(c.a.t0.s2.i.pb_track_more_obj_source, Integer.valueOf(this.f48263f ? 2 : 3));
        view.setTag(sparseArray);
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048762, this) == null) {
            hideNetRefreshView(this.F0.a1());
            P3();
            if (this.y0.L1()) {
                this.F0.Q2();
            }
            this.F0.X2();
        }
    }

    public final void w3(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048763, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.U == null) {
            c.a.t0.s2.u.f.c1.f.a aVar = new c.a.t0.s2.u.f.c1.f.a(this.f48262e);
            this.U = aVar;
            aVar.n(this.Z0);
            this.U.m(this.Z1);
        }
        this.U.k(emotionImageData, getPbModel(), getPbModel().R0());
    }

    public final void x3() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048764, this) == null) || (pbModel = this.y0) == null || pbModel.R0() == null || this.y0.R0().O() == null || !this.y0.R0().O().H2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
    }

    public final void y2() {
        PbModel pbModel;
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048765, this) == null) || (pbModel = this.y0) == null || (fVar = pbModel.K) == null || fVar.O() == null) {
            return;
        }
        c.a.s0.s.q.d2 O = this.y0.K.O();
        O.b1 = this.y0.W0();
        O.a1 = this.y0.Z0();
        O.Z0 = this.y0.Y0();
        O.c1 = this.y0.X0();
        O.K2 = this.y0.F0();
        if (O.U() == 0) {
            O.I3(c.a.d.f.m.b.g(this.y0.getForumId(), 0L));
        }
        StatisticItem i3 = c.a.s0.p0.c.i(getContext(), O, "c13562");
        TbPageTag l3 = c.a.s0.p0.c.l(getContext());
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
        c.a.s0.t.c.d adAdSense;
        c.a.t0.s2.u.f.t0 t0Var;
        c.a.t0.s2.u.f.h n02;
        ArrayList<PostData> E;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048766, this, z3, postData) == null) || (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) == null || !adAdSense.g() || (t0Var = this.F0) == null || (n02 = t0Var.n0()) == null || (E = n02.E()) == null) {
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
            String G = next.G();
            i3++;
            if (z3) {
                if (next == postData) {
                    a.c cVar = new a.c();
                    cVar.f25616b = G;
                    cVar.f25617c = i3;
                    arrayList.add(cVar);
                    break;
                }
            } else if (next.G == 1 && !TextUtils.isEmpty(G)) {
                next.G = 2;
                a.c cVar2 = new a.c();
                cVar2.f25616b = G;
                cVar2.f25617c = i3;
                arrayList.add(cVar2);
            }
        }
        if (arrayList.size() > 0) {
            PbModel pbModel = this.y0;
            if (pbModel == null || pbModel.R0() == null || this.y0.R0().l() == null) {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                String first_class = this.y0.R0().l().getFirst_class();
                str2 = this.y0.R0().l().getSecond_class();
                str3 = this.y0.R0().l().getId();
                str4 = this.y0.h1();
                str = first_class;
            }
            c.a.t0.j3.z.w(z3, str, str2, str3, str4, arrayList, adAdSense.i());
        }
    }

    public final void z2(boolean z3) {
        PbModel pbModel;
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048767, this, z3) == null) || (pbModel = this.y0) == null || (fVar = pbModel.K) == null || fVar.O() == null) {
            return;
        }
        c.a.s0.s.q.d2 O = this.y0.K.O();
        O.b1 = this.y0.W0();
        O.a1 = this.y0.Z0();
        O.Z0 = this.y0.Y0();
        O.c1 = this.y0.X0();
        if (O.U() == 0) {
            O.I3(c.a.d.f.m.b.g(this.y0.getForumId(), 0L));
        }
        StatisticItem i3 = c.a.s0.p0.c.i(getContext(), O, "c13563");
        TbPageTag l3 = c.a.s0.p0.c.l(getContext());
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
            c.a.s0.o0.c k3 = TbPageExtraHelper.k(getContext());
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
        if (!(interceptable == null || interceptable.invokeV(1048768, this) == null) || (pbModel = this.y0) == null || pbModel.R0() == null || this.y0.R0().O() == null || !this.y0.R0().O().H2()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004019));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.g1.n.i
    public BdTypeListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            c.a.t0.s2.u.f.t0 t0Var = this.F0;
            if (t0Var == null) {
                return null;
            }
            return t0Var.E0();
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void deleteThread(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048644, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(c.a.t0.s2.u.f.t0.X1)).intValue();
            if (intValue == c.a.t0.s2.u.f.t0.Y1) {
                if (this.B0.P()) {
                    return;
                }
                this.F0.B3();
                String str = (String) sparseArray.get(c.a.t0.s2.i.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(c.a.t0.s2.i.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(c.a.t0.s2.i.tag_del_post_type)).intValue();
                boolean booleanValue2 = sparseArray.get(c.a.t0.s2.i.tag_is_block_thread) != null ? ((Boolean) sparseArray.get(c.a.t0.s2.i.tag_is_block_thread)).booleanValue() : false;
                if (jSONArray != null) {
                    this.B0.R(StringHelper.JsonArrayToString(jSONArray));
                }
                this.B0.S(this.y0.R0().l().getId(), this.y0.R0().l().getName(), this.y0.R0().O().g0(), str, intValue3, intValue2, booleanValue, this.y0.R0().O().L(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == c.a.t0.s2.u.f.t0.Z1 || intValue == c.a.t0.s2.u.f.t0.b2) {
                if (this.y0.n0() != null) {
                    this.y0.n0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == c.a.t0.s2.u.f.t0.Z1) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }
}
