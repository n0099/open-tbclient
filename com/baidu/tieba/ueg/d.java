package com.baidu.tieba.ueg;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import tbclient.BlockPopInfo;
/* loaded from: classes.dex */
public class d {
    private static BlockPopInfo lzc;
    private static BlockPopInfo lzd;
    private TbPageContext dIF;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.ueg.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                d.d(null);
                d.e(null);
            }
        }
    };

    public d(TbPageContext tbPageContext) {
        this.dIF = tbPageContext;
        this.dIF.registerListener(this.mAccountChangedListener);
    }

    private boolean a(BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null && blockPopInfo.appeal_status != null && blockPopInfo.appeal_status.intValue() == 1) {
            BdToast.a(this.dIF.getPageActivity(), blockPopInfo.appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aSY();
            return true;
        } else if (blockPopInfo == null || blockPopInfo.can_post.intValue() != 0 || (!(blockPopInfo.ahead_type.intValue() == 1 || blockPopInfo.ahead_type.intValue() == 2) || blockPopInfo.appeal_status.intValue() == 1)) {
            return false;
        } else {
            if (blockPopInfo.ahead_type.intValue() == 1) {
                String str = blockPopInfo.block_info;
                String str2 = blockPopInfo.ok_info;
                if (aq.isEmpty(str) || aq.isEmpty(str2)) {
                    BdToast.a(this.dIF.getPageActivity(), this.dIF.getString(R.string.hanpen_error), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).aSY();
                    return true;
                }
                b(blockPopInfo);
                return true;
            } else if (blockPopInfo.ahead_type.intValue() == 2) {
                c(blockPopInfo);
                return true;
            } else {
                return true;
            }
        }
    }

    public boolean dhk() {
        return a(lzc);
    }

    public boolean dhl() {
        return a(lzd);
    }

    private void b(final BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
            aVar.vO(blockPopInfo.block_info);
            aVar.b(blockPopInfo.ok_info, new a.b() { // from class: com.baidu.tieba.ueg.d.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.a(blockPopInfo.ahead_info, new a.b() { // from class: com.baidu.tieba.ueg.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    d.this.c(blockPopInfo);
                }
            });
            aVar.b(this.dIF).aST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null) {
            AntiHelper.aY(this.dIF.getPageActivity(), blockPopInfo.ahead_url);
        }
    }

    public static void d(BlockPopInfo blockPopInfo) {
        lzc = blockPopInfo;
    }

    public static void e(BlockPopInfo blockPopInfo) {
        lzd = blockPopInfo;
    }
}
