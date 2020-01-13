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
import com.baidu.tieba.personCenter.data.i;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes7.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.g> {
    private TextView emq;
    private View jhD;
    private ImageView jhE;
    private TextView jhF;
    private ImageView jhG;
    private TextView jhH;
    private TextView jhI;
    private View jhJ;
    private View jhK;
    private com.baidu.tieba.personCenter.data.g jhL;
    private i jhM;
    private ImageView jhe;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jhD = view.findViewById(R.id.item_content);
        this.jhJ = view.findViewById(R.id.function_item_bottom_divider);
        this.jhK = view.findViewById(R.id.function_item_bottom_divider_line);
        this.jhE = (ImageView) view.findViewById(R.id.function_icon);
        this.jhG = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.emq = (TextView) view.findViewById(R.id.function_title);
        this.jhe = (ImageView) view.findViewById(R.id.function_red_tip);
        this.jhF = (TextView) view.findViewById(R.id.function_desc);
        this.jhH = (TextView) view.findViewById(R.id.right_text);
        this.jhI = (TextView) view.findViewById(R.id.function_title_mark);
        this.jhH.setOnClickListener(this);
        this.jhD.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SvgManager.aEp().a(this.jhG, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.c(this.jhD, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            am.setImageResource(this.jhe, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.jhJ, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.jhK, R.color.cp_bg_line_b);
            am.setViewTextColor(this.emq, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jhF, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jhH, (int) R.color.cp_cont_b);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.person_center_function_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.g gVar) {
        if (gVar != null) {
            this.jhL = gVar;
            this.mUserData = gVar.userData;
            this.jhM = gVar.jgD;
            this.emq.setText(gVar.title);
            ctT();
            b(gVar);
            a(this.jhM);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ctT() {
        if (this.jhL.iconId > 0) {
            this.jhE.setVisibility(0);
            if (this.jhL.jgA) {
                if (this.jhL.jgB) {
                    SvgManager.aEp().a(this.jhE, this.jhL.iconId, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                } else {
                    SvgManager.aEp().a(this.jhE, this.jhL.iconId, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                }
            }
            am.setImageResource(this.jhE, this.jhL.iconId);
            return;
        }
        this.jhE.setVisibility(8);
    }

    private void b(com.baidu.tieba.personCenter.data.g gVar) {
        if (gVar.jgC) {
            this.jhJ.setVisibility(0);
        } else {
            this.jhJ.setVisibility(8);
        }
    }

    private void a(i iVar) {
        if (iVar != null) {
            if (iVar.isShowRedTip) {
                this.jhe.setVisibility(0);
            } else {
                this.jhe.setVisibility(8);
            }
            if (!StringUtils.isNull(iVar.jgH)) {
                this.jhF.setVisibility(0);
                this.jhF.setText(iVar.jgH);
            } else {
                this.jhF.setVisibility(8);
            }
            if (iVar.jgL) {
                this.jhI.setVisibility(0);
            } else {
                this.jhI.setVisibility(8);
            }
            if (!TextUtils.isEmpty(iVar.text)) {
                this.jhH.setVisibility(0);
                this.jhH.setText(iVar.text);
                this.jhH.setCompoundDrawablesWithIntrinsicBounds(iVar.jgI, iVar.jgJ, iVar.jgK, iVar.jgK);
                return;
            }
            this.jhH.setVisibility(8);
            return;
        }
        this.jhe.setVisibility(8);
        this.jhF.setVisibility(8);
        this.jhH.setVisibility(8);
        this.jhI.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jhD) {
                if (this.jhL.type == 36 && "游戏".equals(this.jhL.title) && this.fEI != null) {
                    this.fEI.a(view, this.jhL);
                    return;
                } else {
                    ctU();
                    return;
                }
            }
            cJ(view);
        }
    }

    private void ctU() {
        if (this.jhL != null) {
            switch (this.jhL.type) {
                case 10:
                    com.baidu.tieba.o.a.cCk().g(1, false, true);
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 13));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 16));
                    if (!StringUtils.isNull(this.jhL.cHN)) {
                        ba.aEt().b(this.mTbPageContext, new String[]{this.jhL.cHN});
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.o.a.cCk().g(7, false, true);
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 12));
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
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 9));
                    com.baidu.tieba.o.a.cCk().g(3, false, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 17:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 10));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 18:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 15));
                    ba.aEt().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 22:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 11));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                        return;
                    }
                    return;
                case 25:
                    if (this.mUserData != null) {
                        TiebaStatic.log(new an("c12523").Z("obj_locate", 18));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                        return;
                    }
                    return;
                case 30:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 17));
                    if (!com.baidu.tbadk.plugins.b.h(this.mTbPageContext)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, SchemeCollecter.CLASSIFY_ALL)));
                        return;
                    }
                    return;
                case 31:
                    com.baidu.tieba.o.a.cCk().g(10, false, true);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 19));
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 33:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 21));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.jhL.jgE)));
                    return;
                case 36:
                    TiebaStatic.log(new an("c12524").Z("obj_locate", this.jhL.itemId));
                    Go(this.jhL.cHN);
                    return;
                case 37:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 24));
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, true);
                    if (this.jhL.jgD != null) {
                        this.jhL.jgD.isShowRedTip = false;
                    }
                    this.jhe.setVisibility(8);
                    String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("cash_pay", "");
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
                            com.baidu.tieba.o.a.cCk().g(9, false, true);
                            ba.aEt().a(getTbPageContext(), new String[]{h5Url}, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 39:
                    com.baidu.tbadk.browser.a.startWebActivity(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                    return;
                case 41:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 25));
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_baidu_financial_has_clicked", true);
                    if (this.jhL.jgD != null) {
                        this.jhL.jgD.isShowRedTip = false;
                    }
                    this.jhe.setVisibility(8);
                    MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
                    return;
                case 43:
                    bLU();
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                    return;
                case 44:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 26));
                    if (!TextUtils.isEmpty(this.jhL.cHN)) {
                        ba.aEt().b(this.mTbPageContext, new String[]{this.jhL.cHN});
                    }
                    if (aq.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                        TiebaStatic.log(new an("c13274").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", getContext().getString(R.string.baidu_lite_game_center)).cp("obj_id", "11811875").cp("obj_source", "smallgame_center").Z("obj_param1", 0));
                        return;
                    } else {
                        TiebaStatic.log(new an("c13274").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", getContext().getString(R.string.third_lite_game_center)).cp("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).cp("obj_source", "smallgame_center").Z("obj_param1", 0));
                        return;
                    }
                case 45:
                    if (!TextUtils.isEmpty(this.jhL.cHN)) {
                        com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.jhL.cHN);
                    }
                    an.tf("c13548").aEm();
                    return;
            }
        }
    }

    private void cJ(View view) {
        if (this.jhL != null && view == this.jhH) {
            switch (this.jhL.type) {
                case 10:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 45:
                    if (this.jhM != null && !TextUtils.isEmpty(this.jhM.linkUrl)) {
                        ba.aEt().b(this.mTbPageContext, new String[]{this.jhM.linkUrl});
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Gn(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                ba.aEt().b(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                com.baidu.tbadk.browser.a.startWebActivity((Context) this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void Go(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                Gn(str);
            } else if (str.startsWith("nohead:url")) {
                ba.aEt().b(this.mTbPageContext, new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ba.aEt().b(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void bLU() {
        an anVar = new an("c13422");
        anVar.Z("obj_type", 2);
        anVar.Z("obj_locate", 5);
        TiebaStatic.log(anVar);
    }
}
