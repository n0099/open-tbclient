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
    private e gVc;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.gVc = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.gVc.T(true, true);
            } else {
                this.gVc.T(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData vl = getItem(i);
        if (vl != null && String.valueOf(String.valueOf(2)).equals(vl.getOwnerName())) {
            if (vl.getUnReadCount() >= 30) {
                if (this.gVc != null) {
                    this.gVc.mR(true);
                }
            } else if (this.gVc != null) {
                this.gVc.mR(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.gVc = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aoy().aoC()) {
                str = "";
            } else {
                if (!f.bHw().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aoy().aoO()) {
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
            if (!d.aoy().aoG()) {
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
            if (!d.aoy().aoG()) {
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
        aVar.gCN.setDrawerType(1);
        aVar.gCN.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gCN.setDrawBorder(false);
            aVar.gCN.setAutoChangeStyle(true);
            aVar.gCN.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                am.c(aVar.gCN, (int) R.drawable.icon_new_test);
            }
            aVar.gCN.setUserName(String.valueOf(2));
            aVar.gCN.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gCN.setIsRound(false);
            aVar.gCN.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gCN.setDrawBorder(false);
            aVar.gCN.setAutoChangeStyle(true);
            aVar.gCN.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gCN.setUserName(String.valueOf(3));
            aVar.gCN.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask != null) {
                am.c(aVar.gCN, ((Integer) runTask.getData()).intValue());
            }
            aVar.gCN.setIsRound(false);
            aVar.gCN.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gCN.setDrawBorder(true);
            aVar.gCN.setAutoChangeStyle(true);
            aVar.gCN.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gCN.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.gCN.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.gCN.startLoad(friendPortrait, 10, false);
            }
            aVar.gCN.setClickable(false);
            aVar.gCN.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gCN.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gCN.setUserName(String.valueOf(1));
            aVar.gCN.setIsRound(false);
            aVar.gCN.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gCN.setDrawBorder(false);
            aVar.gCN.setAutoChangeStyle(true);
            aVar.gCN.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gCN.setUserName(String.valueOf(5));
            aVar.gCN.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask2 != null) {
                am.c(aVar.gCN, ((Integer) runTask2.getData()).intValue());
            }
            aVar.gCN.setIsRound(false);
            aVar.gCN.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gCN.setDrawBorder(true);
            aVar.gCN.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gCN.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.gCN.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.gCN.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.gCN.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gCN.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gCN.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gCN.setIsRound(false);
            aVar.gCN.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gCN.setDrawBorder(false);
            aVar.gCN.setAutoChangeStyle(true);
            aVar.gCN.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gCN.setUserName(String.valueOf(7));
            aVar.gCN.setUserId(imMessageCenterShowItemData.getFriendId());
            am.c(aVar.gCN, (int) R.drawable.icon_new_stranger);
            aVar.gCN.setIsRound(false);
            aVar.gCN.invalidate();
        } else {
            aVar.gCN.setDrawBorder(true);
            aVar.gCN.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gCN.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.gCN.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.gCN.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.gCN.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gCN.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gCN.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gCN.setIsRound(false);
            aVar.gCN.invalidate();
        }
    }
}
