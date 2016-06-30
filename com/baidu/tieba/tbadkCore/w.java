package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static void p(List<com.baidu.adp.widget.ListView.v> list, int i) {
        int i2;
        boolean z;
        if (list != null && list.size() != 0) {
            boolean z2 = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null;
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) instanceof com.baidu.tbadk.core.data.z) {
                    if (z2) {
                        if (!((com.baidu.tbadk.core.data.z) list.get(i3)).isValid()) {
                            ((com.baidu.tbadk.core.data.z) list.get(i3)).pr();
                        }
                        if (((com.baidu.tbadk.core.data.z) list.get(i3)).isValid()) {
                            ICardInfo ps = ((com.baidu.tbadk.core.data.z) list.get(i3)).ps();
                            int viewCount = ps.getViewCount();
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < viewCount; i4++) {
                                ICardInfo viewItem = ps.getViewItem(i4, i);
                                if (viewItem != null) {
                                    viewItem.setBdUniqueId(com.baidu.tieba.lego.card.c.dlW.get(viewItem.getCardType()));
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
                                viewItem.setBdUniqueId(com.baidu.tieba.lego.card.c.dlW.get(viewItem.getCardType()));
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

    public static ArrayList<BdUniqueId> bbn() {
        int size = com.baidu.tieba.lego.card.c.dlW.size();
        ArrayList<BdUniqueId> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(com.baidu.tieba.lego.card.c.dlW.valueAt(i));
        }
        return arrayList;
    }

    public static String pt(String str) {
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

    public static String pu(String str) {
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

    public static int pv(String str) {
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

    public static int pw(String str) {
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
}
