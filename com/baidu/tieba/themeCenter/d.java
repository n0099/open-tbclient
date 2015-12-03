package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SkinDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.SkinItemView;
import com.baidu.tieba.themeCenter.background.BackgroundSetRequestMessage;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.core.dialog.a LN;
    private SkinItemView.a dDR;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        a(new e(this));
    }

    public void b(b bVar) {
        if (bVar != null && bVar.getId() > 0) {
            TiebaStatic.log("c10267");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SkinDetailActivityConfig(this.mPageContext.getPageActivity(), bVar.getId(), bVar.aFf(), bVar.getPicUrl(), bVar.aFc())));
        }
    }

    public void c(b bVar) {
        if (bVar != null && bVar.getId() > 0) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2 && bVar.getId() == TbadkCoreApplication.m411getInst().getUsedThemeId()) {
                e(bVar);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKINT_DATA_FROM_DB, bVar));
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0038: INVOKE  (r2v1 int A[REMOVE]) = (r12v0 com.baidu.tieba.themeCenter.b) type: VIRTUAL call: com.baidu.tieba.themeCenter.b.getId():int)] */
    public void b(SkinProgressView skinProgressView, b bVar) {
        if (skinProgressView != null && bVar != null) {
            int aFf = bVar.aFf();
            if (aFf == 1 || aFf == 5 || aFf == 3) {
                if (aFf == 1) {
                    TiebaStatic.log("c10268");
                } else if (aFf == 5) {
                    TiebaStatic.log("c10270");
                }
                if (i.f(bVar)) {
                    if (!StringUtils.isNull(bVar.aFb())) {
                        skinProgressView.e(2, 0.0f);
                        com.baidu.tbadk.download.b.Bm().a(new StringBuilder().append(bVar.getId()).toString(), bVar.aFb(), bVar.getTitle(), 0, bVar.getId(), null, false, true, false);
                        return;
                    }
                    return;
                }
                d(bVar);
            } else if (aFf == 2) {
                skinProgressView.e(3, 0.0f);
                com.baidu.tbadk.download.b.Bm().eV(bVar.aFb());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKIN_TEMP_FILE, bVar));
            } else if (aFf == 4) {
                TiebaStatic.log("c10269");
                if (i.f(bVar)) {
                    if (bVar.getId() == -1) {
                        TbadkCoreApplication.m411getInst().setSkinType(0);
                    } else if (bVar.getId() == -2) {
                        TbadkCoreApplication.m411getInst().setSkinType(1);
                    } else {
                        TbadkCoreApplication.m411getInst().setUsedTheme(bVar.getId(), bVar.aFe());
                        TiebaStatic.log(new av("c10220").r("obj_id", bVar.getId()).r("obj_type", bVar.aFe()));
                        BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
                        backgroundSetRequestMessage.setPropId(bVar.getId());
                        MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_THEME_LIST));
                    return;
                }
                d(bVar);
            }
        }
    }

    private void d(b bVar) {
        String string;
        if (bVar.aFe() == 100) {
            if (bVar.getActivityFinish() == 0) {
                i.b(this.mPageContext, 1, bVar.getActivityUrl());
                return;
            }
            return;
        }
        if (bVar.aFe() == 101) {
            string = this.mPageContext.getString(n.i.become_annual_can_use_theme);
        } else if (bVar.aFe() > 1) {
            string = String.format(this.mPageContext.getString(n.i.become_vip_can_use_theme), Integer.valueOf(bVar.aFe()));
        } else {
            string = this.mPageContext.getString(n.i.become_member_can_use);
        }
        i.a(this.mPageContext, 1, string);
    }

    private void e(b bVar) {
        if (this.LN == null) {
            this.LN = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.LN.bN(n.i.tip_delete_used_skin);
            this.LN.b(n.i.cancel_text, new f(this));
            this.LN.a(n.i.delete, new g(this, bVar));
            this.LN.b(this.mPageContext);
        }
        this.LN.tv();
    }

    public SkinItemView.a aFj() {
        return this.dDR;
    }

    public void a(SkinItemView.a aVar) {
        this.dDR = aVar;
    }
}
