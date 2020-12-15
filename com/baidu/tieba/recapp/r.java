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
public class r implements q {
    public static final AtomicReference<q> mHB = new AtomicReference<>(null);
    private static final q mHC = new r();

    public static q dFg() {
        q qVar = mHB.get();
        return qVar == null ? mHC : qVar;
    }

    @Override // com.baidu.tieba.recapp.q
    public com.baidu.adp.widget.ListView.a<?, ?> a(p pVar, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.q
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.q
    public com.baidu.adp.widget.ListView.a<?, ?> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.q
    public void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.q
    public void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.q
    public l dFa() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.q
    public n dFb() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.q
    public com.baidu.tieba.s.a dFc() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.q
    public i dFd() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.q
    public List<AppData> dFe() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.q
    public void dFf() {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.q
    public void a(AdvertAppInfo advertAppInfo, Context context) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.q
    public h a(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }
}
