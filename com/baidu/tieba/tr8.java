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
/* loaded from: classes8.dex */
public final class tr8 extends ig8 {
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
    public tr8(BaseFragment mRootFragment) {
        super(R.layout.obfuscated_res_0x7f0d0642);
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
        this.p = new View.OnClickListener() { // from class: com.baidu.tieba.hr8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    tr8.Z(tr8.this, view2);
                }
            }
        };
    }

    public static final void Z(tr8 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.e.getContext() != null) {
                Context requireContext = this$0.e.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "mRootFragment.requireContext()");
                ss8.a.d(this$0.W(), requireContext);
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                String ownerName = this$0.W().getOwnerName();
                if (Intrinsics.areEqual(ownerName, "5")) {
                    TiebaStatic.log("c12931");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(requireContext)));
                } else if (Intrinsics.areEqual(ownerName, "8")) {
                    long j = JavaTypesHelper.toLong(this$0.W().getFriendId(), 0L);
                    OfficalBarChatActivityConfig officalBarChatActivityConfig = new OfficalBarChatActivityConfig(requireContext, j, this$0.W().getFriendNameShow(), this$0.W().getFriendPortrait(), 0, this$0.W().getUserType());
                    ss8.a.g(j);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, officalBarChatActivityConfig));
                }
                if (!TextUtils.isEmpty(this$0.W().getFriendName())) {
                    String friendName = this$0.W().getFriendName();
                    if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cb9))) {
                        statisticItem.param("obj_type", 8);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cbc))) {
                        statisticItem.param("obj_type", 9);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cba))) {
                        statisticItem.param("obj_type", 10);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cb5))) {
                        statisticItem.param("obj_type", 4);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cb7))) {
                        statisticItem.param("obj_type", 5);
                    }
                }
                TiebaStatic.log(statisticItem);
                ss8.a.b(this$0.W(), requireContext);
                if (this$0.W().getUnReadCount() > 0) {
                    this$0.W().setUnReadCount(0);
                    this$0.Q(this$0.W());
                }
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g0((HeadImageView) j(R.id.obfuscated_res_0x7f0905e1));
            d0((LinearLayout) j(R.id.obfuscated_res_0x7f09060c));
            e0((TextView) j(R.id.obfuscated_res_0x7f09062a));
            b0((TextView) j(R.id.obfuscated_res_0x7f090573));
            c0((TextView) j(R.id.obfuscated_res_0x7f09060b));
            h0((MessageRedDotView) j(R.id.obfuscated_res_0x7f09060e));
        }
    }

    public final void Q(ImMessageCenterShowItemData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            f0(data);
            V().setText(data.getFriendNameShow());
            S().setText(data.getMsgContent());
            if (data.getUnReadCount() > 0) {
                Y().setVisibility(0);
                if (TextUtils.equals(data.getFriendNameShow(), this.m)) {
                    Y().refresh("", false);
                } else {
                    Y().refresh(data.getUnReadCount());
                }
            } else {
                Y().setVisibility(8);
            }
            R(data);
            a0(data);
        }
    }

    @Override // com.baidu.tieba.hg8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            X().setScaleType(ImageView.ScaleType.CENTER_CROP);
            EMManager.from(V()).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01);
            EMManager.from(S()).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(T()).setTextColor(R.color.CAM_X0111).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            a0(W());
        }
    }

    public final void R(ImMessageCenterShowItemData imMessageCenterShowItemData) {
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
            T().setText(str);
        }
    }

    public final void a0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
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
                X().setImageResource(num.intValue());
            }
        }
    }

    public final TextView S() {
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

    public final TextView T() {
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

    public final LinearLayout U() {
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

    public final TextView V() {
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

    public final ImMessageCenterShowItemData W() {
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

    public final HeadImageView X() {
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

    public final MessageRedDotView Y() {
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

    public final void b0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.i = textView;
        }
    }

    public final void c0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.j = textView;
        }
    }

    public final void d0(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.g = linearLayout;
        }
    }

    public final void e0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.h = textView;
        }
    }

    public final void f0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, imMessageCenterShowItemData) == null) {
            Intrinsics.checkNotNullParameter(imMessageCenterShowItemData, "<set-?>");
            this.l = imMessageCenterShowItemData;
        }
    }

    public final void g0(HeadImageView headImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, headImageView) == null) {
            Intrinsics.checkNotNullParameter(headImageView, "<set-?>");
            this.f = headImageView;
        }
    }

    public final void h0(MessageRedDotView messageRedDotView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, messageRedDotView) == null) {
            Intrinsics.checkNotNullParameter(messageRedDotView, "<set-?>");
            this.k = messageRedDotView;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Y().setThreeDotMode(2);
            HeadImageView X = X();
            X.setOnClickListener(this.p);
            X.setConrers(15);
            X.setPlaceHolder(1);
            X.setAutoChangeStyle(true);
            X.setIsRound(true);
            X.setDrawBorder(true);
            U().setOnClickListener(this.p);
            V().setOnClickListener(this.p);
            S().setOnClickListener(this.p);
            T().setOnClickListener(this.p);
            String string = context.getResources().getString(R.string.obfuscated_res_0x7f0f0cb7);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ring.msg_tieba_broadcast)");
            this.m = string;
            Map<String, Integer> map = this.n;
            String string2 = context.getString(R.string.obfuscated_res_0x7f0f0cb7);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.msg_tieba_broadcast)");
            map.put(string2, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080caa));
            String string3 = context.getString(R.string.obfuscated_res_0x7f0f0cb6);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.msg_tieba_bazhu_notify)");
            map.put(string3, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080fb5));
            String string4 = context.getString(R.string.obfuscated_res_0x7f0f0cb8);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.msg_tieba_group_notify)");
            map.put(string4, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080916));
            String string5 = context.getString(R.string.obfuscated_res_0x7f0f0cbb);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri….msg_tieba_system_notify)");
            map.put(string5, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080cac));
            String string6 = context.getString(R.string.obfuscated_res_0x7f0f0cbd);
            Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri….msg_tieba_zhanwu_notify)");
            map.put(string6, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d62));
            Map<String, Integer> map2 = this.o;
            String string7 = context.getString(R.string.obfuscated_res_0x7f0f0cb7);
            Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.string.msg_tieba_broadcast)");
            map2.put(string7, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ca9));
            String string8 = context.getString(R.string.obfuscated_res_0x7f0f0cb6);
            Intrinsics.checkNotNullExpressionValue(string8, "context.getString(R.string.msg_tieba_bazhu_notify)");
            map2.put(string8, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080fb4));
            String string9 = context.getString(R.string.obfuscated_res_0x7f0f0cb8);
            Intrinsics.checkNotNullExpressionValue(string9, "context.getString(R.string.msg_tieba_group_notify)");
            map2.put(string9, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080915));
            String string10 = context.getString(R.string.obfuscated_res_0x7f0f0cbb);
            Intrinsics.checkNotNullExpressionValue(string10, "context.getString(R.stri….msg_tieba_system_notify)");
            map2.put(string10, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080cab));
            String string11 = context.getString(R.string.obfuscated_res_0x7f0f0cbd);
            Intrinsics.checkNotNullExpressionValue(string11, "context.getString(R.stri….msg_tieba_zhanwu_notify)");
            map2.put(string11, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d61));
        }
    }
}
