package com.baidu.tieba;

import android.util.Pair;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.MyEmotionHorizontalAdater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class s59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public MyEmotionHorizontalAdater b;
    public List<EmotionPackageData> c;
    public final List<a> d;
    public x59 e;
    public q59 f;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "id: " + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + "firstVisibleItem: " + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + "padX: " + this.c;
            }
            return (String) invokeV.objValue;
        }
    }

    public s59(TbPageContext<?> tbPageContext, BdListView bdListView, q59 q59Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdListView, q59Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bdListView;
        x59 x59Var = new x59(tbPageContext);
        this.e = x59Var;
        x59Var.b(TbadkCoreApplication.getInst().getSkinType());
        this.a.addHeaderView(this.e.a());
        this.c = new ArrayList();
        this.d = new ArrayList();
        MyEmotionHorizontalAdater myEmotionHorizontalAdater = new MyEmotionHorizontalAdater(this.c, this.d, tbPageContext);
        this.b = myEmotionHorizontalAdater;
        this.f = q59Var;
        this.a.setAdapter((ListAdapter) myEmotionHorizontalAdater);
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i >= 0 && i < this.c.size() && i2 >= 0 && i2 < this.c.size()) {
            List<EmotionPackageData> list = this.c;
            list.add(i2, list.remove(i));
            List<a> list2 = this.d;
            list2.add(i2, list2.remove(i));
            this.b.notifyDataSetChanged();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921312, new Pair(Integer.valueOf(i), Integer.valueOf(i2))));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList arrayList = new ArrayList(this.d);
            this.d.clear();
            for (EmotionPackageData emotionPackageData : this.c) {
                a aVar = null;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a aVar2 = (a) it.next();
                    if (aVar2 != null && aVar2.a == emotionPackageData.id) {
                        aVar = aVar2;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a();
                    aVar.a = emotionPackageData.id;
                }
                this.d.add(aVar);
            }
        }
    }

    public void update() {
        x59 x59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.b != null && this.a != null && this.c != null && (x59Var = this.e) != null && this.f != null) {
            x59Var.c();
            this.f.b(0, this.b.b());
            this.f.a(p59.b().a());
            this.b.notifyDataSetChanged();
        }
    }

    public void update(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && this.a != null && this.b != null) {
            this.c.clear();
            this.c.addAll(list);
            b();
            this.b.d();
            this.e.update(Integer.valueOf(this.b.b()));
            this.f.b(0, this.b.b());
            this.f.a(p59.b().a());
            this.b.notifyDataSetChanged();
        }
    }
}
