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
    private TextView ccM;
    private View ehd;
    private ImageView gkb;
    private ImageView gkn;
    private ImageView gko;
    private TextView gkp;
    private TextView gkq;
    private com.baidu.tieba.personCenter.data.e gkr;
    private int mSkinType;
    private UserData mUserData;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gkn = (ImageView) view.findViewById(d.g.function_icon);
        this.gko = (ImageView) view.findViewById(d.g.function_right_arrow);
        this.ccM = (TextView) view.findViewById(d.g.function_title);
        this.ehd = view.findViewById(d.g.function_item_bottom_divider);
        this.gkb = (ImageView) view.findViewById(d.g.function_red_tip);
        this.gkp = (TextView) view.findViewById(d.g.function_desc);
        this.gkq = (TextView) view.findViewById(d.g.tbean_num);
        view.setOnClickListener(this);
        this.gkq.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.gko.setImageDrawable(aj.au(i, d.f.icon_arrow_gray_right_n));
            aj.r(this.ccM, d.C0141d.cp_cont_b);
            aj.t(this.ehd, d.C0141d.cp_bg_line_e);
            aj.s(getView(), d.f.person_center_action_item_selector);
            this.gkb.setImageDrawable(aj.au(i, d.f.person_center_red_tip_shape));
            aj.r(this.gkp, d.C0141d.cp_cont_d);
            aj.r(this.gkq, d.C0141d.cp_cont_b);
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
            this.gkr = eVar;
            this.mUserData = eVar.fHq;
            this.ccM.setText(eVar.title);
            if (eVar.iconId != 0) {
                this.gkn.setVisibility(0);
                this.gkn.setImageDrawable(aj.au(TbadkCoreApplication.getInst().getSkinType(), eVar.iconId));
            } else {
                this.gkn.setVisibility(8);
            }
            b(eVar);
            a(eVar.gjJ);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.e eVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.ehd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.ehd.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (eVar.gjI) {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds1);
        }
        this.ehd.setLayoutParams(layoutParams);
    }

    private void a(g gVar) {
        if (gVar != null) {
            if (gVar.gjN) {
                this.gkb.setVisibility(0);
            } else {
                this.gkb.setVisibility(8);
            }
            if (!StringUtils.isNull(gVar.gjQ)) {
                this.gkp.setVisibility(0);
                this.gkp.setText(gVar.gjQ);
            } else {
                this.gkp.setVisibility(8);
            }
            if (gVar.gjO) {
                this.gkq.setVisibility(0);
                this.gkq.setText(am.P(gVar.gjP));
                this.gkq.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.gkq.setVisibility(8);
            return;
        }
        this.gkb.setVisibility(8);
        this.gkp.setVisibility(8);
        this.gkq.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                if (this.gkr.type == 36 && "游戏".equals(this.gkr.title) && this.cVl != null) {
                    this.cVl.a(view, this.gkr);
                    return;
                } else {
                    biN();
                    return;
                }
            }
            cH(view);
        }
    }

    private void biN() {
        switch (this.gkr.type) {
            case 10:
                com.baidu.tieba.m.a.bpm().c(1, false, true);
                TiebaStatic.log(new ak("c12523").s("obj_locate", 13));
                if (this.mUserData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 16));
                if (!StringUtils.isNull(this.gkr.ecs)) {
                    aw.Du().c(this.mTbPageContext, new String[]{this.gkr.ecs});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.m.a.bpm().c(7, false, true);
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
                com.baidu.tieba.m.a.bpm().c(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 15));
                aw.Du().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
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
                aw.Du().c(this.mTbPageContext, new String[]{"https://tieba.baidu.com/mo/q/hotMessage/list?cuid=" + TbadkCoreApplication.getInst().getCuid() + "&timestamp=" + System.currentTimeMillis() + "&_client_version=" + TbadkCoreApplication.getInst().getVersionName() + "&nohead=1"});
                return;
            case 31:
                com.baidu.tieba.m.a.bpm().c(10, false, true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", false);
                TiebaStatic.log(new ak("c12523").s("obj_locate", 19));
                com.baidu.tbadk.browser.b.R(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.gkr.gjK)));
                return;
            case 36:
                TiebaStatic.log(new ak("c12524").s("obj_locate", this.gkr.itemId));
                qT(this.gkr.ecs);
                return;
            case 37:
                TiebaStatic.log(new ak("c12523").s("obj_locate", 24));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_has_borrow_cash_clicked", true);
                if (this.gkr.gjJ != null) {
                    this.gkr.gjJ.gjN = false;
                }
                this.gkb.setVisibility(8);
                if (TbadkCoreApplication.getInst().appResponseToCmd(2001447)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=bdbar_and&hideShare=1"));
                    return;
                } else {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.plugin_pay_wallet_not_found);
                    return;
                }
            case 38:
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.Fj()) {
                    String Fl = activityPrizeData.Fl();
                    if (!StringUtils.isNull(Fl)) {
                        TiebaStatic.log(new ak("c12598"));
                        com.baidu.tieba.m.a.bpm().c(9, false, true);
                        aw.Du().a(akO(), new String[]{Fl}, true);
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
        if (view == this.gkq) {
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
                aw.Du().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
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
                aw.Du().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                aw.Du().c(this.mTbPageContext, new String[]{str});
            }
        }
    }
}
