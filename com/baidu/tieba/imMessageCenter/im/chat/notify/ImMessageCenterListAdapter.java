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
/* loaded from: classes21.dex */
public class ImMessageCenterListAdapter extends c {
    private e ksc;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.ksc = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.ksc.aj(true, true);
            } else {
                this.ksc.aj(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData CX = getItem(i);
        if (CX != null && String.valueOf(2).equals(CX.getOwnerName())) {
            if (CX.getUnReadCount() >= 30) {
                if (this.ksc != null) {
                    this.ksc.sE(true);
                }
            } else if (this.ksc != null) {
                this.ksc.sE(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.ksc = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bvL().bvP()) {
                str = "";
            } else {
                if (!f.cUO().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.bvL().bwb()) {
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
            if (!d.bvL().bvT()) {
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
            if (!d.bvL().bvT()) {
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
        aVar.jXF.setDrawerType(1);
        aVar.jXF.setRadius(l.dip2px(this.mContext, 4.0f));
        aVar.jXG.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jXF.setDrawBorder(false);
            aVar.jXF.setAutoChangeStyle(true);
            aVar.jXF.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jXF.setVisibility(0);
            aVar.jXG.setVisibility(8);
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                ap.setImageResource(aVar.jXF, R.drawable.icon_new_test);
            }
            aVar.jXF.setUserName(String.valueOf(2));
            aVar.jXF.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jXF.setIsRound(false);
            aVar.jXF.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jXF.setDrawBorder(false);
            aVar.jXF.setAutoChangeStyle(true);
            aVar.jXF.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jXF.setUserName(String.valueOf(3));
            aVar.jXF.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jXF.setVisibility(0);
            aVar.jXG.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                ap.setImageResource(aVar.jXF, ((Integer) runTask.getData()).intValue());
            }
            aVar.jXF.setIsRound(false);
            aVar.jXF.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jXF.setDrawBorder(true);
            aVar.jXF.setAutoChangeStyle(true);
            aVar.jXF.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jXF.setImageDrawable(null);
            aVar.jXF.setVisibility(0);
            aVar.jXG.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.jXF.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.jXF.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.jXF.setClickable(false);
            aVar.jXF.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jXF.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jXF.setUserName(String.valueOf(1));
            aVar.jXF.setIsRound(false);
            aVar.jXF.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jXF.setDrawBorder(false);
            aVar.jXF.setAutoChangeStyle(true);
            aVar.jXF.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jXF.setUserName(String.valueOf(5));
            aVar.jXF.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jXF.setVisibility(4);
            aVar.jXG.setVisibility(0);
            SvgManager.bqB().a(aVar.jXG, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.jXF.setIsRound(false);
            aVar.jXF.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jXF.setDrawBorder(true);
            aVar.jXF.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jXF.setVisibility(0);
            aVar.jXG.setVisibility(8);
            aVar.jXF.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.jXF.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.jXF.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                }
            }
            aVar.jXF.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jXF.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jXF.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.jXF.setIsRound(false);
            aVar.jXF.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.jXF.setDrawBorder(false);
            aVar.jXF.setAutoChangeStyle(true);
            aVar.jXF.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.jXF.setUserName(String.valueOf(7));
            aVar.jXF.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jXF.setVisibility(4);
            aVar.jXG.setVisibility(0);
            SvgManager.bqB().a(aVar.jXG, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.jXF.setIsRound(false);
            aVar.jXF.invalidate();
        } else {
            aVar.jXF.setDrawBorder(true);
            aVar.jXF.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.jXF.setImageDrawable(null);
            aVar.jXF.setVisibility(0);
            aVar.jXG.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.jXF.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.jXF.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.jXF.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jXF.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.jXF.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.jXF.setIsRound(false);
            aVar.jXF.invalidate();
        }
    }
}
