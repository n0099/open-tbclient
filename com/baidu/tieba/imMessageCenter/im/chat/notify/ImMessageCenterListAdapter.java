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
    private e krs;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.krs = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.krs.aj(true, true);
            } else {
                this.krs.aj(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData Cz = getItem(i);
        if (Cz != null && String.valueOf(2).equals(Cz.getOwnerName())) {
            if (Cz.getUnReadCount() >= 30) {
                if (this.krs != null) {
                    this.krs.sB(true);
                }
            } else if (this.krs != null) {
                this.krs.sB(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.krs = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bwv().bwz()) {
                str = "";
            } else {
                if (!f.cVi().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bwv().bwL()) {
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
            if (!d.bwv().bwD()) {
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
            if (!d.bwv().bwD()) {
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
        aVar.jWV.setDrawerType(1);
        aVar.jWV.setRadius(l.dip2px(this.mContext, 4.0f));
        aVar.jWW.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jWV.setDrawBorder(false);
            aVar.jWV.setAutoChangeStyle(true);
            aVar.jWV.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jWV.setVisibility(0);
            aVar.jWW.setVisibility(8);
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                ap.setImageResource(aVar.jWV, R.drawable.icon_new_test);
            }
            aVar.jWV.setUserName(String.valueOf(2));
            aVar.jWV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jWV.setIsRound(false);
            aVar.jWV.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jWV.setDrawBorder(false);
            aVar.jWV.setAutoChangeStyle(true);
            aVar.jWV.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jWV.setUserName(String.valueOf(3));
            aVar.jWV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jWV.setVisibility(0);
            aVar.jWW.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                ap.setImageResource(aVar.jWV, ((Integer) runTask.getData()).intValue());
            }
            aVar.jWV.setIsRound(false);
            aVar.jWV.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jWV.setDrawBorder(true);
            aVar.jWV.setAutoChangeStyle(true);
            aVar.jWV.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jWV.setImageDrawable(null);
            aVar.jWV.setVisibility(0);
            aVar.jWW.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.jWV.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.jWV.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.jWV.setClickable(false);
            aVar.jWV.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jWV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jWV.setUserName(String.valueOf(1));
            aVar.jWV.setIsRound(false);
            aVar.jWV.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jWV.setDrawBorder(false);
            aVar.jWV.setAutoChangeStyle(true);
            aVar.jWV.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jWV.setUserName(String.valueOf(5));
            aVar.jWV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jWV.setVisibility(4);
            aVar.jWW.setVisibility(0);
            SvgManager.brn().a(aVar.jWW, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.jWV.setIsRound(false);
            aVar.jWV.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jWV.setDrawBorder(true);
            aVar.jWV.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jWV.setVisibility(0);
            aVar.jWW.setVisibility(8);
            aVar.jWV.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.jWV.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.jWV.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                }
            }
            aVar.jWV.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jWV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jWV.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.jWV.setIsRound(false);
            aVar.jWV.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jWV.setDrawBorder(false);
            aVar.jWV.setAutoChangeStyle(true);
            aVar.jWV.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jWV.setUserName(String.valueOf(7));
            aVar.jWV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jWV.setVisibility(4);
            aVar.jWW.setVisibility(0);
            SvgManager.brn().a(aVar.jWW, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.jWV.setIsRound(false);
            aVar.jWV.invalidate();
        } else {
            aVar.jWV.setDrawBorder(true);
            aVar.jWV.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jWV.setImageDrawable(null);
            aVar.jWV.setVisibility(0);
            aVar.jWW.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.jWV.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.jWV.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.jWV.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jWV.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jWV.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.jWV.setIsRound(false);
            aVar.jWV.invalidate();
        }
    }
}
