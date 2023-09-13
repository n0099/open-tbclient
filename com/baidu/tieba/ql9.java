package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ql9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;
    public BdTypeListView b;
    public ep9 c;
    public gp9 d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public TbRichTextView.z g;
    public vk9 h;
    public View.OnLongClickListener i;
    public SubPbReplyAdapter j;
    public rl9 k;
    public List<pm> l;
    public aj9 m;
    public ArrayList<cn> n;

    public ql9(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.n = new ArrayList<>();
        this.a = foldCommentActivity;
        this.b = bdTypeListView;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, er9.b);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.u(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.a;
            rl9 rl9Var = new rl9(foldCommentActivity, tha.X0, foldCommentActivity.getPageContext());
            this.k = rl9Var;
            rl9Var.c0(this.c);
            this.k.d0(this.d);
            this.k.f0(this.a);
            this.k.k(this.e);
            this.k.e(this.f);
            this.k.n(this.g);
            this.k.e0(this.h);
            this.k.d(this.i);
            this.l.add(this.k);
            this.b.addAdapters(this.l);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b.getAdapter2() != null) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void d(boolean z) {
        rl9 rl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (rl9Var = this.k) != null) {
            rl9Var.setFromCDN(z);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(boolean z) {
        rl9 rl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (rl9Var = this.k) != null) {
            rl9Var.b0(z);
        }
    }

    public void g(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zVar) == null) {
            this.g = zVar;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.i = onLongClickListener;
        }
    }

    public void j(ep9 ep9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ep9Var) == null) {
            this.c = ep9Var;
        }
    }

    public void k(gp9 gp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gp9Var) == null) {
            this.d = gp9Var;
        }
    }

    public void l(vk9 vk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, vk9Var) == null) {
            this.h = vk9Var;
        }
    }

    public void i(aj9 aj9Var) {
        rl9 rl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aj9Var) == null) {
            this.m = aj9Var;
            rl9 rl9Var2 = this.k;
            if (rl9Var2 != null) {
                rl9Var2.r(aj9Var);
            }
            this.n.clear();
            aj9 aj9Var2 = this.m;
            if (aj9Var2 != null && aj9Var2.F() != null && this.m.F().size() > 0) {
                er9 er9Var = new er9();
                er9Var.b(aj9Var.F().size());
                this.n.add(er9Var);
                Iterator<tha> it = this.m.F().iterator();
                while (it.hasNext()) {
                    tha next = it.next();
                    if (next.getType() != tha.W0) {
                        this.n.add(next);
                    }
                }
            }
            if (aj9Var != null && aj9Var.O() != null && aj9Var.O().getAuthor() != null && (rl9Var = this.k) != null) {
                rl9Var.o(aj9Var.O().getAuthor().getUserId());
            }
            if (this.m != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_HAS_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.m.l());
                statisticItem.param("fname", this.m.m());
                statisticItem.param("tid", this.m.Q());
                TiebaStatic.log(statisticItem);
            }
            this.b.setData(this.n);
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }
}
