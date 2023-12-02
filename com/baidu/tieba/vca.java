package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.writeModel.AttentionBarData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vca extends nl6<rba> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public BarImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public rba r;
    public LikeModel s;
    public boolean t;
    public CustomMessageListener u;
    public CustomMessageListener v;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d01e6 : invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vca a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vca vcaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vcaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !this.a.t) {
                Object data = customResponsedMessage.getData();
                if (data instanceof AttentionBarData) {
                    AttentionBarData attentionBarData = (AttentionBarData) data;
                    if (attentionBarData.forumId == this.a.r.f) {
                        if (attentionBarData.isSuccess) {
                            this.a.r.i = true;
                            this.a.q.setVisibility(0);
                            this.a.C(true);
                        } else if (StringUtils.isNull(attentionBarData.errorMessage)) {
                            BdUtilHelper.showToast(this.a.c, (int) R.string.attention_fail);
                        } else {
                            BdUtilHelper.showToast(this.a.c, attentionBarData.errorMessage);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vca a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vca vcaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vcaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vcaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !this.a.t) {
                Object data = customResponsedMessage.getData();
                if (data instanceof AttentionBarData) {
                    AttentionBarData attentionBarData = (AttentionBarData) data;
                    if (attentionBarData.forumId == this.a.r.f) {
                        if (attentionBarData.isSuccess) {
                            this.a.r.i = false;
                            this.a.q.setVisibility(0);
                            vca vcaVar = this.a;
                            vcaVar.C(vcaVar.r.i);
                            BdUtilHelper.showToast(this.a.c, (int) R.string.unlike_success);
                            return;
                        }
                        BdUtilHelper.showToast(this.a.c, (int) R.string.unlike_failure);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vca(TbPageContext tbPageContext) {
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
        this.u = new a(this, 2001437);
        this.v = new b(this, 2001438);
        z(i());
    }

    public final void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.q.setText(this.c.getString(R.string.relate_forum_is_followed));
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0110);
                SkinManager.setBackgroundResource(this.q, R.color.transparent);
                this.q.setClickable(false);
                return;
            }
            this.q.setText(this.c.getString(R.string.focus_text));
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundResource(this.q, R.drawable.obfuscated_res_0x7f0812b6);
            this.q.setClickable(true);
        }
    }

    public void B(LikeModel likeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, likeModel) == null) {
            this.s = likeModel;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: A */
    public void j(rba rbaVar) {
        int i;
        Context context;
        int i2;
        String string;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rbaVar) == null) {
            if (rbaVar == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            this.r = rbaVar;
            this.t = rbaVar.a;
            TextView textView = this.j;
            int i3 = 4;
            if (rbaVar.c) {
                i = 0;
            } else {
                i = 4;
            }
            textView.setVisibility(i);
            TextView textView2 = this.k;
            if (rbaVar.c) {
                i3 = 0;
            }
            textView2.setVisibility(i3);
            this.j.setText(rbaVar.e);
            this.k.setText(rbaVar.d);
            TextView textView3 = this.l;
            if (rbaVar.a) {
                string = this.c.getString(R.string.obfuscated_res_0x7f0f0ca2);
            } else {
                if (rbaVar.b == 2) {
                    context = this.c;
                    i2 = R.string.obfuscated_res_0x7f0f1427;
                } else {
                    context = this.c;
                    i2 = R.string.obfuscated_res_0x7f0f09de;
                }
                string = context.getString(i2);
            }
            textView3.setText(string);
            this.n.startLoad(rbaVar.g, 10, false);
            String str = rbaVar.h;
            if (uu5.c(str) > 10) {
                str = uu5.k(str, 0, 10) + "...";
            }
            this.o.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f10d9), str));
            String numFormatOverWanNa = StringHelper.numFormatOverWanNa(rbaVar.j);
            String numFormatOverWanNa2 = StringHelper.numFormatOverWanNa(rbaVar.k);
            TextView textView4 = this.p;
            if (rbaVar.a) {
                format = String.format(this.c.getString(R.string.obfuscated_res_0x7f0f10d8), numFormatOverWanNa, numFormatOverWanNa2);
            } else {
                format = String.format(this.c.getString(R.string.obfuscated_res_0x7f0f10d7), numFormatOverWanNa);
            }
            textView4.setText(format);
            if (!rbaVar.i && !rbaVar.a) {
                this.q.setVisibility(0);
                C(rbaVar.i);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.drawable.item_person_header_attention_bg_selector);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0108, 1);
                rba rbaVar = this.r;
                if (rbaVar != null) {
                    C(rbaVar.i);
                }
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (this.i == view2) {
                if (!this.t) {
                    TiebaStatic.log(new StatisticItem("c11595"));
                }
                this.b.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c).createNormalCfg(this.r.h, "")));
            } else if (this.q == view2) {
                TiebaStatic.log(new StatisticItem("c11596"));
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    ViewHelper.skipToLoginActivity(this.c);
                } else if (rd.isForumName(this.r.h)) {
                    rba rbaVar = this.r;
                    if (!rbaVar.i) {
                        this.s.g0(rbaVar.h, String.valueOf(rbaVar.f));
                    }
                }
            }
        }
    }

    public final void z(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f09066f);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09066b);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09066d);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090673);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09066c);
            this.n = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090671);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09066e);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090672);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090670);
            this.i.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.b.registerListener(this.u);
            this.b.registerListener(this.v);
        }
    }
}
