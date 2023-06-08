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
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
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
import com.baidu.tbadk.util.DataExt;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.personCenter.data.PersonRedTipData;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.setting.SecretSettingActivityConfig;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes7.dex */
public class ne9 extends in6<ud9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public View j;
    public TbImageView k;
    public TextView l;
    public ImageView m;
    public TextView n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public ud9 s;
    public wd9 t;
    public UserData u;
    public LinearLayout v;
    public LinearLayout w;
    public LinearLayout x;
    public View y;

    @Override // com.baidu.tieba.in6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0791 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ne9(TbPageContext<?> tbPageContext) {
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
        this.y = h();
        int g = vi.g(this.c, R.dimen.M_W_X003);
        this.y.setPadding(g, 0, g, 0);
        this.v = (LinearLayout) this.y.findViewById(R.id.obfuscated_res_0x7f091aef);
        this.w = (LinearLayout) this.y.findViewById(R.id.obfuscated_res_0x7f091af0);
        this.j = this.y.findViewById(R.id.obfuscated_res_0x7f09115f);
        this.k = (TbImageView) this.y.findViewById(R.id.obfuscated_res_0x7f090da3);
        this.o = (ImageView) this.y.findViewById(R.id.obfuscated_res_0x7f090da6);
        this.l = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f090da7);
        this.m = (ImageView) this.y.findViewById(R.id.obfuscated_res_0x7f090da5);
        this.n = (TextView) this.y.findViewById(R.id.function_desc);
        this.p = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f091e77);
        this.q = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f090da8);
        this.r = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f090617);
        this.x = (LinearLayout) this.y.findViewById(R.id.obfuscated_res_0x7f090618);
        this.p.setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ud9 ud9Var = this.s;
            if (ud9Var.b > 0) {
                this.k.setVisibility(0);
                ud9 ud9Var2 = this.s;
                if (ud9Var2.c) {
                    if (ud9Var2.d) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, this.s.b, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    } else {
                        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, this.s.b, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    }
                }
                SkinManager.setImageResource(this.k, ud9Var2.b);
            } else if (ud9Var.m && !TextUtils.isEmpty(ud9Var.k)) {
                this.k.setVisibility(0);
                this.k.N(this.s.k, 10, false);
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public final void B(wd9 wd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wd9Var) == null) {
            if (wd9Var != null) {
                if (wd9Var.a()) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
                if (!StringUtils.isNull(wd9Var.b)) {
                    this.n.setVisibility(0);
                    this.n.setText(wd9Var.b);
                } else {
                    this.n.setVisibility(8);
                }
                boolean z = !TextUtils.isEmpty(wd9Var.i);
                if (!wd9Var.h && !z) {
                    this.q.setVisibility(8);
                } else {
                    this.q.setVisibility(0);
                    this.n.setVisibility(8);
                    if (z) {
                        this.q.setText(wd9Var.i);
                    }
                }
                if (!TextUtils.isEmpty(wd9Var.c)) {
                    this.p.setVisibility(0);
                    this.p.setText(wd9Var.c);
                    TextView textView = this.p;
                    Drawable drawable = wd9Var.e;
                    Drawable drawable2 = wd9Var.f;
                    Drawable drawable3 = wd9Var.g;
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

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HashMap hashMap = new HashMap();
            String s = n95.m().s(n95.q("key_my_tab_item_red_tip_data"), "");
            if (!StringUtils.isNull(s)) {
                new HashMap();
                for (Map.Entry<String, Object> entry : DataExt.toMap(s).entrySet()) {
                    if (entry.getValue() instanceof Map) {
                        PersonRedTipData personRedTipData = new PersonRedTipData();
                        if (((Map) entry.getValue()).get("hadShow") instanceof Boolean) {
                            personRedTipData.setShow(((Boolean) ((Map) entry.getValue()).get("hadShow")).booleanValue());
                        }
                        if (((Map) entry.getValue()).get("redPointVersion") instanceof Long) {
                            personRedTipData.setRedPointVersion(((Long) ((Map) entry.getValue()).get("redPointVersion")).longValue());
                        }
                        hashMap.put(entry.getKey(), personRedTipData);
                    }
                }
                if (hashMap.get(String.valueOf(this.s.a)) != null) {
                    ((PersonRedTipData) Objects.requireNonNull(hashMap.get(String.valueOf(this.s.a)))).setShow(false);
                    n95.m().B(n95.q("key_my_tab_item_red_tip_data"), DataExt.toJson(hashMap));
                    this.m.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tieba.in6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) && this.i != i) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(this.j, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setImageResource(this.m, R.drawable.person_center_red_tip_shape);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
            o75 d = o75.d(this.x);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            o75 d2 = o75.d(this.w);
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            if (this.s.o) {
                o75 d3 = o75.d(this.j);
                d3.n(2);
                d3.o(R.string.J_X06);
                d3.f(R.color.CAM_X0205);
            }
            this.i = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        go6<T> go6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2 == this.j) {
            ud9 ud9Var = this.s;
            if (ud9Var.a == 36 && "游戏".equals(ud9Var.e) && (go6Var = this.e) != 0) {
                go6Var.a(view2, this.s);
                return;
            } else {
                r();
                return;
            }
        }
        s(view2);
    }

    public final void r() {
        ud9 ud9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (ud9Var = this.s) == null) {
            return;
        }
        if (ud9Var.m && ud9Var.l != 0) {
            ee9.a(ud9Var, this.b);
            C();
            return;
        }
        ud9 ud9Var2 = this.s;
        int i = ud9Var2.a;
        if (i != 25) {
            if (i != 33) {
                if (i != 41) {
                    if (i != 61) {
                        if (i != 30) {
                            if (i != 31) {
                                switch (i) {
                                    case 10:
                                        PersonRedTipManager.getInstance().updateRedTipState(1, false, true);
                                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 13));
                                        if (this.u != null) {
                                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getUserName(), this.u.getName_show(), this.u.getSex(), "iowner_gift")));
                                            return;
                                        }
                                        return;
                                    case 11:
                                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 16));
                                        if (!StringUtils.isNull(this.s.f)) {
                                            UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.f});
                                            return;
                                        }
                                        return;
                                    case 12:
                                        PersonRedTipManager.getInstance().updateRedTipState(7, false, true);
                                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 12));
                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(this.b.getPageActivity())));
                                        return;
                                    default:
                                        switch (i) {
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
                                            default:
                                                switch (i) {
                                                    case 36:
                                                        TiebaStatic.log(new StatisticItem("c12524").param("obj_locate", this.s.j));
                                                        t(this.s.f);
                                                        return;
                                                    case 37:
                                                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 24));
                                                        n95.m().w("key_has_borrow_cash_clicked", true);
                                                        wd9 wd9Var = this.s.h;
                                                        if (wd9Var != null) {
                                                            wd9Var.b(false);
                                                        }
                                                        this.m.setVisibility(8);
                                                        String s = n95.m().s("cash_pay", "");
                                                        if (!StringUtils.isNull(s)) {
                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2001447, s));
                                                            return;
                                                        }
                                                        return;
                                                    case 38:
                                                        ActivityPrizeData activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                                                        if (activityPrizeData.isPersonItemSwitch()) {
                                                            String h5Url = activityPrizeData.getH5Url();
                                                            if (!StringUtils.isNull(h5Url)) {
                                                                TiebaStatic.log(new StatisticItem("c12598"));
                                                                PersonRedTipManager.getInstance().updateRedTipState(9, false, true);
                                                                UrlManager.getInstance().dealOneLink(g(), new String[]{h5Url}, true);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    case 39:
                                                        qx4.E(true, this.b.getPageActivity(), this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0311), TbConfig.URL_BAIDU_SINGKIL);
                                                        return;
                                                    default:
                                                        switch (i) {
                                                            case 43:
                                                                x();
                                                                qx4.s(this.b.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                                                                return;
                                                            case 44:
                                                                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 26));
                                                                if (!TextUtils.isEmpty(this.s.f)) {
                                                                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.f});
                                                                }
                                                                if (!ui.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) && !"f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", getContext().getString(R.string.third_lite_game_center)).param("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).param("obj_source", "smallgame_center").param("obj_param1", 0));
                                                                    return;
                                                                } else {
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", getContext().getString(R.string.baidu_lite_game_center)).param("obj_id", "11811875").param("obj_source", "smallgame_center").param("obj_param1", 0));
                                                                    return;
                                                                }
                                                            case 45:
                                                                if (!TextUtils.isEmpty(ud9Var2.f)) {
                                                                    qx4.s(this.c, this.s.f);
                                                                }
                                                                StatisticItem.make("c13548").eventStat();
                                                                return;
                                                            case 46:
                                                                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.f}, true);
                                                                return;
                                                            case 47:
                                                                if (!TextUtils.isEmpty(ud9Var2.f)) {
                                                                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.f});
                                                                    return;
                                                                }
                                                                return;
                                                            case 48:
                                                                if (!TextUtils.isEmpty(ud9Var2.f)) {
                                                                    qx4.s(this.c, this.s.f);
                                                                    return;
                                                                }
                                                                return;
                                                            case 49:
                                                                if (!TextUtils.isEmpty(ud9Var2.f)) {
                                                                    lz4.n = true;
                                                                    qx4.s(this.c, this.s.f);
                                                                    return;
                                                                }
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                        }
                                }
                            }
                            PersonRedTipManager.getInstance().updateRedTipState(10, false, true);
                            n95.m().w("key_feedback_tip_show", false);
                            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 19));
                            if (getContext() != null) {
                                getContext().startActivity(s5a.a());
                            }
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SERVICE_CENTER_CLICK);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 17));
                        j6a.b();
                        return;
                    }
                    wd9 wd9Var2 = ud9Var2.h;
                    if (wd9Var2 != null && wd9Var2.a()) {
                        this.s.h.b(false);
                        this.m.setVisibility(8);
                        n95.m().z("setting_private_red_dot", 0);
                    }
                    u();
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 25));
                n95.m().w("key_baidu_financial_has_clicked", true);
                wd9 wd9Var3 = this.s.h;
                if (wd9Var3 != null) {
                    wd9Var3.b(false);
                }
                this.m.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                return;
            }
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 21));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.b.getPageActivity(), this.s.i)));
        } else if (this.u != null) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 18));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.b.getPageActivity(), this.u.getUserId(), this.u.getUserName(), this.u.getPortrait(), this.u.getSex(), true)));
        }
    }

    public final void s(View view2) {
        ud9 ud9Var;
        wd9 wd9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && (ud9Var = this.s) != null && view2 == this.p) {
            int i = ud9Var.a;
            if (i != 10) {
                if (i == 45 && (wd9Var = this.t) != null && !TextUtils.isEmpty(wd9Var.d)) {
                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.t.d});
                    return;
                }
                return;
            }
            CurrencyJumpHelper.personGotoBuyBean(this.b.getPageActivity());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in6
    /* renamed from: y */
    public void i(ud9 ud9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, ud9Var) != null) || ud9Var == null) {
            return;
        }
        this.s = ud9Var;
        this.u = ud9Var.g;
        this.t = ud9Var.h;
        this.l.setText(ud9Var.e);
        if (this.s.n) {
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(8);
        }
        A();
        B(this.t);
        j(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            z(str);
        } else if (str.startsWith("nohead:url")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.replaceFirst("nohead:url=", ""));
            String str2 = "?";
            if (str.contains("?")) {
                str2 = "&";
            }
            sb.append(str2);
            sb.append("jump=open_full_screen_web_page&nonavigationbar=1");
            UrlManager.getInstance().dealOneLink(this.b, new String[]{sb.toString()});
        } else {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str});
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                vi.P(this.b.getPageActivity(), R.string.cosume_record_plugin_not_install_tip);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str.substring(6)});
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
        } else {
            qx4.C(this.b.getPageActivity(), true, str);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext().getPageActivity())));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 5);
            TiebaStatic.log(statisticItem);
        }
    }
}
