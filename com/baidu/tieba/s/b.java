package com.baidu.tieba.s;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import tbclient.BlockPopInfo;
/* loaded from: classes.dex */
public class b {
    private static BlockPopInfo gVM;
    private static BlockPopInfo gVN;
    private CustomMessageListener bvy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.s.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                b.d(null);
                b.e(null);
            }
        }
    };
    private TbPageContext mContext;

    public b(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.mContext.registerListener(this.bvy);
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

    public boolean bAH() {
        return a(gVM);
    }

    public boolean bAI() {
        return a(gVN);
    }

    private void b(final BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.dB(blockPopInfo.block_info);
            aVar.b(blockPopInfo.ok_info, new a.b() { // from class: com.baidu.tieba.s.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.a(blockPopInfo.ahead_info, new a.b() { // from class: com.baidu.tieba.s.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    b.this.c(blockPopInfo);
                }
            });
            aVar.b(this.mContext).xa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null) {
            AntiHelper.ap(this.mContext.getPageActivity(), blockPopInfo.ahead_url);
        }
    }

    public static void d(BlockPopInfo blockPopInfo) {
        gVM = blockPopInfo;
    }

    public static void e(BlockPopInfo blockPopInfo) {
        gVN = blockPopInfo;
    }
}
