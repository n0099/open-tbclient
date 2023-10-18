package com.baidu.tieba.newfaceshop.nativemotionmanager.managers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView;
import com.baidu.tieba.za9;
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
    public List<EmotionPackageData> a;
    public List<za9.a> b;
    public TbPageContext c;
    public int d;
    public int e;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EmotionManageHorizontalView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmotionGridViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (EmotionManageHorizontalView) view2;
        }

        public void b(EmotionPackageData emotionPackageData, int i) {
            EmotionManageHorizontalView emotionManageHorizontalView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, emotionPackageData, i) == null) && (emotionManageHorizontalView = this.a) != null && emotionPackageData != null) {
                emotionManageHorizontalView.setData(emotionPackageData, i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements AbsHListView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ MyEmotionHorizontalAdater b;

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absHListView, i) == null) {
            }
        }

        public a(MyEmotionHorizontalAdater myEmotionHorizontalAdater, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myEmotionHorizontalAdater, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = myEmotionHorizontalAdater;
            this.a = i;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i, int i2, int i3) {
            int i4;
            za9.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absHListView, i, i2, i3) == null) && (i4 = this.a) >= 0 && i4 < this.b.b.size() && (aVar = (za9.a) this.b.b.get(this.a)) != null) {
                int i5 = 0;
                if (absHListView.getChildCount() > 0) {
                    i5 = absHListView.getChildAt(0).getLeft();
                }
                aVar.b = i;
                aVar.c = i5;
            }
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<za9.a> list2, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.b = list2;
        this.c = tbPageContext;
        c();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = 0;
            this.e = 0;
            for (EmotionPackageData emotionPackageData : this.a) {
                if (emotionPackageData.ishasdownload) {
                    this.d++;
                } else {
                    this.e++;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        EmotionGridViewHolder emotionGridViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = new EmotionManageHorizontalView(this.c);
                view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                emotionGridViewHolder = new EmotionGridViewHolder(view2);
                view2.setTag(emotionGridViewHolder);
            } else {
                emotionGridViewHolder = null;
            }
            if (emotionGridViewHolder == null) {
                emotionGridViewHolder = (EmotionGridViewHolder) view2.getTag();
            }
            emotionGridViewHolder.b(this.a.get(i), this.e);
            HListView listView = emotionGridViewHolder.a.getListView();
            za9.a aVar = this.b.get(i);
            if (aVar != null) {
                listView.setSelectionFromLeft(aVar.b, aVar.c);
            }
            listView.setOnScrollListener(new a(this, i));
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
