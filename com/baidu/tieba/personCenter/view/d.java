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
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.c.e> {
    private View cUW;
    private ImageView daV;
    private ImageView fbi;
    private TextView fbj;
    private ImageView fbk;
    private TextView fbl;
    private TextView fbm;
    private com.baidu.tieba.personCenter.c.e fbn;
    private int mSkinType;
    private UserData mUserData;
    protected int userType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.userType = 2;
        this.mSkinType = 3;
        View view = getView();
        this.fbi = (ImageView) view.findViewById(d.h.function_icon);
        this.fbk = (ImageView) view.findViewById(d.h.function_right_arrow);
        this.fbj = (TextView) view.findViewById(d.h.function_title);
        this.cUW = view.findViewById(d.h.function_item_bottom_divider);
        this.daV = (ImageView) view.findViewById(d.h.function_red_tip);
        this.fbl = (TextView) view.findViewById(d.h.function_desc);
        this.fbm = (TextView) view.findViewById(d.h.tbean_num);
        view.setOnClickListener(this);
        this.fbm.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.fbk.setImageDrawable(aj.u(i, d.g.icon_mine_list_arrow));
            aj.i(this.fbj, d.e.cp_cont_b);
            aj.k(this.cUW, d.e.cp_bg_line_e);
            aj.j(getView(), d.g.person_center_action_item_selector);
            this.daV.setImageDrawable(aj.u(i, d.g.person_center_red_tip_shape));
            aj.i(this.fbl, d.e.cp_cont_d);
            aj.i(this.fbm, d.e.cp_cont_b);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.person_center_function_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.c.e eVar) {
        if (eVar != null) {
            this.fbn = eVar;
            this.mUserData = eVar.eyy;
            this.fbj.setText(eVar.title);
            if (eVar.iconId != 0) {
                this.fbi.setVisibility(0);
                this.fbi.setImageDrawable(aj.u(TbadkCoreApplication.getInst().getSkinType(), eVar.iconId));
            } else {
                this.fbi.setVisibility(8);
            }
            b(eVar);
            a(eVar.faD);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.c.e eVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.cUW.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.cUW.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (eVar.faC) {
            layoutParams.height = (int) getContext().getResources().getDimension(d.f.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(d.f.ds1);
        }
        this.cUW.setLayoutParams(layoutParams);
    }

    private void a(com.baidu.tieba.personCenter.c.g gVar) {
        if (gVar != null) {
            if (gVar.faI) {
                this.daV.setVisibility(0);
            } else {
                this.daV.setVisibility(8);
            }
            if (!StringUtils.isNull(gVar.faL)) {
                this.fbl.setVisibility(0);
                this.fbl.setText(gVar.faL);
            } else {
                this.fbl.setVisibility(8);
            }
            if (gVar.faJ) {
                this.fbm.setVisibility(0);
                this.fbm.setText(am.G(gVar.faK));
                this.fbm.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.fbm.setVisibility(8);
            return;
        }
        this.daV.setVisibility(8);
        this.fbl.setVisibility(8);
        this.fbm.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                aVu();
            } else {
                bs(view);
            }
        }
    }

    private void aVu() {
        switch (this.fbn.type) {
            case 10:
                com.baidu.tieba.j.a.bgO().b(1, false, true);
                TiebaStatic.log(new ak("c12523").r("obj_locate", 13));
                if (this.mUserData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 16));
                if (!StringUtils.isNull(this.fbn.cRz)) {
                    av.vH().c(this.mTbPageContext, new String[]{this.fbn.cRz});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.j.a.bgO().b(7, false, true);
                TiebaStatic.log(new ak("c12523").r("obj_locate", 12));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 13:
                TiebaStatic.log(new ak("c12524").r("obj_locate", 1));
                pu(this.fbn.cRz);
                return;
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
            case 33:
            default:
                return;
            case 16:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 9));
                com.baidu.tieba.j.a.bgO().b(3, false, true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.LEFT_NAV_COLLECTION_CLICK));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_EDITMARK, new IntentConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 17:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 10));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.mTbPageContext.getPageActivity())));
                return;
            case 18:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 15));
                av.vH().a(this.mTbPageContext, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
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
                av.vH().c(this.mTbPageContext, new String[]{"feedback:"});
                return;
            case 26:
                if (this.mUserData != null) {
                    TiebaStatic.log(new ak("c12523").r("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 30:
                TiebaStatic.log(new ak("c12524").r("obj_locate", 4));
                if (!StringUtils.isNull(this.fbn.cRz)) {
                    av.vH().a(this.mTbPageContext, new String[]{this.fbn.cRz}, true);
                    return;
                }
                return;
            case 31:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 17));
                av.vH().c(this.mTbPageContext, new String[]{"https://tieba.baidu.com/mo/q/hotMessage/list?cuid=" + TbadkCoreApplication.getInst().getCuid() + "&timestamp=" + System.currentTimeMillis() + "&_client_version=" + TbadkCoreApplication.getInst().getVersionName() + "&nohead=1"});
                return;
            case 32:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 19));
                com.baidu.tbadk.browser.a.T(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 34:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.fbn.faE)));
                return;
            case 35:
                TiebaStatic.log(new ak("c12524").r("obj_locate", 3));
                if (!StringUtils.isNull(this.fbn.cRz)) {
                    av.vH().c(this.mTbPageContext, new String[]{this.fbn.cRz});
                    return;
                }
                return;
            case d.n.View_clickable /* 36 */:
                TiebaStatic.log(new ak("c12524").r("obj_locate", 2));
                if (!StringUtils.isNull(this.fbn.cRz)) {
                    com.baidu.tbadk.browser.a.T(this.mTbPageContext.getPageActivity(), this.fbn.cRz);
                    return;
                }
                return;
        }
    }

    private void bs(View view) {
        if (view == this.fbm) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
        }
    }

    private void pu(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(ConsumptionRecordsActivityConfig.class)) {
                    l.showToast(this.mTbPageContext.getPageActivity(), d.l.cosume_record_plugin_not_install_tip);
                    return;
                }
                av.vH().c(this.mTbPageContext, new String[]{str.substring("tieba&".length())});
            } else if (str.startsWith("http:") || str.startsWith("https:")) {
                com.baidu.tbadk.browser.a.b(this.mTbPageContext.getPageActivity(), true, str);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_WALLET_ITEM_CLICK, str));
            }
        }
    }
}
