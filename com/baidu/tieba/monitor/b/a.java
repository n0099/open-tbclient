package com.baidu.tieba.monitor.b;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.monitor.a;
import com.baidu.tieba.play.d.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tieba.play.d.b> implements c<T> {
    protected final String exW;
    protected List<T> list = new ArrayList();

    public a(String str) {
        this.exW = str;
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

    public String aNp() {
        if (StringUtils.isNull(this.exW) || !k.dG() || StringUtils.isNull(getKey())) {
            return null;
        }
        String str = a.InterfaceC0105a.exs + aNq();
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

    protected String aNq() {
        return "_" + this.exW + "_" + getKey();
    }

    @Override // com.baidu.tieba.monitor.b.c
    public e aNr() {
        return new e(getKey(), aNp());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cl(List<T> list) {
        new BdAsyncTask<List<T>, Void, Void>() { // from class: com.baidu.tieba.monitor.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public Void doInBackground(List<T>[] listArr) {
                if (listArr != null && listArr.length == 1) {
                    String aNp = a.this.aNp();
                    if (!StringUtils.isNull(aNp)) {
                        a.this.k(aNp, listArr[0]);
                    }
                }
                return null;
            }
        }.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k(String str, List<T> list) {
        int size = list.size();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).aNo());
        }
        com.baidu.tieba.monitor.b.e(new File(str), jSONArray.toString() + "\n");
    }
}
