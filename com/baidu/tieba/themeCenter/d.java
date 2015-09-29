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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinItemView;
/* loaded from: classes.dex */
public class d {
    private com.baidu.tbadk.core.dialog.a Lt;
    private SkinItemView.a dee;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        a(new e(this));
    }

    public void b(b bVar) {
        if (bVar != null && bVar.getId() > 0) {
            TiebaStatic.log("c10267");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SkinDetailActivityConfig(this.mPageContext.getPageActivity(), bVar.getId(), bVar.azc(), bVar.getPicUrl(), bVar.ayZ())));
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
            int azc = bVar.azc();
            if (azc == 1 || azc == 5 || azc == 3) {
                if (azc == 1) {
                    TiebaStatic.log("c10268");
                } else if (azc == 5) {
                    TiebaStatic.log("c10270");
                }
                if (i.lr(bVar.azb())) {
                    if (!StringUtils.isNull(bVar.ayY())) {
                        skinProgressView.e(2, 0.0f);
                        com.baidu.tbadk.download.b.An().a(new StringBuilder().append(bVar.getId()).toString(), bVar.ayY(), bVar.getTitle(), 0, bVar.getId(), false, true, false);
                        return;
                    }
                    return;
                }
                i.a(this.mPageContext, 1, i.h.become_member_can_use);
            } else if (azc == 2) {
                skinProgressView.e(3, 0.0f);
                com.baidu.tbadk.download.b.An().eG(bVar.ayY());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DELETE_SKIN_TEMP_FILE, bVar));
            } else if (azc == 4) {
                TiebaStatic.log("c10269");
                if (i.lr(bVar.azb())) {
                    if (bVar.getId() == -1) {
                        TbadkCoreApplication.m411getInst().setSkinType(0);
                    } else if (bVar.getId() == -2) {
                        TbadkCoreApplication.m411getInst().setSkinType(1);
                    } else {
                        TbadkCoreApplication.m411getInst().setUsedTheme(bVar.getId(), bVar.azb());
                        TiebaStatic.log(new ap("c10220").r("obj_id", bVar.getId()).r("obj_type", bVar.azb()));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_THEME_LIST));
                    return;
                }
                i.a(this.mPageContext, 1, i.h.become_member_can_use);
            }
        }
    }

    private void d(b bVar) {
        if (this.Lt == null) {
            this.Lt = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
            this.Lt.bF(i.h.tip_delete_used_skin);
            this.Lt.b(i.h.cancel_text, new f(this));
            this.Lt.a(i.h.delete, new g(this, bVar));
            this.Lt.b(this.mPageContext);
        }
        this.Lt.sR();
    }

    public SkinItemView.a azg() {
        return this.dee;
    }

    public void a(SkinItemView.a aVar) {
        this.dee = aVar;
    }
}
