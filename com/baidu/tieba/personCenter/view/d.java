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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.e> {
    private View deP;
    private ImageView dix;
    private ImageView fjl;
    private TextView fjm;
    private ImageView fjn;
    private TextView fjo;
    private TextView fjp;
    private com.baidu.tieba.personCenter.data.e fjq;
    private int mSkinType;
    private UserData mUserData;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fjl = (ImageView) view.findViewById(d.g.function_icon);
        this.fjn = (ImageView) view.findViewById(d.g.function_right_arrow);
        this.fjm = (TextView) view.findViewById(d.g.function_title);
        this.deP = view.findViewById(d.g.function_item_bottom_divider);
        this.dix = (ImageView) view.findViewById(d.g.function_red_tip);
        this.fjo = (TextView) view.findViewById(d.g.function_desc);
        this.fjp = (TextView) view.findViewById(d.g.tbean_num);
        view.setOnClickListener(this);
        this.fjp.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.fjn.setImageDrawable(aj.u(i, d.f.icon_mine_list_arrow));
            aj.i(this.fjm, d.C0080d.cp_cont_b);
            aj.k(this.deP, d.C0080d.cp_bg_line_e);
            aj.j(getView(), d.f.person_center_action_item_selector);
            this.dix.setImageDrawable(aj.u(i, d.f.person_center_red_tip_shape));
            aj.i(this.fjo, d.C0080d.cp_cont_d);
            aj.i(this.fjp, d.C0080d.cp_cont_b);
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
            this.fjq = eVar;
            this.mUserData = eVar.eGm;
            this.fjm.setText(eVar.title);
            if (eVar.iconId != 0) {
                this.fjl.setVisibility(0);
                this.fjl.setImageDrawable(aj.u(TbadkCoreApplication.getInst().getSkinType(), eVar.iconId));
            } else {
                this.fjl.setVisibility(8);
            }
            b(eVar);
            a(eVar.fiH);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.e eVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.deP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.deP.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (eVar.fiG) {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds1);
        }
        this.deP.setLayoutParams(layoutParams);
    }

    private void a(com.baidu.tieba.personCenter.data.g gVar) {
        if (gVar != null) {
            if (gVar.fiL) {
                this.dix.setVisibility(0);
            } else {
                this.dix.setVisibility(8);
            }
            if (!StringUtils.isNull(gVar.fiO)) {
                this.fjo.setVisibility(0);
                this.fjo.setText(gVar.fiO);
            } else {
                this.fjo.setVisibility(8);
            }
            if (gVar.fiM) {
                this.fjp.setVisibility(0);
                this.fjp.setText(am.H(gVar.fiN));
                this.fjp.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.fjp.setVisibility(8);
            return;
        }
        this.dix.setVisibility(8);
        this.fjo.setVisibility(8);
        this.fjp.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                aYr();
            } else {
                bv(view);
            }
        }
    }

    private void aYr() {
        switch (this.fjq.type) {
            case 10:
                com.baidu.tieba.j.a.bjW().c(1, false, true);
                TiebaStatic.log(new ak("c12523").r("obj_locate", 13));
                if (this.mUserData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 16));
                if (!StringUtils.isNull(this.fjq.dac)) {
                    av.vI().c(this.mTbPageContext, new String[]{this.fjq.dac});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.j.a.bjW().c(7, false, true);
                TiebaStatic.log(new ak("c12523").r("obj_locate", 12));
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
            case 27:
            case 28:
            case 29:
            case 30:
            case 33:
            case 35:
            case d.l.View_clickable /* 36 */:
            default:
                return;
            case 16:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 9));
                com.baidu.tieba.j.a.bjW().c(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 15));
                av.vI().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
                return;
            case 22:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 11));
                if (this.mUserData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonGroupActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getSex(), 0, 1)));
                    return;
                }
                return;
            case 25:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 20));
                av.vI().c(this.mTbPageContext, new String[]{"feedback:"});
                return;
            case 26:
                if (this.mUserData != null) {
                    TiebaStatic.log(new ak("c12523").r("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 31:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 17));
                av.vI().c(this.mTbPageContext, new String[]{"https://tieba.baidu.com/mo/q/hotMessage/list?cuid=" + TbadkCoreApplication.getInst().getCuid() + "&timestamp=" + System.currentTimeMillis() + "&_client_version=" + TbadkCoreApplication.getInst().getVersionName() + "&nohead=1"});
                return;
            case 32:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 19));
                com.baidu.tbadk.browser.a.O(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 34:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.fjq.fiI)));
                return;
            case d.l.View_longClickable /* 37 */:
                TiebaStatic.log(new ak("c12524").r("obj_locate", this.fjq.itemId));
                pY(this.fjq.dac);
                return;
            case d.l.View_saveEnabled /* 38 */:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 24));
                if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_OPEN_WALLET_ICASH)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=bdbar_and&hideShare=1"));
                    return;
                } else {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.plugin_pay_wallet_not_found);
                    return;
                }
        }
    }

    private void bv(View view) {
        if (view == this.fjp) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
        }
    }

    private void pX(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), d.j.cosume_record_plugin_not_install_tip);
                    return;
                }
                av.vI().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }

    private void pY(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                pX(str);
            } else if (str.startsWith("nohead:url")) {
                av.vI().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                av.vI().c(this.mTbPageContext, new String[]{str});
            }
        }
    }
}
