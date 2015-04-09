package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.u;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private d bpU;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.bpU = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.bpU.db(true);
            } else {
                this.bpU.db(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData fC = getItem(i);
        if (fC != null && String.valueOf(String.valueOf(2)).equals(fC.getOwnerName())) {
            if (fC.getUnReadCount() >= 30) {
                if (this.bpU != null) {
                    this.bpU.da(true);
                }
            } else if (this.bpU != null) {
                this.bpU.da(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void g(d dVar) {
        this.bpU = dVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
            i = 0;
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
            i = 0;
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
            i = 0;
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vA()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.TE().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vL()) {
                str = "";
                i = 0;
            } else {
                GroupSettingItemData groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                if (groupSettingItemData != null && !groupSettingItemData.isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
            }
        } else if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE()) {
                str = "";
                i = 0;
            } else {
                PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
            }
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE() || !TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vw().vE()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.TB().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        }
        return new BasicNameValuePair(String.valueOf(i), str);
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected void f(com.baidu.tieba.im.chat.notify.c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        cVar.Mn.setDrawerType(1);
        cVar.Mn.setRadius(com.baidu.adp.lib.util.n.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mn.setDrawBorder(false);
            cVar.Mn.setAutoChangeStyle(true);
            cVar.Mn.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001294, Integer.class);
            if (runTask != null) {
                ba.c(cVar.Mn, ((Integer) runTask.getData()).intValue());
            }
            cVar.Mn.setUserName(String.valueOf(2));
            cVar.Mn.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Mn.setIsRound(false);
            cVar.Mn.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mn.setDrawBorder(false);
            cVar.Mn.setAutoChangeStyle(true);
            cVar.Mn.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Mn.setUserName(String.valueOf(3));
            cVar.Mn.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001293, Integer.class);
            if (runTask2 != null) {
                ba.c(cVar.Mn, ((Integer) runTask2.getData()).intValue());
            }
            cVar.Mn.setIsRound(false);
            cVar.Mn.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mn.setDrawBorder(false);
            cVar.Mn.setAutoChangeStyle(true);
            cVar.Mn.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Mn.setUserName(String.valueOf(6));
            cVar.Mn.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001295, Integer.class);
            if (runTask3 != null) {
                ba.c(cVar.Mn, ((Integer) runTask3.getData()).intValue());
            }
            cVar.Mn.setIsRound(false);
            cVar.Mn.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mn.setDrawBorder(true);
            cVar.Mn.setAutoChangeStyle(true);
            cVar.Mn.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            cVar.Mn.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                cVar.Mn.c(String.valueOf(u.icon_default_avatar100), 24, false);
            } else {
                cVar.Mn.c(friendPortrait, 10, false);
            }
            cVar.Mn.setClickable(false);
            cVar.Mn.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.Mn.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Mn.setUserName(String.valueOf(1));
            cVar.Mn.setIsRound(false);
            cVar.Mn.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mn.setDrawBorder(false);
            cVar.Mn.setAutoChangeStyle(true);
            cVar.Mn.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Mn.setUserName(String.valueOf(5));
            cVar.Mn.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001296, Integer.class);
            if (runTask4 != null) {
                ba.c(cVar.Mn, ((Integer) runTask4.getData()).intValue());
            }
            cVar.Mn.setIsRound(false);
            cVar.Mn.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mn.setDrawBorder(true);
            cVar.Mn.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.Mn.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                cVar.Mn.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(2001296, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    cVar.Mn.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            cVar.Mn.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.Mn.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Mn.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.Mn.setIsRound(false);
            cVar.Mn.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mn.setDrawBorder(false);
            cVar.Mn.setAutoChangeStyle(true);
            cVar.Mn.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Mn.setUserName(String.valueOf(7));
            cVar.Mn.setUserId(imMessageCenterShowItemData.getFriendId());
            ba.c(cVar.Mn, u.icon_new_stranger);
            cVar.Mn.setIsRound(false);
            cVar.Mn.invalidate();
        } else {
            cVar.Mn.setDrawBorder(true);
            cVar.Mn.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.Mn.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                cVar.Mn.c(friendPortrait3, 12, false);
            } else {
                cVar.Mn.c(String.valueOf(u.person_photo), 24, false);
            }
            cVar.Mn.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.Mn.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Mn.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.Mn.setIsRound(false);
            cVar.Mn.invalidate();
        }
    }
}
