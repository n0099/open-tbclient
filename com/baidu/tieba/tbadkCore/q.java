package com.baidu.tieba.tbadkCore;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    public static void r(List<com.baidu.adp.widget.ListView.i> list, int i) {
        int i2;
        boolean z;
        if (list != null && list.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(2016447) != null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof ab) {
                    if (z2) {
                        if (!((ab) list.get(i3)).isValid()) {
                            ((ab) list.get(i3)).yg();
                        }
                        if (((ab) list.get(i3)).isValid()) {
                            ICardInfo yh = ((ab) list.get(i3)).yh();
                            int viewCount = yh.getViewCount();
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < viewCount; i4++) {
                                ICardInfo viewItem = yh.getViewItem(i4, i);
                                if (viewItem != null) {
                                    viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.faH.get(viewItem.getCardType()));
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

    public static void s(List<Object> list, int i) {
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
                                viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.faH.get(viewItem.getCardType()));
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

    public static ArrayList<BdUniqueId> bwj() {
        int size = com.baidu.tieba.lego.card.e.faH.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(com.baidu.tieba.lego.card.e.faH.valueAt(i));
        }
        return arrayList;
    }

    public static boolean sG(String str) {
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
        if (com.baidu.tieba.recapp.s.o(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TbWebViewActivityConfig.PARAMS_KEY)))) {
            return 1;
        }
        return g(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    private static boolean g(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        if (aw.Du().eC(str)) {
            aw.Du().a(tbPageContext, strArr, true);
            return true;
        }
        return aw.Du().c(tbPageContext, strArr);
    }

    public static boolean bhI() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense == null || adAdSense.Fv()) ? com.baidu.adp.lib.util.j.oK() : (com.baidu.adp.lib.util.j.oL() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.j.oK() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }

    public static boolean bwk() {
        com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense != null && adAdSense.Fw()) ? com.baidu.adp.lib.util.j.oK() : (com.baidu.adp.lib.util.j.oL() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.j.oK() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }
}
