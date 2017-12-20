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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.data.f;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.personCenter.data.d> {
    private View doW;
    private ImageView dsX;
    private TextView ftA;
    private ImageView ftB;
    private TextView ftC;
    private TextView ftD;
    private com.baidu.tieba.personCenter.data.d ftE;
    private ImageView ftz;
    private int mSkinType;
    private UserData mUserData;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ftz = (ImageView) view.findViewById(d.g.function_icon);
        this.ftB = (ImageView) view.findViewById(d.g.function_right_arrow);
        this.ftA = (TextView) view.findViewById(d.g.function_title);
        this.doW = view.findViewById(d.g.function_item_bottom_divider);
        this.dsX = (ImageView) view.findViewById(d.g.function_red_tip);
        this.ftC = (TextView) view.findViewById(d.g.function_desc);
        this.ftD = (TextView) view.findViewById(d.g.tbean_num);
        view.setOnClickListener(this);
        this.ftD.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.ftB.setImageDrawable(aj.v(i, d.f.icon_arrow_gray_right_n));
            aj.i(this.ftA, d.C0096d.cp_cont_b);
            aj.k(this.doW, d.C0096d.cp_bg_line_e);
            aj.j(getView(), d.f.person_center_action_item_selector);
            this.dsX.setImageDrawable(aj.v(i, d.f.person_center_red_tip_shape));
            aj.i(this.ftC, d.C0096d.cp_cont_d);
            aj.i(this.ftD, d.C0096d.cp_cont_b);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.person_center_function_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.personCenter.data.d dVar) {
        if (dVar != null) {
            this.ftE = dVar;
            this.mUserData = dVar.ePs;
            this.ftA.setText(dVar.title);
            if (dVar.iconId != 0) {
                this.ftz.setVisibility(0);
                this.ftz.setImageDrawable(aj.v(TbadkCoreApplication.getInst().getSkinType(), dVar.iconId));
            } else {
                this.ftz.setVisibility(8);
            }
            b(dVar);
            a(dVar.fsW);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.personCenter.data.d dVar) {
        LinearLayout.LayoutParams layoutParams;
        if (this.doW.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) this.doW.getLayoutParams();
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
        }
        if (dVar.fsV) {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds12);
        } else {
            layoutParams.height = (int) getContext().getResources().getDimension(d.e.ds1);
        }
        this.doW.setLayoutParams(layoutParams);
    }

    private void a(f fVar) {
        if (fVar != null) {
            if (fVar.fta) {
                this.dsX.setVisibility(0);
            } else {
                this.dsX.setVisibility(8);
            }
            if (!StringUtils.isNull(fVar.ftd)) {
                this.ftC.setVisibility(0);
                this.ftC.setText(fVar.ftd);
            } else {
                this.ftC.setVisibility(8);
            }
            if (fVar.ftb) {
                this.ftD.setVisibility(0);
                this.ftD.setText(am.H(fVar.ftc));
                this.ftD.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            this.ftD.setVisibility(8);
            return;
        }
        this.dsX.setVisibility(8);
        this.ftC.setVisibility(8);
        this.ftD.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == getView().getId()) {
                baj();
            } else {
                bv(view);
            }
        }
    }

    private void baj() {
        switch (this.ftE.type) {
            case 10:
                com.baidu.tieba.m.a.bmM().c(1, false, true);
                TiebaStatic.log(new ak("c12523").r("obj_locate", 13));
                if (this.mUserData != null && TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyGiftListActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getName_show(), this.mUserData.getSex(), "iowner_gift")));
                    return;
                }
                return;
            case 11:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 16));
                if (!StringUtils.isNull(this.ftE.dkk)) {
                    av.vI().c(this.mTbPageContext, new String[]{this.ftE.dkk});
                    return;
                }
                return;
            case 12:
                com.baidu.tieba.m.a.bmM().c(7, false, true);
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
                TiebaStatic.log(new ak("c12523").r("obj_locate", 9));
                com.baidu.tieba.m.a.bmM().c(3, false, true);
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
                if (this.mUserData != null) {
                    TiebaStatic.log(new ak("c12523").r("obj_locate", 18));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(this.mTbPageContext.getPageActivity(), this.mUserData.getUserId(), this.mUserData.getUserName(), this.mUserData.getPortrait(), this.mUserData.getSex(), true)));
                    return;
                }
                return;
            case 30:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 17));
                av.vI().c(this.mTbPageContext, new String[]{"https://tieba.baidu.com/mo/q/hotMessage/list?cuid=" + TbadkCoreApplication.getInst().getCuid() + "&timestamp=" + System.currentTimeMillis() + "&_client_version=" + TbadkCoreApplication.getInst().getVersionName() + "&nohead=1"});
                return;
            case 31:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 19));
                com.baidu.tbadk.browser.a.O(this.mTbPageContext.getPageActivity(), TbConfig.URL_UEG_SERVICE_CENTER);
                return;
            case 33:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 21));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonMoreActivityConfig(this.mTbPageContext.getPageActivity(), this.ftE.fsX)));
                return;
            case d.l.View_clickable /* 36 */:
                TiebaStatic.log(new ak("c12524").r("obj_locate", this.ftE.itemId));
                qs(this.ftE.dkk);
                return;
            case d.l.View_longClickable /* 37 */:
                TiebaStatic.log(new ak("c12523").r("obj_locate", 24));
                if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_OPEN_WALLET_ICASH)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, "https://icash.baidu.com/cloan/index?na=postbarapp&CH=postbarapp&fr=bdbar_and&hideShare=1"));
                    return;
                } else {
                    l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.plugin_pay_wallet_not_found);
                    return;
                }
            case d.l.View_saveEnabled /* 38 */:
                com.baidu.tbadk.coreExtra.data.a activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
                if (activityPrizeData.xw()) {
                    String xy = activityPrizeData.xy();
                    if (!StringUtils.isNull(xy)) {
                        TiebaStatic.log(new ak("c12598"));
                        com.baidu.tieba.m.a.bmM().c(9, false, true);
                        av.vI().a(abs(), new String[]{xy}, true);
                        return;
                    }
                    return;
                }
                return;
            case d.l.View_filterTouchesWhenObscured /* 39 */:
                com.baidu.tbadk.browser.a.a(true, (Context) this.mTbPageContext.getPageActivity(), this.mTbPageContext.getResources().getString(d.j.baidu_singkil), TbConfig.URL_BAIDU_SINGKIL);
                return;
        }
    }

    private void bv(View view) {
        if (view == this.ftD) {
            BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(this.mTbPageContext.getPageActivity(), 0L);
            buyTBeanActivityConfig.setReferPageAndClickZone("personal_center_V8.9", "T_recharge_V8.9");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
        }
    }

    private void qr(String str) {
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

    private void qs(String str) {
        if (!StringUtils.isNull(str)) {
            if (str.startsWith("tieba&")) {
                qr(str);
            } else if (str.startsWith("nohead:url")) {
                av.vI().c(this.mTbPageContext, new String[]{str.replaceFirst("nohead:url=", "") + (str.contains("?") ? "&" : "?") + "jump=open_full_screen_web_page&nonavigationbar=1"});
            } else {
                av.vI().c(this.mTbPageContext, new String[]{str});
            }
        }
    }
}
