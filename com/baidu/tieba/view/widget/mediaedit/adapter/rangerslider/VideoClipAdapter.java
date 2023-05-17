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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.j6a;
import com.baidu.tieba.l6a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
/* loaded from: classes7.dex */
public class VideoClipAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements l6a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int k = 1;
    public static int l = 2;
    public static int m = 3;
    public static int n = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;
    public int b;
    public int c;
    public double d;
    @IntRange(from = 0, to = 2)
    public int e;
    public int f;
    public int g;
    public final Context h;
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
        this.h = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.e == 1) {
                return k;
            }
            if (i == 0) {
                return m;
            }
            int i2 = this.g;
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

    @Override // com.baidu.tieba.l6a
    public void a(int i, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048576, this, i, bitmap) != null) || this.j) {
            return;
        }
        if (this.i == null) {
            this.i = new SparseArray<>();
        }
        this.i.put(i, bitmap);
        if (this.e == 1) {
            notifyItemChanged(i);
        } else {
            notifyItemChanged(i + 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.e == 1) {
                return this.g;
            }
            return this.g + 2;
        }
        return invokeV.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j = true;
            SparseArray<Bitmap> sparseArray = this.i;
            if (sparseArray != null) {
                sparseArray.clear();
            }
        }
    }

    public void k(MultiMediaData multiMediaData, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, multiMediaData, i) == null) {
            int i3 = this.b;
            int i4 = this.c;
            if (multiMediaData != null && (i2 = multiMediaData.height) != 0) {
                i3 = (int) (((multiMediaData.width * 1.0f) / i2) * i4);
            }
            this.g = i;
            j6a.c(multiMediaData, TbadkCoreApplication.getInst().getContext(), i, i3, i4, this);
            notifyDataSetChanged();
        }
    }

    public void l(VlogEditManager vlogEditManager, int i) {
        MultiMediaData multiMediaData;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, vlogEditManager, i) == null) {
            int i3 = this.b;
            int i4 = this.c;
            if (vlogEditManager != null && vlogEditManager.getMultiMediaData(0) != null) {
                multiMediaData = vlogEditManager.getMultiMediaData(0);
            } else {
                multiMediaData = null;
            }
            if (multiMediaData != null && (i2 = multiMediaData.height) != 0) {
                i3 = (int) (((multiMediaData.width * 1.0f) / i2) * i4);
            }
            this.g = i;
            j6a.b(vlogEditManager, TbadkCoreApplication.getInst().getContext(), i, i3, i4, this);
            notifyDataSetChanged();
        }
    }

    public void m(int i, double d, double d2, double d3, double d4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Integer.valueOf(i2)}) == null) {
            this.e = i;
            this.a = d;
            this.b = (int) d2;
            this.c = (int) d3;
            this.d = d4;
            this.f = i2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Bitmap bitmap;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i) == null) {
            if (viewHolder instanceof CommonRangerSliderHolder) {
                CommonRangerSliderHolder commonRangerSliderHolder = (CommonRangerSliderHolder) viewHolder;
                SparseArray<Bitmap> sparseArray = this.i;
                if (sparseArray == null) {
                    return;
                }
                if (this.e == 1) {
                    bitmap = sparseArray.get(i);
                } else {
                    bitmap = sparseArray.get(i - 1);
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    commonRangerSliderHolder.a(bitmap);
                    if (getItemViewType(i) == l) {
                        commonRangerSliderHolder.getView().setLayoutParams(new ViewGroup.LayoutParams((int) this.d, this.f));
                        i2 = (int) this.d;
                    } else {
                        i2 = this.b;
                    }
                    ViewGroup.LayoutParams layoutParams = commonRangerSliderHolder.a.getLayoutParams();
                    layoutParams.width = i2;
                    layoutParams.height = this.c;
                    commonRangerSliderHolder.a.setLayoutParams(layoutParams);
                }
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) {
            if (i != m && i != n) {
                if (i == k) {
                    View inflate = LayoutInflater.from(this.h).inflate(R.layout.obfuscated_res_0x7f0d0964, viewGroup, false);
                    inflate.setLayoutParams(new ViewGroup.LayoutParams(this.b, this.f));
                    return new CommonRangerSliderHolder(inflate);
                } else if (i == l) {
                    View inflate2 = LayoutInflater.from(this.h).inflate(R.layout.obfuscated_res_0x7f0d0964, viewGroup, false);
                    inflate2.setLayoutParams(new ViewGroup.LayoutParams((int) this.d, this.f));
                    return new CommonRangerSliderHolder(inflate2);
                } else {
                    return null;
                }
            }
            View view2 = new View(viewGroup.getContext());
            view2.setLayoutParams(new ViewGroup.LayoutParams((int) this.a, -1));
            view2.setBackgroundColor(0);
            return new TransparentRangerSliderHolder(view2);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
