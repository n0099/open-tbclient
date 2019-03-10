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
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.h;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.f> {
    private View bFo;
    private TextView dgj;
    private ImageView hMO;
    private ImageView hMP;
    private TextView hMQ;
    private TextView hMR;
    private com.baidu.tieba.personCenter.data.f hMS;
    private ImageView hMz;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hMO = (ImageView) view.findViewById(d.g.function_icon);
        this.hMP = (ImageView) view.findViewById(d.g.function_right_arrow);
        this.dgj = (TextView) view.findViewById(d.g.function_title);
        this.bFo = view.findViewById(d.g.function_item_bottom_divider);
        this.hMz = (ImageView) view.findViewById(d.g.function_red_tip);
        this.hMQ = (TextView) view.findViewById(d.g.function_desc);
        this.hMR = (TextView) view.findViewById(d.g.tbean_num);
        view.setOnClickListener(this);
        this.hMR.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.hMP.setImageDrawable(al.T(i, d.f.icon_arrow_gray_right_n));
            al.j(this.dgj, d.C0236d.cp_cont_b);
            al.l(this.bFo, d.C0236d.cp_bg_line_e);
            al.k(getView(), d.f.person_center_action_item_selector);
            this.hMz.setImageDrawable(al.T(i, d.f.person_center_red_tip_shape));
            al.j(this.hMQ, d.C0236d.cp_cont_d);
            al.j(this.hMR, d.C0236d.cp_cont_b);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_function_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null) {
            this.hMS = fVar;
            this.mUserData = fVar.userData;
            this.dgj.setText(fVar.title);
            if (fVar.iconId != 0) {
                this.hMO.setVisibility(0);
                this.hMO.setImageDrawable(al.T(TbadkCoreApplication.getInst().getSkinType(), fVar.iconId));
            } else {
                this.hMO.setVisibility(8);
            }
            b(fVar);
            a(fVar.hMf);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.f fVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bFo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.bFo.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (fVar.hMe) {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds1);
        }
        this.bFo.setLayoutParams(layoutParams);
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.isShowRedTip) {
                this.hMz.setVisibility(0);
            } else {
                this.hMz.setVisibility(8);
            }
            if (!StringUtils.isNull(hVar.hMl)) {
                this.hMQ.setVisibility(0);
                this.hMQ.setText(hVar.hMl);
            } else {
                this.hMQ.setVisibility(8);
            }
            if (hVar.hMj) {
                this.hMR.setVisibility(0);
                this.hMR.setText(ap.aF(hVar.hMk));
                this.hMR.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.hMR.setVisibility(8);
            return;
        }
        this.hMz.setVisibility(8);
        this.hMQ.setVisibility(8);
        this.hMR.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                if (this.hMS.type == 36 && "游戏".equals(this.hMS.title) && this.efx != null) {
                    this.efx.a(view, this.hMS);
                    return;
                } else {
                    bQB();
                    return;
                }
            }
            cz(view);
        }
    }

    private void bQB() {
        switch (this.hMS.type) {
            case 10:
                com.baidu.tieba.o.a.bXU().d(1, false, true);
                TiebaStatic.log(new am("c12523").T("obj_locate", 13));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new am("c12523").T("obj_locate", 16));
                if (!StringUtils.isNull(this.hMS.bvG)) {
                    ba.adD().c(this.mTbPageContext, new String[]{this.hMS.bvG});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.o.a.bXU().d(7, false, true);
                TiebaStatic.log(new am("c12523").T("obj_locate", 12));
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
                TiebaStatic.log(new am("c12523").T("obj_locate", 9));
                com.baidu.tieba.o.a.bXU().d(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                if (com.baidu.tbadk.plugins.c.b(this.mTbPageContext, "com.baidu.tieba.pluginCore")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.mTbPageContext.getPageActivity())));
                    return;
                }
                return;
            case 17:
                TiebaStatic.log(new am("c12523").T("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new am("c12523").T("obj_locate", 15));
                ba.adD().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new am("c12523").T("obj_locate", 11));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                    return;
                }
                return;
            case 25:
                if (this.mUserData != null && com.baidu.tbadk.plugins.c.b(this.mTbPageContext, "com.baidu.tieba.pluginAla")) {
                    TiebaStatic.log(new am("c12523").T("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 30:
                TiebaStatic.log(new am("c12523").T("obj_locate", 17));
                if (!com.baidu.tbadk.plugins.b.f(this.mTbPageContext)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(VideoMiddlePageActivityConfig.FROM_HOTTOPIC, "all")));
                    return;
                }
                return;
            case 31:
                com.baidu.tieba.o.a.bXU().d(10, false, true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", false);
                TiebaStatic.log(new am("c12523").T("obj_locate", 19));
                com.baidu.tbadk.browser.a.ar(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new am("c12523").T("obj_locate", 21));
                if (com.baidu.tbadk.plugins.c.b(this.mTbPageContext, "com.baidu.tieba.pluginMember")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.hMS.hMg)));
                    return;
                }
                return;
            case 36:
                TiebaStatic.log(new am("c12524").T("obj_locate", this.hMS.itemId));
                Ay(this.hMS.bvG);
                return;
            case 37:
                TiebaStatic.log(new am("c12523").T("obj_locate", 24));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_has_borrow_cash_clicked", true);
                if (this.hMS.hMf != null) {
                    this.hMS.hMf.isShowRedTip = false;
                }
                this.hMz.setVisibility(8);
                if (com.baidu.tbadk.plugins.c.b(this.mTbPageContext, "com.baidu.tieba.pluginWallet")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=solely_bdbar_and&hideShare=1"));
                    return;
                }
                return;
            case 38:
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.afQ()) {
                    String afS = activityPrizeData.afS();
                    if (!StringUtils.isNull(afS)) {
                        TiebaStatic.log(new am("c12598"));
                        com.baidu.tieba.o.a.bXU().d(9, false, true);
                        ba.adD().a(getTbPageContext(), new String[]{afS}, true);
                        return;
                    }
                    return;
                }
                return;
            case 39:
                com.baidu.tbadk.browser.a.a(true, this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(d.j.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_baidu_financial_has_clicked", true);
                if (this.hMS.hMf != null) {
                    this.hMS.hMf.isShowRedTip = false;
                }
                this.hMz.setVisibility(8);
                if (com.baidu.tbadk.plugins.c.b(this.mTbPageContext, "com.baidu.tieba.pluginWallet")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                    return;
                }
                return;
        }
    }

    private void cz(View view) {
        if (view == this.hMR && com.baidu.tbadk.plugins.c.b(this.mTbPageContext, "com.baidu.tieba.pluginResource")) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    private void Ax(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), d.j.cosume_record_plugin_not_install_tip);
                    return;
                }
                ba.adD().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    private void Ay(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                Ax(str);
            } else if (str.startsWith("nohead:url")) {
                ba.adD().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ba.adD().c(this.mTbPageContext, new String[]{str});
            }
        }
    }
}
