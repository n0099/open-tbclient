package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ AtListActivity fcq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AtListActivity atListActivity) {
        this.fcq = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AtSelectFriendList atSelectFriendList;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        atSelectFriendList = this.fcq.fce;
        bundle.putStringArrayList(IntentConfig.NAME_SHOW, atSelectFriendList.getDataList());
        intent.putExtras(bundle);
        com.baidu.adp.lib.util.k.a(this.fcq.getPageContext().getPageActivity(), this.fcq.crz);
        this.fcq.setResult(-1, intent);
        this.fcq.finish();
    }
}
