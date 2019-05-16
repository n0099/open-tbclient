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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.data.i;
/* loaded from: classes4.dex */
public class f extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.g> {
    private View bMQ;
    private TextView dqM;
    private final String ieP;
    private ImageView ieQ;
    private ImageView ieR;
    private TextView ieS;
    private TextView ieT;
    private com.baidu.tieba.personCenter.data.g ieU;
    private ImageView ieq;
    private int mSkinType;
    private UserData mUserData;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ieP = "f3TuxsL47kihWbLdWMiymiYwChMr52Rd";
        this.mSkinType = 3;
        View view = getView();
        this.ieQ = (ImageView) view.findViewById(R.id.function_icon);
        this.ieR = (ImageView) view.findViewById(R.id.function_right_arrow);
        this.dqM = (TextView) view.findViewById(R.id.function_title);
        this.bMQ = view.findViewById(R.id.function_item_bottom_divider);
        this.ieq = (ImageView) view.findViewById(R.id.function_red_tip);
        this.ieS = (TextView) view.findViewById(R.id.function_desc);
        this.ieT = (TextView) view.findViewById(R.id.tbean_num);
        view.setOnClickListener(this);
        this.ieT.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ieR.setImageDrawable(al.S(i, R.drawable.icon_arrow_gray_right_n));
            al.j(this.dqM, R.color.cp_cont_b);
            al.l(this.bMQ, R.color.cp_bg_line_e);
            al.k(getView(), R.drawable.person_center_action_item_selector);
            this.ieq.setImageDrawable(al.S(i, R.drawable.person_center_red_tip_shape));
            al.j(this.ieS, R.color.cp_cont_d);
            al.j(this.ieT, R.color.cp_cont_b);
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
            this.ieU = gVar;
            this.mUserData = gVar.userData;
            this.dqM.setText(gVar.title);
            if (gVar.iconId != 0) {
                this.ieQ.setVisibility(0);
                this.ieQ.setImageDrawable(al.S(TbadkCoreApplication.getInst().getSkinType(), gVar.iconId));
            } else {
                this.ieQ.setVisibility(8);
            }
            b(gVar);
            a(gVar.idQ);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.g gVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bMQ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.bMQ.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (gVar.idP) {
            layoutParams.height = (int) getContext().getResources().getDimension(R.dimen.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(R.dimen.ds1);
        }
        this.bMQ.setLayoutParams(layoutParams);
    }

