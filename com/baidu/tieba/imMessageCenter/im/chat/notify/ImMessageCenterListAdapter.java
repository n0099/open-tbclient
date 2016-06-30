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
    private com.baidu.tieba.imMessageCenter.mention.k cZg;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.cZg = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.cZg.o(true, true);
            } else {
                this.cZg.o(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData ks = getItem(i);
        if (ks != null && String.valueOf(String.valueOf(2)).equals(ks.getOwnerName())) {
            if (ks.getUnReadCount() >= 30) {
                if (this.cZg != null) {
                    this.cZg.fK(true);
                }
            } else if (this.cZg != null) {
                this.cZg.fK(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.k kVar) {
        this.cZg = kVar;
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
            } else if (!com.baidu.tieba.im.settingcache.l.aqL().isAcceptNotify()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().xS() || !TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().yf()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.aqI().isAcceptNotify()) {
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
        aVar.Ee.setDrawerType(1);
        aVar.Ee.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Ee.setDrawBorder(false);
            aVar.Ee.setAutoChangeStyle(true);
            aVar.Ee.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                av.c(aVar.Ee, ((Integer) runTask.getData()).intValue());
            }
            aVar.Ee.setUserName(String.valueOf(2));
            aVar.Ee.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Ee.setIsRound(false);
            aVar.Ee.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Ee.setDrawBorder(false);
            aVar.Ee.setAutoChangeStyle(true);
            aVar.Ee.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Ee.setUserName(String.valueOf(3));
            aVar.Ee.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                av.c(aVar.Ee, ((Integer) runTask2.getData()).intValue());
            }
            aVar.Ee.setIsRound(false);
            aVar.Ee.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Ee.setDrawBorder(false);
            aVar.Ee.setAutoChangeStyle(true);
            aVar.Ee.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Ee.setUserName(String.valueOf(6));
            aVar.Ee.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                av.c(aVar.Ee, ((Integer) runTask3.getData()).intValue());
            }
            aVar.Ee.setIsRound(false);
            aVar.Ee.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Ee.setDrawBorder(true);
            aVar.Ee.setAutoChangeStyle(true);
            aVar.Ee.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Ee.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.Ee.c(String.valueOf(u.f.icon_default_avatar100), 24, false);
            } else {
                aVar.Ee.c(friendPortrait, 10, false);
            }
            aVar.Ee.setClickable(false);
            aVar.Ee.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Ee.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Ee.setUserName(String.valueOf(1));
            aVar.Ee.setIsRound(false);
            aVar.Ee.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Ee.setDrawBorder(false);
            aVar.Ee.setAutoChangeStyle(true);
            aVar.Ee.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Ee.setUserName(String.valueOf(5));
            aVar.Ee.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                av.c(aVar.Ee, ((Integer) runTask4.getData()).intValue());
            }
            aVar.Ee.setIsRound(false);
            aVar.Ee.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Ee.setDrawBorder(true);
            aVar.Ee.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Ee.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.Ee.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.Ee.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.Ee.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Ee.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Ee.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.Ee.setIsRound(false);
            aVar.Ee.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Ee.setDrawBorder(false);
            aVar.Ee.setAutoChangeStyle(true);
            aVar.Ee.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Ee.setUserName(String.valueOf(7));
            aVar.Ee.setUserId(imMessageCenterShowItemData.getFriendId());
            av.c(aVar.Ee, u.f.icon_new_stranger);
            aVar.Ee.setIsRound(false);
            aVar.Ee.invalidate();
        } else {
            aVar.Ee.setDrawBorder(true);
            aVar.Ee.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Ee.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.Ee.c(friendPortrait3, 12, false);
            } else {
                aVar.Ee.c(String.valueOf(u.f.person_photo), 24, false);
            }
            aVar.Ee.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Ee.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Ee.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.Ee.setIsRound(false);
            aVar.Ee.invalidate();
        }
    }
}
