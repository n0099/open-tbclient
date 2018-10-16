package com.baidu.tieba.recapp;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class r implements o {
    public static final AtomicReference<o> gDd = new AtomicReference<>(null);
    private static final o gDe = new r();

    public static o btk() {
        o oVar = gDd.get();
        return oVar == null ? gDe : oVar;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(n nVar, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
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
    public j bte() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public l btf() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.tieba.p.a btg() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public h bth() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public List<AppData> bti() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.o
    public void btj() {
        BdLog.e("recapp plugin install failed!");
    }
}
