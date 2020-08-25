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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.j;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes16.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.h> {
    private TextView fJx;
    private ImageView izH;
    private View lgA;
    private View lgB;
    private com.baidu.tieba.personCenter.c.h lgC;
    private j lgD;
    private View lgu;
    private ImageView lgv;
    private ImageView lgw;
    private TextView lgx;
    private TextView lgy;
    private TextView lgz;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.lgu = view.findViewById(R.id.item_content);
        this.lgA = view.findViewById(R.id.function_item_bottom_divider);
        this.lgB = view.findViewById(R.id.function_item_bottom_divider_line);
        this.lgv = (ImageView) view.findViewById(R.id.function_icon);
        this.izH = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.fJx = (TextView) view.findViewById(R.id.function_title);
        this.lgw = (ImageView) view.findViewById(R.id.function_red_tip);
        this.lgx = (TextView) view.findViewById(R.id.function_desc);
        this.lgy = (TextView) view.findViewById(R.id.right_text);
        this.lgz = (TextView) view.findViewById(R.id.function_title_mark);
        this.lgy.setOnClickListener(this);
        this.lgu.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SvgManager.bjq().a(this.izH, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(this.lgu, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setImageResource(this.lgw, R.drawable.person_center_red_tip_shape);
            ap.setBackgroundColor(this.lgA, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.lgB, R.color.cp_bg_line_b);
            ap.setViewTextColor(this.fJx, R.color.cp_cont_b);
            ap.setViewTextColor(this.lgx, R.color.cp_cont_d);
            ap.setViewTextColor(this.lgy, R.color.cp_cont_b);
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
            this.lgC = hVar;
            this.mUserData = hVar.userData;
            this.lgD = hVar.lfm;
            this.fJx.setText(hVar.title);
            dgM();
            b(hVar);
            a(this.lgD);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dgM() {
        if (this.lgC.lfi > 0) {
            this.lgv.setVisibility(0);
            if (this.lgC.lfj) {
                if (this.lgC.lfk) {
                    SvgManager.bjq().a(this.lgv, this.lgC.lfi, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                } else {
                    SvgManager.bjq().a(this.lgv, this.lgC.lfi, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                }
            }
            ap.setImageResource(this.lgv, this.lgC.lfi);
            return;
        }
        this.lgv.setVisibility(8);
    }

    private void b(com.baidu.tieba.personCenter.c.h hVar) {
        if (hVar.lfl) {
            this.lgA.setVisibility(0);
        } else {
            this.lgA.setVisibility(8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.isShowRedTip) {
                this.lgw.setVisibility(0);
            } else {
                this.lgw.setVisibility(8);
            }
            if (!StringUtils.isNull(jVar.lfq)) {
                this.lgx.setVisibility(0);
                this.lgx.setText(jVar.lfq);
            } else {
                this.lgx.setVisibility(8);
            }
            if (jVar.lfu) {
                this.lgz.setVisibility(0);
            } else {
                this.lgz.setVisibility(8);
            }
            if (!TextUtils.isEmpty(jVar.text)) {
                this.lgy.setVisibility(0);
                this.lgy.setText(jVar.text);
                this.lgy.setCompoundDrawablesWithIntrinsicBounds(jVar.lfr, jVar.lfs, jVar.lft, jVar.lft);
                return;
            }
            this.lgy.setVisibility(8);
            return;
        }
        this.lgw.setVisibility(8);
        this.lgx.setVisibility(8);
        this.lgy.setVisibility(8);
        this.lgz.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.lgu) {
                if (this.lgC.type == 36 && "游戏".equals(this.lgC.title) && this.hhh != null) {
                    this.hhh.a(view, this.lgC);
                    return;
                } else {
                    dgN();
                    return;
                }
            }
            de(view);
        }
    }

    private void dgN() {
        if (this.lgC != null) {
            switch (this.lgC.type) {
                case 10:
                    com.baidu.tieba.p.a.doQ().h(1, false, true);
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 13));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 16));
                    if (!StringUtils.isNull(this.lgC.aDg)) {
                        be.bju().b(this.mTbPageContext, new String[]{this.lgC.aDg});
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.p.a.doQ().h(7, false, true);
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 12));
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
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 9));
                    com.baidu.tieba.p.a.doQ().h(3, false, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 17:
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 10));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 18:
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 15));
                    be.bju().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 22:
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 11));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                        return;
                    }
                    return;
                case 25:
                    if (this.mUserData != null) {
                        TiebaStatic.log(new aq("c12523").ai("obj_locate", 18));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                        return;
                    }
                    return;
                case 30:
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 17));
                    if (!com.baidu.tbadk.plugins.b.k(this.mTbPageContext)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all")));
                        return;
                    }
                    return;
                case 31:
                    com.baidu.tieba.p.a.doQ().h(10, false, true);
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 19));
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 33:
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 21));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.lgC.lfn)));
                    return;
                case 36:
                    TiebaStatic.log(new aq("c12524").ai("obj_locate", this.lgC.itemId));
                    Oj(this.lgC.aDg);
                    return;
                case 37:
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 24));
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, true);
                    if (this.lgC.lfm != null) {
                        this.lgC.lfm.isShowRedTip = false;
                    }
                    this.lgw.setVisibility(8);
                    String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("cash_pay", "");
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
                            com.baidu.tieba.p.a.doQ().h(9, false, true);
                            be.bju().a(getTbPageContext(), new String[]{h5Url}, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 39:
                    com.baidu.tbadk.browser.a.startWebActivity(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                    return;
                case 41:
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 25));
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_baidu_financial_has_clicked", true);
                    if (this.lgC.lfm != null) {
                        this.lgC.lfm.isShowRedTip = false;
                    }
                    this.lgw.setVisibility(8);
                    MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
                    return;
                case 43:
                    cwv();
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                    return;
                case 44:
                    TiebaStatic.log(new aq("c12523").ai("obj_locate", 26));
                    if (!TextUtils.isEmpty(this.lgC.aDg)) {
                        be.bju().b(this.mTbPageContext, new String[]{this.lgC.aDg});
                    }
                    if (at.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                        TiebaStatic.log(new aq("c13274").dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("obj_name", getContext().getString(R.string.baidu_lite_game_center)).dD("obj_id", "11811875").dD("obj_source", "smallgame_center").ai("obj_param1", 0));
                        return;
                    } else {
                        TiebaStatic.log(new aq("c13274").dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("obj_name", getContext().getString(R.string.third_lite_game_center)).dD("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).dD("obj_source", "smallgame_center").ai("obj_param1", 0));
                        return;
                    }
                case 45:
                    if (!TextUtils.isEmpty(this.lgC.aDg)) {
                        com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.lgC.aDg);
                    }
                    aq.Ad("c13548").bjn();
                    return;
                case 46:
                    be.bju().a(this.mTbPageContext, new String[]{this.lgC.aDg}, true);
                    return;
            }
        }
    }

    private void de(View view) {
        if (this.lgC != null && view == this.lgy) {
            switch (this.lgC.type) {
                case 10:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 45:
                    if (this.lgD != null && !TextUtils.isEmpty(this.lgD.linkUrl)) {
                        be.bju().b(this.mTbPageContext, new String[]{this.lgD.linkUrl});
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Oi(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                be.bju().b(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                com.baidu.tbadk.browser.a.startWebActivity((Context) this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void Oj(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                Oi(str);
            } else if (str.startsWith("nohead:url")) {
                be.bju().b(this.mTbPageContext, new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                be.bju().b(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void cwv() {
        aq aqVar = new aq("c13422");
        aqVar.ai("obj_type", 2);
        aqVar.ai("obj_locate", 5);
        TiebaStatic.log(aqVar);
    }
}
