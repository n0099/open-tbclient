package com.baidu.tieba.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ AtListActivity bST;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.bST = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AtSelectFriendList atSelectFriendList;
        EditText editText;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        atSelectFriendList = this.bST.bSI;
        bundle.putStringArrayList(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, atSelectFriendList.getDataList());
        intent.putExtras(bundle);
        AtListActivity atListActivity = this.bST;
        editText = this.bST.mEditText;
        com.baidu.adp.lib.util.m.b(atListActivity, editText);
        this.bST.setResult(-1, intent);
        this.bST.finish();
    }
}
