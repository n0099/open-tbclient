package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.i;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.g> {
    private View ceJ;
    private TextView dAv;
    private ImageView ilG;
    private final String imh;
    private ImageView imi;
    private ImageView imj;
    private TextView imk;
    private TextView iml;
    private TextView imm;
    private com.baidu.tieba.personCenter.data.g imn;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.imh = "f3TuxsL47kihWbLdWMiymiYwChMr52Rd";
        this.mSkinType = 3;
        View view = getView();
        this.imi = (ImageView) view.findViewById(R.id.function_icon);
        this.imj = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.dAv = (TextView) view.findViewById(R.id.function_title);
        this.ceJ = view.findViewById(R.id.function_item_bottom_divider);
        this.ilG = (ImageView) view.findViewById(R.id.function_red_tip);
        this.imk = (TextView) view.findViewById(R.id.function_desc);
        this.iml = (TextView) view.findViewById(R.id.tbean_num);
        this.imm = (TextView) view.findViewById(R.id.function_title_mark);
        view.setOnClickListener(this);
        this.iml.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            SvgManager.amL().a(this.imj, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.dAv, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.ceJ, R.color.cp_bg_line_c);
            getView().setBackgroundDrawable(am.is(R.color.cp_bg_line_e));
            this.ilG.setImageDrawable(am.getDrawable(i, (int) R.drawable.person_center_red_tip_shape));
            am.setViewTextColor(this.imk, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.iml, (int) R.color.cp_cont_b);
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
            this.imn = gVar;
            this.mUserData = gVar.userData;
            this.dAv.setText(gVar.title);
            if (gVar.ilc != 0) {
                this.imi.setVisibility(0);
                if (this.imn.ild) {
                    SvgManager.amL().a(this.imi, this.imn.ilc, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL);
                } else {
                    am.setImageResource(this.imi, this.imn.ilc);
                }
            } else {
                this.imi.setVisibility(8);
            }
            b(gVar);
            a(gVar.ilf);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.g gVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.ceJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.ceJ.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (gVar.ile) {
            layoutParams.height = (int) getContext().getResources().getDimension(R.dimen.ds12);
        } else {
            layoutParams.height = 0;
        }
        this.ceJ.setLayoutParams(layoutParams);
    }

    private void a(i iVar) {
        if (iVar != null) {
            if (iVar.isShowRedTip) {
                this.ilG.setVisibility(0);
            } else {
                this.ilG.setVisibility(8);
            }
            if (!StringUtils.isNull(iVar.ill)) {
                this.imk.setVisibility(0);
                this.imk.setText(iVar.ill);
            } else {
                this.imk.setVisibility(8);
                if (iVar.ilm) {
                    this.imm.setVisibility(0);
                }
            }
            if (iVar.ilj) {
                this.iml.setVisibility(0);
                this.iml.setText(aq.formatNumForTdouDisPlay(iVar.ilk));
                this.iml.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.iml.setVisibility(8);
            return;
        }
        this.ilG.setVisibility(8);
        this.imk.setVisibility(8);
        this.iml.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                if (this.imn.type == 36 && "游戏".equals(this.imn.title) && this.eJA != null) {
                    this.eJA.a(view, this.imn);
                    return;
                } else {
                    bZu();
                    return;
                }
            }
            cI(view);
        }
    }

    private void bZu() {
        switch (this.imn.type) {
            case 10:
                com.baidu.tieba.o.a.chb().e(1, false, true);
                TiebaStatic.log(new an("c12523").O("obj_locate", 13));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new an("c12523").O("obj_locate", 16));
                if (!StringUtils.isNull(this.imn.bVl)) {
                    ba.amO().b(this.mTbPageContext, new String[]{this.imn.bVl});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.o.a.chb().e(7, false, true);
                TiebaStatic.log(new an("c12523").O("obj_locate", 12));
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
                TiebaStatic.log(new an("c12523").O("obj_locate", 9));
                com.baidu.tieba.o.a.chb().e(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new an("c12523").O("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new an("c12523").O("obj_locate", 15));
                ba.amO().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new an("c12523").O("obj_locate", 11));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                    return;
                }
                return;
            case 25:
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").O("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 30:
                TiebaStatic.log(new an("c12523").O("obj_locate", 17));
                if (!com.baidu.tbadk.plugins.b.f(this.mTbPageContext)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all")));
                    return;
                }
                return;
            case 31:
                com.baidu.tieba.o.a.chb().e(10, false, true);
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.KEY_FEEDBACK_TIP_SHOW, false);
                TiebaStatic.log(new an("c12523").O("obj_locate", 19));
                com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new an("c12523").O("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.imn.ilg)));
                return;
            case 36:
                TiebaStatic.log(new an("c12524").O("obj_locate", this.imn.itemId));
                Bt(this.imn.bVl);
                return;
            case 37:
                TiebaStatic.log(new an("c12523").O("obj_locate", 24));
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, true);
                if (this.imn.ilf != null) {
                    this.imn.ilf.isShowRedTip = false;
                }
                this.ilG.setVisibility(8);
                String string = com.baidu.tbadk.core.sharedPref.b.alP().getString("cash_pay", "");
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
                        com.baidu.tieba.o.a.chb().e(9, false, true);
                        ba.amO().a(getTbPageContext(), new String[]{h5Url}, true);
                        return;
                    }
                    return;
                }
                return;
            case 39:
                com.baidu.tbadk.browser.a.startWebActivity(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                TiebaStatic.log(new an("c12523").O("obj_locate", 25));
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("key_baidu_financial_has_clicked", true);
                if (this.imn.ilf != null) {
                    this.imn.ilf.isShowRedTip = false;
                }
                this.ilG.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SLUMDOG_MILLIONAIRE_SHARE_DIALOG_DISMISS));
                return;
            case 43:
                btA();
                com.baidu.tbadk.browser.a.startWebActivity(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                return;
            case 44:
                TiebaStatic.log(new an("c12523").O("obj_locate", 26));
                if (aq.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                    com.baidu.tieba.aiapps.a.b("f3TuxsL47kihWbLdWMiymiYwChMr52Rd", null, "1191000700000000", 0);
                    TiebaStatic.log(new an("c13274").bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", getContext().getString(R.string.baidu_lite_game_center)).bS("obj_id", "11811875").bS("obj_source", "smallgame_center").O("obj_param1", 0));
                    return;
                }
                com.baidu.tieba.aiapps.a.b(TbSingleton.getInstance().getProfileGameCenterKey(), null, "1191000700000000", 0);
                TiebaStatic.log(new an("c13274").bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", getContext().getString(R.string.third_lite_game_center)).bS("obj_id", TbSingleton.getInstance().getProfileGameCenterKey()).bS("obj_source", "smallgame_center").O("obj_param1", 0));
                return;
        }
    }

    private void cI(View view) {
        if (view == this.iml) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
        }
    }

    private void Bs(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                ba.amO().b(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
                com.baidu.tbadk.browser.a.startWebActivity((Context) this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void Bt(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                Bs(str);
            } else if (str.startsWith("nohead:url")) {
                ba.amO().b(this.mTbPageContext, new String[]{str.replaceFirst(UrlSchemaHelper.PREFIX_BOOK_TOWN, "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ba.amO().b(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void btA() {
        an anVar = new an("c13422");
        anVar.O("obj_type", 2);
        anVar.O("obj_locate", 5);
        TiebaStatic.log(anVar);
    }
}
