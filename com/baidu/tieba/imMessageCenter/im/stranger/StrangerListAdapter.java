package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import d.a.m0.s.d.d;
import d.a.n0.f1.f.i.c;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class StrangerListAdapter extends c {
    public StrangerListAdapter(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext().getContext());
    }

    @Override // d.a.n0.f1.f.i.c
    public boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // d.a.n0.f1.f.i.c
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // d.a.n0.f1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.f54379b.setDrawBorder(true);
        aVar.f54379b.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
        if (TextUtils.isEmpty(friendBjhAvatar)) {
            friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
        }
        if (TextUtils.isEmpty(friendBjhAvatar)) {
            return;
        }
        aVar.f54379b.V(friendBjhAvatar, 12, false);
    }

    @Override // d.a.n0.f1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str) {
        String str2 = "";
        int i3 = 0;
        if (!d.d().p()) {
            str = "";
            i2 = 0;
        }
        if (imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
            i3 = i2;
            str2 = str;
        }
        return new BasicNameValuePair(String.valueOf(i3), str2);
    }
}
