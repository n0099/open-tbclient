package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class jz7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public TbPageContext<?> c;
    public final Context d;
    public final LinearLayout e;
    public final View f;
    public final View g;
    public View h;
    public final BdRecyclerView i;
    public final LinearLayoutManager j;
    public final LinkedHashMap<Integer, Integer> k;
    public int l;
    public gg5 m;

    /* loaded from: classes6.dex */
    public class a implements BdListView.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz7 a;

        public a(jz7 jz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.m
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 != this.a.h) {
                return;
            }
            if (this.a.n()) {
                k58.e(this.a.b);
            }
            UrlManager.getInstance().dealOneLink(this.a.c, new String[]{this.a.m.f()});
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947900674, "Lcom/baidu/tieba/jz7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947900674, "Lcom/baidu/tieba/jz7;");
                return;
            }
        }
        n = i(2600.0f);
        o = i(1300.0f);
        p = i(150.0f);
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.d.getString(R.string.obfuscated_res_0x7f0f15b4).equals(this.b) && !this.d.getString(R.string.obfuscated_res_0x7f0f15b7).equals(this.b)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void o() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a != (skinType = TbadkApplication.getInst().getSkinType())) {
            this.a = skinType;
            this.f.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{SkinManager.getColor(R.color.transparent), SkinManager.getColor(R.color.CAM_X0202)}));
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0202);
        }
    }

    public jz7(ViewGroup viewGroup, BdRecyclerView bdRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, bdRecyclerView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.k = new LinkedHashMap<>();
        this.l = 0;
        this.d = viewGroup.getContext();
        this.i = bdRecyclerView;
        this.j = (LinearLayoutManager) bdRecyclerView.getLayoutManager();
        this.e = new LinearLayout(this.d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, n);
        this.e.setOrientation(1);
        this.e.setLayoutParams(layoutParams);
        viewGroup.addView(this.e, 0);
        View view2 = new View(this.d);
        this.f = view2;
        view2.setId(R.id.tb_color_head_gradient_layer);
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, p));
        this.e.addView(this.f);
        View view3 = new View(this.d);
        this.g = view3;
        view3.setId(R.id.tb_color_head_fillLayer);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        this.g.setLayoutParams(layoutParams2);
        this.e.addView(this.g);
    }

    public static int i(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65545, null, f)) == null) {
            return (int) TypedValue.applyDimension(1, f, TbadkApplication.getInst().getResources().getDisplayMetrics());
        }
        return invokeF.intValue;
    }

    public void p(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.c = tbPageContext;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.b = str;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        }
    }

    public static void g(gg5 gg5Var, TbImageView tbImageView, View view2) {
        String b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65543, null, gg5Var, tbImageView, view2) != null) || gg5Var == null) {
            return;
        }
        if (TbadkApplication.getInst().getSkinType() != 4) {
            b = gg5Var.a();
        } else {
            b = gg5Var.b();
        }
        if (!StringUtils.isNull(b)) {
            view2.setVisibility(0);
            tbImageView.setVisibility(8);
            view2.setBackgroundColor(y9a.f(b));
        }
    }

    public static void h(gg5 gg5Var, TbImageView tbImageView, View view2, BdResourceCallback<BdImage> bdResourceCallback, BdUniqueId bdUniqueId) {
        String d;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65544, null, gg5Var, tbImageView, view2, bdResourceCallback, bdUniqueId) != null) || gg5Var == null) {
            return;
        }
        if (TbadkApplication.getInst().getSkinType() != 4) {
            d = gg5Var.c();
        } else {
            d = gg5Var.d();
        }
        if (!TextUtils.isEmpty(d)) {
            tbImageView.setVisibility(0);
            view2.setVisibility(8);
            BdResourceLoader.getInstance().loadResource(d, 10, bdResourceCallback, bdUniqueId);
        }
    }

    public static boolean m(HashMap<String, gg5> hashMap, HashMap<String, gg5> hashMap2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, hashMap, hashMap2)) == null) {
            if (hashMap == null && hashMap2 == null) {
                return false;
            }
            if (hashMap == null || hashMap2 == null || hashMap.size() != hashMap2.size()) {
                return true;
            }
            for (String str : hashMap.keySet()) {
                gg5 gg5Var = hashMap.get(str);
                gg5 gg5Var2 = hashMap2.get(str);
                if (gg5Var != null || gg5Var2 != null) {
                    if (gg5Var == null || !gg5Var.q(hashMap2.get(str))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void f() {
        HashMap<String, gg5> colourHeaderConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (colourHeaderConfig = TbSingleton.getInstance().getColourHeaderConfig()) != null && colourHeaderConfig.containsKey(this.b)) {
            gg5 gg5Var = colourHeaderConfig.get(this.b);
            this.m = gg5Var;
            if (gg5Var != null) {
                int g = gg5Var.g();
                int e = this.m.e();
                if (g > 0 && e > 0) {
                    int equipmentWidth = (g * BdUtilHelper.getEquipmentWidth(TbadkApplication.getInst().getContext())) / e;
                    if (this.h == null) {
                        View view2 = new View(this.d);
                        this.h = view2;
                        view2.setId(R.id.tb_color_head_header_view);
                        this.h.setLayoutParams(new ViewGroup.LayoutParams(-1, equipmentWidth));
                        this.i.setOnHeaderClickListener(new a(this));
                        this.i.addHeaderView(this.h, 0);
                        if (n()) {
                            k58.l(this.b);
                        }
                    }
                } else {
                    return;
                }
            } else {
                View view3 = this.h;
                if (view3 != null && view3.getParent() != null) {
                    this.i.removeHeaderView(this.h);
                    this.h = null;
                }
            }
            l();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int findFirstVisibleItemPosition = this.j.findFirstVisibleItemPosition();
            View findViewByPosition = this.j.findViewByPosition(findFirstVisibleItemPosition);
            int height = findViewByPosition.getHeight();
            if (this.k.size() == 0) {
                this.k.put(Integer.valueOf(findFirstVisibleItemPosition), Integer.valueOf(height));
            } else if (!this.k.containsKey(Integer.valueOf(findFirstVisibleItemPosition))) {
                this.k.put(Integer.valueOf(findFirstVisibleItemPosition), Integer.valueOf(height));
            }
            int top = findViewByPosition.getTop();
            for (int i = 0; i < findFirstVisibleItemPosition; i++) {
                if (this.k.get(Integer.valueOf(i)) != null) {
                    this.l += this.k.get(Integer.valueOf(i)).intValue();
                }
            }
            int i2 = this.l - top;
            this.l = 0;
            if (i2 < o) {
                this.e.setScrollY(i2);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.d.getString(R.string.tab_name_topic_rank).equals(this.b)) {
                View childAt = this.i.getChildAt(0);
                if (childAt != null && childAt == this.h) {
                    int bottom = childAt.getBottom();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
                    layoutParams.topMargin = bottom;
                    this.f.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            View childAt2 = this.i.getChildAt(this.i.getHeaderViewsCount() - 1);
            if (childAt2 != null) {
                int bottom2 = childAt2.getBottom();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
                layoutParams2.topMargin = bottom2;
                this.f.setLayoutParams(layoutParams2);
            }
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }
}
