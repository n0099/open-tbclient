package com.baidu.tieba.j.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.j.c;
import com.baidu.tieba.play.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
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

    public String bEA() {
        if (StringUtils.isNull(this.uuid) || !m.hy() || StringUtils.isNull(getKey())) {
            return null;
        }
        String str = c.a.gXR + bEB();
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

    protected String bEB() {
        return "_" + this.uuid + "_" + getKey();
    }

    @Override // com.baidu.tieba.j.a.c
    public e bEC() {
        return new e(getKey(), bEA());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: do  reason: not valid java name */
    public void m22do(List<T> list) {
        new BdAsyncTask<List<T>, Void, Void>() { // from class: com.baidu.tieba.j.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public Void doInBackground(List<T>[] listArr) {
                if (listArr != null && listArr.length == 1) {
                    String bEA = a.this.bEA();
                    if (!StringUtils.isNull(bEA)) {
                        a.this.m(bEA, listArr[0]);
                    }
                }
                return null;
            }
        }.execute(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(String str, List<T> list) {
        int size = list.size();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).bUo());
        }
        com.baidu.tieba.j.d.g(new File(str), jSONArray.toString() + "\n");
    }
}
