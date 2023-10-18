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
import com.baidu.adp.lib.safe.SafeHandler;
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
public class ln9 extends kn9<pea, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData c;
    public TbRichTextView.t d;
    public boolean e;
    public String f;
    public View.OnClickListener g;
    public TbRichTextView.z h;
    public tg9 i;
    public View.OnLongClickListener j;
    public pl9 k;
    public int l;
    public boolean m;
    public boolean n;
    public ya<ConstrainImageLayout> o;
    public ya<TbImageView> p;

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ln9 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ pea a;
            public final /* synthetic */ g b;

            public a(g gVar, pea peaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, peaVar};
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
                this.a = peaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.b;
                    ln9 ln9Var = gVar.b;
                    ln9Var.k.b.a(null, ln9Var.c, this.a, gVar.a.r.getLayoutStrategy());
                }
            }
        }

        public g(ln9 ln9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ln9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            pea peaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof pea) && (peaVar = (pea) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b.k != null) {
                SafeHandler.getInst().postDelayed(new a(this, peaVar), 100L);
                String id = this.b.c.getId();
                if (StringUtils.isNull(id) || "0".equals(id)) {
                    id = this.b.c.getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.c.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", peaVar.U()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements za<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ln9 a;

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

        public a(ln9 ln9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ln9Var;
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
                return new ConstrainImageLayout(this.a.a.getPageContext().getPageActivity());
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements za<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ln9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public b(ln9 ln9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ln9Var;
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
        public final /* synthetic */ ln9 b;

        public c(ln9 ln9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ln9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray sparseArray;
            pea peaVar;
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
                if (this.a.getView() != null && (sparseArray = (SparseArray) this.a.getView().getTag(R.id.tag_from)) != null && (sparseArray.get(R.id.tag_clip_board) instanceof pea) && (peaVar = (pea) sparseArray.get(R.id.tag_clip_board)) != null && peaVar.t() != null && peaVar.p() != null) {
                    jn9.a(peaVar.p().threadId, TbadkCoreApplication.getCurrentAccount(), peaVar.U());
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

        public d(ln9 ln9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln9Var, pbCommenFloorItemViewHolder, str};
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
                arrayList.add(this.a.j);
                arrayList.add(this.a.y0);
                arrayList.add(this.a.E);
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                ss5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.E, arrayList, pbCommenFloorItemViewHolder.H);
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                us5.a(pbCommenFloorItemViewHolder2.g, pbCommenFloorItemViewHolder2.G, pbCommenFloorItemViewHolder2.k, pbCommenFloorItemViewHolder2.E, pbCommenFloorItemViewHolder2.H, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ln9 a;

        public e(ln9 ln9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ln9Var;
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
        public final /* synthetic */ ln9 a;

        public f(ln9 ln9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ln9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ts5.d(String.valueOf(this.a.c.getFid()), this.a.c.getAuthor().getPortrait(), "4", this.a.mContext.getApplicationContext());
                us5.c("c15281", String.valueOf(this.a.c.getFid()), "4");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ln9 b;

        public h(ln9 ln9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ln9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ln9Var;
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
    public ln9(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
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
                super((lh9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = uu4.c().g();
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.n = false;
        this.o = new ya<>(new a(this), 6, 0);
        this.p = new ya<>(new b(this), 12, 0);
        if (newSubPbActivity != null && newSubPbActivity.k3() != null) {
            this.l = newSubPbActivity.k3().J0();
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

    public final void A(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.X;
            if (peaVar.d0) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public final void B(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar, View view2, int i) {
        String str;
        String diplayIntro;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder, peaVar, view2, i) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            pbCommenFloorItemViewHolder.Z = i;
            ThreadData threadData = this.c;
            if (threadData != null && threadData.getAuthor() != null) {
                str = this.c.getAuthor().getUserId();
            } else {
                str = null;
            }
            xk9.g(pbCommenFloorItemViewHolder, peaVar, view2, i, this.c, str, xk9.r(this.a), R.color.CAM_X0106, null, this.a.getPageContext().getPageActivity(), false, xk9.x(this.a), xk9.u(this.a));
            mh9.l(pbCommenFloorItemViewHolder, peaVar, this.c, i, peaVar.j0);
            TextView textView = pbCommenFloorItemViewHolder.A0;
            String str2 = "";
            if (StringUtils.isNull(peaVar.t().getDiplayIntro())) {
                diplayIntro = "";
            } else {
                diplayIntro = peaVar.t().getDiplayIntro();
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
                if (peaVar.j0) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
            pbCommenFloorItemViewHolder.r.setTid(this.c.getTid());
            pbCommenFloorItemViewHolder.r.setPid(peaVar.U());
            pbCommenFloorItemViewHolder.r.setPosition(TbRichTextView.Position.SUB_PB);
            lh9 lh9Var = this.a;
            boolean z2 = this.e;
            boolean z3 = this.b;
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            mh9.m(lh9Var, pbCommenFloorItemViewHolder, peaVar, view2, z2, z3, z, this.d);
            mh9.n(this.a, pbCommenFloorItemViewHolder, peaVar, view2, this.c, peaVar.j0);
            mh9.k(this.a, pbCommenFloorItemViewHolder, peaVar, this.c);
            mh9.p(pbCommenFloorItemViewHolder, peaVar);
            mh9.j(pbCommenFloorItemViewHolder, peaVar, view2, this.e, null);
            A(pbCommenFloorItemViewHolder, peaVar);
            mh9.o(pbCommenFloorItemViewHolder, view2, peaVar, this.m, false);
            if (peaVar.j0) {
                pbCommenFloorItemViewHolder.z.setVisibility(8);
                pbCommenFloorItemViewHolder.A.setVisibility(8);
                pbCommenFloorItemViewHolder.o0.setVisibility(0);
                WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.o0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                pbCommenFloorItemViewHolder.o0.setPadding(0, 0, 0, 0);
            } else {
                pbCommenFloorItemViewHolder.z.setVisibility(0);
                pbCommenFloorItemViewHolder.o0.setVisibility(8);
            }
            if (peaVar.t() != null) {
                str2 = peaVar.t().getName_show();
            }
            pbCommenFloorItemViewHolder.f.post(new d(this, pbCommenFloorItemViewHolder, str2));
        }
    }

    public final void C(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, peaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            if (StringHelper.equals(this.f, peaVar.U())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void D(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048579, this, pbCommenFloorItemViewHolder, peaVar, i) == null) && pbCommenFloorItemViewHolder != null && peaVar != null) {
            if (i == 0) {
                pbCommenFloorItemViewHolder.h(peaVar.f1148T, peaVar.U(), this.n);
                return;
            }
            boolean z = true;
            if (peaVar.u0 != 1) {
                z = false;
            }
            pbCommenFloorItemViewHolder.h(z, peaVar.U(), this.n);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: E */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d090d, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091b66)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d090c, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.getPageContext(), inflate, this.l);
            pbCommenFloorItemViewHolder.g(true);
            pbCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.o);
            pbCommenFloorItemViewHolder.u.setImageViewPool(this.p);
            y(pbCommenFloorItemViewHolder);
            mh9.t(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View F(int i, View view2, ViewGroup viewGroup, pea peaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, peaVar, pbCommenFloorItemViewHolder})) == null) {
            z(pbCommenFloorItemViewHolder, peaVar, i);
            G(pbCommenFloorItemViewHolder);
            x(pbCommenFloorItemViewHolder);
            pea peaVar2 = (pea) getItem(i);
            if (peaVar2 != null) {
                peaVar2.C1();
                B(pbCommenFloorItemViewHolder, peaVar2, view2, i);
                C(pbCommenFloorItemViewHolder, peaVar);
                D(pbCommenFloorItemViewHolder, peaVar, i);
            }
            mh9.t(pbCommenFloorItemViewHolder);
            View view3 = pbCommenFloorItemViewHolder.J;
            int i3 = 0;
            if (i == 0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            view3.setVisibility(i2);
            pbCommenFloorItemViewHolder.A0.setVisibility((i != 0 || StringUtils.isNull(peaVar2.t().getDiplayIntro())) ? 8 : 8);
            if (peaVar2 != null && peaVar2.t() != null && peaVar2.p() != null) {
                jn9.b("2", String.valueOf(peaVar2.p().threadId), TbadkCoreApplication.getCurrentAccount(), peaVar2.U(), peaVar2.Q(), peaVar2.R());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void G(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.j);
            lh9 lh9Var = this.a;
            if (lh9Var != null && lh9Var.getPageContext().getOrignalPage() != 0) {
                nl9 X0 = this.a.X0();
                if (X0 != null) {
                    pbCommenFloorItemViewHolder.g.setOnClickListener(X0.b);
                    pbCommenFloorItemViewHolder.q.setOnClickListener(X0.b);
                    pbCommenFloorItemViewHolder.F.setOnClickListener(X0.b);
                    pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(X0.b);
                    pbCommenFloorItemViewHolder.r.setOnEmotionClickListener(X0.f);
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
                    this.k = new pl9(this.a.getPageContext());
                }
                pbCommenFloorItemViewHolder.E.setOnClickListener(new f(this));
                pbCommenFloorItemViewHolder.z.setOnClickListener(this.g);
                pbCommenFloorItemViewHolder.A.setOnClickListener(new g(this, pbCommenFloorItemViewHolder));
                pbCommenFloorItemViewHolder.p.D = new h(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.o0.setOnClickListener(this.g);
            }
        }
    }

    @Override // com.baidu.tieba.lh
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        F(i, view2, viewGroup, (pea) obj, (PbCommenFloorItemViewHolder) viewHolder);
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
            layoutParams.height = mh9.q(R.dimen.tbds2);
            layoutParams.leftMargin = mh9.q(R.dimen.tbds148);
            pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
            LinearLayout linearLayout = (LinearLayout) pbCommenFloorItemViewHolder.getView().findViewById(R.id.obfuscated_res_0x7f0911c8);
            if (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams2.leftMargin = mh9.q(R.dimen.tbds21);
            layoutParams2.rightMargin = mh9.q(R.dimen.tbds1);
            linearLayout.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(new c(this, pbCommenFloorItemViewHolder));
        }
    }

    public final void z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, pea peaVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, pbCommenFloorItemViewHolder, peaVar, i) == null) {
            ImageView imageView = pbCommenFloorItemViewHolder.z;
            if (imageView != null) {
                SparseArray sparseArray = (SparseArray) imageView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, peaVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.A;
            if (imageView2 != null) {
                SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.A.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, peaVar);
                sparseArray2.put(R.id.tag_is_subpb, Boolean.valueOf(!peaVar.j0));
            }
        }
    }
}
