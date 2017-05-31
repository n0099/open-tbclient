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
    private com.baidu.tieba.imMessageCenter.mention.l djG;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.djG = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.djG.u(true, true);
            } else {
                this.djG.u(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData ls = getItem(i);
        if (ls != null && String.valueOf(String.valueOf(2)).equals(ls.getOwnerName())) {
            if (ls.getUnReadCount() >= 30) {
                if (this.djG != null) {
                    this.djG.gi(true);
                }
            } else if (this.djG != null) {
                this.djG.gi(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.l lVar) {
        this.djG = lVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().yO()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.ast().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().yZ()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().yS()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().yS() || !TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yK().ze()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.asq().isAcceptNotify()) {
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
        aVar.cQC.setDrawerType(1);
        aVar.cQC.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQC.setDrawBorder(false);
            aVar.cQC.setAutoChangeStyle(true);
            aVar.cQC.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                aq.c(aVar.cQC, ((Integer) runTask.getData()).intValue());
            }
            aVar.cQC.setUserName(String.valueOf(2));
            aVar.cQC.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cQC.setIsRound(false);
            aVar.cQC.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQC.setDrawBorder(false);
            aVar.cQC.setAutoChangeStyle(true);
            aVar.cQC.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cQC.setUserName(String.valueOf(3));
            aVar.cQC.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                aq.c(aVar.cQC, ((Integer) runTask2.getData()).intValue());
            }
            aVar.cQC.setIsRound(false);
            aVar.cQC.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQC.setDrawBorder(false);
            aVar.cQC.setAutoChangeStyle(true);
            aVar.cQC.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cQC.setUserName(String.valueOf(6));
            aVar.cQC.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                aq.c(aVar.cQC, ((Integer) runTask3.getData()).intValue());
            }
            aVar.cQC.setIsRound(false);
            aVar.cQC.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQC.setDrawBorder(true);
            aVar.cQC.setAutoChangeStyle(true);
            aVar.cQC.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cQC.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.cQC.c(String.valueOf(w.g.icon_default_avatar100), 24, false);
            } else {
                aVar.cQC.c(friendPortrait, 10, false);
            }
            aVar.cQC.setClickable(false);
            aVar.cQC.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cQC.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cQC.setUserName(String.valueOf(1));
            aVar.cQC.setIsRound(false);
            aVar.cQC.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQC.setDrawBorder(false);
            aVar.cQC.setAutoChangeStyle(true);
            aVar.cQC.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cQC.setUserName(String.valueOf(5));
            aVar.cQC.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                aq.c(aVar.cQC, ((Integer) runTask4.getData()).intValue());
            }
            aVar.cQC.setIsRound(false);
            aVar.cQC.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQC.setDrawBorder(true);
            aVar.cQC.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cQC.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.cQC.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.cQC.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.cQC.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cQC.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cQC.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.cQC.setIsRound(false);
            aVar.cQC.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cQC.setDrawBorder(false);
            aVar.cQC.setAutoChangeStyle(true);
            aVar.cQC.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cQC.setUserName(String.valueOf(7));
            aVar.cQC.setUserId(imMessageCenterShowItemData.getFriendId());
            aq.c(aVar.cQC, w.g.icon_new_stranger);
            aVar.cQC.setIsRound(false);
            aVar.cQC.invalidate();
        } else {
            aVar.cQC.setDrawBorder(true);
            aVar.cQC.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cQC.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.cQC.c(friendPortrait3, 12, false);
            } else {
                aVar.cQC.c(String.valueOf(w.g.person_photo), 24, false);
            }
            aVar.cQC.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cQC.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cQC.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.cQC.setIsRound(false);
            aVar.cQC.invalidate();
        }
    }
}
