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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.a.c;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.f;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class ImMessageCenterListAdapter extends com.baidu.tieba.im.chat.a.c {
    private e ePY;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.ePY = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.ePY.G(true, true);
            } else {
                this.ePY.G(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData pK = getItem(i);
        if (pK != null && String.valueOf(String.valueOf(2)).equals(pK.getOwnerName())) {
            if (pK.getUnReadCount() >= 30) {
                if (this.ePY != null) {
                    this.ePY.id(true);
                }
            } else if (this.ePY != null) {
                this.ePY.id(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.ePY = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hu()) {
                str = "";
            } else {
                if (!f.aLY().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HF()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hy()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hy() || !TbadkCoreApplication.getInst().isPromotedMessageOn()) {
                str = "";
            }
            i2 = i;
        } else {
            if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                str = "";
            }
            i2 = i;
        }
        return new BasicNameValuePair(String.valueOf(i2), str);
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.a.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.exm.setDrawerType(1);
        aVar.exm.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.exm.setDrawBorder(false);
            aVar.exm.setAutoChangeStyle(true);
            aVar.exm.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001287, Integer.class);
            if (runTask != null) {
                aj.c(aVar.exm, ((Integer) runTask.getData()).intValue());
            }
            aVar.exm.setUserName(String.valueOf(2));
            aVar.exm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.exm.setIsRound(false);
            aVar.exm.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.exm.setDrawBorder(false);
            aVar.exm.setAutoChangeStyle(true);
            aVar.exm.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.exm.setUserName(String.valueOf(3));
            aVar.exm.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask2 != null) {
                aj.c(aVar.exm, ((Integer) runTask2.getData()).intValue());
            }
            aVar.exm.setIsRound(false);
            aVar.exm.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.exm.setDrawBorder(true);
            aVar.exm.setAutoChangeStyle(true);
            aVar.exm.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.exm.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.exm.startLoad(String.valueOf(d.f.icon_default_avatar100), 24, false);
            } else {
                aVar.exm.startLoad(friendPortrait, 10, false);
            }
            aVar.exm.setClickable(false);
            aVar.exm.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.exm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.exm.setUserName(String.valueOf(1));
            aVar.exm.setIsRound(false);
            aVar.exm.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.exm.setDrawBorder(false);
            aVar.exm.setAutoChangeStyle(true);
            aVar.exm.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.exm.setUserName(String.valueOf(5));
            aVar.exm.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask3 != null) {
                aj.c(aVar.exm, ((Integer) runTask3.getData()).intValue());
            }
            aVar.exm.setIsRound(false);
            aVar.exm.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.exm.setDrawBorder(true);
            aVar.exm.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.exm.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.exm.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    aVar.exm.startLoad(((Integer) runTask4.getData()).toString(), 24, false);
                }
            }
            aVar.exm.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.exm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.exm.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.exm.setIsRound(false);
            aVar.exm.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.exm.setDrawBorder(false);
            aVar.exm.setAutoChangeStyle(true);
            aVar.exm.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.exm.setUserName(String.valueOf(7));
            aVar.exm.setUserId(imMessageCenterShowItemData.getFriendId());
            aj.c(aVar.exm, d.f.icon_new_stranger);
            aVar.exm.setIsRound(false);
            aVar.exm.invalidate();
        } else {
            aVar.exm.setDrawBorder(true);
            aVar.exm.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.exm.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.exm.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.exm.startLoad(String.valueOf(d.f.person_photo), 24, false);
            }
            aVar.exm.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.exm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.exm.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.exm.setIsRound(false);
            aVar.exm.invalidate();
        }
    }
}
