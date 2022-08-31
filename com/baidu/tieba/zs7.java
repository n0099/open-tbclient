package com.baidu.tieba;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class zs7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<j08> a;
    public Context b;
    public int c;
    public int d;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public zs7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = 0;
        this.b = context;
        this.a = new ArrayList();
        this.c = ri.k(context) - (((int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201)) * 2);
        this.d = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207);
    }

    public final View a(int i, View view2) {
        InterceptResult invokeIL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof a)) {
                aVar = (a) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d01d4, (ViewGroup) null);
                aVar = new a();
                aVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917b1);
                view2.setTag(aVar);
            }
            j08 item = getItem(i);
            if (item instanceof k08) {
                k08 k08Var = (k08) item;
                if (!StringUtils.isNull(k08Var.e) && !"1".equals(k08Var.e)) {
                    aVar.a.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = aVar.a.getLayoutParams();
                    int i2 = this.c;
                    int c = k08Var.c(i2);
                    if (layoutParams == null) {
                        layoutParams = new AbsListView.LayoutParams(i2, c);
                    } else {
                        layoutParams.height = c;
                        layoutParams.width = i2;
                    }
                    aVar.a.setLayoutParams(layoutParams);
                    aVar.a.K(k08Var.d(), 17, false);
                } else {
                    aVar.a.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeIL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public j08 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<j08> list = this.a;
            if (list != null && list.size() > 0) {
                int size = this.a.size();
                if (i >= 0 && i < size) {
                    return this.a.get(i);
                }
            }
            return null;
        }
        return (j08) invokeI.objValue;
    }

    public final View c(int i, View view2) {
        InterceptResult invokeIL;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, view2)) == null) {
            if (view2 instanceof TextView) {
                textView = (TextView) view2;
            } else {
                textView = new TextView(this.b);
                textView.setTextSize(0, this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b7));
                textView.setLineSpacing(0.0f, 1.2f);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                int i2 = this.d;
                textView.setPadding(i2, 0, i2, 0);
            }
            j08 item = getItem(i);
            if (item instanceof m08) {
                m08 m08Var = (m08) item;
                textView.setText(m08Var.b());
                int d = m08Var.d();
                if (d == 1) {
                    textView.setGravity(17);
                } else if (d != 2) {
                    textView.setGravity(3);
                } else {
                    textView.setGravity(5);
                }
                if (!StringUtils.isNull(m08Var.e())) {
                    if (!SkinManager.setViewTextColor(textView, m08Var.e())) {
                        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                    }
                } else {
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                }
                if (m08Var.f() > 0) {
                    textView.setTextSize(0, m08Var.f());
                }
            }
            return textView;
        }
        return (View) invokeIL.objValue;
    }

    public void d(List<j08> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.a.clear();
            if (list == null || list.size() <= 0) {
                return;
            }
            this.a.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<j08> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            List<j08> list = this.a;
            if (list != null && list.size() > 0) {
                if (i >= 0 && i < this.a.size()) {
                    j08 j08Var = this.a.get(i);
                    if (j08Var == null) {
                        return super.getItemViewType(i);
                    }
                    if (j08Var.getType() == 0) {
                        return 0;
                    }
                    if (j08Var.getType() == 3) {
                        return 1;
                    }
                    return super.getItemViewType(i);
                }
                return super.getItemViewType(i);
            }
            return super.getItemViewType(i);
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                return c(i, view2);
            }
            if (itemViewType == 1) {
                return a(i, view2);
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
