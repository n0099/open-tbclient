package com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class GroupChatRobotTopHeadView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public RelativeLayout b;
    public LinearLayout c;
    public HeadImageView d;
    public TextView e;
    public RelativeLayout f;
    public ImageView g;
    public b h;

    /* loaded from: classes6.dex */
    public interface b {
        void onCloseEvent();
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatRobotTopHeadView a;

        public a(GroupChatRobotTopHeadView groupChatRobotTopHeadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatRobotTopHeadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatRobotTopHeadView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null) {
                this.a.h.onCloseEvent();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupChatRobotTopHeadView(Context context) {
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

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            d85 d = d85.d(this.b);
            d.o(R.string.deprecated_J_X18);
            d.f(R.color.CAM_X0207);
            d85 d2 = d85.d(this.e);
            d2.x(R.color.CAM_X0107);
            d2.C(R.dimen.T_X06);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupChatRobotTopHeadView(Context context, AttributeSet attributeSet) {
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
    public GroupChatRobotTopHeadView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = context;
        c();
    }

    public void setEventCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.h = bVar;
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.setOnClickListener(null);
            this.c.setOnClickListener(null);
            this.f.setOnClickListener(new a(this));
        }
    }

    public final void c() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (context = this.a) == null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d03e0, (ViewGroup) this, true);
        this.b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092206);
        this.c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092203);
        HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092204);
        this.d = headImageView;
        headImageView.setIsRound(true);
        this.d.setIsBigV(false);
        this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092205);
        this.f = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092202);
        this.g = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092201);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setData(String str, String str2, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str)) {
                this.d.N(String.valueOf((int) R.drawable.obfuscated_res_0x7f08118b), 24, false);
            } else {
                this.d.N(str, 12, false);
            }
            String str5 = "";
            if (TextUtils.isEmpty(str2)) {
                str4 = "";
            } else {
                str4 = "@" + str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str5 = "/" + str3;
            }
            this.e.setText(str4 + str5);
        }
    }
}
