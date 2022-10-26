package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.i87;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.xd7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MsgReplyCardView extends i87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MsgReplyCardView a;

        public a(MsgReplyCardView msgReplyCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgReplyCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = msgReplyCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b.q(view2, 14, this.a.f, 0L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgReplyCardView(TbPageContext tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d05a5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a0();
    }

    public final String Z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 1) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f085d);
            }
            if (i == 2) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f11a7);
            }
            return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f137a);
        }
        return (String) invokeI.objValue;
    }

    private String getType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            if (i == 1) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f00c5);
            }
            return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1484);
        }
        return (String) invokeI.objValue;
    }

    public final String X(xd7.a aVar, String str) {
        InterceptResult invokeLL;
        String Z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                Z = this.mContext.getString(R.string.obfuscated_res_0x7f0f0ad1);
            } else {
                Z = Z(aVar.a);
            }
            if (aVar.h == 1) {
                sb.append(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00c2), Z));
                sb.append(aVar.c);
            } else {
                sb.append(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00c3), Z));
                sb.append(aVar.g);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final String Y(xd7.a aVar, String str) {
        InterceptResult invokeLL;
        String string;
        String Z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                string = Z(aVar.a);
                Z = this.mContext.getString(R.string.obfuscated_res_0x7f0f1649);
            } else {
                string = this.mContext.getString(R.string.obfuscated_res_0x7f0f1649);
                Z = Z(aVar.a);
            }
            return String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00c4), string, getType(aVar.h), Z);
        }
        return (String) invokeLL.objValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.G = (LinearLayout) j(R.id.obfuscated_res_0x7f091be5);
            this.H = (TextView) j(R.id.obfuscated_res_0x7f091bf9);
            this.I = (TextView) j(R.id.obfuscated_res_0x7f091be7);
            this.J = (TextView) j(R.id.obfuscated_res_0x7f091bf6);
            this.K = (TextView) j(R.id.obfuscated_res_0x7f091bea);
            this.G.setOnClickListener(new a(this));
        }
    }

    public void b0(TbPageContext tbPageContext, ChatMessage chatMessage, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048580, this, tbPageContext, chatMessage, view2) != null) || chatMessage == null) {
            return;
        }
        xd7.a a2 = xd7.a(chatMessage.getContent());
        String valueOf = String.valueOf(chatMessage.getUserId());
        this.H.setText(Y(a2, valueOf));
        this.I.setText(a2.b);
        this.J.setText(X(a2, valueOf));
        TextView textView = this.K;
        textView.setText(a2.d + this.mContext.getString(R.string.obfuscated_res_0x7f0f0677));
    }
}
