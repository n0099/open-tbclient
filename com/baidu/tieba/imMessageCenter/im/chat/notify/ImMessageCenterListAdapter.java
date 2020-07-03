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
import com.baidu.tbadk.core.util.an;
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
    private e jdV;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.jdV = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.jdV.aa(true, true);
            } else {
                this.jdV.aa(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData ya = getItem(i);
        if (ya != null && String.valueOf(String.valueOf(2)).equals(ya.getOwnerName())) {
            if (ya.getUnReadCount() >= 30) {
                if (this.jdV != null) {
                    this.jdV.pW(true);
                }
            } else if (this.jdV != null) {
                this.jdV.pW(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.jdV = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bbV().bbZ()) {
                str = "";
            } else {
                if (!f.ctr().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bbV().bcl()) {
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
            if (!d.bbV().bcd()) {
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
            if (!d.bbV().bcd()) {
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
        aVar.iLM.setDrawerType(1);
        aVar.iLM.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.iLM.setDrawBorder(false);
            aVar.iLM.setAutoChangeStyle(true);
            aVar.iLM.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                an.setImageResource(aVar.iLM, R.drawable.icon_new_test);
            }
            aVar.iLM.setUserName(String.valueOf(2));
            aVar.iLM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.iLM.setIsRound(false);
            aVar.iLM.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.iLM.setDrawBorder(false);
            aVar.iLM.setAutoChangeStyle(true);
            aVar.iLM.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.iLM.setUserName(String.valueOf(3));
            aVar.iLM.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                an.setImageResource(aVar.iLM, ((Integer) runTask.getData()).intValue());
            }
            aVar.iLM.setIsRound(false);
            aVar.iLM.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.iLM.setDrawBorder(true);
            aVar.iLM.setAutoChangeStyle(true);
            aVar.iLM.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.iLM.setImageDrawable(null);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.iLM.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.iLM.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.iLM.setClickable(false);
            aVar.iLM.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.iLM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.iLM.setUserName(String.valueOf(1));
            aVar.iLM.setIsRound(false);
            aVar.iLM.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.iLM.setDrawBorder(false);
            aVar.iLM.setAutoChangeStyle(true);
            aVar.iLM.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.iLM.setUserName(String.valueOf(5));
            aVar.iLM.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask2 != null) {
                an.setImageResource(aVar.iLM, ((Integer) runTask2.getData()).intValue());
            }
            aVar.iLM.setIsRound(false);
            aVar.iLM.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.iLM.setDrawBorder(true);
            aVar.iLM.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.iLM.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.iLM.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.iLM.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.iLM.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.iLM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.iLM.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.iLM.setIsRound(false);
            aVar.iLM.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.iLM.setDrawBorder(false);
            aVar.iLM.setAutoChangeStyle(true);
            aVar.iLM.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.iLM.setUserName(String.valueOf(7));
            aVar.iLM.setUserId(imMessageCenterShowItemData.getFriendId());
            an.setImageResource(aVar.iLM, R.drawable.icon_new_stranger);
            aVar.iLM.setIsRound(false);
            aVar.iLM.invalidate();
        } else {
            aVar.iLM.setDrawBorder(true);
            aVar.iLM.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.iLM.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.iLM.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.iLM.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.iLM.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.iLM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.iLM.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.iLM.setIsRound(false);
            aVar.iLM.invalidate();
        }
    }
}
