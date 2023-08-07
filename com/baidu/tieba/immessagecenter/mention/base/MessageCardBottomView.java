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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
import com.baidu.tieba.bi;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.vo8;
import com.baidu.tieba.w05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Agree;
/* loaded from: classes6.dex */
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
    public AgreeMessageData i;
    public CustomMessageListener j;

    /* loaded from: classes6.dex */
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
            AgreeMessageData agreeMessageData;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof AgreeMessageData) || (agreeMessageData = (AgreeMessageData) customResponsedMessage.getData()) == null || (agreeData = agreeMessageData.agreeData) == null || this.a.h == null || TextUtils.isEmpty(this.a.h.postId) || TextUtils.isEmpty(agreeData.postId) || !this.a.h.postId.equals(agreeData.postId) || this.a.h.isInThread || this.a.i.uniqueId == agreeMessageData.uniqueId) {
                return;
            }
            this.a.h.hasAgree = agreeData.hasAgree;
            this.a.h.agreeType = agreeData.agreeType;
            this.a.i();
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            if (!z && bi.isEmpty(str)) {
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
            if (bi.isEmpty(str)) {
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
            w05 w05Var = new w05();
            w05Var.b = 27;
            this.f.setStatisticData(w05Var);
        }
    }

    public final void e() {
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (agreeView = this.f) != null) {
            agreeView.D = new c(this);
            this.f.O();
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

    public final AgreeData f(vo8 vo8Var, int i) {
        InterceptResult invokeLI;
        Agree agree;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, vo8Var, i)) == null) {
            AgreeData agreeData = new AgreeData();
            OriginalThreadInfo l = vo8Var.l();
            if (l != null && (agree = l.z) != null) {
                agreeData.parseProtobuf(agree);
            }
            this.f.getImgAgree().cancelAnimation();
            this.f.setNeedMatchStrategy(false);
            this.f.setUseDynamicLikeResImmediately();
            agreeData.postId = vo8Var.n();
            agreeData.threadId = vo8Var.v();
            agreeData.forumId = String.valueOf(vo8Var.e());
            if (vo8Var.f()) {
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0618, (ViewGroup) this, true);
            this.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091745);
            this.b = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091747);
            this.c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091748);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091746);
            this.e = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091742);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091743);
            AgreeView agreeView = (AgreeView) inflate.findViewById(R.id.obfuscated_res_0x7f091744);
            this.f = agreeView;
            agreeView.getAgreeNumView().setVisibility(8);
            this.f.N(true);
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
            EMManager.from(this.d).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0107);
            AgreeView agreeView = this.f;
            if (agreeView != null) {
                agreeView.Q(TbadkCoreApplication.getInst().getSkinType());
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
            this.g.setText(getContext().getString(R.string.obfuscated_res_0x7f0f02af));
            EMManager.from(this.g).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0301);
            return;
        }
        this.g.setText(getContext().getString(R.string.obfuscated_res_0x7f0f16a8));
        EMManager.from(this.g).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0107);
    }

    public void setAgreeData(vo8 vo8Var, int i) {
        AgreeData agreeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, vo8Var, i) == null) {
            this.h = f(vo8Var, i);
            AgreeMessageData agreeMessageData = new AgreeMessageData();
            this.i = agreeMessageData;
            agreeMessageData.agreeData = this.h;
            agreeMessageData.uniqueId = BdUniqueId.gen();
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
