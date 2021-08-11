package com.baidu.wallet.personal.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class a<T> extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<T> f63035a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63036b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f63037c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC1853a f63038d;

    /* renamed from: com.baidu.wallet.personal.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1853a {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public interface b<T> {
        void a(int i2, T t);

        void a(View view);

        void a(boolean z);

        void b(boolean z);

        void c(boolean z);
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63035a = new ArrayList();
        this.f63037c = LayoutInflater.from(context);
    }

    private View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, viewGroup, i2)) == null) {
            View inflate = this.f63036b ? this.f63037c.inflate(a(i2), viewGroup, false) : this.f63037c.inflate(a(i2), (ViewGroup) null);
            inflate.setTag(a(i2, inflate));
            if (inflate != null) {
                a(inflate, i2);
            }
            return inflate;
        }
        return (View) invokeLI.objValue;
    }

    public abstract int a(int i2);

    public abstract b<T> a(int i2, View view);

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f63035a == null) {
                    return;
                }
                this.f63035a.clear();
                notifyDataSetChanged();
            }
        }
    }

    public void a(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) {
        }
    }

    public synchronized void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
            synchronized (this) {
                if (this.f63035a == null) {
                    return;
                }
                this.f63035a.add(t);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<T> list = this.f63035a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public T getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            List<T> list = this.f63035a;
            if (list != null && i2 < list.size() && i2 >= 0) {
                return this.f63035a.get(i2);
            }
            return null;
        }
        return (T) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            View a2 = a(viewGroup, i2);
            Object tag = a2.getTag();
            if (tag != null && (tag instanceof b)) {
                ((b) tag).a(i2, getItem(i2));
            }
            return a2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        InterfaceC1853a interfaceC1853a;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.notifyDataSetChanged();
            if (this.f63038d == null) {
                return;
            }
            if (this.f63035a.size() == 0) {
                interfaceC1853a = this.f63038d;
                z = true;
            } else if (this.f63035a.size() <= 0) {
                return;
            } else {
                interfaceC1853a = this.f63038d;
                z = false;
            }
            interfaceC1853a.a(z);
        }
    }
}
