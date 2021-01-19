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
    private e kGe;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.kGe = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.kGe.al(true, true);
            } else {
                this.kGe.al(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData Cr = getItem(i);
        if (Cr != null && String.valueOf(2).equals(Cr.getOwnerName())) {
            if (Cr.getUnReadCount() >= 30) {
                if (this.kGe != null) {
                    this.kGe.td(true);
                }
            } else if (this.kGe != null) {
                this.kGe.td(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.kGe = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bxM().bxQ()) {
                str = "";
            } else {
                if (!f.cVX().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bxM().byc()) {
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
            if (!d.bxM().bxU()) {
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
            if (!d.bxM().bxU()) {
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
        aVar.ktn.setDrawerType(1);
        aVar.ktn.setRadius(l.dip2px(this.mContext, 4.0f));
        aVar.kto.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ktn.setDrawBorder(false);
            aVar.ktn.setAutoChangeStyle(true);
            aVar.ktn.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.ktn.setVisibility(0);
            aVar.kto.setVisibility(8);
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                ao.setImageResource(aVar.ktn, R.drawable.icon_new_test);
            }
            aVar.ktn.setUserName(String.valueOf(2));
            aVar.ktn.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ktn.setIsRound(false);
            aVar.ktn.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ktn.setDrawBorder(false);
            aVar.ktn.setAutoChangeStyle(true);
            aVar.ktn.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.ktn.setUserName(String.valueOf(3));
            aVar.ktn.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ktn.setVisibility(0);
            aVar.kto.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                ao.setImageResource(aVar.ktn, ((Integer) runTask.getData()).intValue());
            }
            aVar.ktn.setIsRound(false);
            aVar.ktn.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ktn.setDrawBorder(true);
            aVar.ktn.setAutoChangeStyle(true);
            aVar.ktn.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.ktn.setImageDrawable(null);
            aVar.ktn.setVisibility(0);
            aVar.kto.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.ktn.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.ktn.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.ktn.setClickable(false);
            aVar.ktn.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.ktn.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ktn.setUserName(String.valueOf(1));
            aVar.ktn.setIsRound(false);
            aVar.ktn.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ktn.setDrawBorder(false);
            aVar.ktn.setAutoChangeStyle(true);
            aVar.ktn.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.ktn.setUserName(String.valueOf(5));
            aVar.ktn.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ktn.setVisibility(4);
            aVar.kto.setVisibility(0);
            SvgManager.bsx().a(aVar.kto, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.ktn.setIsRound(false);
            aVar.ktn.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ktn.setDrawBorder(true);
            aVar.ktn.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.ktn.setVisibility(0);
            aVar.kto.setVisibility(8);
            aVar.ktn.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.ktn.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.ktn.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                }
            }
            aVar.ktn.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.ktn.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ktn.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.ktn.setIsRound(false);
            aVar.ktn.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.ktn.setDrawBorder(false);
            aVar.ktn.setAutoChangeStyle(true);
            aVar.ktn.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.ktn.setUserName(String.valueOf(7));
            aVar.ktn.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ktn.setVisibility(4);
            aVar.kto.setVisibility(0);
            SvgManager.bsx().a(aVar.kto, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.ktn.setIsRound(false);
            aVar.ktn.invalidate();
        } else {
            aVar.ktn.setDrawBorder(true);
            aVar.ktn.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.ktn.setImageDrawable(null);
            aVar.ktn.setVisibility(0);
            aVar.kto.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.ktn.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.ktn.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.ktn.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.ktn.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.ktn.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.ktn.setIsRound(false);
            aVar.ktn.invalidate();
        }
    }
}
