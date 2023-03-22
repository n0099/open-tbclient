package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.adapter.ClassFitionForumItemAdapter;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class so6 extends oj5<lm6, nm6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext f;
    public final LinearLayout g;
    public RecyclerView h;
    public EMTextView i;
    public ImageView j;
    public ClassFitionForumItemAdapter k;
    public List<km6> l;
    public boolean m;

    /* loaded from: classes6.dex */
    public interface b {
        void a(List<km6> list, int i);
    }

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ so6 a;

        public a(so6 so6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {so6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = so6Var;
        }

        @Override // com.baidu.tieba.so6.b
        public void a(List<km6> list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i == list.size() - 1) {
                    so6 so6Var = this.a;
                    so6Var.m = !so6Var.m;
                    this.a.k.update(this.a.o());
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(this.a.f.getString(R.string.obfuscated_res_0x7f0f071f), list.get(i).b());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921678, hashMap));
                TiebaStatic.log(new StatisticItem("c14583").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", i + 1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public so6(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, xo6 xo6Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, xo6Var, enterForumModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.f = tbPageContext;
        this.i = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0923fe);
        this.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902cb);
        this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090506);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.recycler_view);
        this.h = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.h.setLayoutManager(new GridLayoutManager(getContext(), 5));
        ClassFitionForumItemAdapter classFitionForumItemAdapter = new ClassFitionForumItemAdapter(tbPageContext, null);
        this.k = classFitionForumItemAdapter;
        this.h.setAdapter(classFitionForumItemAdapter);
        this.k.f(new a(this));
    }

    public final List<km6> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.l);
            if (this.m) {
                if (this.l.size() >= 14) {
                    List<km6> subList = arrayList.subList(0, 14);
                    subList.add(new km6(this.f.getString(R.string.obfuscated_res_0x7f0f069e), R.drawable.obfuscated_res_0x7f08083f));
                    return subList;
                }
                return arrayList;
            } else if (this.l.size() >= 9) {
                List<km6> subList2 = arrayList.subList(0, 9);
                subList2.add(new km6(this.f.getString(R.string.obfuscated_res_0x7f0f0bb0), R.drawable.obfuscated_res_0x7f080895));
                return subList2;
            } else {
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ya9
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            n15 d = n15.d(this.g);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            n15 d2 = n15.d(this.i);
            d2.B(R.string.F_X02);
            d2.A(R.dimen.T_X07);
            d2.w(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            return false;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rj5
    /* renamed from: p */
    public void f(lm6 lm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lm6Var) == null) {
            super.f(lm6Var);
            this.l = lm6Var.h();
            this.k.update(o());
            this.i.setText(lm6Var.getTitle());
            onChangeSkinType(b(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
