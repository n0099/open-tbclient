package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import d.b.h0.s.d.d;
import d.b.i0.d1.f.i.c;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class StrangerListAdapter extends c {
    public StrangerListAdapter(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext().getContext());
    }

    @Override // d.b.i0.d1.f.i.c
    public boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // d.b.i0.d1.f.i.c
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // d.b.i0.d1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.f53688b.setDrawBorder(true);
        aVar.f53688b.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
        if (TextUtils.isEmpty(friendBjhAvatar)) {
            friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
        }
        if (TextUtils.isEmpty(friendBjhAvatar)) {
            return;
        }
        aVar.f53688b.W(friendBjhAvatar, 12, false);
    }

    @Override // d.b.i0.d1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        String str2 = "";
        int i2 = 0;
        if (!d.d().p()) {
            str = "";
            i = 0;
        }
        if (imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
            i2 = i;
            str2 = str;
        }
        return new BasicNameValuePair(String.valueOf(i2), str2);
    }
}
