package com.baidu.tieba;

import android.graphics.drawable.Drawable;
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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.underlayer.StatOnceSet;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.ux9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class v1a extends a0a<nwa, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pb<TbImageView> A;
    public ux9 B;
    public int g;
    public TbRichTextView.t h;
    public boolean i;
    public float j;
    public String k;
    public aw9 l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public TbRichTextView.z o;
    public ux9 p;
    public View.OnLongClickListener q;
    public l5a r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public final StatOnceSet<String> y;
    public pb<ConstrainImageLayout> z;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ c3a b;
        public final /* synthetic */ v1a c;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nwa a;
            public final /* synthetic */ l b;

            public a(l lVar, nwa nwaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, nwaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = lVar;
                this.a = nwaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    l lVar = this.b;
                    lVar.b.b.a(lVar.c.l, null, this.a, lVar.a.r.getLayoutStrategy());
                }
            }
        }

        public l(v1a v1aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, c3a c3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar, pbCommenFloorItemViewHolder, c3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v1aVar;
            this.a = pbCommenFloorItemViewHolder;
            this.b = c3aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            nwa nwaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof nwa) && (nwaVar = (nwa) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                SafeHandler.getInst().postDelayed(new a(this, nwaVar), 100L);
                String T2 = this.c.l.T();
                if ((StringUtils.isNull(T2) || "0".equals(this.c.l.T())) && this.c.l.R() != null) {
                    T2 = this.c.l.R().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", T2).param("fid", this.c.l.o()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", nwaVar.U()).param("obj_source", this.c.b0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ v1a b;

        public a(v1a v1aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v1aVar;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.l != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.p) != null && agreeView.getData() != null) {
                if (view2 == this.a.p.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String T2 = this.b.l.T();
                if ((StringUtils.isNull(T2) || "0".equals(this.b.l.T())) && this.b.l.R() != null) {
                    T2 = this.b.l.R().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", T2).param("fid", this.b.l.o()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.p.getData().postId).param("obj_source", this.b.b0(this.a.p)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.o());
                statisticItem.param("tid", this.b.l.T());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.l().U());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.a0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ v1a b;

        public b(v1a v1aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v1aVar;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.l != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.d0) != null && agreeView.getData() != null) {
                if (view2 == this.a.d0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String T2 = this.b.l.T();
                if ((StringUtils.isNull(T2) || "0".equals(this.b.l.T())) && this.b.l.R() != null) {
                    T2 = this.b.l.R().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", T2).param("fid", this.b.l.o()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId).param("obj_source", this.b.b0(this.a.d0)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.o());
                statisticItem.param("tid", this.b.l.T());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.l().U());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.a0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v1a a;

        public c(v1a v1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v1aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.p != null) {
                    this.a.p.a(view2);
                    return this.a.p.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements qb<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v1a a;

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

        public d(v1a v1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v1aVar;
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

    /* loaded from: classes8.dex */
    public class e implements qb<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v1a a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public e(v1a v1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v1aVar;
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

    /* loaded from: classes8.dex */
    public class f implements ux9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v1a a;

        @Override // com.baidu.tieba.ux9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public f(v1a v1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v1aVar;
        }

        @Override // com.baidu.tieba.ux9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.p != null) {
                    if ((view2 instanceof TbListTextView) && this.a.n != null) {
                        this.a.n.onClick(view2);
                        return true;
                    }
                    this.a.p.a(view2);
                    this.a.p.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ux9.a
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
                            this.a.N((RelativeLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.N(view2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ v1a b;

        public g(v1a v1aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v1aVar;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.a.c, R.color.CAM_X0205);
                i6a i6aVar = this.b.a;
                if (i6aVar != null && i6aVar.l0() != null) {
                    this.b.a.l0().z0();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ nwa b;
        public final /* synthetic */ v1a c;

        public h(v1a v1aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar, pbCommenFloorItemViewHolder, nwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v1aVar;
            this.a = pbCommenFloorItemViewHolder;
            this.b = nwaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.S.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.L(this.a, !z, this.b.O());
                this.b.h1(!z);
                this.c.e0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.i7() != null && this.c.b.i7().t1() != null && this.c.b.i7().Z0() != null && !z && this.a.getView().getTop() < this.c.b.i7().t1().getMeasuredHeight()) {
                    this.c.b.i7().Z0().setSelectionFromTop(ListUtils.getPosition(this.c.b.i7().Z0().getData(), this.b) + this.c.b.i7().Z0().getHeaderViewsCount(), this.c.b.i7().t1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ v1a b;

        public i(v1a v1aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v1aVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 7, this.a);
            BrowserHelper.startWebActivity(this.b.mContext, (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nwa a;
        public final /* synthetic */ v1a b;

        public j(v1a v1aVar, nwa nwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar, nwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v1aVar;
            this.a = nwaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nwa nwaVar = this.a;
                if (nwaVar != null && nwaVar.u() != null) {
                    av5.d(this.b.l.o(), this.a.u().getPortrait(), "3", this.b.c.getContext());
                }
                bv5.c("c15281", this.b.l.o(), "3");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public k(v1a v1aVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar, pbCommenFloorItemViewHolder};
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1a(i6a i6aVar, BdUniqueId bdUniqueId) {
        super(i6aVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i6aVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i6a) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 0;
        this.h = null;
        this.i = true;
        this.j = 1.0f;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.u = true;
        this.w = true;
        this.x = false;
        this.y = new StatOnceSet<>();
        this.z = new pb<>(new d(this), 6, 0);
        this.A = new pb<>(new e(this), 12, 0);
        this.B = new ux9(new f(this));
        if (i6aVar != null && i6aVar.l0() != null) {
            this.v = i6aVar.l0().r1();
        }
        this.g = t(R.dimen.tbds14);
    }

    public final void H(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.p);
            pbCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.t.setOnTouchListener(new c(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.i = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            this.q = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.s = i2;
        }
    }

    public void i0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            this.j = f2;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.t = z;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void k0(ux9 ux9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, ux9Var) == null) {
            this.p = ux9Var;
        }
    }

    public void l0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, tVar) == null) {
            this.h = tVar;
        }
    }

    public void o(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, zVar) == null) {
            this.o = zVar;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.k = str;
        }
    }

    public void s(aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, aw9Var) == null) {
            this.l = aw9Var;
        }
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, nwaVar) == null) && pbCommenFloorItemViewHolder != null && nwaVar != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.X;
            if (nwaVar.f0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, nwaVar) == null) && pbCommenFloorItemViewHolder != null && nwaVar != null) {
            pbCommenFloorItemViewHolder.f(nwaVar.f1129T, nwaVar.U(), this.x);
        }
    }

    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbCommenFloorItemViewHolder, nwaVar) == null) {
            TbRichText f0 = nwaVar.f0();
            f0.isChanged = true;
            pbCommenFloorItemViewHolder.r.setText(f0, true, this.h);
        }
    }

    public final void I(nwa nwaVar) {
        aw9 aw9Var;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nwaVar) == null) && (aw9Var = this.l) != null) {
            if (aw9Var.y0()) {
                AbsVideoPbFragment absVideoPbFragment = this.c;
                if (absVideoPbFragment != null) {
                    BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                    aw9 aw9Var2 = this.l;
                    int i4 = nwaVar.h0;
                    if (nwaVar.g0) {
                        i3 = 2;
                    } else {
                        i3 = 8;
                    }
                    c6a.e(uniqueId, aw9Var2, nwaVar, i4, i3, "common_exp_source_pb_comment");
                    return;
                }
                return;
            }
            PbFragment pbFragment = this.b;
            if (pbFragment != null) {
                BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                aw9 aw9Var3 = this.l;
                int i5 = nwaVar.h0;
                if (nwaVar.g0) {
                    i2 = 2;
                } else {
                    i2 = 8;
                }
                c6a.e(uniqueId2, aw9Var3, nwaVar, i5, i2, "common_exp_source_pb_comment");
            }
        }
    }

    public final void J(nwa nwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nwaVar) == null) && nwaVar.E == 0 && nwaVar.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", nwaVar.U());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            i6a i6aVar = this.a;
            if (i6aVar != null) {
                int r1 = i6aVar.l0().r1();
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
            if (nwaVar.u() != null && nwaVar.u().getAlaInfo() != null && nwaVar.u().getAlaInfo().live_status == 1) {
                f0(nwaVar);
            }
        }
    }

    public final void K(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
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
            tbRichTextView.getLayoutStrategy().r((int) ((equipmentWidth - i3) * this.j));
            tbRichTextView.getLayoutStrategy().q((int) (equipmentWidth * 1.618f * this.j));
        }
    }

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048585, this, pbCommenFloorItemViewHolder, nwaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && nwaVar != null) {
            pbCommenFloorItemViewHolder.B.setVisibility(8);
            pbCommenFloorItemViewHolder.v.setVisibility(0);
            pbCommenFloorItemViewHolder.f0.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.p.setVisibility(8);
            pbCommenFloorItemViewHolder.o0.setVisibility(8);
            j2a.b(pbCommenFloorItemViewHolder, nwaVar, view2, i2, this.l, this.k, k2a.m(this.a), R.color.CAM_X0107, k2a.g(this.l, nwaVar), this.mContext, false, k2a.s(this.a), k2a.n(this.l));
            Z(pbCommenFloorItemViewHolder, nwaVar);
            k2a.c(pbCommenFloorItemViewHolder, nwaVar, this.l);
            R(pbCommenFloorItemViewHolder, nwaVar);
            U(pbCommenFloorItemViewHolder, nwaVar, view2);
            T(pbCommenFloorItemViewHolder, nwaVar, view2, i2);
            k2a.e(pbCommenFloorItemViewHolder, nwaVar, this.l, this.g);
            W(pbCommenFloorItemViewHolder, nwaVar);
            S(pbCommenFloorItemViewHolder, nwaVar);
            X(pbCommenFloorItemViewHolder, nwaVar);
            ny9.j(pbCommenFloorItemViewHolder, nwaVar, view2, this.i, this.B);
            P(pbCommenFloorItemViewHolder, nwaVar);
            V(pbCommenFloorItemViewHolder, nwaVar);
            Y(pbCommenFloorItemViewHolder, nwaVar);
            d4a.d(pbCommenFloorItemViewHolder, nwaVar, this.n, this.y);
            ny9.o(pbCommenFloorItemViewHolder, view2, nwaVar, this.t, true);
        }
    }

    public final void L(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06ff);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.U.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0483);
        }
    }

    public final void M(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, nwaVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.J) != null && pbCommenFloorItemViewHolder.f1133T != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.f1133T.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(nwaVar.k0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.f1133T.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(0);
                if (z2) {
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
                pbCommenFloorItemViewHolder.f1133T.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
            }
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048589, this, pbCommenFloorItemViewHolder, nwaVar, view2) == null) && pbCommenFloorItemViewHolder != null && nwaVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
            if (!this.i) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.r.p0(null);
                pbCommenFloorItemViewHolder.r.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().z(R.drawable.pic_video);
            K(pbCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(nwaVar.x()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.r.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.r.setText(nwaVar.f0(), true, this.h);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, nwaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.o0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.e0.setTag(sparseArray);
        }
    }

    public final void N(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).d0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.d0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.d0.N();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.l.o());
            statisticItem.param("tid", this.l.T());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.l.l().U());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", a0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: c0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07e9, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091c24)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07e1, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.u0().getPageContext(), inflate, this.v);
            pbCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.z);
            pbCommenFloorItemViewHolder.u.setImageViewPool(this.A);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.w;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.w);
                pbCommenFloorItemViewHolder.w.setIsVideoThread(true);
            }
            m0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.r;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.u);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void f0(nwa nwaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, nwaVar) == null) {
            String userId = nwaVar.u().getUserId();
            aw9 aw9Var = this.l;
            String str2 = "";
            if (aw9Var == null) {
                str = "";
            } else {
                str = aw9Var.o();
            }
            aw9 aw9Var2 = this.l;
            if (aw9Var2 != null) {
                str2 = aw9Var2.p();
            }
            int L = nwaVar.L();
            String U = nwaVar.U();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", U);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, L);
            if (nwaVar.u().getAlaInfo() != null) {
                AlaInfoData alaInfo = nwaVar.u().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void O(nwa nwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, nwaVar) == null) && nwaVar != null) {
            int i2 = 8;
            if (nwaVar.g0) {
                i2 = 2;
            }
            StatisticItem k2 = c6a.k(this.l, nwaVar, nwaVar.h0, i2, 6);
            nwaVar.i0 = k2;
            if (!ListUtils.isEmpty(nwaVar.k0())) {
                Iterator<nwa> it = nwaVar.k0().iterator();
                while (it.hasNext()) {
                    it.next().i0 = k2;
                }
            }
        }
    }

    public final String b0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, view2)) == null) {
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

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, nwaVar) == null) && pbCommenFloorItemViewHolder != null && nwaVar != null && nwaVar.p() != null) {
            nwaVar.p().threadId = this.a.l0().M1();
            nwaVar.p().objType = 1;
            nwaVar.p().isInPost = true;
            ThreadData threadData = null;
            aw9 aw9Var = this.l;
            if (aw9Var != null && aw9Var.R() != null) {
                threadData = this.l.R();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.p.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.p.setThreadData(threadData);
            pbCommenFloorItemViewHolder.p.setData(nwaVar.p());
            pbCommenFloorItemViewHolder.d0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.d0.setData(nwaVar.p());
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, nwaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            i6a i6aVar = this.a;
            if (i6aVar != null && i6aVar.l0() != null && StringHelper.equals(this.a.l0().T0(), nwaVar.U())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                return;
            }
            i6a i6aVar2 = this.a;
            if (i6aVar2 != null && i6aVar2.l0() != null && StringHelper.equals(this.a.l0().S0(), nwaVar.U())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                SafeHandler.getInst().postDelayed(new g(this, pbCommenFloorItemViewHolder), 3000L);
                return;
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, nwaVar) == null) {
            if (nwaVar != null && nwaVar.u() != null && nwaVar.n0() != null) {
                TbRichText f0 = nwaVar.f0();
                if (f0 != null && StringUtils.isNull(f0.toString()) && StringUtils.isNull(nwaVar.x())) {
                    z = true;
                } else {
                    z = false;
                }
                if (nwaVar.u().getSmallTailThemeData() != null) {
                    str = nwaVar.u().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.L.setTag(R.id.tag_pb_small_tail_theme_id, str);
                t6a.c(nwaVar.n0(), pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, pbCommenFloorItemViewHolder.M, false, false, z, nwaVar.u().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.K.setVisibility(8);
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, nwaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.Q != null && pbCommenFloorItemViewHolder.N != null) {
            if (nwaVar != null && (alaLiveInfoCoreData = nwaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.Q.setText(nwaVar.U.liveTitle);
                pbCommenFloorItemViewHolder.N.setTag(nwaVar.U);
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

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, nwaVar) == null) {
            if (nwaVar.P() != 2 && nwaVar.P() != 4) {
                pbCommenFloorItemViewHolder.f1133T.setVisibility(8);
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                M(false, pbCommenFloorItemViewHolder, nwaVar);
            } else {
                pbCommenFloorItemViewHolder.f1133T.setOnClickListener(new h(this, pbCommenFloorItemViewHolder, nwaVar));
                pbCommenFloorItemViewHolder.f1133T.setVisibility(0);
                L(pbCommenFloorItemViewHolder, nwaVar.H0(), nwaVar.O());
                M(true, pbCommenFloorItemViewHolder, nwaVar);
            }
            e0(pbCommenFloorItemViewHolder, nwaVar);
        }
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, nwaVar) == null) && pbCommenFloorItemViewHolder != null && nwaVar != null && TbSingleton.getInstance().isUserGrowthOpen() && nwaVar.u().getUserGrowthData() != null) {
            int a2 = nwaVar.u().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                pbCommenFloorItemViewHolder.k.setImageResource(ss.b(a2));
                pbCommenFloorItemViewHolder.k.setVisibility(0);
                pbCommenFloorItemViewHolder.k.setOnClickListener(new i(this, a2));
                CommonStatisticUtils.staticNameplateOfUserLevel(1, 7, a2);
                return;
            }
            pbCommenFloorItemViewHolder.k.setVisibility(8);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048588, this, pbCommenFloorItemViewHolder, nwaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && nwaVar != null) {
            if (nwaVar.m0() > 0) {
                pbCommenFloorItemViewHolder.y.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.y.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, nwaVar);
                if (nwaVar.P() == 2) {
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
                sparseArray2.put(R.id.tag_load_sub_data, nwaVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.A;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.A.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, nwaVar);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            boolean z = true;
            if (!nwaVar.B0() && !nwaVar.A0(true)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.w.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.w.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.w.getLayoutParams();
                layoutParams2.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds10);
                layoutParams2.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.w.setLayoutParams(layoutParams2);
                if (this.r == null) {
                    l5a l5aVar = new l5a(this.mContext);
                    this.r = l5aVar;
                    l5aVar.f(this.e);
                    this.r.h(this.m);
                    this.r.e(this.n);
                    String str = null;
                    aw9 aw9Var = this.l;
                    if (aw9Var != null && aw9Var.R() != null && this.l.R().getAuthor() != null) {
                        str = this.l.R().getAuthor().getUserId();
                    }
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    aw9 aw9Var2 = this.l;
                    if (aw9Var2 != null) {
                        this.r.j(aw9Var2.Z(), z);
                        this.r.i(this.l.R());
                    }
                }
                this.r.g(nwaVar.U());
                pbCommenFloorItemViewHolder.w.setSubPbAdapter(this.r);
                pbCommenFloorItemViewHolder.w.setVisibility(0);
                pbCommenFloorItemViewHolder.w.setData(nwaVar, view2);
                pbCommenFloorItemViewHolder.w.setChildOnClickListener(this.n);
                pbCommenFloorItemViewHolder.w.setChildOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.w.setChildOnTouchListener(this.B);
            }
            if (nwaVar.P) {
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

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public View d0(int i2, View view2, ViewGroup viewGroup, nwa nwaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, nwaVar, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) nwaVar, (nwa) pbCommenFloorItemViewHolder);
            m0(pbCommenFloorItemViewHolder);
            h0(pbCommenFloorItemViewHolder, nwaVar);
            H(pbCommenFloorItemViewHolder);
            nwa nwaVar2 = (nwa) getItem(i2);
            if (nwaVar2 != null) {
                nwaVar2.h0 = i2 + 1;
                J(nwaVar2);
                I(nwaVar2);
                nwaVar2.G1();
                O(nwaVar2);
                Q(pbCommenFloorItemViewHolder, nwaVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void h0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, pbCommenFloorItemViewHolder, nwaVar) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.B);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.q);
            if (this.a.u0() != null && this.a.u0().getPageContext() != null && this.a.u0().getPageContext().getOrignalPage() != null) {
                a3a a3aVar = this.a.u0().c;
                pbCommenFloorItemViewHolder.g.setOnClickListener(a3aVar.b);
                pbCommenFloorItemViewHolder.q.setOnClickListener(a3aVar.b);
                pbCommenFloorItemViewHolder.F.setOnClickListener(a3aVar.b);
                pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(a3aVar.b);
                pbCommenFloorItemViewHolder.r.setOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.r.setOnTouchListener(this.B);
                pbCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(this.n);
                pbCommenFloorItemViewHolder.r.setOnImageClickListener(this.o);
                pbCommenFloorItemViewHolder.r.setOnImageTouchListener(this.B);
                pbCommenFloorItemViewHolder.r.setOnEmotionClickListener(a3aVar.f);
                pbCommenFloorItemViewHolder.r.setOnVoiceAfterClickListener(this.n);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.L.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.N.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.i0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.m0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.E.setOnClickListener(new j(this, nwaVar));
                pbCommenFloorItemViewHolder.e0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.o0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.f0.setOnClickListener(new k(this, pbCommenFloorItemViewHolder));
                c3a c3aVar = this.a.u0().d;
                pbCommenFloorItemViewHolder.z.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.A.setOnClickListener(new l(this, pbCommenFloorItemViewHolder, c3aVar));
                pbCommenFloorItemViewHolder.p.D = new a(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.d0.D = new b(this, pbCommenFloorItemViewHolder);
            }
        }
    }

    public final void m0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            k2a.w(pbCommenFloorItemViewHolder.i, this.l, this.k);
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
            if (pbCommenFloorItemViewHolder.S.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0483);
            } else {
                aw9 aw9Var = this.l;
                if (aw9Var != null && StringUtils.isNull(aw9Var.m())) {
                    pbCommenFloorItemViewHolder.U.setText(this.l.m());
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

    @Override // com.baidu.tieba.a0a, com.baidu.tieba.ci
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        d0(i2, view2, viewGroup, (nwa) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }
}
