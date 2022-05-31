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
import com.repackage.h27;
import com.repackage.s77;
/* loaded from: classes3.dex */
public class MsgReplyCardView extends h27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;

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
                this.a.b.onItemViewClick(view2, 14, this.a.f, 0L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgReplyCardView(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d054f);
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
        R();
    }

    private String getType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            if (i == 1) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f00c3);
            }
            return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1451);
        }
        return (String) invokeI.objValue;
    }

    public final String O(s77.a aVar, String str) {
        InterceptResult invokeLL;
        String Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                Q = this.mContext.getString(R.string.obfuscated_res_0x7f0f0aa7);
            } else {
                Q = Q(aVar.a);
            }
            if (aVar.h == 1) {
                sb.append(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00c0), Q));
                sb.append(aVar.c);
            } else {
                sb.append(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00c1), Q));
                sb.append(aVar.g);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final String P(s77.a aVar, String str) {
        InterceptResult invokeLL;
        String string;
        String Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.equals(TbadkCoreApplication.getCurrentAccount())) {
                string = Q(aVar.a);
                Q = this.mContext.getString(R.string.obfuscated_res_0x7f0f15fa);
            } else {
                string = this.mContext.getString(R.string.obfuscated_res_0x7f0f15fa);
                Q = Q(aVar.a);
            }
            return String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f00c2), string, getType(aVar.h), Q);
        }
        return (String) invokeLL.objValue;
    }

    public final String Q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 1) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0827);
            }
            if (i == 2) {
                return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1185);
            }
            return this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1351);
        }
        return (String) invokeI.objValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.B = (LinearLayout) b(R.id.obfuscated_res_0x7f091a47);
            this.C = (TextView) b(R.id.obfuscated_res_0x7f091a5b);
            this.D = (TextView) b(R.id.obfuscated_res_0x7f091a49);
            this.E = (TextView) b(R.id.obfuscated_res_0x7f091a58);
            this.F = (TextView) b(R.id.obfuscated_res_0x7f091a4c);
            this.B.setOnClickListener(new a(this));
        }
    }

    public void T(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, tbPageContext, chatMessage, view2) == null) || chatMessage == null) {
            return;
        }
        s77.a a2 = s77.a(chatMessage.getContent());
        String valueOf = String.valueOf(chatMessage.getUserId());
        this.C.setText(P(a2, valueOf));
        this.D.setText(a2.b);
        this.E.setText(O(a2, valueOf));
        TextView textView = this.F;
        textView.setText(a2.d + this.mContext.getString(R.string.obfuscated_res_0x7f0f0652));
    }
}
