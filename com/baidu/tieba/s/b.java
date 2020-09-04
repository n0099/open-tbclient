package com.baidu.tieba.s;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<BdUniqueId, ArrayList<aq>> mcw;
    private String[] mcx = {"obj_floor", "obj_isad", "obj_id", "tid", "pid", "thread_type", "fid", "post_type", "obj_isofficial", "obj_adlocate", "recom_weight", IntentConfig.RECOM_SOURCE, "recom_ab_tag", "recom_extra", "recom_type", "ugc_vid", "ugc_nid", "ori_ugc_type"};

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        if (this.mcw == null) {
            this.mcw = new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.mcw.put(bdUniqueId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.mcw.remove(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, aq aqVar) {
        if (aqVar != null && bdUniqueId != null) {
            ArrayList<aq> arrayList = this.mcw.get(bdUniqueId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.mcw.put(bdUniqueId, arrayList);
            }
            arrayList.add(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean C(BdUniqueId bdUniqueId) {
        return this.mcw.containsKey(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dvI() {
        if (this.mcw.size() != 0) {
            for (Map.Entry<BdUniqueId, ArrayList<aq>> entry : this.mcw.entrySet()) {
                ArrayList<aq> value = entry.getValue();
                if (value != null) {
                    value.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, boolean z) {
        if (bdUniqueId != null) {
            ArrayList<aq> arrayList = this.mcw.get(bdUniqueId);
            if (y.getCount(arrayList) != 0) {
                bd(arrayList);
                arrayList.clear();
            }
        }
    }

    private void bd(ArrayList<aq> arrayList) {
        if (arrayList != null && y.getCount(arrayList) != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (y.getCount(arrayList) == 1) {
                TiebaStatic.log((aq) y.getItem(arrayList, 0));
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < arrayList.size(); i++) {
                    aq aqVar = arrayList.get(i);
                    if (hashMap.containsKey(aqVar.getKey())) {
                        ((List) hashMap.get(aqVar.getKey())).add(aqVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(aqVar);
                        hashMap.put(aqVar.getKey(), arrayList2);
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    List list = (List) entry.getValue();
                    if (y.getCount(list) != 0) {
                        aq aqVar2 = (aq) list.get(0);
                        for (int i2 = 0; i2 < this.mcx.length; i2++) {
                            StringBuilder sb = new StringBuilder();
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                sb.append(m(((aq) list.get(i3)).getParams(), this.mcx[i2]));
                                sb.append("|");
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            aqVar2.delete(this.mcx[i2]);
                            aqVar2.dD(this.mcx[i2] + "s", sb.toString());
                        }
                        TiebaStatic.log(aqVar2);
                    }
                }
                if (hashMap != null && !hashMap.isEmpty()) {
                    hashMap.clear();
                }
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("logStatisticByKey->" + (System.currentTimeMillis() - currentTimeMillis) + "|size=" + arrayList.size());
            }
        }
    }

    private String m(List<Object> list, String str) {
        int indexOf;
        if (y.getCount(list) != 0 && !StringUtils.isNull(str) && (indexOf = list.indexOf(str)) >= 0 && list.size() > indexOf + 1) {
            String valueOf = String.valueOf(list.get(indexOf + 1));
            return StringUtils.isNull(valueOf, true) ? "" : valueOf;
        }
        return "";
    }
}
