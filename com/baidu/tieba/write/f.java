package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ AtListActivity cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.cdZ = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AtSelectFriendList atSelectFriendList;
        EditText editText;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        atSelectFriendList = this.cdZ.cdO;
        bundle.putStringArrayList(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW, atSelectFriendList.getDataList());
        intent.putExtras(bundle);
        Activity pageActivity = this.cdZ.getPageContext().getPageActivity();
        editText = this.cdZ.mEditText;
        com.baidu.adp.lib.util.l.c(pageActivity, editText);
        this.cdZ.setResult(-1, intent);
        this.cdZ.finish();
    }
}
