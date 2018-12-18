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
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.a.c;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.f;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class ImMessageCenterListAdapter extends c {
    private e fbs;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.fbs = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.fbs.K(true, true);
            } else {
                this.fbs.K(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData pD = getItem(i);
        if (pD != null && String.valueOf(String.valueOf(2)).equals(pD.getOwnerName())) {
            if (pD.getUnReadCount() >= 30) {
                if (this.fbs != null) {
                    this.fbs.jh(true);
                }
            } else if (this.fbs != null) {
                this.fbs.jh(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.fbs = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IA()) {
                str = "";
            } else {
                if (!f.aUl().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IM()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IE()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IE()) {
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
        aVar.eJi.setDrawerType(1);
        aVar.eJi.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eJi.setDrawBorder(false);
            aVar.eJi.setAutoChangeStyle(true);
            aVar.eJi.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001287, Integer.class);
            if (runTask != null) {
                al.c(aVar.eJi, ((Integer) runTask.getData()).intValue());
            }
            aVar.eJi.setUserName(String.valueOf(2));
            aVar.eJi.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eJi.setIsRound(false);
            aVar.eJi.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eJi.setDrawBorder(false);
            aVar.eJi.setAutoChangeStyle(true);
            aVar.eJi.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.eJi.setUserName(String.valueOf(3));
            aVar.eJi.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask2 != null) {
                al.c(aVar.eJi, ((Integer) runTask2.getData()).intValue());
            }
            aVar.eJi.setIsRound(false);
            aVar.eJi.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eJi.setDrawBorder(true);
            aVar.eJi.setAutoChangeStyle(true);
            aVar.eJi.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.eJi.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.eJi.startLoad(String.valueOf(e.f.icon_default_avatar100), 24, false);
            } else {
                aVar.eJi.startLoad(friendPortrait, 10, false);
            }
            aVar.eJi.setClickable(false);
            aVar.eJi.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.eJi.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eJi.setUserName(String.valueOf(1));
            aVar.eJi.setIsRound(false);
            aVar.eJi.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eJi.setDrawBorder(false);
            aVar.eJi.setAutoChangeStyle(true);
            aVar.eJi.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.eJi.setUserName(String.valueOf(5));
            aVar.eJi.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask3 != null) {
                al.c(aVar.eJi, ((Integer) runTask3.getData()).intValue());
            }
            aVar.eJi.setIsRound(false);
            aVar.eJi.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eJi.setDrawBorder(true);
            aVar.eJi.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.eJi.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.eJi.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    aVar.eJi.startLoad(((Integer) runTask4.getData()).toString(), 24, false);
                }
            }
            aVar.eJi.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.eJi.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eJi.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.eJi.setIsRound(false);
            aVar.eJi.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eJi.setDrawBorder(false);
            aVar.eJi.setAutoChangeStyle(true);
            aVar.eJi.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.eJi.setUserName(String.valueOf(7));
            aVar.eJi.setUserId(imMessageCenterShowItemData.getFriendId());
            al.c(aVar.eJi, e.f.icon_new_stranger);
            aVar.eJi.setIsRound(false);
            aVar.eJi.invalidate();
        } else {
            aVar.eJi.setDrawBorder(true);
            aVar.eJi.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.eJi.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.eJi.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.eJi.startLoad(String.valueOf(e.f.person_photo), 24, false);
            }
            aVar.eJi.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.eJi.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eJi.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.eJi.setIsRound(false);
            aVar.eJi.invalidate();
        }
    }
}
