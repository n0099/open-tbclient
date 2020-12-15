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
    private e kFA;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.kFA = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.kFA.aj(true, true);
            } else {
                this.kFA.aj(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData DM = getItem(i);
        if (DM != null && String.valueOf(2).equals(DM.getOwnerName())) {
            if (DM.getUnReadCount() >= 30) {
                if (this.kFA != null) {
                    this.kFA.tg(true);
                }
            } else if (this.kFA != null) {
                this.kFA.tg(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.kFA = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bzl().bzp()) {
                str = "";
            } else {
                if (!f.dab().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bzl().bzB()) {
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
            if (!d.bzl().bzt()) {
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
            if (!d.bzl().bzt()) {
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
        aVar.klm.setDrawerType(1);
        aVar.klm.setRadius(l.dip2px(this.mContext, 4.0f));
        aVar.kln.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.klm.setDrawBorder(false);
            aVar.klm.setAutoChangeStyle(true);
            aVar.klm.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.klm.setVisibility(0);
            aVar.kln.setVisibility(8);
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                ap.setImageResource(aVar.klm, R.drawable.icon_new_test);
            }
            aVar.klm.setUserName(String.valueOf(2));
            aVar.klm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.klm.setIsRound(false);
            aVar.klm.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.klm.setDrawBorder(false);
            aVar.klm.setAutoChangeStyle(true);
            aVar.klm.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.klm.setUserName(String.valueOf(3));
            aVar.klm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.klm.setVisibility(0);
            aVar.kln.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                ap.setImageResource(aVar.klm, ((Integer) runTask.getData()).intValue());
            }
            aVar.klm.setIsRound(false);
            aVar.klm.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.klm.setDrawBorder(true);
            aVar.klm.setAutoChangeStyle(true);
            aVar.klm.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.klm.setImageDrawable(null);
            aVar.klm.setVisibility(0);
            aVar.kln.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.klm.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.klm.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.klm.setClickable(false);
            aVar.klm.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.klm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.klm.setUserName(String.valueOf(1));
            aVar.klm.setIsRound(false);
            aVar.klm.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.klm.setDrawBorder(false);
            aVar.klm.setAutoChangeStyle(true);
            aVar.klm.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.klm.setUserName(String.valueOf(5));
            aVar.klm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.klm.setVisibility(4);
            aVar.kln.setVisibility(0);
            SvgManager.btW().a(aVar.kln, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.klm.setIsRound(false);
            aVar.klm.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.klm.setDrawBorder(true);
            aVar.klm.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.klm.setVisibility(0);
            aVar.kln.setVisibility(8);
            aVar.klm.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.klm.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.klm.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                }
            }
            aVar.klm.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.klm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.klm.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.klm.setIsRound(false);
            aVar.klm.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.klm.setDrawBorder(false);
            aVar.klm.setAutoChangeStyle(true);
            aVar.klm.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.klm.setUserName(String.valueOf(7));
            aVar.klm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.klm.setVisibility(4);
            aVar.kln.setVisibility(0);
            SvgManager.btW().a(aVar.kln, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.klm.setIsRound(false);
            aVar.klm.invalidate();
        } else {
            aVar.klm.setDrawBorder(true);
            aVar.klm.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.klm.setImageDrawable(null);
            aVar.klm.setVisibility(0);
            aVar.kln.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.klm.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.klm.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.klm.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.klm.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.klm.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.klm.setIsRound(false);
            aVar.klm.invalidate();
        }
    }
}
