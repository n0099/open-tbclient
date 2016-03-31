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
import com.baidu.tieba.t;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private com.baidu.tieba.imMessageCenter.mention.k csT;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.csT = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.csT.o(true, true);
            } else {
                this.csT.o(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData jn = getItem(i);
        if (jn != null && String.valueOf(String.valueOf(2)).equals(jn.getOwnerName())) {
            if (jn.getUnReadCount() >= 30) {
                if (this.csT != null) {
                    this.csT.eu(true);
                }
            } else if (this.csT != null) {
                this.csT.eu(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.k kVar) {
        this.csT = kVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zQ()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.aio().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ab()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zU()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().zU() || !TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zM().Ah()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.ail().isAcceptNotify()) {
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
        aVar.NH.setDrawerType(1);
        aVar.NH.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NH.setDrawBorder(false);
            aVar.NH.setAutoChangeStyle(true);
            aVar.NH.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                at.c(aVar.NH, ((Integer) runTask.getData()).intValue());
            }
            aVar.NH.setUserName(String.valueOf(2));
            aVar.NH.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.NH.setIsRound(false);
            aVar.NH.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NH.setDrawBorder(false);
            aVar.NH.setAutoChangeStyle(true);
            aVar.NH.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.NH.setUserName(String.valueOf(3));
            aVar.NH.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                at.c(aVar.NH, ((Integer) runTask2.getData()).intValue());
            }
            aVar.NH.setIsRound(false);
            aVar.NH.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NH.setDrawBorder(false);
            aVar.NH.setAutoChangeStyle(true);
            aVar.NH.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.NH.setUserName(String.valueOf(6));
            aVar.NH.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                at.c(aVar.NH, ((Integer) runTask3.getData()).intValue());
            }
            aVar.NH.setIsRound(false);
            aVar.NH.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NH.setDrawBorder(true);
            aVar.NH.setAutoChangeStyle(true);
            aVar.NH.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.NH.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.NH.c(String.valueOf(t.f.icon_default_avatar100), 24, false);
            } else {
                aVar.NH.c(friendPortrait, 10, false);
            }
            aVar.NH.setClickable(false);
            aVar.NH.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.NH.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.NH.setUserName(String.valueOf(1));
            aVar.NH.setIsRound(false);
            aVar.NH.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NH.setDrawBorder(false);
            aVar.NH.setAutoChangeStyle(true);
            aVar.NH.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.NH.setUserName(String.valueOf(5));
            aVar.NH.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                at.c(aVar.NH, ((Integer) runTask4.getData()).intValue());
            }
            aVar.NH.setIsRound(false);
            aVar.NH.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NH.setDrawBorder(true);
            aVar.NH.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.NH.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.NH.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.NH.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.NH.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.NH.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.NH.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.NH.setIsRound(false);
            aVar.NH.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NH.setDrawBorder(false);
            aVar.NH.setAutoChangeStyle(true);
            aVar.NH.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.NH.setUserName(String.valueOf(7));
            aVar.NH.setUserId(imMessageCenterShowItemData.getFriendId());
            at.c(aVar.NH, t.f.icon_new_stranger);
            aVar.NH.setIsRound(false);
            aVar.NH.invalidate();
        } else {
            aVar.NH.setDrawBorder(true);
            aVar.NH.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.NH.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.NH.c(friendPortrait3, 12, false);
            } else {
                aVar.NH.c(String.valueOf(t.f.person_photo), 24, false);
            }
            aVar.NH.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.NH.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.NH.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.NH.setIsRound(false);
            aVar.NH.invalidate();
        }
    }
}
