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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.im.chat.notify.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.u;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private com.baidu.tieba.imMessageCenter.mention.k dcd;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.dcd = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.dcd.o(true, true);
            } else {
                this.dcd.o(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData ky = getItem(i);
        if (ky != null && String.valueOf(String.valueOf(2)).equals(ky.getOwnerName())) {
            if (ky.getUnReadCount() >= 30) {
                if (this.dcd != null) {
                    this.dcd.fN(true);
                }
            } else if (this.dcd != null) {
                this.dcd.fN(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.k kVar) {
        this.dcd = kVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xO()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.arx().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xZ()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS() || !TbadkCoreApplication.m10getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().yf()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.aru().isAcceptNotify()) {
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
        aVar.EE.setDrawerType(1);
        aVar.EE.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.EE.setDrawBorder(false);
            aVar.EE.setAutoChangeStyle(true);
            aVar.EE.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                av.c(aVar.EE, ((Integer) runTask.getData()).intValue());
            }
            aVar.EE.setUserName(String.valueOf(2));
            aVar.EE.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.EE.setIsRound(false);
            aVar.EE.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.EE.setDrawBorder(false);
            aVar.EE.setAutoChangeStyle(true);
            aVar.EE.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.EE.setUserName(String.valueOf(3));
            aVar.EE.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                av.c(aVar.EE, ((Integer) runTask2.getData()).intValue());
            }
            aVar.EE.setIsRound(false);
            aVar.EE.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.EE.setDrawBorder(false);
            aVar.EE.setAutoChangeStyle(true);
            aVar.EE.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.EE.setUserName(String.valueOf(6));
            aVar.EE.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                av.c(aVar.EE, ((Integer) runTask3.getData()).intValue());
            }
            aVar.EE.setIsRound(false);
            aVar.EE.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.EE.setDrawBorder(true);
            aVar.EE.setAutoChangeStyle(true);
            aVar.EE.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.EE.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.EE.c(String.valueOf(u.f.icon_default_avatar100), 24, false);
            } else {
                aVar.EE.c(friendPortrait, 10, false);
            }
            aVar.EE.setClickable(false);
            aVar.EE.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.EE.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.EE.setUserName(String.valueOf(1));
            aVar.EE.setIsRound(false);
            aVar.EE.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.EE.setDrawBorder(false);
            aVar.EE.setAutoChangeStyle(true);
            aVar.EE.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.EE.setUserName(String.valueOf(5));
            aVar.EE.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                av.c(aVar.EE, ((Integer) runTask4.getData()).intValue());
            }
            aVar.EE.setIsRound(false);
            aVar.EE.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.EE.setDrawBorder(true);
            aVar.EE.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.EE.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.EE.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.EE.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.EE.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.EE.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.EE.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.EE.setIsRound(false);
            aVar.EE.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.EE.setDrawBorder(false);
            aVar.EE.setAutoChangeStyle(true);
            aVar.EE.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.EE.setUserName(String.valueOf(7));
            aVar.EE.setUserId(imMessageCenterShowItemData.getFriendId());
            av.c(aVar.EE, u.f.icon_new_stranger);
            aVar.EE.setIsRound(false);
            aVar.EE.invalidate();
        } else {
            aVar.EE.setDrawBorder(true);
            aVar.EE.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.EE.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.EE.c(friendPortrait3, 12, false);
            } else {
                aVar.EE.c(String.valueOf(u.f.person_photo), 24, false);
            }
            aVar.EE.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.EE.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.EE.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.EE.setIsRound(false);
            aVar.EE.invalidate();
        }
    }
}
