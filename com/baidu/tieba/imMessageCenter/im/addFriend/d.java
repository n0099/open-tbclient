package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity csV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AddFriendActivity addFriendActivity) {
        this.csV = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        EditText editText2;
        AddFriendActivity addFriendActivity = this.csV;
        inputMethodManager = this.csV.bHm;
        editText = this.csV.csQ;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
        if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            editText2 = this.csV.csQ;
            this.csV.gN(editText2.getText().toString());
            return;
        }
        this.csV.showToast(t.j.plugin_not_install);
    }
}
