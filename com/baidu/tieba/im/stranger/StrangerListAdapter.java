package com.baidu.tieba.im.stranger;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class StrangerListAdapter extends com.baidu.tieba.im.chat.notify.b {
    public StrangerListAdapter(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext().getContext());
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
            str = "";
            i = 0;
        }
        if (imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
            i2 = i;
        } else {
            str = "";
        }
        return new BasicNameValuePair(String.valueOf(i2), str);
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected void f(com.baidu.tieba.im.chat.notify.c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        cVar.zJ.setDrawBorder(true);
        cVar.zJ.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
            cVar.zJ.d(imMessageCenterShowItemData.getFriendPortrait(), 12, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }
}
