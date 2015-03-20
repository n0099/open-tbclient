package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.u;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.notify.b {
    private d bpE;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.bpE = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.bpE.dd(true);
            } else {
                this.bpE.dd(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData fA = getItem(i);
        if (fA != null && String.valueOf(String.valueOf(2)).equals(fA.getOwnerName())) {
            if (fA.getUnReadCount() >= 30) {
                if (this.bpE != null) {
                    this.bpE.dc(true);
                }
            } else if (this.bpE != null) {
                this.bpE.dc(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void g(d dVar) {
        this.bpE = dVar;
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vu()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.Tr().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vF()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy() || !TbadkCoreApplication.m411getInst().isPromotedMessageOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.To().isAcceptNotify()) {
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
        cVar.Ml.setDrawerType(1);
        cVar.Ml.setRadius(com.baidu.adp.lib.util.n.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Ml.setDrawBorder(false);
            cVar.Ml.setAutoChangeStyle(true);
            cVar.Ml.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001294, Integer.class);
            if (runTask != null) {
                ba.c(cVar.Ml, ((Integer) runTask.getData()).intValue());
            }
            cVar.Ml.setUserName(String.valueOf(2));
            cVar.Ml.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Ml.setIsRound(false);
            cVar.Ml.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Ml.setDrawBorder(false);
            cVar.Ml.setAutoChangeStyle(true);
            cVar.Ml.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Ml.setUserName(String.valueOf(3));
            cVar.Ml.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001293, Integer.class);
            if (runTask2 != null) {
                ba.c(cVar.Ml, ((Integer) runTask2.getData()).intValue());
            }
            cVar.Ml.setIsRound(false);
            cVar.Ml.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Ml.setDrawBorder(false);
            cVar.Ml.setAutoChangeStyle(true);
            cVar.Ml.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Ml.setUserName(String.valueOf(6));
            cVar.Ml.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001295, Integer.class);
            if (runTask3 != null) {
                ba.c(cVar.Ml, ((Integer) runTask3.getData()).intValue());
            }
            cVar.Ml.setIsRound(false);
            cVar.Ml.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Ml.setDrawBorder(true);
            cVar.Ml.setAutoChangeStyle(true);
            cVar.Ml.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            cVar.Ml.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                cVar.Ml.c(String.valueOf(u.icon_default_avatar100), 24, false);
            } else {
                cVar.Ml.c(friendPortrait, 10, false);
            }
            cVar.Ml.setClickable(false);
            cVar.Ml.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.Ml.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Ml.setUserName(String.valueOf(1));
            cVar.Ml.setIsRound(false);
            cVar.Ml.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Ml.setDrawBorder(false);
            cVar.Ml.setAutoChangeStyle(true);
            cVar.Ml.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Ml.setUserName(String.valueOf(5));
            cVar.Ml.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001296, Integer.class);
            if (runTask4 != null) {
                ba.c(cVar.Ml, ((Integer) runTask4.getData()).intValue());
            }
            cVar.Ml.setIsRound(false);
            cVar.Ml.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Ml.setDrawBorder(true);
            cVar.Ml.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.Ml.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                cVar.Ml.c(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(2001296, Integer.class);
                if (runTask5 != null && runTask5.getData() != null) {
                    cVar.Ml.c(((Integer) runTask5.getData()).toString(), 24, false);
                }
            }
            cVar.Ml.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.Ml.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Ml.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.Ml.setIsRound(false);
            cVar.Ml.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.Ml.setDrawBorder(false);
            cVar.Ml.setAutoChangeStyle(true);
            cVar.Ml.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.Ml.setUserName(String.valueOf(7));
            cVar.Ml.setUserId(imMessageCenterShowItemData.getFriendId());
            ba.c(cVar.Ml, u.icon_new_stranger);
            cVar.Ml.setIsRound(false);
            cVar.Ml.invalidate();
        } else {
            cVar.Ml.setDrawBorder(true);
            cVar.Ml.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.Ml.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                cVar.Ml.c(friendPortrait3, 12, false);
            } else {
                cVar.Ml.c(String.valueOf(u.person_photo), 24, false);
            }
            cVar.Ml.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.Ml.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.Ml.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.Ml.setIsRound(false);
            cVar.Ml.invalidate();
        }
    }
}
