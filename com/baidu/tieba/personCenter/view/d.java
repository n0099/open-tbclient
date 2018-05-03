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
import com.baidu.tbadk.core.atomData.AlaQuestionHomeActivityConfig;
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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.g;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.e> {
    private TextView bmL;
    private View dBG;
    private ImageView fEH;
    private ImageView fEI;
    private TextView fEJ;
    private TextView fEK;
    private com.baidu.tieba.personCenter.data.e fEL;
    private ImageView fEv;
    private int mSkinType;
    private UserData mUserData;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view2 = getView();
        this.fEH = (ImageView) view2.findViewById(d.g.function_icon);
        this.fEI = (ImageView) view2.findViewById(d.g.function_right_arrow);
        this.bmL = (TextView) view2.findViewById(d.g.function_title);
        this.dBG = view2.findViewById(d.g.function_item_bottom_divider);
        this.fEv = (ImageView) view2.findViewById(d.g.function_red_tip);
        this.fEJ = (TextView) view2.findViewById(d.g.function_desc);
        this.fEK = (TextView) view2.findViewById(d.g.tbean_num);
        view2.setOnClickListener(this);
        this.fEK.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.fEI.setImageDrawable(ak.u(i, d.f.icon_arrow_gray_right_n));
            ak.h(this.bmL, d.C0126d.cp_cont_b);
            ak.j(this.dBG, d.C0126d.cp_bg_line_e);
            ak.i(getView(), d.f.person_center_action_item_selector);
            this.fEv.setImageDrawable(ak.u(i, d.f.person_center_red_tip_shape));
            ak.h(this.fEJ, d.C0126d.cp_cont_d);
            ak.h(this.fEK, d.C0126d.cp_cont_b);
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
            this.fEL = eVar;
            this.mUserData = eVar.fbS;
            this.bmL.setText(eVar.title);
            if (eVar.iconId != 0) {
                this.fEH.setVisibility(0);
                this.fEH.setImageDrawable(ak.u(TbadkCoreApplication.getInst().getSkinType(), eVar.iconId));
            } else {
                this.fEH.setVisibility(8);
            }
            b(eVar);
            a(eVar.fEc);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.e eVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.dBG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.dBG.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (eVar.fEb) {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds1);
        }
        this.dBG.setLayoutParams(layoutParams);
    }

    private void a(g gVar) {
        if (gVar != null) {
            if (gVar.fEg) {
                this.fEv.setVisibility(0);
            } else {
                this.fEv.setVisibility(8);
            }
            if (!StringUtils.isNull(gVar.fEj)) {
                this.fEJ.setVisibility(0);
                this.fEJ.setText(gVar.fEj);
            } else {
                this.fEJ.setVisibility(8);
            }
            if (gVar.fEh) {
                this.fEK.setVisibility(0);
                this.fEK.setText(an.H(gVar.fEi));
                this.fEK.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.fEK.setVisibility(8);
            return;
        }
        this.fEv.setVisibility(8);
        this.fEJ.setVisibility(8);
        this.fEK.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null) {
            if (view2.getId() == getView().getId()) {
                if (this.fEL.type == 36 && "游戏".equals(this.fEL.title) && this.clL != null) {
                    this.clL.a(view2, this.fEL);
                    return;
                } else {
                    bdO();
                    return;
                }
            }
            bn(view2);
        }
    }

    private void bdO() {
        switch (this.fEL.type) {
            case 10:
                com.baidu.tieba.n.a.bkt().b(1, false, true);
                TiebaStatic.log(new al("c12523").r("obj_locate", 13));
                if (this.mUserData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new al("c12523").r("obj_locate", 16));
                if (!StringUtils.isNull(this.fEL.dwV)) {
                    ax.wg().c(this.mTbPageContext, new String[]{this.fEL.dwV});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.n.a.bkt().b(7, false, true);
                TiebaStatic.log(new al("c12523").r("obj_locate", 12));
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
                TiebaStatic.log(new al("c12523").r("obj_locate", 9));
                com.baidu.tieba.n.a.bkt().b(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new al("c12523").r("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new al("c12523").r("obj_locate", 15));
                ax.wg().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new al("c12523").r("obj_locate", 11));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                    return;
                }
                return;
            case 25:
                if (this.mUserData != null) {
                    TiebaStatic.log(new al("c12523").r("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 30:
                TiebaStatic.log(new al("c12523").r("obj_locate", 17));
                ax.wg().c(this.mTbPageContext, new String[]{"https://tieba.baidu.com/mo/q/hotMessage/list?cuid=" + TbadkCoreApplication.getInst().getCuid() + "&timestamp=" + System.currentTimeMillis() + "&_client_version=" + TbadkCoreApplication.getInst().getVersionName() + "&nohead=1"});
                return;
            case 31:
                com.baidu.tieba.n.a.bkt().b(10, false, true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", false);
                TiebaStatic.log(new al("c12523").r("obj_locate", 19));
                com.baidu.tbadk.browser.a.M(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new al("c12523").r("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.fEL.fEd)));
                return;
            case 36:
                TiebaStatic.log(new al("c12524").r("obj_locate", this.fEL.itemId));
                qZ(this.fEL.dwV);
                return;
            case 37:
                TiebaStatic.log(new al("c12523").r("obj_locate", 24));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_has_borrow_cash_clicked", true);
                if (this.fEL.fEc != null) {
                    this.fEL.fEc.fEg = false;
                }
                this.fEv.setVisibility(8);
                if (TbadkCoreApplication.getInst().appResponseToCmd(2001447)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=bdbar_and&hideShare=1"));
                    return;
                } else {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.plugin_pay_wallet_not_found);
                    return;
                }
            case 38:
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.xW()) {
                    String xY = activityPrizeData.xY();
                    if (!StringUtils.isNull(xY)) {
                        TiebaStatic.log(new al("c12598"));
                        com.baidu.tieba.n.a.bkt().b(9, false, true);
                        ax.wg().a(aeY(), new String[]{xY}, true);
                        return;
                    }
                    return;
                }
                return;
            case 39:
                com.baidu.tbadk.browser.a.a(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(d.k.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 40:
                TiebaStatic.log(new al("c12923"));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaQuestionHomeActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
        }
    }

    private void bn(View view2) {
        if (view2 == this.fEK) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    private void qY(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), d.k.cosume_record_plugin_not_install_tip);
                    return;
                }
                ax.wg().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    private void qZ(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                qY(str);
            } else if (str.startsWith("nohead:url")) {
                ax.wg().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else if (str.startsWith("livequiz:")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaQuestionHomeActivityConfig(this.mTbPageContext.getPageActivity())));
            } else {
                ax.wg().c(this.mTbPageContext, new String[]{str});
            }
        }
    }
}
