package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.vi8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TopBubbleView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public RelativeLayout b;
        public LinearLayout c;
        public TextView d;
        public TextView e;
        public ConstraintLayout f;
        public ImageView g;
        public ImageView h;

        public a() {
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

        public static a a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                a aVar = new a();
                aVar.a = view2;
                aVar.f = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906ba);
                aVar.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09051e);
                aVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09051d);
                aVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09051b);
                aVar.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09051c);
                aVar.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906bb);
                aVar.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092187);
                return aVar;
            }
            return (a) invokeL.objValue;
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
            this.a = a.a(LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0998, this));
            b();
        }
    }

    public void setIconVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.a.g.setVisibility(0);
            } else {
                this.a.g.setVisibility(8);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMManager.from(this.a.d).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X10);
            EMManager.from(this.a.e).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X08);
            EMManager.from(this.a.f).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0207);
            EMManager.from(this.a.c).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0303);
            SkinManager.setViewTextColor(this.a.d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.a.e, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.a.c, (int) R.color.CAM_X0304);
            SkinManager.setImageResource(this.a.h, R.drawable.top_bubble_excellent_bg);
        }
    }

    public void c(@NonNull TopBubbleData topBubbleData, boolean z, boolean z2) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{topBubbleData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            setIconVisibility(true);
            TextView textView = this.a.d;
            if (z) {
                i = R.string.obfuscated_res_0x7f0f040b;
            } else {
                i = R.string.obfuscated_res_0x7f0f040a;
            }
            textView.setText(i);
            if (z) {
                if (z2) {
                    this.a.g.setVisibility(0);
                    this.a.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f0804d9);
                } else {
                    this.a.g.setVisibility(8);
                }
            } else if (!vi8.a(topBubbleData.getVersionKey())) {
                this.a.g.setVisibility(0);
                this.a.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f080614);
            } else {
                this.a.g.setVisibility(8);
            }
            TextView textView2 = this.a.e;
            if (z) {
                str = topBubbleData.getContent();
            } else {
                str = topBubbleData.getUserName() + "：" + topBubbleData.getContent();
            }
            textView2.setText(str);
            if (z) {
                TiebaStatic.log(new StatisticItem("c15200"));
            }
        }
    }

    public void setExcellentRead() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.g.getVisibility() == 0) {
            this.a.g.setVisibility(8);
        }
    }
}
