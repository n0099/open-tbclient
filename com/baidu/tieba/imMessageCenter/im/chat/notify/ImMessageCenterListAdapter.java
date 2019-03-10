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
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.a.c;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.f;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class ImMessageCenterListAdapter extends c {
    private e gve;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.gve = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.gve.R(true, true);
            } else {
                this.gve.R(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData tB = getItem(i);
        if (tB != null && String.valueOf(String.valueOf(2)).equals(tB.getOwnerName())) {
            if (tB.getUnReadCount() >= 30) {
                if (this.gve != null) {
                    this.gve.lK(true);
                }
            } else if (this.gve != null) {
                this.gve.lK(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.gve = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aih().ail()) {
                str = "";
            } else {
                if (!f.bwf().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aih().aix()) {
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
            if (!d.aih().aip()) {
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
            if (!d.aih().aip()) {
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
        aVar.gcO.setDrawerType(1);
        aVar.gcO.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gcO.setDrawBorder(false);
            aVar.gcO.setAutoChangeStyle(true);
            aVar.gcO.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001287, Integer.class);
            if (runTask != null) {
                al.c(aVar.gcO, ((Integer) runTask.getData()).intValue());
            }
            aVar.gcO.setUserName(String.valueOf(2));
            aVar.gcO.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gcO.setIsRound(false);
            aVar.gcO.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gcO.setDrawBorder(false);
            aVar.gcO.setAutoChangeStyle(true);
            aVar.gcO.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gcO.setUserName(String.valueOf(3));
            aVar.gcO.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask2 != null) {
                al.c(aVar.gcO, ((Integer) runTask2.getData()).intValue());
            }
            aVar.gcO.setIsRound(false);
            aVar.gcO.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gcO.setDrawBorder(true);
            aVar.gcO.setAutoChangeStyle(true);
            aVar.gcO.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gcO.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.gcO.startLoad(String.valueOf(d.f.icon_default_avatar100), 24, false);
            } else {
                aVar.gcO.startLoad(friendPortrait, 10, false);
            }
            aVar.gcO.setClickable(false);
            aVar.gcO.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gcO.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gcO.setUserName(String.valueOf(1));
            aVar.gcO.setIsRound(false);
            aVar.gcO.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gcO.setDrawBorder(false);
            aVar.gcO.setAutoChangeStyle(true);
            aVar.gcO.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gcO.setUserName(String.valueOf(5));
            aVar.gcO.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask3 != null) {
                al.c(aVar.gcO, ((Integer) runTask3.getData()).intValue());
            }
            aVar.gcO.setIsRound(false);
            aVar.gcO.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gcO.setDrawBorder(true);
            aVar.gcO.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gcO.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.gcO.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    aVar.gcO.startLoad(((Integer) runTask4.getData()).toString(), 24, false);
                }
            }
            aVar.gcO.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gcO.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gcO.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gcO.setIsRound(false);
            aVar.gcO.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gcO.setDrawBorder(false);
            aVar.gcO.setAutoChangeStyle(true);
            aVar.gcO.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gcO.setUserName(String.valueOf(7));
            aVar.gcO.setUserId(imMessageCenterShowItemData.getFriendId());
            al.c(aVar.gcO, d.f.icon_new_stranger);
            aVar.gcO.setIsRound(false);
            aVar.gcO.invalidate();
        } else {
            aVar.gcO.setDrawBorder(true);
            aVar.gcO.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gcO.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.gcO.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.gcO.startLoad(String.valueOf(d.f.person_photo), 24, false);
            }
            aVar.gcO.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gcO.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gcO.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gcO.setIsRound(false);
            aVar.gcO.invalidate();
        }
    }
}