    private void a(i iVar) {
        if (iVar != null) {
            if (iVar.isShowRedTip) {
                this.ieq.setVisibility(0);
            } else {
                this.ieq.setVisibility(8);
            }
            if (!StringUtils.isNull(iVar.idW)) {
                this.ieS.setVisibility(0);
                this.ieS.setText(iVar.idW);
            } else {
                this.ieS.setVisibility(8);
            }
            if (iVar.idU) {
                this.ieT.setVisibility(0);
                this.ieT.setText(ap.aU(iVar.idV));
                this.ieT.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.ieT.setVisibility(8);
            return;
        }
        this.ieq.setVisibility(8);
        this.ieS.setVisibility(8);
        this.ieT.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                if (this.ieU.type == 36 && "游戏".equals(this.ieU.title) && this.euT != null) {
                    this.euT.a(view, this.ieU);
                    return;
                } else {
                    bYv();
                    return;
                }
            }
            cH(view);
        }
    }

    private void bYv() {
        switch (this.ieU.type) {
            case 10:
                com.baidu.tieba.o.a.cfX().d(1, false, true);
                TiebaStatic.log(new am("c12523").P("obj_locate", 13));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new am("c12523").P("obj_locate", 16));
                if (!StringUtils.isNull(this.ieU.bCP)) {
                    ba.aiz().c(this.mTbPageContext, new String[]{this.ieU.bCP});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.o.a.cfX().d(7, false, true);
                TiebaStatic.log(new am("c12523").P("obj_locate", 12));
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
                TiebaStatic.log(new am("c12523").P("obj_locate", 9));
                com.baidu.tieba.o.a.cfX().d(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new am("c12523").P("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new am("c12523").P("obj_locate", 15));
                ba.aiz().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new am("c12523").P("obj_locate", 11));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                    return;
                }
                return;
            case 25:
                if (this.mUserData != null) {
                    TiebaStatic.log(new am("c12523").P("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 30:
                TiebaStatic.log(new am("c12523").P("obj_locate", 17));
                if (!com.baidu.tbadk.plugins.b.f(this.mTbPageContext)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all")));
                    return;
                }
                return;
            case 31:
                com.baidu.tieba.o.a.cfX().d(10, false, true);
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_feedback_tip_show", false);
                TiebaStatic.log(new am("c12523").P("obj_locate", 19));
                com.baidu.tbadk.browser.a.af(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new am("c12523").P("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.ieU.idR)));
                return;
            case 36:
                TiebaStatic.log(new am("c12524").P("obj_locate", this.ieU.itemId));
                BL(this.ieU.bCP);
                return;
            case 37:
                TiebaStatic.log(new am("c12523").P("obj_locate", 24));
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_has_borrow_cash_clicked", true);
                if (this.ieU.idQ != null) {
                    this.ieU.idQ.isShowRedTip = false;
                }
                this.ieq.setVisibility(8);
                String string = com.baidu.tbadk.core.sharedPref.b.agM().getString("cash_pay", "");
                if (!StringUtils.isNull(string)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, string));
                    return;
                }
                return;
            case 38:
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.akM()) {
                    String akO = activityPrizeData.akO();
                    if (!StringUtils.isNull(akO)) {
                        TiebaStatic.log(new am("c12598"));
                        com.baidu.tieba.o.a.cfX().d(9, false, true);
                        ba.aiz().a(getTbPageContext(), new String[]{akO}, true);
                        return;
                    }
                    return;
                }
                return;
            case 39:
                com.baidu.tbadk.browser.a.a(true, this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(R.string.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                TiebaStatic.log(new am("c12523").P("obj_locate", 25));
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_baidu_financial_has_clicked", true);
                if (this.ieU.idQ != null) {
                    this.ieU.idQ.isShowRedTip = false;
                }
                this.ieq.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                return;
            case 43:
                btp();
                com.baidu.tbadk.browser.a.af(this.mTbPageContext.getPageActivity(), "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=2&source=2-101-1&idfrom=2&tbioswk=1");
                return;
            case 44:
                TiebaStatic.log(new am("c12523").P("obj_locate", 26));
                if (ap.isEmpty(TbSingleton.getInstance().getProfileGameCenterKey()) || "f3TuxsL47kihWbLdWMiymiYwChMr52Rd".equals(TbSingleton.getInstance().getProfileGameCenterKey())) {
                    com.baidu.tieba.aiapps.a.b("f3TuxsL47kihWbLdWMiymiYwChMr52Rd", null, "1191000700000000", 0);
                    TiebaStatic.log(new am("c13274").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", getContext().getString(R.string.baidu_lite_game_center)).bT(VideoPlayActivityConfig.OBJ_ID, "11811875").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "smallgame_center").P("obj_param1", 0));
                    return;
                }
                com.baidu.tieba.aiapps.a.b(TbSingleton.getInstance().getProfileGameCenterKey(), null, "1191000700000000", 0);
                TiebaStatic.log(new am("c13274").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", getContext().getString(R.string.third_lite_game_center)).bT(VideoPlayActivityConfig.OBJ_ID, TbSingleton.getInstance().getProfileGameCenterKey()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "smallgame_center").P("obj_param1", 0));
                return;
        }
    }

    private void cH(View view) {
        if (view == this.ieT) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    private void BK(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.cosume_record_plugin_not_install_tip);
                    return;
                }
                ba.aiz().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    private void BL(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                BK(str);
            } else if (str.startsWith("nohead:url")) {
                ba.aiz().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ba.aiz().c(this.mTbPageContext, new String[]{str});
            }
        }
    }

    private void btp() {
        am amVar = new am("c13422");
        amVar.P("obj_type", 2);
        amVar.P("obj_locate", 5);
        TiebaStatic.log(amVar);
    }
}
