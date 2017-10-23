package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
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
    private e dGS;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.dGS = null;
    }

    @Override // com.baidu.tieba.im.chat.a.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.dGS.C(true, true);
            } else {
                this.dGS.C(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData ml = getItem(i);
        if (ml != null && String.valueOf(String.valueOf(2)).equals(ml.getOwnerName())) {
            if (ml.getUnReadCount() >= 30) {
                if (this.dGS != null) {
                    this.dGS.gM(true);
                }
            } else if (this.dGS != null) {
                this.dGS.gM(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.dGS = eVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.yS().yW()) {
                str = "";
            } else {
                if (!f.azc().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.yS().zh()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.yS().za()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.b.yS().za() || !TbadkCoreApplication.getInst().isPromotedMessageOn()) {
                str = "";
            }
            i2 = i;
        } else {
            if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                if (!com.baidu.tbadk.coreExtra.messageCenter.b.yS().zm()) {
                    str = "";
                } else if (!com.baidu.tieba.im.settingcache.c.ayZ().isAcceptNotify()) {
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
        aVar.dnW.setDrawerType(1);
        aVar.dnW.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dnW.setDrawBorder(false);
            aVar.dnW.setAutoChangeStyle(true);
            aVar.dnW.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                aj.c(aVar.dnW, ((Integer) runTask.getData()).intValue());
            }
            aVar.dnW.setUserName(String.valueOf(2));
            aVar.dnW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dnW.setIsRound(false);
            aVar.dnW.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dnW.setDrawBorder(false);
            aVar.dnW.setAutoChangeStyle(true);
            aVar.dnW.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dnW.setUserName(String.valueOf(3));
            aVar.dnW.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                aj.c(aVar.dnW, ((Integer) runTask2.getData()).intValue());
            }
            aVar.dnW.setIsRound(false);
            aVar.dnW.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dnW.setDrawBorder(false);
            aVar.dnW.setAutoChangeStyle(true);
            aVar.dnW.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dnW.setUserName(String.valueOf(6));
            aVar.dnW.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                aj.c(aVar.dnW, ((Integer) runTask3.getData()).intValue());
            }
            aVar.dnW.setIsRound(false);
            aVar.dnW.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dnW.setDrawBorder(true);
            aVar.dnW.setAutoChangeStyle(true);
            aVar.dnW.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dnW.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.dnW.c(String.valueOf(d.g.icon_default_avatar100), 24, false);
            } else {
                aVar.dnW.c(friendPortrait, 10, false);
            }
            aVar.dnW.setClickable(false);
            aVar.dnW.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dnW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dnW.setUserName(String.valueOf(1));
            aVar.dnW.setIsRound(false);
            aVar.dnW.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dnW.setDrawBorder(false);
            aVar.dnW.setAutoChangeStyle(true);
            aVar.dnW.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dnW.setUserName(String.valueOf(5));
            aVar.dnW.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                aj.c(aVar.dnW, ((Integer) runTask4.getData()).intValue());
            }
            aVar.dnW.setIsRound(false);
            aVar.dnW.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dnW.setDrawBorder(true);
            aVar.dnW.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dnW.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.dnW.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.dnW.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.dnW.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dnW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dnW.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.dnW.setIsRound(false);
            aVar.dnW.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.dnW.setDrawBorder(false);
            aVar.dnW.setAutoChangeStyle(true);
            aVar.dnW.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.dnW.setUserName(String.valueOf(7));
            aVar.dnW.setUserId(imMessageCenterShowItemData.getFriendId());
            aj.c(aVar.dnW, d.g.icon_new_stranger);
            aVar.dnW.setIsRound(false);
            aVar.dnW.invalidate();
        } else {
            aVar.dnW.setDrawBorder(true);
            aVar.dnW.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.dnW.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.dnW.c(friendPortrait3, 12, false);
            } else {
                aVar.dnW.c(String.valueOf(d.g.person_photo), 24, false);
            }
            aVar.dnW.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.dnW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.dnW.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.dnW.setIsRound(false);
            aVar.dnW.invalidate();
        }
    }
}
