package com.baidu.tieba.j.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.j.c;
import com.baidu.tieba.play.c.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public abstract class a<T extends com.baidu.tieba.play.c.b> implements c<T> {
    protected List<T> list = new ArrayList();
    protected final String uuid;

    public a(String str) {
        this.uuid = str;
    }

    public void a(T t) {
        this.list.add(t);
    }

    public int size() {
        if (this.list == null) {
            return 0;
        }
        return this.list.size();
    }

    public String bMZ() {
        if (StringUtils.isNull(this.uuid) || !m.checkSD() || StringUtils.isNull(getKey())) {
            return null;
        }
        String str = c.a.hwY + bNa();
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
                return str;
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String bNa() {
        return PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.uuid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + getKey();
    }

    @Override // com.baidu.tieba.j.a.c
    public e bNb() {
        return new e(getKey(), bMZ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dK(List<T> list) {
        new BdAsyncTask<List<T>, Void, Void>() { // from class: com.baidu.tieba.j.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Void doInBackground(List<T>[] listArr) {
                if (listArr != null && listArr.length == 1) {
                    String bMZ = a.this.bMZ();
                    if (!StringUtils.isNull(bMZ)) {
                        a.this.l(bMZ, listArr[0]);
                    }
                }
                return null;
            }
        }.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(String str, List<T> list) {
        int size = list.size();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).cdp());
        }
        com.baidu.tieba.j.d.c(new File(str), jSONArray.toString() + "\n");
    }
}
