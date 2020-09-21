package com.baidu.tieba.recapp;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class r implements o {
    public static final AtomicReference<o> lLp = new AtomicReference<>(null);
    private static final o lLq = new r();

    public static o dqU() {
        o oVar = lLp.get();
        return oVar == null ? lLq : oVar;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(n nVar, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.o
    public j dqO() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public l dqP() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.tieba.r.a dqQ() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public g dqR() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public List<AppData> dqS() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public void dqT() {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, Context context) {
        BdLog.e("recapp plugin install failed!");
    }
}
