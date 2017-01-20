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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.r;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.a.b {
    private com.baidu.tieba.imMessageCenter.mention.l dhb;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.dhb = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.dhb.s(true, true);
            } else {
                this.dhb.s(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData lo = getItem(i);
        if (lo != null && String.valueOf(String.valueOf(2)).equals(lo.getOwnerName())) {
            if (lo.getUnReadCount() >= 30) {
                if (this.dhb != null) {
                    this.dhb.gt(true);
                }
            } else if (this.dhb != null) {
                this.dhb.gt(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.l lVar) {
        this.dhb = lVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yQ().yU()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.aum().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yQ().zf()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yQ().yY()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yQ().yY() || !TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yQ().zk()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.auj().isAcceptNotify()) {
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
        aVar.Gc.setDrawerType(1);
        aVar.Gc.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Gc.setDrawBorder(false);
            aVar.Gc.setAutoChangeStyle(true);
            aVar.Gc.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                ap.c(aVar.Gc, ((Integer) runTask.getData()).intValue());
            }
            aVar.Gc.setUserName(String.valueOf(2));
            aVar.Gc.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Gc.setIsRound(false);
            aVar.Gc.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Gc.setDrawBorder(false);
            aVar.Gc.setAutoChangeStyle(true);
            aVar.Gc.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Gc.setUserName(String.valueOf(3));
            aVar.Gc.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                ap.c(aVar.Gc, ((Integer) runTask2.getData()).intValue());
            }
            aVar.Gc.setIsRound(false);
            aVar.Gc.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Gc.setDrawBorder(false);
            aVar.Gc.setAutoChangeStyle(true);
            aVar.Gc.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Gc.setUserName(String.valueOf(6));
            aVar.Gc.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                ap.c(aVar.Gc, ((Integer) runTask3.getData()).intValue());
            }
            aVar.Gc.setIsRound(false);
            aVar.Gc.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Gc.setDrawBorder(true);
            aVar.Gc.setAutoChangeStyle(true);
            aVar.Gc.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Gc.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.Gc.c(String.valueOf(r.g.icon_default_avatar100), 24, false);
            } else {
                aVar.Gc.c(friendPortrait, 10, false);
            }
            aVar.Gc.setClickable(false);
            aVar.Gc.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Gc.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Gc.setUserName(String.valueOf(1));
            aVar.Gc.setIsRound(false);
            aVar.Gc.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Gc.setDrawBorder(false);
            aVar.Gc.setAutoChangeStyle(true);
            aVar.Gc.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Gc.setUserName(String.valueOf(5));
            aVar.Gc.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                ap.c(aVar.Gc, ((Integer) runTask4.getData()).intValue());
            }
            aVar.Gc.setIsRound(false);
            aVar.Gc.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Gc.setDrawBorder(true);
            aVar.Gc.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Gc.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.Gc.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.Gc.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.Gc.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Gc.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Gc.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.Gc.setIsRound(false);
            aVar.Gc.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Gc.setDrawBorder(false);
            aVar.Gc.setAutoChangeStyle(true);
            aVar.Gc.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Gc.setUserName(String.valueOf(7));
            aVar.Gc.setUserId(imMessageCenterShowItemData.getFriendId());
            ap.c(aVar.Gc, r.g.icon_new_stranger);
            aVar.Gc.setIsRound(false);
            aVar.Gc.invalidate();
        } else {
            aVar.Gc.setDrawBorder(true);
            aVar.Gc.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Gc.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.Gc.c(friendPortrait3, 12, false);
            } else {
                aVar.Gc.c(String.valueOf(r.g.person_photo), 24, false);
            }
            aVar.Gc.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Gc.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Gc.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.Gc.setIsRound(false);
            aVar.Gc.invalidate();
        }
    }
}
