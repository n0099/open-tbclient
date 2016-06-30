package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity cYl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AddFriendActivity addFriendActivity) {
        this.cYl = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        EditText editText2;
        AddFriendActivity addFriendActivity = this.cYl;
        inputMethodManager = this.cYl.cfb;
        editText = this.cYl.cYg;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            editText2 = this.cYl.cYg;
            this.cYl.gU(editText2.getText().toString());
            return;
        }
        this.cYl.showToast(u.j.plugin_not_install);
    }
}
