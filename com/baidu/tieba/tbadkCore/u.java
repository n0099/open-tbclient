package com.baidu.tieba.tbadkCore;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u {
    public static void x(List<com.baidu.adp.widget.ListView.q> list, int i) {
        int i2;
        boolean z;
        if (list != null && list.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof ak) {
                    if (z2) {
                        if (!((ak) list.get(i3)).isValid()) {
                            ((ak) list.get(i3)).bkQ();
                        }
                        if (((ak) list.get(i3)).isValid()) {
                            ICardInfo bkR = ((ak) list.get(i3)).bkR();
                            int viewCount = bkR.getViewCount();
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < viewCount; i4++) {
                                ICardInfo viewItem = bkR.getViewItem(i4, i);
                                if (viewItem != null) {
                                    viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.kEC.get(viewItem.getCardType()));
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

    public static void y(List<Object> list, int i) {
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
                                viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.kEC.get(viewItem.getCardType()));
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

    public static ArrayList<BdUniqueId> dJq() {
        int size = com.baidu.tieba.lego.card.e.kEC.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(com.baidu.tieba.lego.card.e.kEC.valueAt(i));
        }
        return arrayList;
    }

    public static boolean Rp(String str) {
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
        if (com.baidu.tieba.recapp.s.f(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter(TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT)))) {
            return 1;
        }
        return i(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    private static boolean i(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        if (be.brr().UrlValidated(str)) {
            be.brr().a((TbPageContext<?>) tbPageContext, strArr, true);
            return true;
        }
        return be.brr().b(tbPageContext, strArr);
    }

    public static boolean dBE() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense == null || adAdSense.buq()) ? com.baidu.adp.lib.util.j.isWifiNet() : (com.baidu.adp.lib.util.j.isMobileNet() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.j.isWifiNet() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }

    public static boolean dJr() {
        com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        return !(adAdSense != null && adAdSense.bur()) ? com.baidu.adp.lib.util.j.isWifiNet() : (com.baidu.adp.lib.util.j.isMobileNet() && TbadkCoreApplication.getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.j.isWifiNet() && TbadkCoreApplication.getInst().getVideoAutoPlay() != 1);
    }
}
