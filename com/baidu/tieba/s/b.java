package com.baidu.tieba.s;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<BdUniqueId, ArrayList<ao>> lDh;
    private String[] lDi = {"obj_floor", "obj_isad", "obj_id", "tid", "pid", "thread_type", "fid", "post_type", "obj_isofficial", "obj_adlocate", "recom_weight", IntentConfig.RECOM_SOURCE, "recom_ab_tag", "recom_extra", "recom_type", "ugc_vid", "ugc_nid", "ori_ugc_type"};

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        if (this.lDh == null) {
            this.lDh = new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.lDh.put(bdUniqueId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.lDh.remove(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, ao aoVar) {
        if (aoVar != null && bdUniqueId != null) {
            ArrayList<ao> arrayList = this.lDh.get(bdUniqueId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.lDh.put(bdUniqueId, arrayList);
            }
            arrayList.add(aoVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(BdUniqueId bdUniqueId) {
        return this.lDh.containsKey(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dgW() {
        if (this.lDh.size() != 0) {
            for (Map.Entry<BdUniqueId, ArrayList<ao>> entry : this.lDh.entrySet()) {
                ArrayList<ao> value = entry.getValue();
                if (value != null) {
                    value.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, boolean z) {
        if (bdUniqueId != null) {
            ArrayList<ao> arrayList = this.lDh.get(bdUniqueId);
            if (w.getCount(arrayList) != 0) {
                aW(arrayList);
                arrayList.clear();
            }
        }
    }

    private void aW(ArrayList<ao> arrayList) {
        if (arrayList != null && w.getCount(arrayList) != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (w.getCount(arrayList) == 1) {
                TiebaStatic.log((ao) w.getItem(arrayList, 0));
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < arrayList.size(); i++) {
                    ao aoVar = arrayList.get(i);
                    if (hashMap.containsKey(aoVar.getKey())) {
                        ((List) hashMap.get(aoVar.getKey())).add(aoVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(aoVar);
                        hashMap.put(aoVar.getKey(), arrayList2);
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    List list = (List) entry.getValue();
                    if (w.getCount(list) != 0) {
                        ao aoVar2 = (ao) list.get(0);
                        for (int i2 = 0; i2 < this.lDi.length; i2++) {
                            StringBuilder sb = new StringBuilder();
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                sb.append(l(((ao) list.get(i3)).getParams(), this.lDi[i2]));
                                sb.append("|");
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            aoVar2.delete(this.lDi[i2]);
                            aoVar2.dk(this.lDi[i2] + "s", sb.toString());
                        }
                        TiebaStatic.log(aoVar2);
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

    private String l(List<Object> list, String str) {
        int indexOf;
        if (w.getCount(list) != 0 && !StringUtils.isNull(str) && (indexOf = list.indexOf(str)) >= 0 && list.size() > indexOf + 1) {
            String valueOf = String.valueOf(list.get(indexOf + 1));
            return StringUtils.isNull(valueOf, true) ? "" : valueOf;
        }
        return "";
    }
}
