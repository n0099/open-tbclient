package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class wa6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public List<xa6> b;
    public d c;

    /* loaded from: classes6.dex */
    public interface d {
        void a(ya6 ya6Var);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa6 a;
        public final /* synthetic */ wa6 b;

        public a(wa6 wa6Var, xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa6Var, xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wa6Var;
            this.a = xa6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.c != null) {
                this.b.c.a(this.a.b(0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa6 a;
        public final /* synthetic */ wa6 b;

        public b(wa6 wa6Var, xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa6Var, xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wa6Var;
            this.a = xa6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.c != null) {
                this.b.c.a(this.a.b(1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa6 a;
        public final /* synthetic */ wa6 b;

        public c(wa6 wa6Var, xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa6Var, xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wa6Var;
            this.a = xa6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.c != null) {
                this.b.c.a(this.a.b(2));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TbImageView b;
        public TextView c;
        public RelativeLayout d;
        public TextView e;
        public TextView f;
        public TbImageView g;
        public TextView h;
        public RelativeLayout i;
        public TextView j;
        public TextView k;
        public TbImageView l;
        public TextView m;
        public RelativeLayout n;
        public TextView o;
        public View p;
        public TextView q;

        public e(wa6 wa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(wa6 wa6Var, a aVar) {
            this(wa6Var);
        }
    }

    public wa6(TbPageContext<?> tbPageContext, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = tbPageContext;
        this.c = dVar;
    }

    public void d(List<za6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || list == null) {
            return;
        }
        List<xa6> list2 = this.b;
        if (list2 != null && list2.size() > 0) {
            this.b.clear();
        }
        this.b = b(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            List<xa6> list = this.b;
            if (list != null && i < list.size()) {
                return this.b.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    public final List<xa6> b(List<za6> list) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                List<ya6> a2 = list.get(i2).a();
                int size = a2.size();
                if (size % 3 == 0) {
                    i = size / 3;
                } else {
                    i = (size / 3) + 1;
                }
                ya6[][] ya6VarArr = (ya6[][]) Array.newInstance(ya6.class, i, 3);
                for (int i3 = 0; i3 < size; i3++) {
                    int i4 = i3 / 3;
                    int i5 = i3 % 3;
                    ya6VarArr[i4][i5] = a2.get(i3);
                    ya6VarArr[i4][i5].o(list.get(i2).b());
                }
                arrayList2.add(ya6VarArr);
            }
            for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                for (int i7 = 0; i7 < ((ya6[][]) arrayList2.get(i6)).length; i7++) {
                    xa6 xa6Var = new xa6();
                    if (((ya6[][]) arrayList2.get(i6)).length == 1) {
                        xa6Var.e(1);
                    } else if (((ya6[][]) arrayList2.get(i6)).length > 1 && i7 == 0) {
                        xa6Var.e(2);
                    } else if (((ya6[][]) arrayList2.get(i6)).length > 1 && i7 == ((ya6[][]) arrayList2.get(i6)).length - 1) {
                        xa6Var.e(3);
                    } else {
                        xa6Var.e(4);
                    }
                    if (i6 == arrayList2.size() - 1) {
                        if (xa6Var.getType() == 1) {
                            xa6Var.e(2);
                        } else if (xa6Var.getType() == 3) {
                            xa6Var.e(4);
                        }
                    }
                    for (int i8 = 0; i8 < 3; i8++) {
                        if (((ya6[][]) arrayList2.get(i6))[i7][i8] != null) {
                            xa6Var.a(((ya6[][]) arrayList2.get(i6))[i7][i8]);
                        }
                    }
                    if (((ya6[][]) arrayList2.get(i6))[0][0] != null) {
                        xa6Var.d(((ya6[][]) arrayList2.get(i6))[0][0].h());
                    }
                    arrayList.add(xa6Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) != null) || eVar == null) {
            return;
        }
        SkinManager.setViewTextColor(eVar.q, R.color.CAM_X0105, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.a, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.f, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.k, R.color.CAM_X0107, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.e, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.j, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(eVar.o, R.color.CAM_X0305, 1, TbadkApplication.getInst().getSkinType());
        eVar.b.setDefaultResource(R.drawable.obfuscated_res_0x7f081017);
        eVar.g.setDefaultResource(R.drawable.obfuscated_res_0x7f081017);
        eVar.l.setDefaultResource(R.drawable.obfuscated_res_0x7f081017);
        SkinManager.setBackgroundColor(eVar.p, R.color.CAM_X0204);
    }

    public final void e(TbImageView tbImageView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, tbImageView, i) != null) || tbImageView == null) {
            return;
        }
        if (i == 0) {
            tbImageView.setAlpha(0.5f);
        } else if (i == 3) {
            tbImageView.setAlpha(0.2f);
        } else {
            tbImageView.setAlpha(1);
        }
    }

    public final void f(TextView textView, boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{textView, Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            if (z) {
                textView.setVisibility(0);
                Drawable normalSkinMoneyIcon = CurrencySwitchUtil.getNormalSkinMoneyIcon();
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                normalSkinMoneyIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                textView.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                textView.setCompoundDrawables(normalSkinMoneyIcon, null, null, null);
                textView.setText(AlaStringHelper.formatLowercasekDou((float) j));
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void g(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, textView, i) != null) || textView == null) {
            return;
        }
        if (i == 0) {
            textView.setText(R.string.obfuscated_res_0x7f0f01f4);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else if (i == 1) {
            textView.setText(R.string.obfuscated_res_0x7f0f01f5);
            SkinManager.setViewTextColor(textView, (int) R.color.obfuscated_res_0x7f06063b);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_green);
        } else if (i == 2) {
            textView.setText(R.string.obfuscated_res_0x7f0f01f3);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_blue);
        } else if (i == 3) {
            textView.setText(R.string.obfuscated_res_0x7f0f01f2);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_ala_person_privilege_status_bg_gray);
        } else {
            textView.setVisibility(4);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<xa6> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        String e2;
        String e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            xa6 xa6Var = this.b.get(i);
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00e6, viewGroup, false);
                eVar = new e(this, null);
                eVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b8);
                eVar.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901b3);
                eVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901bb);
                eVar.d = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901be);
                eVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c1);
                eVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b9);
                eVar.g = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901b4);
                eVar.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901bc);
                eVar.i = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901bf);
                eVar.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c2);
                eVar.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901ba);
                eVar.l = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0901b5);
                eVar.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901bd);
                eVar.n = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0901c0);
                eVar.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c3);
                eVar.p = view2.findViewById(R.id.obfuscated_res_0x7f0901b6);
                eVar.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b7);
            } else {
                eVar = (e) view2.getTag();
            }
            c(eVar);
            if (xa6Var != null) {
                String str = "";
                if (xa6Var.b(0) != null) {
                    ya6 b2 = xa6Var.b(0);
                    eVar.d.setVisibility(0);
                    TextView textView = eVar.a;
                    if (b2.e() == null) {
                        e3 = "";
                    } else {
                        e3 = b2.e();
                    }
                    textView.setText(e3);
                    if (b2.f() != null) {
                        eVar.b.setDefaultBgResource(R.color.transparent);
                        eVar.b.N(b2.f(), 10, false);
                    }
                    g(eVar.c, b2.j());
                    e(eVar.b, b2.j());
                    f(eVar.e, b2.m(), b2.n);
                    eVar.d.setOnClickListener(new a(this, xa6Var));
                } else {
                    eVar.d.setVisibility(4);
                    eVar.d.setOnClickListener(null);
                }
                if (xa6Var.b(1) != null) {
                    ya6 b3 = xa6Var.b(1);
                    eVar.i.setVisibility(0);
                    TextView textView2 = eVar.f;
                    if (b3.e() == null) {
                        e2 = "";
                    } else {
                        e2 = b3.e();
                    }
                    textView2.setText(e2);
                    if (b3.f() != null) {
                        eVar.g.setDefaultBgResource(R.color.transparent);
                        eVar.g.N(b3.f(), 10, false);
                    }
                    g(eVar.h, b3.j());
                    e(eVar.g, b3.j());
                    f(eVar.j, b3.m(), b3.n);
                    eVar.i.setOnClickListener(new b(this, xa6Var));
                } else {
                    eVar.i.setVisibility(4);
                    eVar.i.setOnClickListener(null);
                }
                if (xa6Var.b(2) != null) {
                    ya6 b4 = xa6Var.b(2);
                    eVar.n.setVisibility(0);
                    TextView textView3 = eVar.k;
                    if (b4.e() != null) {
                        str = b4.e();
                    }
                    textView3.setText(str);
                    if (b4.f() != null) {
                        eVar.l.setDefaultBgResource(R.color.transparent);
                        eVar.l.N(b4.f(), 10, false);
                    }
                    g(eVar.m, b4.j());
                    e(eVar.l, b4.j());
                    f(eVar.o, b4.m(), b4.n);
                    eVar.n.setOnClickListener(new c(this, xa6Var));
                } else {
                    eVar.n.setVisibility(4);
                    eVar.n.setOnClickListener(null);
                }
                if (xa6Var.getType() != 3 && xa6Var.getType() != 1) {
                    eVar.p.setVisibility(8);
                } else {
                    eVar.p.setVisibility(0);
                }
                if ((xa6Var.getType() == 1 || xa6Var.getType() == 2) && xa6Var.c() != null) {
                    eVar.q.setVisibility(0);
                    eVar.q.setText(xa6Var.c());
                } else {
                    eVar.q.setVisibility(8);
                }
            }
            view2.setTag(eVar);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
