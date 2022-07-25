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
import com.repackage.a95;
import com.repackage.an4;
import com.repackage.c9;
import com.repackage.d9;
import com.repackage.dp8;
import com.repackage.dr4;
import com.repackage.du4;
import com.repackage.eg;
import com.repackage.ei8;
import com.repackage.ep8;
import com.repackage.fg;
import com.repackage.fr4;
import com.repackage.fx7;
import com.repackage.gp8;
import com.repackage.gu4;
import com.repackage.gy4;
import com.repackage.k15;
import com.repackage.kl4;
import com.repackage.l35;
import com.repackage.li4;
import com.repackage.lv7;
import com.repackage.lw8;
import com.repackage.lx7;
import com.repackage.m35;
import com.repackage.mi4;
import com.repackage.n45;
import com.repackage.ng;
import com.repackage.ng5;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.nx7;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.pq7;
import com.repackage.pz4;
import com.repackage.q85;
import com.repackage.qg;
import com.repackage.qz4;
import com.repackage.rn;
import com.repackage.rw7;
import com.repackage.rx7;
import com.repackage.s35;
import com.repackage.sg;
import com.repackage.sg5;
import com.repackage.sl4;
import com.repackage.sv7;
import com.repackage.t35;
import com.repackage.tt7;
import com.repackage.tv4;
import com.repackage.tw7;
import com.repackage.un4;
import com.repackage.ut4;
import com.repackage.v15;
import com.repackage.vg5;
import com.repackage.w15;
import com.repackage.ws7;
import com.repackage.wu7;
import com.repackage.x05;
import com.repackage.x85;
import com.repackage.xm6;
import com.repackage.ym;
import com.repackage.yt4;
import com.repackage.z85;
import com.repackage.zr7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes3.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.j, vg5, BdListView.p, ws7<NewSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String F0 = "tbgametype";
    public transient /* synthetic */ FieldHolder $fh;
    public eg<View> A;
    public final gu4.g A0;
    public eg<ImageView> B;
    public boolean B0;
    public eg<LinearLayout> C;
    public final fr4.c C0;
    public eg<RelativeLayout> D;
    public CustomMessageListener D0;
    public s35 E;
    public CustomMessageListener E0;
    public boolean F;
    public d9 G;
    public Object H;
    public du4 I;
    public boolean J;
    public BdUniqueId K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public boolean Q;
    public boolean R;
    public lw8 S;
    public EditText T;
    public ReplyPrivacyCheckController U;
    public pq7<zr7> V;
    public rw7 W;
    public xm6 X;
    public PostWriteCallBackData Y;
    public boolean Z;
    public boolean a;
    public m35 a0;
    public int b;
    public String b0;
    public SubPbModel c;
    public PbCommenFloorItemViewHolder c0;
    public lx7 d;
    public int d0;
    public PermissionJudgePolicy e;
    public boolean e0;
    public sv7 f;
    public ut4 f0;
    public kl4 g;
    public BdUniqueId g0;
    public ForumManageModel h;
    public ei8 h0;
    public VoiceManager i;
    public boolean i0;
    public nx7 j;
    public boolean j0;
    public ym k;
    public String l;
    public TbRichTextMemeInfo m;
    public PostData n;
    public wu7 o;
    public View.OnClickListener p;
    public AbsListView.OnScrollListener q;
    public ep8 q0;
    public View.OnLongClickListener r;
    @Nullable
    public TiePlusEventController r0;
    public TbRichTextView.y s;
    @NonNull
    public TiePlusEventController.f s0;
    public SubPbModel.b t;
    public BdUniqueId t0;
    public kl4.a u;
    public l35 u0;
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
    public class b0 extends x85 {
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

        @Override // com.repackage.x85
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a95.b().c() : invokeV.intValue;
        }

        @Override // com.repackage.x85
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
    public class c0 implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.b.j.E0();
                MessageManager.getInstance().sendMessage(this.a);
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ s35 b;
        public final /* synthetic */ NewSubPbActivity c;

        public d(NewSubPbActivity newSubPbActivity, View view2, s35 s35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, view2, s35Var};
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
            this.b = s35Var;
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
    public class d0 implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
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
            public final /* synthetic */ zr7 a;
            public final /* synthetic */ e b;

            public a(e eVar, zr7 zr7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, zr7Var};
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
                this.a = zr7Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.j0 = false;
                    this.b.a.F3(this.a.i(), false);
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
        public void a(boolean z, int i, String str, zr7 zr7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, zr7Var}) == null) || this.a.j == null) {
                return;
            }
            this.a.j.o0();
            if (this.a.N && this.a.j.B() != null) {
                NewSubPbActivity newSubPbActivity = this.a;
                newSubPbActivity.hideLoadingView(newSubPbActivity.j.B());
            }
            if (!z) {
                this.a.D3(i, str);
                return;
            }
            this.a.j.U();
            if (zr7Var != null) {
                if (zr7Var.i() != null || this.a.c != null) {
                    zr7Var.i().H0(this.a.c.A0());
                }
                if (this.a.j != null) {
                    this.a.l3(zr7Var.l() != null && zr7Var.l().isBjh());
                    if (this.a.E != null && this.a.E.a() != null) {
                        this.a.E.a().w(TbadkCoreApplication.getInst().getSkinType());
                    }
                    this.a.j.L0(zr7Var, this.a.c.F0(), this.a.c.E0() != null, this.a.J);
                    if (this.a.J) {
                        this.a.j.I().setSelectionFromTop(this.a.j.I().getHeaderViewsCount() + 1, -pi.f(this.a, R.dimen.tbds18));
                        this.a.T2();
                        this.a.J = false;
                    }
                }
                if (this.a.E != null) {
                    this.a.E.G(zr7Var.a());
                    this.a.E.c0(zr7Var.l());
                    if (this.a.getIntent() != null && this.a.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && this.a.j0) {
                        qg.a().postDelayed(new a(this, zr7Var), 200L);
                    }
                }
                if (this.a.V == null) {
                    this.a.V = new pq7();
                }
                this.a.V.b(zr7Var);
                this.a.V.c(0);
                NewSubPbActivity newSubPbActivity2 = this.a;
                newSubPbActivity2.U.setLikeUserData(newSubPbActivity2.c.m0());
            }
            String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || this.a.R) {
                return;
            }
            this.a.R = true;
            NewSubPbActivity newSubPbActivity3 = this.a;
            newSubPbActivity3.I3(newSubPbActivity3.j.P(), this.a.E, stringExtra);
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements kl4.a {
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

        @Override // com.repackage.kl4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.g != null) {
                        this.a.g.h(z2);
                    }
                    MarkData f = this.a.g.f();
                    pq7 pq7Var = new pq7();
                    pq7Var.c(2);
                    if (z2) {
                        pq7Var.b(f);
                        if (this.a.g != null) {
                            if (f != null) {
                                this.a.c.d1(true);
                                this.a.c.e1(this.a.c.C());
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
                        pq7Var.b(null);
                        this.a.c.d1(false);
                        this.a.c.e1(null);
                        NewSubPbActivity newSubPbActivity2 = this.a;
                        newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f9c));
                        if (this.a.j != null) {
                            this.a.j.P0(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, pq7Var));
                    return;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f1482));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    dr4Var.dismiss();
                    ((TbPageContext) this.a.G).showToast(R.string.obfuscated_res_0x7f0f06fd);
                    return;
                }
                TiebaStatic.log("c10025");
                dr4Var.dismiss();
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
                String valueOf = (this.a.c.n0() == null || this.a.c.n0().l() == null || this.a.c.n0().l().getAuthor() == null) ? "" : String.valueOf(this.a.c.n0().l().getAuthor().getUserId());
                String valueOf2 = objArr.length > 1 ? String.valueOf(objArr[1]) : "";
                String valueOf3 = objArr.length > 2 ? String.valueOf(objArr[2]) : "";
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.c.n0().d().getId(), this.a.c.n0().d().getName(), this.a.c.n0().l().getId(), valueOf, valueOf2, objArr.length > 3 ? String.valueOf(objArr[3]) : "", valueOf3, objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g0 implements l35 {
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

        @Override // com.repackage.l35
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
                    this.a.Q2(true);
                    return true;
                }
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (newSubPbActivity2.U == null || newSubPbActivity2.c == null || this.a.c.l0() == null || this.a.G(TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                return !newSubPbActivity3.U.checkPrivacyBeforeSend(newSubPbActivity3.c.l0().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR);
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
                    if (this.a.h.T() || objArr == null || objArr.length < 4) {
                        return;
                    }
                    String valueOf = String.valueOf(objArr[0]);
                    int e = ng.e(String.valueOf(objArr[1]), 0);
                    boolean b = ng.b(String.valueOf(objArr[2]), false);
                    int e2 = ng.e(String.valueOf(objArr[3]), 0);
                    if (this.a.c == null || this.a.c.n0() == null || this.a.c.n0().d() == null || this.a.c.n0().l() == null) {
                        return;
                    }
                    if (objArr.length > 4) {
                        this.a.h.V(String.valueOf(objArr[4]));
                    }
                    this.a.h.W(this.a.c.n0().d().getId(), this.a.c.n0().d().getName(), this.a.c.n0().l().getId(), valueOf, e2, e, b, this.a.c.n0().l().getBaijiahaoData(), false);
                    return;
                }
                TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
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
                        this.a.Y2(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
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
                if (this.a.c.n0() == null || this.a.c.n0().i() == null || this.a.c.n0().i().s() == null || !currentAccount.equals(this.a.c.n0().i().s().getUserId()) || this.a.c.n0().i().s().getPendantData() == null) {
                    return;
                }
                this.a.c.n0().i().s().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.a.c.n0().i().s().getPendantData().setPropsId(userPendantData.getPropsId());
                this.a.j.y(this.a.c.n0(), this.a.c.n0().i(), this.a.c.n0().e(), this.a.c.n0().f(), this.a.c.F0(), this.a.c.E0() != null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                if (dr4Var != null) {
                    dr4Var.dismiss();
                }
                if (this.d.x != null) {
                    this.d.x.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091ef3), Integer.valueOf(this.b), Boolean.valueOf(this.c), this.a.get(R.id.obfuscated_res_0x7f091ef5)});
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
    public class k implements m35 {
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

        @Override // com.repackage.m35
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
    public class l implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.c != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.c.B0())) {
                if (this.a.S != null) {
                    this.a.S.n(null);
                    this.a.S.i(null);
                    this.a.S.k(false);
                }
                if (this.a.E != null) {
                    this.a.E.q();
                    this.a.E.H();
                }
                this.a.c.L();
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
            public final /* synthetic */ tw7 a;
            public final /* synthetic */ PostData b;
            public final /* synthetic */ m c;

            public a(m mVar, tw7 tw7Var, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, tw7Var, postData};
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
                this.a = tw7Var;
                this.b = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    tt7 tt7Var = new tt7(new ng5());
                    tt7Var.j(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
                    tt7Var.o(TbConfig.getPostLineSpace(), 1.0f);
                    this.a.b.a(null, this.c.a.c.n0().l(), this.b, tt7Var);
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
                    String str2 = view2.getTag(R.id.obfuscated_res_0x7f091f41) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091f41) : null;
                    String str3 = view2.getTag(R.id.obfuscated_res_0x7f091f49) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091f49) : null;
                    String str4 = view2.getTag(R.id.obfuscated_res_0x7f091f4b) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f091f4b) : null;
                    if (str4 != null) {
                        if (this.a.checkUpIsLogin()) {
                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str4});
                        }
                    } else if (str2 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), str2, str3, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                    }
                } else if (view2 == this.a.j.P()) {
                    if (this.a.P2() && this.a.checkUpIsLogin()) {
                        this.a.G3();
                        if (this.a.c == null || this.a.c.n0() == null || this.a.c.n0().l() == null || this.a.c.n0().l().getAuthor() == null) {
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.c.B0()).param("fid", this.a.c.n0().l().getFid()).param("obj_locate", 5).param("uid", this.a.c.n0().l().getAuthor().getUserId()));
                    }
                } else if (view2 != this.a.j.M()) {
                    if (view2 == this.a.j.N()) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.j.O0();
                            this.a.j.t();
                            if (this.a.E != null) {
                                this.a.E.h0();
                            }
                        }
                    } else if (view2.getId() != R.id.obfuscated_res_0x7f091705) {
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
                            if (!((this.a.c.n0() == null || this.a.c.n0().l() == null) ? false : ThreadCardUtils.isUgcThreadType(this.a.c.n0().l().getBaijiahaoData()))) {
                                if (this.a.c == null || this.a.c.n0() == null) {
                                    return;
                                }
                                if (this.a.y3(this.a.c.n0().l())) {
                                    VideoItemData videoItemData = new VideoItemData();
                                    videoItemData.buildWithThreadData(this.a.c.n0().l());
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoPlayActivityConfig(this.a.getActivity(), Arrays.asList(videoItemData), 0, null, "frs")));
                                    return;
                                }
                                PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.getActivity()).createNormalCfg(this.a.c.B0(), this.a.c.C(), "");
                                if (!StringUtils.isNull(this.a.c.getFromForumId())) {
                                    createNormalCfg.setForumId(this.a.c.getFromForumId());
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                return;
                            }
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.a.getActivity()).createNormalCfg(this.a.c.B0(), null, "");
                            if (!StringUtils.isNull(this.a.c.getFromForumId())) {
                                createNormalCfg2.setForumId(this.a.c.getFromForumId());
                            }
                            if (this.a.c.n0() != null && this.a.c.n0().l() != null) {
                                createNormalCfg2.setBjhData(this.a.c.n0().l().getBaijiahaoData());
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
                        } else if (this.a.j.L() == null || view2 != this.a.j.L().A()) {
                            if (this.a.j.L() == null || view2 != this.a.j.L().u()) {
                                if (this.a.j.L() == null || view2 != this.a.j.L().z()) {
                                    if (this.a.j.L() == null || view2 != this.a.j.L().D()) {
                                        if (this.a.j.L() == null || view2 != this.a.j.L().t()) {
                                            if (view2 != this.a.j.G() && view2 != this.a.j.Q()) {
                                                if (view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                    this.a.c0 = (PbCommenFloorItemViewHolder) view2.getTag();
                                                    if (this.a.P2() && ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                        if (this.a.L) {
                                                            this.a.L = false;
                                                            return;
                                                        }
                                                        NewSubPbActivity newSubPbActivity = this.a;
                                                        if (newSubPbActivity.U != null && newSubPbActivity.c != null && this.a.c.l0() != null && !this.a.G(TbadkCoreApplication.getCurrentAccount())) {
                                                            NewSubPbActivity newSubPbActivity2 = this.a;
                                                            if (!newSubPbActivity2.U.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.c.l0().replyPrivateFlag)) {
                                                                return;
                                                            }
                                                        }
                                                        SparseArray sparseArray3 = (SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091f04);
                                                        if (sparseArray3 == null) {
                                                            return;
                                                        }
                                                        if ((view2.getTag(R.id.obfuscated_res_0x7f091f38) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f091f38) == Boolean.TRUE) {
                                                            r4 = true;
                                                        }
                                                        this.a.E3(sparseArray3, r4);
                                                        if (sparseArray3.get(R.id.obfuscated_res_0x7f091ef1) instanceof PostData) {
                                                            PostData postData2 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091ef1);
                                                            rx7.a(this.a.c != null ? this.a.c.B0() : "", postData2.s() == null ? "" : postData2.s().getUserId(), postData2.J());
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f09192e || view2.getId() == R.id.obfuscated_res_0x7f091701 || (this.a.o != null && view2 == this.a.o.C())) {
                                                    if (this.a.P2() && this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                        if ((sparseArray4.get(R.id.obfuscated_res_0x7f091f0d) instanceof PostData) && (postData = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f091f0d)) != null) {
                                                            if (this.a.c != null) {
                                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.c.C0()).param("fid", this.a.c.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.J()).param("obj_source", 1).param("obj_type", 3));
                                                            }
                                                            this.a.F3(postData, (view2.getTag(R.id.obfuscated_res_0x7f091f38) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f091f38) == Boolean.TRUE);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } else if (this.a.o == null || view2 != this.a.o.D()) {
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
                                                                                            if (this.a.P2() && this.a.E != null && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                                                                                                this.a.E.f0();
                                                                                                this.a.W2();
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                        int id = view2.getId();
                                                                                        if (id == R.id.obfuscated_res_0x7f091730) {
                                                                                            if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                                                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f132a);
                                                                                                String q = yt4.k().q("tail_link", "");
                                                                                                if (StringUtils.isNull(q)) {
                                                                                                    return;
                                                                                                }
                                                                                                TiebaStatic.log("c10056");
                                                                                                sl4.s(view2.getContext(), string, q, true, true, true);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else if (id == R.id.obfuscated_res_0x7f091af1 && (view2.getTag() instanceof SparseArray)) {
                                                                                            Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091ef1);
                                                                                            if (obj instanceof PostData) {
                                                                                                PostData postData3 = (PostData) obj;
                                                                                                if (postData3.getType() == PostData.C0 || TextUtils.isEmpty(postData3.t()) || !an4.c().g()) {
                                                                                                    return;
                                                                                                }
                                                                                                this.a.C3(postData3.J());
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    } else if (view2.getTag() instanceof SparseArray) {
                                                                                        SparseArray sparseArray5 = (SparseArray) view2.getTag();
                                                                                        if (sparseArray5.get(R.id.obfuscated_res_0x7f091f0d) instanceof PostData) {
                                                                                            PostData postData4 = (PostData) sparseArray5.get(R.id.obfuscated_res_0x7f091f0d);
                                                                                            tw7 tw7Var = new tw7(this.a.getPageContext());
                                                                                            if (postData4 != null) {
                                                                                                qg.a().postDelayed(new a(this, tw7Var, postData4), 100L);
                                                                                                String id2 = this.a.c.n0().l().getId();
                                                                                                if (StringUtils.isNull(id2) || "0".equals(id2)) {
                                                                                                    id2 = this.a.c.n0().l().getNid();
                                                                                                }
                                                                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", id2).param("fid", this.a.c.n0().l().getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.J()).param("obj_source", 1).param("obj_type", 4));
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (!ni.z()) {
                                                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                                                                    return;
                                                                                } else if (!ViewHelper.checkUpIsLogin(this.a.getActivity()) || (c = dp8.c(view2)) == null || this.a.q0 == null) {
                                                                                    return;
                                                                                } else {
                                                                                    this.a.q0.n(ng.g(c, 0L));
                                                                                    return;
                                                                                }
                                                                            } else if (!ni.z()) {
                                                                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                                                                return;
                                                                            } else {
                                                                                SparseArray<Object> sparseArray6 = (SparseArray) view2.getTag();
                                                                                if (sparseArray6 == null) {
                                                                                    return;
                                                                                }
                                                                                boolean booleanValue = ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f091f34)).booleanValue();
                                                                                boolean booleanValue2 = ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f091f32)).booleanValue();
                                                                                boolean booleanValue3 = ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f091f48)).booleanValue();
                                                                                r4 = sparseArray6.get(R.id.obfuscated_res_0x7f091f09) instanceof Boolean ? ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f091f09)).booleanValue() : false;
                                                                                if (!booleanValue) {
                                                                                    if (booleanValue2) {
                                                                                        this.a.j.j0(((Integer) sparseArray6.get(R.id.obfuscated_res_0x7f091ef5)).intValue(), (String) sparseArray6.get(R.id.obfuscated_res_0x7f091ef3), ((Integer) sparseArray6.get(R.id.obfuscated_res_0x7f091f10)).intValue(), ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f091ef4)).booleanValue(), false);
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else if (!booleanValue3) {
                                                                                    if (r4) {
                                                                                        sparseArray6.put(R.id.obfuscated_res_0x7f091eed, 2);
                                                                                    }
                                                                                    this.a.j.l0(view2);
                                                                                    return;
                                                                                } else {
                                                                                    sparseArray6.put(R.id.obfuscated_res_0x7f091f04, 1);
                                                                                    sparseArray6.put(R.id.obfuscated_res_0x7f091eed, 2);
                                                                                    this.a.S2(sparseArray6);
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (this.a.checkUpIsLogin() && (sparseArray2 = (SparseArray) view2.getTag()) != null) {
                                                                            PostData postData5 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091ef1);
                                                                            if (postData5.p() == null) {
                                                                                return;
                                                                            }
                                                                            this.a.U2(postData5.p());
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
                                                                            newSubPbActivity3.f = new sv7(newSubPbActivity3.getPageContext());
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
                                                                        n45.a aVar = new n45.a();
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
                                                                postData6.r0();
                                                                this.a.n = null;
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        SparseArray sparseArray7 = (SparseArray) view2.getTag();
                                                        if (sparseArray7 != null && (sparseArray7.get(R.id.obfuscated_res_0x7f091ef5) instanceof Integer) && (sparseArray7.get(R.id.obfuscated_res_0x7f091ef3) instanceof String) && (sparseArray7.get(R.id.obfuscated_res_0x7f091f10) instanceof Integer) && (sparseArray7.get(R.id.obfuscated_res_0x7f091ef4) instanceof Boolean)) {
                                                            boolean booleanValue4 = ((Boolean) sparseArray7.get(R.id.obfuscated_res_0x7f091ef4)).booleanValue();
                                                            int intValue = ((Integer) sparseArray7.get(R.id.obfuscated_res_0x7f091f10)).intValue();
                                                            boolean booleanValue5 = ((Boolean) sparseArray7.get(R.id.obfuscated_res_0x7f091f05)).booleanValue();
                                                            boolean G = this.a.G(TbadkCoreApplication.getCurrentAccount());
                                                            if (G) {
                                                                if (!booleanValue5) {
                                                                    this.a.H3(sparseArray7, intValue, booleanValue4);
                                                                    return;
                                                                } else {
                                                                    this.a.j.j0(((Integer) sparseArray7.get(R.id.obfuscated_res_0x7f091ef5)).intValue(), (String) sparseArray7.get(R.id.obfuscated_res_0x7f091ef3), intValue, booleanValue4, G);
                                                                    return;
                                                                }
                                                            } else if (booleanValue4 && !booleanValue5) {
                                                                this.a.H3(sparseArray7, intValue, booleanValue4);
                                                                return;
                                                            } else {
                                                                this.a.j.j0(((Integer) sparseArray7.get(R.id.obfuscated_res_0x7f091ef5)).intValue(), (String) sparseArray7.get(R.id.obfuscated_res_0x7f091ef3), intValue, booleanValue4, G);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (this.a.checkUpIsLogin()) {
                                                        this.a.A3(view2);
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (!ni.z()) {
                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                                    return;
                                                } else {
                                                    Object tag = view2.getTag();
                                                    if (tag instanceof String) {
                                                        this.a.i3((String) tag);
                                                        return;
                                                    } else if (tag instanceof SparseArray) {
                                                        SparseArray<Object> sparseArray8 = (SparseArray) tag;
                                                        if ((sparseArray8.get(R.id.obfuscated_res_0x7f091f48) instanceof Boolean) && ((Boolean) sparseArray8.get(R.id.obfuscated_res_0x7f091f48)).booleanValue()) {
                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091f04, 0);
                                                            sparseArray8.put(R.id.obfuscated_res_0x7f091eed, 2);
                                                            this.a.S2(sparseArray8);
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
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
                                            if (sparseArray9.get(R.id.obfuscated_res_0x7f091ef1) instanceof PostData) {
                                                ((PostData) sparseArray9.get(R.id.obfuscated_res_0x7f091ef1)).r0();
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                    if (!ni.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                        return;
                                    }
                                    Object tag2 = view2.getTag();
                                    this.a.j.v();
                                    if (tag2 instanceof String) {
                                        String str5 = (String) tag2;
                                        if (this.a.checkUpIsLogin()) {
                                            this.a.i3(str5);
                                            return;
                                        }
                                        return;
                                    } else if (tag2 instanceof SparseArray) {
                                        SparseArray<Object> sparseArray10 = (SparseArray) tag2;
                                        if ((sparseArray10.get(R.id.obfuscated_res_0x7f091f48) instanceof Boolean) && ((Boolean) sparseArray10.get(R.id.obfuscated_res_0x7f091f48)).booleanValue()) {
                                            sparseArray10.put(R.id.obfuscated_res_0x7f091f04, 0);
                                            sparseArray10.put(R.id.obfuscated_res_0x7f091eed, 2);
                                            this.a.S2(sparseArray10);
                                            return;
                                        }
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (ni.z()) {
                                    this.a.j.v();
                                    if (this.a.checkUpIsLogin()) {
                                        this.a.V2(view2);
                                        return;
                                    }
                                    return;
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                                    return;
                                }
                            }
                            this.a.j.v();
                            SparseArray sparseArray11 = (SparseArray) view2.getTag();
                            if (sparseArray11 == null) {
                                return;
                            }
                            this.a.j.j0(((Integer) sparseArray11.get(R.id.obfuscated_res_0x7f091ef5)).intValue(), (String) sparseArray11.get(R.id.obfuscated_res_0x7f091ef3), ((Integer) sparseArray11.get(R.id.obfuscated_res_0x7f091f10)).intValue(), ((Boolean) sparseArray11.get(R.id.obfuscated_res_0x7f091ef4)).booleanValue(), false);
                        } else {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                            this.a.j.v();
                            if (this.a.checkUpIsLogin() && this.a.c.n0() != null) {
                                NewSubPbActivity newSubPbActivity4 = this.a;
                                newSubPbActivity4.B3(newSubPbActivity4.c.n0().i());
                            }
                        }
                    } else {
                        try {
                            sparseArray = (SparseArray) view2.getTag();
                        } catch (ClassCastException e) {
                            e.printStackTrace();
                            sparseArray = null;
                        }
                        if (sparseArray == null || ((PostData) sparseArray.get(R.id.obfuscated_res_0x7f091ef1)) == null) {
                            return;
                        }
                        if (this.a.o == null) {
                            this.a.o = new wu7(this.a.getPageContext(), this.a.p);
                            this.a.j.A0(this.a.o.G());
                            this.a.o.o(this.a.mIsLogin);
                        }
                        this.a.o.m();
                        this.a.o.p(sparseArray, this.a.f3(), (this.a.x3(sparseArray.get(R.id.obfuscated_res_0x7f091ef4) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef4)).booleanValue() : false) && this.a.isLogin()) ? false : false, this.a.c.n0());
                    }
                } else if (this.a.checkUpIsLogin()) {
                    this.a.j.O0();
                    this.a.j.t();
                    if (this.a.E != null) {
                        this.a.E.f0();
                    }
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
        public class a implements dr4.e {
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

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                    dr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dr4.e {
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

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                    dr4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, gy4 gy4Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, gy4Var, writeData, antiData}) == null) {
                if (z && this.a.E != null && this.a.E.a() != null) {
                    this.a.E.a().o();
                    if (this.a.c.L0()) {
                        TiebaStatic.log(new StatisticItem("c10367").param("post_id", this.a.c.C()));
                    }
                }
                if (z) {
                    if (writeData != null) {
                        tv4.b(writeData.getContent(), "4");
                    }
                    this.a.S.n(null);
                    this.a.S.i(null);
                    this.a.S.k(false);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        qz4.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    this.a.Q2(true);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f046d), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    dr4 dr4Var = new dr4(this.a.getActivity());
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        dr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ccd));
                    } else {
                        dr4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new a(this));
                    dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ccf, new b(this));
                    dr4Var.create(this.a.getPageContext()).show();
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
                    if (this.a.d0 != 2 && this.a.d0 != 1) {
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
                    this.a.I.c(this.a.G.getResources().getString(R.string.obfuscated_res_0x7f0f0b10));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.G.getResources().getString(R.string.obfuscated_res_0x7f0f0b0c);
                    }
                    this.a.L3(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.J3();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (oi.isEmpty(errorString2)) {
                        errorString2 = this.a.G.getResources().getString(R.string.obfuscated_res_0x7f0f0b0d);
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
            if (sparseArray == null && this.a.v3(view2)) {
                if (view2 instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) view2;
                    this.a.k = tbImageView.getBdImage();
                    this.a.l = tbImageView.getUrl();
                    if (this.a.k == null || TextUtils.isEmpty(this.a.l)) {
                        return true;
                    }
                    if (view2.getTag(R.id.obfuscated_res_0x7f091f28) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091f28) instanceof TbRichTextImageInfo)) {
                        this.a.m = null;
                    } else {
                        this.a.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091f28);
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
                    if (view2.getTag(R.id.obfuscated_res_0x7f091f28) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091f28) instanceof TbRichTextImageInfo)) {
                        this.a.m = null;
                    } else {
                        this.a.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091f28);
                    }
                } else if (view2 instanceof TbMemeImageView) {
                    TbMemeImageView tbMemeImageView = (TbMemeImageView) view2;
                    if (tbMemeImageView.getBdImage() != null) {
                        this.a.k = tbMemeImageView.getBdImage();
                        if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                            this.a.l = tbMemeImageView.getBdImage().q();
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f091f28) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091f28) instanceof TbRichTextImageInfo)) {
                            this.a.m = null;
                        } else {
                            this.a.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091f28);
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
                this.a.n = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091ef1);
                NewSubPbActivity newSubPbActivity = this.a;
                if (newSubPbActivity.n == null || newSubPbActivity.g == null) {
                    return true;
                }
                if (this.a.g != null) {
                    this.a.g.h(this.a.c.P0());
                }
                boolean z = this.a.g.e() && this.a.n.J() != null && this.a.n.J().equals(this.a.c.w0());
                if (this.a.o == null) {
                    this.a.o = new wu7(this.a.getPageContext(), this.a.p);
                    this.a.j.A0(this.a.o.G());
                    this.a.o.o(this.a.mIsLogin);
                }
                this.a.o.m();
                boolean z2 = this.a.x3(sparseArray2.get(R.id.obfuscated_res_0x7f091ef4) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091ef4)).booleanValue() : false) && this.a.isLogin();
                boolean z3 = (this.a.c.n0() == null || this.a.c.n0().l() == null || !this.a.c.n0().l().isBjh()) ? false : true;
                boolean booleanValue = sparseArray2.get(R.id.obfuscated_res_0x7f091f0a) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091f0a)).booleanValue() : false;
                if (z) {
                    this.a.o.A().setText(R.string.obfuscated_res_0x7f0f0f9c);
                } else {
                    this.a.o.A().setText(R.string.obfuscated_res_0x7f0f0a6c);
                }
                if (booleanValue || z3) {
                    this.a.o.A().setVisibility(8);
                } else {
                    this.a.o.A().setVisibility(0);
                }
                if (this.a.v3(view2)) {
                    if (this.a.k != null && !this.a.k.t()) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f2d, Boolean.TRUE);
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f2d, Boolean.FALSE);
                    }
                    sparseArray2.put(R.id.obfuscated_res_0x7f091f2c, Boolean.TRUE);
                } else {
                    sparseArray2.put(R.id.obfuscated_res_0x7f091f2d, Boolean.FALSE);
                    sparseArray2.put(R.id.obfuscated_res_0x7f091f2c, Boolean.FALSE);
                }
                zr7 n0 = this.a.c.n0();
                this.a.o.k(fx7.f(this.a.n));
                this.a.o.q(sparseArray2, this.a.f3(), z2, this.a.i0 && this.a.n.f0, n0);
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
                    this.a.I.c(this.a.G.getResources().getString(R.string.obfuscated_res_0x7f0f145b));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (oi.isEmpty(muteMessage)) {
                    muteMessage = this.a.G.getResources().getString(R.string.obfuscated_res_0x7f0f145a);
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
                    if (view2.getTag(R.id.obfuscated_res_0x7f091f28) == null || !(view2.getTag(R.id.obfuscated_res_0x7f091f28) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
                        zr7 n0 = this.a.c.n0();
                        TbRichText P3 = this.a.P3(str, i);
                        TbRichTextData tbRichTextData = (P3 == null || P3.C() == null) ? null : P3.C().get(this.a.b);
                        if (tbRichTextData == null) {
                            return;
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!tbRichTextData.G().I()) {
                            String X2 = this.a.X2(tbRichTextData);
                            arrayList.add(X2);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = this.a.a ? 17 : 18;
                            concurrentHashMap.put(X2, imageUrlData);
                            if (n0 != null) {
                                if (n0.d() != null) {
                                    str6 = n0.d().getName();
                                    str7 = n0.d().getId();
                                } else {
                                    str6 = null;
                                    str7 = null;
                                }
                                str8 = n0.l() != null ? n0.l().getId() : null;
                                z4 = true;
                            } else {
                                z4 = false;
                                str6 = null;
                                str7 = null;
                                str8 = null;
                            }
                            if (this.a.c.E0() != null) {
                                concurrentHashMap = this.a.c.E0();
                                z4 = this.a.c.I0();
                                arrayList = this.a.c.D0();
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
                            builder.O(this.a.e3());
                            builder.M(String.valueOf(P3.getPostId()));
                            builder.B(this.a.c.getFromForumId());
                            this.a.sendMessage(new CustomMessage(2010000, builder.w(this.a.getPageContext().getPageActivity())));
                            return;
                        }
                        this.a.B0 = false;
                        TbRichText Q = n0.i().Q();
                        int size = arrayList.size();
                        int b3 = this.a.b3(Q, P3, i, i, arrayList, concurrentHashMap);
                        int size2 = arrayList.size();
                        String str9 = size != size2 ? arrayList.get(size2 - 1) : "";
                        if (n0 != null) {
                            if (n0.d() != null) {
                                str5 = n0.d().getName();
                                str3 = n0.d().getId();
                            } else {
                                str5 = null;
                                str3 = null;
                            }
                            str2 = n0.l() != null ? n0.l().getId() : null;
                            z3 = true;
                            str4 = str5;
                        } else {
                            str2 = null;
                            str3 = null;
                            z3 = false;
                            str4 = null;
                        }
                        if (this.a.c.E0() != null) {
                            concurrentHashMap = this.a.c.E0();
                            z3 = this.a.c.I0();
                            arrayList = this.a.c.D0();
                            b3 += this.a.c.x0();
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(arrayList, b3));
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
                        builder2.O(this.a.e3());
                        builder2.M(String.valueOf(P3.getPostId()));
                        builder2.B(this.a.c.getFromForumId());
                        this.a.sendMessage(new CustomMessage(2010000, builder2.w(this.a.getPageContext().getPageActivity())));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091f28);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gp8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.K) {
                gp8 gp8Var = (gp8) customResponsedMessage.getData();
                this.a.j.T();
                SparseArray<Object> sparseArray = (SparseArray) this.a.H;
                DataRes dataRes = gp8Var.a;
                if (gp8Var.c == 0 && dataRes != null) {
                    z = ng.e(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.obfuscated_res_0x7f091f48, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f42, dataRes.mute_confirm);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f48, Boolean.FALSE);
                    z = false;
                }
                int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091f04) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091f04)).intValue() : 0;
                if (intValue == 0) {
                    this.a.K3(z, sparseArray);
                } else if (intValue == 1) {
                    this.a.j.k0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements fr4.c {
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

        @Override // com.repackage.fr4.c
        public void a(fr4 fr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fr4Var, i, view2) == null) {
                fr4Var.e();
                if (this.a.k == null || TextUtils.isEmpty(this.a.l)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.m == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.l));
                    } else {
                        n45.a aVar = new n45.a();
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
                        newSubPbActivity.f = new sv7(newSubPbActivity.getPageContext());
                    }
                    this.a.f.b(this.a.l, this.a.k.n());
                }
                this.a.k = null;
                this.a.l = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q0 implements gu4.g {
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

        @Override // com.repackage.gu4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.c == null) {
                return;
            }
            this.a.c.U0();
        }
    }

    /* loaded from: classes3.dex */
    public class r implements xm6.d {
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

        @Override // com.repackage.xm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
        @Override // com.repackage.xm6.d
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
            if (newSubPbActivity.U != null && newSubPbActivity.c != null && this.a.c.l0() != null && !this.a.G(TbadkCoreApplication.getCurrentAccount())) {
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (!newSubPbActivity2.U.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.c.l0().replyPrivateFlag)) {
                    return;
                }
            }
            if (this.a.c != null && this.a.c.n0() != null && this.a.c.n0().i() != null) {
                PostData i = this.a.c.n0().i();
                if (i.Q() != null && i.s() != null) {
                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb5), i.s().getName_show(), i.Q().toString());
                    this.a.E.a().A(new k15(45, 27, str));
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
            this.a.E.a().A(new k15(45, 27, str));
            if (!this.a.E.x()) {
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
                this.a.Q2(false);
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
    public class t implements fr4.c {
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

        @Override // com.repackage.fr4.c
        public void a(fr4 fr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fr4Var, i, view2) == null) {
                if (i == 0) {
                    String str = this.a.get(R.id.obfuscated_res_0x7f091f45) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091f45) : "";
                    String str2 = this.a.get(R.id.obfuscated_res_0x7f091f47) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091f47) : "";
                    String str3 = this.a.get(R.id.obfuscated_res_0x7f091f46) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091f46) : "";
                    String str4 = this.a.get(R.id.obfuscated_res_0x7f091f42) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091f42) : "";
                    String str5 = this.a.get(R.id.obfuscated_res_0x7f091f43) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091f43) : "";
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, str4, this.d.K);
                    userMuteAddAndDelCustomMessage.setTag(this.d.K);
                    this.d.M3(this.b, userMuteAddAndDelCustomMessage, str4, str, str5);
                }
                fr4Var.e();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof sg5.a)) {
                sg5.a aVar = (sg5.a) customResponsedMessage.getData();
                sg5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
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
                    if (an4.c().g()) {
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
                boolean g = an4.c().g();
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
        this.a0 = new k(this);
        this.d0 = 0;
        this.e0 = false;
        this.g0 = BdUniqueId.gen();
        this.i0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.j0 = true;
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

    @Override // com.repackage.vg5
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

    @Override // com.repackage.ws7
    public rw7 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.W : (rw7) invokeV.objValue;
    }

    public final void A3(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091ef1)) == null) {
                return;
            }
            B3(postData);
        }
    }

    public void B3(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (this.c.P0() && postData.J() != null && postData.J().equals(this.c.w0())) {
            z2 = true;
        }
        MarkData v0 = this.c.v0(postData);
        if (v0 == null) {
            return;
        }
        this.j.v();
        kl4 kl4Var = this.g;
        if (kl4Var != null) {
            kl4Var.i(v0);
            if (!z2) {
                this.g.a();
            } else {
                this.g.d();
            }
        }
    }

    public final void C3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String q2 = yt4.k().q("bubble_link", "");
            if (StringUtils.isNull(q2)) {
                return;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return;
            }
            sl4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f052f), q2 + "?props_id=" + str, true, true, true);
        }
    }

    public final void D3(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            if (this.c.H0()) {
                showToast(str);
            } else if (!pi.D()) {
                this.j.G0(R.string.obfuscated_res_0x7f0f0f77);
            } else if (i2 == 4) {
                nx7 nx7Var = this.j;
                nx7Var.H0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                nx7 nx7Var2 = this.j;
                nx7Var2.H0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.j.G0(R.string.obfuscated_res_0x7f0f0c31);
            }
        }
    }

    @Override // com.repackage.vg5
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final void E3(SparseArray<Object> sparseArray, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, sparseArray, z2) == null) || sparseArray == null) {
            return;
        }
        if (sparseArray.get(R.id.obfuscated_res_0x7f091ef1) instanceof PostData) {
            F3((PostData) sparseArray.get(R.id.obfuscated_res_0x7f091ef1), z2);
        } else {
            F3(null, z2);
        }
    }

    public final void F3(PostData postData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData, z2) == null) || R2()) {
            return;
        }
        if (postData != null) {
            if (postData.s() != null) {
                MetaData s2 = postData.s();
                this.E.W(s2.getUserId());
                this.E.b0(postData.J());
                boolean z3 = postData.f0;
                this.E.p(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb5), postData.s().getName_show(), postData.Q() != null ? postData.Q().toString() : ""));
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
            Z2(false);
        }
    }

    @Override // com.repackage.ws7
    public boolean G(String str) {
        InterceptResult invokeL;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str) || (subPbModel = this.c) == null || subPbModel.n0() == null || this.c.n0().l() == null || this.c.n0().l().getAuthor() == null) {
                return false;
            }
            return str.equals(this.c.n0().l().getAuthor().getUserId());
        }
        return invokeL.booleanValue;
    }

    public final void G3() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
            if (R2()) {
                return;
            }
            if (booleanExtra) {
                if (this.U == null || (subPbModel = this.c) == null || subPbModel.l0() == null || G(TbadkCoreApplication.getCurrentAccount()) || this.U.checkPrivacyBeforeInvokeEditor(this.c.l0().replyPrivateFlag)) {
                    if (this.E.x()) {
                        this.E.v(null);
                        return;
                    }
                    this.j.O0();
                    this.j.t();
                    s35 s35Var = this.E;
                    if (s35Var != null) {
                        s35Var.k0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.X == null) {
                xm6 xm6Var = new xm6(getPageContext());
                this.X = xm6Var;
                xm6Var.i(new r(this));
            }
            SubPbModel subPbModel2 = this.c;
            if (subPbModel2 == null || subPbModel2.n0() == null || this.c.n0().d() == null) {
                return;
            }
            this.X.g(this.c.n0().d().getId(), ng.g(this.c.B0(), 0L));
        }
    }

    @Override // com.repackage.vg5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.L = true;
        }
    }

    public final void H3(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            fx7.d(this, getPageContext(), new j(this, sparseArray, i2, z2), new l(this));
        }
    }

    public final void I3(View view2, s35 s35Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, view2, s35Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new d(this, view2, s35Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0cca), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    @Override // com.repackage.vg5
    public void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
        }
    }

    public final void J3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            dr4 dr4Var = new dr4(getPageContext().getPageActivity());
            dr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b0e));
            dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ccf, new f0(this));
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new h0(this));
            dr4Var.create(this.G).show();
        }
    }

    public final void K3(boolean z2, SparseArray<Object> sparseArray) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048592, this, z2, sparseArray) == null) {
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f44) : "";
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f48)).booleanValue()) {
                String[] strArr = new String[1];
                if (z2) {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f1459);
                } else {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f0b0b);
                }
                strArr[0] = string;
                fr4 fr4Var = new fr4(getPageContext().getPageActivity());
                fr4Var.k(R.string.obfuscated_res_0x7f0f0cdd);
                fr4Var.j(strArr, new t(this, sparseArray, z2, str));
                fr4Var.c(getPageContext());
                fr4Var.m();
            }
        }
    }

    public final void L3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (str == null) {
                str = "";
            }
            dr4 dr4Var = new dr4(this.G.getPageActivity());
            dr4Var.setMessage(str);
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0989, new e0(this));
            dr4Var.create(this.G).show();
        }
    }

    @Override // com.repackage.vg5
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

    public final void M3(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.j.E0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            dr4 dr4Var = new dr4(this.G.getPageActivity());
            if (oi.isEmpty(str)) {
                dr4Var.setMessage(this.G.getResources().getString(R.string.obfuscated_res_0x7f0f0319, str3));
            } else {
                dr4Var.setMessage(str);
            }
            dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0426, new c0(this, userMuteAddAndDelCustomMessage));
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036a, new d0(this));
            dr4Var.create(this.G).show();
        }
    }

    public final void N3() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (subPbModel = this.c) == null || oi.isEmpty(subPbModel.B0())) {
            return;
        }
        mi4.w().P(li4.Z, ng.g(this.c.B0(), 0L));
    }

    @Override // com.repackage.vg5
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

    public void O3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.t0);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.repackage.vg5
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
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.U == null || (subPbModel = this.c) == null || subPbModel.n0() == null || this.c.n0().a() == null || this.U.checkPrivacyBeforeInvokeEditor(this.c.n0().a().replyPrivateFlag) : invokeV.booleanValue;
    }

    public final TbRichText P3(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, str, i2)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.n0() == null || str == null || i2 < 0) {
                return null;
            }
            zr7 n02 = this.c.n0();
            TbRichText a3 = a3(n02.i(), str, i2);
            if (a3 != null || (a3 = a3(n02.i(), str, i2)) != null) {
            }
            return a3;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // com.repackage.vg5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, str) == null) {
        }
    }

    public void Q2(boolean z2) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) || (editText = this.T) == null || editText.getText() == null) {
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
            lw8 lw8Var = this.S;
            lw8Var.k(lw8Var.b() >= 0);
        }
    }

    @Override // com.repackage.vg5
    public void R(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048604, this, context, str, z2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (u3(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                x05 x05Var = new x05();
                x05Var.a = str;
                x05Var.b = 3;
                x05Var.c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, x05Var));
            }
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
        this.L = true;
    }

    public final boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return false;
            }
            return AntiHelper.d(getPageContext(), subPbModel.l0());
        }
        return invokeV.booleanValue;
    }

    public void S2(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091f44) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f44) : "";
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

    @Override // com.repackage.ws7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return 0;
            }
            return subPbModel.F0();
        }
        return invokeV.intValue;
    }

    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.E.y();
            } else if (StringUtils.isNull(this.c.z0())) {
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
    public final void U2(AgreeData agreeData) {
        q85 currentVisiblePageExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.f0 == null) {
            this.f0 = new ut4();
        }
        if (this.h0 == null) {
            ei8 ei8Var = new ei8();
            this.h0 = ei8Var;
            ei8Var.a = this.g0;
        }
        un4 un4Var = new un4();
        un4Var.b = 12;
        un4Var.h = 9;
        un4Var.g = 3;
        if (d3() != null) {
            un4Var.f = d3().y0();
        }
        un4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                un4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.f0.c(agreeData, i2, getUniqueId(), false);
                this.f0.d(agreeData, this.h0);
                if (d3() != null || d3().n0() == null) {
                }
                this.f0.b(this, un4Var, agreeData, d3().n0().l());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            un4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            un4Var.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
        if (currentVisiblePageExtra != null) {
        }
        this.f0.c(agreeData, i2, getUniqueId(), false);
        this.f0.d(agreeData, this.h0);
        if (d3() != null) {
        }
    }

    @Override // com.repackage.vg5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048610, this, context, str, str2) == null) {
        }
    }

    public final void V2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, view2) == null) || view2 == null || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091f34) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f34)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091f32) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f32)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091f48) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f48)).booleanValue() : false;
        if (booleanValue) {
            if (booleanValue3) {
                sparseArray.put(R.id.obfuscated_res_0x7f091f04, 1);
                S2(sparseArray);
            } else {
                this.j.l0(view2);
            }
        } else if (booleanValue2) {
            this.j.j0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ef5)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091ef3), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091f10)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef4)).booleanValue(), false);
        }
        sg.d(this.j.O(), getPageContext().getPageActivity());
    }

    public void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", nx7.u0);
            TiebaStatic.log(statisticItem);
        }
    }

    public final String X2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, tbRichTextData)) == null) {
            if (tbRichTextData == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(150);
            TbRichTextImageInfo G = tbRichTextData.G();
            if (G != null) {
                if (!StringUtils.isNull(G.A())) {
                    return G.A();
                }
                if (G.getHeight() * G.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                    double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (G.getHeight() * G.getWidth()));
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (G.getWidth() * sqrt)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) (G.getHeight() * sqrt)));
                } else {
                    double width = G.getWidth() / G.getHeight();
                    double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (width * sqrt2)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) sqrt2));
                }
                sb.append("&src=");
                sb.append(oi.getUrlEncode(G.G()));
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.vg5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, context, str) == null) {
        }
    }

    @Override // com.repackage.ws7
    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.n0() == null || this.c.n0().l() == null) {
                return null;
            }
            return this.c.n0().l().getForum_name();
        }
        return (String) invokeV.objValue;
    }

    public void Y2(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048616, this, bVar, z2) == null) || bVar == null) {
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
                this.c.j0(bVar.g);
                this.j.L0(this.c.n0(), this.c.F0(), this.c.E0() != null, false);
                if (this.c.Q0()) {
                    this.c.c1(false);
                    this.j.s();
                    this.c.loadData();
                }
            }
            pq7 pq7Var = new pq7();
            pq7Var.b(bVar);
            pq7Var.c(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, pq7Var));
        }
    }

    @Override // com.repackage.vg5
    public eg<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.y == null) {
                this.y = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.y;
        }
        return (eg) invokeV.objValue;
    }

    public final void Z2(boolean z2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        int i2;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) {
            Rect rect = new Rect();
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
                frameLayout.getWindowVisibleDisplayFrame(rect);
                if (z2) {
                    ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                    childAt.requestLayout();
                }
            }
            nx7 nx7Var = this.j;
            if (nx7Var == null || nx7Var.I() == null || (pbCommenFloorItemViewHolder = this.c0) == null || (i2 = pbCommenFloorItemViewHolder.X) == -1) {
                return;
            }
            int headerViewsCount = i2 + this.j.I().getHeaderViewsCount();
            if (this.c0.a() != null) {
                int height = this.c0.a().getHeight();
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

    public final TbRichText a3(PostData postData, String str, int i2) {
        InterceptResult invokeLLI;
        TbRichText Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048619, this, postData, str, i2)) == null) {
            if (postData != null && (Q = postData.Q()) != null) {
                ArrayList<TbRichTextData> C = Q.C();
                int size = C.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (C.get(i4) != null && C.get(i4).getType() == 8) {
                        i3++;
                        if (C.get(i4).G().C().equals(str)) {
                            int h2 = (int) pi.h(TbadkCoreApplication.getInst());
                            int width = C.get(i4).G().getWidth() * h2;
                            int height = C.get(i4).G().getHeight() * h2;
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

    public final int b3(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048620, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.B0 = true;
            }
            if (tbRichText != null && tbRichText.C() != null) {
                int size = tbRichText.C().size();
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    if (tbRichText.C().get(i5) != null && tbRichText.C().get(i5).getType() == 8) {
                        i4++;
                        int h2 = (int) pi.h(TbadkCoreApplication.getInst());
                        int width = tbRichText.C().get(i5).G().getWidth() * h2;
                        int height = tbRichText.C().get(i5).G().getHeight() * h2;
                        if (!(width < 80 || height < 80 || width * height < 10000) && tbRichText.C().get(i5).G().I()) {
                            TbRichTextData tbRichTextData = tbRichText.C().get(i5);
                            String X2 = X2(tbRichTextData);
                            arrayList.add(X2);
                            if (!TextUtils.isEmpty(X2) && tbRichTextData != null && (G = tbRichTextData.G()) != null) {
                                String C = G.C();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = C;
                                imageUrlData.urlType = this.a ? 17 : 18;
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(X2, imageUrlData);
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

    public String c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (!oi.isEmpty(this.b0)) {
                return this.b0;
            }
            String string = getResources().getString(lv7.b());
            this.b0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.M && !this.e0 && !this.N && !this.O) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            } else {
                super.closeAnimation();
            }
        }
    }

    public SubPbModel d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.c : (SubPbModel) invokeV.objValue;
    }

    @Override // com.repackage.vg5
    public eg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public final ThreadData e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.n0() == null) {
                return null;
            }
            return this.c.n0().l();
        }
        return (ThreadData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.M && !this.e0 && !this.N && !this.O) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, voiceModel)) == null) {
            View G = this.j.G();
            if (G == null || (findViewWithTag = G.findViewWithTag(voiceModel)) == null) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public int f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.F0();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void g3(int i2, Intent intent) {
        w15 w15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048629, this, i2, intent) == null) {
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
                v15 n2 = this.E.a().n(6);
                if (n2 != null && (w15Var = n2.m) != null) {
                    w15Var.C(new k15(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.E.F();
                }
                this.j.V();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.w85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? "a007" : (String) invokeV.objValue;
    }

    @Override // com.repackage.vg5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            nx7 nx7Var = this.j;
            if (nx7Var != null) {
                return nx7Var.I();
            }
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || oi.isEmpty(subPbModel.B0())) {
                return 0L;
            }
            return ng.g(this.c.B0(), 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public z85 getPageStayDurationItem() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            z85 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (subPbModel = this.c) != null) {
                if (subPbModel.n0() != null && this.c.n0().d() != null) {
                    pageStayDurationItem.t(ng.g(this.c.n0().d().getId(), 0L));
                }
                pageStayDurationItem.C(ng.g(this.c.B0(), 0L));
                if (this.c.n0() != null && this.c.n0().l() != null) {
                    ThreadData l2 = this.c.n0().l();
                    pageStayDurationItem.u(l2.getNid());
                    if (l2.isNormalThreadType()) {
                        pageStayDurationItem.t = "1";
                    } else if (l2.isVideoThreadType()) {
                        pageStayDurationItem.t = "2";
                    } else {
                        pageStayDurationItem.t = "3";
                    }
                }
                pageStayDurationItem.w(ng.g(this.c.C(), 0L));
            }
            return pageStayDurationItem;
        }
        return (z85) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.w85
    public x85 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? new b0(this) : (x85) invokeV.objValue;
    }

    @Override // com.repackage.vg5
    public void h1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, context, str) == null) {
        }
    }

    public void h3(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091f45) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f45) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091f47) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f47) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091f46) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f46) : "";
            if (sparseArray.get(R.id.obfuscated_res_0x7f091f42) instanceof String) {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091f42);
            }
            String str5 = str4;
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091f42) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f42) : "";
            String str7 = sparseArray.get(R.id.obfuscated_res_0x7f091f43) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f43) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str5, 1, str6, this.K);
            userMuteAddAndDelCustomMessage.setTag(this.K);
            M3(z2, userMuteAddAndDelCustomMessage, str6, str2, str7);
        }
    }

    public void i3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.n0() != null && this.c.n0().l() != null && this.c.n0().l().isBjh()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.c.B0(), str);
                ThreadData l2 = this.c.n0().l();
                if (l2.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (l2.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (l2.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                z3(format);
                return;
            }
            this.d.a(str);
        }
    }

    public void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.t = new e(this);
            this.u = new f(this);
            this.w = new g(this);
            this.x = new h(this);
            this.v = new i(this);
        }
    }

    public void k3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bundle) == null) {
            SubPbModel subPbModel = new SubPbModel(getPageContext());
            this.c = subPbModel;
            subPbModel.b1(new c(this));
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.h = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.v);
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            kl4 b2 = kl4.b(this);
            this.g = b2;
            if (b2 != null) {
                b2.j(this.u);
            }
            if (bundle != null) {
                this.c.initWithBundle(bundle);
            } else {
                this.c.initWithIntent(getIntent());
            }
            setForceInterceptStimeStat(this.c.J0());
            this.c.f1(this.t);
            if (this.c.M0() && !this.c.S0()) {
                this.c.loadData();
            } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
                this.c.loadData();
            } else {
                this.c.T0();
            }
        }
    }

    public final void l3(boolean z2) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z2) == null) {
            s35 s35Var = (s35) new t35(z2).a(getActivity());
            this.E = s35Var;
            if (s35Var != null) {
                s35Var.N(getPageContext());
                this.E.a0(this.c);
                this.E.Q(this.w0);
                this.E.O(2);
                this.E.U(this.a0);
                this.E.M(this.u0);
                this.E.a().C(true);
                this.E.z(getPageContext());
                this.E.P(this.P);
            }
            nx7 nx7Var = this.j;
            if (nx7Var != null) {
                nx7Var.a0(this.E);
            }
            s35 s35Var2 = this.E;
            if (s35Var2 != null && (subPbModel = this.c) != null) {
                s35Var2.G(subPbModel.l0());
                this.E.y();
            }
            s35 s35Var3 = this.E;
            if (s35Var3 == null) {
                return;
            }
            s35Var3.t().l(c3());
            this.E.t().m(c3());
            EditText i2 = this.E.t().i();
            this.T = i2;
            i2.addTextChangedListener(new s(this));
        }
    }

    public final boolean m3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, bundle)) == null) {
            if (bundle != null) {
                this.O = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            } else {
                this.O = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            }
            return this.O;
        }
        return invokeL.booleanValue;
    }

    public final boolean n3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, bundle)) == null) {
            if (bundle != null) {
                this.M = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            } else {
                this.M = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            }
            return this.M;
        }
        return invokeL.booleanValue;
    }

    public final boolean o3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, bundle)) == null) {
            if (bundle != null) {
                this.Q = bundle.getBoolean("is_jump_from_video_middle");
            } else {
                this.Q = getIntent().getBooleanExtra("is_jump_from_video_middle", false);
            }
            return this.Q;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048644, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25035) {
                g3(i3, intent);
            }
            s35 s35Var = this.E;
            if (s35Var != null) {
                s35Var.C(i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            s35 s35Var = this.E;
            if (s35Var != null && s35Var.a() != null && this.E.a().u()) {
                this.E.a().q();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048647, this, bundle) == null) {
            n3(bundle);
            p3(bundle);
            q3(bundle);
            o3(bundle);
            m3(bundle);
            if (getIntent() != null) {
                this.e0 = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
                if (this.N) {
                    this.t0 = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
                }
            }
            super.onCreate(bundle);
            this.G = getPageContext();
            this.J = true;
            lw8 lw8Var = new lw8();
            this.S = lw8Var;
            lw8Var.h(R.color.cp_cont_h_alpha85);
            this.S.j(R.color.CAM_X0101);
            r3();
            j3();
            k3(bundle);
            s3();
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
            l3(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.j.r(this.e0);
            du4 du4Var = new du4();
            this.I = du4Var;
            du4Var.a = 1000L;
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
            lx7 lx7Var = new lx7(this);
            this.d = lx7Var;
            lx7Var.b(getUniqueId());
            this.W = new rw7(this);
            this.q0 = new ep8(getPageContext(), getUniqueId());
            if (this.r0 == null) {
                if (this.Q) {
                    this.r0 = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.r0 = new TiePlusEventController(this, TiePlusStat.Locate.PB_COMMENT);
                }
                this.r0.l(this.s0);
            }
            pz4.b(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
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
            ep8 ep8Var = this.q0;
            if (ep8Var != null) {
                ep8Var.l();
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
        if (interceptable == null || interceptable.invokeZ(1048649, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            this.Z = z2;
            Z2(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.F = true;
            super.onPause();
            TiePlusEventController tiePlusEventController = this.r0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            mi4.w().E();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.D0);
            this.j.f0();
            if (this.N || this.O) {
                O3(false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.repackage.g9
    public void onPreLoad(rn rnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, rnVar) == null) {
            PreLoadImageHelper.load(rnVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(rnVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.F = false;
            super.onResume();
            TiePlusEventController tiePlusEventController = this.r0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            N3();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.D0);
            this.j.g0();
            if (this.N || this.O) {
                O3(true);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null || (subPbModel = this.c) == null) {
                return;
            }
            subPbModel.a1(bundle);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048658, this, z2) == null) {
            super.onUserChanged(z2);
            wu7 wu7Var = this.o;
            if (wu7Var != null) {
                wu7Var.o(z2);
            }
        }
    }

    public final boolean p3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, bundle)) == null) {
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

    public final int q3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, bundle)) == null) {
            if (bundle != null) {
                this.P = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                this.P = getIntent().getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.P;
        }
        return invokeL.intValue;
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            registerListener(this.E0);
            this.p = new m(this);
            this.q = new n(this);
            this.r = new o(this);
            this.s = new p(this);
        }
    }

    public void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            nx7 nx7Var = new nx7(this, this.p);
            this.j = nx7Var;
            nx7Var.t0(this.c);
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
            if (subPbModel != null && subPbModel.M0() && !this.c.R0()) {
                this.j.F().setVisibility(8);
            } else {
                this.j.F().setVisibility(0);
            }
            SubPbModel subPbModel2 = this.c;
            if (subPbModel2 == null || subPbModel2.M0()) {
                return;
            }
            this.j.q0(false);
        }
    }

    public boolean t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.M0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.i : (VoiceManager) invokeV.objValue;
    }

    public boolean u3(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                return false;
            }
            this.L = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return u3(oi.getUrlDecode(str2));
            }
            String str3 = paramPair.get(F0);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ws7
    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.n0() == null || this.c.n0().l() == null) {
                return false;
            }
            return !this.c.n0().l().isMutiForumThread();
        }
        return invokeV.booleanValue;
    }

    public boolean v3(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    public boolean w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.F : invokeV.booleanValue;
    }

    @Override // com.repackage.vg5
    public eg<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (this.z == null) {
                this.z = new eg<>(new w(this), 20, 0);
            }
            return this.z;
        }
        return (eg) invokeV.objValue;
    }

    public final boolean x3(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048670, this, z2)) == null) {
            if (this.c == null) {
                return false;
            }
            return ((f3() != 0) || this.c.n0() == null || this.c.n0().l() == null || this.c.n0().l().getAuthor() == null || this.c.n0().l().isUgcThreadType() || TextUtils.equals(this.c.n0().l().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public boolean y3(@Nullable ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048671, this, threadData)) == null) ? (threadData == null || !threadData.isVideoThreadType() || threadData.getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    @Override // com.repackage.vg5
    public eg<TiebaPlusRecommendCard> z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public final void z3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }
}
