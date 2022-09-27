package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k59 implements m59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    @NonNull
    public final u49 b;

    public k59(@NonNull TbPageContext<?> tbPageContext, @NonNull u49 u49Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, u49Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = u49Var;
    }

    @Override // com.baidu.tieba.i55
    public void B(h55 h55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h55Var) == null) {
            int i = h55Var.a;
            if (i == 14 || i == 48) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 1));
                this.b.r();
            } else if (i == 60) {
                this.b.u();
            } else if (i == 12 || i == 13 || i == 46 || i == 49) {
                this.b.x(new int[]{10, 34});
                this.b.h();
            } else if (i == 21) {
                this.b.g();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 5));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(this.a.getPageActivity(), 25049, "", true, null)));
            } else if (i == 24) {
                this.b.z(h55Var);
            } else if (i == 3) {
                this.b.z(h55Var);
            } else if (i == 16) {
                this.b.z(h55Var);
            } else if (i == 43) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 4));
                ox4.k().u("hot_topic_has_click", true);
                this.b.D(new h55(2, 26, null));
                this.b.p(true);
                this.b.m();
            } else if (i == 10) {
                this.b.z(h55Var);
            } else if (i == 11) {
                this.b.z(h55Var);
            } else if (i == 25) {
                this.b.z(h55Var);
            } else if (i == 22) {
                this.b.z(h55Var);
            } else if (i == 59) {
                this.b.z(h55Var);
            } else if (i == 61) {
                this.b.z(h55Var);
            } else if (i == 69) {
                this.b.v();
            } else if (i == 55) {
                Object obj = h55Var.c;
                if (obj instanceof Boolean) {
                    this.b.j(((Boolean) obj).booleanValue());
                }
            } else if (i == 66) {
                Object obj2 = h55Var.c;
                if (obj2 instanceof Boolean) {
                    this.b.y(((Boolean) obj2).booleanValue());
                }
            }
        }
    }
}
