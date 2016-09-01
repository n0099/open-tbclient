package com.baidu.tieba.tbadkCore;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class v {
    public static void r(List<com.baidu.adp.widget.ListView.v> list, int i) {
        int i2;
        boolean z;
        if (list != null && list.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof com.baidu.tbadk.core.data.ad) {
                    if (z2) {
                        if (!((com.baidu.tbadk.core.data.ad) list.get(i3)).isValid()) {
                            ((com.baidu.tbadk.core.data.ad) list.get(i3)).qd();
                        }
                        if (((com.baidu.tbadk.core.data.ad) list.get(i3)).isValid()) {
                            ICardInfo qe = ((com.baidu.tbadk.core.data.ad) list.get(i3)).qe();
                            int viewCount = qe.getViewCount();
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < viewCount; i4++) {
                                ICardInfo viewItem = qe.getViewItem(i4, i);
                                if (viewItem != null) {
                                    viewItem.setBdUniqueId(com.baidu.tieba.lego.card.d.dAD.get(viewItem.getCardType()));
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
                                viewItem.setBdUniqueId(com.baidu.tieba.lego.card.d.dAD.get(viewItem.getCardType()));
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

    public static ArrayList<BdUniqueId> bih() {
        int size = com.baidu.tieba.lego.card.d.dAD.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(com.baidu.tieba.lego.card.d.dAD.valueAt(i));
        }
        return arrayList;
    }

    public static String qN(String str) {
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

    public static String qO(String str) {
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

    public static int qP(String str) {
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

    public static int qQ(String str) {
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

    public static int j(TbPageContext tbPageContext, String str) {
        if (tbPageContext == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        if (!str.startsWith("tieba://deeplink?")) {
            return k(tbPageContext, str) ? 3 : 0;
        }
        Uri parse = Uri.parse(str);
        if (com.baidu.tieba.recapp.f.c(tbPageContext.getPageActivity(), Uri.parse(parse.getQueryParameter("jump")))) {
            return 1;
        }
        return k(tbPageContext, parse.getQueryParameter("wap")) ? 2 : 0;
    }

    private static boolean k(TbPageContext tbPageContext, String str) {
        String[] strArr = {str};
        if (bi.vx().dK(str)) {
            bi.vx().a(tbPageContext, strArr, true);
            return true;
        }
        return bi.vx().c(tbPageContext, strArr);
    }
}
