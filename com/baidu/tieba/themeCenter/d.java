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
    private com.baidu.tbadk.core.dialog.a Md;
    private SkinItemView.a dLv;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        a(new e(this));
    }

    public void b(b bVar) {
        if (bVar != null && bVar.getId() > 0) {
            TiebaStatic.log("c10267");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SkinDetailActivityConfig(this.mPageContext.getPageActivity(), bVar.getId(), bVar.aHu(), bVar.getPicUrl(), bVar.aHr())));
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0043: INVOKE  (r2v1 int A[REMOVE]) = (r12v0 com.baidu.tieba.themeCenter.b) type: VIRTUAL call: com.baidu.tieba.themeCenter.b.getId():int)] */
    public void b(SkinProgressView skinProgressView, b bVar) {
        int id;
        if (skinProgressView != null && bVar != null) {
            int aHu = bVar.aHu();
            if (aHu == 1 || aHu == 5 || aHu == 3) {
                if (aHu == 1) {
                    TiebaStatic.log("c10268");
                } else if (aHu == 5) {
                    TiebaStatic.log("c10270");
                }
                if (i.f(bVar)) {
                    if (!StringUtils.isNull(bVar.aHq())) {
                        TbadkCoreApplication.m411getInst().addThemeToWaitDownloadQuene(bVar.getId());
                        skinProgressView.e(2, 0.0f);
                        com.baidu.tbadk.download.b.Bb().a(new StringBuilder().append(bVar.getId()).toString(), bVar.aHq(), bVar.getTitle(), 0, bVar.getId(), null, false, true, false);
                        return;
                    }
                    return;
                }
                d(bVar);
            } else if (aHu == 2) {
                TbadkCoreApplication.m411getInst().deleteThemeFromWaitDownloadQuene(bVar.getId());
                skinProgressView.e(3, 0.0f);
                com.baidu.tbadk.download.b.Bb().eZ(bVar.aHq());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKIN_TEMP_FILE, bVar));
            } else if (aHu == 4) {
                TiebaStatic.log("c10269");
                if (i.f(bVar)) {
                    if (bVar.getId() == -1) {
                        TbadkCoreApplication.m411getInst().setSkinType(0);
                        id = 1250000;
                    } else if (bVar.getId() == -2) {
                        TbadkCoreApplication.m411getInst().setSkinType(1);
                        id = 1250000;
                    } else {
                        TbadkCoreApplication.m411getInst().setUsedTheme(bVar.getId(), bVar.aHt());
                        TiebaStatic.log(new av("c10220").r("obj_id", bVar.getId()).r("obj_type", bVar.aHt()));
                        id = bVar.getId();
                    }
                    BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
                    backgroundSetRequestMessage.setPropId(id);
                    MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_THEME_LIST));
                    return;
                }
                d(bVar);
            }
        }
    }

    private void d(b bVar) {
        String string;
        if (bVar.aHt() == 100) {
            if (bVar.getActivityFinish() == 0) {
                i.b(this.mPageContext, 1, bVar.getActivityUrl());
                return;
            }
            return;
        }
        if (bVar.aHt() == 101) {
            string = this.mPageContext.getString(n.j.become_annual_can_use_theme);
        } else if (bVar.aHt() > 1) {
            string = String.format(this.mPageContext.getString(n.j.become_vip_can_use_theme), Integer.valueOf(bVar.aHt()));
        } else {
            string = this.mPageContext.getString(n.j.become_member_can_use);
        }
        i.a(this.mPageContext, 1, string);
    }

    private void e(b bVar) {
        if (this.Md == null) {
            this.Md = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.Md.bG(n.j.tip_delete_used_skin);
            this.Md.b(n.j.cancel_text, new f(this));
            this.Md.a(n.j.delete, new g(this, bVar));
            this.Md.b(this.mPageContext);
        }
        this.Md.tf();
    }

    public SkinItemView.a aHy() {
        return this.dLv;
    }

    public void a(SkinItemView.a aVar) {
        this.dLv = aVar;
    }
}
