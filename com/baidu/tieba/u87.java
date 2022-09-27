package com.baidu.tieba;

import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.tieba.qa7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class u87 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<OfficialBarFeedActivity> a;
    public List<ra7> b;
    public LongSparseArray<ea7> c;
    public OfficialBarFeedMsglistAdapter.c d;
    public BdTypeListView e;
    public boolean f;

    /* loaded from: classes6.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<r87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u87 u87Var, View view2, r87 r87Var) {
            super(view2, r87Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u87Var, view2, r87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public u87(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.a = tbPageContext;
        this.d = cVar;
        this.e = bdTypeListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ra7 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<ra7> list = this.b;
            if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
                return null;
            }
            return this.b.get(i);
        }
        return (ra7) invokeI.objValue;
    }

    public final View b(int i, View view2, ViewGroup viewGroup, ra7 ra7Var, MsgCommonItemAdapter.MsgViewHolder<r87> msgViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ra7Var, msgViewHolder})) == null) {
            r87 a2 = msgViewHolder.a();
            qa7.a d = ra7Var.d();
            d.m = ra7Var.b();
            LongSparseArray<ea7> longSparseArray = this.c;
            a2.p(this.a.getPageActivity().getBaseContext(), d, ra7Var.c(), longSparseArray == null ? null : longSparseArray.get(d.h), ra7Var.e(), ra7Var.f(), i);
            StatisticItem statisticItem = new StatisticItem(this.f ? "c13865" : "c13863");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            String str = d.n;
            if (str == null) {
                str = "";
            }
            statisticItem.param("tid", str);
            statisticItem.param("fid", d.e);
            TiebaStatic.log(statisticItem);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void c(List<ra7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            if (this.b == null) {
                this.b = new LinkedList();
            }
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f = z;
        }
    }

    @RequiresApi(api = 16)
    public void e(LongSparseArray<ea7> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, longSparseArray) == null) {
            if (this.c == null) {
                this.c = new LongSparseArray<>();
            }
            this.c.clear();
            for (int i = 0; i < longSparseArray.size(); i++) {
                this.c.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<ra7> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            a aVar2 = view2 != null ? (a) view2.getTag() : null;
            if (aVar2 == null) {
                r87 r87Var = new r87(this.a, this.f);
                r87Var.q(this.d);
                View k = r87Var.k();
                a aVar3 = new a(this, r87Var.k(), r87Var);
                k.setTag(aVar3);
                view2 = k;
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            b(i, view2, viewGroup, getItem(i), aVar);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
