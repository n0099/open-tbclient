package com.baidu.tieba.imMessageCenter.im.stranger;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.repackage.g47;
import com.repackage.v97;
/* loaded from: classes3.dex */
public class MsgReplyCardView extends g47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;

    /* loaded from: classes3.dex */
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
                this.a.b.h(view2, 14, this.a.f, 0L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0566);
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
        V();
    }

    private String getType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            if (i == 1) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f00c3);
            }
            return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1458);
        }
        return (String) invokeI.objValue;
    }

    public final String S(v97.a aVar, String str) {
        InterceptResult invokeLL;
        String U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                U = this.mContext.getString(R.string.obfuscated_res_0x7f0f0a99);
            } else {
                U = U(aVar.a);
            }
            if (aVar.h == 1) {
                sb.append(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00c0), U));
                sb.append(aVar.c);
            } else {
                sb.append(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00c1), U));
                sb.append(aVar.g);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final String T(v97.a aVar, String str) {
        InterceptResult invokeLL;
        String string;
        String U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                string = U(aVar.a);
                U = this.mContext.getString(R.string.obfuscated_res_0x7f0f1607);
            } else {
                string = this.mContext.getString(R.string.obfuscated_res_0x7f0f1607);
                U = U(aVar.a);
            }
            return String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00c2), string, getType(aVar.h), U);
        }
        return (String) invokeLL.objValue;
    }

    public final String U(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 1) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f082f);
            }
            if (i == 2) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1187);
            }
            return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1357);
        }
        return (String) invokeI.objValue;
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.C = (LinearLayout) a(R.id.obfuscated_res_0x7f091ae6);
            this.D = (TextView) a(R.id.obfuscated_res_0x7f091afa);
            this.E = (TextView) a(R.id.obfuscated_res_0x7f091ae8);
            this.F = (TextView) a(R.id.obfuscated_res_0x7f091af7);
            this.G = (TextView) a(R.id.obfuscated_res_0x7f091aeb);
            this.C.setOnClickListener(new a(this));
        }
    }

    public void W(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, tbPageContext, chatMessage, view2) == null) || chatMessage == null) {
            return;
        }
        v97.a a2 = v97.a(chatMessage.getContent());
        String valueOf = String.valueOf(chatMessage.getUserId());
        this.D.setText(T(a2, valueOf));
        this.E.setText(a2.b);
        this.F.setText(S(a2, valueOf));
        TextView textView = this.G;
        textView.setText(a2.d + this.mContext.getString(R.string.obfuscated_res_0x7f0f0650));
    }
}
