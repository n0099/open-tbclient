package com.baidu.tieba.tbadkCore;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    public static void q(List<com.baidu.adp.widget.ListView.v> list, int i) {
        int i2;
        boolean z;
        if (list != null && list.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof ai) {
                    if (z2) {
                        if (!((ai) list.get(i3)).isValid()) {
                            ((ai) list.get(i3)).pX();
                        }
                        if (((ai) list.get(i3)).isValid()) {
                            ICardInfo pY = ((ai) list.get(i3)).pY();
                            int viewCount = pY.getViewCount();
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < viewCount; i4++) {
                                ICardInfo viewItem = pY.getViewItem(i4, i);
                                if (viewItem != null) {
                                    viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.dDa.get(viewItem.getCardType()));
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

    public static void r(List<Object> list, int i) {
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
                                viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.dDa.get(viewItem.getCardType()));
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

    public static ArrayList<BdUniqueId> blE() {
        int size = com.baidu.tieba.lego.card.e.dDa.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(com.baidu.tieba.lego.card.e.dDa.valueAt(i));
        }
        return arrayList;
    }

    public static boolean rf(String str) {
        return str != null && str.startsWith("tieba://deeplink?");
    }

    public static int h(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return i(tbPageContext, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (com.baidu.tieba.recapp.ad.c(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter("jump")))) {
            return 1;
        }
        return i(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    private static boolean i(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        if (be.vP().ea(str)) {
            be.vP().a(tbPageContext, strArr, true);
            return true;
        }
        return be.vP().c(tbPageContext, strArr);
    }

    public static boolean aTu() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        return !(adAdSense == null || adAdSense.xE()) ? com.baidu.adp.lib.util.i.hk() : (com.baidu.adp.lib.util.i.hl() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.i.hk() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() != 1);
    }

    public static boolean blF() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        return !(adAdSense != null && adAdSense.xF()) ? com.baidu.adp.lib.util.i.hk() : (com.baidu.adp.lib.util.i.hl() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.i.hk() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() != 1);
    }
}
