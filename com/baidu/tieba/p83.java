package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.publisher.view.PhotoChooseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class p83 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public List<String> d;
    public Context e;
    public PhotoChooseView.b f;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ p83 b;

        public a(p83 p83Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p83Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p83Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.d.remove(this.a);
                this.b.notifyDataSetChanged();
                if (this.b.f != null) {
                    this.b.f.a(this.b.d.size());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SimpleDraweeView a;
        public ImageView b;
        public RelativeLayout c;
        public TextView d;

        public b() {
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

    public p83(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 9;
        this.d = new ArrayList(0);
        this.e = context;
        this.a = i;
        this.b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public String getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < this.d.size()) {
                return this.d.get(i);
            }
            return "more_option";
        }
        return (String) invokeI.objValue;
    }

    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == getCount() - 1 && this.d.size() < this.c) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void f(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && list != null) {
            for (String str : list) {
                if (!this.d.contains(str)) {
                    this.d.add(str);
                }
            }
        }
    }

    public void g(PhotoChooseView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c = i;
        }
    }

    public List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int size = this.d.size();
            int i = this.c;
            if (size < i) {
                return size + 1;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view3;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                bVar = new b();
                view3 = LayoutInflater.from(this.e).inflate(R.layout.obfuscated_res_0x7f0d092d, viewGroup, false);
                bVar.a = (SimpleDraweeView) view3.findViewById(R.id.obfuscated_res_0x7f091d8e);
                bVar.b = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f091d8b);
                bVar.c = (RelativeLayout) view3.findViewById(R.id.obfuscated_res_0x7f091d94);
                bVar.d = (TextView) view3.findViewById(R.id.obfuscated_res_0x7f091d95);
                bVar.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int o = po3.o(this.e) - po3.g(30.0f);
                int i2 = this.a;
                int i3 = this.b;
                int i4 = (o - (i2 * (i3 - 1))) / i3;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.a.getLayoutParams();
                layoutParams.width = i4;
                layoutParams.height = i4;
                bVar.a.setLayoutParams(layoutParams);
                bVar.a.setBackground(ContextCompat.getDrawable(this.e, R.drawable.obfuscated_res_0x7f08147c));
                view3.setTag(bVar);
            } else {
                view3 = view2;
                bVar = (b) view2.getTag();
            }
            int o2 = po3.o(this.e) / 3;
            int o3 = po3.o(this.e) / 3;
            bVar.b.setImageResource(R.drawable.obfuscated_res_0x7f08147b);
            bVar.b.setVisibility(8);
            if (e(i)) {
                bVar.c.setVisibility(8);
                bVar.a.setBackground(ContextCompat.getDrawable(this.e, R.drawable.obfuscated_res_0x7f081478));
                bVar.a.setImageResource(R.drawable.obfuscated_res_0x7f081476);
            } else {
                bVar.b.setVisibility(0);
                String item = getItem(i);
                if (!TextUtils.isEmpty(item)) {
                    if (jo3.c(item)) {
                        bVar.c.setVisibility(0);
                        bVar.d.setText(this.e.getString(R.string.obfuscated_res_0x7f0f14f5));
                    } else if (jo3.f(item)) {
                        bVar.c.setVisibility(0);
                        bVar.d.setText(this.e.getString(R.string.obfuscated_res_0x7f0f14f6));
                    } else {
                        bVar.c.setVisibility(8);
                    }
                    Fresco.getImagePipeline().evictFromCache(qo3.p(item));
                    bVar.a.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(false).setOldController(bVar.a.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(qo3.p(item)).setResizeOptions(new ResizeOptions((int) (o2 / 2.0f), (int) (o3 / 2.0f))).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setForceStaticImage(true).build()).build()).build());
                }
            }
            bVar.b.setOnClickListener(new a(this, i));
            return view3;
        }
        return (View) invokeILL.objValue;
    }
}
