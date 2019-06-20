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
    private e gMh;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.gMh = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.gMh.Q(true, true);
            } else {
                this.gMh.Q(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData uE = getItem(i);
        if (uE != null && String.valueOf(String.valueOf(2)).equals(uE.getOwnerName())) {
            if (uE.getUnReadCount() >= 30) {
                if (this.gMh != null) {
                    this.gMh.mA(true);
                }
            } else if (this.gMh != null) {
                this.gMh.mA(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.gMh = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.anf().anj()) {
                str = "";
            } else {
                if (!f.bDN().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.anf().anv()) {
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
            if (!d.anf().ann()) {
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
            if (!d.anf().ann()) {
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
        aVar.gtT.setDrawerType(1);
        aVar.gtT.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gtT.setDrawBorder(false);
            aVar.gtT.setAutoChangeStyle(true);
            aVar.gtT.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                al.c(aVar.gtT, (int) R.drawable.icon_new_test);
            }
            aVar.gtT.setUserName(String.valueOf(2));
            aVar.gtT.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gtT.setIsRound(false);
            aVar.gtT.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gtT.setDrawBorder(false);
            aVar.gtT.setAutoChangeStyle(true);
            aVar.gtT.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gtT.setUserName(String.valueOf(3));
            aVar.gtT.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask != null) {
                al.c(aVar.gtT, ((Integer) runTask.getData()).intValue());
            }
            aVar.gtT.setIsRound(false);
            aVar.gtT.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gtT.setDrawBorder(true);
            aVar.gtT.setAutoChangeStyle(true);
            aVar.gtT.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gtT.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.gtT.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.gtT.startLoad(friendPortrait, 10, false);
            }
            aVar.gtT.setClickable(false);
            aVar.gtT.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gtT.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gtT.setUserName(String.valueOf(1));
            aVar.gtT.setIsRound(false);
            aVar.gtT.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gtT.setDrawBorder(false);
            aVar.gtT.setAutoChangeStyle(true);
            aVar.gtT.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gtT.setUserName(String.valueOf(5));
            aVar.gtT.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask2 != null) {
                al.c(aVar.gtT, ((Integer) runTask2.getData()).intValue());
            }
            aVar.gtT.setIsRound(false);
            aVar.gtT.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gtT.setDrawBorder(true);
            aVar.gtT.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gtT.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.gtT.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.gtT.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.gtT.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gtT.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gtT.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gtT.setIsRound(false);
            aVar.gtT.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gtT.setDrawBorder(false);
            aVar.gtT.setAutoChangeStyle(true);
            aVar.gtT.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gtT.setUserName(String.valueOf(7));
            aVar.gtT.setUserId(imMessageCenterShowItemData.getFriendId());
            al.c(aVar.gtT, (int) R.drawable.icon_new_stranger);
            aVar.gtT.setIsRound(false);
            aVar.gtT.invalidate();
        } else {
            aVar.gtT.setDrawBorder(true);
            aVar.gtT.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gtT.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.gtT.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.gtT.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.gtT.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gtT.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gtT.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gtT.setIsRound(false);
            aVar.gtT.invalidate();
        }
    }
}
