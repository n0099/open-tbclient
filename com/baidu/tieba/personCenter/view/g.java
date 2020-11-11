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
/* loaded from: classes22.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.personCenter.c.h> {
    private TextView goZ;
    private ImageView jot;
    private View lXb;
    private ImageView lXc;
    private ImageView lXd;
    private TextView lXe;
    private TextView lXf;
    private TextView lXg;
    private View lXh;
    private View lXi;
    private com.baidu.tieba.personCenter.c.h lXj;
    private j lXk;
    private int mSkinType;
    private UserData mUserData;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.lXb = view.findViewById(R.id.item_content);
        this.lXh = view.findViewById(R.id.function_item_bottom_divider);
        this.lXi = view.findViewById(R.id.function_item_bottom_divider_line);
        this.lXc = (ImageView) view.findViewById(R.id.function_icon);
        this.jot = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.goZ = (TextView) view.findViewById(R.id.function_title);
        this.lXd = (ImageView) view.findViewById(R.id.function_red_tip);
        this.lXe = (TextView) view.findViewById(R.id.function_desc);
        this.lXf = (TextView) view.findViewById(R.id.right_text);
        this.lXg = (TextView) view.findViewById(R.id.function_title_mark);
        this.lXf.setOnClickListener(this);
        this.lXb.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SvgManager.brn().a(this.jot, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.g(this.lXb, R.color.cp_bg_line_e, R.color.cp_bg_line_c);
            ap.setImageResource(this.lXd, R.drawable.person_center_red_tip_shape);
            ap.setBackgroundColor(this.lXh, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.lXi, R.color.cp_bg_line_b);
            ap.setViewTextColor(this.goZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.lXe, R.color.cp_cont_d);
            ap.setViewTextColor(this.lXf, R.color.cp_cont_b);
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
            this.lXj = hVar;
            this.mUserData = hVar.userData;
            this.lXk = hVar.lVU;
            this.goZ.setText(hVar.title);
            dtL();
            b(hVar);
            a(this.lXk);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void dtL() {
        if (this.lXj.gbi > 0) {
            this.lXc.setVisibility(0);
            if (this.lXj.lVR) {
                if (this.lXj.lVS) {
                    SvgManager.brn().a(this.lXc, this.lXj.gbi, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                } else {
                    SvgManager.brn().a(this.lXc, this.lXj.gbi, SvgManager.SvgResourceStateType.NORMAL);
                    return;
                }
            }
            ap.setImageResource(this.lXc, this.lXj.gbi);
            return;
        }
        this.lXc.setVisibility(8);
    }

    private void b(com.baidu.tieba.personCenter.c.h hVar) {
        if (hVar.lVT) {
            this.lXh.setVisibility(0);
        } else {
            this.lXh.setVisibility(8);
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            if (jVar.isShowRedTip) {
                this.lXd.setVisibility(0);
            } else {
                this.lXd.setVisibility(8);
            }
            if (!StringUtils.isNull(jVar.lVY)) {
                this.lXe.setVisibility(0);
                this.lXe.setText(jVar.lVY);
            } else {
                this.lXe.setVisibility(8);
            }
            if (jVar.lWc) {
                this.lXg.setVisibility(0);
            } else {
                this.lXg.setVisibility(8);
            }
            if (!TextUtils.isEmpty(jVar.text)) {
                this.lXf.setVisibility(0);
                this.lXf.setText(jVar.text);
                this.lXf.setCompoundDrawablesWithIntrinsicBounds(jVar.lVZ, jVar.lWa, jVar.lWb, jVar.lWb);
                return;
            }
            this.lXf.setVisibility(8);
            return;
        }
        this.lXd.setVisibility(8);
        this.lXe.setVisibility(8);
        this.lXf.setVisibility(8);
        this.lXg.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view == this.lXb) {
                if (this.lXj.type == 36 && "游戏".equals(this.lXj.title) && this.hVC != null) {
                    this.hVC.a(view, this.lXj);
                    return;
                } else {
                    dtM();
                    return;
                }
            }
            dz(view);
        }
    }

    private void dtM() {
        if (this.lXj != null) {
            switch (this.lXj.type) {
                case 10:
                    com.baidu.tieba.p.a.dBY().h(1, false, true);
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 13));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                        return;
                    }
                    return;
                case 11:
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 16));
                    if (!StringUtils.isNull(this.lXj.aIk)) {
                        be.brr().b(this.mTbPageContext, new String[]{this.lXj.aIk});
                        return;
                    }
                    return;
                case 12:
                    com.baidu.tieba.p.a.dBY().h(7, false, true);
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 12));
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
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 9));
                    com.baidu.tieba.p.a.dBY().h(3, false, true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 17:
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 10));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                    return;
                case 18:
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 15));
                    be.brr().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                    return;
                case 22:
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 11));
                    if (this.mUserData != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                        return;
                    }
                    return;
                case 25:
                    if (this.mUserData != null) {
                        TiebaStatic.log(new aq("c12523").al("obj_locate", 18));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                        return;
                    }
                    return;
                case 30:
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 17));
                    if (!com.baidu.tbadk.plugins.b.k(this.mTbPageContext)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all")));
                        return;
                    }
                    return;
                case 31:
                    com.baidu.tieba.p.a.dBY().h(10, false, true);
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 19));
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                    return;
                case 33:
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 21));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.lXj.lVV)));
                    return;
                case 36:
                    TiebaStatic.log(new aq("c12524").al("obj_locate", this.lXj.itemId));
                    Qp(this.lXj.aIk);
                    return;
                case 37:
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 24));
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, true);
                    if (this.lXj.lVU != null) {
                        this.lXj.lVU.isShowRedTip = false;
                    }
                    this.lXd.setVisibility(8);
                    String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("cash_pay", "");
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
                            com.baidu.tieba.p.a.dBY().h(9, false, true);
                            be.brr().a(getTbPageContext(), new String[]{h5Url}, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 39:
                    com.baidu.tbadk.browser.a.startWebActivity(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                    return;
                case 41:
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 25));
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_baidu_financial_has_clicked", true);
                    if (this.lXj.lVU != null) {
                        this.lXj.lVU.isShowRedTip = false;
                    }
                    this.lXd.setVisibility(8);
                    MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
                    return;
                case 43:
                    cJo();
                    com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                    return;
                case 44:
                    TiebaStatic.log(new aq("c12523").al("obj_locate", 26));
                    if (!TextUtils.isEmpty(this.lXj.aIk)) {
                        be.brr().b(this.mTbPageContext, new String[]{this.lXj.aIk});
                    }
                    if (at.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                        TiebaStatic.log(new aq("c13274").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", getContext().getString(R.string.baidu_lite_game_center)).dR("obj_id", "11811875").dR("obj_source", "smallgame_center").al("obj_param1", 0));
                        return;
                    } else {
                        TiebaStatic.log(new aq("c13274").dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", getContext().getString(R.string.third_lite_game_center)).dR("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).dR("obj_source", "smallgame_center").al("obj_param1", 0));
                        return;
                    }
                case 45:
                    if (!TextUtils.isEmpty(this.lXj.aIk)) {
                        com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.lXj.aIk);
                    }
                    aq.BT("c13548").brk();
                    return;
                case 46:
                    be.brr().a(this.mTbPageContext, new String[]{this.lXj.aIk}, true);
                    return;
            }
        }
    }

    private void dz(View view) {
        if (this.lXj != null && view == this.lXf) {
            switch (this.lXj.type) {
                case 10:
                    BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
                    buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
                    return;
                case 45:
                    if (this.lXk != null && !TextUtils.isEmpty(this.lXk.linkUrl)) {
                        be.brr().b(this.mTbPageContext, new String[]{this.lXk.linkUrl});
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void Qo(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                be.brr().b(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                com.baidu.tbadk.browser.a.startWebActivity((Context) this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void Qp(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                Qo(str);
            } else if (str.startsWith("nohead:url")) {
                be.brr().b(this.mTbPageContext, new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                be.brr().b(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void cJo() {
        aq aqVar = new aq("c13422");
        aqVar.al("obj_type", 2);
        aqVar.al("obj_locate", 5);
        TiebaStatic.log(aqVar);
    }
}
