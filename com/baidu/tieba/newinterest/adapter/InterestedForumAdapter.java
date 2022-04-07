package com.baidu.tieba.newinterest.adapter;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kp7;
import com.repackage.mu4;
import com.repackage.oi;
import com.repackage.qp7;
import com.repackage.wp7;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<kp7> a;
    public int b;
    public c c;
    public boolean d;

    /* loaded from: classes3.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;
        public TextView b;
        public TextView c;
        public RelativeLayout d;
        public RelativeLayout e;
        public RelativeLayout f;
        public BarImageView g;
        public BarImageView h;
        public BarImageView i;
        public TextView j;
        public TextView k;
        public TextView l;
        public TextView m;
        public TextView n;
        public TextView o;
        public TextView p;
        public TextView q;
        public TextView r;
        public TextView s;
        public TextView t;
        public TextView u;
        public TBSpecificationBtn v;
        public TBSpecificationBtn w;
        public TBSpecificationBtn x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InterestedForumViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f13);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f21);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f0c);
            this.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0920ae);
            this.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091413);
            this.f = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0903e0);
            this.g = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f09209a);
            this.h = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f09140e);
            this.i = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f0903cf);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09209b);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09140f);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903d0);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092099);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09140d);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903ce);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920a7);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091411);
            this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903d7);
            this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920ac);
            this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091412);
            this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903dd);
            this.v = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f0920af);
            this.w = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f091414);
            this.x = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f0903e2);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
            this.b.setTypeface(Typeface.DEFAULT_BOLD);
            this.j.setTypeface(Typeface.DEFAULT_BOLD);
            this.k.setTypeface(Typeface.DEFAULT_BOLD);
            this.l.setTypeface(Typeface.DEFAULT_BOLD);
            this.v.setConfig(new mu4());
            this.w.setConfig(new mu4());
            this.x.setConfig(new mu4());
            a(this.g);
            a(this.h);
            a(this.i);
        }

        public final void a(BarImageView barImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, barImageView) == null) {
                barImageView.setShowOval(true);
                barImageView.setShowOuterBorder(false);
                barImageView.setShowInnerBorder(true);
                barImageView.setStrokeWith(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                barImageView.setStrokeColorResId(R.color.CAM_X0401);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kp7 a;
        public final /* synthetic */ InterestedForumViewHolder b;
        public final /* synthetic */ int c;
        public final /* synthetic */ InterestedForumAdapter d;

        public a(InterestedForumAdapter interestedForumAdapter, kp7 kp7Var, InterestedForumViewHolder interestedForumViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestedForumAdapter, kp7Var, interestedForumViewHolder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = interestedForumAdapter;
            this.a = kp7Var;
            this.b = interestedForumViewHolder;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int size = this.a.a.size() - 1;
                this.d.p(size, this.a);
                InterestedForumAdapter interestedForumAdapter = this.d;
                InterestedForumViewHolder interestedForumViewHolder = this.b;
                kp7 kp7Var = this.a;
                interestedForumAdapter.z(interestedForumViewHolder, kp7Var.a.get(kp7Var.e));
                this.d.p(size, this.a);
                InterestedForumAdapter interestedForumAdapter2 = this.d;
                InterestedForumViewHolder interestedForumViewHolder2 = this.b;
                kp7 kp7Var2 = this.a;
                interestedForumAdapter2.w(interestedForumViewHolder2, kp7Var2.a.get(kp7Var2.e));
                this.d.p(size, this.a);
                InterestedForumAdapter interestedForumAdapter3 = this.d;
                InterestedForumViewHolder interestedForumViewHolder3 = this.b;
                kp7 kp7Var3 = this.a;
                interestedForumAdapter3.v(interestedForumViewHolder3, kp7Var3.a.get(kp7Var3.e));
                InterestedForumAdapter interestedForumAdapter4 = this.d;
                interestedForumAdapter4.d = interestedForumAdapter4.r();
                this.d.notifyItemChanged(this.c);
                if (this.d.c != null) {
                    this.d.c.a(this.d.b, this.d.d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("obj_source", this.a.b.intValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qp7 a;
        public final /* synthetic */ TBSpecificationBtn b;
        public final /* synthetic */ InterestedForumAdapter c;

        public b(InterestedForumAdapter interestedForumAdapter, qp7 qp7Var, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestedForumAdapter, qp7Var, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = interestedForumAdapter;
            this.a = qp7Var;
            this.b = tBSpecificationBtn;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qp7 qp7Var = this.a;
                qp7Var.b = !qp7Var.b;
                mu4 mu4Var = new mu4();
                if (!this.a.b) {
                    InterestedForumAdapter.m(this.c);
                    this.b.setText("感兴趣");
                    this.b.setConfig(mu4Var);
                    this.c.d = false;
                } else {
                    InterestedForumAdapter.l(this.c);
                    this.b.setText("已选择");
                    mu4Var.t(R.color.CAM_X0109);
                    this.b.setConfig(mu4Var);
                    InterestedForumAdapter interestedForumAdapter = this.c;
                    interestedForumAdapter.d = interestedForumAdapter.r();
                }
                if (this.c.c != null) {
                    this.c.c.a(this.c.b, this.c.d);
                }
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 4);
                statisticItem.param("fid", this.a.a.forum_id.longValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i, boolean z);
    }

    public InterestedForumAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public static /* synthetic */ int l(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.b;
        interestedForumAdapter.b = i + 1;
        return i;
    }

    public static /* synthetic */ int m(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.b;
        interestedForumAdapter.b = i - 1;
        return i;
    }

    public final void A(TBSpecificationBtn tBSpecificationBtn, qp7 qp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, tBSpecificationBtn, qp7Var) == null) {
            mu4 mu4Var = new mu4();
            if (!qp7Var.b) {
                tBSpecificationBtn.setText("感兴趣");
                tBSpecificationBtn.setConfig(mu4Var);
                return;
            }
            tBSpecificationBtn.setText("已选择");
            mu4Var.t(R.color.CAM_X0109);
            tBSpecificationBtn.setConfig(mu4Var);
        }
    }

    public final void B(kp7 kp7Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kp7Var, i) == null) || this.d) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13682");
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_locate", 3);
        statisticItem.param("fid", kp7Var.a.get(i).a.forum_id.longValue());
        TiebaStatic.log(statisticItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<kp7> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void n(List<kp7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<kp7> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final void p(int i, kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, kp7Var) == null) {
            int i2 = kp7Var.e;
            if (i2 < i) {
                kp7Var.e = i2 + 1;
            } else {
                kp7Var.e = 0;
            }
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (kp7 kp7Var : this.a) {
                int i = kp7Var.e;
                if (!kp7Var.a.get(i).b) {
                    return false;
                }
                int size = i + (-1) < 0 ? kp7Var.a.size() - 1 : i - 1;
                if (!kp7Var.a.get(size).b) {
                    return false;
                }
                if (!kp7Var.a.get(size + (-1) < 0 ? kp7Var.a.size() - 1 : size - 1).b) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s */
    public void onBindViewHolder(@NonNull InterestedForumViewHolder interestedForumViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, interestedForumViewHolder, i) == null) {
            kp7 kp7Var = this.a.get(i);
            interestedForumViewHolder.b.setText(kp7Var.c);
            if (kp7Var.b.intValue() > 0) {
                SkinManager.setImageResource(interestedForumViewHolder.a, wp7.b(kp7Var.b.intValue()));
            }
            List<qp7> list = kp7Var.a;
            if (list == null || list.size() == 0) {
                return;
            }
            int i2 = kp7Var.e;
            if (i2 == 0) {
                if (kp7Var.a.size() >= 1) {
                    z(interestedForumViewHolder, kp7Var.a.get(0));
                }
                if (kp7Var.a.size() >= 2) {
                    w(interestedForumViewHolder, kp7Var.a.get(1));
                }
                if (kp7Var.a.size() >= 3) {
                    v(interestedForumViewHolder, kp7Var.a.get(2));
                }
                if (kp7Var.a.size() > 3) {
                    kp7Var.e = 2;
                }
            } else {
                v(interestedForumViewHolder, kp7Var.a.get(i2));
                int size = i2 + (-1) < 0 ? kp7Var.a.size() - 1 : i2 - 1;
                w(interestedForumViewHolder, kp7Var.a.get(size));
                z(interestedForumViewHolder, kp7Var.a.get(size + (-1) < 0 ? kp7Var.a.size() - 1 : size - 1));
            }
            if (kp7Var.a.size() <= 3) {
                interestedForumViewHolder.c.setEnabled(false);
            } else {
                interestedForumViewHolder.c.setEnabled(true);
            }
            interestedForumViewHolder.c.setOnClickListener(new a(this, kp7Var, interestedForumViewHolder, i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: t */
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i)) == null) ? new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d04ff, (ViewGroup) null)) : (InterestedForumViewHolder) invokeLI.objValue;
    }

    public void u() {
        List<kp7> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (list = this.a) == null || list.size() == 0) {
            return;
        }
        for (kp7 kp7Var : this.a) {
            int i = kp7Var.e;
            kp7Var.a.get(i).b = !this.d;
            B(kp7Var, i);
            int size = i + (-1) < 0 ? kp7Var.a.size() - 1 : i - 1;
            kp7Var.a.get(size).b = !this.d;
            B(kp7Var, size);
            if (size - 1 < 0) {
                size = kp7Var.a.size();
            }
            int i2 = size - 1;
            kp7Var.a.get(i2).b = !this.d;
            B(kp7Var, i2);
        }
        this.d = !this.d;
        notifyDataSetChanged();
        c cVar = this.c;
        if (cVar != null) {
            boolean z = this.d;
            if (z) {
                this.b = this.a.size() * 3;
                this.c.a(this.a.size() * 3, this.d);
                return;
            }
            this.b = 0;
            cVar.a(0, z);
        }
    }

    public final void v(InterestedForumViewHolder interestedForumViewHolder, qp7 qp7Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, interestedForumViewHolder, qp7Var) == null) {
            interestedForumViewHolder.f.setVisibility(0);
            interestedForumViewHolder.i.setVisibility(0);
            interestedForumViewHolder.i.K(qp7Var.a.avatar, 10, false);
            interestedForumViewHolder.l.setText(qp7Var.a.forum_name);
            if (TextUtils.isEmpty(qp7Var.a.slogan)) {
                str = "百度" + qp7Var.a.forum_name + "吧";
            } else {
                str = qp7Var.a.slogan;
            }
            interestedForumViewHolder.o.setText(str);
            interestedForumViewHolder.r.setText("关注 " + StringHelper.numberUniformFormatExtra(qp7Var.a.member_count.intValue()));
            interestedForumViewHolder.u.setText("贴子 " + StringHelper.numberUniformFormatExtra(qp7Var.a.thread_count.intValue()));
            A(interestedForumViewHolder.x, qp7Var);
            y(qp7Var, interestedForumViewHolder.x);
        }
    }

    public final void w(InterestedForumViewHolder interestedForumViewHolder, qp7 qp7Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, interestedForumViewHolder, qp7Var) == null) {
            interestedForumViewHolder.e.setVisibility(0);
            interestedForumViewHolder.h.setVisibility(0);
            interestedForumViewHolder.h.K(qp7Var.a.avatar, 10, false);
            interestedForumViewHolder.k.setText(qp7Var.a.forum_name);
            if (TextUtils.isEmpty(qp7Var.a.slogan)) {
                str = "百度" + qp7Var.a.forum_name + "吧";
            } else {
                str = qp7Var.a.slogan;
            }
            interestedForumViewHolder.n.setText(str);
            interestedForumViewHolder.q.setText("关注 " + StringHelper.numberUniformFormatExtra(qp7Var.a.member_count.intValue()));
            interestedForumViewHolder.t.setText("贴子 " + StringHelper.numberUniformFormatExtra(qp7Var.a.thread_count.intValue()));
            A(interestedForumViewHolder.w, qp7Var);
            y(qp7Var, interestedForumViewHolder.w);
        }
    }

    public void x(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            this.c = cVar;
        }
    }

    public final void y(qp7 qp7Var, TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, qp7Var, tBSpecificationBtn) == null) {
            tBSpecificationBtn.setOnClickListener(new b(this, qp7Var, tBSpecificationBtn));
        }
    }

    public final void z(InterestedForumViewHolder interestedForumViewHolder, qp7 qp7Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, interestedForumViewHolder, qp7Var) == null) {
            interestedForumViewHolder.d.setVisibility(0);
            interestedForumViewHolder.g.setVisibility(0);
            interestedForumViewHolder.g.K(qp7Var.a.avatar, 10, false);
            interestedForumViewHolder.j.setText(qp7Var.a.forum_name);
            if (TextUtils.isEmpty(qp7Var.a.slogan)) {
                str = "百度" + qp7Var.a.forum_name + "吧";
            } else {
                str = qp7Var.a.slogan;
            }
            interestedForumViewHolder.m.setText(str);
            interestedForumViewHolder.p.setText("关注 " + StringHelper.numberUniformFormatExtra(qp7Var.a.member_count.intValue()));
            interestedForumViewHolder.s.setText("贴子 " + StringHelper.numberUniformFormatExtra(qp7Var.a.thread_count.intValue()));
            A(interestedForumViewHolder.v, qp7Var);
            y(qp7Var, interestedForumViewHolder.v);
        }
    }
}
