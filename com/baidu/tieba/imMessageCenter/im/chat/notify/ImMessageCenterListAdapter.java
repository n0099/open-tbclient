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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.a.c;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.im.settingcache.f;
import com.baidu.tieba.imMessageCenter.mention.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class ImMessageCenterListAdapter extends c {
    private e kKJ;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.kKJ = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.kKJ.al(true, true);
            } else {
                this.kKJ.al(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData DY = getItem(i);
        if (DY != null && String.valueOf(2).equals(DY.getOwnerName())) {
            if (DY.getUnReadCount() >= 30) {
                if (this.kKJ != null) {
                    this.kKJ.th(true);
                }
            } else if (this.kKJ != null) {
                this.kKJ.th(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.kKJ = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bBG().bBK()) {
                str = "";
            } else {
                if (!f.cZP().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bBG().bBW()) {
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
            if (!d.bBG().bBO()) {
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
            if (!d.bBG().bBO()) {
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
        aVar.kxS.setDrawerType(1);
        aVar.kxS.setRadius(l.dip2px(this.mContext, 4.0f));
        aVar.kxT.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kxS.setDrawBorder(false);
            aVar.kxS.setAutoChangeStyle(true);
            aVar.kxS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.kxS.setVisibility(0);
            aVar.kxT.setVisibility(8);
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                ao.setImageResource(aVar.kxS, R.drawable.icon_new_test);
            }
            aVar.kxS.setUserName(String.valueOf(2));
            aVar.kxS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kxS.setIsRound(false);
            aVar.kxS.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kxS.setDrawBorder(false);
            aVar.kxS.setAutoChangeStyle(true);
            aVar.kxS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.kxS.setUserName(String.valueOf(3));
            aVar.kxS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kxS.setVisibility(0);
            aVar.kxT.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                ao.setImageResource(aVar.kxS, ((Integer) runTask.getData()).intValue());
            }
            aVar.kxS.setIsRound(false);
            aVar.kxS.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kxS.setDrawBorder(true);
            aVar.kxS.setAutoChangeStyle(true);
            aVar.kxS.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.kxS.setImageDrawable(null);
            aVar.kxS.setVisibility(0);
            aVar.kxT.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.kxS.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.kxS.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.kxS.setClickable(false);
            aVar.kxS.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.kxS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kxS.setUserName(String.valueOf(1));
            aVar.kxS.setIsRound(false);
            aVar.kxS.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kxS.setDrawBorder(false);
            aVar.kxS.setAutoChangeStyle(true);
            aVar.kxS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.kxS.setUserName(String.valueOf(5));
            aVar.kxS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kxS.setVisibility(4);
            aVar.kxT.setVisibility(0);
            SvgManager.bwr().a(aVar.kxT, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.kxS.setIsRound(false);
            aVar.kxS.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kxS.setDrawBorder(true);
            aVar.kxS.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.kxS.setVisibility(0);
            aVar.kxT.setVisibility(8);
            aVar.kxS.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.kxS.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.kxS.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                }
            }
            aVar.kxS.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.kxS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kxS.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.kxS.setIsRound(false);
            aVar.kxS.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kxS.setDrawBorder(false);
            aVar.kxS.setAutoChangeStyle(true);
            aVar.kxS.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.kxS.setUserName(String.valueOf(7));
            aVar.kxS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kxS.setVisibility(4);
            aVar.kxT.setVisibility(0);
            SvgManager.bwr().a(aVar.kxT, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.kxS.setIsRound(false);
            aVar.kxS.invalidate();
        } else {
            aVar.kxS.setDrawBorder(true);
            aVar.kxS.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.kxS.setImageDrawable(null);
            aVar.kxS.setVisibility(0);
            aVar.kxT.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.kxS.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.kxS.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.kxS.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.kxS.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kxS.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.kxS.setIsRound(false);
            aVar.kxS.invalidate();
        }
    }
}
