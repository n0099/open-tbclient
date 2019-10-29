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
/* loaded from: classes4.dex */
public class ImMessageCenterListAdapter extends c {
    private e gTc;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.gTc = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.gTc.V(true, true);
            } else {
                this.gTc.V(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData tQ = getItem(i);
        if (tQ != null && String.valueOf(String.valueOf(2)).equals(tQ.getOwnerName())) {
            if (tQ.getUnReadCount() >= 30) {
                if (this.gTc != null) {
                    this.gTc.mF(true);
                }
            } else if (this.gTc != null) {
                this.gTc.mF(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.gTc = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.ara().are()) {
                str = "";
            } else {
                if (!f.bEh().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.ara().arq()) {
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
            if (!d.ara().ari()) {
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
            if (!d.ara().ari()) {
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
        aVar.gAM.setDrawerType(1);
        aVar.gAM.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAM.setDrawBorder(false);
            aVar.gAM.setAutoChangeStyle(true);
            aVar.gAM.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                am.setImageResource(aVar.gAM, R.drawable.icon_new_test);
            }
            aVar.gAM.setUserName(String.valueOf(2));
            aVar.gAM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAM.setIsRound(false);
            aVar.gAM.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAM.setDrawBorder(false);
            aVar.gAM.setAutoChangeStyle(true);
            aVar.gAM.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gAM.setUserName(String.valueOf(3));
            aVar.gAM.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                am.setImageResource(aVar.gAM, ((Integer) runTask.getData()).intValue());
            }
            aVar.gAM.setIsRound(false);
            aVar.gAM.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAM.setDrawBorder(true);
            aVar.gAM.setAutoChangeStyle(true);
            aVar.gAM.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gAM.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.gAM.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.gAM.startLoad(friendPortrait, 10, false);
            }
            aVar.gAM.setClickable(false);
            aVar.gAM.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gAM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAM.setUserName(String.valueOf(1));
            aVar.gAM.setIsRound(false);
            aVar.gAM.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAM.setDrawBorder(false);
            aVar.gAM.setAutoChangeStyle(true);
            aVar.gAM.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gAM.setUserName(String.valueOf(5));
            aVar.gAM.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask2 != null) {
                am.setImageResource(aVar.gAM, ((Integer) runTask2.getData()).intValue());
            }
            aVar.gAM.setIsRound(false);
            aVar.gAM.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAM.setDrawBorder(true);
            aVar.gAM.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gAM.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.gAM.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.gAM.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.gAM.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gAM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAM.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gAM.setIsRound(false);
            aVar.gAM.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gAM.setDrawBorder(false);
            aVar.gAM.setAutoChangeStyle(true);
            aVar.gAM.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gAM.setUserName(String.valueOf(7));
            aVar.gAM.setUserId(imMessageCenterShowItemData.getFriendId());
            am.setImageResource(aVar.gAM, R.drawable.icon_new_stranger);
            aVar.gAM.setIsRound(false);
            aVar.gAM.invalidate();
        } else {
            aVar.gAM.setDrawBorder(true);
            aVar.gAM.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gAM.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.gAM.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.gAM.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.gAM.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gAM.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gAM.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gAM.setIsRound(false);
            aVar.gAM.invalidate();
        }
    }
}
