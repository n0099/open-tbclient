package com.baidu.tieba.personCenter.view;

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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.i;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.g> {
    private View bNX;
    private TextView dtd;
    private ImageView ilN;
    private final String imn;
    private ImageView imo;
    private ImageView imp;
    private TextView imq;
    private TextView imr;
    private TextView ims;
    private com.baidu.tieba.personCenter.data.g imt;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.imn = "f3TuxsL47kihWbLdWMiymiYwChMr52Rd";
        this.mSkinType = 3;
        View view = getView();
        this.imo = (ImageView) view.findViewById(R.id.function_icon);
        this.imp = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.dtd = (TextView) view.findViewById(R.id.function_title);
        this.bNX = view.findViewById(R.id.function_item_bottom_divider);
        this.ilN = (ImageView) view.findViewById(R.id.function_red_tip);
        this.imq = (TextView) view.findViewById(R.id.function_desc);
        this.imr = (TextView) view.findViewById(R.id.tbean_num);
        this.ims = (TextView) view.findViewById(R.id.function_title_mark);
        view.setOnClickListener(this);
        this.imr.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.imp.setImageDrawable(am.V(i, R.drawable.icon_arrow_gray_right_n));
            am.j(this.dtd, R.color.cp_cont_b);
            am.l(this.bNX, R.color.cp_bg_line_e);
            am.k(getView(), R.drawable.person_center_action_item_selector);
            this.ilN.setImageDrawable(am.V(i, R.drawable.person_center_red_tip_shape));
            am.j(this.imq, R.color.cp_cont_d);
            am.j(this.imr, R.color.cp_cont_b);
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
            this.imt = gVar;
            this.mUserData = gVar.userData;
            this.dtd.setText(gVar.title);
            if (gVar.ilk != 0) {
                this.imo.setVisibility(0);
                this.imo.setImageDrawable(am.V(TbadkCoreApplication.getInst().getSkinType(), gVar.ilk));
            } else {
                this.imo.setVisibility(8);
            }
            b(gVar);
            a(gVar.ilm);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.g gVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bNX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.bNX.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (gVar.ill) {
            layoutParams.height = (int) getContext().getResources().getDimension(R.dimen.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(R.dimen.ds1);
        }
        this.bNX.setLayoutParams(layoutParams);
    }

    private void a(i iVar) {
        if (iVar != null) {
            if (iVar.isShowRedTip) {
                this.ilN.setVisibility(0);
            } else {
                this.ilN.setVisibility(8);
            }
            if (!StringUtils.isNull(iVar.ils)) {
                this.imq.setVisibility(0);
                this.imq.setText(iVar.ils);
            } else {
                this.imq.setVisibility(8);
                if (iVar.ilt) {
                    this.ims.setVisibility(0);
                }
            }
            if (iVar.ilq) {
                this.imr.setVisibility(0);
                this.imr.setText(aq.aV(iVar.ilr));
                this.imr.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.imr.setVisibility(8);
            return;
        }
        this.ilN.setVisibility(8);
        this.imq.setVisibility(8);
        this.imr.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                if (this.imt.type == 36 && "游戏".equals(this.imt.title) && this.eAa != null) {
                    this.eAa.a(view, this.imt);
                    return;
                } else {
                    cbG();
                    return;
                }
            }
            cM(view);
        }
    }

    private void cbG() {
        switch (this.imt.type) {
            case 10:
                com.baidu.tieba.o.a.cjj().e(1, false, true);
                TiebaStatic.log(new an("c12523").P("obj_locate", 13));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new an("c12523").P("obj_locate", 16));
                if (!StringUtils.isNull(this.imt.bDN)) {
                    bb.ajE().c(this.mTbPageContext, new String[]{this.imt.bDN});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.o.a.cjj().e(7, false, true);
                TiebaStatic.log(new an("c12523").P("obj_locate", 12));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MembercenterActivityConfig(this.mTbPageContext.getPageActivity())));
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
                TiebaStatic.log(new an("c12523").P("obj_locate", 9));
                com.baidu.tieba.o.a.cjj().e(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new an("c12523").P("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new an("c12523").P("obj_locate", 15));
                bb.ajE().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new an("c12523").P("obj_locate", 11));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                    return;
                }
                return;
            case 25:
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").P("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 30:
                TiebaStatic.log(new an("c12523").P("obj_locate", 17));
                if (!com.baidu.tbadk.plugins.b.f(this.mTbPageContext)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all")));
                    return;
                }
                return;
            case 31:
                com.baidu.tieba.o.a.cjj().e(10, false, true);
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("key_feedback_tip_show", false);
                TiebaStatic.log(new an("c12523").P("obj_locate", 19));
                com.baidu.tbadk.browser.a.ae(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new an("c12523").P("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.imt.iln)));
                return;
            case 36:
                TiebaStatic.log(new an("c12524").P("obj_locate", this.imt.itemId));
                CB(this.imt.bDN);
                return;
            case 37:
                TiebaStatic.log(new an("c12523").P("obj_locate", 24));
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("key_has_borrow_cash_clicked", true);
                if (this.imt.ilm != null) {
                    this.imt.ilm.isShowRedTip = false;
                }
                this.ilN.setVisibility(8);
                String string = com.baidu.tbadk.core.sharedPref.b.ahQ().getString("cash_pay", "");
                if (!StringUtils.isNull(string)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, string));
                    return;
                }
                return;
            case 38:
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.alT()) {
                    String alV = activityPrizeData.alV();
                    if (!StringUtils.isNull(alV)) {
                        TiebaStatic.log(new an("c12598"));
                        com.baidu.tieba.o.a.cjj().e(9, false, true);
                        bb.ajE().a(getTbPageContext(), new String[]{alV}, true);
                        return;
                    }
                    return;
                }
                return;
            case 39:
                com.baidu.tbadk.browser.a.a(true, this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                TiebaStatic.log(new an("c12523").P("obj_locate", 25));
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("key_baidu_financial_has_clicked", true);
                if (this.imt.ilm != null) {
                    this.imt.ilm.isShowRedTip = false;
                }
                this.ilN.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                return;
            case 43:
                bvJ();
                com.baidu.tbadk.browser.a.ae(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                return;
            case 44:
                TiebaStatic.log(new an("c12523").P("obj_locate", 26));
                if (aq.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                    com.baidu.tieba.aiapps.a.b("f3TuxsL47kihWbLdWMiymiYwChMr52Rd", null, "1191000700000000", 0);
                    TiebaStatic.log(new an("c13274").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", getContext().getString(R.string.baidu_lite_game_center)).bT(VideoPlayActivityConfig.OBJ_ID, "11811875").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "smallgame_center").P("obj_param1", 0));
                    return;
                }
                com.baidu.tieba.aiapps.a.b(TbSingleton.getInstance().getProfileGameCenterKey(), null, "1191000700000000", 0);
                TiebaStatic.log(new an("c13274").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", getContext().getString(R.string.third_lite_game_center)).bT(VideoPlayActivityConfig.OBJ_ID, TbSingleton.getInstance().getProfileGameCenterKey()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "smallgame_center").P("obj_param1", 0));
                return;
        }
    }

    private void cM(View view) {
        if (view == this.imr) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    private void CA(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                bb.ajE().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    private void CB(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                CA(str);
            } else if (str.startsWith("nohead:url")) {
                bb.ajE().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                bb.ajE().c(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void bvJ() {
        an anVar = new an("c13422");
        anVar.P("obj_type", 2);
        anVar.P("obj_locate", 5);
        TiebaStatic.log(anVar);
    }
}
