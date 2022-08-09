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
import com.repackage.av4;
import com.repackage.az4;
import com.repackage.bm4;
import com.repackage.bs4;
import com.repackage.bz8;
import com.repackage.c9;
import com.repackage.cj4;
import com.repackage.d9;
import com.repackage.dj4;
import com.repackage.ds4;
import com.repackage.fg;
import com.repackage.fs4;
import com.repackage.fz7;
import com.repackage.gg;
import com.repackage.gi5;
import com.repackage.h25;
import com.repackage.h45;
import com.repackage.i45;
import com.repackage.j55;
import com.repackage.ji5;
import com.repackage.jm4;
import com.repackage.jz7;
import com.repackage.k05;
import com.repackage.l05;
import com.repackage.lo4;
import com.repackage.ls7;
import com.repackage.lx7;
import com.repackage.nu4;
import com.repackage.nw4;
import com.repackage.o45;
import com.repackage.o95;
import com.repackage.og;
import com.repackage.oi;
import com.repackage.on;
import com.repackage.oz7;
import com.repackage.p45;
import com.repackage.pi;
import com.repackage.qi;
import com.repackage.qo6;
import com.repackage.qz7;
import com.repackage.rg;
import com.repackage.rn4;
import com.repackage.ru4;
import com.repackage.ry7;
import com.repackage.s15;
import com.repackage.s25;
import com.repackage.sk8;
import com.repackage.sn;
import com.repackage.su7;
import com.repackage.sx7;
import com.repackage.t25;
import com.repackage.ur4;
import com.repackage.ur8;
import com.repackage.uz7;
import com.repackage.v95;
import com.repackage.vr8;
import com.repackage.vt7;
import com.repackage.wr4;
import com.repackage.wu4;
import com.repackage.x95;
import com.repackage.xr8;
import com.repackage.y95;
import com.repackage.zm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes4.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.j, ji5, BdListView.p, su7<NewSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String I0 = "tbgametype";
    public transient /* synthetic */ FieldHolder $fh;
    public fg<TextView> A;
    public CustomMessageListener A0;
    public fg<GifView> B;
    public CustomMessageListener B0;
    public fg<View> C;
    public CustomMessageListener C0;
    public fg<ImageView> D;
    public final av4.g D0;
    public fg<LinearLayout> E;
    public boolean E0;
    public fg<RelativeLayout> F;
    public final wr4.c F0;
    public o45 G;
    public CustomMessageListener G0;
    public boolean H;
    public CustomMessageListener H0;
    public d9 I;
    public Object J;
    public wu4 K;
    public boolean L;
    public BdUniqueId M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public boolean S;
    public boolean T;
    public boolean U;
    public bz8 V;
    public EditText W;
    public ReplyPrivacyCheckController X;
    public ls7<vt7> Y;
    public ry7 Z;
    public boolean a;
    public qo6 a0;
    public int b;
    public PostWriteCallBackData b0;
    public SubPbModel c;
    public boolean c0;
    public oz7 d;
    public i45 d0;
    public PermissionJudgePolicy e;
    public String e0;
    public sx7 f;
    public PbCommenFloorItemViewHolder f0;
    public bm4 g;
    public int g0;
    public ForumManageModel h;
    public boolean h0;
    public VoiceManager i;
    public nu4 i0;
    public qz7 j;
    public BdUniqueId j0;
    public zm k;
    public String l;
    public TbRichTextMemeInfo m;
    public PostData n;
    public ds4 o;
    public fs4 p;
    public fs4.e q;
    public sk8 q0;
    public View.OnClickListener r;
    public boolean r0;
    public AbsListView.OnScrollListener s;
    public boolean s0;
    public View.OnLongClickListener t;
    public vr8 t0;
    public TbRichTextView.y u;
    @Nullable
    public TiePlusEventController u0;
    public SubPbModel.b v;
    @NonNull
    public TiePlusEventController.f v0;
    public bm4.a w;
    public BdUniqueId w0;
    public c9 x;
    public h45 x0;
    public s0 y;
    public CustomMessageListener y0;
    public s0 z;
    public NewWriteModel.e z0;

    /* loaded from: classes4.dex */
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
                this.a.G.F();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements gg<LinearLayout> {
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b0 implements gg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class c0 extends v95 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity b;

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

        @Override // com.repackage.v95
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? y95.b().c() : invokeV.intValue;
        }

        @Override // com.repackage.v95
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ o45 b;
        public final /* synthetic */ NewSubPbActivity c;

        public d(NewSubPbActivity newSubPbActivity, View view2, o45 o45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, view2, o45Var};
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
            this.b = o45Var;
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

    /* loaded from: classes4.dex */
    public class d0 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                this.b.j.t0();
                MessageManager.getInstance().sendMessage(this.a);
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements SubPbModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ vt7 a;
            public final /* synthetic */ e b;

            public a(e eVar, vt7 vt7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, vt7Var};
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
                this.a = vt7Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.s0 = false;
                    this.b.a.N3(this.a.i(), false);
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
        public void a(boolean z, int i, String str, vt7 vt7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, vt7Var}) == null) || this.a.j == null) {
                return;
            }
            this.a.j.e0();
            if (this.a.P && this.a.j.u() != null) {
                NewSubPbActivity newSubPbActivity = this.a;
                newSubPbActivity.hideLoadingView(newSubPbActivity.j.u());
            }
            if (!z) {
                this.a.L3(i, str);
                return;
            }
            this.a.j.L();
            if (vt7Var != null) {
                if (vt7Var.i() != null || this.a.c != null) {
                    vt7Var.i().X0(this.a.c.z0());
                }
                if (this.a.j != null) {
                    this.a.u3(vt7Var.l() != null && vt7Var.l().isBjh());
                    if (this.a.G != null && this.a.G.a() != null) {
                        this.a.G.a().w(TbadkCoreApplication.getInst().getSkinType());
                    }
                    this.a.j.A0(vt7Var, this.a.c.E0(), this.a.c.D0() != null, this.a.L);
                    if (this.a.L) {
                        this.a.j.B().setSelectionFromTop(this.a.j.B().getHeaderViewsCount() + 1, -qi.f(this.a, R.dimen.tbds18));
                        this.a.S2();
                        this.a.L = false;
                    }
                }
                if (this.a.G != null) {
                    this.a.G.G(vt7Var.a());
                    this.a.G.c0(vt7Var.l());
                    if (this.a.getIntent() != null && this.a.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && this.a.s0) {
                        rg.a().postDelayed(new a(this, vt7Var), 200L);
                    }
                }
                if (this.a.Y == null) {
                    this.a.Y = new ls7();
                }
                this.a.Y.b(vt7Var);
                this.a.Y.c(0);
                NewSubPbActivity newSubPbActivity2 = this.a;
                newSubPbActivity2.X.setLikeUserData(newSubPbActivity2.c.l0());
            }
            String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || this.a.U) {
                return;
            }
            this.a.U = true;
            NewSubPbActivity newSubPbActivity3 = this.a;
            newSubPbActivity3.Q3(newSubPbActivity3.j.G(), this.a.G, stringExtra);
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements bm4.a {
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

        @Override // com.repackage.bm4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.g != null) {
                        this.a.g.h(z2);
                    }
                    MarkData f = this.a.g.f();
                    ls7 ls7Var = new ls7();
                    ls7Var.c(2);
                    if (z2) {
                        ls7Var.b(f);
                        if (this.a.g != null) {
                            if (f != null) {
                                this.a.c.c1(true);
                                this.a.c.d1(this.a.c.B());
                                this.a.showToast(R.string.obfuscated_res_0x7f0f00d1);
                            } else {
                                NewSubPbActivity newSubPbActivity = this.a;
                                newSubPbActivity.showToast(newSubPbActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d0));
                            }
                        }
                    } else {
                        ls7Var.b(null);
                        this.a.c.c1(false);
                        this.a.c.d1(null);
                        NewSubPbActivity newSubPbActivity2 = this.a;
                        newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fd1));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, ls7Var));
                    return;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14c0));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class g0 implements h45 {
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

        @Override // com.repackage.h45
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.V.d()) {
                    NewSubPbActivity newSubPbActivity = this.a;
                    newSubPbActivity.showToast(newSubPbActivity.V.c());
                    if (this.a.G.x()) {
                        this.a.G.v(this.a.b0);
                    }
                    this.a.P2(true);
                    return true;
                }
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (newSubPbActivity2.X == null || newSubPbActivity2.c == null || this.a.c.k0() == null || this.a.E(TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                return !newSubPbActivity3.X.checkPrivacyBeforeSend(newSubPbActivity3.c.k0().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                    if (this.a.h.S() || objArr == null || objArr.length < 4) {
                        return;
                    }
                    String valueOf = String.valueOf(objArr[0]);
                    int e = og.e(String.valueOf(objArr[1]), 0);
                    boolean b = og.b(String.valueOf(objArr[2]), false);
                    int e2 = og.e(String.valueOf(objArr[3]), 0);
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

    /* loaded from: classes4.dex */
    public class h0 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    ur4Var.dismiss();
                    ((TbPageContext) this.a.I).showToast(R.string.obfuscated_res_0x7f0f070c);
                    return;
                }
                TiebaStatic.log("c10025");
                ur4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.I.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes4.dex */
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
                        this.a.h3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.j.s(1, dVar.a, dVar.b, true);
                        return;
                    }
                }
                this.a.j.s(this.a.h.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                if (ur4Var != null) {
                    ur4Var.dismiss();
                }
                if (this.d.z != null) {
                    this.d.z.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091fea), Integer.valueOf(this.b), Boolean.valueOf(this.c), this.a.get(R.id.obfuscated_res_0x7f091fec)});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.j.r(this.a.c.m0(), this.a.c.m0().i(), this.a.c.m0().e(), this.a.c.m0().f(), this.a.c.E0(), this.a.c.D0() != null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements i45 {
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

        @Override // com.repackage.i45
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.q0();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.j == null || this.c.j.B() == null) {
                return;
            }
            this.c.j.B().setSelectionFromTop(this.a, this.c.j.D() - this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class l implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.d.j == null || this.d.j.B() == null) {
                return;
            }
            this.d.j.B().setSelectionFromTop(this.a, this.d.j.D() + (this.b - this.c));
        }
    }

    /* loaded from: classes4.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == null && this.a.j == null) {
                    return;
                }
                boolean z = true;
                if (view2 == this.a.j.A()) {
                    this.a.j.o();
                    String str = view2.getTag(R.id.obfuscated_res_0x7f09203d) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f09203d) : null;
                    String str2 = view2.getTag(R.id.obfuscated_res_0x7f092045) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f092045) : null;
                    String str3 = view2.getTag(R.id.obfuscated_res_0x7f092047) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f092047) : null;
                    if (str3 != null) {
                        if (this.a.checkUpIsLogin()) {
                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str3});
                        }
                    } else if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                    }
                } else if (view2 == this.a.j.G()) {
                    if (this.a.O2() && this.a.checkUpIsLogin()) {
                        this.a.O3();
                        if (this.a.c == null || this.a.c.m0() == null || this.a.c.m0().l() == null || this.a.c.m0().l().getAuthor() == null) {
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.c.A0()).param("fid", this.a.c.m0().l().getFid()).param("obj_locate", 5).param("uid", this.a.c.m0().l().getAuthor().getUserId()));
                    }
                } else if (view2 != this.a.j.E()) {
                    if (view2 == this.a.j.F()) {
                        if (this.a.checkUpIsLogin()) {
                            this.a.j.D0();
                            this.a.j.m();
                            if (this.a.G != null) {
                                this.a.G.i0();
                            }
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d1) {
                        this.a.t.onLongClick(view2);
                    } else if (view2 == this.a.j.C()) {
                        this.a.j.o();
                        if (this.a.c.loadData()) {
                            this.a.j.z0();
                        }
                    } else {
                        if (view2 == this.a.j.y() || view2 == this.a.j.x() || view2 == this.a.j.H()) {
                            if (this.a.N) {
                                this.a.N = false;
                                return;
                            }
                            if (!((this.a.c.m0() == null || this.a.c.m0().l() == null) ? false : ThreadCardUtils.isUgcThreadType(this.a.c.m0().l().getBaijiahaoData()))) {
                                if (this.a.c == null || this.a.c.m0() == null) {
                                    return;
                                }
                                if (this.a.H3(this.a.c.m0().l())) {
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
                        } else if (view2 != this.a.j.z() && view2 != this.a.j.H()) {
                            if (view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                this.a.f0 = (PbCommenFloorItemViewHolder) view2.getTag();
                                if (this.a.O2() && ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                    if (this.a.N) {
                                        this.a.N = false;
                                        return;
                                    }
                                    NewSubPbActivity newSubPbActivity = this.a;
                                    if (newSubPbActivity.X != null && newSubPbActivity.c != null && this.a.c.k0() != null && !this.a.E(TbadkCoreApplication.getCurrentAccount())) {
                                        NewSubPbActivity newSubPbActivity2 = this.a;
                                        if (!newSubPbActivity2.X.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.c.k0().replyPrivateFlag)) {
                                            return;
                                        }
                                    }
                                    SparseArray sparseArray = (SparseArray) view2.getTag(R.id.obfuscated_res_0x7f091ffb);
                                    if (sparseArray == null) {
                                        return;
                                    }
                                    this.a.M3(sparseArray, ((view2.getTag(R.id.obfuscated_res_0x7f092034) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f092034) == Boolean.TRUE) ? false : false);
                                    if (sparseArray.get(R.id.obfuscated_res_0x7f091fe8) instanceof PostData) {
                                        PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8);
                                        uz7.a(this.a.c != null ? this.a.c.A0() : "", postData.s() == null ? "" : postData.s().getUserId(), postData.K());
                                    }
                                }
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091a01 || view2.getId() == R.id.obfuscated_res_0x7f0917cd) {
                                this.a.d3(view2);
                            } else if (view2 == this.a.j.w()) {
                                if (this.a.O2() && this.a.G != null && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                                    this.a.G.f0();
                                    this.a.f3();
                                }
                            } else if (view2.getId() != R.id.obfuscated_res_0x7f09076e && view2.getId() != R.id.obfuscated_res_0x7f0909f1) {
                                int id = view2.getId();
                                if (id == R.id.obfuscated_res_0x7f0917fd) {
                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1366);
                                        String q = ru4.k().q("tail_link", "");
                                        if (StringUtils.isNull(q)) {
                                            return;
                                        }
                                        TiebaStatic.log("c10056");
                                        jm4.s(view2.getContext(), string, q, true, true, true);
                                    }
                                } else if (id == R.id.obfuscated_res_0x7f091bd2 && (view2.getTag() instanceof SparseArray)) {
                                    Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091fe8);
                                    if (obj instanceof PostData) {
                                        PostData postData2 = (PostData) obj;
                                        if (postData2.getType() == PostData.N0 || TextUtils.isEmpty(postData2.t()) || !rn4.c().g()) {
                                            return;
                                        }
                                        this.a.K3(postData2.K());
                                    }
                                }
                            } else {
                                SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                if (sparseArray2 == null || !(sparseArray2.get(R.id.obfuscated_res_0x7f092005) instanceof PostData)) {
                                    return;
                                }
                                PostData postData3 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f092005);
                                View view3 = (View) sparseArray2.get(R.id.obfuscated_res_0x7f092007);
                                if (postData3 == null || view3 == null) {
                                    return;
                                }
                                ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09076f);
                                EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090770);
                                View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f0909f1);
                                if (postData3.p0()) {
                                    postData3.P0(false);
                                    jz7.e(postData3);
                                } else {
                                    if (this.a.c != null ? jz7.c(this.a.c.m0(), postData3) : false) {
                                        postData3.P0(true);
                                    }
                                }
                                SkinManager.setBackgroundColor(findViewById, postData3.p0() ? R.color.CAM_X0201 : R.color.transparent);
                                boolean p0 = postData3.p0();
                                int i = R.color.CAM_X0304;
                                SkinManager.setViewTextColor(eMTextView, p0 ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                int i2 = postData3.p0() ? R.drawable.obfuscated_res_0x7f080964 : R.drawable.obfuscated_res_0x7f080963;
                                if (!postData3.p0()) {
                                    i = R.color.CAM_X0107;
                                }
                                WebPManager.setPureDrawable(imageView, i2, i, null);
                            }
                        } else if (this.a.checkUpIsLogin()) {
                            if (this.a.G.A()) {
                                this.a.G.y();
                            } else {
                                this.a.G.l0(null, null);
                            }
                        }
                    }
                } else if (this.a.checkUpIsLogin()) {
                    this.a.j.D0();
                    this.a.j.m();
                    if (this.a.G != null) {
                        this.a.G.f0();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.V != null) {
                    this.a.V.n(null);
                    this.a.V.i(null);
                    this.a.V.k(false);
                }
                if (this.a.G != null) {
                    this.a.G.q();
                    this.a.G.H();
                }
                this.a.c.K();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    if (this.a.g0 != 2 && this.a.g0 != 1) {
                        this.a.j.M();
                    }
                }
                this.a.G.y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes4.dex */
        public class a implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ur4.e {
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, az4Var, writeData, antiData}) == null) {
                if (z && this.a.G != null && this.a.G.a() != null) {
                    this.a.G.a().o();
                    if (this.a.c.K0()) {
                        TiebaStatic.log(new StatisticItem("c10367").param("post_id", this.a.c.B()));
                    }
                }
                if (z) {
                    if (writeData != null) {
                        nw4.b(writeData.getContent(), "4");
                    }
                    this.a.V.n(null);
                    this.a.V.i(null);
                    this.a.V.k(false);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        l05.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    this.a.V.i(postWriteCallBackData.getSensitiveWords());
                    this.a.V.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.a.V.a())) {
                        return;
                    }
                    this.a.b0 = postWriteCallBackData;
                    if (this.a.G.x()) {
                        this.a.G.v(this.a.b0);
                    }
                    this.a.P2(true);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
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
                    ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new a(this));
                    ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf5, new b(this));
                    ur4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && (replyPrivacyCheckController = this.a.X) != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
                this.a.j.e0();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.j == null || !this.a.j.S()) {
                    return this.a.e3(view2);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.K.c(this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f0b34));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f0b30);
                    }
                    this.a.T3(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.R3();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (pi.isEmpty(errorString2)) {
                        errorString2 = this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f0b31);
                    }
                    this.a.K.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    if (view2.getTag(R.id.obfuscated_res_0x7f092024) == null || !(view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextMemeInfo) || !(view2 instanceof TbImageView)) {
                        vt7 m0 = this.a.c.m0();
                        TbRichText X3 = this.a.X3(str, i);
                        TbRichTextData tbRichTextData = (X3 == null || X3.B() == null) ? null : X3.B().get(this.a.b);
                        if (tbRichTextData == null) {
                            return;
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!tbRichTextData.F().H()) {
                            String g3 = this.a.g3(tbRichTextData);
                            arrayList.add(g3);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = this.a.a ? 17 : 18;
                            concurrentHashMap.put(g3, imageUrlData);
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
                            builder.O(this.a.n3());
                            builder.M(String.valueOf(X3.getPostId()));
                            builder.B(this.a.c.getFromForumId());
                            this.a.sendMessage(new CustomMessage(2010000, builder.w(this.a.getPageContext().getPageActivity())));
                            return;
                        }
                        this.a.E0 = false;
                        TbRichText V = m0.i().V();
                        int size = arrayList.size();
                        int k3 = this.a.k3(V, X3, i, i, arrayList, concurrentHashMap);
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
                            k3 += this.a.c.w0();
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(arrayList, k3));
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
                        builder2.O(this.a.n3());
                        builder2.M(String.valueOf(X3.getPostId()));
                        builder2.B(this.a.c.getFromForumId());
                        this.a.sendMessage(new CustomMessage(2010000, builder2.w(this.a.getPageContext().getPageActivity())));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
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

    /* loaded from: classes4.dex */
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
                    this.a.K.c(this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f1499));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (pi.isEmpty(muteMessage)) {
                    muteMessage = this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f1498);
                }
                this.a.K.b(muteMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements fs4.e {
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

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                if (i == -4) {
                    View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b7);
                    if (view3 != null) {
                        view3.performClick();
                    }
                } else if (i == -3) {
                    View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b6);
                    if (view4 != null) {
                        view4.performClick();
                    }
                } else if (i == -2) {
                    View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b8);
                    if (view5 != null) {
                        AgreeView agreeView = (AgreeView) view5;
                        if (agreeView.getImgDisagree() != null) {
                            agreeView.getImgDisagree().performClick();
                        }
                    }
                } else if (i == -1) {
                    View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917b8);
                    if (view6 != null) {
                        AgreeView agreeView2 = (AgreeView) view6;
                        if (agreeView2.getImgAgree() != null) {
                            agreeView2.getImgAgree().performClick();
                        }
                    }
                } else if (i != 13) {
                    switch (i) {
                        case 1:
                            this.a.X2();
                            return;
                        case 2:
                            this.a.b3();
                            return;
                        case 3:
                            this.a.U2(view2);
                            return;
                        case 4:
                            this.a.Z2(view2);
                            return;
                        case 5:
                            this.a.a3(view2);
                            return;
                        case 6:
                            this.a.V2(view2);
                            return;
                        case 7:
                            this.a.Y2(view2);
                            return;
                        case 8:
                            this.a.W2(view2);
                            return;
                        case 9:
                            this.a.T2(view2);
                            return;
                        default:
                            return;
                    }
                } else {
                    this.a.T = true;
                    this.a.j.E0(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof xr8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.M) {
                xr8 xr8Var = (xr8) customResponsedMessage.getData();
                this.a.j.K();
                SparseArray<Object> sparseArray = (SparseArray) this.a.J;
                DataRes dataRes = xr8Var.a;
                if (xr8Var.c == 0 && dataRes != null) {
                    z = og.e(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09203e, dataRes.mute_confirm);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                    z = false;
                }
                sparseArray.put(R.id.obfuscated_res_0x7f092009, Boolean.TRUE);
                int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091ffb) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ffb)).intValue() : 0;
                if (intValue == 0) {
                    this.a.S3(z, sparseArray);
                } else if (intValue == 1) {
                    this.a.j.a0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements wr4.c {
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

        @Override // com.repackage.wr4.c
        public void a(wr4 wr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wr4Var, i, view2) == null) {
                wr4Var.e();
                if (this.a.k == null || TextUtils.isEmpty(this.a.l)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.m == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.l));
                    } else {
                        j55.a aVar = new j55.a();
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
                        newSubPbActivity.f = new sx7(newSubPbActivity.getPageContext());
                    }
                    this.a.f.b(this.a.l, this.a.k.n());
                }
                this.a.k = null;
                this.a.l = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r0 implements av4.g {
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

        @Override // com.repackage.av4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.c == null) {
                return;
            }
            this.a.c.T0();
        }
    }

    /* loaded from: classes4.dex */
    public class s implements qo6.d {
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

        @Override // com.repackage.qo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
        @Override // com.repackage.qo6.d
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
            if (newSubPbActivity.X != null && newSubPbActivity.c != null && this.a.c.k0() != null && !this.a.E(TbadkCoreApplication.getCurrentAccount())) {
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (!newSubPbActivity2.X.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.c.k0().replyPrivateFlag)) {
                    return;
                }
            }
            if (this.a.c != null && this.a.c.m0() != null && this.a.c.m0().i() != null) {
                PostData i = this.a.c.m0().i();
                if (i.V() != null && i.s() != null) {
                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fec), i.s().getName_show(), i.V().toString());
                    this.a.G.a().A(new h25(45, 27, str));
                    if (!this.a.G.x()) {
                        this.a.G.v(null);
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
            this.a.G.a().A(new h25(45, 27, str));
            if (!this.a.G.x()) {
            }
        }

        @Override // com.repackage.qo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface s0 {
        void a(Object obj);
    }

    /* loaded from: classes4.dex */
    public class t implements TextWatcher {
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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.V == null) {
                return;
            }
            if (!this.a.V.e()) {
                this.a.P2(false);
            }
            this.a.V.l(false);
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

    /* loaded from: classes4.dex */
    public class u implements wr4.c {
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

        @Override // com.repackage.wr4.c
        public void a(wr4 wr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wr4Var, i, view2) == null) {
                if (i == 0) {
                    String str = this.a.get(R.id.obfuscated_res_0x7f092041) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f092041) : "";
                    String str2 = this.a.get(R.id.obfuscated_res_0x7f092043) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f092043) : "";
                    String str3 = this.a.get(R.id.obfuscated_res_0x7f092042) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f092042) : "";
                    String str4 = this.a.get(R.id.obfuscated_res_0x7f09203e) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f09203e) : "";
                    String str5 = this.a.get(R.id.obfuscated_res_0x7f09203f) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f09203f) : "";
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, str4, this.d.M);
                    userMuteAddAndDelCustomMessage.setTag(this.d.M);
                    this.d.U3(this.b, userMuteAddAndDelCustomMessage, str4, str, str5);
                }
                wr4Var.e();
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gi5.a)) {
                gi5.a aVar = (gi5.a) customResponsedMessage.getData();
                gi5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements gg<GifView> {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.b0();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
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

    /* loaded from: classes4.dex */
    public class y implements gg<ImageView> {
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
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
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class z implements gg<View> {
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) ? view2 : (View) invokeL.objValue;
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
        this.d0 = new k(this);
        this.g0 = 0;
        this.h0 = false;
        this.j0 = BdUniqueId.gen();
        this.r0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.s0 = true;
        this.v0 = new v(this);
        this.x0 = new g0(this);
        this.y0 = new m0(this, 2921481);
        this.z0 = new n0(this);
        this.A0 = new o0(this, 2001427);
        this.B0 = new p0(this, 2001428);
        this.C0 = new q0(this, 2001426);
        this.D0 = new r0(this);
        this.E0 = false;
        this.F0 = new r(this);
        this.G0 = new w(this, 2001332);
        this.H0 = new j0(this, 2016485);
    }

    public void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            registerListener(this.H0);
            this.r = new m(this);
            this.s = new n(this);
            this.t = new o(this);
            this.u = new p(this);
            this.q = new q(this);
        }
    }

    public void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            qz7 qz7Var = new qz7(this, this.r);
            this.j = qz7Var;
            qz7Var.j0(this.c);
            this.j.p0(getUniqueId());
            setContentView(this.j.I(), new FrameLayout.LayoutParams(-1, -1));
            this.j.n0(this.s);
            this.j.o0(this);
            this.j.k0(this.u);
            this.j.l0(this.t);
            this.j.m0(new b(this));
            this.j.f0(this.y);
            this.j.d0(this.z);
            this.j.h0(this.D0);
            SubPbModel subPbModel = this.c;
            if (subPbModel != null && subPbModel.L0() && !this.c.Q0()) {
                this.j.y().setVisibility(8);
            } else {
                this.j.y().setVisibility(0);
            }
            SubPbModel subPbModel2 = this.c;
            if (subPbModel2 == null || subPbModel2.L0()) {
                return;
            }
            this.j.g0(false);
        }
    }

    @Override // com.repackage.ji5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.L0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean D3(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                return false;
            }
            this.N = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return D3(pi.getUrlDecode(str2));
            }
            String str3 = paramPair.get(I0);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.su7
    public boolean E(String str) {
        InterceptResult invokeL;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (StringUtils.isNull(str) || (subPbModel = this.c) == null || subPbModel.m0() == null || this.c.m0().l() == null || this.c.m0().l().getAuthor() == null) {
                return false;
            }
            return str.equals(this.c.m0().l().getAuthor().getUserId());
        }
        return invokeL.booleanValue;
    }

    public boolean E3(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    @Override // com.repackage.ji5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.N = true;
        }
    }

    public boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public final boolean G3(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z2)) == null) {
            if (this.c == null) {
                return false;
            }
            return ((o3() != 0) || this.c.m0() == null || this.c.m0().l() == null || this.c.m0().l().getAuthor() == null || this.c.m0().l().isUgcThreadType() || TextUtils.equals(this.c.m0().l().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.repackage.ji5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
        }
    }

    public boolean H3(@Nullable ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, threadData)) == null) ? (threadData == null || !threadData.isVideoThreadType() || threadData.getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    public final void I3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void J3(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8)) == null) {
                return;
            }
            boolean z2 = false;
            if (this.c.O0() && postData.K() != null && postData.K().equals(this.c.v0())) {
                z2 = true;
            }
            MarkData u0 = this.c.u0(postData);
            if (u0 == null) {
                return;
            }
            this.j.o();
            bm4 bm4Var = this.g;
            if (bm4Var != null) {
                bm4Var.i(u0);
                if (!z2) {
                    this.g.a();
                } else {
                    this.g.d();
                }
            }
        }
    }

    public final void K3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, str) == null) && !StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String q2 = ru4.k().q("bubble_link", "");
            if (StringUtils.isNull(q2)) {
                return;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return;
            }
            jm4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f053d), q2 + "?props_id=" + str, true, true, true);
        }
    }

    @Override // com.repackage.ji5
    public fg<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            fg<RelativeLayout> fgVar = new fg<>(new b0(this), 10, 0);
            this.F = fgVar;
            return fgVar;
        }
        return (fg) invokeV.objValue;
    }

    public final void L3(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, str) == null) {
            if (this.c.G0()) {
                showToast(str);
            } else if (!qi.D()) {
                this.j.v0(R.string.obfuscated_res_0x7f0f0fac);
            } else if (i2 == 4) {
                qz7 qz7Var = this.j;
                qz7Var.w0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                qz7 qz7Var2 = this.j;
                qz7Var2.w0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.j.v0(R.string.obfuscated_res_0x7f0f0c56);
            }
        }
    }

    public final void M3(SparseArray<Object> sparseArray, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048593, this, sparseArray, z2) == null) || sparseArray == null) {
            return;
        }
        if (sparseArray.get(R.id.obfuscated_res_0x7f091fe8) instanceof PostData) {
            N3((PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8), z2);
        } else {
            N3(null, z2);
        }
    }

    @Override // com.repackage.ji5
    public fg<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.D == null) {
                this.D = new fg<>(new y(this), 8, 0);
            }
            return this.D;
        }
        return (fg) invokeV.objValue;
    }

    public final void N3(PostData postData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048595, this, postData, z2) == null) || Q2()) {
            return;
        }
        if (postData != null) {
            if (postData.s() != null) {
                MetaData s2 = postData.s();
                this.G.W(s2.getUserId());
                this.G.b0(postData.K());
                boolean z3 = postData.f0;
                this.G.p(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fec), postData.s().getName_show(), postData.V() != null ? postData.V().toString() : ""));
                if (z3) {
                    if (!z2) {
                        this.G.V(s2.getName_show(), s2.getPortrait());
                    }
                } else if (!z2) {
                    this.G.V(s2.getName_show(), s2.getPortrait());
                }
            }
            this.j.m();
        }
        if (this.c0) {
            i3(false);
        }
    }

    @Override // com.repackage.ji5
    public fg<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.C == null) {
                this.C = new fg<>(new z(this), 8, 0);
            }
            return this.C;
        }
        return (fg) invokeV.objValue;
    }

    public final boolean O2() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.X == null || (subPbModel = this.c) == null || subPbModel.m0() == null || this.c.m0().a() == null || this.X.checkPrivacyBeforeInvokeEditor(this.c.m0().a().replyPrivateFlag) : invokeV.booleanValue;
    }

    public final void O3() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
            if (Q2()) {
                return;
            }
            if (booleanExtra) {
                if (this.X == null || (subPbModel = this.c) == null || subPbModel.k0() == null || E(TbadkCoreApplication.getCurrentAccount()) || this.X.checkPrivacyBeforeInvokeEditor(this.c.k0().replyPrivateFlag)) {
                    if (this.G.x()) {
                        this.G.v(null);
                        return;
                    }
                    this.j.D0();
                    this.j.m();
                    o45 o45Var = this.G;
                    if (o45Var != null) {
                        o45Var.k0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.a0 == null) {
                qo6 qo6Var = new qo6(getPageContext());
                this.a0 = qo6Var;
                qo6Var.i(new s(this));
            }
            SubPbModel subPbModel2 = this.c;
            if (subPbModel2 == null || subPbModel2.m0() == null || this.c.m0().d() == null) {
                return;
            }
            this.a0.g(this.c.m0().d().getId(), og.g(this.c.A0(), 0L));
        }
    }

    public void P2(boolean z2) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) || (editText = this.W) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.W.getSelectionEnd();
        SpannableStringBuilder f2 = this.V.f(this.W.getText());
        if (f2 != null) {
            this.V.l(true);
            this.W.setText(f2);
            if (z2 && this.V.b() >= 0) {
                this.W.requestFocus();
                this.W.setSelection(this.V.b());
            } else {
                this.W.setSelection(selectionEnd);
            }
            bz8 bz8Var = this.V;
            bz8Var.k(bz8Var.b() >= 0);
        }
    }

    public final void P3(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            fz7.e(this, getPageContext(), new j(this, sparseArray, i2, z2), new l(this));
        }
    }

    @Override // com.repackage.ji5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, str) == null) {
        }
    }

    public final boolean Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return false;
            }
            return AntiHelper.d(getPageContext(), subPbModel.k0());
        }
        return invokeV.booleanValue;
    }

    public final void Q3(View view2, o45 o45Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, view2, o45Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new d(this, view2, o45Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0cf0), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    @Override // com.repackage.ji5
    public void R(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048604, this, context, str, z2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (D3(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                s15 s15Var = new s15();
                s15Var.a = str;
                s15Var.b = 3;
                s15Var.c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, s15Var));
            }
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
        this.N = true;
    }

    public void R2(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092040) : "";
            this.j.t0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = og.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = og.g(str, 0L);
            this.J = sparseArray;
            BdUniqueId bdUniqueId = this.M;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ur4 ur4Var = new ur4(getPageContext().getPageActivity());
            ur4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b32));
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf5, new h0(this));
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new i0(this));
            ur4Var.create(this.I).show();
        }
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.G.y();
            } else if (StringUtils.isNull(this.c.y0())) {
            } else {
                if (this.j.B0() && qi.D()) {
                    this.j.i0();
                } else {
                    this.j.e0();
                }
            }
        }
    }

    public final void S3(boolean z2, SparseArray<Object> sparseArray) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048608, this, z2, sparseArray) == null) {
            String str = sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092040) : "";
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue()) {
                String[] strArr = new String[1];
                if (z2) {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f1497);
                } else {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f0b2f);
                }
                strArr[0] = string;
                wr4 wr4Var = new wr4(getPageContext().getPageActivity());
                wr4Var.k(R.string.obfuscated_res_0x7f0f0d03);
                wr4Var.j(strArr, new u(this, sparseArray, z2, str));
                wr4Var.c(getPageContext());
                wr4Var.m();
            }
        }
    }

    @Override // com.repackage.su7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return 0;
            }
            return subPbModel.E0();
        }
        return invokeV.intValue;
    }

    public final void T2(View view2) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view2) == null) {
            if (!oi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c3d);
            } else if (!ViewHelper.checkUpIsLogin(getActivity()) || (c2 = ur8.c(view2)) == null || this.t0 == null) {
            } else {
                this.t0.n(og.g(c2, 0L));
            }
        }
    }

    public final void T3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            if (str == null) {
                str = "";
            }
            ur4 ur4Var = new ur4(this.I.getPageActivity());
            ur4Var.setMessage(str);
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09a0, new f0(this));
            ur4Var.create(this.I).show();
        }
    }

    public final void U2(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, view2) == null) && view2.getTag() != null && (view2.getTag() instanceof SparseArray)) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (sparseArray.get(R.id.obfuscated_res_0x7f091fe8) instanceof PostData) {
                ((PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8)).B0();
            }
        }
    }

    public final void U3(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.j.t0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            ur4 ur4Var = new ur4(this.I.getPageActivity());
            if (pi.isEmpty(str)) {
                ur4Var.setMessage(this.I.getResources().getString(R.string.obfuscated_res_0x7f0f031e, str3));
            } else {
                ur4Var.setMessage(str);
            }
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0431, new d0(this, userMuteAddAndDelCustomMessage));
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new e0(this));
            ur4Var.create(this.I).show();
        }
    }

    @Override // com.repackage.ji5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048614, this, context, str, str2) == null) {
        }
    }

    public final void V2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view2) == null) {
            this.j.o();
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            if (sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f091fec) instanceof Integer) && (sparseArray.get(R.id.obfuscated_res_0x7f091fea) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f092008) instanceof Integer) && (sparseArray.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue();
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue();
                boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ffc)).booleanValue();
                boolean E = E(TbadkCoreApplication.getCurrentAccount());
                if (E) {
                    if (!booleanValue2) {
                        P3(sparseArray, intValue, booleanValue);
                    } else {
                        this.j.Z(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea), intValue, booleanValue, E);
                    }
                } else if (booleanValue && !booleanValue2) {
                    P3(sparseArray, intValue, booleanValue);
                } else {
                    this.j.Z(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea), intValue, booleanValue, E);
                }
            }
        }
    }

    public final void V3() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (subPbModel = this.c) == null || pi.isEmpty(subPbModel.A0())) {
            return;
        }
        dj4.w().P(cj4.Z, og.g(this.c.A0(), 0L));
    }

    public final void W2(View view2) {
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, view2) == null) && checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8);
            if (postData.q() == null) {
                return;
            }
            c3(postData.q());
        }
    }

    public void W3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.w0);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.repackage.su7
    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null || this.c.m0().l() == null) {
                return null;
            }
            return this.c.m0().l().getForum_name();
        }
        return (String) invokeV.objValue;
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.k == null || TextUtils.isEmpty(this.l)) {
            return;
        }
        if (this.m == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.l));
        } else {
            j55.a aVar = new j55.a();
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

    public final TbRichText X3(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048621, this, str, i2)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null || str == null || i2 < 0) {
                return null;
            }
            vt7 m02 = this.c.m0();
            TbRichText j3 = j3(m02.i(), str, i2);
            if (j3 != null || (j3 = j3(m02.i(), str, i2)) != null) {
            }
            return j3;
        }
        return (TbRichText) invokeLI.objValue;
    }

    @Override // com.repackage.ji5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, context, str) == null) {
        }
    }

    @Override // com.repackage.ji5
    public fg<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.A == null) {
                this.A = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (fg) invokeV.objValue;
    }

    public final void Y2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, view2) == null) {
            if (!oi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c3d);
                return;
            }
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            if (sparseArray == null) {
                return;
            }
            boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue();
            boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09202e)).booleanValue();
            boolean booleanValue3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue();
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092000) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092000)).booleanValue() : false;
            if (!booleanValue) {
                if (booleanValue2) {
                    this.j.Z(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue(), false);
                }
            } else if (booleanValue3) {
                sparseArray.put(R.id.obfuscated_res_0x7f091ffb, 1);
                sparseArray.put(R.id.obfuscated_res_0x7f091fe4, 2);
                R2(sparseArray);
            } else {
                if (booleanValue4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091fe4, 2);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f092009, Boolean.TRUE);
                this.j.b0(view2);
            }
        }
    }

    public final void Z2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
            this.j.o();
            if (checkUpIsLogin()) {
                J3(view2);
            }
        }
    }

    public final void a3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
            if (!oi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c3d);
                return;
            }
            Object tag = view2.getTag();
            this.j.o();
            if (tag instanceof String) {
                String str = (String) tag;
                if (checkUpIsLogin()) {
                    r3(str);
                }
            } else if (tag instanceof SparseArray) {
                SparseArray<Object> sparseArray = (SparseArray) tag;
                if ((sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue()) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffb, 0);
                    sparseArray.put(R.id.obfuscated_res_0x7f091fe4, 2);
                    R2(sparseArray);
                }
            }
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || this.k == null || TextUtils.isEmpty(this.l)) {
            return;
        }
        if (this.e == null) {
            this.e = new PermissionJudgePolicy();
        }
        this.e.clearRequestPermissionList();
        this.e.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.e.startRequestPermission(getPageContext().getPageActivity())) {
            return;
        }
        if (this.f == null) {
            this.f = new sx7(getPageContext());
        }
        this.f.b(this.l, this.k.n());
        this.k = null;
        this.l = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c3(AgreeData agreeData) {
        o95 currentVisiblePageExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.i0 == null) {
            this.i0 = new nu4();
        }
        if (this.q0 == null) {
            sk8 sk8Var = new sk8();
            this.q0 = sk8Var;
            sk8Var.a = this.j0;
        }
        lo4 lo4Var = new lo4();
        lo4Var.b = 12;
        lo4Var.h = 9;
        lo4Var.g = 3;
        if (m3() != null) {
            lo4Var.f = m3().x0();
        }
        lo4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                lo4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.i0.c(agreeData, i2, getUniqueId(), false);
                this.i0.d(agreeData, this.q0);
                if (m3() != null || m3().m0() == null) {
                }
                this.i0.b(this, lo4Var, agreeData, m3().m0().l());
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
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
        if (currentVisiblePageExtra != null) {
        }
        this.i0.c(agreeData, i2, getUniqueId(), false);
        this.i0.d(agreeData, this.q0);
        if (m3() != null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (this.O && !this.h0 && !this.P && !this.Q) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            } else {
                super.closeAnimation();
            }
        }
    }

    public final void d3(View view2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, view2) == null) && O2() && checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092005) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092005)) != null) {
                boolean z2 = true;
                if (this.c != null) {
                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.c.B0()).param("fid", this.c.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.K()).param("obj_source", 1).param("obj_type", 3));
                }
                N3(postData, ((view2.getTag(R.id.obfuscated_res_0x7f092034) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f092034) == Boolean.TRUE) ? false : false);
            }
        }
    }

    @Override // com.repackage.ji5
    public fg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, voiceModel)) == null) {
            View z2 = this.j.z();
            if (z2 == null || (findViewWithTag = z2.findViewWithTag(voiceModel)) == null) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final boolean e3(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        bm4 bm4Var;
        boolean z2;
        boolean z3;
        boolean z4;
        List<bs4> c2;
        bs4 bs4Var;
        bs4 bs4Var2;
        bs4 bs4Var3;
        bs4 bs4Var4;
        bs4 bs4Var5;
        bs4 bs4Var6;
        zm zmVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (E3(view2)) {
                    if (view2 instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view2;
                        this.k = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.l = url;
                        if (this.k == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f092024) != null && (view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextImageInfo)) {
                            this.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
                        } else {
                            this.m = null;
                        }
                    } else if (view2 instanceof GifView) {
                        GifView gifView = (GifView) view2;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.k = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.l = gifView.getBdImage().q();
                        }
                        if (view2.getTag(R.id.obfuscated_res_0x7f092024) != null && (view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextImageInfo)) {
                            this.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f092024) != null && (view2.getTag(R.id.obfuscated_res_0x7f092024) instanceof TbRichTextImageInfo)) {
                                this.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092024);
                            } else {
                                this.m = null;
                            }
                        }
                    }
                    if (view2.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                        }
                    } else if (view2.getParent().getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view2.getParent().getParent()).getTag();
                        } catch (ClassCastException e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        this.j.x0(this.F0, this.k.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091fe8);
            this.n = postData;
            if (postData == null || (bm4Var = this.g) == null) {
                return true;
            }
            if (bm4Var != null) {
                bm4Var.h(this.c.O0());
            }
            boolean z5 = this.g.e() && this.n.K() != null && this.n.K().equals(this.c.v0());
            boolean z6 = (this.c.m0() == null || this.c.m0().l() == null || !this.c.m0().l().isBjh()) ? false : true;
            if (this.p == null) {
                fs4 fs4Var = new fs4(getBaseContext());
                this.p = fs4Var;
                fs4Var.n(this.q);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean z7 = E3(view2) && !z6;
            boolean z8 = (!E3(view2) || (zmVar = this.k) == null || zmVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092001) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092001)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091feb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f09202e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09202e)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091ff8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ff8) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f092000) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092000)).booleanValue() : false;
            if (z7) {
                z2 = booleanValue7;
                z4 = booleanValue6;
                z3 = booleanValue5;
                arrayList.add(new bs4(1, getString(R.string.obfuscated_res_0x7f0f108d), this.p));
            } else {
                z2 = booleanValue7;
                z3 = booleanValue5;
                z4 = booleanValue6;
            }
            if (z8) {
                arrayList.add(new bs4(2, getString(R.string.obfuscated_res_0x7f0f108e), this.p));
            }
            if (!z7 && !z8) {
                bs4 bs4Var7 = new bs4(3, getString(R.string.obfuscated_res_0x7f0f044d), this.p);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091fe8, this.n);
                bs4Var7.d.setTag(sparseArray3);
                arrayList.add(bs4Var7);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    bs4Var6 = new bs4(4, getString(R.string.obfuscated_res_0x7f0f0fd1), this.p);
                } else {
                    bs4Var6 = new bs4(4, getString(R.string.obfuscated_res_0x7f0f0a90), this.p);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091fe8, this.n);
                sparseArray4.put(R.id.obfuscated_res_0x7f092001, Boolean.FALSE);
                bs4Var6.d.setTag(sparseArray4);
                arrayList.add(bs4Var6);
            }
            if (this.mIsLogin && !this.r0) {
                if (!fz7.j(m3().m0()) && !booleanValue4 && booleanValue3) {
                    bs4 bs4Var8 = new bs4(5, getString(R.string.obfuscated_res_0x7f0f0b33), this.p);
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
                    if ((G3(booleanValue2) && isLogin()) && !z6) {
                        bs4 bs4Var9 = new bs4(5, getString(R.string.obfuscated_res_0x7f0f0ff6), this.p);
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
                    if (!fz7.j(m3().m0()) && z3) {
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
                    if (z4) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                        sparseArray6.put(R.id.obfuscated_res_0x7f092000, Boolean.valueOf(z2));
                        if (z2) {
                            bs4Var5 = new bs4(6, getString(R.string.obfuscated_res_0x7f0f04ab), this.p);
                            bs4Var5.d.setTag(sparseArray6);
                            bs4Var2 = new bs4(7, getString(R.string.obfuscated_res_0x7f0f02e3), this.p);
                            bs4Var2.d.setTag(sparseArray6);
                            bs4Var3 = bs4Var5;
                            bs4Var = null;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                    }
                    bs4Var5 = null;
                    bs4Var2 = new bs4(7, getString(R.string.obfuscated_res_0x7f0f02e3), this.p);
                    bs4Var2.d.setTag(sparseArray6);
                    bs4Var3 = bs4Var5;
                    bs4Var = null;
                } else if (z4) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f092008, sparseArray.get(R.id.obfuscated_res_0x7f092008));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091fea, sparseArray.get(R.id.obfuscated_res_0x7f091fea));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091ffc, sparseArray.get(R.id.obfuscated_res_0x7f091ffc));
                    if (o3() == 1002 && !booleanValue2) {
                        bs4Var4 = new bs4(6, getString(R.string.obfuscated_res_0x7f0f0ff6), this.p);
                    } else {
                        bs4Var4 = new bs4(6, getString(R.string.obfuscated_res_0x7f0f04ab), this.p);
                    }
                    bs4Var4.d.setTag(sparseArray7);
                    bs4Var = new bs4(13, getString(R.string.obfuscated_res_0x7f0f0b23), this.p);
                    bs4Var3 = bs4Var4;
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
                fz7.a(arrayList, this.p, this.n, this.c.m0());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                c2 = fz7.d(arrayList, this.n.q(), sparseArray, this.p);
            } else {
                c2 = fz7.c(arrayList, this.n.q(), sparseArray, this.p);
            }
            fz7.l(c2, true);
            fz7.f(c2);
            this.p.o(fz7.g(this.n));
            if (UbsABTestHelper.isPBPlanA()) {
                this.p.k(c2, false);
            } else {
                this.p.k(c2, true);
            }
            o45 o45Var = this.G;
            if (o45Var != null) {
                o45Var.y();
            }
            ds4 ds4Var = new ds4(getPageContext(), this.p);
            this.o = ds4Var;
            ds4Var.k();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.O && !this.h0 && !this.P && !this.Q) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    public void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", qz7.q0);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.repackage.ji5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, context, str) == null) {
        }
    }

    public final String g3(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, tbRichTextData)) == null) {
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
                sb.append(pi.getUrlEncode(F.F()));
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.u95
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? "a007" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ji5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            qz7 qz7Var = this.j;
            if (qz7Var != null) {
                return qz7Var.B();
            }
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || pi.isEmpty(subPbModel.A0())) {
                return 0L;
            }
            return og.g(this.c.A0(), 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public x95 getPageStayDurationItem() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            x95 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (subPbModel = this.c) != null) {
                if (subPbModel.m0() != null && this.c.m0().d() != null) {
                    pageStayDurationItem.t(og.g(this.c.m0().d().getId(), 0L));
                }
                pageStayDurationItem.C(og.g(this.c.A0(), 0L));
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
                pageStayDurationItem.w(og.g(this.c.B(), 0L));
            }
            return pageStayDurationItem;
        }
        return (x95) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.u95
    public v95 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? new c0(this) : (v95) invokeV.objValue;
    }

    public void h3(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048643, this, bVar, z2) == null) || bVar == null) {
            return;
        }
        int i2 = 0;
        this.j.s(0, bVar.a, bVar.b, z2);
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                if (this.j.B() instanceof BdTypeListView) {
                    List<on> data = ((BdTypeListView) this.j.B()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        while (i2 < data.size() && (!(data.get(i2) instanceof PostData) || !bVar.g.equals(((PostData) data.get(i2)).K()))) {
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
                this.j.A0(this.c.m0(), this.c.E0(), this.c.D0() != null, false);
                if (this.c.P0()) {
                    this.c.b1(false);
                    this.j.l();
                    this.c.loadData();
                }
            }
            ls7 ls7Var = new ls7();
            ls7Var.b(bVar);
            ls7Var.c(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, ls7Var));
        }
    }

    public final void i3(boolean z2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        int i2;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z2) == null) {
            Rect rect = new Rect();
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
                frameLayout.getWindowVisibleDisplayFrame(rect);
                if (z2) {
                    ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                    childAt.requestLayout();
                }
            }
            qz7 qz7Var = this.j;
            if (qz7Var == null || qz7Var.B() == null || (pbCommenFloorItemViewHolder = this.f0) == null || (i2 = pbCommenFloorItemViewHolder.Z) == -1) {
                return;
            }
            int headerViewsCount = i2 + this.j.B().getHeaderViewsCount();
            if (this.f0.getView() != null) {
                int height = this.f0.getView().getHeight();
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

    public final TbRichText j3(PostData postData, String str, int i2) {
        InterceptResult invokeLLI;
        TbRichText V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048645, this, postData, str, i2)) == null) {
            if (postData != null && (V = postData.V()) != null) {
                ArrayList<TbRichTextData> B = V.B();
                int size = B.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (B.get(i4) != null && B.get(i4).getType() == 8) {
                        i3++;
                        if (B.get(i4).F().B().equals(str)) {
                            int h2 = (int) qi.h(TbadkCoreApplication.getInst());
                            int width = B.get(i4).F().getWidth() * h2;
                            int height = B.get(i4).F().getHeight() * h2;
                            if (width < 80 || height < 80 || width * height < 10000) {
                                return null;
                            }
                            this.b = i4;
                            return V;
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

    public final int k3(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048646, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.E0 = true;
            }
            if (tbRichText != null && tbRichText.B() != null) {
                int size = tbRichText.B().size();
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    if (tbRichText.B().get(i5) != null && tbRichText.B().get(i5).getType() == 8) {
                        i4++;
                        int h2 = (int) qi.h(TbadkCoreApplication.getInst());
                        int width = tbRichText.B().get(i5).F().getWidth() * h2;
                        int height = tbRichText.B().get(i5).F().getHeight() * h2;
                        if (!(width < 80 || height < 80 || width * height < 10000) && tbRichText.B().get(i5).F().H()) {
                            TbRichTextData tbRichTextData = tbRichText.B().get(i5);
                            String g3 = g3(tbRichTextData);
                            arrayList.add(g3);
                            if (!TextUtils.isEmpty(g3) && tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                String B = F.B();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = B;
                                imageUrlData.urlType = this.a ? 17 : 18;
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(g3, imageUrlData);
                                }
                            }
                            if (!this.E0) {
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

    public String l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (!pi.isEmpty(this.e0)) {
                return this.e0;
            }
            String string = getResources().getString(lx7.b());
            this.e0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public SubPbModel m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.c : (SubPbModel) invokeV.objValue;
    }

    public final ThreadData n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null) {
                return null;
            }
            return this.c.m0().l();
        }
        return (ThreadData) invokeV.objValue;
    }

    public int o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.E0();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048651, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25035) {
                p3(i3, intent);
            }
            o45 o45Var = this.G;
            if (o45Var != null) {
                o45Var.C(i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            o45 o45Var = this.G;
            if (o45Var != null && o45Var.a() != null && this.G.a().u()) {
                this.G.a().q();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.j.X(i2);
            if (!this.P || UtilHelper.isFlyMeOs()) {
                return;
            }
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, bundle) == null) {
            w3(bundle);
            y3(bundle);
            z3(bundle);
            x3(bundle);
            v3(bundle);
            if (getIntent() != null) {
                this.h0 = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
                if (this.P) {
                    this.w0 = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
                }
            }
            super.onCreate(bundle);
            this.I = getPageContext();
            this.L = true;
            bz8 bz8Var = new bz8();
            this.V = bz8Var;
            bz8Var.h(R.color.cp_cont_h_alpha85);
            this.V.j(R.color.CAM_X0101);
            A3();
            s3();
            t3(bundle);
            B3();
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
            u3(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.j.k(this.h0);
            wu4 wu4Var = new wu4();
            this.K = wu4Var;
            wu4Var.a = 1000L;
            registerListener(this.C0);
            registerListener(this.A0);
            registerListener(this.B0);
            registerListener(this.y0);
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
            this.X = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new a(this));
            oz7 oz7Var = new oz7(this);
            this.d = oz7Var;
            oz7Var.b(getUniqueId());
            this.Z = new ry7(this);
            this.t0 = new vr8(getPageContext(), getUniqueId());
            if (this.u0 == null) {
                if (this.S) {
                    this.u0 = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.u0 = new TiePlusEventController(this, TiePlusStat.Locate.PB_COMMENT);
                }
                this.u0.k(this.v0);
            }
            k05.b(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
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
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.C0);
            MessageManager.getInstance().unRegisterListener(this.M);
            vr8 vr8Var = this.t0;
            if (vr8Var != null) {
                vr8Var.l();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.X;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            this.I = null;
            this.K = null;
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            this.c0 = z2;
            i3(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            this.H = true;
            super.onPause();
            TiePlusEventController tiePlusEventController = this.u0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            jz7.a();
            dj4.w().E();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.G0);
            this.j.V();
            if (this.P || this.Q) {
                W3(false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.repackage.g9
    public void onPreLoad(sn snVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, snVar) == null) {
            PreLoadImageHelper.load(snVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(snVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            this.H = false;
            super.onResume();
            TiePlusEventController tiePlusEventController = this.u0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            V3();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.G0);
            this.j.W();
            if (this.P || this.Q) {
                W3(true);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            if (this.j.B0() && qi.D()) {
                this.c.loadData();
            } else {
                this.j.e0();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            this.G.E();
        }
    }

    public final void p3(int i2, Intent intent) {
        t25 t25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048665, this, i2, intent) == null) {
            this.G.a().q();
            this.G.y();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.G.B(writeData);
                this.G.d0(pbEditorData.getVoiceModel());
                s25 n2 = this.G.a().n(6);
                if (n2 != null && (t25Var = n2.m) != null) {
                    t25Var.A(new h25(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.G.F();
                }
                this.j.M();
            }
        }
    }

    public void q3(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048666, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092041) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092041) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092043) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092043) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092042) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092042) : "";
            if (sparseArray.get(R.id.obfuscated_res_0x7f09203e) instanceof String) {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e);
            }
            String str5 = str4;
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f09203e) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e) : "";
            String str7 = sparseArray.get(R.id.obfuscated_res_0x7f09203f) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f09203f) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str5, 1, str6, this.M);
            userMuteAddAndDelCustomMessage.setTag(this.M);
            U3(z2, userMuteAddAndDelCustomMessage, str6, str2, str7);
        }
    }

    public void r3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
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
                I3(format);
                return;
            }
            this.d.a(str);
        }
    }

    public void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            this.v = new e(this);
            this.w = new f(this);
            this.y = new g(this);
            this.z = new h(this);
            this.x = new i(this);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.i : (VoiceManager) invokeV.objValue;
    }

    public void t3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, bundle) == null) {
            SubPbModel subPbModel = new SubPbModel(getPageContext());
            this.c = subPbModel;
            subPbModel.a1(new c(this));
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.h = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.x);
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            bm4 b2 = bm4.b(this);
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

    @Override // com.repackage.su7
    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null || this.c.m0().l() == null) {
                return false;
            }
            return !this.c.m0().l().isMutiForumThread();
        }
        return invokeV.booleanValue;
    }

    public final void u3(boolean z2) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z2) == null) {
            o45 o45Var = (o45) new p45(z2).a(getActivity());
            this.G = o45Var;
            if (o45Var != null) {
                o45Var.N(getPageContext());
                this.G.a0(this.c);
                this.G.Q(this.z0);
                this.G.O(2);
                this.G.U(this.d0);
                this.G.M(this.x0);
                this.G.a().C(true);
                this.G.z(getPageContext());
                this.G.P(this.R);
            }
            qz7 qz7Var = this.j;
            if (qz7Var != null) {
                qz7Var.R(this.G);
            }
            o45 o45Var2 = this.G;
            if (o45Var2 != null && (subPbModel = this.c) != null) {
                o45Var2.G(subPbModel.k0());
                this.G.y();
            }
            o45 o45Var3 = this.G;
            if (o45Var3 == null) {
                return;
            }
            o45Var3.t().l(l3());
            this.G.t().m(l3());
            EditText i2 = this.G.t().i();
            this.W = i2;
            i2.addTextChangedListener(new t(this));
        }
    }

    @Override // com.repackage.ji5
    public fg<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            if (this.B == null) {
                this.B = new fg<>(new x(this), 20, 0);
            }
            return this.B;
        }
        return (fg) invokeV.objValue;
    }

    public final boolean v3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048674, this, bundle)) == null) {
            if (bundle != null) {
                this.Q = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            } else {
                this.Q = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            }
            return this.Q;
        }
        return invokeL.booleanValue;
    }

    public final boolean w3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048675, this, bundle)) == null) {
            if (bundle != null) {
                this.O = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            } else {
                this.O = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            }
            return this.O;
        }
        return invokeL.booleanValue;
    }

    public final boolean x3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, bundle)) == null) {
            if (bundle != null) {
                this.S = bundle.getBoolean("is_jump_from_video_middle");
            } else {
                this.S = getIntent().getBooleanExtra("is_jump_from_video_middle", false);
            }
            return this.S;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ji5
    public fg<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            if (this.E == null) {
                this.E = new fg<>(new a0(this), 15, 0);
            }
            return this.E;
        }
        return (fg) invokeV.objValue;
    }

    @Override // com.repackage.ji5
    public fg<TiebaPlusRecommendCard> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    public final boolean y3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, bundle)) == null) {
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

    @Override // com.repackage.su7
    public ry7 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.Z : (ry7) invokeV.objValue;
    }

    public final int z3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, bundle)) == null) {
            if (bundle != null) {
                this.R = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                this.R = getIntent().getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.R;
        }
        return invokeL.intValue;
    }
}
