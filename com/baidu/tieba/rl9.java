package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.gp9;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFloorComplaint;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.vk9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class rl9 extends pm<tha, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public View.OnClickListener c;
    public View.OnClickListener d;
    public TbRichTextView.z e;
    public vk9 f;
    public View.OnLongClickListener g;
    public String h;
    public aj9 i;
    public boolean j;
    public SparseIntArray k;
    public wq9 l;
    public ep9 m;
    public gp9 n;
    public TbRichTextView.t o;
    public boolean p;
    public bg<ConstrainImageLayout> q;
    public bg<TbImageView> r;
    public vk9 s;

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ rl9 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ tha a;
            public final /* synthetic */ i b;

            public a(i iVar, tha thaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, thaVar};
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
                this.a = thaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    gp9.b bVar = this.b.b.n.b;
                    i iVar = this.b;
                    bVar.a(iVar.b.i, null, this.a, iVar.a.q.getLayoutStrategy());
                }
            }
        }

        public i(rl9 rl9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rl9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            tha thaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof tha) && (thaVar = (tha) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b.n != null) {
                SafeHandler.getInst().postDelayed(new a(this, thaVar), 100L);
                String Q = this.b.i.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                    Q = this.b.i.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", thaVar.U()).param("obj_source", this.b.X(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tha b;
        public final /* synthetic */ rl9 c;

        public a(rl9 rl9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var, pbCommenFloorItemViewHolder, thaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rl9Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = thaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.R.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.F(this.a, !z, this.b.O());
                this.b.e1(!z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public b(rl9 rl9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var, pbCommenFloorItemViewHolder, str};
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
                arrayList.add(this.a.F);
                arrayList.add(this.a.i);
                arrayList.add(this.a.j);
                arrayList.add(this.a.x0);
                arrayList.add(this.a.D);
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                jy5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.D, arrayList, pbCommenFloorItemViewHolder.G);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tha b;
        public final /* synthetic */ rl9 c;

        public c(rl9 rl9Var, String str, tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var, str, thaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rl9Var;
            this.a = str;
            this.b = thaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(WebViewActivityConfig.TAG_FIX_TITLE, true);
                    BrowserHelper.startWebActivity(this.c.b.getPageActivity(), "", this.a, false, true, true, bundle);
                }
                if (this.c.i != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.c.i.l());
                    statisticItem.param("fname", this.c.i.m());
                    statisticItem.param("tid", this.c.i.Q());
                    statisticItem.param("pid", this.b.U());
                    statisticItem.param("obj_type", this.b.N());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements cg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl9 a;

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

        public d(rl9 rl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
    public class e implements cg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public e(rl9 rl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl9Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
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
        @Override // com.baidu.tieba.cg
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
    public class f implements vk9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl9 a;

        @Override // com.baidu.tieba.vk9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public f(rl9 rl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl9Var;
        }

        @Override // com.baidu.tieba.vk9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.f != null) {
                    if ((view2 instanceof TbListTextView) && this.a.d != null) {
                        this.a.d.onClick(view2);
                        return true;
                    }
                    this.a.f.a(view2);
                    this.a.f.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.vk9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || view2.getId() == R.id.obfuscated_res_0x7f090b78) {
                    return true;
                }
                if (view2 instanceof RelativeLayout) {
                    this.a.H(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.a.H((RelativeLayout) parent);
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
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public g(rl9 rl9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var, pbCommenFloorItemViewHolder};
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
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ rl9 b;

        public h(rl9 rl9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rl9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.c0) != null && agreeView.getData() != null) {
                String Q = this.b.i.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                    Q = this.b.i.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c14442").param("tid", Q).param("fname", this.b.i.m()).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ rl9 b;

        public j(rl9 rl9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rl9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.o) != null && agreeView.getData() != null) {
                if (view2 == this.a.o.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String Q = this.b.i.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                    Q = this.b.i.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.X(this.a.o)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ rl9 b;

        public k(rl9 rl9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rl9Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.i != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.c0) != null && agreeView.getData() != null) {
                if (view2 == this.a.c0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String Q = this.b.i.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.b.i.Q())) && this.b.i.O() != null) {
                    Q = this.b.i.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId).param("obj_source", this.b.X(this.a.c0)).param("obj_type", i));
                TiebaStatic.log(new StatisticItem("c14440").param("tid", Q).param("fname", this.b.i.m()).param("fid", this.b.i.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rl9 a;

        public l(rl9 rl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rl9Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.f != null) {
                    this.a.f.a(view2);
                    return this.a.f.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rl9(Context context, BdUniqueId bdUniqueId, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = new SparseIntArray();
        this.l = null;
        this.q = new bg<>(new d(this), 6, 0);
        this.r = new bg<>(new e(this), 12, 0);
        this.s = new vk9(new f(this));
        this.b = tbPageContext;
        this.a = W(R.dimen.tbds14);
    }

    public final void K(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.W;
            if (thaVar.d0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.c) != null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0205);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            pbCommenFloorItemViewHolder.h(thaVar.f1164T, thaVar.U(), false);
        }
    }

    public final void D(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.f);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new l(this));
        }
    }

    public int W(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            int i3 = this.k.get(i2, -1);
            if (i3 != -1) {
                return i3;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
            this.k.put(i2, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.p = z;
        }
    }

    public void c0(ep9 ep9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ep9Var) == null) {
            this.m = ep9Var;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onLongClickListener) == null) {
            this.g = onLongClickListener;
        }
    }

    public void d0(gp9 gp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, gp9Var) == null) {
            this.n = gp9Var;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void e0(vk9 vk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, vk9Var) == null) {
            this.f = vk9Var;
        }
    }

    public void f0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, tVar) == null) {
            this.o = tVar;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, zVar) == null) {
            this.e = zVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.h = str;
        }
    }

    public void r(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, aj9Var) == null) {
            this.i = aj9Var;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.j = z;
        }
    }

    public final void E(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int equipmentWidth = ((((BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                equipmentWidth = (equipmentWidth - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = W(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (equipmentWidth - i3) - W(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                equipmentWidth /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((equipmentWidth - i3) * 1.0f));
            tbRichTextView.getLayoutStrategy().q((int) (equipmentWidth * 1.618f * 1.0f));
        }
    }

    public final void F(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.R.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f06ef);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.f1141T.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f0477);
        }
    }

    public final void G(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, thaVar}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.I) != null && pbCommenFloorItemViewHolder.S != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.S.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(thaVar.j0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.I.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.S.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.S.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
            }
        }
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, pbCommenFloorItemViewHolder, thaVar, view2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            pbCommenFloorItemViewHolder.q.p0(null);
            pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.transparent_bg);
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().z(R.drawable.pic_video);
            E(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(thaVar.v()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.j);
            pbCommenFloorItemViewHolder.q.setText(thaVar.f0(), true, this.o);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, thaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.n0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.d0.setTag(sparseArray);
        }
    }

    public final void H(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).c0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.c0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.c0.N();
        }
    }

    public final void I(tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, thaVar) == null) && thaVar != null) {
            int i2 = 8;
            if (thaVar.e0) {
                i2 = 2;
            }
            StatisticItem k2 = nr9.k(this.i, thaVar, thaVar.f0, i2, 6);
            thaVar.g0 = k2;
            if (!ListUtils.isEmpty(thaVar.j0())) {
                Iterator<tha> it = thaVar.j0().iterator();
                while (it.hasNext()) {
                    it.next().g0 = k2;
                }
            }
        }
    }

    public final String X(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, view2)) == null) {
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
    /* JADX WARN: Removed duplicated region for block: B:45:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void J(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        aj9 aj9Var;
        aj9 aj9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            String str = null;
            boolean z3 = true;
            if (thaVar.L() > 0 && (aj9Var2 = this.i) != null && !aj9Var2.j0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0b33), Integer.valueOf(thaVar.L()));
                pbCommenFloorItemViewHolder.C.setVisibility(0);
                pbCommenFloorItemViewHolder.C.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.C.setVisibility(8);
                z = false;
            }
            if (thaVar.t() != null) {
                str = thaVar.t().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    oh5 a0 = thaVar.a0();
                    z3 = (a0 != null || StringUtils.isNull(a0.b()) || (aj9Var = this.i) == null || aj9Var.j0()) ? false : false;
                    if (!z) {
                        pbCommenFloorItemViewHolder.l.setVisibility(0);
                        i2 = this.a;
                    } else {
                        pbCommenFloorItemViewHolder.l.setVisibility(8);
                        i2 = 0;
                    }
                    if (z3 && !z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                        i3 = 0;
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                        i3 = this.a;
                    }
                    pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(thaVar.q0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(thaVar.q0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(thaVar.q0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds14), 0, 0, 0);
                        pbCommenFloorItemViewHolder.n.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.a, 0, 0, 0);
                        if (thaVar.d0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(a0.b(), 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(a0.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView = pbCommenFloorItemViewHolder.f0;
                    textView.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            oh5 a02 = thaVar.a0();
            if (a02 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            i3 = this.a;
            pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(thaVar.q0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView2 = pbCommenFloorItemViewHolder.f0;
            textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void L(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, thaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.e0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.n0.setVisibility(8);
            U(pbCommenFloorItemViewHolder, thaVar, view2, i2);
            oo9.b(pbCommenFloorItemViewHolder, thaVar, this.i);
            M(pbCommenFloorItemViewHolder, thaVar);
            P(pbCommenFloorItemViewHolder, thaVar, view2);
            O(pbCommenFloorItemViewHolder, thaVar, view2, i2);
            J(pbCommenFloorItemViewHolder, thaVar);
            R(pbCommenFloorItemViewHolder, thaVar);
            N(pbCommenFloorItemViewHolder, thaVar);
            S(pbCommenFloorItemViewHolder, thaVar);
            hl9.i(pbCommenFloorItemViewHolder, thaVar, view2, this.s);
            K(pbCommenFloorItemViewHolder, thaVar);
            Q(pbCommenFloorItemViewHolder, thaVar);
            T(pbCommenFloorItemViewHolder, thaVar);
            hl9.o(pbCommenFloorItemViewHolder, view2, thaVar, this.p, true);
        }
    }

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && thaVar != null && thaVar.p() != null) {
            thaVar.p().objType = 1;
            thaVar.p().isInPost = true;
            ThreadData threadData = null;
            aj9 aj9Var = this.i;
            if (aj9Var != null && aj9Var.O() != null) {
                threadData = this.i.O();
                thaVar.p().threadId = threadData.getTid();
                thaVar.p().forumId = String.valueOf(threadData.getFid());
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(thaVar.p());
            pbCommenFloorItemViewHolder.c0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.c0.setData(thaVar.p());
        }
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, thaVar) == null) {
            if (thaVar != null && thaVar.t() != null && thaVar.m0() != null) {
                TbRichText f0 = thaVar.f0();
                if (f0 != null && StringUtils.isNull(f0.toString()) && StringUtils.isNull(thaVar.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (thaVar.t().getSmallTailThemeData() != null) {
                    str = thaVar.t().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.J.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                cs9.c(thaVar.m0(), pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, false, false, z, thaVar.t().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.J.setVisibility(8);
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    public final void N(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, thaVar) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.P != null && pbCommenFloorItemViewHolder.M != null) {
            if (thaVar != null && (alaLiveInfoCoreData = thaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.P.setText(thaVar.U.liveTitle);
                pbCommenFloorItemViewHolder.M.setTag(thaVar.U);
                pbCommenFloorItemViewHolder.M.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbCommenFloorItemViewHolder.M.setVisibility(8);
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, thaVar) == null) {
            if (thaVar.P() != 2 && thaVar.P() != 4) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                G(false, pbCommenFloorItemViewHolder, thaVar);
                return;
            }
            pbCommenFloorItemViewHolder.S.setOnClickListener(new a(this, pbCommenFloorItemViewHolder, thaVar));
            pbCommenFloorItemViewHolder.S.setVisibility(0);
            F(pbCommenFloorItemViewHolder, thaVar.E0(), thaVar.O());
            G(true, pbCommenFloorItemViewHolder, thaVar);
        }
    }

    public final void O(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048587, this, pbCommenFloorItemViewHolder, thaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            if (thaVar.l0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, thaVar);
                if (thaVar.P() == 2) {
                    pbCommenFloorItemViewHolder.x.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.x.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            }
            ImageView imageView = pbCommenFloorItemViewHolder.y;
            if (imageView != null) {
                SparseArray sparseArray2 = (SparseArray) imageView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, thaVar);
            }
            if (this.i != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.i.l());
                statisticItem.param("fname", this.i.m());
                statisticItem.param("tid", this.i.Q());
                statisticItem.param("pid", thaVar.U());
                TiebaStatic.log(statisticItem);
            }
            if (pbCommenFloorItemViewHolder.U != null) {
                PbFloorComplaint pbFloorComplaint = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091ae4);
                pbCommenFloorItemViewHolder.U = pbFloorComplaint;
                pbCommenFloorItemViewHolder.V = Boolean.TRUE;
                pbFloorComplaint.setRemindText(thaVar.N());
                pbCommenFloorItemViewHolder.U.setRemindIcon(thaVar.N());
                if (thaVar.N() == 0) {
                    pbCommenFloorItemViewHolder.U.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.U.setVisibility(0);
                    if (this.i != null) {
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_FLOOR_COMPLAINT_SHOW);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", this.i.l());
                        statisticItem2.param("fname", this.i.m());
                        statisticItem2.param("tid", this.i.Q());
                        statisticItem2.param("pid", thaVar.U());
                        statisticItem2.param("obj_type", thaVar.N());
                        TiebaStatic.log(statisticItem2);
                    }
                }
                pbCommenFloorItemViewHolder.U.setAmendIconListener(new c(this, thaVar.M(), thaVar));
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, thaVar);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            if (!thaVar.A0() && !thaVar.z0(false)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds10);
                layoutParams2.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.l == null) {
                    wq9 wq9Var = new wq9(this.mContext);
                    this.l = wq9Var;
                    wq9Var.f(this.j);
                    this.l.h(this.c);
                    this.l.e(this.d);
                    String str = null;
                    aj9 aj9Var = this.i;
                    if (aj9Var != null && aj9Var.O() != null && this.i.O().getAuthor() != null) {
                        str = this.i.O().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    aj9 aj9Var2 = this.i;
                    if (aj9Var2 != null) {
                        this.l.j(aj9Var2.W(), z);
                        this.l.i(this.i.O());
                    }
                }
                this.l.g(thaVar.U());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.l);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(thaVar, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.d);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.g);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.s);
            }
            if (thaVar.P) {
                pbCommenFloorItemViewHolder.I.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.I.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams3.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.w.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.g0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1247));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0663  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tha thaVar, View view2, int i2) {
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
        if ((interceptable == null || interceptable.invokeLLLI(1048593, this, pbCommenFloorItemViewHolder, thaVar, view2, i2) == null) && pbCommenFloorItemViewHolder != null && thaVar != null) {
            int i6 = 0;
            if (thaVar.R) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            ThreadData threadData = null;
            pbCommenFloorItemViewHolder.p.setTag(null);
            pbCommenFloorItemViewHolder.p.setUserId(null);
            pbCommenFloorItemViewHolder.g.setText((CharSequence) null);
            pbCommenFloorItemViewHolder.E.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.q.setIsHost(false);
            String str6 = "";
            if (thaVar.t() != null) {
                String str7 = this.h;
                if (str7 != null && !str7.equals("0") && this.h.equals(thaVar.t().getUserId())) {
                    pbCommenFloorItemViewHolder.q.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = thaVar.t().getIconInfo();
                ArrayList<IconData> tShowInfoNew = thaVar.t().getTShowInfoNew();
                UserIconBox userIconBox = pbCommenFloorItemViewHolder.G;
                if (userIconBox != null) {
                    userIconBox.setTag(R.id.tag_user_id, thaVar.t().getUserId());
                    ep9 ep9Var = this.m;
                    if (ep9Var != null) {
                        pbCommenFloorItemViewHolder.G.setOnClickListener(ep9Var.c);
                    }
                    int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.G;
                    i4 = R.id.tag_user_id;
                    userIconBox2.g(iconInfo, 2, dimens, dimens, dimens2);
                } else {
                    i4 = R.id.tag_user_id;
                }
                if (pbCommenFloorItemViewHolder.F != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.F.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    ep9 ep9Var2 = this.m;
                    if (ep9Var2 != null) {
                        pbCommenFloorItemViewHolder.F.setOnClickListener(ep9Var2.e);
                    }
                    int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.F.h(tShowInfoNew, 3, dimens3, dimens3, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !thaVar.t().isBigV()) {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = thaVar.t().getAvater();
                if (thaVar.e0) {
                    i5 = 2;
                } else {
                    i5 = 8;
                }
                pbCommenFloorItemViewHolder.g.setTag(i4, thaVar.t().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, thaVar.t().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, thaVar.t().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, nr9.k(this.i, thaVar, thaVar.f0, i5, 2));
                String name_show = thaVar.t().getName_show();
                String userName = thaVar.t().getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    pbCommenFloorItemViewHolder.g.setText(eh9.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, eh9.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (thaVar.t().getPendantData() != null && !StringUtils.isNull(thaVar.t().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.E.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.E.i(thaVar.t());
                    pbCommenFloorItemViewHolder.p.setVisibility(8);
                    pbCommenFloorItemViewHolder.E.setVisibility(0);
                    pbCommenFloorItemViewHolder.E.getHeadView().startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.E.getHeadView().setUserId(thaVar.t().getUserId());
                    pbCommenFloorItemViewHolder.E.getHeadView().setUserName(thaVar.t().getUserName());
                    aj9 aj9Var = this.i;
                    if (aj9Var == null) {
                        str4 = "";
                    } else {
                        str4 = aj9Var.l();
                    }
                    pbCommenFloorItemViewHolder.E.getHeadView().setFid(str4);
                    aj9 aj9Var2 = this.i;
                    if (aj9Var2 == null) {
                        str5 = "";
                    } else {
                        str5 = aj9Var2.m();
                    }
                    pbCommenFloorItemViewHolder.E.getHeadView().setFName(str5);
                    pbCommenFloorItemViewHolder.E.getHeadView().setFloor(thaVar.L());
                    pbCommenFloorItemViewHolder.E.getHeadView().setTid(thaVar.U());
                    pbCommenFloorItemViewHolder.E.getHeadView().setTag(R.id.tag_statistic_item, nr9.k(this.i, thaVar, thaVar.f0, i5, 2));
                    pbCommenFloorItemViewHolder.E.i(thaVar.t());
                } else {
                    pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, thaVar.t(), 4);
                    pbCommenFloorItemViewHolder.p.setUserId(thaVar.t().getUserId());
                    aj9 aj9Var3 = this.i;
                    if (aj9Var3 == null) {
                        str2 = "";
                    } else {
                        str2 = aj9Var3.l();
                    }
                    pbCommenFloorItemViewHolder.p.setFid(str2);
                    aj9 aj9Var4 = this.i;
                    if (aj9Var4 == null) {
                        str3 = "";
                    } else {
                        str3 = aj9Var4.m();
                    }
                    pbCommenFloorItemViewHolder.p.setFName(str3);
                    pbCommenFloorItemViewHolder.p.setFloor(thaVar.L());
                    pbCommenFloorItemViewHolder.p.setTid(thaVar.U());
                    pbCommenFloorItemViewHolder.p.setUserName(thaVar.t().getUserName(), thaVar.t0());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, thaVar.t().getVirtualUserUrl());
                    pbCommenFloorItemViewHolder.p.setTag(R.id.tag_statistic_item, nr9.k(this.i, thaVar, thaVar.f0, i5, 2));
                    pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                    pbCommenFloorItemViewHolder.p.startLoad(avater, 28, false);
                    pbCommenFloorItemViewHolder.p.setVisibility(0);
                    pbCommenFloorItemViewHolder.E.setVisibility(8);
                }
                if (thaVar.t() != null && thaVar.t().getAlaInfo() != null && thaVar.t().getAlaUserData() != null && thaVar.t().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.d(true);
                    pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.p.setAlaInfo(thaVar.t().getAlaInfo());
                    pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(thaVar.t().getAlaInfo());
                    threadData = null;
                } else {
                    pbCommenFloorItemViewHolder.d(false);
                    pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                    threadData = null;
                    pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(null);
                }
                oo9.e(pbCommenFloorItemViewHolder.i, thaVar, this.i, this.h);
            }
            if (thaVar.t() == null) {
                str = "";
                i3 = 0;
            } else {
                i3 = thaVar.t().getLevel_id();
                str = thaVar.t().getLevelName();
            }
            aj9 aj9Var5 = this.i;
            if (aj9Var5 != null && aj9Var5.j0()) {
                i3 = 0;
            }
            if (i3 > 0) {
                pbCommenFloorItemViewHolder.D.setVisibility(0);
                pbCommenFloorItemViewHolder.D.setLevel(i3, str);
            } else {
                pbCommenFloorItemViewHolder.D.setVisibility(8);
            }
            if (thaVar.t() != null) {
                str6 = thaVar.t().getName_show();
            }
            pbCommenFloorItemViewHolder.g.setText(str6);
            pbCommenFloorItemViewHolder.f.post(new b(this, pbCommenFloorItemViewHolder, str6));
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, thaVar);
            sparseArray.put(R.id.tag_load_sub_data, thaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(thaVar.L()));
            sparseArray.put(R.id.tag_forbid_user_post_id, thaVar.U());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.c0);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
            aj9 aj9Var6 = this.i;
            if (aj9Var6 != null && aj9Var6.O() != null) {
                threadData = this.i.O();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
            } else {
                sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
            }
            if (thaVar.t() != null && !StringUtils.isNull(thaVar.t().getVirtualUserUrl())) {
                z = true;
            } else {
                z = false;
            }
            aj9 aj9Var7 = this.i;
            if (aj9Var7 != null && aj9Var7.W() != 0 && !oo9.c(this.i)) {
                if (this.i.W() != 1002 && this.i.W() != 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.i.W() != 3 && !this.i.j0()) {
                    z3 = true;
                    z4 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
                if (thaVar != null && thaVar.t() != null) {
                    String userId = thaVar.t().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        z2 = false;
                    }
                    if (userId == null || userId.equals("0") || userId.length() == 0) {
                        z2 = false;
                    }
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
            }
            aj9 aj9Var8 = this.i;
            if (aj9Var8 != null && aj9Var8.O() != null && this.i.O().getAuthor() != null && thaVar.t() != null) {
                String userId2 = this.i.O().getAuthor().getUserId();
                String userId3 = thaVar.t().getUserId();
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
                    if (thaVar != null && thaVar.t() != null && UtilHelper.isCurrentAccount(thaVar.t().getUserId())) {
                        z4 = true;
                        z6 = true;
                    }
                    if (z) {
                        z2 = false;
                        z5 = false;
                        z4 = false;
                    }
                    if (thaVar.L() != 1) {
                        i6 = 1;
                    }
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.i.W()));
                        if (thaVar.t() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, thaVar.t().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, thaVar.t().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, thaVar.t().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (!z5) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (thaVar.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, thaVar.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, thaVar.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, thaVar.t().getName_show());
                        }
                        if (this.i.O() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.i.O().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, thaVar.U());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(thaVar.A0()));
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.i.W()));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                        sparseArray.put(R.id.tag_del_post_id, thaVar.U());
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
                    sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                    pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                    pbCommenFloorItemViewHolder.s.setTag(sparseArray);
                }
            }
            z5 = false;
            z6 = false;
            z7 = false;
            if (thaVar != null) {
                z4 = true;
                z6 = true;
            }
            if (z) {
            }
            if (thaVar.L() != 1) {
            }
            if (!z2) {
            }
            if (!z5) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: Y */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07c7, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091b51)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07bf, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.b, inflate, 0);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.q);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.r);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(true);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(false);
            }
            g0(pbCommenFloorItemViewHolder);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View Z(int i2, View view2, ViewGroup viewGroup, tha thaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, thaVar, pbCommenFloorItemViewHolder})) == null) {
            g0(pbCommenFloorItemViewHolder);
            a0(pbCommenFloorItemViewHolder);
            D(pbCommenFloorItemViewHolder);
            tha thaVar2 = (tha) getItem(i2);
            if (thaVar2 != null) {
                thaVar2.f0 = i2 + 1;
                thaVar2.C1();
                I(thaVar2);
                L(pbCommenFloorItemViewHolder, thaVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.g.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.p.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.E.setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.E.getHeadView().setOnClickListener(this.m.b);
            pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.g);
            pbCommenFloorItemViewHolder.q.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.d);
            pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.e);
            pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.s);
            pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(this.m.f);
            pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.d);
            pbCommenFloorItemViewHolder.J.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.K.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.M.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.w.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.x.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.l0.setOnTouchListener(this.s);
            pbCommenFloorItemViewHolder.l0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.h0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.d0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.n0.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.e0.setOnClickListener(new g(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.c.setOnClickListener(new h(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.y.setOnClickListener(this.d);
            pbCommenFloorItemViewHolder.z.setOnClickListener(new i(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.o.D = new j(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.c0.D = new k(this, pbCommenFloorItemViewHolder);
        }
    }

    public final void g0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            oo9.d(pbCommenFloorItemViewHolder.i, this.i, this.h);
            boolean z = true;
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.C, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.s.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.s.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.v, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080bba, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080bbb, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.d();
            pbCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.N, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.M, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.Q, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f1141T, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.R.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f0477);
            } else {
                aj9 aj9Var = this.i;
                if (aj9Var != null && StringUtils.isNull(aj9Var.j())) {
                    pbCommenFloorItemViewHolder.f1141T.setText(this.i.j());
                } else {
                    pbCommenFloorItemViewHolder.f1141T.setText(R.string.obfuscated_res_0x7f0f06ef);
                }
            }
            pbCommenFloorItemViewHolder.o.P(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.d0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.n0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, tha thaVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Z(i2, view2, viewGroup, thaVar, pbCommenFloorItemViewHolder);
        return view2;
    }
}
