package com.baidu.tieba.j.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.j.c;
import com.baidu.tieba.play.b.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
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

    public String aYl() {
        if (StringUtils.isNull(this.uuid) || !l.hk() || StringUtils.isNull(getKey())) {
            return null;
        }
        String str = c.a.fos + aYm();
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

    protected String aYm() {
        return "_" + this.uuid + "_" + getKey();
    }

    @Override // com.baidu.tieba.j.a.c
    public e aYn() {
        return new e(getKey(), aYl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cK(List<T> list) {
        new BdAsyncTask<List<T>, Void, Void>() { // from class: com.baidu.tieba.j.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public Void doInBackground(List<T>[] listArr) {
                if (listArr != null && listArr.length == 1) {
                    String aYl = a.this.aYl();
                    if (!StringUtils.isNull(aYl)) {
                        a.this.k(aYl, listArr[0]);
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
            jSONArray.put(list.get(i).bnG());
        }
        com.baidu.tieba.j.d.f(new File(str), jSONArray.toString() + "\n");
    }
}
