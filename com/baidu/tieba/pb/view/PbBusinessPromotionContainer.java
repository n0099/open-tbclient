package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.z1;
import c.a.r0.q2.f;
import c.a.r0.q2.g;
import c.a.r0.q2.h;
import c.a.r0.q2.i;
import c.a.r0.q2.j;
import c.a.r0.q2.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f48063e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f48064f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f48065g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48066h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f48067i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f48068j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f48069k;
    public boolean l;
    public boolean m;
    public final View.OnClickListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbBusinessPromotionContainer f48070e;

        public a(PbBusinessPromotionContainer pbBusinessPromotionContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbBusinessPromotionContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48070e = pbBusinessPromotionContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(this.f48070e.f48067i);
                if (this.f48070e.f48068j != null) {
                    this.f48070e.f48068j.onClick(view);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbBusinessPromotionContainer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbBusinessPromotionContainer pbBusinessPromotionContainer, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbBusinessPromotionContainer, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                if (this.a.f48067i != null && this.a.f48067i.U() == longValue && this.a.m) {
                    this.a.l = false;
                    this.a.g();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbBusinessPromotionContainer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbBusinessPromotionContainer pbBusinessPromotionContainer, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbBusinessPromotionContainer, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                if (this.a.f48067i != null && this.a.f48067i.U() == longValue && this.a.m) {
                    this.a.l = true;
                    this.a.g();
                }
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
        q = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(g.tbds60);
        r = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(g.tbds30);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void bindForumData(d2 d2Var, z1 z1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, d2Var, z1Var, z) == null) {
            if (d2Var != null && z1Var != null && !StringUtils.isNull(z1Var.getForumName())) {
                this.f48067i = d2Var;
                f(z);
                this.m = true;
                setVisibility(0);
                this.f48064f.startLoad(z1Var.b(), 10, false);
                this.f48065g.setText(z1Var.getForumName());
                if (this.f48069k) {
                    return;
                }
                this.f48069k = true;
                this.l = z1Var.getIsLike();
                g();
                return;
            }
            this.m = false;
            setVisibility(8);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f48069k = false;
            this.l = false;
            this.m = false;
            if (this.p != null) {
                MessageManager.getInstance().unRegisterListener(this.p);
            }
            if (this.o != null) {
                MessageManager.getInstance().unRegisterListener(this.o);
            }
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                setPadding(0, 0, 0, 0);
            } else {
                setPadding(0, q, 0, r);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.l) {
                this.f48066h.setText(getResources().getString(l.followed));
                SkinManager.setViewTextColor(this.f48066h, f.CAM_X0109);
                SkinManager.setBackgroundResource(this.f48066h, 17170445);
                this.f48066h.setOnClickListener(null);
                return;
            }
            this.f48066h.setText(getResources().getString(l.attention));
            SkinManager.setViewTextColor(this.f48066h, f.CAM_X0101);
            SkinManager.setBackgroundResource(this.f48066h, h.pb_business_promotion_attention_bg);
            this.f48066h.setOnClickListener(this.n);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.o);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f48065g, f.CAM_X0105);
            SkinManager.setBackgroundResource(this.f48063e, h.pb_business_promotion_bg);
            if (this.l) {
                SkinManager.setViewTextColor(this.f48066h, f.CAM_X0109);
                SkinManager.setBackgroundResource(this.f48066h, 17170445);
                return;
            }
            SkinManager.setViewTextColor(this.f48066h, f.CAM_X0101);
            SkinManager.setBackgroundResource(this.f48066h, h.pb_business_promotion_attention_bg);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f48068j = onClickListener;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f48069k = false;
        this.l = false;
        this.m = false;
        this.n = new a(this);
        this.o = new b(this, 2001336);
        this.p = new c(this, 2001335);
        LayoutInflater.from(context).inflate(j.layout_pb_business_promotion, this);
        this.f48063e = (RelativeLayout) findViewById(i.id_pb_business_promotion_wrapper);
        this.f48064f = (TbImageView) findViewById(i.id_pb_business_promotion_avatar);
        this.f48065g = (TextView) findViewById(i.id_pb_business_promotion_forum_name);
        this.f48066h = (TextView) findViewById(i.id_pb_business_promotion_attention);
        this.f48064f.setRadius(c.a.d.f.p.l.f(context, g.tbds24));
        this.f48064f.setConrers(5);
        this.f48064f.setDefaultResource(17170445);
        this.f48064f.setDefaultBgResource(17170445);
        this.f48063e.setOnClickListener(this.n);
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(this.o);
    }
}
