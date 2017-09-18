package com.baidu.tieba.tbadkCore;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    public static void p(List<com.baidu.adp.widget.ListView.f> list, int i) {
        int i2;
        boolean z;
        if (list != null && list.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof ah) {
                    if (z2) {
                        if (!((ah) list.get(i3)).isValid()) {
                            ((ah) list.get(i3)).qg();
                        }
                        if (((ah) list.get(i3)).isValid()) {
                            ICardInfo qh = ((ah) list.get(i3)).qh();
                            int viewCount = qh.getViewCount();
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < viewCount; i4++) {
                                ICardInfo viewItem = qh.getViewItem(i4, i);
                                if (viewItem != null) {
                                    viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.dWx.get(viewItem.getCardType()));
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

    public static void q(List<Object> list, int i) {
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
                                viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.dWx.get(viewItem.getCardType()));
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

    public static ArrayList<BdUniqueId> brJ() {
        int size = com.baidu.tieba.lego.card.e.dWx.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(com.baidu.tieba.lego.card.e.dWx.valueAt(i));
        }
        return arrayList;
    }

    public static boolean rZ(String str) {
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
        if (com.baidu.tieba.recapp.s.c(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TbWebViewActivityConfig.PARAMS_KEY)))) {
            return 1;
        }
        return i(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    private static boolean i(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        if (au.wd().ef(str)) {
            au.wd().a(tbPageContext, strArr, true);
            return true;
        }
        return au.wd().c(tbPageContext, strArr);
    }

    public static boolean aWB() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense == null || adAdSense.xZ()) ? com.baidu.adp.lib.util.i.hj() : (com.baidu.adp.lib.util.i.hk() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.i.hj() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }

    public static boolean brK() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense != null && adAdSense.ya()) ? com.baidu.adp.lib.util.i.hj() : (com.baidu.adp.lib.util.i.hk() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.i.hj() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }
}
