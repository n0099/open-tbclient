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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.a19;
import com.baidu.tieba.a75;
import com.baidu.tieba.au4;
import com.baidu.tieba.b18;
import com.baidu.tieba.b75;
import com.baidu.tieba.bc5;
import com.baidu.tieba.bu7;
import com.baidu.tieba.bx4;
import com.baidu.tieba.c08;
import com.baidu.tieba.cu4;
import com.baidu.tieba.d18;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.dl4;
import com.baidu.tieba.do4;
import com.baidu.tieba.ej;
import com.baidu.tieba.el4;
import com.baidu.tieba.ez7;
import com.baidu.tieba.f45;
import com.baidu.tieba.f55;
import com.baidu.tieba.g55;
import com.baidu.tieba.gh;
import com.baidu.tieba.h18;
import com.baidu.tieba.ho;
import com.baidu.tieba.hu4;
import com.baidu.tieba.hx4;
import com.baidu.tieba.ic5;
import com.baidu.tieba.iw7;
import com.baidu.tieba.ju4;
import com.baidu.tieba.kc5;
import com.baidu.tieba.kq6;
import com.baidu.tieba.l15;
import com.baidu.tieba.lc5;
import com.baidu.tieba.lm8;
import com.baidu.tieba.lo4;
import com.baidu.tieba.lu4;
import com.baidu.tieba.lv7;
import com.baidu.tieba.lx4;
import com.baidu.tieba.on;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.q9;
import com.baidu.tieba.r9;
import com.baidu.tieba.rq4;
import com.baidu.tieba.s08;
import com.baidu.tieba.st8;
import com.baidu.tieba.t65;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tt8;
import com.baidu.tieba.u45;
import com.baidu.tieba.u65;
import com.baidu.tieba.ug;
import com.baidu.tieba.up4;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.v75;
import com.baidu.tieba.vg;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.vk5;
import com.baidu.tieba.vt8;
import com.baidu.tieba.w08;
import com.baidu.tieba.x25;
import com.baidu.tieba.xw4;
import com.baidu.tieba.xy7;
import com.baidu.tieba.y25;
import com.baidu.tieba.yk5;
import com.baidu.tieba.yy4;
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
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.j, yk5, BdListView.p, iw7<NewSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String H0 = "tbgametype";
    public transient /* synthetic */ FieldHolder $fh;
    public ug<TextView> A;
    public CustomMessageListener A0;
    public ug<GifView> B;
    public CustomMessageListener B0;
    public ug<View> C;
    public final lx4.g C0;
    public ug<ImageView> D;
    public boolean D0;
    public ug<LinearLayout> E;
    public final cu4.c E0;
    public ug<RelativeLayout> F;
    public CustomMessageListener F0;
    public a75 G;
    public CustomMessageListener G0;
    public boolean H;
    public r9 I;
    public Object J;
    public hx4 K;
    public boolean L;
    public BdUniqueId M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public boolean S;
    public boolean T;
    public a19 U;
    public EditText V;
    public ReplyPrivacyCheckController W;
    public bu7<lv7> X;
    public c08 Y;
    public kq6 Z;
    public boolean a;
    public PostWriteCallBackData a0;
    public int b;
    public boolean b0;
    public SubPbModel c;
    public u65 c0;
    public b18 d;
    public String d0;
    public PermissionJudgePolicy e;
    public PbCommenFloorItemViewHolder e0;
    public ez7 f;
    public int f0;
    public do4 g;
    public boolean g0;
    public ForumManageModel h;
    public xw4 h0;
    public VoiceManager i;
    public BdUniqueId i0;
    public d18 j;
    public lm8 j0;
    public on k;
    public String l;
    public TbRichTextMemeInfo m;
    public PostData n;
    public ju4 o;
    public lu4 p;
    public lu4.e q;
    public boolean q0;
    public View.OnClickListener r;
    public boolean r0;
    public AbsListView.OnScrollListener s;
    public tt8 s0;
    public View.OnLongClickListener t;
    @Nullable
    public TiePlusEventController t0;
    public TbRichTextView.y u;
    @NonNull
    public TiePlusEventController.f u0;
    public SubPbModel.b v;
    public BdUniqueId v0;
    public do4.a w;
    public t65 w0;
    public q9 x;
    public CustomMessageListener x0;
    public s0 y;
    public NewWriteModel.d y0;
    public s0 z;
    public CustomMessageListener z0;

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
    public class a0 implements vg<LinearLayout> {
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.c == null) {
                return;
            }
            this.a.c.loadData();
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements vg<RelativeLayout> {
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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
    public class c0 extends ic5 {
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

        @Override // com.baidu.tieba.ic5
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? lc5.b().c() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.ic5
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ a75 b;
        public final /* synthetic */ NewSubPbActivity c;

        public d(NewSubPbActivity newSubPbActivity, View view2, a75 a75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, view2, a75Var};
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
            this.b = a75Var;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, str) == null) {
                this.a.performClick();
                this.b.r();
                this.b.u().i().setText(str);
                Editable text = this.b.u().i().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.b.u().i().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements au4.e {
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

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                this.b.j.t0();
                MessageManager.getInstance().sendMessage(this.a);
                au4Var.dismiss();
            }
        }
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
            public final /* synthetic */ lv7 a;
            public final /* synthetic */ e b;

            public a(e eVar, lv7 lv7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, lv7Var};
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
                this.a = lv7Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.r0 = false;
                    this.b.a.q4(this.a.i(), false);
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
        public void a(boolean z, int i, String str, lv7 lv7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, lv7Var}) == null) || this.a.j == null) {
                return;
            }
            this.a.j.e0();
            if (this.a.P && this.a.j.u() != null) {
                NewSubPbActivity newSubPbActivity = this.a;
                newSubPbActivity.hideLoadingView(newSubPbActivity.j.u());
            }
            if (!z) {
                this.a.o4(i, str);
                return;
            }
            this.a.j.L();
            if (lv7Var != null) {
                if (lv7Var.i() != null || this.a.c != null) {
                    lv7Var.i().Y0(this.a.c.z0());
                }
                if (this.a.j != null) {
                    this.a.Q3(lv7Var.l() != null && lv7Var.l().isBjh());
                    if (this.a.G != null && this.a.G.a() != null) {
                        this.a.G.a().w(TbadkCoreApplication.getInst().getSkinType());
                    }
                    this.a.j.A0(lv7Var, this.a.c.E0(), this.a.c.D0() != null, this.a.L);
                    if (this.a.L) {
                        this.a.j.B().setSelectionFromTop(this.a.j.B().getHeaderViewsCount() + 1, -ej.f(this.a, R.dimen.tbds18));
                        this.a.f3();
                        this.a.L = false;
                    }
                }
                if (this.a.G != null) {
                    this.a.G.H(lv7Var.a());
                    this.a.G.d0(lv7Var.l());
                    if (this.a.getIntent() != null && this.a.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && this.a.r0) {
                        gh.a().postDelayed(new a(this, lv7Var), 200L);
                    }
                }
                if (this.a.X == null) {
                    this.a.X = new bu7();
                }
                this.a.X.b(lv7Var);
                this.a.X.c(0);
                NewSubPbActivity newSubPbActivity2 = this.a;
                newSubPbActivity2.W.setLikeUserData(newSubPbActivity2.c.l0());
            }
            String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || this.a.T) {
                return;
            }
            this.a.T = true;
            NewSubPbActivity newSubPbActivity3 = this.a;
            newSubPbActivity3.t4(newSubPbActivity3.j.G(), this.a.G, stringExtra);
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements au4.e {
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

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements do4.a {
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

        @Override // com.baidu.tieba.do4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.g != null) {
                        this.a.g.h(z2);
                    }
                    MarkData f = this.a.g.f();
                    bu7 bu7Var = new bu7();
                    bu7Var.c(2);
                    if (z2) {
                        bu7Var.b(f);
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
                        bu7Var.b(null);
                        this.a.c.c1(false);
                        this.a.c.d1(null);
                        NewSubPbActivity newSubPbActivity2 = this.a;
                        newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ff1));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, bu7Var));
                    return;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14e5));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements au4.e {
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

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
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

    /* loaded from: classes5.dex */
    public class g0 implements t65 {
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

        @Override // com.baidu.tieba.t65
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
                    this.a.c3(true);
                    return true;
                }
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (newSubPbActivity2.W == null || newSubPbActivity2.c == null || this.a.c.k0() == null || this.a.F(TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                return !newSubPbActivity3.W.checkPrivacyBeforeSend(newSubPbActivity3.c.k0().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR);
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
                    if (this.a.h.S() || objArr == null || objArr.length < 4) {
                        return;
                    }
                    String valueOf = String.valueOf(objArr[0]);
                    int e = dh.e(String.valueOf(objArr[1]), 0);
                    boolean b = dh.b(String.valueOf(objArr[2]), false);
                    int e2 = dh.e(String.valueOf(objArr[3]), 0);
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

    /* loaded from: classes5.dex */
    public class h0 implements au4.e {
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

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    au4Var.dismiss();
                    ((TbPageContext) this.a.I).showToast(R.string.obfuscated_res_0x7f0f0720);
                    return;
                }
                TiebaStatic.log("c10025");
                au4Var.dismiss();
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
                    if (loadDataMode == 0) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.v3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
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

    /* loaded from: classes5.dex */
    public class i0 implements au4.e {
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

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements au4.e {
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

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                if (au4Var != null) {
                    au4Var.dismiss();
                }
                if (this.d.z != null) {
                    this.d.z.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f09203c), Integer.valueOf(this.b), Boolean.valueOf(this.c), this.a.get(R.id.obfuscated_res_0x7f09203e)});
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

    /* loaded from: classes5.dex */
    public class k implements u65 {
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

        @Override // com.baidu.tieba.u65
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.j == null || this.c.j.B() == null) {
                return;
            }
            this.c.j.B().setSelectionFromTop(this.a, this.c.j.D() - this.b);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements au4.e {
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

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.d.j == null || this.d.j.B() == null) {
                return;
            }
            this.d.j.B().setSelectionFromTop(this.a, this.d.j.D() + (this.b - this.c));
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.a.j == null) {
                return;
            }
            boolean z = true;
            if (view2 == this.a.j.A()) {
                this.a.j.o();
                String H3 = this.a.H3(view2, R.id.obfuscated_res_0x7f09208f);
                String H32 = this.a.H3(view2, R.id.obfuscated_res_0x7f092097);
                String H33 = this.a.H3(view2, R.id.obfuscated_res_0x7f092099);
                if (!TextUtils.isEmpty(H33)) {
                    if (this.a.checkUpIsLogin()) {
                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{H33});
                    }
                } else if (TextUtils.isEmpty(H3)) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), H3, H32, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                }
            } else if (view2 == this.a.j.G()) {
                if (this.a.b3() && this.a.checkUpIsLogin()) {
                    this.a.r4();
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
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091809 || view2.getId() == R.id.obfuscated_res_0x7f091865) {
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
                            if (this.a.h4(this.a.c.m0().l())) {
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
                            this.a.e0 = (PbCommenFloorItemViewHolder) view2.getTag();
                            if (this.a.b3() && ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
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
                                SparseArray sparseArray = (SparseArray) view2.getTag(R.id.obfuscated_res_0x7f09204d);
                                if (sparseArray == null) {
                                    return;
                                }
                                this.a.p4(sparseArray, ((view2.getTag(R.id.obfuscated_res_0x7f092086) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f092086) == Boolean.TRUE) ? false : false);
                                if (sparseArray.get(R.id.obfuscated_res_0x7f09203a) instanceof PostData) {
                                    PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a);
                                    h18.a(this.a.c != null ? this.a.c.A0() : "", postData.s() == null ? "" : postData.s().getUserId(), postData.L());
                                }
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091a41 || view2.getId() == R.id.obfuscated_res_0x7f091805) {
                            this.a.r3(view2);
                        } else if (view2 == this.a.j.w()) {
                            if (this.a.b3() && this.a.G != null && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                                this.a.G.g0();
                                this.a.t3();
                            }
                        } else if (view2.getId() != R.id.obfuscated_res_0x7f090786 && view2.getId() != R.id.obfuscated_res_0x7f090a0c) {
                            if (view2.getId() == R.id.obfuscated_res_0x7f091835 && ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1389);
                                String q = bx4.k().q("tail_link", "");
                                if (StringUtils.isNull(q)) {
                                    return;
                                }
                                TiebaStatic.log("c10056");
                                lo4.s(view2.getContext(), string, q, true, true, true);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091c1b && (view2.getTag() instanceof SparseArray)) {
                                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09203a);
                                if (obj instanceof PostData) {
                                    PostData postData2 = (PostData) obj;
                                    if (postData2.getType() == PostData.N0 || TextUtils.isEmpty(postData2.t()) || !up4.c().g()) {
                                        return;
                                    }
                                    this.a.n4(postData2.L());
                                }
                            }
                        } else {
                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                            if (sparseArray2 == null || !(sparseArray2.get(R.id.obfuscated_res_0x7f092057) instanceof PostData)) {
                                return;
                            }
                            PostData postData3 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f092057);
                            View view3 = (View) sparseArray2.get(R.id.obfuscated_res_0x7f092059);
                            if (postData3 == null || view3 == null) {
                                return;
                            }
                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090787);
                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090788);
                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a0c);
                            if (postData3.q0()) {
                                postData3.Q0(false);
                                w08.e(postData3);
                            } else {
                                if (this.a.c != null ? w08.c(this.a.c.m0(), postData3) : false) {
                                    postData3.Q0(true);
                                }
                            }
                            SkinManager.setBackgroundColor(findViewById, postData3.q0() ? R.color.CAM_X0201 : R.color.transparent);
                            boolean q0 = postData3.q0();
                            int i = R.color.CAM_X0304;
                            SkinManager.setViewTextColor(eMTextView, q0 ? R.color.CAM_X0304 : R.color.CAM_X0107);
                            int i2 = postData3.q0() ? R.drawable.obfuscated_res_0x7f080981 : R.drawable.obfuscated_res_0x7f080980;
                            if (!postData3.q0()) {
                                i = R.color.CAM_X0107;
                            }
                            WebPManager.setPureDrawable(imageView, i2, i, null);
                        }
                    } else if (this.a.checkUpIsLogin()) {
                        if (this.a.G.B()) {
                            this.a.G.z();
                        } else {
                            this.a.G.l0(null, null);
                        }
                    }
                }
            } else if (this.a.checkUpIsLogin()) {
                this.a.j.D0();
                this.a.j.m();
                if (this.a.G != null) {
                    this.a.G.g0();
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
    public class n0 implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes5.dex */
        public class a implements au4.e {
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

            @Override // com.baidu.tieba.au4.e
            public void onClick(au4 au4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                    au4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements au4.e {
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

            @Override // com.baidu.tieba.au4.e
            public void onClick(au4 au4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                    au4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l15 l15Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l15Var, writeData, antiData}) == null) {
                if (z && this.a.G != null && this.a.G.a() != null) {
                    this.a.G.a().o();
                    if (this.a.c.K0()) {
                        TiebaStatic.log(new StatisticItem("c10367").param("post_id", this.a.c.B()));
                    }
                }
                if (z) {
                    if (writeData != null) {
                        yy4.b(writeData.getContent(), "4");
                    }
                    this.a.U.n(null);
                    this.a.U.i(null);
                    this.a.U.k(false);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        y25.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    this.a.U.i(postWriteCallBackData.getSensitiveWords());
                    this.a.U.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.a.U.a())) {
                        return;
                    }
                    this.a.a0 = postWriteCallBackData;
                    if (this.a.G.y()) {
                        this.a.G.w(this.a.a0);
                    }
                    this.a.c3(true);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0480), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    au4 au4Var = new au4(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        au4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d11));
                    } else {
                        au4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new a(this));
                    au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new b(this));
                    au4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && (replyPrivacyCheckController = this.a.W) != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
                this.a.j.e0();
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
                if (this.a.j == null || !this.a.j.S()) {
                    return this.a.s3(view2);
                }
                return false;
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
                    this.a.K.d(this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f0b4e));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f0b4a);
                    }
                    this.a.w4(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.u4();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (dj.isEmpty(errorString2)) {
                        errorString2 = this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f0b4b);
                    }
                    this.a.K.c(errorString2);
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
                    if (!(view2.getTag(R.id.obfuscated_res_0x7f092076) instanceof TbRichTextMemeInfo) || ((TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092076)).memeInfo == null || !(view2 instanceof TbImageView)) {
                        lv7 m0 = this.a.c.m0();
                        TbRichText A4 = this.a.A4(str, i);
                        TbRichTextData tbRichTextData = (A4 == null || A4.B() == null) ? null : A4.B().get(this.a.b);
                        if (tbRichTextData == null) {
                            return;
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!tbRichTextData.F().H()) {
                            String u3 = this.a.u3(tbRichTextData);
                            arrayList.add(u3);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = this.a.a ? 17 : 18;
                            concurrentHashMap.put(u3, imageUrlData);
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
                            builder.A(arrayList2);
                            builder.C(str6);
                            builder.B(str7);
                            builder.R(str8);
                            builder.F(z4);
                            builder.M(arrayList.get(0));
                            builder.I(true);
                            builder.y(concurrentHashMap);
                            builder.K(true);
                            builder.N(false);
                            builder.J(false);
                            builder.Q(this.a.I3());
                            builder.O(String.valueOf(A4.getPostId()));
                            builder.z(String.valueOf(A4.getPostId()));
                            builder.D(this.a.c.getFromForumId());
                            this.a.sendMessage(new CustomMessage(2010000, builder.x(this.a.getPageContext().getPageActivity())));
                            return;
                        }
                        this.a.D0 = false;
                        TbRichText W = m0.i().W();
                        int size = arrayList.size();
                        int C3 = this.a.C3(W, A4, i, i, arrayList, concurrentHashMap);
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
                            C3 += this.a.c.w0();
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(arrayList, C3));
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.A(arrayList3);
                        builder2.C(str4);
                        builder2.B(str3);
                        builder2.R(str2);
                        builder2.F(z3);
                        builder2.M(str9);
                        builder2.I(true);
                        builder2.y(concurrentHashMap);
                        builder2.K(true);
                        builder2.N(false);
                        builder2.J(false);
                        builder2.Q(this.a.I3());
                        builder2.O(String.valueOf(A4.getPostId()));
                        builder2.z(String.valueOf(A4.getPostId()));
                        builder2.D(this.a.c.getFromForumId());
                        this.a.sendMessage(new CustomMessage(2010000, builder2.x(this.a.getPageContext().getPageActivity())));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092076);
                    this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, ((TbImageView) view2).w())));
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
                    this.a.K.d(this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f14be));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (dj.isEmpty(muteMessage)) {
                    muteMessage = this.a.I.getResources().getString(R.string.obfuscated_res_0x7f0f14bd);
                }
                this.a.K.c(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements lu4.e {
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

        @Override // com.baidu.tieba.lu4.e
        public void n0(lu4 lu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lu4Var, i, view2) == null) {
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                if (i == -4) {
                    this.a.k4(view2, R.id.obfuscated_res_0x7f0917ee);
                } else if (i == -3) {
                    this.a.k4(view2, R.id.obfuscated_res_0x7f0917ed);
                } else if (i == -2) {
                    this.a.l4(view2);
                } else if (i == -1) {
                    this.a.j4(view2);
                } else if (i != 13) {
                    switch (i) {
                        case 1:
                            this.a.l3();
                            return;
                        case 2:
                            this.a.p3();
                            return;
                        case 3:
                            this.a.h3(view2);
                            return;
                        case 4:
                            this.a.n3(view2);
                            return;
                        case 5:
                            this.a.o3(view2);
                            return;
                        case 6:
                            this.a.j3(view2);
                            return;
                        case 7:
                            this.a.m3(view2);
                            return;
                        case 8:
                            this.a.k3(view2);
                            return;
                        case 9:
                            this.a.g3(view2);
                            return;
                        default:
                            return;
                    }
                } else {
                    this.a.i3();
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vt8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.M) {
                vt8 vt8Var = (vt8) customResponsedMessage.getData();
                this.a.j.K();
                SparseArray<Object> sparseArray = (SparseArray) this.a.J;
                DataRes dataRes = vt8Var.a;
                if (vt8Var.c == 0 && dataRes != null) {
                    z = dh.e(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092090, dataRes.mute_confirm);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
                    z = false;
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09205b, Boolean.TRUE);
                int intValue = sparseArray.get(R.id.obfuscated_res_0x7f09204d) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09204d)).intValue() : 0;
                if (intValue == 0) {
                    this.a.v4(z, sparseArray);
                } else if (intValue == 1) {
                    this.a.j.a0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements cu4.c {
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

        @Override // com.baidu.tieba.cu4.c
        public void a(cu4 cu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cu4Var, i, view2) == null) {
                cu4Var.e();
                if (this.a.k == null || TextUtils.isEmpty(this.a.l)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.m == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.l));
                    } else {
                        v75.a aVar = new v75.a();
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
                        newSubPbActivity.f = new ez7(newSubPbActivity.getPageContext());
                    }
                    this.a.f.b(this.a.l, this.a.k.n());
                }
                this.a.k = null;
                this.a.l = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements lx4.g {
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

        @Override // com.baidu.tieba.lx4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.c == null) {
                return;
            }
            this.a.c.T0();
        }
    }

    /* loaded from: classes5.dex */
    public class s implements kq6.d {
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

        @Override // com.baidu.tieba.kq6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
        @Override // com.baidu.tieba.kq6.d
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
            if (newSubPbActivity.W != null && newSubPbActivity.c != null && this.a.c.k0() != null && !this.a.F(TbadkCoreApplication.getCurrentAccount())) {
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (!newSubPbActivity2.W.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.c.k0().replyPrivateFlag)) {
                    return;
                }
            }
            if (this.a.c != null && this.a.c.m0() != null && this.a.c.m0().i() != null) {
                PostData i = this.a.c.m0().i();
                if (i.W() != null && i.s() != null) {
                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f100c), i.s().getName_show(), i.W().toString());
                    this.a.G.a().A(new u45(45, 27, str));
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
            this.a.G.a().A(new u45(45, 27, str));
            if (!this.a.G.y()) {
            }
        }

        @Override // com.baidu.tieba.kq6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface s0 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.U == null) {
                return;
            }
            if (!this.a.U.e()) {
                this.a.c3(false);
            }
            this.a.U.l(false);
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

    /* loaded from: classes5.dex */
    public class u implements cu4.c {
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

        @Override // com.baidu.tieba.cu4.c
        public void a(cu4 cu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cu4Var, i, view2) == null) {
                if (i == 0) {
                    String str = this.a.get(R.id.obfuscated_res_0x7f092093) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f092093) : "";
                    String str2 = this.a.get(R.id.obfuscated_res_0x7f092095) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f092095) : "";
                    String str3 = this.a.get(R.id.obfuscated_res_0x7f092094) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f092094) : "";
                    String str4 = this.a.get(R.id.obfuscated_res_0x7f092090) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f092090) : "";
                    String str5 = this.a.get(R.id.obfuscated_res_0x7f092091) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f092091) : "";
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, str4, this.d.M);
                    userMuteAddAndDelCustomMessage.setTag(this.d.M);
                    this.d.x4(this.b, userMuteAddAndDelCustomMessage, str4, str, str5);
                }
                cu4Var.e();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vk5.a)) {
                vk5.a aVar = (vk5.a) customResponsedMessage.getData();
                vk5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements vg<GifView> {
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.b0();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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

    /* loaded from: classes5.dex */
    public class y implements vg<ImageView> {
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
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
                    if (up4.c().g()) {
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
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = up4.c().g();
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

    /* loaded from: classes5.dex */
    public class z implements vg<View> {
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
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
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
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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
        this.c0 = new k(this);
        this.f0 = 0;
        this.g0 = false;
        this.i0 = BdUniqueId.gen();
        this.q0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.r0 = true;
        this.u0 = new v(this);
        this.w0 = new g0(this);
        this.x0 = new m0(this, 2921481);
        this.y0 = new n0(this);
        this.z0 = new o0(this, 2001427);
        this.A0 = new p0(this, 2001428);
        this.B0 = new q0(this, 2001426);
        this.C0 = new r0(this);
        this.D0 = false;
        this.E0 = new r(this);
        this.F0 = new w(this, 2001332);
        this.G0 = new j0(this, 2016485);
    }

    public final boolean A3(SparseArray<?> sparseArray, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) ? (sparseArray != null && (sparseArray.get(i2) instanceof Boolean)) ? ((Boolean) sparseArray.get(i2)).booleanValue() : z2 : invokeCommon.booleanValue;
    }

    public final TbRichText A4(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null || str == null || i2 < 0) {
                return null;
            }
            lv7 m02 = this.c.m0();
            TbRichText B3 = B3(m02.i(), str, i2);
            if (B3 != null || (B3 = B3(m02.i(), str, i2)) != null) {
            }
            return B3;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public final TbRichText B3(PostData postData, String str, int i2) {
        InterceptResult invokeLLI;
        TbRichText W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, postData, str, i2)) == null) {
            if (postData != null && (W = postData.W()) != null) {
                ArrayList<TbRichTextData> B = W.B();
                int size = B.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (B.get(i4) != null && B.get(i4).getType() == 8) {
                        i3++;
                        if (B.get(i4).F().B().equals(str)) {
                            int h2 = (int) ej.h(TbadkCoreApplication.getInst());
                            int width = B.get(i4).F().getWidth() * h2;
                            int height = B.get(i4).F().getHeight() * h2;
                            if (width < 80 || height < 80 || width * height < 10000) {
                                return null;
                            }
                            this.b = i4;
                            return W;
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

    public final int C3(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.D0 = true;
            }
            if (tbRichText != null && tbRichText.B() != null) {
                int size = tbRichText.B().size();
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    if (tbRichText.B().get(i5) != null && tbRichText.B().get(i5).getType() == 8) {
                        i4++;
                        int h2 = (int) ej.h(TbadkCoreApplication.getInst());
                        int width = tbRichText.B().get(i5).F().getWidth() * h2;
                        int height = tbRichText.B().get(i5).F().getHeight() * h2;
                        if (!(width < 80 || height < 80 || width * height < 10000) && tbRichText.B().get(i5).F().H()) {
                            TbRichTextData tbRichTextData = tbRichText.B().get(i5);
                            String u3 = u3(tbRichTextData);
                            arrayList.add(u3);
                            if (!TextUtils.isEmpty(u3) && tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                String B = F.B();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = B;
                                imageUrlData.urlType = this.a ? 17 : 18;
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(u3, imageUrlData);
                                }
                            }
                            if (!this.D0) {
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

    @Override // com.baidu.tieba.yk5
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!dj.isEmpty(this.d0)) {
                return this.d0;
            }
            String string = getResources().getString(xy7.b());
            this.d0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final SparseArray<?> E3(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            if (e4(view2)) {
                if (view2 instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) view2;
                    this.k = tbImageView.getBdImage();
                    String url = tbImageView.getUrl();
                    this.l = url;
                    if (this.k == null || TextUtils.isEmpty(url)) {
                        return null;
                    }
                    if (view2.getTag(R.id.obfuscated_res_0x7f092076) != null && (view2.getTag(R.id.obfuscated_res_0x7f092076) instanceof TbRichTextImageInfo)) {
                        this.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092076);
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
                    if (view2.getTag(R.id.obfuscated_res_0x7f092076) != null && (view2.getTag(R.id.obfuscated_res_0x7f092076) instanceof TbRichTextImageInfo)) {
                        this.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092076);
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f092076) != null && (view2.getTag(R.id.obfuscated_res_0x7f092076) instanceof TbRichTextImageInfo)) {
                            this.m = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092076);
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
                this.j.x0(this.E0, this.k.t());
                return null;
            }
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    @Override // com.baidu.tieba.iw7
    public boolean F(String str) {
        InterceptResult invokeL;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (StringUtils.isNull(str) || (subPbModel = this.c) == null || subPbModel.m0() == null || this.c.m0().l() == null || this.c.m0().l().getAuthor() == null) {
                return false;
            }
            return str.equals(this.c.m0().l().getAuthor().getUserId());
        }
        return invokeL.booleanValue;
    }

    public final String F3(SparseArray<?> sparseArray, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sparseArray, i2, str)) == null) ? (sparseArray != null && (sparseArray.get(i2) instanceof String)) ? (String) sparseArray.get(i2) : str : (String) invokeLIL.objValue;
    }

    @Override // com.baidu.tieba.yk5
    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.N = true;
        }
    }

    public SubPbModel G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c : (SubPbModel) invokeV.objValue;
    }

    public final String H3(View view2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, view2, i2)) == null) ? view2.getTag(i2) instanceof String ? (String) view2.getTag(i2) : "" : (String) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.yk5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
        }
    }

    public final ThreadData I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null) {
                return null;
            }
            return this.c.m0().l();
        }
        return (ThreadData) invokeV.objValue;
    }

    public int J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.E0();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void K3(int i2, Intent intent) {
        g55 g55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, intent) == null) {
            this.G.a().q();
            this.G.z();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.G.C(writeData);
                this.G.e0(pbEditorData.getVoiceModel());
                f55 n2 = this.G.a().n(6);
                if (n2 != null && (g55Var = n2.m) != null) {
                    g55Var.B(new u45(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.G.G();
                }
                this.j.M();
            }
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ug<RelativeLayout> ugVar = new ug<>(new b0(this), 10, 0);
            this.F = ugVar;
            return ugVar;
        }
        return (ug) invokeV.objValue;
    }

    public void L3(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f092093) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092093) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f092095) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092095) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f092094) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092094) : "";
            if (sparseArray.get(R.id.obfuscated_res_0x7f092090) instanceof String) {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092090);
            }
            String str5 = str4;
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f092090) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092090) : "";
            String str7 = sparseArray.get(R.id.obfuscated_res_0x7f092091) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092091) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str5, 1, str6, this.M);
            userMuteAddAndDelCustomMessage.setTag(this.M);
            x4(z2, userMuteAddAndDelCustomMessage, str6, str2, str7);
        }
    }

    public void M3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
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
                i4(format);
                return;
            }
            this.d.a(str);
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.D == null) {
                this.D = new ug<>(new y(this), 8, 0);
            }
            return this.D;
        }
        return (ug) invokeV.objValue;
    }

    public void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.v = new e(this);
            this.w = new f(this);
            this.y = new g(this);
            this.z = new h(this);
            this.x = new i(this);
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.C == null) {
                this.C = new ug<>(new z(this), 8, 0);
            }
            return this.C;
        }
        return (ug) invokeV.objValue;
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.r = new m(this);
        }
    }

    public void P3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            SubPbModel subPbModel = new SubPbModel(getPageContext());
            this.c = subPbModel;
            subPbModel.a1(new c(this));
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.h = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.x);
            VoiceManager voiceManager = new VoiceManager();
            this.i = voiceManager;
            voiceManager.onCreate(getPageContext());
            do4 b2 = do4.b(this);
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

    @Override // com.baidu.tieba.yk5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, context, str) == null) {
        }
    }

    public final void Q3(boolean z2) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) {
            a75 a75Var = (a75) new b75(z2).a(getActivity());
            this.G = a75Var;
            if (a75Var != null) {
                a75Var.O(getPageContext());
                this.G.b0(this.c);
                this.G.R(this.y0);
                this.G.P(2);
                this.G.V(this.c0);
                this.G.N(this.w0);
                this.G.a().C(true);
                this.G.A(getPageContext());
                this.G.Q(this.R);
            }
            d18 d18Var = this.j;
            if (d18Var != null) {
                d18Var.R(this.G);
            }
            a75 a75Var2 = this.G;
            if (a75Var2 != null && (subPbModel = this.c) != null) {
                a75Var2.H(subPbModel.k0());
                this.G.z();
            }
            a75 a75Var3 = this.G;
            if (a75Var3 == null) {
                return;
            }
            a75Var3.u().l(D3());
            this.G.u().m(D3());
            EditText i2 = this.G.u().i();
            this.V = i2;
            i2.addTextChangedListener(new t(this));
        }
    }

    @Override // com.baidu.tieba.yk5
    public void R(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048602, this, context, str, z2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (d4(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                f45 f45Var = new f45();
                f45Var.a = str;
                f45Var.b = 3;
                f45Var.c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, f45Var));
            }
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
        this.N = true;
    }

    public final void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.u = new p(this);
        }
    }

    public final void S2(boolean z2, boolean z3, List<hu4> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), list}) == null) || z2 || z3) {
            return;
        }
        hu4 hu4Var = new hu4(3, getString(R.string.obfuscated_res_0x7f0f0452), this.p);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f09203a, this.n);
        hu4Var.d.setTag(sparseArray);
        list.add(hu4Var);
    }

    public final boolean S3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, bundle)) == null) {
            if (bundle != null) {
                this.Q = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            } else {
                this.Q = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            }
            return this.Q;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iw7
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T2(SparseArray<?> sparseArray, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, List<hu4> list) {
        hu4 hu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048607, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), str, list}) != null) || !this.mIsLogin || this.q0) {
            return;
        }
        hu4 hu4Var2 = null;
        if (!z3 || !z5 || !z6) {
            if (z5) {
                SparseArray<Object> x3 = x3(sparseArray, z2);
                if (J3() == 1002 && !z2) {
                    hu4Var = new hu4(6, getString(R.string.obfuscated_res_0x7f0f1016), this.p);
                } else {
                    hu4Var = new hu4(6, getString(R.string.obfuscated_res_0x7f0f04b0), this.p);
                }
                hu4Var.d.setTag(x3);
            }
            if (hu4Var2 == null) {
                list.add(hu4Var2);
                return;
            }
            return;
        }
        SparseArray<Object> y3 = y3(sparseArray, z2, z4, z5, z6, str);
        hu4Var = new hu4(6, getString(R.string.obfuscated_res_0x7f0f04b0), this.p);
        hu4Var.d.setTag(y3);
        hu4Var2 = hu4Var;
        if (hu4Var2 == null) {
        }
    }

    public final boolean T3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, bundle)) == null) {
            if (bundle != null) {
                this.O = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            } else {
                this.O = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            }
            return this.O;
        }
        return invokeL.booleanValue;
    }

    public final void U2(boolean z2, List<hu4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048609, this, z2, list) == null) && z2) {
            list.add(new hu4(1, getString(R.string.obfuscated_res_0x7f0f10ae), this.p));
        }
    }

    public final boolean U3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, bundle)) == null) {
            if (bundle != null) {
                this.S = bundle.getBoolean("is_jump_from_video_middle");
            } else {
                this.S = getIntent().getBooleanExtra("is_jump_from_video_middle", false);
            }
            return this.S;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yk5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, context, str, str2) == null) {
        }
    }

    @Nullable
    public final void V2(SparseArray<?> sparseArray, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, List<hu4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), str, list}) == null) && this.mIsLogin && !this.q0) {
            hu4 hu4Var = null;
            if (z3) {
                SparseArray<Object> y3 = y3(sparseArray, z2, z4, z5, z6, str);
                hu4Var = new hu4(7, getString(R.string.obfuscated_res_0x7f0f02e8), this.p);
                hu4Var.d.setTag(y3);
            }
            if (hu4Var != null) {
                list.add(hu4Var);
            }
        }
    }

    public final boolean V3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, bundle)) == null) {
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

    public final void W2(boolean z2, boolean z3, boolean z4, List<hu4> list) {
        hu4 hu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), list}) == null) || z4 || z3) {
            return;
        }
        if (z2) {
            hu4Var = new hu4(4, getString(R.string.obfuscated_res_0x7f0f0ff1), this.p);
        } else {
            hu4Var = new hu4(4, getString(R.string.obfuscated_res_0x7f0f0aaa), this.p);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f09203a, this.n);
        sparseArray.put(R.id.obfuscated_res_0x7f092053, Boolean.FALSE);
        hu4Var.d.setTag(sparseArray);
        list.add(hu4Var);
    }

    public final int W3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, bundle)) == null) {
            if (bundle != null) {
                this.R = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                this.R = getIntent().getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.R;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.iw7
    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null || this.c.m0().l() == null) {
                return null;
            }
            return this.c.m0().l().getForum_name();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final void X2(boolean z2, boolean z3, List<hu4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), list}) == null) && this.mIsLogin && !this.q0) {
            hu4 hu4Var = null;
            if (!z2 && z3) {
                hu4Var = new hu4(13, getString(R.string.obfuscated_res_0x7f0f0b3d), this.p);
            }
            if (hu4Var != null) {
                list.add(hu4Var);
            }
        }
    }

    public void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            registerListener(this.G0);
            O3();
            a4();
            Z3();
            R3();
            Y3();
        }
    }

    @Override // com.baidu.tieba.yk5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.A == null) {
                this.A = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.A;
        }
        return (ug) invokeV.objValue;
    }

    public final void Y2(SparseArray<?> sparseArray, boolean z2, boolean z3, List<hu4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), list}) == null) && this.mIsLogin && !this.q0) {
            hu4 hu4Var = null;
            if (!s08.j(G3().m0()) && !z3 && z2) {
                hu4Var = new hu4(5, getString(R.string.obfuscated_res_0x7f0f0b4d), this.p);
                hu4Var.d.setTag(z3(sparseArray));
            }
            if (hu4Var != null) {
                list.add(hu4Var);
            }
        }
    }

    public final void Y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.q = new q(this);
        }
    }

    public final void Z2(boolean z2, boolean z3, boolean z4, boolean z5, String str, List<hu4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), str, list}) == null) && this.mIsLogin && !this.q0) {
            hu4 hu4Var = null;
            if ((s08.j(G3().m0()) || z5 || !z4) && g4(z3) && isLogin() && !z2) {
                hu4Var = new hu4(5, getString(R.string.obfuscated_res_0x7f0f1016), this.p);
                hu4Var.d.setTag(str);
            }
            if (hu4Var != null) {
                list.add(hu4Var);
            }
        }
    }

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.t = new o(this);
        }
    }

    public final void a3(boolean z2, List<hu4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048625, this, z2, list) == null) && z2) {
            list.add(new hu4(2, getString(R.string.obfuscated_res_0x7f0f10af), this.p));
        }
    }

    public final void a4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.s = new n(this);
        }
    }

    public final boolean b3() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.W == null || (subPbModel = this.c) == null || subPbModel.m0() == null || this.c.m0().a() == null || this.W.checkPrivacyBeforeInvokeEditor(this.c.m0().a().replyPrivateFlag) : invokeV.booleanValue;
    }

    public void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            d18 d18Var = new d18(this, this.r);
            this.j = d18Var;
            d18Var.j0(this.c);
            this.j.p0(getUniqueId());
            setContentView(this.j.I(), new FrameLayout.LayoutParams(-1, -1));
            this.j.n0(this.s);
            this.j.o0(this);
            this.j.k0(this.u);
            this.j.l0(this.t);
            this.j.m0(new b(this));
            this.j.f0(this.y);
            this.j.d0(this.z);
            this.j.h0(this.C0);
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

    public void c3(boolean z2) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) || (editText = this.V) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.V.getSelectionEnd();
        SpannableStringBuilder f2 = this.U.f(this.V.getText());
        if (f2 != null) {
            this.U.l(true);
            this.V.setText(f2);
            if (z2 && this.U.b() >= 0) {
                this.V.requestFocus();
                this.V.setSelection(this.U.b());
            } else {
                this.V.setSelection(selectionEnd);
            }
            a19 a19Var = this.U;
            a19Var.k(a19Var.b() >= 0);
        }
    }

    public boolean c4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel != null) {
                return subPbModel.L0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (this.O && !this.g0 && !this.P && !this.Q) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            } else {
                super.closeAnimation();
            }
        }
    }

    public final boolean d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null) {
                return false;
            }
            return AntiHelper.d(getPageContext(), subPbModel.k0());
        }
        return invokeV.booleanValue;
    }

    public boolean d4(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                return false;
            }
            this.N = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return d4(dj.getUrlDecode(str2));
            }
            String str3 = paramPair.get(H0);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yk5
    public ug<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, voiceModel)) == null) {
            View z2 = this.j.z();
            if (z2 == null || (findViewWithTag = z2.findViewWithTag(voiceModel)) == null) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public void e3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = sparseArray.get(R.id.obfuscated_res_0x7f092092) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092092) : "";
            this.j.t0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = dh.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = dh.g(str, 0L);
            this.J = sparseArray;
            BdUniqueId bdUniqueId = this.M;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public boolean e4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, view2)) == null) ? (view2 instanceof TbImageView) || (view2 instanceof TbMemeImageView) || (view2 instanceof GifView) : invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.O && !this.g0 && !this.P && !this.Q) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    public void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.G.z();
            } else if (StringUtils.isNull(this.c.y0())) {
            } else {
                if (this.j.B0() && ej.D()) {
                    this.j.i0();
                } else {
                    this.j.e0();
                }
            }
        }
    }

    public boolean f4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.H : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yk5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, context, str) == null) {
        }
    }

    public final void g3(View view2) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c5a);
            } else if (!ViewHelper.checkUpIsLogin(getActivity()) || (c2 = st8.c(view2)) == null || this.s0 == null) {
            } else {
                this.s0.n(dh.g(c2, 0L));
            }
        }
    }

    public final boolean g4(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048643, this, z2)) == null) {
            if (this.c == null) {
                return false;
            }
            return ((J3() != 0) || this.c.m0() == null || this.c.m0().l() == null || this.c.m0().l().getAuthor() == null || this.c.m0().l().isUgcThreadType() || TextUtils.equals(this.c.m0().l().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.hc5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? "a007" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yk5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            d18 d18Var = this.j;
            if (d18Var != null) {
                return d18Var.B();
            }
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || dj.isEmpty(subPbModel.A0())) {
                return 0L;
            }
            return dh.g(this.c.A0(), 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public kc5 getPageStayDurationItem() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            kc5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (subPbModel = this.c) != null) {
                if (subPbModel.m0() != null && this.c.m0().d() != null) {
                    pageStayDurationItem.t(dh.g(this.c.m0().d().getId(), 0L));
                }
                pageStayDurationItem.C(dh.g(this.c.A0(), 0L));
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
                pageStayDurationItem.w(dh.g(this.c.B(), 0L));
            }
            return pageStayDurationItem;
        }
        return (kc5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.hc5
    public ic5 getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? new c0(this) : (ic5) invokeV.objValue;
    }

    public final void h3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048649, this, view2) == null) && view2.getTag() != null && (view2.getTag() instanceof SparseArray)) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (sparseArray.get(R.id.obfuscated_res_0x7f09203a) instanceof PostData) {
                ((PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a)).C0();
            }
        }
    }

    public boolean h4(@Nullable ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, threadData)) == null) ? (threadData == null || !threadData.isVideoThreadType() || threadData.getThreadVideoInfo() == null) ? false : true : invokeL.booleanValue;
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.j.E0(true);
        }
    }

    public final void i4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void j3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, view2) == null) {
            this.j.o();
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            if (sparseArray != null && (sparseArray.get(R.id.obfuscated_res_0x7f09203e) instanceof Integer) && (sparseArray.get(R.id.obfuscated_res_0x7f09203c) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f09205a) instanceof Integer) && (sparseArray.get(R.id.obfuscated_res_0x7f09203d) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203d)).booleanValue();
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205a)).intValue();
                boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09204e)).booleanValue();
                boolean F = F(TbadkCoreApplication.getCurrentAccount());
                if (F) {
                    if (!booleanValue2) {
                        s4(sparseArray, intValue, booleanValue);
                    } else {
                        this.j.Z(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203c), intValue, booleanValue, F);
                    }
                } else if (booleanValue && !booleanValue2) {
                    s4(sparseArray, intValue, booleanValue);
                } else {
                    this.j.Z(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203c), intValue, booleanValue, F);
                }
            }
        }
    }

    public final void j4(View view2) {
        View view3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048654, this, view2) == null) || (view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917ef)) == null) {
            return;
        }
        AgreeView agreeView = (AgreeView) view3;
        if (agreeView.getImgAgree() != null) {
            agreeView.getImgAgree().performClick();
        }
    }

    public final void k3(View view2) {
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048655, this, view2) == null) && checkUpIsLogin() && (sparseArray = (SparseArray) view2.getTag()) != null) {
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a);
            if (postData.q() == null) {
                return;
            }
            q3(postData.q());
        }
    }

    public final void k4(View view2, int i2) {
        View view3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048656, this, view2, i2) == null) || (view3 = (View) ((SparseArray) view2.getTag()).get(i2)) == null) {
            return;
        }
        view3.performClick();
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || this.k == null || TextUtils.isEmpty(this.l)) {
            return;
        }
        if (this.m == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.l));
        } else {
            v75.a aVar = new v75.a();
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

    public final void l4(View view2) {
        View view3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048658, this, view2) == null) || (view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917ef)) == null) {
            return;
        }
        AgreeView agreeView = (AgreeView) view3;
        if (agreeView.getImgDisagree() != null) {
            agreeView.getImgDisagree().performClick();
        }
    }

    public final void m3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, view2) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c5a);
                return;
            }
            SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
            if (sparseArray == null) {
                return;
            }
            boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
            boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092080)).booleanValue();
            boolean booleanValue3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue();
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f092052) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092052)).booleanValue() : false;
            if (!booleanValue) {
                if (booleanValue2) {
                    this.j.Z(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203c), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205a)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203d)).booleanValue(), false);
                }
            } else if (booleanValue3) {
                sparseArray.put(R.id.obfuscated_res_0x7f09204d, 1);
                sparseArray.put(R.id.obfuscated_res_0x7f092036, 2);
                e3(sparseArray);
            } else {
                if (booleanValue4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092036, 2);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09205b, Boolean.TRUE);
                this.j.b0(view2);
            }
        }
    }

    public final void m4(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a)) == null) {
                return;
            }
            boolean z2 = false;
            if (this.c.O0() && postData.L() != null && postData.L().equals(this.c.v0())) {
                z2 = true;
            }
            MarkData u0 = this.c.u0(postData);
            if (u0 == null) {
                return;
            }
            this.j.o();
            do4 do4Var = this.g;
            if (do4Var != null) {
                do4Var.i(u0);
                if (!z2) {
                    this.g.a();
                } else {
                    this.g.d();
                }
            }
        }
    }

    public final void n3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
            this.j.o();
            if (checkUpIsLogin()) {
                m4(view2);
            }
        }
    }

    public final void n4(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048662, this, str) == null) && !StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String q2 = bx4.k().q("bubble_link", "");
            if (StringUtils.isNull(q2)) {
                return;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return;
            }
            lo4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f054a), q2 + "?props_id=" + str, true, true, true);
        }
    }

    public final void o3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c5a);
                return;
            }
            Object tag = view2.getTag();
            this.j.o();
            if (tag instanceof String) {
                String str = (String) tag;
                if (checkUpIsLogin()) {
                    M3(str);
                }
            } else if (tag instanceof SparseArray) {
                SparseArray<Object> sparseArray = (SparseArray) tag;
                if ((sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue()) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09204d, 0);
                    sparseArray.put(R.id.obfuscated_res_0x7f092036, 2);
                    e3(sparseArray);
                }
            }
        }
    }

    public final void o4(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048664, this, i2, str) == null) {
            if (this.c.G0()) {
                showToast(str);
            } else if (!ej.D()) {
                this.j.v0(R.string.obfuscated_res_0x7f0f0fcc);
            } else if (i2 == 4) {
                d18 d18Var = this.j;
                d18Var.w0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                d18 d18Var2 = this.j;
                d18Var2.w0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.j.v0(R.string.obfuscated_res_0x7f0f0c73);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048665, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25035) {
                K3(i3, intent);
            }
            a75 a75Var = this.G;
            if (a75Var != null) {
                a75Var.D(i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            a75 a75Var = this.G;
            if (a75Var != null && a75Var.a() != null && this.G.a().u()) {
                this.G.a().q();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048667, this, i2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048668, this, bundle) == null) {
            T3(bundle);
            V3(bundle);
            W3(bundle);
            U3(bundle);
            S3(bundle);
            if (getIntent() != null) {
                this.g0 = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
                if (this.P) {
                    this.v0 = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
                }
            }
            super.onCreate(bundle);
            this.I = getPageContext();
            this.L = true;
            a19 a19Var = new a19();
            this.U = a19Var;
            a19Var.h(R.color.cp_cont_h_alpha85);
            this.U.j(R.color.CAM_X0101);
            X3();
            N3();
            P3(bundle);
            b4();
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
            Q3(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.j.k(this.g0);
            hx4 hx4Var = new hx4();
            this.K = hx4Var;
            hx4Var.a = 1000L;
            registerListener(this.B0);
            registerListener(this.z0);
            registerListener(this.A0);
            registerListener(this.x0);
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
            b18 b18Var = new b18(this);
            this.d = b18Var;
            b18Var.b(getUniqueId());
            this.Y = new c08(this);
            this.s0 = new tt8(getPageContext(), getUniqueId());
            if (this.t0 == null) {
                if (this.S) {
                    this.t0 = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.t0 = new TiePlusEventController(this, TiePlusStat.Locate.PB_COMMENT);
                }
                this.t0.k(this.u0);
            }
            x25.b(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
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
            MessageManager.getInstance().unRegisterListener(this.z0);
            MessageManager.getInstance().unRegisterListener(this.A0);
            MessageManager.getInstance().unRegisterListener(this.B0);
            MessageManager.getInstance().unRegisterListener(this.M);
            tt8 tt8Var = this.s0;
            if (tt8Var != null) {
                tt8Var.l();
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

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            this.b0 = z2;
            w3(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            this.H = true;
            super.onPause();
            TiePlusEventController tiePlusEventController = this.t0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            w08.a();
            el4.w().E();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.F0);
            this.j.V();
            if (this.P || this.Q) {
                z4(false);
            }
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.tieba.v9
    public void onPreLoad(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, hoVar) == null) {
            PreLoadImageHelper.load(hoVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(hoVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            this.H = false;
            super.onResume();
            TiePlusEventController tiePlusEventController = this.t0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            y4();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.F0);
            this.j.W();
            if (this.P || this.Q) {
                z4(true);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            if (this.j.B0() && ej.D()) {
                this.c.loadData();
            } else {
                this.j.e0();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.i;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            this.G.F();
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || this.k == null || TextUtils.isEmpty(this.l)) {
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
            this.f = new ez7(getPageContext());
        }
        this.f.b(this.l, this.k.n());
        this.k = null;
        this.l = null;
    }

    public final void p4(SparseArray<Object> sparseArray, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048680, this, sparseArray, z2) == null) || sparseArray == null) {
            return;
        }
        if (sparseArray.get(R.id.obfuscated_res_0x7f09203a) instanceof PostData) {
            q4((PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203a), z2);
        } else {
            q4(null, z2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q3(AgreeData agreeData) {
        bc5 currentVisiblePageExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048681, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.h0 == null) {
            this.h0 = new xw4();
        }
        if (this.j0 == null) {
            lm8 lm8Var = new lm8();
            this.j0 = lm8Var;
            lm8Var.a = this.i0;
        }
        rq4 rq4Var = new rq4();
        rq4Var.b = 12;
        rq4Var.h = 9;
        rq4Var.g = 3;
        if (G3() != null) {
            rq4Var.f = G3().x0();
        }
        rq4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                rq4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.h0.c(agreeData, i2, getUniqueId(), false);
                this.h0.d(agreeData, this.j0);
                if (G3() != null || G3().m0() == null) {
                }
                this.h0.b(this, rq4Var, agreeData, G3().m0().l());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            rq4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            rq4Var.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
        if (currentVisiblePageExtra != null) {
        }
        this.h0.c(agreeData, i2, getUniqueId(), false);
        this.h0.d(agreeData, this.j0);
        if (G3() != null) {
        }
    }

    public final void q4(PostData postData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048682, this, postData, z2) == null) || d3()) {
            return;
        }
        if (postData != null) {
            if (postData.s() != null) {
                MetaData s2 = postData.s();
                this.G.X(s2.getUserId());
                this.G.c0(postData.L());
                boolean z3 = postData.f0;
                this.G.q(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f100c), postData.s().getName_show(), postData.W() != null ? postData.W().toString() : ""));
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
            w3(false);
        }
    }

    public final void r3(View view2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048683, this, view2) == null) && b3() && checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092057) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092057)) != null) {
                boolean z2 = true;
                if (this.c != null) {
                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.c.B0()).param("fid", this.c.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.L()).param("obj_source", 1).param("obj_type", 3));
                }
                q4(postData, ((view2.getTag(R.id.obfuscated_res_0x7f092086) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f092086) == Boolean.TRUE) ? false : false);
            }
        }
    }

    public final void r4() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
            if (d3()) {
                return;
            }
            if (booleanExtra) {
                if (this.W == null || (subPbModel = this.c) == null || subPbModel.k0() == null || F(TbadkCoreApplication.getCurrentAccount()) || this.W.checkPrivacyBeforeInvokeEditor(this.c.k0().replyPrivateFlag)) {
                    if (this.G.y()) {
                        this.G.w(null);
                        return;
                    }
                    this.j.D0();
                    this.j.m();
                    a75 a75Var = this.G;
                    if (a75Var != null) {
                        a75Var.k0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.Z == null) {
                kq6 kq6Var = new kq6(getPageContext());
                this.Z = kq6Var;
                kq6Var.i(new s(this));
            }
            SubPbModel subPbModel2 = this.c;
            if (subPbModel2 == null || subPbModel2.m0() == null || this.c.m0().d() == null) {
                return;
            }
            this.Z.g(this.c.m0().d().getId(), dh.g(this.c.A0(), 0L));
        }
    }

    public final boolean s3(View view2) {
        InterceptResult invokeL;
        List<hu4> c2;
        on onVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048685, this, view2)) == null) {
            SparseArray<?> sparseArray = view2.getTag() instanceof SparseArray ? (SparseArray) view2.getTag() : null;
            if (sparseArray == null && (sparseArray = E3(view2)) == null) {
                return true;
            }
            SparseArray<?> sparseArray2 = sparseArray;
            if (sparseArray2.get(R.id.obfuscated_res_0x7f09203a) instanceof PostData) {
                this.n = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f09203a);
                do4 do4Var = this.g;
                if (do4Var == null) {
                    return true;
                }
                do4Var.h(this.c.O0());
                boolean z2 = this.g.e() && TextUtils.equals(this.n.L(), this.c.v0());
                boolean z3 = (this.c.m0() == null || this.c.m0().l() == null || !this.c.m0().l().isBjh()) ? false : true;
                boolean z4 = e4(view2) && !z3;
                boolean z5 = (!e4(view2) || (onVar = this.k) == null || onVar.t()) ? false : true;
                boolean A3 = A3(sparseArray2, R.id.obfuscated_res_0x7f092053, false);
                boolean A32 = A3(sparseArray2, R.id.obfuscated_res_0x7f09203d, false);
                boolean A33 = A3(sparseArray2, R.id.obfuscated_res_0x7f092096, false);
                boolean A34 = A3(sparseArray2, R.id.obfuscated_res_0x7f092082, false);
                boolean A35 = A3(sparseArray2, R.id.obfuscated_res_0x7f092096, false);
                boolean A36 = A3(sparseArray2, R.id.obfuscated_res_0x7f092080, false);
                boolean A37 = A3(sparseArray2, R.id.obfuscated_res_0x7f092052, false);
                String F3 = F3(sparseArray2, R.id.obfuscated_res_0x7f09204a, null);
                ArrayList arrayList = new ArrayList();
                if (this.p == null) {
                    lu4 lu4Var = new lu4(getBaseContext());
                    this.p = lu4Var;
                    lu4Var.n(this.q);
                }
                U2(z4, arrayList);
                a3(z5, arrayList);
                S2(z4, z5, arrayList);
                W2(z2, z3, A3, arrayList);
                Y2(sparseArray2, A33, A34, arrayList);
                Z2(z3, A32, A33, A34, F3, arrayList);
                V2(sparseArray2, A32, A34, A35, A36, A37, F3, arrayList);
                T2(sparseArray2, A32, A34, A35, A36, A37, F3, arrayList);
                X2(A34, A36, arrayList);
                s08.a(arrayList, this.p, this.n, this.c.m0(), this.mIsLogin, this.q0);
                if (UbsABTestHelper.isPBPlanA()) {
                    c2 = s08.d(arrayList, this.n.q(), sparseArray2, this.p);
                } else {
                    c2 = s08.c(arrayList, this.n.q(), sparseArray2, this.p);
                }
                s08.l(c2, true);
                s08.f(c2);
                this.p.o(s08.g(this.n));
                this.p.k(c2, !UbsABTestHelper.isPBPlanA());
                a75 a75Var = this.G;
                if (a75Var != null) {
                    a75Var.z();
                }
                ju4 ju4Var = new ju4(getPageContext(), this.p);
                this.o = ju4Var;
                ju4Var.k();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s4(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048686, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            s08.e(this, getPageContext(), new j(this, sparseArray, i2, z2), new l(this));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.i : (VoiceManager) invokeV.objValue;
    }

    public void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", d18.q0);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void t4(View view2, a75 a75Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048689, this, view2, a75Var, str) == null) {
            new WriteTipBubbleController(getPageContext(), new d(this, view2, a75Var)).d(view2, getString(R.string.obfuscated_res_0x7f0f0d0e), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    @Override // com.baidu.tieba.iw7
    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            SubPbModel subPbModel = this.c;
            if (subPbModel == null || subPbModel.m0() == null || this.c.m0().l() == null) {
                return false;
            }
            return !this.c.m0().l().isMutiForumThread();
        }
        return invokeV.booleanValue;
    }

    public final String u3(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048691, this, tbRichTextData)) == null) {
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
                sb.append(dj.getUrlEncode(F.F()));
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            au4 au4Var = new au4(getPageContext().getPageActivity());
            au4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b4c));
            au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new h0(this));
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new i0(this));
            au4Var.create(this.I).show();
        }
    }

    public void v3(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048693, this, bVar, z2) == null) || bVar == null) {
            return;
        }
        int i2 = 0;
        this.j.s(0, bVar.a, bVar.b, z2);
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                if (this.j.B() instanceof BdTypeListView) {
                    List<Cdo> data = ((BdTypeListView) this.j.B()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        while (i2 < data.size() && (!(data.get(i2) instanceof PostData) || !bVar.g.equals(((PostData) data.get(i2)).L()))) {
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
            bu7 bu7Var = new bu7();
            bu7Var.b(bVar);
            bu7Var.c(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, bu7Var));
        }
    }

    public final void v4(boolean z2, SparseArray<Object> sparseArray) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048694, this, z2, sparseArray) == null) {
            String str = sparseArray.get(R.id.obfuscated_res_0x7f092092) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f092092) : "";
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue()) {
                String[] strArr = new String[1];
                if (z2) {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f14bc);
                } else {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f0b49);
                }
                strArr[0] = string;
                cu4 cu4Var = new cu4(getPageContext().getPageActivity());
                cu4Var.k(R.string.obfuscated_res_0x7f0f0d21);
                cu4Var.j(strArr, new u(this, sparseArray, z2, str));
                cu4Var.c(getPageContext());
                cu4Var.m();
            }
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<GifView> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            if (this.B == null) {
                this.B = new ug<>(new x(this), 20, 0);
            }
            return this.B;
        }
        return (ug) invokeV.objValue;
    }

    public final void w3(boolean z2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        int i2;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z2) == null) {
            Rect rect = new Rect();
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
                frameLayout.getWindowVisibleDisplayFrame(rect);
                if (z2) {
                    ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                    childAt.requestLayout();
                }
            }
            d18 d18Var = this.j;
            if (d18Var == null || d18Var.B() == null || (pbCommenFloorItemViewHolder = this.e0) == null || (i2 = pbCommenFloorItemViewHolder.b0) == -1) {
                return;
            }
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

    public final void w4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, str) == null) {
            if (str == null) {
                str = "";
            }
            au4 au4Var = new au4(this.I.getPageActivity());
            au4Var.setMessage(str);
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09b7, new f0(this));
            au4Var.create(this.I).show();
        }
    }

    @NonNull
    public final SparseArray<Object> x3(SparseArray<?> sparseArray, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048698, this, sparseArray, z2)) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
            sparseArray2.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
            sparseArray2.put(R.id.obfuscated_res_0x7f092080, Boolean.TRUE);
            sparseArray2.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
            sparseArray2.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z2));
            sparseArray2.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
            sparseArray2.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
            sparseArray2.put(R.id.obfuscated_res_0x7f09204e, sparseArray.get(R.id.obfuscated_res_0x7f09204e));
            return sparseArray2;
        }
        return (SparseArray) invokeLZ.objValue;
    }

    public final void x4(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048699, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.j.t0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            au4 au4Var = new au4(this.I.getPageActivity());
            if (dj.isEmpty(str)) {
                au4Var.setMessage(this.I.getResources().getString(R.string.obfuscated_res_0x7f0f0323, str3));
            } else {
                au4Var.setMessage(str);
            }
            au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0436, new d0(this, userMuteAddAndDelCustomMessage));
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new e0(this));
            au4Var.create(this.I).show();
        }
    }

    @Override // com.baidu.tieba.yk5
    public ug<TiebaPlusRecommendCard> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    public final SparseArray<Object> y3(SparseArray<?> sparseArray, boolean z2, boolean z3, boolean z4, boolean z5, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048701, this, new Object[]{sparseArray, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), str})) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
            sparseArray2.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
            sparseArray2.put(R.id.obfuscated_res_0x7f092047, sparseArray.get(R.id.obfuscated_res_0x7f092047));
            sparseArray2.put(R.id.obfuscated_res_0x7f092048, sparseArray.get(R.id.obfuscated_res_0x7f092048));
            sparseArray2.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
            sparseArray2.put(R.id.obfuscated_res_0x7f09204a, str);
            if (!s08.j(G3().m0()) && z3) {
                sparseArray2.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
                sparseArray2.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                sparseArray2.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                sparseArray2.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                sparseArray2.put(R.id.obfuscated_res_0x7f092091, sparseArray.get(R.id.obfuscated_res_0x7f092091));
                sparseArray2.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                sparseArray2.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
            } else {
                sparseArray2.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
            }
            if (z4) {
                sparseArray2.put(R.id.obfuscated_res_0x7f092080, Boolean.TRUE);
                sparseArray2.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z2));
                sparseArray2.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                sparseArray2.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                sparseArray2.put(R.id.obfuscated_res_0x7f09204e, sparseArray.get(R.id.obfuscated_res_0x7f09204e));
                sparseArray2.put(R.id.obfuscated_res_0x7f092052, Boolean.valueOf(z5));
            } else {
                sparseArray2.put(R.id.obfuscated_res_0x7f092080, Boolean.FALSE);
            }
            return sparseArray2;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final void y4() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048702, this) == null) || (subPbModel = this.c) == null || dj.isEmpty(subPbModel.A0())) {
            return;
        }
        el4.w().P(dl4.Z, dh.g(this.c.A0(), 0L));
    }

    @Override // com.baidu.tieba.yk5
    public ug<LinearLayout> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            if (this.E == null) {
                this.E = new ug<>(new a0(this), 15, 0);
            }
            return this.E;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iw7
    public c08 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.Y : (c08) invokeV.objValue;
    }

    @NonNull
    public final SparseArray<Object> z3(SparseArray<?> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048705, this, sparseArray)) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
            sparseArray2.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
            sparseArray2.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
            sparseArray2.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
            sparseArray2.put(R.id.obfuscated_res_0x7f092091, sparseArray.get(R.id.obfuscated_res_0x7f092091));
            sparseArray2.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
            sparseArray2.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
            sparseArray2.put(R.id.obfuscated_res_0x7f09203d, sparseArray.get(R.id.obfuscated_res_0x7f09203d));
            sparseArray2.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
            sparseArray2.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
            sparseArray2.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
            return sparseArray2;
        }
        return (SparseArray) invokeL.objValue;
    }

    public void z4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048706, this, z2) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.v0);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }
}
