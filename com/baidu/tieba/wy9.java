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
/* loaded from: classes9.dex */
public class wy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;
    public BdTypeListView b;
    public a3a c;
    public c3a d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public TbRichTextView.z g;
    public ux9 h;
    public View.OnLongClickListener i;
    public SubPbReplyAdapter j;
    public xy9 k;
    public List<ci> l;
    public aw9 m;
    public ArrayList<pi> n;

    public wy9(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
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
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, t5a.b);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.x(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.a;
            xy9 xy9Var = new xy9(foldCommentActivity, nwa.Y0, foldCommentActivity.getPageContext());
            this.k = xy9Var;
            xy9Var.a0(this.c);
            this.k.b0(this.d);
            this.k.d0(this.a);
            this.k.k(this.e);
            this.k.e(this.f);
            this.k.o(this.g);
            this.k.c0(this.h);
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
        xy9 xy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (xy9Var = this.k) != null) {
            xy9Var.setFromCDN(z);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(boolean z) {
        xy9 xy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (xy9Var = this.k) != null) {
            xy9Var.Z(z);
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

    public void j(a3a a3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, a3aVar) == null) {
            this.c = a3aVar;
        }
    }

    public void k(c3a c3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, c3aVar) == null) {
            this.d = c3aVar;
        }
    }

    public void l(ux9 ux9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ux9Var) == null) {
            this.h = ux9Var;
        }
    }

    public void i(aw9 aw9Var) {
        xy9 xy9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aw9Var) == null) {
            this.m = aw9Var;
            xy9 xy9Var2 = this.k;
            if (xy9Var2 != null) {
                xy9Var2.s(aw9Var);
            }
            this.n.clear();
            aw9 aw9Var2 = this.m;
            if (aw9Var2 != null && aw9Var2.I() != null && this.m.I().size() > 0) {
                t5a t5aVar = new t5a();
                t5aVar.b(aw9Var.I().size());
                this.n.add(t5aVar);
                Iterator<nwa> it = this.m.I().iterator();
                while (it.hasNext()) {
                    nwa next = it.next();
                    if (next.getType() != nwa.X0) {
                        this.n.add(next);
                    }
                }
            }
            if (aw9Var != null && aw9Var.R() != null && aw9Var.R().getAuthor() != null && (xy9Var = this.k) != null) {
                xy9Var.p(aw9Var.R().getAuthor().getUserId());
            }
            if (this.m != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_HAS_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.m.o());
                statisticItem.param("fname", this.m.p());
                statisticItem.param("tid", this.m.T());
                TiebaStatic.log(statisticItem);
            }
            this.b.setData(this.n);
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }
}
