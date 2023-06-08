package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.j45;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public ThreadData e;
    public View.OnClickListener f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final View.OnClickListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbBusinessPromotionContainer a;

        public a(PbBusinessPromotionContainer pbBusinessPromotionContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbBusinessPromotionContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbBusinessPromotionContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(this.a.e);
                if (this.a.f != null) {
                    this.a.f.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbBusinessPromotionContainer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbBusinessPromotionContainer pbBusinessPromotionContainer, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbBusinessPromotionContainer, Integer.valueOf(i)};
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
            this.a = pbBusinessPromotionContainer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.a.e == null || this.a.e.getFid() != longValue || !this.a.i) {
                    return;
                }
                this.a.h = false;
                this.a.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbBusinessPromotionContainer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbBusinessPromotionContainer pbBusinessPromotionContainer, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbBusinessPromotionContainer, Integer.valueOf(i)};
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
            this.a = pbBusinessPromotionContainer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.a.e == null || this.a.e.getFid() != longValue || !this.a.i) {
                    return;
                }
                this.a.h = true;
                this.a.j();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(860198352, "Lcom/baidu/tieba/pb/view/PbBusinessPromotionContainer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(860198352, "Lcom/baidu/tieba/pb/view/PbBusinessPromotionContainer;");
                return;
            }
        }
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.a, R.drawable.pb_business_promotion_bg);
            if (this.h) {
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundResource(this.d, 17170445);
                return;
            }
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.d, R.drawable.pb_business_promotion_attention_bg);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = new a(this);
        this.k = new b(this, 2001336);
        this.l = new c(this, 2001335);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0528, this);
        this.a = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090fed);
        this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090feb);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090fec);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090fea);
        this.b.setRadius(vi.g(context, R.dimen.tbds24));
        this.b.setConrers(5);
        this.b.setDefaultResource(17170445);
        this.b.setDefaultBgResource(17170445);
        this.a.setOnClickListener(this.j);
        MessageManager.getInstance().registerListener(this.l);
        MessageManager.getInstance().registerListener(this.k);
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                setPadding(0, 0, 0, 0);
            } else {
                setPadding(0, m, 0, n);
            }
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void f(ThreadData threadData, j45 j45Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, threadData, j45Var, z) == null) {
            if (threadData != null && j45Var != null && !StringUtils.isNull(j45Var.d())) {
                this.e = threadData;
                i(z);
                this.i = true;
                setVisibility(0);
                this.b.N(j45Var.a(), 10, false);
                this.c.setText(j45Var.d());
                if (!this.g) {
                    this.g = true;
                    this.h = j45Var.f();
                    j();
                    return;
                }
                return;
            }
            this.i = false;
            setVisibility(8);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g = false;
            this.h = false;
            this.i = false;
            if (this.l != null) {
                MessageManager.getInstance().unRegisterListener(this.l);
            }
            if (this.k != null) {
                MessageManager.getInstance().unRegisterListener(this.k);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.l);
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.h) {
                this.d.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0751));
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundResource(this.d, 17170445);
                this.d.setOnClickListener(null);
                return;
            }
            this.d.setText(getResources().getString(R.string.obfuscated_res_0x7f0f02e5));
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.d, R.drawable.pb_business_promotion_attention_bg);
            this.d.setOnClickListener(this.j);
        }
    }
}
