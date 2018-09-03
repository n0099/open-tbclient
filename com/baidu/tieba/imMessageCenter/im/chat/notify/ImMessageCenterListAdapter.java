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
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.a.c;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.f;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class ImMessageCenterListAdapter extends c {
    private e eEm;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.eEm = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.eEm.F(true, true);
            } else {
                this.eEm.F(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData nO = getItem(i);
        if (nO != null && String.valueOf(String.valueOf(2)).equals(nO.getOwnerName())) {
            if (nO.getUnReadCount() >= 30) {
                if (this.eEm != null) {
                    this.eEm.m16if(true);
                }
            } else if (this.eEm != null) {
                this.eEm.m16if(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.eEm = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().DW()) {
                str = "";
            } else {
                if (!f.aNu().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().Eh()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ea()) {
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
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ea()) {
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
        aVar.elP.setDrawerType(1);
        aVar.elP.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.elP.setDrawBorder(false);
            aVar.elP.setAutoChangeStyle(true);
            aVar.elP.setTag(imMessageCenterShowItemData.getOwnerName());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001287, Integer.class);
            if (runTask != null) {
                am.c(aVar.elP, ((Integer) runTask.getData()).intValue());
            }
            aVar.elP.setUserName(String.valueOf(2));
            aVar.elP.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.elP.setIsRound(false);
            aVar.elP.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.elP.setDrawBorder(false);
            aVar.elP.setAutoChangeStyle(true);
            aVar.elP.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.elP.setUserName(String.valueOf(3));
            aVar.elP.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask2 != null) {
                am.c(aVar.elP, ((Integer) runTask2.getData()).intValue());
            }
            aVar.elP.setIsRound(false);
            aVar.elP.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.elP.setDrawBorder(true);
            aVar.elP.setAutoChangeStyle(true);
            aVar.elP.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.elP.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.elP.startLoad(String.valueOf(f.C0146f.icon_default_avatar100), 24, false);
            } else {
                aVar.elP.startLoad(friendPortrait, 10, false);
            }
            aVar.elP.setClickable(false);
            aVar.elP.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.elP.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.elP.setUserName(String.valueOf(1));
            aVar.elP.setIsRound(false);
            aVar.elP.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.elP.setDrawBorder(false);
            aVar.elP.setAutoChangeStyle(true);
            aVar.elP.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.elP.setUserName(String.valueOf(5));
            aVar.elP.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001289, Integer.class);
            if (runTask3 != null) {
                am.c(aVar.elP, ((Integer) runTask3.getData()).intValue());
            }
            aVar.elP.setIsRound(false);
            aVar.elP.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.elP.setDrawBorder(true);
            aVar.elP.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.elP.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.elP.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask4 != null && runTask4.getData() != null) {
                    aVar.elP.startLoad(((Integer) runTask4.getData()).toString(), 24, false);
                }
            }
            aVar.elP.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.elP.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.elP.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.elP.setIsRound(false);
            aVar.elP.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.elP.setDrawBorder(false);
            aVar.elP.setAutoChangeStyle(true);
            aVar.elP.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.elP.setUserName(String.valueOf(7));
            aVar.elP.setUserId(imMessageCenterShowItemData.getFriendId());
            am.c(aVar.elP, f.C0146f.icon_new_stranger);
            aVar.elP.setIsRound(false);
            aVar.elP.invalidate();
        } else {
            aVar.elP.setDrawBorder(true);
            aVar.elP.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.elP.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.elP.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.elP.startLoad(String.valueOf(f.C0146f.person_photo), 24, false);
            }
            aVar.elP.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.elP.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.elP.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.elP.setIsRound(false);
            aVar.elP.invalidate();
        }
    }
}
