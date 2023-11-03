package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v7a extends yk6<s6a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ClickableHeaderImageView m;
    public ClickableHeaderImageView n;
    public ClickableHeaderImageView o;
    public TextView p;
    public View q;
    public int r;
    public TbPageContext<?> s;
    public View.OnClickListener t;
    public boolean u;

    @Override // com.baidu.tieba.yk6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d07fa : invokeV.intValue;
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
        public final /* synthetic */ v7a a;

        public a(v7a v7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v7aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            if (!this.a.u) {
                TiebaStatic.log(new StatisticItem("c11595"));
            }
            if (view2.getTag() instanceof UserData) {
                UserData userData = (UserData) view2.getTag();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.s.getPageActivity(), userData.getUserId(), userData.getUserName(), null, AddFriendActivityConfig.TYPE_FOCUS)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v7a(TbPageContext<?> tbPageContext) {
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
        this.r = 3;
        this.s = tbPageContext;
        View i3 = i();
        x();
        this.q = i3.findViewById(R.id.bottom_divider);
        this.j = (TextView) i3.findViewById(R.id.month_num);
        this.i = (TextView) i3.findViewById(R.id.day_num);
        this.k = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09108d);
        this.l = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090308);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) i3.findViewById(R.id.obfuscated_res_0x7f090f5e);
        this.m = clickableHeaderImageView;
        clickableHeaderImageView.setRadius(BdUtilHelper.getDimens(this.s.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a));
        this.m.setAutoChangeStyle(true);
        this.m.setOnClickListener(this.t);
        ClickableHeaderImageView clickableHeaderImageView2 = (ClickableHeaderImageView) i3.findViewById(R.id.obfuscated_res_0x7f090f5f);
        this.n = clickableHeaderImageView2;
        clickableHeaderImageView2.setRadius(BdUtilHelper.getDimens(this.s.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a));
        this.n.setAutoChangeStyle(true);
        this.n.setOnClickListener(this.t);
        ClickableHeaderImageView clickableHeaderImageView3 = (ClickableHeaderImageView) i3.findViewById(R.id.obfuscated_res_0x7f090f60);
        this.o = clickableHeaderImageView3;
        clickableHeaderImageView3.setRadius(BdUtilHelper.getDimens(this.s.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a));
        this.o.setAutoChangeStyle(true);
        this.o.setOnClickListener(this.t);
        this.p = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090abb);
    }

    @Override // com.baidu.tieba.yk6
    public void l(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.r != i) {
                SkinManager.setBackgroundResource(i(), R.drawable.home_thread_card_item_bg);
                SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0106);
                SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0108);
            }
            this.r = i;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t = new a(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yk6
    /* renamed from: y */
    public void k(s6a s6aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, s6aVar) == null) {
            if (s6aVar == null) {
                if (i() != null) {
                    i().setVisibility(8);
                    return;
                }
                return;
            }
            if (i() != null) {
                i().setVisibility(0);
            }
            this.u = s6aVar.a;
            this.i.setText(s6aVar.d);
            this.j.setText(s6aVar.c);
            TextView textView = this.i;
            int i2 = 4;
            if (s6aVar.b) {
                i = 0;
            } else {
                i = 4;
            }
            textView.setVisibility(i);
            TextView textView2 = this.j;
            if (s6aVar.b) {
                i2 = 0;
            }
            textView2.setVisibility(i2);
            if (s6aVar.a) {
                this.k.setText(this.s.getString(R.string.obfuscated_res_0x7f0f0c94));
            } else {
                this.k.setText(StringHelper.getUserDescByGender(s6aVar.e));
            }
            int count = ListUtils.getCount(s6aVar.f);
            if (count > 3) {
                this.p.setVisibility(0);
                this.p.setText(String.format(this.s.getString(R.string.obfuscated_res_0x7f0f02f4), Integer.valueOf(count)));
            } else {
                this.p.setVisibility(8);
            }
            if (count >= 3) {
                this.o.setVisibility(0);
                this.o.setTag(s6aVar.f.get(2));
                if (s6aVar.f.get(2).getGodUserData() != null && s6aVar.f.get(2).getGodUserData().getType() == 2) {
                    this.o.setIsGod(true);
                } else {
                    this.o.setIsGod(false);
                }
                this.o.startLoad(s6aVar.f.get(2).getPortrait(), 12, false);
            } else {
                this.o.setVisibility(8);
            }
            if (count >= 2) {
                this.n.setVisibility(0);
                this.n.setTag(s6aVar.f.get(1));
                if (s6aVar.f.get(1).getGodUserData() != null && s6aVar.f.get(1).getGodUserData().getType() == 2) {
                    this.n.setIsGod(true);
                } else {
                    this.n.setIsGod(false);
                }
                this.n.startLoad(s6aVar.f.get(1).getPortrait(), 12, false);
            } else {
                this.n.setVisibility(8);
            }
            if (count >= 1) {
                this.m.setVisibility(0);
                this.m.setTag(s6aVar.f.get(0));
                if (s6aVar.f.get(0).getGodUserData() != null && s6aVar.f.get(0).getGodUserData().getType() == 2) {
                    this.m.setIsGod(true);
                } else {
                    this.m.setIsGod(false);
                }
                this.m.startLoad(s6aVar.f.get(0).getPortrait(), 12, false);
            } else {
                this.m.setVisibility(8);
            }
            l(this.s, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
