package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import d.b.c.e.p.l;
import d.b.h0.s.d.d;
import d.b.i0.e1.f.i.c;
import d.b.i0.e1.t.f;
import d.b.i0.f1.b.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class ImMessageCenterListAdapter extends c {

    /* renamed from: h  reason: collision with root package name */
    public e f17889h;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.f17889h = null;
    }

    @Override // d.b.i0.e1.f.i.c
    public boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // d.b.i0.e1.f.i.c
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // d.b.i0.e1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.f55211b.setDrawerType(1);
        aVar.f55211b.setRadius(l.e(this.f55207e, 4.0f));
        aVar.f55212c.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f55211b.setDrawBorder(false);
            aVar.f55211b.setAutoChangeStyle(true);
            aVar.f55211b.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.f55211b.setVisibility(0);
            aVar.f55212c.setVisibility(8);
            if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                SkinManager.setImageResource(aVar.f55211b, R.drawable.icon_new_test);
            }
            aVar.f55211b.setUserName(String.valueOf(2));
            aVar.f55211b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f55211b.setIsRound(false);
            aVar.f55211b.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f55211b.setDrawBorder(false);
            aVar.f55211b.setAutoChangeStyle(true);
            aVar.f55211b.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.f55211b.setUserName(String.valueOf(3));
            aVar.f55211b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f55211b.setVisibility(0);
            aVar.f55212c.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask != null) {
                SkinManager.setImageResource(aVar.f55211b, ((Integer) runTask.getData()).intValue());
            }
            aVar.f55211b.setIsRound(false);
            aVar.f55211b.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f55211b.setDrawBorder(true);
            aVar.f55211b.setAutoChangeStyle(true);
            aVar.f55211b.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.f55211b.setImageDrawable(null);
            aVar.f55211b.setVisibility(0);
            aVar.f55212c.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.f55211b.W(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.f55211b.W(friendBjhAvatar, 10, false);
            }
            aVar.f55211b.setClickable(false);
            aVar.f55211b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.f55211b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f55211b.setUserName(String.valueOf(1));
            aVar.f55211b.setIsRound(false);
            aVar.f55211b.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f55211b.setDrawBorder(false);
            aVar.f55211b.setAutoChangeStyle(true);
            aVar.f55211b.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.f55211b.setUserName(String.valueOf(5));
            aVar.f55211b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f55211b.setVisibility(4);
            aVar.f55212c.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f55212c, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.f55211b.setIsRound(false);
            aVar.f55211b.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f55211b.setDrawBorder(true);
            aVar.f55211b.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.f55211b.setVisibility(0);
            aVar.f55212c.setVisibility(8);
            aVar.f55211b.setImageDrawable(null);
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.f55211b.W(((Integer) runTask2.getData()).toString(), 24, false);
                }
            } else {
                aVar.f55211b.W(friendBjhAvatar2, 12, false);
            }
            aVar.f55211b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.f55211b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f55211b.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.f55211b.setIsRound(false);
            aVar.f55211b.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f55211b.setDrawBorder(false);
            aVar.f55211b.setAutoChangeStyle(true);
            aVar.f55211b.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.f55211b.setUserName(String.valueOf(7));
            aVar.f55211b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f55211b.setVisibility(4);
            aVar.f55212c.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f55212c, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.f55211b.setIsRound(false);
            aVar.f55211b.invalidate();
        } else {
            aVar.f55211b.setDrawBorder(true);
            aVar.f55211b.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.f55211b.setImageDrawable(null);
            aVar.f55211b.setVisibility(0);
            aVar.f55212c.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.f55211b.W(friendBjhAvatar3, 12, false);
            } else {
                aVar.f55211b.W(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.f55211b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.f55211b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f55211b.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.f55211b.setIsRound(false);
            aVar.f55211b.invalidate();
        }
    }

    @Override // d.b.i0.e1.f.i.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData item = getItem(i);
        if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
            if (item.getUnReadCount() >= 30) {
                e eVar = this.f17889h;
                if (eVar != null) {
                    eVar.v0(true);
                }
            } else {
                e eVar2 = this.f17889h;
                if (eVar2 != null) {
                    eVar2.v0(false);
                }
            }
        }
        return super.getView(i, view, viewGroup);
    }

    @Override // d.b.i0.e1.f.i.c
    public void n(List<ImMessageCenterShowItemData> list) {
        super.n(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.f55208f.size() <= 0) {
                this.f17889h.w0(true, true);
            } else {
                this.f17889h.w0(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // d.b.i0.e1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : d.d().p() : d.d().p() && ((personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify()) : d.d().n() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(d.d().z() && f.a().b()))) {
            str = "";
            i = 0;
        }
        return new BasicNameValuePair(String.valueOf(i), str);
    }

    public void q(e eVar) {
        this.f17889h = eVar;
    }
}
