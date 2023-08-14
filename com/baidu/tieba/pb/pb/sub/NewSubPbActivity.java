package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.DialogLoginHelper;
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
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.PbNewInputContainer;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageStayDuration.PageStayDurationFilter;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tbadk.pageStayDuration.PageStayDurationStat;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.ag;
import com.baidu.tieba.b05;
import com.baidu.tieba.bc9;
import com.baidu.tieba.bg;
import com.baidu.tieba.bi;
import com.baidu.tieba.bi9;
import com.baidu.tieba.bka;
import com.baidu.tieba.br5;
import com.baidu.tieba.bw4;
import com.baidu.tieba.cka;
import com.baidu.tieba.cn;
import com.baidu.tieba.dl9;
import com.baidu.tieba.dt4;
import com.baidu.tieba.e95;
import com.baidu.tieba.ek9;
import com.baidu.tieba.eka;
import com.baidu.tieba.et4;
import com.baidu.tieba.h9;
import com.baidu.tieba.hi9;
import com.baidu.tieba.i95;
import com.baidu.tieba.ij9;
import com.baidu.tieba.jd5;
import com.baidu.tieba.jk9;
import com.baidu.tieba.ke9;
import com.baidu.tieba.lf5;
import com.baidu.tieba.lf9;
import com.baidu.tieba.lh5;
import com.baidu.tieba.m45;
import com.baidu.tieba.mj5;
import com.baidu.tieba.n45;
import com.baidu.tieba.nf5;
import com.baidu.tieba.nj5;
import com.baidu.tieba.p06;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.qsa;
import com.baidu.tieba.r85;
import com.baidu.tieba.rba;
import com.baidu.tieba.rl5;
import com.baidu.tieba.rl9;
import com.baidu.tieba.s06;
import com.baidu.tieba.s45;
import com.baidu.tieba.ta5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tj5;
import com.baidu.tieba.u45;
import com.baidu.tieba.uj5;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.v45;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.w05;
import com.baidu.tieba.w16;
import com.baidu.tieba.w45;
import com.baidu.tieba.wg5;
import com.baidu.tieba.xca;
import com.baidu.tieba.xh5;
import com.baidu.tieba.xk9;
import com.baidu.tieba.yh5;
import com.baidu.tieba.ym;
import com.baidu.tieba.zj9;
import com.baidu.tieba.zk9;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes7.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.i, s06, BdListView.p, lf9<NewSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String K0 = "tbgametype";
    public transient /* synthetic */ FieldHolder $fh;
    public ag<TextView> A;
    public CustomMessageListener A0;
    public ag<GifView> B;
    public CustomMessageListener B0;
    public ag<View> C;
    public final i95.g C0;
    public ag<ImageView> D;
    public int D0;
    public ag<LinearLayout> E;
    public Runnable E0;
    public ag<RelativeLayout> F;
    public CustomMessageListener F0;
    public ag<FestivalTipView> G;
    public boolean G0;
    public tj5 H;
    public final n45.c H0;
    public boolean I;
    public CustomMessageListener I0;
    public BdPageContext J;
    public CustomMessageListener J0;
    public Object K;
    public e95 L;
    public boolean M;
    public BdUniqueId N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1148T;
    public boolean U;
    public qsa V;
    public EditText W;
    public ReplyPrivacyCheckController X;
    public bc9<ke9> Y;
    public ij9 Z;
    public boolean a;
    public PostWriteCallBackData a0;
    public int b;
    public boolean b0;
    public SubPbModel c;
    public nj5 c0;
    public xk9 d;
    public String d0;
    public PermissionJudgePolicy e;
    public PbCommenFloorItemViewHolder e0;
    public hi9 f;
    public int f0;
    public bw4 g;
    public boolean g0;
    public ForumManageModel h;
    public r85 h0;
    public VoiceManager i;
    public BdUniqueId i0;
    public zk9 j;
    public AgreeMessageData j0;
    public BdImage k;
    public String l;
    public TbRichTextMemeInfo m;
    public rba n;
    public u45 o;
    public w45 p;
    public w45.f q;
    public View.OnClickListener r;
    public boolean r0;
    public AbsListView.OnScrollListener s;
    public cka s0;
    public View.OnLongClickListener t;
    @Nullable
    public TiePlusEventController t0;
    public TbRichTextView.z u;
    @NonNull
    public TiePlusEventController.g u0;
    public SubPbModel.b v;
    public BdUniqueId v0;
    public bw4.a w;
    public mj5 w0;
    public h9 x;
    public CustomMessageListener x0;
    public u0 y;
    public NewWriteModel.d y0;
    public u0 z;
    public CustomMessageListener z0;

    /* loaded from: classes7.dex */
    public interface u0 {
        void callback(Object obj);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(889977085, "Lcom/baidu/tieba/pb/pb/sub/NewSubPbActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(889977085, "Lcom/baidu/tieba/pb/pb/sub/NewSubPbActivity;");
        }
    }

    @Override // com.baidu.tieba.s06
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.s06
    public ag<TiebaPlusRecommendCard> H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s06
    public void K(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.s06
    public void Z(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.s06
    public void f0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048640, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? "a007" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s06
    public void i0(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048653, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.s06
    public void j1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048656, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.s06
    public ag<ItemCardView> o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class g implements SubPbModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ke9 a;
            public final /* synthetic */ g b;

            public a(g gVar, ke9 ke9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, ke9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = ke9Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.b.a.r0 = false;
                this.b.a.s4(this.a.g(), false);
            }
        }

        public g(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.b
        public void a(boolean z, int i, String str, ke9 ke9Var) {
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, ke9Var}) != null) || this.a.j == null) {
                return;
            }
            this.a.j.e0();
            if (this.a.Q && this.a.j.u() != null) {
                NewSubPbActivity newSubPbActivity = this.a;
                newSubPbActivity.hideLoadingView(newSubPbActivity.j.u());
            }
            if (z) {
                this.a.j.L();
                if (ke9Var != null) {
                    if (ke9Var.g() != null || this.a.c != null) {
                        ke9Var.g().n1(this.a.c.L0());
                    }
                    if (this.a.j != null) {
                        NewSubPbActivity newSubPbActivity2 = this.a;
                        if (ke9Var.j() != null && ke9Var.j().isBjh()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        newSubPbActivity2.S3(z2);
                        if (this.a.H != null && this.a.H.b() != null) {
                            this.a.H.b().z(TbadkCoreApplication.getInst().getSkinType());
                        }
                        zk9 zk9Var = this.a.j;
                        int Q0 = this.a.c.Q0();
                        if (this.a.c.P0() != null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zk9Var.A0(ke9Var, Q0, z3, this.a.M);
                        if (this.a.M) {
                            this.a.j.B().setSelectionFromTop(this.a.j.B().getHeaderViewsCount() + 1, -BdUtilHelper.getDimens(this.a, R.dimen.tbds18));
                            this.a.h3();
                            this.a.M = false;
                        }
                    }
                    if (this.a.H != null) {
                        this.a.H.J(ke9Var.a());
                        this.a.H.f0(ke9Var.j());
                        if (this.a.getIntent() != null && this.a.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && this.a.r0) {
                            SafeHandler.getInst().postDelayed(new a(this, ke9Var), 200L);
                        }
                    }
                    if (this.a.Y == null) {
                        this.a.Y = new bc9();
                    }
                    this.a.Y.b(ke9Var);
                    this.a.Y.c(0);
                    NewSubPbActivity newSubPbActivity3 = this.a;
                    newSubPbActivity3.X.setLikeUserData(newSubPbActivity3.c.x0());
                }
                String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
                if (TextUtils.isEmpty(stringExtra) || this.a.U) {
                    return;
                }
                this.a.U = true;
                NewSubPbActivity newSubPbActivity4 = this.a;
                newSubPbActivity4.v4(newSubPbActivity4.j.G(), this.a.H, stringExtra);
                return;
            }
            this.a.q4(i, str);
        }
    }

    /* loaded from: classes7.dex */
    public class p0 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes7.dex */
        public class a implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(p0 p0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    m45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements m45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p0 a;

            public b(p0 p0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = p0Var;
            }

            @Override // com.baidu.tieba.m45.e
            public void onClick(m45 m45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                    m45Var.dismiss();
                    ek9.a(this.a.a.getPageContext());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public p0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, jd5 jd5Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, jd5Var, writeData, antiData}) == null) {
                if (z && this.a.H != null && this.a.H.b() != null) {
                    this.a.H.b().q();
                    if (this.a.c.Y0()) {
                        rl9.t("c10367", null, this.a.c.P());
                    }
                }
                if (z) {
                    if (writeData != null) {
                        ta5.b(writeData.getContent(), "4");
                    }
                    this.a.V.n(null);
                    this.a.V.i(null);
                    this.a.V.k(false);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        nf5.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    this.a.V.i(postWriteCallBackData.getSensitiveWords());
                    this.a.V.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.a.V.a())) {
                        return;
                    }
                    this.a.a0 = postWriteCallBackData;
                    if (this.a.H.z()) {
                        this.a.H.w(this.a.a0);
                    }
                    this.a.e3(true);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (bi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    m45 m45Var = new m45(this.a.getActivity());
                    if (bi.isEmpty(postWriteCallBackData.getErrorString())) {
                        m45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        m45Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new a(this));
                    m45Var.setPositiveButton(R.string.open_now, new b(this));
                    m45Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && (replyPrivacyCheckController = this.a.X) != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
                this.a.j.e0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public a(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b0 || this.a.H == null) {
                return;
            }
            for (xh5 xh5Var : this.a.H.b().getAllTools()) {
                if (xh5Var != null) {
                    yh5 yh5Var = xh5Var.m;
                    if ((yh5Var instanceof PbNewInputContainer) && ((View) yh5Var).getVisibility() == 0 && !xh5Var.o) {
                        xh5Var.m.display();
                    }
                }
            }
            if (this.a.D0 < 5) {
                NewSubPbActivity.D1(this.a);
                SafeHandler.getInst().postDelayed(this.a.E0, 200L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements bg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public a0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
            }
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (b05.c().g()) {
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = b05.c().g();
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
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
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
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            rba rbaVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w16)) {
                w16 w16Var = (w16) customResponsedMessage.getData();
                if (this.a.j.B() instanceof BdTypeListView) {
                    List<ym> data = ((BdTypeListView) this.a.j.B()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        for (int i = 0; i < data.size(); i++) {
                            if ((data.get(i) instanceof rba) && (rbaVar = (rba) data.get(i)) != null && rbaVar.r() != null && rbaVar.r().getPortrait() != null && rbaVar.r().getPortrait().equals(w16Var.a) && rbaVar.r().getUserWorldCupData() != null) {
                                rbaVar.r().getUserWorldCupData().d(w16Var.b);
                            }
                        }
                        this.a.j.T();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements bg<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public View e(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) ? view2 : (View) invokeL.objValue;
        }

        public b0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ View c(View view2) {
            View view3 = view2;
            h(view3);
            return view3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).k();
            }
        }

        public View h(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).k();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.z0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public c(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                this.a.H.I();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements bg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

        public c0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
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
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public d(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.c != null) {
                this.a.c.loadData();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements bg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        public d0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new RelativeLayout(this.a.getPageContext().getPageActivity());
            }
            return (RelativeLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public e(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(rba rbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rbaVar) == null) {
                this.a.j.s0(rbaVar);
                this.a.j.o0(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 extends PageStayDurationFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public e0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tbadk.pageStayDuration.PageStayDurationFilter
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return PageStayDurationStat.getInstance().getMaxCostFromServer();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ tj5 b;
        public final /* synthetic */ NewSubPbActivity c;

        public f(NewSubPbActivity newSubPbActivity, View view2, tj5 tj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, view2, tj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = newSubPbActivity;
            this.a = view2;
            this.b = tj5Var;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) {
                this.a.performClick();
                this.b.r();
                this.b.u().i().setText(str);
                Editable text = this.b.u().i().getText();
                if (!TextUtils.isEmpty(text)) {
                    this.b.u().i().setSelection(text.length());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ NewSubPbActivity b;

        public f0(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newSubPbActivity;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.b.j.t0();
                MessageManager.getInstance().sendMessage(this.a);
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements mj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public g0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.mj5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.V.d()) {
                    NewSubPbActivity newSubPbActivity = this.a;
                    newSubPbActivity.showToast(newSubPbActivity.V.c());
                    if (this.a.H.z()) {
                        this.a.H.w(this.a.a0);
                    }
                    this.a.e3(true);
                    return true;
                }
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (newSubPbActivity2.X != null && newSubPbActivity2.c != null && this.a.c.w0() != null && !this.a.G(TbadkCoreApplication.getCurrentAccount())) {
                    NewSubPbActivity newSubPbActivity3 = this.a;
                    if (!newSubPbActivity3.X.checkPrivacyBeforeSend(newSubPbActivity3.c.w0().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class h implements bw4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public h(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.bw4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.g != null) {
                        this.a.g.h(z2);
                    }
                    MarkData f = this.a.g.f();
                    bc9 bc9Var = new bc9();
                    bc9Var.c(2);
                    if (z2) {
                        bc9Var.b(f);
                        if (this.a.g != null) {
                            if (f != null) {
                                this.a.c.p1(true);
                                this.a.c.q1(this.a.c.P());
                                this.a.showToast(R.string.obfuscated_res_0x7f0f00ff);
                            } else {
                                NewSubPbActivity newSubPbActivity = this.a;
                                newSubPbActivity.showToast(newSubPbActivity.getPageContext().getString(R.string.add_mark));
                            }
                        }
                    } else {
                        bc9Var.b(null);
                        this.a.c.p1(false);
                        this.a.c.q1(null);
                        NewSubPbActivity newSubPbActivity2 = this.a;
                        newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(R.string.remove_mark));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, bc9Var));
                    return;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public h0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements u0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public i(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.u0
        public void callback(Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String str5 = "";
                if (this.a.c.y0() == null || this.a.c.y0().j() == null || this.a.c.y0().j().getAuthor() == null) {
                    str = "";
                } else {
                    str = String.valueOf(this.a.c.y0().j().getAuthor().getUserId());
                }
                if (objArr.length <= 1) {
                    str2 = "";
                } else {
                    str2 = String.valueOf(objArr[1]);
                }
                if (objArr.length <= 2) {
                    str3 = "";
                } else {
                    str3 = String.valueOf(objArr[2]);
                }
                if (objArr.length <= 3) {
                    str4 = "";
                } else {
                    str4 = String.valueOf(objArr[3]);
                }
                if (objArr.length > 4) {
                    str5 = String.valueOf(objArr[4]);
                }
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.c.y0().d().getId(), this.a.c.y0().d().getName(), this.a.c.y0().j().getId(), str, str2, str4, str3, str5)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public i0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements u0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public j(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.u0
        public void callback(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!this.a.h.g0() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = JavaTypesHelper.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = JavaTypesHelper.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = JavaTypesHelper.toInt(String.valueOf(objArr[3]), 0);
                        if (this.a.c != null && this.a.c.y0() != null && this.a.c.y0().d() != null && this.a.c.y0().j() != null) {
                            if (objArr.length > 4) {
                                this.a.h.i0(String.valueOf(objArr[4]));
                            }
                            this.a.h.j0(this.a.c.y0().d().getId(), this.a.c.y0().d().getName(), this.a.c.y0().j().getId(), valueOf, i2, i, z, this.a.c.y0().j().getBaijiahaoData(), false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public j0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    m45Var.dismiss();
                    ((TbPageContext) this.a.J).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                m45Var.dismiss();
                ek9.a(this.a.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements nj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public k(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.nj5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.q0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public k0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public l(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.h.getLoadDataMode();
                    if (loadDataMode != 0) {
                        if (loadDataMode == 1) {
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.j.s(1, dVar.a, dVar.b, true);
                            return;
                        }
                        return;
                    }
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    this.a.x3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                    return;
                }
                this.a.j.s(this.a.h.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
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
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData)) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            UserPendantData userPendantData = (UserPendantData) customResponsedMessage.getData();
            if (this.a.c.y0() != null && this.a.c.y0().g() != null && this.a.c.y0().g().r() != null && currentAccount.equals(this.a.c.y0().g().r().getUserId()) && this.a.c.y0().g().r().getPendantData() != null) {
                this.a.c.y0().g().r().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.a.c.y0().g().r().getPendantData().setPropsId(userPendantData.getPropsId());
                zk9 zk9Var = this.a.j;
                ke9 y0 = this.a.c.y0();
                rba g = this.a.c.y0().g();
                boolean e = this.a.c.y0().e();
                int Q0 = this.a.c.Q0();
                if (this.a.c.P0() != null) {
                    z = true;
                } else {
                    z = false;
                }
                zk9Var.r(y0, g, e, false, Q0, z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ NewSubPbActivity d;

        public m(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = newSubPbActivity;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                if (m45Var != null) {
                    m45Var.dismiss();
                }
                if (this.d.z != null) {
                    this.d.z.callback(new Object[]{this.a.get(R.id.tag_del_post_id), Integer.valueOf(this.b), Boolean.valueOf(this.c), this.a.get(R.id.tag_del_post_type)});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ NewSubPbActivity c;

        public m0(NewSubPbActivity newSubPbActivity, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = newSubPbActivity;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.j != null && this.c.j.B() != null) {
                this.c.j.B().setSelectionFromTop(this.a, this.c.j.D() - this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public n(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                m45Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ NewSubPbActivity d;

        public n0(NewSubPbActivity newSubPbActivity, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = newSubPbActivity;
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.d.j != null && this.d.j.B() != null) {
                this.d.j.B().setSelectionFromTop(this.a, this.d.j.D() + (this.b - this.c));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public o(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.j != null) {
                boolean z = true;
                boolean z2 = false;
                if (view2 == this.a.j.A()) {
                    this.a.j.o();
                    String J3 = this.a.J3(view2, R.id.tag_user_id);
                    String J32 = this.a.J3(view2, R.id.tag_user_name);
                    String J33 = this.a.J3(view2, R.id.tag_virtual_user_url);
                    if (!TextUtils.isEmpty(J33)) {
                        if (!this.a.checkUpIsLogin()) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{J33});
                    } else if (!TextUtils.isEmpty(J3)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), J3, J32, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                    }
                } else if (view2 == this.a.j.G()) {
                    if (this.a.d3() && this.a.checkUpIsLogin()) {
                        this.a.t4();
                        if (this.a.c != null && this.a.c.y0() != null && this.a.c.y0().j() != null && this.a.c.y0().j().getAuthor() != null) {
                            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.c.M0()).param("fid", this.a.c.y0().j().getFid()).param("obj_locate", 5).param("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    }
                } else if (view2 == this.a.j.E()) {
                    if (!this.a.checkUpIsLogin()) {
                        return;
                    }
                    this.a.j.D0();
                    this.a.j.m();
                    if (this.a.H != null) {
                        this.a.H.i0();
                    }
                } else if (view2 == this.a.j.F()) {
                    if (!this.a.checkUpIsLogin()) {
                        return;
                    }
                    this.a.j.D0();
                    this.a.j.m();
                    if (this.a.H != null) {
                        this.a.H.k0();
                    }
                } else if (view2.getId() != R.id.obfuscated_res_0x7f091aa9 && view2.getId() != R.id.obfuscated_res_0x7f091b0e) {
                    if (view2 == this.a.j.C()) {
                        this.a.j.o();
                        if (this.a.c.loadData()) {
                            this.a.j.z0();
                            return;
                        }
                        return;
                    }
                    String str = "";
                    if (view2 != this.a.j.y() && view2 != this.a.j.x() && view2 != this.a.j.H()) {
                        if (view2 != this.a.j.z() && view2 != this.a.j.H()) {
                            if (view2 == null || !(view2.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                if (view2.getId() != R.id.obfuscated_res_0x7f091cf8 && view2.getId() != R.id.obfuscated_res_0x7f091aa5) {
                                    if (view2 == this.a.j.w()) {
                                        if (!this.a.d3() || this.a.H == null || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                                            return;
                                        }
                                        this.a.H.i0();
                                        this.a.v3();
                                        return;
                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f090870 && view2.getId() != R.id.obfuscated_res_0x7f090b70) {
                                        if ((view2.getId() == R.id.obfuscated_res_0x7f091ad9 || view2.getId() == R.id.obfuscated_res_0x7f091a9f) && ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                            String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
                                            if (!StringUtils.isNull(string2)) {
                                                TiebaStatic.log("c10056");
                                                BrowserHelper.startWebActivity(view2.getContext(), string, string2, true, true, true);
                                                return;
                                            }
                                            return;
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091f04 && (view2.getTag() instanceof SparseArray)) {
                                            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
                                            if (obj instanceof rba) {
                                                rba rbaVar = (rba) obj;
                                                if (rbaVar.getType() == rba.Z0 || TextUtils.isEmpty(rbaVar.u()) || !b05.c().g()) {
                                                    return;
                                                }
                                                this.a.p4(rbaVar);
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        SparseArray sparseArray = (SparseArray) view2.getTag();
                                        if (sparseArray != null && (sparseArray.get(R.id.tag_load_sub_data) instanceof rba)) {
                                            rba rbaVar2 = (rba) sparseArray.get(R.id.tag_load_sub_data);
                                            View view3 = (View) sparseArray.get(R.id.tag_load_sub_view);
                                            if (rbaVar2 != null && view3 != null) {
                                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090871);
                                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090872);
                                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b70);
                                                if (rbaVar2.C0()) {
                                                    rbaVar2.f1(false);
                                                    jk9.e(rbaVar2);
                                                } else {
                                                    if (this.a.c != null) {
                                                        z2 = jk9.c(this.a.c.y0(), rbaVar2);
                                                    }
                                                    if (z2) {
                                                        rbaVar2.f1(true);
                                                    }
                                                }
                                                if (rbaVar2.C0()) {
                                                    i = R.color.CAM_X0201;
                                                } else {
                                                    i = R.color.transparent;
                                                }
                                                SkinManager.setBackgroundColor(findViewById, i);
                                                boolean C0 = rbaVar2.C0();
                                                int i4 = R.color.CAM_X0304;
                                                if (C0) {
                                                    i2 = R.color.CAM_X0304;
                                                } else {
                                                    i2 = R.color.CAM_X0107;
                                                }
                                                SkinManager.setViewTextColor(eMTextView, i2);
                                                if (rbaVar2.C0()) {
                                                    i3 = R.drawable.icon_pure_pb_del_select;
                                                } else {
                                                    i3 = R.drawable.icon_pure_pb_del_normal;
                                                }
                                                if (!rbaVar2.C0()) {
                                                    i4 = R.color.CAM_X0107;
                                                }
                                                WebPManager.setPureDrawable(imageView, i3, i4, null);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                                this.a.t3(view2);
                                return;
                            }
                            this.a.e0 = (PbCommenFloorItemViewHolder) view2.getTag();
                            if (!this.a.d3() || !ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                return;
                            }
                            if (!this.a.O) {
                                NewSubPbActivity newSubPbActivity = this.a;
                                if (newSubPbActivity.X != null && newSubPbActivity.c != null && this.a.c.w0() != null && !this.a.G(TbadkCoreApplication.getCurrentAccount())) {
                                    NewSubPbActivity newSubPbActivity2 = this.a;
                                    if (!newSubPbActivity2.X.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.c.w0().replyPrivateFlag)) {
                                        return;
                                    }
                                }
                                SparseArray sparseArray2 = (SparseArray) view2.getTag(R.id.tag_from);
                                if (sparseArray2 == null) {
                                    return;
                                }
                                this.a.r4(sparseArray2, ((view2.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view2.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE) ? false : false);
                                if (sparseArray2.get(R.id.tag_clip_board) instanceof rba) {
                                    rba rbaVar3 = (rba) sparseArray2.get(R.id.tag_clip_board);
                                    if (this.a.c != null) {
                                        str = this.a.c.M0();
                                    }
                                    dl9.a(str, TbadkCoreApplication.getCurrentAccount(), rbaVar3.S());
                                    return;
                                }
                                return;
                            }
                            this.a.O = false;
                        } else if (!this.a.checkUpIsLogin()) {
                        } else {
                            if (this.a.H.C()) {
                                this.a.H.A();
                            } else {
                                this.a.H.n0(null, null);
                            }
                        }
                    } else if (!this.a.O) {
                        if (this.a.c.y0() != null && this.a.c.y0().j() != null) {
                            z2 = ThreadCardUtils.isUgcThreadType(this.a.c.y0().j().getBaijiahaoData());
                        }
                        if (z2) {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.getActivity()).createNormalCfg(this.a.c.M0(), null, "");
                            if (!StringUtils.isNull(this.a.c.getFromForumId())) {
                                createNormalCfg.setForumId(this.a.c.getFromForumId());
                            }
                            if (this.a.c.y0() != null && this.a.c.y0().j() != null) {
                                createNormalCfg.setBjhData(this.a.c.y0().j().getBaijiahaoData());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } else if (this.a.c != null && this.a.c.y0() != null) {
                            if (this.a.j4(this.a.c.y0().j())) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(this.a.c.y0().j());
                                new VideoRecommentPlayActivityConfig(this.a.getActivity(), Collections.singletonList(videoItemData), null, VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE).start();
                                return;
                            }
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.a.getActivity()).createNormalCfg(this.a.c.M0(), this.a.c.P(), "");
                            if (!StringUtils.isNull(this.a.c.getFromForumId())) {
                                createNormalCfg2.setForumId(this.a.c.getFromForumId());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
                        }
                    } else {
                        this.a.O = false;
                    }
                } else {
                    this.a.t.onLongClick(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
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
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.c != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.c.M0())) {
                if (this.a.V != null) {
                    this.a.V.n(null);
                    this.a.V.i(null);
                    this.a.V.k(false);
                }
                if (this.a.H != null) {
                    this.a.H.r();
                    this.a.H.K();
                }
                this.a.c.Y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public p(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                this.a.j.Y();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (i == 2 || i == 1) {
                    this.a.j.o();
                    if (this.a.f0 != 2 && this.a.f0 != 1) {
                        this.a.j.M();
                    }
                }
                this.a.H.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public q(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a.j != null && this.a.j.S()) {
                    return false;
                }
                return this.a.u3(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
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
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N) {
                this.a.j.K();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.L.d(this.a.J.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.J.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    this.a.y4(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.w4();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (bi.isEmpty(errorString2)) {
                        errorString2 = this.a.J.getResources().getString(R.string.mute_fail);
                    }
                    this.a.L.c(errorString2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public r(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            TbRichTextData tbRichTextData;
            String str2;
            String str3;
            boolean z3;
            String str4;
            String str5;
            String str6;
            int i2;
            boolean z4;
            String str7;
            String str8;
            String str9;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if ((view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) && ((TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info)).memeInfo != null && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                        this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, ((TbImageView) view2).isGif())));
                        return;
                    }
                    ke9 y0 = this.a.c.y0();
                    TbRichText C4 = this.a.C4(str, i);
                    if (C4 != null && C4.P() != null) {
                        tbRichTextData = C4.P().get(this.a.b);
                    } else {
                        tbRichTextData = null;
                    }
                    if (tbRichTextData == null) {
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (tbRichTextData.V().T()) {
                        this.a.G0 = false;
                        String str10 = "";
                        TbRichText e0 = y0.g().e0();
                        int size = arrayList.size();
                        int E3 = this.a.E3(e0, C4, i, i, arrayList, concurrentHashMap);
                        int size2 = arrayList.size();
                        if (size != size2) {
                            str10 = arrayList.get(size2 - 1);
                        }
                        if (y0 != null) {
                            if (y0.d() != null) {
                                str5 = y0.d().getName();
                                str3 = y0.d().getId();
                            } else {
                                str5 = null;
                                str3 = null;
                            }
                            if (y0.j() != null) {
                                str6 = y0.j().getId();
                            } else {
                                str6 = null;
                            }
                            str2 = str6;
                            z3 = true;
                            str4 = str5;
                        } else {
                            str2 = null;
                            str3 = null;
                            z3 = false;
                            str4 = null;
                        }
                        if (this.a.c.P0() != null) {
                            concurrentHashMap = this.a.c.P0();
                            z3 = this.a.c.V0();
                            arrayList = this.a.c.O0();
                            E3 += this.a.c.I0();
                        }
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(ListUtils.getItem(arrayList, E3));
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.setData(arrayList2).setForumName(str4).setForumId(str3).setThreadId(str2).setIsCDN(z3).setLastId(str10).setIsReserve(true).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(false).setThreadData(this.a.K3()).setPostId(String.valueOf(C4.getPostId())).setBjhPostId(String.valueOf(C4.getPostId())).setFromForumId(this.a.c.getFromForumId());
                        this.a.sendMessage(new CustomMessage(2010000, builder.bulid(this.a.getPageContext().getPageActivity())));
                        return;
                    }
                    String w3 = this.a.w3(tbRichTextData);
                    arrayList.add(w3);
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = str;
                    if (this.a.a) {
                        i2 = 17;
                    } else {
                        i2 = 18;
                    }
                    imageUrlData.urlType = i2;
                    imageUrlData.urlThumbType = i2;
                    imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
                    concurrentHashMap.put(w3, imageUrlData);
                    if (y0 != null) {
                        if (y0.d() != null) {
                            str7 = y0.d().getName();
                            str8 = y0.d().getId();
                        } else {
                            str7 = null;
                            str8 = null;
                        }
                        if (y0.j() != null) {
                            str9 = y0.j().getId();
                        } else {
                            str9 = null;
                        }
                        z4 = true;
                    } else {
                        z4 = false;
                        str7 = null;
                        str8 = null;
                        str9 = null;
                    }
                    if (this.a.c.P0() != null) {
                        concurrentHashMap = this.a.c.P0();
                        z4 = this.a.c.V0();
                        arrayList = this.a.c.O0();
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(ListUtils.getItem(arrayList, 0));
                    ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                    builder2.setData(arrayList3).setForumName(str7).setForumId(str8).setThreadId(str9).setIsCDN(z4).setLastId(arrayList.get(0)).setIsReserve(true).setAssistUrls(concurrentHashMap).setIsShowAd(true).setNeedBroadCaset(false).setIsSeeHost(false).setThreadData(this.a.K3()).setPostId(String.valueOf(C4.getPostId())).setBjhPostId(String.valueOf(C4.getPostId())).setFromForumId(this.a.c.getFromForumId());
                    this.a.sendMessage(new CustomMessage(2010000, builder2.bulid(this.a.getPageContext().getPageActivity())));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
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
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N) {
                this.a.j.K();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.L.d(this.a.J.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (bi.isEmpty(muteMessage)) {
                    muteMessage = this.a.J.getResources().getString(R.string.un_mute_fail);
                }
                this.a.L.c(muteMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements w45.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public s(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.w45.f
        public void K0(w45 w45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, w45Var, i, view2) == null) {
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                if (i != -4) {
                    if (i != -3) {
                        if (i != -2) {
                            if (i != -1) {
                                if (i != 13) {
                                    switch (i) {
                                        case 1:
                                            this.a.n3();
                                            return;
                                        case 2:
                                            this.a.r3();
                                            return;
                                        case 3:
                                            this.a.j3(view2);
                                            return;
                                        case 4:
                                            this.a.p3(view2);
                                            return;
                                        case 5:
                                            this.a.q3(view2);
                                            return;
                                        case 6:
                                            this.a.l3(view2);
                                            return;
                                        case 7:
                                            this.a.o3(view2);
                                            return;
                                        case 8:
                                            this.a.m3(view2);
                                            return;
                                        case 9:
                                            this.a.i3(view2);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                this.a.k3();
                                return;
                            }
                            this.a.l4(view2);
                            return;
                        }
                        this.a.n4(view2);
                        return;
                    }
                    this.a.m4(view2, R.id.pb_dialog_item_reply);
                    return;
                }
                this.a.m4(view2, R.id.pb_dialog_item_share);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s0(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
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
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof eka) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N) {
                eka ekaVar = (eka) customResponsedMessage.getData();
                this.a.j.K();
                SparseArray<Object> sparseArray = (SparseArray) this.a.K;
                DataRes dataRes = ekaVar.a;
                int i = 0;
                if (ekaVar.c == 0 && dataRes != null) {
                    if (JavaTypesHelper.toInt(dataRes.is_mute, 0) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_user_mute_msg, dataRes.mute_confirm);
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    z = false;
                }
                sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                if (sparseArray.get(R.id.tag_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                }
                if (i != 0) {
                    if (i == 1) {
                        this.a.j.a0(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.x4(z, sparseArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements w45.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public t(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.w45.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p != null) {
                this.a.p.r(zj9.g(this.a.n));
                ArrayList arrayList = new ArrayList();
                for (v45 v45Var : this.a.p.g()) {
                    if (v45Var instanceof s45) {
                        arrayList.add((s45) v45Var);
                    }
                }
                zj9.e(arrayList);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements i95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public t0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.i95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.c != null) {
                this.a.c.h1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements n45.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public u(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                n45Var.e();
                if (this.a.k != null && !TextUtils.isEmpty(this.a.l)) {
                    if (i == 0) {
                        if (this.a.m == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.l));
                        } else {
                            rl5.a aVar = new rl5.a();
                            aVar.a = this.a.l;
                            String str = "";
                            if (this.a.m.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.a.m.memeInfo.pck_id;
                            }
                            aVar.b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                    } else if (i == 1) {
                        if (this.a.e == null) {
                            this.a.e = new PermissionJudgePolicy();
                        }
                        this.a.e.clearRequestPermissionList();
                        this.a.e.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.e.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.a.f == null) {
                            NewSubPbActivity newSubPbActivity = this.a;
                            newSubPbActivity.f = new hi9(newSubPbActivity.getPageContext());
                        }
                        this.a.f.b(this.a.l, this.a.k.getImageByte());
                    }
                    this.a.k = null;
                    this.a.l = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements TiePlusEventController.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public v(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.g
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.O = true;
        }
    }

    /* loaded from: classes7.dex */
    public class w implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

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

        public w(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || this.a.V == null) {
                return;
            }
            if (!this.a.V.e()) {
                this.a.e3(false);
            }
            this.a.V.l(false);
        }
    }

    /* loaded from: classes7.dex */
    public class x implements n45.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ NewSubPbActivity d;

        public x(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, sparseArray, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = newSubPbActivity;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
        }

        @Override // com.baidu.tieba.n45.c
        public void a(n45 n45Var, int i, View view2) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n45Var, i, view2) == null) {
                if (i == 0) {
                    String str5 = "";
                    if (!(this.a.get(R.id.tag_user_mute_mute_username) instanceof String)) {
                        str = "";
                    } else {
                        str = (String) this.a.get(R.id.tag_user_mute_mute_username);
                    }
                    if (!(this.a.get(R.id.tag_user_mute_thread_id) instanceof String)) {
                        str2 = "";
                    } else {
                        str2 = (String) this.a.get(R.id.tag_user_mute_thread_id);
                    }
                    if (!(this.a.get(R.id.tag_user_mute_post_id) instanceof String)) {
                        str3 = "";
                    } else {
                        str3 = (String) this.a.get(R.id.tag_user_mute_post_id);
                    }
                    if (!(this.a.get(R.id.tag_user_mute_msg) instanceof String)) {
                        str4 = "";
                    } else {
                        str4 = (String) this.a.get(R.id.tag_user_mute_msg);
                    }
                    if (this.a.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
                        str5 = (String) this.a.get(R.id.tag_user_mute_mute_nameshow);
                    }
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, str4, this.d.N);
                    userMuteAddAndDelCustomMessage.setTag(this.d.N);
                    this.d.z4(this.b, userMuteAddAndDelCustomMessage, str4, str, str5);
                }
                n45Var.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
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
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof p06.a)) {
                p06.a aVar = (p06.a) customResponsedMessage.getData();
                p06.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements bg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }

        public z(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.bg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.m();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new GifView(this.a.getPageContext().getPageActivity());
            }
            return (GifView) invokeV.objValue;
        }
    }

    public NewSubPbActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = true;
        this.b = 0;
        this.n = null;
        this.w = null;
        this.y = null;
        this.z = null;
        this.I = false;
        this.M = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = 0;
        this.f1148T = false;
        this.c0 = new k(this);
        this.f0 = 0;
        this.g0 = false;
        this.i0 = BdUniqueId.gen();
        this.r0 = true;
        this.u0 = new v(this);
        this.w0 = new g0(this);
        this.x0 = new o0(this, 2921481);
        this.y0 = new p0(this);
        this.z0 = new q0(this, 2001427);
        this.A0 = new r0(this, 2001428);
        this.B0 = new s0(this, 2001426);
        this.C0 = new t0(this);
        this.D0 = 0;
        this.E0 = new a(this);
        this.F0 = new b(this, 2921787);
        this.G0 = false;
        this.H0 = new u(this);
        this.I0 = new y(this, 2001332);
        this.J0 = new l0(this, 2016485);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t4() {
        boolean z2;
        String str;
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                z2 = intent.getBooleanExtra("key_is_from_dynamic", false);
            } else {
                z2 = false;
            }
            if (f3()) {
                return;
            }
            if (z2) {
                if (this.X != null && (subPbModel2 = this.c) != null && subPbModel2.w0() != null && !G(TbadkCoreApplication.getCurrentAccount()) && !this.X.checkPrivacyBeforeInvokeEditor(this.c.w0().replyPrivateFlag)) {
                    return;
                }
                if (this.H.z()) {
                    this.H.w(null);
                    return;
                }
                this.j.D0();
                this.j.m();
                tj5 tj5Var = this.H;
                if (tj5Var != null) {
                    tj5Var.m0();
                }
            } else if (this.X != null && (subPbModel = this.c) != null && subPbModel.w0() != null && !G(TbadkCoreApplication.getCurrentAccount()) && !this.X.checkPrivacyBeforeInvokeEditor(this.c.w0().replyPrivateFlag)) {
            } else {
                SubPbModel subPbModel3 = this.c;
                if (subPbModel3 != null && subPbModel3.y0() != null && this.c.y0().g() != null) {
                    rba g2 = this.c.y0().g();
                    if (g2.e0() != null && g2.r() != null) {
                        str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), g2.r().getName_show(), g2.e0().toString());
                        this.H.b().D(new lh5(45, 27, str));
                        if (!this.H.z()) {
                            this.H.w(null);
                            return;
                        }
                        this.j.D0();
                        this.j.m();
                        tj5 tj5Var2 = this.H;
                        if (tj5Var2 != null) {
                            tj5Var2.m0();
                            return;
                        }
                        return;
                    }
                }
                str = null;
                this.H.b().D(new lh5(45, 27, str));
                if (!this.H.z()) {
                }
            }
        }
    }

    public static /* synthetic */ int D1(NewSubPbActivity newSubPbActivity) {
        int i2 = newSubPbActivity.D0;
        newSubPbActivity.D0 = i2 + 1;
        return i2;
    }

    public void B4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z2) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.v0);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final boolean U3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, bundle)) == null) {
            if (bundle != null) {
                this.R = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            } else {
                this.R = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            }
            return this.R;
        }
        return invokeL.booleanValue;
    }

    public final boolean V3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, bundle)) == null) {
            if (bundle != null) {
                this.P = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            } else {
                this.P = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            }
            return this.P;
        }
        return invokeL.booleanValue;
    }

    public final boolean W3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, bundle)) == null) {
            if (bundle != null) {
                this.f1148T = bundle.getBoolean("is_jump_from_video_middle");
            } else {
                this.f1148T = getIntent().getBooleanExtra("is_jump_from_video_middle", false);
            }
            return this.f1148T;
        }
        return invokeL.booleanValue;
    }

    public final int Y3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, bundle)) == null) {
            if (bundle != null) {
                this.S = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                this.S = getIntent().getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.S;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.IPlayView g1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, voiceModel)) == null) {
            View z2 = this.j.z();
            if (z2 != null && (findViewWithTag = z2.findViewWithTag(voiceModel)) != null) {
                return (VoiceManager.IPlayView) findViewWithTag;
            }
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    public boolean g4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean j4(@Nullable ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, threadData)) == null) {
            if (threadData != null && threadData.isVideoThreadType() && threadData.getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void k4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
            BrowserHelper.startWebActivity(this, "", str, false, true, true, bundle);
        }
    }

    public final void l4(View view2) {
        View view3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048662, this, view2) == null) && (view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_1)) != null) {
            AgreeView agreeView = (AgreeView) view3;
            if (agreeView.getImgAgree() != null) {
                agreeView.getImgAgree().performClick();
            }
        }
    }

    public final void n4(View view2) {
        View view3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048666, this, view2) == null) && (view3 = (View) ((SparseArray) view2.getTag()).get(R.id.pb_dialog_item_zan_1)) != null) {
            AgreeView agreeView = (AgreeView) view3;
            if (agreeView.getImgDisagree() != null) {
                agreeView.getImgDisagree().performClick();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048672, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.j.X(i2);
            if (this.Q && !UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            this.b0 = z2;
            y3(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.tieba.k9
    public void onPreLoad(cn cnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, cnVar) == null) {
            PreLoadImageHelper.load(cnVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(cnVar, getUniqueId(), this);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null && (subPbModel = this.c) != null) {
                subPbModel.m1(bundle);
            }
        }
    }

    public final void p3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
            this.j.o();
            if (!checkUpIsLogin()) {
                return;
            }
            o4(view2);
        }
    }

    @Override // com.baidu.tieba.s06
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.O = true;
        }
    }

    public final String J3(View view2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, view2, i2)) == null) {
            if (view2.getTag(i2) instanceof String) {
                return (String) view2.getTag(i2);
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public final void W2(boolean z2, List<s45> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048614, this, z2, list) == null) && z2) {
            list.add(new s45(1, getString(R.string.save_to_emotion), this.p));
        }
    }

    public final void c3(boolean z2, List<s45> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048632, this, z2, list) == null) && z2) {
            list.add(new s45(2, getString(R.string.save_to_local), this.p));
        }
    }

    public final void m4(View view2, int i2) {
        View view3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048664, this, view2, i2) == null) && (view3 = (View) ((SparseArray) view2.getTag()).get(i2)) != null) {
            view3.performClick();
        }
    }

    public final void r4(SparseArray<Object> sparseArray, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048689, this, sparseArray, z2) != null) || sparseArray == null) {
            return;
        }
        if (sparseArray.get(R.id.tag_clip_board) instanceof rba) {
            s4((rba) sparseArray.get(R.id.tag_clip_board), z2);
        } else {
            s4(null, z2);
        }
    }

    public final String H3(SparseArray<?> sparseArray, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048591, this, sparseArray, i2, str)) == null) {
            if (sparseArray == null) {
                return str;
            }
            if (sparseArray.get(i2) instanceof String) {
                return (String) sparseArray.get(i2);
            }
            return str;
        }
        return (String) invokeLIL.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048670, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25035) {
                M3(i3, intent);
            }
            tj5 tj5Var = this.H;
            if (tj5Var != null) {
                tj5Var.E(i2, i3, intent);
            }
        }
    }

    public final void v4(View view2, tj5 tj5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048697, this, view2, tj5Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new f(this, view2, tj5Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0ee6), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    @Override // com.baidu.tieba.s06
    public ag<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.E == null) {
                this.E = new ag<>(new c0(this), 15, 0);
            }
            return this.E;
        }
        return (ag) invokeV.objValue;
    }

    public String F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!bi.isEmpty(this.d0)) {
                return this.d0;
            }
            String string = getResources().getString(bi9.g());
            this.d0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public SubPbModel I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.c;
        }
        return (SubPbModel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lf9
    public ij9 J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.Z;
        }
        return (ij9) invokeV.objValue;
    }

    public final ThreadData K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.y0() != null) {
                return this.c.y0().j();
            }
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public int L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.Q0();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.r = new o(this);
        }
    }

    @Override // com.baidu.tieba.s06
    public ag<RelativeLayout> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ag<RelativeLayout> agVar = new ag<>(new d0(this), 10, 0);
            this.F = agVar;
            return agVar;
        }
        return (ag) invokeV.objValue;
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.u = new r(this);
        }
    }

    @Override // com.baidu.tieba.s06
    public ag<FestivalTipView> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (this.G == null) {
                this.G = TbRichTextView.G(getPageContext().getPageActivity(), R.dimen.M_H_X004);
            }
            return this.G;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s06
    public ag<ImageView> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.D == null) {
                this.D = new ag<>(new a0(this), 8, 0);
            }
            return this.D;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s06
    public ag<View> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.C == null) {
                this.C = new ag<>(new b0(this), 8, 0);
            }
            return this.C;
        }
        return (ag) invokeV.objValue;
    }

    public void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            registerListener(this.J0);
            registerListener(this.F0);
            Q3();
            c4();
            b4();
            T3();
            a4();
        }
    }

    @Override // com.baidu.tieba.s06
    public ag<TextView> a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.A == null) {
                this.A = TbRichTextView.H(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (ag) invokeV.objValue;
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.q = new s(this);
        }
    }

    public final void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.t = new q(this);
        }
    }

    @Override // com.baidu.tieba.lf9
    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return 0;
            }
            return subPbModel.Q0();
        }
        return invokeV.intValue;
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.s = new p(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.P && !this.g0 && !this.Q && !this.R) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            } else {
                super.closeAnimation();
            }
        }
    }

    public boolean e4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.Z0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (this.P && !this.g0 && !this.Q && !this.R) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    public final boolean f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return false;
            }
            return AntiHelper.d(getPageContext(), subPbModel.w0());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s06
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            zk9 zk9Var = this.j;
            if (zk9Var != null) {
                return zk9Var.B();
            }
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || bi.isEmpty(subPbModel.M0())) {
                return 0L;
            }
            return JavaTypesHelper.toLong(this.c.M0(), 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationFilter getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return new e0(this);
        }
        return (PageStayDurationFilter) invokeV.objValue;
    }

    public boolean h4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            this.j.E0(true);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            if (this.j.B0() && BdUtilHelper.isNetOk()) {
                this.c.loadData();
            } else {
                this.j.e0();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            this.H.H();
        }
    }

    public void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", zk9.o0);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.s06
    public ag<GifView> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            if (this.B == null) {
                this.B = new ag<>(new z(this), 20, 0);
            }
            return this.B;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lf9
    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.y0() != null && this.c.y0().j() != null) {
                return !this.c.y0().j().isMutiForumThread();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void A4() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (subPbModel = this.c) != null && !bi.isEmpty(subPbModel.M0())) {
            et4.w().Q(dt4.Z, JavaTypesHelper.toLong(this.c.M0(), 0L));
        }
    }

    public void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.v = new g(this);
            this.w = new h(this);
            this.y = new i(this);
            this.z = new j(this);
            this.x = new l(this);
        }
    }

    @Override // com.baidu.tieba.lf9
    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.y0() != null && this.c.y0().j() != null) {
                return this.c.y0().j().getForum_name();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final boolean d3() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (this.X != null && (subPbModel = this.c) != null && subPbModel.y0() != null && this.c.y0().a() != null && !this.X.checkPrivacyBeforeInvokeEditor(this.c.y0().a().replyPrivateFlag)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.H.A();
            } else if (!StringUtils.isNull(this.c.K0())) {
                if (this.j.B0() && BdUtilHelper.isNetOk()) {
                    this.j.i0();
                } else {
                    this.j.e0();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            tj5 tj5Var = this.H;
            if (tj5Var != null && tj5Var.b() != null && this.H.b().x()) {
                this.H.b().t();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            this.I = false;
            super.onResume();
            TiePlusEventController tiePlusEventController = this.t0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            A4();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.I0);
            this.j.W();
            if (this.Q || this.R) {
                B4(true);
            }
        }
    }

    public final SparseArray<Object> A3(SparseArray<?> sparseArray, boolean z2, boolean z3, boolean z4, boolean z5, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), str})) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray2.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray2.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray2.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray2.put(R.id.tag_forbid_user_post_id, str);
            if (!zj9.j(I3().y0()) && z3) {
                sparseArray2.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                sparseArray2.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray2.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray2.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray2.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray2.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            } else {
                sparseArray2.put(R.id.tag_user_mute_visible, Boolean.FALSE);
            }
            if (z4) {
                sparseArray2.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                sparseArray2.put(R.id.tag_is_self_post, Boolean.valueOf(z5));
            } else {
                sparseArray2.put(R.id.tag_should_delete_visible, Boolean.FALSE);
            }
            return sparseArray2;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final int E3(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z2;
        TbRichTextImageInfo V;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.G0 = true;
            }
            if (tbRichText != null && tbRichText.P() != null) {
                int size = tbRichText.P().size();
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    if (tbRichText.P().get(i6) != null && tbRichText.P().get(i6).getType() == 8) {
                        i5++;
                        int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = tbRichText.P().get(i6).V().getWidth() * equipmentDensity;
                        int height = tbRichText.P().get(i6).V().getHeight() * equipmentDensity;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!z2 && tbRichText.P().get(i6).V().T()) {
                            TbRichTextData tbRichTextData = tbRichText.P().get(i6);
                            String w3 = w3(tbRichTextData);
                            arrayList.add(w3);
                            if (!TextUtils.isEmpty(w3) && tbRichTextData != null && (V = tbRichTextData.V()) != null) {
                                String O = V.O();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = O;
                                if (this.a) {
                                    i4 = 17;
                                } else {
                                    i4 = 18;
                                }
                                imageUrlData.urlType = i4;
                                imageUrlData.urlThumbType = i4;
                                imageUrlData.imageThumbUrl = imageUrlData.imageUrl;
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(w3, imageUrlData);
                                }
                            }
                            if (!this.G0) {
                                i2++;
                            }
                        } else if (tbRichText == tbRichText2 && i5 <= i3) {
                            i2--;
                        }
                    }
                }
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    @NonNull
    public final SparseArray<Object> B3(SparseArray<?> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sparseArray)) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.tag_user_mute_visible, Boolean.TRUE);
            sparseArray2.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray2.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray2.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray2.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray2.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray2.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            return sparseArray2;
        }
        return (SparseArray) invokeL.objValue;
    }

    public void e3(boolean z2) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048637, this, z2) == null) && (editText = this.W) != null && editText.getText() != null) {
            int selectionEnd = this.W.getSelectionEnd();
            SpannableStringBuilder f2 = this.V.f(this.W.getText());
            if (f2 != null) {
                boolean z3 = true;
                this.V.l(true);
                this.W.setText(f2);
                if (z2 && this.V.b() >= 0) {
                    this.W.requestFocus();
                    this.W.setSelection(this.V.b());
                } else {
                    this.W.setSelection(selectionEnd);
                }
                qsa qsaVar = this.V;
                if (qsaVar.b() < 0) {
                    z3 = false;
                }
                qsaVar.k(z3);
            }
        }
    }

    public final boolean i4(boolean z2) {
        InterceptResult invokeZ;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048655, this, z2)) == null) {
            if (this.c == null) {
                return false;
            }
            if (L3() != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 || this.c.y0() == null || this.c.y0().j() == null || this.c.y0().j().getAuthor() == null || this.c.y0().j().isUgcThreadType() || TextUtils.equals(this.c.y0().j().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                return false;
            }
            return !z2;
        }
        return invokeZ.booleanValue;
    }

    public final void o4(View view2) {
        SparseArray sparseArray;
        rba rbaVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (rbaVar = (rba) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            if (this.c.c1() && rbaVar.S() != null && rbaVar.S().equals(this.c.H0())) {
                z2 = true;
            } else {
                z2 = false;
            }
            MarkData G0 = this.c.G0(rbaVar);
            if (G0 == null) {
                return;
            }
            this.j.o();
            bw4 bw4Var = this.g;
            if (bw4Var != null) {
                bw4Var.i(G0);
                if (!z2) {
                    this.g.a();
                } else {
                    this.g.d();
                }
            }
        }
    }

    public final void q3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            Object tag = view2.getTag();
            this.j.o();
            if (tag instanceof String) {
                String str = (String) tag;
                if (!checkUpIsLogin()) {
                    return;
                }
                O3(str);
            } else if (tag instanceof SparseArray) {
                SparseArray<Object> sparseArray = (SparseArray) tag;
                if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 2);
                    g3(sparseArray);
                }
            }
        }
    }

    public final boolean C3(SparseArray<?> sparseArray, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            if (sparseArray == null) {
                return z2;
            }
            if (sparseArray.get(i2) instanceof Boolean) {
                return ((Boolean) sparseArray.get(i2)).booleanValue();
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public final void u4(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048695, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            zj9.d(this, getPageContext(), new m(this, sparseArray, i2, z2), new n(this));
        }
    }

    public final TbRichText C4(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.y0() != null && str != null && i2 >= 0) {
                ke9 y0 = this.c.y0();
                TbRichText D3 = D3(y0.g(), str, i2);
                if (D3 != null || (D3 = D3(y0.g(), str, i2)) != null) {
                }
                return D3;
            }
            return null;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public final TbRichText D3(rba rbaVar, String str, int i2) {
        InterceptResult invokeLLI;
        TbRichText e02;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, rbaVar, str, i2)) == null) {
            if (rbaVar != null && (e02 = rbaVar.e0()) != null) {
                ArrayList<TbRichTextData> P = e02.P();
                int size = P.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (P.get(i4) != null && P.get(i4).getType() == 8) {
                        i3++;
                        if (P.get(i4).V().O().equals(str)) {
                            int equipmentDensity = (int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
                            int width = P.get(i4).V().getWidth() * equipmentDensity;
                            int height = P.get(i4).V().getHeight() * equipmentDensity;
                            if (width < 80 || height < 80 || width * height < 10000) {
                                return null;
                            }
                            this.b = i4;
                            return e02;
                        } else if (i3 > i2) {
                            break;
                        }
                    }
                }
            }
            return null;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.s06
    public void a0(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048625, this, context, str, z2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f4(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                wg5 wg5Var = new wg5();
                wg5Var.a = str;
                wg5Var.b = 3;
                wg5Var.c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, wg5Var));
            }
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
        this.O = true;
    }

    @Override // com.baidu.tieba.lf9
    public boolean G(String str) {
        InterceptResult invokeL;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (!StringUtils.isNull(str) && (subPbModel = this.c) != null && subPbModel.y0() != null && this.c.y0().j() != null && this.c.y0().j().getAuthor() != null) {
                return str.equals(this.c.y0().j().getAuthor().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f4(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                return false;
            }
            this.O = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return f4(bi.getUrlDecode(str2));
            }
            return "1".equals(paramPair.get(K0));
        }
        return invokeL.booleanValue;
    }

    public void g3(SparseArray<Object> sparseArray) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
                str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            } else {
                str = "";
            }
            this.j.t0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = JavaTypesHelper.toLong(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = JavaTypesHelper.toLong(str, 0L);
            this.K = sparseArray;
            BdUniqueId bdUniqueId = this.N;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    @Nullable
    public final SparseArray<?> G3(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, view2)) == null) {
            if (!g4(view2)) {
                return null;
            }
            if (view2 instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) view2;
                this.k = tbImageView.getBdImage();
                String url = tbImageView.getUrl();
                this.l = url;
                if (this.k == null || TextUtils.isEmpty(url)) {
                    return null;
                }
                if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                    this.m = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                } else {
                    this.m = null;
                }
            } else if (view2 instanceof GifView) {
                GifView gifView = (GifView) view2;
                if (gifView.getBdImage() == null) {
                    return null;
                }
                this.k = gifView.getBdImage();
                if (!TextUtils.isEmpty(gifView.getBdImage().getUrl())) {
                    this.l = gifView.getBdImage().getUrl();
                }
                if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                    this.m = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                } else {
                    this.m = null;
                }
            } else if (view2 instanceof TbMemeImageView) {
                TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                if (tbMemeImageView.getBdImage() != null) {
                    this.k = tbMemeImageView.getBdImage();
                    if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().getUrl())) {
                        this.l = tbMemeImageView.getBdImage().getUrl();
                    }
                    if (view2.getTag(R.id.tag_rich_text_meme_info) != null && (view2.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.m = (TbRichTextMemeInfo) view2.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.m = null;
                    }
                }
            }
            if ((view2.getParent() instanceof TbRichTextView) && (((TbRichTextView) view2.getParent()).getTag() instanceof SparseArray)) {
                return (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
            }
            if (view2.getParent() != null && (view2.getParent().getParent() instanceof TbRichTextView) && (((TbRichTextView) view2.getParent().getParent()).getTag() instanceof SparseArray)) {
                return (SparseArray) ((TbRichTextView) view2.getParent().getParent()).getTag();
            }
            this.j.x0(this.H0, this.k.isGif());
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    public final boolean u3(View view2) {
        InterceptResult invokeL;
        SparseArray<?> sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048694, this, view2)) == null) {
            if (view2.getTag() instanceof SparseArray) {
                sparseArray = (SparseArray) view2.getTag();
            } else {
                sparseArray = null;
            }
            if (sparseArray == null && (sparseArray = G3(view2)) == null) {
                return true;
            }
            SparseArray<?> sparseArray2 = sparseArray;
            if (!(sparseArray2.get(R.id.tag_clip_board) instanceof rba)) {
                return true;
            }
            this.n = (rba) sparseArray2.get(R.id.tag_clip_board);
            bw4 bw4Var = this.g;
            if (bw4Var == null) {
                return true;
            }
            bw4Var.h(this.c.c1());
            if (this.g.e() && TextUtils.equals(this.n.S(), this.c.H0())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.c.y0() != null && this.c.y0().j() != null && this.c.y0().j().isBjh()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (g4(view2) && !z3) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (g4(view2) && (bdImage = this.k) != null && !bdImage.isGif()) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean C3 = C3(sparseArray2, R.id.tag_is_subpb, false);
            boolean C32 = C3(sparseArray2, R.id.tag_del_post_is_self, false);
            boolean C33 = C3(sparseArray2, R.id.tag_user_mute_visible, false);
            boolean C34 = C3(sparseArray2, R.id.tag_should_manage_visible, false);
            boolean C35 = C3(sparseArray2, R.id.tag_user_mute_visible, false);
            boolean C36 = C3(sparseArray2, R.id.tag_should_delete_visible, false);
            boolean C37 = C3(sparseArray2, R.id.tag_is_self_post, false);
            String H3 = H3(sparseArray2, R.id.tag_forbid_user_post_id, null);
            ArrayList arrayList = new ArrayList();
            if (this.p == null) {
                w45 w45Var = new w45(getBaseContext());
                this.p = w45Var;
                w45Var.q(this.q);
            }
            W2(z4, arrayList);
            c3(z5, arrayList);
            U2(z4, z5, arrayList);
            Y2(z2, z3, C3, arrayList);
            a3(sparseArray2, C33, C34, arrayList);
            b3(z3, C32, C33, C34, H3, arrayList);
            X2(sparseArray2, C32, C34, C35, C36, C37, H3, arrayList);
            V2(sparseArray2, C32, C34, C35, C36, C37, H3, arrayList);
            Z2(C34, C36, arrayList);
            zj9.a(arrayList, this.p, this.n, this.c.y0(), this.mIsLogin);
            List<s45> c2 = zj9.c(arrayList, this.n.o(), sparseArray2, this.p);
            zj9.l(c2, true);
            zj9.e(c2);
            this.p.r(zj9.g(this.n));
            this.p.m(c2, true);
            tj5 tj5Var = this.H;
            if (tj5Var != null) {
                tj5Var.A();
            }
            this.o = new u45(getPageContext(), this.p);
            this.p.p(new t(this));
            this.o.l();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M3(int i2, Intent intent) {
        yh5 yh5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i2, intent) == null) {
            this.H.b().t();
            this.H.A();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (!(serializableExtra instanceof PbEditorData)) {
                return;
            }
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            writeData.setName(pbEditorData.getName());
            writeData.setPortrait(pbEditorData.getPortrait());
            this.H.D(writeData);
            this.H.g0(pbEditorData.getVoiceModel());
            xh5 p2 = this.H.b().p(6);
            if (p2 != null && (yh5Var = p2.m) != null) {
                yh5Var.B(new lh5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.H.I();
            }
            this.j.M();
        }
    }

    public final void q4(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048687, this, i2, str) == null) {
            if (this.c.S0()) {
                showToast(str);
            } else if (BdUtilHelper.isNetOk()) {
                if (i2 == 4) {
                    zk9 zk9Var = this.j;
                    zk9Var.w0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
                } else if (!TextUtils.isEmpty(str)) {
                    zk9 zk9Var2 = this.j;
                    zk9Var2.w0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
                } else {
                    this.j.v0(R.string.no_data_text);
                }
            } else {
                this.j.v0(R.string.recommend_pb_no_net_text);
            }
        }
    }

    public final void s4(rba rbaVar, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048691, this, rbaVar, z2) != null) || f3()) {
            return;
        }
        if (rbaVar != null) {
            if (rbaVar.r() != null) {
                MetaData r2 = rbaVar.r();
                this.H.Z(r2.getUserId());
                this.H.e0(rbaVar.S());
                if (rbaVar.e0() != null) {
                    str = rbaVar.e0().toString();
                } else {
                    str = "";
                }
                this.H.q(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), rbaVar.r().getName_show(), str));
                if (!z2) {
                    this.H.Y(r2.getName_show(), r2.getPortrait());
                    SafeHandler.getInst().postDelayed(this.E0, 200L);
                }
            }
            this.j.m();
        }
        if (this.b0) {
            y3(false);
        }
    }

    public final void x4(boolean z2, SparseArray<Object> sparseArray) {
        String str;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048701, this, z2, sparseArray) == null) {
            if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
                str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            } else {
                str = "";
            }
            if (!((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                return;
            }
            String[] strArr = new String[1];
            if (z2) {
                string = getResources().getString(R.string.un_mute);
            } else {
                string = getResources().getString(R.string.obfuscated_res_0x7f0f0cf9);
            }
            strArr[0] = string;
            n45 n45Var = new n45(getPageContext().getPageActivity());
            n45Var.k(R.string.obfuscated_res_0x7f0f0efb);
            n45Var.j(strArr, new x(this, sparseArray, z2, str));
            n45Var.c(getPageContext());
            n45Var.m();
        }
    }

    public void N3(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
            }
            if (!(sparseArray.get(R.id.tag_user_mute_post_id) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
            }
            if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
                str4 = (String) sparseArray.get(R.id.tag_user_mute_msg);
            }
            String str7 = str4;
            if (!(sparseArray.get(R.id.tag_user_mute_msg) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
            }
            if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
                str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str7, 1, str5, this.N);
            userMuteAddAndDelCustomMessage.setTag(this.N);
            z4(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void O3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.y0() != null && this.c.y0().j() != null && this.c.y0().j().isBjh()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.c.M0(), str);
                ThreadData j2 = this.c.y0().j();
                if (j2.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (j2.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (j2.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                k4(format);
                return;
            }
            this.d.a(str);
        }
    }

    public void R3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            SubPbModel subPbModel = new SubPbModel(getPageContext());
            this.c = subPbModel;
            subPbModel.n1(new e(this));
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.h = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.x);
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            bw4 b2 = bw4.b(this);
            this.g = b2;
            if (b2 != null) {
                b2.j(this.w);
            }
            if (bundle != null) {
                this.c.T0(bundle);
            } else {
                this.c.U0(getIntent());
            }
            setForceInterceptStimeStat(this.c.W0());
            this.c.r1(this.v);
            if (this.c.Z0() && !this.c.f1()) {
                this.c.loadData();
            } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
                this.c.loadData();
            } else {
                this.c.g1();
            }
        }
    }

    public final void S3(boolean z2) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) {
            tj5 tj5Var = (tj5) new uj5(z2).a(getActivity());
            this.H = tj5Var;
            if (tj5Var != null) {
                tj5Var.Q(getPageContext());
                this.H.d0(this.c);
                this.H.T(this.y0);
                this.H.R(2);
                this.H.X(this.c0);
                this.H.P(this.w0);
                this.H.b().F(true);
                this.H.B(getPageContext());
                this.H.S(this.S);
            }
            zk9 zk9Var = this.j;
            if (zk9Var != null) {
                zk9Var.R(this.H);
            }
            tj5 tj5Var2 = this.H;
            if (tj5Var2 != null && (subPbModel = this.c) != null) {
                tj5Var2.J(subPbModel.w0());
                this.H.A();
            }
            tj5 tj5Var3 = this.H;
            if (tj5Var3 == null) {
                return;
            }
            tj5Var3.u().l(F3());
            this.H.u().n(F3());
            EditText i2 = this.H.u().i();
            this.W = i2;
            i2.addTextChangedListener(new w(this));
        }
    }

    public final void l3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, view2) == null) {
            this.j.o();
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            if (sparseArray != null && (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray.get(R.id.tag_del_post_id) instanceof String) && (sparseArray.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.tag_has_sub_post)).booleanValue();
                boolean G = G(TbadkCoreApplication.getCurrentAccount());
                if (G) {
                    if (!booleanValue2) {
                        u4(sparseArray, intValue, booleanValue);
                    } else {
                        this.j.Z(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), intValue, booleanValue, G);
                    }
                } else if (booleanValue && !booleanValue2) {
                    u4(sparseArray, intValue, booleanValue);
                } else {
                    this.j.Z(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), intValue, booleanValue, G);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s3(AgreeData agreeData) {
        br5 currentVisiblePageExtra;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048690, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.h0 == null) {
            this.h0 = new r85();
        }
        if (this.j0 == null) {
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.j0 = agreeMessageData;
            agreeMessageData.uniqueId = this.i0;
        }
        w05 w05Var = new w05();
        w05Var.b = 12;
        w05Var.h = 9;
        w05Var.g = 3;
        if (I3() != null) {
            w05Var.f = I3().J0();
        }
        w05Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                w05Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.h0.c(agreeData, i2, getUniqueId(), false);
                this.h0.d(agreeData, this.j0);
                if (I3() == null && I3().y0() != null) {
                    this.h0.b(this, w05Var, agreeData, I3().y0().j());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            w05Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            w05Var.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
        if (currentVisiblePageExtra != null) {
        }
        this.h0.c(agreeData, i2, getUniqueId(), false);
        this.h0.d(agreeData, this.j0);
        if (I3() == null) {
        }
    }

    public final void t3(View view2) {
        rba rbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048692, this, view2) != null) || !d3() || !checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof rba) || (rbaVar = (rba) sparseArray.get(R.id.tag_load_sub_data)) == null) {
            return;
        }
        boolean z2 = true;
        if (this.c != null) {
            TiebaStatic.log(new StatisticItem("c13700").param("tid", this.c.N0()).param("fid", this.c.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", rbaVar.S()).param("obj_source", 1).param("obj_type", 3));
        }
        s4(rbaVar, ((view2.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view2.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE) ? false : false);
    }

    public final void y3(boolean z2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        int i2;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) {
            Rect rect = new Rect();
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
                frameLayout.getWindowVisibleDisplayFrame(rect);
                if (z2) {
                    ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                    childAt.requestLayout();
                }
            }
            zk9 zk9Var = this.j;
            if (zk9Var != null && zk9Var.B() != null && (pbCommenFloorItemViewHolder = this.e0) != null && (i2 = pbCommenFloorItemViewHolder.Y) != -1) {
                int headerViewsCount = i2 + this.j.B().getHeaderViewsCount();
                if (this.e0.getView() != null) {
                    int height = this.e0.getView().getHeight();
                    int height2 = ((rect.height() - this.j.t()) - this.j.D()) - this.j.v();
                    int i3 = height - height2;
                    if (i3 > 0) {
                        this.j.B().post(new m0(this, headerViewsCount, i3));
                    } else {
                        this.j.B().post(new n0(this, headerViewsCount, height2, height));
                    }
                }
            }
        }
    }

    public final void U2(boolean z2, boolean z3, List<s45> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), list}) == null) && !z2 && !z3) {
            s45 s45Var = new s45(3, getString(R.string.obfuscated_res_0x7f0f04e1), this.p);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, this.n);
            s45Var.d.setTag(sparseArray);
            list.add(s45Var);
        }
    }

    @Nullable
    public final void Z2(boolean z2, boolean z3, List<s45> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), list}) != null) || !this.mIsLogin) {
            return;
        }
        s45 s45Var = null;
        if (!z2 && z3) {
            s45Var = new s45(13, getString(R.string.multi_delete), this.p);
        }
        if (s45Var != null) {
            list.add(s45Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V2(SparseArray<?> sparseArray, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, List<s45> list) {
        s45 s45Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048611, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), str, list}) != null) || !this.mIsLogin) {
            return;
        }
        s45 s45Var2 = null;
        if (z3 && z5 && z6) {
            SparseArray<Object> A3 = A3(sparseArray, z2, z4, z5, z6, str);
            s45Var = new s45(6, getString(R.string.obfuscated_res_0x7f0f0546), this.p);
            s45Var.d.setTag(A3);
        } else {
            if (z5) {
                SparseArray<Object> z32 = z3(sparseArray, z2);
                if (L3() == 1002 && !z2) {
                    s45Var = new s45(6, getString(R.string.report_text), this.p);
                } else {
                    s45Var = new s45(6, getString(R.string.obfuscated_res_0x7f0f0546), this.p);
                }
                s45Var.d.setTag(z32);
            }
            if (s45Var2 == null) {
                list.add(s45Var2);
                return;
            }
            return;
        }
        s45Var2 = s45Var;
        if (s45Var2 == null) {
        }
    }

    @Nullable
    public final void X2(SparseArray<?> sparseArray, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, List<s45> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048617, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), str, list}) != null) || !this.mIsLogin) {
            return;
        }
        s45 s45Var = null;
        if (z3) {
            SparseArray<Object> A3 = A3(sparseArray, z2, z4, z5, z6, str);
            s45Var = new s45(7, getString(R.string.obfuscated_res_0x7f0f0322), this.p);
            s45Var.d.setTag(A3);
        }
        if (s45Var != null) {
            list.add(s45Var);
        }
    }

    public final boolean X3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, bundle)) == null) {
            if (bundle != null) {
                this.Q = bundle.getBoolean("is_jump_from_video_tab", false);
                this.S = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                Intent intent = getIntent();
                this.Q = intent.getBooleanExtra("is_jump_from_video_tab", false);
                this.S = intent.getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.Q;
        }
        return invokeL.booleanValue;
    }

    public final void i3(View view2) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (ViewHelper.checkUpIsLogin(getActivity()) && (c2 = bka.c(view2)) != null && this.s0 != null) {
                this.s0.n(JavaTypesHelper.toLong(c2, 0L));
            }
        }
    }

    public final void j3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048657, this, view2) == null) && view2.getTag() != null && (view2.getTag() instanceof SparseArray)) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (sparseArray.get(R.id.tag_clip_board) instanceof rba) {
                ((rba) sparseArray.get(R.id.tag_clip_board)).P0();
            }
        }
    }

    public final void m3(View view2) {
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048663, this, view2) != null) || !checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        rba rbaVar = (rba) sparseArray.get(R.id.tag_clip_board);
        if (rbaVar.o() == null) {
            return;
        }
        s3(rbaVar.o());
    }

    public final void y4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, str) == null) {
            if (str == null) {
                str = "";
            }
            m45 m45Var = new m45(this.J.getPageActivity());
            m45Var.setMessage(str);
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b3e, new i0(this));
            m45Var.create(this.J).show();
        }
    }

    public final void Y2(boolean z2, boolean z3, boolean z4, List<s45> list) {
        s45 s45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), list}) == null) && !z4 && !z3) {
            if (z2) {
                s45Var = new s45(4, getString(R.string.remove_mark), this.p);
            } else {
                s45Var = new s45(4, getString(R.string.obfuscated_res_0x7f0f0c3d), this.p);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, this.n);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            s45Var.d.setTag(sparseArray);
            list.add(s45Var);
        }
    }

    public final void a3(SparseArray<?> sparseArray, boolean z2, boolean z3, List<s45> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048627, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), list}) != null) || !this.mIsLogin) {
            return;
        }
        s45 s45Var = null;
        if (!zj9.j(I3().y0()) && !z3 && z2) {
            s45Var = new s45(5, getString(R.string.obfuscated_res_0x7f0f0cfd), this.p);
            s45Var.d.setTag(B3(sparseArray));
        }
        if (s45Var != null) {
            list.add(s45Var);
        }
    }

    public final void b3(boolean z2, boolean z3, boolean z4, boolean z5, String str, List<s45> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048629, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), str, list}) != null) || !this.mIsLogin) {
            return;
        }
        s45 s45Var = null;
        if ((zj9.j(I3().y0()) || z5 || !z4) && i4(z3) && isLogin() && !z2) {
            s45Var = new s45(5, getString(R.string.report_text), this.p);
            s45Var.d.setTag(str);
        }
        if (s45Var != null) {
            list.add(s45Var);
        }
    }

    public void d4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            zk9 zk9Var = new zk9(this, this.r);
            this.j = zk9Var;
            zk9Var.j0(this.c);
            this.j.p0(getUniqueId());
            setContentView(this.j.I(), new FrameLayout.LayoutParams(-1, -1));
            this.j.n0(this.s);
            this.j.o0(this);
            this.j.k0(this.u);
            this.j.l0(this.t);
            this.j.m0(new d(this));
            this.j.f0(this.y);
            this.j.d0(this.z);
            this.j.h0(this.C0);
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.Z0() && !this.c.e1()) {
                this.j.y().setVisibility(8);
            } else {
                this.j.y().setVisibility(0);
            }
            SubPbModel subPbModel2 = this.c;
            if (subPbModel2 != null && !subPbModel2.Z0()) {
                this.j.g0(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public PageStayDurationItem getPageStayDurationItem() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            PageStayDurationItem pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (subPbModel = this.c) != null) {
                if (subPbModel.y0() != null && this.c.y0().d() != null) {
                    pageStayDurationItem.setFid(JavaTypesHelper.toLong(this.c.y0().d().getId(), 0L));
                }
                pageStayDurationItem.setTid(JavaTypesHelper.toLong(this.c.M0(), 0L));
                if (this.c.y0() != null && this.c.y0().j() != null) {
                    ThreadData j2 = this.c.y0().j();
                    pageStayDurationItem.setNid(j2.getNid());
                    if (j2.isNormalThreadType()) {
                        pageStayDurationItem.resourceType = "1";
                    } else if (j2.isVideoThreadType()) {
                        pageStayDurationItem.resourceType = "2";
                    } else {
                        pageStayDurationItem.resourceType = "3";
                    }
                }
                pageStayDurationItem.setPid(JavaTypesHelper.toLong(this.c.P(), 0L));
            }
            return pageStayDurationItem;
        }
        return (PageStayDurationItem) invokeV.objValue;
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && this.k != null && !TextUtils.isEmpty(this.l)) {
            if (this.m == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.l));
            } else {
                rl5.a aVar = new rl5.a();
                aVar.a = this.l;
                String str = "";
                if (this.m.memeInfo.pck_id.intValue() >= 0) {
                    str = "" + this.m.memeInfo.pck_id;
                }
                aVar.b = str;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
            }
            this.k = null;
            this.l = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.Y));
            this.c.cancelLoadData();
            this.c.destory();
            this.h.cancelLoadData();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            this.j.o();
            this.j.U();
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.N);
            cka ckaVar = this.s0;
            if (ckaVar != null) {
                ckaVar.l();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.X;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ag<FestivalTipView> agVar = this.G;
            if (agVar != null) {
                agVar.c();
            }
            this.J = null;
            this.L = null;
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
            SafeHandler.getInst().removeCallbacks(this.E0);
        }
    }

    public final void r3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048688, this) == null) && this.k != null && !TextUtils.isEmpty(this.l)) {
            if (this.e == null) {
                this.e = new PermissionJudgePolicy();
            }
            this.e.clearRequestPermissionList();
            this.e.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.e.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
            if (this.f == null) {
                this.f = new hi9(getPageContext());
            }
            this.f.b(this.l, this.k.getImageByte());
            this.k = null;
            this.l = null;
        }
    }

    public final void o3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
                return;
            }
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            if (sparseArray == null) {
                return;
            }
            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
            boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
            boolean booleanValue3 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            boolean z2 = false;
            if (sparseArray.get(R.id.tag_is_self_post) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.tag_is_self_post)).booleanValue();
            }
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(R.id.tag_from, 1);
                    sparseArray.put(R.id.tag_check_mute_from, 2);
                    g3(sparseArray);
                    return;
                }
                if (z2) {
                    sparseArray.put(R.id.tag_check_mute_from, 2);
                }
                sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                this.j.b0(view2);
            } else if (booleanValue2) {
                this.j.Z(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue(), false);
            }
        }
    }

    public final void p4(rba rbaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048685, this, rbaVar) != null) || rbaVar == null) {
            return;
        }
        String S = rbaVar.S();
        if (StringUtils.isNull(S) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            return;
        }
        String string = SharedPrefHelper.getInstance().getString("bubble_link", "");
        if (StringUtils.isNull(string)) {
            return;
        }
        TiebaStatic.log("c10051");
        String jumpUrl = rbaVar.n0().getJumpUrl();
        int packageId = rbaVar.n0().getPackageId();
        int propsId = rbaVar.n0().getPropsId();
        if (!StringUtils.isNull(jumpUrl)) {
            BrowserHelper.startWebActivity(getPageContext().getPageActivity(), xca.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
        } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
        } else {
            BrowserHelper.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + S, true, true, true);
        }
    }

    public final String w3(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048698, this, tbRichTextData)) == null) {
            if (tbRichTextData == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(150);
            TbRichTextImageInfo V = tbRichTextData.V();
            if (V == null) {
                return null;
            }
            if (!StringUtils.isNull(V.N())) {
                return V.N();
            }
            if (V.getHeight() * V.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (V.getHeight() * V.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (V.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (V.getHeight() * sqrt)));
            } else {
                double width = V.getWidth() / V.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(bi.getUrlEncode(V.getSrc()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, bundle) == null) {
            V3(bundle);
            X3(bundle);
            Y3(bundle);
            W3(bundle);
            U3(bundle);
            if (getIntent() != null) {
                this.g0 = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
                if (this.Q) {
                    this.v0 = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
                }
            }
            super.onCreate(bundle);
            this.J = getPageContext();
            this.M = true;
            qsa qsaVar = new qsa();
            this.V = qsaVar;
            qsaVar.h(R.color.cp_cont_h_alpha85);
            this.V.j(R.color.CAM_X0101);
            Z3();
            P3();
            R3(bundle);
            d4();
            if (this.Q && this.j.u() != null) {
                showLoadingView(this.j.u(), true, UtilHelper.getDimenPixelSize(R.dimen.tbds300));
            }
            if (this.Q) {
                ((SubPbView) this.j.I()).setAnimTime(0);
                ((SubPbView) this.j.I()).setIsFromVideoTab(true);
            } else if (this.R) {
                setActivityBgTransparent();
                ((SubPbView) this.j.I()).setAnimTime(0);
                ((SubPbView) this.j.I()).setIsFromFoldComment(true);
            } else {
                ((SubPbView) this.j.I()).setAnimTime(300);
                ((SubPbView) this.j.I()).setIsFromVideoTab(false);
            }
            ((SubPbView) this.j.I()).h();
            S3(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.j.k(this.g0);
            e95 e95Var = new e95();
            this.L = e95Var;
            e95Var.a = 1000L;
            registerListener(this.B0);
            registerListener(this.z0);
            registerListener(this.A0);
            registerListener(this.x0);
            this.N = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.N;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.N;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.X = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new c(this));
            xk9 xk9Var = new xk9(this);
            this.d = xk9Var;
            xk9Var.b(getUniqueId());
            this.Z = new ij9(this);
            this.s0 = new cka(getPageContext(), getUniqueId());
            if (this.t0 == null) {
                if (this.f1148T) {
                    this.t0 = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.t0 = new TiePlusEventController(this, TiePlusStat.Locate.PB_COMMENT);
                }
                this.t0.k(this.u0);
            }
            lf5.b(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            this.I = true;
            super.onPause();
            TiePlusEventController tiePlusEventController = this.t0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            jk9.a();
            et4.w().E();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            MessageManager.getInstance().unRegisterListener(this.I0);
            this.j.V();
            if (this.Q || this.R) {
                B4(false);
            }
        }
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            m45 m45Var = new m45(getPageContext().getPageActivity());
            m45Var.setMessage(getResources().getString(R.string.mute_is_super_member_function));
            m45Var.setPositiveButton(R.string.open_now, new j0(this));
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new k0(this));
            m45Var.create(this.J).show();
        }
    }

    public void x3(ForumManageModel.b bVar, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048700, this, bVar, z2) != null) || bVar == null) {
            return;
        }
        int i2 = 0;
        this.j.s(0, bVar.a, bVar.b, z2);
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                if (this.j.B() instanceof BdTypeListView) {
                    List<ym> data = ((BdTypeListView) this.j.B()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        while (i2 < data.size() && (!(data.get(i2) instanceof rba) || !bVar.g.equals(((rba) data.get(i2)).S()))) {
                            i2++;
                        }
                        if (i2 < data.size()) {
                            data.remove(i2);
                        }
                        this.j.T();
                    }
                }
            } else if (i3 == 2) {
                this.c.u0(bVar.g);
                zk9 zk9Var = this.j;
                ke9 y0 = this.c.y0();
                int Q0 = this.c.Q0();
                if (this.c.P0() != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zk9Var.A0(y0, Q0, z3, false);
                if (this.c.d1()) {
                    this.c.o1(false);
                    this.j.l();
                    this.c.loadData();
                }
            }
            bc9 bc9Var = new bc9();
            bc9Var.b(bVar);
            bc9Var.c(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, bc9Var));
        }
    }

    @NonNull
    public final SparseArray<Object> z3(SparseArray<?> sparseArray, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048706, this, sparseArray, z2)) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            sparseArray2.put(R.id.tag_user_mute_visible, Boolean.FALSE);
            sparseArray2.put(R.id.tag_should_delete_visible, Boolean.TRUE);
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
            return sparseArray2;
        }
        return (SparseArray) invokeLZ.objValue;
    }

    public final void z4(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048707, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.j.t0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            m45 m45Var = new m45(this.J.getPageActivity());
            if (!bi.isEmpty(str)) {
                m45Var.setMessage(str);
            } else {
                m45Var.setMessage(this.J.getResources().getString(R.string.block_mute_message_alert, str3));
            }
            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04c1, new f0(this, userMuteAddAndDelCustomMessage));
            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new h0(this));
            m45Var.create(this.J).show();
        }
    }
}
