package com.baidu.tieba.imMessageCenter.im.addFriend;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AddFriendActivity dgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AddFriendActivity addFriendActivity) {
        this.dgX = addFriendActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        EditText editText2;
        AddFriendActivity addFriendActivity = this.dgX;
        inputMethodManager = this.dgX.cjw;
        editText = this.dgX.dgR;
        addFriendActivity.HidenSoftKeyPad(inputMethodManager, editText);
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            editText2 = this.dgX.dgR;
            this.dgX.hp(editText2.getText().toString());
            return;
        }
        this.dgX.showToast(w.l.plugin_not_install);
    }
}
