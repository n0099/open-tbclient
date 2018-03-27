package com.baidu.tieba.p;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import tbclient.BlockPopInfo;
/* loaded from: classes.dex */
public class a {
    private static BlockPopInfo hnC;
    private static BlockPopInfo hnD;
    private TbPageContext aRI;
    private CustomMessageListener cde = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.p.a.3
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
        this.aRI = tbPageContext;
        this.aRI.registerListener(this.cde);
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

    public boolean bAA() {
        return a(hnC);
    }

    public boolean bAB() {
        return a(hnD);
    }

    private void b(final BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
            aVar.dk(blockPopInfo.block_info);
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
            aVar.b(this.aRI).AV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null) {
            AntiHelper.as(this.aRI.getPageActivity(), blockPopInfo.ahead_url);
        }
    }

    public static void d(BlockPopInfo blockPopInfo) {
        hnC = blockPopInfo;
    }

    public static void e(BlockPopInfo blockPopInfo) {
        hnD = blockPopInfo;
    }
}
