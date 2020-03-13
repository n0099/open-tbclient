package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes9.dex */
public class ImMessageCenterListAdapter extends c {
    private e hMd;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.hMd = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.hMd.W(true, true);
            } else {
                this.hMd.W(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData wc = getItem(i);
        if (wc != null && String.valueOf(String.valueOf(2)).equals(wc.getOwnerName())) {
            if (wc.getUnReadCount() >= 30) {
                if (this.hMd != null) {
                    this.hMd.og(true);
                }
            } else if (this.hMd != null) {
                this.hMd.og(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.hMd = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aLm().aLq()) {
                str = "";
            } else {
                if (!f.bYe().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aLm().aLC()) {
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
            if (!d.aLm().aLu()) {
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
            if (!d.aLm().aLu()) {
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
        aVar.htR.setDrawerType(1);
        aVar.htR.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.htR.setDrawBorder(false);
            aVar.htR.setAutoChangeStyle(true);
            aVar.htR.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                am.setImageResource(aVar.htR, R.drawable.icon_new_test);
            }
            aVar.htR.setUserName(String.valueOf(2));
            aVar.htR.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.htR.setIsRound(false);
            aVar.htR.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.htR.setDrawBorder(false);
            aVar.htR.setAutoChangeStyle(true);
            aVar.htR.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.htR.setUserName(String.valueOf(3));
            aVar.htR.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                am.setImageResource(aVar.htR, ((Integer) runTask.getData()).intValue());
            }
            aVar.htR.setIsRound(false);
            aVar.htR.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.htR.setDrawBorder(true);
            aVar.htR.setAutoChangeStyle(true);
            aVar.htR.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.htR.setImageDrawable(null);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.htR.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.htR.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.htR.setClickable(false);
            aVar.htR.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.htR.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.htR.setUserName(String.valueOf(1));
            aVar.htR.setIsRound(false);
            aVar.htR.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.htR.setDrawBorder(false);
            aVar.htR.setAutoChangeStyle(true);
            aVar.htR.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.htR.setUserName(String.valueOf(5));
            aVar.htR.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask2 != null) {
                am.setImageResource(aVar.htR, ((Integer) runTask2.getData()).intValue());
            }
            aVar.htR.setIsRound(false);
            aVar.htR.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.htR.setDrawBorder(true);
            aVar.htR.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.htR.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.htR.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.htR.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.htR.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.htR.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.htR.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.htR.setIsRound(false);
            aVar.htR.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.htR.setDrawBorder(false);
            aVar.htR.setAutoChangeStyle(true);
            aVar.htR.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.htR.setUserName(String.valueOf(7));
            aVar.htR.setUserId(imMessageCenterShowItemData.getFriendId());
            am.setImageResource(aVar.htR, R.drawable.icon_new_stranger);
            aVar.htR.setIsRound(false);
            aVar.htR.invalidate();
        } else {
            aVar.htR.setDrawBorder(true);
            aVar.htR.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.htR.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.htR.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.htR.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.htR.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.htR.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.htR.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.htR.setIsRound(false);
            aVar.htR.invalidate();
        }
    }
}
