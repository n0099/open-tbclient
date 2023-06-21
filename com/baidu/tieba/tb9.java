package com.baidu.tieba;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class tb9 extends sb9<b0a, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData c;
    public TbRichTextView.t d;
    public boolean e;
    public String f;
    public View.OnClickListener g;
    public TbRichTextView.z h;
    public q59 i;
    public View.OnLongClickListener j;
    public z99 k;
    public int l;
    public boolean m;
    public boolean n;
    public lg<ConstrainImageLayout> o;
    public lg<TbImageView> p;

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tb9 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b0a a;
            public final /* synthetic */ g b;

            public a(g gVar, b0a b0aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, b0aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = b0aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.b;
                    tb9 tb9Var = gVar.b;
                    tb9Var.k.b.a(null, tb9Var.c, this.a, gVar.a.r.getLayoutStrategy());
                }
            }
        }

        public g(tb9 tb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tb9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b0a b0aVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof b0a) && (b0aVar = (b0a) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b.k != null) {
                xg.a().postDelayed(new a(this, b0aVar), 100L);
                String id = this.b.c.getId();
                if (StringUtils.isNull(id) || "0".equals(id)) {
                    id = this.b.c.getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.c.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", b0aVar.S()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements mg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tb9 a;

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

        public a(tb9 tb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tb9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.mg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.mg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new ConstrainImageLayout(this.a.a.getPageContext().getPageActivity());
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements mg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tb9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public b(tb9 tb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tb9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.mg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.mg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mg
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
        @Override // com.baidu.tieba.mg
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.a.getPageContext().getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tb9 b;

        public c(tb9 tb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tb9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray sparseArray;
            b0a b0aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != null && (view2.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view2.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && this.a.getView() != null) {
                    this.a.getView().setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                }
                this.b.g.onClick(this.a.getView());
                if (view2 != null) {
                    view2.setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (this.a.getView() != null) {
                    this.a.getView().setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (this.a.getView() != null && (sparseArray = (SparseArray) this.a.getView().getTag(R.id.tag_from)) != null && (sparseArray.get(R.id.tag_clip_board) instanceof b0a) && (b0aVar = (b0a) sparseArray.get(R.id.tag_clip_board)) != null && b0aVar.q() != null && b0aVar.o() != null) {
                    rb9.a(b0aVar.o().threadId, TbadkCoreApplication.getCurrentAccount(), b0aVar.S());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public d(tb9 tb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb9Var, pbCommenFloorItemViewHolder, str};
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
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.f.getMeasuredWidth();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.a.G);
                arrayList.add(this.a.i);
                arrayList.add(this.a.y0);
                arrayList.add(this.a.E);
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                zx5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.E, arrayList, pbCommenFloorItemViewHolder.H);
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                by5.a(pbCommenFloorItemViewHolder2.g, pbCommenFloorItemViewHolder2.G, pbCommenFloorItemViewHolder2.j, pbCommenFloorItemViewHolder2.E, pbCommenFloorItemViewHolder2.H, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tb9 a;

        public e(tb9 tb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tb9Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.i != null) {
                    this.a.i.a(view2);
                    return this.a.i.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tb9 a;

        public f(tb9 tb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tb9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ay5.d(String.valueOf(this.a.c.getFid()), this.a.c.getAuthor().getPortrait(), "4", this.a.mContext.getApplicationContext());
                by5.c("c15281", String.valueOf(this.a.c.getFid()), "4");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tb9 b;

        public h(tb9 tb9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tb9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.c != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.p) != null && agreeView.getData() != null) {
                if (view2 == this.a.p.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String id = this.b.c.getId();
                if (StringUtils.isNull(id) || "0".equals(id)) {
                    id = this.b.c.getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.c.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.p.getData().postId).param("obj_source", 1).param("obj_type", i));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tb9(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b69) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = o05.c().g();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.n = false;
        this.o = new lg<>(new a(this), 6, 0);
        this.p = new lg<>(new b(this), 12, 0);
        if (newSubPbActivity != null && newSubPbActivity.L3() != null) {
            this.l = newSubPbActivity.L3().Q0();
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n = z;
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.m = z;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f = str;
        }
    }

    public void K(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) {
            this.c = threadData;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onLongClickListener) == null) {
            this.j = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zVar) == null) {
            this.h = zVar;
        }
    }

    public final void x(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.i);
            pbCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.t.setOnTouchListener(new e(this));
        }
    }

    public final void A(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, pbCommenFloorItemViewHolder, b0aVar) == null) && pbCommenFloorItemViewHolder != null && b0aVar != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.X;
            if (b0aVar.c0) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public final void B(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, View view2, int i) {
        boolean z;
        String diplayIntro;
        boolean z2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder, b0aVar, view2, i) == null) && pbCommenFloorItemViewHolder != null && b0aVar != null) {
            pbCommenFloorItemViewHolder.Z = i;
            b69 b69Var = this.a;
            ThreadData threadData = this.c;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            c69.m(pbCommenFloorItemViewHolder, b0aVar, view2, i, b69Var, threadData, z);
            c69.h(pbCommenFloorItemViewHolder, b0aVar, this.c, i, b0aVar.i0);
            TextView textView = pbCommenFloorItemViewHolder.A0;
            String str = "";
            if (StringUtils.isNull(b0aVar.q().getDiplayIntro())) {
                diplayIntro = "";
            } else {
                diplayIntro = b0aVar.q().getDiplayIntro();
            }
            textView.setText(diplayIntro);
            pbCommenFloorItemViewHolder.B.setVisibility(8);
            pbCommenFloorItemViewHolder.v.setVisibility(0);
            pbCommenFloorItemViewHolder.z.setVisibility(0);
            pbCommenFloorItemViewHolder.A.setVisibility(0);
            pbCommenFloorItemViewHolder.p.setVisibility(0);
            pbCommenFloorItemViewHolder.I.setVisibility(8);
            ImageView imageView = pbCommenFloorItemViewHolder.A;
            if (imageView != null) {
                if (b0aVar.i0) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
            pbCommenFloorItemViewHolder.r.setTid(this.c.getTid());
            pbCommenFloorItemViewHolder.r.setPid(b0aVar.S());
            pbCommenFloorItemViewHolder.r.setPosition(TbRichTextView.Position.SUB_PB);
            b69 b69Var2 = this.a;
            boolean z3 = this.e;
            boolean z4 = this.b;
            if (i != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            c69.i(b69Var2, pbCommenFloorItemViewHolder, b0aVar, view2, z3, z4, z2, this.d);
            c69.j(this.a, pbCommenFloorItemViewHolder, b0aVar, view2, this.c, b0aVar.i0);
            c69.g(this.a, pbCommenFloorItemViewHolder, b0aVar, this.c);
            c69.l(pbCommenFloorItemViewHolder, b0aVar);
            c69.f(pbCommenFloorItemViewHolder, b0aVar, view2, this.e, null);
            A(pbCommenFloorItemViewHolder, b0aVar);
            c69.k(pbCommenFloorItemViewHolder, view2, b0aVar, this.m, false);
            if (b0aVar.i0) {
                pbCommenFloorItemViewHolder.z.setVisibility(8);
                pbCommenFloorItemViewHolder.A.setVisibility(8);
                pbCommenFloorItemViewHolder.o0.setVisibility(0);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.o0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.o0.setPadding(0, 0, 0, 0);
            } else {
                pbCommenFloorItemViewHolder.z.setVisibility(0);
                pbCommenFloorItemViewHolder.o0.setVisibility(8);
            }
            c69.u(this.a.getPageContext(), pbCommenFloorItemViewHolder, b0aVar);
            if (b0aVar.q() != null) {
                str = b0aVar.q().getName_show();
            }
            pbCommenFloorItemViewHolder.g.setText(str);
            pbCommenFloorItemViewHolder.f.post(new d(this, pbCommenFloorItemViewHolder, str));
        }
    }

    public final void C(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, b0aVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            if (StringHelper.equals(this.f, b0aVar.S())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void D(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048579, this, pbCommenFloorItemViewHolder, b0aVar, i) == null) && pbCommenFloorItemViewHolder != null && b0aVar != null) {
            if (i == 0) {
                pbCommenFloorItemViewHolder.h(b0aVar.f1088T, b0aVar.S(), this.n);
                return;
            }
            boolean z = true;
            if (b0aVar.t0 != 1) {
                z = false;
            }
            pbCommenFloorItemViewHolder.h(z, b0aVar.S(), this.n);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: E */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d08c8, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091a8b)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08c7, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.getPageContext(), inflate, this.l);
            pbCommenFloorItemViewHolder.g(true);
            pbCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.o);
            pbCommenFloorItemViewHolder.u.setImageViewPool(this.p);
            y(pbCommenFloorItemViewHolder);
            c69.s(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View F(int i, View view2, ViewGroup viewGroup, b0a b0aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, b0aVar, pbCommenFloorItemViewHolder})) == null) {
            z(pbCommenFloorItemViewHolder, b0aVar, i);
            G(pbCommenFloorItemViewHolder);
            x(pbCommenFloorItemViewHolder);
            b0a b0aVar2 = (b0a) getItem(i);
            if (b0aVar2 != null) {
                b0aVar2.y1();
                B(pbCommenFloorItemViewHolder, b0aVar2, view2, i);
                C(pbCommenFloorItemViewHolder, b0aVar);
                D(pbCommenFloorItemViewHolder, b0aVar, i);
            }
            c69.s(pbCommenFloorItemViewHolder);
            View view3 = pbCommenFloorItemViewHolder.J;
            int i3 = 0;
            if (i == 0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view3.setVisibility(i2);
            pbCommenFloorItemViewHolder.A0.setVisibility((i != 0 || StringUtils.isNull(b0aVar2.q().getDiplayIntro())) ? 8 : 8);
            if (b0aVar2 != null && b0aVar2.q() != null && b0aVar2.o() != null) {
                rb9.b("2", String.valueOf(b0aVar2.o().threadId), TbadkCoreApplication.getCurrentAccount(), b0aVar2.S(), b0aVar2.O(), b0aVar2.P());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void G(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.j);
            b69 b69Var = this.a;
            if (b69Var != null && b69Var.getPageContext().getOrignalPage() != null) {
                x99 I0 = this.a.I0();
                if (I0 != null) {
                    pbCommenFloorItemViewHolder.g.setOnClickListener(I0.b);
                    pbCommenFloorItemViewHolder.q.setOnClickListener(I0.b);
                    pbCommenFloorItemViewHolder.F.setOnClickListener(I0.b);
                    pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(I0.b);
                    pbCommenFloorItemViewHolder.r.setOnEmotionClickListener(I0.f);
                }
                pbCommenFloorItemViewHolder.r.setOnLongClickListener(this.j);
                pbCommenFloorItemViewHolder.r.setOnImageClickListener(this.h);
                pbCommenFloorItemViewHolder.r.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.getView().setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.L.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.N.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.m0.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.i0.setOnClickListener(this.g);
                if (this.k == null) {
                    this.k = new z99(this.a.getPageContext());
                }
                pbCommenFloorItemViewHolder.E.setOnClickListener(new f(this));
                pbCommenFloorItemViewHolder.z.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.A.setOnClickListener(new g(this, pbCommenFloorItemViewHolder));
                pbCommenFloorItemViewHolder.p.D = new h(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.o0.setOnClickListener(this.g);
            }
        }
    }

    @Override // com.baidu.tieba.sb9, com.baidu.tieba.jn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        F(i, view2, viewGroup, (b0a) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pbCommenFloorItemViewHolder) == null) {
            if (pbCommenFloorItemViewHolder.J.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams.height = c69.n(R.dimen.tbds2);
            layoutParams.leftMargin = c69.n(R.dimen.tbds148);
            pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
            LinearLayout linearLayout = (LinearLayout) pbCommenFloorItemViewHolder.getView().findViewById(R.id.obfuscated_res_0x7f091172);
            if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams2.leftMargin = c69.n(R.dimen.tbds21);
            layoutParams2.rightMargin = c69.n(R.dimen.tbds1);
            linearLayout.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(new c(this, pbCommenFloorItemViewHolder));
        }
    }

    public final void z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, b0a b0aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, pbCommenFloorItemViewHolder, b0aVar, i) == null) {
            ImageView imageView = pbCommenFloorItemViewHolder.z;
            if (imageView != null) {
                SparseArray sparseArray = (SparseArray) imageView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, b0aVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.A;
            if (imageView2 != null) {
                SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.A.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, b0aVar);
                sparseArray2.put(R.id.tag_is_subpb, Boolean.valueOf(!b0aVar.i0));
            }
        }
    }
}
