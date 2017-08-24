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
import com.baidu.tbadk.core.util.ai;
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
    private e dDs;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.dDs = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.dDs.A(true, true);
            } else {
                this.dDs.A(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData lW = getItem(i);
        if (lW != null && String.valueOf(String.valueOf(2)).equals(lW.getOwnerName())) {
            if (lW.getUnReadCount() >= 30) {
                if (this.dDs != null) {
                    this.dDs.gR(true);
                }
            } else if (this.dDs != null) {
                this.dDs.gR(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.dDs = eVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zw().zA()) {
                str = "";
            } else {
                if (!f.ayu().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zw().zL()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zw().zE()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.zw().zE() || !TbadkCoreApplication.getInst().isPromotedMessageOn()) {
                str = "";
            }
            i2 = i;
        } else {
            if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.zw().zQ()) {
                    str = "";
                } else if (!com.baidu.tieba.im.settingcache.c.ayr().isAcceptNotify()) {
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
        aVar.dkv.setDrawerType(1);
        aVar.dkv.setRadius(k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dkv.setDrawBorder(false);
            aVar.dkv.setAutoChangeStyle(true);
            aVar.dkv.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                ai.c(aVar.dkv, ((Integer) runTask.getData()).intValue());
            }
            aVar.dkv.setUserName(String.valueOf(2));
            aVar.dkv.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dkv.setIsRound(false);
            aVar.dkv.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dkv.setDrawBorder(false);
            aVar.dkv.setAutoChangeStyle(true);
            aVar.dkv.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dkv.setUserName(String.valueOf(3));
            aVar.dkv.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                ai.c(aVar.dkv, ((Integer) runTask2.getData()).intValue());
            }
            aVar.dkv.setIsRound(false);
            aVar.dkv.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dkv.setDrawBorder(false);
            aVar.dkv.setAutoChangeStyle(true);
            aVar.dkv.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dkv.setUserName(String.valueOf(6));
            aVar.dkv.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                ai.c(aVar.dkv, ((Integer) runTask3.getData()).intValue());
            }
            aVar.dkv.setIsRound(false);
            aVar.dkv.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dkv.setDrawBorder(true);
            aVar.dkv.setAutoChangeStyle(true);
            aVar.dkv.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dkv.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.dkv.c(String.valueOf(d.g.icon_default_avatar100), 24, false);
            } else {
                aVar.dkv.c(friendPortrait, 10, false);
            }
            aVar.dkv.setClickable(false);
            aVar.dkv.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dkv.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dkv.setUserName(String.valueOf(1));
            aVar.dkv.setIsRound(false);
            aVar.dkv.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dkv.setDrawBorder(false);
            aVar.dkv.setAutoChangeStyle(true);
            aVar.dkv.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dkv.setUserName(String.valueOf(5));
            aVar.dkv.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                ai.c(aVar.dkv, ((Integer) runTask4.getData()).intValue());
            }
            aVar.dkv.setIsRound(false);
            aVar.dkv.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dkv.setDrawBorder(true);
            aVar.dkv.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dkv.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.dkv.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.dkv.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.dkv.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dkv.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dkv.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.dkv.setIsRound(false);
            aVar.dkv.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dkv.setDrawBorder(false);
            aVar.dkv.setAutoChangeStyle(true);
            aVar.dkv.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dkv.setUserName(String.valueOf(7));
            aVar.dkv.setUserId(imMessageCenterShowItemData.getFriendId());
            ai.c(aVar.dkv, d.g.icon_new_stranger);
            aVar.dkv.setIsRound(false);
            aVar.dkv.invalidate();
        } else {
            aVar.dkv.setDrawBorder(true);
            aVar.dkv.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dkv.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.dkv.c(friendPortrait3, 12, false);
            } else {
                aVar.dkv.c(String.valueOf(d.g.person_photo), 24, false);
            }
            aVar.dkv.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dkv.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dkv.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.dkv.setIsRound(false);
            aVar.dkv.invalidate();
        }
    }
}
