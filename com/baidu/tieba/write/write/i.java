package com.baidu.tieba.write.write;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ AtListActivity cBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AtListActivity atListActivity) {
        this.cBt = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AtSelectFriendList atSelectFriendList;
        EditText editText;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        atSelectFriendList = this.cBt.cBh;
        bundle.putStringArrayList(com.baidu.tbadk.core.frameworkData.c.NAME_SHOW, atSelectFriendList.getDataList());
        intent.putExtras(bundle);
        Activity pageActivity = this.cBt.getPageContext().getPageActivity();
        editText = this.cBt.mEditText;
        com.baidu.adp.lib.util.n.c(pageActivity, editText);
        this.cBt.setResult(-1, intent);
        this.cBt.finish();
    }
}
