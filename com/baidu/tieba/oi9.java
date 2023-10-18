package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.feedback.AigcFeedbackHelper;
import com.baidu.tieba.pb.feedback.FeedbackButtonStateType;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.tg9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import tbclient.AigcFeedbackInfo;
/* loaded from: classes7.dex */
public class oi9 extends qi9<pea, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tg9 A;
    public boolean B;
    public TbRichTextView.t g;
    public boolean h;
    public float i;
    public String j;
    public ye9 k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public TbRichTextView.z n;
    public tg9 o;
    public View.OnLongClickListener p;
    public gn9 q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public ya<ConstrainImageLayout> y;
    public ya<TbImageView> z;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ pl9 b;
        public final /* synthetic */ oi9 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pea a;
            public final /* synthetic */ c b;

            public a(c cVar, pea peaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, peaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = peaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.b;
                    cVar.b.b.a(cVar.c.k, null, this.a, cVar.a.r.getLayoutStrategy());
                }
            }
        }

        public c(oi9 oi9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pl9 pl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, pbCommenFloorItemViewHolder, pl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oi9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = pl9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            pea peaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof pea) && (peaVar = (pea) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                SafeHandler.getInst().postDelayed(new a(this, peaVar), 100L);
                String Q = this.c.k.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.c.k.Q())) && this.c.k.O() != null) {
                    Q = this.c.k.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", peaVar.U()).param("obj_source", this.c.n0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ pea b;
        public final /* synthetic */ PbCommenFloorItemViewHolder c;
        public final /* synthetic */ oi9 d;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.a;
                    if (gVar.d.getItem(gVar.a) instanceof pea) {
                        g gVar2 = this.a;
                        pea peaVar = (pea) gVar2.d.getItem(gVar2.a);
                        peaVar.M0();
                        if (peaVar.e0() <= 0 && !this.a.b.y0()) {
                            peaVar.h1(Boolean.FALSE);
                            this.a.c.z0.setVisibility(8);
                            g gVar3 = this.a;
                            xk9.B(gVar3.c, gVar3.b);
                            this.a.c.e0.setVisibility(0);
                        }
                    }
                }
            }
        }

        public g(oi9 oi9Var, int i, pea peaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, Integer.valueOf(i), peaVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = oi9Var;
            this.a = i;
            this.b = peaVar;
            this.c = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((pea) this.d.getItem(this.a)).L0();
                if (!this.b.y0()) {
                    ((pea) this.d.getItem(this.a)).h1(Boolean.TRUE);
                    this.c.d0.setVisibility(8);
                    this.c.e0.setVisibility(8);
                    this.c.z0.setVisibility(0);
                    this.d.u0(this.c.z0, this.a);
                }
                this.c.z0.postDelayed(new a(this), 5000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pea a;
        public final /* synthetic */ oi9 b;

        public a(oi9 oi9Var, pea peaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, peaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oi9Var;
            this.a = peaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                pea peaVar = this.a;
                if (peaVar != null && peaVar.t() != null) {
                    ts5.d(this.b.k.l(), this.a.t().getPortrait(), "3", this.b.b.getContext());
                }
                us5.c("c15281", this.b.k.l(), "3");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public b(oi9 oi9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.z.performClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ oi9 b;

        public d(oi9 oi9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oi9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.p) != null && agreeView.getData() != null) {
                if (view2 == this.a.p.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String Q = this.b.k.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.k.Q())) && this.b.k.O() != null) {
                    Q = this.b.k.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.p.getData().postId).param("obj_source", this.b.n0(this.a.p)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ oi9 b;

        public e(oi9 oi9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oi9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.d0) != null && agreeView.getData() != null) {
                if (view2 == this.a.d0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String Q = this.b.k.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.k.Q())) && this.b.k.O() != null) {
                    Q = this.b.k.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId).param("obj_source", this.b.n0(this.a.d0)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ pea c;
        public final /* synthetic */ View d;
        public final /* synthetic */ oi9 e;

        public f(oi9 oi9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i, pea peaVar, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, pbCommenFloorItemViewHolder, Integer.valueOf(i), peaVar, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = oi9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = i;
            this.c = peaVar;
            this.d = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AgreeView agreeView = this.a.d0;
                if (agreeView != null && agreeView.getAgreeFlag()) {
                    z = true;
                } else {
                    z = false;
                }
                this.e.Y(this.b, this.a, this.c, z, this.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi9 a;

        public h(oi9 oi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi9Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    this.a.o.a(view2);
                    return this.a.o.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ oi9 b;

        public i(oi9 oi9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oi9Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                xn9.w("c14886");
                if (this.b.getItem(this.a) instanceof pea) {
                    pea peaVar = (pea) this.b.getItem(this.a);
                    if (peaVar.A() != null) {
                        UrlManager.getInstance().dealOneLink(peaVar.A().a());
                        return;
                    }
                    oi9 oi9Var = this.b;
                    oi9Var.o0(((pea) oi9Var.getItem(this.a)).t());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class j {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-545706620, "Lcom/baidu/tieba/oi9$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-545706620, "Lcom/baidu/tieba/oi9$j;");
                    return;
                }
            }
            int[] iArr = new int[FeedbackButtonStateType.values().length];
            a = iArr;
            try {
                iArr[FeedbackButtonStateType.UNSELECT_POSITIVE_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FeedbackButtonStateType.SELECT_POSITIVE_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FeedbackButtonStateType.UNSELECT_NEGATIVE_STATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FeedbackButtonStateType.SELECT_NEGATIVE_STATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements za<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi9 a;

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public k(oi9 oi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new ConstrainImageLayout(this.a.mContext);
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements za<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public l(oi9 oi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.za
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.za
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class m implements tg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi9 a;

        @Override // com.baidu.tieba.tg9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public m(oi9 oi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi9Var;
        }

        @Override // com.baidu.tieba.tg9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if ((view2 instanceof TbListTextView) && this.a.m != null) {
                        this.a.m.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.d8(false);
                            return true;
                        }
                        return true;
                    }
                    this.a.o.a(view2);
                    this.a.o.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.tg9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.E6() != null && !this.a.b.E6().i2()) || view2.getId() == R.id.obfuscated_res_0x7f090b85)) {
                    return true;
                }
                if (!(view2 instanceof FrameLayout)) {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (!(parent instanceof FrameLayout)) {
                            parent = parent.getParent();
                            i++;
                        } else {
                            this.a.V((FrameLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.V(view2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public n(oi9 oi9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            TBLottieAnimationView tBLottieAnimationView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tBLottieAnimationView = this.a.B0) != null) {
                tBLottieAnimationView.setVisibility(8);
                this.a.B0.pauseAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ pea b;
        public final /* synthetic */ oi9 c;

        public o(oi9 oi9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, pbCommenFloorItemViewHolder, peaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oi9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = peaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.S.getVisibility() == 8 && this.a.D0.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.P(this.a, !z, this.b.O());
                this.b.e1(!z);
                this.c.r0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.E6() != null && this.c.b.E6().F1() != null && this.c.b.E6().m1() != null && !z && this.a.getView().getTop() < this.c.b.E6().F1().getMeasuredHeight()) {
                    this.c.b.E6().m1().setSelectionFromTop(ListUtils.getPosition(this.c.b.E6().m1().getData(), this.b) + this.c.b.E6().m1().getHeaderViewsCount(), this.c.b.E6().F1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Function1<FeedbackButtonStateType, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pea a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbCommenFloorItemViewHolder c;
        public final /* synthetic */ View d;
        public final /* synthetic */ oi9 e;

        public p(oi9 oi9Var, pea peaVar, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, peaVar, Integer.valueOf(i), pbCommenFloorItemViewHolder, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = oi9Var;
            this.a = peaVar;
            this.b = i;
            this.c = pbCommenFloorItemViewHolder;
            this.d = view2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(FeedbackButtonStateType feedbackButtonStateType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, feedbackButtonStateType)) == null) {
                PbFragment pbFragment = this.e.b;
                if (pbFragment == null) {
                    return null;
                }
                pbFragment.D2 = this.a;
                int i = j.a[feedbackButtonStateType.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                this.a.U0(1);
                                this.e.T(this.c, this.a);
                                oi9 oi9Var = this.e;
                                oi9Var.s0(this.c, oi9Var.b.getListView(), this.b);
                                AigcFeedbackHelper.b(this.e.b.getPageContext(), this.a.p());
                                AigcFeedbackHelper.d(this.a);
                                this.e.Y(this.b, this.c, this.a, false, this.d);
                                ng9.b(String.valueOf(this.a.p0()), this.a.U(), false, true);
                            }
                        } else {
                            ng9.e(String.valueOf(this.a.p0()), this.a.U(), this.a.F());
                            this.a.U0(0);
                            AigcFeedbackHelper.b(this.e.b.getPageContext(), this.a.p());
                            this.e.U(this.c, this.a);
                            ng9.b(String.valueOf(this.a.p0()), this.a.U(), false, false);
                        }
                    } else {
                        ng9.e(String.valueOf(this.a.p0()), this.a.U(), this.a.F());
                        this.a.U0(0);
                        AigcFeedbackHelper.a(this.e.b.getPageContext(), this.a.p());
                        this.e.Y(this.b, this.c, this.a, true, this.d);
                        this.e.U(this.c, this.a);
                        ng9.b(String.valueOf(this.a.p0()), this.a.U(), true, true);
                    }
                } else {
                    AigcFeedbackHelper.a(this.e.b.getPageContext(), this.a.p());
                    this.e.Y(this.b, this.c, this.a, false, this.d);
                    ng9.b(String.valueOf(this.a.p0()), this.a.U(), true, false);
                }
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q implements Function0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi9 a;

        public q(oi9 oi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Boolean invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.mContext == null) {
                    return Boolean.TRUE;
                }
                return Boolean.valueOf(!ViewHelper.checkUpIsLogin(this.a.mContext));
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pea a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ oi9 c;

        public r(oi9 oi9Var, pea peaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, peaVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oi9Var;
            this.a = peaVar;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            pea peaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (peaVar = this.a) == null) {
                return;
            }
            ng9.e(String.valueOf(peaVar.p0()), this.a.U(), this.a.F());
            this.a.U0(0);
            this.c.U(this.b, this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oi9(bo9 bo9Var, BdUniqueId bdUniqueId) {
        super(bo9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bo9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bo9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.h = true;
        this.i = 1.0f;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = true;
        this.u = true;
        this.v = false;
        this.w = 0;
        this.x = null;
        this.y = new ya<>(new k(this), 6, 0);
        this.z = new ya<>(new l(this), 12, 0);
        this.A = new tg9(new m(this));
        this.B = false;
        if (bo9Var != null && bo9Var.e0() != null) {
            this.t = bo9Var.e0().r1();
        }
    }

    public void A0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tVar) == null) {
            this.g = tVar;
        }
    }

    public final void L(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.o);
            pbCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.t.setOnTouchListener(new h(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onLongClickListener) == null) {
            this.p = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, zVar) == null) {
            this.n = zVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.j = str;
        }
    }

    public void q(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, ye9Var) == null) {
            this.k = ye9Var;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.s = z;
        }
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.v = z;
        }
    }

    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.r = z;
        }
    }

    public void z0(tg9 tg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, tg9Var) == null) {
            this.o = tg9Var;
        }
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            int i2 = 0;
            if (pbCommenFloorItemViewHolder.Y.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ImageView imageView = pbCommenFloorItemViewHolder.X;
                if (!peaVar.d0) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    public final void l0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048608, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            pbCommenFloorItemViewHolder.h(peaVar.f1148T, peaVar.U(), this.v);
        }
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, pbCommenFloorItemViewHolder, peaVar) == null) {
            TbRichText f0 = peaVar.f0();
            if (f0 != null) {
                f0.isChanged = true;
            }
            pbCommenFloorItemViewHolder.r.setText(f0, true, this.g);
        }
    }

    public final void u0(View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048623, this, view2, i2) != null) || view2 == null) {
            return;
        }
        view2.setOnClickListener(new i(this, i2));
    }

    public final void B0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            xk9.C(pbCommenFloorItemViewHolder.i, this.k, this.j);
            boolean z = true;
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.o, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.y, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.t.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.t.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.h0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.w, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080bbb, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.A, R.drawable.obfuscated_res_0x7f080bbc, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.w.d();
            pbCommenFloorItemViewHolder.u.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.Q, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.N, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.P, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.R, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.U, (int) R.color.CAM_X0107);
            if ((pbCommenFloorItemViewHolder.S.getVisibility() == 8 && pbCommenFloorItemViewHolder.D0.getVisibility() == 8) ? false : false) {
                pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0479);
            } else {
                ye9 ye9Var = this.k;
                if (ye9Var != null && StringUtils.isNull(ye9Var.j())) {
                    pbCommenFloorItemViewHolder.U.setText(this.k.j());
                } else {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06f5);
                }
            }
            pbCommenFloorItemViewHolder.p.P(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.e0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.o0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    public void C0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, peaVar) == null) {
            String str = "#7F66FE";
            if (peaVar.v0() != null) {
                VirtualImageCustomFigure v0 = peaVar.v0();
                pbCommenFloorItemViewHolder.u0.setHeadImageViewResource(v0.getFigureUrl());
                pbCommenFloorItemViewHolder.u0.setTid(peaVar.U());
                pbCommenFloorItemViewHolder.u0.setLocate(fk9.c);
                pbCommenFloorItemViewHolder.u0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(v0.getBackGroundType())) {
                    str = v0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.u0.setHeadImageBackgroundColorResource(v0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(v0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.u0.setHeadImageBackgroundResource(v0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.u0.f(peaVar.t());
                pbCommenFloorItemViewHolder.s0.setVisibility(8);
                pbCommenFloorItemViewHolder.v0.setVisibility(0);
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_id, peaVar.t().getUserId());
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_name, peaVar.t().getUserName());
                pbCommenFloorItemViewHolder.f();
                String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.l0() != null && this.b.l0().getIntent() != null && this.b.l0().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.B && SharedPrefHelper.getInstance().getInt(sharedPrefKeyWithAccount, 0) == 3 && !gm9.c(this.k) && (peaVar.y() == null || !bd9.c())) {
                    this.B = true;
                    pbCommenFloorItemViewHolder.B0.setVisibility(0);
                    pbCommenFloorItemViewHolder.B0.playAnimation();
                    SafeHandler.getInst().postDelayed(new n(this, pbCommenFloorItemViewHolder), 4000L);
                }
            } else {
                pbCommenFloorItemViewHolder.v0.setVisibility(8);
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_id, null);
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.s0.setVisibility(0);
                pbCommenFloorItemViewHolder.B0.setVisibility(8);
                pbCommenFloorItemViewHolder.B0.pauseAnimation();
            }
            if (peaVar.w0() != null && !TextUtils.isEmpty(peaVar.w0().getIcon())) {
                pbCommenFloorItemViewHolder.t0.setData(peaVar.w0(), false, str);
                pbCommenFloorItemViewHolder.t0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.w0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.w0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.w0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_id, peaVar.t().getUserId());
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_name, peaVar.t().getUserName());
                this.w = fk9.d;
                this.x = pbCommenFloorItemViewHolder.t0.getData();
                pbCommenFloorItemViewHolder.u0.setWithBubble(this.w);
                pbCommenFloorItemViewHolder.u0.setBubbleName(this.x);
                pbCommenFloorItemViewHolder.u0.setVirtualHeadUid(peaVar.t().getUserId());
            } else {
                if (pbCommenFloorItemViewHolder.w0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.w0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.w0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.t0.setVisibility(8);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_id, null);
                int i2 = fk9.e;
                this.w = i2;
                pbCommenFloorItemViewHolder.u0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.u0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.u0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (peaVar.v0() != null) {
                fk9.a(2, peaVar.U(), fk9.c, this.w, this.x, peaVar.u());
            }
        }
    }

    public final void M(pea peaVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, peaVar) == null) {
            if (peaVar != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", peaVar.U());
                statisticItem.param("pid", peaVar.U());
                statisticItem.param("tid", peaVar.p0());
                statisticItem.param("fid", peaVar.Q());
                statisticItem.param("fname", peaVar.R());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            ye9 ye9Var = this.k;
            if (ye9Var != null) {
                if (ye9Var.x0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        ye9 ye9Var2 = this.k;
                        int i4 = peaVar.f0;
                        if (peaVar.e0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        xn9.e(uniqueId, ye9Var2, peaVar, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    ye9 ye9Var3 = this.k;
                    int i5 = peaVar.f0;
                    if (peaVar.e0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    xn9.e(uniqueId2, ye9Var3, peaVar, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: p0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07b9, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091b66)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07b1, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.l0().getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.u.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.w;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.u);
                pbCommenFloorItemViewHolder.w.setIsVideoThread(false);
            }
            B0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.r;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.s);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void t0(pea peaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, peaVar) == null) {
            String userId = peaVar.t().getUserId();
            ye9 ye9Var = this.k;
            String str2 = "";
            if (ye9Var == null) {
                str = "";
            } else {
                str = ye9Var.l();
            }
            ye9 ye9Var2 = this.k;
            if (ye9Var2 != null) {
                str2 = ye9Var2.m();
            }
            int L = peaVar.L();
            String U = peaVar.U();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", U);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, L);
            if (peaVar.t().getAlaInfo() != null) {
                AlaInfoData alaInfo = peaVar.t().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void N(pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, peaVar) == null) && peaVar.E == 0 && peaVar.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", peaVar.U());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            bo9 bo9Var = this.a;
            if (bo9Var != null) {
                int r1 = bo9Var.e0().r1();
                if (1 != r1 && 2 != r1) {
                    if (3 == r1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (peaVar.t() != null && peaVar.t().getAlaInfo() != null && peaVar.t().getAlaInfo().live_status == 1) {
                t0(peaVar);
            }
        }
    }

    public final void O(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int equipmentWidth = ((((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (equipmentWidth - i3) - s(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                equipmentWidth /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((equipmentWidth - i3) * this.i));
            tbRichTextView.getLayoutStrategy().q((int) (equipmentWidth * 1.618f * this.i));
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048596, this, pbCommenFloorItemViewHolder, peaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            pbCommenFloorItemViewHolder.B.setVisibility(8);
            pbCommenFloorItemViewHolder.v.setVisibility(0);
            pbCommenFloorItemViewHolder.f0.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.p.setVisibility(8);
            pbCommenFloorItemViewHolder.o0.setVisibility(8);
            xk9.h(pbCommenFloorItemViewHolder, peaVar, view2, i2, this.k, this.j, xk9.s(this.a), R.color.CAM_X0107, xk9.m(this.k, peaVar), this.mContext, true, xk9.y(this.a), xk9.t(this.k));
            xk9.c(pbCommenFloorItemViewHolder, peaVar, this.k);
            d0(pbCommenFloorItemViewHolder, peaVar);
            g0(pbCommenFloorItemViewHolder, peaVar, view2);
            f0(pbCommenFloorItemViewHolder, peaVar, view2, i2);
            xk9.e(pbCommenFloorItemViewHolder, peaVar, this.k, 0);
            j0(pbCommenFloorItemViewHolder, peaVar);
            e0(pbCommenFloorItemViewHolder, peaVar);
            C0(pbCommenFloorItemViewHolder, peaVar);
            k0(pbCommenFloorItemViewHolder, peaVar);
            mh9.j(pbCommenFloorItemViewHolder, peaVar, view2, this.h, this.A);
            i0(pbCommenFloorItemViewHolder, peaVar);
            b0(pbCommenFloorItemViewHolder, peaVar);
            h0(pbCommenFloorItemViewHolder, peaVar);
            l0(pbCommenFloorItemViewHolder, peaVar);
            a0(pbCommenFloorItemViewHolder, peaVar, view2, i2);
            mh9.o(pbCommenFloorItemViewHolder, view2, peaVar, this.r, true);
            mh9.h(pbCommenFloorItemViewHolder, peaVar, this.k, this.mContext);
        }
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.D0.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06f5);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.U.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            pbCommenFloorItemViewHolder.D0.setVisibility(0);
            pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0479);
        }
    }

    public final void R(AigcFeedbackInfo aigcFeedbackInfo, pea peaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048585, this, aigcFeedbackInfo, peaVar, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        W(pbCommenFloorItemViewHolder);
        if (peaVar != null && aigcFeedbackInfo != null && peaVar.y0()) {
            int F = peaVar.F();
            if (F != 1) {
                if (F != 2) {
                    U(pbCommenFloorItemViewHolder, peaVar);
                } else {
                    S(pbCommenFloorItemViewHolder, peaVar);
                }
            } else {
                T(pbCommenFloorItemViewHolder, peaVar);
            }
            if (!TextUtils.isEmpty(aigcFeedbackInfo.feedback_fold_tip)) {
                str = aigcFeedbackInfo.feedback_fold_tip;
            } else {
                str = "";
            }
            pbCommenFloorItemViewHolder.G0.a(str);
            pbCommenFloorItemViewHolder.G0.setOnClickFoldListener(new r(this, peaVar, pbCommenFloorItemViewHolder));
        }
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, BdTypeListView bdTypeListView, int i2) {
        int firstVisiblePosition;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048621, this, pbCommenFloorItemViewHolder, bdTypeListView, i2) == null) && pbCommenFloorItemViewHolder != null && bdTypeListView != null && (firstVisiblePosition = bdTypeListView.getFirstVisiblePosition()) == i2 + bdTypeListView.getHeaderViewsCount()) {
            bdTypeListView.setSelectionFromTop(firstVisiblePosition, (((pbCommenFloorItemViewHolder.c.getTop() - pbCommenFloorItemViewHolder.G0.getMeasuredHeight()) + pbCommenFloorItemViewHolder.S.getMeasuredHeight()) + pbCommenFloorItemViewHolder.D0.getMeasuredHeight()) - BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146));
        }
    }

    public final void Q(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, peaVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.J) != null && pbCommenFloorItemViewHolder.f1141T != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.f1141T.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = true;
            boolean z3 = !ListUtils.isEmpty(peaVar.j0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.f1141T.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(0);
                if (z3) {
                    pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.f1141T.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
                }
            } else {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
                if (layoutParams != null) {
                    layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds14);
                    pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
                }
            }
            if (pbCommenFloorItemViewHolder.t0.getVisibility() != 0 && pbCommenFloorItemViewHolder.A0.getVisibility() != 0) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
            cta.b(peaVar, pbCommenFloorItemViewHolder.r, (TextUtils.isEmpty(peaVar.v()) || !this.h) ? false : false);
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            pbCommenFloorItemViewHolder.S.setVisibility(8);
            pbCommenFloorItemViewHolder.G0.setVisibility(0);
            pbCommenFloorItemViewHolder.D0.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.D0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.E0.getLayoutParams();
            layoutParams.topMargin = 0;
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (peaVar.H0(false)) {
                i2 = R.dimen.tbds48;
            } else {
                i2 = R.dimen.tbds25;
            }
            layoutParams.bottomMargin = BdUtilHelper.getDimens(inst, i2);
            layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            ng9.f(String.valueOf(peaVar.p0()), peaVar.U(), peaVar.F());
        }
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && peaVar != null && peaVar.p() != null) {
            peaVar.p().threadId = this.a.e0().M1();
            peaVar.p().objType = 1;
            peaVar.p().isInPost = true;
            ThreadData threadData = null;
            ye9 ye9Var = this.k;
            if (ye9Var != null && ye9Var.O() != null) {
                threadData = this.k.O();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.p.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.p.setThreadData(threadData);
            pbCommenFloorItemViewHolder.p.setData(peaVar.p());
            pbCommenFloorItemViewHolder.d0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.d0.setData(peaVar.p());
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, pbCommenFloorItemViewHolder, peaVar) == null) {
            if (peaVar != null && peaVar.t() != null && peaVar.m0() != null) {
                TbRichText f0 = peaVar.f0();
                if (f0 != null && StringUtils.isNull(f0.toString()) && StringUtils.isNull(peaVar.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (peaVar.t().getSmallTailThemeData() != null) {
                    str = peaVar.t().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.L.setTag(R.id.tag_pb_small_tail_theme_id, str);
                mo9.c(peaVar.m0(), pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, pbCommenFloorItemViewHolder.M, false, false, z, peaVar.t().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.K.setVisibility(8);
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            pbCommenFloorItemViewHolder.S.setVisibility(8);
            pbCommenFloorItemViewHolder.G0.setVisibility(0);
            pbCommenFloorItemViewHolder.D0.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.D0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_10);
            }
            ng9.f(String.valueOf(peaVar.p0()), peaVar.U(), peaVar.F());
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            pbCommenFloorItemViewHolder.G0.setVisibility(8);
            pbCommenFloorItemViewHolder.D0.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.D0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.E0.getLayoutParams();
            layoutParams.topMargin = 0;
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (peaVar.H0(false)) {
                i2 = R.dimen.tbds48;
            } else {
                i2 = R.dimen.tbds25;
            }
            layoutParams.bottomMargin = BdUtilHelper.getDimens(inst, i2);
            layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            r0(pbCommenFloorItemViewHolder, peaVar);
        }
    }

    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.Q != null && pbCommenFloorItemViewHolder.N != null) {
            if (peaVar != null && (alaLiveInfoCoreData = peaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.Q.setText(peaVar.U.liveTitle);
                pbCommenFloorItemViewHolder.N.setTag(peaVar.U);
                pbCommenFloorItemViewHolder.N.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbCommenFloorItemViewHolder.N.setVisibility(8);
        }
    }

    public final void k0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, pbCommenFloorItemViewHolder, peaVar) == null) {
            if (peaVar.P() != 2 && peaVar.P() != 4) {
                pbCommenFloorItemViewHolder.f1141T.setVisibility(8);
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                pbCommenFloorItemViewHolder.D0.setVisibility(0);
                Q(false, pbCommenFloorItemViewHolder, peaVar);
            } else {
                pbCommenFloorItemViewHolder.f1141T.setOnClickListener(new o(this, pbCommenFloorItemViewHolder, peaVar));
                pbCommenFloorItemViewHolder.f1141T.setVisibility(0);
                P(pbCommenFloorItemViewHolder, peaVar.E0(), peaVar.O());
                Q(true, pbCommenFloorItemViewHolder, peaVar);
            }
            r0(pbCommenFloorItemViewHolder, peaVar);
        }
    }

    public final void V(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).d0) != null && agreeView.getData() != null && !m0(pbCommenFloorItemViewHolder.r)) {
            pbCommenFloorItemViewHolder.d0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.d0.N();
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        pbCommenFloorItemViewHolder.S.setVisibility(0);
        pbCommenFloorItemViewHolder.G0.setVisibility(8);
        pbCommenFloorItemViewHolder.D0.setVisibility(0);
        ((LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.D0.getLayoutParams()).bottomMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        ((RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.E0.getLayoutParams()).topMargin = 0;
    }

    public final void Z(pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, peaVar) == null) && peaVar != null) {
            int i2 = 8;
            if (peaVar.e0) {
                i2 = 2;
            }
            StatisticItem k2 = xn9.k(this.k, peaVar, peaVar.f0, i2, 6);
            peaVar.g0 = k2;
            if (!ListUtils.isEmpty(peaVar.j0())) {
                Iterator<pea> it = peaVar.j0().iterator();
                while (it.hasNext()) {
                    it.next().g0 = k2;
                }
            }
        }
    }

    public final boolean m0(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            pea peaVar = null;
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return false;
            }
            if (sparseArray.get(R.id.tag_clip_board) instanceof pea) {
                peaVar = (pea) sparseArray.get(R.id.tag_clip_board);
            }
            if (peaVar == null) {
                return false;
            }
            return peaVar.B0();
        }
        return invokeL.booleanValue;
    }

    public final String n0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            Object obj = "1";
            if (sparseArray == null) {
                return "1";
            }
            Object obj2 = sparseArray.get(R.id.pb_track_more_obj_source);
            if (obj2 != null) {
                obj = obj2;
            }
            sparseArray.remove(R.id.pb_track_more_obj_source);
            view2.setTag(sparseArray);
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public void o0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    public final void Y(int i2, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar, boolean z, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), pbCommenFloorItemViewHolder, peaVar, Boolean.valueOf(z), view2}) != null) || !UtilHelper.isCurrentAccount(this.k.O().getAuthor().getUserId()) || !this.k.O().isQuestionThread() || UtilHelper.isCurrentAccount(((pea) getItem(i2)).t().getUserId())) {
            return;
        }
        if (z) {
            ((pea) getItem(i2)).i1(1);
            pbCommenFloorItemViewHolder.y0.setVisibility(0);
            ((pea) getItem(i2)).b1(true);
            pbCommenFloorItemViewHolder.i.setVisibility(8);
            pbCommenFloorItemViewHolder.d0.postDelayed(new g(this, i2, peaVar, pbCommenFloorItemViewHolder), 900L);
        } else {
            ((pea) getItem(i2)).i1(0);
            if (!peaVar.y0()) {
                pbCommenFloorItemViewHolder.z0.setVisibility(8);
                pbCommenFloorItemViewHolder.e0.setVisibility(0);
                xk9.B(pbCommenFloorItemViewHolder, peaVar);
            }
            pbCommenFloorItemViewHolder.y0.setVisibility(8);
            ((pea) getItem(i2)).b1(false);
            if (((pea) getItem(i2)).h0().booleanValue()) {
                pbCommenFloorItemViewHolder.i.setVisibility(0);
            }
        }
        xk9.h(pbCommenFloorItemViewHolder, peaVar, view2, i2, this.k, this.j, xk9.s(this.a), R.color.CAM_X0107, xk9.m(this.k, peaVar), this.mContext, true, xk9.y(this.a), xk9.t(this.k));
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048593, this, pbCommenFloorItemViewHolder, peaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            R(peaVar.r(), peaVar, pbCommenFloorItemViewHolder);
            xk9.B(pbCommenFloorItemViewHolder, peaVar);
            if (!peaVar.y0()) {
                pbCommenFloorItemViewHolder.F0.setVisibility(8);
                pbCommenFloorItemViewHolder.z0.setVisibility(8);
                pbCommenFloorItemViewHolder.e0.setVisibility(0);
                return;
            }
            pbCommenFloorItemViewHolder.d0.setVisibility(8);
            pbCommenFloorItemViewHolder.F0.setVisibility(0);
            pbCommenFloorItemViewHolder.z0.setVisibility(0);
            u0(pbCommenFloorItemViewHolder.z0, i2);
            pbCommenFloorItemViewHolder.e0.setVisibility(8);
            pbCommenFloorItemViewHolder.F0.b(new hg9(peaVar, new p(this, peaVar, i2, pbCommenFloorItemViewHolder, view2), new q(this)));
        }
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048601, this, pbCommenFloorItemViewHolder, peaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            if (peaVar.l0() > 0) {
                pbCommenFloorItemViewHolder.y.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.y.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, peaVar);
                if (peaVar.P() == 2) {
                    pbCommenFloorItemViewHolder.y.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.y.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            }
            ImageView imageView = pbCommenFloorItemViewHolder.z;
            if (imageView != null) {
                SparseArray sparseArray2 = (SparseArray) imageView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, peaVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.A;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.A.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, peaVar);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            if (!peaVar.A0() && !peaVar.z0(false)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.w.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.w.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.w.getLayoutParams();
                layoutParams2.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams2.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.w.setLayoutParams(layoutParams2);
                if (this.q == null) {
                    gn9 gn9Var = new gn9(this.mContext);
                    this.q = gn9Var;
                    gn9Var.f(this.e);
                    this.q.h(this.l);
                    this.q.e(this.m);
                    String str = null;
                    ye9 ye9Var = this.k;
                    if (ye9Var != null && ye9Var.O() != null && this.k.O().getAuthor() != null) {
                        str = this.k.O().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    ye9 ye9Var2 = this.k;
                    if (ye9Var2 != null) {
                        this.q.j(ye9Var2.W(), z);
                        this.q.i(this.k.O());
                    }
                }
                this.q.g(peaVar.U());
                pbCommenFloorItemViewHolder.w.setSubPbAdapter(this.q);
                pbCommenFloorItemViewHolder.w.setVisibility(0);
                pbCommenFloorItemViewHolder.w.setData(peaVar, view2);
                pbCommenFloorItemViewHolder.w.setChildOnClickListener(this.m);
                pbCommenFloorItemViewHolder.w.setChildOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.w.setChildOnTouchListener(this.A);
            }
            if (peaVar.P) {
                pbCommenFloorItemViewHolder.J.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.J.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
            layoutParams3.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.x.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.v.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.h0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1258));
        }
    }

    public final void g0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048602, this, pbCommenFloorItemViewHolder, peaVar, view2) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
            if (!this.h) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.r.p0(null);
                pbCommenFloorItemViewHolder.r.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().z(R.drawable.pic_video);
            O(pbCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(peaVar.v()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.r.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.r.setTid(this.k.Q());
            pbCommenFloorItemViewHolder.r.setPid(peaVar.U());
            pbCommenFloorItemViewHolder.r.setPosition(TbRichTextView.Position.PB_COMMENT_FLOOR);
            pbCommenFloorItemViewHolder.r.setText(peaVar.f0(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, peaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            sparseArray.put(R.id.tag_is_top_question, Boolean.FALSE);
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.o0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.e0.setTag(sparseArray);
        }
    }

    public final void h0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            bo9 bo9Var = this.a;
            if (bo9Var != null && bo9Var.e0() != null && StringHelper.equals(this.a.e0().T0(), peaVar.U())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048604, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            String g0 = peaVar.g0();
            if (!StringUtils.isNull(g0)) {
                pbCommenFloorItemViewHolder.Y.startLoad(g0, 10, false);
                pbCommenFloorItemViewHolder.Y.setVisibility(0);
                pbCommenFloorItemViewHolder.X.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.Y.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qi9, com.baidu.tieba.lh
    /* renamed from: q0 */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, pea peaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, peaVar, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) peaVar, (pea) pbCommenFloorItemViewHolder);
            B0(pbCommenFloorItemViewHolder);
            w0(pbCommenFloorItemViewHolder, i2, peaVar, view2);
            L(pbCommenFloorItemViewHolder);
            pea peaVar2 = (pea) getItem(i2);
            if (peaVar2 != null) {
                peaVar2.f0 = i2 + 1;
                N(peaVar2);
                M(peaVar2);
                peaVar2.C1();
                Z(peaVar2);
                c0(pbCommenFloorItemViewHolder, peaVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void w0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, pea peaVar, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048625, this, pbCommenFloorItemViewHolder, i2, peaVar, view2) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.p);
            if (this.a.l0() != null && this.a.l0().getPageContext() != null && this.a.l0().getPageContext().getOrignalPage() != null) {
                nl9 nl9Var = this.a.l0().c;
                pbCommenFloorItemViewHolder.g.setOnClickListener(nl9Var.b);
                pbCommenFloorItemViewHolder.q.setOnClickListener(nl9Var.b);
                pbCommenFloorItemViewHolder.u0.setOnClickListener(nl9Var.d);
                pbCommenFloorItemViewHolder.t0.setOnClickListener(nl9Var.d);
                pbCommenFloorItemViewHolder.F.setOnClickListener(nl9Var.b);
                pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(nl9Var.b);
                pbCommenFloorItemViewHolder.r.setOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.r.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(this.m);
                pbCommenFloorItemViewHolder.r.setOnImageClickListener(this.n);
                pbCommenFloorItemViewHolder.r.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.r.setOnEmotionClickListener(nl9Var.f);
                pbCommenFloorItemViewHolder.r.setOnVoiceAfterClickListener(this.m);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.L.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.N.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.i0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.m0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.m0.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.E.setOnClickListener(new a(this, peaVar));
                pbCommenFloorItemViewHolder.e0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.o0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.f0.setOnClickListener(new b(this, pbCommenFloorItemViewHolder));
                pl9 pl9Var = this.a.l0().d;
                pbCommenFloorItemViewHolder.z.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.A.setOnClickListener(new c(this, pbCommenFloorItemViewHolder, pl9Var));
                pbCommenFloorItemViewHolder.p.D = new d(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.d0.D = new e(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.d0.setAfterClickListener(new f(this, pbCommenFloorItemViewHolder, i2, peaVar, view2));
            }
        }
    }
}
