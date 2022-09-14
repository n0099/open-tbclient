package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.data.ActivityPrizeData;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y58 extends v06<g58> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public View j;
    public ImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public g58 s;
    public i58 t;
    public UserData u;
    public LinearLayout v;
    public LinearLayout w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y58(TbPageContext<?> tbPageContext) {
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
        this.i = 3;
        View h = h();
        this.v = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f0918e3);
        this.j = h.findViewById(R.id.obfuscated_res_0x7f090f96);
        this.k = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090c57);
        this.o = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090c5a);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090c5b);
        this.m = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f090c59);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090c55);
        this.p = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091c40);
        this.q = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090c5c);
        this.r = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090581);
        this.w = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f090582);
        this.p.setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.v06
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06f9 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.v06
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.i == i) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        TBSelector.setViewBackgroundColorWithPressedState(this.j, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setImageResource(this.m, R.drawable.person_center_red_tip_shape);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
        uu4 d = uu4.d(this.w);
        d.n(R.string.J_X06);
        d.f(R.color.CAM_X0205);
        uu4 d2 = uu4.d(this.v);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
        if (this.s.e.equals("更多")) {
            uu4 d3 = uu4.d(this.j);
            d3.m(2);
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0205);
        }
        this.i = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        v16<T> v16Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || view2 == null) {
            return;
        }
        if (view2 == this.j) {
            g58 g58Var = this.s;
            if (g58Var.a == 36 && "游戏".equals(g58Var.e) && (v16Var = this.e) != 0) {
                v16Var.a(view2, this.s);
                return;
            } else {
                r();
                return;
            }
        }
        s(view2);
    }

    public final void r() {
        g58 g58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (g58Var = this.s) == null) {
            return;
        }
        switch (g58Var.a) {
            case 10:
                PersonRedTipManager.getInstance().updateRedTipState(1, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 13));
                if (this.u == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getUserName(), this.u.getName_show(), this.u.getSex(), "iowner_gift")));
                return;
            case 11:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 16));
                if (StringUtils.isNull(this.s.g)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g});
                return;
            case 12:
                PersonRedTipManager.getInstance().updateRedTipState(7, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 12));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(this.b.getPageActivity())));
                return;
            case 13:
            case 14:
            case 15:
            case 19:
            case 20:
            case 21:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
            case 32:
            case 34:
            case 35:
            case 40:
            case 42:
            default:
                return;
            case 16:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 9));
                PersonRedTipManager.getInstance().updateRedTipState(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.b.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.b.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 15));
                UrlManager.getInstance().dealOneLink(this.b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 11));
                if (this.u == null) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.b.getPageActivity(), this.u.getSex(), 0, 1)));
                return;
            case 25:
                if (this.u == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 18));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getUserName(), this.u.getPortrait(), this.u.getSex(), true)));
                return;
            case 30:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 17));
                if (ug5.b(this.b)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(g().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all")));
                return;
            case 31:
                PersonRedTipManager.getInstance().updateRedTipState(10, false, true);
                bx4.k().u("key_feedback_tip_show", false);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 19));
                if (getContext() != null) {
                    getContext().startActivity(mt8.a());
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SERVICE_CENTER_CLICK);
                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                return;
            case 33:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.b.getPageActivity(), this.s.j)));
                return;
            case 36:
                TiebaStatic.log(new StatisticItem("c12524").param("obj_locate", this.s.k));
                t(this.s.g);
                return;
            case 37:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 24));
                bx4.k().u("key_has_borrow_cash_clicked", true);
                i58 i58Var = this.s.i;
                if (i58Var != null) {
                    i58Var.a = false;
                }
                this.m.setVisibility(8);
                String q = bx4.k().q("cash_pay", "");
                if (StringUtils.isNull(q)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2001447, q));
                return;
            case 38:
                ActivityPrizeData activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.isPersonItemSwitch()) {
                    String h5Url = activityPrizeData.getH5Url();
                    if (StringUtils.isNull(h5Url)) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c12598"));
                    PersonRedTipManager.getInstance().updateRedTipState(9, false, true);
                    UrlManager.getInstance().dealOneLink(g(), new String[]{h5Url}, true);
                    return;
                }
                return;
            case 39:
                lo4.z(true, this.b.getPageActivity(), this.b.getResources().getString(R.string.obfuscated_res_0x7f0f02da), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 25));
                bx4.k().u("key_baidu_financial_has_clicked", true);
                i58 i58Var2 = this.s.i;
                if (i58Var2 != null) {
                    i58Var2.a = false;
                }
                this.m.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                return;
            case 43:
                u();
                lo4.o(this.b.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                return;
            case 44:
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 26));
                if (!TextUtils.isEmpty(this.s.g)) {
                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g});
                }
                if (!dj.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) && !"f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", getContext().getString(R.string.obfuscated_res_0x7f0f13df)).param("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).param("obj_source", "smallgame_center").param("obj_param1", 0));
                    return;
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", getContext().getString(R.string.obfuscated_res_0x7f0f02d8)).param("obj_id", "11811875").param("obj_source", "smallgame_center").param("obj_param1", 0));
                    return;
                }
            case 45:
                if (!TextUtils.isEmpty(g58Var.g)) {
                    lo4.o(this.c, this.s.g);
                }
                StatisticItem.make("c13548").eventStat();
                return;
            case 46:
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g}, true);
                return;
            case 47:
                if (TextUtils.isEmpty(g58Var.g)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.g});
                return;
            case 48:
                if (TextUtils.isEmpty(g58Var.g)) {
                    return;
                }
                lo4.o(this.c, this.s.g);
                return;
            case 49:
                if (TextUtils.isEmpty(g58Var.g)) {
                    return;
                }
                lo4.c = true;
                lo4.o(this.c, this.s.g);
                return;
        }
    }

    public final void s(View view2) {
        g58 g58Var;
        i58 i58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && (g58Var = this.s) != null && view2 == this.p) {
            int i = g58Var.a;
            if (i == 10) {
                CurrencyJumpHelper.personGotoBuyBean(this.b.getPageActivity());
            } else if (i != 45 || (i58Var = this.t) == null || TextUtils.isEmpty(i58Var.d)) {
            } else {
                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.t.d});
            }
        }
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            w(str);
        } else if (str.startsWith("nohead:url")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.replaceFirst("nohead:url=", ""));
            sb.append(str.contains("?") ? "&" : "?");
            sb.append("jump=open_full_screen_web_page&nonavigationbar=1");
            UrlManager.getInstance().dealOneLink(this.b, new String[]{sb.toString()});
        } else {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str});
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 5);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v06
    /* renamed from: v */
    public void i(g58 g58Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g58Var) == null) || g58Var == null) {
            return;
        }
        this.s = g58Var;
        this.u = g58Var.h;
        this.t = g58Var.i;
        this.l.setText(g58Var.e);
        if (this.s.e.equals("服务中心")) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(8);
        }
        x();
        y(this.t);
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                ej.M(this.b.getPageActivity(), R.string.obfuscated_res_0x7f0f0465);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str.substring(6)});
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
        } else {
            lo4.x(this.b.getPageActivity(), true, str);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.s.b > 0) {
                this.k.setVisibility(0);
                g58 g58Var = this.s;
                if (g58Var.c) {
                    if (g58Var.d) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, this.s.b, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    } else {
                        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, this.s.b, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    }
                }
                SkinManager.setImageResource(this.k, g58Var.b);
                return;
            }
            this.k.setVisibility(8);
        }
    }

    public final void y(i58 i58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, i58Var) == null) {
            if (i58Var != null) {
                if (i58Var.a) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
                if (!StringUtils.isNull(i58Var.b)) {
                    this.n.setVisibility(0);
                    this.n.setText(i58Var.b);
                } else {
                    this.n.setVisibility(8);
                }
                if (i58Var.h) {
                    this.q.setVisibility(0);
                } else {
                    this.q.setVisibility(8);
                }
                if (!TextUtils.isEmpty(i58Var.c)) {
                    this.p.setVisibility(0);
                    this.p.setText(i58Var.c);
                    TextView textView = this.p;
                    Drawable drawable = i58Var.e;
                    Drawable drawable2 = i58Var.f;
                    Drawable drawable3 = i58Var.g;
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable3);
                    return;
                }
                this.p.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        }
    }
}
