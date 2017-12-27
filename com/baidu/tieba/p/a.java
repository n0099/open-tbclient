package com.baidu.tieba.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.UegWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import tbclient.BlockPopInfo;
/* loaded from: classes.dex */
public class a {
    private static BlockPopInfo hwf;
    private static BlockPopInfo hwg;
    private TbPageContext aQq;
    private CustomMessageListener dJy = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.p.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                a.d(null);
                a.e(null);
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.aQq = tbPageContext;
        this.aQq.registerListener(this.dJy);
    }

    private boolean a(BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null && blockPopInfo.can_post.intValue() == 0 && (blockPopInfo.ahead_type.intValue() == 1 || blockPopInfo.ahead_type.intValue() == 2)) {
            if (blockPopInfo.ahead_type.intValue() == 1) {
                b(blockPopInfo);
                return true;
            } else if (blockPopInfo.ahead_type.intValue() == 2) {
                c(blockPopInfo);
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean bGn() {
        return a(hwf);
    }

    public boolean bGo() {
        return a(hwg);
    }

    private void b(final BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aQq.getPageActivity());
            aVar.cZ(blockPopInfo.block_info);
            aVar.b(blockPopInfo.ok_info, new a.b() { // from class: com.baidu.tieba.p.a.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.a(blockPopInfo.ahead_info, new a.b() { // from class: com.baidu.tieba.p.a.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    a.this.c(blockPopInfo);
                }
            });
            aVar.b(this.aQq).AI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UegWebViewActivityConfig(this.aQq.getPageActivity(), blockPopInfo.ahead_url)));
        }
    }

    public static void d(BlockPopInfo blockPopInfo) {
        hwf = blockPopInfo;
    }

    public static void e(BlockPopInfo blockPopInfo) {
        hwg = blockPopInfo;
    }
}
