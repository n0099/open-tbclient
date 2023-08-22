package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BotReplyContent;
import tbclient.BotReplyUserInfo;
/* loaded from: classes7.dex */
public class PbPostFriendReplyView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public TextView b;
    public LinearLayout c;
    public TbImageView d;
    public TextView e;
    public TbImageView f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PbPostFriendReplyView b;

        public a(PbPostFriendReplyView pbPostFriendReplyView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbPostFriendReplyView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbPostFriendReplyView;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UrlManager.getInstance().dealOneLink(this.a);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbPostFriendReplyView(@NonNull Context context) {
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
    public PbPostFriendReplyView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbPostFriendReplyView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPostFriendReplyView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        a(context);
        b();
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d07ae, this);
            this.a = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090441);
            this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09043a);
            this.c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090440);
            this.d = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090436);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090435);
            this.f = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090434);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMManager.from(this.b).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X09);
            EMManager.from(this.c).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0212);
            EMManager.from(this.e).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X09);
        }
    }

    public void c(BotReplyContent botReplyContent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, botReplyContent) != null) || botReplyContent == null) {
            return;
        }
        String str = botReplyContent.text;
        if (!TextUtils.isEmpty(str)) {
            this.b.setVisibility(0);
            this.b.setText(str);
        } else {
            this.b.setVisibility(8);
        }
        BotReplyUserInfo botReplyUserInfo = botReplyContent.user_info;
        if (botReplyUserInfo != null) {
            this.c.setVisibility(0);
            String str2 = botReplyUserInfo.name;
            String str3 = botReplyUserInfo.portrait_url;
            String str4 = botReplyUserInfo.icon_url;
            if (!TextUtils.isEmpty(str2)) {
                this.e.setVisibility(0);
                this.e.setText(str2);
            } else {
                this.e.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str3)) {
                this.d.setVisibility(0);
                this.d.startLoad(str3, 10, false);
            } else {
                this.d.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str4)) {
                this.f.setVisibility(0);
                this.f.startLoad(str4, 10, false);
            } else {
                this.f.setVisibility(8);
            }
        } else {
            this.c.setVisibility(8);
        }
        String str5 = botReplyContent.target_scheme;
        if (!TextUtils.isEmpty(str) && botReplyUserInfo != null && !TextUtils.isEmpty(str5) && this.c.getVisibility() == 0) {
            this.a.setOnClickListener(new a(this, str5));
        } else {
            this.a.setOnClickListener(null);
        }
    }
}
