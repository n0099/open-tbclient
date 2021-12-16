package com.baidu.tieba.write.write.work.topic.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.s0.n4.e;
import c.a.s0.n4.h;
import c.a.s0.r1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class VideoHotTopicSearchAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ICON_PADDING;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_VIDEO = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f51761b;

    /* renamed from: c  reason: collision with root package name */
    public List<f> f51762c;

    /* renamed from: d  reason: collision with root package name */
    public LayoutInflater f51763d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f51764e;

    /* renamed from: f  reason: collision with root package name */
    public a f51765f;

    /* renamed from: g  reason: collision with root package name */
    public long f51766g;

    /* loaded from: classes12.dex */
    public interface a {
        void a(f fVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1949611039, "Lcom/baidu/tieba/write/write/work/topic/adapter/VideoHotTopicSearchAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1949611039, "Lcom/baidu/tieba/write/write/work/topic/adapter/VideoHotTopicSearchAdapter;");
                return;
            }
        }
        ICON_PADDING = UtilHelper.getDimenPixelSize(e.M_W_X001);
    }

    public VideoHotTopicSearchAdapter(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f51762c = new ArrayList();
        this.f51766g = -1L;
        this.f51764e = tbPageContext;
        this.f51763d = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public void clearList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f51762c.clear();
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51762c.size() : invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.a : invokeI.intValue;
    }

    public List<f> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51762c : (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) || (fVar = (f) ListUtils.getItem(this.f51762c, i2)) == null) {
            return;
        }
        if (viewHolder instanceof HotNormalViewHolder) {
            HotNormalViewHolder hotNormalViewHolder = (HotNormalViewHolder) viewHolder;
            hotNormalViewHolder.bindViewHolder(hotNormalViewHolder, i2, fVar, this.f51764e, this.f51761b, this.f51765f);
        } else if (viewHolder instanceof HotVideoViewHolder) {
            HotVideoViewHolder hotVideoViewHolder = (HotVideoViewHolder) viewHolder;
            hotVideoViewHolder.bindDataToViewHolder(hotVideoViewHolder, i2, fVar, this.f51764e, this.f51766g, this.f51765f, this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            if (i2 == 2) {
                return new HotVideoViewHolder(this.f51763d.inflate(h.hot_video_topic_item, viewGroup, false));
            }
            return new HotNormalViewHolder(this.f51763d.inflate(h.hot_video_normal_topic_item, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setList(String str, List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, list) == null) {
            this.f51761b = str;
            this.f51762c.clear();
            if (list != null) {
                this.f51762c.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void setOnClickItemListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f51765f = aVar;
        }
    }

    public void setSelectTopicId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.f51766g = j2;
        }
    }

    public void setmAdapterType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.a = i2;
        }
    }
}
