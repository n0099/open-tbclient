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
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.r;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.a.b {
    private com.baidu.tieba.imMessageCenter.mention.o cZM;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.cZM = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.cZM.u(true, true);
            } else {
                this.cZM.u(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData kB = getItem(i);
        if (kB != null && String.valueOf(String.valueOf(2)).equals(kB.getOwnerName())) {
            if (kB.getUnReadCount() >= 30) {
                if (this.cZM != null) {
                    this.cZM.gq(true);
                }
            } else if (this.cZM != null) {
                this.cZM.gq(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.o oVar) {
        this.cZM = oVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yV().yZ()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.atg().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yV().zk()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yV().zd()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yV().zd() || !TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yV().zp()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.atd().isAcceptNotify()) {
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
        aVar.GS.setDrawerType(1);
        aVar.GS.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GS.setDrawBorder(false);
            aVar.GS.setAutoChangeStyle(true);
            aVar.GS.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                ar.c(aVar.GS, ((Integer) runTask.getData()).intValue());
            }
            aVar.GS.setUserName(String.valueOf(2));
            aVar.GS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GS.setIsRound(false);
            aVar.GS.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GS.setDrawBorder(false);
            aVar.GS.setAutoChangeStyle(true);
            aVar.GS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GS.setUserName(String.valueOf(3));
            aVar.GS.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                ar.c(aVar.GS, ((Integer) runTask2.getData()).intValue());
            }
            aVar.GS.setIsRound(false);
            aVar.GS.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GS.setDrawBorder(false);
            aVar.GS.setAutoChangeStyle(true);
            aVar.GS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GS.setUserName(String.valueOf(6));
            aVar.GS.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                ar.c(aVar.GS, ((Integer) runTask3.getData()).intValue());
            }
            aVar.GS.setIsRound(false);
            aVar.GS.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GS.setDrawBorder(true);
            aVar.GS.setAutoChangeStyle(true);
            aVar.GS.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.GS.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.GS.c(String.valueOf(r.f.icon_default_avatar100), 24, false);
            } else {
                aVar.GS.c(friendPortrait, 10, false);
            }
            aVar.GS.setClickable(false);
            aVar.GS.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.GS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GS.setUserName(String.valueOf(1));
            aVar.GS.setIsRound(false);
            aVar.GS.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GS.setDrawBorder(false);
            aVar.GS.setAutoChangeStyle(true);
            aVar.GS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GS.setUserName(String.valueOf(5));
            aVar.GS.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                ar.c(aVar.GS, ((Integer) runTask4.getData()).intValue());
            }
            aVar.GS.setIsRound(false);
            aVar.GS.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GS.setDrawBorder(true);
            aVar.GS.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.GS.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.GS.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.GS.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.GS.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.GS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GS.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.GS.setIsRound(false);
            aVar.GS.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.GS.setDrawBorder(false);
            aVar.GS.setAutoChangeStyle(true);
            aVar.GS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.GS.setUserName(String.valueOf(7));
            aVar.GS.setUserId(imMessageCenterShowItemData.getFriendId());
            ar.c(aVar.GS, r.f.icon_new_stranger);
            aVar.GS.setIsRound(false);
            aVar.GS.invalidate();
        } else {
            aVar.GS.setDrawBorder(true);
            aVar.GS.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.GS.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.GS.c(friendPortrait3, 12, false);
            } else {
                aVar.GS.c(String.valueOf(r.f.person_photo), 24, false);
            }
            aVar.GS.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.GS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.GS.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.GS.setIsRound(false);
            aVar.GS.invalidate();
        }
    }
}
