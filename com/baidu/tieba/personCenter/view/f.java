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
/* loaded from: classes6.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.g> {
    private TextView elu;
    private ImageView jdC;
    private View jeb;
    private ImageView jec;
    private TextView jed;
    private ImageView jee;
    private TextView jef;
    private TextView jeg;
    private View jeh;
    private View jei;
    private com.baidu.tieba.personCenter.data.g jej;
    private i jek;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jeb = view.findViewById(R.id.item_content);
        this.jeh = view.findViewById(R.id.function_item_bottom_divider);
        this.jei = view.findViewById(R.id.function_item_bottom_divider_line);
        this.jec = (ImageView) view.findViewById(R.id.function_icon);
        this.jee = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.elu = (TextView) view.findViewById(R.id.function_title);
        this.jdC = (ImageView) view.findViewById(R.id.function_red_tip);
        this.jed = (TextView) view.findViewById(R.id.function_desc);
        this.jef = (TextView) view.findViewById(R.id.right_text);
        this.jeg = (TextView) view.findViewById(R.id.function_title_mark);
        this.jef.setOnClickListener(this);
        this.jeb.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SvgManager.aDW().a(this.jee, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.c(this.jeb, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            am.setImageResource(this.jdC, R.drawable.person_center_red_tip_shape);
            am.setBackgroundColor(this.jeh, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.jei, R.color.cp_bg_line_b);
            am.setViewTextColor(this.elu, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jed, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jef, (int) R.color.cp_cont_b);
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
            this.jej = gVar;
            this.mUserData = gVar.userData;
            this.jek = gVar.jda;
            this.elu.setText(gVar.title);
            csM();
            b(gVar);
            a(this.jek);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void csM() {
        if (this.jej.iconId > 0) {
            this.jec.setVisibility(0);
            if (this.jej.jcX) {
                if (this.jej.jcY) {
                    SvgManager.aDW().a(this.jec, this.jej.iconId, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                } else {
                    SvgManager.aDW().a(this.jec, this.jej.iconId, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                }
            }
            am.setImageResource(this.jec, this.jej.iconId);
            return;
        }
        this.jec.setVisibility(8);
    }

    private void b(com.baidu.tieba.personCenter.data.g gVar) {
        if (gVar.jcZ) {
            this.jeh.setVisibility(0);
        } else {
            this.jeh.setVisibility(8);
        }
    }

    private void a(i iVar) {
        if (iVar != null) {
            if (iVar.isShowRedTip) {
                this.jdC.setVisibility(0);
            } else {
                this.jdC.setVisibility(8);
            }
            if (!StringUtils.isNull(iVar.jde)) {
                this.jed.setVisibility(0);
                this.jed.setText(iVar.jde);
            } else {
                this.jed.setVisibility(8);
            }
            if (iVar.jdi) {
                this.jeg.setVisibility(0);
            } else {
                this.jeg.setVisibility(8);
            }
            if (!TextUtils.isEmpty(iVar.text)) {
                this.jef.setVisibility(0);
                this.jef.setText(iVar.text);
                this.jef.setCompoundDrawablesWithIntrinsicBounds(iVar.jdf, iVar.jdg, iVar.jdh, iVar.jdh);
                return;
            }
            this.jef.setVisibility(8);
            return;
        }
        this.jdC.setVisibility(8);
        this.jed.setVisibility(8);
        this.jef.setVisibility(8);
        this.jeg.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.jeb) {
                if (this.jej.type == 36 && "游戏".equals(this.jej.title) && this.fBx != null) {
                    this.fBx.a(view, this.jej);
                    return;
                } else {
                    csN();
                    return;
                }
            }
            cE(view);
        }
    }

    private void csN() {
        if (this.jej != null) {
            switch (this.jej.type) {
                case 10:
                    com.baidu.tieba.o.a.cBe().g(1, false, true);
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 13));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 16));
                    if (!StringUtils.isNull(this.jej.cHB)) {
                        ba.aEa().b(this.mTbPageContext, new String[]{this.jej.cHB});
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.o.a.cBe().g(7, false, true);
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
                    com.baidu.tieba.o.a.cBe().g(3, false, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 17:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 10));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 18:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 15));
                    ba.aEa().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
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
                    com.baidu.tieba.o.a.cBe().g(10, false, true);
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 19));
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 33:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 21));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.jej.jdb)));
                    return;
                case 36:
                    TiebaStatic.log(new an("c12524").Z("obj_locate", this.jej.itemId));
                    Ge(this.jej.cHB);
                    return;
                case 37:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 24));
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, true);
                    if (this.jej.jda != null) {
                        this.jej.jda.isShowRedTip = false;
                    }
                    this.jdC.setVisibility(8);
                    String string = com.baidu.tbadk.core.sharedPref.b.aCY().getString("cash_pay", "");
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
                            com.baidu.tieba.o.a.cBe().g(9, false, true);
                            ba.aEa().a(getTbPageContext(), new String[]{h5Url}, true);
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
                    com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("key_baidu_financial_has_clicked", true);
                    if (this.jej.jda != null) {
                        this.jej.jda.isShowRedTip = false;
                    }
                    this.jdC.setVisibility(8);
                    MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
                    return;
                case 43:
                    bKP();
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                    return;
                case 44:
                    TiebaStatic.log(new an("c12523").Z("obj_locate", 26));
                    if (!TextUtils.isEmpty(this.jej.cHB)) {
                        ba.aEa().b(this.mTbPageContext, new String[]{this.jej.cHB});
                    }
                    if (aq.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                        TiebaStatic.log(new an("c13274").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", getContext().getString(R.string.baidu_lite_game_center)).cp("obj_id", "11811875").cp("obj_source", "smallgame_center").Z("obj_param1", 0));
                        return;
                    } else {
                        TiebaStatic.log(new an("c13274").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", getContext().getString(R.string.third_lite_game_center)).cp("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).cp("obj_source", "smallgame_center").Z("obj_param1", 0));
                        return;
                    }
                case 45:
                    if (!TextUtils.isEmpty(this.jej.cHB)) {
                        com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.jej.cHB);
                    }
                    an.tb("c13548").aDT();
                    return;
            }
        }
    }

    private void cE(View view) {
        if (this.jej != null && view == this.jef) {
            switch (this.jej.type) {
                case 10:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 45:
                    if (this.jek != null && !TextUtils.isEmpty(this.jek.linkUrl)) {
                        ba.aEa().b(this.mTbPageContext, new String[]{this.jek.linkUrl});
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Gd(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                ba.aEa().b(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                com.baidu.tbadk.browser.a.startWebActivity((Context) this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void Ge(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                Gd(str);
            } else if (str.startsWith("nohead:url")) {
                ba.aEa().b(this.mTbPageContext, new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ba.aEa().b(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void bKP() {
        an anVar = new an("c13422");
        anVar.Z("obj_type", 2);
        anVar.Z("obj_locate", 5);
        TiebaStatic.log(anVar);
    }
}
