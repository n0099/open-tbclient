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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
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
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.am6;
import com.repackage.bt7;
import com.repackage.c9;
import com.repackage.cl4;
import com.repackage.d9;
import com.repackage.dt4;
import com.repackage.eg;
import com.repackage.en4;
import com.repackage.es7;
import com.repackage.eu7;
import com.repackage.fg;
import com.repackage.h05;
import com.repackage.ho8;
import com.repackage.hr7;
import com.repackage.ht4;
import com.repackage.hx4;
import com.repackage.io8;
import com.repackage.j25;
import com.repackage.jh8;
import com.repackage.k25;
import com.repackage.k35;
import com.repackage.kf5;
import com.repackage.km4;
import com.repackage.ko8;
import com.repackage.lt4;
import com.repackage.lv8;
import com.repackage.lw7;
import com.repackage.n75;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.nq4;
import com.repackage.oi;
import com.repackage.ot4;
import com.repackage.p25;
import com.repackage.pf5;
import com.repackage.pi;
import com.repackage.pq4;
import com.repackage.py4;
import com.repackage.q25;
import com.repackage.qg;
import com.repackage.qy4;
import com.repackage.rn;
import com.repackage.rw7;
import com.repackage.sf5;
import com.repackage.sg;
import com.repackage.t05;
import com.repackage.tu7;
import com.repackage.tw7;
import com.repackage.u05;
import com.repackage.u75;
import com.repackage.uk4;
import com.repackage.uu4;
import com.repackage.vh4;
import com.repackage.vz4;
import com.repackage.w75;
import com.repackage.wh4;
import com.repackage.x75;
import com.repackage.xp7;
import com.repackage.xv7;
import com.repackage.xw7;
import com.repackage.ym;
import com.repackage.zu7;
import com.repackage.zv7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes3.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.j, sf5, BdListView.p, es7<NewSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String F0 = "tbgametype";
    public transient /* synthetic */ FieldHolder $fh;
    public eg<View> A;
    public final ot4.g A0;
    public eg<ImageView> B;
    public boolean B0;
    public eg<LinearLayout> C;
    public final pq4.c C0;
    public eg<RelativeLayout> D;
    public CustomMessageListener D0;
    public p25 E;
    public CustomMessageListener E0;
    public boolean F;
    public d9 G;
    public Object H;
    public lt4 I;
    public boolean J;
    public BdUniqueId K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public boolean Q;
    public boolean R;
    public lv8 S;
    public EditText T;
    public ReplyPrivacyCheckController U;
    public xp7<hr7> V;
    public xv7 W;
    public am6 X;
    public PostWriteCallBackData Y;
    public boolean Z;
    public boolean a;
    public int b;
    public SubPbModel c;
    public rw7 d;
    public PermissionJudgePolicy e;
    public zu7 f;
    public uk4 g;
    public k25 g0;
    public ForumManageModel h;
    public String h0;
    public VoiceManager i;
    public PbCommenFloorItemViewHolder i0;
    public tw7 j;
    public int j0;
    public ym k;
    public boolean k0;
    public String l;
    public dt4 l0;
    public TbRichTextMemeInfo m;
    public BdUniqueId m0;
    public PostData n;
    public jh8 n0;
    public eu7 o;
    public boolean o0;
    public View.OnClickListener p;
    public boolean p0;
    public AbsListView.OnScrollListener q;
    public io8 q0;
    public View.OnLongClickListener r;
    @Nullable
    public TiePlusEventController r0;
    public TbRichTextView.y s;
    @NonNull
    public TiePlusEventController.f s0;
    public SubPbModel.b t;
    public BdUniqueId t0;
    public uk4.a u;
    public j25 u0;
    public c9 v;
    public CustomMessageListener v0;
    public r0 w;
    public NewWriteModel.e w0;
    public r0 x;
    public CustomMessageListener x0;
    public eg<TextView> y;
    public CustomMessageListener y0;
    public eg<GifView> z;
    public CustomMessageListener z0;

    /* loaded from: classes3.dex */
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
                this.a.E.F();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements fg<RelativeLayout> {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.c == null) {
                return;
            }
            this.a.c.loadData();
        }
    }

    /* loaded from: classes3.dex */
    public class b0 extends u75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity b;

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
            this.b = newSubPbActivity;
        }

        @Override // com.repackage.u75
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? x75.b().c() : invokeV.intValue;
        }

        @Override // com.repackage.u75
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.j.D0(postData);
                this.a.j.y0(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ NewSubPbActivity b;

        public c0(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                this.b.j.E0();
                MessageManager.getInstance().sendMessage(this.a);
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ p25 b;
        public final /* synthetic */ NewSubPbActivity c;

        public d(NewSubPbActivity newSubPbActivity, View view2, p25 p25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, view2, p25Var};
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
            this.b = p25Var;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) {
                this.a.performClick();
                this.b.q();
                this.b.t().i().setText(str);
                Editable text = this.b.t().i().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.b.t().i().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements SubPbModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hr7 a;
            public final /* synthetic */ e b;

            public a(e eVar, hr7 hr7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, hr7Var};
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
                this.a = hr7Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.p0 = false;
                    this.b.a.D3(this.a.i(), false);
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
        public void a(boolean z, int i, String str, hr7 hr7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, hr7Var}) == null) || this.a.j == null) {
                return;
            }
            this.a.j.o0();
            if (this.a.N && this.a.j.B() != null) {
                NewSubPbActivity newSubPbActivity = this.a;
                newSubPbActivity.hideLoadingView(newSubPbActivity.j.B());
            }
            if (!z) {
                this.a.B3(i, str);
                return;
            }
            this.a.j.U();
            if (hr7Var != null) {
                if (hr7Var.i() != null || this.a.c != null) {
                    hr7Var.i().F0(this.a.c.z0());
                }
                if (this.a.j != null) {
                    this.a.j3(hr7Var.l() != null && hr7Var.l().isBjh());
                    if (this.a.E != null && this.a.E.a() != null) {
                        this.a.E.a().w(TbadkCoreApplication.getInst().getSkinType());
                    }
                    this.a.j.L0(hr7Var, this.a.c.E0(), this.a.c.D0() != null, this.a.J);
                    if (this.a.J) {
                        this.a.j.I().setSelectionFromTop(this.a.j.I().getHeaderViewsCount() + 1, -pi.f(this.a, R.dimen.tbds18));
                        this.a.R2();
                        this.a.J = false;
                    }
                }
                if (this.a.E != null) {
                    this.a.E.G(hr7Var.a());
                    this.a.E.c0(hr7Var.l());
                    if (this.a.getIntent() != null && this.a.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && this.a.p0) {
                        qg.a().postDelayed(new a(this, hr7Var), 200L);
                    }
                }
                if (this.a.V == null) {
                    this.a.V = new xp7();
                }
                this.a.V.b(hr7Var);
                this.a.V.c(0);
                NewSubPbActivity newSubPbActivity2 = this.a;
                newSubPbActivity2.U.setLikeUserData(newSubPbActivity2.c.l0());
            }
            String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || this.a.R) {
                return;
            }
            this.a.R = true;
            NewSubPbActivity newSubPbActivity3 = this.a;
            newSubPbActivity3.G3(newSubPbActivity3.j.P(), this.a.E, stringExtra);
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements nq4.e {
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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements uk4.a {
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

        @Override // com.repackage.uk4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.g != null) {
                        this.a.g.h(z2);
                    }
                    MarkData f = this.a.g.f();
                    xp7 xp7Var = new xp7();
                    xp7Var.c(2);
                    if (z2) {
                        xp7Var.b(f);
                        if (this.a.g != null) {
                            if (f != null) {
                                this.a.c.c1(true);
                                this.a.c.d1(this.a.c.B());
                                this.a.showToast(R.string.obfuscated_res_0x7f0f00d1);
                            } else {
                                NewSubPbActivity newSubPbActivity = this.a;
                                newSubPbActivity.showToast(newSubPbActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d0));
                            }
                            if (this.a.j != null) {
                                this.a.j.P0(true);
                            }
                        }
                    } else {
                        xp7Var.b(null);
                        this.a.c.c1(false);
                        this.a.c.d1(null);
                        NewSubPbActivity newSubPbActivity2 = this.a;
                        newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fb8));
                        if (this.a.j != null) {
                            this.a.j.P0(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, xp7Var));
                    return;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14d9));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements nq4.e {
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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    nq4Var.dismiss();
                    ((TbPageContext) this.a.G).showToast(R.string.obfuscated_res_0x7f0f06f7);
                    return;
                }
                TiebaStatic.log("c10025");
                nq4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.G.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements r0 {
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

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.r0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String valueOf = (this.a.c.m0() == null || this.a.c.m0().l() == null || this.a.c.m0().l().getAuthor() == null) ? "" : String.valueOf(this.a.c.m0().l().getAuthor().getUserId());
                String valueOf2 = objArr.length > 1 ? String.valueOf(objArr[1]) : "";
                String valueOf3 = objArr.length > 2 ? String.valueOf(objArr[2]) : "";
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.c.m0().d().getId(), this.a.c.m0().d().getName(), this.a.c.m0().l().getId(), valueOf, valueOf2, objArr.length > 3 ? String.valueOf(objArr[3]) : "", valueOf3, objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g0 implements j25 {
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

        @Override // com.repackage.j25
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.S.d()) {
                    NewSubPbActivity newSubPbActivity = this.a;
                    newSubPbActivity.showToast(newSubPbActivity.S.c());
                    if (this.a.E.x()) {
                        this.a.E.v(this.a.Y);
                    }
                    this.a.O2(true);
                    return true;
                }
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (newSubPbActivity2.U == null || newSubPbActivity2.c == null || this.a.c.k0() == null || this.a.G(TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                return !newSubPbActivity3.U.checkPrivacyBeforeSend(newSubPbActivity3.c.k0().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements r0 {
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

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.r0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (this.a.h.S() || objArr == null || objArr.length < 4) {
                        return;
                    }
                    String valueOf = String.valueOf(objArr[0]);
                    int e = ng.e(String.valueOf(objArr[1]), 0);
                    boolean b = ng.b(String.valueOf(objArr[2]), false);
                    int e2 = ng.e(String.valueOf(objArr[3]), 0);
                    if (this.a.c == null || this.a.c.m0() == null || this.a.c.m0().d() == null || this.a.c.m0().l() == null) {
                        return;
                    }
                    if (objArr.length > 4) {
                        this.a.h.U(String.valueOf(objArr[4]));
                    }
                    this.a.h.V(this.a.c.m0().d().getId(), this.a.c.m0().d().getName(), this.a.c.m0().l().getId(), valueOf, e2, e, b, this.a.c.m0().l().getBaijiahaoData(), false);
                    return;
                }
                TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements nq4.e {
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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends c9 {
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.h.getLoadDataMode();
                    if (loadDataMode == 0) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.W2(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.j.z(1, dVar.a, dVar.b, true);
                        return;
                    }
                }
                this.a.j.z(this.a.h.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(NewSubPbActivity newSubPbActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (StringUtils.isNull(currentAccount)) {
                    return;
                }
                UserPendantData userPendantData = (UserPendantData) customResponsedMessage.getData();
                if (this.a.c.m0() == null || this.a.c.m0().i() == null || this.a.c.m0().i().s() == null || !currentAccount.equals(this.a.c.m0().i().s().getUserId()) || this.a.c.m0().i().s().getPendantData() == null) {
                    return;
                }
                this.a.c.m0().i().s().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.a.c.m0().i().s().getPendantData().setPropsId(userPendantData.getPropsId());
                this.a.j.y(this.a.c.m0(), this.a.c.m0().i(), this.a.c.m0().e(), this.a.c.m0().f(), this.a.c.E0(), this.a.c.D0() != null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements nq4.e {
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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                if (nq4Var != null) {
                    nq4Var.dismiss();
                }
                if (this.d.x != null) {
                    this.d.x.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091e4b), Integer.valueOf(this.b), Boolean.valueOf(this.c), this.a.get(R.id.obfuscated_res_0x7f091e4d)});
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ NewSubPbActivity c;

        public j0(NewSubPbActivity newSubPbActivity, int i, int i2) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.j == null || this.c.j.I() == null) {
                return;
            }
            this.c.j.I().setSelectionFromTop(this.a, this.c.j.K() - this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements k25 {
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

        @Override // com.repackage.k25
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.B0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ NewSubPbActivity d;

        public k0(NewSubPbActivity newSubPbActivity, int i, int i2, int i3) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.d.j == null || this.d.j.I() == null) {
                return;
            }
            this.d.j.I().setSelectionFromTop(this.a, this.d.j.K() + (this.b - this.c));
        }
    }

    /* loaded from: classes3.dex */
    public class l implements nq4.e {
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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.c != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.c.A0())) {
                if (this.a.S != null) {
                    this.a.S.n(null);
                    this.a.S.i(null);
                    this.a.S.k(false);
                }
                if (this.a.E != null) {
                    this.a.E.q();
                    this.a.E.H();
                }
                this.a.c.K();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zv7 a;
            public final /* synthetic */ PostData b;
            public final /* synthetic */ m c;

            public a(m mVar, zv7 zv7Var, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, zv7Var, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = mVar;
                this.a = zv7Var;
                this.b = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    bt7 bt7Var = new bt7(new kf5());
                    bt7Var.j(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
                    bt7Var.o(TbConfig.getPostLineSpace(), 1.0f);
                    this.a.b.a(null, this.c.a.c.m0().l(), this.b, bt7Var);
                }
            }
        }

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
            SparseArray<Object> sparseArray;
            String str;
            PostData postData;
            String c;
            SparseArray sparseArray2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == null && this.a.j == null) {
                    return;
                }
                boolean z = true;
                if (view2 == this.a.j.H()) {
                    this.a.j.v();
                    String str2 = view2.getTag(R.id.obfuscated_res_0x7f091e99) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091e99) : null;
                    String str3 = view2.getTag(R.id.obfuscated_res_0x7f091ea1) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091ea1) : null;
                    String str4 = view2.getTag(R.id.obfuscated_res_0x7f091ea3) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091ea3) : null;
                    if (str4 != null) {
                        if (this.a.checkUpIsLogin()) {
                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str4});
                        }
                    } else if (str2 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), str2, str3, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                    }
                } else if (view2 != this.a.j.P()) {
                    if (view2 != this.a.j.M()) {
                        if (view2 == this.a.j.N()) {
                            if (this.a.checkUpIsLogin()) {
                                this.a.j.O0();
                                this.a.j.t();
                                if (this.a.E != null) {
                                    this.a.E.h0();
                                }
                            }
                        } else if (view2.getId() != R.id.obfuscated_res_0x7f091681) {
                            if (view2 == this.a.j.J()) {
                                this.a.j.v();
                                if (this.a.c.loadData()) {
                                    this.a.j.K0();
                                    return;
                                }
                                return;
                            }
                            str = "";
                            if (view2 == this.a.j.F() || view2 == this.a.j.E() || view2 == this.a.j.Q()) {
                                if (this.a.L) {
                                    this.a.L = false;
                                    return;
                                }
                                if (!((this.a.c.m0() == null || this.a.c.m0().l() == null) ? false : ThreadCardUtils.isUgcThreadType(this.a.c.m0().l().getBaijiahaoData()))) {
                                    if (this.a.c == null || this.a.c.m0() == null) {
                                        return;
                                    }
                                    if (this.a.w3(this.a.c.m0().l())) {
                                        VideoItemData videoItemData = new VideoItemData();
                                        videoItemData.buildWithThreadData(this.a.c.m0().l());
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.a.getActivity(), Arrays.asList(videoItemData), 0, null, "frs")));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.getActivity()).createNormalCfg(this.a.c.A0(), this.a.c.B(), "");
                                    if (!StringUtils.isNull(this.a.c.getFromForumId())) {
                                        createNormalCfg.setForumId(this.a.c.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                    return;
                                }
                                PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.a.getActivity()).createNormalCfg(this.a.c.A0(), null, "");
                                if (!StringUtils.isNull(this.a.c.getFromForumId())) {
                                    createNormalCfg2.setForumId(this.a.c.getFromForumId());
                                }
                                if (this.a.c.m0() != null && this.a.c.m0().l() != null) {
                                    createNormalCfg2.setBjhData(this.a.c.m0().l().getBaijiahaoData());
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            } else if (this.a.j.L() == null || view2 != this.a.j.L().A()) {
                                if (this.a.j.L() == null || view2 != this.a.j.L().u()) {
                                    if (this.a.j.L() == null || view2 != this.a.j.L().z()) {
                                        if (this.a.j.L() == null || view2 != this.a.j.L().D()) {
                                            if (this.a.j.L() == null || view2 != this.a.j.L().t()) {
                                                if (view2 != this.a.j.G() && view2 != this.a.j.Q()) {
                                                    if (view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                        this.a.i0 = (PbCommenFloorItemViewHolder) view2.getTag();
                                                        if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                            if (this.a.L) {
                                                                this.a.L = false;
                                                                return;
                                                            }
                                                            NewSubPbActivity newSubPbActivity = this.a;
                                                            if (newSubPbActivity.U != null && newSubPbActivity.c != null && this.a.c.k0() != null && !this.a.G(TbadkCoreApplication.getCurrentAccount())) {
                                                                NewSubPbActivity newSubPbActivity2 = this.a;
                                                                if (!newSubPbActivity2.U.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.c.k0().replyPrivateFlag)) {
                                                                    return;
                                                                }
                                                            }
                                                            SparseArray sparseArray3 = (SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091e5c);
                                                            if (sparseArray3 == null) {
                                                                return;
                                                            }
                                                            if ((view2.getTag(R.id.obfuscated_res_0x7f091e90) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f091e90) == Boolean.TRUE) {
                                                                r4 = true;
                                                            }
                                                            this.a.C3(sparseArray3, r4);
                                                            if (sparseArray3.get(R.id.obfuscated_res_0x7f091e49) instanceof PostData) {
                                                                PostData postData2 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e49);
                                                                xw7.a(this.a.c != null ? this.a.c.A0() : "", postData2.s() == null ? "" : postData2.s().getUserId(), postData2.J());
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f0918aa && view2.getId() != R.id.obfuscated_res_0x7f09167d && (this.a.o == null || view2 != this.a.o.C())) {
                                                        if (this.a.o == null || view2 != this.a.o.D()) {
                                                            if (this.a.o == null || view2 != this.a.o.A()) {
                                                                if (this.a.o == null || view2 != this.a.o.u()) {
                                                                    if (this.a.o == null || view2 != this.a.o.t()) {
                                                                        if (this.a.o == null || view2 != this.a.o.w()) {
                                                                            if (this.a.o == null || view2 != this.a.o.E()) {
                                                                                if (this.a.o == null || view2 != this.a.o.v()) {
                                                                                    if (this.a.o == null || view2 != this.a.o.z()) {
                                                                                        if (this.a.o == null || view2 != this.a.o.s()) {
                                                                                            if (this.a.o == null || view2 != this.a.o.F()) {
                                                                                                if (view2 == this.a.j.D()) {
                                                                                                    if (this.a.E == null || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.E.f0();
                                                                                                    this.a.U2();
                                                                                                    return;
                                                                                                }
                                                                                                int id = view2.getId();
                                                                                                if (id == R.id.obfuscated_res_0x7f0916ac) {
                                                                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1382);
                                                                                                        String q = ht4.k().q("tail_link", "");
                                                                                                        if (StringUtils.isNull(q)) {
                                                                                                            return;
                                                                                                        }
                                                                                                        TiebaStatic.log("c10056");
                                                                                                        cl4.s(view2.getContext(), string, q, true, true, true);
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else if (id == R.id.obfuscated_res_0x7f091a6f && (view2.getTag() instanceof SparseArray)) {
                                                                                                    Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091e49);
                                                                                                    if (obj instanceof PostData) {
                                                                                                        PostData postData3 = (PostData) obj;
                                                                                                        if (postData3.getType() == PostData.A0 || TextUtils.isEmpty(postData3.t()) || !km4.c().g()) {
                                                                                                            return;
                                                                                                        }
                                                                                                        this.a.A3(postData3.J());
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                } else {
                                                                                                    return;
                                                                                                }
                                                                                            } else if (view2.getTag() instanceof SparseArray) {
                                                                                                SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                                                                if (sparseArray4.get(R.id.obfuscated_res_0x7f091e65) instanceof PostData) {
                                                                                                    PostData postData4 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f091e65);
                                                                                                    zv7 zv7Var = new zv7(this.a.getPageContext());
                                                                                                    if (postData4 != null) {
                                                                                                        qg.a().postDelayed(new a(this, zv7Var, postData4), 100L);
                                                                                                        String id2 = this.a.c.m0().l().getId();
                                                                                                        if (StringUtils.isNull(id2) || "0".equals(id2)) {
                                                                                                            id2 = this.a.c.m0().l().getNid();
                                                                                                        }
                                                                                                        TiebaStatic.log(new StatisticItem("c13700").param("tid", id2).param("fid", this.a.c.m0().l().getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.J()).param("obj_source", 1).param("obj_type", 4));
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else if (!ni.z()) {
                                                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                                                                            return;
                                                                                        } else if (!ViewHelper.checkUpIsLogin(this.a.getActivity()) || (c = ho8.c(view2)) == null || this.a.q0 == null) {
                                                                                            return;
                                                                                        } else {
                                                                                            this.a.q0.n(ng.g(c, 0L));
                                                                                            return;
                                                                                        }
                                                                                    } else if (!ni.z()) {
                                                                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray<Object> sparseArray5 = (SparseArray) view2.getTag();
                                                                                        if (sparseArray5 == null) {
                                                                                            return;
                                                                                        }
                                                                                        boolean booleanValue = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091e8c)).booleanValue();
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091e8a)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue();
                                                                                        r4 = sparseArray5.get(R.id.obfuscated_res_0x7f091e61) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091e61)).booleanValue() : false;
                                                                                        if (!booleanValue) {
                                                                                            if (booleanValue2) {
                                                                                                this.a.j.j0(((Integer) sparseArray5.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) sparseArray5.get(R.id.obfuscated_res_0x7f091e4b), ((Integer) sparseArray5.get(R.id.obfuscated_res_0x7f091e68)).intValue(), ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue(), false);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else if (!booleanValue3) {
                                                                                            if (r4) {
                                                                                                sparseArray5.put(R.id.obfuscated_res_0x7f091e45, 2);
                                                                                            }
                                                                                            this.a.j.l0(view2);
                                                                                            return;
                                                                                        } else {
                                                                                            sparseArray5.put(R.id.obfuscated_res_0x7f091e5c, 1);
                                                                                            sparseArray5.put(R.id.obfuscated_res_0x7f091e45, 2);
                                                                                            this.a.Q2(sparseArray5);
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                } else if (this.a.checkUpIsLogin() && (sparseArray2 = (SparseArray) view2.getTag()) != null) {
                                                                                    PostData postData5 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091e49);
                                                                                    if (postData5.q() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.a.S2(postData5.q());
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (this.a.k == null || TextUtils.isEmpty(this.a.l)) {
                                                                                return;
                                                                            } else {
                                                                                if (this.a.e == null) {
                                                                                    this.a.e = new PermissionJudgePolicy();
                                                                                }
                                                                                this.a.e.clearRequestPermissionList();
                                                                                this.a.e.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (this.a.e.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                                                    return;
                                                                                }
                                                                                if (this.a.f == null) {
                                                                                    NewSubPbActivity newSubPbActivity3 = this.a;
                                                                                    newSubPbActivity3.f = new zu7(newSubPbActivity3.getPageContext());
                                                                                }
                                                                                this.a.f.b(this.a.l, this.a.k.n());
                                                                                this.a.k = null;
                                                                                this.a.l = null;
                                                                                return;
                                                                            }
                                                                        } else if (this.a.k == null || TextUtils.isEmpty(this.a.l)) {
                                                                            return;
                                                                        } else {
                                                                            if (this.a.m == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.l));
                                                                            } else {
                                                                                k35.a aVar = new k35.a();
                                                                                aVar.a = this.a.l;
                                                                                if (this.a.m.memeInfo.pck_id.intValue() >= 0) {
                                                                                    str = "" + this.a.m.memeInfo.pck_id;
                                                                                }
                                                                                aVar.b = str;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            this.a.k = null;
                                                                            this.a.l = null;
                                                                            return;
                                                                        }
                                                                    }
                                                                    PostData postData6 = this.a.n;
                                                                    if (postData6 != null) {
                                                                        postData6.p0();
                                                                        this.a.n = null;
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view2.getTag();
                                                                if (sparseArray6 != null && (sparseArray6.get(R.id.obfuscated_res_0x7f091e4d) instanceof Integer) && (sparseArray6.get(R.id.obfuscated_res_0x7f091e4b) instanceof String) && (sparseArray6.get(R.id.obfuscated_res_0x7f091e68) instanceof Integer) && (sparseArray6.get(R.id.obfuscated_res_0x7f091e4c) instanceof Boolean)) {
                                                                    boolean booleanValue4 = ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue();
                                                                    int intValue = ((Integer) sparseArray6.get(R.id.obfuscated_res_0x7f091e68)).intValue();
                                                                    boolean booleanValue5 = ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f091e5d)).booleanValue();
                                                                    boolean G = this.a.G(TbadkCoreApplication.getCurrentAccount());
                                                                    if (G) {
                                                                        if (!booleanValue5) {
                                                                            this.a.F3(sparseArray6, intValue, booleanValue4);
                                                                            return;
                                                                        } else {
                                                                            this.a.j.j0(((Integer) sparseArray6.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) sparseArray6.get(R.id.obfuscated_res_0x7f091e4b), intValue, booleanValue4, G);
                                                                            return;
                                                                        }
                                                                    } else if (booleanValue4 && !booleanValue5) {
                                                                        this.a.F3(sparseArray6, intValue, booleanValue4);
                                                                        return;
                                                                    } else {
                                                                        this.a.j.j0(((Integer) sparseArray6.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) sparseArray6.get(R.id.obfuscated_res_0x7f091e4b), intValue, booleanValue4, G);
                                                                        return;
                                                                    }
                                                                }
                                                                return;
                                                            } else if (this.a.checkUpIsLogin()) {
                                                                this.a.y3(view2);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!ni.z()) {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                                            return;
                                                        } else {
                                                            Object tag = view2.getTag();
                                                            if (tag instanceof String) {
                                                                this.a.g3((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray7 = (SparseArray) tag;
                                                                if ((sparseArray7.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean) && ((Boolean) sparseArray7.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue()) {
                                                                    sparseArray7.put(R.id.obfuscated_res_0x7f091e5c, 0);
                                                                    sparseArray7.put(R.id.obfuscated_res_0x7f091e45, 2);
                                                                    this.a.Q2(sparseArray7);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                        SparseArray sparseArray8 = (SparseArray) view2.getTag();
                                                        if ((sparseArray8.get(R.id.obfuscated_res_0x7f091e65) instanceof PostData) && (postData = (PostData) sparseArray8.get(R.id.obfuscated_res_0x7f091e65)) != null) {
                                                            if (this.a.c != null) {
                                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.c.B0()).param("fid", this.a.c.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.J()).param("obj_source", 1).param("obj_type", 3));
                                                            }
                                                            this.a.D3(postData, (view2.getTag(R.id.obfuscated_res_0x7f091e90) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f091e90) == Boolean.TRUE);
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.a.checkUpIsLogin()) {
                                                    if (this.a.E.A()) {
                                                        this.a.E.y();
                                                        return;
                                                    } else {
                                                        this.a.E.l0(null, null);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else if (view2.getTag() == null || !(view2.getTag() instanceof SparseArray)) {
                                                return;
                                            } else {
                                                SparseArray sparseArray9 = (SparseArray) view2.getTag();
                                                if (sparseArray9.get(R.id.obfuscated_res_0x7f091e49) instanceof PostData) {
                                                    ((PostData) sparseArray9.get(R.id.obfuscated_res_0x7f091e49)).p0();
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                        if (!ni.z()) {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                            return;
                                        }
                                        Object tag2 = view2.getTag();
                                        this.a.j.v();
                                        if (tag2 instanceof String) {
                                            String str5 = (String) tag2;
                                            if (this.a.checkUpIsLogin()) {
                                                this.a.g3(str5);
                                                return;
                                            }
                                            return;
                                        } else if (tag2 instanceof SparseArray) {
                                            SparseArray<Object> sparseArray10 = (SparseArray) tag2;
                                            if ((sparseArray10.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean) && ((Boolean) sparseArray10.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue()) {
                                                sparseArray10.put(R.id.obfuscated_res_0x7f091e5c, 0);
                                                sparseArray10.put(R.id.obfuscated_res_0x7f091e45, 2);
                                                this.a.Q2(sparseArray10);
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else if (ni.z()) {
                                        this.a.j.v();
                                        if (this.a.checkUpIsLogin()) {
                                            this.a.T2(view2);
                                            return;
                                        }
                                        return;
                                    } else {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                        return;
                                    }
                                }
                                this.a.j.v();
                                SparseArray sparseArray11 = (SparseArray) view2.getTag();
                                if (sparseArray11 == null) {
                                    return;
                                }
                                this.a.j.j0(((Integer) sparseArray11.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) sparseArray11.get(R.id.obfuscated_res_0x7f091e4b), ((Integer) sparseArray11.get(R.id.obfuscated_res_0x7f091e68)).intValue(), ((Boolean) sparseArray11.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue(), false);
                            } else {
                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                this.a.j.v();
                                if (this.a.checkUpIsLogin() && this.a.c.m0() != null) {
                                    NewSubPbActivity newSubPbActivity4 = this.a;
                                    newSubPbActivity4.z3(newSubPbActivity4.c.m0().i());
                                }
                            }
                        } else {
                            try {
                                sparseArray = (SparseArray) view2.getTag();
                            } catch (ClassCastException e) {
                                e.printStackTrace();
                                sparseArray = null;
                            }
                            if (sparseArray == null || ((PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49)) == null) {
                                return;
                            }
                            if (this.a.o == null) {
                                this.a.o = new eu7(this.a.getPageContext(), this.a.p);
                                this.a.j.A0(this.a.o.G());
                                this.a.o.o(this.a.mIsLogin);
                            }
                            this.a.o.m();
                            this.a.o.p(sparseArray, this.a.d3(), (this.a.v3(sparseArray.get(R.id.obfuscated_res_0x7f091e4c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue() : false) && this.a.isLogin()) ? false : false, this.a.c.m0());
                        }
                    } else if (this.a.checkUpIsLogin()) {
                        this.a.j.O0();
                        this.a.j.t();
                        if (this.a.E != null) {
                            this.a.E.f0();
                        }
                    }
                } else if (this.a.checkUpIsLogin()) {
                    this.a.E3();
                    if (this.a.c == null || this.a.c.m0() == null || this.a.c.m0().l() == null || this.a.c.m0().l().getAuthor() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.c.A0()).param("fid", this.a.c.m0().l().getFid()).param("obj_locate", 5).param("uid", this.a.c.m0().l().getAuthor().getUserId()));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m0 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes3.dex */
        public class a implements nq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(m0 m0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    nq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements nq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m0 a;

            public b(m0 m0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = m0Var;
            }

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    nq4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public m0(NewSubPbActivity newSubPbActivity) {
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, hx4 hx4Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, hx4Var, writeData, antiData}) == null) {
                if (z && this.a.E != null && this.a.E.a() != null) {
                    this.a.E.a().o();
                    if (this.a.c.K0()) {
                        TiebaStatic.log(new StatisticItem("c10367").param("post_id", this.a.c.B()));
                    }
                }
                if (z) {
                    if (writeData != null) {
                        uu4.b(writeData.getContent(), "4");
                    }
                    this.a.S.n(null);
                    this.a.S.i(null);
                    this.a.S.k(false);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        qy4.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    this.a.S.i(postWriteCallBackData.getSensitiveWords());
                    this.a.S.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.a.S.a())) {
                        return;
                    }
                    this.a.Y = postWriteCallBackData;
                    if (this.a.E.x()) {
                        this.a.E.v(this.a.Y);
                    }
                    this.a.O2(true);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0466), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    nq4 nq4Var = new nq4(this.a.getActivity());
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        nq4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ced));
                    } else {
                        nq4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new a(this));
                    nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cef, new b(this));
                    nq4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && (replyPrivacyCheckController = this.a.U) != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
                this.a.j.o0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.j.i0();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (i == 2 || i == 1) {
                    this.a.j.v();
                    if (this.a.j0 != 2 && this.a.j0 != 1) {
                        this.a.j.V();
                    }
                }
                this.a.E.y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(NewSubPbActivity newSubPbActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.K) {
                this.a.j.T();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.I.c(this.a.G.getResources().getString(R.string.obfuscated_res_0x7f0f0b34));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.G.getResources().getString(R.string.obfuscated_res_0x7f0f0b30);
                    }
                    this.a.J3(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.H3();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (oi.isEmpty(errorString2)) {
                        errorString2 = this.a.G.getResources().getString(R.string.obfuscated_res_0x7f0f0b31);
                    }
                    this.a.I.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

        /* JADX WARN: Removed duplicated region for block: B:74:0x0181 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0182  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2;
            SparseArray<Object> sparseArray3;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            if (this.a.j != null && this.a.j.b0()) {
                return false;
            }
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null && this.a.t3(view2)) {
                if (view2 instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) view2;
                    this.a.k = tbImageView.getBdImage();
                    this.a.l = tbImageView.getUrl();
                    if (this.a.k == null || TextUtils.isEmpty(this.a.l)) {
                        return true;
                    }
                    if (view2.getTag(R.id.obfuscated_res_0x7f091e80) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091e80) instanceof TbRichTextImageInfo)) {
                        this.a.m = null;
                    } else {
                        this.a.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e80);
                    }
                } else if (view2 instanceof GifView) {
                    GifView gifView = (GifView) view2;
                    if (gifView.getBdImage() == null) {
                        return true;
                    }
                    this.a.k = gifView.getBdImage();
                    if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                        this.a.l = gifView.getBdImage().q();
                    }
                    if (view2.getTag(R.id.obfuscated_res_0x7f091e80) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091e80) instanceof TbRichTextImageInfo)) {
                        this.a.m = null;
                    } else {
                        this.a.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e80);
                    }
                } else if (view2 instanceof TbMemeImageView) {
                    TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                    if (tbMemeImageView.getBdImage() != null) {
                        this.a.k = tbMemeImageView.getBdImage();
                        if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                            this.a.l = tbMemeImageView.getBdImage().q();
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f091e80) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091e80) instanceof TbRichTextImageInfo)) {
                            this.a.m = null;
                        } else {
                            this.a.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e80);
                        }
                    }
                }
                if (view2.getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray3 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                    } catch (ClassCastException e2) {
                        e2.printStackTrace();
                    }
                } else if (!(view2.getParent().getParent() instanceof TbRichTextView)) {
                    this.a.j.I0(this.a.C0, this.a.k.t());
                } else {
                    try {
                        sparseArray3 = (SparseArray) ((TbRichTextView) view2.getParent().getParent()).getTag();
                    } catch (ClassCastException e3) {
                        e3.printStackTrace();
                    }
                }
                sparseArray2 = sparseArray3;
                if (sparseArray2 != null) {
                    return true;
                }
                this.a.n = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091e49);
                NewSubPbActivity newSubPbActivity = this.a;
                if (newSubPbActivity.n == null || newSubPbActivity.g == null) {
                    return true;
                }
                if (this.a.g != null) {
                    this.a.g.h(this.a.c.O0());
                }
                boolean z = this.a.g.e() && this.a.n.J() != null && this.a.n.J().equals(this.a.c.v0());
                if (this.a.o == null) {
                    this.a.o = new eu7(this.a.getPageContext(), this.a.p);
                    this.a.j.A0(this.a.o.G());
                    this.a.o.o(this.a.mIsLogin);
                }
                this.a.o.m();
                boolean z2 = this.a.v3(sparseArray2.get(R.id.obfuscated_res_0x7f091e4c) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue() : false) && this.a.isLogin();
                boolean z3 = (this.a.c.m0() == null || this.a.c.m0().l() == null || !this.a.c.m0().l().isBjh()) ? false : true;
                boolean booleanValue = sparseArray2.get(R.id.obfuscated_res_0x7f091e62) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091e62)).booleanValue() : false;
                if (z) {
                    this.a.o.A().setText(R.string.obfuscated_res_0x7f0f0fb8);
                } else {
                    this.a.o.A().setText(R.string.obfuscated_res_0x7f0f0a92);
                }
                if (booleanValue || z3) {
                    this.a.o.A().setVisibility(8);
                } else {
                    this.a.o.A().setVisibility(0);
                }
                if (this.a.t3(view2)) {
                    if (this.a.k != null && !this.a.k.t()) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e85, Boolean.TRUE);
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e85, Boolean.FALSE);
                    }
                    sparseArray2.put(R.id.obfuscated_res_0x7f091e84, Boolean.TRUE);
                } else {
                    sparseArray2.put(R.id.obfuscated_res_0x7f091e85, Boolean.FALSE);
                    sparseArray2.put(R.id.obfuscated_res_0x7f091e84, Boolean.FALSE);
                }
                hr7 m0 = this.a.c.m0();
                this.a.o.k(lw7.f(this.a.n));
                this.a.o.q(sparseArray2, this.a.d3(), z2, this.a.o0 && this.a.n.l0, m0);
                return true;
            }
            sparseArray2 = sparseArray;
            if (sparseArray2 != null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.K) {
                this.a.j.T();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.I.c(this.a.G.getResources().getString(R.string.obfuscated_res_0x7f0f14b2));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (oi.isEmpty(muteMessage)) {
                    muteMessage = this.a.G.getResources().getString(R.string.obfuscated_res_0x7f0f14b1);
                }
                this.a.I.b(muteMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
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

        /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            String str2;
            String str3;
            boolean z3;
            String str4;
            String str5;
            boolean z4;
            String str6;
            String str7;
            String str8;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view2.getTag(R.id.obfuscated_res_0x7f091e80) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091e80) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
                        hr7 m0 = this.a.c.m0();
                        TbRichText N3 = this.a.N3(str, i);
                        TbRichTextData tbRichTextData = (N3 == null || N3.B() == null) ? null : N3.B().get(this.a.b);
                        if (tbRichTextData == null) {
                            return;
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!tbRichTextData.F().H()) {
                            String V2 = this.a.V2(tbRichTextData);
                            arrayList.add(V2);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = this.a.a ? 17 : 18;
                            concurrentHashMap.put(V2, imageUrlData);
                            if (m0 != null) {
                                if (m0.d() != null) {
                                    str6 = m0.d().getName();
                                    str7 = m0.d().getId();
                                } else {
                                    str6 = null;
                                    str7 = null;
                                }
                                str8 = m0.l() != null ? m0.l().getId() : null;
                                z4 = true;
                            } else {
                                z4 = false;
                                str6 = null;
                                str7 = null;
                                str8 = null;
                            }
                            if (this.a.c.D0() != null) {
                                concurrentHashMap = this.a.c.D0();
                                z4 = this.a.c.H0();
                                arrayList = this.a.c.C0();
                            }
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(ListUtils.getItem(arrayList, 0));
                            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                            builder.y(arrayList2);
                            builder.A(str6);
                            builder.z(str7);
                            builder.P(str8);
                            builder.D(z4);
                            builder.K(arrayList.get(0));
                            builder.G(true);
                            builder.x(concurrentHashMap);
                            builder.I(true);
                            builder.L(false);
                            builder.H(false);
                            builder.O(this.a.c3());
                            builder.M(String.valueOf(N3.getPostId()));
                            builder.B(this.a.c.getFromForumId());
                            this.a.sendMessage(new CustomMessage(2010000, builder.w(this.a.getPageContext().getPageActivity())));
                            return;
                        }
                        this.a.B0 = false;
                        TbRichText Q = m0.i().Q();
                        int size = arrayList.size();
                        int Z2 = this.a.Z2(Q, N3, i, i, arrayList, concurrentHashMap);
                        int size2 = arrayList.size();
                        String str9 = size != size2 ? arrayList.get(size2 - 1) : "";
                        if (m0 != null) {
                            if (m0.d() != null) {
                                str5 = m0.d().getName();
                                str3 = m0.d().getId();
                            } else {
                                str5 = null;
                                str3 = null;
                            }
                            str2 = m0.l() != null ? m0.l().getId() : null;
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
                            Z2 += this.a.c.w0();
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(arrayList, Z2));
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.y(arrayList3);
                        builder2.A(str4);
                        builder2.z(str3);
                        builder2.P(str2);
                        builder2.D(z3);
                        builder2.K(str9);
                        builder2.G(true);
                        builder2.x(concurrentHashMap);
                        builder2.I(true);
                        builder2.L(false);
                        builder2.H(false);
                        builder2.O(this.a.c3());
                        builder2.M(String.valueOf(N3.getPostId()));
                        builder2.B(this.a.c.getFromForumId());
                        this.a.sendMessage(new CustomMessage(2010000, builder2.w(this.a.getPageContext().getPageActivity())));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e80);
                    boolean w = ((TbImageView) view2).w();
                    if (tbRichTextMemeInfo == null || tbRichTextMemeInfo.memeInfo == null) {
                        return;
                    }
                    this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ko8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.K) {
                ko8 ko8Var = (ko8) customResponsedMessage.getData();
                this.a.j.T();
                SparseArray<Object> sparseArray = (SparseArray) this.a.H;
                DataRes dataRes = ko8Var.a;
                if (ko8Var.c == 0 && dataRes != null) {
                    z = ng.e(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea0, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e9a, dataRes.mute_confirm);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea0, Boolean.FALSE);
                    z = false;
                }
                int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e5c) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e5c)).intValue() : 0;
                if (intValue == 0) {
                    this.a.I3(z, sparseArray);
                } else if (intValue == 1) {
                    this.a.j.k0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements pq4.c {
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

        @Override // com.repackage.pq4.c
        public void a(pq4 pq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pq4Var, i, view2) == null) {
                pq4Var.e();
                if (this.a.k == null || TextUtils.isEmpty(this.a.l)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.m == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.l));
                    } else {
                        k35.a aVar = new k35.a();
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
                        newSubPbActivity.f = new zu7(newSubPbActivity.getPageContext());
                    }
                    this.a.f.b(this.a.l, this.a.k.n());
                }
                this.a.k = null;
                this.a.l = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q0 implements ot4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public q0(NewSubPbActivity newSubPbActivity) {
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

        @Override // com.repackage.ot4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.c == null) {
                return;
            }
            this.a.c.T0();
        }
    }

    /* loaded from: classes3.dex */
    public class r implements am6.d {
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

        @Override // com.repackage.am6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
        @Override // com.repackage.am6.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                return;
            }
            NewSubPbActivity newSubPbActivity = this.a;
            if (newSubPbActivity.U != null && newSubPbActivity.c != null && this.a.c.k0() != null && !this.a.G(TbadkCoreApplication.getCurrentAccount())) {
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (!newSubPbActivity2.U.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.c.k0().replyPrivateFlag)) {
                    return;
                }
            }
            if (this.a.c != null && this.a.c.m0() != null && this.a.c.m0().i() != null) {
                PostData i = this.a.c.m0().i();
                if (i.Q() != null && i.s() != null) {
                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fd1), i.s().getName_show(), i.Q().toString());
                    this.a.E.a().A(new h05(45, 27, str));
                    if (!this.a.E.x()) {
                        this.a.E.v(null);
                        return;
                    }
                    this.a.j.O0();
                    this.a.j.t();
                    if (this.a.E != null) {
                        this.a.E.k0();
                        return;
                    }
                    return;
                }
            }
            str = null;
            this.a.E.a().A(new h05(45, 27, str));
            if (!this.a.E.x()) {
            }
        }

        @Override // com.repackage.am6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface r0 {
        void a(Object obj);
    }

    /* loaded from: classes3.dex */
    public class s implements TextWatcher {
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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.S == null) {
                return;
            }
            if (!this.a.S.e()) {
                this.a.O2(false);
            }
            this.a.S.l(false);
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

    /* loaded from: classes3.dex */
    public class t implements pq4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ NewSubPbActivity d;

        public t(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
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

        @Override // com.repackage.pq4.c
        public void a(pq4 pq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pq4Var, i, view2) == null) {
                if (i == 0) {
                    String str = this.a.get(R.id.obfuscated_res_0x7f091e9d) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091e9d) : "";
                    String str2 = this.a.get(R.id.obfuscated_res_0x7f091e9f) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091e9f) : "";
                    String str3 = this.a.get(R.id.obfuscated_res_0x7f091e9e) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091e9e) : "";
                    String str4 = this.a.get(R.id.obfuscated_res_0x7f091e9a) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091e9a) : "";
                    String str5 = this.a.get(R.id.obfuscated_res_0x7f091e9b) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091e9b) : "";
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, str4, this.d.K);
                    userMuteAddAndDelCustomMessage.setTag(this.d.K);
                    this.d.K3(this.b, userMuteAddAndDelCustomMessage, str4, str, str5);
                }
                pq4Var.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(NewSubPbActivity newSubPbActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pf5.a)) {
                pf5.a aVar = (pf5.a) customResponsedMessage.getData();
                pf5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.L = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w implements fg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.b0();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new GifView(this.a.getPageContext().getPageActivity()) : (GifView) invokeV.objValue;
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class x implements fg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

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
                    if (km4.c().g()) {
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
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
                boolean g = km4.c().g();
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class y implements fg<View> {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) ? view2 : (View) invokeL.objValue;
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
    public class z implements fg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

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
        this.u = null;
        this.w = null;
        this.x = null;
        this.F = false;
        this.J = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.Q = false;
        this.g0 = new k(this);
        this.j0 = 0;
        this.k0 = false;
        this.m0 = BdUniqueId.gen();
        this.o0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.p0 = true;
        this.s0 = new v(this);
        this.u0 = new g0(this);
        this.v0 = new l0(this, 2921481);
        this.w0 = new m0(this);
        this.x0 = new n0(this, 2001427);
        this.y0 = new o0(this, 2001428);
        this.z0 = new p0(this, 2001426);
        this.A0 = new q0(this);
        this.B0 = false;
        this.C0 = new q(this);
        this.D0 = new u(this, 2001332);
        this.E0 = new i0(this, 2016485);
    }

    @Override // com.repackage.sf5
    public eg<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.C == null) {
                this.C = new eg<>(new z(this), 15, 0);
            }
            return this.C;
        }
        return (eg) invokeV.objValue;
    }

    @Override // com.repackage.es7
    public xv7 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.W : (xv7) invokeV.objValue;
    }

    public final void A3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String q2 = ht4.k().q("bubble_link", "");
            if (StringUtils.isNull(q2)) {
                return;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return;
            }
            cl4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0529), q2 + "?props_id=" + str, true, true, true);
        }
    }

    public final void B3(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            if (this.c.G0()) {
                showToast(str);
            } else if (!pi.D()) {
                this.j.G0(R.string.obfuscated_res_0x7f0f0f93);
            } else if (i2 == 4) {
                tw7 tw7Var = this.j;
                tw7Var.H0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                tw7 tw7Var2 = this.j;
                tw7Var2.H0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.j.G0(R.string.obfuscated_res_0x7f0f0c51);
            }
        }
    }

    public final void C3(SparseArray<Object> sparseArray, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, sparseArray, z2) == null) || sparseArray == null) {
            return;
        }
        if (sparseArray.get(R.id.obfuscated_res_0x7f091e49) instanceof PostData) {
            D3((PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49), z2);
        } else {
            D3(null, z2);
        }
    }

    public final void D3(PostData postData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, postData, z2) == null) || P2()) {
            return;
        }
        if (postData != null) {
            if (postData.s() != null) {
                MetaData s2 = postData.s();
                this.E.W(s2.getUserId());
                this.E.b0(postData.J());
                boolean z3 = postData.l0;
                this.E.p(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fd1), postData.s().getName_show(), postData.Q() != null ? postData.Q().toString() : ""));
                if (z3) {
                    if (!z2) {
                        this.E.V(s2.getName_show(), s2.getPortrait());
                    }
                } else if (!z2) {
                    this.E.V(s2.getName_show(), s2.getPortrait());
                }
            }
            this.j.t();
        }
        if (this.Z) {
            X2(false);
        }
    }

    @Override // com.repackage.sf5
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final void E3() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
            if (P2()) {
                return;
            }
            if (booleanExtra) {
                if (this.U == null || (subPbModel = this.c) == null || subPbModel.k0() == null || G(TbadkCoreApplication.getCurrentAccount()) || this.U.checkPrivacyBeforeInvokeEditor(this.c.k0().replyPrivateFlag)) {
                    if (this.E.x()) {
                        this.E.v(null);
                        return;
                    }
                    this.j.O0();
                    this.j.t();
                    p25 p25Var = this.E;
                    if (p25Var != null) {
                        p25Var.k0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.X == null) {
                am6 am6Var = new am6(getPageContext());
                this.X = am6Var;
                am6Var.i(new r(this));
            }
            SubPbModel subPbModel2 = this.c;
            if (subPbModel2 == null || subPbModel2.m0() == null || this.c.m0().d() == null) {
                return;
            }
            this.X.g(this.c.m0().d().getId(), ng.g(this.c.A0(), 0L));
        }
    }

    public final void F3(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            lw7.d(this, getPageContext(), new j(this, sparseArray, i2, z2), new l(this));
        }
    }

    @Override // com.repackage.es7
    public boolean G(String str) {
        InterceptResult invokeL;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str) || (subPbModel = this.c) == null || subPbModel.m0() == null || this.c.m0().l() == null || this.c.m0().l().getAuthor() == null) {
                return false;
            }
            return str.equals(this.c.m0().l().getAuthor().getUserId());
        }
        return invokeL.booleanValue;
    }

    public final void G3(View view2, p25 p25Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, view2, p25Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new d(this, view2, p25Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0cea), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    @Override // com.repackage.sf5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.L = true;
        }
    }

    public final void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            nq4 nq4Var = new nq4(getPageContext().getPageActivity());
            nq4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b32));
            nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cef, new f0(this));
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new h0(this));
            nq4Var.create(this.G).show();
        }
    }

    public final void I3(boolean z2, SparseArray<Object> sparseArray) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z2, sparseArray) == null) {
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e9c) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9c) : "";
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue()) {
                String[] strArr = new String[1];
                if (z2) {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f14b0);
                } else {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f0b2f);
                }
                strArr[0] = string;
                pq4 pq4Var = new pq4(getPageContext().getPageActivity());
                pq4Var.k(R.string.obfuscated_res_0x7f0f0cfd);
                pq4Var.j(strArr, new t(this, sparseArray, z2, str));
                pq4Var.c(getPageContext());
                pq4Var.m();
            }
        }
    }

    @Override // com.repackage.sf5
    public void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
        }
    }

    public final void J3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (str == null) {
                str = "";
            }
            nq4 nq4Var = new nq4(this.G.getPageActivity());
            nq4Var.setMessage(str);
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0993, new e0(this));
            nq4Var.create(this.G).show();
        }
    }

    public final void K3(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.j.E0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            nq4 nq4Var = new nq4(this.G.getPageActivity());
            if (oi.isEmpty(str)) {
                nq4Var.setMessage(this.G.getResources().getString(R.string.obfuscated_res_0x7f0f0315, str3));
            } else {
                nq4Var.setMessage(str);
            }
            nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f041f, new c0(this, userMuteAddAndDelCustomMessage));
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new d0(this));
            nq4Var.create(this.G).show();
        }
    }

    public final void L3() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (subPbModel = this.c) == null || oi.isEmpty(subPbModel.A0())) {
            return;
        }
        wh4.w().P(vh4.X, ng.g(this.c.A0(), 0L));
    }

    @Override // com.repackage.sf5
    public eg<RelativeLayout> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            eg<RelativeLayout> egVar = new eg<>(new a0(this), 10, 0);
            this.D = egVar;
            return egVar;
        }
        return (eg) invokeV.objValue;
    }

    public void M3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.t0);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final TbRichText N3(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, str, i2)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null || str == null || i2 < 0) {
                return null;
            }
            hr7 m02 = this.c.m0();
            TbRichText Y2 = Y2(m02.i(), str, i2);
            if (Y2 != null || (Y2 = Y2(m02.i(), str, i2)) != null) {
            }
            return Y2;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // com.repackage.sf5
    public eg<ImageView> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.B == null) {
                this.B = new eg<>(new x(this), 8, 0);
            }
            return this.B;
        }
        return (eg) invokeV.objValue;
    }

    public void O2(boolean z2) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) || (editText = this.T) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.T.getSelectionEnd();
        SpannableStringBuilder f2 = this.S.f(this.T.getText());
        if (f2 != null) {
            this.S.l(true);
            this.T.setText(f2);
            if (z2 && this.S.b() >= 0) {
                this.T.requestFocus();
                this.T.setSelection(this.S.b());
            } else {
                this.T.setSelection(selectionEnd);
            }
            lv8 lv8Var = this.S;
            lv8Var.k(lv8Var.b() >= 0);
        }
    }

    @Override // com.repackage.sf5
    public eg<View> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.A == null) {
                this.A = new eg<>(new y(this), 8, 0);
            }
            return this.A;
        }
        return (eg) invokeV.objValue;
    }

    public final boolean P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return false;
            }
            return AntiHelper.d(getPageContext(), subPbModel.k0());
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.sf5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, str) == null) {
        }
    }

    public void Q2(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e9c) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9c) : "";
            this.j.E0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = ng.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = ng.g(str, 0L);
            this.H = sparseArray;
            BdUniqueId bdUniqueId = this.K;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    @Override // com.repackage.sf5
    public void R(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048603, this, context, str, z2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (s3(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                vz4 vz4Var = new vz4();
                vz4Var.a = str;
                vz4Var.b = 3;
                vz4Var.c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, vz4Var));
            }
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
        this.L = true;
    }

    public void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.E.y();
            } else if (StringUtils.isNull(this.c.y0())) {
            } else {
                if (this.j.M0() && pi.D()) {
                    this.j.s0();
                } else {
                    this.j.o0();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S2(AgreeData agreeData) {
        n75 currentVisiblePageExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.l0 == null) {
            this.l0 = new dt4();
        }
        if (this.n0 == null) {
            jh8 jh8Var = new jh8();
            this.n0 = jh8Var;
            jh8Var.a = this.m0;
        }
        en4 en4Var = new en4();
        en4Var.b = 12;
        en4Var.h = 9;
        en4Var.g = 3;
        if (b3() != null) {
            en4Var.f = b3().x0();
        }
        en4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                en4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l0.c(agreeData, i2, getUniqueId(), false);
                this.l0.d(agreeData, this.n0);
                if (b3() != null || b3().m0() == null) {
                }
                this.l0.b(this, en4Var, agreeData, b3().m0().l());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            en4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            en4Var.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
        if (currentVisiblePageExtra != null) {
        }
        this.l0.c(agreeData, i2, getUniqueId(), false);
        this.l0.d(agreeData, this.n0);
        if (b3() != null) {
        }
    }

    @Override // com.repackage.es7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return 0;
            }
            return subPbModel.E0();
        }
        return invokeV.intValue;
    }

    public final void T2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, view2) == null) || view2 == null || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e8c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8c)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e8a) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8a)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue() : false;
        if (booleanValue) {
            if (booleanValue3) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e5c, 1);
                Q2(sparseArray);
            } else {
                this.j.l0(view2);
            }
        } else if (booleanValue2) {
            this.j.j0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e4b), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e68)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue(), false);
        }
        sg.d(this.j.O(), getPageContext().getPageActivity());
    }

    public void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", tw7.u0);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.repackage.sf5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048609, this, context, str, str2) == null) {
        }
    }

    public final String V2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, tbRichTextData)) == null) {
            if (tbRichTextData == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(150);
            TbRichTextImageInfo F = tbRichTextData.F();
            if (F != null) {
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
                sb.append(oi.getUrlEncode(F.F()));
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void W2(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048611, this, bVar, z2) == null) || bVar == null) {
            return;
        }
        int i2 = 0;
        this.j.z(0, bVar.a, bVar.b, z2);
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                if (this.j.I() instanceof BdTypeListView) {
                    List<nn> data = ((BdTypeListView) this.j.I()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        while (i2 < data.size() && (!(data.get(i2) instanceof PostData) || !bVar.g.equals(((PostData) data.get(i2)).J()))) {
                            i2++;
                        }
                        if (i2 < data.size()) {
                            data.remove(i2);
                        }
                        this.j.d0();
                    }
                }
            } else if (i3 == 2) {
                this.c.i0(bVar.g);
                this.j.L0(this.c.m0(), this.c.E0(), this.c.D0() != null, false);
                if (this.c.P0()) {
                    this.c.b1(false);
                    this.j.s();
                    this.c.loadData();
                }
            }
            xp7 xp7Var = new xp7();
            xp7Var.b(bVar);
            xp7Var.c(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, xp7Var));
        }
    }

    public final void X2(boolean z2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        int i2;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) {
            Rect rect = new Rect();
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
                frameLayout.getWindowVisibleDisplayFrame(rect);
                if (z2) {
                    ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                    childAt.requestLayout();
                }
            }
            tw7 tw7Var = this.j;
            if (tw7Var == null || tw7Var.I() == null || (pbCommenFloorItemViewHolder = this.i0) == null || (i2 = pbCommenFloorItemViewHolder.X) == -1) {
                return;
            }
            int headerViewsCount = i2 + this.j.I().getHeaderViewsCount();
            if (this.i0.b() != null) {
                int height = this.i0.b().getHeight();
                int height2 = ((rect.height() - this.j.A()) - this.j.K()) - this.j.C();
                int i3 = height - height2;
                if (i3 > 0) {
                    this.j.I().post(new j0(this, headerViewsCount, i3));
                } else {
                    this.j.I().post(new k0(this, headerViewsCount, height2, height));
                }
            }
        }
    }

    @Override // com.repackage.sf5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, context, str) == null) {
        }
    }

    @Override // com.repackage.es7
    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null || this.c.m0().l() == null) {
                return null;
            }
            return this.c.m0().l().getForum_name();
        }
        return (String) invokeV.objValue;
    }

    public final TbRichText Y2(PostData postData, String str, int i2) {
        InterceptResult invokeLLI;
        TbRichText Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048615, this, postData, str, i2)) == null) {
            if (postData != null && (Q = postData.Q()) != null) {
                ArrayList<TbRichTextData> B = Q.B();
                int size = B.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (B.get(i4) != null && B.get(i4).getType() == 8) {
                        i3++;
                        if (B.get(i4).F().B().equals(str)) {
                            int h2 = (int) pi.h(TbadkCoreApplication.getInst());
                            int width = B.get(i4).F().getWidth() * h2;
                            int height = B.get(i4).F().getHeight() * h2;
                            if (width < 80 || height < 80 || width * height < 10000) {
                                return null;
                            }
                            this.b = i4;
                            return Q;
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

    @Override // com.repackage.sf5
    public eg<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.y;
        }
        return (eg) invokeV.objValue;
    }

    public final int Z2(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.B0 = true;
            }
            if (tbRichText != null && tbRichText.B() != null) {
                int size = tbRichText.B().size();
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    if (tbRichText.B().get(i5) != null && tbRichText.B().get(i5).getType() == 8) {
                        i4++;
                        int h2 = (int) pi.h(TbadkCoreApplication.getInst());
                        int width = tbRichText.B().get(i5).F().getWidth() * h2;
                        int height = tbRichText.B().get(i5).F().getHeight() * h2;
                        if (!(width < 80 || height < 80 || width * height < 10000) && tbRichText.B().get(i5).F().H()) {
                            TbRichTextData tbRichTextData = tbRichText.B().get(i5);
                            String V2 = V2(tbRichTextData);
                            arrayList.add(V2);
                            if (!TextUtils.isEmpty(V2) && tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                String B = F.B();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = B;
                                imageUrlData.urlType = this.a ? 17 : 18;
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(V2, imageUrlData);
                                }
                            }
                            if (!this.B0) {
                                i2++;
                            }
                        } else if (tbRichText == tbRichText2 && i4 <= i3) {
                            i2--;
                        }
                    }
                }
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public String a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!oi.isEmpty(this.h0)) {
                return this.h0;
            }
            String string = getResources().getString(tu7.b());
            this.h0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public SubPbModel b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.c : (SubPbModel) invokeV.objValue;
    }

    public final ThreadData c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null) {
                return null;
            }
            return this.c.m0().l();
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.M && !this.k0 && !this.N && !this.O) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            } else {
                super.closeAnimation();
            }
        }
    }

    public int d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.E0();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.sf5
    public eg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public final void e3(int i2, Intent intent) {
        u05 u05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048624, this, i2, intent) == null) {
            this.E.a().q();
            this.E.y();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.E.B(writeData);
                this.E.d0(pbEditorData.getVoiceModel());
                t05 n2 = this.E.a().n(6);
                if (n2 != null && (u05Var = n2.m) != null) {
                    u05Var.C(new h05(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.E.F();
                }
                this.j.V();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            if (this.M && !this.k0 && !this.N && !this.O) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, voiceModel)) == null) {
            View G = this.j.G();
            if (G == null || (findViewWithTag = G.findViewWithTag(voiceModel)) == null) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public void f3(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091e9d) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9d) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091e9f) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9f) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091e9e) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9e) : "";
            if (sparseArray.get(R.id.obfuscated_res_0x7f091e9a) instanceof String) {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9a);
            }
            String str5 = str4;
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091e9a) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9a) : "";
            String str7 = sparseArray.get(R.id.obfuscated_res_0x7f091e9b) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9b) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str5, 1, str6, this.K);
            userMuteAddAndDelCustomMessage.setTag(this.K);
            K3(z2, userMuteAddAndDelCustomMessage, str6, str2, str7);
        }
    }

    public void g3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
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
                x3(format);
                return;
            }
            this.d.a(str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.t75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? "a007" : (String) invokeV.objValue;
    }

    @Override // com.repackage.sf5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            tw7 tw7Var = this.j;
            if (tw7Var != null) {
                return tw7Var.I();
            }
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || oi.isEmpty(subPbModel.A0())) {
                return 0L;
            }
            return ng.g(this.c.A0(), 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public w75 getPageStayDurationItem() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            w75 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (subPbModel = this.c) != null) {
                if (subPbModel.m0() != null && this.c.m0().d() != null) {
                    pageStayDurationItem.t(ng.g(this.c.m0().d().getId(), 0L));
                }
                pageStayDurationItem.C(ng.g(this.c.A0(), 0L));
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
                pageStayDurationItem.w(ng.g(this.c.B(), 0L));
            }
            return pageStayDurationItem;
        }
        return (w75) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.t75
    public u75 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? new b0(this) : (u75) invokeV.objValue;
    }

    @Override // com.repackage.sf5
    public void h1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, context, str) == null) {
        }
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.t = new e(this);
            this.u = new f(this);
            this.w = new g(this);
            this.x = new h(this);
            this.v = new i(this);
        }
    }

    public void i3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bundle) == null) {
            SubPbModel subPbModel = new SubPbModel(getPageContext());
            this.c = subPbModel;
            subPbModel.a1(new c(this));
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.h = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.v);
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            uk4 b2 = uk4.b(this);
            this.g = b2;
            if (b2 != null) {
                b2.j(this.u);
            }
            if (bundle != null) {
                this.c.initWithBundle(bundle);
            } else {
                this.c.initWithIntent(getIntent());
            }
            setForceInterceptStimeStat(this.c.I0());
            this.c.e1(this.t);
            if (this.c.L0() && !this.c.R0()) {
                this.c.loadData();
            } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
                this.c.loadData();
            } else {
                this.c.S0();
            }
        }
    }

    public final void j3(boolean z2) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z2) == null) {
            p25 p25Var = (p25) new q25(z2).a(getActivity());
            this.E = p25Var;
            if (p25Var != null) {
                p25Var.N(getPageContext());
                this.E.a0(this.c);
                this.E.Q(this.w0);
                this.E.O(2);
                this.E.U(this.g0);
                this.E.M(this.u0);
                this.E.a().C(true);
                this.E.z(getPageContext());
                this.E.P(this.P);
            }
            tw7 tw7Var = this.j;
            if (tw7Var != null) {
                tw7Var.a0(this.E);
            }
            p25 p25Var2 = this.E;
            if (p25Var2 != null && (subPbModel = this.c) != null) {
                p25Var2.G(subPbModel.k0());
                this.E.y();
            }
            p25 p25Var3 = this.E;
            if (p25Var3 == null) {
                return;
            }
            p25Var3.t().k(a3());
            this.E.t().l(a3());
            EditText i2 = this.E.t().i();
            this.T = i2;
            i2.addTextChangedListener(new s(this));
        }
    }

    public final boolean k3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, bundle)) == null) {
            if (bundle != null) {
                this.O = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            } else {
                this.O = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            }
            return this.O;
        }
        return invokeL.booleanValue;
    }

    public final boolean l3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, bundle)) == null) {
            if (bundle != null) {
                this.M = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            } else {
                this.M = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            }
            return this.M;
        }
        return invokeL.booleanValue;
    }

    public final boolean m3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, bundle)) == null) {
            if (bundle != null) {
                this.Q = bundle.getBoolean("is_jump_from_video_middle");
            } else {
                this.Q = getIntent().getBooleanExtra("is_jump_from_video_middle", false);
            }
            return this.Q;
        }
        return invokeL.booleanValue;
    }

    public final boolean n3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, bundle)) == null) {
            if (bundle != null) {
                this.N = bundle.getBoolean("is_jump_from_video_tab", false);
                this.P = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                Intent intent = getIntent();
                this.N = intent.getBooleanExtra("is_jump_from_video_tab", false);
                this.P = intent.getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.N;
        }
        return invokeL.booleanValue;
    }

    public final int o3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, bundle)) == null) {
            if (bundle != null) {
                this.P = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                this.P = getIntent().getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.P;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048643, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25035) {
                e3(i3, intent);
            }
            p25 p25Var = this.E;
            if (p25Var != null) {
                p25Var.C(i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            p25 p25Var = this.E;
            if (p25Var != null && p25Var.a() != null && this.E.a().u()) {
                this.E.a().q();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.j.h0(i2);
            if (!this.N || UtilHelper.isFlyMeOs()) {
                return;
            }
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, bundle) == null) {
            l3(bundle);
            n3(bundle);
            o3(bundle);
            m3(bundle);
            k3(bundle);
            if (getIntent() != null) {
                this.k0 = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
                if (this.N) {
                    this.t0 = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
                }
            }
            super.onCreate(bundle);
            this.G = getPageContext();
            this.J = true;
            lv8 lv8Var = new lv8();
            this.S = lv8Var;
            lv8Var.h(R.color.cp_cont_h_alpha85);
            this.S.j(R.color.CAM_X0101);
            p3();
            h3();
            i3(bundle);
            q3();
            if (this.N && this.j.B() != null) {
                showLoadingView(this.j.B(), true, UtilHelper.getDimenPixelSize(R.dimen.tbds300));
            }
            if (this.N) {
                ((SubPbView) this.j.R()).setAnimTime(0);
                ((SubPbView) this.j.R()).setIsFromVideoTab(true);
            } else if (this.O) {
                setActivityBgTransparent();
                ((SubPbView) this.j.R()).setAnimTime(0);
                ((SubPbView) this.j.R()).setIsFromFoldComment(true);
            } else {
                ((SubPbView) this.j.R()).setAnimTime(300);
                ((SubPbView) this.j.R()).setIsFromVideoTab(false);
            }
            ((SubPbView) this.j.R()).h();
            j3(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.j.r(this.k0);
            lt4 lt4Var = new lt4();
            this.I = lt4Var;
            lt4Var.a = 1000L;
            registerListener(this.z0);
            registerListener(this.x0);
            registerListener(this.y0);
            registerListener(this.v0);
            this.K = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.K;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.K;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.U = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new a(this));
            rw7 rw7Var = new rw7(this);
            this.d = rw7Var;
            rw7Var.b(getUniqueId());
            this.W = new xv7(this);
            this.q0 = new io8(getPageContext(), getUniqueId());
            if (this.r0 == null) {
                if (this.Q) {
                    this.r0 = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.r0 = new TiePlusEventController(this, TiePlusStat.Locate.PB_COMMENT);
                }
                this.r0.l(this.s0);
            }
            py4.b(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.V));
            this.c.cancelLoadData();
            this.c.destory();
            this.h.cancelLoadData();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            this.j.v();
            this.j.e0();
            MessageManager.getInstance().unRegisterListener(this.x0);
            MessageManager.getInstance().unRegisterListener(this.y0);
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().unRegisterListener(this.K);
            io8 io8Var = this.q0;
            if (io8Var != null) {
                io8Var.l();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.U;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            this.G = null;
            this.I = null;
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            this.Z = z2;
            X2(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.F = true;
            super.onPause();
            TiePlusEventController tiePlusEventController = this.r0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            wh4.w().E();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.D0);
            this.j.f0();
            if (this.N || this.O) {
                M3(false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.repackage.g9
    public void onPreLoad(rn rnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, rnVar) == null) {
            PreLoadImageHelper.load(rnVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(rnVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            this.F = false;
            super.onResume();
            TiePlusEventController tiePlusEventController = this.r0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            L3();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.D0);
            this.j.g0();
            if (this.N || this.O) {
                M3(true);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null || (subPbModel = this.c) == null) {
                return;
            }
            subPbModel.Z0(bundle);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            if (this.j.M0() && pi.D()) {
                this.c.loadData();
            } else {
                this.j.o0();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            this.E.E();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z2) == null) {
            super.onUserChanged(z2);
            eu7 eu7Var = this.o;
            if (eu7Var != null) {
                eu7Var.o(z2);
            }
        }
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            registerListener(this.E0);
            this.p = new m(this);
            this.q = new n(this);
            this.r = new o(this);
            this.s = new p(this);
        }
    }

    public void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            tw7 tw7Var = new tw7(this, this.p);
            this.j = tw7Var;
            tw7Var.t0(this.c);
            this.j.z0(getUniqueId());
            setContentView(this.j.R(), new FrameLayout.LayoutParams(-1, -1));
            this.j.x0(this.q);
            this.j.y0(this);
            this.j.u0(this.s);
            this.j.v0(this.r);
            this.j.w0(new b(this));
            this.j.p0(this.w);
            this.j.n0(this.x);
            this.j.r0(this.A0);
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.L0() && !this.c.Q0()) {
                this.j.F().setVisibility(8);
            } else {
                this.j.F().setVisibility(0);
            }
            SubPbModel subPbModel2 = this.c;
            if (subPbModel2 == null || subPbModel2.L0()) {
                return;
            }
            this.j.q0(false);
        }
    }

    public boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.L0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s3(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                return false;
            }
            this.L = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return s3(oi.getUrlDecode(str2));
            }
            String str3 = paramPair.get(F0);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return invokeL.booleanValue;
    }

    public boolean t3(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.i : (VoiceManager) invokeV.objValue;
    }

    public boolean u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.F : invokeV.booleanValue;
    }

    @Override // com.repackage.es7
    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null || this.c.m0().l() == null) {
                return false;
            }
            return !this.c.m0().l().isMutiForumThread();
        }
        return invokeV.booleanValue;
    }

    public final boolean v3(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048666, this, z2)) == null) {
            if (this.c == null) {
                return false;
            }
            return ((d3() != 0) || this.c.m0() == null || this.c.m0().l() == null || this.c.m0().l().getAuthor() == null || this.c.m0().l().isUgcThreadType() || TextUtils.equals(this.c.m0().l().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public boolean w3(@Nullable ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, threadData)) == null) ? (threadData == null || !threadData.isVideoThreadType() || threadData.getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.sf5
    public eg<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (this.z == null) {
                this.z = new eg<>(new w(this), 20, 0);
            }
            return this.z;
        }
        return (eg) invokeV.objValue;
    }

    public final void x3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void y3(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49)) == null) {
                return;
            }
            z3(postData);
        }
    }

    @Override // com.repackage.sf5
    public eg<TiebaPlusRecommendCard> z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public void z3(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048672, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (this.c.O0() && postData.J() != null && postData.J().equals(this.c.v0())) {
            z2 = true;
        }
        MarkData u0 = this.c.u0(postData);
        if (u0 == null) {
            return;
        }
        this.j.v();
        uk4 uk4Var = this.g;
        if (uk4Var != null) {
            uk4Var.i(u0);
            if (!z2) {
                this.g.a();
            } else {
                this.g.d();
            }
        }
    }
}
