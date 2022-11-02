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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.GameLaunchMessage;
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
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
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
import com.baidu.tieba.ao;
import com.baidu.tieba.ar4;
import com.baidu.tieba.aw8;
import com.baidu.tieba.b38;
import com.baidu.tieba.bw8;
import com.baidu.tieba.d85;
import com.baidu.tieba.dq8;
import com.baidu.tieba.dw8;
import com.baidu.tieba.e48;
import com.baidu.tieba.e65;
import com.baidu.tieba.e85;
import com.baidu.tieba.f18;
import com.baidu.tieba.f38;
import com.baidu.tieba.f95;
import com.baidu.tieba.g05;
import com.baidu.tieba.gy4;
import com.baidu.tieba.h39;
import com.baidu.tieba.hn;
import com.baidu.tieba.i45;
import com.baidu.tieba.iv4;
import com.baidu.tieba.jm4;
import com.baidu.tieba.jp4;
import com.baidu.tieba.jw7;
import com.baidu.tieba.k38;
import com.baidu.tieba.k45;
import com.baidu.tieba.k85;
import com.baidu.tieba.km4;
import com.baidu.tieba.kv4;
import com.baidu.tieba.ky4;
import com.baidu.tieba.l28;
import com.baidu.tieba.l85;
import com.baidu.tieba.m18;
import com.baidu.tieba.m38;
import com.baidu.tieba.ng;
import com.baidu.tieba.nm5;
import com.baidu.tieba.ns6;
import com.baidu.tieba.og;
import com.baidu.tieba.p65;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pd5;
import com.baidu.tieba.pv4;
import com.baidu.tieba.q38;
import com.baidu.tieba.q55;
import com.baidu.tieba.q65;
import com.baidu.tieba.q9;
import com.baidu.tieba.qm5;
import com.baidu.tieba.qo8;
import com.baidu.tieba.qy4;
import com.baidu.tieba.qy7;
import com.baidu.tieba.r9;
import com.baidu.tieba.rp4;
import com.baidu.tieba.rv4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tv4;
import com.baidu.tieba.tx7;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uy4;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.w25;
import com.baidu.tieba.wd5;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi;
import com.baidu.tieba.wn;
import com.baidu.tieba.xi;
import com.baidu.tieba.xr4;
import com.baidu.tieba.yd5;
import com.baidu.tieba.zd5;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes5.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.j, qm5, BdListView.p, qy7<NewSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String G0 = "tbgametype";
    public transient /* synthetic */ FieldHolder $fh;
    public ng<TextView> A;
    public CustomMessageListener A0;
    public ng<GifView> B;
    public final uy4.g B0;
    public ng<View> C;
    public boolean C0;
    public ng<ImageView> D;
    public final kv4.c D0;
    public ng<LinearLayout> E;
    public CustomMessageListener E0;
    public ng<RelativeLayout> F;
    public CustomMessageListener F0;
    public k85 G;
    public boolean H;
    public r9 I;
    public Object J;
    public qy4 K;
    public boolean L;
    public BdUniqueId M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public boolean S;
    public boolean T;
    public h39 U;
    public EditText V;
    public ReplyPrivacyCheckController W;
    public jw7<tx7> X;
    public l28 Y;
    public ns6 Z;
    public boolean a;
    public PostWriteCallBackData a0;
    public int b;
    public boolean b0;
    public SubPbModel c;
    public e85 c0;
    public k38 d;
    public String d0;
    public PermissionJudgePolicy e;
    public PbCommenFloorItemViewHolder e0;
    public m18 f;
    public int f0;
    public jp4 g;
    public boolean g0;
    public ForumManageModel h;
    public gy4 h0;
    public VoiceManager i;
    public BdUniqueId i0;
    public m38 j;
    public qo8 j0;
    public hn k;
    public String l;
    public TbRichTextMemeInfo m;
    public PostData n;
    public rv4 o;
    public tv4 p;
    public tv4.e q;
    public boolean q0;
    public View.OnClickListener r;
    public bw8 r0;
    public AbsListView.OnScrollListener s;
    @Nullable
    public TiePlusEventController s0;
    public View.OnLongClickListener t;
    @NonNull
    public TiePlusEventController.f t0;
    public TbRichTextView.y u;
    public BdUniqueId u0;
    public SubPbModel.b v;
    public d85 v0;
    public jp4.a w;
    public CustomMessageListener w0;
    public q9 x;
    public NewWriteModel.d x0;
    public s0 y;
    public CustomMessageListener y0;
    public s0 z;
    public CustomMessageListener z0;

    /* loaded from: classes5.dex */
    public interface s0 {
        void a(Object obj);
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

    @Override // com.baidu.tieba.qm5
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qm5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.qm5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.qm5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tieba.qm5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.qm5
    public ng<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return null;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qm5
    public void e1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.vd5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? "a007" : (String) invokeV.objValue;
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z2) == null) {
        }
    }

    @Override // com.baidu.tieba.qm5
    public ng<TiebaPlusRecommendCard> w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return null;
        }
        return (ng) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class e implements SubPbModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tx7 a;
            public final /* synthetic */ e b;

            public a(e eVar, tx7 tx7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, tx7Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = tx7Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.q0 = false;
                    this.b.a.o4(this.a.i(), false);
                }
            }
        }

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

        @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.b
        public void a(boolean z, int i, String str, tx7 tx7Var) {
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, tx7Var}) != null) || this.a.j == null) {
                return;
            }
            this.a.j.e0();
            if (this.a.P && this.a.j.u() != null) {
                NewSubPbActivity newSubPbActivity = this.a;
                newSubPbActivity.hideLoadingView(newSubPbActivity.j.u());
            }
            if (z) {
                this.a.j.L();
                if (tx7Var != null) {
                    if (tx7Var.i() != null || this.a.c != null) {
                        tx7Var.i().a1(this.a.c.z0());
                    }
                    if (this.a.j != null) {
                        NewSubPbActivity newSubPbActivity2 = this.a;
                        if (tx7Var.l() != null && tx7Var.l().isBjh()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        newSubPbActivity2.O3(z2);
                        if (this.a.G != null && this.a.G.b() != null) {
                            this.a.G.b().w(TbadkCoreApplication.getInst().getSkinType());
                        }
                        m38 m38Var = this.a.j;
                        int E0 = this.a.c.E0();
                        if (this.a.c.D0() != null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        m38Var.A0(tx7Var, E0, z3, this.a.L);
                        if (this.a.L) {
                            this.a.j.B().setSelectionFromTop(this.a.j.B().getHeaderViewsCount() + 1, -xi.g(this.a, R.dimen.tbds18));
                            this.a.d3();
                            this.a.L = false;
                        }
                    }
                    if (this.a.G != null) {
                        this.a.G.H(tx7Var.a());
                        this.a.G.d0(tx7Var.l());
                        if (this.a.getIntent() != null && this.a.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && this.a.q0) {
                            zg.a().postDelayed(new a(this, tx7Var), 200L);
                        }
                    }
                    if (this.a.X == null) {
                        this.a.X = new jw7();
                    }
                    this.a.X.b(tx7Var);
                    this.a.X.c(0);
                    NewSubPbActivity newSubPbActivity3 = this.a;
                    newSubPbActivity3.W.setLikeUserData(newSubPbActivity3.c.l0());
                }
                String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
                if (!TextUtils.isEmpty(stringExtra) && !this.a.T) {
                    this.a.T = true;
                    NewSubPbActivity newSubPbActivity4 = this.a;
                    newSubPbActivity4.r4(newSubPbActivity4.j.G(), this.a.G, stringExtra);
                    return;
                }
                return;
            }
            this.a.m4(i, str);
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes5.dex */
        public class a implements iv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(n0 n0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.iv4.e
            public void onClick(iv4 iv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                    iv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements iv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n0 a;

            public b(n0 n0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = n0Var;
            }

            @Override // com.baidu.tieba.iv4.e
            public void onClick(iv4 iv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                    iv4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public n0(NewSubPbActivity newSubPbActivity) {
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w25 w25Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, w25Var, writeData, antiData}) == null) {
                if (z && this.a.G != null && this.a.G.b() != null) {
                    this.a.G.b().o();
                    if (this.a.c.K0()) {
                        e48.p("c10367", null, this.a.c.B());
                    }
                }
                if (z) {
                    if (writeData != null) {
                        g05.b(writeData.getContent(), "4");
                    }
                    this.a.U.n(null);
                    this.a.U.i(null);
                    this.a.U.k(false);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        k45.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    this.a.U.i(postWriteCallBackData.getSensitiveWords());
                    this.a.U.n(postWriteCallBackData.getErrorString());
                    if (!ListUtils.isEmpty(this.a.U.a())) {
                        this.a.a0 = postWriteCallBackData;
                        if (this.a.G.y()) {
                            this.a.G.w(this.a.a0);
                        }
                        this.a.a3(true);
                    } else {
                        return;
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (wi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f048a), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    iv4 iv4Var = new iv4(this.a.getActivity());
                    if (wi.isEmpty(postWriteCallBackData.getErrorString())) {
                        iv4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d39));
                    } else {
                        iv4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new a(this));
                    iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d3b, new b(this));
                    iv4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && (replyPrivacyCheckController = this.a.W) != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
                this.a.j.e0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
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

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                this.a.G.G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements og<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public b(NewSubPbActivity newSubPbActivity) {
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

    /* loaded from: classes5.dex */
    public class b0 implements og<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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

    /* loaded from: classes5.dex */
    public class c implements PbFakeFloorModel.b {
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

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.j.s0(postData);
                this.a.j.o0(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 extends wd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity b;

        @Override // com.baidu.tieba.wd5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
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
            this.b = newSubPbActivity;
        }

        @Override // com.baidu.tieba.wd5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return zd5.b().c();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ k85 b;
        public final /* synthetic */ NewSubPbActivity c;

        public d(NewSubPbActivity newSubPbActivity, View view2, k85 k85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, view2, k85Var};
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
            this.b = k85Var;
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

    /* loaded from: classes5.dex */
    public class d0 implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ NewSubPbActivity b;

        public d0(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                this.b.j.t0();
                MessageManager.getInstance().sendMessage(this.a);
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements jp4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public f(NewSubPbActivity newSubPbActivity) {
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

        @Override // com.baidu.tieba.jp4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.g != null) {
                        this.a.g.h(z2);
                    }
                    MarkData f = this.a.g.f();
                    jw7 jw7Var = new jw7();
                    jw7Var.c(2);
                    if (z2) {
                        jw7Var.b(f);
                        if (this.a.g != null) {
                            if (f != null) {
                                this.a.c.c1(true);
                                this.a.c.d1(this.a.c.B());
                                this.a.showToast(R.string.obfuscated_res_0x7f0f00d3);
                            } else {
                                NewSubPbActivity newSubPbActivity = this.a;
                                newSubPbActivity.showToast(newSubPbActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d2));
                            }
                        }
                    } else {
                        jw7Var.b(null);
                        this.a.c.c1(false);
                        this.a.c.d1(null);
                        NewSubPbActivity newSubPbActivity2 = this.a;
                        newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f101f));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, jw7Var));
                    return;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f151d));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public f0(NewSubPbActivity newSubPbActivity) {
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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements s0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

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

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.s0
        public void a(Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String str5 = "";
                if (this.a.c.m0() == null || this.a.c.m0().l() == null || this.a.c.m0().l().getAuthor() == null) {
                    str = "";
                } else {
                    str = String.valueOf(this.a.c.m0().l().getAuthor().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.c.m0().d().getId(), this.a.c.m0().d().getName(), this.a.c.m0().l().getId(), str, str2, str4, str3, str5)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements d85 {
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

        @Override // com.baidu.tieba.d85
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.U.d()) {
                    NewSubPbActivity newSubPbActivity = this.a;
                    newSubPbActivity.showToast(newSubPbActivity.U.c());
                    if (this.a.G.y()) {
                        this.a.G.w(this.a.a0);
                    }
                    this.a.a3(true);
                    return true;
                }
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (newSubPbActivity2.W != null && newSubPbActivity2.c != null && this.a.c.k0() != null && !this.a.F(TbadkCoreApplication.getCurrentAccount())) {
                    NewSubPbActivity newSubPbActivity3 = this.a;
                    if (!newSubPbActivity3.W.checkPrivacyBeforeSend(newSubPbActivity3.c.k0().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements s0 {
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

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.s0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!this.a.h.S() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int e = wg.e(String.valueOf(objArr[1]), 0);
                        boolean b = wg.b(String.valueOf(objArr[2]), false);
                        int e2 = wg.e(String.valueOf(objArr[3]), 0);
                        if (this.a.c != null && this.a.c.m0() != null && this.a.c.m0().d() != null && this.a.c.m0().l() != null) {
                            if (objArr.length > 4) {
                                this.a.h.U(String.valueOf(objArr[4]));
                            }
                            this.a.h.V(this.a.c.m0().d().getId(), this.a.c.m0().d().getName(), this.a.c.m0().l().getId(), valueOf, e2, e, b, this.a.c.m0().l().getBaijiahaoData(), false);
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

    /* loaded from: classes5.dex */
    public class h0 implements iv4.e {
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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    iv4Var.dismiss();
                    ((TbPageContext) this.a.I).showToast(R.string.obfuscated_res_0x7f0f072f);
                    return;
                }
                TiebaStatic.log("c10025");
                iv4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.I.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends q9 {
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

        @Override // com.baidu.tieba.q9
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
                    this.a.t3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                    return;
                }
                this.a.j.s(this.a.h.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements iv4.e {
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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ NewSubPbActivity d;

        public j(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, int i, boolean z) {
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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                if (iv4Var != null) {
                    iv4Var.dismiss();
                }
                if (this.d.z != null) {
                    this.d.z.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f092089), Integer.valueOf(this.b), Boolean.valueOf(this.c), this.a.get(R.id.obfuscated_res_0x7f09208b)});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(NewSubPbActivity newSubPbActivity, int i) {
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
            if (this.a.c.m0() != null && this.a.c.m0().i() != null && this.a.c.m0().i().s() != null && currentAccount.equals(this.a.c.m0().i().s().getUserId()) && this.a.c.m0().i().s().getPendantData() != null) {
                this.a.c.m0().i().s().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.a.c.m0().i().s().getPendantData().setPropsId(userPendantData.getPropsId());
                m38 m38Var = this.a.j;
                tx7 m0 = this.a.c.m0();
                PostData i = this.a.c.m0().i();
                boolean e = this.a.c.m0().e();
                boolean f = this.a.c.m0().f();
                int E0 = this.a.c.E0();
                if (this.a.c.D0() != null) {
                    z = true;
                } else {
                    z = false;
                }
                m38Var.r(m0, i, e, f, E0, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements e85 {
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

        @Override // com.baidu.tieba.e85
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.q0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ NewSubPbActivity c;

        public k0(NewSubPbActivity newSubPbActivity, int i, int i2) {
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

    /* loaded from: classes5.dex */
    public class l implements iv4.e {
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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ NewSubPbActivity d;

        public l0(NewSubPbActivity newSubPbActivity, int i, int i2, int i3) {
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

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public m(NewSubPbActivity newSubPbActivity) {
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
            boolean z;
            int i;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.j != null) {
                boolean z2 = true;
                boolean z3 = false;
                if (view2 == this.a.j.A()) {
                    this.a.j.o();
                    String F3 = this.a.F3(view2, R.id.obfuscated_res_0x7f0920dd);
                    String F32 = this.a.F3(view2, R.id.obfuscated_res_0x7f0920e5);
                    String F33 = this.a.F3(view2, R.id.obfuscated_res_0x7f0920e7);
                    if (!TextUtils.isEmpty(F33)) {
                        if (!this.a.checkUpIsLogin()) {
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{F33});
                    } else if (!TextUtils.isEmpty(F3)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), F3, F32, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                    }
                } else if (view2 == this.a.j.G()) {
                    if (!this.a.Z2() || !this.a.checkUpIsLogin()) {
                        return;
                    }
                    this.a.p4();
                    if (this.a.c != null && this.a.c.m0() != null && this.a.c.m0().l() != null && this.a.c.m0().l().getAuthor() != null) {
                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.c.A0()).param("fid", this.a.c.m0().l().getFid()).param("obj_locate", 5).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                } else if (view2 == this.a.j.E()) {
                    if (!this.a.checkUpIsLogin()) {
                        return;
                    }
                    this.a.j.D0();
                    this.a.j.m();
                    if (this.a.G != null) {
                        this.a.G.g0();
                    }
                } else if (view2 == this.a.j.F()) {
                    if (!this.a.checkUpIsLogin()) {
                        return;
                    }
                    this.a.j.D0();
                    this.a.j.m();
                    if (this.a.G != null) {
                        this.a.G.i0();
                    }
                } else if (view2.getId() != R.id.obfuscated_res_0x7f09183e && view2.getId() != R.id.obfuscated_res_0x7f09189c) {
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
                            if (view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                this.a.e0 = (PbCommenFloorItemViewHolder) view2.getTag();
                                if (!this.a.Z2() || !ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                    return;
                                }
                                if (this.a.N) {
                                    this.a.N = false;
                                    return;
                                }
                                NewSubPbActivity newSubPbActivity = this.a;
                                if (newSubPbActivity.W != null && newSubPbActivity.c != null && this.a.c.k0() != null && !this.a.F(TbadkCoreApplication.getCurrentAccount())) {
                                    NewSubPbActivity newSubPbActivity2 = this.a;
                                    if (!newSubPbActivity2.W.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.c.k0().replyPrivateFlag)) {
                                        return;
                                    }
                                }
                                SparseArray sparseArray = (SparseArray) view2.getTag(R.id.obfuscated_res_0x7f09209a);
                                if (sparseArray == null) {
                                    return;
                                }
                                this.a.n4(sparseArray, ((view2.getTag(R.id.obfuscated_res_0x7f0920d4) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f0920d4) == Boolean.TRUE) ? false : false);
                                if (sparseArray.get(R.id.obfuscated_res_0x7f092087) instanceof PostData) {
                                    PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092087);
                                    if (this.a.c != null) {
                                        str = this.a.c.A0();
                                    }
                                    q38.a(str, TbadkCoreApplication.getCurrentAccount(), postData.M());
                                }
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091a83 || view2.getId() == R.id.obfuscated_res_0x7f09183a) {
                                this.a.p3(view2);
                            } else if (view2 == this.a.j.w()) {
                                if (!this.a.Z2() || this.a.G == null || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                                    return;
                                }
                                this.a.G.g0();
                                this.a.r3();
                            } else if (view2.getId() != R.id.obfuscated_res_0x7f09079d && view2.getId() != R.id.obfuscated_res_0x7f090a29) {
                                if ((view2.getId() == R.id.obfuscated_res_0x7f09186c || view2.getId() == R.id.obfuscated_res_0x7f091835) && ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                    String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13bc);
                                    String q = ky4.k().q("tail_link", "");
                                    if (!StringUtils.isNull(q)) {
                                        TiebaStatic.log("c10056");
                                        rp4.s(view2.getContext(), string, q, true, true, true);
                                    }
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091c61 && (view2.getTag() instanceof SparseArray)) {
                                    Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f092087);
                                    if (obj instanceof PostData) {
                                        PostData postData2 = (PostData) obj;
                                        if (postData2.getType() != PostData.P0 && !TextUtils.isEmpty(postData2.v()) && ar4.c().g()) {
                                            this.a.l4(postData2);
                                        }
                                    }
                                }
                            } else {
                                SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                if (sparseArray2 != null && (sparseArray2.get(R.id.obfuscated_res_0x7f0920a4) instanceof PostData)) {
                                    PostData postData3 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f0920a4);
                                    View view3 = (View) sparseArray2.get(R.id.obfuscated_res_0x7f0920a6);
                                    if (postData3 != null && view3 != null) {
                                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09079e);
                                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f09079f);
                                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a29);
                                        if (postData3.s0()) {
                                            postData3.S0(false);
                                            f38.e(postData3);
                                        } else {
                                            if (this.a.c != null) {
                                                z3 = f38.c(this.a.c.m0(), postData3);
                                            }
                                            if (z3) {
                                                postData3.S0(true);
                                            }
                                        }
                                        if (postData3.s0()) {
                                            i = R.color.CAM_X0201;
                                        } else {
                                            i = R.color.transparent;
                                        }
                                        SkinManager.setBackgroundColor(findViewById, i);
                                        boolean s0 = postData3.s0();
                                        int i4 = R.color.CAM_X0304;
                                        if (s0) {
                                            i2 = R.color.CAM_X0304;
                                        } else {
                                            i2 = R.color.CAM_X0107;
                                        }
                                        SkinManager.setViewTextColor(eMTextView, i2);
                                        if (postData3.s0()) {
                                            i3 = R.drawable.obfuscated_res_0x7f08099c;
                                        } else {
                                            i3 = R.drawable.obfuscated_res_0x7f08099b;
                                        }
                                        if (!postData3.s0()) {
                                            i4 = R.color.CAM_X0107;
                                        }
                                        WebPManager.setPureDrawable(imageView, i3, i4, null);
                                    }
                                }
                            }
                        } else if (!this.a.checkUpIsLogin()) {
                        } else {
                            if (this.a.G.B()) {
                                this.a.G.z();
                            } else {
                                this.a.G.l0(null, null);
                            }
                        }
                    } else if (this.a.N) {
                        this.a.N = false;
                    } else {
                        if (this.a.c.m0() != null && this.a.c.m0().l() != null) {
                            z = ThreadCardUtils.isUgcThreadType(this.a.c.m0().l().getBaijiahaoData());
                        } else {
                            z = false;
                        }
                        if (z) {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.getActivity()).createNormalCfg(this.a.c.A0(), null, "");
                            if (!StringUtils.isNull(this.a.c.getFromForumId())) {
                                createNormalCfg.setForumId(this.a.c.getFromForumId());
                            }
                            if (this.a.c.m0() != null && this.a.c.m0().l() != null) {
                                createNormalCfg.setBjhData(this.a.c.m0().l().getBaijiahaoData());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } else if (this.a.c != null && this.a.c.m0() != null) {
                            if (this.a.f4(this.a.c.m0().l())) {
                                VideoItemData videoItemData = new VideoItemData();
                                videoItemData.buildWithThreadData(this.a.c.m0().l());
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.a.getActivity(), Arrays.asList(videoItemData), 0, null, "frs")));
                                return;
                            }
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.a.getActivity()).createNormalCfg(this.a.c.A0(), this.a.c.B(), "");
                            if (!StringUtils.isNull(this.a.c.getFromForumId())) {
                                createNormalCfg2.setForumId(this.a.c.getFromForumId());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
                        }
                    }
                } else {
                    this.a.t.onLongClick(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(NewSubPbActivity newSubPbActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.c != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.c.A0())) {
                if (this.a.U != null) {
                    this.a.U.n(null);
                    this.a.U.i(null);
                    this.a.U.k(false);
                }
                if (this.a.G != null) {
                    this.a.G.r();
                    this.a.G.I();
                }
                this.a.c.K();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements AbsListView.OnScrollListener {
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
                this.a.G.z();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.a.j != null && this.a.j.S()) {
                    return false;
                }
                return this.a.q3(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.M) {
                this.a.j.K();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.K.d(this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f0b69));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f0b65);
                    }
                    this.a.u4(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (wi.isEmpty(errorString2)) {
                        errorString2 = this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f0b66);
                    }
                    this.a.K.c(errorString2);
                } else {
                    this.a.s4();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements TbRichTextView.y {
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

        /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
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
                    if ((view2.getTag(R.id.obfuscated_res_0x7f0920c4) instanceof TbRichTextMemeInfo) && ((TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920c4)).memeInfo != null && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920c4);
                        this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, ((TbImageView) view2).w())));
                        return;
                    }
                    tx7 m0 = this.a.c.m0();
                    TbRichText y4 = this.a.y4(str, i);
                    if (y4 != null && y4.B() != null) {
                        tbRichTextData = y4.B().get(this.a.b);
                    } else {
                        tbRichTextData = null;
                    }
                    if (tbRichTextData == null) {
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                    if (!tbRichTextData.F().H()) {
                        String s3 = this.a.s3(tbRichTextData);
                        arrayList.add(s3);
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = str;
                        if (this.a.a) {
                            i2 = 17;
                        } else {
                            i2 = 18;
                        }
                        imageUrlData.urlType = i2;
                        concurrentHashMap.put(s3, imageUrlData);
                        if (m0 != null) {
                            if (m0.d() != null) {
                                str7 = m0.d().getName();
                                str8 = m0.d().getId();
                            } else {
                                str7 = null;
                                str8 = null;
                            }
                            if (m0.l() != null) {
                                str9 = m0.l().getId();
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
                        if (this.a.c.D0() != null) {
                            concurrentHashMap = this.a.c.D0();
                            z4 = this.a.c.H0();
                            arrayList = this.a.c.C0();
                        }
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(ListUtils.getItem(arrayList, 0));
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList2);
                        builder.C(str7);
                        builder.B(str8);
                        builder.R(str9);
                        builder.F(z4);
                        builder.M(arrayList.get(0));
                        builder.I(true);
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(false);
                        builder.Q(this.a.G3());
                        builder.O(String.valueOf(y4.getPostId()));
                        builder.z(String.valueOf(y4.getPostId()));
                        builder.D(this.a.c.getFromForumId());
                        this.a.sendMessage(new CustomMessage(2010000, builder.x(this.a.getPageContext().getPageActivity())));
                        return;
                    }
                    this.a.C0 = false;
                    String str10 = "";
                    TbRichText X = m0.i().X();
                    int size = arrayList.size();
                    int A3 = this.a.A3(X, y4, i, i, arrayList, concurrentHashMap);
                    int size2 = arrayList.size();
                    if (size != size2) {
                        str10 = arrayList.get(size2 - 1);
                    }
                    if (m0 != null) {
                        if (m0.d() != null) {
                            str5 = m0.d().getName();
                            str3 = m0.d().getId();
                        } else {
                            str5 = null;
                            str3 = null;
                        }
                        if (m0.l() != null) {
                            str6 = m0.l().getId();
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
                    if (this.a.c.D0() != null) {
                        concurrentHashMap = this.a.c.D0();
                        z3 = this.a.c.H0();
                        arrayList = this.a.c.C0();
                        A3 += this.a.c.w0();
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(ListUtils.getItem(arrayList, A3));
                    ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                    builder2.A(arrayList3);
                    builder2.C(str4);
                    builder2.B(str3);
                    builder2.R(str2);
                    builder2.F(z3);
                    builder2.M(str10);
                    builder2.I(true);
                    builder2.y(concurrentHashMap);
                    builder2.K(true);
                    builder2.N(false);
                    builder2.J(false);
                    builder2.Q(this.a.G3());
                    builder2.O(String.valueOf(y4.getPostId()));
                    builder2.z(String.valueOf(y4.getPostId()));
                    builder2.D(this.a.c.getFromForumId());
                    this.a.sendMessage(new CustomMessage(2010000, builder2.x(this.a.getPageContext().getPageActivity())));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(NewSubPbActivity newSubPbActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.M) {
                this.a.j.K();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.K.d(this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f14f6));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (wi.isEmpty(muteMessage)) {
                    muteMessage = this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f14f5);
                }
                this.a.K.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements tv4.e {
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

        @Override // com.baidu.tieba.tv4.e
        public void n0(tv4 tv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, tv4Var, i, view2) == null) {
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                if (i != -4) {
                    if (i != -3) {
                        if (i == -2) {
                            this.a.j4(view2);
                            return;
                        } else if (i == -1) {
                            this.a.h4(view2);
                            return;
                        } else if (i != 13) {
                            switch (i) {
                                case 1:
                                    this.a.j3();
                                    return;
                                case 2:
                                    this.a.n3();
                                    return;
                                case 3:
                                    this.a.f3(view2);
                                    return;
                                case 4:
                                    this.a.l3(view2);
                                    return;
                                case 5:
                                    this.a.m3(view2);
                                    return;
                                case 6:
                                    this.a.h3(view2);
                                    return;
                                case 7:
                                    this.a.k3(view2);
                                    return;
                                case 8:
                                    this.a.i3(view2);
                                    return;
                                case 9:
                                    this.a.e3(view2);
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.a.g3();
                            return;
                        }
                    }
                    this.a.i4(view2, R.id.obfuscated_res_0x7f091820);
                    return;
                }
                this.a.i4(view2, R.id.obfuscated_res_0x7f091821);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof dw8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.M) {
                dw8 dw8Var = (dw8) customResponsedMessage.getData();
                this.a.j.K();
                SparseArray<Object> sparseArray = (SparseArray) this.a.J;
                DataRes dataRes = dw8Var.a;
                int i = 0;
                if (dw8Var.c == 0 && dataRes != null) {
                    if (wg.e(dataRes.is_mute, 0) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f0920e4, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f0920de, dataRes.mute_confirm);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920e4, Boolean.FALSE);
                    z = false;
                }
                sparseArray.put(R.id.obfuscated_res_0x7f0920a8, Boolean.TRUE);
                if (sparseArray.get(R.id.obfuscated_res_0x7f09209a) instanceof Integer) {
                    i = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09209a)).intValue();
                }
                if (i != 0) {
                    if (i == 1) {
                        this.a.j.a0(sparseArray, z);
                        return;
                    }
                    return;
                }
                this.a.t4(z, sparseArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements kv4.c {
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

        @Override // com.baidu.tieba.kv4.c
        public void a(kv4 kv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, kv4Var, i, view2) == null) {
                kv4Var.e();
                if (this.a.k != null && !TextUtils.isEmpty(this.a.l)) {
                    if (i == 0) {
                        if (this.a.m == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.l));
                        } else {
                            f95.a aVar = new f95.a();
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
                            newSubPbActivity.f = new m18(newSubPbActivity.getPageContext());
                        }
                        this.a.f.b(this.a.l, this.a.k.n());
                    }
                    this.a.k = null;
                    this.a.l = null;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements uy4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public r0(NewSubPbActivity newSubPbActivity) {
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

        @Override // com.baidu.tieba.uy4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.c != null) {
                this.a.c.T0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements ns6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        @Override // com.baidu.tieba.ns6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.ns6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

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

        /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
        @Override // com.baidu.tieba.ns6.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                NewSubPbActivity newSubPbActivity = this.a;
                if (newSubPbActivity.W != null && newSubPbActivity.c != null && this.a.c.k0() != null && !this.a.F(TbadkCoreApplication.getCurrentAccount())) {
                    NewSubPbActivity newSubPbActivity2 = this.a;
                    if (!newSubPbActivity2.W.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.c.k0().replyPrivateFlag)) {
                        return;
                    }
                }
                if (this.a.c != null && this.a.c.m0() != null && this.a.c.m0().i() != null) {
                    PostData i = this.a.c.m0().i();
                    if (i.X() != null && i.s() != null) {
                        str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f103a), i.s().getName_show(), i.X().toString());
                        this.a.G.b().A(new e65(45, 27, str));
                        if (!this.a.G.y()) {
                            this.a.G.w(null);
                            return;
                        }
                        this.a.j.D0();
                        this.a.j.m();
                        if (this.a.G != null) {
                            this.a.G.k0();
                            return;
                        }
                        return;
                    }
                }
                str = null;
                this.a.G.b().A(new e65(45, 27, str));
                if (!this.a.G.y()) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements TextWatcher {
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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || this.a.U == null) {
                return;
            }
            if (!this.a.U.e()) {
                this.a.a3(false);
            }
            this.a.U.l(false);
        }
    }

    /* loaded from: classes5.dex */
    public class u implements kv4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ NewSubPbActivity d;

        public u(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
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

        @Override // com.baidu.tieba.kv4.c
        public void a(kv4 kv4Var, int i, View view2) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, kv4Var, i, view2) == null) {
                if (i == 0) {
                    String str5 = "";
                    if (!(this.a.get(R.id.obfuscated_res_0x7f0920e1) instanceof String)) {
                        str = "";
                    } else {
                        str = (String) this.a.get(R.id.obfuscated_res_0x7f0920e1);
                    }
                    if (!(this.a.get(R.id.obfuscated_res_0x7f0920e3) instanceof String)) {
                        str2 = "";
                    } else {
                        str2 = (String) this.a.get(R.id.obfuscated_res_0x7f0920e3);
                    }
                    if (!(this.a.get(R.id.obfuscated_res_0x7f0920e2) instanceof String)) {
                        str3 = "";
                    } else {
                        str3 = (String) this.a.get(R.id.obfuscated_res_0x7f0920e2);
                    }
                    if (!(this.a.get(R.id.obfuscated_res_0x7f0920de) instanceof String)) {
                        str4 = "";
                    } else {
                        str4 = (String) this.a.get(R.id.obfuscated_res_0x7f0920de);
                    }
                    if (this.a.get(R.id.obfuscated_res_0x7f0920df) instanceof String) {
                        str5 = (String) this.a.get(R.id.obfuscated_res_0x7f0920df);
                    }
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, str4, this.d.M);
                    userMuteAddAndDelCustomMessage.setTag(this.d.M);
                    this.d.v4(this.b, userMuteAddAndDelCustomMessage, str4, str, str5);
                }
                kv4Var.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements TiePlusEventController.f {
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

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.f
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.N = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(NewSubPbActivity newSubPbActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof nm5.a)) {
                nm5.a aVar = (nm5.a) customResponsedMessage.getData();
                nm5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements og<GifView> {
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

        public x(NewSubPbActivity newSubPbActivity) {
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.b0();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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

    /* loaded from: classes5.dex */
    public class y implements og<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public y(NewSubPbActivity newSubPbActivity) {
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
                    if (ar4.c().g()) {
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
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = ar4.c().g();
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

    /* loaded from: classes5.dex */
    public class z implements og<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public View e(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) ? view2 : (View) invokeL.objValue;
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
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ View c(View view2) {
            View view3 = view2;
            h(view3);
            return view3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.s0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
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
        this.H = false;
        this.L = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = 0;
        this.S = false;
        this.c0 = new k(this);
        this.f0 = 0;
        this.g0 = false;
        this.i0 = BdUniqueId.gen();
        this.q0 = true;
        this.t0 = new v(this);
        this.v0 = new g0(this);
        this.w0 = new m0(this, 2921481);
        this.x0 = new n0(this);
        this.y0 = new o0(this, 2001427);
        this.z0 = new p0(this, 2001428);
        this.A0 = new q0(this, 2001426);
        this.B0 = new r0(this);
        this.C0 = false;
        this.D0 = new r(this);
        this.E0 = new w(this, 2001332);
        this.F0 = new j0(this, 2016485);
    }

    public void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            m38 m38Var = new m38(this, this.r);
            this.j = m38Var;
            m38Var.j0(this.c);
            this.j.p0(getUniqueId());
            setContentView(this.j.I(), new FrameLayout.LayoutParams(-1, -1));
            this.j.n0(this.s);
            this.j.o0(this);
            this.j.k0(this.u);
            this.j.l0(this.t);
            this.j.m0(new b(this));
            this.j.f0(this.y);
            this.j.d0(this.z);
            this.j.h0(this.B0);
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.L0() && !this.c.Q0()) {
                this.j.y().setVisibility(8);
            } else {
                this.j.y().setVisibility(0);
            }
            SubPbModel subPbModel2 = this.c;
            if (subPbModel2 != null && !subPbModel2.L0()) {
                this.j.g0(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public yd5 getPageStayDurationItem() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            yd5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (subPbModel = this.c) != null) {
                if (subPbModel.m0() != null && this.c.m0().d() != null) {
                    pageStayDurationItem.t(wg.g(this.c.m0().d().getId(), 0L));
                }
                pageStayDurationItem.C(wg.g(this.c.A0(), 0L));
                if (this.c.m0() != null && this.c.m0().l() != null) {
                    ThreadData l2 = this.c.m0().l();
                    pageStayDurationItem.u(l2.getNid());
                    if (l2.isNormalThreadType()) {
                        pageStayDurationItem.t = "1";
                    } else if (l2.isVideoThreadType()) {
                        pageStayDurationItem.t = "2";
                    } else {
                        pageStayDurationItem.t = "3";
                    }
                }
                pageStayDurationItem.w(wg.g(this.c.B(), 0L));
            }
            return pageStayDurationItem;
        }
        return (yd5) invokeV.objValue;
    }

    public final void p4() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            Intent intent = getIntent();
            boolean z2 = false;
            if (intent != null) {
                z2 = intent.getBooleanExtra("key_is_from_dynamic", false);
            }
            if (b3()) {
                return;
            }
            if (z2) {
                if (this.W != null && (subPbModel = this.c) != null && subPbModel.k0() != null && !F(TbadkCoreApplication.getCurrentAccount()) && !this.W.checkPrivacyBeforeInvokeEditor(this.c.k0().replyPrivateFlag)) {
                    return;
                }
                if (this.G.y()) {
                    this.G.w(null);
                    return;
                }
                this.j.D0();
                this.j.m();
                k85 k85Var = this.G;
                if (k85Var != null) {
                    k85Var.k0();
                    return;
                }
                return;
            }
            if (this.Z == null) {
                ns6 ns6Var = new ns6(getPageContext());
                this.Z = ns6Var;
                ns6Var.i(new s(this));
            }
            SubPbModel subPbModel2 = this.c;
            if (subPbModel2 != null && subPbModel2.m0() != null && this.c.m0().d() != null) {
                this.Z.g(this.c.m0().d().getId(), wg.g(this.c.A0(), 0L));
            }
        }
    }

    public final String F3(View view2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, view2, i2)) == null) {
            if (view2.getTag(i2) instanceof String) {
                return (String) view2.getTag(i2);
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.qm5
    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.N = true;
        }
    }

    public final void S2(boolean z2, List<pv4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048605, this, z2, list) == null) && z2) {
            list.add(new pv4(1, getString(R.string.obfuscated_res_0x7f0f10dc), this.p));
        }
    }

    public final void Y2(boolean z2, List<pv4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048622, this, z2, list) == null) && z2) {
            list.add(new pv4(2, getString(R.string.obfuscated_res_0x7f0f10dd), this.p));
        }
    }

    public final void i4(View view2, int i2) {
        View view3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048653, this, view2, i2) == null) && (view3 = (View) ((SparseArray) view2.getTag()).get(i2)) != null) {
            view3.performClick();
        }
    }

    public final void n4(SparseArray<Object> sparseArray, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048663, this, sparseArray, z2) != null) || sparseArray == null) {
            return;
        }
        if (sparseArray.get(R.id.obfuscated_res_0x7f092087) instanceof PostData) {
            o4((PostData) sparseArray.get(R.id.obfuscated_res_0x7f092087), z2);
        } else {
            o4(null, z2);
        }
    }

    public final boolean Q3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, bundle)) == null) {
            if (bundle != null) {
                this.Q = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            } else {
                this.Q = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            }
            return this.Q;
        }
        return invokeL.booleanValue;
    }

    public final boolean R3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, bundle)) == null) {
            if (bundle != null) {
                this.O = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            } else {
                this.O = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            }
            return this.O;
        }
        return invokeL.booleanValue;
    }

    public final boolean S3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, bundle)) == null) {
            if (bundle != null) {
                this.S = bundle.getBoolean("is_jump_from_video_middle");
            } else {
                this.S = getIntent().getBooleanExtra("is_jump_from_video_middle", false);
            }
            return this.S;
        }
        return invokeL.booleanValue;
    }

    public final int U3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, bundle)) == null) {
            if (bundle != null) {
                this.R = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                this.R = getIntent().getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.R;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, voiceModel)) == null) {
            View z2 = this.j.z();
            if (z2 != null && (findViewWithTag = z2.findViewWithTag(voiceModel)) != null) {
                return (VoiceManager.i) findViewWithTag;
            }
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public boolean c4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, view2)) == null) {
            if (!(view2 instanceof TbImageView) && !(view2 instanceof TbMemeImageView) && !(view2 instanceof GifView)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean f4(@Nullable ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, threadData)) == null) {
            if (threadData != null && threadData.isVideoThreadType() && threadData.getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void g4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void h4(View view2) {
        View view3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048651, this, view2) == null) && (view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091822)) != null) {
            AgreeView agreeView = (AgreeView) view3;
            if (agreeView.getImgAgree() != null) {
                agreeView.getImgAgree().performClick();
            }
        }
    }

    public final void j4(View view2) {
        View view3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048655, this, view2) == null) && (view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091822)) != null) {
            AgreeView agreeView = (AgreeView) view3;
            if (agreeView.getImgDisagree() != null) {
                agreeView.getImgDisagree().performClick();
            }
        }
    }

    public final void l3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
            this.j.o();
            if (!checkUpIsLogin()) {
                return;
            }
            k4(view2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.j.X(i2);
            if (this.P && !UtilHelper.isFlyMeOs()) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048671, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            this.b0 = z2;
            u3(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.tieba.v9
    public void onPreLoad(ao aoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, aoVar) == null) {
            PreLoadImageHelper.load(aoVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(aoVar, getUniqueId(), this);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null && (subPbModel = this.c) != null) {
                subPbModel.Z0(bundle);
            }
        }
    }

    public void x4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048701, this, z2) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.u0);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final String D3(SparseArray<?> sparseArray, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, sparseArray, i2, str)) == null) {
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
        if (interceptable == null || interceptable.invokeIIL(1048666, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25035) {
                I3(i3, intent);
            }
            k85 k85Var = this.G;
            if (k85Var != null) {
                k85Var.D(i2, i3, intent);
            }
        }
    }

    public final void r4(View view2, k85 k85Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048685, this, view2, k85Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new d(this, view2, k85Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0d36), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    public final int A3(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z2;
        TbRichTextImageInfo F;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.C0 = true;
            }
            if (tbRichText != null && tbRichText.B() != null) {
                int size = tbRichText.B().size();
                int i5 = -1;
                for (int i6 = 0; i6 < size; i6++) {
                    if (tbRichText.B().get(i6) != null && tbRichText.B().get(i6).getType() == 8) {
                        i5++;
                        int i7 = (int) xi.i(TbadkCoreApplication.getInst());
                        int width = tbRichText.B().get(i6).F().getWidth() * i7;
                        int height = tbRichText.B().get(i6).F().getHeight() * i7;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!z2 && tbRichText.B().get(i6).F().H()) {
                            TbRichTextData tbRichTextData = tbRichText.B().get(i6);
                            String s3 = s3(tbRichTextData);
                            arrayList.add(s3);
                            if (!TextUtils.isEmpty(s3) && tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                String B = F.B();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = B;
                                if (this.a) {
                                    i4 = 17;
                                } else {
                                    i4 = 18;
                                }
                                imageUrlData.urlType = i4;
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(s3, imageUrlData);
                                }
                            }
                            if (!this.C0) {
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

    public final SparseArray<Object> w3(SparseArray<?> sparseArray, boolean z2, boolean z3, boolean z4, boolean z5, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048698, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), str})) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.obfuscated_res_0x7f0920d0, Boolean.TRUE);
            sparseArray2.put(R.id.obfuscated_res_0x7f0920a7, sparseArray.get(R.id.obfuscated_res_0x7f0920a7));
            sparseArray2.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
            sparseArray2.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
            sparseArray2.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
            sparseArray2.put(R.id.obfuscated_res_0x7f092097, str);
            if (!b38.j(E3().m0()) && z3) {
                sparseArray2.put(R.id.obfuscated_res_0x7f0920e4, Boolean.TRUE);
                sparseArray2.put(R.id.obfuscated_res_0x7f09209e, sparseArray.get(R.id.obfuscated_res_0x7f09209e));
                sparseArray2.put(R.id.obfuscated_res_0x7f0920e0, sparseArray.get(R.id.obfuscated_res_0x7f0920e0));
                sparseArray2.put(R.id.obfuscated_res_0x7f0920e1, sparseArray.get(R.id.obfuscated_res_0x7f0920e1));
                sparseArray2.put(R.id.obfuscated_res_0x7f0920df, sparseArray.get(R.id.obfuscated_res_0x7f0920df));
                sparseArray2.put(R.id.obfuscated_res_0x7f0920e2, sparseArray.get(R.id.obfuscated_res_0x7f0920e2));
                sparseArray2.put(R.id.obfuscated_res_0x7f0920e3, sparseArray.get(R.id.obfuscated_res_0x7f0920e3));
            } else {
                sparseArray2.put(R.id.obfuscated_res_0x7f0920e4, Boolean.FALSE);
            }
            if (z4) {
                sparseArray2.put(R.id.obfuscated_res_0x7f0920ce, Boolean.TRUE);
                sparseArray2.put(R.id.obfuscated_res_0x7f09208a, Boolean.valueOf(z2));
                sparseArray2.put(R.id.obfuscated_res_0x7f092089, sparseArray.get(R.id.obfuscated_res_0x7f092089));
                sparseArray2.put(R.id.obfuscated_res_0x7f09208b, sparseArray.get(R.id.obfuscated_res_0x7f09208b));
                sparseArray2.put(R.id.obfuscated_res_0x7f09209b, sparseArray.get(R.id.obfuscated_res_0x7f09209b));
                sparseArray2.put(R.id.obfuscated_res_0x7f09209f, Boolean.valueOf(z5));
            } else {
                sparseArray2.put(R.id.obfuscated_res_0x7f0920ce, Boolean.FALSE);
            }
            return sparseArray2;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public String B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!wi.isEmpty(this.d0)) {
                return this.d0;
            }
            String string = getResources().getString(f18.g());
            this.d0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public SubPbModel E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (SubPbModel) invokeV.objValue;
    }

    public final ThreadData G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.m0() != null) {
                return this.c.m0().l();
            }
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public int H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.E0();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qm5
    public ng<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ng<RelativeLayout> ngVar = new ng<>(new b0(this), 10, 0);
            this.F = ngVar;
            return ngVar;
        }
        return (ng) invokeV.objValue;
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.r = new m(this);
        }
    }

    @Override // com.baidu.tieba.qm5
    public ng<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.D == null) {
                this.D = new ng<>(new y(this), 8, 0);
            }
            return this.D;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qm5
    public ng<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.C == null) {
                this.C = new ng<>(new z(this), 8, 0);
            }
            return this.C;
        }
        return (ng) invokeV.objValue;
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.u = new p(this);
        }
    }

    @Override // com.baidu.tieba.qy7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return 0;
            }
            return subPbModel.E0();
        }
        return invokeV.intValue;
    }

    public void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            registerListener(this.F0);
            M3();
            Y3();
            X3();
            P3();
            W3();
        }
    }

    @Override // com.baidu.tieba.qm5
    public ng<TextView> W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.A == null) {
                this.A = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (ng) invokeV.objValue;
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.q = new q(this);
        }
    }

    public final void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.t = new o(this);
        }
    }

    public final void Y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.s = new n(this);
        }
    }

    public boolean a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.L0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return false;
            }
            return AntiHelper.d(getPageContext(), subPbModel.k0());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (this.O && !this.g0 && !this.P && !this.Q) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            } else {
                super.closeAnimation();
            }
        }
    }

    public boolean d4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (this.O && !this.g0 && !this.P && !this.Q) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.j.E0(true);
        }
    }

    @Override // com.baidu.tieba.qm5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            m38 m38Var = this.j;
            if (m38Var != null) {
                return m38Var.B();
            }
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || wi.isEmpty(subPbModel.A0())) {
                return 0L;
            }
            return wg.g(this.c.A0(), 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.vd5
    public wd5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return new c0(this);
        }
        return (wd5) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            if (this.j.B0() && xi.F()) {
                this.c.loadData();
            } else {
                this.j.e0();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            this.G.F();
        }
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", m38.q0);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.i;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qm5
    public ng<GifView> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            if (this.B == null) {
                this.B = new ng<>(new x(this), 20, 0);
            }
            return this.B;
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qy7
    public l28 y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.Y;
        }
        return (l28) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qm5
    public ng<LinearLayout> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            if (this.E == null) {
                this.E = new ng<>(new a0(this), 15, 0);
            }
            return this.E;
        }
        return (ng) invokeV.objValue;
    }

    @Nullable
    public final SparseArray<?> C3(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            if (!c4(view2)) {
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
                if (view2.getTag(R.id.obfuscated_res_0x7f0920c4) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920c4) instanceof TbRichTextImageInfo)) {
                    this.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920c4);
                } else {
                    this.m = null;
                }
            } else if (view2 instanceof GifView) {
                GifView gifView = (GifView) view2;
                if (gifView.getBdImage() == null) {
                    return null;
                }
                this.k = gifView.getBdImage();
                if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                    this.l = gifView.getBdImage().q();
                }
                if (view2.getTag(R.id.obfuscated_res_0x7f0920c4) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920c4) instanceof TbRichTextImageInfo)) {
                    this.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920c4);
                } else {
                    this.m = null;
                }
            } else if (view2 instanceof TbMemeImageView) {
                TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                if (tbMemeImageView.getBdImage() != null) {
                    this.k = tbMemeImageView.getBdImage();
                    if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                        this.l = tbMemeImageView.getBdImage().q();
                    }
                    if (view2.getTag(R.id.obfuscated_res_0x7f0920c4) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920c4) instanceof TbRichTextImageInfo)) {
                        this.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920c4);
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
            this.j.x0(this.D0, this.k.t());
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qy7
    public boolean F(String str) {
        InterceptResult invokeL;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (!StringUtils.isNull(str) && (subPbModel = this.c) != null && subPbModel.m0() != null && this.c.m0().l() != null && this.c.m0().l().getAuthor() != null) {
                return str.equals(this.c.m0().l().getAuthor().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b4(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                return false;
            }
            this.N = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return b4(wi.getUrlDecode(str2));
            }
            String str3 = paramPair.get(G0);
            if (TextUtils.isEmpty(str3) || !str3.equals("1")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c3(SparseArray<Object> sparseArray) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920e0) instanceof String) {
                str = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920e0);
            } else {
                str = "";
            }
            this.j.t0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = wg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = wg.g(str, 0L);
            this.J = sparseArray;
            BdUniqueId bdUniqueId = this.M;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void I3(int i2, Intent intent) {
        q65 q65Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, intent) == null) {
            this.G.b().q();
            this.G.z();
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
            this.G.C(writeData);
            this.G.e0(pbEditorData.getVoiceModel());
            p65 n2 = this.G.b().n(6);
            if (n2 != null && (q65Var = n2.m) != null) {
                q65Var.B(new e65(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.G.G();
            }
            this.j.M();
        }
    }

    public final void m4(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048661, this, i2, str) == null) {
            if (this.c.G0()) {
                showToast(str);
            } else if (xi.F()) {
                if (i2 == 4) {
                    m38 m38Var = this.j;
                    m38Var.w0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
                } else if (!TextUtils.isEmpty(str)) {
                    m38 m38Var2 = this.j;
                    m38Var2.w0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
                } else {
                    this.j.v0(R.string.obfuscated_res_0x7f0f0c9b);
                }
            } else {
                this.j.v0(R.string.obfuscated_res_0x7f0f0ff9);
            }
        }
    }

    public final void t4(boolean z2, SparseArray<Object> sparseArray) {
        String str;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048691, this, z2, sparseArray) == null) {
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920e0) instanceof String) {
                str = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920e0);
            } else {
                str = "";
            }
            if (!((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920e4)).booleanValue()) {
                return;
            }
            String[] strArr = new String[1];
            if (z2) {
                string = getResources().getString(R.string.obfuscated_res_0x7f0f14f4);
            } else {
                string = getResources().getString(R.string.obfuscated_res_0x7f0f0b64);
            }
            strArr[0] = string;
            kv4 kv4Var = new kv4(getPageContext().getPageActivity());
            kv4Var.k(R.string.obfuscated_res_0x7f0f0d49);
            kv4Var.j(strArr, new u(this, sparseArray, z2, str));
            kv4Var.c(getPageContext());
            kv4Var.m();
        }
    }

    public void J3(boolean z2, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920e1) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920e1);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920e3) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920e3);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920e2) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920e2);
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920de) instanceof String) {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920de);
            }
            String str7 = str4;
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920de) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920de);
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920df) instanceof String) {
                str6 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920df);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str7, 1, str5, this.M);
            userMuteAddAndDelCustomMessage.setTag(this.M);
            v4(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void K3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.m0() != null && this.c.m0().l() != null && this.c.m0().l().isBjh()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.c.A0(), str);
                ThreadData l2 = this.c.m0().l();
                if (l2.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (l2.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (l2.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                g4(format);
                return;
            }
            this.d.a(str);
        }
    }

    public void N3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            SubPbModel subPbModel = new SubPbModel(getPageContext());
            this.c = subPbModel;
            subPbModel.a1(new c(this));
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.h = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.x);
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            jp4 b2 = jp4.b(this);
            this.g = b2;
            if (b2 != null) {
                b2.j(this.w);
            }
            if (bundle != null) {
                this.c.initWithBundle(bundle);
            } else {
                this.c.initWithIntent(getIntent());
            }
            setForceInterceptStimeStat(this.c.I0());
            this.c.e1(this.v);
            if (this.c.L0() && !this.c.R0()) {
                this.c.loadData();
            } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
                this.c.loadData();
            } else {
                this.c.S0();
            }
        }
    }

    public final void O3(boolean z2) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z2) == null) {
            k85 k85Var = (k85) new l85(z2).a(getActivity());
            this.G = k85Var;
            if (k85Var != null) {
                k85Var.O(getPageContext());
                this.G.b0(this.c);
                this.G.R(this.x0);
                this.G.P(2);
                this.G.V(this.c0);
                this.G.N(this.v0);
                this.G.b().C(true);
                this.G.A(getPageContext());
                this.G.Q(this.R);
            }
            m38 m38Var = this.j;
            if (m38Var != null) {
                m38Var.R(this.G);
            }
            k85 k85Var2 = this.G;
            if (k85Var2 != null && (subPbModel = this.c) != null) {
                k85Var2.H(subPbModel.k0());
                this.G.z();
            }
            k85 k85Var3 = this.G;
            if (k85Var3 == null) {
                return;
            }
            k85Var3.u().l(B3());
            this.G.u().m(B3());
            EditText i2 = this.G.u().i();
            this.V = i2;
            i2.addTextChangedListener(new t(this));
        }
    }

    public final void h3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, view2) == null) {
            this.j.o();
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            if (sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f09208b) instanceof Integer) && (sparseArray.get(R.id.obfuscated_res_0x7f092089) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f0920a7) instanceof Integer) && (sparseArray.get(R.id.obfuscated_res_0x7f09208a) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09208a)).booleanValue();
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f0920a7)).intValue();
                boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09209b)).booleanValue();
                boolean F = F(TbadkCoreApplication.getCurrentAccount());
                if (F) {
                    if (!booleanValue2) {
                        q4(sparseArray, intValue, booleanValue);
                    } else {
                        this.j.Z(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09208b)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f092089), intValue, booleanValue, F);
                    }
                } else if (booleanValue && !booleanValue2) {
                    q4(sparseArray, intValue, booleanValue);
                } else {
                    this.j.Z(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09208b)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f092089), intValue, booleanValue, F);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o3(AgreeData agreeData) {
        pd5 currentVisiblePageExtra;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048664, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.h0 == null) {
            this.h0 = new gy4();
        }
        if (this.j0 == null) {
            qo8 qo8Var = new qo8();
            this.j0 = qo8Var;
            qo8Var.a = this.i0;
        }
        xr4 xr4Var = new xr4();
        xr4Var.b = 12;
        xr4Var.h = 9;
        xr4Var.g = 3;
        if (E3() != null) {
            xr4Var.f = E3().x0();
        }
        xr4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                xr4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.h0.c(agreeData, i2, getUniqueId(), false);
                this.h0.d(agreeData, this.j0);
                if (E3() == null && E3().m0() != null) {
                    this.h0.b(this, xr4Var, agreeData, E3().m0().l());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            xr4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            xr4Var.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
        if (currentVisiblePageExtra != null) {
        }
        this.h0.c(agreeData, i2, getUniqueId(), false);
        this.h0.d(agreeData, this.j0);
        if (E3() == null) {
        }
    }

    public final void p3(View view2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048680, this, view2) != null) || !Z2() || !checkUpIsLogin() || !(view2.getTag() instanceof SparseArray)) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920a4) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f0920a4)) == null) {
            return;
        }
        boolean z2 = true;
        if (this.c != null) {
            TiebaStatic.log(new StatisticItem("c13700").param("tid", this.c.B0()).param("fid", this.c.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.M()).param("obj_source", 1).param("obj_type", 3));
        }
        o4(postData, ((view2.getTag(R.id.obfuscated_res_0x7f0920d4) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f0920d4) == Boolean.TRUE) ? false : false);
    }

    public final void u3(boolean z2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        int i2;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z2) == null) {
            Rect rect = new Rect();
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
                frameLayout.getWindowVisibleDisplayFrame(rect);
                if (z2) {
                    ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                    childAt.requestLayout();
                }
            }
            m38 m38Var = this.j;
            if (m38Var != null && m38Var.B() != null && (pbCommenFloorItemViewHolder = this.e0) != null && (i2 = pbCommenFloorItemViewHolder.e0) != -1) {
                int headerViewsCount = i2 + this.j.B().getHeaderViewsCount();
                if (this.e0.getView() != null) {
                    int height = this.e0.getView().getHeight();
                    int height2 = ((rect.height() - this.j.t()) - this.j.D()) - this.j.v();
                    int i3 = height - height2;
                    if (i3 > 0) {
                        this.j.B().post(new k0(this, headerViewsCount, i3));
                    } else {
                        this.j.B().post(new l0(this, headerViewsCount, height2, height));
                    }
                }
            }
        }
    }

    public void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.v = new e(this);
            this.w = new f(this);
            this.y = new g(this);
            this.z = new h(this);
            this.x = new i(this);
        }
    }

    @Override // com.baidu.tieba.qy7
    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.m0() != null && this.c.m0().l() != null) {
                return this.c.m0().l().getForum_name();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final boolean Z2() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.W != null && (subPbModel = this.c) != null && subPbModel.m0() != null && this.c.m0().a() != null && !this.W.checkPrivacyBeforeInvokeEditor(this.c.m0().a().replyPrivateFlag)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.G.z();
            } else if (!StringUtils.isNull(this.c.y0())) {
                if (this.j.B0() && xi.F()) {
                    this.j.i0();
                } else {
                    this.j.e0();
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            k85 k85Var = this.G;
            if (k85Var != null && k85Var.b() != null && this.G.b().u()) {
                this.G.b().q();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            this.H = false;
            super.onResume();
            TiePlusEventController tiePlusEventController = this.s0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            w4();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.E0);
            this.j.W();
            if (this.P || this.Q) {
                x4(true);
            }
        }
    }

    @Override // com.baidu.tieba.qy7
    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.m0() != null && this.c.m0().l() != null) {
                return !this.c.m0().l().isMutiForumThread();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void w4() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048699, this) == null) && (subPbModel = this.c) != null && !wi.isEmpty(subPbModel.A0())) {
            km4.w().P(jm4.Z, wg.g(this.c.A0(), 0L));
        }
    }

    public final void Q2(boolean z2, boolean z3, List<pv4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), list}) == null) && !z2 && !z3) {
            pv4 pv4Var = new pv4(3, getString(R.string.obfuscated_res_0x7f0f045b), this.p);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f092087, this.n);
            pv4Var.d.setTag(sparseArray);
            list.add(pv4Var);
        }
    }

    @Nullable
    public final void V2(boolean z2, boolean z3, List<pv4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048614, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), list}) != null) || !this.mIsLogin) {
            return;
        }
        pv4 pv4Var = null;
        if (!z2 && z3) {
            pv4Var = new pv4(13, getString(R.string.obfuscated_res_0x7f0f0b58), this.p);
        }
        if (pv4Var != null) {
            list.add(pv4Var);
        }
    }

    @Override // com.baidu.tieba.qm5
    public void R(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048602, this, context, str, z2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (b4(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                q55 q55Var = new q55();
                q55Var.a = str;
                q55Var.b = 3;
                q55Var.c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, q55Var));
            }
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
        this.N = true;
    }

    public final TbRichText z3(PostData postData, String str, int i2) {
        InterceptResult invokeLLI;
        TbRichText X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048706, this, postData, str, i2)) == null) {
            if (postData != null && (X = postData.X()) != null) {
                ArrayList<TbRichTextData> B = X.B();
                int size = B.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (B.get(i4) != null && B.get(i4).getType() == 8) {
                        i3++;
                        if (B.get(i4).F().B().equals(str)) {
                            int i5 = (int) xi.i(TbadkCoreApplication.getInst());
                            int width = B.get(i4).F().getWidth() * i5;
                            int height = B.get(i4).F().getHeight() * i5;
                            if (width < 80 || height < 80 || width * height < 10000) {
                                return null;
                            }
                            this.b = i4;
                            return X;
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R2(SparseArray<?> sparseArray, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, List<pv4> list) {
        pv4 pv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048603, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), str, list}) != null) || !this.mIsLogin) {
            return;
        }
        pv4 pv4Var2 = null;
        if (z3 && z5 && z6) {
            SparseArray<Object> w3 = w3(sparseArray, z2, z4, z5, z6, str);
            pv4Var = new pv4(6, getString(R.string.obfuscated_res_0x7f0f04ba), this.p);
            pv4Var.d.setTag(w3);
        } else {
            if (z5) {
                SparseArray<Object> v3 = v3(sparseArray, z2);
                if (H3() == 1002 && !z2) {
                    pv4Var = new pv4(6, getString(R.string.obfuscated_res_0x7f0f1044), this.p);
                } else {
                    pv4Var = new pv4(6, getString(R.string.obfuscated_res_0x7f0f04ba), this.p);
                }
                pv4Var.d.setTag(v3);
            }
            if (pv4Var2 == null) {
                list.add(pv4Var2);
                return;
            }
            return;
        }
        pv4Var2 = pv4Var;
        if (pv4Var2 == null) {
        }
    }

    @Nullable
    public final void T2(SparseArray<?> sparseArray, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, List<pv4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048608, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), str, list}) != null) || !this.mIsLogin) {
            return;
        }
        pv4 pv4Var = null;
        if (z3) {
            SparseArray<Object> w3 = w3(sparseArray, z2, z4, z5, z6, str);
            pv4Var = new pv4(7, getString(R.string.obfuscated_res_0x7f0f02e9), this.p);
            pv4Var.d.setTag(w3);
        }
        if (pv4Var != null) {
            list.add(pv4Var);
        }
    }

    public final boolean T3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, bundle)) == null) {
            if (bundle != null) {
                this.P = bundle.getBoolean("is_jump_from_video_tab", false);
                this.R = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                Intent intent = getIntent();
                this.P = intent.getBooleanExtra("is_jump_from_video_tab", false);
                this.R = intent.getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.P;
        }
        return invokeL.booleanValue;
    }

    public final void e3(View view2) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c80);
            } else if (ViewHelper.checkUpIsLogin(getActivity()) && (c2 = aw8.c(view2)) != null && this.r0 != null) {
                this.r0.n(wg.g(c2, 0L));
            }
        }
    }

    public final void f3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048641, this, view2) == null) && view2.getTag() != null && (view2.getTag() instanceof SparseArray)) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (sparseArray.get(R.id.obfuscated_res_0x7f092087) instanceof PostData) {
                ((PostData) sparseArray.get(R.id.obfuscated_res_0x7f092087)).E0();
            }
        }
    }

    public final void i3(View view2) {
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048652, this, view2) != null) || !checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092087);
        if (postData.q() == null) {
            return;
        }
        o3(postData.q());
    }

    public final void u4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, str) == null) {
            if (str == null) {
                str = "";
            }
            iv4 iv4Var = new iv4(this.I.getPageActivity());
            iv4Var.setMessage(str);
            iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09d2, new f0(this));
            iv4Var.create(this.I).show();
        }
    }

    public final void U2(boolean z2, boolean z3, boolean z4, List<pv4> list) {
        pv4 pv4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), list}) == null) && !z4 && !z3) {
            if (z2) {
                pv4Var = new pv4(4, getString(R.string.obfuscated_res_0x7f0f101f), this.p);
            } else {
                pv4Var = new pv4(4, getString(R.string.obfuscated_res_0x7f0f0ac4), this.p);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f092087, this.n);
            sparseArray.put(R.id.obfuscated_res_0x7f0920a0, Boolean.FALSE);
            pv4Var.d.setTag(sparseArray);
            list.add(pv4Var);
        }
    }

    public final void W2(SparseArray<?> sparseArray, boolean z2, boolean z3, List<pv4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048617, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), list}) != null) || !this.mIsLogin) {
            return;
        }
        pv4 pv4Var = null;
        if (!b38.j(E3().m0()) && !z3 && z2) {
            pv4Var = new pv4(5, getString(R.string.obfuscated_res_0x7f0f0b68), this.p);
            pv4Var.d.setTag(x3(sparseArray));
        }
        if (pv4Var != null) {
            list.add(pv4Var);
        }
    }

    public final void X2(boolean z2, boolean z3, boolean z4, boolean z5, String str, List<pv4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), str, list}) != null) || !this.mIsLogin) {
            return;
        }
        pv4 pv4Var = null;
        if ((b38.j(E3().m0()) || z5 || !z4) && e4(z3) && isLogin() && !z2) {
            pv4Var = new pv4(5, getString(R.string.obfuscated_res_0x7f0f1044), this.p);
            pv4Var.d.setTag(str);
        }
        if (pv4Var != null) {
            list.add(pv4Var);
        }
    }

    public void a3(boolean z2) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) && (editText = this.V) != null && editText.getText() != null) {
            int selectionEnd = this.V.getSelectionEnd();
            SpannableStringBuilder f2 = this.U.f(this.V.getText());
            if (f2 != null) {
                boolean z3 = true;
                this.U.l(true);
                this.V.setText(f2);
                if (z2 && this.U.b() >= 0) {
                    this.V.requestFocus();
                    this.V.setSelection(this.U.b());
                } else {
                    this.V.setSelection(selectionEnd);
                }
                h39 h39Var = this.U;
                if (h39Var.b() < 0) {
                    z3 = false;
                }
                h39Var.k(z3);
            }
        }
    }

    public final boolean e4(boolean z2) {
        InterceptResult invokeZ;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048639, this, z2)) == null) {
            if (this.c == null) {
                return false;
            }
            if (H3() != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 || this.c.m0() == null || this.c.m0().l() == null || this.c.m0().l().getAuthor() == null || this.c.m0().l().isUgcThreadType() || TextUtils.equals(this.c.m0().l().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void k4(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092087)) == null) {
                return;
            }
            boolean z2 = false;
            if (this.c.O0() && postData.M() != null && postData.M().equals(this.c.v0())) {
                z2 = true;
            }
            MarkData u0 = this.c.u0(postData);
            if (u0 == null) {
                return;
            }
            this.j.o();
            jp4 jp4Var = this.g;
            if (jp4Var != null) {
                jp4Var.i(u0);
                if (!z2) {
                    this.g.a();
                } else {
                    this.g.d();
                }
            }
        }
    }

    public final void m3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c80);
                return;
            }
            Object tag = view2.getTag();
            this.j.o();
            if (tag instanceof String) {
                String str = (String) tag;
                if (!checkUpIsLogin()) {
                    return;
                }
                K3(str);
            } else if (tag instanceof SparseArray) {
                SparseArray<Object> sparseArray = (SparseArray) tag;
                if ((sparseArray.get(R.id.obfuscated_res_0x7f0920e4) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920e4)).booleanValue()) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09209a, 0);
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, 2);
                    c3(sparseArray);
                }
            }
        }
    }

    @NonNull
    public final SparseArray<Object> x3(SparseArray<?> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048700, this, sparseArray)) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.obfuscated_res_0x7f0920e4, Boolean.TRUE);
            sparseArray2.put(R.id.obfuscated_res_0x7f09209e, sparseArray.get(R.id.obfuscated_res_0x7f09209e));
            sparseArray2.put(R.id.obfuscated_res_0x7f0920e0, sparseArray.get(R.id.obfuscated_res_0x7f0920e0));
            sparseArray2.put(R.id.obfuscated_res_0x7f0920e1, sparseArray.get(R.id.obfuscated_res_0x7f0920e1));
            sparseArray2.put(R.id.obfuscated_res_0x7f0920df, sparseArray.get(R.id.obfuscated_res_0x7f0920df));
            sparseArray2.put(R.id.obfuscated_res_0x7f0920e2, sparseArray.get(R.id.obfuscated_res_0x7f0920e2));
            sparseArray2.put(R.id.obfuscated_res_0x7f0920e3, sparseArray.get(R.id.obfuscated_res_0x7f0920e3));
            sparseArray2.put(R.id.obfuscated_res_0x7f09208a, sparseArray.get(R.id.obfuscated_res_0x7f09208a));
            sparseArray2.put(R.id.obfuscated_res_0x7f09208b, sparseArray.get(R.id.obfuscated_res_0x7f09208b));
            sparseArray2.put(R.id.obfuscated_res_0x7f092089, sparseArray.get(R.id.obfuscated_res_0x7f092089));
            sparseArray2.put(R.id.obfuscated_res_0x7f0920a7, sparseArray.get(R.id.obfuscated_res_0x7f0920a7));
            return sparseArray2;
        }
        return (SparseArray) invokeL.objValue;
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048654, this) == null) && this.k != null && !TextUtils.isEmpty(this.l)) {
            if (this.m == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.l));
            } else {
                f95.a aVar = new f95.a();
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

    public final void n3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && this.k != null && !TextUtils.isEmpty(this.l)) {
            if (this.e == null) {
                this.e = new PermissionJudgePolicy();
            }
            this.e.clearRequestPermissionList();
            this.e.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.e.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
            if (this.f == null) {
                this.f = new m18(getPageContext());
            }
            this.f.b(this.l, this.k.n());
            this.k = null;
            this.l = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.X));
            this.c.cancelLoadData();
            this.c.destory();
            this.h.cancelLoadData();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            this.j.o();
            this.j.U();
            MessageManager.getInstance().unRegisterListener(this.y0);
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.M);
            bw8 bw8Var = this.r0;
            if (bw8Var != null) {
                bw8Var.l();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.W;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            this.I = null;
            this.K = null;
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
        }
    }

    public final void k3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c80);
                return;
            }
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            if (sparseArray == null) {
                return;
            }
            boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920d0)).booleanValue();
            boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920ce)).booleanValue();
            boolean booleanValue3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920e4)).booleanValue();
            boolean z2 = false;
            if (sparseArray.get(R.id.obfuscated_res_0x7f09209f) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09209f)).booleanValue();
            }
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09209a, 1);
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, 2);
                    c3(sparseArray);
                    return;
                }
                if (z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, 2);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f0920a8, Boolean.TRUE);
                this.j.b0(view2);
            } else if (booleanValue2) {
                this.j.Z(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09208b)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f092089), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f0920a7)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09208a)).booleanValue(), false);
            }
        }
    }

    public final void l4(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048659, this, postData) != null) || postData == null) {
            return;
        }
        String M = postData.M();
        if (StringUtils.isNull(M) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            return;
        }
        String q2 = ky4.k().q("bubble_link", "");
        if (StringUtils.isNull(q2)) {
            return;
        }
        TiebaStatic.log("c10051");
        String jumpUrl = postData.f0().getJumpUrl();
        int packageId = postData.f0().getPackageId();
        int propsId = postData.f0().getPropsId();
        if (!StringUtils.isNull(jumpUrl)) {
            rp4.o(getPageContext().getPageActivity(), dq8.a(jumpUrl, "1", String.valueOf(packageId), String.valueOf(propsId)));
        } else if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
        } else {
            rp4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0555), q2 + "?props_id=" + M, true, true, true);
        }
    }

    public final String s3(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048687, this, tbRichTextData)) == null) {
            if (tbRichTextData == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(150);
            TbRichTextImageInfo F = tbRichTextData.F();
            if (F == null) {
                return null;
            }
            if (!StringUtils.isNull(F.z())) {
                return F.z();
            }
            if (F.getHeight() * F.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (F.getHeight() * F.getWidth()));
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (F.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (F.getHeight() * sqrt)));
            } else {
                double width = F.getWidth() / F.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append(BigImageLoaderProc.NCDN_PER);
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(wi.getUrlEncode(F.F()));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final void o4(PostData postData, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048665, this, postData, z2) != null) || b3()) {
            return;
        }
        if (postData != null) {
            if (postData.s() != null) {
                MetaData s2 = postData.s();
                this.G.X(s2.getUserId());
                this.G.c0(postData.M());
                boolean z3 = postData.g0;
                if (postData.X() != null) {
                    str = postData.X().toString();
                } else {
                    str = "";
                }
                this.G.q(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f103a), postData.s().getName_show(), str));
                if (z3) {
                    if (!z2) {
                        this.G.W(s2.getName_show(), s2.getPortrait());
                    }
                } else if (!z2) {
                    this.G.W(s2.getName_show(), s2.getPortrait());
                }
            }
            this.j.m();
        }
        if (this.b0) {
            u3(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, bundle) == null) {
            R3(bundle);
            T3(bundle);
            U3(bundle);
            S3(bundle);
            Q3(bundle);
            if (getIntent() != null) {
                this.g0 = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
                if (this.P) {
                    this.u0 = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
                }
            }
            super.onCreate(bundle);
            this.I = getPageContext();
            this.L = true;
            h39 h39Var = new h39();
            this.U = h39Var;
            h39Var.h(R.color.cp_cont_h_alpha85);
            this.U.j(R.color.CAM_X0101);
            V3();
            L3();
            N3(bundle);
            Z3();
            if (this.P && this.j.u() != null) {
                showLoadingView(this.j.u(), true, UtilHelper.getDimenPixelSize(R.dimen.tbds300));
            }
            if (this.P) {
                ((SubPbView) this.j.I()).setAnimTime(0);
                ((SubPbView) this.j.I()).setIsFromVideoTab(true);
            } else if (this.Q) {
                setActivityBgTransparent();
                ((SubPbView) this.j.I()).setAnimTime(0);
                ((SubPbView) this.j.I()).setIsFromFoldComment(true);
            } else {
                ((SubPbView) this.j.I()).setAnimTime(300);
                ((SubPbView) this.j.I()).setIsFromVideoTab(false);
            }
            ((SubPbView) this.j.I()).h();
            O3(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.j.k(this.g0);
            qy4 qy4Var = new qy4();
            this.K = qy4Var;
            qy4Var.a = 1000L;
            registerListener(this.A0);
            registerListener(this.y0);
            registerListener(this.z0);
            registerListener(this.w0);
            this.M = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.M;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.M;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.W = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new a(this));
            k38 k38Var = new k38(this);
            this.d = k38Var;
            k38Var.b(getUniqueId());
            this.Y = new l28(this);
            this.r0 = new bw8(getPageContext(), getUniqueId());
            if (this.s0 == null) {
                if (this.S) {
                    this.s0 = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.s0 = new TiePlusEventController(this, TiePlusStat.Locate.PB_COMMENT);
                }
                this.s0.k(this.t0);
            }
            i45.b(false);
        }
    }

    public final boolean q3(View view2) {
        InterceptResult invokeL;
        SparseArray<?> sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        List<pv4> c2;
        hn hnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048682, this, view2)) == null) {
            if (view2.getTag() instanceof SparseArray) {
                sparseArray = (SparseArray) view2.getTag();
            } else {
                sparseArray = null;
            }
            if (sparseArray == null && (sparseArray = C3(view2)) == null) {
                return true;
            }
            SparseArray<?> sparseArray2 = sparseArray;
            if (!(sparseArray2.get(R.id.obfuscated_res_0x7f092087) instanceof PostData)) {
                return true;
            }
            this.n = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f092087);
            jp4 jp4Var = this.g;
            if (jp4Var == null) {
                return true;
            }
            jp4Var.h(this.c.O0());
            if (this.g.e() && TextUtils.equals(this.n.M(), this.c.v0())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.c.m0() != null && this.c.m0().l() != null && this.c.m0().l().isBjh()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (c4(view2) && !z3) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (c4(view2) && (hnVar = this.k) != null && !hnVar.t()) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean y3 = y3(sparseArray2, R.id.obfuscated_res_0x7f0920a0, false);
            boolean y32 = y3(sparseArray2, R.id.obfuscated_res_0x7f09208a, false);
            boolean y33 = y3(sparseArray2, R.id.obfuscated_res_0x7f0920e4, false);
            boolean y34 = y3(sparseArray2, R.id.obfuscated_res_0x7f0920d0, false);
            boolean y35 = y3(sparseArray2, R.id.obfuscated_res_0x7f0920e4, false);
            boolean y36 = y3(sparseArray2, R.id.obfuscated_res_0x7f0920ce, false);
            boolean y37 = y3(sparseArray2, R.id.obfuscated_res_0x7f09209f, false);
            String D3 = D3(sparseArray2, R.id.obfuscated_res_0x7f092097, null);
            ArrayList arrayList = new ArrayList();
            if (this.p == null) {
                tv4 tv4Var = new tv4(getBaseContext());
                this.p = tv4Var;
                tv4Var.n(this.q);
            }
            S2(z4, arrayList);
            Y2(z5, arrayList);
            Q2(z4, z5, arrayList);
            U2(z2, z3, y3, arrayList);
            W2(sparseArray2, y33, y34, arrayList);
            X2(z3, y32, y33, y34, D3, arrayList);
            T2(sparseArray2, y32, y34, y35, y36, y37, D3, arrayList);
            R2(sparseArray2, y32, y34, y35, y36, y37, D3, arrayList);
            V2(y34, y36, arrayList);
            b38.a(arrayList, this.p, this.n, this.c.m0(), this.mIsLogin);
            if (UbsABTestHelper.isPBPlanA()) {
                c2 = b38.d(arrayList, this.n.q(), sparseArray2, this.p);
            } else {
                c2 = b38.c(arrayList, this.n.q(), sparseArray2, this.p);
            }
            b38.l(c2, true);
            b38.f(c2);
            this.p.o(b38.g(this.n));
            this.p.k(c2, !UbsABTestHelper.isPBPlanA());
            k85 k85Var = this.G;
            if (k85Var != null) {
                k85Var.z();
            }
            rv4 rv4Var = new rv4(getPageContext(), this.p);
            this.o = rv4Var;
            rv4Var.k();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            this.H = true;
            super.onPause();
            TiePlusEventController tiePlusEventController = this.s0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            f38.a();
            km4.w().E();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.E0);
            this.j.V();
            if (this.P || this.Q) {
                x4(false);
            }
        }
    }

    public final void s4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            iv4 iv4Var = new iv4(getPageContext().getPageActivity());
            iv4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b67));
            iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d3b, new h0(this));
            iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new i0(this));
            iv4Var.create(this.I).show();
        }
    }

    public final void q4(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048683, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            b38.e(this, getPageContext(), new j(this, sparseArray, i2, z2), new l(this));
        }
    }

    public final boolean y3(SparseArray<?> sparseArray, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048703, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
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

    public void t3(ForumManageModel.b bVar, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048690, this, bVar, z2) != null) || bVar == null) {
            return;
        }
        int i2 = 0;
        this.j.s(0, bVar.a, bVar.b, z2);
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                if (this.j.B() instanceof BdTypeListView) {
                    List<wn> data = ((BdTypeListView) this.j.B()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        while (i2 < data.size() && (!(data.get(i2) instanceof PostData) || !bVar.g.equals(((PostData) data.get(i2)).M()))) {
                            i2++;
                        }
                        if (i2 < data.size()) {
                            data.remove(i2);
                        }
                        this.j.T();
                    }
                }
            } else if (i3 == 2) {
                this.c.i0(bVar.g);
                m38 m38Var = this.j;
                tx7 m02 = this.c.m0();
                int E0 = this.c.E0();
                if (this.c.D0() != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                m38Var.A0(m02, E0, z3, false);
                if (this.c.P0()) {
                    this.c.b1(false);
                    this.j.l();
                    this.c.loadData();
                }
            }
            jw7 jw7Var = new jw7();
            jw7Var.b(bVar);
            jw7Var.c(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, jw7Var));
        }
    }

    @NonNull
    public final SparseArray<Object> v3(SparseArray<?> sparseArray, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048694, this, sparseArray, z2)) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.obfuscated_res_0x7f0920d0, Boolean.FALSE);
            sparseArray2.put(R.id.obfuscated_res_0x7f0920e4, Boolean.FALSE);
            sparseArray2.put(R.id.obfuscated_res_0x7f0920ce, Boolean.TRUE);
            sparseArray2.put(R.id.obfuscated_res_0x7f0920a7, sparseArray.get(R.id.obfuscated_res_0x7f0920a7));
            sparseArray2.put(R.id.obfuscated_res_0x7f09208a, Boolean.valueOf(z2));
            sparseArray2.put(R.id.obfuscated_res_0x7f092089, sparseArray.get(R.id.obfuscated_res_0x7f092089));
            sparseArray2.put(R.id.obfuscated_res_0x7f09208b, sparseArray.get(R.id.obfuscated_res_0x7f09208b));
            sparseArray2.put(R.id.obfuscated_res_0x7f09209b, sparseArray.get(R.id.obfuscated_res_0x7f09209b));
            return sparseArray2;
        }
        return (SparseArray) invokeLZ.objValue;
    }

    public final void v4(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048695, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.j.t0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            iv4 iv4Var = new iv4(this.I.getPageActivity());
            if (!wi.isEmpty(str)) {
                iv4Var.setMessage(str);
            } else {
                iv4Var.setMessage(this.I.getResources().getString(R.string.obfuscated_res_0x7f0f0324, str3));
            }
            iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f043f, new d0(this, userMuteAddAndDelCustomMessage));
            iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new e0(this));
            iv4Var.create(this.I).show();
        }
    }

    public final TbRichText y4(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048704, this, str, i2)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.m0() != null && str != null && i2 >= 0) {
                tx7 m02 = this.c.m0();
                TbRichText z3 = z3(m02.i(), str, i2);
                if (z3 != null || (z3 = z3(m02.i(), str, i2)) != null) {
                }
                return z3;
            }
            return null;
        }
        return (TbRichText) invokeLI.objValue;
    }
}
