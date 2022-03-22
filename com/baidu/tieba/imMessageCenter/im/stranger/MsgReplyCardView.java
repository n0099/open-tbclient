package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.p0.u1.f.e;
import c.a.p0.v1.a.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class MsgReplyCardView extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TextView B;
    public TextView C;
    public LinearLayout y;
    public TextView z;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f18676b.onItemViewClick(view, 14, this.a.f18680f, 0L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d056b);
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
        N();
    }

    private String getType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            if (i == 1) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f00bf);
            }
            return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1410);
        }
        return (String) invokeI.objValue;
    }

    public final String K(a.C1445a c1445a, String str) {
        InterceptResult invokeLL;
        String M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c1445a, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                M = this.mContext.getString(R.string.obfuscated_res_0x7f0f0a97);
            } else {
                M = M(c1445a.a);
            }
            if (c1445a.f19094h == 1) {
                sb.append(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00bc), M));
                sb.append(c1445a.f19089c);
            } else {
                sb.append(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00bd), M));
                sb.append(c1445a.f19093g);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final String L(a.C1445a c1445a, String str) {
        InterceptResult invokeLL;
        String string;
        String M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1445a, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                string = M(c1445a.a);
                M = this.mContext.getString(R.string.obfuscated_res_0x7f0f15b0);
            } else {
                string = this.mContext.getString(R.string.obfuscated_res_0x7f0f15b0);
                M = M(c1445a.a);
            }
            return String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00be), string, getType(c1445a.f19094h), M);
        }
        return (String) invokeLL.objValue;
    }

    public final String M(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 1) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0818);
            }
            if (i == 2) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1150);
            }
            return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1316);
        }
        return (String) invokeI.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.y = (LinearLayout) c(R.id.obfuscated_res_0x7f091a58);
            this.z = (TextView) c(R.id.obfuscated_res_0x7f091a6d);
            this.A = (TextView) c(R.id.obfuscated_res_0x7f091a5a);
            this.B = (TextView) c(R.id.obfuscated_res_0x7f091a6a);
            this.C = (TextView) c(R.id.obfuscated_res_0x7f091a5d);
            this.y.setOnClickListener(new a(this));
        }
    }

    public void O(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, tbPageContext, chatMessage, view) == null) || chatMessage == null) {
            return;
        }
        a.C1445a a2 = c.a.p0.v1.a.e.a.a(chatMessage.getContent());
        String valueOf = String.valueOf(chatMessage.getUserId());
        this.z.setText(L(a2, valueOf));
        this.A.setText(a2.f19088b);
        this.B.setText(K(a2, valueOf));
        TextView textView = this.C;
        textView.setText(a2.f19090d + this.mContext.getString(R.string.obfuscated_res_0x7f0f063c));
    }
}
