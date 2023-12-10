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
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
/* loaded from: classes8.dex */
public class rz6 extends lo5<mx6, ox6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext f;
    public final LinearLayout g;
    public RecyclerView h;
    public EMTextView i;
    public ImageView j;
    public ClassFitionForumItemAdapter k;
    public List<lx6> l;
    public boolean m;

    /* loaded from: classes8.dex */
    public interface b {
        void a(List<lx6> list, int i);
    }

    /* loaded from: classes8.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz6 a;

        public a(rz6 rz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rz6Var;
        }

        @Override // com.baidu.tieba.rz6.b
        public void a(List<lx6> list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i == list.size() - 1) {
                    rz6 rz6Var = this.a;
                    rz6Var.m = !rz6Var.m;
                    this.a.k.p(this.a.q());
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(this.a.f.getString(R.string.obfuscated_res_0x7f0f07f2), list.get(i).b());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921678, hashMap));
                TiebaStatic.log(new StatisticItem("c14583").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", i + 1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rz6(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, wz6 wz6Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, wz6Var, enterForumModel};
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
        this.i = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f092685);
        this.j = (ImageView) view2.findViewById(R.id.arrow_img);
        this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090572);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.recycler_view);
        this.h = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.h.setLayoutManager(new GridLayoutManager(b(), 5));
        ClassFitionForumItemAdapter classFitionForumItemAdapter = new ClassFitionForumItemAdapter(tbPageContext, null);
        this.k = classFitionForumItemAdapter;
        this.h.setAdapter(classFitionForumItemAdapter);
        this.k.o(new a(this));
    }

    @Override // com.baidu.tieba.mva
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i)) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            EMManager.from(this.g).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.i).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final List<lx6> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.l);
            if (this.m) {
                if (this.l.size() >= 14) {
                    List<lx6> subList = arrayList.subList(0, 14);
                    subList.add(new lx6(this.f.getString(R.string.obfuscated_res_0x7f0f0770), R.drawable.obfuscated_res_0x7f0809e1));
                    return subList;
                }
                return arrayList;
            } else if (this.l.size() >= 9) {
                List<lx6> subList2 = arrayList.subList(0, 9);
                subList2.add(new lx6(this.f.getString(R.string.obfuscated_res_0x7f0f0cdf), R.drawable.obfuscated_res_0x7f080a3a));
                return subList2;
            } else {
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oo5
    /* renamed from: r */
    public void h(mx6 mx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mx6Var) == null) {
            super.h(mx6Var);
            this.l = mx6Var.f();
            this.k.p(q());
            this.i.setText(mx6Var.getTitle());
            onChangeSkinType(c(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
