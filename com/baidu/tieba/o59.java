package com.baidu.tieba;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonMountCard.TbMountCardLinkLayout;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class o59 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinkedList<j05> b;
    public LinkedList<qs4> c;
    public d d;

    /* loaded from: classes5.dex */
    public interface d {
        void a(List<qs4> list);

        void b(int i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements sz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ o59 b;

        public a(o59 o59Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o59Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o59Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.sz4
        public void a(String str) {
            j05 g;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || !"4".equals(str) || (g = this.b.g(this.a)) == null) {
                return;
            }
            if (this.b.d != null) {
                this.b.d.b(g.e());
            }
            if (this.b.d != null) {
                this.b.d.a(this.b.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ o59 b;

        public b(o59 o59Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o59Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o59Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            j05 g;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (g = this.b.g(this.a)) == null) {
                return;
            }
            if (this.b.d != null) {
                this.b.d.b(g.e());
            }
            if (this.b.d != null) {
                this.b.d.a(this.b.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbMountCardLinkLayout a;

        public c(o59 o59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(o59 o59Var, a aVar) {
            this(o59Var);
        }
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public View c;
        public TbImageView d;
        public TextView e;
        public ImageView f;
        public TextView g;
        public TextView h;
        public View i;

        public e(o59 o59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(o59 o59Var, a aVar) {
            this(o59Var);
        }
    }

    public o59(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList<>();
        this.a = tbPageContext;
    }

    public j05 g(int i) {
        InterceptResult invokeI;
        LinkedList<j05> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            long itemId = getItemId(i);
            if (itemId != 0 && (linkedList = this.b) != null) {
                Iterator<j05> it = linkedList.iterator();
                while (it.hasNext()) {
                    j05 next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (j05) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            LinkedList<qs4> linkedList = this.c;
            if (linkedList != null && linkedList.size() > i) {
                return this.c.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            LinkedList<qs4> linkedList = this.c;
            if (linkedList != null && linkedList.size() > i && this.c.get(i) != null) {
                i2 = this.c.get(i).a;
            } else {
                i2 = 0;
            }
            return i2;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        qs4 qs4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            LinkedList<qs4> linkedList = this.c;
            if (linkedList != null && linkedList.size() > i && (qs4Var = this.c.get(i)) != null && qs4Var.o == 4) {
                return 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public void i(LinkedList<j05> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, linkedList) == null) {
            this.b = linkedList;
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.d = dVar;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.clear();
            if (ListUtils.isEmpty(this.b)) {
                return;
            }
            Iterator<j05> it = this.b.iterator();
            while (it.hasNext()) {
                j05 next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.t() != null) {
                        qs4 t = tbLinkSpanGroup.t();
                        t.q = tbLinkSpanGroup.f();
                        this.c.add(t);
                    }
                }
            }
            Collections.sort(this.c);
        }
    }

    public LinkedList<qs4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (LinkedList) invokeV.objValue;
    }

    public LinkedList<j05> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (LinkedList) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<qs4> linkedList = this.c;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c();
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.c)) {
                return true;
            }
            Iterator<qs4> it = this.c.iterator();
            while (it.hasNext()) {
                qs4 next = it.next();
                if (next.b == 2 || !next.i) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        View view3;
        View view4;
        TbMountCardLinkLayout tbMountCardLinkLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            qs4 qs4Var = (qs4) getItem(i);
            c cVar = null;
            if (qs4Var == null) {
                return null;
            }
            if (getItemViewType(i) == 1) {
                if (view2 == null) {
                    view4 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0953, (ViewGroup) null);
                    c cVar2 = new c(this, null);
                    cVar2.a = (TbMountCardLinkLayout) view4.findViewById(R.id.obfuscated_res_0x7f092708);
                    view4.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    if (view2.getTag() instanceof c) {
                        cVar = (c) view2.getTag();
                    }
                    view4 = view2;
                }
                if (cVar != null && (tbMountCardLinkLayout = cVar.a) != null) {
                    tbMountCardLinkLayout.setData(qs4Var.p);
                    tbMountCardLinkLayout.setClickListener(new a(this, i));
                }
                return view4;
            }
            if (view2 == null) {
                view3 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03f3, (ViewGroup) null);
                eVar = new e(this, null);
                eVar.a = view3.findViewById(R.id.obfuscated_res_0x7f0906ac);
                eVar.b = view3.findViewById(R.id.obfuscated_res_0x7f0906aa);
                TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f0906a8);
                eVar.d = tbImageView;
                tbImageView.setConrers(15);
                eVar.d.setRadius(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                eVar.d.setPlaceHolderAutoChangeSkinType(1);
                eVar.d.setGifIconSupport(false);
                eVar.d.setLongIconSupport(false);
                eVar.d.setDrawBorder(true);
                eVar.d.setBorderWidth(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                eVar.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                eVar.e = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f0906a7);
                eVar.f = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0906a6);
                eVar.c = view3.findViewById(R.id.obfuscated_res_0x7f090984);
                eVar.g = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f0906ab);
                eVar.h = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f0906a5);
                eVar.i = view3.findViewById(R.id.obfuscated_res_0x7f0906ad);
                view3.setTag(eVar);
            } else {
                eVar = (e) view2.getTag();
                view3 = view2;
            }
            eVar.d.K(qs4Var.e, 10, false);
            if (TextUtils.isEmpty(qs4Var.f)) {
                eVar.c.setVisibility(8);
                eVar.e.setMaxLines(2);
            } else {
                eVar.c.setVisibility(0);
                eVar.e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(qs4Var.f)) {
                eVar.g.setVisibility(8);
            } else {
                eVar.g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0423), qs4Var.f));
                eVar.g.setVisibility(0);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(qs4Var.l)) {
                spannableStringBuilder.append((CharSequence) qs4Var.l);
                int g = yi.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int g5 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int g6 = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                vy4 vy4Var = new vy4(g, -1, R.color.CAM_X0305, g3, R.color.CAM_X0305, g4, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                vy4Var.b(g2);
                vy4Var.h(g5);
                vy4Var.i(g6);
                spannableStringBuilder.setSpan(vy4Var, 0, qs4Var.l.length(), 17);
            }
            if (!qs4Var.n && qs4Var.b != 2 && !qs4Var.i) {
                String str = qs4Var.g;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                eVar.e.setMaxLines(1);
            } else {
                String str2 = qs4Var.c;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            eVar.e.setText(spannableStringBuilder);
            eVar.f.setOnClickListener(new b(this, i));
            yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            SkinManager.setBackgroundShapeDrawable(eVar.a, 0, R.color.CAM_X0205, R.color.CAM_X0205);
            qw4 d2 = qw4.d(eVar.b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            eVar.f.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08082c, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(eVar.e, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(eVar.g, (int) R.color.CAM_X0305);
            SkinManager.setViewTextColor(eVar.h, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(eVar.i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
            return view3;
        }
        return (View) invokeILL.objValue;
    }
}
