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
import com.baidu.tbadk.core.view.commonGroupChatCard.TbGroupChatCardLinkLayout;
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
/* loaded from: classes6.dex */
public class n9a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinkedList<h85> b;
    public LinkedList<hz4> c;
    public f d;

    /* loaded from: classes6.dex */
    public interface f {
        void a(List<hz4> list);

        void b(int i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements q75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ n9a b;

        public a(n9a n9aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n9aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n9aVar;
            this.a = i;
        }

        @Override // com.baidu.tieba.q75
        public void a(String str) {
            h85 g;
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

    /* loaded from: classes6.dex */
    public class b implements TbGroupChatCardLinkLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ n9a b;

        public b(n9a n9aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n9aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n9aVar;
            this.a = i;
        }

        @Override // com.baidu.tbadk.core.view.commonGroupChatCard.TbGroupChatCardLinkLayout.b
        public void a(TbGroupChatCardLinkLayout.ClickType clickType) {
            h85 g;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, clickType) != null) || clickType != TbGroupChatCardLinkLayout.ClickType.CLICK_CLOSE || (g = this.b.g(this.a)) == null) {
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

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ n9a b;

        public c(n9a n9aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n9aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n9aVar;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            h85 g;
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

    /* loaded from: classes6.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbGroupChatCardLinkLayout a;

        public d(n9a n9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(n9a n9aVar, a aVar) {
            this(n9aVar);
        }
    }

    /* loaded from: classes6.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbMountCardLinkLayout a;

        public e(n9a n9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(n9a n9aVar, a aVar) {
            this(n9aVar);
        }
    }

    /* loaded from: classes6.dex */
    public class g {
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

        public g(n9a n9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(n9a n9aVar, a aVar) {
            this(n9aVar);
        }
    }

    public n9a(TbPageContext tbPageContext) {
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

    public h85 g(int i) {
        InterceptResult invokeI;
        LinkedList<h85> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            long itemId = getItemId(i);
            if (itemId != 0 && (linkedList = this.b) != null) {
                Iterator<h85> it = linkedList.iterator();
                while (it.hasNext()) {
                    h85 next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (h85) invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        hz4 hz4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            LinkedList<hz4> linkedList = this.c;
            if (linkedList != null && linkedList.size() > i && (hz4Var = this.c.get(i)) != null) {
                int i2 = hz4Var.o;
                if (i2 == 4) {
                    return 1;
                }
                if (i2 == 5) {
                    return 2;
                }
                return 0;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            LinkedList<hz4> linkedList = this.c;
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
            LinkedList<hz4> linkedList = this.c;
            if (linkedList != null && linkedList.size() > i && this.c.get(i) != null) {
                i2 = this.c.get(i).a;
            } else {
                i2 = 0;
            }
            return i2;
        }
        return invokeI.longValue;
    }

    public void i(LinkedList<h85> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, linkedList) == null) {
            this.b = linkedList;
        }
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            this.d = fVar;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.clear();
            if (ListUtils.isEmpty(this.b)) {
                return;
            }
            Iterator<h85> it = this.b.iterator();
            while (it.hasNext()) {
                h85 next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.v() != null) {
                        hz4 v = tbLinkSpanGroup.v();
                        v.q = tbLinkSpanGroup.f();
                        this.c.add(v);
                    }
                }
            }
            Collections.sort(this.c);
        }
    }

    public LinkedList<hz4> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (LinkedList) invokeV.objValue;
    }

    public LinkedList<h85> f() {
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
            LinkedList<hz4> linkedList = this.c;
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
            Iterator<hz4> it = this.c.iterator();
            while (it.hasNext()) {
                hz4 next = it.next();
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
        g gVar;
        View view3;
        TbGroupChatCardLinkLayout tbGroupChatCardLinkLayout;
        View view4;
        TbMountCardLinkLayout tbMountCardLinkLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            hz4 hz4Var = (hz4) getItem(i);
            d dVar = null;
            e eVar = null;
            if (hz4Var == null) {
                return null;
            }
            if (getItemViewType(i) == 1) {
                if (view2 == null) {
                    view4 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.write_link_mount_card_item_layout, (ViewGroup) null);
                    e eVar2 = new e(this, null);
                    eVar2.a = (TbMountCardLinkLayout) view4.findViewById(R.id.write_item_link_mount_card);
                    view4.setTag(eVar2);
                    eVar = eVar2;
                } else {
                    if (view2.getTag() instanceof e) {
                        eVar = (e) view2.getTag();
                    }
                    view4 = view2;
                }
                if (eVar != null && (tbMountCardLinkLayout = eVar.a) != null) {
                    tbMountCardLinkLayout.setData(hz4Var.p);
                    tbMountCardLinkLayout.setClickListener(new a(this, i));
                }
                return view4;
            } else if (getItemViewType(i) == 2) {
                if (view2 == null) {
                    TbGroupChatCardLinkLayout tbGroupChatCardLinkLayout2 = new TbGroupChatCardLinkLayout(this.a.getPageActivity());
                    d dVar2 = new d(this, null);
                    dVar2.a = tbGroupChatCardLinkLayout2;
                    tbGroupChatCardLinkLayout2.setTag(dVar2);
                    dVar = dVar2;
                    tbGroupChatCardLinkLayout = tbGroupChatCardLinkLayout2;
                } else {
                    if (view2.getTag() instanceof d) {
                        dVar = (d) view2.getTag();
                    }
                    tbGroupChatCardLinkLayout = view2;
                }
                TbGroupChatCardLinkLayout tbGroupChatCardLinkLayout3 = dVar.a;
                tbGroupChatCardLinkLayout3.c(hz4Var);
                tbGroupChatCardLinkLayout3.setCardClickListener(new b(this, i));
                return tbGroupChatCardLinkLayout;
            } else {
                if (view2 == null) {
                    view3 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0441, (ViewGroup) null);
                    gVar = new g(this, null);
                    gVar.a = view3.findViewById(R.id.obfuscated_res_0x7f090758);
                    gVar.b = view3.findViewById(R.id.obfuscated_res_0x7f090756);
                    TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f090754);
                    gVar.d = tbImageView;
                    tbImageView.setConrers(15);
                    gVar.d.setRadius(ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                    gVar.d.setPlaceHolderAutoChangeSkinType(1);
                    gVar.d.setGifIconSupport(false);
                    gVar.d.setLongIconSupport(false);
                    gVar.d.setDrawBorder(true);
                    gVar.d.setBorderWidth(ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                    gVar.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                    gVar.e = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f090753);
                    gVar.f = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090752);
                    gVar.c = view3.findViewById(R.id.extra_info_container);
                    gVar.g = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f090757);
                    gVar.h = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f090751);
                    gVar.i = view3.findViewById(R.id.obfuscated_res_0x7f090759);
                    view3.setTag(gVar);
                } else {
                    gVar = (g) view2.getTag();
                    view3 = view2;
                }
                gVar.d.N(hz4Var.e, 10, false);
                if (TextUtils.isEmpty(hz4Var.f)) {
                    gVar.c.setVisibility(8);
                    gVar.e.setMaxLines(2);
                } else {
                    gVar.c.setVisibility(0);
                    gVar.e.setMaxLines(1);
                }
                if (TextUtils.isEmpty(hz4Var.f)) {
                    gVar.g.setVisibility(8);
                } else {
                    gVar.g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), hz4Var.f));
                    gVar.g.setVisibility(0);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (!TextUtils.isEmpty(hz4Var.l)) {
                    spannableStringBuilder.append((CharSequence) hz4Var.l);
                    int g2 = ri.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                    int g3 = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                    int g4 = ri.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                    int g5 = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                    int g6 = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                    int g7 = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                    t65 t65Var = new t65(g2, -1, R.color.CAM_X0305, g4, R.color.CAM_X0305, g5, ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                    t65Var.b(g3);
                    t65Var.h(g6);
                    t65Var.i(g7);
                    spannableStringBuilder.setSpan(t65Var, 0, hz4Var.l.length(), 17);
                }
                if (!hz4Var.n && hz4Var.b != 2 && !hz4Var.i) {
                    String str = hz4Var.g;
                    if (str != null) {
                        spannableStringBuilder.append((CharSequence) str);
                    }
                    gVar.e.setMaxLines(1);
                } else {
                    String str2 = hz4Var.c;
                    if (str2 != null) {
                        spannableStringBuilder.append((CharSequence) str2);
                    }
                }
                gVar.e.setText(spannableStringBuilder);
                gVar.f.setOnClickListener(new c(this, i));
                SkinManager.setBackgroundShapeDrawable(gVar.a, 0, R.color.CAM_X0205, R.color.CAM_X0205);
                p45 d2 = p45.d(gVar.b);
                d2.o(R.string.J_X05);
                d2.f(R.color.CAM_X0206);
                WebPManager.setPureDrawable(gVar.f, R.drawable.icon_pure_mount_card_link_right_del, R.color.CAM_X0108, null);
                SkinManager.setViewTextColor(gVar.e, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(gVar.g, (int) R.color.CAM_X0305);
                SkinManager.setViewTextColor(gVar.h, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColorToTransparent(gVar.i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
                return view3;
            }
        }
        return (View) invokeILL.objValue;
    }
}
