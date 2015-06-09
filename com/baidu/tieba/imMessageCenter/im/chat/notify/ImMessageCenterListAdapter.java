package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private d bsA;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.bsA = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.bsA.dm(true);
            } else {
                this.bsA.dm(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData fT = getItem(i);
        if (fT != null && String.valueOf(String.valueOf(2)).equals(fT.getOwnerName())) {
            if (fT.getUnReadCount() >= 30) {
                if (this.bsA != null) {
                    this.bsA.dl(true);
                }
            } else if (this.bsA != null) {
                this.bsA.dl(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void g(d dVar) {
        this.bsA = dVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.US().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wv()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo() || !TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.UP().isAcceptNotify()) {
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
    protected void f(com.baidu.tieba.im.chat.notify.c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        cVar.Mi.setDrawerType(1);
        cVar.Mi.setRadius(com.baidu.adp.lib.util.n.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mi.setDrawBorder(false);
            cVar.Mi.setAutoChangeStyle(true);
            cVar.Mi.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001294, Integer.class);
            if (runTask != null) {
                ay.c(cVar.Mi, ((Integer) runTask.getData()).intValue());
            }
            cVar.Mi.setUserName(String.valueOf(2));
            cVar.Mi.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Mi.setIsRound(false);
            cVar.Mi.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mi.setDrawBorder(false);
            cVar.Mi.setAutoChangeStyle(true);
            cVar.Mi.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Mi.setUserName(String.valueOf(3));
            cVar.Mi.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001293, Integer.class);
            if (runTask2 != null) {
                ay.c(cVar.Mi, ((Integer) runTask2.getData()).intValue());
            }
            cVar.Mi.setIsRound(false);
            cVar.Mi.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mi.setDrawBorder(false);
            cVar.Mi.setAutoChangeStyle(true);
            cVar.Mi.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Mi.setUserName(String.valueOf(6));
            cVar.Mi.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001295, Integer.class);
            if (runTask3 != null) {
                ay.c(cVar.Mi, ((Integer) runTask3.getData()).intValue());
            }
            cVar.Mi.setIsRound(false);
            cVar.Mi.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mi.setDrawBorder(true);
            cVar.Mi.setAutoChangeStyle(true);
            cVar.Mi.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            cVar.Mi.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                cVar.Mi.c(String.valueOf(com.baidu.tieba.p.icon_default_avatar100), 24, false);
            } else {
                cVar.Mi.c(friendPortrait, 10, false);
            }
            cVar.Mi.setClickable(false);
            cVar.Mi.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.Mi.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Mi.setUserName(String.valueOf(1));
            cVar.Mi.setIsRound(false);
            cVar.Mi.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mi.setDrawBorder(false);
            cVar.Mi.setAutoChangeStyle(true);
            cVar.Mi.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Mi.setUserName(String.valueOf(5));
            cVar.Mi.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001296, Integer.class);
            if (runTask4 != null) {
                ay.c(cVar.Mi, ((Integer) runTask4.getData()).intValue());
            }
            cVar.Mi.setIsRound(false);
            cVar.Mi.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mi.setDrawBorder(true);
            cVar.Mi.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.Mi.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                cVar.Mi.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(2001296, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    cVar.Mi.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            cVar.Mi.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.Mi.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Mi.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.Mi.setIsRound(false);
            cVar.Mi.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Mi.setDrawBorder(false);
            cVar.Mi.setAutoChangeStyle(true);
            cVar.Mi.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Mi.setUserName(String.valueOf(7));
            cVar.Mi.setUserId(imMessageCenterShowItemData.getFriendId());
            ay.c(cVar.Mi, com.baidu.tieba.p.icon_new_stranger);
            cVar.Mi.setIsRound(false);
            cVar.Mi.invalidate();
        } else {
            cVar.Mi.setDrawBorder(true);
            cVar.Mi.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.Mi.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                cVar.Mi.c(friendPortrait3, 12, false);
            } else {
                cVar.Mi.c(String.valueOf(com.baidu.tieba.p.person_photo), 24, false);
            }
            cVar.Mi.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.Mi.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Mi.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.Mi.setIsRound(false);
            cVar.Mi.invalidate();
        }
    }
}
