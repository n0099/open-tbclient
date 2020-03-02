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
    private TextView eqF;
    private View jiE;
    private ImageView jiF;
    private TextView jiG;
    private ImageView jiH;
    private TextView jiI;
    private TextView jiJ;
    private View jiK;
    private View jiL;
    private com.baidu.tieba.personCenter.c.g jiM;
    private i jiN;
    private ImageView jif;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jiE = view.findViewById(R.id.item_content);
        this.jiK = view.findViewById(R.id.function_item_bottom_divider);
        this.jiL = view.findViewById(R.id.function_item_bottom_divider_line);
        this.jiF = (ImageView) view.findViewById(R.id.function_icon);
        this.jiH = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.eqF = (TextView) view.findViewById(R.id.function_title);
        this.jif = (ImageView) view.findViewById(R.id.function_red_tip);
        this.jiG = (TextView) view.findViewById(R.id.function_desc);
        this.jiI = (TextView) view.findViewById(R.id.right_text);
        this.jiJ = (TextView) view.findViewById(R.id.function_title_mark);
        this.jiI.setOnClickListener(this);
        this.jiE.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SvgManager.aGC().a(this.jiH, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.c(this.jiE, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            am.setImageResource(this.jif, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.jiK, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.jiL, R.color.cp_bg_line_b);
            am.setViewTextColor(this.eqF, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jiG, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jiI, (int) R.color.cp_cont_b);
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
            this.jiM = gVar;
            this.mUserData = gVar.userData;
            this.jiN = gVar.jhD;
            this.eqF.setText(gVar.title);
            cvq();
            b(gVar);
            a(this.jiN);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void cvq() {
        if (this.jiM.iconId > 0) {
            this.jiF.setVisibility(0);
            if (this.jiM.jhA) {
                if (this.jiM.jhB) {
                    SvgManager.aGC().a(this.jiF, this.jiM.iconId, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                } else {
                    SvgManager.aGC().a(this.jiF, this.jiM.iconId, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                }
            }
            am.setImageResource(this.jiF, this.jiM.iconId);
            return;
        }
        this.jiF.setVisibility(8);
    }

    private void b(com.baidu.tieba.personCenter.c.g gVar) {
        if (gVar.jhC) {
            this.jiK.setVisibility(0);
        } else {
            this.jiK.setVisibility(8);
        }
    }

    private void a(i iVar) {
        if (iVar != null) {
            if (iVar.isShowRedTip) {
                this.jif.setVisibility(0);
            } else {
                this.jif.setVisibility(8);
            }
            if (!StringUtils.isNull(iVar.jhH)) {
                this.jiG.setVisibility(0);
                this.jiG.setText(iVar.jhH);
            } else {
                this.jiG.setVisibility(8);
            }
            if (iVar.jhL) {
                this.jiJ.setVisibility(0);
            } else {
                this.jiJ.setVisibility(8);
            }
            if (!TextUtils.isEmpty(iVar.text)) {
                this.jiI.setVisibility(0);
                this.jiI.setText(iVar.text);
                this.jiI.setCompoundDrawablesWithIntrinsicBounds(iVar.jhI, iVar.jhJ, iVar.jhK, iVar.jhK);
                return;
            }
            this.jiI.setVisibility(8);
            return;
        }
        this.jif.setVisibility(8);
        this.jiG.setVisibility(8);
        this.jiI.setVisibility(8);
        this.jiJ.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jiE) {
                if (this.jiM.type == 36 && "游戏".equals(this.jiM.title) && this.fHh != null) {
                    this.fHh.a(view, this.jiM);
                    return;
                } else {
                    cvr();
                    return;
                }
            }
            cK(view);
        }
    }

    private void cvr() {
        if (this.jiM != null) {
            switch (this.jiM.type) {
                case 10:
                    com.baidu.tieba.p.a.cDP().g(1, false, true);
                    TiebaStatic.log(new an("c12523").X("obj_locate", 13));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 16));
                    if (!StringUtils.isNull(this.jiM.cLR)) {
                        ba.aGG().b(this.mTbPageContext, new String[]{this.jiM.cLR});
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.p.a.cDP().g(7, false, true);
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
                    com.baidu.tieba.p.a.cDP().g(3, false, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 17:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 10));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 18:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 15));
                    ba.aGG().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
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
                    com.baidu.tieba.p.a.cDP().g(10, false, true);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
                    TiebaStatic.log(new an("c12523").X("obj_locate", 19));
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 33:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 21));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.jiM.jhE)));
                    return;
                case 36:
                    TiebaStatic.log(new an("c12524").X("obj_locate", this.jiM.itemId));
                    GC(this.jiM.cLR);
                    return;
                case 37:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 24));
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, true);
                    if (this.jiM.jhD != null) {
                        this.jiM.jhD.isShowRedTip = false;
                    }
                    this.jif.setVisibility(8);
                    String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("cash_pay", "");
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
                            com.baidu.tieba.p.a.cDP().g(9, false, true);
                            ba.aGG().a(getTbPageContext(), new String[]{h5Url}, true);
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
                    com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_baidu_financial_has_clicked", true);
                    if (this.jiM.jhD != null) {
                        this.jiM.jhD.isShowRedTip = false;
                    }
                    this.jif.setVisibility(8);
                    MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
                    return;
                case 43:
                    bNz();
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                    return;
                case 44:
                    TiebaStatic.log(new an("c12523").X("obj_locate", 26));
                    if (!TextUtils.isEmpty(this.jiM.cLR)) {
                        ba.aGG().b(this.mTbPageContext, new String[]{this.jiM.cLR});
                    }
                    if (aq.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                        TiebaStatic.log(new an("c13274").cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", getContext().getString(R.string.baidu_lite_game_center)).cy("obj_id", "11811875").cy("obj_source", "smallgame_center").X("obj_param1", 0));
                        return;
                    } else {
                        TiebaStatic.log(new an("c13274").cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", getContext().getString(R.string.third_lite_game_center)).cy("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).cy("obj_source", "smallgame_center").X("obj_param1", 0));
                        return;
                    }
                case 45:
                    if (!TextUtils.isEmpty(this.jiM.cLR)) {
                        com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.jiM.cLR);
                    }
                    an.tv("c13548").aGz();
                    return;
                case 46:
                    ba.aGG().a(this.mTbPageContext, new String[]{this.jiM.cLR}, true);
                    return;
            }
        }
    }

    private void cK(View view) {
        if (this.jiM != null && view == this.jiI) {
            switch (this.jiM.type) {
                case 10:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 45:
                    if (this.jiN != null && !TextUtils.isEmpty(this.jiN.linkUrl)) {
                        ba.aGG().b(this.mTbPageContext, new String[]{this.jiN.linkUrl});
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
                ba.aGG().b(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
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
                ba.aGG().b(this.mTbPageContext, new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ba.aGG().b(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void bNz() {
        an anVar = new an("c13422");
        anVar.X("obj_type", 2);
        anVar.X("obj_locate", 5);
        TiebaStatic.log(anVar);
    }
}
