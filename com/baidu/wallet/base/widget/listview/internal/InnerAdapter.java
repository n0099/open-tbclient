package com.baidu.wallet.base.widget.listview.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.listview.BaseListAdapter;
import com.baidu.wallet.base.widget.listview.ViewMappingUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class InnerAdapter<T> extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<Class<?>> f60916a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60917b;

    /* renamed from: c  reason: collision with root package name */
    public BaseListAdapter<T> f60918c;

    public InnerAdapter(Context context, BaseListAdapter<T> baseListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baseListAdapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60916a = new ArrayList();
        this.f60917b = context;
        this.f60918c = baseListAdapter;
    }

    private void a(int i2, T t, BaseListAdapter.BaseViewHolder baseViewHolder, BaseListAdapter<T> baseListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), t, baseViewHolder, baseListAdapter}) == null) {
            baseViewHolder.setView(t, i2, this.f60917b, baseListAdapter);
        }
    }

    public int getBindItemViewResId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (BindLayoutMapping.getLayoutId(getViewBundles().get(this.f60918c.useItemTrueType() ? this.f60918c.getItemTrueType(i2) : this.f60918c.getItemViewType(i2))).equals("NOT_USE_XML")) {
                return -1;
            }
            return ResUtils.layout(this.f60917b, BindLayoutMapping.getLayoutId(getViewBundles().get(this.f60918c.useItemTrueType() ? this.f60918c.getItemTrueType(i2) : this.f60918c.getItemViewType(i2))));
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public T getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return null;
        }
        return (T) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        BaseListAdapter.BaseViewHolder baseViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                BaseListAdapter.BaseViewHolder onCreateViewHolder = onCreateViewHolder(i2, getViewBundles());
                baseViewHolder = onCreateViewHolder;
                view = a(i2, onCreateViewHolder);
            } else {
                baseViewHolder = (BaseListAdapter.BaseViewHolder) view.getTag();
            }
            if (view != null && view.getTag() != null) {
                a(i2, this.f60918c.getItem(i2), baseViewHolder, this.f60918c);
                return view;
            }
            throw new NullPointerException(" creatview fails");
        }
        return (View) invokeILL.objValue;
    }

    public List<Class<?>> getViewBundles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? a(this.f60916a) : (List) invokeV.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void handleViewHolder(BaseListAdapter.BaseViewHolder baseViewHolder, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, baseViewHolder, tArr) == null) {
        }
    }

    public BaseListAdapter.BaseViewHolder onCreateViewHolder(int i2, List<Class<?>> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list)) == null) {
            return (BaseListAdapter.BaseViewHolder) a(list.get(this.f60918c.useItemTrueType() ? this.f60918c.getItemTrueType(i2) : this.f60918c.getItemViewType(i2)));
        }
        return (BaseListAdapter.BaseViewHolder) invokeIL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.wallet.base.widget.listview.internal.InnerAdapter<T> */
    /* JADX WARN: Multi-variable type inference failed */
    private View a(int i2, BaseListAdapter.BaseViewHolder baseViewHolder) {
        InterceptResult invokeIL;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, this, i2, baseViewHolder)) == null) {
            if (getBindItemViewResId(i2) == -1) {
                inflate = baseViewHolder.createView(this.f60917b);
            } else {
                inflate = View.inflate(this.f60917b, getBindItemViewResId(i2), null);
                ViewMappingUtil.mapView(baseViewHolder, inflate);
            }
            handleViewHolder(baseViewHolder, new Object[0]);
            inflate.setTag(baseViewHolder);
            return inflate;
        }
        return (View) invokeIL.objValue;
    }

    public static <T> T a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[0]);
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (T) invokeL.objValue;
    }

    private List<Class<?>> a(List<Class<?>> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, list)) == null) {
            if (list.size() <= 0) {
                this.f60918c.onBindViewHolder(list);
            }
            return list;
        }
        return (List) invokeL.objValue;
    }
}
