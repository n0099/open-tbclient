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
    private e ePJ;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.ePJ = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.ePJ.G(true, true);
            } else {
                this.ePJ.G(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData pJ = getItem(i);
        if (pJ != null && String.valueOf(String.valueOf(2)).equals(pJ.getOwnerName())) {
            if (pJ.getUnReadCount() >= 30) {
                if (this.ePJ != null) {
                    this.ePJ.hY(true);
                }
            } else if (this.ePJ != null) {
                this.ePJ.hY(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.ePJ = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Ht()) {
                str = "";
            } else {
                if (!f.aLX().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HE()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hx()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hx() || !TbadkCoreApplication.getInst().isPromotedMessageOn()) {
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
        aVar.ewW.setDrawerType(1);
        aVar.ewW.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ewW.setDrawBorder(false);
            aVar.ewW.setAutoChangeStyle(true);
            aVar.ewW.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001287, Integer.class);
            if (runTask != null) {
                aj.c(aVar.ewW, ((Integer) runTask.getData()).intValue());
            }
            aVar.ewW.setUserName(String.valueOf(2));
            aVar.ewW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ewW.setIsRound(false);
            aVar.ewW.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ewW.setDrawBorder(false);
            aVar.ewW.setAutoChangeStyle(true);
            aVar.ewW.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.ewW.setUserName(String.valueOf(3));
            aVar.ewW.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask2 != null) {
                aj.c(aVar.ewW, ((Integer) runTask2.getData()).intValue());
            }
            aVar.ewW.setIsRound(false);
            aVar.ewW.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ewW.setDrawBorder(true);
            aVar.ewW.setAutoChangeStyle(true);
            aVar.ewW.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.ewW.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.ewW.startLoad(String.valueOf(d.f.icon_default_avatar100), 24, false);
            } else {
                aVar.ewW.startLoad(friendPortrait, 10, false);
            }
            aVar.ewW.setClickable(false);
            aVar.ewW.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.ewW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ewW.setUserName(String.valueOf(1));
            aVar.ewW.setIsRound(false);
            aVar.ewW.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ewW.setDrawBorder(false);
            aVar.ewW.setAutoChangeStyle(true);
            aVar.ewW.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.ewW.setUserName(String.valueOf(5));
            aVar.ewW.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask3 != null) {
                aj.c(aVar.ewW, ((Integer) runTask3.getData()).intValue());
            }
            aVar.ewW.setIsRound(false);
            aVar.ewW.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ewW.setDrawBorder(true);
            aVar.ewW.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.ewW.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.ewW.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    aVar.ewW.startLoad(((Integer) runTask4.getData()).toString(), 24, false);
                }
            }
            aVar.ewW.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.ewW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ewW.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.ewW.setIsRound(false);
            aVar.ewW.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ewW.setDrawBorder(false);
            aVar.ewW.setAutoChangeStyle(true);
            aVar.ewW.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.ewW.setUserName(String.valueOf(7));
            aVar.ewW.setUserId(imMessageCenterShowItemData.getFriendId());
            aj.c(aVar.ewW, d.f.icon_new_stranger);
            aVar.ewW.setIsRound(false);
            aVar.ewW.invalidate();
        } else {
            aVar.ewW.setDrawBorder(true);
            aVar.ewW.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.ewW.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.ewW.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.ewW.startLoad(String.valueOf(d.f.person_photo), 24, false);
            }
            aVar.ewW.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.ewW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ewW.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.ewW.setIsRound(false);
            aVar.ewW.invalidate();
        }
    }
}
