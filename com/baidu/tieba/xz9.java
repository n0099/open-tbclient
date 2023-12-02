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
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.feedback.AigcFeedbackHelper;
import com.baidu.tieba.pb.feedback.FeedbackButtonStateType;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.underlayer.StatOnceSet;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.tx9;
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
import tbclient.ChatContent;
/* loaded from: classes9.dex */
public class xz9 extends zz9<mwa, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pb<TbImageView> A;
    public tx9 B;
    public TbRichTextView.t g;
    public boolean h;
    public float i;
    public String j;
    public zv9 k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public TbRichTextView.z n;
    public tx9 o;
    public View.OnLongClickListener p;
    public k5a q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public final StatOnceSet<String> y;
    public pb<ConstrainImageLayout> z;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ b3a b;
        public final /* synthetic */ xz9 c;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mwa a;
            public final /* synthetic */ b b;

            public a(b bVar, mwa mwaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, mwaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = mwaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.b;
                    bVar.b.b.a(bVar.c.k, null, this.a, bVar.a.r.getLayoutStrategy());
                }
            }
        }

        public b(xz9 xz9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b3a b3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, pbCommenFloorItemViewHolder, b3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = b3aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            mwa mwaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof mwa) && (mwaVar = (mwa) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                SafeHandler.getInst().postDelayed(new a(this, mwaVar), 100L);
                String T2 = this.c.k.T();
                if ((StringUtils.isNull(T2) || "0".equals(this.c.k.T())) && this.c.k.R() != null) {
                    T2 = this.c.k.R().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", T2).param("fid", this.c.k.o()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", mwaVar.U()).param("obj_source", this.c.n0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ mwa b;
        public final /* synthetic */ PbCommenFloorItemViewHolder c;
        public final /* synthetic */ xz9 d;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.a;
                    if (fVar.d.getItem(fVar.a) instanceof mwa) {
                        f fVar2 = this.a;
                        mwa mwaVar = (mwa) fVar2.d.getItem(fVar2.a);
                        mwaVar.Q0();
                        if (mwaVar.e0() <= 0 && !this.a.b.z0()) {
                            mwaVar.k1(Boolean.FALSE);
                            this.a.c.z0.setVisibility(8);
                            f fVar3 = this.a;
                            j2a.v(fVar3.c, fVar3.b);
                            this.a.c.e0.setVisibility(0);
                        }
                    }
                }
            }
        }

        public f(xz9 xz9Var, int i, mwa mwaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, Integer.valueOf(i), mwaVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xz9Var;
            this.a = i;
            this.b = mwaVar;
            this.c = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((mwa) this.d.getItem(this.a)).P0();
                if (!this.b.z0()) {
                    ((mwa) this.d.getItem(this.a)).k1(Boolean.TRUE);
                    this.c.d0.setVisibility(8);
                    this.c.e0.setVisibility(8);
                    this.c.z0.setVisibility(0);
                    this.d.u0(this.c.z0, this.a);
                }
                this.c.z0.postDelayed(new a(this), 5000L);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public a(xz9 xz9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, pbCommenFloorItemViewHolder};
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

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ xz9 b;

        public c(xz9 xz9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz9Var;
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
                String T2 = this.b.k.T();
                if ((StringUtils.isNull(T2) || "0".equals(this.b.k.T())) && this.b.k.R() != null) {
                    T2 = this.b.k.R().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", T2).param("fid", this.b.k.o()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.p.getData().postId).param("obj_source", this.b.n0(this.a.p)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ xz9 b;

        public d(xz9 xz9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz9Var;
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
                String T2 = this.b.k.T();
                if ((StringUtils.isNull(T2) || "0".equals(this.b.k.T())) && this.b.k.R() != null) {
                    T2 = this.b.k.R().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", T2).param("fid", this.b.k.o()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId).param("obj_source", this.b.n0(this.a.d0)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ mwa c;
        public final /* synthetic */ View d;
        public final /* synthetic */ xz9 e;

        public e(xz9 xz9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i, mwa mwaVar, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, pbCommenFloorItemViewHolder, Integer.valueOf(i), mwaVar, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xz9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = i;
            this.c = mwaVar;
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

    /* loaded from: classes9.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public g(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
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

    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ xz9 b;

        public h(xz9 xz9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz9Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                b6a.w("c14886");
                if (this.b.getItem(this.a) instanceof mwa) {
                    mwa mwaVar = (mwa) this.b.getItem(this.a);
                    ChatContent B = mwaVar.B();
                    if (B != null && !TextUtils.isEmpty(B.scheme)) {
                        UrlManager.getInstance().dealOneLink(mwaVar.B().scheme);
                        return;
                    }
                    xz9 xz9Var = this.b;
                    xz9Var.o0(((mwa) xz9Var.getItem(this.a)).u());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class i {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-272344435, "Lcom/baidu/tieba/xz9$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-272344435, "Lcom/baidu/tieba/xz9$i;");
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

    /* loaded from: classes9.dex */
    public class j implements qb<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

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

        public j(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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

    /* loaded from: classes9.dex */
    public class k implements qb<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public k(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.qb
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qb
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
        @Override // com.baidu.tieba.qb
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

    /* loaded from: classes9.dex */
    public class l implements tx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        @Override // com.baidu.tieba.tx9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public l(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // com.baidu.tieba.tx9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if ((view2 instanceof TbListTextView) && this.a.m != null) {
                        this.a.m.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.J8(false);
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

        @Override // com.baidu.tieba.tx9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.i7() != null && !this.a.b.i7().a2()) || view2.getId() == R.id.obfuscated_res_0x7f090bc7)) {
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
                            this.a.W((FrameLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.W(view2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ mwa b;
        public final /* synthetic */ xz9 c;

        public m(xz9 xz9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, pbCommenFloorItemViewHolder, mwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = mwaVar;
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
                this.c.Q(this.a, !z, this.b.O());
                this.b.h1(!z);
                this.c.r0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.i7() != null && this.c.b.i7().t1() != null && this.c.b.i7().Z0() != null && !z && this.a.getView().getTop() < this.c.b.i7().t1().getMeasuredHeight()) {
                    this.c.b.i7().Z0().setSelectionFromTop(ListUtils.getPosition(this.c.b.i7().Z0().getData(), this.b) + this.c.b.i7().Z0().getHeaderViewsCount(), this.c.b.i7().t1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements Function1<FeedbackButtonStateType, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mwa a;
        public final /* synthetic */ int b;
        public final /* synthetic */ PbCommenFloorItemViewHolder c;
        public final /* synthetic */ View d;
        public final /* synthetic */ xz9 e;

        public n(xz9 xz9Var, mwa mwaVar, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, mwaVar, Integer.valueOf(i), pbCommenFloorItemViewHolder, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xz9Var;
            this.a = mwaVar;
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
                int i = i.a[feedbackButtonStateType.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                this.a.X0(1);
                                this.e.U(this.c, this.a);
                                xz9 xz9Var = this.e;
                                xz9Var.s0(this.c, xz9Var.b.getListView(), this.b);
                                AigcFeedbackHelper.b(this.e.b.getPageContext(), this.a.p());
                                AigcFeedbackHelper.d(this.a);
                                this.e.Y(this.b, this.c, this.a, false, this.d);
                                nx9.b(String.valueOf(this.a.q0()), this.a.U(), false, true);
                            }
                        } else {
                            nx9.e(String.valueOf(this.a.q0()), this.a.U(), this.a.F());
                            this.a.X0(0);
                            AigcFeedbackHelper.b(this.e.b.getPageContext(), this.a.p());
                            this.e.V(this.c, this.a);
                            nx9.b(String.valueOf(this.a.q0()), this.a.U(), false, false);
                        }
                    } else {
                        nx9.e(String.valueOf(this.a.q0()), this.a.U(), this.a.F());
                        this.a.X0(0);
                        AigcFeedbackHelper.a(this.e.b.getPageContext(), this.a.p());
                        this.e.Y(this.b, this.c, this.a, true, this.d);
                        this.e.V(this.c, this.a);
                        nx9.b(String.valueOf(this.a.q0()), this.a.U(), true, true);
                    }
                } else {
                    AigcFeedbackHelper.a(this.e.b.getPageContext(), this.a.p());
                    this.e.Y(this.b, this.c, this.a, false, this.d);
                    nx9.b(String.valueOf(this.a.q0()), this.a.U(), true, false);
                }
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class o implements Function0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public o(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
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

    /* loaded from: classes9.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mwa a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ xz9 c;

        public p(xz9 xz9Var, mwa mwaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, mwaVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz9Var;
            this.a = mwaVar;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            mwa mwaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (mwaVar = this.a) == null) {
                return;
            }
            nx9.e(String.valueOf(mwaVar.q0()), this.a.U(), this.a.F());
            this.a.X0(0);
            this.c.V(this.b, this.a);
        }
    }

    /* loaded from: classes9.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mwa a;
        public final /* synthetic */ xz9 b;

        public q(xz9 xz9Var, mwa mwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, mwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz9Var;
            this.a = mwaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                mwa mwaVar = this.a;
                if (mwaVar != null && mwaVar.u() != null) {
                    av5.d(this.b.k.o(), this.a.u().getPortrait(), "3", this.b.b.getContext());
                }
                bv5.c("c15281", this.b.k.o(), "3");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xz9(h6a h6aVar, BdUniqueId bdUniqueId) {
        super(h6aVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h6aVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((h6a) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.y = new StatOnceSet<>();
        this.z = new pb<>(new j(this), 6, 0);
        this.A = new pb<>(new k(this), 12, 0);
        this.B = new tx9(new l(this));
        if (h6aVar != null && h6aVar.l0() != null) {
            this.t = h6aVar.l0().r1();
        }
    }

    public void A0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tVar) == null) {
            this.g = tVar;
        }
    }

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.o);
            pbCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.t.setOnTouchListener(new g(this));
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

    public void o(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, zVar) == null) {
            this.n = zVar;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.j = str;
        }
    }

    public void s(zv9 zv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, zv9Var) == null) {
            this.k = zv9Var;
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

    public void z0(tx9 tx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, tx9Var) == null) {
            this.o = tx9Var;
        }
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, mwaVar) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            int i2 = 0;
            if (pbCommenFloorItemViewHolder.Y.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ImageView imageView = pbCommenFloorItemViewHolder.X;
                if (!mwaVar.f0) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    public final void l0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048608, this, pbCommenFloorItemViewHolder, mwaVar) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            pbCommenFloorItemViewHolder.f(mwaVar.f1127T, mwaVar.U(), this.v);
        }
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, pbCommenFloorItemViewHolder, mwaVar) == null) {
            TbRichText f0 = mwaVar.f0();
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
        view2.setOnClickListener(new h(this, i2));
    }

    public final void B0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            j2a.w(pbCommenFloorItemViewHolder.i, this.k, this.j);
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
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080bd4, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.A, R.drawable.obfuscated_res_0x7f080bd5, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.w.d();
            pbCommenFloorItemViewHolder.u.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.Q, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.N, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.P, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.R, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.U, (int) R.color.CAM_X0107);
            if ((pbCommenFloorItemViewHolder.S.getVisibility() == 8 && pbCommenFloorItemViewHolder.D0.getVisibility() == 8) ? false : false) {
                pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0483);
            } else {
                zv9 zv9Var = this.k;
                if (zv9Var != null && StringUtils.isNull(zv9Var.m())) {
                    pbCommenFloorItemViewHolder.U.setText(this.k.m());
                } else {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06ff);
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

    public void C0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, mwaVar) == null) {
            String str = "#7F66FE";
            if (mwaVar.w0() != null) {
                VirtualImageCustomFigure w0 = mwaVar.w0();
                pbCommenFloorItemViewHolder.u0.setHeadImageViewResource(w0.getFigureUrl());
                pbCommenFloorItemViewHolder.u0.setTid(mwaVar.U());
                pbCommenFloorItemViewHolder.u0.setLocate(p1a.c);
                pbCommenFloorItemViewHolder.u0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(w0.getBackGroundType())) {
                    str = w0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.u0.setHeadImageBackgroundColorResource(w0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(w0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.u0.setHeadImageBackgroundResource(w0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.u0.f(mwaVar.u());
                pbCommenFloorItemViewHolder.s0.setVisibility(8);
                pbCommenFloorItemViewHolder.v0.setVisibility(0);
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_id, mwaVar.u().getUserId());
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_name, mwaVar.u().getUserName());
            } else {
                pbCommenFloorItemViewHolder.v0.setVisibility(8);
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_id, null);
                pbCommenFloorItemViewHolder.u0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.s0.setVisibility(0);
            }
            if (mwaVar.x0() != null && !TextUtils.isEmpty(mwaVar.x0().getIcon())) {
                pbCommenFloorItemViewHolder.t0.setData(mwaVar.x0(), false, str);
                pbCommenFloorItemViewHolder.t0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.w0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.w0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.w0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_id, mwaVar.u().getUserId());
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_name, mwaVar.u().getUserName());
                this.w = p1a.d;
                this.x = pbCommenFloorItemViewHolder.t0.getData();
                pbCommenFloorItemViewHolder.u0.setWithBubble(this.w);
                pbCommenFloorItemViewHolder.u0.setBubbleName(this.x);
                pbCommenFloorItemViewHolder.u0.setVirtualHeadUid(mwaVar.u().getUserId());
            } else {
                if (pbCommenFloorItemViewHolder.w0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.w0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.w0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.t0.setVisibility(8);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.tag_user_id, null);
                int i2 = p1a.e;
                this.w = i2;
                pbCommenFloorItemViewHolder.u0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.u0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.u0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (mwaVar.w0() != null) {
                p1a.a(2, mwaVar.U(), p1a.c, this.w, this.x, mwaVar.v());
            }
        }
    }

    public final void N(mwa mwaVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mwaVar) == null) {
            if (mwaVar != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", mwaVar.U());
                statisticItem.param("pid", mwaVar.U());
                statisticItem.param("tid", mwaVar.q0());
                statisticItem.param("fid", mwaVar.Q());
                statisticItem.param("fname", mwaVar.R());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            zv9 zv9Var = this.k;
            if (zv9Var != null) {
                if (zv9Var.y0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        zv9 zv9Var2 = this.k;
                        int i4 = mwaVar.h0;
                        if (mwaVar.g0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        b6a.e(uniqueId, zv9Var2, mwaVar, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    zv9 zv9Var3 = this.k;
                    int i5 = mwaVar.h0;
                    if (mwaVar.g0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    b6a.e(uniqueId2, zv9Var3, mwaVar, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: p0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07e9, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091c24)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07e1, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.u0().getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.z);
            pbCommenFloorItemViewHolder.u.setImageViewPool(this.A);
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

    public final void t0(mwa mwaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, mwaVar) == null) {
            String userId = mwaVar.u().getUserId();
            zv9 zv9Var = this.k;
            String str2 = "";
            if (zv9Var == null) {
                str = "";
            } else {
                str = zv9Var.o();
            }
            zv9 zv9Var2 = this.k;
            if (zv9Var2 != null) {
                str2 = zv9Var2.p();
            }
            int L = mwaVar.L();
            String U = mwaVar.U();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", U);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, L);
            if (mwaVar.u().getAlaInfo() != null) {
                AlaInfoData alaInfo = mwaVar.u().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void O(mwa mwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mwaVar) == null) && mwaVar.E == 0 && mwaVar.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", mwaVar.U());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            h6a h6aVar = this.a;
            if (h6aVar != null) {
                int r1 = h6aVar.l0().r1();
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
            if (mwaVar.u() != null && mwaVar.u().getAlaInfo() != null && mwaVar.u().getAlaInfo().live_status == 1) {
                t0(mwaVar);
            }
        }
    }

    public final void P(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int equipmentWidth = ((((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = t(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (equipmentWidth - i3) - t(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                equipmentWidth /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((equipmentWidth - i3) * this.i));
            tbRichTextView.getLayoutStrategy().q((int) (equipmentWidth * 1.618f * this.i));
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048596, this, pbCommenFloorItemViewHolder, mwaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            pbCommenFloorItemViewHolder.B.setVisibility(8);
            pbCommenFloorItemViewHolder.v.setVisibility(0);
            pbCommenFloorItemViewHolder.f0.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.p.setVisibility(8);
            pbCommenFloorItemViewHolder.o0.setVisibility(8);
            i2a.b(pbCommenFloorItemViewHolder, mwaVar, view2, i2, this.k, this.j, j2a.m(this.a), R.color.CAM_X0107, j2a.g(this.k, mwaVar), this.mContext, true, j2a.s(this.a), j2a.n(this.k));
            j2a.c(pbCommenFloorItemViewHolder, mwaVar, this.k);
            d0(pbCommenFloorItemViewHolder, mwaVar);
            g0(pbCommenFloorItemViewHolder, mwaVar, view2);
            f0(pbCommenFloorItemViewHolder, mwaVar, view2, i2);
            j2a.e(pbCommenFloorItemViewHolder, mwaVar, this.k, 0);
            j0(pbCommenFloorItemViewHolder, mwaVar);
            e0(pbCommenFloorItemViewHolder, mwaVar);
            C0(pbCommenFloorItemViewHolder, mwaVar);
            k0(pbCommenFloorItemViewHolder, mwaVar);
            my9.j(pbCommenFloorItemViewHolder, mwaVar, view2, this.h, this.B);
            i0(pbCommenFloorItemViewHolder, mwaVar);
            b0(pbCommenFloorItemViewHolder, mwaVar);
            h0(pbCommenFloorItemViewHolder, mwaVar);
            l0(pbCommenFloorItemViewHolder, mwaVar);
            a0(pbCommenFloorItemViewHolder, mwaVar, view2, i2);
            c4a.d(pbCommenFloorItemViewHolder, mwaVar, this.m, this.y);
            my9.h(pbCommenFloorItemViewHolder, mwaVar, this.k, this.mContext);
            my9.o(pbCommenFloorItemViewHolder, view2, mwaVar, this.r, true);
        }
    }

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.D0.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06ff);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.U.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            pbCommenFloorItemViewHolder.D0.setVisibility(0);
            pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0483);
        }
    }

    public final void S(AigcFeedbackInfo aigcFeedbackInfo, mwa mwaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048585, this, aigcFeedbackInfo, mwaVar, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        X(pbCommenFloorItemViewHolder);
        if (mwaVar != null && aigcFeedbackInfo != null && mwaVar.z0()) {
            int F = mwaVar.F();
            if (F != 1) {
                if (F != 2) {
                    V(pbCommenFloorItemViewHolder, mwaVar);
                } else {
                    T(pbCommenFloorItemViewHolder, mwaVar);
                }
            } else {
                U(pbCommenFloorItemViewHolder, mwaVar);
            }
            if (!TextUtils.isEmpty(aigcFeedbackInfo.feedback_fold_tip)) {
                str = aigcFeedbackInfo.feedback_fold_tip;
            } else {
                str = "";
            }
            pbCommenFloorItemViewHolder.G0.a(str);
            pbCommenFloorItemViewHolder.G0.setOnClickFoldListener(new p(this, mwaVar, pbCommenFloorItemViewHolder));
        }
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, BdTypeListView bdTypeListView, int i2) {
        int firstVisiblePosition;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048621, this, pbCommenFloorItemViewHolder, bdTypeListView, i2) == null) && pbCommenFloorItemViewHolder != null && bdTypeListView != null && (firstVisiblePosition = bdTypeListView.getFirstVisiblePosition()) == i2 + bdTypeListView.getHeaderViewsCount()) {
            bdTypeListView.setSelectionFromTop(firstVisiblePosition, (((pbCommenFloorItemViewHolder.c.getTop() - pbCommenFloorItemViewHolder.G0.getMeasuredHeight()) + pbCommenFloorItemViewHolder.S.getMeasuredHeight()) + pbCommenFloorItemViewHolder.D0.getMeasuredHeight()) - BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146));
        }
    }

    public final void R(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, mwaVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.J) != null && pbCommenFloorItemViewHolder.f1135T != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.f1135T.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = true;
            boolean z3 = !ListUtils.isEmpty(mwaVar.k0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.f1135T.getLayoutParams();
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
                pbCommenFloorItemViewHolder.f1135T.setLayoutParams(layoutParams2);
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
            if (pbCommenFloorItemViewHolder.t0.getVisibility() != 0 && pbCommenFloorItemViewHolder.B0.getVisibility() != 0) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().k(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
            zab.b(mwaVar, pbCommenFloorItemViewHolder.r, (TextUtils.isEmpty(mwaVar.x()) || !this.h) ? false : false);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, mwaVar) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            pbCommenFloorItemViewHolder.S.setVisibility(8);
            pbCommenFloorItemViewHolder.G0.setVisibility(0);
            pbCommenFloorItemViewHolder.D0.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.D0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.E0.getLayoutParams();
            layoutParams.topMargin = 0;
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (mwaVar.L0(false)) {
                i2 = R.dimen.tbds48;
            } else {
                i2 = R.dimen.tbds25;
            }
            layoutParams.bottomMargin = BdUtilHelper.getDimens(inst, i2);
            layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            nx9.f(String.valueOf(mwaVar.q0()), mwaVar.U(), mwaVar.F());
        }
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, pbCommenFloorItemViewHolder, mwaVar) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null && mwaVar.p() != null) {
            mwaVar.p().threadId = this.a.l0().M1();
            mwaVar.p().objType = 1;
            mwaVar.p().isInPost = true;
            ThreadData threadData = null;
            zv9 zv9Var = this.k;
            if (zv9Var != null && zv9Var.R() != null) {
                threadData = this.k.R();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.p.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.p.setThreadData(threadData);
            pbCommenFloorItemViewHolder.p.setData(mwaVar.p());
            pbCommenFloorItemViewHolder.d0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.d0.setData(mwaVar.p());
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, pbCommenFloorItemViewHolder, mwaVar) == null) {
            if (mwaVar != null && mwaVar.u() != null && mwaVar.n0() != null) {
                TbRichText f0 = mwaVar.f0();
                if (f0 != null && StringUtils.isNull(f0.toString()) && StringUtils.isNull(mwaVar.x())) {
                    z = true;
                } else {
                    z = false;
                }
                if (mwaVar.u().getSmallTailThemeData() != null) {
                    str = mwaVar.u().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.L.setTag(R.id.tag_pb_small_tail_theme_id, str);
                s6a.c(mwaVar.n0(), pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, pbCommenFloorItemViewHolder.M, false, false, z, mwaVar.u().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.K.setVisibility(8);
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, mwaVar) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            pbCommenFloorItemViewHolder.S.setVisibility(8);
            pbCommenFloorItemViewHolder.G0.setVisibility(0);
            pbCommenFloorItemViewHolder.D0.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.D0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_10);
            }
            nx9.f(String.valueOf(mwaVar.q0()), mwaVar.U(), mwaVar.F());
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, mwaVar) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            pbCommenFloorItemViewHolder.G0.setVisibility(8);
            pbCommenFloorItemViewHolder.D0.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.D0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.E0.getLayoutParams();
            layoutParams.topMargin = 0;
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (mwaVar.L0(false)) {
                i2 = R.dimen.tbds48;
            } else {
                i2 = R.dimen.tbds25;
            }
            layoutParams.bottomMargin = BdUtilHelper.getDimens(inst, i2);
            layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            r0(pbCommenFloorItemViewHolder, mwaVar);
        }
    }

    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, pbCommenFloorItemViewHolder, mwaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.Q != null && pbCommenFloorItemViewHolder.N != null) {
            if (mwaVar != null && (alaLiveInfoCoreData = mwaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.Q.setText(mwaVar.U.liveTitle);
                pbCommenFloorItemViewHolder.N.setTag(mwaVar.U);
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

    public final void k0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, pbCommenFloorItemViewHolder, mwaVar) == null) {
            if (mwaVar.P() != 2 && mwaVar.P() != 4) {
                pbCommenFloorItemViewHolder.f1135T.setVisibility(8);
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                pbCommenFloorItemViewHolder.D0.setVisibility(0);
                R(false, pbCommenFloorItemViewHolder, mwaVar);
            } else {
                pbCommenFloorItemViewHolder.f1135T.setOnClickListener(new m(this, pbCommenFloorItemViewHolder, mwaVar));
                pbCommenFloorItemViewHolder.f1135T.setVisibility(0);
                Q(pbCommenFloorItemViewHolder, mwaVar.H0(), mwaVar.O());
                R(true, pbCommenFloorItemViewHolder, mwaVar);
            }
            r0(pbCommenFloorItemViewHolder, mwaVar);
        }
    }

    public final void W(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).d0) != null && agreeView.getData() != null && !m0(pbCommenFloorItemViewHolder.r)) {
            pbCommenFloorItemViewHolder.d0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.d0.N();
        }
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
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

    public final void Z(mwa mwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, mwaVar) == null) && mwaVar != null) {
            int i2 = 8;
            if (mwaVar.g0) {
                i2 = 2;
            }
            StatisticItem k2 = b6a.k(this.k, mwaVar, mwaVar.h0, i2, 6);
            mwaVar.i0 = k2;
            if (!ListUtils.isEmpty(mwaVar.k0())) {
                Iterator<mwa> it = mwaVar.k0().iterator();
                while (it.hasNext()) {
                    it.next().i0 = k2;
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
            mwa mwaVar = null;
            try {
                sparseArray = (SparseArray) view2.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                return false;
            }
            if (sparseArray.get(R.id.tag_clip_board) instanceof mwa) {
                mwaVar = (mwa) sparseArray.get(R.id.tag_clip_board);
            }
            if (mwaVar == null) {
                return false;
            }
            return mwaVar.E0();
        }
        return invokeL.booleanValue;
    }

    public final String n0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, view2)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048612, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    public final void Y(int i2, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, boolean z, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), pbCommenFloorItemViewHolder, mwaVar, Boolean.valueOf(z), view2}) != null) || !UtilHelper.isCurrentAccount(this.k.R().getAuthor().getUserId()) || !this.k.R().isQuestionThread() || UtilHelper.isCurrentAccount(((mwa) getItem(i2)).u().getUserId())) {
            return;
        }
        if (z) {
            ((mwa) getItem(i2)).l1(1);
            pbCommenFloorItemViewHolder.y0.setVisibility(0);
            ((mwa) getItem(i2)).e1(true);
            pbCommenFloorItemViewHolder.i.setVisibility(8);
            pbCommenFloorItemViewHolder.d0.postDelayed(new f(this, i2, mwaVar, pbCommenFloorItemViewHolder), 900L);
        } else {
            ((mwa) getItem(i2)).l1(0);
            if (!mwaVar.z0()) {
                pbCommenFloorItemViewHolder.z0.setVisibility(8);
                pbCommenFloorItemViewHolder.e0.setVisibility(0);
                j2a.v(pbCommenFloorItemViewHolder, mwaVar);
            }
            pbCommenFloorItemViewHolder.y0.setVisibility(8);
            ((mwa) getItem(i2)).e1(false);
            if (((mwa) getItem(i2)).h0().booleanValue()) {
                pbCommenFloorItemViewHolder.i.setVisibility(0);
            }
        }
        i2a.b(pbCommenFloorItemViewHolder, mwaVar, view2, i2, this.k, this.j, j2a.m(this.a), R.color.CAM_X0107, j2a.g(this.k, mwaVar), this.mContext, true, j2a.s(this.a), j2a.n(this.k));
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048593, this, pbCommenFloorItemViewHolder, mwaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            S(mwaVar.t(), mwaVar, pbCommenFloorItemViewHolder);
            j2a.v(pbCommenFloorItemViewHolder, mwaVar);
            if (!mwaVar.z0()) {
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
            pbCommenFloorItemViewHolder.F0.b(new hx9(mwaVar, new n(this, mwaVar, i2, pbCommenFloorItemViewHolder, view2), new o(this)));
        }
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048601, this, pbCommenFloorItemViewHolder, mwaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            if (mwaVar.m0() > 0) {
                pbCommenFloorItemViewHolder.y.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.y.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, mwaVar);
                if (mwaVar.P() == 2) {
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
                sparseArray2.put(R.id.tag_load_sub_data, mwaVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.A;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.A.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, mwaVar);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            if (!mwaVar.B0() && !mwaVar.A0(false)) {
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
                    k5a k5aVar = new k5a(this.mContext);
                    this.q = k5aVar;
                    k5aVar.f(this.e);
                    this.q.h(this.l);
                    this.q.e(this.m);
                    String str = null;
                    zv9 zv9Var = this.k;
                    if (zv9Var != null && zv9Var.R() != null && this.k.R().getAuthor() != null) {
                        str = this.k.R().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    zv9 zv9Var2 = this.k;
                    if (zv9Var2 != null) {
                        this.q.j(zv9Var2.Z(), z);
                        this.q.i(this.k.R());
                    }
                }
                this.q.g(mwaVar.U());
                pbCommenFloorItemViewHolder.w.setSubPbAdapter(this.q);
                pbCommenFloorItemViewHolder.w.setVisibility(0);
                pbCommenFloorItemViewHolder.w.setData(mwaVar, view2);
                pbCommenFloorItemViewHolder.w.setChildOnClickListener(this.m);
                pbCommenFloorItemViewHolder.w.setChildOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.w.setChildOnTouchListener(this.B);
            }
            if (mwaVar.P) {
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
            pbCommenFloorItemViewHolder.h0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f127d));
        }
    }

    public final void g0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048602, this, pbCommenFloorItemViewHolder, mwaVar, view2) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
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
            P(pbCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(mwaVar.x()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.r.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.r.setTid(this.k.T());
            pbCommenFloorItemViewHolder.r.setPid(mwaVar.U());
            pbCommenFloorItemViewHolder.r.setPosition(TbRichTextView.Position.PB_COMMENT_FLOOR);
            pbCommenFloorItemViewHolder.r.setText(mwaVar.f0(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, mwaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            sparseArray.put(R.id.tag_is_top_question, Boolean.FALSE);
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.o0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.e0.setTag(sparseArray);
        }
    }

    public final void h0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, pbCommenFloorItemViewHolder, mwaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            h6a h6aVar = this.a;
            if (h6aVar != null && h6aVar.l0() != null && StringHelper.equals(this.a.l0().T0(), mwaVar.U())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048604, this, pbCommenFloorItemViewHolder, mwaVar) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null) {
            String g0 = mwaVar.g0();
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
    @Override // com.baidu.tieba.zz9, com.baidu.tieba.ci
    /* renamed from: q0 */
    public View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, mwa mwaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, mwaVar, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) mwaVar, (mwa) pbCommenFloorItemViewHolder);
            B0(pbCommenFloorItemViewHolder);
            w0(pbCommenFloorItemViewHolder, i2, mwaVar, view2);
            M(pbCommenFloorItemViewHolder);
            mwa mwaVar2 = (mwa) getItem(i2);
            if (mwaVar2 != null) {
                mwaVar2.h0 = i2 + 1;
                O(mwaVar2);
                N(mwaVar2);
                mwaVar2.G1();
                Z(mwaVar2);
                c0(pbCommenFloorItemViewHolder, mwaVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void w0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, mwa mwaVar, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048625, this, pbCommenFloorItemViewHolder, i2, mwaVar, view2) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.B);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.p);
            if (this.a.u0() != null && this.a.u0().getPageContext() != null && this.a.u0().getPageContext().getOrignalPage() != null) {
                z2a z2aVar = this.a.u0().c;
                pbCommenFloorItemViewHolder.g.setOnClickListener(z2aVar.b);
                pbCommenFloorItemViewHolder.q.setOnClickListener(z2aVar.b);
                pbCommenFloorItemViewHolder.u0.setOnClickListener(z2aVar.d);
                pbCommenFloorItemViewHolder.t0.setOnClickListener(z2aVar.d);
                pbCommenFloorItemViewHolder.F.setOnClickListener(z2aVar.b);
                pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(z2aVar.b);
                pbCommenFloorItemViewHolder.r.setOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.r.setOnTouchListener(this.B);
                pbCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(this.m);
                pbCommenFloorItemViewHolder.r.setOnImageClickListener(this.n);
                pbCommenFloorItemViewHolder.r.setOnImageTouchListener(this.B);
                pbCommenFloorItemViewHolder.r.setOnEmotionClickListener(z2aVar.f);
                pbCommenFloorItemViewHolder.r.setOnVoiceAfterClickListener(this.m);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.L.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.N.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.i0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.m0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.m0.setOnTouchListener(this.B);
                pbCommenFloorItemViewHolder.E.setOnClickListener(new q(this, mwaVar));
                pbCommenFloorItemViewHolder.e0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.o0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.f0.setOnClickListener(new a(this, pbCommenFloorItemViewHolder));
                b3a b3aVar = this.a.u0().d;
                pbCommenFloorItemViewHolder.z.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.A.setOnClickListener(new b(this, pbCommenFloorItemViewHolder, b3aVar));
                pbCommenFloorItemViewHolder.p.D = new c(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.d0.D = new d(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.d0.setAfterClickListener(new e(this, pbCommenFloorItemViewHolder, i2, mwaVar, view2));
            }
        }
    }
}
