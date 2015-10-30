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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinItemView;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.core.dialog.a Lu;
    private SkinItemView.a deE;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        a(new e(this));
    }

    public void b(b bVar) {
        if (bVar != null && bVar.getId() > 0) {
            TiebaStatic.log("c10267");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SkinDetailActivityConfig(this.mPageContext.getPageActivity(), bVar.getId(), bVar.azi(), bVar.getPicUrl(), bVar.azf())));
        }
    }

    public void c(b bVar) {
        if (bVar != null && bVar.getId() > 0) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2 && bVar.getId() == TbadkCoreApplication.m411getInst().getUsedThemeId()) {
                d(bVar);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKINT_DATA_FROM_DB, bVar));
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x003c: INVOKE  (r2v1 int A[REMOVE]) = (r11v0 com.baidu.tieba.themeCenter.b) type: VIRTUAL call: com.baidu.tieba.themeCenter.b.getId():int)] */
    public void b(SkinProgressView skinProgressView, b bVar) {
        if (skinProgressView != null && bVar != null) {
            int azi = bVar.azi();
            if (azi == 1 || azi == 5 || azi == 3) {
                if (azi == 1) {
                    TiebaStatic.log("c10268");
                } else if (azi == 5) {
                    TiebaStatic.log("c10270");
                }
                if (i.lt(bVar.azh())) {
                    if (!StringUtils.isNull(bVar.aze())) {
                        skinProgressView.e(2, 0.0f);
                        com.baidu.tbadk.download.b.Ak().a(new StringBuilder().append(bVar.getId()).toString(), bVar.aze(), bVar.getTitle(), 0, bVar.getId(), false, true, false);
                        return;
                    }
                    return;
                }
                i.a(this.mPageContext, 1, i.h.become_member_can_use);
            } else if (azi == 2) {
                skinProgressView.e(3, 0.0f);
                com.baidu.tbadk.download.b.Ak().eG(bVar.aze());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKIN_TEMP_FILE, bVar));
            } else if (azi == 4) {
                TiebaStatic.log("c10269");
                if (i.lt(bVar.azh())) {
                    if (bVar.getId() == -1) {
                        TbadkCoreApplication.m411getInst().setSkinType(0);
                    } else if (bVar.getId() == -2) {
                        TbadkCoreApplication.m411getInst().setSkinType(1);
                    } else {
                        TbadkCoreApplication.m411getInst().setUsedTheme(bVar.getId(), bVar.azh());
                        TiebaStatic.log(new aq("c10220").r("obj_id", bVar.getId()).r("obj_type", bVar.azh()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_THEME_LIST));
                    return;
                }
                i.a(this.mPageContext, 1, i.h.become_member_can_use);
            }
        }
    }

    private void d(b bVar) {
        if (this.Lu == null) {
            this.Lu = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.Lu.bF(i.h.tip_delete_used_skin);
            this.Lu.b(i.h.cancel_text, new f(this));
            this.Lu.a(i.h.delete, new g(this, bVar));
            this.Lu.b(this.mPageContext);
        }
        this.Lu.sO();
    }

    public SkinItemView.a azm() {
        return this.deE;
    }

    public void a(SkinItemView.a aVar) {
        this.deE = aVar;
    }
}
