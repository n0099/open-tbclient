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
/* loaded from: classes2.dex */
public class ImMessageCenterListAdapter extends c {
    private e kQy;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.kQy = null;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.kQy.al(true, true);
            } else {
                this.kQy.al(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData CM = getItem(i);
        if (CM != null && String.valueOf(2).equals(CM.getOwnerName())) {
            if (CM.getUnReadCount() >= 30) {
                if (this.kQy != null) {
                    this.kQy.tq(true);
                }
            } else if (this.kQy != null) {
                this.kQy.tq(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void a(e eVar) {
        this.kQy = eVar;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.byh().byl()) {
                str = "";
            } else {
                if (!f.cYj().isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
                i2 = i;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!d.byh().byx()) {
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
            if (!d.byh().byp()) {
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
            if (!d.byh().byp()) {
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
        aVar.kDK.setDrawerType(1);
        aVar.kDK.setRadius(l.dip2px(this.mContext, 4.0f));
        aVar.kDL.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kDK.setDrawBorder(false);
            aVar.kDK.setAutoChangeStyle(true);
            aVar.kDK.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.kDK.setVisibility(0);
            aVar.kDL.setVisibility(8);
            if (MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_ICON, Integer.class) != null) {
                ap.setImageResource(aVar.kDK, R.drawable.icon_new_test);
            }
            aVar.kDK.setUserName(String.valueOf(2));
            aVar.kDK.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kDK.setIsRound(false);
            aVar.kDK.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kDK.setDrawBorder(false);
            aVar.kDK.setAutoChangeStyle(true);
            aVar.kDK.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.kDK.setUserName(String.valueOf(3));
            aVar.kDK.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kDK.setVisibility(0);
            aVar.kDL.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_ICON, Integer.class);
            if (runTask != null) {
                ap.setImageResource(aVar.kDK, ((Integer) runTask.getData()).intValue());
            }
            aVar.kDK.setIsRound(false);
            aVar.kDK.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kDK.setDrawBorder(true);
            aVar.kDK.setAutoChangeStyle(true);
            aVar.kDK.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.kDK.setImageDrawable(null);
            aVar.kDK.setVisibility(0);
            aVar.kDL.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.kDK.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.kDK.startLoad(friendBjhAvatar, 10, false);
            }
            aVar.kDK.setClickable(false);
            aVar.kDK.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.kDK.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kDK.setUserName(String.valueOf(1));
            aVar.kDK.setIsRound(false);
            aVar.kDK.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kDK.setDrawBorder(false);
            aVar.kDK.setAutoChangeStyle(true);
            aVar.kDK.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.kDK.setUserName(String.valueOf(5));
            aVar.kDK.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kDK.setVisibility(4);
            aVar.kDL.setVisibility(0);
            SvgManager.bsU().a(aVar.kDL, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.kDK.setIsRound(false);
            aVar.kDK.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kDK.setDrawBorder(true);
            aVar.kDK.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.kDK.setVisibility(0);
            aVar.kDL.setVisibility(8);
            aVar.kDK.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendBjhAvatar2)) {
                aVar.kDK.startLoad(friendBjhAvatar2, 12, false);
            } else {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_OFFICIAL_MERGE_ICON, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.kDK.startLoad(((Integer) runTask2.getData()).toString(), 24, false);
                }
            }
            aVar.kDK.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.kDK.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kDK.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.kDK.setIsRound(false);
            aVar.kDK.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.kDK.setDrawBorder(false);
            aVar.kDK.setAutoChangeStyle(true);
            aVar.kDK.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.kDK.setUserName(String.valueOf(7));
            aVar.kDK.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kDK.setVisibility(4);
            aVar.kDL.setVisibility(0);
            SvgManager.bsU().a(aVar.kDL, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.kDK.setIsRound(false);
            aVar.kDK.invalidate();
        } else {
            aVar.kDK.setDrawBorder(true);
            aVar.kDK.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.kDK.setImageDrawable(null);
            aVar.kDK.setVisibility(0);
            aVar.kDL.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.kDK.startLoad(friendBjhAvatar3, 12, false);
            } else {
                aVar.kDK.startLoad(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.kDK.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.kDK.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.kDK.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.kDK.setIsRound(false);
            aVar.kDK.invalidate();
        }
    }
}
