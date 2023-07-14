package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class wt9 extends wo6<vs9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long i;
    public View j;
    public TextView k;
    public HTypeListView l;
    public nr9 m;
    public View.OnClickListener n;

    @Override // com.baidu.tieba.wo6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01cf : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wt9 a;

        public a(wt9 wt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wt9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.s();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wt9(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.n = new a(this);
        this.h = 4;
        View h = h();
        this.j = h;
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090609);
        HTypeListView hTypeListView = (HTypeListView) this.j.findViewById(R.id.obfuscated_res_0x7f09060a);
        this.l = hTypeListView;
        this.m = new nr9(this.b, hTypeListView);
    }

    public final List<yn> u(List<yn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<yn> arrayList = new ArrayList<>(list);
            int g = yi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f0703e8);
            int g2 = yi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
            if (count > 3) {
                arrayList = arrayList.subList(0, 3);
                qs9 qs9Var = new qs9();
                qs9Var.a = yi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070364);
                qs9Var.b = yi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f0703d4);
                ListUtils.add(arrayList, qs9Var);
            }
            zn9 zn9Var = new zn9(g2, g);
            ListUtils.add(arrayList, 0, zn9Var);
            ListUtils.add(arrayList, zn9Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wo6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) != null) || i == this.a) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.c).createNormalCfg(this.i, "personal")));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wo6
    /* renamed from: t */
    public void i(vs9 vs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vs9Var) == null) {
            if (vs9Var != null && !ListUtils.isEmpty(vs9Var.b)) {
                this.i = vs9Var.a;
                this.k.setText(R.string.video_title_str);
                this.l.setData(u(vs9Var.b));
                this.m.b(this.n);
                return;
            }
            this.j.setVisibility(8);
        }
    }
}
