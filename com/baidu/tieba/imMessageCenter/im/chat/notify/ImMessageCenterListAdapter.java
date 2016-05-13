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
    private com.baidu.tieba.imMessageCenter.mention.k ctR;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.ctR = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.ctR.n(true, true);
            } else {
                this.ctR.n(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData iQ = getItem(i);
        if (iQ != null && String.valueOf(String.valueOf(2)).equals(iQ.getOwnerName())) {
            if (iQ.getUnReadCount() >= 30) {
                if (this.ctR != null) {
                    this.ctR.eW(true);
                }
            } else if (this.ctR != null) {
                this.ctR.eW(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.k kVar) {
        this.ctR = kVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xG().xK()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.aix().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xG().xV()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xG().xO()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xG().xO() || !TbadkCoreApplication.m11getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xG().yb()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.aiu().isAcceptNotify()) {
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
        aVar.DZ.setDrawerType(1);
        aVar.DZ.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.DZ.setDrawBorder(false);
            aVar.DZ.setAutoChangeStyle(true);
            aVar.DZ.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                at.c(aVar.DZ, ((Integer) runTask.getData()).intValue());
            }
            aVar.DZ.setUserName(String.valueOf(2));
            aVar.DZ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.DZ.setIsRound(false);
            aVar.DZ.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.DZ.setDrawBorder(false);
            aVar.DZ.setAutoChangeStyle(true);
            aVar.DZ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.DZ.setUserName(String.valueOf(3));
            aVar.DZ.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                at.c(aVar.DZ, ((Integer) runTask2.getData()).intValue());
            }
            aVar.DZ.setIsRound(false);
            aVar.DZ.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.DZ.setDrawBorder(false);
            aVar.DZ.setAutoChangeStyle(true);
            aVar.DZ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.DZ.setUserName(String.valueOf(6));
            aVar.DZ.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                at.c(aVar.DZ, ((Integer) runTask3.getData()).intValue());
            }
            aVar.DZ.setIsRound(false);
            aVar.DZ.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.DZ.setDrawBorder(true);
            aVar.DZ.setAutoChangeStyle(true);
            aVar.DZ.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.DZ.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.DZ.c(String.valueOf(t.f.icon_default_avatar100), 24, false);
            } else {
                aVar.DZ.c(friendPortrait, 10, false);
            }
            aVar.DZ.setClickable(false);
            aVar.DZ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.DZ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.DZ.setUserName(String.valueOf(1));
            aVar.DZ.setIsRound(false);
            aVar.DZ.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.DZ.setDrawBorder(false);
            aVar.DZ.setAutoChangeStyle(true);
            aVar.DZ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.DZ.setUserName(String.valueOf(5));
            aVar.DZ.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                at.c(aVar.DZ, ((Integer) runTask4.getData()).intValue());
            }
            aVar.DZ.setIsRound(false);
            aVar.DZ.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.DZ.setDrawBorder(true);
            aVar.DZ.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.DZ.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.DZ.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.DZ.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.DZ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.DZ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.DZ.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.DZ.setIsRound(false);
            aVar.DZ.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.DZ.setDrawBorder(false);
            aVar.DZ.setAutoChangeStyle(true);
            aVar.DZ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.DZ.setUserName(String.valueOf(7));
            aVar.DZ.setUserId(imMessageCenterShowItemData.getFriendId());
            at.c(aVar.DZ, t.f.icon_new_stranger);
            aVar.DZ.setIsRound(false);
            aVar.DZ.invalidate();
        } else {
            aVar.DZ.setDrawBorder(true);
            aVar.DZ.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.DZ.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.DZ.c(friendPortrait3, 12, false);
            } else {
                aVar.DZ.c(String.valueOf(t.f.person_photo), 24, false);
            }
            aVar.DZ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.DZ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.DZ.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.DZ.setIsRound(false);
            aVar.DZ.invalidate();
        }
    }
}
