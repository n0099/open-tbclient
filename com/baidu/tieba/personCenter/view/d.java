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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.g;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.e> {
    private TextView bwB;
    private View dRm;
    private ImageView fUW;
    private ImageView fVi;
    private ImageView fVj;
    private TextView fVk;
    private TextView fVl;
    private com.baidu.tieba.personCenter.data.e fVm;
    private int mSkinType;
    private UserData mUserData;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fVi = (ImageView) view.findViewById(d.g.function_icon);
        this.fVj = (ImageView) view.findViewById(d.g.function_right_arrow);
        this.bwB = (TextView) view.findViewById(d.g.function_title);
        this.dRm = view.findViewById(d.g.function_item_bottom_divider);
        this.fUW = (ImageView) view.findViewById(d.g.function_red_tip);
        this.fVk = (TextView) view.findViewById(d.g.function_desc);
        this.fVl = (TextView) view.findViewById(d.g.tbean_num);
        view.setOnClickListener(this);
        this.fVl.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.fVj.setImageDrawable(am.v(i, d.f.icon_arrow_gray_right_n));
            am.h(this.bwB, d.C0142d.cp_cont_b);
            am.j(this.dRm, d.C0142d.cp_bg_line_e);
            am.i(getView(), d.f.person_center_action_item_selector);
            this.fUW.setImageDrawable(am.v(i, d.f.person_center_red_tip_shape));
            am.h(this.fVk, d.C0142d.cp_cont_d);
            am.h(this.fVl, d.C0142d.cp_cont_b);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.person_center_function_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null) {
            this.fVm = eVar;
            this.mUserData = eVar.fso;
            this.bwB.setText(eVar.title);
            if (eVar.iconId != 0) {
                this.fVi.setVisibility(0);
                this.fVi.setImageDrawable(am.v(TbadkCoreApplication.getInst().getSkinType(), eVar.iconId));
            } else {
                this.fVi.setVisibility(8);
            }
            b(eVar);
            a(eVar.fUD);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.e eVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.dRm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.dRm.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (eVar.fUC) {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds1);
        }
        this.dRm.setLayoutParams(layoutParams);
    }

    private void a(g gVar) {
        if (gVar != null) {
            if (gVar.fUH) {
                this.fUW.setVisibility(0);
            } else {
                this.fUW.setVisibility(8);
            }
            if (!StringUtils.isNull(gVar.fUK)) {
                this.fVk.setVisibility(0);
                this.fVk.setText(gVar.fUK);
            } else {
                this.fVk.setVisibility(8);
            }
            if (gVar.fUI) {
                this.fVl.setVisibility(0);
                this.fVl.setText(ap.L(gVar.fUJ));
                this.fVl.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.fVl.setVisibility(8);
            return;
        }
        this.fUW.setVisibility(8);
        this.fVk.setVisibility(8);
        this.fVl.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                if (this.fVm.type == 36 && "游戏".equals(this.fVm.title) && this.ctG != null) {
                    this.ctG.a(view, this.fVm);
                    return;
                } else {
                    bju();
                    return;
                }
            }
            br(view);
        }
    }

    private void bju() {
        switch (this.fVm.type) {
            case 10:
                com.baidu.tieba.o.a.bpR().b(1, false, true);
                TiebaStatic.log(new an("c12523").r("obj_locate", 13));
                if (this.mUserData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new an("c12523").r("obj_locate", 16));
                if (!StringUtils.isNull(this.fVm.adc)) {
                    az.zV().c(this.mTbPageContext, new String[]{this.fVm.adc});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.o.a.bpR().b(7, false, true);
                TiebaStatic.log(new an("c12523").r("obj_locate", 12));
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
            default:
                return;
            case 16:
                TiebaStatic.log(new an("c12523").r("obj_locate", 9));
                com.baidu.tieba.o.a.bpR().b(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new an("c12523").r("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new an("c12523").r("obj_locate", 15));
                az.zV().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new an("c12523").r("obj_locate", 11));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                    return;
                }
                return;
            case 25:
                if (this.mUserData != null) {
                    TiebaStatic.log(new an("c12523").r("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 30:
                TiebaStatic.log(new an("c12523").r("obj_locate", 17));
                az.zV().c(this.mTbPageContext, new String[]{"https://tieba.baidu.com/mo/q/hotMessage/list?cuid=" + TbadkCoreApplication.getInst().getCuid() + "&timestamp=" + System.currentTimeMillis() + "&_client_version=" + TbadkCoreApplication.getInst().getVersionName() + "&nohead=1"});
                return;
            case 31:
                com.baidu.tieba.o.a.bpR().b(10, false, true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", false);
                TiebaStatic.log(new an("c12523").r("obj_locate", 19));
                com.baidu.tbadk.browser.a.O(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new an("c12523").r("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.fVm.fUE)));
                return;
            case 36:
                TiebaStatic.log(new an("c12524").r("obj_locate", this.fVm.itemId));
                rR(this.fVm.adc);
                return;
            case 37:
                TiebaStatic.log(new an("c12523").r("obj_locate", 24));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_has_borrow_cash_clicked", true);
                if (this.fVm.fUD != null) {
                    this.fVm.fUD.fUH = false;
                }
                this.fUW.setVisibility(8);
                if (TbadkCoreApplication.getInst().appResponseToCmd(2001447)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1"));
                    return;
                } else {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.plugin_pay_wallet_not_found);
                    return;
                }
            case 38:
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.BM()) {
                    String BO = activityPrizeData.BO();
                    if (!StringUtils.isNull(BO)) {
                        TiebaStatic.log(new an("c12598"));
                        com.baidu.tieba.o.a.bpR().b(9, false, true);
                        az.zV().a(ahZ(), new String[]{BO}, true);
                        return;
                    }
                    return;
                }
                return;
            case 39:
                com.baidu.tbadk.browser.a.a(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(d.k.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
        }
    }

    private void br(View view) {
        if (view == this.fVl) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    private void rQ(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), d.k.cosume_record_plugin_not_install_tip);
                    return;
                }
                az.zV().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    private void rR(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                rQ(str);
            } else if (str.startsWith("nohead:url")) {
                az.zV().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else if (str.startsWith("livequiz:")) {
                az.zV().a(this.mTbPageContext, new String[]{"https://tieba.baidu.com/mo/q/cash/accountBalancePage?nonavigationbar=1"}, false);
            } else {
                az.zV().c(this.mTbPageContext, new String[]{str});
            }
        }
    }
}
