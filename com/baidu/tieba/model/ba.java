package com.baidu.tieba.model;

import android.content.Context;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.a.d {
    private Context c;

    /* renamed from: a  reason: collision with root package name */
    private bd f2000a = null;
    private ArrayList<com.baidu.tieba.data.ag> b = null;
    private bc d = null;

    public ba(Context context) {
        this.c = null;
        this.c = context;
    }

    public void a(bc bcVar) {
        this.d = bcVar;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        if (this.f2000a == null) {
            this.f2000a = new bd(this);
            this.f2000a.execute(new String[0]);
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }
}
