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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.w;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.a.b {
    private com.baidu.tieba.imMessageCenter.mention.l drC;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.drC = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.drC.v(true, true);
            } else {
                this.drC.v(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData lD = getItem(i);
        if (lD != null && String.valueOf(String.valueOf(2)).equals(lD.getOwnerName())) {
            if (lD.getUnReadCount() >= 30) {
                if (this.drC != null) {
                    this.drC.gA(true);
                }
            } else if (this.drC != null) {
                this.drC.gA(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.l lVar) {
        this.drC = lVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zh()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.awe().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zs()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zl()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zl() || !TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zd().zx()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.awb().isAcceptNotify()) {
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
        aVar.cYy.setDrawerType(1);
        aVar.cYy.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cYy.setDrawBorder(false);
            aVar.cYy.setAutoChangeStyle(true);
            aVar.cYy.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                as.c(aVar.cYy, ((Integer) runTask.getData()).intValue());
            }
            aVar.cYy.setUserName(String.valueOf(2));
            aVar.cYy.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cYy.setIsRound(false);
            aVar.cYy.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cYy.setDrawBorder(false);
            aVar.cYy.setAutoChangeStyle(true);
            aVar.cYy.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cYy.setUserName(String.valueOf(3));
            aVar.cYy.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                as.c(aVar.cYy, ((Integer) runTask2.getData()).intValue());
            }
            aVar.cYy.setIsRound(false);
            aVar.cYy.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cYy.setDrawBorder(false);
            aVar.cYy.setAutoChangeStyle(true);
            aVar.cYy.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cYy.setUserName(String.valueOf(6));
            aVar.cYy.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                as.c(aVar.cYy, ((Integer) runTask3.getData()).intValue());
            }
            aVar.cYy.setIsRound(false);
            aVar.cYy.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cYy.setDrawBorder(true);
            aVar.cYy.setAutoChangeStyle(true);
            aVar.cYy.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cYy.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.cYy.c(String.valueOf(w.g.icon_default_avatar100), 24, false);
            } else {
                aVar.cYy.c(friendPortrait, 10, false);
            }
            aVar.cYy.setClickable(false);
            aVar.cYy.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cYy.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cYy.setUserName(String.valueOf(1));
            aVar.cYy.setIsRound(false);
            aVar.cYy.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cYy.setDrawBorder(false);
            aVar.cYy.setAutoChangeStyle(true);
            aVar.cYy.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cYy.setUserName(String.valueOf(5));
            aVar.cYy.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                as.c(aVar.cYy, ((Integer) runTask4.getData()).intValue());
            }
            aVar.cYy.setIsRound(false);
            aVar.cYy.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cYy.setDrawBorder(true);
            aVar.cYy.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cYy.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.cYy.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.cYy.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.cYy.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cYy.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cYy.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.cYy.setIsRound(false);
            aVar.cYy.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.cYy.setDrawBorder(false);
            aVar.cYy.setAutoChangeStyle(true);
            aVar.cYy.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.cYy.setUserName(String.valueOf(7));
            aVar.cYy.setUserId(imMessageCenterShowItemData.getFriendId());
            as.c(aVar.cYy, w.g.icon_new_stranger);
            aVar.cYy.setIsRound(false);
            aVar.cYy.invalidate();
        } else {
            aVar.cYy.setDrawBorder(true);
            aVar.cYy.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.cYy.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.cYy.c(friendPortrait3, 12, false);
            } else {
                aVar.cYy.c(String.valueOf(w.g.person_photo), 24, false);
            }
            aVar.cYy.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.cYy.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.cYy.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.cYy.setIsRound(false);
            aVar.cYy.invalidate();
        }
    }
}
