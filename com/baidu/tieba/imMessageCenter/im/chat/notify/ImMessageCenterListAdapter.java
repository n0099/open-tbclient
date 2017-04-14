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
    private com.baidu.tieba.imMessageCenter.mention.l dhS;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.dhS = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.dhS.r(true, true);
            } else {
                this.dhS.r(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData lf = getItem(i);
        if (lf != null && String.valueOf(String.valueOf(2)).equals(lf.getOwnerName())) {
            if (lf.getUnReadCount() >= 30) {
                if (this.dhS != null) {
                    this.dhS.gk(true);
                }
            } else if (this.dhS != null) {
                this.dhS.gk(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.l lVar) {
        this.dhS = lVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zK()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.atA().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zV()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zO()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().zO() || !TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zG().Aa()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.atx().isAcceptNotify()) {
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
        aVar.cOL.setDrawerType(1);
        aVar.cOL.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cOL.setDrawBorder(false);
            aVar.cOL.setAutoChangeStyle(true);
            aVar.cOL.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                aq.c(aVar.cOL, ((Integer) runTask.getData()).intValue());
            }
            aVar.cOL.setUserName(String.valueOf(2));
            aVar.cOL.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cOL.setIsRound(false);
            aVar.cOL.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cOL.setDrawBorder(false);
            aVar.cOL.setAutoChangeStyle(true);
            aVar.cOL.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cOL.setUserName(String.valueOf(3));
            aVar.cOL.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                aq.c(aVar.cOL, ((Integer) runTask2.getData()).intValue());
            }
            aVar.cOL.setIsRound(false);
            aVar.cOL.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cOL.setDrawBorder(false);
            aVar.cOL.setAutoChangeStyle(true);
            aVar.cOL.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cOL.setUserName(String.valueOf(6));
            aVar.cOL.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                aq.c(aVar.cOL, ((Integer) runTask3.getData()).intValue());
            }
            aVar.cOL.setIsRound(false);
            aVar.cOL.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cOL.setDrawBorder(true);
            aVar.cOL.setAutoChangeStyle(true);
            aVar.cOL.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cOL.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.cOL.c(String.valueOf(w.g.icon_default_avatar100), 24, false);
            } else {
                aVar.cOL.c(friendPortrait, 10, false);
            }
            aVar.cOL.setClickable(false);
            aVar.cOL.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cOL.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cOL.setUserName(String.valueOf(1));
            aVar.cOL.setIsRound(false);
            aVar.cOL.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cOL.setDrawBorder(false);
            aVar.cOL.setAutoChangeStyle(true);
            aVar.cOL.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cOL.setUserName(String.valueOf(5));
            aVar.cOL.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                aq.c(aVar.cOL, ((Integer) runTask4.getData()).intValue());
            }
            aVar.cOL.setIsRound(false);
            aVar.cOL.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cOL.setDrawBorder(true);
            aVar.cOL.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cOL.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.cOL.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.cOL.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.cOL.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cOL.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cOL.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.cOL.setIsRound(false);
            aVar.cOL.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cOL.setDrawBorder(false);
            aVar.cOL.setAutoChangeStyle(true);
            aVar.cOL.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cOL.setUserName(String.valueOf(7));
            aVar.cOL.setUserId(imMessageCenterShowItemData.getFriendId());
            aq.c(aVar.cOL, w.g.icon_new_stranger);
            aVar.cOL.setIsRound(false);
            aVar.cOL.invalidate();
        } else {
            aVar.cOL.setDrawBorder(true);
            aVar.cOL.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cOL.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.cOL.c(friendPortrait3, 12, false);
            } else {
                aVar.cOL.c(String.valueOf(w.g.person_photo), 24, false);
            }
            aVar.cOL.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cOL.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cOL.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.cOL.setIsRound(false);
            aVar.cOL.invalidate();
        }
    }
}
