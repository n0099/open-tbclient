package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.j;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.h> {
    private TextView gFZ;
    private ImageView jRC;
    private int mSkinType;
    private UserData mUserData;
    private View mvh;
    private ImageView mvi;
    private ImageView mvj;
    private TextView mvk;
    private TextView mvl;
    private TextView mvm;
    private View mvn;
    private View mvo;
    private com.baidu.tieba.personCenter.c.h mvp;
    private j mvq;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.mvh = view.findViewById(R.id.item_content);
        this.mvn = view.findViewById(R.id.function_item_bottom_divider);
        this.mvo = view.findViewById(R.id.function_item_bottom_divider_line);
        this.mvi = (ImageView) view.findViewById(R.id.function_icon);
        this.jRC = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.gFZ = (TextView) view.findViewById(R.id.function_title);
        this.mvj = (ImageView) view.findViewById(R.id.function_red_tip);
        this.mvk = (TextView) view.findViewById(R.id.function_desc);
        this.mvl = (TextView) view.findViewById(R.id.right_text);
        this.mvm = (TextView) view.findViewById(R.id.function_title_mark);
        this.mvl.setOnClickListener(this);
        this.mvh.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SvgManager.bsR().a(this.jRC, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.m(this.mvh, R.color.CAM_X0205, R.color.CAM_X0204);
            ap.setImageResource(this.mvj, R.drawable.person_center_red_tip_shape);
            ap.setBackgroundColor(this.mvn, R.color.CAM_X0205);
            ap.setBackgroundColor(this.mvo, R.color.CAM_X0203);
            ap.setViewTextColor(this.gFZ, R.color.CAM_X0105);
            ap.setViewTextColor(this.mvk, R.color.CAM_X0109);
            ap.setViewTextColor(this.mvl, R.color.CAM_X0105);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.person_center_function_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.personCenter.c.h hVar) {
        if (hVar != null) {
            this.mvp = hVar;
            this.mUserData = hVar.userData;
            this.mvq = hVar.mua;
            this.gFZ.setText(hVar.title);
            dwL();
            b(hVar);
            a(this.mvq);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dwL() {
        if (this.mvp.grE > 0) {
            this.mvi.setVisibility(0);
            if (this.mvp.mtX) {
                if (this.mvp.mtY) {
                    SvgManager.bsR().a(this.mvi, this.mvp.grE, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                } else {
                    SvgManager.bsR().a(this.mvi, this.mvp.grE, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                }
            }
            ap.setImageResource(this.mvi, this.mvp.grE);
            return;
        }
        this.mvi.setVisibility(8);
    }

    private void b(com.baidu.tieba.personCenter.c.h hVar) {
        if (hVar.mtZ) {
            this.mvn.setVisibility(0);
        } else {
            this.mvn.setVisibility(8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.isShowRedTip) {
                this.mvj.setVisibility(0);
            } else {
                this.mvj.setVisibility(8);
            }
            if (!StringUtils.isNull(jVar.mue)) {
                this.mvk.setVisibility(0);
                this.mvk.setText(jVar.mue);
            } else {
                this.mvk.setVisibility(8);
            }
            if (jVar.mui) {
                this.mvm.setVisibility(0);
            } else {
                this.mvm.setVisibility(8);
            }
            if (!TextUtils.isEmpty(jVar.text)) {
                this.mvl.setVisibility(0);
                this.mvl.setText(jVar.text);
                this.mvl.setCompoundDrawablesWithIntrinsicBounds(jVar.muf, jVar.mug, jVar.muh, jVar.muh);
                return;
            }
            this.mvl.setVisibility(8);
            return;
        }
        this.mvj.setVisibility(8);
        this.mvk.setVisibility(8);
        this.mvl.setVisibility(8);
        this.mvm.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.mvh) {
                if (this.mvp.type == 36 && "游戏".equals(this.mvp.title) && this.iut != null) {
                    this.iut.a(view, this.mvp);
                    return;
                } else {
                    dwM();
                    return;
                }
            }
            dW(view);
        }
    }

    private void dwM() {
        if (this.mvp != null) {
            switch (this.mvp.type) {
                case 10:
                    com.baidu.tieba.p.a.dEW().h(1, false, true);
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 13));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 16));
                    if (!StringUtils.isNull(this.mvp.aHq)) {
                        bf.bsV().b(this.mTbPageContext, new String[]{this.mvp.aHq});
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.p.a.dEW().h(7, false, true);
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 12));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.mTbPageContext.getPageActivity())));
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
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 9));
                    com.baidu.tieba.p.a.dEW().h(3, false, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 17:
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 10));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 18:
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 15));
                    bf.bsV().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 22:
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 11));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                        return;
                    }
                    return;
                case 25:
                    if (this.mUserData != null) {
                        TiebaStatic.log(new ar("c12523").ap("obj_locate", 18));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                        return;
                    }
                    return;
                case 30:
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 17));
                    if (!com.baidu.tbadk.plugins.b.k(this.mTbPageContext)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig("hottopic", "all")));
                        return;
                    }
                    return;
                case 31:
                    com.baidu.tieba.p.a.dEW().h(10, false, true);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 19));
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 33:
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 21));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.mvp.mub)));
                    return;
                case 36:
                    TiebaStatic.log(new ar("c12524").ap("obj_locate", this.mvp.itemId));
                    Qi(this.mvp.aHq);
                    return;
                case 37:
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 24));
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, true);
                    if (this.mvp.mua != null) {
                        this.mvp.mua.isShowRedTip = false;
                    }
                    this.mvj.setVisibility(8);
                    String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("cash_pay", "");
                    if (!StringUtils.isNull(string)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, string));
                        return;
                    }
                    return;
                case 38:
                    com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                    if (activityPrizeData.isPersonItemSwitch()) {
                        String h5Url = activityPrizeData.getH5Url();
                        if (!StringUtils.isNull(h5Url)) {
                            TiebaStatic.log(new ar("c12598"));
                            com.baidu.tieba.p.a.dEW().h(9, false, true);
                            bf.bsV().a(getTbPageContext(), new String[]{h5Url}, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 39:
                    com.baidu.tbadk.browser.a.startWebActivity(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                    return;
                case 41:
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 25));
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_baidu_financial_has_clicked", true);
                    if (this.mvp.mua != null) {
                        this.mvp.mua.isShowRedTip = false;
                    }
                    this.mvj.setVisibility(8);
                    MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
                    return;
                case 43:
                    cPu();
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                    return;
                case 44:
                    TiebaStatic.log(new ar("c12523").ap("obj_locate", 26));
                    if (!TextUtils.isEmpty(this.mvp.aHq)) {
                        bf.bsV().b(this.mTbPageContext, new String[]{this.mvp.aHq});
                    }
                    if (au.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                        TiebaStatic.log(new ar("c13274").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", getContext().getString(R.string.baidu_lite_game_center)).dR("obj_id", "11811875").dR("obj_source", "smallgame_center").ap("obj_param1", 0));
                        return;
                    } else {
                        TiebaStatic.log(new ar("c13274").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", getContext().getString(R.string.third_lite_game_center)).dR("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).dR("obj_source", "smallgame_center").ap("obj_param1", 0));
                        return;
                    }
                case 45:
                    if (!TextUtils.isEmpty(this.mvp.aHq)) {
                        com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.mvp.aHq);
                    }
                    ar.Bd("c13548").bsO();
                    return;
                case 46:
                    bf.bsV().a(this.mTbPageContext, new String[]{this.mvp.aHq}, true);
                    return;
            }
        }
    }

    private void dW(View view) {
        if (this.mvp != null && view == this.mvl) {
            switch (this.mvp.type) {
                case 10:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 45:
                    if (this.mvq != null && !TextUtils.isEmpty(this.mvq.linkUrl)) {
                        bf.bsV().b(this.mTbPageContext, new String[]{this.mvq.linkUrl});
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Qh(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                bf.bsV().b(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                com.baidu.tbadk.browser.a.startWebActivity((Context) this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void Qi(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                Qh(str);
            } else if (str.startsWith("nohead:url")) {
                bf.bsV().b(this.mTbPageContext, new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                bf.bsV().b(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void cPu() {
        ar arVar = new ar("c13422");
        arVar.ap("obj_type", 2);
        arVar.ap("obj_locate", 5);
        TiebaStatic.log(arVar);
    }
}
