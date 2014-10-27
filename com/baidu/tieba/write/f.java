package com.baidu.tieba.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ AtListActivity bSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.bSE = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AtSelectFriendList atSelectFriendList;
        EditText editText;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        atSelectFriendList = this.bSE.bSt;
        bundle.putStringArrayList(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, atSelectFriendList.getDataList());
        intent.putExtras(bundle);
        AtListActivity atListActivity = this.bSE;
        editText = this.bSE.mEditText;
        com.baidu.adp.lib.util.m.b(atListActivity, editText);
        this.bSE.setResult(-1, intent);
        this.bSE.finish();
    }
}
