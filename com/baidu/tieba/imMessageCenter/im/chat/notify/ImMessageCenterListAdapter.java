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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.notify.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private e bKd;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.bKd = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.bKd.dv(true);
            } else {
                this.bKd.dv(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData gK = getItem(i);
        if (gK != null && String.valueOf(String.valueOf(2)).equals(gK.getOwnerName())) {
            if (gK.getUnReadCount() >= 30) {
                if (this.bKd != null) {
                    this.bKd.du(true);
                }
            } else if (this.bKd != null) {
                this.bKd.du(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void g(e eVar) {
        this.bKd = eVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xl()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.Xk().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xw()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp() || !TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xh().xp()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.Xh().isAcceptNotify()) {
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
    protected void f(b.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.Mt.setDrawerType(1);
        aVar.Mt.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mt.setDrawBorder(false);
            aVar.Mt.setAutoChangeStyle(true);
            aVar.Mt.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                am.c(aVar.Mt, ((Integer) runTask.getData()).intValue());
            }
            aVar.Mt.setUserName(String.valueOf(2));
            aVar.Mt.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Mt.setIsRound(false);
            aVar.Mt.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mt.setDrawBorder(false);
            aVar.Mt.setAutoChangeStyle(true);
            aVar.Mt.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Mt.setUserName(String.valueOf(3));
            aVar.Mt.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                am.c(aVar.Mt, ((Integer) runTask2.getData()).intValue());
            }
            aVar.Mt.setIsRound(false);
            aVar.Mt.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mt.setDrawBorder(false);
            aVar.Mt.setAutoChangeStyle(true);
            aVar.Mt.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Mt.setUserName(String.valueOf(6));
            aVar.Mt.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                am.c(aVar.Mt, ((Integer) runTask3.getData()).intValue());
            }
            aVar.Mt.setIsRound(false);
            aVar.Mt.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mt.setDrawBorder(true);
            aVar.Mt.setAutoChangeStyle(true);
            aVar.Mt.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Mt.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.Mt.d(String.valueOf(i.e.icon_default_avatar100), 24, false);
            } else {
                aVar.Mt.d(friendPortrait, 10, false);
            }
            aVar.Mt.setClickable(false);
            aVar.Mt.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Mt.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Mt.setUserName(String.valueOf(1));
            aVar.Mt.setIsRound(false);
            aVar.Mt.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mt.setDrawBorder(false);
            aVar.Mt.setAutoChangeStyle(true);
            aVar.Mt.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Mt.setUserName(String.valueOf(5));
            aVar.Mt.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                am.c(aVar.Mt, ((Integer) runTask4.getData()).intValue());
            }
            aVar.Mt.setIsRound(false);
            aVar.Mt.invalidate();
            TiebaStatic.log(new ap("c10321").r("obj_type", 2).ae("obj_name", "show"));
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mt.setDrawBorder(true);
            aVar.Mt.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Mt.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.Mt.d(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.Mt.d(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.Mt.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Mt.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Mt.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.Mt.setIsRound(false);
            aVar.Mt.invalidate();
            TiebaStatic.log(new ap("c10321").r("obj_type", 2).ae("obj_name", "show"));
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mt.setDrawBorder(false);
            aVar.Mt.setAutoChangeStyle(true);
            aVar.Mt.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Mt.setUserName(String.valueOf(7));
            aVar.Mt.setUserId(imMessageCenterShowItemData.getFriendId());
            am.c(aVar.Mt, i.e.icon_new_stranger);
            aVar.Mt.setIsRound(false);
            aVar.Mt.invalidate();
        } else {
            aVar.Mt.setDrawBorder(true);
            aVar.Mt.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Mt.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.Mt.d(friendPortrait3, 12, false);
            } else {
                aVar.Mt.d(String.valueOf(i.e.person_photo), 24, false);
            }
            aVar.Mt.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Mt.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Mt.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.Mt.setIsRound(false);
            aVar.Mt.invalidate();
        }
    }
}
