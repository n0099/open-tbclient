package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i bpV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bpV = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        HeadImageView headImageView;
        ValidateItemData validateItemData;
        validateActivity = this.bpV.bpQ;
        headImageView = this.bpV.bhk;
        validateItemData = this.bpV.bpU;
        validateActivity.a(headImageView, PersonInfoActivityConfig.REQUSET_CHANGE, 0, 0L, validateItemData);
    }
}
