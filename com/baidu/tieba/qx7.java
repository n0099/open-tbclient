package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tbadk.switchs.NovelPaySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.gx;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.xv7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FullLengthNovel;
import tbclient.Item;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class qx7 extends mx7<PostData, PbFirstFloorViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xv7 A;
    public v16<lq4> B;
    public gx.a C;
    public int g;
    public boolean h;
    public boolean i;
    public PbModel j;
    public boolean k;
    public vu7 l;
    public e18 m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public TbRichTextView.y p;
    public xv7 q;
    public View.OnLongClickListener r;
    public TbRichTextView.s s;
    public View.OnClickListener t;
    public boolean u;
    public final boolean v;
    public boolean w;
    public Context x;
    public boolean y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements xv7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx7 a;

        public a(qx7 qx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qx7Var;
        }

        @Override // com.baidu.tieba.xv7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.xv7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.q != null) {
                    this.a.q.a(view2);
                    this.a.q.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.xv7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, motionEvent));
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends v16<lq4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx7 b;

        public b(qx7 qx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, lq4 lq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lq4Var) == null) {
                super.a(view2, lq4Var);
                if (lq4Var == null || lq4Var.getThreadData() == null || lq4Var.getThreadData().originalThreadData == null || this.b.l == null) {
                    return;
                }
                OriginalThreadInfo originalThreadInfo = lq4Var.getThreadData().originalThreadData;
                String Q = this.b.l.Q();
                String str = originalThreadInfo.f;
                int i = 1;
                int i2 = originalThreadInfo.a;
                if (i2 == 3) {
                    i = 2;
                } else if (i2 == 4) {
                    i = 3;
                }
                if (StringUtils.isNull(Q) || StringUtils.isNull(str)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12602").param("tid", Q).param("obj_source", str).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements gx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx7 a;

        public c(qx7 qx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qx7Var;
        }

        @Override // com.baidu.tieba.gx.a
        public void a(lq4 lq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, lq4Var) == null) || lq4Var == null || lq4Var.getThreadData() == null || lq4Var.getThreadData().originalThreadData == null) {
                return;
            }
            OriginalThreadInfo originalThreadInfo = lq4Var.getThreadData().originalThreadData;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.x);
            pbActivityConfig.createNormalCfg(originalThreadInfo.f, originalThreadInfo.n, null);
            pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.e));
            pbActivityConfig.setStartFrom(this.a.z);
            pbActivityConfig.setBjhData(originalThreadInfo.p);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TbRichTextView.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ SparseArray c;
        public final /* synthetic */ View d;
        public final /* synthetic */ int e;
        public final /* synthetic */ qx7 f;

        public d(qx7 qx7Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, SparseArray sparseArray, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx7Var, pbFirstFloorViewHolder, postData, sparseArray, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qx7Var;
            this.a = pbFirstFloorViewHolder;
            this.b = postData;
            this.c = sparseArray;
            this.d = view2;
            this.e = i;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.v
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.g.getLayoutParams();
                layoutParams.topMargin = this.f.s(R.dimen.obfuscated_res_0x7f0701be);
                int s = this.f.s(R.dimen.obfuscated_res_0x7f07020f);
                layoutParams.bottomMargin = s;
                layoutParams.leftMargin = s;
                layoutParams.rightMargin = s;
                this.a.g.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.f.getLayoutParams();
                if (!TextUtils.isEmpty(this.b.y())) {
                    this.a.h.setTag(this.c);
                    this.a.h.setVisibility(0);
                    this.a.h.k(ln4.a(this.b.y()));
                    layoutParams2.topMargin = ej.f(this.f.x, R.dimen.tbds48) * (-1);
                } else {
                    this.a.h.setVisibility(8);
                    layoutParams2.topMargin = 0;
                }
                this.a.f.setLayoutParams(layoutParams2);
                this.f.B(this.a, this.b, this.d, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx7 a;

        public e(qx7 qx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qx7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.q != null) {
                    this.a.q.a(view2);
                    return this.a.q.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(qx7 qx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qx7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((f28) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 0;
        boolean z = true;
        this.h = true;
        this.i = true;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = false;
        int i3 = Build.VERSION.SDK_INT;
        this.v = (i3 < 14 || i3 > 16) ? false : false;
        this.w = false;
        this.z = 0;
        this.A = new xv7(new a(this));
        this.B = new b(this);
        this.C = new c(this);
        if (pbFragment != null && pbFragment.K() != null) {
            this.z = pbFragment.K().R1();
            this.j = pbFragment.K();
        }
        this.x = pbFragment.getContext();
    }

    public final String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            return skinType != 1 ? skinType != 4 ? "default" : "dark" : "night";
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0516  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str;
        String str2;
        long j;
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbFirstFloorViewHolder, postData, view2, i) == null) || this.l == null) {
            return;
        }
        TbRichText tbRichText = null;
        if (postData.C() != 1) {
            if (TextUtils.isEmpty(postData.t())) {
                pbFirstFloorViewHolder.f.setOnClickListener(this.o);
                pbFirstFloorViewHolder.f.setTextViewOnClickListener(this.o);
            } else {
                pbFirstFloorViewHolder.f.setOnClickListener(null);
                pbFirstFloorViewHolder.f.setTextViewOnClickListener(null);
            }
            pbFirstFloorViewHolder.c.setOnClickListener(this.o);
        } else {
            pbFirstFloorViewHolder.c.setOnClickListener(null);
        }
        if (postData.C() == 1) {
            pbFirstFloorViewHolder.c(this.l, this.b.u0(), postData.O);
            z(pbFirstFloorViewHolder.f, view2, this.w);
            if (postData.s() != null) {
                long userIdLong = postData.s().getUserIdLong();
                str = postData.s().getUserName();
                j = userIdLong;
                str2 = postData.s().getName_show();
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            vu7 vu7Var = this.l;
            if (vu7Var != null && vu7Var.O() != null) {
                pbFirstFloorViewHolder.u.b(postData.J(), str, str2, j, dh.g(this.l.O().getId(), 0L), dh.g(postData.L(), 0L));
            }
            if (this.b.P5().V1()) {
                pbFirstFloorViewHolder.f.setVisibility(8);
            }
            vu7 vu7Var2 = this.l;
            if (vu7Var2 != null && vu7Var2.O() != null && this.l.O().getYulePostActivityData() != null) {
                yt4 yulePostActivityData = this.l.O().getYulePostActivityData();
                String a2 = yulePostActivityData.a();
                if (StringUtils.isNull(yulePostActivityData.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.k.setVisibility(0);
                    pbFirstFloorViewHolder.k.K(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.k.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.l;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            vu7 vu7Var3 = this.l;
            if (vu7Var3 != null && vu7Var3.O() != null && this.l.O().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.x) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.x.getPaddingRight(), pbFirstFloorViewHolder.x.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f09203a, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092057, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092059, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f092068, Integer.valueOf(i));
        sparseArray.put(R.id.obfuscated_res_0x7f092067, Integer.valueOf(postData.C()));
        boolean z6 = postData.o0() || postData.n0(false);
        if (z6) {
            if (this.m == null) {
                e18 e18Var = new e18(this.x);
                this.m = e18Var;
                e18Var.f(this.e);
                this.m.h(this.n);
                vu7 vu7Var4 = this.l;
                if (vu7Var4 != null) {
                    this.m.j(this.l.W(), TextUtils.equals(vu7Var4.O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.m.i(this.l.O());
                }
            }
            this.m.g(postData.L());
        }
        pbFirstFloorViewHolder.f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.h) {
            pbFirstFloorViewHolder.f.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08123c);
        } else {
            pbFirstFloorViewHolder.f.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f.setIsFromCDN(this.e);
        vu7 vu7Var5 = this.l;
        if (vu7Var5 != null && vu7Var5.O() != null && this.l.O().isLinkThread()) {
            D(pbFirstFloorViewHolder, this.l.O().getLinkThreadData());
        }
        vu7 vu7Var6 = this.l;
        if ((vu7Var6 == null || vu7Var6.O() == null || !this.l.O().isShareThread || postData.U() == null) ? false : true) {
            if (postData.U().C != null) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.tbds14));
            }
            E(pbFirstFloorViewHolder, postData);
        } else {
            vu7 vu7Var7 = this.l;
            if (vu7Var7 != null && vu7Var7.O() != null && this.l.O().isQuestionThread()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.M_H_X007));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.tbds24));
            }
        }
        TbRichText W = postData.W();
        vu7 vu7Var8 = this.l;
        if (vu7Var8 == null || !vu7Var8.u0()) {
            tbRichText = W;
        }
        if (this.l.O() != null) {
            pbFirstFloorViewHolder.f.setTid(this.l.Q());
            pbFirstFloorViewHolder.f.setIsUseGridImage(this.l.O().isBJHNormalThreadType());
            pbFirstFloorViewHolder.f.setmIsGridImageSupportLongPress(true);
        }
        vu7 vu7Var9 = this.l;
        if (vu7Var9 != null && 3 == vu7Var9.g()) {
            if (!this.u && this.v) {
                pbFirstFloorViewHolder.f.setText(tbRichText, true, this.s, true, false);
            } else {
                pbFirstFloorViewHolder.f.setText(tbRichText, false, this.s, true, false);
            }
        } else if (!this.u && this.v) {
            pbFirstFloorViewHolder.f.setText(tbRichText, true, this.s, false, true);
        } else {
            pbFirstFloorViewHolder.f.setText(tbRichText, false, this.s, false, true);
        }
        F(pbFirstFloorViewHolder, postData, tbRichText);
        boolean z7 = !StringUtils.isNull(postData.s().getVirtualUserUrl());
        vu7 vu7Var10 = this.l;
        if (vu7Var10 == null || vu7Var10.W() == 0 || K()) {
            z = false;
            z2 = false;
        } else {
            if (this.l.W() != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        vu7 vu7Var11 = this.l;
        if (vu7Var11 != null && vu7Var11.O() != null && this.l.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.l.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                } else {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                }
                z5 = true;
                if (postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z2 = true;
                    z4 = true;
                }
                if (z7) {
                    z = false;
                    z2 = false;
                    z3 = false;
                }
                int i2 = postData.C() == 1 ? 0 : 1;
                sparseArray.put(R.id.obfuscated_res_0x7f09204a, postData.L());
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092047, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092048, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f092049, postData.s().getPortrait());
                    }
                    vu7 vu7Var12 = this.l;
                    if (vu7Var12 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(vu7Var12.W()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092096, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092051, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092092, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092093, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092091, postData.s().getName_show());
                    }
                    vu7 vu7Var13 = this.l;
                    if (vu7Var13 != null && vu7Var13.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092095, this.l.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.L());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092096, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092080, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09204e, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z4));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203e, Integer.valueOf(i2));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203c, postData.L());
                    vu7 vu7Var14 = this.l;
                    if (vu7Var14 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(vu7Var14.W()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092080, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f092052, Boolean.valueOf(z5));
                y(pbFirstFloorViewHolder);
            }
        }
        z3 = false;
        z4 = false;
        z5 = false;
        if (postData.s() != null) {
            z2 = true;
            z4 = true;
        }
        if (z7) {
        }
        if (postData.C() == 1) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09204a, postData.L());
        if (!z) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f092052, Boolean.valueOf(z5));
        y(pbFirstFloorViewHolder);
    }

    public final void C(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
        PostData postData2;
        ev7 ev7Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, pbFirstFloorViewHolder, postData, view2, i) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        pbFirstFloorViewHolder.f.setTag(sparseArray);
        pbFirstFloorViewHolder.c.setTag(R.id.obfuscated_res_0x7f09204d, sparseArray);
        sparseArray.put(R.id.obfuscated_res_0x7f09203a, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092053, Boolean.FALSE);
        pbFirstFloorViewHolder.f.setIsHost(true);
        if (this.i) {
            pbFirstFloorViewHolder.i.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.i.setVisibility(8);
        }
        List<CardLinkInfoData> list = null;
        if (!TextUtils.isEmpty(postData.t()) && this.h) {
            this.w = true;
            pbFirstFloorViewHolder.f.l0(postData.t(), new d(this, pbFirstFloorViewHolder, postData, sparseArray, view2, i));
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.g.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            pbFirstFloorViewHolder.g.setLayoutParams(layoutParams);
            pbFirstFloorViewHolder.f.k0(null);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbFirstFloorViewHolder.f.getLayoutParams();
            layoutParams2.topMargin = 0;
            pbFirstFloorViewHolder.f.setLayoutParams(layoutParams2);
            pbFirstFloorViewHolder.h.setVisibility(8);
            this.w = false;
            B(pbFirstFloorViewHolder, postData, view2, i);
        }
        vu7 vu7Var = this.l;
        if (vu7Var != null && vu7Var.O() != null && this.l.O().isVideoThreadType() && this.l.O().getThreadVideoInfo() != null && dj.isEmpty(this.l.l().getName())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
        } else if (postData.W() != null && !ListUtils.isEmpty(postData.W().B())) {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
        } else {
            pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
        }
        if (postData.W() != null) {
            if (postData.W().C() > 0) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.p.getLayoutParams();
                layoutParams3.topMargin = s(R.dimen.tbds26);
                pbFirstFloorViewHolder.p.setLayoutParams(layoutParams3);
            } else {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.p.getLayoutParams();
                layoutParams4.topMargin = s(R.dimen.tbds16);
                pbFirstFloorViewHolder.p.setLayoutParams(layoutParams4);
            }
        }
        vu7 vu7Var2 = this.l;
        if (vu7Var2 != null && L(vu7Var2.O())) {
            pbFirstFloorViewHolder.A.setDataForPb(this.l.O().getPollData(), this.l.O().getTid(), this.l.m());
            if (postData.W() != null && !ListUtils.isEmpty(postData.W().B())) {
                pbFirstFloorViewHolder.A.setMarginTop(ej.f(this.x, R.dimen.tbds26));
            } else {
                pbFirstFloorViewHolder.A.setMarginTop(ej.f(this.x, R.dimen.tbds0));
            }
            pbFirstFloorViewHolder.A.setVisibility(0);
        } else {
            pbFirstFloorViewHolder.A.setVisibility(8);
        }
        vu7 vu7Var3 = this.l;
        if (vu7Var3 != null && vu7Var3.O() != null && this.l.O().getSmartApp() != null && this.l.O().getThreadVideoInfo() == null) {
            pbFirstFloorViewHolder.p.setData(this.l.O().getSmartApp());
            pbFirstFloorViewHolder.p.setVisibility(0);
            vu7 vu7Var4 = this.l;
            if (vu7Var4 != null && vu7Var4.l() != null) {
                pbFirstFloorViewHolder.p.setForumId(String.valueOf(this.l.l().getId()));
            }
            vu7 vu7Var5 = this.l;
            if (vu7Var5 != null && vu7Var5.Q() != null) {
                pbFirstFloorViewHolder.p.setThreadId(this.l.Q());
            }
            pbFirstFloorViewHolder.p.setFrom("PB_card");
        } else {
            pbFirstFloorViewHolder.p.setVisibility(8);
        }
        vu7 vu7Var6 = this.l;
        if (vu7Var6 != null) {
            pbFirstFloorViewHolder.C.setData(vu7Var6.O(), this.l.P(), this.y);
        }
        if (NovelPaySwitch.isOn() && postData.T() != null && !postData.T().i() && this.l.m0()) {
            this.k = true;
            pbFirstFloorViewHolder.q.setVisibility(0);
            pbFirstFloorViewHolder.r.setVisibility(0);
            pbFirstFloorViewHolder.r.setData(postData.T());
            pbFirstFloorViewHolder.r.setStatisticData(this.l.Q(), this.l.m(), this.l.O() != null ? this.l.O().getThreadType() : 0);
        } else {
            pbFirstFloorViewHolder.q.setVisibility(8);
            pbFirstFloorViewHolder.r.setVisibility(8);
        }
        FullLengthNovel fullLengthNovel = postData.E0;
        if (fullLengthNovel != null && !TextUtils.isEmpty(fullLengthNovel.schema)) {
            pbFirstFloorViewHolder.s.setVisibility(0);
            if (pbFirstFloorViewHolder.s.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.s.getLayoutParams();
                layoutParams5.height = (ej.k(this.x) * postData.E0.button_heigh.intValue()) / 1080;
                pbFirstFloorViewHolder.s.setLayoutParams(layoutParams5);
            }
            pbFirstFloorViewHolder.s.loadUrl(postData.E0.schema + "&curskintype=" + A());
        } else {
            pbFirstFloorViewHolder.s.setVisibility(8);
        }
        vu7 vu7Var7 = this.l;
        if (vu7Var7 != null && (ev7Var = vu7Var7.h) != null) {
            if (pbFirstFloorViewHolder.o != null) {
                if (TextUtils.isEmpty(ev7Var.e())) {
                    pbFirstFloorViewHolder.o.setVisibility(8);
                } else {
                    pbFirstFloorViewHolder.o.setVisibility(0);
                    pbFirstFloorViewHolder.o.setText(this.l.h.e());
                }
            }
            if (pbFirstFloorViewHolder.n != null && pbFirstFloorViewHolder.z.h() == null) {
                pbFirstFloorViewHolder.n.addView(pbFirstFloorViewHolder.z.a(this.l));
                String fromPageKey = UtilHelper.getFromPageKey(this.b.getPageContext());
                Context context = this.x;
                if (!(context instanceof AbsPbActivity) || ((AbsPbActivity) context).getIntent() == null) {
                    z = false;
                } else {
                    z = ((AbsPbActivity) this.x).getIntent().getBooleanExtra("is_from_bar_vote", false);
                    if (z) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 1).eventStat();
                    }
                }
                if (fromPageKey != null && !z) {
                    if (fromPageKey.equals("a002")) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 3).eventStat();
                    } else if (fromPageKey.equals("a006")) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 2).eventStat();
                    } else if (fromPageKey.equals("a026")) {
                        new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 4).eventStat();
                    }
                }
            }
        }
        LinearLayout linearLayout = pbFirstFloorViewHolder.t;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        vu7 vu7Var8 = this.l;
        if (vu7Var8 != null && vu7Var8.F() != null && this.l.F().size() > 0 && (postData2 = this.l.F().get(0)) != null) {
            list = postData2.v();
        }
        vu7 vu7Var9 = this.l;
        if (vu7Var9 != null && vu7Var9.O() != null && !L(this.l.O()) && (!ListUtils.isEmpty(this.l.O().getLinkDataList()) || !ListUtils.isEmpty(this.l.O().getGoodsDataList()) || !ListUtils.isEmpty(list))) {
            zh5 zh5Var = new zh5();
            PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.x);
            vu7 vu7Var10 = this.l;
            pbLinkGoodsRootView.i(vu7Var10, zh5Var.b(vu7Var10.O().getLinkDataList(), this.l.O().getGoodsDataList(), list), this.l.n(), this.b, zh5Var.c());
            pbFirstFloorViewHolder.t.addView(pbLinkGoodsRootView);
            pbFirstFloorViewHolder.t.setVisibility(0);
            return;
        }
        pbFirstFloorViewHolder.t.setVisibility(8);
    }

    public final void D(PbFirstFloorViewHolder pbFirstFloorViewHolder, ds4 ds4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, pbFirstFloorViewHolder, ds4Var) == null) || ds4Var == null || dj.isEmpty(ds4Var.e()) || ds4Var.c() != ds4.g) {
            return;
        }
        if (!ds4Var.f()) {
            pbFirstFloorViewHolder.f.getLayoutStrategy().m(ej.f(this.x, R.dimen.obfuscated_res_0x7f0702cb));
        }
        pbFirstFloorViewHolder.u.c(ds4Var);
    }

    public final void E(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, pbFirstFloorViewHolder, postData) == null) || pbFirstFloorViewHolder == null || postData == null) {
            return;
        }
        pbFirstFloorViewHolder.v.setVisibility(0);
        if (pbFirstFloorViewHolder.w == null) {
            pbFirstFloorViewHolder.w = H(postData);
        }
        if (pbFirstFloorViewHolder.v.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.w.a()) != null) {
            pbFirstFloorViewHolder.v.addView(a2);
        }
        pbFirstFloorViewHolder.w.e(this.B);
        pbFirstFloorViewHolder.w.d(this.C);
        pbFirstFloorViewHolder.w.c(postData.U());
        pbFirstFloorViewHolder.w.b(this.b.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    public final void F(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.c0() != null) {
                c38.c(postData.c0(), pbFirstFloorViewHolder.m, false, true, tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.t()));
            } else {
                pbFirstFloorViewHolder.m.setVisibility(8);
            }
        }
    }

    public final int G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? ej.f(TbadkCoreApplication.getInst().getContext(), i) : invokeI.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final f08 H(PostData postData) {
        InterceptResult invokeL;
        f08 f08Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, postData)) != null) {
            return (f08) invokeL.objValue;
        }
        if (postData != null && postData.U() != null && postData.U().k()) {
            BaijiahaoData baijiahaoData = postData.U().p;
            Item item = postData.U().C;
            if (!postData.U().m && !postData.f1()) {
                if (item != null && item.item_id.longValue() != 0) {
                    if (postData.U().a != 0 && postData.U().a != 1) {
                        if (postData.U().a == 3) {
                            f08Var = new l08(this.b.getPageContext());
                        } else {
                            f08Var = new j08(this.b.getPageContext());
                        }
                    } else {
                        f08Var = new k08(this.b.getPageContext());
                    }
                } else if (baijiahaoData != null && postData.U().l()) {
                    int i = baijiahaoData.oriUgcType;
                    if (i == 1) {
                        f08Var = new g08(this.b.getPageContext(), this.z);
                    } else if (i == 2) {
                        f08Var = new n08(this.b.getPageContext(), this.z);
                    } else if (i == 3) {
                        f08Var = new m08(this.b.getPageContext(), this.z);
                    } else if (i != 4) {
                        f08Var = new h08(this.b.getPageContext(), this.z);
                    } else {
                        f08Var = new n08(this.b.getPageContext(), this.z);
                    }
                } else if (postData.U().a != 0 && postData.U().a != 1) {
                    if (postData.U().a == 3) {
                        f08Var = new n08(this.b.getPageContext(), this.z);
                    }
                } else {
                    f08Var = new m08(this.b.getPageContext(), this.z);
                }
            } else {
                f08Var = new i08(this.b.getPageContext(), this.z);
            }
            return f08Var != null ? new h08(this.b.getPageContext(), this.z) : f08Var;
        }
        f08Var = null;
        if (f08Var != null) {
        }
    }

    public PbFirstFloorViewHolder I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (PbFirstFloorViewHolder) this.viewholder : (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            vu7 vu7Var = this.l;
            if (vu7Var == null || vu7Var.O() == null) {
                return false;
            }
            return this.l.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    public final boolean L(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, threadData)) == null) ? (threadData == null || threadData.getPollData() == null || threadData.getPollData().getOptions() == null || threadData.getPollData().getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: M */
    public PbFirstFloorViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.b.getPageContext(), LayoutInflater.from(this.x).inflate(R.layout.obfuscated_res_0x7f0d0645, viewGroup, false), this.h, this.g);
            X(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.u.f(this.z);
            return pbFirstFloorViewHolder;
        }
        return (PbFirstFloorViewHolder) invokeL.objValue;
    }

    public View N(int i, View view2, ViewGroup viewGroup, PostData postData, PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        InterceptResult invokeCommon;
        BdTypeListView listView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, pbFirstFloorViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, postData, pbFirstFloorViewHolder);
            X(pbFirstFloorViewHolder);
            S(pbFirstFloorViewHolder);
            PostData postData2 = (PostData) getItem(i);
            if (postData2 != null) {
                postData2.i1();
                postData2.b0 = i + 1;
                v18.d(this.b.getUniqueId(), this.l, postData2, postData2.b0, 1);
                C(pbFirstFloorViewHolder, postData2, view2, i);
            }
            if (!this.u && this.v && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.f.G() && (listView = this.b.getListView()) != null) {
                this.u = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.B.setVisibility(8);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void O(boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (pbModel = this.j) != null && z && this.k) {
            pbModel.o3(3);
        }
    }

    public void P() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (v = this.viewholder) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).u.d();
    }

    public void Q() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (v = this.viewholder) == 0) {
            return;
        }
        if (((PbFirstFloorViewHolder) v).u != null) {
            ((PbFirstFloorViewHolder) v).u.a();
        }
        V v2 = this.viewholder;
        if (((PbFirstFloorViewHolder) v2).y != null) {
            ((PbFirstFloorViewHolder) v2).y.g();
        }
        V v3 = this.viewholder;
        if (((PbFirstFloorViewHolder) v3).r != null) {
            ((PbFirstFloorViewHolder) v3).r.i();
        }
        V v4 = this.viewholder;
        if (((PbFirstFloorViewHolder) v4).s != null) {
            ((PbFirstFloorViewHolder) v4).s.destroy();
        }
    }

    public void R() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (v = this.viewholder) == 0) {
            return;
        }
        ((PbFirstFloorViewHolder) v).u.e();
        ((PbFirstFloorViewHolder) this.viewholder).r.j();
    }

    public final void S(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.c.setOnTouchListener(this.q);
            pbFirstFloorViewHolder.c.setOnLongClickListener(this.r);
            c08 c08Var = this.a.P().d;
            pbFirstFloorViewHolder.f.setOnLongClickListener(this.r);
            pbFirstFloorViewHolder.f.setOnTouchListener(this.A);
            pbFirstFloorViewHolder.f.setItemOrderOrDownloadListener(this.t);
            pbFirstFloorViewHolder.f.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.f.setCommonTextViewOnClickListener(this.o);
            pbFirstFloorViewHolder.f.setOnImageClickListener(this.p);
            pbFirstFloorViewHolder.f.setOnImageTouchListener(this.A);
            pbFirstFloorViewHolder.f.setmGridEmptyClickListener(new f(this));
            pbFirstFloorViewHolder.f.setOnEmotionClickListener(c08Var.f);
            pbFirstFloorViewHolder.m.setOnClickListener(this.o);
            pbFirstFloorViewHolder.x.setAfterItemClickListener(this.o);
            pbFirstFloorViewHolder.y.setAfterItemClickListener(this.o);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.i = z;
        }
    }

    public void V(xv7 xv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, xv7Var) == null) {
            this.q = xv7Var;
        }
    }

    public void W(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sVar) == null) {
            this.s = sVar;
        }
    }

    public final void X(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, pbFirstFloorViewHolder) == null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.b != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.B, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.c, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.i, R.color.CAM_X0204);
            pbFirstFloorViewHolder.f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.p.c();
            pbFirstFloorViewHolder.r.g();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.x;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.a();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.y;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.h();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.o, (int) R.color.CAM_X0107);
            pbFirstFloorViewHolder.z.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.A;
            if (voteView != null) {
                voteView.C(skinType);
            }
            SkinManager.setBackgroundColorToTransparent(pbFirstFloorViewHolder.q, R.color.CAM_X0201, GradientDrawable.Orientation.BOTTOM_TOP);
            pbFirstFloorViewHolder.C.h();
            if (pbFirstFloorViewHolder.h.getVisibility() == 0) {
                pbFirstFloorViewHolder.h.g(skinType);
            }
        }
        pbFirstFloorViewHolder.b = TbadkCoreApplication.getInst().getSkinType();
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onLongClickListener) == null) {
            this.r = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.g = i;
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, yVar) == null) {
            this.p = yVar;
        }
    }

    @Override // com.baidu.tieba.mx7, com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        N(i, view2, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view2;
    }

    public void r(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, vu7Var) == null) {
            this.l = vu7Var;
        }
    }

    @Override // com.baidu.tieba.qn
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.y = z;
        }
    }

    public final void y(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.f.setTextViewOnTouchListener(this.A);
            pbFirstFloorViewHolder.f.setTextViewCheckSelection(false);
            pbFirstFloorViewHolder.h.setOnTouchListener(new e(this));
        }
    }

    public final void z(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048610, this, tbRichTextView, view2, z) == null) || tbRichTextView == null) {
            return;
        }
        int min = Math.min(((((ej.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - (z ? s(R.dimen.obfuscated_res_0x7f070275) : 0), this.g);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
    }
}
