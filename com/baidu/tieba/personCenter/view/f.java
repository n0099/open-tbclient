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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.c.i;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.c.g> {
    private TextView eqE;
    private View jiC;
    private ImageView jiD;
    private TextView jiE;
    private ImageView jiF;
    private TextView jiG;
    private TextView jiH;
    private View jiI;
    private View jiJ;
    private com.baidu.tieba.personCenter.c.g jiK;
    private i jiL;
    private ImageView jic;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jiC = view.findViewById(R.id.item_content);
        this.jiI = view.findViewById(R.id.function_item_bottom_divider);
        this.jiJ = view.findViewById(R.id.function_item_bottom_divider_line);
        this.jiD = (ImageView) view.findViewById(R.id.function_icon);
        this.jiF = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.eqE = (TextView) view.findViewById(R.id.function_title);
        this.jic = (ImageView) view.findViewById(R.id.function_red_tip);
        this.jiE = (TextView) view.findViewById(R.id.function_desc);
        this.jiG = (TextView) view.findViewById(R.id.right_text);
        this.jiH = (TextView) view.findViewById(R.id.function_title_mark);
        this.jiG.setOnClickListener(this);
        this.jiC.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SvgManager.aGA().a(this.jiF, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.c(this.jiC, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            am.setImageResource(this.jic, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.jiI, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.jiJ, R.color.cp_bg_line_b);
            am.setViewTextColor(this.eqE, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jiE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jiG, (int) R.color.cp_cont_b);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_function_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.c.g gVar) {
        if (gVar != null) {
            this.jiK = gVar;
            this.mUserData = gVar.userData;
            this.jiL = gVar.jhB;
            this.eqE.setText(gVar.title);
            cvo();
            b(gVar);
            a(this.jiL);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cvo() {
        if (this.jiK.iconId > 0) {
            this.jiD.setVisibility(0);
            if (this.jiK.jhy) {
                if (this.jiK.jhz) {
                    SvgManager.aGA().a(this.jiD, this.jiK.iconId, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                } else {
                    SvgManager.aGA().a(this.jiD, this.jiK.iconId, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                }
            }
            am.setImageResource(this.jiD, this.jiK.iconId);
            return;
        }
        this.jiD.setVisibility(8);
    }

    private void b(com.baidu.tieba.personCenter.c.g gVar) {
        if (gVar.jhA) {
            this.jiI.setVisibility(0);
        } else {
            this.jiI.setVisibility(8);
        }
    }

    private void a(i iVar) {
        if (iVar != null) {
            if (iVar.isShowRedTip) {
                this.jic.setVisibility(0);
            } else {
                this.jic.setVisibility(8);
            }
            if (!StringUtils.isNull(iVar.jhF)) {
                this.jiE.setVisibility(0);
                this.jiE.setText(iVar.jhF);
            } else {
                this.jiE.setVisibility(8);
            }
            if (iVar.jhJ) {
                this.jiH.setVisibility(0);
            } else {
                this.jiH.setVisibility(8);
            }
            if (!TextUtils.isEmpty(iVar.text)) {
                this.jiG.setVisibility(0);
                this.jiG.setText(iVar.text);
                this.jiG.setCompoundDrawablesWithIntrinsicBounds(iVar.jhG, iVar.jhH, iVar.jhI, iVar.jhI);
                return;
            }
            this.jiG.setVisibility(8);
            return;
        }
        this.jic.setVisibility(8);
        this.jiE.setVisibility(8);
        this.jiG.setVisibility(8);
        this.jiH.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jiC) {
                if (this.jiK.type == 36 && "游戏".equals(this.jiK.title) && this.fHf != null) {
                    this.fHf.a(view, this.jiK);
                    return;
                } else {
                    cvp();
                    return;
                }
            }
            cK(view);
        }
    }

    private void cvp() {
        if (this.jiK != null) {
            switch (this.jiK.type) {
                case 10:
                    com.baidu.tieba.p.a.cDN().g(1, false, true);
                    TiebaStatic.log(new an("c12523").X("obj_locate", 13));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 16));
                    if (!StringUtils.isNull(this.jiK.cLQ)) {
                        ba.aGE().b(this.mTbPageContext, new String[]{this.jiK.cLQ});
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.p.a.cDN().g(7, false, true);
                    TiebaStatic.log(new an("c12523").X("obj_locate", 12));
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
                    TiebaStatic.log(new an("c12523").X("obj_locate", 9));
                    com.baidu.tieba.p.a.cDN().g(3, false, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 17:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 10));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 18:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 15));
                    ba.aGE().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 22:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 11));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                        return;
                    }
                    return;
                case 25:
                    if (this.mUserData != null) {
                        TiebaStatic.log(new an("c12523").X("obj_locate", 18));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                        return;
                    }
                    return;
                case 30:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 17));
                    if (!com.baidu.tbadk.plugins.b.h(this.mTbPageContext)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, SchemeCollecter.CLASSIFY_ALL)));
                        return;
                    }
                    return;
                case 31:
                    com.baidu.tieba.p.a.cDN().g(10, false, true);
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
                    TiebaStatic.log(new an("c12523").X("obj_locate", 19));
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 33:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 21));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.jiK.jhC)));
                    return;
                case 36:
                    TiebaStatic.log(new an("c12524").X("obj_locate", this.jiK.itemId));
                    GC(this.jiK.cLQ);
                    return;
                case 37:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 24));
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, true);
                    if (this.jiK.jhB != null) {
                        this.jiK.jhB.isShowRedTip = false;
                    }
                    this.jic.setVisibility(8);
                    String string = com.baidu.tbadk.core.sharedPref.b.aFB().getString("cash_pay", "");
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
                            TiebaStatic.log(new an("c12598"));
                            com.baidu.tieba.p.a.cDN().g(9, false, true);
                            ba.aGE().a(getTbPageContext(), new String[]{h5Url}, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 39:
                    com.baidu.tbadk.browser.a.startWebActivity(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                    return;
                case 41:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 25));
                    com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("key_baidu_financial_has_clicked", true);
                    if (this.jiK.jhB != null) {
                        this.jiK.jhB.isShowRedTip = false;
                    }
                    this.jic.setVisibility(8);
                    MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
                    return;
                case 43:
                    bNx();
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                    return;
                case 44:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 26));
                    if (!TextUtils.isEmpty(this.jiK.cLQ)) {
                        ba.aGE().b(this.mTbPageContext, new String[]{this.jiK.cLQ});
                    }
                    if (aq.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                        TiebaStatic.log(new an("c13274").cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", getContext().getString(R.string.baidu_lite_game_center)).cy("obj_id", "11811875").cy("obj_source", "smallgame_center").X("obj_param1", 0));
                        return;
                    } else {
                        TiebaStatic.log(new an("c13274").cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", getContext().getString(R.string.third_lite_game_center)).cy("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).cy("obj_source", "smallgame_center").X("obj_param1", 0));
                        return;
                    }
                case 45:
                    if (!TextUtils.isEmpty(this.jiK.cLQ)) {
                        com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.jiK.cLQ);
                    }
                    an.tv("c13548").aGx();
                    return;
                case 46:
                    ba.aGE().a(this.mTbPageContext, new String[]{this.jiK.cLQ}, true);
                    return;
            }
        }
    }

    private void cK(View view) {
        if (this.jiK != null && view == this.jiG) {
            switch (this.jiK.type) {
                case 10:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 45:
                    if (this.jiL != null && !TextUtils.isEmpty(this.jiL.linkUrl)) {
                        ba.aGE().b(this.mTbPageContext, new String[]{this.jiL.linkUrl});
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void GB(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                ba.aGE().b(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                com.baidu.tbadk.browser.a.startWebActivity((Context) this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void GC(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                GB(str);
            } else if (str.startsWith("nohead:url")) {
                ba.aGE().b(this.mTbPageContext, new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ba.aGE().b(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void bNx() {
        an anVar = new an("c13422");
        anVar.X("obj_type", 2);
        anVar.X("obj_locate", 5);
        TiebaStatic.log(anVar);
    }
}
