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
/* loaded from: classes8.dex */
public class vy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;
    public BdTypeListView b;
    public z2a c;
    public b3a d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public TbRichTextView.z g;
    public tx9 h;
    public View.OnLongClickListener i;
    public SubPbReplyAdapter j;
    public wy9 k;
    public List<ci> l;
    public zv9 m;
    public ArrayList<pi> n;

    public vy9(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
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
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, s5a.b);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.x(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.a;
            wy9 wy9Var = new wy9(foldCommentActivity, mwa.Y0, foldCommentActivity.getPageContext());
            this.k = wy9Var;
            wy9Var.a0(this.c);
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
        wy9 wy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (wy9Var = this.k) != null) {
            wy9Var.setFromCDN(z);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(boolean z) {
        wy9 wy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (wy9Var = this.k) != null) {
            wy9Var.Z(z);
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

    public void j(z2a z2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, z2aVar) == null) {
            this.c = z2aVar;
        }
    }

    public void k(b3a b3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, b3aVar) == null) {
            this.d = b3aVar;
        }
    }

    public void l(tx9 tx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tx9Var) == null) {
            this.h = tx9Var;
        }
    }

    public void i(zv9 zv9Var) {
        wy9 wy9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zv9Var) == null) {
            this.m = zv9Var;
            wy9 wy9Var2 = this.k;
            if (wy9Var2 != null) {
                wy9Var2.s(zv9Var);
            }
            this.n.clear();
            zv9 zv9Var2 = this.m;
            if (zv9Var2 != null && zv9Var2.I() != null && this.m.I().size() > 0) {
                s5a s5aVar = new s5a();
                s5aVar.b(zv9Var.I().size());
                this.n.add(s5aVar);
                Iterator<mwa> it = this.m.I().iterator();
                while (it.hasNext()) {
                    mwa next = it.next();
                    if (next.getType() != mwa.X0) {
                        this.n.add(next);
                    }
                }
            }
            if (zv9Var != null && zv9Var.R() != null && zv9Var.R().getAuthor() != null && (wy9Var = this.k) != null) {
                wy9Var.p(zv9Var.R().getAuthor().getUserId());
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
