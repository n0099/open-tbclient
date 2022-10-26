package com.baidu.tieba;

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
import com.baidu.tbadk.novel.NovelMemberCardView;
import com.baidu.tbadk.switchs.NovelPaySwitch;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.hx;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.ww7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FullLengthNovel;
import tbclient.Item;
/* loaded from: classes5.dex */
public class py7 extends ly7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ww7 A;
    public p26 B;
    public hx.a C;
    public int g;
    public boolean h;
    public boolean i;
    public PbModel j;
    public boolean k;
    public uv7 l;
    public d28 m;
    public View.OnClickListener n;
    public View.OnClickListener o;
    public TbRichTextView.y p;
    public ww7 q;
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
    public class a implements ww7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py7 a;

        @Override // com.baidu.tieba.ww7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public a(py7 py7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = py7Var;
        }

        @Override // com.baidu.tieba.ww7.a
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

        @Override // com.baidu.tieba.ww7.a
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
    public class b extends p26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py7 b;

        public b(py7 py7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = py7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p26
        /* renamed from: d */
        public void a(View view2, ar4 ar4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ar4Var) == null) {
                super.a(view2, ar4Var);
                if (ar4Var != null && ar4Var.getThreadData() != null && ar4Var.getThreadData().originalThreadData != null && this.b.l != null) {
                    OriginalThreadInfo originalThreadInfo = ar4Var.getThreadData().originalThreadData;
                    String R = this.b.l.R();
                    String str = originalThreadInfo.f;
                    int i = 1;
                    int i2 = originalThreadInfo.a;
                    if (i2 == 3) {
                        i = 2;
                    } else if (i2 == 4) {
                        i = 3;
                    }
                    if (!StringUtils.isNull(R) && !StringUtils.isNull(str)) {
                        TiebaStatic.log(new StatisticItem("c12602").param("tid", R).param("obj_source", str).param("obj_type", i));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements hx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py7 a;

        public c(py7 py7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = py7Var;
        }

        @Override // com.baidu.tieba.hx.a
        public void a(ar4 ar4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ar4Var) == null) && ar4Var != null && ar4Var.getThreadData() != null && ar4Var.getThreadData().originalThreadData != null) {
                OriginalThreadInfo originalThreadInfo = ar4Var.getThreadData().originalThreadData;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.x);
                pbActivityConfig.createNormalCfg(originalThreadInfo.f, originalThreadInfo.n, null);
                pbActivityConfig.setForumId(String.valueOf(originalThreadInfo.e));
                pbActivityConfig.setStartFrom(this.a.z);
                pbActivityConfig.setBjhData(originalThreadInfo.p);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
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
        public final /* synthetic */ py7 f;

        public d(py7 py7Var, PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, SparseArray sparseArray, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py7Var, pbFirstFloorViewHolder, postData, sparseArray, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = py7Var;
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
                if (!TextUtils.isEmpty(this.b.z())) {
                    this.a.h.setTag(this.c);
                    this.a.h.setVisibility(0);
                    this.a.h.k(zn4.a(this.b.z()));
                    ix7.a(this.a.h, this.d);
                } else {
                    this.a.h.setVisibility(8);
                }
                this.f.B(this.a, this.b, this.d, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ py7 a;

        public e(py7 py7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = py7Var;
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public f(py7 py7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {py7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public py7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((e38) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.A = new ww7(new a(this));
        this.B = new b(this);
        this.C = new c(this);
        if (pbFragment != null && pbFragment.K() != null) {
            this.z = pbFragment.K().R1();
            this.j = pbFragment.K();
        }
        this.x = pbFragment.getContext();
    }

    public final int G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return fj.f(TbadkCoreApplication.getInst().getContext(), i);
        }
        return invokeI.intValue;
    }

    public void O(boolean z) {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (pbModel = this.j) != null && z && this.k) {
            pbModel.o3(3);
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

    public void V(ww7 ww7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, ww7Var) == null) {
            this.q = ww7Var;
        }
    }

    public void W(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, sVar) == null) {
            this.s = sVar;
        }
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

    public void r(uv7 uv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, uv7Var) == null) {
            this.l = uv7Var;
        }
    }

    @Override // com.baidu.tieba.rn
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

    @Override // com.baidu.tieba.ly7, com.baidu.tieba.rn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        N(i, view2, viewGroup, (PostData) obj, (PbFirstFloorViewHolder) viewHolder);
        return view2;
    }

    public final String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return "default";
                }
                return "dark";
            }
            return "night";
        }
        return (String) invokeV.objValue;
    }

    public PbFirstFloorViewHolder I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (PbFirstFloorViewHolder) this.viewholder;
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            uv7 uv7Var = this.l;
            if (uv7Var != null && uv7Var.P() != null) {
                return this.l.P().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void P() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (v = this.viewholder) != 0) {
            ((PbFirstFloorViewHolder) v).w.d();
        }
    }

    public void R() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (v = this.viewholder) != 0) {
            ((PbFirstFloorViewHolder) v).w.e();
            ((PbFirstFloorViewHolder) this.viewholder).t.j();
        }
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
        boolean z6;
        boolean z7;
        String str;
        String str2;
        long j;
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbFirstFloorViewHolder, postData, view2, i) != null) || this.l == null) {
            return;
        }
        TbRichText tbRichText = null;
        int i2 = 1;
        if (postData.D() != 1) {
            if (TextUtils.isEmpty(postData.v())) {
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
        if (postData.D() == 1) {
            pbFirstFloorViewHolder.c(this.l, this.b.u0(), postData.P);
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
            uv7 uv7Var = this.l;
            if (uv7Var != null && uv7Var.P() != null) {
                pbFirstFloorViewHolder.w.b(postData.K(), str, str2, j, eh.g(this.l.P().getId(), 0L), eh.g(postData.M(), 0L));
            }
            if (this.b.O5().S1()) {
                pbFirstFloorViewHolder.f.setVisibility(8);
            }
            uv7 uv7Var2 = this.l;
            if (uv7Var2 != null && uv7Var2.P() != null && this.l.P().getYulePostActivityData() != null) {
                nu4 yulePostActivityData = this.l.P().getYulePostActivityData();
                String a2 = yulePostActivityData.a();
                if (StringUtils.isNull(yulePostActivityData.b())) {
                    return;
                }
                if (!StringUtils.isNull(a2)) {
                    pbFirstFloorViewHolder.k.setVisibility(0);
                    pbFirstFloorViewHolder.k.L(a2, 10, true);
                }
            } else {
                pbFirstFloorViewHolder.k.setVisibility(8);
            }
            ThreadSkinView threadSkinView = pbFirstFloorViewHolder.l;
            if (threadSkinView != null) {
                threadSkinView.setVisibility(8);
            }
            uv7 uv7Var3 = this.l;
            if (uv7Var3 != null && uv7Var3.P() != null && this.l.P().isVideoThreadType() && (threadForumEnterButtonContainer = pbFirstFloorViewHolder.z) != null) {
                threadForumEnterButtonContainer.setPadding(threadForumEnterButtonContainer.getPaddingLeft(), fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds29), pbFirstFloorViewHolder.z.getPaddingRight(), pbFirstFloorViewHolder.z.getPaddingBottom());
            }
        }
        pbFirstFloorViewHolder.f.getLayoutStrategy().x(R.drawable.pic_video);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f09203c, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092059, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f09205b, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f09206a, Integer.valueOf(i));
        sparseArray.put(R.id.obfuscated_res_0x7f092069, Integer.valueOf(postData.D()));
        if (!postData.p0() && !postData.o0(false)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.m == null) {
                d28 d28Var = new d28(this.x);
                this.m = d28Var;
                d28Var.f(this.e);
                this.m.h(this.n);
                uv7 uv7Var4 = this.l;
                if (uv7Var4 != null) {
                    this.m.j(this.l.X(), TextUtils.equals(uv7Var4.P().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()));
                    this.m.i(this.l.P());
                }
            }
            this.m.g(postData.M());
        }
        pbFirstFloorViewHolder.f.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.h) {
            pbFirstFloorViewHolder.f.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081252);
        } else {
            pbFirstFloorViewHolder.f.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbFirstFloorViewHolder.f.setIsFromCDN(this.e);
        uv7 uv7Var5 = this.l;
        if (uv7Var5 != null && uv7Var5.P() != null && this.l.P().isLinkThread()) {
            D(pbFirstFloorViewHolder, this.l.P().getLinkThreadData());
        }
        uv7 uv7Var6 = this.l;
        if (uv7Var6 != null && uv7Var6.P() != null && this.l.P().isShareThread && postData.V() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (postData.V().C != null) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.tbds24));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.tbds14));
            }
            E(pbFirstFloorViewHolder, postData);
        } else {
            uv7 uv7Var7 = this.l;
            if (uv7Var7 != null && uv7Var7.P() != null && this.l.P().isQuestionThread()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.M_H_X007));
            } else {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(G(R.dimen.tbds24));
            }
        }
        TbRichText X = postData.X();
        uv7 uv7Var8 = this.l;
        if (uv7Var8 == null || !uv7Var8.x0()) {
            tbRichText = X;
        }
        if (this.l.P() != null) {
            pbFirstFloorViewHolder.f.setTid(this.l.R());
            pbFirstFloorViewHolder.f.setIsUseGridImage(this.l.P().isBJHNormalThreadType());
            pbFirstFloorViewHolder.f.setmIsGridImageSupportLongPress(true);
        }
        uv7 uv7Var9 = this.l;
        if (uv7Var9 != null && 3 == uv7Var9.g()) {
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
        boolean z8 = !StringUtils.isNull(postData.s().getVirtualUserUrl());
        uv7 uv7Var10 = this.l;
        if (uv7Var10 != null && uv7Var10.X() != 0 && !K()) {
            if (this.l.X() != 3) {
                z3 = true;
                z4 = true;
            } else {
                z3 = false;
                z4 = false;
            }
            if (postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z3 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z3 = false;
                }
            }
        } else {
            z3 = false;
            z4 = false;
        }
        uv7 uv7Var11 = this.l;
        if (uv7Var11 != null && uv7Var11.P() != null && this.l.P().getAuthor() != null && postData.s() != null) {
            String userId2 = this.l.P().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z4 = true;
                    z5 = false;
                    z6 = true;
                } else {
                    z4 = true;
                    z5 = true;
                    z6 = false;
                }
                z7 = true;
                if (postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z4 = true;
                    z6 = true;
                }
                if (z8) {
                    z3 = false;
                    z4 = false;
                    z5 = false;
                }
                if (postData.D() == 1) {
                    i2 = 0;
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09204c, postData.M());
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092084, Boolean.TRUE);
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092049, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204a, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204b, postData.s().getPortrait());
                    }
                    uv7 uv7Var12 = this.l;
                    if (uv7Var12 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(uv7Var12.X()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092084, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092098, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092053, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092095, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092093, postData.s().getName_show());
                    }
                    uv7 uv7Var13 = this.l;
                    if (uv7Var13 != null && uv7Var13.P() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092097, this.l.P().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.M());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092098, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092050, Boolean.valueOf(z));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f092040, Integer.valueOf(i2));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203e, postData.M());
                    uv7 uv7Var14 = this.l;
                    if (uv7Var14 != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(uv7Var14.X()));
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f092054, Boolean.valueOf(z7));
                y(pbFirstFloorViewHolder);
            }
        }
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData.s() != null) {
            z4 = true;
            z6 = true;
        }
        if (z8) {
        }
        if (postData.D() == 1) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09204c, postData.M());
        if (!z3) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f092054, Boolean.valueOf(z7));
        y(pbFirstFloorViewHolder);
    }

    public final void C(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, View view2, int i) {
        PostData postData2;
        dw7 dw7Var;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, pbFirstFloorViewHolder, postData, view2, i) == null) && pbFirstFloorViewHolder != null && postData != null) {
            SparseArray sparseArray = new SparseArray();
            pbFirstFloorViewHolder.f.setTag(sparseArray);
            pbFirstFloorViewHolder.c.setTag(R.id.obfuscated_res_0x7f09204f, sparseArray);
            sparseArray.put(R.id.obfuscated_res_0x7f09203c, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.FALSE);
            pbFirstFloorViewHolder.f.setIsHost(true);
            if (this.i) {
                pbFirstFloorViewHolder.i.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.i.setVisibility(8);
            }
            List<CardLinkInfoData> list = null;
            if (!TextUtils.isEmpty(postData.v()) && this.h) {
                this.w = true;
                pbFirstFloorViewHolder.f.l0(postData.v(), new d(this, pbFirstFloorViewHolder, postData, sparseArray, view2, i));
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.g.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                pbFirstFloorViewHolder.g.setLayoutParams(layoutParams);
                pbFirstFloorViewHolder.f.k0(null);
                pbFirstFloorViewHolder.h.setVisibility(8);
                this.w = false;
                B(pbFirstFloorViewHolder, postData, view2, i);
            }
            uv7 uv7Var = this.l;
            if (uv7Var != null && uv7Var.P() != null && this.l.P().isVideoThreadType() && this.l.P().getThreadVideoInfo() != null && ej.isEmpty(this.l.l().getName())) {
                pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds28));
            } else if (postData.X() != null && !ListUtils.isEmpty(postData.X().B())) {
                pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30));
            } else {
                pbFirstFloorViewHolder.b(true, (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds52));
            }
            if (postData.X() != null) {
                if (postData.X().C() > 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.r.getLayoutParams();
                    layoutParams2.topMargin = s(R.dimen.tbds26);
                    pbFirstFloorViewHolder.r.setLayoutParams(layoutParams2);
                } else {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.r.getLayoutParams();
                    layoutParams3.topMargin = s(R.dimen.tbds16);
                    pbFirstFloorViewHolder.r.setLayoutParams(layoutParams3);
                }
            }
            uv7 uv7Var2 = this.l;
            if (uv7Var2 != null && L(uv7Var2.P())) {
                pbFirstFloorViewHolder.C.setDataForPb(this.l.P().getPollData(), this.l.P().getTid(), this.l.m());
                if (postData.X() != null && !ListUtils.isEmpty(postData.X().B())) {
                    pbFirstFloorViewHolder.C.setMarginTop(fj.f(this.x, R.dimen.tbds26));
                } else {
                    pbFirstFloorViewHolder.C.setMarginTop(fj.f(this.x, R.dimen.tbds0));
                }
                pbFirstFloorViewHolder.C.setVisibility(0);
            } else {
                pbFirstFloorViewHolder.C.setVisibility(8);
            }
            uv7 uv7Var3 = this.l;
            if (uv7Var3 != null && uv7Var3.P() != null && this.l.P().getSmartApp() != null && this.l.P().getThreadVideoInfo() == null) {
                pbFirstFloorViewHolder.r.setData(this.l.P().getSmartApp());
                pbFirstFloorViewHolder.r.setVisibility(0);
                uv7 uv7Var4 = this.l;
                if (uv7Var4 != null && uv7Var4.l() != null) {
                    pbFirstFloorViewHolder.r.setForumId(String.valueOf(this.l.l().getId()));
                }
                uv7 uv7Var5 = this.l;
                if (uv7Var5 != null && uv7Var5.R() != null) {
                    pbFirstFloorViewHolder.r.setThreadId(this.l.R());
                }
                pbFirstFloorViewHolder.r.setFrom("PB_card");
            } else {
                pbFirstFloorViewHolder.r.setVisibility(8);
            }
            uv7 uv7Var6 = this.l;
            if (uv7Var6 != null) {
                pbFirstFloorViewHolder.E.setData(uv7Var6.P(), this.l.Q(), this.y);
            }
            if (NovelPaySwitch.isOn() && postData.U() != null && !postData.U().i() && this.l.p0()) {
                this.k = true;
                pbFirstFloorViewHolder.s.setVisibility(0);
                pbFirstFloorViewHolder.t.setVisibility(0);
                pbFirstFloorViewHolder.t.setData(postData.U());
                NovelMemberCardView novelMemberCardView = pbFirstFloorViewHolder.t;
                String R = this.l.R();
                String m = this.l.m();
                if (this.l.P() != null) {
                    i2 = this.l.P().getThreadType();
                } else {
                    i2 = 0;
                }
                novelMemberCardView.setStatisticData(R, m, i2);
            } else {
                pbFirstFloorViewHolder.s.setVisibility(8);
                pbFirstFloorViewHolder.t.setVisibility(8);
            }
            FullLengthNovel fullLengthNovel = postData.F0;
            if (fullLengthNovel != null && !TextUtils.isEmpty(fullLengthNovel.schema)) {
                pbFirstFloorViewHolder.u.setVisibility(0);
                if (pbFirstFloorViewHolder.u.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) pbFirstFloorViewHolder.u.getLayoutParams();
                    layoutParams4.height = (fj.k(this.x) * postData.F0.button_heigh.intValue()) / 1080;
                    pbFirstFloorViewHolder.u.setLayoutParams(layoutParams4);
                }
                pbFirstFloorViewHolder.u.loadUrl(postData.F0.schema + "&curskintype=" + A());
            } else {
                pbFirstFloorViewHolder.u.setVisibility(8);
            }
            uv7 uv7Var7 = this.l;
            if (uv7Var7 != null && uv7Var7.P() != null && (this.l.P().getIsNoTitle() != 0 || this.l.P().isVideoThreadType())) {
                uv7 uv7Var8 = this.l;
                if (uv7Var8.P().getIs_good() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.l.P().getIs_top() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                pbFirstFloorViewHolder.d(uv7Var8, z2, z3);
            }
            uv7 uv7Var9 = this.l;
            if (uv7Var9 != null && (dw7Var = uv7Var9.h) != null) {
                if (pbFirstFloorViewHolder.q != null) {
                    if (TextUtils.isEmpty(dw7Var.e())) {
                        pbFirstFloorViewHolder.q.setVisibility(8);
                    } else {
                        pbFirstFloorViewHolder.q.setVisibility(0);
                        pbFirstFloorViewHolder.q.setText(this.l.h.e());
                    }
                }
                if (pbFirstFloorViewHolder.p != null && pbFirstFloorViewHolder.B.h() == null) {
                    pbFirstFloorViewHolder.p.addView(pbFirstFloorViewHolder.B.a(this.l));
                    String fromPageKey = UtilHelper.getFromPageKey(this.b.getPageContext());
                    Context context = this.x;
                    if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).getIntent() != null) {
                        z = ((AbsPbActivity) this.x).getIntent().getBooleanExtra("is_from_bar_vote", false);
                        if (z) {
                            new StatisticItem(TbadkCoreStatisticKey.KEY_PB_VOTE_SOURCE).param("obj_source", 1).eventStat();
                        }
                    } else {
                        z = false;
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
            LinearLayout linearLayout = pbFirstFloorViewHolder.v;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            uv7 uv7Var10 = this.l;
            if (uv7Var10 != null && uv7Var10.G() != null && this.l.G().size() > 0 && (postData2 = (PostData) this.l.G().get(0)) != null) {
                list = postData2.w();
            }
            uv7 uv7Var11 = this.l;
            if (uv7Var11 != null && uv7Var11.P() != null && !L(this.l.P()) && (!ListUtils.isEmpty(this.l.P().getLinkDataList()) || !ListUtils.isEmpty(this.l.P().getGoodsDataList()) || !ListUtils.isEmpty(list))) {
                ri5 ri5Var = new ri5();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.x);
                uv7 uv7Var12 = this.l;
                pbLinkGoodsRootView.i(uv7Var12, ri5Var.b(uv7Var12.P().getLinkDataList(), this.l.P().getGoodsDataList(), list), this.l.n(), this.b, ri5Var.c());
                pbFirstFloorViewHolder.v.addView(pbLinkGoodsRootView);
                pbFirstFloorViewHolder.v.setVisibility(0);
                return;
            }
            pbFirstFloorViewHolder.v.setVisibility(8);
        }
    }

    public final void D(PbFirstFloorViewHolder pbFirstFloorViewHolder, ss4 ss4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, pbFirstFloorViewHolder, ss4Var) == null) && ss4Var != null && !ej.isEmpty(ss4Var.e()) && ss4Var.c() == ss4.g) {
            if (!ss4Var.f()) {
                pbFirstFloorViewHolder.f.getLayoutStrategy().m(fj.f(this.x, R.dimen.obfuscated_res_0x7f0702cb));
            }
            pbFirstFloorViewHolder.w.c(ss4Var);
        }
    }

    public final void E(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData) {
        View a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, pbFirstFloorViewHolder, postData) == null) && pbFirstFloorViewHolder != null && postData != null) {
            pbFirstFloorViewHolder.x.setVisibility(0);
            if (pbFirstFloorViewHolder.y == null) {
                pbFirstFloorViewHolder.y = H(postData);
            }
            if (pbFirstFloorViewHolder.x.getChildCount() <= 0 && (a2 = pbFirstFloorViewHolder.y.a()) != null) {
                pbFirstFloorViewHolder.x.addView(a2);
            }
            pbFirstFloorViewHolder.y.e(this.B);
            pbFirstFloorViewHolder.y.d(this.C);
            pbFirstFloorViewHolder.y.c(postData.V());
            pbFirstFloorViewHolder.y.b(this.b.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void F(PbFirstFloorViewHolder pbFirstFloorViewHolder, PostData postData, TbRichText tbRichText) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, pbFirstFloorViewHolder, postData, tbRichText) == null) {
            if (postData != null && postData.d0() != null) {
                if (tbRichText != null && StringUtils.isNull(tbRichText.toString()) && StringUtils.isNull(postData.v())) {
                    z = true;
                } else {
                    z = false;
                }
                b48.c(postData.d0(), pbFirstFloorViewHolder.m, pbFirstFloorViewHolder.n, pbFirstFloorViewHolder.o, false, true, z);
                return;
            }
            pbFirstFloorViewHolder.m.setVisibility(8);
            pbFirstFloorViewHolder.n.setVisibility(8);
        }
    }

    public final void z(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048610, this, tbRichTextView, view2, z) != null) || tbRichTextView == null) {
            return;
        }
        int k = (((fj.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        int i = 0;
        if (z) {
            i = s(R.dimen.obfuscated_res_0x7f070275);
        }
        int min = Math.min(k - i, this.g);
        tbRichTextView.getLayoutStrategy().q(min);
        tbRichTextView.getLayoutStrategy().p((int) (min * 1.618f));
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e18 H(PostData postData) {
        InterceptResult invokeL;
        e18 e18Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, postData)) == null) {
            if (postData != null && postData.V() != null && postData.V().k()) {
                BaijiahaoData baijiahaoData = postData.V().p;
                Item item = postData.V().C;
                if (!postData.V().m && !postData.g1()) {
                    if (item != null && item.item_id.longValue() != 0) {
                        if (postData.V().a != 0 && postData.V().a != 1) {
                            if (postData.V().a == 3) {
                                e18Var = new k18(this.b.getPageContext());
                            } else {
                                e18Var = new i18(this.b.getPageContext());
                            }
                        } else {
                            e18Var = new j18(this.b.getPageContext());
                        }
                    } else if (baijiahaoData != null && postData.V().l()) {
                        int i = baijiahaoData.oriUgcType;
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (i != 4) {
                                        e18Var = new g18(this.b.getPageContext(), this.z);
                                    } else {
                                        e18Var = new m18(this.b.getPageContext(), this.z);
                                    }
                                } else {
                                    e18Var = new l18(this.b.getPageContext(), this.z);
                                }
                            } else {
                                e18Var = new m18(this.b.getPageContext(), this.z);
                            }
                        } else {
                            e18Var = new f18(this.b.getPageContext(), this.z);
                        }
                    } else if (postData.V().a != 0 && postData.V().a != 1) {
                        if (postData.V().a == 3) {
                            e18Var = new m18(this.b.getPageContext(), this.z);
                        }
                    } else {
                        e18Var = new l18(this.b.getPageContext(), this.z);
                    }
                } else {
                    e18Var = new h18(this.b.getPageContext(), this.z);
                }
                if (e18Var != null) {
                    return new g18(this.b.getPageContext(), this.z);
                }
                return e18Var;
            }
            e18Var = null;
            if (e18Var != null) {
            }
        } else {
            return (e18) invokeL.objValue;
        }
    }

    public final boolean L(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, threadData)) == null) {
            if (threadData != null && threadData.getPollData() != null && threadData.getPollData().getOptions() != null && threadData.getPollData().getOptions().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rn
    /* renamed from: M */
    public PbFirstFloorViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            PbFirstFloorViewHolder pbFirstFloorViewHolder = new PbFirstFloorViewHolder(this.b.getPageContext(), LayoutInflater.from(this.x).inflate(R.layout.obfuscated_res_0x7f0d0645, viewGroup, false), this.h, this.g);
            X(pbFirstFloorViewHolder);
            pbFirstFloorViewHolder.w.f(this.z);
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
                postData2.j1();
                postData2.c0 = i + 1;
                u28.d(this.b.getUniqueId(), this.l, postData2, postData2.c0, 1);
                C(pbFirstFloorViewHolder, postData2, view2, i);
            }
            if (!this.u && this.v && pbFirstFloorViewHolder != null && pbFirstFloorViewHolder.f.G() && (listView = this.b.getListView()) != null) {
                this.u = true;
                CompatibleUtile.getInstance().closeViewGpu(listView);
            }
            pbFirstFloorViewHolder.D.setVisibility(8);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void Q() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (v = this.viewholder) == 0) {
            return;
        }
        if (((PbFirstFloorViewHolder) v).w != null) {
            ((PbFirstFloorViewHolder) v).w.a();
        }
        V v2 = this.viewholder;
        if (((PbFirstFloorViewHolder) v2).A != null) {
            ((PbFirstFloorViewHolder) v2).A.g();
        }
        V v3 = this.viewholder;
        if (((PbFirstFloorViewHolder) v3).t != null) {
            ((PbFirstFloorViewHolder) v3).t.i();
        }
        V v4 = this.viewholder;
        if (((PbFirstFloorViewHolder) v4).u != null) {
            ((PbFirstFloorViewHolder) v4).u.destroy();
        }
    }

    public final void S(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pbFirstFloorViewHolder) == null) {
            pbFirstFloorViewHolder.c.setOnTouchListener(this.q);
            pbFirstFloorViewHolder.c.setOnLongClickListener(this.r);
            b18 b18Var = this.a.P().d;
            pbFirstFloorViewHolder.f.setOnLongClickListener(this.r);
            pbFirstFloorViewHolder.f.setOnTouchListener(this.A);
            pbFirstFloorViewHolder.f.setItemOrderOrDownloadListener(this.t);
            pbFirstFloorViewHolder.f.setIsShowOrderOrDownloadBtn(true);
            pbFirstFloorViewHolder.f.setCommonTextViewOnClickListener(this.o);
            pbFirstFloorViewHolder.f.setOnImageClickListener(this.p);
            pbFirstFloorViewHolder.f.setOnImageTouchListener(this.A);
            pbFirstFloorViewHolder.f.setmGridEmptyClickListener(new f(this));
            pbFirstFloorViewHolder.f.setOnEmotionClickListener(b18Var.f);
            pbFirstFloorViewHolder.m.setOnClickListener(this.o);
            pbFirstFloorViewHolder.n.setOnClickListener(this.o);
            pbFirstFloorViewHolder.z.setAfterItemClickListener(this.o);
            pbFirstFloorViewHolder.A.setAfterItemClickListener(this.o);
        }
    }

    public final void X(PbFirstFloorViewHolder pbFirstFloorViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, pbFirstFloorViewHolder) != null) || pbFirstFloorViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbFirstFloorViewHolder.b != skinType) {
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.D, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.c, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(pbFirstFloorViewHolder.i, R.color.CAM_X0204);
            pbFirstFloorViewHolder.f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            pbFirstFloorViewHolder.r.c();
            pbFirstFloorViewHolder.t.g();
            ThreadForumEnterButtonContainer threadForumEnterButtonContainer = pbFirstFloorViewHolder.z;
            if (threadForumEnterButtonContainer != null) {
                threadForumEnterButtonContainer.a();
            }
            PbBusinessPromotionContainer pbBusinessPromotionContainer = pbFirstFloorViewHolder.A;
            if (pbBusinessPromotionContainer != null) {
                pbBusinessPromotionContainer.h();
            }
            SkinManager.setViewTextColor(pbFirstFloorViewHolder.q, (int) R.color.CAM_X0107);
            pbFirstFloorViewHolder.B.i(skinType);
            VoteView voteView = pbFirstFloorViewHolder.C;
            if (voteView != null) {
                voteView.C(skinType);
            }
            SkinManager.setBackgroundColorToTransparent(pbFirstFloorViewHolder.s, R.color.CAM_X0201, GradientDrawable.Orientation.BOTTOM_TOP);
            pbFirstFloorViewHolder.E.h();
            if (pbFirstFloorViewHolder.h.getVisibility() == 0) {
                pbFirstFloorViewHolder.h.g(skinType);
            }
        }
        pbFirstFloorViewHolder.b = TbadkCoreApplication.getInst().getSkinType();
    }
}
