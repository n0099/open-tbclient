package com.baidu.tieba.write;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.BdUtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AtSelectFriendList atSelectFriendList;
        EditText editText;
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        atSelectFriendList = this.a.e;
        bundle.putStringArrayList("name_show", atSelectFriendList.getDataList());
        intent.putExtras(bundle);
        AtListActivity atListActivity = this.a;
        editText = this.a.b;
        BdUtilHelper.a(atListActivity, editText);
        this.a.setResult(-1, intent);
        this.a.finish();
    }
}
