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
import d.a.c.e.p.l;
import d.a.m0.s.d.d;
import d.a.n0.f1.f.i.c;
import d.a.n0.f1.t.f;
import d.a.n0.g1.b.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class ImMessageCenterListAdapter extends c {

    /* renamed from: h  reason: collision with root package name */
    public e f17457h;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.f17457h = null;
    }

    @Override // d.a.n0.f1.f.i.c
    public boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // d.a.n0.f1.f.i.c
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // d.a.n0.f1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.f54379b.setDrawerType(1);
        aVar.f54379b.setRadius(l.e(this.f54375e, 4.0f));
        aVar.f54380c.setClickable(false);
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f54379b.setDrawBorder(false);
            aVar.f54379b.setAutoChangeStyle(true);
            aVar.f54379b.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.f54379b.setVisibility(0);
            aVar.f54380c.setVisibility(8);
            if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                SkinManager.setImageResource(aVar.f54379b, R.drawable.icon_new_test);
            }
            aVar.f54379b.setUserName(String.valueOf(2));
            aVar.f54379b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f54379b.setIsRound(false);
            aVar.f54379b.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f54379b.setDrawBorder(false);
            aVar.f54379b.setAutoChangeStyle(true);
            aVar.f54379b.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.f54379b.setUserName(String.valueOf(3));
            aVar.f54379b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f54379b.setVisibility(0);
            aVar.f54380c.setVisibility(8);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
            if (runTask != null) {
                SkinManager.setImageResource(aVar.f54379b, ((Integer) runTask.getData()).intValue());
            }
            aVar.f54379b.setIsRound(false);
            aVar.f54379b.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f54379b.setDrawBorder(true);
            aVar.f54379b.setAutoChangeStyle(true);
            aVar.f54379b.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.f54379b.setImageDrawable(null);
            aVar.f54379b.setVisibility(0);
            aVar.f54380c.setVisibility(8);
            if (TextUtils.isEmpty(friendBjhAvatar)) {
                aVar.f54379b.V(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
            } else {
                aVar.f54379b.V(friendBjhAvatar, 10, false);
            }
            aVar.f54379b.setClickable(false);
            aVar.f54379b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.f54379b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f54379b.setUserName(String.valueOf(1));
            aVar.f54379b.setIsRound(false);
            aVar.f54379b.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f54379b.setDrawBorder(false);
            aVar.f54379b.setAutoChangeStyle(true);
            aVar.f54379b.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.f54379b.setUserName(String.valueOf(5));
            aVar.f54379b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f54379b.setVisibility(4);
            aVar.f54380c.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f54380c, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.f54379b.setIsRound(false);
            aVar.f54379b.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f54379b.setDrawBorder(true);
            aVar.f54379b.setAutoChangeStyle(true);
            String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.f54379b.setVisibility(0);
            aVar.f54380c.setVisibility(8);
            aVar.f54379b.setImageDrawable(null);
            if (TextUtils.isEmpty(friendBjhAvatar2)) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    aVar.f54379b.V(((Integer) runTask2.getData()).toString(), 24, false);
                }
            } else {
                aVar.f54379b.V(friendBjhAvatar2, 12, false);
            }
            aVar.f54379b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.f54379b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f54379b.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.f54379b.setIsRound(false);
            aVar.f54379b.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            aVar.f54379b.setDrawBorder(false);
            aVar.f54379b.setAutoChangeStyle(true);
            aVar.f54379b.setTag(imMessageCenterShowItemData.getOwnerName());
            aVar.f54379b.setUserName(String.valueOf(7));
            aVar.f54379b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f54379b.setVisibility(4);
            aVar.f54380c.setVisibility(0);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f54380c, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
            aVar.f54379b.setIsRound(false);
            aVar.f54379b.invalidate();
        } else {
            aVar.f54379b.setDrawBorder(true);
            aVar.f54379b.setAutoChangeStyle(true);
            String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
            if (TextUtils.isEmpty(friendBjhAvatar3)) {
                friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
            }
            aVar.f54379b.setImageDrawable(null);
            aVar.f54379b.setVisibility(0);
            aVar.f54380c.setVisibility(8);
            if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                aVar.f54379b.V(friendBjhAvatar3, 12, false);
            } else {
                aVar.f54379b.V(String.valueOf(R.drawable.person_photo), 24, false);
            }
            aVar.f54379b.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.f54379b.setUserId(imMessageCenterShowItemData.getFriendId());
            aVar.f54379b.setUserName(imMessageCenterShowItemData.getFriendName());
            aVar.f54379b.setIsRound(false);
            aVar.f54379b.invalidate();
        }
    }

    @Override // d.a.n0.f1.f.i.c, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData item = getItem(i2);
        if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
            if (item.getUnReadCount() >= 30) {
                e eVar = this.f17457h;
                if (eVar != null) {
                    eVar.v0(true);
                }
            } else {
                e eVar2 = this.f17457h;
                if (eVar2 != null) {
                    eVar2.v0(false);
                }
            }
        }
        return super.getView(i2, view, viewGroup);
    }

    @Override // d.a.n0.f1.f.i.c
    public void n(List<ImMessageCenterShowItemData> list) {
        super.n(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.f54376f.size() <= 0) {
                this.f17457h.w0(true, true);
            } else {
                this.f17457h.w0(true, false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // d.a.n0.f1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str) {
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : d.d().p() : d.d().p() && ((personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify()) : d.d().n() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(d.d().z() && f.a().b()))) {
            str = "";
            i2 = 0;
        }
        return new BasicNameValuePair(String.valueOf(i2), str);
    }

    public void q(e eVar) {
        this.f17457h = eVar;
    }
}
