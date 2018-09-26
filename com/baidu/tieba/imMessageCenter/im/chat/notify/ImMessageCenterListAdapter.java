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
/* loaded from: classes2.dex */
public class ImMessageCenterListAdapter extends c {
    private e eLC;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.eLC = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.eLC.H(true, true);
            } else {
                this.eLC.H(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData os = getItem(i);
        if (os != null && String.valueOf(String.valueOf(2)).equals(os.getOwnerName())) {
            if (os.getUnReadCount() >= 30) {
                if (this.eLC != null) {
                    this.eLC.iD(true);
                }
            } else if (this.eLC != null) {
                this.eLC.iD(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.eLC = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fj()) {
                str = "";
            } else {
                if (!f.aPJ().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fv()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fn()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fn()) {
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
        aVar.etk.setDrawerType(1);
        aVar.etk.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.etk.setDrawBorder(false);
            aVar.etk.setAutoChangeStyle(true);
            aVar.etk.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001287, Integer.class);
            if (runTask != null) {
                al.c(aVar.etk, ((Integer) runTask.getData()).intValue());
            }
            aVar.etk.setUserName(String.valueOf(2));
            aVar.etk.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.etk.setIsRound(false);
            aVar.etk.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.etk.setDrawBorder(false);
            aVar.etk.setAutoChangeStyle(true);
            aVar.etk.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.etk.setUserName(String.valueOf(3));
            aVar.etk.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask2 != null) {
                al.c(aVar.etk, ((Integer) runTask2.getData()).intValue());
            }
            aVar.etk.setIsRound(false);
            aVar.etk.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.etk.setDrawBorder(true);
            aVar.etk.setAutoChangeStyle(true);
            aVar.etk.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.etk.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.etk.startLoad(String.valueOf(e.f.icon_default_avatar100), 24, false);
            } else {
                aVar.etk.startLoad(friendPortrait, 10, false);
            }
            aVar.etk.setClickable(false);
            aVar.etk.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.etk.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.etk.setUserName(String.valueOf(1));
            aVar.etk.setIsRound(false);
            aVar.etk.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.etk.setDrawBorder(false);
            aVar.etk.setAutoChangeStyle(true);
            aVar.etk.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.etk.setUserName(String.valueOf(5));
            aVar.etk.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask3 != null) {
                al.c(aVar.etk, ((Integer) runTask3.getData()).intValue());
            }
            aVar.etk.setIsRound(false);
            aVar.etk.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.etk.setDrawBorder(true);
            aVar.etk.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.etk.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.etk.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    aVar.etk.startLoad(((Integer) runTask4.getData()).toString(), 24, false);
                }
            }
            aVar.etk.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.etk.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.etk.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.etk.setIsRound(false);
            aVar.etk.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.etk.setDrawBorder(false);
            aVar.etk.setAutoChangeStyle(true);
            aVar.etk.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.etk.setUserName(String.valueOf(7));
            aVar.etk.setUserId(imMessageCenterShowItemData.getFriendId());
            al.c(aVar.etk, e.f.icon_new_stranger);
            aVar.etk.setIsRound(false);
            aVar.etk.invalidate();
        } else {
            aVar.etk.setDrawBorder(true);
            aVar.etk.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.etk.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.etk.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.etk.startLoad(String.valueOf(e.f.person_photo), 24, false);
            }
            aVar.etk.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.etk.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.etk.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.etk.setIsRound(false);
            aVar.etk.invalidate();
        }
    }
}
