package com.baidu.tieba.s;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<BdUniqueId, ArrayList<an>> lid;
    private String[] lie = {"obj_floor", "obj_isad", "obj_id", "tid", "pid", "thread_type", "fid", "post_type", "obj_isofficial", "obj_adlocate", "recom_weight", IntentConfig.RECOM_SOURCE, "recom_ab_tag", "recom_extra", "recom_type", "ugc_vid", "ugc_nid", "ori_ugc_type"};

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        if (this.lid == null) {
            this.lid = new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.lid.put(bdUniqueId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.lid.remove(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, an anVar) {
        if (anVar != null && bdUniqueId != null) {
            ArrayList<an> arrayList = this.lid.get(bdUniqueId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.lid.put(bdUniqueId, arrayList);
            }
            arrayList.add(anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(BdUniqueId bdUniqueId) {
        return this.lid.containsKey(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dcs() {
        if (this.lid.size() != 0) {
            for (Map.Entry<BdUniqueId, ArrayList<an>> entry : this.lid.entrySet()) {
                ArrayList<an> value = entry.getValue();
                if (value != null) {
                    value.clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(BdUniqueId bdUniqueId, boolean z) {
        if (bdUniqueId != null) {
            ArrayList<an> arrayList = this.lid.get(bdUniqueId);
            if (v.getCount(arrayList) != 0) {
                aV(arrayList);
                arrayList.clear();
            }
        }
    }

    private void aV(ArrayList<an> arrayList) {
        if (arrayList != null && v.getCount(arrayList) != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (v.getCount(arrayList) == 1) {
                TiebaStatic.log((an) v.getItem(arrayList, 0));
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < arrayList.size(); i++) {
                    an anVar = arrayList.get(i);
                    if (hashMap.containsKey(anVar.getKey())) {
                        ((List) hashMap.get(anVar.getKey())).add(anVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(anVar);
                        hashMap.put(anVar.getKey(), arrayList2);
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    List list = (List) entry.getValue();
                    if (v.getCount(list) != 0) {
                        an anVar2 = (an) list.get(0);
                        for (int i2 = 0; i2 < this.lie.length; i2++) {
                            StringBuilder sb = new StringBuilder();
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                sb.append(l(((an) list.get(i3)).getParams(), this.lie[i2]));
                                sb.append("|");
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            anVar2.delete(this.lie[i2]);
                            anVar2.dh(this.lie[i2] + "s", sb.toString());
                        }
                        TiebaStatic.log(anVar2);
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
        if (v.getCount(list) != 0 && !StringUtils.isNull(str) && (indexOf = list.indexOf(str)) >= 0 && list.size() > indexOf + 1) {
            String valueOf = String.valueOf(list.get(indexOf + 1));
            return StringUtils.isNull(valueOf, true) ? "" : valueOf;
        }
        return "";
    }
}
