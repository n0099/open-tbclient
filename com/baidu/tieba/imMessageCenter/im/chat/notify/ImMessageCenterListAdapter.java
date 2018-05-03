package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.a.c;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.f;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class ImMessageCenterListAdapter extends c {
    private e ekk;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.ekk = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.ekk.C(true, true);
            } else {
                this.ekk.C(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        ImMessageCenterShowItemData ni = getItem(i);
        if (ni != null && String.valueOf(String.valueOf(2)).equals(ni.getOwnerName())) {
            if (ni.getUnReadCount() >= 30) {
                if (this.ekk != null) {
                    this.ekk.hL(true);
                }
            } else if (this.ekk != null) {
                this.ekk.hL(false);
            }
        }
        return super.getView(i, view2, viewGroup);
    }

    public void a(e eVar) {
        this.ekk = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Ai()) {
                str = "";
            } else {
                if (!f.aGY().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Ae().At()) {
                str = "";
            } else {
                GroupSettingItemData groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                if (groupSettingItemData != null && !groupSettingItemData.isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Am()) {
                str = "";
            } else {
                PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Am()) {
                str = "";
            }
            i2 = i;
        } else {
            if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                str = "";
            }
            i2 = i;
        }
        return new BasicNameValuePair(String.valueOf(i2), str);
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.a.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.dRP.setDrawerType(1);
        aVar.dRP.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRP.setDrawBorder(false);
            aVar.dRP.setAutoChangeStyle(true);
            aVar.dRP.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001287, Integer.class);
            if (runTask != null) {
                ak.c(aVar.dRP, ((Integer) runTask.getData()).intValue());
            }
            aVar.dRP.setUserName(String.valueOf(2));
            aVar.dRP.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dRP.setIsRound(false);
            aVar.dRP.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRP.setDrawBorder(false);
            aVar.dRP.setAutoChangeStyle(true);
            aVar.dRP.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dRP.setUserName(String.valueOf(3));
            aVar.dRP.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask2 != null) {
                ak.c(aVar.dRP, ((Integer) runTask2.getData()).intValue());
            }
            aVar.dRP.setIsRound(false);
            aVar.dRP.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRP.setDrawBorder(true);
            aVar.dRP.setAutoChangeStyle(true);
            aVar.dRP.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dRP.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.dRP.startLoad(String.valueOf(d.f.icon_default_avatar100), 24, false);
            } else {
                aVar.dRP.startLoad(friendPortrait, 10, false);
            }
            aVar.dRP.setClickable(false);
            aVar.dRP.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dRP.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dRP.setUserName(String.valueOf(1));
            aVar.dRP.setIsRound(false);
            aVar.dRP.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRP.setDrawBorder(false);
            aVar.dRP.setAutoChangeStyle(true);
            aVar.dRP.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dRP.setUserName(String.valueOf(5));
            aVar.dRP.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask3 != null) {
                ak.c(aVar.dRP, ((Integer) runTask3.getData()).intValue());
            }
            aVar.dRP.setIsRound(false);
            aVar.dRP.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRP.setDrawBorder(true);
            aVar.dRP.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dRP.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.dRP.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    aVar.dRP.startLoad(((Integer) runTask4.getData()).toString(), 24, false);
                }
            }
            aVar.dRP.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dRP.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dRP.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.dRP.setIsRound(false);
            aVar.dRP.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRP.setDrawBorder(false);
            aVar.dRP.setAutoChangeStyle(true);
            aVar.dRP.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dRP.setUserName(String.valueOf(7));
            aVar.dRP.setUserId(imMessageCenterShowItemData.getFriendId());
            ak.c(aVar.dRP, d.f.icon_new_stranger);
            aVar.dRP.setIsRound(false);
            aVar.dRP.invalidate();
        } else {
            aVar.dRP.setDrawBorder(true);
            aVar.dRP.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dRP.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.dRP.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.dRP.startLoad(String.valueOf(d.f.person_photo), 24, false);
            }
            aVar.dRP.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dRP.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dRP.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.dRP.setIsRound(false);
            aVar.dRP.invalidate();
        }
    }
}
