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
    private e ekn;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.ekn = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.ekn.C(true, true);
            } else {
                this.ekn.C(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        ImMessageCenterShowItemData ni = getItem(i);
        if (ni != null && String.valueOf(String.valueOf(2)).equals(ni.getOwnerName())) {
            if (ni.getUnReadCount() >= 30) {
                if (this.ekn != null) {
                    this.ekn.hL(true);
                }
            } else if (this.ekn != null) {
                this.ekn.hL(false);
            }
        }
        return super.getView(i, view2, viewGroup);
    }

    public void a(e eVar) {
        this.ekn = eVar;
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
        aVar.dRS.setDrawerType(1);
        aVar.dRS.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRS.setDrawBorder(false);
            aVar.dRS.setAutoChangeStyle(true);
            aVar.dRS.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001287, Integer.class);
            if (runTask != null) {
                ak.c(aVar.dRS, ((Integer) runTask.getData()).intValue());
            }
            aVar.dRS.setUserName(String.valueOf(2));
            aVar.dRS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dRS.setIsRound(false);
            aVar.dRS.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRS.setDrawBorder(false);
            aVar.dRS.setAutoChangeStyle(true);
            aVar.dRS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dRS.setUserName(String.valueOf(3));
            aVar.dRS.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask2 != null) {
                ak.c(aVar.dRS, ((Integer) runTask2.getData()).intValue());
            }
            aVar.dRS.setIsRound(false);
            aVar.dRS.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRS.setDrawBorder(true);
            aVar.dRS.setAutoChangeStyle(true);
            aVar.dRS.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dRS.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.dRS.startLoad(String.valueOf(d.f.icon_default_avatar100), 24, false);
            } else {
                aVar.dRS.startLoad(friendPortrait, 10, false);
            }
            aVar.dRS.setClickable(false);
            aVar.dRS.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dRS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dRS.setUserName(String.valueOf(1));
            aVar.dRS.setIsRound(false);
            aVar.dRS.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRS.setDrawBorder(false);
            aVar.dRS.setAutoChangeStyle(true);
            aVar.dRS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dRS.setUserName(String.valueOf(5));
            aVar.dRS.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask3 != null) {
                ak.c(aVar.dRS, ((Integer) runTask3.getData()).intValue());
            }
            aVar.dRS.setIsRound(false);
            aVar.dRS.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRS.setDrawBorder(true);
            aVar.dRS.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dRS.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.dRS.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    aVar.dRS.startLoad(((Integer) runTask4.getData()).toString(), 24, false);
                }
            }
            aVar.dRS.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dRS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dRS.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.dRS.setIsRound(false);
            aVar.dRS.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dRS.setDrawBorder(false);
            aVar.dRS.setAutoChangeStyle(true);
            aVar.dRS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dRS.setUserName(String.valueOf(7));
            aVar.dRS.setUserId(imMessageCenterShowItemData.getFriendId());
            ak.c(aVar.dRS, d.f.icon_new_stranger);
            aVar.dRS.setIsRound(false);
            aVar.dRS.invalidate();
        } else {
            aVar.dRS.setDrawBorder(true);
            aVar.dRS.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dRS.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.dRS.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.dRS.startLoad(String.valueOf(d.f.person_photo), 24, false);
            }
            aVar.dRS.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dRS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dRS.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.dRS.setIsRound(false);
            aVar.dRS.invalidate();
        }
    }
}
