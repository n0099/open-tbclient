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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.a.c;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.f;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class ImMessageCenterListAdapter extends c {
    private e gSr;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.gSr = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.gSr.T(true, true);
            } else {
                this.gSr.T(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData vf = getItem(i);
        if (vf != null && String.valueOf(String.valueOf(2)).equals(vf.getOwnerName())) {
            if (vf.getUnReadCount() >= 30) {
                if (this.gSr != null) {
                    this.gSr.mO(true);
                }
            } else if (this.gSr != null) {
                this.gSr.mO(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.gSr = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aok().aoo()) {
                str = "";
            } else {
                if (!f.bGu().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aok().aoA()) {
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
            if (!d.aok().aos()) {
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
            if (!d.aok().aos()) {
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
        aVar.gAe.setDrawerType(1);
        aVar.gAe.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAe.setDrawBorder(false);
            aVar.gAe.setAutoChangeStyle(true);
            aVar.gAe.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                am.c(aVar.gAe, (int) R.drawable.icon_new_test);
            }
            aVar.gAe.setUserName(String.valueOf(2));
            aVar.gAe.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAe.setIsRound(false);
            aVar.gAe.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAe.setDrawBorder(false);
            aVar.gAe.setAutoChangeStyle(true);
            aVar.gAe.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gAe.setUserName(String.valueOf(3));
            aVar.gAe.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask != null) {
                am.c(aVar.gAe, ((Integer) runTask.getData()).intValue());
            }
            aVar.gAe.setIsRound(false);
            aVar.gAe.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAe.setDrawBorder(true);
            aVar.gAe.setAutoChangeStyle(true);
            aVar.gAe.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gAe.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.gAe.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.gAe.startLoad(friendPortrait, 10, false);
            }
            aVar.gAe.setClickable(false);
            aVar.gAe.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gAe.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAe.setUserName(String.valueOf(1));
            aVar.gAe.setIsRound(false);
            aVar.gAe.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAe.setDrawBorder(false);
            aVar.gAe.setAutoChangeStyle(true);
            aVar.gAe.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gAe.setUserName(String.valueOf(5));
            aVar.gAe.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask2 != null) {
                am.c(aVar.gAe, ((Integer) runTask2.getData()).intValue());
            }
            aVar.gAe.setIsRound(false);
            aVar.gAe.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAe.setDrawBorder(true);
            aVar.gAe.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gAe.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.gAe.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.gAe.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.gAe.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gAe.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAe.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gAe.setIsRound(false);
            aVar.gAe.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAe.setDrawBorder(false);
            aVar.gAe.setAutoChangeStyle(true);
            aVar.gAe.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gAe.setUserName(String.valueOf(7));
            aVar.gAe.setUserId(imMessageCenterShowItemData.getFriendId());
            am.c(aVar.gAe, (int) R.drawable.icon_new_stranger);
            aVar.gAe.setIsRound(false);
            aVar.gAe.invalidate();
        } else {
            aVar.gAe.setDrawBorder(true);
            aVar.gAe.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gAe.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.gAe.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.gAe.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.gAe.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gAe.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAe.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gAe.setIsRound(false);
            aVar.gAe.invalidate();
        }
    }
}
