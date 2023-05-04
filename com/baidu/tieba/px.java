package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.ry;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class px extends tw implements lx, kx<ThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RelativeLayout e;
    public final LinearLayout f;
    public View g;
    public View h;
    public View i;
    public ImageView j;
    public TextView k;
    public ThreadData l;
    public boolean m;
    public boolean n;
    public CustomMessageListener o;

    @Override // com.baidu.tieba.tw
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.tw
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(px pxVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pxVar, Integer.valueOf(i)};
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
            this.a = pxVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ThreadData) && ((ThreadData) customResponsedMessage.getData()) == this.a.l) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px a;

        public b(px pxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pxVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.j != null && this.a.l != null && this.a.k != null && !this.a.l.isTransportThread() && this.a.n) {
                if (!this.a.l.isMarkToDel() && g67.f().i()) {
                    if (g67.f().a(this.a.l)) {
                        this.a.l.setMarkToDel(true);
                    }
                } else if (!this.a.l.isMarkToMove() && f67.h().j()) {
                    if (f67.h().a(this.a.l)) {
                        this.a.l.setMarkToMove(true);
                    }
                } else {
                    g67.f().l(this.a.l);
                    this.a.l.setMarkToDel(false);
                    f67.h().l(this.a.l);
                    this.a.l.setMarkToMove(false);
                }
                this.a.r();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, this.a.l));
            }
        }
    }

    public px(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.n = true;
        this.o = new a(this, 2921402);
        View inflate = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.g = inflate;
        this.h = inflate.findViewById(R.id.multi_del_mask_top_view);
        this.f = (LinearLayout) this.g.findViewById(R.id.multi_del_bottom_layout);
        this.h.setAlpha(0.5f);
        View findViewById = this.g.findViewById(R.id.multi_del_mask_bottom_view);
        this.i = findViewById;
        findViewById.setAlpha(0.5f);
        this.j = (ImageView) this.g.findViewById(R.id.manage_select_img);
        this.e = (RelativeLayout) this.g.findViewById(R.id.multi_del_bottom_root);
        this.k = (TextView) this.g.findViewById(R.id.manage_select_txt);
        g(this.g);
        this.g.setFocusable(true);
        this.g.setOnClickListener(new b(this));
        h(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.o);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.o);
        }
        r55.b(this.f);
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.tieba.lx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            if (!this.l.isMarkToDel() && !this.l.isMarkToMove()) {
                WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
            }
            g35 d = g35.d(this.h);
            d.o(R.string.J_X06);
            if (this.m) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            d.n(i2);
            d.f(R.color.CAM_X0201);
            g35 d2 = g35.d(this.i);
            d2.o(R.string.J_X06);
            d2.n(2);
            d2.f(R.color.CAM_X0201);
            g35.d(this.k).C(R.string.F_X01);
            TextView textView = this.k;
            if (!this.l.isMarkToDel() && !this.l.isMarkToMove()) {
                i3 = R.drawable.selector_comment_and_prise_item_text_color;
            } else {
                i3 = R.color.CAM_X0302;
            }
            SkinManager.setViewTextColor(textView, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kx
    /* renamed from: p */
    public void a(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            this.l = threadData;
            if (threadData.getType() != ThreadData.TYPE_FAKE_VIDEO && ((threadData == null || threadData.getAuthor() == null || !threadData.getAuthor().isForumBusinessAccount() || threadData.isSelf()) && threadData != null && (!threadData.isTiePlusCantDeleteUnion() || threadData.isSelf()))) {
                z = true;
            } else {
                z = false;
            }
            this.n = z;
            if (!g67.f().i() && !f67.h().j()) {
                this.d.p(new ry.a(4, Boolean.TRUE));
                this.g.setVisibility(8);
                return;
            }
            this.g.setVisibility(0);
            this.d.p(new ry.a(4, Boolean.FALSE));
            r();
        }
    }

    public final void r() {
        ThreadData threadData;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (threadData = this.l) == null) {
            return;
        }
        View view2 = this.h;
        int i2 = 4;
        if (!threadData.isMarkToDel() && !this.l.isMarkToMove() && this.n) {
            i = 4;
        } else {
            i = 0;
        }
        view2.setVisibility(i);
        this.i.setVisibility((this.l.isMarkToDel() || this.l.isMarkToMove()) ? 0 : 0);
        if (this.m) {
            this.e.setVisibility(0);
            if (this.n) {
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                boolean isMarkToDel = this.l.isMarkToDel();
                int i3 = R.color.CAM_X0304;
                if (!isMarkToDel && !this.l.isMarkToMove()) {
                    WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                } else {
                    WebPManager.setPureDrawable(this.j, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                }
                TextView textView = this.k;
                if (!this.l.isMarkToDel() && !this.l.isMarkToMove()) {
                    i3 = R.drawable.selector_comment_and_prise_item_text_color;
                }
                SkinManager.setViewTextColor(textView, i3);
                return;
            }
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            return;
        }
        this.e.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
    }

    public void t(int i, hy hyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, hyVar) == null) {
            this.f.setWeightSum(i);
            if (this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.f.getLayoutParams()).setMargins(hyVar.g, hyVar.d, hyVar.h, hyVar.f);
            }
        }
    }
}
