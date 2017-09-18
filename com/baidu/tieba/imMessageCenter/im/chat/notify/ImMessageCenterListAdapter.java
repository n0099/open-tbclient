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
    private e dKR;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.dKR = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.dKR.B(true, true);
            } else {
                this.dKR.B(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData mq = getItem(i);
        if (mq != null && String.valueOf(String.valueOf(2)).equals(mq.getOwnerName())) {
            if (mq.getUnReadCount() >= 30) {
                if (this.dKR != null) {
                    this.dKR.ha(true);
                }
            } else if (this.dKR != null) {
                this.dKR.ha(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.dKR = eVar;
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
                if (!f.aAu().isAcceptNotify()) {
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
                } else if (!com.baidu.tieba.im.settingcache.c.aAr().isAcceptNotify()) {
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
        aVar.drU.setDrawerType(1);
        aVar.drU.setRadius(k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.drU.setDrawBorder(false);
            aVar.drU.setAutoChangeStyle(true);
            aVar.drU.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                aj.c(aVar.drU, ((Integer) runTask.getData()).intValue());
            }
            aVar.drU.setUserName(String.valueOf(2));
            aVar.drU.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.drU.setIsRound(false);
            aVar.drU.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.drU.setDrawBorder(false);
            aVar.drU.setAutoChangeStyle(true);
            aVar.drU.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.drU.setUserName(String.valueOf(3));
            aVar.drU.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                aj.c(aVar.drU, ((Integer) runTask2.getData()).intValue());
            }
            aVar.drU.setIsRound(false);
            aVar.drU.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.drU.setDrawBorder(false);
            aVar.drU.setAutoChangeStyle(true);
            aVar.drU.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.drU.setUserName(String.valueOf(6));
            aVar.drU.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                aj.c(aVar.drU, ((Integer) runTask3.getData()).intValue());
            }
            aVar.drU.setIsRound(false);
            aVar.drU.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.drU.setDrawBorder(true);
            aVar.drU.setAutoChangeStyle(true);
            aVar.drU.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.drU.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.drU.c(String.valueOf(d.g.icon_default_avatar100), 24, false);
            } else {
                aVar.drU.c(friendPortrait, 10, false);
            }
            aVar.drU.setClickable(false);
            aVar.drU.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.drU.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.drU.setUserName(String.valueOf(1));
            aVar.drU.setIsRound(false);
            aVar.drU.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.drU.setDrawBorder(false);
            aVar.drU.setAutoChangeStyle(true);
            aVar.drU.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.drU.setUserName(String.valueOf(5));
            aVar.drU.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                aj.c(aVar.drU, ((Integer) runTask4.getData()).intValue());
            }
            aVar.drU.setIsRound(false);
            aVar.drU.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.drU.setDrawBorder(true);
            aVar.drU.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.drU.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.drU.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.drU.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.drU.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.drU.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.drU.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.drU.setIsRound(false);
            aVar.drU.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.drU.setDrawBorder(false);
            aVar.drU.setAutoChangeStyle(true);
            aVar.drU.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.drU.setUserName(String.valueOf(7));
            aVar.drU.setUserId(imMessageCenterShowItemData.getFriendId());
            aj.c(aVar.drU, d.g.icon_new_stranger);
            aVar.drU.setIsRound(false);
            aVar.drU.invalidate();
        } else {
            aVar.drU.setDrawBorder(true);
            aVar.drU.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.drU.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.drU.c(friendPortrait3, 12, false);
            } else {
                aVar.drU.c(String.valueOf(d.g.person_photo), 24, false);
            }
            aVar.drU.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.drU.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.drU.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.drU.setIsRound(false);
            aVar.drU.invalidate();
        }
    }
}
