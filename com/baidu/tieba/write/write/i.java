package com.baidu.tieba.write.write;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ AtListActivity cBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AtListActivity atListActivity) {
        this.cBu = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AtSelectFriendList atSelectFriendList;
        EditText editText;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        atSelectFriendList = this.cBu.cBi;
        bundle.putStringArrayList(com.baidu.tbadk.core.frameworkData.c.NAME_SHOW, atSelectFriendList.getDataList());
        intent.putExtras(bundle);
        Activity pageActivity = this.cBu.getPageContext().getPageActivity();
        editText = this.cBu.mEditText;
        com.baidu.adp.lib.util.n.c(pageActivity, editText);
        this.cBu.setResult(-1, intent);
        this.cBu.finish();
    }
}
