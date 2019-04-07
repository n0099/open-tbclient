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
    private View bFs;
    private TextView dgj;
    private ImageView hMf;
    private ImageView hMu;
    private ImageView hMv;
    private TextView hMw;
    private TextView hMx;
    private com.baidu.tieba.personCenter.data.f hMy;
    private int mSkinType;
    private UserData mUserData;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hMu = (ImageView) view.findViewById(d.g.function_icon);
        this.hMv = (ImageView) view.findViewById(d.g.function_right_arrow);
        this.dgj = (TextView) view.findViewById(d.g.function_title);
        this.bFs = view.findViewById(d.g.function_item_bottom_divider);
        this.hMf = (ImageView) view.findViewById(d.g.function_red_tip);
        this.hMw = (TextView) view.findViewById(d.g.function_desc);
        this.hMx = (TextView) view.findViewById(d.g.tbean_num);
        view.setOnClickListener(this);
        this.hMx.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.hMv.setImageDrawable(al.T(i, d.f.icon_arrow_gray_right_n));
            al.j(this.dgj, d.C0277d.cp_cont_b);
            al.l(this.bFs, d.C0277d.cp_bg_line_e);
            al.k(getView(), d.f.person_center_action_item_selector);
            this.hMf.setImageDrawable(al.T(i, d.f.person_center_red_tip_shape));
            al.j(this.hMw, d.C0277d.cp_cont_d);
            al.j(this.hMx, d.C0277d.cp_cont_b);
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
            this.hMy = fVar;
            this.mUserData = fVar.userData;
            this.dgj.setText(fVar.title);
            if (fVar.iconId != 0) {
                this.hMu.setVisibility(0);
                this.hMu.setImageDrawable(al.T(TbadkCoreApplication.getInst().getSkinType(), fVar.iconId));
            } else {
                this.hMu.setVisibility(8);
            }
            b(fVar);
            a(fVar.hLL);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.f fVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.bFs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.bFs.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (fVar.hLK) {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds1);
        }
        this.bFs.setLayoutParams(layoutParams);
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (hVar.isShowRedTip) {
                this.hMf.setVisibility(0);
            } else {
                this.hMf.setVisibility(8);
            }
            if (!StringUtils.isNull(hVar.hLR)) {
                this.hMw.setVisibility(0);
                this.hMw.setText(hVar.hLR);
            } else {
                this.hMw.setVisibility(8);
            }
            if (hVar.hLP) {
                this.hMx.setVisibility(0);
                this.hMx.setText(ap.aF(hVar.hLQ));
                this.hMx.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.hMx.setVisibility(8);
            return;
        }
        this.hMf.setVisibility(8);
        this.hMw.setVisibility(8);
        this.hMx.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                if (this.hMy.type == 36 && "游戏".equals(this.hMy.title) && this.eff != null) {
                    this.eff.a(view, this.hMy);
                    return;
                } else {
                    bQz();
                    return;
                }
            }
            cz(view);
        }
    }

    private void bQz() {
        switch (this.hMy.type) {
            case 10:
                com.baidu.tieba.o.a.bXS().d(1, false, true);
                TiebaStatic.log(new am("c12523").T("obj_locate", 13));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new am("c12523").T("obj_locate", 16));
                if (!StringUtils.isNull(this.hMy.bvL)) {
                    ba.adA().c(this.mTbPageContext, new String[]{this.hMy.bvL});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.o.a.bXS().d(7, false, true);
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
                com.baidu.tieba.o.a.bXS().d(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001259));
                MessageManager.getInstance().sendMessage(new CustomMessage(2015005, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new am("c12523").T("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new am("c12523").T("obj_locate", 15));
                ba.adA().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new am("c12523").T("obj_locate", 11));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                    return;
                }
                return;
            case 25:
                if (this.mUserData != null) {
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
                com.baidu.tieba.o.a.bXS().d(10, false, true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_feedback_tip_show", false);
                TiebaStatic.log(new am("c12523").T("obj_locate", 19));
                com.baidu.tbadk.browser.a.ar(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new am("c12523").T("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.hMy.hLM)));
                return;
            case 36:
                TiebaStatic.log(new am("c12524").T("obj_locate", this.hMy.itemId));
                Av(this.hMy.bvL);
                return;
            case 37:
                TiebaStatic.log(new am("c12523").T("obj_locate", 24));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_has_borrow_cash_clicked", true);
                if (this.hMy.hLL != null) {
                    this.hMy.hLL.isShowRedTip = false;
                }
                this.hMf.setVisibility(8);
                String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("cash_pay", "");
                if (!StringUtils.isNull(string)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, string));
                    return;
                }
                return;
            case 38:
                com.baidu.tbadk.coreExtra.data.b activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.afN()) {
                    String afP = activityPrizeData.afP();
                    if (!StringUtils.isNull(afP)) {
                        TiebaStatic.log(new am("c12598"));
                        com.baidu.tieba.o.a.bXS().d(9, false, true);
                        ba.adA().a(getTbPageContext(), new String[]{afP}, true);
                        return;
                    }
                    return;
                }
                return;
            case 39:
                com.baidu.tbadk.browser.a.a(true, this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(d.j.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
            case 41:
                TiebaStatic.log(new am("c12523").T("obj_locate", 25));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_baidu_financial_has_clicked", true);
                if (this.hMy.hLL != null) {
                    this.hMy.hLL.isShowRedTip = false;
                }
                this.hMf.setVisibility(8);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                return;
        }
    }

    private void cz(View view) {
        if (view == this.hMx) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, buyTBeanActivityConfig));
        }
    }

    private void Au(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), d.j.cosume_record_plugin_not_install_tip);
                    return;
                }
                ba.adA().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001387, str));
            }
        }
    }

    private void Av(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                Au(str);
            } else if (str.startsWith("nohead:url")) {
                ba.adA().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                ba.adA().c(this.mTbPageContext, new String[]{str});
            }
        }
    }
}
