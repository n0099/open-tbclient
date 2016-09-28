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
import com.baidu.tieba.r;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private com.baidu.tieba.imMessageCenter.mention.k dpk;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.dpk = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.dpk.t(true, true);
            } else {
                this.dpk.t(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData lj = getItem(i);
        if (lj != null && String.valueOf(String.valueOf(2)).equals(lj.getOwnerName())) {
            if (lj.getUnReadCount() >= 30) {
                if (this.dpk != null) {
                    this.dpk.gm(true);
                }
            } else if (this.dpk != null) {
                this.dpk.gm(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.k kVar) {
        this.dpk = kVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.za().ze()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.awK().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.za().zp()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.za().zi()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.za().zi() || !TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.za().zv()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.awH().isAcceptNotify()) {
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
        aVar.GQ.setDrawerType(1);
        aVar.GQ.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GQ.setDrawBorder(false);
            aVar.GQ.setAutoChangeStyle(true);
            aVar.GQ.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                av.c(aVar.GQ, ((Integer) runTask.getData()).intValue());
            }
            aVar.GQ.setUserName(String.valueOf(2));
            aVar.GQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GQ.setIsRound(false);
            aVar.GQ.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GQ.setDrawBorder(false);
            aVar.GQ.setAutoChangeStyle(true);
            aVar.GQ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GQ.setUserName(String.valueOf(3));
            aVar.GQ.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                av.c(aVar.GQ, ((Integer) runTask2.getData()).intValue());
            }
            aVar.GQ.setIsRound(false);
            aVar.GQ.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GQ.setDrawBorder(false);
            aVar.GQ.setAutoChangeStyle(true);
            aVar.GQ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GQ.setUserName(String.valueOf(6));
            aVar.GQ.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                av.c(aVar.GQ, ((Integer) runTask3.getData()).intValue());
            }
            aVar.GQ.setIsRound(false);
            aVar.GQ.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GQ.setDrawBorder(true);
            aVar.GQ.setAutoChangeStyle(true);
            aVar.GQ.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.GQ.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.GQ.c(String.valueOf(r.f.icon_default_avatar100), 24, false);
            } else {
                aVar.GQ.c(friendPortrait, 10, false);
            }
            aVar.GQ.setClickable(false);
            aVar.GQ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.GQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GQ.setUserName(String.valueOf(1));
            aVar.GQ.setIsRound(false);
            aVar.GQ.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GQ.setDrawBorder(false);
            aVar.GQ.setAutoChangeStyle(true);
            aVar.GQ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GQ.setUserName(String.valueOf(5));
            aVar.GQ.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                av.c(aVar.GQ, ((Integer) runTask4.getData()).intValue());
            }
            aVar.GQ.setIsRound(false);
            aVar.GQ.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GQ.setDrawBorder(true);
            aVar.GQ.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.GQ.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.GQ.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.GQ.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.GQ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.GQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GQ.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.GQ.setIsRound(false);
            aVar.GQ.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GQ.setDrawBorder(false);
            aVar.GQ.setAutoChangeStyle(true);
            aVar.GQ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GQ.setUserName(String.valueOf(7));
            aVar.GQ.setUserId(imMessageCenterShowItemData.getFriendId());
            av.c(aVar.GQ, r.f.icon_new_stranger);
            aVar.GQ.setIsRound(false);
            aVar.GQ.invalidate();
        } else {
            aVar.GQ.setDrawBorder(true);
            aVar.GQ.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.GQ.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.GQ.c(friendPortrait3, 12, false);
            } else {
                aVar.GQ.c(String.valueOf(r.f.person_photo), 24, false);
            }
            aVar.GQ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.GQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GQ.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.GQ.setIsRound(false);
            aVar.GQ.invalidate();
        }
    }
}
