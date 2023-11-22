package com.baidu.tieba;

import android.content.Context;
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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.util.TopicListUtil;
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
public class q4a extends zk6<x3a> {
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
    public x3a s;
    public z3a t;
    public UserData u;
    public LinearLayout v;
    public LinearLayout w;
    public LinearLayout x;
    public View y;

    @Override // com.baidu.tieba.zk6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.layout.obfuscated_res_0x7f0d07e2 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q4a(TbPageContext<?> tbPageContext) {
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
        this.y = i();
        int dimens = BdUtilHelper.getDimens(this.c, R.dimen.M_W_X003);
        this.y.setPadding(dimens, 0, dimens, 0);
        this.v = (LinearLayout) this.y.findViewById(R.id.obfuscated_res_0x7f091c1a);
        this.w = (LinearLayout) this.y.findViewById(R.id.obfuscated_res_0x7f091c1b);
        this.j = this.y.findViewById(R.id.obfuscated_res_0x7f0911f8);
        this.k = (TbImageView) this.y.findViewById(R.id.obfuscated_res_0x7f090e21);
        this.o = (ImageView) this.y.findViewById(R.id.obfuscated_res_0x7f090e24);
        this.l = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f090e25);
        this.m = (ImageView) this.y.findViewById(R.id.obfuscated_res_0x7f090e23);
        this.n = (TextView) this.y.findViewById(R.id.function_desc);
        this.p = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f091faa);
        this.q = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f090e26);
        this.r = (TextView) this.y.findViewById(R.id.obfuscated_res_0x7f090665);
        this.x = (LinearLayout) this.y.findViewById(R.id.obfuscated_res_0x7f090666);
        this.p.setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zk6
    /* renamed from: A */
    public void k(x3a x3aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, x3aVar) != null) || x3aVar == null) {
            return;
        }
        this.s = x3aVar;
        this.u = x3aVar.g;
        this.t = x3aVar.h;
        this.l.setText(x3aVar.e);
        if (this.s.n) {
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(8);
        }
        C();
        D(this.t);
        l(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void r(View view2) {
        x3a x3aVar;
        z3a z3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && (x3aVar = this.s) != null && view2 == this.p) {
            int i = x3aVar.a;
            if (i != 10) {
                if (i == 45 && (z3aVar = this.t) != null && !TextUtils.isEmpty(z3aVar.d)) {
                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.t.d});
                    return;
                }
                return;
            }
            CurrencyJumpHelper.personGotoBuyBean(this.b.getPageActivity());
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                BdUtilHelper.showToast(this.b.getPageActivity(), (int) R.string.cosume_record_plugin_not_install_tip);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.b, new String[]{str.substring(6)});
        } else if (!str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
        } else {
            BrowserHelper.startWebActivity((Context) this.b.getPageActivity(), true, str);
        }
    }

    public final void x(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (str.startsWith("tieba&")) {
            B(str);
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

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            x3a x3aVar = this.s;
            if (x3aVar.b > 0) {
                this.k.setVisibility(0);
                x3a x3aVar2 = this.s;
                if (x3aVar2.c) {
                    if (x3aVar2.d) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, this.s.b, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    } else {
                        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, this.s.b, SvgManager.SvgResourceStateType.NORMAL);
                        return;
                    }
                }
                SkinManager.setImageResource(this.k, x3aVar2.b);
            } else if (x3aVar.m && !TextUtils.isEmpty(x3aVar.k)) {
                this.k.setVisibility(0);
                this.k.startLoad(this.s.k, 10, false);
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public final void D(z3a z3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, z3aVar) == null) {
            if (z3aVar != null) {
                if (z3aVar.a()) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
                if (!StringUtils.isNull(z3aVar.b)) {
                    this.n.setVisibility(0);
                    this.n.setText(z3aVar.b);
                } else {
                    this.n.setVisibility(8);
                }
                boolean z = !TextUtils.isEmpty(z3aVar.i);
                if (!z3aVar.h && !z) {
                    this.q.setVisibility(8);
                } else {
                    this.q.setVisibility(0);
                    this.n.setVisibility(8);
                    if (z) {
                        this.q.setText(z3aVar.i);
                    }
                }
                if (!TextUtils.isEmpty(z3aVar.c)) {
                    this.p.setVisibility(0);
                    this.p.setText(z3aVar.c);
                    TextView textView = this.p;
                    Drawable drawable = z3aVar.e;
                    Drawable drawable2 = z3aVar.f;
                    Drawable drawable3 = z3aVar.g;
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

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HashMap hashMap = new HashMap();
            String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), "");
            if (!StringUtils.isNull(string)) {
                new HashMap();
                for (Map.Entry<String, Object> entry : DataExt.toMap(string).entrySet()) {
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
                    SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), DataExt.toJson(hashMap));
                    this.m.setVisibility(8);
                }
            }
        }
    }

    @Override // com.baidu.tieba.zk6
    public void l(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) && this.i != i) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            TBSelector.setViewBackgroundColorWithPressedState(this.j, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setImageResource(this.m, R.drawable.person_center_red_tip_shape);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
            EMManager.from(this.x).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.w).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            if (this.s.o) {
                EMManager.from(this.j).setCardType(2).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            }
            this.i = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        yl6<T> yl6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2 == this.j) {
            x3a x3aVar = this.s;
            if (x3aVar.a == 36 && "游戏".equals(x3aVar.e) && (yl6Var = this.e) != 0) {
                yl6Var.a(view2, this.s);
                return;
            } else {
                p();
                return;
            }
        }
        r(view2);
    }

    public final void p() {
        x3a x3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (x3aVar = this.s) == null) {
            return;
        }
        if (x3aVar.m && x3aVar.l != 0) {
            h4a.a(x3aVar, this.b);
            E();
            return;
        }
        x3a x3aVar2 = this.s;
        int i = x3aVar2.a;
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
                                                        x(this.s.f);
                                                        return;
                                                    case 37:
                                                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 24));
                                                        SharedPrefHelper.getInstance().putBoolean("key_has_borrow_cash_clicked", true);
                                                        z3a z3aVar = this.s.h;
                                                        if (z3aVar != null) {
                                                            z3aVar.b(false);
                                                        }
                                                        this.m.setVisibility(8);
                                                        String string = SharedPrefHelper.getInstance().getString("cash_pay", "");
                                                        if (!StringUtils.isNull(string)) {
                                                            MessageManager.getInstance().sendMessage(new CustomMessage(2001447, string));
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
                                                                UrlManager.getInstance().dealOneLink(h(), new String[]{h5Url}, true);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    case 39:
                                                        BrowserHelper.startWebActivity(true, (Context) this.b.getPageActivity(), this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0318), TbConfig.URL_BAIDU_SINGKIL);
                                                        return;
                                                    default:
                                                        switch (i) {
                                                            case 43:
                                                                z();
                                                                BrowserHelper.startWebActivity(this.b.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                                                                return;
                                                            case 44:
                                                                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 26));
                                                                if (!TextUtils.isEmpty(this.s.f)) {
                                                                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.f});
                                                                }
                                                                if (!qd.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) && !"f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", c().getString(R.string.third_lite_game_center)).param("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).param("obj_source", "smallgame_center").param("obj_param1", 0));
                                                                    return;
                                                                } else {
                                                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", c().getString(R.string.baidu_lite_game_center)).param("obj_id", "11811875").param("obj_source", "smallgame_center").param("obj_param1", 0));
                                                                    return;
                                                                }
                                                            case 45:
                                                                if (!TextUtils.isEmpty(x3aVar2.f)) {
                                                                    BrowserHelper.startWebActivity(this.c, this.s.f);
                                                                }
                                                                StatisticItem.make("c13548").eventStat();
                                                                return;
                                                            case 46:
                                                                UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.f}, true);
                                                                return;
                                                            case 47:
                                                                if (!TextUtils.isEmpty(x3aVar2.f)) {
                                                                    UrlManager.getInstance().dealOneLink(this.b, new String[]{this.s.f});
                                                                    return;
                                                                }
                                                                return;
                                                            case 48:
                                                                if (!TextUtils.isEmpty(x3aVar2.f)) {
                                                                    BrowserHelper.startWebActivity(this.c, this.s.f);
                                                                    return;
                                                                }
                                                                return;
                                                            case 49:
                                                                if (!TextUtils.isEmpty(x3aVar2.f)) {
                                                                    ku4.n = true;
                                                                    BrowserHelper.startWebActivity(this.c, this.s.f);
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
                            SharedPrefHelper.getInstance().putBoolean("key_feedback_tip_show", false);
                            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 19));
                            if (c() != null) {
                                c().startActivity(a0b.a());
                            }
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SERVICE_CENTER_CLICK);
                            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 17));
                        TopicListUtil.openWebTopicListPage();
                        return;
                    }
                    z3a z3aVar2 = x3aVar2.h;
                    if (z3aVar2 != null && z3aVar2.a()) {
                        this.s.h.b(false);
                        this.m.setVisibility(8);
                        SharedPrefHelper.getInstance().putInt("setting_private_red_dot", 0);
                    }
                    y();
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 25));
                SharedPrefHelper.getInstance().putBoolean("key_baidu_financial_has_clicked", true);
                z3a z3aVar3 = this.s.h;
                if (z3aVar3 != null) {
                    z3aVar3.b(false);
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

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (TbadkApplication.getInst().getCurrentActivity() instanceof TbPageContextSupport)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SecretSettingActivityConfig(((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext().getPageActivity())));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TASK_ENTRANCE);
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 5);
            TiebaStatic.log(statisticItem);
        }
    }
}
