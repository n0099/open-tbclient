package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.a.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.f;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.a.b {
    private e dJW;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.dJW = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.dJW.B(true, true);
            } else {
                this.dJW.B(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData mo = getItem(i);
        if (mo != null && String.valueOf(String.valueOf(2)).equals(mo.getOwnerName())) {
            if (mo.getUnReadCount() >= 30) {
                if (this.dJW != null) {
                    this.dJW.gZ(true);
                }
            } else if (this.dJW != null) {
                this.dJW.gZ(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.dJW = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zE()) {
                str = "";
            } else {
                if (!f.aAj().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zP()) {
                str = "";
            } else {
                GroupSettingItemData groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                if (groupSettingItemData != null && !groupSettingItemData.isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zI()) {
                str = "";
            } else {
                PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zI() || !TbadkCoreApplication.getInst().isPromotedMessageOn()) {
                str = "";
            }
            i2 = i;
        } else {
            if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.zA().zU()) {
                    str = "";
                } else if (!com.baidu.tieba.im.settingcache.c.aAg().isAcceptNotify()) {
                    str = "";
                }
            }
            i2 = i;
        }
        return new BasicNameValuePair(String.valueOf(i2), str);
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
        aVar.dqZ.setDrawerType(1);
        aVar.dqZ.setRadius(k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dqZ.setDrawBorder(false);
            aVar.dqZ.setAutoChangeStyle(true);
            aVar.dqZ.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                aj.c(aVar.dqZ, ((Integer) runTask.getData()).intValue());
            }
            aVar.dqZ.setUserName(String.valueOf(2));
            aVar.dqZ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dqZ.setIsRound(false);
            aVar.dqZ.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dqZ.setDrawBorder(false);
            aVar.dqZ.setAutoChangeStyle(true);
            aVar.dqZ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dqZ.setUserName(String.valueOf(3));
            aVar.dqZ.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                aj.c(aVar.dqZ, ((Integer) runTask2.getData()).intValue());
            }
            aVar.dqZ.setIsRound(false);
            aVar.dqZ.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dqZ.setDrawBorder(false);
            aVar.dqZ.setAutoChangeStyle(true);
            aVar.dqZ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dqZ.setUserName(String.valueOf(6));
            aVar.dqZ.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                aj.c(aVar.dqZ, ((Integer) runTask3.getData()).intValue());
            }
            aVar.dqZ.setIsRound(false);
            aVar.dqZ.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dqZ.setDrawBorder(true);
            aVar.dqZ.setAutoChangeStyle(true);
            aVar.dqZ.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dqZ.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.dqZ.c(String.valueOf(d.g.icon_default_avatar100), 24, false);
            } else {
                aVar.dqZ.c(friendPortrait, 10, false);
            }
            aVar.dqZ.setClickable(false);
            aVar.dqZ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dqZ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dqZ.setUserName(String.valueOf(1));
            aVar.dqZ.setIsRound(false);
            aVar.dqZ.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dqZ.setDrawBorder(false);
            aVar.dqZ.setAutoChangeStyle(true);
            aVar.dqZ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dqZ.setUserName(String.valueOf(5));
            aVar.dqZ.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                aj.c(aVar.dqZ, ((Integer) runTask4.getData()).intValue());
            }
            aVar.dqZ.setIsRound(false);
            aVar.dqZ.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dqZ.setDrawBorder(true);
            aVar.dqZ.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dqZ.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.dqZ.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.dqZ.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.dqZ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dqZ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dqZ.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.dqZ.setIsRound(false);
            aVar.dqZ.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dqZ.setDrawBorder(false);
            aVar.dqZ.setAutoChangeStyle(true);
            aVar.dqZ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dqZ.setUserName(String.valueOf(7));
            aVar.dqZ.setUserId(imMessageCenterShowItemData.getFriendId());
            aj.c(aVar.dqZ, d.g.icon_new_stranger);
            aVar.dqZ.setIsRound(false);
            aVar.dqZ.invalidate();
        } else {
            aVar.dqZ.setDrawBorder(true);
            aVar.dqZ.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dqZ.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.dqZ.c(friendPortrait3, 12, false);
            } else {
                aVar.dqZ.c(String.valueOf(d.g.person_photo), 24, false);
            }
            aVar.dqZ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dqZ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dqZ.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.dqZ.setIsRound(false);
            aVar.dqZ.invalidate();
        }
    }
}
