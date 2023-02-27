package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xi1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.List;
/* loaded from: classes7.dex */
public class yi1 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<xi1.a> a;
    public Context b;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public ImageView c;
        public TextView d;
        public ImageView e;
        public LinearLayout f;
        public LinearLayout g;
        public TextView h;
        public ImageView i;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09079b);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09079a);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fbb);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905f8);
            this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09079c);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090798);
            this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090795);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090799);
            this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fc5);
        }
    }

    public yi1(Context context) {
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
        this.b = context;
    }

    public final String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            return new DecimalFormat("0").format((j * 1.0d) / 100.0d);
        }
        return (String) invokeJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public xi1.a getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (xi1.a) invokeI.objValue;
    }

    public void c(List<xi1.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<xi1.a> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            xi1.a item = getItem(i);
            if (item == null) {
                return view2;
            }
            boolean z2 = false;
            if (view2 == null) {
                view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d020c, (ViewGroup) null, false);
                view2.setTag(new a(view2));
            }
            if (view2.getTag() != null && (view2.getTag() instanceof a)) {
                a aVar = (a) view2.getTag();
                if (item.a == -1) {
                    aVar.g.setVisibility(8);
                    aVar.f.setVisibility(0);
                    aVar.h.setText(item.d);
                    ImageView imageView = aVar.i;
                    if (item.h == 1) {
                        z2 = true;
                    }
                    imageView.setSelected(z2);
                } else {
                    aVar.g.setVisibility(0);
                    aVar.f.setVisibility(8);
                    aVar.a.setText(item.d);
                    if (TextUtils.isEmpty(item.e)) {
                        aVar.b.setVisibility(8);
                    } else {
                        aVar.b.setVisibility(0);
                        aVar.b.setText(item.e);
                    }
                    ImageView imageView2 = aVar.c;
                    if (item.h == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    imageView2.setSelected(z);
                    SpannableString spannableString = new SpannableString("￥" + a(item.g.longValue()));
                    spannableString.setSpan(new AbsoluteSizeSpan(zh1.a(this.b, 14.0f)), 0, 1, 33);
                    aVar.d.setText(spannableString);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
