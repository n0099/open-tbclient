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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarFeedActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
/* loaded from: classes7.dex */
public final class oy8 extends oq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment f;
    public HeadImageView g;
    public LinearLayout h;
    public TextView i;
    public TextView j;
    public TextView k;
    public MessageRedDotView l;
    public ImMessageCenterShowItemData m;
    public String n;
    public Map<String, Integer> o;
    public final Map<String, Integer> p;
    public final View.OnClickListener q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oy8(BaseFragment mRootFragment) {
        super(R.layout.obfuscated_res_0x7f0d0659);
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
        this.f = mRootFragment;
        this.n = "";
        this.o = new LinkedHashMap();
        this.p = new LinkedHashMap();
        this.q = new View.OnClickListener() { // from class: com.baidu.tieba.dy8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    oy8.Y(oy8.this, view2);
                }
            }
        };
    }

    public static final void Y(oy8 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.f.getContext() != null) {
                Context requireContext = this$0.f.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "mRootFragment.requireContext()");
                lz8.a.d(this$0.V(), requireContext);
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                String ownerName = this$0.V().getOwnerName();
                if (Intrinsics.areEqual(ownerName, "5")) {
                    TiebaStatic.log("c12931");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(requireContext)));
                } else if (Intrinsics.areEqual(ownerName, "8")) {
                    long j = JavaTypesHelper.toLong(this$0.V().getFriendId(), 0L);
                    OfficalBarChatActivityConfig officalBarChatActivityConfig = new OfficalBarChatActivityConfig(requireContext, j, this$0.V().getFriendNameShow(), this$0.V().getFriendPortrait(), 0, this$0.V().getUserType());
                    lz8.a.g(j);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, officalBarChatActivityConfig));
                }
                if (!TextUtils.isEmpty(this$0.V().getFriendName())) {
                    String friendName = this$0.V().getFriendName();
                    if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cd9))) {
                        statisticItem.param("obj_type", 8);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cdc))) {
                        statisticItem.param("obj_type", 9);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cda))) {
                        statisticItem.param("obj_type", 10);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cd5))) {
                        statisticItem.param("obj_type", 4);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cd7))) {
                        statisticItem.param("obj_type", 5);
                    }
                }
                TiebaStatic.log(statisticItem);
                lz8.a.b(this$0.V(), requireContext);
                if (this$0.V().getUnReadCount() > 0) {
                    this$0.V().setUnReadCount(0);
                    this$0.P(this$0.V());
                }
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g0((HeadImageView) k(R.id.obfuscated_res_0x7f0905e1));
            d0((LinearLayout) k(R.id.obfuscated_res_0x7f09060c));
            e0((TextView) k(R.id.obfuscated_res_0x7f09062b));
            b0((TextView) k(R.id.obfuscated_res_0x7f090573));
            c0((TextView) k(R.id.obfuscated_res_0x7f09060b));
            h0((MessageRedDotView) k(R.id.obfuscated_res_0x7f09060e));
        }
    }

    public final void P(ImMessageCenterShowItemData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            f0(data);
            U().setText(data.getFriendNameShow());
            R().setText(data.getMsgContent());
            if (data.getUnReadCount() > 0) {
                X().setVisibility(0);
                if (TextUtils.equals(data.getFriendNameShow(), this.n)) {
                    X().refresh("", false);
                } else {
                    X().refresh(data.getUnReadCount());
                }
            } else {
                X().setVisibility(8);
            }
            Q(data);
            Z(data);
        }
    }

    @Override // com.baidu.tieba.nq8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            W().setScaleType(ImageView.ScaleType.CENTER_CROP);
            EMManager.from(U()).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01);
            EMManager.from(R()).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(S()).setTextColor(R.color.CAM_X0111).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            Z(V());
        }
    }

    public final void Q(ImMessageCenterShowItemData imMessageCenterShowItemData) {
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
            S().setText(str);
        }
    }

    public final void Z(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Map<String, Integer> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, imMessageCenterShowItemData) == null) {
            if (TbadkApplication.getInst().getSkinType() == 4) {
                map = this.o;
            } else {
                map = this.p;
            }
            Integer num = map.get(imMessageCenterShowItemData.getFriendNameShow());
            if (num != null) {
                W().setImageResource(num.intValue());
            }
        }
    }

    public final TextView R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.j;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardAbs");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.k;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardMsgTime");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final LinearLayout T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinearLayout linearLayout = this.h;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardMsgView");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final TextView U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TextView textView = this.i;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardTitle");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImMessageCenterShowItemData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = this.m;
            if (imMessageCenterShowItemData != null) {
                return imMessageCenterShowItemData;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            return null;
        }
        return (ImMessageCenterShowItemData) invokeV.objValue;
    }

    public final HeadImageView W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HeadImageView headImageView = this.g;
            if (headImageView != null) {
                return headImageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mHeadView");
            return null;
        }
        return (HeadImageView) invokeV.objValue;
    }

    public final MessageRedDotView X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            MessageRedDotView messageRedDotView = this.l;
            if (messageRedDotView != null) {
                return messageRedDotView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            return null;
        }
        return (MessageRedDotView) invokeV.objValue;
    }

    public final void b0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.j = textView;
        }
    }

    public final void c0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.k = textView;
        }
    }

    public final void d0(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.h = linearLayout;
        }
    }

    public final void e0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.i = textView;
        }
    }

    public final void f0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, imMessageCenterShowItemData) == null) {
            Intrinsics.checkNotNullParameter(imMessageCenterShowItemData, "<set-?>");
            this.m = imMessageCenterShowItemData;
        }
    }

    public final void g0(HeadImageView headImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, headImageView) == null) {
            Intrinsics.checkNotNullParameter(headImageView, "<set-?>");
            this.g = headImageView;
        }
    }

    public final void h0(MessageRedDotView messageRedDotView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, messageRedDotView) == null) {
            Intrinsics.checkNotNullParameter(messageRedDotView, "<set-?>");
            this.l = messageRedDotView;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            X().setThreeDotMode(2);
            HeadImageView W = W();
            W.setOnClickListener(this.q);
            W.setConrers(15);
            W.setPlaceHolder(1);
            W.setAutoChangeStyle(true);
            W.setIsRound(true);
            W.setDrawBorder(true);
            T().setOnClickListener(this.q);
            U().setOnClickListener(this.q);
            R().setOnClickListener(this.q);
            S().setOnClickListener(this.q);
            String string = context.getResources().getString(R.string.obfuscated_res_0x7f0f0cd7);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ring.msg_tieba_broadcast)");
            this.n = string;
            Map<String, Integer> map = this.o;
            String string2 = context.getString(R.string.obfuscated_res_0x7f0f0cd7);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.msg_tieba_broadcast)");
            map.put(string2, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080cce));
            String string3 = context.getString(R.string.obfuscated_res_0x7f0f0cd6);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.msg_tieba_bazhu_notify)");
            map.put(string3, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080fdd));
            String string4 = context.getString(R.string.obfuscated_res_0x7f0f0cd8);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.msg_tieba_group_notify)");
            map.put(string4, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080932));
            String string5 = context.getString(R.string.obfuscated_res_0x7f0f0cdb);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri….msg_tieba_system_notify)");
            map.put(string5, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080cd0));
            String string6 = context.getString(R.string.obfuscated_res_0x7f0f0cdd);
            Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri….msg_tieba_zhanwu_notify)");
            map.put(string6, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d83));
            Map<String, Integer> map2 = this.p;
            String string7 = context.getString(R.string.obfuscated_res_0x7f0f0cd7);
            Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.string.msg_tieba_broadcast)");
            map2.put(string7, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ccd));
            String string8 = context.getString(R.string.obfuscated_res_0x7f0f0cd6);
            Intrinsics.checkNotNullExpressionValue(string8, "context.getString(R.string.msg_tieba_bazhu_notify)");
            map2.put(string8, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080fdc));
            String string9 = context.getString(R.string.obfuscated_res_0x7f0f0cd8);
            Intrinsics.checkNotNullExpressionValue(string9, "context.getString(R.string.msg_tieba_group_notify)");
            map2.put(string9, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080931));
            String string10 = context.getString(R.string.obfuscated_res_0x7f0f0cdb);
            Intrinsics.checkNotNullExpressionValue(string10, "context.getString(R.stri….msg_tieba_system_notify)");
            map2.put(string10, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ccf));
            String string11 = context.getString(R.string.obfuscated_res_0x7f0f0cdd);
            Intrinsics.checkNotNullExpressionValue(string11, "context.getString(R.stri….msg_tieba_zhanwu_notify)");
            map2.put(string11, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d82));
        }
    }
}
