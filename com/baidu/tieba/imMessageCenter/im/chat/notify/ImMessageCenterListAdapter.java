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
    private e klw;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.klw = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.klw.aj(true, true);
            } else {
                this.klw.aj(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData Cm = getItem(i);
        if (Cm != null && String.valueOf(2).equals(Cm.getOwnerName())) {
            if (Cm.getUnReadCount() >= 30) {
                if (this.klw != null) {
                    this.klw.ss(true);
                }
            } else if (this.klw != null) {
                this.klw.ss(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.klw = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.btV().btZ()) {
                str = "";
            } else {
                if (!f.cSH().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.btV().bul()) {
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
            if (!d.btV().bud()) {
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
            if (!d.btV().bud()) {
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
        aVar.jQY.setDrawerType(1);
        aVar.jQY.setRadius(l.dip2px(this.mContext, 4.0f));
        aVar.jQZ.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jQY.setDrawBorder(false);
            aVar.jQY.setAutoChangeStyle(true);
            aVar.jQY.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jQY.setVisibility(0);
            aVar.jQZ.setVisibility(8);
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                ap.setImageResource(aVar.jQY, R.drawable.icon_new_test);
            }
            aVar.jQY.setUserName(String.valueOf(2));
            aVar.jQY.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jQY.setIsRound(false);
            aVar.jQY.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jQY.setDrawBorder(false);
            aVar.jQY.setAutoChangeStyle(true);
            aVar.jQY.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jQY.setUserName(String.valueOf(3));
            aVar.jQY.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jQY.setVisibility(0);
            aVar.jQZ.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                ap.setImageResource(aVar.jQY, ((Integer) runTask.getData()).intValue());
            }
            aVar.jQY.setIsRound(false);
            aVar.jQY.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jQY.setDrawBorder(true);
            aVar.jQY.setAutoChangeStyle(true);
            aVar.jQY.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jQY.setImageDrawable(null);
            aVar.jQY.setVisibility(0);
            aVar.jQZ.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.jQY.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.jQY.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.jQY.setClickable(false);
            aVar.jQY.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jQY.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jQY.setUserName(String.valueOf(1));
            aVar.jQY.setIsRound(false);
            aVar.jQY.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jQY.setDrawBorder(false);
            aVar.jQY.setAutoChangeStyle(true);
            aVar.jQY.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jQY.setUserName(String.valueOf(5));
            aVar.jQY.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jQY.setVisibility(4);
            aVar.jQZ.setVisibility(0);
            SvgManager.boN().a(aVar.jQZ, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.jQY.setIsRound(false);
            aVar.jQY.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jQY.setDrawBorder(true);
            aVar.jQY.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jQY.setVisibility(0);
            aVar.jQZ.setVisibility(8);
            aVar.jQY.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.jQY.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.jQY.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                }
            }
            aVar.jQY.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jQY.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jQY.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.jQY.setIsRound(false);
            aVar.jQY.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jQY.setDrawBorder(false);
            aVar.jQY.setAutoChangeStyle(true);
            aVar.jQY.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jQY.setUserName(String.valueOf(7));
            aVar.jQY.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jQY.setVisibility(4);
            aVar.jQZ.setVisibility(0);
            SvgManager.boN().a(aVar.jQZ, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.jQY.setIsRound(false);
            aVar.jQY.invalidate();
        } else {
            aVar.jQY.setDrawBorder(true);
            aVar.jQY.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jQY.setImageDrawable(null);
            aVar.jQY.setVisibility(0);
            aVar.jQZ.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.jQY.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.jQY.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.jQY.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jQY.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jQY.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.jQY.setIsRound(false);
            aVar.jQY.invalidate();
        }
    }
}
