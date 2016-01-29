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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.im.chat.notify.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.t;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private com.baidu.tieba.imMessageCenter.mention.k cio;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.cio = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.cio.m(true, true);
            } else {
                this.cio.m(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData iG = getItem(i);
        if (iG != null && String.valueOf(String.valueOf(2)).equals(iG.getOwnerName())) {
            if (iG.getUnReadCount() >= 30) {
                if (this.cio != null) {
                    this.cio.dY(true);
                }
            } else if (this.cio != null) {
                this.cio.dY(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.k kVar) {
        this.cio = kVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zo()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.aeV().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zz()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs() || !TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zk().zs()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.aeS().isAcceptNotify()) {
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
        aVar.NA.setDrawerType(1);
        aVar.NA.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NA.setDrawBorder(false);
            aVar.NA.setAutoChangeStyle(true);
            aVar.NA.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                ar.c(aVar.NA, ((Integer) runTask.getData()).intValue());
            }
            aVar.NA.setUserName(String.valueOf(2));
            aVar.NA.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.NA.setIsRound(false);
            aVar.NA.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NA.setDrawBorder(false);
            aVar.NA.setAutoChangeStyle(true);
            aVar.NA.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.NA.setUserName(String.valueOf(3));
            aVar.NA.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                ar.c(aVar.NA, ((Integer) runTask2.getData()).intValue());
            }
            aVar.NA.setIsRound(false);
            aVar.NA.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NA.setDrawBorder(false);
            aVar.NA.setAutoChangeStyle(true);
            aVar.NA.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.NA.setUserName(String.valueOf(6));
            aVar.NA.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                ar.c(aVar.NA, ((Integer) runTask3.getData()).intValue());
            }
            aVar.NA.setIsRound(false);
            aVar.NA.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NA.setDrawBorder(true);
            aVar.NA.setAutoChangeStyle(true);
            aVar.NA.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.NA.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.NA.d(String.valueOf(t.f.icon_default_avatar100), 24, false);
            } else {
                aVar.NA.d(friendPortrait, 10, false);
            }
            aVar.NA.setClickable(false);
            aVar.NA.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.NA.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.NA.setUserName(String.valueOf(1));
            aVar.NA.setIsRound(false);
            aVar.NA.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NA.setDrawBorder(false);
            aVar.NA.setAutoChangeStyle(true);
            aVar.NA.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.NA.setUserName(String.valueOf(5));
            aVar.NA.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                ar.c(aVar.NA, ((Integer) runTask4.getData()).intValue());
            }
            aVar.NA.setIsRound(false);
            aVar.NA.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NA.setDrawBorder(true);
            aVar.NA.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.NA.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.NA.d(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.NA.d(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.NA.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.NA.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.NA.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.NA.setIsRound(false);
            aVar.NA.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.NA.setDrawBorder(false);
            aVar.NA.setAutoChangeStyle(true);
            aVar.NA.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.NA.setUserName(String.valueOf(7));
            aVar.NA.setUserId(imMessageCenterShowItemData.getFriendId());
            ar.c(aVar.NA, t.f.icon_new_stranger);
            aVar.NA.setIsRound(false);
            aVar.NA.invalidate();
        } else {
            aVar.NA.setDrawBorder(true);
            aVar.NA.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.NA.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.NA.d(friendPortrait3, 12, false);
            } else {
                aVar.NA.d(String.valueOf(t.f.person_photo), 24, false);
            }
            aVar.NA.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.NA.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.NA.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.NA.setIsRound(false);
            aVar.NA.invalidate();
        }
    }
}
