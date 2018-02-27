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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.g;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.e> {
    private TextView ccJ;
    private View egN;
    private ImageView gjL;
    private ImageView gjX;
    private ImageView gjY;
    private TextView gjZ;
    private TextView gka;
    private com.baidu.tieba.personCenter.data.e gkb;
    private int mSkinType;
    private UserData mUserData;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gjX = (ImageView) view.findViewById(d.g.function_icon);
        this.gjY = (ImageView) view.findViewById(d.g.function_right_arrow);
        this.ccJ = (TextView) view.findViewById(d.g.function_title);
        this.egN = view.findViewById(d.g.function_item_bottom_divider);
        this.gjL = (ImageView) view.findViewById(d.g.function_red_tip);
        this.gjZ = (TextView) view.findViewById(d.g.function_desc);
        this.gka = (TextView) view.findViewById(d.g.tbean_num);
        view.setOnClickListener(this);
        this.gka.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.gjY.setImageDrawable(aj.au(i, d.f.icon_arrow_gray_right_n));
            aj.r(this.ccJ, d.C0141d.cp_cont_b);
            aj.t(this.egN, d.C0141d.cp_bg_line_e);
            aj.s(getView(), d.f.person_center_action_item_selector);
            this.gjL.setImageDrawable(aj.au(i, d.f.person_center_red_tip_shape));
            aj.r(this.gjZ, d.C0141d.cp_cont_d);
            aj.r(this.gka, d.C0141d.cp_cont_b);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_function_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null) {
            this.gkb = eVar;
            this.mUserData = eVar.fHa;
            this.ccJ.setText(eVar.title);
            if (eVar.iconId != 0) {
                this.gjX.setVisibility(0);
                this.gjX.setImageDrawable(aj.au(TbadkCoreApplication.getInst().getSkinType(), eVar.iconId));
            } else {
                this.gjX.setVisibility(8);
            }
            b(eVar);
            a(eVar.gjt);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.e eVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.egN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.egN.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (eVar.gjs) {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds1);
        }
        this.egN.setLayoutParams(layoutParams);
    }

    private void a(g gVar) {
        if (gVar != null) {
            if (gVar.gjx) {
                this.gjL.setVisibility(0);
            } else {
                this.gjL.setVisibility(8);
            }
            if (!StringUtils.isNull(gVar.gjA)) {
                this.gjZ.setVisibility(0);
                this.gjZ.setText(gVar.gjA);
            } else {
                this.gjZ.setVisibility(8);
            }
            if (gVar.gjy) {
                this.gka.setVisibility(0);
                this.gka.setText(am.P(gVar.gjz));
                this.gka.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.gka.setVisibility(8);
            return;
        }
        this.gjL.setVisibility(8);
        this.gjZ.setVisibility(8);
        this.gka.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                if (this.gkb.type == 36 && "游戏".equals(this.gkb.title) && this.cVi != null) {
                    this.cVi.a(view, this.gkb);
                    return;
                } else {
                    biM();
                    return;
                }
            }
            cH(view);
        }
    }

    private void biM() {
        switch (this.gkb.type) {
            case 10:
                com.baidu.tieba.m.a.bpl().c(1, false, true);
                TiebaStatic.log(new ak("c12523").s("obj_locate", 13));
                if (this.mUserData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 16));
                if (!StringUtils.isNull(this.gkb.ecc)) {
                    aw.Dt().c(this.mTbPageContext, new String[]{this.gkb.ecc});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.m.a.bpl().c(7, false, true);
                TiebaStatic.log(new ak("c12523").s("obj_locate", 12));
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
                TiebaStatic.log(new ak("c12523").s("obj_locate", 9));
                com.baidu.tieba.m.a.bpl().c(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 15));
                aw.Dt().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 11));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                    return;
                }
                return;
            case 25:
                if (this.mUserData != null) {
                    TiebaStatic.log(new ak("c12523").s("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 30:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 17));
                aw.Dt().c(this.mTbPageContext, new String[]{"https://tieba.baidu.com/mo/q/hotMessage/list?cuid=" + TbadkCoreApplication.getInst().getCuid() + "&timestamp=" + System.currentTimeMillis() + "&_client_version=" + TbadkCoreApplication.getInst().getVersionName() + "&nohead=1"});
                return;
            case 31:
                com.baidu.tieba.m.a.bpl().c(10, false, true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", false);
                TiebaStatic.log(new ak("c12523").s("obj_locate", 19));
                com.baidu.tbadk.browser.b.R(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.gkb.gju)));
                return;
            case 36:
                TiebaStatic.log(new ak("c12524").s("obj_locate", this.gkb.itemId));
                qT(this.gkb.ecc);
                return;
            case 37:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 24));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_has_borrow_cash_clicked", true);
                if (this.gkb.gjt != null) {
                    this.gkb.gjt.gjx = false;
                }
                this.gjL.setVisibility(8);
                if (TbadkCoreApplication.getInst().appResponseToCmd(2001447)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=bdbar_and&hideShare=1"));
                    return;
                } else {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.plugin_pay_wallet_not_found);
                    return;
                }
            case 38:
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.Fi()) {
                    String Fk = activityPrizeData.Fk();
                    if (!StringUtils.isNull(Fk)) {
                        TiebaStatic.log(new ak("c12598"));
                        com.baidu.tieba.m.a.bpl().c(9, false, true);
                        aw.Dt().a(akN(), new String[]{Fk}, true);
                        return;
                    }
                    return;
                }
                return;
            case 39:
                com.baidu.tbadk.browser.b.a(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(d.j.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 40:
                TiebaStatic.log(new ak("c12923"));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaQuestionHomeActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
        }
    }

    private void cH(View view) {
        if (view == this.gka) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    private void qS(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), d.j.cosume_record_plugin_not_install_tip);
                    return;
                }
                aw.Dt().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.b.b(this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    private void qT(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                qS(str);
            } else if (str.startsWith("nohead:url")) {
                aw.Dt().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                aw.Dt().c(this.mTbPageContext, new String[]{str});
            }
        }
    }
}
