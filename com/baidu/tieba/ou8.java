package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.tieba.memberCenter.bubble.BubbleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class ou8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<BubbleListData.BubbleData> a;
    public TbPageContext<BubbleChooseActivity> b;
    public int c;
    public int d;
    public boolean e;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    public ou8(TbPageContext<BubbleChooseActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = tbPageContext;
        this.c = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201);
        this.d = (int) this.b.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public BubbleListData.BubbleData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<BubbleListData.BubbleData> list = this.a;
            if (list != null) {
                if (i >= 0 || i < list.size()) {
                    return this.a.get(i);
                }
                return null;
            }
            return null;
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    public void c(List<BubbleListData.BubbleData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a.clear();
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            this.a.add(bubbleData);
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.e = z;
        }
    }

    public List<BubbleListData.BubbleData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<BubbleListData.BubbleData> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        BubbleView bubbleView;
        BubbleView bubbleView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                bubbleView2 = new BubbleView(this.b.getPageActivity());
                bubbleView = bubbleView2;
            } else {
                bubbleView = view2;
                bubbleView2 = (BubbleView) view2;
            }
            if (i == 0 || i == 1) {
                bubbleView2.setPadding(0, this.d, 0, 0);
            }
            if (getCount() % 2 == 0) {
                if (i == getCount() - 1 || i == getCount() - 2) {
                    bubbleView2.setPadding(0, bubbleView2.getPaddingTop(), 0, this.c);
                }
            } else if (i == getCount() - 1) {
                bubbleView2.setPadding(0, bubbleView2.getPaddingTop(), 0, this.c);
            }
            BubbleListData.BubbleData item = getItem(i);
            if (item != null) {
                bubbleView2.setShowName(true);
                bubbleView2.setData(item, this.e);
            }
            bubbleView2.a(this.b);
            return bubbleView;
        }
        return (View) invokeILL.objValue;
    }
}
