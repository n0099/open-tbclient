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
import com.baidu.tbadk.core.util.al;
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
    private e ewI;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.ewI = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.ewI.C(true, true);
            } else {
                this.ewI.C(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData nt = getItem(i);
        if (nt != null && String.valueOf(String.valueOf(2)).equals(nt.getOwnerName())) {
            if (nt.getUnReadCount() >= 30) {
                if (this.ewI != null) {
                    this.ewI.hS(true);
                }
            } else if (this.ewI != null) {
                this.ewI.hS(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.ewI = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DE().DI()) {
                str = "";
            } else {
                if (!f.aLR().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DE().DT()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DE().DM()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DE().DM()) {
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
        aVar.eej.setDrawerType(1);
        aVar.eej.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eej.setDrawBorder(false);
            aVar.eej.setAutoChangeStyle(true);
            aVar.eej.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001287, Integer.class);
            if (runTask != null) {
                al.c(aVar.eej, ((Integer) runTask.getData()).intValue());
            }
            aVar.eej.setUserName(String.valueOf(2));
            aVar.eej.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eej.setIsRound(false);
            aVar.eej.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eej.setDrawBorder(false);
            aVar.eej.setAutoChangeStyle(true);
            aVar.eej.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.eej.setUserName(String.valueOf(3));
            aVar.eej.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask2 != null) {
                al.c(aVar.eej, ((Integer) runTask2.getData()).intValue());
            }
            aVar.eej.setIsRound(false);
            aVar.eej.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eej.setDrawBorder(true);
            aVar.eej.setAutoChangeStyle(true);
            aVar.eej.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.eej.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.eej.startLoad(String.valueOf(d.f.icon_default_avatar100), 24, false);
            } else {
                aVar.eej.startLoad(friendPortrait, 10, false);
            }
            aVar.eej.setClickable(false);
            aVar.eej.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.eej.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eej.setUserName(String.valueOf(1));
            aVar.eej.setIsRound(false);
            aVar.eej.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eej.setDrawBorder(false);
            aVar.eej.setAutoChangeStyle(true);
            aVar.eej.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.eej.setUserName(String.valueOf(5));
            aVar.eej.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask3 != null) {
                al.c(aVar.eej, ((Integer) runTask3.getData()).intValue());
            }
            aVar.eej.setIsRound(false);
            aVar.eej.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eej.setDrawBorder(true);
            aVar.eej.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.eej.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.eej.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    aVar.eej.startLoad(((Integer) runTask4.getData()).toString(), 24, false);
                }
            }
            aVar.eej.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.eej.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eej.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.eej.setIsRound(false);
            aVar.eej.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eej.setDrawBorder(false);
            aVar.eej.setAutoChangeStyle(true);
            aVar.eej.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.eej.setUserName(String.valueOf(7));
            aVar.eej.setUserId(imMessageCenterShowItemData.getFriendId());
            al.c(aVar.eej, d.f.icon_new_stranger);
            aVar.eej.setIsRound(false);
            aVar.eej.invalidate();
        } else {
            aVar.eej.setDrawBorder(true);
            aVar.eej.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.eej.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.eej.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.eej.startLoad(String.valueOf(d.f.person_photo), 24, false);
            }
            aVar.eej.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.eej.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eej.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.eej.setIsRound(false);
            aVar.eej.invalidate();
        }
    }
}
