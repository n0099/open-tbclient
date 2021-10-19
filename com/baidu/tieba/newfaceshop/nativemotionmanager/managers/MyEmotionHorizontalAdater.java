package com.baidu.tieba.newfaceshop.nativemotionmanager.managers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import c.a.r0.f2.h.d.a;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionPackageData> f54735e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C0853a> f54736f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f54737g;

    /* renamed from: h  reason: collision with root package name */
    public int f54738h;

    /* renamed from: i  reason: collision with root package name */
    public int f54739i;

    /* loaded from: classes7.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EmotionManageHorizontalView f54740a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmotionGridViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54740a = (EmotionManageHorizontalView) view;
        }

        public void setData(EmotionPackageData emotionPackageData, int i2) {
            EmotionManageHorizontalView emotionManageHorizontalView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, emotionPackageData, i2) == null) || (emotionManageHorizontalView = this.f54740a) == null || emotionPackageData == null) {
                return;
            }
            emotionManageHorizontalView.setData(emotionPackageData, i2);
        }
    }

    /* loaded from: classes7.dex */
    public class a implements AbsHListView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f54741a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MyEmotionHorizontalAdater f54742b;

        public a(MyEmotionHorizontalAdater myEmotionHorizontalAdater, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionHorizontalAdater, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54742b = myEmotionHorizontalAdater;
            this.f54741a = i2;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i2, int i3, int i4) {
            int i5;
            a.C0853a c0853a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(1048576, this, absHListView, i2, i3, i4) == null) || (i5 = this.f54741a) < 0 || i5 >= this.f54742b.f54736f.size() || (c0853a = (a.C0853a) this.f54742b.f54736f.get(this.f54741a)) == null) {
                return;
            }
            int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
            c0853a.f17570b = i2;
            c0853a.f17571c = left;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absHListView, i2) == null) {
            }
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C0853a> list2, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54735e = list;
        this.f54736f = list2;
        this.f54737g = tbPageContext;
        c();
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54738h : invokeV.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f54738h = 0;
            this.f54739i = 0;
            for (EmotionPackageData emotionPackageData : this.f54735e) {
                if (emotionPackageData.ishasdownload) {
                    this.f54738h++;
                } else {
                    this.f54739i++;
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54735e.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f54735e.get(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        EmotionGridViewHolder emotionGridViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = new EmotionManageHorizontalView(this.f54737g);
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                emotionGridViewHolder = new EmotionGridViewHolder(view);
                view.setTag(emotionGridViewHolder);
            } else {
                emotionGridViewHolder = null;
            }
            if (emotionGridViewHolder == null) {
                emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
            }
            emotionGridViewHolder.setData(this.f54735e.get(i2), this.f54739i);
            HListView listView = emotionGridViewHolder.f54740a.getListView();
            a.C0853a c0853a = this.f54736f.get(i2);
            if (c0853a != null) {
                listView.setSelectionFromLeft(c0853a.f17570b, c0853a.f17571c);
            }
            listView.setOnScrollListener(new a(this, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
