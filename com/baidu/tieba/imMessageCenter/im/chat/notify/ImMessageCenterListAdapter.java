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
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.a.b {
    private com.baidu.tieba.imMessageCenter.mention.l djt;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.djt = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.djt.r(true, true);
            } else {
                this.djt.r(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData le = getItem(i);
        if (le != null && String.valueOf(String.valueOf(2)).equals(le.getOwnerName())) {
            if (le.getUnReadCount() >= 30) {
                if (this.djt != null) {
                    this.djt.gk(true);
                }
            } else if (this.djt != null) {
                this.djt.gk(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.l lVar) {
        this.djt = lVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zl()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.atH().isAcceptNotify()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zB()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.atE().isAcceptNotify()) {
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
        aVar.cQo.setDrawerType(1);
        aVar.cQo.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQo.setDrawBorder(false);
            aVar.cQo.setAutoChangeStyle(true);
            aVar.cQo.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                aq.c(aVar.cQo, ((Integer) runTask.getData()).intValue());
            }
            aVar.cQo.setUserName(String.valueOf(2));
            aVar.cQo.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cQo.setIsRound(false);
            aVar.cQo.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQo.setDrawBorder(false);
            aVar.cQo.setAutoChangeStyle(true);
            aVar.cQo.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cQo.setUserName(String.valueOf(3));
            aVar.cQo.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                aq.c(aVar.cQo, ((Integer) runTask2.getData()).intValue());
            }
            aVar.cQo.setIsRound(false);
            aVar.cQo.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQo.setDrawBorder(false);
            aVar.cQo.setAutoChangeStyle(true);
            aVar.cQo.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cQo.setUserName(String.valueOf(6));
            aVar.cQo.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                aq.c(aVar.cQo, ((Integer) runTask3.getData()).intValue());
            }
            aVar.cQo.setIsRound(false);
            aVar.cQo.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQo.setDrawBorder(true);
            aVar.cQo.setAutoChangeStyle(true);
            aVar.cQo.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cQo.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.cQo.c(String.valueOf(w.g.icon_default_avatar100), 24, false);
            } else {
                aVar.cQo.c(friendPortrait, 10, false);
            }
            aVar.cQo.setClickable(false);
            aVar.cQo.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cQo.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cQo.setUserName(String.valueOf(1));
            aVar.cQo.setIsRound(false);
            aVar.cQo.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQo.setDrawBorder(false);
            aVar.cQo.setAutoChangeStyle(true);
            aVar.cQo.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cQo.setUserName(String.valueOf(5));
            aVar.cQo.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                aq.c(aVar.cQo, ((Integer) runTask4.getData()).intValue());
            }
            aVar.cQo.setIsRound(false);
            aVar.cQo.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQo.setDrawBorder(true);
            aVar.cQo.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cQo.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.cQo.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.cQo.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.cQo.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cQo.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cQo.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.cQo.setIsRound(false);
            aVar.cQo.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQo.setDrawBorder(false);
            aVar.cQo.setAutoChangeStyle(true);
            aVar.cQo.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cQo.setUserName(String.valueOf(7));
            aVar.cQo.setUserId(imMessageCenterShowItemData.getFriendId());
            aq.c(aVar.cQo, w.g.icon_new_stranger);
            aVar.cQo.setIsRound(false);
            aVar.cQo.invalidate();
        } else {
            aVar.cQo.setDrawBorder(true);
            aVar.cQo.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cQo.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.cQo.c(friendPortrait3, 12, false);
            } else {
                aVar.cQo.c(String.valueOf(w.g.person_photo), 24, false);
            }
            aVar.cQo.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cQo.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cQo.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.cQo.setIsRound(false);
            aVar.cQo.invalidate();
        }
    }
}
