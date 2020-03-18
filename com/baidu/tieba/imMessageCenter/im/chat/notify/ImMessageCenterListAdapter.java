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
    private e hND;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.hND = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.hND.W(true, true);
            } else {
                this.hND.W(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData wk = getItem(i);
        if (wk != null && String.valueOf(String.valueOf(2)).equals(wk.getOwnerName())) {
            if (wk.getUnReadCount() >= 30) {
                if (this.hND != null) {
                    this.hND.om(true);
                }
            } else if (this.hND != null) {
                this.hND.om(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.hND = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aLq().aLu()) {
                str = "";
            } else {
                if (!f.bYw().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aLq().aLG()) {
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
            if (!d.aLq().aLy()) {
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
            if (!d.aLq().aLy()) {
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
        aVar.hvr.setDrawerType(1);
        aVar.hvr.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hvr.setDrawBorder(false);
            aVar.hvr.setAutoChangeStyle(true);
            aVar.hvr.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                am.setImageResource(aVar.hvr, R.drawable.icon_new_test);
            }
            aVar.hvr.setUserName(String.valueOf(2));
            aVar.hvr.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.hvr.setIsRound(false);
            aVar.hvr.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hvr.setDrawBorder(false);
            aVar.hvr.setAutoChangeStyle(true);
            aVar.hvr.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.hvr.setUserName(String.valueOf(3));
            aVar.hvr.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                am.setImageResource(aVar.hvr, ((Integer) runTask.getData()).intValue());
            }
            aVar.hvr.setIsRound(false);
            aVar.hvr.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hvr.setDrawBorder(true);
            aVar.hvr.setAutoChangeStyle(true);
            aVar.hvr.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.hvr.setImageDrawable(null);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.hvr.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.hvr.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.hvr.setClickable(false);
            aVar.hvr.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.hvr.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.hvr.setUserName(String.valueOf(1));
            aVar.hvr.setIsRound(false);
            aVar.hvr.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hvr.setDrawBorder(false);
            aVar.hvr.setAutoChangeStyle(true);
            aVar.hvr.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.hvr.setUserName(String.valueOf(5));
            aVar.hvr.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask2 != null) {
                am.setImageResource(aVar.hvr, ((Integer) runTask2.getData()).intValue());
            }
            aVar.hvr.setIsRound(false);
            aVar.hvr.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hvr.setDrawBorder(true);
            aVar.hvr.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.hvr.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.hvr.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.hvr.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.hvr.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.hvr.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.hvr.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.hvr.setIsRound(false);
            aVar.hvr.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hvr.setDrawBorder(false);
            aVar.hvr.setAutoChangeStyle(true);
            aVar.hvr.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.hvr.setUserName(String.valueOf(7));
            aVar.hvr.setUserId(imMessageCenterShowItemData.getFriendId());
            am.setImageResource(aVar.hvr, R.drawable.icon_new_stranger);
            aVar.hvr.setIsRound(false);
            aVar.hvr.invalidate();
        } else {
            aVar.hvr.setDrawBorder(true);
            aVar.hvr.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.hvr.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.hvr.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.hvr.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.hvr.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.hvr.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.hvr.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.hvr.setIsRound(false);
            aVar.hvr.invalidate();
        }
    }
}
