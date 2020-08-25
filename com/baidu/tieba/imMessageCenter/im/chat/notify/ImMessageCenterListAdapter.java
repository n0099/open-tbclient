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
/* loaded from: classes16.dex */
public class ImMessageCenterListAdapter extends c {
    private e jBr;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.jBr = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.jBr.af(true, true);
            } else {
                this.jBr.af(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData AM = getItem(i);
        if (AM != null && String.valueOf(2).equals(AM.getOwnerName())) {
            if (AM.getUnReadCount() >= 30) {
                if (this.jBr != null) {
                    this.jBr.rk(true);
                }
            } else if (this.jBr != null) {
                this.jBr.rk(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.jBr = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.boy().boC()) {
                str = "";
            } else {
                if (!f.cIl().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.boy().boO()) {
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
            if (!d.boy().boG()) {
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
            if (!d.boy().boG()) {
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
        aVar.jgQ.setDrawerType(1);
        aVar.jgQ.setRadius(l.dip2px(this.mContext, 4.0f));
        aVar.jgR.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jgQ.setDrawBorder(false);
            aVar.jgQ.setAutoChangeStyle(true);
            aVar.jgQ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jgQ.setVisibility(0);
            aVar.jgR.setVisibility(8);
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                ap.setImageResource(aVar.jgQ, R.drawable.icon_new_test);
            }
            aVar.jgQ.setUserName(String.valueOf(2));
            aVar.jgQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jgQ.setIsRound(false);
            aVar.jgQ.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jgQ.setDrawBorder(false);
            aVar.jgQ.setAutoChangeStyle(true);
            aVar.jgQ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jgQ.setUserName(String.valueOf(3));
            aVar.jgQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jgQ.setVisibility(0);
            aVar.jgR.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                ap.setImageResource(aVar.jgQ, ((Integer) runTask.getData()).intValue());
            }
            aVar.jgQ.setIsRound(false);
            aVar.jgQ.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jgQ.setDrawBorder(true);
            aVar.jgQ.setAutoChangeStyle(true);
            aVar.jgQ.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jgQ.setImageDrawable(null);
            aVar.jgQ.setVisibility(0);
            aVar.jgR.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.jgQ.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.jgQ.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.jgQ.setClickable(false);
            aVar.jgQ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jgQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jgQ.setUserName(String.valueOf(1));
            aVar.jgQ.setIsRound(false);
            aVar.jgQ.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jgQ.setDrawBorder(false);
            aVar.jgQ.setAutoChangeStyle(true);
            aVar.jgQ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jgQ.setUserName(String.valueOf(5));
            aVar.jgQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jgQ.setVisibility(4);
            aVar.jgR.setVisibility(0);
            SvgManager.bjq().a(aVar.jgR, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.jgQ.setIsRound(false);
            aVar.jgQ.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jgQ.setDrawBorder(true);
            aVar.jgQ.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jgQ.setVisibility(0);
            aVar.jgR.setVisibility(8);
            aVar.jgQ.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.jgQ.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.jgQ.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                }
            }
            aVar.jgQ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jgQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jgQ.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.jgQ.setIsRound(false);
            aVar.jgQ.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jgQ.setDrawBorder(false);
            aVar.jgQ.setAutoChangeStyle(true);
            aVar.jgQ.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jgQ.setUserName(String.valueOf(7));
            aVar.jgQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jgQ.setVisibility(4);
            aVar.jgR.setVisibility(0);
            SvgManager.bjq().a(aVar.jgR, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.jgQ.setIsRound(false);
            aVar.jgQ.invalidate();
        } else {
            aVar.jgQ.setDrawBorder(true);
            aVar.jgQ.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jgQ.setImageDrawable(null);
            aVar.jgQ.setVisibility(0);
            aVar.jgR.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.jgQ.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.jgQ.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.jgQ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jgQ.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jgQ.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.jgQ.setIsRound(false);
            aVar.jgQ.invalidate();
        }
    }
}
