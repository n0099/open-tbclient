package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.w;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.a.b {
    private com.baidu.tieba.imMessageCenter.mention.l del;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.del = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.del.r(true, true);
            } else {
                this.del.r(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData kY = getItem(i);
        if (kY != null && String.valueOf(String.valueOf(2)).equals(kY.getOwnerName())) {
            if (kY.getUnReadCount() >= 30) {
                if (this.del != null) {
                    this.del.fV(true);
                }
            } else if (this.del != null) {
                this.del.fV(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.l lVar) {
        this.del = lVar;
    }

    @Override // com.baidu.tieba.im.chat.a.b
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().yV()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.arv().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().zg()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().yZ()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().yZ() || !TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yR().zl()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.ars().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        }
        return new BasicNameValuePair(String.valueOf(i), str);
    }

    @Override // com.baidu.tieba.im.chat.a.b
    protected boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // com.baidu.tieba.im.chat.a.b
    protected boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.a.b
    public void g(b.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.cLe.setDrawerType(1);
        aVar.cLe.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cLe.setDrawBorder(false);
            aVar.cLe.setAutoChangeStyle(true);
            aVar.cLe.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                aq.c(aVar.cLe, ((Integer) runTask.getData()).intValue());
            }
            aVar.cLe.setUserName(String.valueOf(2));
            aVar.cLe.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cLe.setIsRound(false);
            aVar.cLe.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cLe.setDrawBorder(false);
            aVar.cLe.setAutoChangeStyle(true);
            aVar.cLe.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cLe.setUserName(String.valueOf(3));
            aVar.cLe.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                aq.c(aVar.cLe, ((Integer) runTask2.getData()).intValue());
            }
            aVar.cLe.setIsRound(false);
            aVar.cLe.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cLe.setDrawBorder(false);
            aVar.cLe.setAutoChangeStyle(true);
            aVar.cLe.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cLe.setUserName(String.valueOf(6));
            aVar.cLe.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                aq.c(aVar.cLe, ((Integer) runTask3.getData()).intValue());
            }
            aVar.cLe.setIsRound(false);
            aVar.cLe.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cLe.setDrawBorder(true);
            aVar.cLe.setAutoChangeStyle(true);
            aVar.cLe.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cLe.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.cLe.c(String.valueOf(w.g.icon_default_avatar100), 24, false);
            } else {
                aVar.cLe.c(friendPortrait, 10, false);
            }
            aVar.cLe.setClickable(false);
            aVar.cLe.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cLe.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cLe.setUserName(String.valueOf(1));
            aVar.cLe.setIsRound(false);
            aVar.cLe.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cLe.setDrawBorder(false);
            aVar.cLe.setAutoChangeStyle(true);
            aVar.cLe.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cLe.setUserName(String.valueOf(5));
            aVar.cLe.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                aq.c(aVar.cLe, ((Integer) runTask4.getData()).intValue());
            }
            aVar.cLe.setIsRound(false);
            aVar.cLe.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cLe.setDrawBorder(true);
            aVar.cLe.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cLe.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.cLe.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.cLe.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.cLe.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cLe.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cLe.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.cLe.setIsRound(false);
            aVar.cLe.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cLe.setDrawBorder(false);
            aVar.cLe.setAutoChangeStyle(true);
            aVar.cLe.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cLe.setUserName(String.valueOf(7));
            aVar.cLe.setUserId(imMessageCenterShowItemData.getFriendId());
            aq.c(aVar.cLe, w.g.icon_new_stranger);
            aVar.cLe.setIsRound(false);
            aVar.cLe.invalidate();
        } else {
            aVar.cLe.setDrawBorder(true);
            aVar.cLe.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cLe.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.cLe.c(friendPortrait3, 12, false);
            } else {
                aVar.cLe.c(String.valueOf(w.g.person_photo), 24, false);
            }
            aVar.cLe.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cLe.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cLe.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.cLe.setIsRound(false);
            aVar.cLe.invalidate();
        }
    }
}
