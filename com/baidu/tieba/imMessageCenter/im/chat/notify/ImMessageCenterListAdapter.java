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
    private e ixu;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.ixu = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.ixu.W(true, true);
            } else {
                this.ixu.W(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData wI = getItem(i);
        if (wI != null && String.valueOf(String.valueOf(2)).equals(wI.getOwnerName())) {
            if (wI.getUnReadCount() >= 30) {
                if (this.ixu != null) {
                    this.ixu.pq(true);
                }
            } else if (this.ixu != null) {
                this.ixu.pq(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.ixu = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aTN().aTR()) {
                str = "";
            } else {
                if (!f.ciX().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aTN().aUd()) {
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
            if (!d.aTN().aTV()) {
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
            if (!d.aTN().aTV()) {
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
        aVar.ife.setDrawerType(1);
        aVar.ife.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ife.setDrawBorder(false);
            aVar.ife.setAutoChangeStyle(true);
            aVar.ife.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                am.setImageResource(aVar.ife, R.drawable.icon_new_test);
            }
            aVar.ife.setUserName(String.valueOf(2));
            aVar.ife.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ife.setIsRound(false);
            aVar.ife.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ife.setDrawBorder(false);
            aVar.ife.setAutoChangeStyle(true);
            aVar.ife.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.ife.setUserName(String.valueOf(3));
            aVar.ife.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                am.setImageResource(aVar.ife, ((Integer) runTask.getData()).intValue());
            }
            aVar.ife.setIsRound(false);
            aVar.ife.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ife.setDrawBorder(true);
            aVar.ife.setAutoChangeStyle(true);
            aVar.ife.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.ife.setImageDrawable(null);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.ife.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.ife.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.ife.setClickable(false);
            aVar.ife.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.ife.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ife.setUserName(String.valueOf(1));
            aVar.ife.setIsRound(false);
            aVar.ife.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ife.setDrawBorder(false);
            aVar.ife.setAutoChangeStyle(true);
            aVar.ife.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.ife.setUserName(String.valueOf(5));
            aVar.ife.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask2 != null) {
                am.setImageResource(aVar.ife, ((Integer) runTask2.getData()).intValue());
            }
            aVar.ife.setIsRound(false);
            aVar.ife.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ife.setDrawBorder(true);
            aVar.ife.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.ife.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.ife.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.ife.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.ife.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.ife.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ife.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.ife.setIsRound(false);
            aVar.ife.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ife.setDrawBorder(false);
            aVar.ife.setAutoChangeStyle(true);
            aVar.ife.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.ife.setUserName(String.valueOf(7));
            aVar.ife.setUserId(imMessageCenterShowItemData.getFriendId());
            am.setImageResource(aVar.ife, R.drawable.icon_new_stranger);
            aVar.ife.setIsRound(false);
            aVar.ife.invalidate();
        } else {
            aVar.ife.setDrawBorder(true);
            aVar.ife.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.ife.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.ife.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.ife.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.ife.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.ife.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ife.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.ife.setIsRound(false);
            aVar.ife.invalidate();
        }
    }
}
