package com.baidu.tieba.k.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.k.c;
import com.baidu.tieba.play.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes10.dex */
public abstract class a<T extends com.baidu.tieba.play.b.b> implements c<T> {
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

    public String crY() {
        if (StringUtils.isNull(this.uuid) || !m.checkSD() || StringUtils.isNull(getKey())) {
            return null;
        }
        String str = c.a.jbI + crZ();
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

    protected String crZ() {
        return PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.uuid + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + getKey();
    }

    @Override // com.baidu.tieba.k.a.c
    public e csa() {
        return new e(getKey(), crY());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dG(List<T> list) {
        new BdAsyncTask<List<T>, Void, Void>() { // from class: com.baidu.tieba.k.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: a */
            public Void doInBackground(List<T>[] listArr) {
                if (listArr != null && listArr.length == 1) {
                    String crY = a.this.crY();
                    if (!StringUtils.isNull(crY)) {
                        a.this.l(crY, listArr[0]);
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
            jSONArray.put(list.get(i).cKQ());
        }
        com.baidu.tieba.k.d.g(new File(str), jSONArray.toString() + "\n");
    }
}
