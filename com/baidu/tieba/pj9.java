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
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
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
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.gg9;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class pj9 extends wh9<yca, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gg9 A;
    public int g;
    public TbRichTextView.t h;
    public boolean i;
    public float j;
    public String k;
    public ze9 l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public TbRichTextView.z o;
    public gg9 p;
    public View.OnLongClickListener q;
    public gm9 r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public ng<ConstrainImageLayout> y;
    public ng<TbImageView> z;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ qk9 b;
        public final /* synthetic */ pj9 c;

        /* renamed from: com.baidu.tieba.pj9$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0454a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yca a;
            public final /* synthetic */ a b;

            public RunnableC0454a(a aVar, yca ycaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ycaVar};
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
                this.a = ycaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    aVar.b.b.a(aVar.c.l, null, this.a, aVar.a.r.getLayoutStrategy());
                }
            }
        }

        public a(pj9 pj9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, qk9 qk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var, pbCommenFloorItemViewHolder, qk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pj9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = qk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            yca ycaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof yca) && (ycaVar = (yca) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                zg.a().postDelayed(new RunnableC0454a(this, ycaVar), 100L);
                String P = this.c.l.P();
                if ((StringUtils.isNull(P) || "0".equals(this.c.l.P())) && this.c.l.N() != null) {
                    P = this.c.l.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.c.l.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", ycaVar.S()).param("obj_source", this.c.g0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ pj9 b;

        public b(pj9 pj9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pj9Var;
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
                String P = this.b.l.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.l.P())) && this.b.l.N() != null) {
                    P = this.b.l.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.b.l.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.p.getData().postId).param("obj_source", this.b.g0(this.a.p)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.l());
                statisticItem.param("tid", this.b.l.P());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.i().S());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.f0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ pj9 b;

        public c(pj9 pj9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pj9Var;
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
                String P = this.b.l.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.l.P())) && this.b.l.N() != null) {
                    P = this.b.l.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.b.l.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId).param("obj_source", this.b.g0(this.a.d0)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.l());
                statisticItem.param("tid", this.b.l.P());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.i().S());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.f0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pj9 a;

        public d(pj9 pj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pj9Var;
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

    /* loaded from: classes7.dex */
    public class e implements og<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pj9 a;

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

        public e(pj9 pj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pj9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
    public class f implements og<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pj9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public f(pj9 pj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pj9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
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
        @Override // com.baidu.tieba.og
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
    public class g implements gg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pj9 a;

        @Override // com.baidu.tieba.gg9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public g(pj9 pj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pj9Var;
        }

        @Override // com.baidu.tieba.gg9.a
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

        @Override // com.baidu.tieba.gg9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.L5() != null && !this.a.b.L5().O1()) || view2.getId() == R.id.obfuscated_res_0x7f090b60)) {
                    return true;
                }
                if (view2 instanceof FrameLayout) {
                    this.a.P(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof FrameLayout) {
                            this.a.P((RelativeLayout) parent);
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

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ pj9 b;

        public h(pj9 pj9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pj9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.a.c, R.color.CAM_X0205);
                bn9 bn9Var = this.b.a;
                if (bn9Var != null && bn9Var.Q() != null) {
                    this.b.a.Q().G0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ yca b;
        public final /* synthetic */ pj9 c;

        public i(pj9 pj9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var, pbCommenFloorItemViewHolder, ycaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pj9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = ycaVar;
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
                this.c.N(this.a, !z, this.b.L());
                this.b.a1(!z);
                this.c.k0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.L5() != null && this.c.b.L5().o1() != null && this.c.b.L5().X0() != null && !z && this.a.getView().getTop() < this.c.b.L5().o1().getMeasuredHeight()) {
                    this.c.b.L5().X0().setSelectionFromTop(ListUtils.getPosition(this.c.b.L5().X0().getData(), this.b) + this.c.b.L5().X0().getHeaderViewsCount(), this.c.b.L5().o1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ pj9 b;

        public j(pj9 pj9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pj9Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 7, this.a);
            nx4.v(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public k(pj9 pj9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var, pbCommenFloorItemViewHolder, str};
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
                iz5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.E, arrayList, pbCommenFloorItemViewHolder.H);
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                kz5.a(pbCommenFloorItemViewHolder2.g, pbCommenFloorItemViewHolder2.G, pbCommenFloorItemViewHolder2.j, pbCommenFloorItemViewHolder2.E, pbCommenFloorItemViewHolder2.H, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yca a;
        public final /* synthetic */ pj9 b;

        public l(pj9 pj9Var, yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var, ycaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pj9Var;
            this.a = ycaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.mContext != null && this.b.l != null && this.a.q() != null && StringUtils.isNotNull(this.a.q().getPortrait())) {
                jz5.d(this.b.l.l(), this.a.q().getPortrait(), "3", this.b.mContext);
                kz5.c("c15281", this.b.l.l(), "3");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public m(pj9 pj9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pj9Var, pbCommenFloorItemViewHolder};
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
    public pj9(bn9 bn9Var, BdUniqueId bdUniqueId) {
        super(bn9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bn9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bn9) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.y = new ng<>(new e(this), 6, 0);
        this.z = new ng<>(new f(this), 12, 0);
        this.A = new gg9(new g(this));
        if (bn9Var != null && bn9Var.Q() != null) {
            this.v = bn9Var.Q().y1();
        }
        this.g = s(R.dimen.tbds14);
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null && (imageView = pbCommenFloorItemViewHolder.I) != null && this.l != null) {
            imageView.setVisibility(8);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.X;
            if (ycaVar.c0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            pbCommenFloorItemViewHolder.i(ycaVar.f1185T, ycaVar.S(), this.x);
        }
    }

    public final void k0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, pbCommenFloorItemViewHolder, ycaVar) == null) {
            TbRichText e0 = ycaVar.e0();
            e0.isChanged = true;
            pbCommenFloorItemViewHolder.r.setText(e0, true, this.h);
        }
    }

    public final void I(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.p);
            pbCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.t.setOnTouchListener(new d(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.i = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onLongClickListener) == null) {
            this.q = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.s = i2;
        }
    }

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, zVar) == null) {
            this.o = zVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.k = str;
        }
    }

    public void o0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
            this.j = f2;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.t = z;
        }
    }

    public void q0(gg9 gg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, gg9Var) == null) {
            this.p = gg9Var;
        }
    }

    public void r(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, ze9Var) == null) {
            this.l = ze9Var;
        }
    }

    public void r0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, tVar) == null) {
            this.h = tVar;
        }
    }

    public final void t0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof yca)) {
            return;
        }
        u0(textView, (yca) tag);
    }

    public final void J(yca ycaVar) {
        ze9 ze9Var;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ycaVar) == null) && (ze9Var = this.l) != null) {
            if (ze9Var.w0()) {
                AbsVideoPbFragment absVideoPbFragment = this.c;
                if (absVideoPbFragment != null) {
                    BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                    ze9 ze9Var2 = this.l;
                    int i4 = ycaVar.e0;
                    if (ycaVar.d0) {
                        i3 = 2;
                    } else {
                        i3 = 8;
                    }
                    xm9.e(uniqueId, ze9Var2, ycaVar, i4, i3, "common_exp_source_pb_comment");
                    return;
                }
                return;
            }
            PbFragment pbFragment = this.b;
            if (pbFragment != null) {
                BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                ze9 ze9Var3 = this.l;
                int i5 = ycaVar.e0;
                if (ycaVar.d0) {
                    i2 = 2;
                } else {
                    i2 = 8;
                }
                xm9.e(uniqueId2, ze9Var3, ycaVar, i5, i2, "common_exp_source_pb_comment");
            }
        }
    }

    public final void L(yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ycaVar) == null) && ycaVar.E == 0 && ycaVar.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", ycaVar.S());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            bn9 bn9Var = this.a;
            if (bn9Var != null) {
                int y1 = bn9Var.Q().y1();
                if (1 != y1 && 2 != y1) {
                    if (3 == y1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (ycaVar.q() != null && ycaVar.q().getAlaInfo() != null && ycaVar.q().getAlaInfo().live_status == 1) {
                l0(ycaVar);
            }
        }
    }

    public final void M(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int m2 = ((((yi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                m2 = (m2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (m2 - i3) - s(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                m2 /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((m2 - i3) * this.j));
            tbRichTextView.getLayoutStrategy().q((int) (m2 * 1.618f * this.j));
        }
    }

    public final void N(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06e3);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.U.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0474);
        }
    }

    public final void O(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, ycaVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.J) != null && pbCommenFloorItemViewHolder.f1149T != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.f1149T.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(ycaVar.i0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.f1149T.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.f1149T.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = yi.g(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.r.getLayoutStrategy().n(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = yi.g(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
            }
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048591, this, pbCommenFloorItemViewHolder, ycaVar, view2) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = yi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = yi.g(this.mContext, R.dimen.tbds148);
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
            M(pbCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(ycaVar.t()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.r.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.r.setText(ycaVar.e0(), true, this.h);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, ycaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.o0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.e0.setTag(sparseArray);
        }
    }

    public final void P(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).d0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.d0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.d0.O();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.l.l());
            statisticItem.param("tid", this.l.P());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.l.i().S());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", f0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: i0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07a6, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091af9)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d079f, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.X().getPageContext(), inflate, this.v);
            pbCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.u.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.w;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.w);
                pbCommenFloorItemViewHolder.w.setIsVideoThread(true);
            }
            s0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.r;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.u);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void l0(yca ycaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, ycaVar) == null) {
            String userId = ycaVar.q().getUserId();
            ze9 ze9Var = this.l;
            String str2 = "";
            if (ze9Var == null) {
                str = "";
            } else {
                str = ze9Var.l();
            }
            ze9 ze9Var2 = this.l;
            if (ze9Var2 != null) {
                str2 = ze9Var2.m();
            }
            int I = ycaVar.I();
            String S = ycaVar.S();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", S);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, I);
            if (ycaVar.q().getAlaInfo() != null) {
                AlaInfoData alaInfo = ycaVar.q().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void Q(yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, ycaVar) == null) && ycaVar != null) {
            int i2 = 8;
            if (ycaVar.d0) {
                i2 = 2;
            }
            StatisticItem i3 = xm9.i(this.l, ycaVar, ycaVar.e0, i2, 6);
            ycaVar.f0 = i3;
            if (!ListUtils.isEmpty(ycaVar.i0())) {
                Iterator<yca> it = ycaVar.i0().iterator();
                while (it.hasNext()) {
                    it.next().f0 = i3;
                }
            }
        }
    }

    public final String g0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, view2)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        ze9 ze9Var;
        ze9 ze9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            String str = null;
            boolean z3 = true;
            if (ycaVar.I() > 0 && (ze9Var2 = this.l) != null && !ze9Var2.i0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0b19), Integer.valueOf(ycaVar.I()));
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
                z = false;
            }
            if (ycaVar.q() != null) {
                str = ycaVar.q().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    ci5 Z = ycaVar.Z();
                    z3 = (Z != null || StringUtils.isNull(Z.b()) || (ze9Var = this.l) == null || ze9Var.i0()) ? false : false;
                    if (!z) {
                        pbCommenFloorItemViewHolder.l.setVisibility(0);
                        i2 = this.g;
                    } else {
                        pbCommenFloorItemViewHolder.l.setVisibility(8);
                        i2 = 0;
                    }
                    if (z3 && !z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                        i3 = 0;
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                        i3 = this.g;
                    }
                    pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(ycaVar.p0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(ycaVar.p0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(ycaVar.p0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setPadding(this.g, 0, 0, 0);
                        TextView textView = pbCommenFloorItemViewHolder.o;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.o.setVisibility(0);
                        pbCommenFloorItemViewHolder.o.setPadding(this.g, 0, 0, 0);
                        if (ycaVar.c0) {
                            pbCommenFloorItemViewHolder.o.setText(StringHelper.cutStringWithSuffix(Z.b(), 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.o.setText(Z.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.o.setVisibility(8);
                    }
                    TextView textView2 = pbCommenFloorItemViewHolder.g0;
                    textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            ci5 Z2 = ycaVar.Z();
            if (Z2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            i3 = this.g;
            pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(ycaVar.p0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView22 = pbCommenFloorItemViewHolder.g0;
            textView22.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void u0(TextView textView, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048623, this, textView, ycaVar) == null) {
            if (textView == null && ycaVar == null) {
                return;
            }
            textView.setTag(ycaVar);
            ze9 ze9Var = this.l;
            if (ze9Var != null && ze9Var.i0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (ycaVar.q() != null) {
                MetaData q = ycaVar.q();
                String str = this.k;
                if (str != null && !"0".equals(str) && this.k.equals(q.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    d85 d2 = d85.d(textView);
                    d2.o(R.string.J_X04);
                    d2.m(R.dimen.L_X01);
                    d2.x(R.color.CAM_X0302);
                    d2.l(R.color.CAM_X0302);
                } else if (q.getIs_bawu() == 1 && ycaVar.B0()) {
                    d85 d3 = d85.d(textView);
                    d3.x(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (q.getIs_bawu() == 1 && "manager".equals(q.getBawu_type())) {
                    d85 d4 = d85.d(textView);
                    d4.x(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (q.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(q.getBawu_type())) {
                    d85 d5 = d85.d(textView);
                    d5.x(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (q.getIs_bawu() == 1 && "pri_content_assist".equals(q.getBawu_type())) {
                    d85 d6 = d85.d(textView);
                    d6.x(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (q.getIs_bawu() == 1 && "pri_manage_assist".equals(q.getBawu_type())) {
                    d85 d7 = d85.d(textView);
                    d7.x(R.color.CAM_X0101);
                    d7.o(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048587, this, pbCommenFloorItemViewHolder, ycaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            pbCommenFloorItemViewHolder.B.setVisibility(8);
            pbCommenFloorItemViewHolder.v.setVisibility(0);
            pbCommenFloorItemViewHolder.f0.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.p.setVisibility(8);
            pbCommenFloorItemViewHolder.o0.setVisibility(8);
            d0(pbCommenFloorItemViewHolder, ycaVar, view2, i2);
            e0(pbCommenFloorItemViewHolder, ycaVar);
            R(pbCommenFloorItemViewHolder, ycaVar);
            V(pbCommenFloorItemViewHolder, ycaVar);
            Y(pbCommenFloorItemViewHolder, ycaVar, view2);
            X(pbCommenFloorItemViewHolder, ycaVar, view2, i2);
            S(pbCommenFloorItemViewHolder, ycaVar);
            a0(pbCommenFloorItemViewHolder, ycaVar);
            W(pbCommenFloorItemViewHolder, ycaVar);
            b0(pbCommenFloorItemViewHolder, ycaVar);
            sg9.f(pbCommenFloorItemViewHolder, ycaVar, view2, this.i, this.A);
            T(pbCommenFloorItemViewHolder, ycaVar);
            Z(pbCommenFloorItemViewHolder, ycaVar);
            c0(pbCommenFloorItemViewHolder, ycaVar);
            sg9.k(pbCommenFloorItemViewHolder, view2, ycaVar, this.t, true);
            sg9.u(this.a.X().getPageContext(), pbCommenFloorItemViewHolder, ycaVar);
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null && ycaVar.o() != null) {
            ycaVar.o().threadId = this.a.Q().S1();
            ycaVar.o().objType = 1;
            ycaVar.o().isInPost = true;
            ThreadData threadData = null;
            ze9 ze9Var = this.l;
            if (ze9Var != null && ze9Var.N() != null) {
                threadData = this.l.N();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.p.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.p.setThreadData(threadData);
            pbCommenFloorItemViewHolder.p.setData(ycaVar.o());
            pbCommenFloorItemViewHolder.d0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.d0.setData(ycaVar.o());
        }
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            bn9 bn9Var = this.a;
            if (bn9Var != null && bn9Var.Q() != null && StringHelper.equals(this.a.Q().a1(), ycaVar.S())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                return;
            }
            bn9 bn9Var2 = this.a;
            if (bn9Var2 != null && bn9Var2.Q() != null && StringHelper.equals(this.a.Q().Z0(), ycaVar.S())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                zg.a().postDelayed(new h(this, pbCommenFloorItemViewHolder), 3000L);
                return;
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, ycaVar) == null) {
            if (ycaVar != null && ycaVar.q() != null && ycaVar.l0() != null) {
                TbRichText e0 = ycaVar.e0();
                if (e0 != null && StringUtils.isNull(e0.toString()) && StringUtils.isNull(ycaVar.t())) {
                    z = true;
                } else {
                    z = false;
                }
                if (ycaVar.q().getSmallTailThemeData() != null) {
                    str = ycaVar.q().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.L.setTag(R.id.tag_pb_small_tail_theme_id, str);
                mn9.c(ycaVar.l0(), pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, pbCommenFloorItemViewHolder.M, false, false, z, ycaVar.q().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.K.setVisibility(8);
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.Q != null && pbCommenFloorItemViewHolder.N != null) {
            if (ycaVar != null && (alaLiveInfoCoreData = ycaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.Q.setText(ycaVar.U.liveTitle);
                pbCommenFloorItemViewHolder.N.setTag(ycaVar.U);
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

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, ycaVar) == null) {
            if (ycaVar.M() != 2 && ycaVar.M() != 4) {
                pbCommenFloorItemViewHolder.f1149T.setVisibility(8);
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                O(false, pbCommenFloorItemViewHolder, ycaVar);
            } else {
                pbCommenFloorItemViewHolder.f1149T.setOnClickListener(new i(this, pbCommenFloorItemViewHolder, ycaVar));
                pbCommenFloorItemViewHolder.f1149T.setVisibility(0);
                N(pbCommenFloorItemViewHolder, ycaVar.D0(), ycaVar.L());
                O(true, pbCommenFloorItemViewHolder, ycaVar);
            }
            k0(pbCommenFloorItemViewHolder, ycaVar);
        }
    }

    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, pbCommenFloorItemViewHolder, ycaVar) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null && TbSingleton.getInstance().isUserGrowthOpen() && ycaVar.q().getUserGrowthData() != null) {
            int a2 = ycaVar.q().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                pbCommenFloorItemViewHolder.j.setImageResource(by.b(a2));
                pbCommenFloorItemViewHolder.j.setVisibility(0);
                pbCommenFloorItemViewHolder.j.setOnClickListener(new j(this, a2));
                CommonStatisticUtils.staticNameplateOfUserLevel(1, 7, a2);
                return;
            }
            pbCommenFloorItemViewHolder.j.setVisibility(8);
        }
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048590, this, pbCommenFloorItemViewHolder, ycaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            if (ycaVar.k0() > 0) {
                pbCommenFloorItemViewHolder.y.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.y.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, ycaVar);
                if (ycaVar.M() == 2) {
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
                sparseArray2.put(R.id.tag_load_sub_data, ycaVar);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.A;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.A.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, ycaVar);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            boolean z = true;
            if (!ycaVar.z0() && !ycaVar.y0(true)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.w.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.w.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.w.getLayoutParams();
                layoutParams2.topMargin = yi.g(this.mContext, R.dimen.tbds10);
                layoutParams2.leftMargin = yi.g(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = yi.g(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = yi.g(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.w.setLayoutParams(layoutParams2);
                if (this.r == null) {
                    gm9 gm9Var = new gm9(this.mContext);
                    this.r = gm9Var;
                    gm9Var.f(this.e);
                    this.r.h(this.m);
                    this.r.e(this.n);
                    String str = null;
                    ze9 ze9Var = this.l;
                    if (ze9Var != null && ze9Var.N() != null && this.l.N().getAuthor() != null) {
                        str = this.l.N().getAuthor().getUserId();
                    }
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    ze9 ze9Var2 = this.l;
                    if (ze9Var2 != null) {
                        this.r.j(ze9Var2.V(), z);
                        this.r.i(this.l.N());
                    }
                }
                this.r.g(ycaVar.S());
                pbCommenFloorItemViewHolder.w.setSubPbAdapter(this.r);
                pbCommenFloorItemViewHolder.w.setVisibility(0);
                pbCommenFloorItemViewHolder.w.setData(ycaVar, view2);
                pbCommenFloorItemViewHolder.w.setChildOnClickListener(this.n);
                pbCommenFloorItemViewHolder.w.setChildOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.w.setChildOnTouchListener(this.A);
            }
            if (ycaVar.P) {
                pbCommenFloorItemViewHolder.J.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.J.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
            layoutParams3.topMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.x.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.v.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.h0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1220));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x06a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, yca ycaVar, View view2, int i2) {
        String str;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i4;
        int i5;
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048598, this, pbCommenFloorItemViewHolder, ycaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && ycaVar != null) {
            int i6 = 0;
            if (ycaVar.R) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            ThreadData threadData = null;
            pbCommenFloorItemViewHolder.q.setTag(null);
            pbCommenFloorItemViewHolder.q.setUserId(null);
            pbCommenFloorItemViewHolder.g.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.r.setIsHost(false);
            String str6 = "";
            if (ycaVar.q() != null) {
                String str7 = this.k;
                if (str7 != null && !"0".equals(str7) && this.k.equals(ycaVar.q().getUserId())) {
                    pbCommenFloorItemViewHolder.r.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = ycaVar.q().getIconInfo();
                ArrayList<IconData> tShowInfoNew = ycaVar.q().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.H;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, ycaVar.q().getUserId());
                    bn9 bn9Var = this.a;
                    if (bn9Var != null && bn9Var.X() != null) {
                        pbCommenFloorItemViewHolder.H.setOnClickListener(this.a.X().c.c);
                    }
                    int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.H;
                    i4 = R.id.tag_user_id;
                    userIconBox2.g(iconInfo, 2, g2, g2, g3);
                } else {
                    i4 = R.id.tag_user_id;
                }
                if (pbCommenFloorItemViewHolder.G != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    bn9 bn9Var2 = this.a;
                    if (bn9Var2 != null && bn9Var2.X() != null) {
                        pbCommenFloorItemViewHolder.G.setOnClickListener(this.a.X().c.e);
                    }
                    int g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, g4, g4, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !ycaVar.q().isBigV()) {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = ycaVar.q().getAvater();
                if (ycaVar.d0) {
                    i5 = 2;
                } else {
                    i5 = 8;
                }
                pbCommenFloorItemViewHolder.g.setTag(i4, ycaVar.q().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, ycaVar.q().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, ycaVar.q().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, xm9.i(this.l, ycaVar, ycaVar.e0, i5, 2));
                String name_show = ycaVar.q().getName_show();
                String userName = ycaVar.q().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(ae9.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, ae9.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (ycaVar.q().getPendantData() != null && !StringUtils.isNull(ycaVar.q().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.F.i(ycaVar.q());
                    pbCommenFloorItemViewHolder.q.setVisibility(8);
                    pbCommenFloorItemViewHolder.F.setVisibility(0);
                    pbCommenFloorItemViewHolder.F.getHeadView().N(avater, 28, false);
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserId(ycaVar.q().getUserId());
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserName(ycaVar.q().getUserName());
                    ze9 ze9Var = this.l;
                    if (ze9Var == null) {
                        str4 = "";
                    } else {
                        str4 = ze9Var.l();
                    }
                    pbCommenFloorItemViewHolder.F.getHeadView().setFid(str4);
                    ze9 ze9Var2 = this.l;
                    if (ze9Var2 == null) {
                        str5 = "";
                    } else {
                        str5 = ze9Var2.m();
                    }
                    pbCommenFloorItemViewHolder.F.getHeadView().setFName(str5);
                    pbCommenFloorItemViewHolder.F.getHeadView().setFloor(ycaVar.I());
                    pbCommenFloorItemViewHolder.F.getHeadView().setTid(ycaVar.S());
                    pbCommenFloorItemViewHolder.F.getHeadView().setTag(R.id.tag_statistic_item, xm9.i(this.l, ycaVar, ycaVar.e0, i5, 2));
                    pbCommenFloorItemViewHolder.F.n(ycaVar.q().getPendantData().getImgUrl());
                } else {
                    pbCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.q, ycaVar.q(), 4);
                    pbCommenFloorItemViewHolder.q.setUserId(ycaVar.q().getUserId());
                    ze9 ze9Var3 = this.l;
                    if (ze9Var3 == null) {
                        str2 = "";
                    } else {
                        str2 = ze9Var3.l();
                    }
                    pbCommenFloorItemViewHolder.q.setFid(str2);
                    ze9 ze9Var4 = this.l;
                    if (ze9Var4 == null) {
                        str3 = "";
                    } else {
                        str3 = ze9Var4.m();
                    }
                    pbCommenFloorItemViewHolder.q.setFName(str3);
                    pbCommenFloorItemViewHolder.q.setFloor(ycaVar.I());
                    pbCommenFloorItemViewHolder.q.setTid(ycaVar.S());
                    pbCommenFloorItemViewHolder.q.setUserName(ycaVar.q().getUserName(), ycaVar.s0());
                    pbCommenFloorItemViewHolder.q.setTag(R.id.tag_virtual_user_url, ycaVar.q().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.q.setTag(R.id.tag_statistic_item, xm9.i(this.l, ycaVar, ycaVar.e0, i5, 2));
                    pbCommenFloorItemViewHolder.q.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.q.N(avater, 28, false);
                    pbCommenFloorItemViewHolder.q.setVisibility(0);
                    pbCommenFloorItemViewHolder.F.setVisibility(8);
                }
                if (ycaVar.q() != null && ycaVar.q().getAlaInfo() != null && ycaVar.q().getAlaUserData() != null && ycaVar.q().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.e(true);
                    pbCommenFloorItemViewHolder.q.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.q.setAlaInfo(ycaVar.q().getAlaInfo());
                    pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(ycaVar.q().getAlaInfo());
                    threadData = null;
                } else {
                    pbCommenFloorItemViewHolder.e(false);
                    pbCommenFloorItemViewHolder.q.setLiveStatus(0);
                    threadData = null;
                    pbCommenFloorItemViewHolder.q.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(null);
                }
                u0(pbCommenFloorItemViewHolder.i, ycaVar);
            }
            bn9 bn9Var3 = this.a;
            if (bn9Var3 == null || bn9Var3.X() == null || !this.a.X().z0() || ycaVar.q() == null) {
                str = "";
                i3 = 0;
            } else {
                i3 = ycaVar.q().getLevel_id();
                str = ycaVar.q().getLevelName();
            }
            ze9 ze9Var5 = this.l;
            if (ze9Var5 != null && ze9Var5.i0()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.E.setVisibility(0);
                pbCommenFloorItemViewHolder.E.setLevel(i3, str);
            } else {
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
            if (ycaVar.q() != null && ycaVar.q().getName_show() != null) {
                str6 = ycaVar.q().getName_show();
            }
            pbCommenFloorItemViewHolder.g.setText(str6);
            pbCommenFloorItemViewHolder.f.post(new k(this, pbCommenFloorItemViewHolder, str6));
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, ycaVar);
            sparseArray.put(R.id.tag_load_sub_data, ycaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(ycaVar.I()));
            sparseArray.put(R.id.tag_forbid_user_post_id, ycaVar.S());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.p);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.d0);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.z);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.A);
            ze9 ze9Var6 = this.l;
            if (ze9Var6 != null && ze9Var6.N() != null) {
                threadData = this.l.N();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
            }
            if (ycaVar.q() != null && !StringUtils.isNull(ycaVar.q().getVirtualUserUrl())) {
                z = true;
            } else {
                z = false;
            }
            ze9 ze9Var7 = this.l;
            if (ze9Var7 != null && ze9Var7.V() != 0 && !h0()) {
                if (this.l.V() != 1002 && this.l.V() != 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.l.V() != 3 && !this.l.i0()) {
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
                if (ycaVar != null && ycaVar.q() != null) {
                    String userId = ycaVar.q().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z2 = false;
                    }
                    if (userId == null || "0".equals(userId) || userId.length() == 0) {
                        z2 = false;
                    }
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
            }
            ze9 ze9Var8 = this.l;
            if (ze9Var8 != null && ze9Var8.N() != null && this.l.N().getAuthor() != null && ycaVar.q() != null) {
                String userId2 = this.l.N().getAuthor().getUserId();
                String userId3 = ycaVar.q().getUserId();
                if (UtilHelper.isCurrentAccount(userId2)) {
                    if (UtilHelper.isCurrentAccount(userId3)) {
                        z5 = false;
                        z3 = true;
                        z6 = true;
                    } else {
                        z5 = true;
                        z3 = true;
                        z6 = false;
                    }
                    z7 = true;
                    if (ycaVar != null && ycaVar.q() != null && UtilHelper.isCurrentAccount(ycaVar.q().getUserId())) {
                        z3 = true;
                        z6 = true;
                    }
                    if (z) {
                        z2 = false;
                        z5 = false;
                        z3 = false;
                    }
                    if (ycaVar.I() != 1) {
                        i6 = 1;
                    }
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.l.V()));
                        if (ycaVar.q() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, ycaVar.q().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, ycaVar.q().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, ycaVar.q().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z5) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (ycaVar.q() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, ycaVar.q().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, ycaVar.q().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, ycaVar.q().getName_show());
                        }
                        if (this.l.N() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.l.N().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, ycaVar.S());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(ycaVar.z0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.l.V()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(R.id.tag_del_post_id, ycaVar.S());
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z4));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                    pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.t.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.E.setOnClickListener(new l(this, ycaVar));
                }
            }
            z5 = false;
            z6 = false;
            z7 = false;
            if (ycaVar != null) {
                z3 = true;
                z6 = true;
            }
            if (z) {
            }
            if (ycaVar.I() != 1) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (!z3) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z4));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            pbCommenFloorItemViewHolder.E.setOnClickListener(new l(this, ycaVar));
        }
    }

    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ze9 ze9Var = this.l;
            if (ze9Var != null && ze9Var.N() != null) {
                return this.l.N().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View j0(int i2, View view2, ViewGroup viewGroup, yca ycaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ycaVar, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) ycaVar, (yca) pbCommenFloorItemViewHolder);
            s0(pbCommenFloorItemViewHolder);
            n0(pbCommenFloorItemViewHolder);
            I(pbCommenFloorItemViewHolder);
            yca ycaVar2 = (yca) getItem(i2);
            if (ycaVar2 != null) {
                ycaVar2.e0 = i2 + 1;
                L(ycaVar2);
                J(ycaVar2);
                ycaVar2.y1();
                Q(ycaVar2);
                U(pbCommenFloorItemViewHolder, ycaVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.q);
            if (this.a.X() != null && this.a.X().getPageContext() != null && this.a.X().getPageContext().getOrignalPage() != null) {
                ok9 ok9Var = this.a.X().c;
                pbCommenFloorItemViewHolder.g.setOnClickListener(ok9Var.b);
                pbCommenFloorItemViewHolder.q.setOnClickListener(ok9Var.b);
                pbCommenFloorItemViewHolder.F.setOnClickListener(ok9Var.b);
                pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(ok9Var.b);
                pbCommenFloorItemViewHolder.r.setOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.r.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(this.n);
                pbCommenFloorItemViewHolder.r.setOnImageClickListener(this.o);
                pbCommenFloorItemViewHolder.r.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.r.setOnEmotionClickListener(ok9Var.f);
                pbCommenFloorItemViewHolder.r.setOnVoiceAfterClickListener(this.n);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.L.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.N.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.i0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.m0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.e0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.o0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.f0.setOnClickListener(new m(this, pbCommenFloorItemViewHolder));
                qk9 qk9Var = this.a.X().d;
                pbCommenFloorItemViewHolder.z.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.A.setOnClickListener(new a(this, pbCommenFloorItemViewHolder, qk9Var));
                pbCommenFloorItemViewHolder.p.D = new b(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.d0.D = new c(this, pbCommenFloorItemViewHolder);
            }
        }
    }

    @Override // com.baidu.tieba.wh9, com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view2, viewGroup, (yca) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048621, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            t0(pbCommenFloorItemViewHolder.i);
            boolean z = true;
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.o, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.y, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.t.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.t.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.h0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.w, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080b99, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.A, R.drawable.obfuscated_res_0x7f080b9a, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
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
                pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f0474);
            } else {
                ze9 ze9Var = this.l;
                if (ze9Var != null && StringUtils.isNull(ze9Var.j())) {
                    pbCommenFloorItemViewHolder.U.setText(this.l.j());
                } else {
                    pbCommenFloorItemViewHolder.U.setText(R.string.obfuscated_res_0x7f0f06e3);
                }
            }
            pbCommenFloorItemViewHolder.p.Q(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.d(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.e0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.o0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.c();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }
}
