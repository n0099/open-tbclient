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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.x1;
/* loaded from: classes4.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f19995e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f19996f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19997g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19998h;

    /* renamed from: i  reason: collision with root package name */
    public b2 f19999i;
    public View.OnClickListener j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final View.OnClickListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbBusinessPromotionContainer f20000e;

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
            this.f20000e = pbBusinessPromotionContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(this.f20000e.f19999i);
                if (this.f20000e.j != null) {
                    this.f20000e.j.onClick(view);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbBusinessPromotionContainer f20001a;

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
            this.f20001a = pbBusinessPromotionContainer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.f20001a.f19999i != null && this.f20001a.f19999i.R() == longValue && this.f20001a.m) {
                    this.f20001a.l = false;
                    this.f20001a.j();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbBusinessPromotionContainer f20002a;

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
            this.f20002a = pbBusinessPromotionContainer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                if (this.f20002a.f19999i != null && this.f20002a.f19999i.R() == longValue && this.f20002a.m) {
                    this.f20002a.l = true;
                    this.f20002a.j();
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
        q = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
        r = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
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

    public void f(b2 b2Var, x1 x1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, b2Var, x1Var, z) == null) {
            if (b2Var != null && x1Var != null && !StringUtils.isNull(x1Var.g())) {
                this.f19999i = b2Var;
                i(z);
                this.m = true;
                setVisibility(0);
                this.f19996f.M(x1Var.a(), 10, false);
                this.f19997g.setText(x1Var.g());
                if (this.k) {
                    return;
                }
                this.k = true;
                this.l = x1Var.getIsLike();
                j();
                return;
            }
            this.m = false;
            setVisibility(8);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k = false;
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

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f19997g, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(this.f19995e, R.drawable.pb_business_promotion_bg);
            if (this.l) {
                SkinManager.setViewTextColor(this.f19998h, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(this.f19998h, 17170445);
                return;
            }
            SkinManager.setViewTextColor(this.f19998h, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f19998h, R.drawable.pb_business_promotion_attention_bg);
        }
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                setPadding(0, 0, 0, 0);
            } else {
                setPadding(0, q, 0, r);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.l) {
                this.f19998h.setText(getResources().getString(R.string.followed));
                SkinManager.setViewTextColor(this.f19998h, R.color.CAM_X0109);
                SkinManager.setBackgroundResource(this.f19998h, 17170445);
                this.f19998h.setOnClickListener(null);
                return;
            }
            this.f19998h.setText(getResources().getString(R.string.attention));
            SkinManager.setViewTextColor(this.f19998h, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f19998h, R.drawable.pb_business_promotion_attention_bg);
            this.f19998h.setOnClickListener(this.n);
        }
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.j = onClickListener;
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
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = new a(this);
        this.o = new b(this, 2001336);
        this.p = new c(this, 2001335);
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.f19995e = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.f19996f = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.f19997g = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.f19998h = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.f19996f.setRadius(l.g(context, R.dimen.tbds24));
        this.f19996f.setConrers(5);
        this.f19996f.setDefaultResource(17170445);
        this.f19996f.setDefaultBgResource(17170445);
        this.f19995e.setOnClickListener(this.n);
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(this.o);
    }
}
