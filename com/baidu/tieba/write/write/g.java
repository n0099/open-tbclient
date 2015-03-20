package com.baidu.tieba.write.write;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ AtListActivity cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.cwI = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AtSelectFriendList atSelectFriendList;
        EditText editText;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        atSelectFriendList = this.cwI.cwx;
        bundle.putStringArrayList(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, atSelectFriendList.getDataList());
        intent.putExtras(bundle);
        Activity pageActivity = this.cwI.getPageContext().getPageActivity();
        editText = this.cwI.mEditText;
        com.baidu.adp.lib.util.n.c(pageActivity, editText);
        this.cwI.setResult(-1, intent);
        this.cwI.finish();
    }
}
