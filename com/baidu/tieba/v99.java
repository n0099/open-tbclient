package com.baidu.tieba;

import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.SingleThreadEmotionHorizontalAdater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class v99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleThreadEmotionHorizontalAdater a;
    public BdListView b;
    public ba9 c;
    public List<EmotionPackageData> d;

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public v99(TbPageContext<?> tbPageContext, BdListView bdListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = bdListView;
        ba9 ba9Var = new ba9(tbPageContext);
        this.c = ba9Var;
        ba9Var.c(TbadkCoreApplication.getInst().getSkinType());
        this.b.addHeaderView(this.c.b());
        this.d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.d, tbPageContext);
        this.a = singleThreadEmotionHorizontalAdater;
        this.b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void update(List<EmotionPackageData> list) {
        ba9 ba9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && list != null && (ba9Var = this.c) != null && this.a != null) {
            ba9Var.update(Integer.valueOf(list.size()));
            this.d.clear();
            if (list != null) {
                this.d.addAll(list);
            }
            this.a.notifyDataSetChanged();
        }
    }
}
