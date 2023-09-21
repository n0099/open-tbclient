package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble;

import android.annotation.SuppressLint;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.lib.socket.msg.data.TopBubbleData;
import com.baidu.tieba.yh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TopBubbleView extends RelativeLayout implements View.OnClickListener, View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public int b;
    @Nullable
    public b c;

    /* loaded from: classes6.dex */
    public interface b {
        void a(View view2);

        void b(View view2);
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public FrameLayout b;
        public ImageView c;
        public TextView d;
        public LinearLayout e;
        public TextView f;
        public TextView g;
        public LinearLayout h;
        public TextView i;
        public ImageView j;

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
                aVar.b = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c96);
                aVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910f5);
                aVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c95);
                aVar.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c91);
                aVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c90);
                aVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c94);
                aVar.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c93);
                aVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c92);
                aVar.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910f4);
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopBubbleView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopBubbleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        this.b = 3;
        b(context);
    }

    public final void a(@NonNull TopBubbleData topBubbleData, TextView textView, TextView textView2, TextView textView3) {
        int ceil;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, topBubbleData, textView, textView2, textView3) == null) {
            int a2 = yh.a(TbadkApplication.getInst());
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            int dimenPixelSize2 = (((a2 - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2)) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X005) * 2)) - UtilHelper.getDimenPixelSize(R.dimen.tbds110)) - dimenPixelSize;
            if (topBubbleData.getActivityStatus() == 1) {
                ceil = (dimenPixelSize2 - ((int) Math.ceil(textView3.getPaint().measureText(UtilHelper.getString(R.string.obfuscated_res_0x7f0f0405))))) - dimenPixelSize;
            } else {
                ceil = (dimenPixelSize2 - ((int) Math.ceil(textView2.getPaint().measureText(topBubbleData.getSubContent())))) - UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
            }
            textView.setWidth(Math.min(ceil - (UtilHelper.getDimenPixelSize(R.dimen.tbds34) + dimenPixelSize), (int) Math.ceil(textView.getPaint().measureText(topBubbleData.getContent()))));
        }
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = a.a(LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d09b2, this));
            setOnClickListener(this);
            setOnLongClickListener(this);
            d();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && (bVar = this.c) != null) {
            bVar.b(view2);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(view2);
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setEventCallback(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.c = bVar;
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void c(@NonNull TopBubbleData topBubbleData) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, topBubbleData) == null) {
            setTag(R.id.obfuscated_res_0x7f0906cd, topBubbleData);
            String pinnedType = topBubbleData.getPinnedType();
            int hashCode = pinnedType.hashCode();
            if (hashCode != -1655966961) {
                if (hashCode != -1420194824) {
                    if (hashCode == -1039690024 && pinnedType.equals("notice")) {
                        c = 1;
                    }
                    c = 65535;
                } else {
                    if (pinnedType.equals(TopBubbleData.EXCELLENT)) {
                        c = 2;
                    }
                    c = 65535;
                }
            } else {
                if (pinnedType.equals("activity")) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        return;
                    }
                    this.a.d.setVisibility(0);
                    this.a.c.setVisibility(8);
                    this.a.d.setText(R.string.obfuscated_res_0x7f0f040d);
                    TextView textView = this.a.f;
                    textView.setText(topBubbleData.getUserName() + "：" + topBubbleData.getContent());
                } else {
                    this.a.d.setVisibility(0);
                    this.a.c.setVisibility(8);
                    this.a.d.setText(R.string.obfuscated_res_0x7f0f040e);
                    this.a.f.setText(topBubbleData.getContent());
                    TiebaStatic.log(new StatisticItem("c15200"));
                }
            } else {
                this.a.d.setVisibility(8);
                this.a.c.setVisibility(0);
                WebPManager.setMaskDrawable(this.a.c, R.drawable.obfuscated_res_0x7f0804d3, WebPManager.ResourceStateType.NORMAL);
                a aVar = this.a;
                a(topBubbleData, aVar.f, aVar.g, aVar.i);
                this.a.f.setText(topBubbleData.getContent());
                if (topBubbleData.getActivityStatus() == 1) {
                    this.a.g.setVisibility(8);
                    this.a.i.setText(R.string.obfuscated_res_0x7f0f0405);
                } else {
                    this.a.i.setVisibility(8);
                    this.a.g.setText(topBubbleData.getSubContent());
                }
            }
            int statusType = topBubbleData.getStatusType();
            if (statusType != 1) {
                if (statusType != 2) {
                    if (statusType != 3) {
                        this.a.j.setVisibility(8);
                    } else {
                        this.a.j.setVisibility(0);
                        WebPManager.setPureDrawable(this.a.j, R.drawable.obfuscated_res_0x7f080af2, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
                    }
                } else {
                    this.a.j.setVisibility(0);
                    WebPManager.setPureDrawable(this.a.j, R.drawable.obfuscated_res_0x7f0804e1, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
                }
            } else {
                this.a.j.setVisibility(0);
                WebPManager.setMaskDrawable(this.a.j, R.drawable.obfuscated_res_0x7f080625, WebPManager.ResourceStateType.NORMAL);
            }
            d();
        }
    }

    public void d() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b != (skinType = TbadkApplication.getInst().getSkinType())) {
            this.b = skinType;
            EMManager.from(this.a.d).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0303);
            EMManager.from(this.a.f).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X08);
            EMManager.from(this.a.g).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.a.a).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0207);
            EMManager.from(this.a.i).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109);
        }
    }
}
