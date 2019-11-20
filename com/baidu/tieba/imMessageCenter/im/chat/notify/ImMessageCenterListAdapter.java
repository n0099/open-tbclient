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
    private e gSl;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.gSl = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.gSl.V(true, true);
            } else {
                this.gSl.V(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData tP = getItem(i);
        if (tP != null && String.valueOf(String.valueOf(2)).equals(tP.getOwnerName())) {
            if (tP.getUnReadCount() >= 30) {
                if (this.gSl != null) {
                    this.gSl.mF(true);
                }
            } else if (this.gSl != null) {
                this.gSl.mF(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.gSl = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aqY().arc()) {
                str = "";
            } else {
                if (!f.bEf().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.aqY().aro()) {
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
            if (!d.aqY().arg()) {
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
            if (!d.aqY().arg()) {
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
        aVar.gzV.setDrawerType(1);
        aVar.gzV.setRadius(l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gzV.setDrawBorder(false);
            aVar.gzV.setAutoChangeStyle(true);
            aVar.gzV.setTag(imMessageCenterShowItemData.getOwnerName());
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                am.setImageResource(aVar.gzV, R.drawable.icon_new_test);
            }
            aVar.gzV.setUserName(String.valueOf(2));
            aVar.gzV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gzV.setIsRound(false);
            aVar.gzV.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gzV.setDrawBorder(false);
            aVar.gzV.setAutoChangeStyle(true);
            aVar.gzV.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gzV.setUserName(String.valueOf(3));
            aVar.gzV.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                am.setImageResource(aVar.gzV, ((Integer) runTask.getData()).intValue());
            }
            aVar.gzV.setIsRound(false);
            aVar.gzV.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gzV.setDrawBorder(true);
            aVar.gzV.setAutoChangeStyle(true);
            aVar.gzV.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gzV.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                aVar.gzV.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.gzV.startLoad(friendPortrait, 10, false);
            }
            aVar.gzV.setClickable(false);
            aVar.gzV.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gzV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gzV.setUserName(String.valueOf(1));
            aVar.gzV.setIsRound(false);
            aVar.gzV.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gzV.setDrawBorder(false);
            aVar.gzV.setAutoChangeStyle(true);
            aVar.gzV.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gzV.setUserName(String.valueOf(5));
            aVar.gzV.setUserId(imMessageCenterShowItemData.getFriendId());
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
            if (runTask2 != null) {
                am.setImageResource(aVar.gzV, ((Integer) runTask2.getData()).intValue());
            }
            aVar.gzV.setIsRound(false);
            aVar.gzV.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gzV.setDrawBorder(true);
            aVar.gzV.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gzV.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                aVar.gzV.startLoad(friendPortrait2, 12, false);
            } else {
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    aVar.gzV.startLoad(((Integer) runTask3.getData()).toString(), 24, false);
                }
            }
            aVar.gzV.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gzV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gzV.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gzV.setIsRound(false);
            aVar.gzV.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.gzV.setDrawBorder(false);
            aVar.gzV.setAutoChangeStyle(true);
            aVar.gzV.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.gzV.setUserName(String.valueOf(7));
            aVar.gzV.setUserId(imMessageCenterShowItemData.getFriendId());
            am.setImageResource(aVar.gzV, R.drawable.icon_new_stranger);
            aVar.gzV.setIsRound(false);
            aVar.gzV.invalidate();
        } else {
            aVar.gzV.setDrawBorder(true);
            aVar.gzV.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            aVar.gzV.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                aVar.gzV.startLoad(friendPortrait3, 12, false);
            } else {
                aVar.gzV.startLoad(String.valueOf((int) R.drawable.person_photo), 24, false);
            }
            aVar.gzV.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.gzV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.gzV.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.gzV.setIsRound(false);
            aVar.gzV.invalidate();
        }
    }
}
