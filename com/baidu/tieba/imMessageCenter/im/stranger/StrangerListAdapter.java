package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.im.chat.a.c;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes22.dex */
public class StrangerListAdapter extends c {
    public StrangerListAdapter(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext().getContext());
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (!d.bwv().bwD()) {
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

    @Override // com.baidu.tieba.im.chat.a.c
    protected void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.jWV.setDrawBorder(true);
        aVar.jWV.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
        if (TextUtils.isEmpty(friendBjhAvatar)) {
            friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
        }
        if (!TextUtils.isEmpty(friendBjhAvatar)) {
            aVar.jWV.startLoad(friendBjhAvatar, 12, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }
}
