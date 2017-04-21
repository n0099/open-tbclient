package com.baidu.tieba.tbadkCore;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    public static void r(List<com.baidu.adp.widget.ListView.v> list, int i) {
        int i2;
        boolean z;
        if (list != null && list.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof ah) {
                    if (z2) {
                        if (!((ah) list.get(i3)).isValid()) {
                            ((ah) list.get(i3)).qZ();
                        }
                        if (((ah) list.get(i3)).isValid()) {
                            ICardInfo ra = ((ah) list.get(i3)).ra();
                            int viewCount = ra.getViewCount();
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < viewCount; i4++) {
                                ICardInfo viewItem = ra.getViewItem(i4, i);
                                if (viewItem != null) {
                                    viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.duL.get(viewItem.getCardType()));
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
                                viewItem.setBdUniqueId(com.baidu.tieba.lego.card.e.duL.get(viewItem.getCardType()));
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

    public static ArrayList<BdUniqueId> biv() {
        int size = com.baidu.tieba.lego.card.e.duL.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(com.baidu.tieba.lego.card.e.duL.valueAt(i));
        }
        return arrayList;
    }

    public static String pU(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                return jSONObject.optString(LegoListActivityConfig.ITEM_ID);
            }
            return "";
        } catch (JSONException e) {
            return "";
        }
    }

    public static String pV(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                return jSONObject.optString("stat_time_count");
            }
            return "";
        } catch (JSONException e) {
            return "";
        }
    }

    public static int pW(String str) {
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("page_type");
                if (optInt > 0) {
                    return optInt;
                }
                return 2;
            }
            return 2;
        } catch (JSONException e) {
            return 2;
        }
    }

    public static int pX(String str) {
        if (TextUtils.isEmpty(str)) {
            return 30;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                int optInt = jSONObject.optInt(LegoListActivityConfig.RN);
                if (optInt > 0) {
                    return optInt;
                }
                return 30;
            }
            return 30;
        } catch (JSONException e) {
            return 30;
        }
    }

    public static boolean pY(String str) {
        return str != null && str.startsWith("tieba://deeplink?");
    }

    public static int i(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return j(tbPageContext, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (com.baidu.tieba.recapp.y.c(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter("jump")))) {
            return 1;
        }
        return j(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    private static boolean j(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        if (bb.wn().dL(str)) {
            bb.wn().a(tbPageContext, strArr, true);
            return true;
        }
        return bb.wn().c(tbPageContext, strArr);
    }

    public static boolean aQL() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        return !(adAdSense == null || adAdSense.yg()) ? com.baidu.adp.lib.util.i.hl() : (com.baidu.adp.lib.util.i.hm() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.i.hl() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() != 1);
    }

    public static boolean biw() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        return !(adAdSense != null && adAdSense.yh()) ? com.baidu.adp.lib.util.i.hl() : (com.baidu.adp.lib.util.i.hm() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() == 2) || (com.baidu.adp.lib.util.i.hl() && TbadkCoreApplication.m9getInst().getVideoAutoPlay() != 1);
    }
}
