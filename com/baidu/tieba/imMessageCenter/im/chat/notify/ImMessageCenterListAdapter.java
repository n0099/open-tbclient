package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.s.d.d;
import d.a.s0.i1.f.i.c;
import d.a.s0.i1.t.f;
import d.a.s0.j1.b.e;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes5.dex */
public class ImMessageCenterListAdapter extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public e f17741h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImMessageCenterListAdapter(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17741h = null;
    }

    @Override // d.a.s0.i1.f.i.c
    public boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.s0.i1.f.i.c
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.s0.i1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f61536b.setDrawerType(1);
            aVar.f61536b.setRadius(l.e(this.f61532e, 4.0f));
            aVar.f61537c.setClickable(false);
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f61536b.setDrawBorder(false);
                aVar.f61536b.setAutoChangeStyle(true);
                aVar.f61536b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f61536b.setVisibility(0);
                aVar.f61537c.setVisibility(8);
                if (MessageManager.getInstance().runTask(2001287, Integer.class) != null) {
                    SkinManager.setImageResource(aVar.f61536b, R.drawable.icon_new_test);
                }
                aVar.f61536b.setUserName(String.valueOf(2));
                aVar.f61536b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f61536b.setIsRound(false);
                aVar.f61536b.invalidate();
            } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f61536b.setDrawBorder(false);
                aVar.f61536b.setAutoChangeStyle(true);
                aVar.f61536b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f61536b.setUserName(String.valueOf(3));
                aVar.f61536b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f61536b.setVisibility(0);
                aVar.f61537c.setVisibility(8);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001286, Integer.class);
                if (runTask != null) {
                    SkinManager.setImageResource(aVar.f61536b, ((Integer) runTask.getData()).intValue());
                }
                aVar.f61536b.setIsRound(false);
                aVar.f61536b.invalidate();
            } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f61536b.setDrawBorder(true);
                aVar.f61536b.setAutoChangeStyle(true);
                aVar.f61536b.setUserId(imMessageCenterShowItemData.getFriendId());
                String friendBjhAvatar = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    friendBjhAvatar = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f61536b.setImageDrawable(null);
                aVar.f61536b.setVisibility(0);
                aVar.f61537c.setVisibility(8);
                if (TextUtils.isEmpty(friendBjhAvatar)) {
                    aVar.f61536b.M(String.valueOf(R.drawable.icon_default_avatar100), 24, false);
                } else {
                    aVar.f61536b.M(friendBjhAvatar, 10, false);
                }
                aVar.f61536b.setClickable(false);
                aVar.f61536b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f61536b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f61536b.setUserName(String.valueOf(1));
                aVar.f61536b.setIsRound(false);
                aVar.f61536b.invalidate();
            } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f61536b.setDrawBorder(false);
                aVar.f61536b.setAutoChangeStyle(true);
                aVar.f61536b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f61536b.setUserName(String.valueOf(5));
                aVar.f61536b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f61536b.setVisibility(4);
                aVar.f61537c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f61537c, R.drawable.ic_icon_mask_broadcast_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f61536b.setIsRound(false);
                aVar.f61536b.invalidate();
            } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f61536b.setDrawBorder(true);
                aVar.f61536b.setAutoChangeStyle(true);
                String friendBjhAvatar2 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    friendBjhAvatar2 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f61536b.setVisibility(0);
                aVar.f61537c.setVisibility(8);
                aVar.f61536b.setImageDrawable(null);
                if (TextUtils.isEmpty(friendBjhAvatar2)) {
                    CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001289, Integer.class);
                    if (runTask2 != null && runTask2.getData() != null) {
                        aVar.f61536b.M(((Integer) runTask2.getData()).toString(), 24, false);
                    }
                } else {
                    aVar.f61536b.M(friendBjhAvatar2, 12, false);
                }
                aVar.f61536b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f61536b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f61536b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f61536b.setIsRound(false);
                aVar.f61536b.invalidate();
            } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
                aVar.f61536b.setDrawBorder(false);
                aVar.f61536b.setAutoChangeStyle(true);
                aVar.f61536b.setTag(imMessageCenterShowItemData.getOwnerName());
                aVar.f61536b.setUserName(String.valueOf(7));
                aVar.f61536b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f61536b.setVisibility(4);
                aVar.f61537c.setVisibility(0);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(aVar.f61537c, R.drawable.ic_icon_mask_stranger_svg, SvgManager.SvgResourceStateType.NORMAL);
                aVar.f61536b.setIsRound(false);
                aVar.f61536b.invalidate();
            } else {
                aVar.f61536b.setDrawBorder(true);
                aVar.f61536b.setAutoChangeStyle(true);
                String friendBjhAvatar3 = imMessageCenterShowItemData.getFriendBjhAvatar();
                if (TextUtils.isEmpty(friendBjhAvatar3)) {
                    friendBjhAvatar3 = imMessageCenterShowItemData.getFriendPortrait();
                }
                aVar.f61536b.setImageDrawable(null);
                aVar.f61536b.setVisibility(0);
                aVar.f61537c.setVisibility(8);
                if (!TextUtils.isEmpty(friendBjhAvatar3)) {
                    aVar.f61536b.M(friendBjhAvatar3, 12, false);
                } else {
                    aVar.f61536b.M(String.valueOf(R.drawable.person_photo), 24, false);
                }
                aVar.f61536b.setTag(imMessageCenterShowItemData.getFriendPortrait());
                aVar.f61536b.setUserId(imMessageCenterShowItemData.getFriendId());
                aVar.f61536b.setUserName(imMessageCenterShowItemData.getFriendName());
                aVar.f61536b.setIsRound(false);
                aVar.f61536b.invalidate();
            }
        }
    }

    @Override // d.a.s0.i1.f.i.c, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            ImMessageCenterShowItemData item = getItem(i2);
            if (item != null && String.valueOf(2).equals(item.getOwnerName())) {
                if (item.getUnReadCount() >= 30) {
                    e eVar = this.f17741h;
                    if (eVar != null) {
                        eVar.t0(true);
                    }
                } else {
                    e eVar2 = this.f17741h;
                    if (eVar2 != null) {
                        eVar2.t0(false);
                    }
                }
            }
            return super.getView(i2, view, viewGroup);
        }
        return (View) invokeILL.objValue;
    }

    @Override // d.a.s0.i1.f.i.c
    public void n(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            super.n(list);
            if (TbadkCoreApplication.isLogin()) {
                if (this.f61533f.size() <= 0) {
                    this.f17741h.w0(true, true);
                } else {
                    this.f17741h.w0(true, false);
                }
            }
            notifyDataSetChanged();
        }
    }

    @Override // d.a.s0.i1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str) {
        InterceptResult invokeLIL;
        PersonalSettingItemData personalSettingItemData;
        GroupSettingItemData groupSettingItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, imMessageCenterShowItemData, i2, str)) == null) {
            if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName()) || (!String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName()) ? !(!String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) ? !String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName()) : d.d().p() : d.d().p() && ((personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || personalSettingItemData.isAcceptNotify()) : d.d().n() && ((groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting()) == null || groupSettingItemData.isAcceptNotify())) : !(d.d().z() && f.a().b()))) {
                str = "";
                i2 = 0;
            }
            return new BasicNameValuePair(String.valueOf(i2), str);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }

    public void q(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f17741h = eVar;
        }
    }
}
