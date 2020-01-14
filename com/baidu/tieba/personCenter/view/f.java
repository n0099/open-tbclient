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
    private View jhI;
    private ImageView jhJ;
    private TextView jhK;
    private ImageView jhL;
    private TextView jhM;
    private TextView jhN;
    private View jhO;
    private View jhP;
    private com.baidu.tieba.personCenter.data.g jhQ;
    private i jhR;
    private ImageView jhj;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jhI = view.findViewById(R.id.item_content);
        this.jhO = view.findViewById(R.id.function_item_bottom_divider);
        this.jhP = view.findViewById(R.id.function_item_bottom_divider_line);
        this.jhJ = (ImageView) view.findViewById(R.id.function_icon);
        this.jhL = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.emq = (TextView) view.findViewById(R.id.function_title);
        this.jhj = (ImageView) view.findViewById(R.id.function_red_tip);
        this.jhK = (TextView) view.findViewById(R.id.function_desc);
        this.jhM = (TextView) view.findViewById(R.id.right_text);
        this.jhN = (TextView) view.findViewById(R.id.function_title_mark);
        this.jhM.setOnClickListener(this);
        this.jhI.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SvgManager.aEp().a(this.jhL, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.c(this.jhI, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            am.setImageResource(this.jhj, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.jhO, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.jhP, R.color.cp_bg_line_b);
            am.setViewTextColor(this.emq, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jhK, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jhM, (int) R.color.cp_cont_b);
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
            this.jhQ = gVar;
            this.mUserData = gVar.userData;
            this.jhR = gVar.jgI;
            this.emq.setText(gVar.title);
            ctV();
            b(gVar);
            a(this.jhR);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ctV() {
        if (this.jhQ.iconId > 0) {
            this.jhJ.setVisibility(0);
            if (this.jhQ.jgF) {
                if (this.jhQ.jgG) {
                    SvgManager.aEp().a(this.jhJ, this.jhQ.iconId, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                } else {
                    SvgManager.aEp().a(this.jhJ, this.jhQ.iconId, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                }
            }
            am.setImageResource(this.jhJ, this.jhQ.iconId);
            return;
        }
        this.jhJ.setVisibility(8);
    }

    private void b(com.baidu.tieba.personCenter.data.g gVar) {
        if (gVar.jgH) {
            this.jhO.setVisibility(0);
        } else {
            this.jhO.setVisibility(8);
        }
    }

    private void a(i iVar) {
        if (iVar != null) {
            if (iVar.isShowRedTip) {
                this.jhj.setVisibility(0);
            } else {
                this.jhj.setVisibility(8);
            }
            if (!StringUtils.isNull(iVar.jgM)) {
                this.jhK.setVisibility(0);
                this.jhK.setText(iVar.jgM);
            } else {
                this.jhK.setVisibility(8);
            }
            if (iVar.jgQ) {
                this.jhN.setVisibility(0);
            } else {
                this.jhN.setVisibility(8);
            }
            if (!TextUtils.isEmpty(iVar.text)) {
                this.jhM.setVisibility(0);
                this.jhM.setText(iVar.text);
                this.jhM.setCompoundDrawablesWithIntrinsicBounds(iVar.jgN, iVar.jgO, iVar.jgP, iVar.jgP);
                return;
            }
            this.jhM.setVisibility(8);
            return;
        }
        this.jhj.setVisibility(8);
        this.jhK.setVisibility(8);
        this.jhM.setVisibility(8);
        this.jhN.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jhI) {
                if (this.jhQ.type == 36 && "游戏".equals(this.jhQ.title) && this.fEI != null) {
                    this.fEI.a(view, this.jhQ);
                    return;
                } else {
                    ctW();
                    return;
                }
            }
            cJ(view);
        }
    }

    private void ctW() {
        if (this.jhQ != null) {
            switch (this.jhQ.type) {
                case 10:
                    com.baidu.tieba.o.a.cCm().g(1, false, true);
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 13));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 16));
                    if (!StringUtils.isNull(this.jhQ.cHN)) {
                        ba.aEt().b(this.mTbPageContext, new String[]{this.jhQ.cHN});
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.o.a.cCm().g(7, false, true);
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
                    com.baidu.tieba.o.a.cCm().g(3, false, true);
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
                    com.baidu.tieba.o.a.cCm().g(10, false, true);
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 19));
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 33:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 21));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.jhQ.jgJ)));
                    return;
                case 36:
                    TiebaStatic.log(new an("c12524").Z("obj_locate", this.jhQ.itemId));
                    Go(this.jhQ.cHN);
                    return;
                case 37:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 24));
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, true);
                    if (this.jhQ.jgI != null) {
                        this.jhQ.jgI.isShowRedTip = false;
                    }
                    this.jhj.setVisibility(8);
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
                            com.baidu.tieba.o.a.cCm().g(9, false, true);
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
                    if (this.jhQ.jgI != null) {
                        this.jhQ.jgI.isShowRedTip = false;
                    }
                    this.jhj.setVisibility(8);
                    MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
                    return;
                case 43:
                    bLU();
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                    return;
                case 44:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 26));
                    if (!TextUtils.isEmpty(this.jhQ.cHN)) {
                        ba.aEt().b(this.mTbPageContext, new String[]{this.jhQ.cHN});
                    }
                    if (aq.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                        TiebaStatic.log(new an("c13274").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", getContext().getString(R.string.baidu_lite_game_center)).cp("obj_id", "11811875").cp("obj_source", "smallgame_center").Z("obj_param1", 0));
                        return;
                    } else {
                        TiebaStatic.log(new an("c13274").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", getContext().getString(R.string.third_lite_game_center)).cp("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).cp("obj_source", "smallgame_center").Z("obj_param1", 0));
                        return;
                    }
                case 45:
                    if (!TextUtils.isEmpty(this.jhQ.cHN)) {
                        com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.jhQ.cHN);
                    }
                    an.tf("c13548").aEm();
                    return;
            }
        }
    }

    private void cJ(View view) {
        if (this.jhQ != null && view == this.jhM) {
            switch (this.jhQ.type) {
                case 10:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 45:
                    if (this.jhR != null && !TextUtils.isEmpty(this.jhR.linkUrl)) {
                        ba.aEt().b(this.mTbPageContext, new String[]{this.jhR.linkUrl});
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
