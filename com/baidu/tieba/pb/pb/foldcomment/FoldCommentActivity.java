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
import android.widget.ListView;
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
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
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
import com.baidu.tieba.R;
import com.baidu.tieba.a28;
import com.baidu.tieba.av4;
import com.baidu.tieba.b08;
import com.baidu.tieba.b18;
import com.baidu.tieba.d08;
import com.baidu.tieba.d18;
import com.baidu.tieba.e08;
import com.baidu.tieba.e25;
import com.baidu.tieba.eh;
import com.baidu.tieba.ej;
import com.baidu.tieba.er6;
import com.baidu.tieba.fj;
import com.baidu.tieba.gr4;
import com.baidu.tieba.hh;
import com.baidu.tieba.hj5;
import com.baidu.tieba.hn8;
import com.baidu.tieba.hx7;
import com.baidu.tieba.jq4;
import com.baidu.tieba.k75;
import com.baidu.tieba.kw7;
import com.baidu.tieba.l35;
import com.baidu.tieba.l55;
import com.baidu.tieba.l75;
import com.baidu.tieba.m85;
import com.baidu.tieba.n75;
import com.baidu.tieba.nz7;
import com.baidu.tieba.od8;
import com.baidu.tieba.p75;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pl5;
import com.baidu.tieba.pn;
import com.baidu.tieba.pu4;
import com.baidu.tieba.q35;
import com.baidu.tieba.q9;
import com.baidu.tieba.qx4;
import com.baidu.tieba.r18;
import com.baidu.tieba.r35;
import com.baidu.tieba.r75;
import com.baidu.tieba.ro4;
import com.baidu.tieba.ru8;
import com.baidu.tieba.ry7;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sl5;
import com.baidu.tieba.su8;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tc5;
import com.baidu.tieba.tx7;
import com.baidu.tieba.u28;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.uv7;
import com.baidu.tieba.v55;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.vv7;
import com.baidu.tieba.w55;
import com.baidu.tieba.wg;
import com.baidu.tieba.wu4;
import com.baidu.tieba.ww7;
import com.baidu.tieba.x55;
import com.baidu.tieba.yc5;
import com.baidu.tieba.yu4;
import com.baidu.tieba.yz7;
import com.baidu.tieba.zu4;
import com.baidu.tieba.zw7;
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
public class FoldCommentActivity extends BaseFragmentActivity implements VoiceManager.j, hx7, TbRichTextView.s, pu4.e, sl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ro4 A;
    public vg B;
    public BdUniqueId C;
    public PbModel.h D;
    public View E;
    public int F;
    public final TbRichTextView.y G;
    public boolean H;
    public ww7 I;
    public final View.OnLongClickListener J;
    public d08 K;
    public pn L;
    public String M;
    public TbRichTextMemeInfo N;
    public PostData O;
    public av4.e P;
    public Object Q;
    public final q9 R;
    public l75 S;
    public CustomMessageListener T;
    public NewWriteModel.d U;
    public View.OnClickListener V;
    public k75 W;
    public final ro4.a X;
    public PbModel a;
    public a28 b;
    public tx7 c;
    public b18 d;
    public d18 e;
    public boolean f;
    public boolean g;
    public yu4 h;
    public av4 i;
    public PermissionJudgePolicy j;
    public BdUniqueId k;
    public qx4 l;
    public hn8 m;
    public ForumManageModel n;
    public su8 o;
    public p75 p;
    public n75 q;
    public boolean r;
    public b08 s;
    public VoiceManager t;
    public ReplyPrivacyCheckController u;
    public ShareSuccessReplyToServerModel v;
    public int[] w;
    public int x;
    public er6 y;
    public er6 z;

    @Override // com.baidu.tieba.sl5
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.sl5
    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.sl5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.sl5
    public vg L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (vg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (vg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.sl5
    public void R(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048606, this, context, str, z) == null) {
        }
    }

    @Override // com.baidu.tieba.sl5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tieba.sl5
    public vg X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (vg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i d1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return null;
        }
        return (vg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public void f1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.sl5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public boolean m2(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, view2)) == null) {
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

    @Override // com.baidu.tieba.sl5
    public vg w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return null;
        }
        return (vg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return null;
        }
        return (vg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return null;
        }
        return (vg) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class m implements er6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FoldCommentActivity c;

        @Override // com.baidu.tieba.er6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.er6.d
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
            public class C0365a implements TextWatcher {
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

                public C0365a(a aVar) {
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
                    b08 b08Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (b08Var = this.a.a.c.s) != null && b08Var.g() != null) {
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
                int f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = fj.i(this.a.c.getApplicationContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    } else {
                        i = i2 / 2;
                        f = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds410);
                    }
                    int i3 = i2 - (i + f);
                    FoldCommentActivity foldCommentActivity = this.a.c;
                    boolean z = true;
                    foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.w[1] + foldCommentActivity.x) - i3, 50);
                    if (this.a.c.c.y() != null) {
                        this.a.c.q.b().setVisibility(8);
                        z = (this.a.c.a == null || this.a.c.a.S1() == null || this.a.c.a.S1().P() == null || !this.a.c.a.S1().P().isBjh()) ? false : false;
                        ry7 y = this.a.c.c.y();
                        m mVar = this.a;
                        y.o(mVar.a, mVar.b, mVar.c.c.z(), z);
                        r75 b = this.a.c.c.y().b();
                        if (b != null && this.a.c.a != null && this.a.c.a.S1() != null) {
                            b.H(this.a.c.a.S1().d());
                            b.d0(this.a.c.a.S1().P());
                        }
                        if (this.a.c.s.f() == null && this.a.c.c.y().b().u() != null) {
                            this.a.c.c.y().b().u().g(new C0365a(this));
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

        @Override // com.baidu.tieba.er6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                return;
            }
            hh.a().postDelayed(new a(this), 0L);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        /* loaded from: classes5.dex */
        public class a implements pu4.e {
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

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements pu4.e {
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

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, e25 e25Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, e25Var, writeData, antiData}) == null) {
                if (!ej.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
                    b08 b08Var = this.a.s;
                    if (b08Var != null) {
                        b08Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        r35.c(this.a.getPageContext(), postWriteCallBackData, 2);
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
                    if (ej.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0488), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    pu4 pu4Var = new pu4(this.a.getActivity());
                    if (ej.isEmpty(postWriteCallBackData.getErrorString())) {
                        pu4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d22));
                    } else {
                        pu4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new a(this));
                    pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d24, new b(this));
                    pu4Var.create(this.a.getPageContext()).show();
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
                    zw7.a(this.b.a.getPageContext(), this.a).show();
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
                hh.a().postDelayed(new a(this, customDialogData), 1000L);
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
                b08 b08Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (b08Var = this.a.c.s) != null && b08Var.g() != null) {
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
            int f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = fj.i(this.c.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = fj.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = fj.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                FoldCommentActivity foldCommentActivity = this.c;
                boolean z = true;
                foldCommentActivity.c.w().smoothScrollBy((foldCommentActivity.w[1] + foldCommentActivity.x) - i3, 50);
                if (this.c.c.y() != null) {
                    this.c.q.b().setVisibility(8);
                    this.c.c.y().o(this.a, this.b, this.c.c.z(), (this.c.a == null || this.c.a.S1() == null || this.c.a.S1().P() == null || !this.c.a.S1().P().isBjh()) ? false : false);
                    r75 b = this.c.c.y().b();
                    if (b != null && this.c.a != null && this.c.a.S1() != null) {
                        b.H(this.c.a.S1().d());
                        b.d0(this.c.a.S1().P());
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
                    this.a.S1(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                    return;
                }
                this.a.c.v(this.a.n.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) && pu4Var != null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.b.c.d0();
                MessageManager.getInstance().sendMessage(this.a);
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements l75 {
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

        @Override // com.baidu.tieba.l75
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
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
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f09203c);
                    if (obj instanceof PostData) {
                        PostData postData = (PostData) obj;
                        if (this.a.a == null || this.a.a.S1() == null || postData.s() == null || postData.D() == 1 || !this.a.checkUpIsLogin()) {
                            return;
                        }
                        if (this.a.c.y() != null) {
                            this.a.c.y().c();
                        }
                        kw7 kw7Var = new kw7();
                        kw7Var.A(this.a.a.S1().l());
                        kw7Var.E(this.a.a.S1().P());
                        kw7Var.C(postData);
                        this.a.c.x().V(kw7Var);
                        this.a.c.x().setPostId(postData.M());
                        this.a.q2(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        u28.b(this.a.a.S1(), postData, postData.c0, 8, 1);
                        if (this.a.q != null) {
                            this.a.c.W(this.a.q.y());
                        }
                    }
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f091801 && view2.getId() != R.id.obfuscated_res_0x7f091859) {
                if (view2.getId() != R.id.obfuscated_res_0x7f091f9e && view2.getId() != R.id.obfuscated_res_0x7f091f9c && view2.getId() != R.id.obfuscated_res_0x7f0917ff && view2.getId() != R.id.obfuscated_res_0x7f091690) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f09185f && view2.getId() != R.id.obfuscated_res_0x7f091a3f && view2.getId() != R.id.obfuscated_res_0x7f0917f9) {
                        if ((view2.getId() == R.id.obfuscated_res_0x7f09078f || view2.getId() == R.id.obfuscated_res_0x7f090a16) && (sparseArray = (SparseArray) view2.getTag()) != null && (sparseArray.get(R.id.obfuscated_res_0x7f092059) instanceof PostData)) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092059);
                            View view3 = (View) sparseArray.get(R.id.obfuscated_res_0x7f09205b);
                            if (postData2 == null || view3 == null) {
                                return;
                            }
                            ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090790);
                            EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090791);
                            View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a16);
                            if (postData2.r0()) {
                                postData2.R0(false);
                            } else {
                                postData2.R0(true);
                            }
                            SkinManager.setBackgroundColor(findViewById, postData2.r0() ? R.color.CAM_X0201 : R.color.transparent);
                            SkinManager.setViewTextColor(eMTextView, postData2.r0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                            WebPManager.setPureDrawable(imageView, postData2.r0() ? R.drawable.obfuscated_res_0x7f080984 : R.drawable.obfuscated_res_0x7f080983, postData2.r0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                            return;
                        }
                        return;
                    } else if (this.a.a == null) {
                        return;
                    } else {
                        if (view2.getId() == R.id.obfuscated_res_0x7f09185f) {
                            StatisticItem statisticItem3 = new StatisticItem("c13398");
                            statisticItem3.param("tid", this.a.a.m2());
                            statisticItem3.param("fid", this.a.a.getForumId());
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("obj_locate", 6);
                            TiebaStatic.log(statisticItem3);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f091a3f) {
                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                return;
                            }
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09185f && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                            return;
                        }
                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray2 = (SparseArray) view2.getTag();
                            if (sparseArray2.get(R.id.obfuscated_res_0x7f092059) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f092059);
                                if (view2.getId() == R.id.obfuscated_res_0x7f09185f && (statisticItem = postData3.d0) != null) {
                                    StatisticItem copy = statisticItem.copy();
                                    copy.delete("obj_locate");
                                    copy.param("obj_locate", 8);
                                    TiebaStatic.log(copy);
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091a3f || view2.getId() == R.id.obfuscated_res_0x7f0917f9) {
                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.a.n2()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData3.M()).param("obj_source", 1).param("obj_type", 3));
                                }
                                if (this.a.a == null || this.a.a.S1() == null || postData3.s() == null || postData3.D() == 1) {
                                    return;
                                }
                                if (this.a.c.y() != null) {
                                    this.a.c.y().c();
                                }
                                kw7 kw7Var2 = new kw7();
                                kw7Var2.A(this.a.a.S1().l());
                                kw7Var2.E(this.a.a.S1().P());
                                kw7Var2.C(postData3);
                                this.a.c.x().V(kw7Var2);
                                this.a.c.x().setPostId(postData3.M());
                                this.a.q2(view2, postData3.s().getUserId(), "", postData3);
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
                if (view2.getId() == R.id.obfuscated_res_0x7f091690) {
                    StatisticItem statisticItem4 = new StatisticItem("c13398");
                    statisticItem4.param("tid", this.a.a.m2());
                    statisticItem4.param("fid", this.a.a.getForumId());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("obj_locate", 4);
                    TiebaStatic.log(statisticItem4);
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f0917ff || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                    if (!this.a.checkUpIsLogin()) {
                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.a.S1().m()));
                    } else if (this.a.a == null || this.a.a.S1() == null) {
                    } else {
                        this.a.c.u();
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        PostData postData4 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f092059);
                        PostData postData5 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f09205a);
                        View view4 = (View) sparseArray3.get(R.id.obfuscated_res_0x7f09205b);
                        if (postData4 == null || view4 == null) {
                            return;
                        }
                        if (postData4.H() == 1) {
                            TiebaStatic.log(new StatisticItem("c12630"));
                        }
                        StatisticItem statisticItem5 = postData4.d0;
                        if (statisticItem5 != null) {
                            StatisticItem copy2 = statisticItem5.copy();
                            copy2.delete("obj_locate");
                            if (view2.getId() == R.id.obfuscated_res_0x7f091690) {
                                copy2.param("obj_locate", 6);
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0917ff) {
                                copy2.param("obj_locate", 8);
                            }
                            TiebaStatic.log(copy2);
                        }
                        if (view2.getId() == R.id.obfuscated_res_0x7f0917ff && this.a.a != null && this.a.a.S1() != null && postData4 != null) {
                            TiebaStatic.log(new StatisticItem("c14443").param("tid", this.a.a.m2()).param("fname", this.a.a.S1().n()).param("fid", this.a.a.getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData4.M()));
                        }
                        String m2 = this.a.a.m2();
                        String M = postData4.M();
                        String M2 = postData5 != null ? postData5.M() : "";
                        int X = this.a.a.S1() != null ? this.a.a.S1().X() : 0;
                        this.a.x();
                        if (view2.getId() != R.id.obfuscated_res_0x7f091bfc) {
                            if (view2.getId() != R.id.obfuscated_res_0x7f0917ff || !this.a.r) {
                                TiebaStatic.log("c11742");
                                AbsPbActivity.e x2 = this.a.x2(M);
                                if (postData4 == null || this.a.a == null || this.a.a.S1() == null || x2 == null) {
                                    return;
                                }
                                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, M, "pb", true, this.a.r, null, false, M2, X, postData4.d0(), this.a.a.S1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(x2.a, x2.b, x2.g, x2.j);
                                if (!ej.isEmpty(M2)) {
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
                            AbsPbActivity.e x22 = this.a.x2(M);
                            if (this.a.a == null || this.a.a.S1() == null || x22 == null) {
                                return;
                            }
                            SubPbActivityConfig addBigImageData2 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, M, "pb", true, this.a.r, null, true, null, X, postData4.d0(), this.a.a.S1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(x22.a, x22.b, x22.g, x22.j);
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
                        AbsPbActivity.e x23 = this.a.x2(M);
                        if (this.a.a == null || this.a.a.S1() == null || x23 == null) {
                            return;
                        }
                        SubPbActivityConfig addBigImageData3 = new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(m2, M, "pb", true, this.a.r, null, true, null, X, postData4.d0(), this.a.a.S1().d(), false, postData4.s().getIconInfo(), 5).addBigImageData(x23.a, x23.b, x23.g, x23.j);
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
                foldCommentActivity.O1(view2);
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
        public void a(int i, boolean z, ResponsedMessage responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(uv7 uv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uv7Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, uv7 uv7Var, String str, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), uv7Var, str, Integer.valueOf(i4)}) != null) || this.a.c == null) {
                return;
            }
            this.a.c.U();
            if (z) {
                this.a.c.E();
                if (uv7Var != null) {
                    if (uv7Var.s() == 1) {
                        this.a.f = true;
                    } else {
                        this.a.f = false;
                    }
                    String str2 = null;
                    if (this.a.a != null && this.a.a.A2()) {
                        str2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e1b);
                    } else if (this.a.c != null) {
                        str2 = this.a.c.z();
                    }
                    if (!StringUtils.isNull(str2)) {
                        this.a.q.c0(TbSingleton.getInstance().getAdVertiComment(uv7Var.q0(), uv7Var.r0(), str2));
                    }
                    this.a.c.S(uv7Var, this.a.f);
                    return;
                }
                return;
            }
            this.a.u2(i, str);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements k75 {
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

        @Override // com.baidu.tieba.k75
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b08 b08Var = this.a.s;
                if (b08Var != null && b08Var.g() != null && this.a.s.g().d()) {
                    FoldCommentActivity foldCommentActivity = this.a;
                    foldCommentActivity.showToast(foldCommentActivity.s.g().c());
                    if (this.a.c != null && this.a.c.y() != null && this.a.c.y().b() != null && this.a.c.y().b().y()) {
                        this.a.c.y().b().w(this.a.s.h());
                    }
                    this.a.s.b(true);
                    return true;
                } else if (!this.a.L1(ReplyPrivacyCheckController.TYPE_FLOOR)) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements er6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tieba.er6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.er6.d
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

        @Override // com.baidu.tieba.er6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.q != null && this.a.q.b() != null) {
                    this.a.q.b().A(new l55(45, 27, null));
                }
                this.a.c.t();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements ro4.a {
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

        @Override // com.baidu.tieba.ro4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.A != null) {
                        this.a.A.h(z2);
                    }
                    this.a.a.H3(z2);
                    if (this.a.a.D1()) {
                        this.a.r2();
                    }
                    if (z2) {
                        if (this.a.A != null) {
                            if (this.a.A.f() != null && this.a.a != null && this.a.a.S1() != null && this.a.a.S1().P() != null && this.a.a.S1().P().getAuthor() != null) {
                                MarkData f = this.a.A.f();
                                MetaData author = this.a.a.S1().P().getAuthor();
                                if (f != null && author != null) {
                                    if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) || author.hadConcerned()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d3);
                                        if (l35.g(this.a.getActivity(), 0)) {
                                            l35.i(this.a.getPageContext(), 6, 2000L);
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
                        this.a.G1();
                        return;
                    }
                    FoldCommentActivity foldCommentActivity2 = this.a;
                    foldCommentActivity2.showToast(foldCommentActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f1004));
                    return;
                }
                FoldCommentActivity foldCommentActivity3 = this.a;
                foldCommentActivity3.showToast(foldCommentActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14ff));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements wg {
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

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object a(Object obj) {
            ImageView imageView = (ImageView) obj;
            e(imageView);
            return imageView;
        }

        @Override // com.baidu.tieba.wg
        public /* bridge */ /* synthetic */ Object c(Object obj) {
            ImageView imageView = (ImageView) obj;
            h(imageView);
            return imageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
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
                    foreDrawableImageView.P();
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
                    if (jq4.c().g()) {
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
                    foreDrawableImageView.P();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = jq4.c().g();
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

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view2, String str, int i, boolean z, boolean z2) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view2.getTag(R.id.obfuscated_res_0x7f092078) != null && (view2.getTag(R.id.obfuscated_res_0x7f092078) instanceof TbRichTextMemeInfo) && (view2 instanceof TbImageView)) {
                        TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f092078);
                        boolean x = ((TbImageView) view2).x();
                        if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                            this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, x)));
                        }
                        this.a.E = view2;
                        return;
                    }
                    AbsPbActivity.e eVar = new AbsPbActivity.e();
                    this.a.v2(str, i, eVar);
                    if (this.a.a.S1().k0()) {
                        ArrayList arrayList = new ArrayList();
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
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
                        builder.J(this.a.l2());
                        if (this.a.a != null) {
                            builder.D(this.a.a.getFromForumId());
                            if (this.a.a.S1() != null) {
                                builder.Q(this.a.a.S1().P());
                            }
                        }
                        ImageViewerConfig x2 = builder.x(this.a.getPageContext().getPageActivity());
                        x2.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x2));
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
                        builder2.M((String) eVar.a.get(0));
                        builder2.I(this.a.a.d2());
                        builder2.y(concurrentHashMap2);
                        builder2.N(false);
                        builder2.J(this.a.l2());
                        builder2.z(eVar.f);
                        builder2.O(eVar.f);
                        builder2.G(false);
                        if (this.a.a != null) {
                            builder2.D(this.a.a.getFromForumId());
                            if (this.a.a.S1() != null) {
                                builder2.Q(this.a.a.S1().P());
                            }
                        }
                        ImageViewerConfig x3 = builder2.x(this.a.getPageContext().getPageActivity());
                        x3.getIntent().putExtra("from", "pb");
                        this.a.sendMessage(new CustomMessage(2010000, x3));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004016, Boolean.FALSE));
                    } else {
                        TbRichText K2 = this.a.K2(str, i);
                        if (K2 != null && this.a.F >= 0 && this.a.F < K2.B().size()) {
                            ArrayList arrayList3 = new ArrayList();
                            String a = vv7.a(K2.B().get(this.a.F));
                            int i6 = 0;
                            while (true) {
                                if (i6 >= eVar.a.size()) {
                                    break;
                                } else if (((String) eVar.a.get(i6)).equals(a)) {
                                    eVar.j = i6;
                                    arrayList3.add(a);
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                            ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                            if (!ListUtils.isEmpty(arrayList3)) {
                                String str3 = (String) arrayList3.get(0);
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
                            builder3.J(this.a.l2());
                            builder3.O(eVar.f);
                            builder3.z(eVar.f);
                            if (this.a.a != null) {
                                builder3.D(this.a.a.getFromForumId());
                                if (this.a.a.S1() != null) {
                                    builder3.Q(this.a.a.S1().P());
                                }
                            }
                            ImageViewerConfig x4 = builder3.x(this.a.getPageContext().getPageActivity());
                            x4.getIntent().putExtra("from", "pb");
                            this.a.sendMessage(new CustomMessage(2010000, x4));
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
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(this.a.a.S1().W().getUserId());
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
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.a.S1().l().getId(), this.a.a.S1().l().getName(), this.a.a.S1().P().getId(), valueOf, str, str3, str2, str4)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements ww7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FoldCommentActivity a;

        @Override // com.baidu.tieba.ww7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ww7.a
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

        @Override // com.baidu.tieba.ww7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (view2 != null) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f091c1a) {
                        if (this.a.z2(view2)) {
                            return true;
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0917fe) {
                        if (view2.getTag(R.id.obfuscated_res_0x7f09204f) instanceof SparseArray) {
                            this.a.F2((SparseArray) view2.getTag(R.id.obfuscated_res_0x7f09204f));
                        }
                    } else if ((view2 instanceof TbRichTextView) || view2.getId() == R.id.obfuscated_res_0x7f091858) {
                        SparseArray sparseArray = null;
                        if (view2.getTag() instanceof SparseArray) {
                            sparseArray = (SparseArray) view2.getTag();
                        }
                        if (sparseArray == null) {
                            return false;
                        }
                        this.a.F2(sparseArray);
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
            return this.a.O1(view2);
        }
    }

    /* loaded from: classes5.dex */
    public class w implements av4.e {
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

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                if (this.a.h != null) {
                    this.a.h.dismiss();
                }
                this.a.I2(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917e0);
                        this.a.y2(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917df);
                        this.a.y2(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917e2);
                        if (view5 != null) {
                            AgreeView agreeView = (AgreeView) view5;
                            this.a.y2(view5);
                            if (agreeView.getImgDisagree() != null) {
                                agreeView.getImgDisagree().performClick();
                                return;
                            }
                            return;
                        }
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0917e2);
                        if (view6 == null) {
                            return;
                        }
                        this.a.y2(view6);
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
                                m85.a aVar = new m85.a();
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
                                foldCommentActivity.K = new d08(foldCommentActivity.getPageContext());
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
                            postData.D0();
                            this.a.O = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (!this.a.checkUpIsLogin()) {
                            return;
                        }
                        this.a.s2(view2);
                        if (this.a.a.S1().P() != null && this.a.a.S1().P().getAuthor() != null && this.a.a.S1().P().getAuthor().getUserId() != null && this.a.A != null) {
                            FoldCommentActivity foldCommentActivity2 = this.a;
                            int e2 = foldCommentActivity2.e2(foldCommentActivity2.a.S1());
                            ThreadData P = this.a.a.S1().P();
                            if (P.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (P.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!P.isBJHNormalThreadType()) {
                                if (P.isBJHVideoDynamicThreadType()) {
                                    i2 = 5;
                                } else {
                                    i2 = 1;
                                }
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.m2()).param("obj_locate", 2).param("obj_id", this.a.a.S1().P().getAuthor().getUserId()).param("obj_type", !this.a.A.e()).param("obj_source", e2).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                            return;
                        }
                        Object tag = view2.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.a.h2((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f092098)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f09204f, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f092038, 2);
                                this.a.J1(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f092040) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203e) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f09205c) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f09203f) instanceof Boolean) && (sparseArray3.get(R.id.obfuscated_res_0x7f092050) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f09203f)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f09205c)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f092050)).booleanValue();
                            boolean F = this.a.F(TbadkCoreApplication.getCurrentAccount());
                            if (F) {
                                if (booleanValue2) {
                                    this.a.c.N(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203e), intValue, booleanValue, null, F);
                                    return;
                                } else {
                                    this.a.D2(sparseArray3, intValue, booleanValue);
                                    return;
                                }
                            } else if (!booleanValue || booleanValue2) {
                                this.a.c.L(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f09203e), intValue, booleanValue);
                                return;
                            } else {
                                this.a.D2(sparseArray3, intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                            return;
                        }
                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092084)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
                        if (booleanValue3) {
                            if (booleanValue5) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f09204f, 1);
                                sparseArray4.put(R.id.obfuscated_res_0x7f092038, 2);
                                this.a.J1(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.obfuscated_res_0x7f092038, 2);
                            this.a.c.P(view2);
                            return;
                        } else if (booleanValue4) {
                            this.a.c.L(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f09203e), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    case 8:
                        if (!this.a.checkUpIsLogin() || (sparseArray = (SparseArray) view2.getTag()) == null) {
                            return;
                        }
                        PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c);
                        if (postData2.q() == null) {
                            return;
                        }
                        this.a.M1(postData2.q());
                        return;
                    case 9:
                        if (this.a.checkUpIsLogin() && this.a.a != null && this.a.a.S1() != null) {
                            this.a.C2(ru8.c(view2));
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                if (pu4Var != null) {
                    pu4Var.dismiss();
                }
                this.d.R1(((Integer) this.a.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f09203e), this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements pu4.e {
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

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
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
        this.I = new ww7(new u(this));
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

    public void w2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048660, this) != null) || !checkUpIsLogin() || (pbModel = this.a) == null || pbModel.S1() == null || this.a.S1().l() == null || I1()) {
            return;
        }
        if (this.a.S1().k0()) {
            this.c.t();
            return;
        }
        if (this.y == null) {
            er6 er6Var = new er6(getPageContext());
            this.y = er6Var;
            er6Var.j(0);
            this.y.i(new o(this));
        }
        this.y.g(this.a.S1().l().getId(), eh.g(this.a.m2(), 0L));
    }

    public final void B2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.q.X(z);
            this.q.a0(z);
            this.q.i0(z);
        }
    }

    public void C2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && str != null && this.o != null) {
            this.o.n(eh.g(str, 0L));
        }
    }

    @Override // com.baidu.tieba.hx7
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

    public void H2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.C);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final boolean X1(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().I();
        }
        return invokeL.booleanValue;
    }

    public final boolean Y1(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return false;
            }
            return tbRichTextData.F().J();
        }
        return invokeL.booleanValue;
    }

    public final String a2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return null;
            }
            return tbRichTextData.F().D();
        }
        return (String) invokeL.objValue;
    }

    public final long b2(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, tbRichTextData)) == null) {
            if (tbRichTextData == null || tbRichTextData.F() == null) {
                return 0L;
            }
            return tbRichTextData.F().getOriginalSize();
        }
        return invokeL.longValue;
    }

    public final boolean j2(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, bundle)) == null) {
            if (bundle != null) {
                this.r = bundle.getBoolean("is_jump_from_video_tab", false);
            } else {
                this.r = getIntent().getBooleanExtra("is_jump_from_video_tab", false);
            }
            return this.r;
        }
        return invokeL.booleanValue;
    }

    public final void o2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    @Override // com.baidu.tieba.pu4.e
    public void onClick(pu4 pu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, pu4Var) == null) {
            Q1(pu4Var, null);
        }
    }

    public final void s2(View view2) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, view2) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c)) == null) {
                return;
            }
            t2(postData);
        }
    }

    public final void A2(p75 p75Var) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, p75Var) == null) && p75Var != null && (pbModel = this.a) != null) {
            p75Var.p(pbModel.r1());
            if (this.a.S1() != null && this.a.S1().l() != null) {
                p75Var.o(this.a.S1().l());
            }
            p75Var.q("pb");
            p75Var.r(this.a);
        }
    }

    public boolean L1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            if (this.u != null && this.a.S1() != null && !ThreadCardUtils.isSelf(this.a.S1().P()) && this.a.S1().d() != null) {
                return this.u.checkPrivacyBeforeSend(this.a.S1().d().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void i2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, bundle) == null) {
            this.k = getUniqueId();
            ro4 c2 = ro4.c(this);
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

    public final void D2(SparseArray sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            r18.e(getActivity(), getPageContext(), new x(this, sparseArray, i2, z), new y(this));
        }
    }

    public final void E2(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                this.c.d0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            pu4 pu4Var = new pu4(this);
            if (!ej.isEmpty(str)) {
                pu4Var.setMessage(str);
            } else {
                pu4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0323, str3));
            }
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f043d, new c(this, userMuteAddAndDelCustomMessage));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new d(this));
            pu4Var.create(getPageContext()).show();
        }
    }

    public final void F2(SparseArray sparseArray) {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, sparseArray) != null) || !checkUpIsLogin() || sparseArray == null || !(sparseArray.get(R.id.obfuscated_res_0x7f09203c) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c)) == null) {
            return;
        }
        G2(postData, false);
    }

    public final void I2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.m2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(r18.m(i2))));
        }
    }

    public void J1(SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = eh.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = eh.g((String) sparseArray.get(R.id.obfuscated_res_0x7f092094), 0L);
            BdUniqueId bdUniqueId = this.k;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.Q = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public final int e2(uv7 uv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, uv7Var)) == null) {
            if (uv7Var != null && uv7Var.P() != null) {
                if (uv7Var.P().getThreadType() == 0) {
                    return 1;
                }
                if (uv7Var.P().getThreadType() == 54) {
                    return 2;
                }
                if (uv7Var.P().getThreadType() == 40) {
                    return 3;
                }
                return 4;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void y2(View view2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048664, this, view2) != null) || view2 == null) {
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
        sparseArray.put(R.id.obfuscated_res_0x7f09187f, Integer.valueOf(i2));
        view2.setTag(sparseArray);
    }

    public final void G1() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (pbModel = this.a) != null && pbModel.S1() != null && this.a.S1().P() != null) {
            ThreadData P = this.a.S1().P();
            P.mRecomAbTag = this.a.X1();
            P.mRecomWeight = this.a.a2();
            P.mRecomSource = this.a.Z1();
            P.mRecomExtra = this.a.Y1();
            P.isSubPb = this.a.F1();
            if (P.getFid() == 0) {
                P.setFid(eh.g(this.a.getForumId(), 0L));
            }
            StatisticItem i2 = yc5.i(this, P, "c13562");
            TbPageTag l2 = yc5.l(this);
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

    public PostData U1() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null && this.a.S1().P() != null && this.a.S1().P().getAuthor() != null) {
                PostData postData = new PostData();
                MetaData author = this.a.S1().P().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = this.a.S1().P().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                postData.E0(1);
                postData.K0(this.a.S1().P().getFirstPostId());
                postData.b1(this.a.S1().P().getTitle());
                postData.a1(this.a.S1().P().getCreateTime());
                postData.C0(author);
                return postData;
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public final void G2(PostData postData, boolean z) {
        PbModel pbModel;
        int i2;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048586, this, postData, z) != null) || postData == null || (pbModel = this.a) == null || pbModel.S1() == null || postData.D() == 1) {
            return;
        }
        String m2 = this.a.m2();
        String M = postData.M();
        if (this.a.S1() != null) {
            i2 = this.a.S1().X();
        } else {
            i2 = 0;
        }
        AbsPbActivity.e x2 = x2(M);
        if (x2 == null) {
            return;
        }
        SubPbActivityConfig subPbActivityConfig = new SubPbActivityConfig(this);
        boolean z2 = this.r;
        SmallTailInfo d0 = postData.d0();
        AntiData d2 = this.a.S1().d();
        if (postData.s() != null) {
            arrayList = postData.s().getIconInfo();
        } else {
            arrayList = null;
        }
        SubPbActivityConfig addBigImageData = subPbActivityConfig.createSubPbActivityConfig(m2, M, "pb", true, z2, null, false, null, i2, d0, d2, false, arrayList, 5).addBigImageData(x2.a, x2.b, x2.g, x2.j);
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

    public void P1(SparseArray sparseArray, JSONArray jSONArray) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(yz7.k2)).intValue();
            if (intValue == yz7.l2) {
                if (this.n.S()) {
                    return;
                }
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205c)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092040)).intValue();
                if (sparseArray.get(R.id.obfuscated_res_0x7f092052) != null) {
                    z = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092052)).booleanValue();
                } else {
                    z = false;
                }
                if (jSONArray != null) {
                    this.n.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.n.V(this.a.S1().l().getId(), this.a.S1().l().getName(), this.a.S1().P().getId(), str, intValue3, intValue2, booleanValue, this.a.S1().P().getBaijiahaoData(), z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == yz7.m2 || intValue == yz7.o2) {
                if (this.a.n1() != null) {
                    this.a.n1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == yz7.m2) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void S1(ForumManageModel.b bVar, boolean z) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048608, this, bVar, z) != null) || bVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(bVar.b)) {
            string = bVar.b;
        } else {
            string = getString(R.string.obfuscated_res_0x7f0f04bd);
        }
        int i2 = 0;
        if (bVar.c == 1211066) {
            hideProgressBar();
            pu4 pu4Var = new pu4(getPageContext().getPageActivity());
            pu4Var.setMessage(string);
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04fb, new b(this));
            pu4Var.setCancelable(true);
            pu4Var.create(getPageContext());
            pu4Var.show();
        } else if (bVar.d != 0) {
            this.c.v(0, bVar.a, bVar.b, z);
        }
        if (bVar.a) {
            int i3 = bVar.d;
            if (i3 == 1) {
                ArrayList G = this.a.S1().G();
                int size = G.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.g.equals(((PostData) G.get(i2)).M())) {
                        G.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                this.a.S1().P().setReply_num(this.a.S1().P().getReply_num() - 1);
            } else if (i3 == 0) {
                N1();
            } else if (i3 == 2) {
                ArrayList G2 = this.a.S1().G();
                int size2 = G2.size();
                boolean z2 = false;
                for (int i4 = 0; i4 < size2 && !z2; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= ((PostData) G2.get(i4)).a0().size()) {
                            break;
                        } else if (bVar.g.equals(((PostData) G2.get(i4)).a0().get(i5).M())) {
                            ((PostData) G2.get(i4)).a0().remove(i5);
                            ((PostData) G2.get(i4)).k();
                            z2 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    ((PostData) G2.get(i4)).l(bVar.g);
                }
            }
        }
    }

    public final void f2(int i2, Intent intent) {
        x55 x55Var;
        x55 x55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048631, this, i2, intent) == null) {
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
                    r75 b2 = this.c.y().b();
                    b2.d0(this.a.S1().P());
                    b2.C(writeData);
                    b2.e0(pbEditorData.getVoiceModel());
                    w55 n2 = b2.b().n(6);
                    if (n2 != null && (x55Var2 = n2.m) != null) {
                        x55Var2.B(new l55(52, 0, pbEditorData.getVoiceModel()));
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
            w55 n3 = this.q.b().n(6);
            if (n3 != null && (x55Var = n3.m) != null) {
                x55Var.B(new l55(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.q.G(null, null);
            }
        }
    }

    public final void H1(uv7 uv7Var, ArrayList arrayList) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, uv7Var, arrayList) == null) && uv7Var != null && uv7Var.U() != null && uv7Var.U().a != null && (list = uv7Var.U().a) != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (list.size() > 0 && arrayList.size() > 0) {
                arrayList3.addAll(list);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    PostData postData = (PostData) it.next();
                    if (postData != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            PostData postData2 = (PostData) it2.next();
                            if (postData2 != null && !TextUtils.isEmpty(postData.M()) && !TextUtils.isEmpty(postData2.M()) && postData.M().equals(postData2.M())) {
                                arrayList2.add(postData2);
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

    public final boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel == null || pbModel.S1() == null) {
                return false;
            }
            ThreadData P = this.a.S1().P();
            AntiData d2 = this.a.S1().d();
            if (!AntiHelper.b(getPageContext(), P) && !AntiHelper.d(getPageContext(), d2)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && TbadkCoreApplication.isLogin() && AddExperiencedModel.E(this.a.getForumId()) && this.a.S1() != null && this.a.S1().l() != null) {
            boolean z = true;
            if (this.a.S1().l().isLike() != 1) {
                z = false;
            }
            if (z) {
                this.a.f1().D(this.a.getForumId(), this.a.m2());
            }
        }
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if ((this.a.S1() != null && (this.a.S1().k0() || ThreadCardUtils.isSelf(this.a.S1().P()))) || this.u == null || this.a.S1() == null || this.a.S1().d() == null) {
                return true;
            }
            return this.u.checkPrivacyBeforeInvokeEditor(this.a.S1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
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

    public final TbRichText K2(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, str, i2)) == null) {
            PbModel pbModel = this.a;
            TbRichText tbRichText = null;
            if (pbModel == null || pbModel.S1() == null || str == null || i2 < 0) {
                return null;
            }
            uv7 S1 = this.a.S1();
            if (S1.j() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(S1.j());
                tbRichText = V1(arrayList, str, i2);
            }
            if (tbRichText == null) {
                ArrayList G = S1.G();
                H1(S1, G);
                return V1(G, str, i2);
            }
            return tbRichText;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void Q1(pu4 pu4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, pu4Var, jSONArray) == null) {
            pu4Var.dismiss();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (!(pu4Var.getYesButtonTag() instanceof SparseArray)) {
                    return;
                }
                P1((SparseArray) pu4Var.getYesButtonTag(), jSONArray);
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void M1(AgreeData agreeData) {
        tc5 currentVisiblePageExtra;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, agreeData) != null) || agreeData == null) {
            return;
        }
        if (this.l == null) {
            this.l = new qx4();
        }
        if (this.m == null) {
            hn8 hn8Var = new hn8();
            this.m = hn8Var;
            hn8Var.a = getUniqueId();
        }
        gr4 gr4Var = new gr4();
        gr4Var.b = 5;
        gr4Var.h = 8;
        gr4Var.g = 2;
        PbModel pbModel2 = this.a;
        if (pbModel2 != null) {
            gr4Var.f = pbModel2.R1();
        }
        gr4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                gr4Var.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this);
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.l.c(agreeData, i2, getUniqueId(), false);
                this.l.d(agreeData, this.m);
                pbModel = this.a;
                if (pbModel == null && pbModel.S1() != null) {
                    this.l.b(this, gr4Var, agreeData, this.a.S1().P());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            gr4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            gr4Var.i = 1;
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

    public final boolean z2(View view2) {
        InterceptResult invokeL;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09203c);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (checkUpIsLogin() && (pbModel = this.a) != null && pbModel.S1() != null) {
                if (this.c.y() != null) {
                    this.c.y().c();
                }
                kw7 kw7Var = new kw7();
                kw7Var.A(this.a.S1().l());
                kw7Var.E(this.a.S1().P());
                kw7Var.C(postData);
                TiebaStatic.log("c11743");
                this.c.x().V(kw7Var);
                this.c.x().setPostId(postData.M());
                q2(view2, postData.s().getUserId(), "", postData);
                n75 n75Var = this.q;
                if (n75Var != null) {
                    this.c.W(n75Var.y());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.sl5
    public vg N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.B == null) {
                this.B = new vg(new q(this), 8, 0);
            }
            return this.B;
        }
        return (vg) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hx7
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null) {
                return this.a.S1().X();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public AntiData T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null) {
                return this.a.S1().d();
            }
            return null;
        }
        return (AntiData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hx7
    public String W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null) {
                return pbModel.r1();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public PbModel Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.a;
        }
        return (PbModel) invokeV.objValue;
    }

    public n75 c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.q;
        }
        return (n75) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            }
        }
    }

    public d18 d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.e;
        }
        return (d18) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (this.r) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
            } else {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            }
        }
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
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
                H2(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            super.onResume();
            if (this.r) {
                H2(true);
            }
        }
    }

    public final void p2() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && (pbModel = this.a) != null) {
            pbModel.T2();
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            uv7 S1 = this.a.S1();
            this.a.H3(true);
            ro4 ro4Var = this.A;
            if (ro4Var != null) {
                S1.K0(ro4Var.g());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.t;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hx7
    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && (voiceManager = this.t) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tieba.hx7
    public b18 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.d;
        }
        return (b18) invokeV.objValue;
    }

    public final boolean O1(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        ro4 ro4Var;
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
        List<? extends zu4> c2;
        int i2;
        boolean z12;
        wu4 wu4Var;
        wu4 wu4Var2;
        wu4 wu4Var3;
        pn pnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, view2)) == null) {
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return true;
            }
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09203c);
            this.O = postData;
            if (postData == null || (ro4Var = this.A) == null) {
                return true;
            }
            if (ro4Var.e() && this.O.M() != null) {
                this.O.M().equals(this.a.N1());
            }
            if (this.i == null) {
                av4 av4Var = new av4(this);
                this.i = av4Var;
                av4Var.n(this.P);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 != null && sparseArray != null) {
                boolean m2 = m2(view2);
                if (m2(view2) && (pnVar = this.L) != null && !pnVar.t()) {
                    z = true;
                } else {
                    z = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092055) instanceof Boolean) {
                    z2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092055)).booleanValue();
                } else {
                    z2 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f09203f) instanceof Boolean) {
                    z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue();
                } else {
                    z3 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) {
                    z4 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
                } else {
                    z4 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092084) instanceof Boolean) {
                    z5 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092084)).booleanValue();
                } else {
                    z5 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
                } else {
                    z6 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean) {
                    z7 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
                } else {
                    z7 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f09204c) instanceof String) {
                    str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09204c);
                } else {
                    str = null;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f092054) instanceof Boolean) {
                    z8 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092054)).booleanValue();
                } else {
                    z8 = false;
                }
                if (sparseArray.get(R.id.obfuscated_res_0x7f09205d) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205d)).booleanValue();
                } else {
                    z9 = false;
                }
                if (m2) {
                    z10 = z2;
                    z11 = z9;
                    arrayList.add(new wu4(1, getString(R.string.obfuscated_res_0x7f0f10c1), this.i));
                } else {
                    z10 = z2;
                    z11 = z9;
                }
                if (z) {
                    arrayList.add(new wu4(2, getString(R.string.obfuscated_res_0x7f0f10c2), this.i));
                }
                if (!m2 && !z) {
                    wu4 wu4Var4 = new wu4(3, getString(R.string.obfuscated_res_0x7f0f0459), this.i);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.obfuscated_res_0x7f09203c, this.O);
                    wu4Var4.d.setTag(sparseArray2);
                    arrayList.add(wu4Var4);
                }
                if (this.mIsLogin) {
                    if (!r18.i(this.a) && !z5 && z4) {
                        wu4 wu4Var5 = new wu4(5, getString(R.string.obfuscated_res_0x7f0f0b5c), this.i);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                        sparseArray3.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                        sparseArray3.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                        sparseArray3.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                        sparseArray3.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                        sparseArray3.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                        sparseArray3.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                        sparseArray3.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                        sparseArray3.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                        sparseArray3.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                        sparseArray3.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                        wu4Var5.d.setTag(sparseArray3);
                        arrayList.add(wu4Var5);
                    } else {
                        if (n2(z3) && TbadkCoreApplication.isLogin()) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            wu4 wu4Var6 = new wu4(5, getString(R.string.obfuscated_res_0x7f0f1029), this.i);
                            wu4Var6.d.setTag(str);
                            arrayList.add(wu4Var6);
                        }
                    }
                    if (z5) {
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.obfuscated_res_0x7f092084, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                        sparseArray4.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                        sparseArray4.put(R.id.obfuscated_res_0x7f09204c, str);
                        if (!r18.i(this.a) && z6) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                            sparseArray4.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                            sparseArray4.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                            sparseArray4.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                            sparseArray4.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                            sparseArray4.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                            sparseArray4.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                        }
                        if (z7) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                            sparseArray4.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z3));
                            sparseArray4.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                            sparseArray4.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                            sparseArray4.put(R.id.obfuscated_res_0x7f092050, sparseArray.get(R.id.obfuscated_res_0x7f092050));
                            if (z8) {
                                wu4Var = new wu4(6, getString(R.string.obfuscated_res_0x7f0f04b8), this.i);
                                wu4Var.d.setTag(sparseArray4);
                                wu4Var2 = new wu4(7, getString(R.string.obfuscated_res_0x7f0f02e8), this.i);
                                wu4Var2.d.setTag(sparseArray4);
                            }
                        } else {
                            sparseArray4.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                        }
                        wu4Var = null;
                        wu4Var2 = new wu4(7, getString(R.string.obfuscated_res_0x7f0f02e8), this.i);
                        wu4Var2.d.setTag(sparseArray4);
                    } else {
                        if (z7) {
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.obfuscated_res_0x7f092084, Boolean.FALSE);
                            sparseArray5.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                            sparseArray5.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                            sparseArray5.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                            sparseArray5.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z3));
                            sparseArray5.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                            sparseArray5.put(R.id.obfuscated_res_0x7f092050, sparseArray.get(R.id.obfuscated_res_0x7f092050));
                            if (this.a.S1().X() == 1002 && !z3) {
                                wu4Var3 = new wu4(6, getString(R.string.obfuscated_res_0x7f0f1029), this.i);
                            } else {
                                wu4Var3 = new wu4(6, getString(R.string.obfuscated_res_0x7f0f04b8), this.i);
                            }
                            wu4Var3.d.setTag(sparseArray5);
                            if (z11) {
                                new wu4(13, getString(R.string.obfuscated_res_0x7f0f0b4c), this.i);
                            }
                            wu4Var = wu4Var3;
                        } else {
                            wu4Var = null;
                        }
                        wu4Var2 = null;
                    }
                    if (wu4Var != null) {
                        arrayList.add(wu4Var);
                    }
                    if (wu4Var2 != null) {
                        arrayList.add(wu4Var2);
                    }
                    r18.b(arrayList, this.i, this.O, this.a);
                }
                if (UbsABTestHelper.isPBPlanA()) {
                    c2 = r18.d(arrayList, this.O.q(), sparseArray, this.i);
                } else {
                    c2 = r18.c(arrayList, this.O.q(), sparseArray, this.i);
                }
                r18.l(c2, this.g);
                r18.f(c2);
                this.i.o(r18.g(this.O));
                if (UbsABTestHelper.isPBPlanA()) {
                    this.i.k(c2, false);
                } else {
                    this.i.k(c2, true);
                }
                yu4 yu4Var = new yu4(getPageContext(), this.i);
                this.h = yu4Var;
                yu4Var.k();
                StatisticItem param = new StatisticItem("c13272").param("tid", this.a.m2()).param("fid", this.a.getForumId()).param("uid", this.a.S1().P().getAuthor().getUserId()).param("post_id", this.a.B());
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

    public void R1(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z));
            sparseArray.put(yz7.k2, Integer.valueOf(yz7.l2));
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                P1(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final TbRichText V1(ArrayList arrayList, String str, int i2) {
        InterceptResult invokeLLI;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048613, this, arrayList, str, i2)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    TbRichText X = ((PostData) arrayList.get(i3)).X();
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
                                    int h2 = (int) fj.h(TbadkCoreApplication.getInst());
                                    int width = B.get(i5).F().getWidth() * h2;
                                    int height = B.get(i5).F().getHeight() * h2;
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

    public final int W1(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList arrayList, ConcurrentHashMap concurrentHashMap) {
        InterceptResult invokeCommon;
        boolean z;
        TbRichTextImageInfo F;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
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
                        int h2 = (int) fj.h(TbadkCoreApplication.getInst());
                        int width = tbRichTextData.F().getWidth() * h2;
                        int height = tbRichTextData.F().getHeight() * h2;
                        if (width >= 80 && height >= 80 && width * height >= 10000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z && tbRichTextData.F().H()) {
                            if (tbRichTextData.getType() != 20) {
                                String a2 = vv7.a(tbRichTextData);
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
                                        imageUrlData.originalUrl = a2(tbRichTextData);
                                        imageUrlData.originalSize = b2(tbRichTextData);
                                        imageUrlData.mIsShowOrigonButton = Y1(tbRichTextData);
                                        imageUrlData.isLongPic = X1(tbRichTextData);
                                        imageUrlData.postId = tbRichText.getPostId();
                                        imageUrlData.threadId = eh.g(this.a.m2(), -1L);
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

    public void g2(boolean z, String str, SparseArray sparseArray) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
            String str6 = "";
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092095) instanceof String)) {
                str2 = "";
            } else {
                str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092095);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092097) instanceof String)) {
                str3 = "";
            } else {
                str3 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092097);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof String)) {
                str4 = "";
            } else {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092096);
            }
            if (!(sparseArray.get(R.id.obfuscated_res_0x7f092092) instanceof String)) {
                str5 = "";
            } else {
                str5 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092092);
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092093) instanceof String) {
                str6 = (String) sparseArray.get(R.id.obfuscated_res_0x7f092093);
            }
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.k);
            userMuteAddAndDelCustomMessage.setTag(this.k);
            E2(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
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
                f2(i3, intent);
            }
            if (i3 == -1) {
                if (i2 != 13008) {
                    if (i2 != 13011) {
                        if (i2 == 24007) {
                            int intExtra = intent.getIntExtra("extra_show_channel", 1);
                            if (intent.getIntExtra("extra_share_status", 2) == 1) {
                                od8.g().m(getPageContext());
                                J2();
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
                    od8.g().m(getPageContext());
                    return;
                }
                nz7.b().m();
                this.mHandler.postDelayed(new h(this), 1000L);
            }
        }
    }

    public final void h2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null && this.a.S1().k0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.m2(), str);
                ThreadData P = this.a.S1().P();
                if (P.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (P.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (P.isBJHVideoThreadType()) {
                    format = format + "&channelid=33840";
                }
                o2(format);
                return;
            }
            this.b.a(str);
        }
    }

    public final boolean n2(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048640, this, z)) == null) {
            PbModel pbModel = this.a;
            if (pbModel != null && pbModel.S1() != null) {
                if (this.a.S1().X() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || this.a.S1().P() == null || this.a.S1().P().getAuthor() == null || TextUtils.equals(this.a.S1().P().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void t2(PostData postData) {
        ro4 ro4Var;
        PostData U1;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048655, this, postData) != null) || postData == null) {
            return;
        }
        boolean z = false;
        if (postData.M() != null && postData.M().equals(this.a.N1())) {
            z = true;
        }
        MarkData M1 = this.a.M1(postData);
        if (this.a.S1() != null && this.a.S1().k0() && (U1 = U1()) != null) {
            M1 = this.a.M1(U1);
        }
        if (M1 != null && (ro4Var = this.A) != null) {
            ro4Var.i(M1);
            if (!z) {
                this.A.a();
            } else {
                this.A.d();
            }
        }
    }

    public final void k2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, bundle) == null) {
            this.d = new b18(this);
            this.e = new d18(getPageContext());
            tx7 tx7Var = new tx7(this, this.V, this.G, this.I, this.J);
            this.c = tx7Var;
            tx7Var.Y(this.a);
            setContentView(this.c.A(), new FlowLayout.LayoutParams(-1, -1));
            adjustResizeForSoftInput();
            addGlobalLayoutListener();
            this.c.s();
            this.c.V(new t(this));
            p75 p75Var = new p75();
            this.p = p75Var;
            A2(p75Var);
            n75 n75Var = (n75) this.p.a(getActivity());
            this.q = n75Var;
            n75Var.W(getPageContext());
            this.q.g0(this.S);
            this.q.Y(1);
            this.q.A(getPageContext(), bundle);
            this.q.b().b(new v55(getActivity()));
            this.q.b().C(true);
            B2(true);
            this.q.J(this.a.u1(), this.a.m2(), this.a.q1());
            this.c.T(this.q.b());
            this.s = new b08();
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
                this.q.c0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e1b));
            } else {
                tx7 tx7Var2 = this.c;
                if (tx7Var2 != null) {
                    this.q.c0(tx7Var2.z());
                }
            }
            this.v = new ShareSuccessReplyToServerModel();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bundle) == null) {
            j2(bundle);
            super.onCreate(bundle);
            VoiceManager voiceManager = new VoiceManager();
            this.t = voiceManager;
            voiceManager.onCreate(getPageContext());
            i2(bundle);
            k2(bundle);
            p2();
            if (this.r) {
                this.c.A().setAnimTime(0);
                this.c.A().setIsFromVideoTab(true);
            }
            if (getIntent() != null && this.r) {
                this.C = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
            }
            this.c.A().h();
            this.c.x().setFromForumId(this.a.getFromForumId());
            a28 a28Var = new a28(this);
            this.b = a28Var;
            a28Var.b(getUniqueId());
            this.o = new su8(getPageContext(), getUniqueId());
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.u = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new s(this));
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.q.c0(TbSingleton.getInstance().getAdVertiComment());
            } else {
                this.q.c0(this.c.z());
            }
            q35.b(false);
        }
    }

    public final AbsPbActivity.e x2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, str)) == null) {
            String str2 = null;
            if (this.a.S1() != null && this.a.S1().G() != null && this.a.S1().G().size() != 0 && !StringUtils.isNull(str)) {
                AbsPbActivity.e eVar = new AbsPbActivity.e();
                int i2 = 0;
                while (true) {
                    if (i2 < this.a.S1().G().size()) {
                        if (str.equals(((PostData) this.a.S1().G().get(i2)).M())) {
                            break;
                        }
                        i2++;
                    } else {
                        i2 = 0;
                        break;
                    }
                }
                PostData postData = (PostData) this.a.S1().G().get(i2);
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
                    v2(str2, 0, eVar);
                    vv7.b(postData, eVar);
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
        Object[] objArr = (pl5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), pl5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (e08.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new hj5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void q2(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048651, this, view2, str, str2, postData) != null) || view2 == null || str == null || str2 == null || !K1()) {
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
            this.c.y().j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f101f), postData.s().getName_show(), str3));
        }
        if (this.a.S1() != null && this.a.S1().k0()) {
            hh.a().postDelayed(new l(this, str, str2), 0L);
            return;
        }
        if (this.z == null) {
            er6 er6Var = new er6(getPageContext());
            this.z = er6Var;
            er6Var.j(1);
            this.z.i(new m(this, str, str2));
        }
        PbModel pbModel = this.a;
        if (pbModel != null && pbModel.S1() != null && this.a.S1().l() != null) {
            this.z.g(this.a.S1().l().getId(), eh.g(this.a.m2(), 0L));
        }
    }

    public final void u2(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048657, this, i2, str) == null) {
            if (this.a.t2()) {
                showToast(str);
            } else if (fj.D()) {
                if (i2 == 4) {
                    tx7 tx7Var = this.c;
                    tx7Var.g0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
                } else if (!TextUtils.isEmpty(str)) {
                    tx7 tx7Var2 = this.c;
                    tx7Var2.g0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
                } else {
                    this.c.f0(R.string.obfuscated_res_0x7f0f0c84);
                }
            } else {
                this.c.f0(R.string.obfuscated_res_0x7f0f0fdf);
            }
        }
    }

    public final void v2(String str, int i2, AbsPbActivity.e eVar) {
        TbRichTextData tbRichTextData;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048658, this, str, i2, eVar) != null) || eVar == null) {
            return;
        }
        uv7 S1 = this.a.S1();
        TbRichText K2 = K2(str, i2);
        if (K2 == null || (tbRichTextData = K2.B().get(this.F)) == null) {
            return;
        }
        eVar.f = String.valueOf(K2.getPostId());
        eVar.a = new ArrayList();
        eVar.b = new ConcurrentHashMap();
        boolean z = false;
        if (!tbRichTextData.F().H()) {
            eVar.h = false;
            String a2 = vv7.a(tbRichTextData);
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
            imageUrlData.originalUrl = a2(tbRichTextData);
            imageUrlData.originalUrl = a2(tbRichTextData);
            imageUrlData.originalSize = b2(tbRichTextData);
            imageUrlData.mIsShowOrigonButton = Y1(tbRichTextData);
            imageUrlData.isLongPic = X1(tbRichTextData);
            imageUrlData.postId = K2.getPostId();
            imageUrlData.mIsReserver = this.a.d2();
            imageUrlData.mIsSeeHost = this.a.v1();
            eVar.b.put(a2, imageUrlData);
            if (S1 != null) {
                if (S1.l() != null) {
                    eVar.c = S1.l().getName();
                    eVar.d = S1.l().getId();
                }
                if (S1.P() != null) {
                    eVar.e = S1.P().getId();
                }
                if (S1.s() == 1) {
                    z = true;
                }
                eVar.g = z;
            }
            imageUrlData.threadId = eh.g(eVar.e, -1L);
            return;
        }
        eVar.h = true;
        int size = S1.G().size();
        this.H = false;
        eVar.j = -1;
        if (S1.j() != null) {
            i3 = W1(S1.j().X(), K2, i2, i2, eVar.a, eVar.b);
        } else {
            i3 = i2;
        }
        int i5 = i3;
        for (int i6 = 0; i6 < size; i6++) {
            PostData postData = (PostData) S1.G().get(i6);
            if (postData.M() == null || S1.j() == null || S1.j().M() == null || !postData.M().equals(S1.j().M())) {
                i5 = W1(postData.X(), K2, i5, i2, eVar.a, eVar.b);
            }
        }
        if (eVar.a.size() > 0) {
            ArrayList arrayList = eVar.a;
            eVar.i = (String) arrayList.get(arrayList.size() - 1);
        }
        if (S1 != null) {
            if (S1.l() != null) {
                eVar.c = S1.l().getName();
                eVar.d = S1.l().getId();
            }
            if (S1.P() != null) {
                eVar.e = S1.P().getId();
            }
            if (S1.s() == 1) {
                z = true;
            }
            eVar.g = z;
        }
        eVar.j = i5;
    }
}
