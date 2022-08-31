package com.baidu.tieba.imMessageCenter.mention.base;

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
import com.baidu.tieba.mo4;
import com.baidu.tieba.ns4;
import com.baidu.tieba.oc7;
import com.baidu.tieba.qi;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.xk8;
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
    public xk8 i;
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
            xk8 xk8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof xk8) || (xk8Var = (xk8) customResponsedMessage.getData()) == null || (agreeData = xk8Var.b) == null || this.a.h == null || TextUtils.isEmpty(this.a.h.postId) || TextUtils.isEmpty(agreeData.postId) || !this.a.h.postId.equals(agreeData.postId) || this.a.h.isInThread || this.a.i.a == xk8Var.a) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e();
            }
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

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            mo4 mo4Var = new mo4();
            mo4Var.b = 27;
            this.f.setStatisticData(mo4Var);
        }
    }

    public final void e() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (agreeView = this.f) == null) {
            return;
        }
        agreeView.x = new c(this);
        this.f.J();
    }

    public final AgreeData f(oc7 oc7Var, int i) {
        InterceptResult invokeLI;
        Agree agree;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, oc7Var, i)) == null) {
            AgreeData agreeData = new AgreeData();
            OriginalThreadInfo r = oc7Var.r();
            if (r != null && (agree = r.z) != null) {
                agreeData.parseProtobuf(agree);
            }
            this.f.getImgAgree().cancelAnimation();
            this.f.setNeedMatchStrategy(false);
            this.f.setUseDynamicLikeResImmediately();
            agreeData.postId = oc7Var.t();
            agreeData.threadId = oc7Var.E();
            agreeData.forumId = String.valueOf(oc7Var.f());
            if (oc7Var.h()) {
                agreeData.hasAgree = true;
                agreeData.agreeType = 2;
            }
            if (i == 1) {
                agreeData.objType = 3;
            } else if (i == 2) {
                agreeData.objType = 1;
            } else if (i != 3) {
                agreeData.objType = 0;
            } else {
                agreeData.objType = 2;
            }
            agreeData.isInPost = true;
            return agreeData;
        }
        return (AgreeData) invokeLI.objValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0576, (ViewGroup) this, true);
            this.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914f5);
            this.b = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0914f7);
            this.c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0914f8);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914f6);
            this.e = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0914f2);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914f3);
            AgreeView agreeView = (AgreeView) inflate.findViewById(R.id.obfuscated_res_0x7f0914f4);
            this.f = agreeView;
            agreeView.getAgreeNumView().setVisibility(8);
            this.f.I(true);
            this.f.setAgreeAlone(true);
            this.e.setClickable(true);
            setClickable(true);
            this.e.setOnClickListener(new b(this));
        }
    }

    public View getAgreeContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public View getReplyContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.c, R.drawable.obfuscated_res_0x7f080915, R.color.CAM_X0107, null);
            ns4 d = ns4.d(this.d);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X08);
            d.v(R.color.CAM_X0107);
            AgreeView agreeView = this.f;
            if (agreeView != null) {
                agreeView.L(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void i() {
        AgreeData agreeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (agreeData = this.h) == null) {
            return;
        }
        if (agreeData.hasAgree && agreeData.agreeType == 2) {
            this.g.setText(getContext().getString(R.string.obfuscated_res_0x7f0f027b));
            ns4 d = ns4.d(this.g);
            d.A(R.string.F_X01);
            d.z(R.dimen.T_X08);
            d.v(R.color.CAM_X0301);
            return;
        }
        this.g.setText(getContext().getString(R.string.obfuscated_res_0x7f0f142b));
        ns4 d2 = ns4.d(this.g);
        d2.A(R.string.F_X01);
        d2.z(R.dimen.T_X08);
        d2.v(R.color.CAM_X0107);
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

    public void setAgreeData(oc7 oc7Var, int i) {
        AgreeData agreeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, oc7Var, i) == null) {
            this.h = f(oc7Var, i);
            xk8 xk8Var = new xk8();
            this.i = xk8Var;
            xk8Var.b = this.h;
            xk8Var.a = BdUniqueId.gen();
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

    public void setData(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) {
            if (!z && qi.isEmpty(str)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.b.setVisibility(z ? 0 : 8);
            this.e.setVisibility(z ? 0 : 8);
            if (qi.isEmpty(str)) {
                this.a.setVisibility(8);
                return;
            }
            this.a.setText(UtilHelper.getForumNameWithBar(str, 5, true));
            this.a.setVisibility(0);
        }
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
}
