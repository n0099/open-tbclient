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
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.j;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.h> {
    private TextView gHV;
    private ImageView jPl;
    private int mSkinType;
    private UserData mUserData;
    private View mqL;
    private ImageView mqM;
    private ImageView mqN;
    private TextView mqO;
    private TextView mqP;
    private TextView mqQ;
    private View mqR;
    private View mqS;
    private com.baidu.tieba.personCenter.c.h mqT;
    private j mqU;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.mqL = view.findViewById(R.id.item_content);
        this.mqR = view.findViewById(R.id.function_item_bottom_divider);
        this.mqS = view.findViewById(R.id.function_item_bottom_divider_line);
        this.mqM = (ImageView) view.findViewById(R.id.function_icon);
        this.jPl = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.gHV = (TextView) view.findViewById(R.id.function_title);
        this.mqN = (ImageView) view.findViewById(R.id.function_red_tip);
        this.mqO = (TextView) view.findViewById(R.id.function_desc);
        this.mqP = (TextView) view.findViewById(R.id.right_text);
        this.mqQ = (TextView) view.findViewById(R.id.function_title_mark);
        this.mqP.setOnClickListener(this);
        this.mqL.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SvgManager.bwr().a(this.jPl, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.m(this.mqL, R.color.CAM_X0205, R.color.CAM_X0204);
            ao.setImageResource(this.mqN, R.drawable.person_center_red_tip_shape);
            ao.setBackgroundColor(this.mqR, R.color.CAM_X0205);
            ao.setBackgroundColor(this.mqS, R.color.CAM_X0203);
            ao.setViewTextColor(this.gHV, R.color.CAM_X0105);
            ao.setViewTextColor(this.mqO, R.color.CAM_X0109);
            ao.setViewTextColor(this.mqP, R.color.CAM_X0105);
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
            this.mqT = hVar;
            this.mUserData = hVar.userData;
            this.mqU = hVar.mpD;
            this.gHV.setText(hVar.title);
            dyu();
            b(hVar);
            a(this.mqU);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dyu() {
        if (this.mqT.gtC > 0) {
            this.mqM.setVisibility(0);
            if (this.mqT.mpA) {
                if (this.mqT.mpB) {
                    SvgManager.bwr().a(this.mqM, this.mqT.gtC, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                } else {
                    SvgManager.bwr().a(this.mqM, this.mqT.gtC, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                }
            }
            ao.setImageResource(this.mqM, this.mqT.gtC);
            return;
        }
        this.mqM.setVisibility(8);
    }

    private void b(com.baidu.tieba.personCenter.c.h hVar) {
        if (hVar.mpC) {
            this.mqR.setVisibility(0);
        } else {
            this.mqR.setVisibility(8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.isShowRedTip) {
                this.mqN.setVisibility(0);
            } else {
                this.mqN.setVisibility(8);
            }
            if (!StringUtils.isNull(jVar.mpH)) {
                this.mqO.setVisibility(0);
                this.mqO.setText(jVar.mpH);
            } else {
                this.mqO.setVisibility(8);
            }
            if (jVar.mpL) {
                this.mqQ.setVisibility(0);
            } else {
                this.mqQ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(jVar.text)) {
                this.mqP.setVisibility(0);
                this.mqP.setText(jVar.text);
                this.mqP.setCompoundDrawablesWithIntrinsicBounds(jVar.mpI, jVar.mpJ, jVar.mpK, jVar.mpK);
                return;
            }
            this.mqP.setVisibility(8);
            return;
        }
        this.mqN.setVisibility(8);
        this.mqO.setVisibility(8);
        this.mqP.setVisibility(8);
        this.mqQ.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.mqL) {
                if (this.mqT.type == 36 && "游戏".equals(this.mqT.title) && this.itw != null) {
                    this.itw.a(view, this.mqT);
                    return;
                } else {
                    dyv();
                    return;
                }
            }
            dY(view);
        }
    }

    private void dyv() {
        if (this.mqT != null) {
            switch (this.mqT.type) {
                case 10:
                    com.baidu.tieba.p.a.dGE().h(1, false, true);
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 13));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 16));
                    if (!StringUtils.isNull(this.mqT.aJH)) {
                        be.bwv().b(this.mTbPageContext, new String[]{this.mqT.aJH});
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.p.a.dGE().h(7, false, true);
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 12));
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
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 9));
                    com.baidu.tieba.p.a.dGE().h(3, false, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 17:
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 10));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 18:
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 15));
                    be.bwv().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 22:
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 11));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                        return;
                    }
                    return;
                case 25:
                    if (this.mUserData != null) {
                        TiebaStatic.log(new aq("c12523").an("obj_locate", 18));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                        return;
                    }
                    return;
                case 30:
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 17));
                    if (!com.baidu.tbadk.plugins.b.k(this.mTbPageContext)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all")));
                        return;
                    }
                    return;
                case 31:
                    com.baidu.tieba.p.a.dGE().h(10, false, true);
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 19));
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 33:
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 21));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.mqT.mpE)));
                    return;
                case 36:
                    TiebaStatic.log(new aq("c12524").an("obj_locate", this.mqT.itemId));
                    Qy(this.mqT.aJH);
                    return;
                case 37:
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 24));
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, true);
                    if (this.mqT.mpD != null) {
                        this.mqT.mpD.isShowRedTip = false;
                    }
                    this.mqN.setVisibility(8);
                    String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString("cash_pay", "");
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
                            TiebaStatic.log(new aq("c12598"));
                            com.baidu.tieba.p.a.dGE().h(9, false, true);
                            be.bwv().a(getTbPageContext(), new String[]{h5Url}, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 39:
                    com.baidu.tbadk.browser.a.startWebActivity(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                    return;
                case 41:
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 25));
                    com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("key_baidu_financial_has_clicked", true);
                    if (this.mqT.mpD != null) {
                        this.mqT.mpD.isShowRedTip = false;
                    }
                    this.mqN.setVisibility(8);
                    MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
                    return;
                case 43:
                    cRq();
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                    return;
                case 44:
                    TiebaStatic.log(new aq("c12523").an("obj_locate", 26));
                    if (!TextUtils.isEmpty(this.mqT.aJH)) {
                        be.bwv().b(this.mTbPageContext, new String[]{this.mqT.aJH});
                    }
                    if (at.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                        TiebaStatic.log(new aq("c13274").dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("obj_name", getContext().getString(R.string.baidu_lite_game_center)).dX("obj_id", "11811875").dX("obj_source", "smallgame_center").an("obj_param1", 0));
                        return;
                    } else {
                        TiebaStatic.log(new aq("c13274").dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("obj_name", getContext().getString(R.string.third_lite_game_center)).dX("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).dX("obj_source", "smallgame_center").an("obj_param1", 0));
                        return;
                    }
                case 45:
                    if (!TextUtils.isEmpty(this.mqT.aJH)) {
                        com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.mqT.aJH);
                    }
                    aq.BX("c13548").bwo();
                    return;
                case 46:
                    be.bwv().a(this.mTbPageContext, new String[]{this.mqT.aJH}, true);
                    return;
            }
        }
    }

    private void dY(View view) {
        if (this.mqT != null && view == this.mqP) {
            switch (this.mqT.type) {
                case 10:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 45:
                    if (this.mqU != null && !TextUtils.isEmpty(this.mqU.linkUrl)) {
                        be.bwv().b(this.mTbPageContext, new String[]{this.mqU.linkUrl});
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Qx(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                be.bwv().b(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                com.baidu.tbadk.browser.a.startWebActivity((Context) this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void Qy(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                Qx(str);
            } else if (str.startsWith("nohead:url")) {
                be.bwv().b(this.mTbPageContext, new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                be.bwv().b(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void cRq() {
        aq aqVar = new aq("c13422");
        aqVar.an("obj_type", 2);
        aqVar.an("obj_locate", 5);
        TiebaStatic.log(aqVar);
    }
}
