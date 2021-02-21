package com.baidu.tieba.recapp;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.data.AppData;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import tbclient.App;
/* loaded from: classes.dex */
public class s implements r {
    public static final AtomicReference<r> mRI = new AtomicReference<>(null);
    private static final r mRJ = new s();

    public static r dDt() {
        r rVar = mRI.get();
        return rVar == null ? mRJ : rVar;
    }

    @Override // com.baidu.tieba.recapp.r
    public com.baidu.adp.widget.ListView.a<?, ?> a(q qVar, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public com.baidu.adp.widget.ListView.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public com.baidu.adp.widget.ListView.a<?, ?> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public void sendFRS(boolean z, String str, String str2, String str3, List<a.b> list, String str4) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.r
    public void a(boolean z, String str, String str2, String str3, String str4, List<a.b> list, String str5) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.r
    public m dDn() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public o dDo() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public com.baidu.tieba.r.a dDp() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public j dDq() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public List<AppData> dDr() {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public void dDs() {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.r
    public void a(AdvertAppInfo advertAppInfo, Context context) {
        BdLog.e("recapp plugin install failed!");
    }

    @Override // com.baidu.tieba.recapp.r
    public i a(TbPageContext<?> tbPageContext, AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }

    @Override // com.baidu.tieba.recapp.r
    public App a(App app, Cmatch cmatch) {
        BdLog.e("recapp plugin install failed!");
        return null;
    }
}
