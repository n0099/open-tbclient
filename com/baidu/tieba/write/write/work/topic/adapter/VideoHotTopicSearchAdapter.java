package com.baidu.tieba.write.write.work.topic.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.nj8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoHotTopicSearchAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public List<nj8> c;
    public LayoutInflater d;
    public TbPageContext e;
    public a f;
    public long g;

    /* loaded from: classes8.dex */
    public interface a {
        void a(nj8 nj8Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i : invokeI.longValue;
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
        h = UtilHelper.getDimenPixelSize(R.dimen.M_W_X001);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.size();
        }
        return invokeV.intValue;
    }

    public VideoHotTopicSearchAdapter(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.c = new ArrayList();
        this.g = -1L;
        this.e = tbPageContext;
        this.d = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.a;
        }
        return invokeI.intValue;
    }

    public void m(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.g = j;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a = i;
        }
    }

    public void l(String str, List<nj8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) {
            this.b = str;
            this.c.clear();
            if (list != null) {
                this.c.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        nj8 nj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048583, this, viewHolder, i) != null) || (nj8Var = (nj8) ListUtils.getItem(this.c, i)) == null) {
            return;
        }
        if (viewHolder instanceof HotNormalViewHolder) {
            HotNormalViewHolder hotNormalViewHolder = (HotNormalViewHolder) viewHolder;
            hotNormalViewHolder.b(hotNormalViewHolder, i, nj8Var, this.e, this.b, this.f);
        } else if (viewHolder instanceof HotVideoViewHolder) {
            HotVideoViewHolder hotVideoViewHolder = (HotVideoViewHolder) viewHolder;
            hotVideoViewHolder.a(hotVideoViewHolder, i, nj8Var, this.e, this.g, this.f, this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i)) == null) {
            if (i == 2) {
                return new HotVideoViewHolder(this.d.inflate(R.layout.obfuscated_res_0x7f0d043a, viewGroup, false));
            }
            return new HotNormalViewHolder(this.d.inflate(R.layout.obfuscated_res_0x7f0d0439, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
