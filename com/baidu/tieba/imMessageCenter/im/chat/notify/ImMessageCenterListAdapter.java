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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.a.c;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.f;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class ImMessageCenterListAdapter extends c {
    private e eTl;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.eTl = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.eTl.I(true, true);
            } else {
                this.eTl.I(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData oQ = getItem(i);
        if (oQ != null && String.valueOf(String.valueOf(2)).equals(oQ.getOwnerName())) {
            if (oQ.getUnReadCount() >= 30) {
                if (this.eTl != null) {
                    this.eTl.iV(true);
                }
            } else if (this.eTl != null) {
                this.eTl.iV(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.eTl = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hk()) {
                str = "";
            } else {
                if (!f.aSX().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hw()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Ho()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Ho()) {
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
        aVar.eBa.setDrawerType(1);
        aVar.eBa.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eBa.setDrawBorder(false);
            aVar.eBa.setAutoChangeStyle(true);
            aVar.eBa.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001287, Integer.class);
            if (runTask != null) {
                al.c(aVar.eBa, ((Integer) runTask.getData()).intValue());
            }
            aVar.eBa.setUserName(String.valueOf(2));
            aVar.eBa.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eBa.setIsRound(false);
            aVar.eBa.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eBa.setDrawBorder(false);
            aVar.eBa.setAutoChangeStyle(true);
            aVar.eBa.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.eBa.setUserName(String.valueOf(3));
            aVar.eBa.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask2 != null) {
                al.c(aVar.eBa, ((Integer) runTask2.getData()).intValue());
            }
            aVar.eBa.setIsRound(false);
            aVar.eBa.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eBa.setDrawBorder(true);
            aVar.eBa.setAutoChangeStyle(true);
            aVar.eBa.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.eBa.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.eBa.startLoad(String.valueOf(e.f.icon_default_avatar100), 24, false);
            } else {
                aVar.eBa.startLoad(friendPortrait, 10, false);
            }
            aVar.eBa.setClickable(false);
            aVar.eBa.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.eBa.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eBa.setUserName(String.valueOf(1));
            aVar.eBa.setIsRound(false);
            aVar.eBa.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eBa.setDrawBorder(false);
            aVar.eBa.setAutoChangeStyle(true);
            aVar.eBa.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.eBa.setUserName(String.valueOf(5));
            aVar.eBa.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask3 != null) {
                al.c(aVar.eBa, ((Integer) runTask3.getData()).intValue());
            }
            aVar.eBa.setIsRound(false);
            aVar.eBa.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eBa.setDrawBorder(true);
            aVar.eBa.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.eBa.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.eBa.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    aVar.eBa.startLoad(((Integer) runTask4.getData()).toString(), 24, false);
                }
            }
            aVar.eBa.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.eBa.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eBa.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.eBa.setIsRound(false);
            aVar.eBa.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.eBa.setDrawBorder(false);
            aVar.eBa.setAutoChangeStyle(true);
            aVar.eBa.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.eBa.setUserName(String.valueOf(7));
            aVar.eBa.setUserId(imMessageCenterShowItemData.getFriendId());
            al.c(aVar.eBa, e.f.icon_new_stranger);
            aVar.eBa.setIsRound(false);
            aVar.eBa.invalidate();
        } else {
            aVar.eBa.setDrawBorder(true);
            aVar.eBa.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.eBa.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.eBa.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.eBa.startLoad(String.valueOf(e.f.person_photo), 24, false);
            }
            aVar.eBa.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.eBa.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.eBa.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.eBa.setIsRound(false);
            aVar.eBa.invalidate();
        }
    }
}
