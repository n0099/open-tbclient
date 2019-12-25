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
/* loaded from: classes6.dex */
public class ImMessageCenterListAdapter extends c {
    private e hGo;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.hGo = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.hGo.U(true, true);
            } else {
                this.hGo.U(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData vR = getItem(i);
        if (vR != null && String.valueOf(String.valueOf(2)).equals(vR.getOwnerName())) {
            if (vR.getUnReadCount() >= 30) {
                if (this.hGo != null) {
                    this.hGo.nS(true);
                }
            } else if (this.hGo != null) {
                this.hGo.nS(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.hGo = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aIw().aIA()) {
                str = "";
            } else {
                if (!f.bVr().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aIw().aIM()) {
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
            if (!d.aIw().aIE()) {
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
            if (!d.aIw().aIE()) {
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
        aVar.hob.setDrawerType(1);
        aVar.hob.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hob.setDrawBorder(false);
            aVar.hob.setAutoChangeStyle(true);
            aVar.hob.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                am.setImageResource(aVar.hob, R.drawable.icon_new_test);
            }
            aVar.hob.setUserName(String.valueOf(2));
            aVar.hob.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.hob.setIsRound(false);
            aVar.hob.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hob.setDrawBorder(false);
            aVar.hob.setAutoChangeStyle(true);
            aVar.hob.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.hob.setUserName(String.valueOf(3));
            aVar.hob.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                am.setImageResource(aVar.hob, ((Integer) runTask.getData()).intValue());
            }
            aVar.hob.setIsRound(false);
            aVar.hob.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hob.setDrawBorder(true);
            aVar.hob.setAutoChangeStyle(true);
            aVar.hob.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.hob.setImageDrawable(null);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.hob.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.hob.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.hob.setClickable(false);
            aVar.hob.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.hob.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.hob.setUserName(String.valueOf(1));
            aVar.hob.setIsRound(false);
            aVar.hob.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hob.setDrawBorder(false);
            aVar.hob.setAutoChangeStyle(true);
            aVar.hob.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.hob.setUserName(String.valueOf(5));
            aVar.hob.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask2 != null) {
                am.setImageResource(aVar.hob, ((Integer) runTask2.getData()).intValue());
            }
            aVar.hob.setIsRound(false);
            aVar.hob.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hob.setDrawBorder(true);
            aVar.hob.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.hob.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.hob.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.hob.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.hob.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.hob.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.hob.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.hob.setIsRound(false);
            aVar.hob.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.hob.setDrawBorder(false);
            aVar.hob.setAutoChangeStyle(true);
            aVar.hob.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.hob.setUserName(String.valueOf(7));
            aVar.hob.setUserId(imMessageCenterShowItemData.getFriendId());
            am.setImageResource(aVar.hob, R.drawable.icon_new_stranger);
            aVar.hob.setIsRound(false);
            aVar.hob.invalidate();
        } else {
            aVar.hob.setDrawBorder(true);
            aVar.hob.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.hob.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.hob.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.hob.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.hob.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.hob.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.hob.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.hob.setIsRound(false);
            aVar.hob.invalidate();
        }
    }
}
