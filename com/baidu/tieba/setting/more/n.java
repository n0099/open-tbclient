package com.baidu.tieba.setting.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.cFS = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        eVar = this.cFS.cFG;
        eVar.bO(i);
        switch (i) {
            case 0:
                com.baidu.tbadk.core.m.rb().ae(true);
                com.baidu.tbadk.core.m.rb().bq(0);
                break;
            case 1:
                com.baidu.tbadk.core.m.rb().ae(true);
                com.baidu.tbadk.core.m.rb().bq(1);
                break;
            case 2:
                com.baidu.tbadk.core.m.rb().ae(true);
                com.baidu.tbadk.core.m.rb().bq(2);
                break;
            case 3:
                com.baidu.tbadk.core.m.rb().ae(false);
                break;
        }
        this.cFS.apq();
        this.cFS.app();
    }
}
