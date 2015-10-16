package com.baidu.tieba.themeCenter;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetUpdateInfo.ThemeSkinUpdateInfo;
/* loaded from: classes.dex */
public class i {
    public static boolean lt(int i) {
        return i == 0 || TbadkCoreApplication.getCurrentMemberType() >= 2;
    }

    public static int a(b bVar, List<b> list) {
        b bVar2;
        if (bVar == null) {
            return 1;
        }
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (bVar.getId() == -1) {
            if (skinType == 3 || skinType == 0) {
                bVar.gJ(true);
                return 0;
            }
            bVar.gJ(false);
            return 4;
        } else if (bVar.getId() == -2) {
            if (skinType == 1) {
                bVar.gJ(true);
                return 0;
            }
            bVar.gJ(false);
            return 4;
        } else if (list == null || list.size() <= 0) {
            bVar.gJ(false);
            return 1;
        } else {
            if (bVar.getId() == TbadkCoreApplication.m411getInst().getUsedThemeId() && skinType == 2) {
                bVar.gJ(true);
            } else {
                bVar.gJ(false);
            }
            Iterator<b> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar2 = null;
                    break;
                }
                bVar2 = it.next();
                if (bVar2 != null && bVar.getId() == bVar2.getId()) {
                    break;
                }
            }
            if (bVar2 == null) {
                return 1;
            }
            if (bVar2.getVersionCode() < bVar.getVersionCode()) {
                return 5;
            }
            return (bVar.getId() == TbadkCoreApplication.m411getInst().getUsedThemeId() && skinType == 2) ? 0 : 4;
        }
    }

    public static int a(b bVar, ArrayList<ThemeSkinUpdateInfo> arrayList) {
        ThemeSkinUpdateInfo themeSkinUpdateInfo;
        if (bVar == null) {
            return 4;
        }
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (bVar.getId() == -1) {
            if (skinType == 3 || skinType == 0) {
                bVar.gJ(true);
                return 0;
            }
            bVar.gJ(false);
            return 4;
        } else if (bVar.getId() == -2) {
            if (skinType == 1) {
                bVar.gJ(true);
                return 0;
            }
            bVar.gJ(false);
            return 4;
        } else {
            boolean z = bVar.getId() == TbadkCoreApplication.m411getInst().getUsedThemeId() && skinType == 2;
            bVar.gJ(z);
            if (arrayList == null || arrayList.size() <= 0) {
                return !z ? 4 : 0;
            }
            Iterator<ThemeSkinUpdateInfo> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    themeSkinUpdateInfo = null;
                    break;
                }
                themeSkinUpdateInfo = it.next();
                if (themeSkinUpdateInfo != null && themeSkinUpdateInfo.props_id.intValue() == bVar.getId()) {
                    break;
                }
            }
            if (themeSkinUpdateInfo == null) {
                return !z ? 4 : 0;
            } else if (themeSkinUpdateInfo.props_version.intValue() <= bVar.getVersionCode()) {
                return !z ? 4 : 0;
            } else {
                bVar.lT(themeSkinUpdateInfo.package_url);
                bVar.ls(themeSkinUpdateInfo.props_version.intValue());
                return 5;
            }
        }
    }

    public static ArrayList<com.baidu.tieba.themeCenter.theme.top.a> by(List<b> list) {
        int i;
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<com.baidu.tieba.themeCenter.theme.top.a> arrayList = new ArrayList<>();
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            int i5 = i3 + 1;
            if (i5 % 3 == 0) {
                com.baidu.tieba.themeCenter.theme.top.a aVar = new com.baidu.tieba.themeCenter.theme.top.a();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(list.get(i5 - 3));
                arrayList2.add(list.get(i5 - 2));
                arrayList2.add(list.get(i5 - 1));
                i = i2 + 3;
                aVar.bD(arrayList2);
                arrayList.add(aVar);
            } else {
                i = i2;
            }
            i4++;
            i2 = i;
            i3 = i5;
        }
        if (i2 < size) {
            int i6 = size - i2;
            com.baidu.tieba.themeCenter.theme.top.a aVar2 = new com.baidu.tieba.themeCenter.theme.top.a();
            ArrayList arrayList3 = new ArrayList();
            while (true) {
                int i7 = i6;
                if (i7 < 1) {
                    break;
                }
                arrayList3.add(list.get(size - i7));
                i6 = i7 - 1;
            }
            aVar2.bD(arrayList3);
            arrayList.add(aVar2);
        }
        return arrayList;
    }

    public static void a(TbPageContext<?> tbPageContext, int i, int i2) {
        if (tbPageContext != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.bG(i.c.cp_link_tip_d);
            aVar.bE(i2);
            aVar.b(i.h.cancel_text, new j(aVar));
            aVar.a(i.h.become_member_immediately, new k(aVar, i, tbPageContext));
            aVar.b(tbPageContext);
            aVar.sR();
        }
    }
}
