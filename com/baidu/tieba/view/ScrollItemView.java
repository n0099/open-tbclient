package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollItemView extends ListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public int b;
    public Runnable c;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollItemView a;

        public a(ScrollItemView scrollItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollItemView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qg.a().removeCallbacks(this.a.c);
                if (this.a.getItemCount() > 0) {
                    ScrollItemView scrollItemView = this.a;
                    scrollItemView.smoothScrollToPositionFromTop(ScrollItemView.d(scrollItemView), 0, 300);
                }
                qg.a().postDelayed(this.a.c, 3000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollItemView a;

        public b(ScrollItemView scrollItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollItemView;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 0) {
                ScrollItemView scrollItemView = this.a;
                scrollItemView.setSelection(scrollItemView.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;
        public Context b;
        public final /* synthetic */ ScrollItemView c;

        public c(ScrollItemView scrollItemView, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollItemView, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = scrollItemView;
            this.b = context;
            this.a = new ArrayList();
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<String> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        public final String b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                List<String> list = this.a;
                return (list == null || i < 0) ? "" : this.a.get(i % list.size());
            }
            return (String) invokeI.objValue;
        }

        public void c(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                this.a.clear();
                this.a.addAll(list);
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.isEmpty(this.a) ? 0 : Integer.MAX_VALUE : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0747, viewGroup, false);
                    dVar = new d(this.c, view2);
                    view2.setTag(dVar);
                } else {
                    dVar = (d) view2.getTag();
                }
                dVar.a.setText(b(this.c.b));
                SkinManager.setViewTextColor(dVar.a, (int) R.color.CAM_X0109);
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public final /* synthetic */ ScrollItemView b;

        public d(ScrollItemView scrollItemView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollItemView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = scrollItemView;
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f75);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = new a(this);
        e(context);
    }

    public static /* synthetic */ int d(ScrollItemView scrollItemView) {
        int i = scrollItemView.b + 1;
        scrollItemView.b = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            c cVar = this.a;
            if (cVar == null) {
                return 0;
            }
            return cVar.a();
        }
        return invokeV.intValue;
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            c cVar = new c(this, context);
            this.a = cVar;
            setAdapter((ListAdapter) cVar);
            setOnScrollListener(new b(this));
            setClickable(false);
            setFocusable(false);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int floor = (int) Math.floor(getItemCount() * Math.random());
            this.b = floor;
            smoothScrollToPosition(floor);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            qg.a().postDelayed(this.c, 3000L);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            qg.a().removeCallbacks(this.c);
            setSelection(this.b);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            g();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            h();
        }
    }

    public void setData(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            h();
            this.a.c(list);
            f();
            g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = new a(this);
        e(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = new a(this);
        e(context);
    }
}
