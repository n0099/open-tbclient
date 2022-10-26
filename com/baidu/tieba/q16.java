package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class q16 extends p16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public ImageView p;
    public LinearLayout q;
    public View r;
    public View s;

    @Override // com.baidu.tieba.p16
    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0192 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q16(TbPageContext tbPageContext) {
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
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.q = null;
        s(k());
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                r();
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && this.l == view2 && view2 != null && (view2.getTag() instanceof String)) {
            String str = (String) view2.getTag();
            if (!StringUtils.isNull(str)) {
                UrlManager.getInstance().dealOneLink(g(), new String[]{str});
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (c() != null && c().equals(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_HOME)) {
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1);
                this.p.setVisibility(8);
            } else {
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
                SkinManager.setImageResource(this.p, R.drawable.icon_arrow_tab);
            }
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1);
            SkinManager.setBackgroundColor(k(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090fa7);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f9b);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090fc2);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f86);
            this.m = view2.findViewById(R.id.obfuscated_res_0x7f090820);
            this.n = view2.findViewById(R.id.obfuscated_res_0x7f09081d);
            this.o = view2.findViewById(R.id.obfuscated_res_0x7f09081a);
            this.q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090504);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f09080e);
            this.s = view2.findViewById(R.id.obfuscated_res_0x7f09080f);
            this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fc1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: t */
    public void l(v26 v26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, v26Var) == null) {
            if (v26Var == null) {
                k().setVisibility(8);
                return;
            }
            this.j.setText(v26Var.mGroupTitle);
            int i = v26Var.mRightIconResId;
            if (i > 0) {
                this.k.setBackgroundResource(i);
            }
            if (v26Var.showTopDivider) {
                this.s.setVisibility(0);
            } else {
                this.s.setVisibility(8);
            }
            if (v26Var.showBottomDivider) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
            if (!StringUtils.isNull(v26Var.mBottomText)) {
                this.l.setVisibility(0);
                this.o.setVisibility(0);
                this.n.setVisibility(0);
                this.l.setText(v26Var.mBottomText);
                String str = v26Var.mBottomLink;
                if (!StringUtils.isNull(str)) {
                    this.l.setTag(str);
                    this.l.setOnClickListener(this);
                    return;
                }
                return;
            }
            this.l.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
        }
    }
}
