package com.baidu.tieba.view.widget.mediaedit.adapter.rangerslider;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.q4.n.c.d.d;
import c.a.p0.q4.n.c.d.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
/* loaded from: classes6.dex */
public class VideoClipAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements f {
    public static /* synthetic */ Interceptable $ic = null;
    public static int k = 1;
    public static int l = 2;
    public static int m = 3;
    public static int n = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;

    /* renamed from: b  reason: collision with root package name */
    public int f37176b;

    /* renamed from: c  reason: collision with root package name */
    public int f37177c;

    /* renamed from: d  reason: collision with root package name */
    public double f37178d;
    @IntRange(from = 0, to = 2)

    /* renamed from: e  reason: collision with root package name */
    public int f37179e;

    /* renamed from: f  reason: collision with root package name */
    public int f37180f;

    /* renamed from: g  reason: collision with root package name */
    public int f37181g;

    /* renamed from: h  reason: collision with root package name */
    public final Context f37182h;
    public SparseArray<Bitmap> i;
    public boolean j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2079608786, "Lcom/baidu/tieba/view/widget/mediaedit/adapter/rangerslider/VideoClipAdapter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2079608786, "Lcom/baidu/tieba/view/widget/mediaedit/adapter/rangerslider/VideoClipAdapter;");
        }
    }

    public VideoClipAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37182h = context;
    }

    @Override // c.a.p0.q4.n.c.d.f
    public void a(int i, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, bitmap) == null) || this.j) {
            return;
        }
        if (this.i == null) {
            this.i = new SparseArray<>();
        }
        this.i.put(i, bitmap);
        if (this.f37179e == 1) {
            notifyItemChanged(i);
        } else {
            notifyItemChanged(i + 1);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j = true;
            SparseArray<Bitmap> sparseArray = this.i;
            if (sparseArray != null) {
                sparseArray.clear();
            }
        }
    }

    public void e(MultiMediaData multiMediaData, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, multiMediaData, i) == null) {
            int i3 = this.f37176b;
            int i4 = this.f37177c;
            if (multiMediaData != null && (i2 = multiMediaData.height) != 0) {
                i3 = (int) (((multiMediaData.width * 1.0f) / i2) * i4);
            }
            this.f37181g = i;
            d.c(multiMediaData, TbadkCoreApplication.getInst().getContext(), i, i3, i4, this);
            notifyDataSetChanged();
        }
    }

    public void f(VlogEditManager vlogEditManager, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, vlogEditManager, i) == null) {
            int i3 = this.f37176b;
            int i4 = this.f37177c;
            MultiMediaData multiMediaData = (vlogEditManager == null || vlogEditManager.getMultiMediaData(0) == null) ? null : vlogEditManager.getMultiMediaData(0);
            if (multiMediaData != null && (i2 = multiMediaData.height) != 0) {
                i3 = (int) (((multiMediaData.width * 1.0f) / i2) * i4);
            }
            this.f37181g = i;
            d.b(vlogEditManager, TbadkCoreApplication.getInst().getContext(), i, i3, i4, this);
            notifyDataSetChanged();
        }
    }

    public void g(int i, double d2, double d3, double d4, double d5, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Integer.valueOf(i2)}) == null) {
            this.f37179e = i;
            this.a = d2;
            this.f37176b = (int) d3;
            this.f37177c = (int) d4;
            this.f37178d = d5;
            this.f37180f = i2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37179e == 1 ? this.f37181g : this.f37181g + 2 : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.f37179e == 1) {
                return k;
            }
            if (i == 0) {
                return m;
            }
            int i2 = this.f37181g;
            if (i == i2 + 1) {
                return n;
            }
            if (i == i2) {
                return l;
            }
            return k;
        }
        return invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Bitmap bitmap;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, viewHolder, i) == null) {
            if (viewHolder instanceof CommonRangerSliderHolder) {
                CommonRangerSliderHolder commonRangerSliderHolder = (CommonRangerSliderHolder) viewHolder;
                SparseArray<Bitmap> sparseArray = this.i;
                if (sparseArray == null) {
                    return;
                }
                if (this.f37179e == 1) {
                    bitmap = sparseArray.get(i);
                } else {
                    bitmap = sparseArray.get(i - 1);
                }
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                commonRangerSliderHolder.a(bitmap);
                if (getItemViewType(i) == l) {
                    commonRangerSliderHolder.b().setLayoutParams(new ViewGroup.LayoutParams((int) this.f37178d, this.f37180f));
                    i2 = (int) this.f37178d;
                } else {
                    i2 = this.f37176b;
                }
                ViewGroup.LayoutParams layoutParams = commonRangerSliderHolder.a.getLayoutParams();
                layoutParams.width = i2;
                layoutParams.height = this.f37177c;
                commonRangerSliderHolder.a.setLayoutParams(layoutParams);
            } else if (viewHolder instanceof TransparentRangerSliderHolder) {
                ViewGroup.LayoutParams layoutParams2 = viewHolder.itemView.getLayoutParams();
                layoutParams2.width = (int) this.a;
                viewHolder.itemView.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i)) == null) {
            if (i != m && i != n) {
                if (i == k) {
                    View inflate = LayoutInflater.from(this.f37182h).inflate(R.layout.obfuscated_res_0x7f0d085b, viewGroup, false);
                    inflate.setLayoutParams(new ViewGroup.LayoutParams(this.f37176b, this.f37180f));
                    return new CommonRangerSliderHolder(inflate);
                } else if (i == l) {
                    View inflate2 = LayoutInflater.from(this.f37182h).inflate(R.layout.obfuscated_res_0x7f0d085b, viewGroup, false);
                    inflate2.setLayoutParams(new ViewGroup.LayoutParams((int) this.f37178d, this.f37180f));
                    return new CommonRangerSliderHolder(inflate2);
                } else {
                    return null;
                }
            }
            View view = new View(viewGroup.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams((int) this.a, -1));
            view.setBackgroundColor(0);
            return new TransparentRangerSliderHolder(view);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
