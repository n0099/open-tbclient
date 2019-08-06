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
    private e gTj;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.gTj = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.gTj.T(true, true);
            } else {
                this.gTj.T(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData vh = getItem(i);
        if (vh != null && String.valueOf(String.valueOf(2)).equals(vh.getOwnerName())) {
            if (vh.getUnReadCount() >= 30) {
                if (this.gTj != null) {
                    this.gTj.mO(true);
                }
            } else if (this.gTj != null) {
                this.gTj.mO(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.gTj = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aom().aoq()) {
                str = "";
            } else {
                if (!f.bGI().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aom().aoC()) {
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
            if (!d.aom().aou()) {
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
            if (!d.aom().aou()) {
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
        aVar.gAW.setDrawerType(1);
        aVar.gAW.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAW.setDrawBorder(false);
            aVar.gAW.setAutoChangeStyle(true);
            aVar.gAW.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                am.c(aVar.gAW, (int) R.drawable.icon_new_test);
            }
            aVar.gAW.setUserName(String.valueOf(2));
            aVar.gAW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAW.setIsRound(false);
            aVar.gAW.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAW.setDrawBorder(false);
            aVar.gAW.setAutoChangeStyle(true);
            aVar.gAW.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gAW.setUserName(String.valueOf(3));
            aVar.gAW.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask != null) {
                am.c(aVar.gAW, ((Integer) runTask.getData()).intValue());
            }
            aVar.gAW.setIsRound(false);
            aVar.gAW.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAW.setDrawBorder(true);
            aVar.gAW.setAutoChangeStyle(true);
            aVar.gAW.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gAW.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.gAW.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.gAW.startLoad(friendPortrait, 10, false);
            }
            aVar.gAW.setClickable(false);
            aVar.gAW.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gAW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAW.setUserName(String.valueOf(1));
            aVar.gAW.setIsRound(false);
            aVar.gAW.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAW.setDrawBorder(false);
            aVar.gAW.setAutoChangeStyle(true);
            aVar.gAW.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gAW.setUserName(String.valueOf(5));
            aVar.gAW.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask2 != null) {
                am.c(aVar.gAW, ((Integer) runTask2.getData()).intValue());
            }
            aVar.gAW.setIsRound(false);
            aVar.gAW.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAW.setDrawBorder(true);
            aVar.gAW.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gAW.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.gAW.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.gAW.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.gAW.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gAW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAW.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gAW.setIsRound(false);
            aVar.gAW.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAW.setDrawBorder(false);
            aVar.gAW.setAutoChangeStyle(true);
            aVar.gAW.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gAW.setUserName(String.valueOf(7));
            aVar.gAW.setUserId(imMessageCenterShowItemData.getFriendId());
            am.c(aVar.gAW, (int) R.drawable.icon_new_stranger);
            aVar.gAW.setIsRound(false);
            aVar.gAW.invalidate();
        } else {
            aVar.gAW.setDrawBorder(true);
            aVar.gAW.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gAW.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.gAW.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.gAW.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.gAW.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gAW.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAW.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gAW.setIsRound(false);
            aVar.gAW.invalidate();
        }
    }
}
