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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.a.c;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.f;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes22.dex */
public class ImMessageCenterListAdapter extends c {
    private e jYW;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.jYW = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.jYW.ag(true, true);
            } else {
                this.jYW.ag(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData BT = getItem(i);
        if (BT != null && String.valueOf(2).equals(BT.getOwnerName())) {
            if (BT.getUnReadCount() >= 30) {
                if (this.jYW != null) {
                    this.jYW.sa(true);
                }
            } else if (this.jYW != null) {
                this.jYW.sa(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.jYW = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bsc().bsg()) {
                str = "";
            } else {
                if (!f.cPA().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bsc().bss()) {
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
            if (!d.bsc().bsk()) {
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
            if (!d.bsc().bsk()) {
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
        aVar.jEz.setDrawerType(1);
        aVar.jEz.setRadius(l.dip2px(this.mContext, 4.0f));
        aVar.jEA.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jEz.setDrawBorder(false);
            aVar.jEz.setAutoChangeStyle(true);
            aVar.jEz.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jEz.setVisibility(0);
            aVar.jEA.setVisibility(8);
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                ap.setImageResource(aVar.jEz, R.drawable.icon_new_test);
            }
            aVar.jEz.setUserName(String.valueOf(2));
            aVar.jEz.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jEz.setIsRound(false);
            aVar.jEz.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jEz.setDrawBorder(false);
            aVar.jEz.setAutoChangeStyle(true);
            aVar.jEz.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jEz.setUserName(String.valueOf(3));
            aVar.jEz.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jEz.setVisibility(0);
            aVar.jEA.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                ap.setImageResource(aVar.jEz, ((Integer) runTask.getData()).intValue());
            }
            aVar.jEz.setIsRound(false);
            aVar.jEz.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jEz.setDrawBorder(true);
            aVar.jEz.setAutoChangeStyle(true);
            aVar.jEz.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jEz.setImageDrawable(null);
            aVar.jEz.setVisibility(0);
            aVar.jEA.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.jEz.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.jEz.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.jEz.setClickable(false);
            aVar.jEz.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jEz.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jEz.setUserName(String.valueOf(1));
            aVar.jEz.setIsRound(false);
            aVar.jEz.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jEz.setDrawBorder(false);
            aVar.jEz.setAutoChangeStyle(true);
            aVar.jEz.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jEz.setUserName(String.valueOf(5));
            aVar.jEz.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jEz.setVisibility(4);
            aVar.jEA.setVisibility(0);
            SvgManager.bmU().a(aVar.jEA, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.jEz.setIsRound(false);
            aVar.jEz.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jEz.setDrawBorder(true);
            aVar.jEz.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jEz.setVisibility(0);
            aVar.jEA.setVisibility(8);
            aVar.jEz.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.jEz.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.jEz.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                }
            }
            aVar.jEz.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jEz.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jEz.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.jEz.setIsRound(false);
            aVar.jEz.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jEz.setDrawBorder(false);
            aVar.jEz.setAutoChangeStyle(true);
            aVar.jEz.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jEz.setUserName(String.valueOf(7));
            aVar.jEz.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jEz.setVisibility(4);
            aVar.jEA.setVisibility(0);
            SvgManager.bmU().a(aVar.jEA, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.jEz.setIsRound(false);
            aVar.jEz.invalidate();
        } else {
            aVar.jEz.setDrawBorder(true);
            aVar.jEz.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jEz.setImageDrawable(null);
            aVar.jEz.setVisibility(0);
            aVar.jEA.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.jEz.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.jEz.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.jEz.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jEz.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jEz.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.jEz.setIsRound(false);
            aVar.jEz.invalidate();
        }
    }
}
