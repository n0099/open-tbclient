package com.baidu.tieba.tbadkCore;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    public static void s(List<com.baidu.adp.widget.ListView.o> list, int i) {
        int i2;
        boolean z;
        if (list != null && list.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof ad) {
                    if (z2) {
                        if (!((ad) list.get(i3)).isValid()) {
                            ((ad) list.get(i3)).aOU();
                        }
                        if (((ad) list.get(i3)).isValid()) {
                            ICardInfo aOV = ((ad) list.get(i3)).aOV();
                            int viewCount = aOV.getViewCount();
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < viewCount; i4++) {
                                ICardInfo viewItem = aOV.getViewItem(i4, i);
                                if (viewItem != null) {
                                    viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.iYq.get(viewItem.getCardType()));
                                    arrayList.add(viewItem);
                                }
                            }
                            if (arrayList.size() == 0) {
                                z = true;
                                i2 = 1;
                            } else {
                                list.remove(i3);
                                list.addAll(i3, arrayList);
                                i2 = arrayList.size();
                                z = false;
                            }
                        } else {
                            z = true;
                            i2 = 1;
                        }
                    } else {
                        z = true;
                        i2 = 1;
                    }
                    if (z) {
                        list.remove(i3);
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                i3 = i2 + i3;
            }
        }
    }

    public static void t(List<Object> list, int i) {
        int i2;
        boolean z;
        if (list != null && list.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof ICardInfo) {
                    if (z2) {
                        ICardInfo iCardInfo = (ICardInfo) list.get(i3);
                        int viewCount = iCardInfo.getViewCount();
                        ArrayList arrayList = new ArrayList();
                        for (int i4 = 0; i4 < viewCount; i4++) {
                            ICardInfo viewItem = iCardInfo.getViewItem(i4, i);
                            if (viewItem != null) {
                                viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.iYq.get(viewItem.getCardType()));
                                arrayList.add(viewItem);
                            }
                        }
                        if (arrayList.size() == 0) {
                            z = true;
                            i2 = 1;
                        } else {
                            list.remove(i3);
                            list.addAll(i3, arrayList);
                            i2 = arrayList.size();
                            z = false;
                        }
                    } else {
                        z = true;
                        i2 = 1;
                    }
                    if (z) {
                        list.remove(i3);
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                i3 = i2 + i3;
            }
        }
    }

    public static ArrayList<BdUniqueId> dcL() {
        int size = com.baidu.tieba.lego.card.e.iYq.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(com.baidu.tieba.lego.card.e.iYq.valueAt(i));
        }
        return arrayList;
    }

    public static boolean Mt(String str) {
        return str != null && str.startsWith("tieba://deeplink?");
    }

    public static int f(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return g(tbPageContext, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (com.baidu.tieba.recapp.r.e(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)))) {
            return 1;
        }
        return g(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    private static boolean g(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        if (ba.aUZ().UrlValidated(str)) {
            ba.aUZ().a((TbPageContext<?>) tbPageContext, strArr, true);
            return true;
        }
        return ba.aUZ().b(tbPageContext, strArr);
    }

    public static boolean cVy() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense == null || adAdSense.aXK()) ? com.baidu.adp.lib.util.j.isWifiNet() : (com.baidu.adp.lib.util.j.isMobileNet() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.j.isWifiNet() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }

    public static boolean dcM() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense != null && adAdSense.aXL()) ? com.baidu.adp.lib.util.j.isWifiNet() : (com.baidu.adp.lib.util.j.isMobileNet() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.j.isWifiNet() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }
}
