package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarFeedActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class un8 extends td8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment e;
    public HeadImageView f;
    public LinearLayout g;
    public TextView h;
    public TextView i;
    public TextView j;
    public MessageRedDotView k;
    public ImMessageCenterShowItemData l;
    public String m;
    public Map<String, Integer> n;
    public final Map<String, Integer> o;
    public final View.OnClickListener p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public un8(BaseFragment mRootFragment) {
        super(R.layout.obfuscated_res_0x7f0d0632);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mRootFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mRootFragment, "mRootFragment");
        this.e = mRootFragment;
        this.m = "";
        this.n = new LinkedHashMap();
        this.o = new LinkedHashMap();
        this.p = new View.OnClickListener() { // from class: com.baidu.tieba.in8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    un8.X(un8.this, view2);
                }
            }
        };
    }

    public static final void X(un8 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.e.getContext() != null) {
                Context requireContext = this$0.e.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "mRootFragment.requireContext()");
                uo8.a.d(this$0.U(), requireContext);
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                String ownerName = this$0.U().getOwnerName();
                if (Intrinsics.areEqual(ownerName, "5")) {
                    TiebaStatic.log("c12931");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(requireContext)));
                } else if (Intrinsics.areEqual(ownerName, "8")) {
                    long g = vg.g(this$0.U().getFriendId(), 0L);
                    OfficalBarChatActivityConfig officalBarChatActivityConfig = new OfficalBarChatActivityConfig(requireContext, g, this$0.U().getFriendNameShow(), this$0.U().getFriendPortrait(), 0, this$0.U().getUserType());
                    uo8.a.g(g);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, officalBarChatActivityConfig));
                }
                if (!TextUtils.isEmpty(this$0.U().getFriendName())) {
                    String friendName = this$0.U().getFriendName();
                    if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cac))) {
                        statisticItem.param("obj_type", 8);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0caf))) {
                        statisticItem.param("obj_type", 9);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cad))) {
                        statisticItem.param("obj_type", 10);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0ca8))) {
                        statisticItem.param("obj_type", 4);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0caa))) {
                        statisticItem.param("obj_type", 5);
                    }
                }
                TiebaStatic.log(statisticItem);
                uo8.a.b(this$0.U(), requireContext);
                if (this$0.U().getUnReadCount() > 0) {
                    this$0.U().setUnReadCount(0);
                    this$0.N(this$0.U());
                }
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e0((HeadImageView) g(R.id.obfuscated_res_0x7f0905d2));
            b0((LinearLayout) g(R.id.obfuscated_res_0x7f0905fd));
            c0((TextView) g(R.id.obfuscated_res_0x7f09061b));
            Z((TextView) g(R.id.obfuscated_res_0x7f090565));
            a0((TextView) g(R.id.obfuscated_res_0x7f0905fc));
            f0((MessageRedDotView) g(R.id.obfuscated_res_0x7f0905ff));
        }
    }

    public final void N(ImMessageCenterShowItemData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            d0(data);
            T().setText(data.getFriendNameShow());
            Q().setText(data.getMsgContent());
            if (data.getUnReadCount() > 0) {
                W().setVisibility(0);
                if (TextUtils.equals(data.getFriendNameShow(), this.m)) {
                    W().g("", false);
                } else {
                    W().f(data.getUnReadCount());
                }
            } else {
                W().setVisibility(8);
            }
            O(data);
            Y(data);
        }
    }

    @Override // com.baidu.tieba.sd8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            V().setScaleType(ImageView.ScaleType.CENTER_CROP);
            s75 d = s75.d(T());
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X05);
            d.D(R.string.F_X01);
            s75 d2 = s75.d(Q());
            d2.x(R.color.CAM_X0109);
            d2.C(R.dimen.T_X08);
            d2.D(R.string.F_X01);
            s75 d3 = s75.d(R());
            d3.x(R.color.CAM_X0111);
            d3.C(R.dimen.T_X09);
            d3.D(R.string.F_X01);
            Y(U());
        }
    }

    public final void O(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterShowItemData) == null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = StringHelper.getChatTimeString(date);
            } else {
                str = "";
            }
            R().setText(str);
        }
    }

    public final void Y(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Map<String, Integer> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, imMessageCenterShowItemData) == null) {
            if (TbadkApplication.getInst().getSkinType() == 4) {
                map = this.n;
            } else {
                map = this.o;
            }
            Integer num = map.get(imMessageCenterShowItemData.getFriendNameShow());
            if (num != null) {
                V().setImageResource(num.intValue());
            }
        }
    }

    public final TextView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.i;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardAbs");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.j;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardMsgTime");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final LinearLayout S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinearLayout linearLayout = this.g;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardMsgView");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final TextView T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TextView textView = this.h;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardTitle");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImMessageCenterShowItemData U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = this.l;
            if (imMessageCenterShowItemData != null) {
                return imMessageCenterShowItemData;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            return null;
        }
        return (ImMessageCenterShowItemData) invokeV.objValue;
    }

    public final HeadImageView V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HeadImageView headImageView = this.f;
            if (headImageView != null) {
                return headImageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mHeadView");
            return null;
        }
        return (HeadImageView) invokeV.objValue;
    }

    public final MessageRedDotView W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            MessageRedDotView messageRedDotView = this.k;
            if (messageRedDotView != null) {
                return messageRedDotView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            return null;
        }
        return (MessageRedDotView) invokeV.objValue;
    }

    public final void Z(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.i = textView;
        }
    }

    public final void a0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.j = textView;
        }
    }

    public final void b0(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.g = linearLayout;
        }
    }

    public final void c0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.h = textView;
        }
    }

    public final void d0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, imMessageCenterShowItemData) == null) {
            Intrinsics.checkNotNullParameter(imMessageCenterShowItemData, "<set-?>");
            this.l = imMessageCenterShowItemData;
        }
    }

    public final void e0(HeadImageView headImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, headImageView) == null) {
            Intrinsics.checkNotNullParameter(headImageView, "<set-?>");
            this.f = headImageView;
        }
    }

    public final void f0(MessageRedDotView messageRedDotView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, messageRedDotView) == null) {
            Intrinsics.checkNotNullParameter(messageRedDotView, "<set-?>");
            this.k = messageRedDotView;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            W().setThreeDotMode(2);
            HeadImageView V = V();
            V.setOnClickListener(this.p);
            V.setConrers(15);
            V.setPlaceHolder(1);
            V.setAutoChangeStyle(true);
            V.setIsRound(true);
            V.setDrawBorder(true);
            S().setOnClickListener(this.p);
            T().setOnClickListener(this.p);
            Q().setOnClickListener(this.p);
            R().setOnClickListener(this.p);
            String string = context.getResources().getString(R.string.obfuscated_res_0x7f0f0caa);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ring.msg_tieba_broadcast)");
            this.m = string;
            Map<String, Integer> map = this.n;
            String string2 = context.getString(R.string.obfuscated_res_0x7f0f0caa);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.msg_tieba_broadcast)");
            map.put(string2, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c99));
            String string3 = context.getString(R.string.obfuscated_res_0x7f0f0ca9);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.msg_tieba_bazhu_notify)");
            map.put(string3, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080fa2));
            String string4 = context.getString(R.string.obfuscated_res_0x7f0f0cab);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.msg_tieba_group_notify)");
            map.put(string4, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080916));
            String string5 = context.getString(R.string.obfuscated_res_0x7f0f0cae);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri….msg_tieba_system_notify)");
            map.put(string5, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c9b));
            String string6 = context.getString(R.string.obfuscated_res_0x7f0f0cb0);
            Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri….msg_tieba_zhanwu_notify)");
            map.put(string6, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d51));
            Map<String, Integer> map2 = this.o;
            String string7 = context.getString(R.string.obfuscated_res_0x7f0f0caa);
            Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.string.msg_tieba_broadcast)");
            map2.put(string7, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c98));
            String string8 = context.getString(R.string.obfuscated_res_0x7f0f0ca9);
            Intrinsics.checkNotNullExpressionValue(string8, "context.getString(R.string.msg_tieba_bazhu_notify)");
            map2.put(string8, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080fa1));
            String string9 = context.getString(R.string.obfuscated_res_0x7f0f0cab);
            Intrinsics.checkNotNullExpressionValue(string9, "context.getString(R.string.msg_tieba_group_notify)");
            map2.put(string9, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080915));
            String string10 = context.getString(R.string.obfuscated_res_0x7f0f0cae);
            Intrinsics.checkNotNullExpressionValue(string10, "context.getString(R.stri….msg_tieba_system_notify)");
            map2.put(string10, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080c9a));
            String string11 = context.getString(R.string.obfuscated_res_0x7f0f0cb0);
            Intrinsics.checkNotNullExpressionValue(string11, "context.getString(R.stri….msg_tieba_zhanwu_notify)");
            map2.put(string11, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d50));
        }
    }
}
