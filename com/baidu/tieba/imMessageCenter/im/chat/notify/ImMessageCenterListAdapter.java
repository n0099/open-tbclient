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
import com.baidu.tieba.im.chat.notify.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.n;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private com.baidu.tieba.imMessageCenter.mention.k bZN;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.bZN = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.bZN.i(true, true);
            } else {
                this.bZN.i(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData hJ = getItem(i);
        if (hJ != null && String.valueOf(String.valueOf(2)).equals(hJ.getOwnerName())) {
            if (hJ.getUnReadCount() >= 30) {
                if (this.bZN != null) {
                    this.bZN.dR(true);
                }
            } else if (this.bZN != null) {
                this.bZN.dR(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(com.baidu.tieba.imMessageCenter.mention.k kVar) {
        this.bZN = kVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yk()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.aaH().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yv()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo() || !TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yg().yo()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.aaE().isAcceptNotify()) {
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
        aVar.MM.setDrawerType(1);
        aVar.MM.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.MM.setDrawBorder(false);
            aVar.MM.setAutoChangeStyle(true);
            aVar.MM.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                as.c(aVar.MM, ((Integer) runTask.getData()).intValue());
            }
            aVar.MM.setUserName(String.valueOf(2));
            aVar.MM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.MM.setIsRound(false);
            aVar.MM.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.MM.setDrawBorder(false);
            aVar.MM.setAutoChangeStyle(true);
            aVar.MM.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.MM.setUserName(String.valueOf(3));
            aVar.MM.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                as.c(aVar.MM, ((Integer) runTask2.getData()).intValue());
            }
            aVar.MM.setIsRound(false);
            aVar.MM.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.MM.setDrawBorder(false);
            aVar.MM.setAutoChangeStyle(true);
            aVar.MM.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.MM.setUserName(String.valueOf(6));
            aVar.MM.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                as.c(aVar.MM, ((Integer) runTask3.getData()).intValue());
            }
            aVar.MM.setIsRound(false);
            aVar.MM.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.MM.setDrawBorder(true);
            aVar.MM.setAutoChangeStyle(true);
            aVar.MM.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.MM.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.MM.d(String.valueOf(n.e.icon_default_avatar100), 24, false);
            } else {
                aVar.MM.d(friendPortrait, 10, false);
            }
            aVar.MM.setClickable(false);
            aVar.MM.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.MM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.MM.setUserName(String.valueOf(1));
            aVar.MM.setIsRound(false);
            aVar.MM.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.MM.setDrawBorder(false);
            aVar.MM.setAutoChangeStyle(true);
            aVar.MM.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.MM.setUserName(String.valueOf(5));
            aVar.MM.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                as.c(aVar.MM, ((Integer) runTask4.getData()).intValue());
            }
            aVar.MM.setIsRound(false);
            aVar.MM.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.MM.setDrawBorder(true);
            aVar.MM.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.MM.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.MM.d(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.MM.d(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.MM.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.MM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.MM.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.MM.setIsRound(false);
            aVar.MM.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.MM.setDrawBorder(false);
            aVar.MM.setAutoChangeStyle(true);
            aVar.MM.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.MM.setUserName(String.valueOf(7));
            aVar.MM.setUserId(imMessageCenterShowItemData.getFriendId());
            as.c(aVar.MM, n.e.icon_new_stranger);
            aVar.MM.setIsRound(false);
            aVar.MM.invalidate();
        } else {
            aVar.MM.setDrawBorder(true);
            aVar.MM.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.MM.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.MM.d(friendPortrait3, 12, false);
            } else {
                aVar.MM.d(String.valueOf(n.e.person_photo), 24, false);
            }
            aVar.MM.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.MM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.MM.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.MM.setIsRound(false);
            aVar.MM.invalidate();
        }
    }
}
