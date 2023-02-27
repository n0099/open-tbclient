package com.baidu.tieba.immessagecenter.mention.base;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
import com.baidu.tieba.b35;
import com.baidu.tieba.dj;
import com.baidu.tieba.fy4;
import com.baidu.tieba.jw7;
import com.baidu.tieba.m59;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Agree;
/* loaded from: classes4.dex */
public class MessageCardBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ViewGroup b;
    public ImageView c;
    public TextView d;
    public ViewGroup e;
    public AgreeView f;
    public TextView g;
    public AgreeData h;
    public m59 i;
    public CustomMessageListener j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MessageCardBottomView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MessageCardBottomView messageCardBottomView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageCardBottomView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = messageCardBottomView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            m59 m59Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof m59) || (m59Var = (m59) customResponsedMessage.getData()) == null || (agreeData = m59Var.b) == null || this.a.h == null || TextUtils.isEmpty(this.a.h.postId) || TextUtils.isEmpty(agreeData.postId) || !this.a.h.postId.equals(agreeData.postId) || this.a.h.isInThread || this.a.i.a == m59Var.a) {
                return;
            }
            this.a.h.hasAgree = agreeData.hasAgree;
            this.a.h.agreeType = agreeData.agreeType;
            this.a.i();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MessageCardBottomView a;

        public b(MessageCardBottomView messageCardBottomView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageCardBottomView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = messageCardBottomView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.e();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MessageCardBottomView a;

        public c(MessageCardBottomView messageCardBottomView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageCardBottomView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = messageCardBottomView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageCardBottomView(Context context) {
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
        this.j = new a(this, 2016530);
        g(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
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
        this.j = new a(this, 2016530);
        g(context);
    }

    public void setData(String str, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) {
            if (!z && dj.isEmpty(str)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            ViewGroup viewGroup = this.b;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            viewGroup.setVisibility(i);
            ViewGroup viewGroup2 = this.e;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            viewGroup2.setVisibility(i2);
            if (dj.isEmpty(str)) {
                this.a.setVisibility(8);
                return;
            }
            this.a.setText(UtilHelper.getForumNameWithBar(str, 5, true));
            this.a.setVisibility(0);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            fy4 fy4Var = new fy4();
            fy4Var.b = 27;
            this.f.setStatisticData(fy4Var);
        }
    }

    public final void e() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (agreeView = this.f) != null) {
            agreeView.B = new c(this);
            this.f.N();
        }
    }

    public View getAgreeContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public View getReplyContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.j);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public final AgreeData f(jw7 jw7Var, int i) {
        InterceptResult invokeLI;
        Agree agree;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jw7Var, i)) == null) {
            AgreeData agreeData = new AgreeData();
            OriginalThreadInfo n = jw7Var.n();
            if (n != null && (agree = n.z) != null) {
                agreeData.parseProtobuf(agree);
            }
            this.f.getImgAgree().cancelAnimation();
            this.f.setNeedMatchStrategy(false);
            this.f.setUseDynamicLikeResImmediately();
            agreeData.postId = jw7Var.q();
            agreeData.threadId = jw7Var.x();
            agreeData.forumId = String.valueOf(jw7Var.f());
            if (jw7Var.g()) {
                agreeData.hasAgree = true;
                agreeData.agreeType = 2;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        agreeData.objType = 0;
                    } else {
                        agreeData.objType = 2;
                    }
                } else {
                    agreeData.objType = 1;
                }
            } else {
                agreeData.objType = 3;
            }
            agreeData.isInPost = true;
            return agreeData;
        }
        return (AgreeData) invokeLI.objValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05c3, (ViewGroup) this, true);
            this.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09165a);
            this.b = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09165c);
            this.c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09165d);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09165b);
            this.e = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091657);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091658);
            AgreeView agreeView = (AgreeView) inflate.findViewById(R.id.obfuscated_res_0x7f091659);
            this.f = agreeView;
            agreeView.getAgreeNumView().setVisibility(8);
            this.f.M(true);
            this.f.setAgreeAlone(true);
            this.e.setClickable(true);
            setClickable(true);
            this.e.setOnClickListener(new b(this));
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.c, R.drawable.icon_pure_card_comment20, R.color.CAM_X0107, null);
            b35 d = b35.d(this.d);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X08);
            d.v(R.color.CAM_X0107);
            AgreeView agreeView = this.f;
            if (agreeView != null) {
                agreeView.P(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void i() {
        AgreeData agreeData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (agreeData = this.h) == null) {
            return;
        }
        if (agreeData.hasAgree && agreeData.agreeType == 2) {
            this.g.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0284));
            b35 d = b35.d(this.g);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X08);
            d.v(R.color.CAM_X0301);
            return;
        }
        this.g.setText(getContext().getString(R.string.obfuscated_res_0x7f0f1517));
        b35 d2 = b35.d(this.g);
        d2.A(R.string.F_X01);
        d2.z(R.dimen.T_X08);
        d2.v(R.color.CAM_X0107);
    }

    public void setAgreeData(jw7 jw7Var, int i) {
        AgreeData agreeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, jw7Var, i) == null) {
            this.h = f(jw7Var, i);
            m59 m59Var = new m59();
            this.i = m59Var;
            m59Var.b = this.h;
            m59Var.a = BdUniqueId.gen();
            AgreeView agreeView = this.f;
            if (agreeView != null && (agreeData = this.h) != null) {
                agreeView.setData(agreeData);
                i();
                d();
                return;
            }
            this.e.setVisibility(8);
        }
    }
}
