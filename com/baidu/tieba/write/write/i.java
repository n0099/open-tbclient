package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ AtListActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AtListActivity atListActivity) {
        this.dWP = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AtSelectFriendList atSelectFriendList;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        atSelectFriendList = this.dWP.dWD;
        bundle.putStringArrayList(IntentConfig.NAME_SHOW, atSelectFriendList.getDataList());
        intent.putExtras(bundle);
        com.baidu.adp.lib.util.k.c(this.dWP.getPageContext().getPageActivity(), this.dWP.cbx);
        this.dWP.setResult(-1, intent);
        this.dWP.finish();
    }
}
