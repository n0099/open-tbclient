package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.uc6;
import com.baidu.tieba.x87;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public abstract class x87 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List b;
    public boolean c;
    public boolean d;

    public abstract boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract boolean f(ImMessageCenterShowItemData imMessageCenterShowItemData);

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i : invokeI.longValue;
    }

    public abstract void h(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData);

    public abstract BasicNameValuePair t(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str);

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;
        public HeadImageView b;
        public ImageView c;
        public BarImageView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public MessageRedDotView h;
        public View i;
        public LinearLayout j;
        public ImageView k;
        public ImageView l;

        public a(x87 x87Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x87Var};
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
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
        }
    }

    public x87(Context context) {
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

    public void i(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, aVar, imMessageCenterShowItemData) == null) {
            if (imMessageCenterShowItemData.getMarkTopIndex() > 0) {
                TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0206, R.color.CAM_X0204);
            } else {
                TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
            }
        }
    }

    public void l(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, aVar, imMessageCenterShowItemData) != null) || imMessageCenterShowItemData == null) {
            return;
        }
        aVar.e.setText(imMessageCenterShowItemData.getFriendNameShow());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ImMessageCenterShowItemData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List list = this.b;
            if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
                return null;
            }
            return (ImMessageCenterShowItemData) this.b.get(i);
        }
        return (ImMessageCenterShowItemData) invokeI.objValue;
    }

    public void r(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            if (this.b == null) {
                this.b = new LinkedList();
            }
            this.b = list;
            notifyDataSetChanged();
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.c = z;
        }
    }

    public a b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            a aVar = new a(this);
            aVar.a = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09060f);
            aVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fc1);
            aVar.b = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09060d);
            aVar.d = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090a79);
            aVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090613);
            aVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09124b);
            aVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090614);
            aVar.i = view2.findViewById(R.id.obfuscated_res_0x7f0912fc);
            MessageRedDotView messageRedDotView = (MessageRedDotView) view2.findViewById(R.id.obfuscated_res_0x7f09167f);
            aVar.h = messageRedDotView;
            messageRedDotView.setShadowEnabled(false);
            aVar.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0915b7);
            aVar.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e5a);
            aVar.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091e4f);
            aVar.b.setPlaceHolder(1);
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void g(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, aVar, imMessageCenterShowItemData) != null) || aVar == null) {
            return;
        }
        if (imMessageCenterShowItemData == null) {
            q(false, aVar);
        } else if (e(imMessageCenterShowItemData)) {
            ChatSetting groupSetting = imMessageCenterShowItemData.getGroupSetting();
            if (groupSetting == null) {
                q(false, aVar);
            } else if (!groupSetting.isAcceptNotify()) {
                q(true, aVar);
            } else {
                q(false, aVar);
            }
        } else {
            q(false, aVar);
        }
    }

    public void j(final a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, aVar, imMessageCenterShowItemData) == null) {
            if (TextUtils.isEmpty(imMessageCenterShowItemData.getMsgContent())) {
                aVar.f.setText("");
            } else {
                uc6.e(aVar.f.getContext(), imMessageCenterShowItemData.getMsgContent(), new uc6.h() { // from class: com.baidu.tieba.u87
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.uc6.h
                    public final void a(SpannableStringBuilder spannableStringBuilder) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder) == null) {
                            x87.a.this.f.setText(spannableStringBuilder);
                        }
                    }
                });
            }
        }
    }

    public void o(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, aVar, imMessageCenterShowItemData) == null) && aVar != null && imMessageCenterShowItemData != null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = StringHelper.getChatTimeString(date);
            } else {
                str = "";
            }
            aVar.g.setText(str);
        }
    }

    public final void q(boolean z, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048595, this, z, aVar) == null) {
            if (z) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080619, R.color.CAM_X1111, SvgManager.SvgResourceStateType.NORMAL);
                pureDrawable.setBounds(new Rect(0, 0, fj.f(this.a, R.dimen.tbds34), fj.f(this.a, R.dimen.tbds34)));
                aVar.f.setCompoundDrawables(null, null, pureDrawable, null);
                return;
            }
            aVar.f.setCompoundDrawables(null, null, null, null);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            if (view2 != null && (view2.getTag() instanceof a)) {
                aVar = (a) view2.getTag();
            } else {
                aVar = null;
            }
            if (aVar == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d01d3, viewGroup, false);
                aVar = b(view2);
                view2.setTag(aVar);
            }
            SkinManager.setBackgroundResource(view2, R.drawable.list_item_selector);
            SkinManager.setBackgroundResource(aVar.i, R.color.CAM_X0205);
            aVar.a.setVisibility(0);
            ImMessageCenterShowItemData item = getItem(i);
            if (item != null) {
                l(aVar, item);
                j(aVar, item);
                n(aVar, item);
                o(aVar, item);
                h(aVar, item);
                p(aVar, item);
                if (this.d) {
                    k(aVar, item);
                }
                g(aVar, item);
                m(aVar, item);
                i(aVar, item);
                u(item);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void k(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, aVar, imMessageCenterShowItemData) != null) || aVar == null) {
            return;
        }
        if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getRelation() == 3) {
            aVar.j.setVisibility(0);
            nv4 d = nv4.d(aVar.j);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0202);
            SkinManager.setViewTextColor((TextView) aVar.j.findViewById(R.id.obfuscated_res_0x7f0915b8), (int) R.color.CAM_X0108);
            return;
        }
        aVar.j.setVisibility(8);
    }

    public void n(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, aVar, imMessageCenterShowItemData) == null) && aVar != null && imMessageCenterShowItemData != null && imMessageCenterShowItemData.getOwnerName() != null) {
            if (f(imMessageCenterShowItemData)) {
                aVar.k.setVisibility(0);
                if (imMessageCenterShowItemData.getSendStatus() == 2) {
                    SkinManager.setBackgroundResource(aVar.k, R.drawable.icon_send_failed_information);
                    return;
                } else if (imMessageCenterShowItemData.getSendStatus() == 1) {
                    SkinManager.setBackgroundResource(aVar.k, R.drawable.icon_send_in_information);
                    return;
                } else {
                    aVar.k.setVisibility(8);
                    return;
                }
            }
            aVar.k.setVisibility(8);
        }
    }

    public void m(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, aVar, imMessageCenterShowItemData) == null) {
            if (this.c) {
                aVar.l.setVisibility(0);
                aVar.g.setVisibility(8);
                if (imMessageCenterShowItemData.isSelected()) {
                    aVar.l.setBackgroundResource(R.drawable.obfuscated_res_0x7f08035c);
                    WebPManager.setPureDrawable(aVar.l, R.drawable.obfuscated_res_0x7f08035c, R.color.CAM_X0302, null);
                } else {
                    aVar.l.setBackgroundResource(R.drawable.obfuscated_res_0x7f08035a);
                    WebPManager.setPureDrawable(aVar.l, R.drawable.obfuscated_res_0x7f08035a, R.color.CAM_X0111, null);
                }
                SkinManager.setBackgroundColor(aVar.a, R.color.CAM_X0205);
                return;
            }
            aVar.l.setVisibility(8);
            aVar.g.setVisibility(0);
            TBSelector.setViewBackgroundColorWithPressedState(aVar.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    public void p(a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, aVar, imMessageCenterShowItemData) == null) {
            int unReadCount = imMessageCenterShowItemData.getUnReadCount();
            if (unReadCount > 0) {
                if (q25.d().f() == 0) {
                    unReadCount = 0;
                } else {
                    BasicNameValuePair t = t(imMessageCenterShowItemData, unReadCount, String.valueOf(unReadCount));
                    if (t != null && t.getName() != null && t.getName().length() > 0) {
                        unReadCount = eh.e(t.getName(), 0);
                    }
                }
                aVar.h.setThreeDotMode(2);
                aVar.h.f(unReadCount);
                aVar.h.setVisibility(0);
            } else {
                aVar.h.setVisibility(8);
            }
            SkinManager.setViewTextColor(aVar.e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(aVar.f, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(aVar.g, R.color.CAM_X0110, 1);
        }
    }

    public final void u(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, imMessageCenterShowItemData) != null) || imMessageCenterShowItemData == null) {
            return;
        }
        int i = 0;
        int i2 = 2;
        if (TextUtils.equals("4", imMessageCenterShowItemData.getOwnerName())) {
            i = 1;
        } else if (TextUtils.equals("7", imMessageCenterShowItemData.getOwnerName())) {
            i = 2;
        }
        if (i > 0) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount());
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                i2 = 1;
            }
            TiebaStatic.log(param.param("obj_type", i2).param("obj_locate", i).param("obj_param1", imMessageCenterShowItemData.getUnReadCount()));
        }
        if (CommonStatisticKey.TbMemberOfficialStatic.TB_MEMBER_OFFICIAL_ID.equals(imMessageCenterShowItemData.getFriendId())) {
            CommonStatisticUtils.staticTbMemberNotify(CommonStatisticKey.TbMemberOfficialStatic.MEMBER_MSG_CENTER_NOTIFY_SHOW, null, imMessageCenterShowItemData.getFriendName());
        }
    }
}
