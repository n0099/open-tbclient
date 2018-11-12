package com.baidu.tieba.tbadkCore;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    public static void q(List<com.baidu.adp.widget.ListView.h> list, int i) {
        int i2;
        boolean z;
        if (list != null && list.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof ab) {
                    if (z2) {
                        if (!((ab) list.get(i3)).isValid()) {
                            ((ab) list.get(i3)).xt();
                        }
                        if (((ab) list.get(i3)).isValid()) {
                            ICardInfo xu = ((ab) list.get(i3)).xu();
                            int viewCount = xu.getViewCount();
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < viewCount; i4++) {
                                ICardInfo viewItem = xu.getViewItem(i4, i);
                                if (viewItem != null) {
                                    viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.ffQ.get(viewItem.getCardType()));
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
            boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
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
                                viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.ffQ.get(viewItem.getCardType()));
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

    public static ArrayList<BdUniqueId> bAK() {
        int size = com.baidu.tieba.lego.card.e.ffQ.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(com.baidu.tieba.lego.card.e.ffQ.valueAt(i));
        }
        return arrayList;
    }

    public static boolean uW(String str) {
        return str != null && str.startsWith("tieba://deeplink?");
    }

    public static int e(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return f(tbPageContext, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (com.baidu.tieba.recapp.s.c(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter("jump")))) {
            return 1;
        }
        return f(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    private static boolean f(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        if (ay.Db().fA(str)) {
            ay.Db().a((TbPageContext<?>) tbPageContext, strArr, true);
            return true;
        }
        return ay.Db().c(tbPageContext, strArr);
    }

    public static boolean blL() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense == null || adAdSense.Fq()) ? com.baidu.adp.lib.util.j.kW() : (com.baidu.adp.lib.util.j.kX() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.j.kW() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }

    public static boolean bAL() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense != null && adAdSense.Fr()) ? com.baidu.adp.lib.util.j.kW() : (com.baidu.adp.lib.util.j.kX() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.j.kW() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }
}
