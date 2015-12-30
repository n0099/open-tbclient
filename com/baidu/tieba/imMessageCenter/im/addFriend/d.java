package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AddFriendActivity addFriendActivity) {
        this.ccU = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        EditText editText2;
        AddFriendActivity addFriendActivity = this.ccU;
        inputMethodManager = this.ccU.byv;
        editText = this.ccU.ccP;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            editText2 = this.ccU.ccP;
            this.ccU.gA(editText2.getText().toString());
            return;
        }
        this.ccU.showToast(n.j.plugin_not_install);
    }
}
