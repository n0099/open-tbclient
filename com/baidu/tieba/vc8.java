package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.e47;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.vc8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes8.dex */
public abstract class vc8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<ImMessageCenterShowItemData> b;
    public boolean c;
    public boolean d;

    public abstract boolean g(ImMessageCenterShowItemData imMessageCenterShowItemData);

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? i : invokeI.longValue;
    }

    public abstract boolean h(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract void k(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract void v(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
        }
    }

    public abstract BasicNameValuePair z(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;
        public HeadImageView b;
        public ImageView c;
        public BarImageView d;
        public TextView e;
        public EMTextView f;
        public TextView g;
        public TextView h;
        public MessageRedDotView i;
        public FrameLayout j;
        public ImageView k;
        public View l;
        public LinearLayout m;
        public ImageView n;
        public ImageView o;

        public a(vc8 vc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.l = null;
            this.m = null;
            this.n = null;
            this.o = null;
        }
    }

    public vc8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = false;
        this.a = context;
    }

    public void l(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, aVar, imMessageCenterShowItemData) == null) {
            if (imMessageCenterShowItemData.getMarkTopIndex() > 0) {
                TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0206, R.color.CAM_X0204);
            } else {
                TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
            }
        }
    }

    public void m(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, aVar, imMessageCenterShowItemData) == null) {
            if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                aVar.g.setText("");
                aVar.g.setVisibility(8);
                aVar.j.setVisibility(8);
                return;
            }
            i(imMessageCenterShowItemData, aVar);
        }
    }

    public final void t(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048600, this, z, aVar) == null) {
            if (z) {
                aVar.k.setVisibility(0);
            } else {
                aVar.k.setVisibility(8);
            }
        }
    }

    public final void A(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, imMessageCenterShowItemData) != null) || imMessageCenterShowItemData == null) {
            return;
        }
        int i2 = 0;
        int i3 = 2;
        if (TextUtils.equals("4", imMessageCenterShowItemData.getOwnerName())) {
            i2 = 1;
        } else if (TextUtils.equals("7", imMessageCenterShowItemData.getOwnerName())) {
            i2 = 2;
        }
        if (i2 > 0 && e(imMessageCenterShowItemData)) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount());
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                i = 1;
            } else {
                i = 2;
            }
            TiebaStatic.log(param.param("obj_type", i).param("obj_locate", i2).param("obj_param1", imMessageCenterShowItemData.getUnReadCount()));
        }
        if (CommonStatisticKey.TbMemberOfficialStatic.TB_MEMBER_OFFICIAL_ID.equals(imMessageCenterShowItemData.getFriendId())) {
            CommonStatisticUtils.staticTbMemberNotify(CommonStatisticKey.TbMemberOfficialStatic.MEMBER_MSG_CENTER_NOTIFY_SHOW, null, imMessageCenterShowItemData.getFriendName());
        }
        if (d(imMessageCenterShowItemData)) {
            StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_MSG_TAB_GROUP_ITEM).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", imMessageCenterShowItemData.getForumId()).param("room_id", imMessageCenterShowItemData.getRoomId()).param("obj_type", 1);
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                i3 = 1;
            }
            TiebaStatic.log(param2.param("obj_source", i3));
        }
    }

    public final void B(@NonNull a aVar, @NonNull ImMessageCenterShowItemData imMessageCenterShowItemData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, imMessageCenterShowItemData, z) == null) && imMessageCenterShowItemData.getGroupSetting() != null && e(imMessageCenterShowItemData) && z) {
            aVar.i.setVisibility(8);
        }
    }

    public void y(a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, aVar, str, str2) == null) {
            if (!StringUtils.isNull(str2)) {
                aVar.e.setText(str2);
            }
            if (!StringUtils.isNull(str)) {
                aVar.f.setText(str);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ImMessageCenterShowItemData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            List<ImMessageCenterShowItemData> list = this.b;
            if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
                return null;
            }
            return this.b.get(i);
        }
        return (ImMessageCenterShowItemData) invokeI.objValue;
    }

    public final boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null || !String.valueOf(9).equals(imMessageCenterShowItemData.getOwnerName())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            return String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
        }
        return invokeL.booleanValue;
    }

    public void u(List<ImMessageCenterShowItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            if (this.b == null) {
                this.b = new LinkedList();
            }
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.c = z;
        }
    }

    public a b(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, view2, i)) == null) {
            a aVar = new a(this);
            aVar.a = (ViewGroup) view2.findViewById(R.id.chat_item);
            aVar.c = (ImageView) view2.findViewById(R.id.svg_head);
            aVar.b = (HeadImageView) view2.findViewById(R.id.chat_head);
            aVar.d = (BarImageView) view2.findViewById(R.id.forum_head);
            TextView textView = (TextView) view2.findViewById(R.id.chat_name);
            aVar.e = textView;
            d85 d = d85.d(textView);
            d.x(R.color.CAM_X0105);
            d.D(R.string.F_X01);
            d.C(R.dimen.T_X05);
            EMTextView eMTextView = (EMTextView) view2.findViewById(R.id.msg_group_name);
            aVar.f = eMTextView;
            d85 d2 = d85.d(eMTextView);
            d2.o(R.string.J_X04);
            d2.x(R.color.CAM_X0302);
            d2.D(R.string.F_X01);
            d2.C(R.dimen.T_X10);
            d2.e(R.string.obfuscated_res_0x7f0f000e);
            d2.f(R.color.CAM_X0302);
            TextView textView2 = (TextView) view2.findViewById(R.id.last_chat_content);
            aVar.g = textView2;
            d85 d3 = d85.d(textView2);
            d3.x(R.color.CAM_X0109);
            d3.D(R.string.F_X01);
            d3.C(R.dimen.T_X08);
            TextView textView3 = (TextView) view2.findViewById(R.id.chat_time);
            aVar.h = textView3;
            d85 d4 = d85.d(textView3);
            d4.x(R.color.CAM_X0110);
            d4.D(R.string.F_X01);
            d4.C(R.dimen.T_X09);
            aVar.l = view2.findViewById(R.id.obfuscated_res_0x7f091502);
            aVar.i = (MessageRedDotView) view2.findViewById(R.id.new_message);
            aVar.j = (FrameLayout) view2.findViewById(R.id.new_message_container);
            aVar.i.setShadowEnabled(false);
            ImageView imageView = (ImageView) view2.findViewById(R.id.bell_message_icon);
            aVar.k = imageView;
            WebPManager.setPureDrawable(imageView, R.drawable.ic_icon_pure_shield_svg, R.color.CAM_X1111, null);
            aVar.m = (LinearLayout) view2.findViewById(R.id.my_fans);
            aVar.n = (ImageView) view2.findViewById(R.id.send_status);
            aVar.o = (ImageView) view2.findViewById(R.id.select_status);
            aVar.b.setPlaceHolder(1);
            return aVar;
        }
        return (a) invokeLI.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<ImMessageCenterShowItemData> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view2, viewGroup)) == null) {
            if (view2 != null && (view2.getTag() instanceof a)) {
                aVar = (a) view2.getTag();
            } else {
                aVar = null;
            }
            if (aVar == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.chat_list_item, viewGroup, false);
                aVar = b(view2, i);
                view2.setTag(aVar);
            }
            SkinManager.setBackgroundResource(view2, R.drawable.list_item_selector);
            SkinManager.setBackgroundResource(aVar.l, R.color.CAM_X0205);
            aVar.a.setVisibility(0);
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null) {
                o(aVar, item);
                m(aVar, item);
                q(aVar, item);
                r(aVar, item);
                k(aVar, item);
                s(aVar, item);
                v(aVar, item);
                if (this.d) {
                    n(aVar, item);
                }
                j(aVar, item);
                p(aVar, item);
                l(aVar, item);
                A(item);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void i(ImMessageCenterShowItemData imMessageCenterShowItemData, final a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, imMessageCenterShowItemData, aVar) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (d(imMessageCenterShowItemData)) {
                if (!StringUtils.isNull(imMessageCenterShowItemData.getSpecialMsgText())) {
                    SpannableString spannableString = new SpannableString(imMessageCenterShowItemData.getSpecialMsgText());
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, imMessageCenterShowItemData.getSpecialMsgText().length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) imMessageCenterShowItemData.getMsgContent());
                } else if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    String valueOf = String.valueOf(imMessageCenterShowItemData.getUnReadCount());
                    if (imMessageCenterShowItemData.getUnReadCount() >= 100) {
                        spannableStringBuilder.append((CharSequence) ("[99+]" + imMessageCenterShowItemData.getMsgContent()));
                    } else {
                        spannableStringBuilder.append((CharSequence) (PreferencesUtil.LEFT_MOUNT + valueOf + "条]" + imMessageCenterShowItemData.getMsgContent()));
                    }
                } else {
                    spannableStringBuilder.append((CharSequence) imMessageCenterShowItemData.getMsgContent());
                }
            } else {
                spannableStringBuilder.append((CharSequence) imMessageCenterShowItemData.getMsgContent());
            }
            aVar.g.setVisibility(0);
            aVar.j.setVisibility(0);
            e47.e(aVar.g.getContext(), spannableStringBuilder, UtilHelper.getDimenPixelSize(R.dimen.T_X06), new e47.i() { // from class: com.baidu.tieba.sc8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.e47.i
                public final void a(SpannableStringBuilder spannableStringBuilder2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder2) == null) {
                        vc8.a.this.g.setText(spannableStringBuilder2);
                    }
                }
            });
        }
    }

    public void j(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, aVar, imMessageCenterShowItemData) != null) || aVar == null) {
            return;
        }
        if (imMessageCenterShowItemData == null) {
            t(false, aVar);
        } else if (g(imMessageCenterShowItemData)) {
            if (d(imMessageCenterShowItemData)) {
                if (!imMessageCenterShowItemData.isNotify()) {
                    t(true, aVar);
                    return;
                } else {
                    t(false, aVar);
                    return;
                }
            }
            ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
            if (groupSetting == null) {
                t(false, aVar);
                return;
            }
            if (!groupSetting.isAcceptNotify()) {
                t(true, aVar);
            } else {
                t(false, aVar);
            }
            B(aVar, imMessageCenterShowItemData, !groupSetting.isAcceptNotify());
        } else {
            t(false, aVar);
        }
    }

    public void n(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, aVar, imMessageCenterShowItemData) != null) || aVar == null) {
            return;
        }
        if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getRelation() == 3) {
            aVar.m.setVisibility(0);
            d85 d = d85.d(aVar.m);
            d.o(R.string.J_X04);
            d.f(R.color.CAM_X0202);
            SkinManager.setViewTextColor((TextView) aVar.m.findViewById(R.id.my_fans_title), (int) R.color.CAM_X0108);
            return;
        }
        aVar.m.setVisibility(8);
    }

    public void q(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, aVar, imMessageCenterShowItemData) == null) && aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (h(imMessageCenterShowItemData)) {
                aVar.n.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    SkinManager.setBackgroundResource(aVar.n, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    SkinManager.setBackgroundResource(aVar.n, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.n.setVisibility(8);
                    return;
                }
            }
            aVar.n.setVisibility(8);
        }
    }

    public void o(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048595, this, aVar, imMessageCenterShowItemData) != null) || imMessageCenterShowItemData == null) {
            return;
        }
        if (d(imMessageCenterShowItemData) && !TextUtils.isEmpty(imMessageCenterShowItemData.getForumName())) {
            String forumName = imMessageCenterShowItemData.getForumName();
            String friendNameShow = imMessageCenterShowItemData.getFriendNameShow();
            if (forumName.length() > 8) {
                forumName = forumName.substring(0, 7) + "...";
            }
            y(aVar, forumName + "吧", friendNameShow);
            return;
        }
        aVar.e.setText(imMessageCenterShowItemData.getFriendNameShow());
    }

    public void p(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, aVar, imMessageCenterShowItemData) == null) {
            if (this.c) {
                aVar.o.setVisibility(0);
                aVar.h.setVisibility(8);
                if (imMessageCenterShowItemData.isSelected()) {
                    aVar.o.setBackgroundResource(R.drawable.btn_bgb_choice_s_new);
                    WebPManager.setPureDrawable(aVar.o, R.drawable.btn_bgb_choice_s_new, R.color.CAM_X0302, null);
                } else {
                    aVar.o.setBackgroundResource(R.drawable.btn_bgb_choice_n_new);
                    WebPManager.setPureDrawable(aVar.o, R.drawable.btn_bgb_choice_n_new, R.color.CAM_X0111, null);
                }
                SkinManager.setBackgroundColor(aVar.a, R.color.CAM_X0205);
                return;
            }
            aVar.o.setVisibility(8);
            aVar.h.setVisibility(0);
            TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void r(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, aVar, imMessageCenterShowItemData) == null) && aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = StringHelper.getChatTimeString(date);
            } else {
                str = "";
            }
            aVar.h.setText(str);
        }
    }

    public void s(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, aVar, imMessageCenterShowItemData) == null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            if (d(imMessageCenterShowItemData)) {
                unReadCount = 0;
            }
            if (unReadCount > 0) {
                if (pf5.d().f() == 0) {
                    unReadCount = 0;
                } else {
                    BasicNameValuePair z = z(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                    if (z != null && z.getName() != null && z.getName().length() > 0) {
                        unReadCount = wg.e(z.getName(), 0);
                    }
                }
                aVar.i.setThreeDotMode(2);
                aVar.i.f(unReadCount);
                aVar.i.setVisibility(0);
            } else if (d(imMessageCenterShowItemData) && imMessageCenterShowItemData.isNotify && imMessageCenterShowItemData.getUnReadCount() > 0) {
                aVar.i.setThreeDotMode(2);
                aVar.i.f(unReadCount);
                aVar.i.setVisibility(0);
            } else {
                aVar.i.setVisibility(8);
            }
            SkinManager.setViewTextColor(aVar.e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(aVar.g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(aVar.h, R.color.CAM_X0110, 1);
        }
    }
}
