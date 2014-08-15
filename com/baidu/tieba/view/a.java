package com.baidu.tieba.view;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.a = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.data.b bVar;
        com.baidu.tieba.data.b bVar2;
        BaobaoSdkDelegate baobaoSdkDelegate;
        com.baidu.tieba.data.b bVar3;
        bVar = this.a.c;
        if (bVar != null) {
            bVar2 = this.a.c;
            if (bVar2.d() != 1) {
                bVar3 = this.a.c;
                String b = bVar3.b();
                if (!com.baidu.adp.lib.util.i.c(b)) {
                    com.baidu.tbadk.browser.a.a(this.a.getContext(), b, true);
                    return;
                }
                return;
            }
            try {
                com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("baobao");
                if (a != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) a.a(BaobaoSdkDelegate.class)) != null) {
                    if (baobaoSdkDelegate.checkHasInstalled(this.a.getContext())) {
                        baobaoSdkDelegate.launchBaobao(this.a.getContext());
                    } else {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(baobaoSdkDelegate.getJumpUrl()));
                        this.a.getContext().startActivity(intent);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
