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
import c.a.t0.n4.m.c.d.d;
import c.a.t0.n4.m.c.d.f;
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
/* loaded from: classes13.dex */
public class VideoClipAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements f {
    public static /* synthetic */ Interceptable $ic = null;
    public static int o = 1;
    public static int p = 2;
    public static int q = 3;
    public static int r = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public double f49480e;

    /* renamed from: f  reason: collision with root package name */
    public int f49481f;

    /* renamed from: g  reason: collision with root package name */
    public int f49482g;

    /* renamed from: h  reason: collision with root package name */
    public double f49483h;
    @IntRange(from = 0, to = 2)

    /* renamed from: i  reason: collision with root package name */
    public int f49484i;

    /* renamed from: j  reason: collision with root package name */
    public int f49485j;
    public int k;
    public final Context l;
    public SparseArray<Bitmap> m;
    public boolean n;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f49484i == 1 ? this.k : this.k + 2 : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.f49484i == 1) {
                return o;
            }
            if (i2 == 0) {
                return q;
            }
            int i3 = this.k;
            if (i2 == i3 + 1) {
                return r;
            }
            if (i2 == i3) {
                return p;
            }
            return o;
        }
        return invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        Bitmap bitmap;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) {
            if (viewHolder instanceof CommonRangerSliderHolder) {
                CommonRangerSliderHolder commonRangerSliderHolder = (CommonRangerSliderHolder) viewHolder;
                SparseArray<Bitmap> sparseArray = this.m;
                if (sparseArray == null) {
                    return;
                }
                if (this.f49484i == 1) {
                    bitmap = sparseArray.get(i2);
                } else {
                    bitmap = sparseArray.get(i2 - 1);
                }
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                commonRangerSliderHolder.bind(bitmap);
                if (getItemViewType(i2) == p) {
                    commonRangerSliderHolder.getView().setLayoutParams(new ViewGroup.LayoutParams((int) this.f49483h, this.f49485j));
                    i3 = (int) this.f49483h;
                } else {
                    i3 = this.f49481f;
                }
                ViewGroup.LayoutParams layoutParams = commonRangerSliderHolder.mItemView.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = this.f49482g;
                commonRangerSliderHolder.mItemView.setLayoutParams(layoutParams);
            } else if (viewHolder instanceof TransparentRangerSliderHolder) {
                ViewGroup.LayoutParams layoutParams2 = viewHolder.itemView.getLayoutParams();
                layoutParams2.width = (int) this.f49480e;
                viewHolder.itemView.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
            if (i2 != q && i2 != r) {
                if (i2 == o) {
                    View inflate = LayoutInflater.from(this.l).inflate(R.layout.ugc_video_ranger_slider_item, viewGroup, false);
                    inflate.setLayoutParams(new ViewGroup.LayoutParams(this.f49481f, this.f49485j));
                    return new CommonRangerSliderHolder(inflate);
                } else if (i2 == p) {
                    View inflate2 = LayoutInflater.from(this.l).inflate(R.layout.ugc_video_ranger_slider_item, viewGroup, false);
                    inflate2.setLayoutParams(new ViewGroup.LayoutParams((int) this.f49483h, this.f49485j));
                    return new CommonRangerSliderHolder(inflate2);
                } else {
                    return null;
                }
            }
            View view = new View(viewGroup.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams((int) this.f49480e, -1));
            view.setBackgroundColor(0);
            return new TransparentRangerSliderHolder(view);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    @Override // c.a.t0.n4.m.c.d.f
    public void onFrameResult(int i2, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, bitmap) == null) || this.n) {
            return;
        }
        if (this.m == null) {
            this.m = new SparseArray<>();
        }
        this.m.put(i2, bitmap);
        if (this.f49484i == 1) {
            notifyItemChanged(i2);
        } else {
            notifyItemChanged(i2 + 1);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n = true;
            SparseArray<Bitmap> sparseArray = this.m;
            if (sparseArray != null) {
                sparseArray.clear();
            }
        }
    }

    public void setData(VlogEditManager vlogEditManager, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, vlogEditManager, i2) == null) {
            int i4 = this.f49481f;
            int i5 = this.f49482g;
            MultiMediaData multiMediaData = (vlogEditManager == null || vlogEditManager.getMultiMediaData(0) == null) ? null : vlogEditManager.getMultiMediaData(0);
            if (multiMediaData != null && (i3 = multiMediaData.height) != 0) {
                i4 = (int) (((multiMediaData.width * 1.0f) / i3) * i5);
            }
            this.k = i2;
            d.b(vlogEditManager, TbadkCoreApplication.getInst().getContext(), i2, i4, i5, this);
            notifyDataSetChanged();
        }
    }

    public void setImageConfig(int i2, double d2, double d3, double d4, double d5, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Integer.valueOf(i3)}) == null) {
            this.f49484i = i2;
            this.f49480e = d2;
            this.f49481f = (int) d3;
            this.f49482g = (int) d4;
            this.f49483h = d5;
            this.f49485j = i3;
        }
    }

    public void setData(MultiMediaData multiMediaData, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, multiMediaData, i2) == null) {
            int i4 = this.f49481f;
            int i5 = this.f49482g;
            if (multiMediaData != null && (i3 = multiMediaData.height) != 0) {
                i4 = (int) (((multiMediaData.width * 1.0f) / i3) * i5);
            }
            this.k = i2;
            d.c(multiMediaData, TbadkCoreApplication.getInst().getContext(), i2, i4, i5, this);
            notifyDataSetChanged();
        }
    }
}
