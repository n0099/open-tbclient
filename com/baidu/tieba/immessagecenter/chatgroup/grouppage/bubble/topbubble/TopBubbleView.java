package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.n15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TopBubbleView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatFragment a;
        public final /* synthetic */ TopBubbleData b;
        public final /* synthetic */ TopBubbleView c;

        public a(TopBubbleView topBubbleView, GroupChatFragment groupChatFragment, TopBubbleData topBubbleData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topBubbleView, groupChatFragment, topBubbleData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = topBubbleView;
            this.a = groupChatFragment;
            this.b = topBubbleData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d2();
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), null, this.b.getJumpTo(), true);
                tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                TiebaStatic.log(new StatisticItem("c15201"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public LinearLayout b;
        public LinearLayout c;
        public TextView d;
        public TextView e;
        public ConstraintLayout f;
        public TbImageView g;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static b a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                b bVar = new b();
                bVar.a = view2;
                bVar.f = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f09067f);
                bVar.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904ef);
                bVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904ee);
                bVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904ec);
                bVar.g = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0904ed);
                bVar.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090680);
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopBubbleView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopBubbleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopBubbleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = b.a(LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d090c, this));
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            n15 d = n15.d(this.a.d);
            d.w(R.color.CAM_X0101);
            d.B(R.string.F_X01);
            d.A(R.dimen.T_X10);
            n15 d2 = n15.d(this.a.e);
            d2.B(R.string.F_X01);
            d2.w(R.color.CAM_X0107);
            d2.A(R.dimen.T_X08);
            n15 d3 = n15.d(this.a.f);
            d3.m(R.dimen.L_X02);
            d3.o(R.string.J_X05);
            d3.f(R.color.CAM_X0207);
            n15 d4 = n15.d(this.a.c);
            d4.o(R.string.J_X04);
            d4.f(R.color.CAM_X0304);
            SkinManager.setViewTextColor(this.a.d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.a.e, (int) R.color.CAM_X0107);
            SkinManager.setImageResource(this.a.g, R.drawable.obfuscated_res_0x7f080471);
            SkinManager.setViewTextColor(this.a.c, (int) R.color.CAM_X0304);
            SkinManager.setBackgroundResource(this.a.b, R.drawable.pic_mask_chat_notice_bg);
        }
    }

    public void c(@NonNull TopBubbleData topBubbleData, GroupChatFragment groupChatFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, topBubbleData, groupChatFragment) == null) && topBubbleData != null) {
            groupChatFragment.w2(0);
            this.a.b.setVisibility(0);
            if ("notice".equals(topBubbleData.getTopBubbleType())) {
                this.a.d.setText(R.string.obfuscated_res_0x7f0f03ca);
            }
            this.a.e.setText(topBubbleData.getContent());
            TiebaStatic.log(new StatisticItem("c15200"));
            this.a.f.setOnClickListener(new a(this, groupChatFragment, topBubbleData));
        }
    }
}
