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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.notify.b;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private e bKJ;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.bKJ = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.bKJ.dx(true);
            } else {
                this.bKJ.dx(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData gX = getItem(i);
        if (gX != null && String.valueOf(String.valueOf(2)).equals(gX.getOwnerName())) {
            if (gX.getUnReadCount() >= 30) {
                if (this.bKJ != null) {
                    this.bKJ.dw(true);
                }
            } else if (this.bKJ != null) {
                this.bKJ.dw(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void g(e eVar) {
        this.bKJ = eVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xn()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.XB().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xy()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr() || !TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xj().xr()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.Xy().isAcceptNotify()) {
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
        aVar.Mv.setDrawerType(1);
        aVar.Mv.setRadius(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mv.setDrawBorder(false);
            aVar.Mv.setAutoChangeStyle(true);
            aVar.Mv.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class);
            if (runTask != null) {
                an.c(aVar.Mv, ((Integer) runTask.getData()).intValue());
            }
            aVar.Mv.setUserName(String.valueOf(2));
            aVar.Mv.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Mv.setIsRound(false);
            aVar.Mv.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mv.setDrawBorder(false);
            aVar.Mv.setAutoChangeStyle(true);
            aVar.Mv.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Mv.setUserName(String.valueOf(3));
            aVar.Mv.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask2 != null) {
                an.c(aVar.Mv, ((Integer) runTask2.getData()).intValue());
            }
            aVar.Mv.setIsRound(false);
            aVar.Mv.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mv.setDrawBorder(false);
            aVar.Mv.setAutoChangeStyle(true);
            aVar.Mv.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Mv.setUserName(String.valueOf(6));
            aVar.Mv.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_LIVE_NOTIFY_ICON, Integer.class);
            if (runTask3 != null) {
                an.c(aVar.Mv, ((Integer) runTask3.getData()).intValue());
            }
            aVar.Mv.setIsRound(false);
            aVar.Mv.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mv.setDrawBorder(true);
            aVar.Mv.setAutoChangeStyle(true);
            aVar.Mv.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Mv.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.Mv.d(String.valueOf(i.e.icon_default_avatar100), 24, false);
            } else {
                aVar.Mv.d(friendPortrait, 10, false);
            }
            aVar.Mv.setClickable(false);
            aVar.Mv.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Mv.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Mv.setUserName(String.valueOf(1));
            aVar.Mv.setIsRound(false);
            aVar.Mv.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mv.setDrawBorder(false);
            aVar.Mv.setAutoChangeStyle(true);
            aVar.Mv.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Mv.setUserName(String.valueOf(5));
            aVar.Mv.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask4 != null) {
                an.c(aVar.Mv, ((Integer) runTask4.getData()).intValue());
            }
            aVar.Mv.setIsRound(false);
            aVar.Mv.invalidate();
            TiebaStatic.log(new aq("c10321").r("obj_type", 2).ae("obj_name", "show"));
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mv.setDrawBorder(true);
            aVar.Mv.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Mv.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.Mv.d(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    aVar.Mv.d(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            aVar.Mv.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Mv.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Mv.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.Mv.setIsRound(false);
            aVar.Mv.invalidate();
            TiebaStatic.log(new aq("c10321").r("obj_type", 2).ae("obj_name", "show"));
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.Mv.setDrawBorder(false);
            aVar.Mv.setAutoChangeStyle(true);
            aVar.Mv.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.Mv.setUserName(String.valueOf(7));
            aVar.Mv.setUserId(imMessageCenterShowItemData.getFriendId());
            an.c(aVar.Mv, i.e.icon_new_stranger);
            aVar.Mv.setIsRound(false);
            aVar.Mv.invalidate();
        } else {
            aVar.Mv.setDrawBorder(true);
            aVar.Mv.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.Mv.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.Mv.d(friendPortrait3, 12, false);
            } else {
                aVar.Mv.d(String.valueOf(i.e.person_photo), 24, false);
            }
            aVar.Mv.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.Mv.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.Mv.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.Mv.setIsRound(false);
            aVar.Mv.invalidate();
        }
    }
}
