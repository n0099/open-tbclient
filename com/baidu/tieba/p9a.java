package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.personCenter.view.PersonCreatorCenterDataView;
import com.baidu.tieba.personCenter.view.PersonCreatorCenterFunView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CreationData;
/* loaded from: classes7.dex */
public class p9a extends nl6<w8a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public boolean j;
    public a k;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0812 : invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public View c;
        public TextView d;
        public ImageView e;
        public PersonCreatorCenterFunView f;
        public PersonCreatorCenterFunView g;
        public PersonCreatorCenterFunView h;
        public PersonCreatorCenterDataView i;
        public PersonCreatorCenterDataView j;
        public PersonCreatorCenterDataView k;

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

        @NonNull
        public static a a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                a aVar = new a();
                aVar.a = view2;
                aVar.b = view2.findViewById(R.id.card_container);
                aVar.c = view2.findViewById(R.id.obfuscated_res_0x7f09268e);
                aVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092685);
                aVar.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09200c);
                aVar.f = (PersonCreatorCenterFunView) view2.findViewById(R.id.obfuscated_res_0x7f090e37);
                aVar.g = (PersonCreatorCenterFunView) view2.findViewById(R.id.obfuscated_res_0x7f090e34);
                aVar.h = (PersonCreatorCenterFunView) view2.findViewById(R.id.obfuscated_res_0x7f090e35);
                aVar.i = (PersonCreatorCenterDataView) view2.findViewById(R.id.obfuscated_res_0x7f092a46);
                aVar.j = (PersonCreatorCenterDataView) view2.findViewById(R.id.obfuscated_res_0x7f090178);
                aVar.k = (PersonCreatorCenterDataView) view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p9a(TbPageContext<?> tbPageContext) {
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
        this.i = tbPageContext;
        this.k = a.a(i());
        int dimens = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X003);
        this.k.a.setPadding(dimens, 0, dimens, 0);
        this.k.f.a(R.drawable.obfuscated_res_0x7f080a49, tbPageContext.getString(R.string.obfuscated_res_0x7f0f051f));
        this.k.g.a(R.drawable.obfuscated_res_0x7f080a45, tbPageContext.getString(R.string.tieba_string_data_center));
        this.k.h.a(R.drawable.obfuscated_res_0x7f080a1e, tbPageContext.getString(R.string.tieba_string_god_guide));
        k(tbPageContext, this.a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f09268e) {
            this.k.f.c();
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.j = z;
            p();
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.k.a, R.color.CAM_X0204);
            EMManager.from(this.k.b).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.k.d, (int) R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k.e, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.k.f.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k.g.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k.h.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k.i.a, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k.j.a, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k.k.a, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k.i.b, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k.j.b, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k.k.b, (int) R.color.CAM_X0109);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.j) {
            new StatisticItem("c15051").param("uid", TbadkCoreApplication.getCurrentAccountId()).eventStat();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: r */
    public void j(w8a w8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, w8aVar) == null) {
            if (w8aVar == null) {
                o(8);
                return;
            }
            this.k.c.setOnClickListener(this);
            NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
            if (newGodData != null && !StringUtils.isNull(newGodData.getFieldName()) && newGodData.getStatus() == 3) {
                this.k.h.a(R.drawable.obfuscated_res_0x7f080a1e, this.i.getString(R.string.tieba_string_god_examine));
            } else {
                this.k.h.a(R.drawable.obfuscated_res_0x7f080a1e, this.i.getString(R.string.tieba_string_god_guide));
            }
            CreationData c = w8aVar.c();
            this.k.i.a(c.view_count.intValue(), this.i.getString(R.string.obfuscated_res_0x7f0f192a));
            this.k.j.a(c.agree_count.intValue(), this.i.getString(R.string.obfuscated_res_0x7f0f192c));
            this.k.k.a(c.comment_count.intValue(), this.i.getString(R.string.obfuscated_res_0x7f0f192b));
            k(this.i, this.a);
        }
    }
}
