package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.frs.FrsSchoolRecommendItemView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class jw7 extends mn6<mh7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView t;
    public ea8 u;
    public FrsSchoolRecommendItemView v;
    public List<fa8> w;
    public View.OnClickListener x;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jw7 a;

        public a(jw7 jw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e() != null) {
                this.a.e().a(view2, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jw7(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = new a(this);
        HListView hListView = new HListView(getContext());
        this.t = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.t.setFooterDividersEnabled(false);
        this.t.setSelector(R.drawable.list_selector_transparent);
        this.v = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d039c, (ViewGroup) null), tbPageContext, bdUniqueId);
        ea8 ea8Var = new ea8(getContext(), R.layout.obfuscated_res_0x7f0d039c, this.v);
        this.u = ea8Var;
        ea8Var.d(this.x);
        this.t.setAdapter((ListAdapter) this.u);
        this.q.addView(this.t);
        this.p.setVisibility(8);
        this.j.setTextSize(0, BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f9));
    }

    @Override // com.baidu.tieba.mn6, com.baidu.tieba.ln6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            super.j(tbPageContext, i);
            if (this.t != null && this.u != null) {
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
                this.u.b(i);
            }
        }
    }

    public final boolean u(List<fa8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (ListUtils.isEmpty(this.w) || ListUtils.getCount(this.w) != ListUtils.getCount(list)) {
                return true;
            }
            for (int i = 0; i < ListUtils.getCount(this.w); i++) {
                fa8 fa8Var = (fa8) ListUtils.getItem(this.w, i);
                fa8 fa8Var2 = (fa8) ListUtils.getItem(list, i);
                if ((fa8Var instanceof si7) && (fa8Var2 instanceof si7) && !((si7) fa8Var).a.getUserId().equals(((si7) fa8Var2).a.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mn6
    /* renamed from: x */
    public void t(mh7 mh7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mh7Var) == null) {
            super.i(mh7Var);
            if (mh7Var != null && !ListUtils.isEmpty(mh7Var.getDataList())) {
                if (StringUtils.isNull(mh7Var.mGroupTitle)) {
                    this.j.setText(getContext().getResources().getString(R.string.school_recommend));
                } else {
                    this.j.setText(mh7Var.mGroupTitle);
                }
                if (u(mh7Var.getDataList())) {
                    List<fa8> dataList = mh7Var.getDataList();
                    this.w = dataList;
                    this.u.c(dataList);
                    this.u.notifyDataSetChanged();
                }
            }
        }
    }
}
