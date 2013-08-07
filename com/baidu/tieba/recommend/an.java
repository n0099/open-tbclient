package com.baidu.tieba.recommend;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.bl;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FindInterestFragment f1642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FindInterestFragment findInterestFragment) {
        this.f1642a = findInterestFragment;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        aq aqVar;
        com.baidu.tieba.model.o oVar;
        Activity activity;
        Activity activity2;
        Activity activity3;
        com.baidu.tieba.model.o oVar2;
        Activity activity4;
        Activity activity5;
        com.baidu.tieba.model.o oVar3;
        aq aqVar2;
        aq aqVar3;
        bl blVar;
        Handler handler;
        aq aqVar4;
        Activity activity6;
        aqVar = this.f1642a.b;
        aqVar.c();
        if (obj == null) {
            oVar = this.f1642a.f1625a;
            if (oVar.getErrorString() != null) {
                oVar2 = this.f1642a.f1625a;
                if (oVar2.getErrorString().length() != 0) {
                    activity4 = this.f1642a.d;
                    if (activity4 != null) {
                        activity5 = this.f1642a.d;
                        oVar3 = this.f1642a.f1625a;
                        com.baidu.tieba.util.am.a((Context) activity5, oVar3.getErrorString());
                        return;
                    }
                    return;
                }
            }
            activity = this.f1642a.d;
            if (activity != null) {
                activity2 = this.f1642a.d;
                activity3 = this.f1642a.d;
                com.baidu.tieba.util.am.a((Context) activity2, activity3.getResources().getString(R.string.neterror));
            }
        } else if (obj instanceof com.baidu.tieba.data.ac) {
            aqVar2 = this.f1642a.b;
            aqVar2.f().a(TiebaApplication.f().bl());
            aqVar3 = this.f1642a.b;
            aqVar3.a((com.baidu.tieba.data.ac) obj);
            if (((com.baidu.tieba.data.ac) obj).e()) {
                activity6 = this.f1642a.d;
                com.baidu.tieba.util.am.a((Context) activity6, this.f1642a.h().getString(R.string.no_more_to_load));
            }
            blVar = this.f1642a.e;
            if (blVar == null) {
                aqVar4 = this.f1642a.b;
                aqVar4.a("全部兴趣");
            }
            handler = this.f1642a.c;
            handler.post(new ao(this));
        }
    }
}
