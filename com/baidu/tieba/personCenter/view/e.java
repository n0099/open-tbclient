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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.data.h;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.f> {
    private TextView bCY;
    private View ebn;
    private ImageView gcK;
    private ImageView gcL;
    private TextView gcM;
    private TextView gcN;
    private com.baidu.tieba.personCenter.data.f gcO;
    private ImageView gcv;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gcK = (ImageView) view.findViewById(e.g.function_icon);
        this.gcL = (ImageView) view.findViewById(e.g.function_right_arrow);
        this.bCY = (TextView) view.findViewById(e.g.function_title);
        this.ebn = view.findViewById(e.g.function_item_bottom_divider);
        this.gcv = (ImageView) view.findViewById(e.g.function_red_tip);
        this.gcM = (TextView) view.findViewById(e.g.function_desc);
        this.gcN = (TextView) view.findViewById(e.g.tbean_num);
        view.setOnClickListener(this);
        this.gcN.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.gcL.setImageDrawable(al.x(i, e.f.icon_arrow_gray_right_n));
            al.h(this.bCY, e.d.cp_cont_b);
            al.j(this.ebn, e.d.cp_bg_line_e);
            al.i(getView(), e.f.person_center_action_item_selector);
            this.gcv.setImageDrawable(al.x(i, e.f.person_center_red_tip_shape));
            al.h(this.gcM, e.d.cp_cont_d);
            al.h(this.gcN, e.d.cp_cont_b);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.person_center_function_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null) {
            this.gcO = fVar;
            this.mUserData = fVar.fAd;
            this.bCY.setText(fVar.title);
            if (fVar.iconId != 0) {
                this.gcK.setVisibility(0);
                this.gcK.setImageDrawable(al.x(TbadkCoreApplication.getInst().getSkinType(), fVar.iconId));
            } else {
                this.gcK.setVisibility(8);
            }
            b(fVar);
            a(fVar.gca);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.f fVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.ebn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.ebn.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (fVar.gbZ) {
            layoutParams.height = (int) getContext().getResources().getDimension(e.C0141e.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(e.C0141e.ds1);
        }
        this.ebn.setLayoutParams(layoutParams);
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.gce) {
                this.gcv.setVisibility(0);
            } else {
                this.gcv.setVisibility(8);
            }
            if (!StringUtils.isNull(hVar.gch)) {
                this.gcM.setVisibility(0);
                this.gcM.setText(hVar.gch);
            } else {
                this.gcM.setVisibility(8);
            }
            if (hVar.gcf) {
                this.gcN.setVisibility(0);
                this.gcN.setText(ao.R(hVar.gcg));
                this.gcN.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.gcN.setVisibility(8);
            return;
        }
        this.gcv.setVisibility(8);
        this.gcM.setVisibility(8);
        this.gcN.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                if (this.gcO.type == 36 && "游戏".equals(this.gcO.title) && this.cBW != null) {
                    this.cBW.a(view, this.gcO);
                    return;
                } else {
                    bkl();
                    return;
                }
            }
            bH(view);
        }
    }

    private void bkl() {
        switch (this.gcO.type) {
            case 10:
                com.baidu.tieba.o.a.brf().c(1, false, true);
                TiebaStatic.log(new am("c12523").w("obj_locate", 13));
                if (this.mUserData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new am("c12523").w("obj_locate", 16));
                if (!StringUtils.isNull(this.gcO.afi)) {
                    ay.AN().c(this.mTbPageContext, new String[]{this.gcO.afi});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.o.a.brf().c(7, false, true);
                TiebaStatic.log(new am("c12523").w("obj_locate", 12));
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
            default:
                return;
            case 16:
                TiebaStatic.log(new am("c12523").w("obj_locate", 9));
                com.baidu.tieba.o.a.brf().c(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new am("c12523").w("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new am("c12523").w("obj_locate", 15));
                ay.AN().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new am("c12523").w("obj_locate", 11));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                    return;
                }
                return;
            case 25:
                if (this.mUserData != null) {
                    TiebaStatic.log(new am("c12523").w("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 30:
                TiebaStatic.log(new am("c12523").w("obj_locate", 17));
                ay.AN().c(this.mTbPageContext, new String[]{"https://tieba.baidu.com/mo/q/hotMessage/list?cuid=" + TbadkCoreApplication.getInst().getCuid() + "&timestamp=" + System.currentTimeMillis() + "&_client_version=" + TbadkCoreApplication.getInst().getVersionName() + "&nohead=1"});
                return;
            case 31:
                com.baidu.tieba.o.a.brf().c(10, false, true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", false);
                TiebaStatic.log(new am("c12523").w("obj_locate", 19));
                com.baidu.tbadk.browser.a.ae(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new am("c12523").w("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.gcO.gcb)));
                return;
            case 36:
                TiebaStatic.log(new am("c12524").w("obj_locate", this.gcO.itemId));
                sv(this.gcO.afi);
                return;
            case 37:
                TiebaStatic.log(new am("c12523").w("obj_locate", 24));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_has_borrow_cash_clicked", true);
                if (this.gcO.gca != null) {
                    this.gcO.gca.gce = false;
                }
                this.gcv.setVisibility(8);
                if (TbadkCoreApplication.getInst().appResponseToCmd(2001447)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1"));
                    return;
                } else {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_pay_wallet_not_found);
                    return;
                }
            case 38:
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.CP()) {
                    String CR = activityPrizeData.CR();
                    if (!StringUtils.isNull(CR)) {
                        TiebaStatic.log(new am("c12598"));
                        com.baidu.tieba.o.a.brf().c(9, false, true);
                        ay.AN().a(getTbPageContext(), new String[]{CR}, true);
                        return;
                    }
                    return;
                }
                return;
            case 39:
                com.baidu.tbadk.browser.a.a(true, this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(e.j.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_baidu_financial_has_clicked", true);
                if (this.gcO.gca != null) {
                    this.gcO.gca.gce = false;
                }
                this.gcv.setVisibility(8);
                if (TbadkCoreApplication.getInst().appResponseToCmd(2001451)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                    return;
                } else {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.plugin_pay_wallet_not_found);
                    return;
                }
        }
    }

    private void bH(View view) {
        if (view == this.gcN) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    private void su(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), e.j.cosume_record_plugin_not_install_tip);
                    return;
                }
                ay.AN().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    private void sv(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                su(str);
            } else if (str.startsWith("nohead:url")) {
                ay.AN().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ay.AN().c(this.mTbPageContext, new String[]{str});
            }
        }
    }
}
