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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.im.chat.notify.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.r;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private com.baidu.tieba.imMessageCenter.mention.k duR;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.duR = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.duR.t(true, true);
            } else {
                this.duR.t(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData lr = getItem(i);
        if (lr != null && String.valueOf(String.valueOf(2)).equals(lr.getOwnerName())) {
            if (lr.getUnReadCount() >= 30) {
                if (this.duR != null) {
                    this.duR.gG(true);
                }
            } else if (this.duR != null) {
                this.duR.gG(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.k kVar) {
        this.duR = kVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zl()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.ayH().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zw()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zp()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zp() || !TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zC()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.ayE().isAcceptNotify()) {
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
    protected void g(b.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.GT.setDrawerType(1);
        aVar.GT.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GT.setDrawBorder(false);
            aVar.GT.setAutoChangeStyle(true);
            aVar.GT.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                at.c(aVar.GT, ((Integer) runTask.getData()).intValue());
            }
            aVar.GT.setUserName(String.valueOf(2));
            aVar.GT.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GT.setIsRound(false);
            aVar.GT.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GT.setDrawBorder(false);
            aVar.GT.setAutoChangeStyle(true);
            aVar.GT.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GT.setUserName(String.valueOf(3));
            aVar.GT.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                at.c(aVar.GT, ((Integer) runTask2.getData()).intValue());
            }
            aVar.GT.setIsRound(false);
            aVar.GT.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GT.setDrawBorder(false);
            aVar.GT.setAutoChangeStyle(true);
            aVar.GT.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GT.setUserName(String.valueOf(6));
            aVar.GT.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                at.c(aVar.GT, ((Integer) runTask3.getData()).intValue());
            }
            aVar.GT.setIsRound(false);
            aVar.GT.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GT.setDrawBorder(true);
            aVar.GT.setAutoChangeStyle(true);
            aVar.GT.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.GT.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.GT.c(String.valueOf(r.f.icon_default_avatar100), 24, false);
            } else {
                aVar.GT.c(friendPortrait, 10, false);
            }
            aVar.GT.setClickable(false);
            aVar.GT.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.GT.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GT.setUserName(String.valueOf(1));
            aVar.GT.setIsRound(false);
            aVar.GT.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GT.setDrawBorder(false);
            aVar.GT.setAutoChangeStyle(true);
            aVar.GT.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GT.setUserName(String.valueOf(5));
            aVar.GT.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                at.c(aVar.GT, ((Integer) runTask4.getData()).intValue());
            }
            aVar.GT.setIsRound(false);
            aVar.GT.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GT.setDrawBorder(true);
            aVar.GT.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.GT.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.GT.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.GT.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.GT.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.GT.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GT.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.GT.setIsRound(false);
            aVar.GT.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GT.setDrawBorder(false);
            aVar.GT.setAutoChangeStyle(true);
            aVar.GT.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GT.setUserName(String.valueOf(7));
            aVar.GT.setUserId(imMessageCenterShowItemData.getFriendId());
            at.c(aVar.GT, r.f.icon_new_stranger);
            aVar.GT.setIsRound(false);
            aVar.GT.invalidate();
        } else {
            aVar.GT.setDrawBorder(true);
            aVar.GT.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.GT.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.GT.c(friendPortrait3, 12, false);
            } else {
                aVar.GT.c(String.valueOf(r.f.person_photo), 24, false);
            }
            aVar.GT.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.GT.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GT.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.GT.setIsRound(false);
            aVar.GT.invalidate();
        }
    }
}
