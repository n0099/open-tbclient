package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes8.dex */
public class b {
    public static boolean a(DressItemData dressItemData) {
        int freeUserLevel = dressItemData.getFreeUserLevel();
        if (dressItemData.isDefault() || freeUserLevel == 0) {
            return true;
        }
        if (freeUserLevel == 100) {
            return dressItemData.getActivityFinish() != 0;
        }
        return freeUserLevel == 101 ? TbadkCoreApplication.getCurrentMemberType() == 3 : TbadkCoreApplication.getCurrentMemberType() >= 2 && TbadkCoreApplication.getCurrentVipLevel() >= freeUserLevel;
    }

    public static void a(TbPageContext<?> tbPageContext, int i, String str, int i2) {
        if (tbPageContext != null) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.nv(R.color.CAM_X0305);
            aVar.Ac(str);
            a.b bVar = new a.b() { // from class: com.baidu.tieba.themeCenter.b.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tbadk.core.dialog.a.this.dismiss();
                }
            };
            aVar.b(R.string.cancel, bVar);
            aVar.a(R.string.know, bVar);
            aVar.b(tbPageContext);
            aVar.bqe();
        }
    }

    public static void a(final TbPageContext<?> tbPageContext, final int i, String str, final int i2, final String str2, final String str3) {
        if (tbPageContext != null) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.nv(R.color.CAM_X0305);
            aVar.Ad(str);
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.themeCenter.b.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tbadk.core.dialog.a.this.dismiss();
                }
            });
            aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.themeCenter.b.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tbadk.core.dialog.a.this.dismiss();
                    int i3 = 0;
                    String str4 = null;
                    switch (i) {
                        case 1:
                            i3 = 10;
                            str4 = "4011001001";
                            TiebaStatic.log("c10271");
                            break;
                        case 2:
                            i3 = 13;
                            str4 = "4012001001";
                            TiebaStatic.log("c10282");
                            break;
                        case 3:
                            i3 = 11;
                            str4 = "4011001002";
                            TiebaStatic.log("c10276");
                            break;
                        case 4:
                            i3 = 14;
                            str4 = "4012001002";
                            TiebaStatic.log("c10285");
                            break;
                        case 5:
                            i3 = 18;
                            TiebaStatic.log("c10767");
                            break;
                        case 7:
                            i3 = 22;
                            break;
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(tbPageContext.getPageActivity(), TbadkCoreApplication.getCurrentMemberType(), "", i3);
                    if (!StringUtils.isNULL(str4)) {
                        memberPayActivityConfig.setSceneId(str4);
                    }
                    memberPayActivityConfig.setFromScence(i2);
                    memberPayActivityConfig.setReferPageClickZone(str2, str3);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                }
            });
            aVar.b(tbPageContext);
            aVar.bqe();
        }
    }

    public static void a(final TbPageContext<?> tbPageContext, int i, final String str) {
        if (tbPageContext != null) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.nu(R.string.tip_download_activity_require);
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.themeCenter.b.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tbadk.core.dialog.a.this.dismiss();
                }
            });
            aVar.a(R.string.tip_download_activity_in, new a.b() { // from class: com.baidu.tieba.themeCenter.b.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tbadk.core.dialog.a.this.dismiss();
                    if (str != null) {
                        TbadkCoreApplication.getInst().setThemeWebviewOpen(true);
                        com.baidu.tbadk.browser.a.startInternalWebActivity(tbPageContext.getPageActivity(), str);
                    }
                }
            });
            aVar.b(tbPageContext);
            aVar.bqe();
        }
    }
}
