package com.baidu.tieba.pb.pb.foldcomment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.an5;
import com.baidu.tieba.b35;
import com.baidu.tieba.be5;
import com.baidu.tieba.bp8;
import com.baidu.tieba.br4;
import com.baidu.tieba.bz7;
import com.baidu.tieba.ey7;
import com.baidu.tieba.h18;
import com.baidu.tieba.i45;
import com.baidu.tieba.in;
import com.baidu.tieba.j85;
import com.baidu.tieba.jf8;
import com.baidu.tieba.jv4;
import com.baidu.tieba.k65;
import com.baidu.tieba.k85;
import com.baidu.tieba.kp4;
import com.baidu.tieba.l08;
import com.baidu.tieba.l95;
import com.baidu.tieba.lw8;
import com.baidu.tieba.ly4;
import com.baidu.tieba.m38;
import com.baidu.tieba.m85;
import com.baidu.tieba.mw8;
import com.baidu.tieba.n45;
import com.baidu.tieba.nz7;
import com.baidu.tieba.o85;
import com.baidu.tieba.og;
import com.baidu.tieba.ox7;
import com.baidu.tieba.p45;
import com.baidu.tieba.p48;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pg;
import com.baidu.tieba.pk5;
import com.baidu.tieba.px7;
import com.baidu.tieba.q85;
import com.baidu.tieba.q9;
import com.baidu.tieba.qv4;
import com.baidu.tieba.qy7;
import com.baidu.tieba.s18;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sv4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.ty7;
import com.baidu.tieba.u65;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.uv4;
import com.baidu.tieba.v18;
import com.baidu.tieba.v38;
import com.baidu.tieba.v65;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.w28;
import com.baidu.tieba.w65;
import com.baidu.tieba.wd5;
import com.baidu.tieba.x18;
import com.baidu.tieba.xg;
import com.baidu.tieba.xi;
import com.baidu.tieba.xm5;
import com.baidu.tieba.y18;
import com.baidu.tieba.y28;
import com.baidu.tieba.yi;
import com.baidu.tieba.yr4;
import com.baidu.tieba.zs6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, bz7<NewSubPbActivity>, TbRichTextView.s, jv4.e, an5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kp4 A;
    public og<ImageView> B;
    public BdUniqueId C;
    public PbModel.h D;
    public View E;
    public int F;
    public final TbRichTextView.y G;
    public boolean H;
    public qy7 I;
    public final View.OnLongClickListener J;
    public x18 K;
    public in L;
    public String M;
    public TbRichTextMemeInfo N;
    public PostData O;
    public uv4.e P;
    public Object Q;
    public final q9 R;
    public k85 S;
    public CustomMessageListener T;
    public NewWriteModel.d U;
    public View.OnClickListener V;
    public j85 W;
    public final kp4.a X;
    public PbModel a;
    public v38 b;
    public nz7 c;
    public w28 d;
    public y28 e;
    public boolean f;
    public boolean g;
    public sv4 h;
    public uv4 i;
    public PermissionJudgePolicy j;
    public BdUniqueId k;
    public ly4 l;
    public bp8 m;
    public ForumManageModel n;
    public mw8 o;
    public o85 p;
    public m85 q;
    public boolean r;
    public v18 s;
    public VoiceManager t;
    public ReplyPrivacyCheckController u;
    public ShareSuccessReplyToServerModel v;
    public int[] w;
    public int x;
    public zs6 y;
    public zs6 z;

    @Override // com.baidu.tieba.an5
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.an5
    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.an5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.an5
    public og<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return null;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public og<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.an5
    public void R(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048606, this, context, str, z) == null) {
        }
    }

    @Override // com.baidu.tieba.an5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tieba.an5
    public og<TextView> W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return null;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.an5
    public og<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return null;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public void e1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.an5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public boolean n2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.an5
    public og<GifView> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return null;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public og<TiebaPlusRecommendCard> w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return null;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.an5
    public og<LinearLayout> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return null;
        }
        return (og) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class m implements zs6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        @Override // com.baidu.tieba.zs6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.zs6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            /* renamed from: com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity$m$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0388a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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

                public C0388a(a aVar) {
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
                    v18 v18Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (v18Var = this.a.a.c.s) != null && v18Var.g() != null) {
                        if (!this.a.a.c.s.g().e()) {
                            this.a.a.c.s.b(false);
                        }
                        this.a.a.c.s.g().l(false);
                    }
                }
            }

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int g;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int j = yi.j(this.a.c.getApplicationContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = j / 2;
                        g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i2 = j - (i + g);
                    FoldCommentActivity foldCommentActivity = this.a.c;
                    boolean z = true;
                    foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.w[1] + foldCommentActivity.x) - i2, 50);
                    if (this.a.c.c.y() != null) {
                        this.a.c.q.b().setVisibility(8);
                        z = (this.a.c.a == null || this.a.c.a.S1() == null || this.a.c.a.S1().Q() == null || !this.a.c.a.S1().Q().isBjh()) ? false : false;
                        l08 y = this.a.c.c.y();
                        m mVar = this.a;
                        y.o(mVar.a, mVar.b, mVar.c.c.z(), z);
                        q85 b = this.a.c.c.y().b();
                        if (b != null && this.a.c.a != null && this.a.c.a.S1() != null) {
                            b.H(this.a.c.a.S1().d());
                            b.d0(this.a.c.a.S1().Q());
                        }
                        if (this.a.c.s.f() == null && this.a.c.c.y().b().u() != null) {
                            this.a.c.c.y().b().u().g(new C0388a(this));
                            FoldCommentActivity foldCommentActivity2 = this.a.c;
                            foldCommentActivity2.s.n(foldCommentActivity2.c.y().b().u().i());
                            this.a.c.c.y().b().N(this.a.c.W);
                        }
                    }
                    this.a.c.c.B();
                }
            }
        }

        public m(FoldCommentActivity foldCommentActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = foldCommentActivity;
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.zs6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                return;
            }
            ah.a().postDelayed(new a(this), 0L);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes5.dex */
        public class a implements jv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    jv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements jv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    jv4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public g(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b35 b35Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, b35Var, writeData, antiData}) == null) {
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.a != null && this.a.a.S1() != null) {
                        statisticItem.param("fid", this.a.a.S1().m());
                    }
                    if (this.a.a != null) {
                        statisticItem.param("tid", this.a.a.m2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (z) {
                    v18 v18Var = this.a.s;
                    if (v18Var != null) {
                        v18Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        p45.c(this.a.getPageContext(), postWriteCallBackData, 2);
                        return;
                    }
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.u;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f048b), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    jv4 jv4Var = new jv4(this.a.getActivity());
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        jv4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d3b));
                    } else {
                        jv4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new a(this));
                    jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d3d, new b(this));
                    jv4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    if (foldCommentActivity.s != null) {
                        if (foldCommentActivity.c != null && this.a.c.y() != null && this.a.c.y().b() != null && this.a.c.y().b().y()) {
                            this.a.c.y().b().w(postWriteCallBackData);
                        }
                        this.a.s.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ShareSuccessReplyToServerModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ i b;

            public a(i iVar, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ty7.a(this.b.a.getPageContext(), this.a).show();
                }
            }
        }

        public i(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.b
        public void b(CustomDialogData customDialogData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customDialogData) == null) {
                ah.a().postDelayed(new a(this, customDialogData), 1000L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

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

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                v18 v18Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (v18Var = this.a.c.s) != null && v18Var.g() != null) {
                    if (!this.a.c.s.g().e()) {
                        this.a.c.s.b(false);
                    }
                    this.a.c.s.g().l(false);
                }
            }
        }

        public l(FoldCommentActivity foldCommentActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = foldCommentActivity;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = yi.j(this.c.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = yi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = yi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                FoldCommentActivity foldCommentActivity = this.c;
                boolean z = true;
                foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.w[1] + foldCommentActivity.x) - i2, 50);
                if (this.c.c.y() != null) {
                    this.c.q.b().setVisibility(8);
                    this.c.c.y().o(this.a, this.b, this.c.c.z(), (this.c.a == null || this.c.a.S1() == null || this.c.a.S1().Q() == null || !this.c.a.S1().Q().isBjh()) ? false : false);
                    q85 b = this.c.c.y().b();
                    if (b != null && this.c.a != null && this.c.a.S1() != null) {
                        b.H(this.c.a.S1().d());
                        b.d0(this.c.a.S1().Q());
                    }
                    if (this.c.s.f() == null && this.c.c.y().b().u() != null) {
                        this.c.c.y().b().u().g(new a(this));
                        FoldCommentActivity foldCommentActivity2 = this.c;
                        foldCommentActivity2.s.n(foldCommentActivity2.c.y().b().u().i());
                        this.c.c.y().b().N(this.c.W);
                    }
                }
                this.c.c.B();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public a(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.n.getLoadDataMode();
                    if (loadDataMode != 0) {
                        if (loadDataMode == 1) {
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.c.v(1, dVar.a, dVar.b, true);
                            return;
                        }
                        return;
                    }
                    this.a.a.v2();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    this.a.T1(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                    return;
                }
                this.a.c.v(this.a.n.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public b(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) && jv4Var != null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ FoldCommentActivity b;

        public c(FoldCommentActivity foldCommentActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = foldCommentActivity;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                this.b.c.d0();
                MessageManager.getInstance().sendMessage(this.a);
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public d(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements k85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public e(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.k85
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(FoldCommentActivity foldCommentActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, Integer.valueOf(i)};
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
            this.a = foldCommentActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.q != null) {
                this.a.c.W(this.a.q.y());
            }
            this.a.c.a0(false);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public h(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.loadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            StatisticItem statisticItem;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                StatisticItem statisticItem2 = new StatisticItem("c13398");
                statisticItem2.param("tid", this.a.a.m2());
                statisticItem2.param("fid", this.a.a.getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f092094);
                    if (obj instanceof PostData) {
                        PostData postData = (PostData) obj;
                        if (this.a.a == null || this.a.a.S1() == null || postData.s() == null || postData.D() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.c.y() != null) {
                            this.a.c.y().c();
                        }
                        ey7 ey7Var = new ey7();
                        ey7Var.A(this.a.a.S1().l());
                        ey7Var.E(this.a.a.S1().Q());
                        ey7Var.C(postData);
                        this.a.c.x().V(ey7Var);
                        this.a.c.x().setPostId(postData.M());
                        this.a.r2(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        p48.b(this.a.a.S1(), postData, postData.d0, 8, 1);
                        if (this.a.q != null) {
                            this.a.c.W(this.a.q.y());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09184a && view2.getId() != R.id.obfuscated_res_0x7f0918a4) {
                if (view2.getId() != R.id.obfuscated_res_0x7f091ff6 && view2.getId() != R.id.obfuscated_res_0x7f091ff4 && view2.getId() != R.id.obfuscated_res_0x7f091848 && view2.getId() != R.id.obfuscated_res_0x7f0916d6) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f0918aa && view2.getId() != R.id.obfuscated_res_0x7f091a8d && view2.getId() != R.id.obfuscated_res_0x7f091842) {
                        if ((view2.getId() == R.id.obfuscated_res_0x7f09079e || view2.getId() == R.id.obfuscated_res_0x7f090a2a) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.obfuscated_res_0x7f0920b1) instanceof PostData)) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f0920b1);
                            View view3 = (View) sparseArray.get(R.id.obfuscated_res_0x7f0920b3);
                            if (postData2 == null || view3 == null) {
                                return;
                            }
                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09079f);
                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0907a0);
                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a2a);
                            if (postData2.t0()) {
                                postData2.T0(false);
                            } else {
                                postData2.T0(true);
                            }
                            SkinManager.setBackgroundColor(findViewById, postData2.t0() ? R.color.CAM_X0201 : R.color.transparent);
                            SkinManager.setViewTextColor(eMTextView, postData2.t0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                            WebPManager.setPureDrawable(imageView, postData2.t0() ? R.drawable.obfuscated_res_0x7f0809a1 : R.drawable.obfuscated_res_0x7f0809a0, postData2.t0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                            return;
                        }
                        return;
                    } else if (this.a.a == null) {
                        return;
                    } else {
                        if (view2.getId() == R.id.obfuscated_res_0x7f0918aa) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.a.m2());
                            statisticItem3.param("fid", this.a.a.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091a8d) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0918aa && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                            if (sparseArray2.get(R.id.obfuscated_res_0x7f0920b1) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f0920b1);
                                if (view2.getId() == R.id.obfuscated_res_0x7f0918aa && (statisticItem = postData3.e0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091a8d || view2.getId() == R.id.obfuscated_res_0x7f091842) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.a.n2()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData3.M()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.a == null || this.a.a.S1() == null || postData3.s() == null || postData3.D() == 1) {
                                    return;
                                }
                                if (this.a.c.y() != null) {
                                    this.a.c.y().c();
                                }
                                ey7 ey7Var2 = new ey7();
                                ey7Var2.A(this.a.a.S1().l());
                                ey7Var2.E(this.a.a.S1().Q());
                                ey7Var2.C(postData3);
                                this.a.c.x().V(ey7Var2);
                                this.a.c.x().setPostId(postData3.M());
                                this.a.r2(view2, postData3.s().getUserId(), "", postData3);
                                if (this.a.q != null) {
                                    this.a.c.W(this.a.q.y());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f0916d6) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.a.m2());
                    statisticItem4.param("fid", this.a.a.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f091848 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    if (!this.a.checkUpIsLogin()) {
                        p48.r("c10517", this.a.a.S1().m(), 3);
                    } else if (this.a.a == null || this.a.a.S1() == null) {
                    } else {
                        this.a.c.u();
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        PostData postData4 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f0920b1);
                        PostData postData5 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f0920b2);
                        View view4 = (View) sparseArray3.get(R.id.obfuscated_res_0x7f0920b3);
                        if (postData4 == null || view4 == null) {
                            return;
                        }
                        if (postData4.H() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem5 = postData4.e0;
                        if (statisticItem5 != null) {
                            StatisticItem copy2 = statisticItem5.copy();
                            copy2.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f0916d6) {
                                copy2.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091848) {
                                copy2.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy2);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091848 && this.a.a != null && this.a.a.S1() != null && postData4 != null) {
                            TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.a.m2()).param("fname", this.a.a.S1().n()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.M()));
                        }
                        String m2 = this.a.a.m2();
                        String M = postData4.M();
                        String M2 = postData5 != null ? postData5.M() : "";
                        int Y = this.a.a.S1() != null ? this.a.a.S1().Y() : 0;
                        this.a.x();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091c4d) {
                            if (view2.getId() != R.id.obfuscated_res_0x7f091848 || !this.a.r) {
                                TiebaStatic.log("c11742");
                                AbsPbActivity.e y2 = this.a.y2(M);
                                if (postData4 == null || this.a.a == null || this.a.a.S1() == null || y2 == null) {
                                    return;
                                }
                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, M, "pb", true, this.a.r, null, false, M2, Y, postData4.e0(), this.a.a.S1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(y2.a, y2.b, y2.g, y2.j);
                                if (!xi.isEmpty(M2)) {
                                    addBigImageData.setHighLightPostId(M2);
                                    addBigImageData.setKeyIsUseSpid(true);
                                }
                                addBigImageData.setKeyFromForumId(this.a.a.getForumId());
                                addBigImageData.setTiebaPlusData(this.a.a.I(), this.a.a.E(), this.a.a.F(), this.a.a.D(), this.a.a.J());
                                addBigImageData.setBjhData(this.a.a.k1());
                                addBigImageData.setKeyPageStartFrom(this.a.a.R1());
                                addBigImageData.setFromFrsForumId(this.a.a.getFromForumId());
                                addBigImageData.setWorksInfoData(this.a.a.r2());
                                addBigImageData.setFromFoldComment(true);
                                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                                this.a.sendMessage(new CustomMessage(2002001, addBigImageData));
                                return;
                            }
                            AbsPbActivity.e y22 = this.a.y2(M);
                            if (this.a.a == null || this.a.a.S1() == null || y22 == null) {
                                return;
                            }
                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, M, "pb", true, this.a.r, null, true, null, Y, postData4.e0(), this.a.a.S1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(y22.a, y22.b, y22.g, y22.j);
                            addBigImageData2.setKeyPageStartFrom(this.a.a.R1());
                            addBigImageData2.setFromFrsForumId(this.a.a.getFromForumId());
                            addBigImageData2.setWorksInfoData(this.a.a.r2());
                            addBigImageData2.setKeyFromForumId(this.a.a.getForumId());
                            addBigImageData2.setBjhData(this.a.a.k1());
                            addBigImageData2.setTiebaPlusData(this.a.a.I(), this.a.a.E(), this.a.a.F(), this.a.a.D(), this.a.a.J());
                            addBigImageData2.setFromFoldComment(true);
                            addBigImageData2.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, addBigImageData2));
                            return;
                        }
                        AbsPbActivity.e y23 = this.a.y2(M);
                        if (this.a.a == null || this.a.a.S1() == null || y23 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, M, "pb", true, this.a.r, null, true, null, Y, postData4.e0(), this.a.a.S1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(y23.a, y23.b, y23.g, y23.j);
                        addBigImageData3.setKeyPageStartFrom(this.a.a.R1());
                        addBigImageData3.setFromFrsForumId(this.a.a.getFromForumId());
                        addBigImageData3.setWorksInfoData(this.a.a.r2());
                        addBigImageData3.setKeyFromForumId(this.a.a.getForumId());
                        addBigImageData3.setBjhData(this.a.a.k1());
                        addBigImageData3.setTiebaPlusData(this.a.a.I(), this.a.a.E(), this.a.a.F(), this.a.a.D(), this.a.a.J());
                        addBigImageData3.setFromFoldComment(true);
                        addBigImageData3.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                        this.a.sendMessage(new CustomMessage(2002001, addBigImageData3));
                    }
                }
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c13398");
                statisticItem6.param("tid", this.a.a.m2());
                statisticItem6.param("fid", this.a.a.getForumId());
                statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem6.param("obj_locate", 7);
                TiebaStatic.log(statisticItem6);
                if (this.a.a != null && this.a.a.S1() != null && this.a.O != null) {
                    TiebaStatic.log(new StatisticItem("c14441").param("tid", this.a.a.m2()).param("fname", this.a.a.S1().n()).param("fid", this.a.a.S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.O.M()));
                }
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.g = false;
                foldCommentActivity.P1(view2);
            }
        }

        public j(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(ox7 ox7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ox7Var) == null) {
            }
        }

        public k(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, ox7 ox7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ox7Var, str, Integer.valueOf(i4)}) != null) || this.a.c == null) {
                return;
            }
            this.a.c.U();
            if (z) {
                this.a.c.E();
                if (ox7Var != null) {
                    if (ox7Var.s() == 1) {
                        this.a.f = true;
                    } else {
                        this.a.f = false;
                    }
                    String str2 = null;
                    if (this.a.a != null && this.a.a.A2()) {
                        str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e37);
                    } else if (this.a.c != null) {
                        str2 = this.a.c.z();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.q.c0(TbSingleton.getInstance().getAdVertiComment(ox7Var.r0(), ox7Var.s0(), str2));
                    }
                    this.a.c.S(ox7Var, this.a.f);
                    return;
                }
                return;
            }
            this.a.v2(i, str);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements j85 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public n(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.j85
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                v18 v18Var = this.a.s;
                if (v18Var != null && v18Var.g() != null && this.a.s.g().d()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.showToast(foldCommentActivity.s.g().c());
                    if (this.a.c != null && this.a.c.y() != null && this.a.c.y().b() != null && this.a.c.y().b().y()) {
                        this.a.c.y().b().w(this.a.s.h());
                    }
                    this.a.s.b(true);
                    return true;
                } else if (!this.a.M1(ReplyPrivacyCheckController.TYPE_FLOOR)) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements zs6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tieba.zs6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.zs6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        public o(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.zs6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.q != null && this.a.q.b() != null) {
                    this.a.q.b().A(new k65(45, 27, null));
                }
                this.a.c.t();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements kp4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public p(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.kp4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.A != null) {
                        this.a.A.h(z2);
                    }
                    this.a.a.H3(z2);
                    if (this.a.a.D1()) {
                        this.a.s2();
                    }
                    if (z2) {
                        if (this.a.A != null) {
                            if (this.a.A.f() != null && this.a.a != null && this.a.a.S1() != null && this.a.a.S1().Q() != null && this.a.a.S1().Q().getAuthor() != null) {
                                MarkData f = this.a.A.f();
                                MetaData author = this.a.a.S1().Q().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d3);
                                        if (i45.g(this.a.getActivity(), 0)) {
                                            i45.i(this.a.getPageContext(), 6, 2000L);
                                        }
                                    }
                                } else {
                                    FoldCommentActivity foldCommentActivity = this.a;
                                    foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d2));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.H1();
                        return;
                    }
                    FoldCommentActivity foldCommentActivity2 = this.a;
                    foldCommentActivity2.showToast(foldCommentActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f1025));
                    return;
                }
                FoldCommentActivity foldCommentActivity3 = this.a;
                foldCommentActivity3.showToast(foldCommentActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f1524));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements pg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public q(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
                    if (br4.c().g()) {
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
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = br4.c().g();
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
    public class r implements TbRichTextView.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public r(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v17, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$Builder */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view2.getTag(R.id.obfuscated_res_0x7f0920d1) != null && (view2.getTag(R.id.obfuscated_res_0x7f0920d1) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f0920d1);
                        boolean w = ((TbImageView) view2).w();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                        }
                        this.a.E = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.w2(str, i, eVar);
                    if (this.a.a.S1().l0()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        TbRichTextView tbRichTextView = null;
                        if (view2.getParent() instanceof TbRichTextView) {
                            tbRichTextView = (TbRichTextView) view2.getParent();
                        } else if ((view2.getParent() instanceof GridImageLayout) && (view2.getParent().getParent() instanceof TbRichTextView)) {
                            tbRichTextView = (TbRichTextView) view2.getParent().getParent();
                        }
                        int i3 = -1;
                        if (tbRichTextView != null && tbRichTextView.getRichText() != null && tbRichTextView.getRichText().D() != null) {
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
                        } else {
                            i2 = -1;
                        }
                        ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
                        builder.A(arrayList);
                        builder.E(i2);
                        builder.F(false);
                        builder.O(eVar.f);
                        builder.I(this.a.a.d2());
                        builder.y(concurrentHashMap);
                        builder.K(true);
                        builder.N(false);
                        builder.J(this.a.m2());
                        if (this.a.a != null) {
                            builder.D(this.a.a.getFromForumId());
                            if (this.a.a.S1() != null) {
                                builder.Q(this.a.a.S1().Q());
                            }
                        }
                        ImageViewerConfig x = builder.x(this.a.getPageContext().getPageActivity());
                        x.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else if (!eVar.h) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(ListUtils.getItem(eVar.a, 0));
                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                        if (!ListUtils.isEmpty(arrayList2)) {
                            String str2 = (String) arrayList2.get(0);
                            concurrentHashMap2.put(str2, eVar.b.get(str2));
                        }
                        ImageViewerConfig.Builder builder2 = new ImageViewerConfig.Builder();
                        builder2.A(arrayList2);
                        builder2.C(eVar.c);
                        builder2.B(eVar.d);
                        builder2.R(eVar.e);
                        builder2.F(eVar.g);
                        builder2.K(true);
                        builder2.M(eVar.a.get(0));
                        builder2.I(this.a.a.d2());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.m2());
                        builder2.z(eVar.f);
                        builder2.O(eVar.f);
                        builder2.G(false);
                        if (this.a.a != null) {
                            builder2.D(this.a.a.getFromForumId());
                            if (this.a.a.S1() != null) {
                                builder2.Q(this.a.a.S1().Q());
                            }
                        }
                        ImageViewerConfig x2 = builder2.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText L2 = this.a.L2(str, i);
                        if (L2 != null && this.a.F >= 0 && this.a.F < L2.B().size()) {
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            String a = px7.a(L2.B().get(this.a.F));
                            int i6 = 0;
                            while (true) {
                                if (i6 >= eVar.a.size()) {
                                    break;
                                } else if (eVar.a.get(i6).equals(a)) {
                                    eVar.j = i6;
                                    arrayList3.add(a);
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!ListUtils.isEmpty(arrayList3)) {
                                String str3 = arrayList3.get(0);
                                concurrentHashMap3.put(str3, eVar.b.get(str3));
                            }
                            ImageViewerConfig.Builder builder3 = new ImageViewerConfig.Builder();
                            builder3.A(arrayList3);
                            builder3.C(eVar.c);
                            builder3.B(eVar.d);
                            builder3.R(eVar.e);
                            builder3.F(eVar.g);
                            builder3.K(true);
                            builder3.M(eVar.i);
                            builder3.I(this.a.a.d2());
                            builder3.y(concurrentHashMap3);
                            builder3.N(false);
                            builder3.J(this.a.m2());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            if (this.a.a != null) {
                                builder3.D(this.a.a.getFromForumId());
                                if (this.a.a.S1() != null) {
                                    builder3.Q(this.a.a.S1().Q());
                                }
                            }
                            ImageViewerConfig x3 = builder3.x(this.a.getPageContext().getPageActivity());
                            x3.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, x3));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public s(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.q.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.c != null && this.a.c.y() != null && this.a.c.y().b() != null) {
                    this.a.c.y().b().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements PbFragment.h3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public t(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.h3
        public void a(Object obj) {
            String str;
            String str2;
            String str3;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.a.S1().X().getUserId());
                if (objArr.length <= 1) {
                    str = "";
                } else {
                    str = String.valueOf(objArr[1]);
                }
                if (objArr.length <= 2) {
                    str2 = "";
                } else {
                    str2 = String.valueOf(objArr[2]);
                }
                if (objArr.length <= 3) {
                    str3 = "";
                } else {
                    str3 = String.valueOf(objArr[3]);
                }
                if (objArr.length <= 4) {
                    str4 = "";
                } else {
                    str4 = String.valueOf(objArr[4]);
                }
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.a.S1().l().getId(), this.a.a.S1().l().getName(), this.a.a.S1().Q().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements qy7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tieba.qy7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.qy7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public u(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.qy7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091c6b) {
                        if (this.a.A2(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091847) {
                        if (view2.getTag(R.id.obfuscated_res_0x7f0920a7) instanceof SparseArray) {
                            this.a.G2((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f0920a7));
                        }
                    } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.obfuscated_res_0x7f0918a3) {
                        SparseArray sparseArray = null;
                        if (view2.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view2.getTag();
                        }
                        if (sparseArray == null) {
                            return false;
                        }
                        this.a.G2(sparseArray);
                    }
                }
                if (this.a.q != null) {
                    this.a.c.W(this.a.q.y());
                }
                this.a.c.R();
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public v(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            return this.a.P1(view2);
        }
    }

    /* loaded from: classes5.dex */
    public class w implements uv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public w(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.uv4.e
        public void n0(uv4 uv4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, uv4Var, i, view2) == null) {
                if (this.a.h != null) {
                    this.a.h.dismiss();
                }
                this.a.J2(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091828);
                        this.a.z2(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091827);
                        this.a.z2(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09182a);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.z2(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09182a);
                        if (view6 == null) {
                            return;
                        }
                        this.a.z2(view6);
                        AgreeView agreeView2 = (AgreeView) view6;
                        if (agreeView2.getImgAgree() != null) {
                            agreeView2.getImgAgree().performClick();
                            return;
                        }
                        return;
                    case 0:
                    default:
                        return;
                    case 1:
                        if (this.a.L != null && !TextUtils.isEmpty(this.a.M)) {
                            if (this.a.N == null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.M));
                            } else {
                                l95.a aVar = new l95.a();
                                aVar.a = this.a.M;
                                String str = "";
                                if (this.a.N.memeInfo.pck_id.intValue() >= 0) {
                                    str = "" + this.a.N.memeInfo.pck_id;
                                }
                                aVar.b = str;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                            }
                            this.a.L = null;
                            this.a.M = null;
                            return;
                        }
                        return;
                    case 2:
                        if (this.a.L != null && !TextUtils.isEmpty(this.a.M)) {
                            if (this.a.j == null) {
                                this.a.j = new PermissionJudgePolicy();
                            }
                            this.a.j.clearRequestPermissionList();
                            this.a.j.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                            if (this.a.j.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                return;
                            }
                            if (this.a.K == null) {
                                FoldCommentActivity foldCommentActivity = this.a;
                                foldCommentActivity.K = new x18(foldCommentActivity.getPageContext());
                            }
                            this.a.K.b(this.a.M, this.a.L.n());
                            this.a.L = null;
                            this.a.M = null;
                            return;
                        }
                        return;
                    case 3:
                        PostData postData = this.a.O;
                        if (postData != null) {
                            postData.F0();
                            this.a.O = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (!this.a.checkUpIsLogin()) {
                            return;
                        }
                        this.a.t2(view2);
                        if (this.a.a.S1().Q() != null && this.a.a.S1().Q().getAuthor() != null && this.a.a.S1().Q().getAuthor().getUserId() != null && this.a.A != null) {
                            FoldCommentActivity foldCommentActivity2 = this.a;
                            int f2 = foldCommentActivity2.f2(foldCommentActivity2.a.S1());
                            ThreadData Q = this.a.a.S1().Q();
                            if (Q.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (Q.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!Q.isBJHNormalThreadType()) {
                                if (Q.isBJHVideoDynamicThreadType()) {
                                    i2 = 5;
                                } else {
                                    i2 = 1;
                                }
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.m2()).param("obj_locate", 2).param("obj_id", this.a.a.S1().Q().getAuthor().getUserId()).param("obj_type", !this.a.A.e()).param("obj_source", f2).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                            return;
                        }
                        Object tag = view2.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.i2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f0920a7, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f092090, 2);
                                this.a.K1(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f092098) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f092096) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f0920b4) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f092097) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f0920a8) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092097)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f0920b4)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f0920a8)).booleanValue();
                            boolean F = this.a.F(TbadkCoreApplication.getCurrentAccount());
                            if (F) {
                                if (booleanValue2) {
                                    this.a.c.N(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f092096), intValue, booleanValue, null, F);
                                    return;
                                } else {
                                    this.a.E2(sparseArray3, intValue, booleanValue);
                                    return;
                                }
                            } else if (!booleanValue || booleanValue2) {
                                this.a.c.L(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f092096), intValue, booleanValue);
                                return;
                            } else {
                                this.a.E2(sparseArray3, intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c82);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920db)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
                        if (booleanValue3) {
                            if (booleanValue5) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f0920a7, 1);
                                sparseArray4.put(R.id.obfuscated_res_0x7f092090, 2);
                                this.a.K1(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.obfuscated_res_0x7f092090, 2);
                            this.a.c.P(view2);
                            return;
                        } else if (booleanValue4) {
                            this.a.c.L(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f092096), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    case 8:
                        if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                            return;
                        }
                        PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094);
                        if (postData2.q() == null) {
                            return;
                        }
                        this.a.N1(postData2.q());
                        return;
                    case 9:
                        if (this.a.checkUpIsLogin() && this.a.a != null && this.a.a.S1() != null) {
                            this.a.D2(lw8.c(view2));
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ FoldCommentActivity d;

        public x(FoldCommentActivity foldCommentActivity, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = foldCommentActivity;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                if (jv4Var != null) {
                    jv4Var.dismiss();
                }
                this.d.S1(((Integer) this.a.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f092096), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements jv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        public y(FoldCommentActivity foldCommentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foldCommentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = foldCommentActivity;
        }

        @Override // com.baidu.tieba.jv4.e
        public void onClick(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                jv4Var.dismiss();
            }
        }
    }

    public FoldCommentActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = true;
        this.r = false;
        this.w = new int[2];
        this.A = null;
        this.D = new k(this);
        this.F = 0;
        this.G = new r(this);
        this.H = false;
        this.I = new qy7(new u(this));
        this.J = new v(this);
        this.O = null;
        this.P = new w(this);
        this.R = new a(this);
        this.S = new e(this);
        this.T = new f(this, 2004008);
        this.U = new g(this);
        this.V = new j(this);
        this.W = new n(this);
        this.X = new p(this);
    }

    public void x2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048663, this) != null) || !checkUpIsLogin() || (pbModel = this.a) == null || pbModel.S1() == null || this.a.S1().l() == null || J1()) {
            return;
        }
        if (this.a.S1().l0()) {
            this.c.t();
            return;
        }
        if (this.y == null) {
            zs6 zs6Var = new zs6(getPageContext());
            this.y = zs6Var;
            zs6Var.j(0);
            this.y.i(new o(this));
        }
        this.y.g(this.a.S1().l().getId(), xg.g(this.a.m2(), 0L));
    }

    public final void C2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.q.X(z);
            this.q.a0(z);
            this.q.i0(z);
        }
    }

    public void D2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && str != null && this.o != null) {
            this.o.n(xg.g(str, 0L));
        }
    }

    @Override // com.baidu.tieba.bz7
    public boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.K2(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void I2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.C);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final boolean Y1(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().I();
        }
        return invokeL.booleanValue;
    }

    public final boolean Z1(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().J();
        }
        return invokeL.booleanValue;
    }

    public final String b2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return null;
            }
            return tbRichTextData.F().D();
        }
        return (String) invokeL.objValue;
    }

    public final long c2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return 0L;
            }
            return tbRichTextData.F().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final boolean k2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, bundle)) == null) {
            if (bundle != null) {
                this.r = bundle.getBoolean("is_jump_from_video_tab", false);
            } else {
                this.r = getIntent().getBooleanExtra("is_jump_from_video_tab", false);
            }
            return this.r;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jv4.e
    public void onClick(jv4 jv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, jv4Var) == null) {
            R1(jv4Var, null);
        }
    }

    public final void p2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void t2(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094)) == null) {
                return;
            }
            u2(postData);
        }
    }

    public final boolean A2(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f092094);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (checkUpIsLogin() && (pbModel = this.a) != null && pbModel.S1() != null) {
                if (this.c.y() != null) {
                    this.c.y().c();
                }
                ey7 ey7Var = new ey7();
                ey7Var.A(this.a.S1().l());
                ey7Var.E(this.a.S1().Q());
                ey7Var.C(postData);
                TiebaStatic.log("c11743");
                this.c.x().V(ey7Var);
                this.c.x().setPostId(postData.M());
                r2(view2, postData.s().getUserId(), "", postData);
                m85 m85Var = this.q;
                if (m85Var != null) {
                    this.c.W(m85Var.y());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N1(AgreeData agreeData) {
        wd5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.l == null) {
            this.l = new ly4();
        }
        if (this.m == null) {
            bp8 bp8Var = new bp8();
            this.m = bp8Var;
            bp8Var.a = getUniqueId();
        }
        yr4 yr4Var = new yr4();
        yr4Var.b = 5;
        yr4Var.h = 8;
        yr4Var.g = 2;
        PbModel pbModel2 = this.a;
        if (pbModel2 != null) {
            yr4Var.f = pbModel2.R1();
        }
        yr4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                yr4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l.c(agreeData, i2, getUniqueId(), false);
                this.l.d(agreeData, this.m);
                pbModel = this.a;
                if (pbModel == null && pbModel.S1() != null) {
                    this.l.b(this, yr4Var, agreeData, this.a.S1().Q());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            yr4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            yr4Var.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
        if (currentVisiblePageExtra != null) {
        }
        this.l.c(agreeData, i2, getUniqueId(), false);
        this.l.d(agreeData, this.m);
        pbModel = this.a;
        if (pbModel == null) {
        }
    }

    public final void B2(o85 o85Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o85Var) == null) && o85Var != null && (pbModel = this.a) != null) {
            o85Var.p(pbModel.r1());
            if (this.a.S1() != null && this.a.S1().l() != null) {
                o85Var.o(this.a.S1().l());
            }
            o85Var.q("pb");
            o85Var.r(this.a);
        }
    }

    public boolean M1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            if (this.u != null && this.a.S1() != null && !ThreadCardUtils.isSelf(this.a.S1().Q()) && this.a.S1().d() != null) {
                return this.u.checkPrivacyBeforeSend(this.a.S1().d().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void j2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bundle) == null) {
            this.k = getUniqueId();
            kp4 c2 = kp4.c(this);
            this.A = c2;
            if (c2 != null) {
                c2.j(this.X);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this);
            this.n = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.R);
            if (bundle != null) {
                this.a = new PbModel(this, bundle, this.D);
            } else {
                this.a = new PbModel(this, getIntent(), this.D);
            }
            this.a.C3(true);
            this.a.E3(4);
        }
    }

    public final void E2(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            m38.e(getActivity(), getPageContext(), new x(this, sparseArray, i2, z), new y(this));
        }
    }

    public final void F2(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                this.c.d0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            jv4 jv4Var = new jv4(this);
            if (!xi.isEmpty(str)) {
                jv4Var.setMessage(str);
            } else {
                jv4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0324, str3));
            }
            jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0440, new c(this, userMuteAddAndDelCustomMessage));
            jv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new d(this));
            jv4Var.create(getPageContext()).show();
        }
    }

    public final void G2(SparseArray<Object> sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.obfuscated_res_0x7f092094) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094)) == null) {
            return;
        }
        H2(postData, false);
    }

    public final void J2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.m2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(m38.n(i2))));
        }
    }

    public void K1(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = xg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = xg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f0920ed), 0L);
            BdUniqueId bdUniqueId = this.k;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.Q = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final int f2(ox7 ox7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, ox7Var)) == null) {
            if (ox7Var != null && ox7Var.Q() != null) {
                if (ox7Var.Q().getThreadType() == 0) {
                    return 1;
                }
                if (ox7Var.Q().getThreadType() == 54) {
                    return 2;
                }
                if (ox7Var.Q().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void z2(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048667, this, view2) != null) || view2 == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view2.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        if (this.g) {
            i2 = 2;
        } else {
            i2 = 3;
        }
        sparseArray.put(R.id.obfuscated_res_0x7f0918cb, Integer.valueOf(i2));
        view2.setTag(sparseArray);
    }

    public final void H1() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (pbModel = this.a) != null && pbModel.S1() != null && this.a.S1().Q() != null) {
            ThreadData Q = this.a.S1().Q();
            Q.mRecomAbTag = this.a.X1();
            Q.mRecomWeight = this.a.a2();
            Q.mRecomSource = this.a.Z1();
            Q.mRecomExtra = this.a.Y1();
            Q.isSubPb = this.a.F1();
            if (Q.getFid() == 0) {
                Q.setFid(xg.g(this.a.getForumId(), 0L));
            }
            StatisticItem i2 = be5.i(this, Q, "c13562");
            TbPageTag l2 = be5.l(this);
            if (l2 != null && "a008".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a008");
            }
            if (l2 != null && "a002".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    public PostData V1() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null && this.a.S1().Q() != null && this.a.S1().Q().getAuthor() != null) {
                PostData postData = new PostData();
                MetaData author = this.a.S1().Q().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = this.a.S1().Q().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                postData.G0(1);
                postData.M0(this.a.S1().Q().getFirstPostId());
                postData.d1(this.a.S1().Q().getTitle());
                postData.c1(this.a.S1().Q().getCreateTime());
                postData.E0(author);
                return postData;
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public final void H2(PostData postData, boolean z) {
        PbModel pbModel;
        int i2;
        ArrayList<IconData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048587, this, postData, z) != null) || postData == null || (pbModel = this.a) == null || pbModel.S1() == null || postData.D() == 1) {
            return;
        }
        String m2 = this.a.m2();
        String M = postData.M();
        if (this.a.S1() != null) {
            i2 = this.a.S1().Y();
        } else {
            i2 = 0;
        }
        AbsPbActivity.e y2 = y2(M);
        if (y2 == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this);
        boolean z2 = this.r;
        SmallTailInfo e0 = postData.e0();
        AntiData d2 = this.a.S1().d();
        if (postData.s() != null) {
            arrayList = postData.s().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(m2, M, "pb", true, z2, null, false, null, i2, e0, d2, false, arrayList, 5).addBigImageData(y2.a, y2.b, y2.g, y2.j);
        addBigImageData.setKeyPageStartFrom(this.a.R1());
        addBigImageData.setFromFrsForumId(this.a.getFromForumId());
        addBigImageData.setWorksInfoData(this.a.r2());
        addBigImageData.setKeyFromForumId(this.a.getForumId());
        addBigImageData.setBjhData(this.a.k1());
        addBigImageData.setIsOpenEditor(z);
        addBigImageData.setFromFoldComment(true);
        addBigImageData.setFromVideoPageUniqueId((BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id"));
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    public void Q1(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(s18.l2)).intValue();
            if (intValue == s18.m2) {
                if (this.n.S()) {
                    return;
                }
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f092096);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f0920b4)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092098)).intValue();
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920aa) != null) {
                    z = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920aa)).booleanValue();
                } else {
                    z = false;
                }
                if (jSONArray != null) {
                    this.n.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.n.V(this.a.S1().l().getId(), this.a.S1().l().getName(), this.a.S1().Q().getId(), str, intValue3, intValue2, booleanValue, this.a.S1().Q().getBaijiahaoData(), z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == s18.n2 || intValue == s18.p2) {
                if (this.a.n1() != null) {
                    this.a.n1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == s18.n2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void T1(ForumManageModel.b bVar, boolean z) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048610, this, bVar, z) != null) || bVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(bVar.b)) {
            string = bVar.b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f04c0);
        }
        int i2 = 0;
        if (bVar.c == 1211066) {
            hideProgressBar();
            jv4 jv4Var = new jv4(getPageContext().getPageActivity());
            jv4Var.setMessage(string);
            jv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04fe, new b(this));
            jv4Var.setCancelable(true);
            jv4Var.create(getPageContext());
            jv4Var.show();
        } else if (bVar.d != 0) {
            this.c.v(0, bVar.a, bVar.b, z);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList<PostData> H = this.a.S1().H();
                int size = H.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.g.equals(H.get(i2).M())) {
                        H.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.a.S1().Q().setReply_num(this.a.S1().Q().getReply_num() - 1);
            } else if (i3 == 0) {
                O1();
            } else if (i3 == 2) {
                ArrayList<PostData> H2 = this.a.S1().H();
                int size2 = H2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= H2.get(i4).b0().size()) {
                            break;
                        } else if (bVar.g.equals(H2.get(i4).b0().get(i5).M())) {
                            H2.get(i4).b0().remove(i5);
                            H2.get(i4).k();
                            z2 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    H2.get(i4).l(bVar.g);
                }
            }
        }
    }

    public final void g2(int i2, Intent intent) {
        w65 w65Var;
        w65 w65Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048632, this, i2, intent) == null) {
            if (i2 == 0) {
                this.c.D();
                this.c.y().c();
                this.c.a0(false);
            }
            this.c.R();
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
            writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
            int editorType = pbEditorData.getEditorType();
            if (editorType != 0) {
                if (editorType == 1 && this.c.y() != null && this.c.y().b() != null) {
                    q85 b2 = this.c.y().b();
                    b2.d0(this.a.S1().Q());
                    b2.C(writeData);
                    b2.e0(pbEditorData.getVoiceModel());
                    v65 n2 = b2.b().n(6);
                    if (n2 != null && (w65Var2 = n2.m) != null) {
                        w65Var2.B(new k65(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b2.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.q.L();
            this.q.m0(pbEditorData.getVoiceModel());
            this.q.B(writeData);
            v65 n3 = this.q.b().n(6);
            if (n3 != null && (w65Var = n3.m) != null) {
                w65Var.B(new k65(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.q.G(null, null);
            }
        }
    }

    public final void I1(ox7 ox7Var, ArrayList<PostData> arrayList) {
        List<PostData> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, ox7Var, arrayList) == null) && ox7Var != null && ox7Var.V() != null && ox7Var.V().a != null && (list = ox7Var.V().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator<PostData> it = arrayList.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            PostData postData = (PostData) it2.next();
                            if (postData != null && !TextUtils.isEmpty(next.M()) && !TextUtils.isEmpty(postData.M()) && next.M().equals(postData.M())) {
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
        }
    }

    public final boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.S1() == null) {
                return false;
            }
            ThreadData Q = this.a.S1().Q();
            AntiData d2 = this.a.S1().d();
            if (!AntiHelper.b(getPageContext(), Q) && !AntiHelper.d(getPageContext(), d2)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.E(this.a.getForumId()) && this.a.S1() != null && this.a.S1().l() != null) {
            boolean z = true;
            if (this.a.S1().l().isLike() != 1) {
                z = false;
            }
            if (z) {
                this.a.f1().D(this.a.getForumId(), this.a.m2());
            }
        }
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if ((this.a.S1() != null && (this.a.S1().l0() || ThreadCardUtils.isSelf(this.a.S1().Q()))) || this.u == null || this.a.S1() == null || this.a.S1().d() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeInvokeEditor(this.a.S1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.a.x1() || this.a.A1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", this.a.m2());
                setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.m2()));
            finish();
        }
    }

    public final TbRichText L2(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, str, i2)) == null) {
            PbModel pbModel = this.a;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.S1() == null || str == null || i2 < 0) {
                return null;
            }
            ox7 S1 = this.a.S1();
            if (S1.j() != null) {
                ArrayList<PostData> arrayList = new ArrayList<>();
                arrayList.add(S1.j());
                tbRichText = W1(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList<PostData> H = S1.H();
                I1(S1, H);
                return W1(H, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void R1(jv4 jv4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, jv4Var, jSONArray) == null) {
            jv4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(jv4Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                Q1((SparseArray) jv4Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    @Override // com.baidu.tieba.an5
    public og<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.B == null) {
                this.B = new og<>(new q(this), 8, 0);
            }
            return this.B;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bz7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null) {
                return this.a.S1().Y();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public AntiData U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null) {
                return this.a.S1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bz7
    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.r1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public PbModel a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            }
        }
    }

    public m85 d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.q;
        }
        return (m85) invokeV.objValue;
    }

    public y28 e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.e;
        }
        return (y28) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            super.onDestroy();
            ReplyPrivacyCheckController replyPrivacyCheckController = this.u;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            super.onPause();
            if (this.r) {
                I2(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            super.onResume();
            if (this.r) {
                I2(true);
            }
        }
    }

    public final void q2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (pbModel = this.a) != null) {
            pbModel.T2();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            ox7 S1 = this.a.S1();
            this.a.H3(true);
            kp4 kp4Var = this.A;
            if (kp4Var != null) {
                S1.L0(kp4Var.g());
            }
        }
    }

    @Override // com.baidu.tieba.bz7
    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null) {
                return false;
            }
            return pbModel.J2();
        }
        return invokeV.booleanValue;
    }

    public final void x() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && (voiceManager = this.t) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tieba.bz7
    public w28 y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.d;
        }
        return (w28) invokeV.objValue;
    }

    public final boolean P1(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        kp4 kp4Var;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String str;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        List<qv4> c2;
        int i2;
        boolean z12;
        qv4 qv4Var;
        qv4 qv4Var2;
        qv4 qv4Var3;
        in inVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092094);
            this.O = postData;
            if (postData == null || (kp4Var = this.A) == null) {
                return true;
            }
            if (kp4Var.e() && this.O.M() != null) {
                this.O.M().equals(this.a.N1());
            }
            if (this.i == null) {
                uv4 uv4Var = new uv4(this);
                this.i = uv4Var;
                uv4Var.n(this.P);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                boolean n2 = n2(view2);
                if (n2(view2) && (inVar = this.L) != null && !inVar.t()) {
                    z = true;
                } else {
                    z = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920ad) instanceof Boolean) {
                    z2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920ad)).booleanValue();
                } else {
                    z2 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092097) instanceof Boolean) {
                    z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue();
                } else {
                    z3 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) {
                    z4 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
                } else {
                    z4 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920dd) instanceof Boolean) {
                    z5 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue();
                } else {
                    z5 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
                } else {
                    z6 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920db) instanceof Boolean) {
                    z7 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920db)).booleanValue();
                } else {
                    z7 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920a4) instanceof String) {
                    str = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920a4);
                } else {
                    str = null;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920ac) instanceof Boolean) {
                    z8 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920ac)).booleanValue();
                } else {
                    z8 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f0920b5) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920b5)).booleanValue();
                } else {
                    z9 = false;
                }
                if (n2) {
                    z10 = z2;
                    z11 = z9;
                    arrayList.add(new qv4(1, getString(R.string.obfuscated_res_0x7f0f10e2), this.i));
                } else {
                    z10 = z2;
                    z11 = z9;
                }
                if (z) {
                    arrayList.add(new qv4(2, getString(R.string.obfuscated_res_0x7f0f10e3), this.i));
                }
                if (!n2 && !z) {
                    qv4 qv4Var4 = new qv4(3, getString(R.string.obfuscated_res_0x7f0f045c), this.i);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.obfuscated_res_0x7f092094, this.O);
                    qv4Var4.d.setTag(sparseArray2);
                    arrayList.add(qv4Var4);
                }
                if (this.mIsLogin) {
                    if (!m38.j(this.a) && !z5 && z4) {
                        qv4 qv4Var5 = new qv4(5, getString(R.string.obfuscated_res_0x7f0f0b6a), this.i);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                        sparseArray3.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                        sparseArray3.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                        sparseArray3.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                        qv4Var5.d.setTag(sparseArray3);
                        arrayList.add(qv4Var5);
                    } else {
                        if (o2(z3) && TbadkCoreApplication.isLogin()) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            qv4 qv4Var6 = new qv4(5, getString(R.string.obfuscated_res_0x7f0f104a), this.i);
                            qv4Var6.d.setTag(str);
                            arrayList.add(qv4Var6);
                        }
                    }
                    if (z5) {
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920dd, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920a1, sparseArray.get(R.id.obfuscated_res_0x7f0920a1));
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920a2, sparseArray.get(R.id.obfuscated_res_0x7f0920a2));
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920a3, sparseArray.get(R.id.obfuscated_res_0x7f0920a3));
                        sparseArray4.put(R.id.obfuscated_res_0x7f0920a4, str);
                        if (!m38.j(this.a) && z6) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920f1, Boolean.TRUE);
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                        }
                        if (z7) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                            sparseArray4.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z3));
                            sparseArray4.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                            sparseArray4.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920a8, sparseArray.get(R.id.obfuscated_res_0x7f0920a8));
                            if (z8) {
                                qv4Var = new qv4(6, getString(R.string.obfuscated_res_0x7f0f04bb), this.i);
                                qv4Var.d.setTag(sparseArray4);
                                qv4Var2 = new qv4(7, getString(R.string.obfuscated_res_0x7f0f02e9), this.i);
                                qv4Var2.d.setTag(sparseArray4);
                            }
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f0920db, Boolean.FALSE);
                        }
                        qv4Var = null;
                        qv4Var2 = new qv4(7, getString(R.string.obfuscated_res_0x7f0f02e9), this.i);
                        qv4Var2.d.setTag(sparseArray4);
                    } else {
                        if (z7) {
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920dd, Boolean.FALSE);
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920f1, Boolean.FALSE);
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920db, Boolean.TRUE);
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z3));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                            sparseArray5.put(R.id.obfuscated_res_0x7f0920a8, sparseArray.get(R.id.obfuscated_res_0x7f0920a8));
                            if (this.a.S1().Y() == 1002 && !z3) {
                                qv4Var3 = new qv4(6, getString(R.string.obfuscated_res_0x7f0f104a), this.i);
                            } else {
                                qv4Var3 = new qv4(6, getString(R.string.obfuscated_res_0x7f0f04bb), this.i);
                            }
                            qv4Var3.d.setTag(sparseArray5);
                            if (z11) {
                                new qv4(13, getString(R.string.obfuscated_res_0x7f0f0b5a), this.i);
                            }
                            qv4Var = qv4Var3;
                        } else {
                            qv4Var = null;
                        }
                        qv4Var2 = null;
                    }
                    if (qv4Var != null) {
                        arrayList.add(qv4Var);
                    }
                    if (qv4Var2 != null) {
                        arrayList.add(qv4Var2);
                    }
                    m38.b(arrayList, this.i, this.O, this.a);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c2 = m38.d(arrayList, this.O.q(), sparseArray, this.i);
                } else {
                    c2 = m38.c(arrayList, this.O.q(), sparseArray, this.i);
                }
                m38.m(c2, this.g);
                m38.f(c2);
                this.i.o(m38.h(this.O));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.i.k(c2, false);
                } else {
                    this.i.k(c2, true);
                }
                sv4 sv4Var = new sv4(getPageContext(), this.i);
                this.h = sv4Var;
                sv4Var.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.a.m2()).param("fid", this.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("post_id", this.a.B());
                if (z10) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                TiebaStatic.log(param.param("obj_source", i2));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void S1(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f092096, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092098, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z));
            sparseArray.put(s18.l2, Integer.valueOf(s18.m2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                Q1(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final TbRichText W1(ArrayList<PostData> arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048616, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText X = arrayList.get(i3).X();
                    if (X != null && (B = X.B()) != null) {
                        int size = B.size();
                        int i4 = -1;
                        for (int i5 = 0; i5 < size; i5++) {
                            if (B.get(i5) != null && B.get(i5).getType() == 8) {
                                i4++;
                                if (!B.get(i5).F().B().equals(str) && !B.get(i5).F().C().equals(str)) {
                                    if (i4 > i2) {
                                        break;
                                    }
                                } else {
                                    int i6 = (int) yi.i(TbadkCoreApplication.getInst());
                                    int width = B.get(i5).F().getWidth() * i6;
                                    int height = B.get(i5).F().getHeight() * i6;
                                    if (width < 80 || height < 80 || width * height < 10000) {
                                        return null;
                                    }
                                    this.F = i5;
                                    return X;
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

    public final int X1(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z;
        TbRichTextImageInfo F;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048617, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.H = true;
            }
            if (tbRichText != null) {
                int size = tbRichText.B().size();
                int i5 = i2;
                int i6 = -1;
                for (int i7 = 0; i7 < size; i7++) {
                    TbRichTextData tbRichTextData = tbRichText.B().get(i7);
                    if ((tbRichTextData == null || tbRichTextData.getType() != 20) && tbRichTextData != null && tbRichTextData.getType() == 8) {
                        i6++;
                        int i8 = (int) yi.i(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * i8;
                        int height = tbRichTextData.F().getHeight() * i8;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.F().H()) {
                            if (tbRichTextData.getType() != 20) {
                                String a2 = px7.a(tbRichTextData);
                                if (!TextUtils.isEmpty(a2)) {
                                    arrayList.add(a2);
                                    if (tbRichTextData != null && (F = tbRichTextData.F()) != null) {
                                        String B = F.B();
                                        ImageUrlData imageUrlData = new ImageUrlData();
                                        if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                                            imageUrlData.urlType = 38;
                                            B = F.C();
                                        } else {
                                            if (this.f) {
                                                i4 = 17;
                                            } else {
                                                i4 = 18;
                                            }
                                            imageUrlData.urlType = i4;
                                        }
                                        imageUrlData.imageUrl = B;
                                        imageUrlData.originalUrl = b2(tbRichTextData);
                                        imageUrlData.originalSize = c2(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = Z1(tbRichTextData);
                                        imageUrlData.isLongPic = Y1(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = xg.g(this.a.m2(), -1L);
                                        imageUrlData.mIsReserver = this.a.d2();
                                        imageUrlData.mIsSeeHost = this.a.v1();
                                        if (concurrentHashMap != null) {
                                            concurrentHashMap.put(a2, imageUrlData);
                                        }
                                    }
                                }
                                if (!this.H) {
                                    i5++;
                                }
                            }
                        } else if (tbRichText == tbRichText2) {
                            if (i6 <= i3) {
                                i5--;
                            }
                        }
                    }
                }
                return i5;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public void h2(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920ee) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ee);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920f0) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920f0);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920ef) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ef);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f0920eb) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920eb);
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920ec) instanceof String) {
                str6 = (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ec);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.k);
            userMuteAddAndDelCustomMessage.setTag(this.k);
            F2(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048642, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.q.C(i2, i3, intent);
            if (this.c.y() != null) {
                this.c.y().g(i2, i3, intent);
            }
            if (i2 == 25035) {
                g2(i3, intent);
            }
            if (i3 == -1) {
                if (i2 != 13008) {
                    if (i2 != 13011) {
                        if (i2 == 24007) {
                            int intExtra = intent.getIntExtra("extra_show_channel", 1);
                            if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                jf8.g().m(getPageContext());
                                K2();
                                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                                ShareSuccessReplyToServerModel shareSuccessReplyToServerModel = this.v;
                                if (shareSuccessReplyToServerModel != null && shareItem != null && (str = shareItem.x) != null) {
                                    shareSuccessReplyToServerModel.z(str, intExtra, new i(this));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    jf8.g().m(getPageContext());
                    return;
                }
                h18.b().m();
                this.mHandler.postDelayed(new h(this), 1000L);
            }
        }
    }

    public final void i2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null && this.a.S1().l0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.m2(), str);
                ThreadData Q = this.a.S1().Q();
                if (Q.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (Q.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (Q.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                p2(format);
                return;
            }
            this.b.a(str);
        }
    }

    public final boolean o2(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048641, this, z)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null) {
                if (this.a.S1().Y() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || this.a.S1().Q() == null || this.a.S1().Q().getAuthor() == null || TextUtils.equals(this.a.S1().Q().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void u2(PostData postData) {
        kp4 kp4Var;
        PostData V1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048657, this, postData) != null) || postData == null) {
            return;
        }
        boolean z = false;
        if (postData.M() != null && postData.M().equals(this.a.N1())) {
            z = true;
        }
        MarkData M1 = this.a.M1(postData);
        if (this.a.S1() != null && this.a.S1().l0() && (V1 = V1()) != null) {
            M1 = this.a.M1(V1);
        }
        if (M1 != null && (kp4Var = this.A) != null) {
            kp4Var.i(M1);
            if (!z) {
                this.A.a();
            } else {
                this.A.d();
            }
        }
    }

    public final void l2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            this.d = new w28(this);
            this.e = new y28(getPageContext());
            nz7 nz7Var = new nz7(this, this.V, this.G, this.I, this.J);
            this.c = nz7Var;
            nz7Var.Y(this.a);
            setContentView(this.c.A(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.c.s();
            this.c.V(new t(this));
            o85 o85Var = new o85();
            this.p = o85Var;
            B2(o85Var);
            m85 m85Var = (m85) this.p.a(getActivity());
            this.q = m85Var;
            m85Var.W(getPageContext());
            this.q.g0(this.S);
            this.q.Y(1);
            this.q.A(getPageContext(), bundle);
            this.q.b().b(new u65(getActivity()));
            this.q.b().C(true);
            C2(true);
            this.q.J(this.a.u1(), this.a.m2(), this.a.q1());
            this.c.T(this.q.b());
            this.s = new v18();
            if (this.q.s() != null) {
                this.s.m(this.q.s().i());
            }
            registerListener(this.T);
            if (!this.a.F1()) {
                this.q.q(this.a.m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (this.a.A2()) {
                this.q.c0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e37));
            } else {
                nz7 nz7Var2 = this.c;
                if (nz7Var2 != null) {
                    this.q.c0(nz7Var2.z());
                }
            }
            this.v = new ShareSuccessReplyToServerModel();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bundle) == null) {
            k2(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.t = voiceManager;
            voiceManager.onCreate(getPageContext());
            j2(bundle);
            l2(bundle);
            q2();
            if (this.r) {
                this.c.A().setAnimTime(0);
                this.c.A().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.r) {
                this.C = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.c.A().h();
            this.c.x().setFromForumId(this.a.getFromForumId());
            v38 v38Var = new v38(this);
            this.b = v38Var;
            v38Var.b(getUniqueId());
            this.o = new mw8(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.u = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new s(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.c0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.q.c0(this.c.z());
            }
            n45.b(false);
        }
    }

    public final AbsPbActivity.e y2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, str)) == null) {
            String str2 = null;
            if (this.a.S1() != null && this.a.S1().H() != null && this.a.S1().H().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 < this.a.S1().H().size()) {
                        if (str.equals(this.a.S1().H().get(i2).M())) {
                            break;
                        }
                        i2++;
                    } else {
                        i2 = 0;
                        break;
                    }
                }
                PostData postData = this.a.S1().H().get(i2);
                if (postData.X() != null && postData.X().B() != null) {
                    Iterator<TbRichTextData> it = postData.X().B().iterator();
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
                    w2(str2, 0, eVar);
                    px7.b(postData, eVar);
                    return eVar;
                }
            }
            return null;
        }
        return (AbsPbActivity.e) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void p0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048649, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (xm5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), xm5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (y18.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new pk5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void r2(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048652, this, view2, str, str2, postData) != null) || view2 == null || str == null || str2 == null || !L1()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.w);
            this.x = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.c.y() != null && postData != null) {
            if (postData.X() != null) {
                str3 = postData.X().toString();
            } else {
                str3 = "";
            }
            this.c.y().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1040), postData.s().getName_show(), str3));
        }
        if (this.a.S1() != null && this.a.S1().l0()) {
            ah.a().postDelayed(new l(this, str, str2), 0L);
            return;
        }
        if (this.z == null) {
            zs6 zs6Var = new zs6(getPageContext());
            this.z = zs6Var;
            zs6Var.j(1);
            this.z.i(new m(this, str, str2));
        }
        PbModel pbModel = this.a;
        if (pbModel != null && pbModel.S1() != null && this.a.S1().l() != null) {
            this.z.g(this.a.S1().l().getId(), xg.g(this.a.m2(), 0L));
        }
    }

    public final void v2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048658, this, i2, str) == null) {
            if (this.a.t2()) {
                showToast(str);
            } else if (yi.F()) {
                if (i2 == 4) {
                    nz7 nz7Var = this.c;
                    nz7Var.g0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
                } else if (!TextUtils.isEmpty(str)) {
                    nz7 nz7Var2 = this.c;
                    nz7Var2.g0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
                } else {
                    this.c.f0(R.string.obfuscated_res_0x7f0f0c9d);
                }
            } else {
                this.c.f0(R.string.obfuscated_res_0x7f0f0fff);
            }
        }
    }

    public final void w2(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048661, this, str, i2, eVar) != null) || eVar == null) {
            return;
        }
        ox7 S1 = this.a.S1();
        TbRichText L2 = L2(str, i2);
        if (L2 == null || (tbRichTextData = L2.B().get(this.F)) == null) {
            return;
        }
        eVar.f = String.valueOf(L2.getPostId());
        eVar.a = new ArrayList<>();
        eVar.b = new ConcurrentHashMap<>();
        boolean z = false;
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a2 = px7.a(tbRichTextData);
            eVar.a.add(a2);
            ImageUrlData imageUrlData = new ImageUrlData();
            imageUrlData.imageUrl = str;
            if (TbadkCoreApplication.getInst().isGifAutoPlay()) {
                imageUrlData.urlType = 38;
            } else {
                if (this.f) {
                    i4 = 17;
                } else {
                    i4 = 18;
                }
                imageUrlData.urlType = i4;
            }
            imageUrlData.originalUrl = b2(tbRichTextData);
            imageUrlData.originalUrl = b2(tbRichTextData);
            imageUrlData.originalSize = c2(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = Z1(tbRichTextData);
            imageUrlData.isLongPic = Y1(tbRichTextData);
            imageUrlData.postId = L2.getPostId();
            imageUrlData.mIsReserver = this.a.d2();
            imageUrlData.mIsSeeHost = this.a.v1();
            eVar.b.put(a2, imageUrlData);
            if (S1 != null) {
                if (S1.l() != null) {
                    eVar.c = S1.l().getName();
                    eVar.d = S1.l().getId();
                }
                if (S1.Q() != null) {
                    eVar.e = S1.Q().getId();
                }
                if (S1.s() == 1) {
                    z = true;
                }
                eVar.g = z;
            }
            imageUrlData.threadId = xg.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = S1.H().size();
        this.H = false;
        eVar.j = -1;
        if (S1.j() != null) {
            i3 = X1(S1.j().X(), L2, i2, i2, eVar.a, eVar.b);
        } else {
            i3 = i2;
        }
        int i5 = i3;
        for (int i6 = 0; i6 < size; i6++) {
            PostData postData = S1.H().get(i6);
            if (postData.M() == null || S1.j() == null || S1.j().M() == null || !postData.M().equals(S1.j().M())) {
                i5 = X1(postData.X(), L2, i5, i2, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList<String> arrayList = eVar.a;
            eVar.i = arrayList.get(arrayList.size() - 1);
        }
        if (S1 != null) {
            if (S1.l() != null) {
                eVar.c = S1.l().getName();
                eVar.d = S1.l().getId();
            }
            if (S1.Q() != null) {
                eVar.e = S1.Q().getId();
            }
            if (S1.s() == 1) {
                z = true;
            }
            eVar.g = z;
        }
        eVar.j = i5;
    }
}
