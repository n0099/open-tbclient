package com.baidu.tieba.immessagecenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.fc8;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.iq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class MsgReplyCardView extends fc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout H;
    public TextView I;
    public TextView J;
    public TextView K;
    public TextView L;

    /* loaded from: classes6.dex */
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
                this.a.b.B(view2, 14, this.a.f, 0L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d062f);
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
        s0();
    }

    public final String r0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 1) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f09aa);
            }
            if (i == 2) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f13c5);
            }
            return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f15a9);
        }
        return (String) invokeI.objValue;
    }

    private String getType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            if (i == 1) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f00f3);
            }
            return this.mContext.getResources().getString(R.string.topic_thread);
        }
        return (String) invokeI.objValue;
    }

    public final String p0(iq8.a aVar, String str) {
        InterceptResult invokeLL;
        String r0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                r0 = this.mContext.getString(R.string.obfuscated_res_0x7f0f0c54);
            } else {
                r0 = r0(aVar.a);
            }
            if (aVar.h == 1) {
                sb.append(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00f0), r0));
                sb.append(aVar.c);
            } else {
                sb.append(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00f1), r0));
                sb.append(aVar.g);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final String q0(iq8.a aVar, String str) {
        InterceptResult invokeLL;
        String string;
        String r0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                string = r0(aVar.a);
                r0 = this.mContext.getString(R.string.obfuscated_res_0x7f0f18f2);
            } else {
                string = this.mContext.getString(R.string.obfuscated_res_0x7f0f18f2);
                r0 = r0(aVar.a);
            }
            return String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00f2), string, getType(aVar.h), r0);
        }
        return (String) invokeLL.objValue;
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.H = (LinearLayout) x(R.id.obfuscated_res_0x7f091eac);
            this.I = (TextView) x(R.id.obfuscated_res_0x7f091ec1);
            this.J = (TextView) x(R.id.obfuscated_res_0x7f091eaf);
            this.K = (TextView) x(R.id.obfuscated_res_0x7f091ebe);
            this.L = (TextView) x(R.id.obfuscated_res_0x7f091eb2);
            this.H.setOnClickListener(new a(this));
        }
    }

    public void u0(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048580, this, tbPageContext, chatMessage, view2) != null) || chatMessage == null) {
            return;
        }
        iq8.a a2 = iq8.a(chatMessage.getContent());
        String valueOf = String.valueOf(chatMessage.getUserId());
        this.I.setText(q0(a2, valueOf));
        this.J.setText(a2.b);
        this.K.setText(p0(a2, valueOf));
        TextView textView = this.L;
        textView.setText(a2.d + this.mContext.getString(R.string.obfuscated_res_0x7f0f0773));
    }
}
