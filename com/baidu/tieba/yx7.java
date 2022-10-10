package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.lw7;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.t16;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class yx7 extends ay7<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lw7 A;
    public TbRichTextView.s g;
    public boolean h;
    public float i;
    public String j;
    public jv7 k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public TbRichTextView.y n;
    public lw7 o;
    public View.OnLongClickListener p;
    public s18 q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public ug<ConstrainImageLayout> y;
    public ug<TbImageView> z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ s08 b;
        public final /* synthetic */ yx7 c;

        /* renamed from: com.baidu.tieba.yx7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0475a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ a b;

            public RunnableC0475a(a aVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    aVar.b.b.a(aVar.c.k, null, this.a, aVar.a.p.getLayoutStrategy());
                }
            }
        }

        public a(yx7 yx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, s08 s08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var, pbCommenFloorItemViewHolder, s08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yx7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = s08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (!(sparseArray.get(R.id.obfuscated_res_0x7f09205a) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f09205a)) == null || this.a.b == null || this.b == null) {
                    return;
                }
                gh.a().postDelayed(new RunnableC0475a(this, postData), 100L);
                String Q = this.c.k.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.c.k.Q())) && this.c.k.O() != null) {
                    Q = this.c.k.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.L()).param("obj_source", this.c.j0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ yx7 b;

        public b(yx7 yx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.k == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.n) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.n.getImgAgree() ? 1 : 2;
            String Q = this.b.k.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.k.Q())) && this.b.k.O() != null) {
                Q = this.b.k.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.n.getData().postId).param("obj_source", this.b.j0(this.a.n)).param("obj_type", i));
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ yx7 b;

        public c(yx7 yx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.k == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.h0) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.h0.getImgAgree() ? 1 : 2;
            String Q = this.b.k.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.k.Q())) && this.b.k.O() != null) {
                Q = this.b.k.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.h0.getData().postId).param("obj_source", this.b.j0(this.a.h0)).param("obj_type", i));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ yx7 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            /* renamed from: com.baidu.tieba.yx7$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class View$OnClickListenerC0476a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0476a(a aVar) {
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

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        j28.p("c14886");
                        d dVar = this.a.a;
                        yx7 yx7Var = dVar.c;
                        yx7Var.l0(((PostData) yx7Var.getItem(dVar.a)).s());
                    }
                }
            }

            /* loaded from: classes6.dex */
            public class b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public b(a aVar) {
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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        d dVar = this.a.a;
                        ((PostData) dVar.c.getItem(dVar.a)).y0();
                        d dVar2 = this.a.a;
                        if (((PostData) dVar2.c.getItem(dVar2.a)).V() <= 0) {
                            d dVar3 = this.a.a;
                            ((PostData) dVar3.c.getItem(dVar3.a)).O0(Boolean.FALSE);
                            this.a.a.b.C0.setVisibility(8);
                            this.a.a.b.h0.setVisibility(0);
                            this.a.a.b.i0.setVisibility(0);
                        }
                    }
                }
            }

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.h0.getAgreeFlag()) {
                    d dVar = this.a;
                    ((PostData) dVar.c.getItem(dVar.a)).x0();
                    d dVar2 = this.a;
                    ((PostData) dVar2.c.getItem(dVar2.a)).O0(Boolean.TRUE);
                    this.a.b.h0.setVisibility(8);
                    this.a.b.i0.setVisibility(8);
                    this.a.b.C0.setVisibility(0);
                    this.a.b.C0.setOnClickListener(new View$OnClickListenerC0476a(this));
                    this.a.b.C0.postDelayed(new b(this), 5000L);
                }
            }
        }

        public d(yx7 yx7Var, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var, Integer.valueOf(i), pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yx7Var;
            this.a = i;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && UtilHelper.isCurrentAccount(this.c.k.O().getAuthor().getUserId()) && this.c.k.O().isQuestionThread() && !UtilHelper.isCurrentAccount(((PostData) this.c.getItem(this.a)).s().getUserId())) {
                if (this.b.h0.getAgreeFlag()) {
                    ((PostData) this.c.getItem(this.a)).P0(1);
                    this.b.B0.setVisibility(0);
                    ((PostData) this.c.getItem(this.a)).I0(true);
                    this.b.h.setVisibility(8);
                    this.b.h0.postDelayed(new a(this), 900L);
                    return;
                }
                ((PostData) this.c.getItem(this.a)).P0(0);
                this.b.C0.setVisibility(8);
                this.b.B0.setVisibility(8);
                this.b.h0.setVisibility(0);
                this.b.i0.setVisibility(0);
                ((PostData) this.c.getItem(this.a)).I0(false);
                if (((PostData) this.c.getItem(this.a)).X().booleanValue()) {
                    this.b.h.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx7 a;

        public e(yx7 yx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx7Var;
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

    /* loaded from: classes6.dex */
    public class f implements vg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx7 a;

        public f(yx7 yx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.mContext) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements vg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx7 a;

        public g(yx7 yx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
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
    }

    /* loaded from: classes6.dex */
    public class h implements lw7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yx7 a;

        public h(yx7 yx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yx7Var;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if (!(view2 instanceof TbListTextView) || this.a.m == null) {
                        this.a.o.a(view2);
                        this.a.o.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.a.m.onClick(view2);
                    PbFragment pbFragment = this.a.b;
                    if (pbFragment != null) {
                        pbFragment.a7(false);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.lw7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (!((pbFragment = this.a.b) == null || pbFragment.P5() == null || this.a.b.P5().K1()) || view2.getId() == R.id.obfuscated_res_0x7f090a0c)) {
                    return true;
                }
                if (view2 instanceof FrameLayout) {
                    this.a.S(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof FrameLayout) {
                            this.a.S((FrameLayout) parent);
                            break;
                        } else {
                            parent = parent.getParent();
                            i++;
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ yx7 c;

        public i(yx7 yx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yx7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = this.a.X.getVisibility() == 8;
                this.c.P(this.a, !z, this.b.F());
                this.b.L0(!z);
                this.c.o0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment == null || pbFragment.P5() == null || this.c.b.P5().o1() == null || this.c.b.P5().U0() == null || z || this.a.getView().getTop() >= this.c.b.P5().o1().getMeasuredHeight()) {
                    return;
                }
                this.c.b.P5().U0().setSelectionFromTop(ListUtils.getPosition(this.c.b.P5().U0().getData(), this.b) + this.c.b.P5().U0().getHeaderViewsCount(), this.c.b.P5().o1().getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ yx7 b;

        public j(yx7 yx7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yx7Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, this.a);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public k(yx7 yx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var, pbCommenFloorItemViewHolder};
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C0.setVisibility(8);
                this.a.h0.setVisibility(0);
                this.a.i0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ String[] c;
        public final /* synthetic */ int d;
        public final /* synthetic */ yx7 e;

        public l(yx7 yx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, String[] strArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var, pbCommenFloorItemViewHolder, postData, strArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yx7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
            this.c = strArr;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.e.getMeasuredWidth();
                this.e.h0();
                boolean z = true;
                boolean z2 = !this.e.R(this.b);
                int width = !StringUtils.isNull(this.c[0]) ? this.a.g.getWidth() : 0;
                int g = lz7.g(measuredWidth, this.a.L.getVisibility() == 8 ? 0 : this.a.L.getWidth() + lz7.c + lz7.b, width, this.a.i.getVisibility() == 8 ? 0 : this.a.i.getWidth() + lz7.b, this.a.J.getVisibility() == 8 ? 0 : this.a.J.getWidth() + lz7.b, z2);
                if (g < 0 && !StringUtils.isNull(this.c[0])) {
                    this.a.f.setWidth(width + g);
                } else {
                    this.a.f.setWidth(width);
                    z = false;
                }
                if (this.a.g.getText() == null) {
                    if (z) {
                        this.a.f.setText(this.c[0]);
                        yx7 yx7Var = this.e;
                        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                        yx7Var.w0(pbCommenFloorItemViewHolder.f, pbCommenFloorItemViewHolder.i);
                    } else {
                        this.a.f.setText(this.c[0]);
                        this.e.x0(this.a.i, false);
                    }
                } else if (z) {
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                    pbCommenFloorItemViewHolder2.f.setText(pbCommenFloorItemViewHolder2.g.getText());
                    yx7 yx7Var2 = this.e;
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder3 = this.a;
                    yx7Var2.w0(pbCommenFloorItemViewHolder3.f, pbCommenFloorItemViewHolder3.i);
                } else {
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder4 = this.a;
                    pbCommenFloorItemViewHolder4.f.setText(pbCommenFloorItemViewHolder4.g.getText());
                    this.e.x0(this.a.i, false);
                }
                this.e.N(this.b, this.a, g, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TbImageView c;
        public final /* synthetic */ yx7 d;

        public m(yx7 yx7Var, TextView textView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var, textView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yx7Var;
            this.b = textView;
            this.c = tbImageView;
            this.a = true;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a) {
                Layout layout = this.b.getLayout();
                if (this.b == null || layout == null) {
                    return;
                }
                int lineCount = layout.getLineCount() - 1;
                if (layout.getEllipsisCount(lineCount) == 0) {
                    return;
                }
                String charSequence = this.b.getText().toString();
                String substring = charSequence.substring(0, layout.getEllipsisStart(lineCount));
                this.b.setText(charSequence.substring(0, layout.getEllipsisStart(lineCount)).concat(StringHelper.STRING_MORE));
                this.a = false;
                TbImageView tbImageView = this.c;
                if (tbImageView == null || tbImageView.getVisibility() != 0) {
                    return;
                }
                if (substring.length() % 2 == 0) {
                    this.d.x0(this.c, false);
                } else {
                    this.d.x0(this.c, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public n(yx7 yx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx7Var, pbCommenFloorItemViewHolder};
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
                this.a.x.performClick();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx7(t28 t28Var, BdUniqueId bdUniqueId) {
        super(t28Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t28Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((t28) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.y = new ug<>(new f(this), 6, 0);
        this.z = new ug<>(new g(this), 12, 0);
        this.A = new lw7(new h(this));
        if (t28Var != null && t28Var.K() != null) {
            this.t = t28Var.K().R1();
        }
        s(R.dimen.tbds14);
    }

    public final void A0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            B0(textView, (PostData) tag);
        }
    }

    public final void B0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            jv7 jv7Var = this.k;
            if (jv7Var != null && jv7Var.i0()) {
                postData.W0(Boolean.FALSE);
                postData.K0(0);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(s.getUserId())) {
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f087d);
                    textView.setBackgroundColor(0);
                    hv4 d2 = hv4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.p0()) {
                    hv4 d3 = hv4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f0346);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    hv4 d4 = hv4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.obfuscated_res_0x7f0f02ff);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    hv4 d5 = hv4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f0300);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    hv4 d6 = hv4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fc);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    hv4 d7 = hv4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    postData.W0(Boolean.TRUE);
                    postData.K0(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fd);
                } else {
                    postData.W0(Boolean.FALSE);
                    postData.K0(0);
                }
            } else {
                postData.W0(Boolean.FALSE);
                postData.K0(0);
            }
        }
    }

    public final void K(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.p.setTextViewOnTouchListener(this.o);
            pbCommenFloorItemViewHolder.p.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.r.setOnTouchListener(new e(this));
        }
    }

    public final void L(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, postData) == null) {
            if (postData != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", postData.L());
                statisticItem.param("pid", postData.L());
                statisticItem.param("tid", postData.e0());
                statisticItem.param("fid", postData.H());
                statisticItem.param("fname", postData.I());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            jv7 jv7Var = this.k;
            if (jv7Var != null) {
                if (jv7Var.u0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        j28.e(absVideoPbFragment.getUniqueId(), this.k, postData, postData.c0, postData.b0 ? 2 : 8, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    j28.e(pbFragment.getUniqueId(), this.k, postData, postData.c0, postData.b0 ? 2 : 8, "common_exp_source_pb_comment");
                }
            }
        }
    }

    public final void M(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, postData) == null) && postData.D == 0 && postData.L) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.L());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            t28 t28Var = this.a;
            if (t28Var != null) {
                int R1 = t28Var.K().R1();
                if (1 == R1 || 2 == R1) {
                    statisticItem.param("obj_source", "1");
                } else if (3 == R1) {
                    statisticItem.param("obj_source", "2");
                } else {
                    statisticItem.param("obj_source", "0");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.s() == null || postData.s().getAlaInfo() == null || postData.s().getAlaInfo().live_status != 1) {
                return;
            }
            p0(postData);
        }
    }

    public final void N(PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048581, this, postData, pbCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > postData.m0() + postData.M()) {
                if (pbCommenFloorItemViewHolder.M != null && postData.s() != null) {
                    pbCommenFloorItemViewHolder.M.setTag(R.id.obfuscated_res_0x7f092092, postData.s().getUserId());
                    t28 t28Var = this.a;
                    if (t28Var != null && t28Var.P() != null) {
                        pbCommenFloorItemViewHolder.M.setOnClickListener(this.a.P().d.c);
                    }
                    ArrayList<IconData> iconInfo = postData.s().getIconInfo();
                    int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.M.g(iconInfo, i3, f2, f2, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (postData.X().booleanValue() && !postData.K()) {
                    pbCommenFloorItemViewHolder.h.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.h.setVisibility(8);
                }
            } else if (i2 > postData.M()) {
                if (postData.X().booleanValue() && !postData.K()) {
                    pbCommenFloorItemViewHolder.h.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.h.setVisibility(8);
                }
                pbCommenFloorItemViewHolder.M.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.M.setVisibility(8);
                pbCommenFloorItemViewHolder.h.setVisibility(8);
            }
        }
    }

    public final void O(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k2 = ((((ej.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k2 = (k2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int s = z ? s(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k2 - s) * this.i));
        tbRichTextView.getLayoutStrategy().H = (k2 - s) - s(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k2 * 1.618f * this.i));
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.X.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.Z.setText(R.string.obfuscated_res_0x7f0f05e6);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.Z.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.X.setVisibility(0);
            pbCommenFloorItemViewHolder.Z.setText(R.string.obfuscated_res_0x7f0f03fb);
        }
    }

    public final void Q(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view2 = pbCommenFloorItemViewHolder.O) == null || pbCommenFloorItemViewHolder.Y == null || !(view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.Y.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.Z());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.O.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.Y.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.Y.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = ej.f(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.O.setLayoutParams(layoutParams);
            }
        } else {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().m(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            if (layoutParams != null) {
                layoutParams.topMargin = ej.f(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.O.setLayoutParams(layoutParams);
            }
        }
        if (pbCommenFloorItemViewHolder.w0.getVisibility() != 0 && pbCommenFloorItemViewHolder.D0.getVisibility() != 0) {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().j(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
        } else {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().j(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
        }
    }

    public final boolean R(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, postData)) == null) {
            if (this.k.O() == null || this.k.O().getAuthor() == null || this.k.O().getAuthor().getUserId() == null || postData == null || postData.s() == null || postData.s().getUserId() == null) {
                return false;
            }
            return this.k.O().getAuthor().getUserId().equals(postData.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public final void S(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view2) == null) || view2 == null || !(view2.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).h0) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.h0.setAgreeSource(2);
        pbCommenFloorItemViewHolder.h0.J();
    }

    public final void T(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = j28.i(this.k, postData, postData.c0, postData.b0 ? 2 : 8, 6);
        postData.d0 = i2;
        if (ListUtils.isEmpty(postData.Z())) {
            return;
        }
        Iterator<PostData> it = postData.Z().iterator();
        while (it.hasNext()) {
            it.next().d0 = i2;
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.N) == null || this.k == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        boolean z2;
        jv7 jv7Var;
        jv7 jv7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        String str = null;
        boolean z3 = true;
        if (postData.C() > 0 && (jv7Var2 = this.k) != null && !jv7Var2.i0()) {
            String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0994), Integer.valueOf(postData.C()));
            pbCommenFloorItemViewHolder.I.setVisibility(0);
            pbCommenFloorItemViewHolder.I.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.I.setVisibility(8);
            z = false;
        }
        if (postData.s() != null) {
            str = postData.s().getIpAddress();
            if (!TextUtils.isEmpty(str)) {
                z2 = true;
                j45 S = postData.S();
                z3 = (S != null || StringUtils.isNull(S.b()) || (jv7Var = this.k) == null || jv7Var.i0()) ? false : false;
                if (!z) {
                    pbCommenFloorItemViewHolder.k.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.k.setVisibility(8);
                }
                if (z3 && !z2) {
                    pbCommenFloorItemViewHolder.l.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.l.setVisibility(0);
                }
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.f0()), "yyyy"))) {
                    pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTimeShort(postData.f0()));
                } else {
                    pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTime(postData.f0()));
                }
                if (!z2) {
                    pbCommenFloorItemViewHolder.m.setVisibility(0);
                    TextView textView = pbCommenFloorItemViewHolder.m;
                    textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f150b) + str);
                } else if (z3) {
                    pbCommenFloorItemViewHolder.m.setVisibility(0);
                    if (postData.a0) {
                        pbCommenFloorItemViewHolder.m.setText(StringHelper.cutStringWithSuffix(S.b(), 7, StringHelper.STRING_MORE));
                    } else {
                        pbCommenFloorItemViewHolder.m.setText(S.b());
                    }
                } else {
                    pbCommenFloorItemViewHolder.m.setVisibility(8);
                }
                TextView textView2 = pbCommenFloorItemViewHolder.k0;
                textView2.setText(((Object) pbCommenFloorItemViewHolder.j.getText()) + "  • ");
            }
        }
        z2 = false;
        j45 S2 = postData.S();
        if (S2 != null) {
        }
        if (!z) {
        }
        if (z3) {
        }
        pbCommenFloorItemViewHolder.l.setVisibility(0);
        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.f0()), "yyyy"))) {
        }
        if (!z2) {
        }
        TextView textView22 = pbCommenFloorItemViewHolder.k0;
        textView22.setText(((Object) pbCommenFloorItemViewHolder.j.getText()) + "  • ");
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.c0.setVisibility(postData.a0 ? 0 : 8);
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048591, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.z.setVisibility(8);
        pbCommenFloorItemViewHolder.t.setVisibility(0);
        pbCommenFloorItemViewHolder.j0.setVisibility(8);
        pbCommenFloorItemViewHolder.x.setVisibility(8);
        pbCommenFloorItemViewHolder.y.setVisibility(8);
        pbCommenFloorItemViewHolder.n.setVisibility(8);
        pbCommenFloorItemViewHolder.r0.setVisibility(8);
        g0(pbCommenFloorItemViewHolder, postData, view2, i2);
        U(pbCommenFloorItemViewHolder, postData);
        Y(pbCommenFloorItemViewHolder, postData);
        b0(pbCommenFloorItemViewHolder, postData, view2);
        a0(pbCommenFloorItemViewHolder, postData, view2, i2);
        V(pbCommenFloorItemViewHolder, postData);
        d0(pbCommenFloorItemViewHolder, postData);
        Z(pbCommenFloorItemViewHolder, postData);
        z0(pbCommenFloorItemViewHolder, postData);
        e0(pbCommenFloorItemViewHolder, postData);
        xw7.d(pbCommenFloorItemViewHolder, postData, view2, this.h, this.A);
        W(pbCommenFloorItemViewHolder, postData);
        c0(pbCommenFloorItemViewHolder, postData);
        f0(pbCommenFloorItemViewHolder, postData);
        xw7.j(pbCommenFloorItemViewHolder, view2, postData, this.r, true);
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        postData.q().threadId = this.a.K().m2();
        postData.q().objType = 1;
        postData.q().isInPost = true;
        ThreadData threadData = null;
        jv7 jv7Var = this.k;
        if (jv7Var != null && jv7Var.O() != null) {
            threadData = this.k.O();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.n.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.n.setThreadData(threadData);
        pbCommenFloorItemViewHolder.n.setData(postData.q());
        pbCommenFloorItemViewHolder.h0.setThreadData(threadData);
        pbCommenFloorItemViewHolder.h0.setData(postData.q());
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.V == null || pbCommenFloorItemViewHolder.S == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.S) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.V.setText(postData.S.liveTitle);
            pbCommenFloorItemViewHolder.S.setTag(postData.S);
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.S.setVisibility(8);
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048594, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.b0() > 0) {
            pbCommenFloorItemViewHolder.w.setVisibility(8);
        } else {
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.w.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbCommenFloorItemViewHolder.w.setTag(sparseArray);
            }
            sparseArray.put(R.id.obfuscated_res_0x7f09205a, postData);
            if (postData.G() == 2) {
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.w.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.v.setVisibility(8);
        }
        ImageView imageView = pbCommenFloorItemViewHolder.x;
        if (imageView != null) {
            SparseArray sparseArray2 = (SparseArray) imageView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbCommenFloorItemViewHolder.x.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f09205a, postData);
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.y;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.y.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.obfuscated_res_0x7f09205a, postData);
        }
        pbCommenFloorItemViewHolder.v.setVisibility(8);
        if (!postData.o0() && !postData.n0(false)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.u.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.u.setVisibility(8);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams2.topMargin = ej.f(this.mContext, R.dimen.tbds0);
            layoutParams2.leftMargin = ej.f(this.mContext, R.dimen.tbds148);
            layoutParams2.rightMargin = ej.f(this.mContext, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = ej.f(this.mContext, R.dimen.tbds20);
            pbCommenFloorItemViewHolder.u.setLayoutParams(layoutParams2);
            if (this.q == null) {
                s18 s18Var = new s18(this.mContext);
                this.q = s18Var;
                s18Var.f(this.e);
                this.q.h(this.l);
                this.q.e(this.m);
                String str = null;
                jv7 jv7Var = this.k;
                if (jv7Var != null && jv7Var.O() != null && this.k.O().getAuthor() != null) {
                    str = this.k.O().getAuthor().getUserId();
                }
                boolean z = true;
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                jv7 jv7Var2 = this.k;
                if (jv7Var2 != null) {
                    this.q.j(jv7Var2.W(), z);
                    this.q.i(this.k.O());
                }
            }
            this.q.g(postData.L());
            pbCommenFloorItemViewHolder.u.setSubPbAdapter(this.q);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.u.setData(postData, view2);
            pbCommenFloorItemViewHolder.u.setChildOnClickListener(this.m);
            pbCommenFloorItemViewHolder.u.setChildOnLongClickListener(this.p);
            pbCommenFloorItemViewHolder.u.setChildOnTouchListener(this.A);
        }
        if (postData.O) {
            pbCommenFloorItemViewHolder.O.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.O.setVisibility(4);
        }
        pbCommenFloorItemViewHolder.w.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.t.getLayoutParams();
        layoutParams3.topMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
        layoutParams3.bottomMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
        if (pbCommenFloorItemViewHolder.v.getVisibility() == 8) {
            pbCommenFloorItemViewHolder.t.setVisibility(8);
        } else {
            pbCommenFloorItemViewHolder.t.setVisibility(0);
        }
        pbCommenFloorItemViewHolder.l0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ffe));
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048595, this, pbCommenFloorItemViewHolder, postData, view2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = ej.f(this.mContext, R.dimen.M_W_X007);
        layoutParams.leftMargin = ej.f(this.mContext, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.p.setPadding(0, 0, 0, 0);
        if (!this.h) {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbCommenFloorItemViewHolder.p.k0(null);
            pbCommenFloorItemViewHolder.p.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081241);
        }
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().x(R.drawable.pic_video);
        O(pbCommenFloorItemViewHolder.p, view2, !StringUtils.isNull(postData.t()), layoutParams.leftMargin + layoutParams.rightMargin);
        pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.p.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.p.setIsFromCDN(this.e);
        pbCommenFloorItemViewHolder.p.setText(postData.W(), true, this.g);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.p.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09203d, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092056, Boolean.FALSE);
        sparseArray.put(R.id.obfuscated_res_0x7f092057, Boolean.FALSE);
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
        pbCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f092050, sparseArray);
        pbCommenFloorItemViewHolder.r0.setTag(sparseArray);
        pbCommenFloorItemViewHolder.i0.setTag(sparseArray);
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.h = z;
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.b == null) {
            return;
        }
        t28 t28Var = this.a;
        if (t28Var != null && t28Var.K() != null && StringHelper.equals(this.a.K().t1(), postData.L())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0205);
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onLongClickListener) == null) {
            this.p = onLongClickListener;
        }
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.c0() != null) {
                TbRichText W = postData.W();
                q38.c(postData.c0(), pbCommenFloorItemViewHolder.P, pbCommenFloorItemViewHolder.Q, pbCommenFloorItemViewHolder.R, false, false, W != null && StringUtils.isNull(W.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbCommenFloorItemViewHolder.P.setVisibility(8);
            pbCommenFloorItemViewHolder.Q.setVisibility(8);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.G() != 2 && postData.G() != 4) {
                pbCommenFloorItemViewHolder.Y.setVisibility(8);
                pbCommenFloorItemViewHolder.X.setVisibility(0);
                Q(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.Y.setOnClickListener(new i(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.Y.setVisibility(0);
                P(pbCommenFloorItemViewHolder, postData.r0(), postData.F());
                Q(true, pbCommenFloorItemViewHolder, postData);
            }
            o0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.f(postData.R, postData.L(), this.v);
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x07f7  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x083a  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x08aa  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x08f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048603, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        if (postData.Q) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.d.setVisibility(8);
        }
        pbCommenFloorItemViewHolder.o.setTag(null);
        pbCommenFloorItemViewHolder.o.setUserId(null);
        pbCommenFloorItemViewHolder.K.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.p.setIsHost(false);
        if (postData.s() != null) {
            String str = this.j;
            if (str != null && !str.equals("0") && this.j.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.p.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                i3 = iconInfo.size();
                if (i3 > 1) {
                    postData.e1((f2 * i3) + (f3 * i3));
                } else if (i3 == 1) {
                    postData.e1(f2 + f3);
                } else {
                    postData.e1(0);
                }
            } else {
                postData.e1((f2 * 2) + (f3 * 2));
                i3 = 2;
            }
            if (pbCommenFloorItemViewHolder.L != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.L.setTag(tShowInfoNew.get(0).getUrl());
                }
                t28 t28Var = this.a;
                if (t28Var != null && t28Var.P() != null) {
                    pbCommenFloorItemViewHolder.L.setOnClickListener(this.a.P().d.e);
                }
                int f4 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.L.h(tShowInfoNew, 3, f4, f4, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        lz7.m(pbCommenFloorItemViewHolder.f);
                    } else {
                        hv4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            int i4 = postData.b0 ? 2 : 8;
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092092, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f09209a, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f09209c, postData.s().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092088, j28.i(this.k, postData, postData.c0, i4, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.g.setText(ju7.b(this.mContext, pbCommenFloorItemViewHolder.f.getText().toString()));
                pbCommenFloorItemViewHolder.f.setGravity(16);
                pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092067, ju7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.K.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.K.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setVisibility(8);
                pbCommenFloorItemViewHolder.K.setVisibility(0);
                pbCommenFloorItemViewHolder.K.getHeadView().K(avater, 28, false);
                pbCommenFloorItemViewHolder.K.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.K.getHeadView().setUserName(postData.s().getUserName());
                jv7 jv7Var = this.k;
                pbCommenFloorItemViewHolder.K.getHeadView().setFid(jv7Var != null ? jv7Var.m() : "");
                jv7 jv7Var2 = this.k;
                pbCommenFloorItemViewHolder.K.getHeadView().setFName(jv7Var2 != null ? jv7Var2.n() : "");
                pbCommenFloorItemViewHolder.K.getHeadView().setFloor(postData.C());
                pbCommenFloorItemViewHolder.K.getHeadView().setTid(postData.L());
                pbCommenFloorItemViewHolder.K.getHeadView().setTag(R.id.obfuscated_res_0x7f092088, j28.i(this.k, postData, postData.c0, i4, 2));
                pbCommenFloorItemViewHolder.K.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.o.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.o, postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setUserId(postData.s().getUserId());
                jv7 jv7Var3 = this.k;
                pbCommenFloorItemViewHolder.o.setFid(jv7Var3 != null ? jv7Var3.m() : "");
                jv7 jv7Var4 = this.k;
                pbCommenFloorItemViewHolder.o.setFName(jv7Var4 != null ? jv7Var4.n() : "");
                pbCommenFloorItemViewHolder.o.setFloor(postData.C());
                pbCommenFloorItemViewHolder.o.setTid(postData.L());
                pbCommenFloorItemViewHolder.o.setUserName(postData.s().getUserName(), postData.h0());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f09209c, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092088, j28.i(this.k, postData, postData.c0, i4, 2));
                pbCommenFloorItemViewHolder.o.setImageDrawable(null);
                pbCommenFloorItemViewHolder.o.K(avater, 28, false);
                pbCommenFloorItemViewHolder.o.setVisibility(0);
                pbCommenFloorItemViewHolder.K.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.o.setLiveStatus(1);
                pbCommenFloorItemViewHolder.o.setAlaInfo(postData.s().getAlaInfo());
                pbCommenFloorItemViewHolder.K.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.K.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.o.setLiveStatus(0);
                pbCommenFloorItemViewHolder.o.setAlaInfo(null);
                pbCommenFloorItemViewHolder.K.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.K.getHeadView().setAlaInfo(null);
            }
            B0(pbCommenFloorItemViewHolder.h, postData);
            if (TbSingleton.getInstance().isUserGrowthOpen() && postData.s().getUserGrowthData() != null) {
                int a2 = postData.s().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbCommenFloorItemViewHolder.i.setImageResource(kx.b(a2));
                    pbCommenFloorItemViewHolder.i.setVisibility(0);
                    pbCommenFloorItemViewHolder.i.setOnClickListener(new j(this, a2));
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                } else {
                    pbCommenFloorItemViewHolder.i.setVisibility(8);
                }
            }
        } else {
            i3 = 2;
        }
        t28 t28Var2 = this.a;
        int level_id = (t28Var2 == null || t28Var2.P() == null || !this.a.P().u0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        jv7 jv7Var5 = this.k;
        if (jv7Var5 != null && jv7Var5.i0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.J.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.J, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.J.setVisibility(8);
        }
        int i5 = 15;
        if (i3 == 1) {
            i5 = 13;
        } else if (i3 > 1) {
            i5 = 11;
        }
        if (pbCommenFloorItemViewHolder.h.getVisibility() == 0) {
            i5 -= 2;
        }
        if (pbCommenFloorItemViewHolder.L.getChildCount() > 0) {
            i5 -= 2;
        }
        if (postData.x() > 1000) {
            i5 -= 2;
        }
        if (postData.x() > 10) {
            i5 -= 2;
        }
        if (i5 < 10) {
            if (i3 == 1) {
                i5 += 2;
            } else if (i3 > 1) {
                i5 += 4;
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.h.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.h.setVisibility(8);
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.J.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.J.setVisibility(8);
            }
        }
        int e2 = lz7.e();
        String[] strArr = new String[1];
        strArr[0] = (postData.s() == null || postData.s().getName_show() == null) ? "" : postData.s().getName_show();
        int d2 = ji5.d(strArr[0]);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i6 = e2 - 2;
            if (d2 > i6) {
                strArr[0] = ji5.n(strArr[0], i6);
                strArr[0] = strArr[0] + StringHelper.STRING_MORE;
            }
        } else if (d2 > e2) {
            strArr[0] = ji5.n(strArr[0], e2);
            strArr[0] = strArr[0] + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.g.setText(i0(postData.s().getSealPrefix(), strArr[0]));
        } else {
            pbCommenFloorItemViewHolder.g.setText(strArr[0]);
        }
        if (((PostData) getItem(i2)).O() == 1 && this.k.O() != null && this.k.O().isQuestionThread() && !R(postData)) {
            ((PostData) getItem(i2)).I0(true);
            pbCommenFloorItemViewHolder.B0.setVisibility(0);
            if (((PostData) getItem(i2)).N().booleanValue()) {
                pbCommenFloorItemViewHolder.C0.setVisibility(0);
                pbCommenFloorItemViewHolder.h0.setVisibility(8);
                pbCommenFloorItemViewHolder.i0.setVisibility(8);
                pbCommenFloorItemViewHolder.C0.postDelayed(new k(this, pbCommenFloorItemViewHolder), 3000L);
            } else {
                pbCommenFloorItemViewHolder.C0.setVisibility(8);
                pbCommenFloorItemViewHolder.h0.setVisibility(0);
                pbCommenFloorItemViewHolder.i0.setVisibility(0);
            }
        } else {
            ((PostData) getItem(i2)).I0(false);
            pbCommenFloorItemViewHolder.B0.setVisibility(8);
            pbCommenFloorItemViewHolder.C0.setVisibility(8);
            pbCommenFloorItemViewHolder.h0.setVisibility(0);
            pbCommenFloorItemViewHolder.i0.setVisibility(0);
        }
        SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.B0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.A0, R.color.CAM_X0105, 1);
        pbCommenFloorItemViewHolder.e.post(new l(this, pbCommenFloorItemViewHolder, postData, new String[]{strArr[0]}, 2));
        if (!StringUtils.isNull(postData.s().getDiplayIntro())) {
            pbCommenFloorItemViewHolder.D0.setVisibility(0);
            pbCommenFloorItemViewHolder.D0.setText(postData.s().getDiplayIntro() + "");
        } else {
            pbCommenFloorItemViewHolder.D0.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f09203d, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f09205a, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f09205c, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f09206b, Integer.valueOf(i2));
        sparseArray.put(R.id.obfuscated_res_0x7f09206a, Integer.valueOf(postData.C()));
        sparseArray.put(R.id.obfuscated_res_0x7f09204d, postData.L());
        sparseArray.put(R.id.obfuscated_res_0x7f0917ef, pbCommenFloorItemViewHolder.n);
        sparseArray.put(R.id.obfuscated_res_0x7f0917f0, pbCommenFloorItemViewHolder.h0);
        sparseArray.put(R.id.obfuscated_res_0x7f0917ed, pbCommenFloorItemViewHolder.x);
        sparseArray.put(R.id.obfuscated_res_0x7f0917ee, pbCommenFloorItemViewHolder.y);
        jv7 jv7Var6 = this.k;
        ThreadData O = (jv7Var6 == null || jv7Var6.O() == null) ? null : this.k.O();
        if (O != null && O.isUgcThreadType()) {
            sparseArray.put(R.id.obfuscated_res_0x7f0917ec, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.obfuscated_res_0x7f0917ec, Boolean.FALSE);
        }
        boolean z8 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        jv7 jv7Var7 = this.k;
        if (jv7Var7 == null || jv7Var7.W() == 0 || k0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.k.W() == 1002 || this.k.W() == 3) ? false : true;
            if (this.k.W() == 3 || this.k.i0()) {
                z2 = false;
                z3 = false;
            } else {
                z2 = true;
                z3 = true;
            }
            if (postData != null && postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        jv7 jv7Var8 = this.k;
        if (jv7Var8 != null && jv7Var8.O() != null && this.k.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.k.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z5 = false;
                    z4 = true;
                    z6 = true;
                } else {
                    z5 = true;
                    z4 = true;
                    z6 = false;
                }
                z7 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z4 = true;
                    z6 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i7 = postData.C() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092085, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(this.k.W()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f09204a, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204b, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f09204c, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092085, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092054, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092095, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092096, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f092094, postData.s().getName_show());
                    }
                    if (this.k.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092098, this.k.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092097, postData.L());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092051, Boolean.valueOf(postData.o0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(this.k.W()));
                    sparseArray.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f092041, Integer.valueOf(i7));
                    sparseArray.put(R.id.obfuscated_res_0x7f09203f, postData.L());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092083, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09205e, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.p.setTag(sparseArray);
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            }
        }
        z4 = z2;
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData != null) {
            z4 = true;
            z6 = true;
        }
        if (z8) {
        }
        if (postData.C() != 1) {
        }
        if (!z) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f09205e, Boolean.valueOf(z3));
        sparseArray.put(R.id.obfuscated_res_0x7f092055, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            jv7 jv7Var = this.k;
            if (jv7Var == null || jv7Var.O() == null) {
                return false;
            }
            return this.k.O().isQuestionThread();
        }
        return invokeV.booleanValue;
    }

    public final SpannableStringBuilder i0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new t16.a(str, R.drawable.pic_smalldot_title));
            return t16.h(this.a.P(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final String j0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (sparseArray == null) {
                return "1";
            }
            Object obj = sparseArray.get(R.id.obfuscated_res_0x7f09188c);
            String str = obj != null ? obj : "1";
            sparseArray.remove(R.id.obfuscated_res_0x7f09188c);
            view2.setTag(sparseArray);
            return str.toString();
        }
        return (String) invokeL.objValue;
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            jv7 jv7Var = this.k;
            if (jv7Var == null || jv7Var.O() == null) {
                return false;
            }
            return this.k.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    public void l0(com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: m0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06e3, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09186e)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06db, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.P().getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.s.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.s.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.u;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.u);
                pbCommenFloorItemViewHolder.u.setIsVideoThread(false);
            }
            y0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.p;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.s);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, yVar) == null) {
            this.n = yVar;
        }
    }

    public View n0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, postData, pbCommenFloorItemViewHolder);
            y0(pbCommenFloorItemViewHolder);
            r0(pbCommenFloorItemViewHolder, i2);
            K(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.c0 = i2 + 1;
                M(postData2);
                L(postData2);
                postData2.i1();
                T(postData2);
                X(pbCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.j = str;
        }
    }

    public final void o0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText W = postData.W();
            W.isChanged = true;
            pbCommenFloorItemViewHolder.p.setText(W, true, this.g);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.ay7, com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        n0(i2, view2, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void p0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, postData) == null) {
            String userId = postData.s().getUserId();
            jv7 jv7Var = this.k;
            String m2 = jv7Var != null ? jv7Var.m() : "";
            jv7 jv7Var2 = this.k;
            String n2 = jv7Var2 != null ? jv7Var2.n() : "";
            int C = postData.C();
            String L = postData.L();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", m2);
            statisticItem.param("fname", n2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", L);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, C);
            if (postData.s().getAlaInfo() != null) {
                AlaInfoData alaInfo = postData.s().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.s = z;
        }
    }

    public void r(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, jv7Var) == null) {
            this.k = jv7Var;
        }
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048621, this, pbCommenFloorItemViewHolder, i2) == null) {
            pbCommenFloorItemViewHolder.b.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.b.setOnLongClickListener(this.p);
            if (this.a.P() == null || this.a.P().getPageContext() == null || this.a.P().getPageContext().getOrignalPage() == null) {
                return;
            }
            q08 q08Var = this.a.P().d;
            pbCommenFloorItemViewHolder.f.setOnClickListener(q08Var.b);
            pbCommenFloorItemViewHolder.o.setOnClickListener(q08Var.b);
            pbCommenFloorItemViewHolder.x0.setOnClickListener(q08Var.d);
            pbCommenFloorItemViewHolder.w0.setOnClickListener(q08Var.d);
            pbCommenFloorItemViewHolder.K.setOnClickListener(q08Var.b);
            pbCommenFloorItemViewHolder.K.getHeadView().setOnClickListener(q08Var.b);
            pbCommenFloorItemViewHolder.p.setOnLongClickListener(this.p);
            pbCommenFloorItemViewHolder.p.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.p.setCommonTextViewOnClickListener(this.m);
            pbCommenFloorItemViewHolder.p.setOnImageClickListener(this.n);
            pbCommenFloorItemViewHolder.p.setOnImageTouchListener(this.A);
            pbCommenFloorItemViewHolder.p.setOnEmotionClickListener(q08Var.f);
            pbCommenFloorItemViewHolder.p.setOnVoiceAfterClickListener(this.m);
            pbCommenFloorItemViewHolder.P.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.Q.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.S.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.v.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.w.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.m0.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.q0.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.q0.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.i0.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.r0.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.j0.setOnClickListener(new n(this, pbCommenFloorItemViewHolder));
            s08 s08Var = this.a.P().e;
            pbCommenFloorItemViewHolder.x.setOnClickListener(this.m);
            pbCommenFloorItemViewHolder.y.setOnClickListener(new a(this, pbCommenFloorItemViewHolder, s08Var));
            pbCommenFloorItemViewHolder.n.x = new b(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.h0.x = new c(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.h0.setAfterClickListener(new d(this, i2, pbCommenFloorItemViewHolder));
        }
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.v = z;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.r = z;
        }
    }

    public void u0(lw7 lw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, lw7Var) == null) {
            this.o = lw7Var;
        }
    }

    public void v0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, sVar) == null) {
            this.g = sVar;
        }
    }

    public final void w0(TextView textView, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, textView, tbImageView) == null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new m(this, textView, tbImageView));
        }
    }

    public final void x0(TbImageView tbImageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048627, this, tbImageView, z) == null) || tbImageView == null) {
            return;
        }
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.setMargins(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds_16), ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
            tbImageView.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams2.setMargins(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
        tbImageView.setLayoutParams(layoutParams2);
    }

    public final void y0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            A0(pbCommenFloorItemViewHolder.h);
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    lz7.m(pbCommenFloorItemViewHolder.f);
                } else {
                    hv4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.r.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.r.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.u, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.v, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.v, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.x, R.drawable.obfuscated_res_0x7f0809aa, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f0809ab, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.u.d();
            pbCommenFloorItemViewHolder.s.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.V, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.T, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.S, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.U, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.W, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.Z, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.X.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.Z.setText(R.string.obfuscated_res_0x7f0f03fb);
            } else {
                jv7 jv7Var = this.k;
                if (jv7Var != null && StringUtils.isNull(jv7Var.k())) {
                    pbCommenFloorItemViewHolder.Z.setText(this.k.k());
                } else {
                    pbCommenFloorItemViewHolder.Z.setText(R.string.obfuscated_res_0x7f0f05e6);
                }
            }
            pbCommenFloorItemViewHolder.n.L(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.i0, R.drawable.obfuscated_res_0x7f080985, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.r0, R.drawable.obfuscated_res_0x7f080985, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    public void z0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, pbCommenFloorItemViewHolder, postData) == null) {
            String str = "#7F66FE";
            if (postData.j0() != null) {
                VirtualImageCustomFigure j0 = postData.j0();
                pbCommenFloorItemViewHolder.x0.setHeadImageViewResource(j0.getFigureUrl());
                pbCommenFloorItemViewHolder.x0.setTid(postData.L());
                pbCommenFloorItemViewHolder.x0.setLocate(pz7.c);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(j0.getBackGroundType())) {
                    str = j0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.x0.setHeadImageBackgroundColorResource(j0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(j0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.x0.setHeadImageBackgroundResource(j0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.x0.d(postData.s());
                pbCommenFloorItemViewHolder.v0.setVisibility(8);
                pbCommenFloorItemViewHolder.y0.setVisibility(0);
                pbCommenFloorItemViewHolder.x0.setTag(R.id.obfuscated_res_0x7f092092, postData.s().getUserId());
                pbCommenFloorItemViewHolder.x0.setTag(R.id.obfuscated_res_0x7f09209a, postData.s().getUserName());
            } else {
                pbCommenFloorItemViewHolder.y0.setVisibility(8);
                pbCommenFloorItemViewHolder.x0.setTag(R.id.obfuscated_res_0x7f092092, null);
                pbCommenFloorItemViewHolder.x0.setTag(R.id.obfuscated_res_0x7f09209a, null);
                pbCommenFloorItemViewHolder.v0.setVisibility(0);
            }
            if (postData.k0() != null && !TextUtils.isEmpty(postData.k0().b())) {
                pbCommenFloorItemViewHolder.w0.setData(postData.k0().b(), null, str);
                pbCommenFloorItemViewHolder.w0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.z0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.z0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.z0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.w0.setTag(R.id.obfuscated_res_0x7f092092, postData.s().getUserId());
                pbCommenFloorItemViewHolder.w0.setTag(R.id.obfuscated_res_0x7f09209a, postData.s().getUserName());
                this.w = pz7.d;
                this.x = pbCommenFloorItemViewHolder.w0.getData();
                pbCommenFloorItemViewHolder.x0.setWithBubble(this.w);
                pbCommenFloorItemViewHolder.x0.setBubbleName(this.x);
            } else {
                if (pbCommenFloorItemViewHolder.z0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.z0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.z0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.w0.setVisibility(8);
                pbCommenFloorItemViewHolder.w0.setTag(R.id.obfuscated_res_0x7f09209a, null);
                pbCommenFloorItemViewHolder.w0.setTag(R.id.obfuscated_res_0x7f092092, null);
                int i2 = pz7.e;
                this.w = i2;
                pbCommenFloorItemViewHolder.x0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.x0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.x0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (postData.j0() != null) {
                pz7.a(2, postData.L(), pz7.c, this.w, this.x);
            }
        }
    }
}
