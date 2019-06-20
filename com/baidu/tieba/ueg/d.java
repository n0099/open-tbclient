package com.baidu.tieba.ueg;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import tbclient.BlockPopInfo;
/* loaded from: classes.dex */
public class d {
    private static BlockPopInfo jmQ;
    private static BlockPopInfo jmR;
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.ueg.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                d.d(null);
                d.e(null);
            }
        }
    };
    private TbPageContext mContext;

    public d(TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.mContext.registerListener(this.mAccountChangedListener);
    }

    private boolean a(BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null && blockPopInfo.appeal_status != null && blockPopInfo.appeal_status.intValue() == 1) {
            BdToast.b(this.mContext.getPageActivity(), blockPopInfo.appeal_msg, R.drawable.icon_toast_game_error, 3000).afO();
            return true;
        } else if (blockPopInfo != null && blockPopInfo.can_post.intValue() == 0 && ((blockPopInfo.ahead_type.intValue() == 1 || blockPopInfo.ahead_type.intValue() == 2) && blockPopInfo.appeal_status.intValue() != 1)) {
            if (blockPopInfo.ahead_type.intValue() == 1) {
                String str = blockPopInfo.block_info;
                String str2 = blockPopInfo.ok_info;
                if (ap.isEmpty(str) || ap.isEmpty(str2)) {
                    BdToast.b(this.mContext.getPageActivity(), this.mContext.getString(R.string.hanpen_error), R.drawable.icon_toast_game_error, 3000).afO();
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
        } else {
            return false;
        }
    }

    public boolean cqt() {
        return a(jmQ);
    }

    public boolean cqu() {
        return a(jmR);
    }

    private void b(final BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.mD(blockPopInfo.block_info);
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
            aVar.b(this.mContext).afG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(BlockPopInfo blockPopInfo) {
        if (blockPopInfo != null) {
            AntiHelper.aJ(this.mContext.getPageActivity(), blockPopInfo.ahead_url);
        }
    }

    public static void d(BlockPopInfo blockPopInfo) {
        jmQ = blockPopInfo;
    }

    public static void e(BlockPopInfo blockPopInfo) {
        jmR = blockPopInfo;
    }
}
