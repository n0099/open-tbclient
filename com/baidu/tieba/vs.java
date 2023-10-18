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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.vt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vs extends yr implements rs, qs<ThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RelativeLayout a;
    public final LinearLayout b;
    public View c;
    public View d;
    public View e;
    public ImageView f;
    public TextView g;
    public ThreadData h;
    public boolean i;
    public boolean j;
    public CustomMessageListener k;

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
        }
    }

    @Override // com.baidu.tieba.yr
    public void onAttachCard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.yr
    public void onDetachCard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vs a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vs vsVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vsVar, Integer.valueOf(i)};
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
            this.a = vsVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ThreadData) && ((ThreadData) customResponsedMessage.getData()) == this.a.h) {
                this.a.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vs a;

        public b(vs vsVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vsVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vsVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f != null && this.a.h != null && this.a.g != null && !this.a.h.isTransportThread() && this.a.j) {
                if (!this.a.h.isMarkToDel() && pc7.f().i()) {
                    if (pc7.f().a(this.a.h)) {
                        this.a.h.setMarkToDel(true);
                    }
                } else if (!this.a.h.isMarkToMove() && oc7.h().j()) {
                    if (oc7.h().a(this.a.h)) {
                        this.a.h.setMarkToMove(true);
                    }
                } else {
                    pc7.f().l(this.a.h);
                    this.a.h.setMarkToDel(false);
                    oc7.h().l(this.a.h);
                    this.a.h.setMarkToMove(false);
                }
                this.a.h();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, this.a.h));
            }
        }
    }

    public vs(Context context) {
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
        this.i = false;
        this.j = true;
        this.k = new a(this, 2921402);
        View inflate = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.c = inflate;
        this.d = inflate.findViewById(R.id.multi_del_mask_top_view);
        this.b = (LinearLayout) this.c.findViewById(R.id.multi_del_bottom_layout);
        this.d.setAlpha(0.5f);
        View findViewById = this.c.findViewById(R.id.multi_del_mask_bottom_view);
        this.e = findViewById;
        findViewById.setAlpha(0.5f);
        this.f = (ImageView) this.c.findViewById(R.id.manage_select_img);
        this.a = (RelativeLayout) this.c.findViewById(R.id.multi_del_bottom_root);
        this.g = (TextView) this.c.findViewById(R.id.manage_select_txt);
        setDecorView(this.c);
        this.c.setFocusable(true);
        this.c.setOnClickListener(new b(this));
        setInsertIndex(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.k);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.k);
        }
        n45.b(this.b);
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.i = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qs
    /* renamed from: f */
    public void onBindDataToView(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            this.h = threadData;
            if (threadData.getType() != ThreadData.TYPE_FAKE_VIDEO && ((threadData == null || threadData.getAuthor() == null || !threadData.getAuthor().isForumBusinessAccount() || threadData.isSelf()) && threadData != null && (!threadData.isTiePlusCantDeleteUnion() || threadData.isSelf()))) {
                z = true;
            } else {
                z = false;
            }
            this.j = z;
            if (!pc7.f().i() && !oc7.h().j()) {
                this.threadCard.q(new vt.a(4, Boolean.TRUE));
                this.c.setVisibility(8);
                return;
            }
            this.c.setVisibility(0);
            this.threadCard.q(new vt.a(4, Boolean.FALSE));
            h();
        }
    }

    public final void h() {
        ThreadData threadData;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (threadData = this.h) == null) {
            return;
        }
        View view2 = this.d;
        int i2 = 4;
        if (!threadData.isMarkToDel() && !this.h.isMarkToMove() && this.j) {
            i = 4;
        } else {
            i = 0;
        }
        view2.setVisibility(i);
        this.e.setVisibility((this.h.isMarkToDel() || this.h.isMarkToMove()) ? 0 : 0);
        if (this.i) {
            this.a.setVisibility(0);
            if (this.j) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                boolean isMarkToDel = this.h.isMarkToDel();
                int i3 = R.color.CAM_X0304;
                if (!isMarkToDel && !this.h.isMarkToMove()) {
                    WebPManager.setPureDrawable(this.f, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                } else {
                    WebPManager.setPureDrawable(this.f, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                }
                TextView textView = this.g;
                if (!this.h.isMarkToDel() && !this.h.isMarkToMove()) {
                    i3 = R.drawable.selector_comment_and_prise_item_text_color;
                }
                SkinManager.setViewTextColor(textView, i3);
                return;
            }
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            return;
        }
        this.a.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
    }

    public void j(int i, lt ltVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, ltVar) == null) {
            this.b.setWeightSum(i);
            if (this.b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.b.getLayoutParams()).setMargins(ltVar.g, ltVar.d, ltVar.h, ltVar.f);
            }
        }
    }

    @Override // com.baidu.tieba.rs
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            if (!this.h.isMarkToDel() && !this.h.isMarkToMove()) {
                WebPManager.setPureDrawable(this.f, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            } else {
                WebPManager.setPureDrawable(this.f, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
            }
            EMManager corner = EMManager.from(this.d).setCorner(R.string.J_X06);
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            corner.setCardType(i2).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.e).setCorner(R.string.J_X06).setCardType(2).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.g).setTextStyle(R.string.F_X01);
            TextView textView = this.g;
            if (!this.h.isMarkToDel() && !this.h.isMarkToMove()) {
                i3 = R.drawable.selector_comment_and_prise_item_text_color;
            } else {
                i3 = R.color.CAM_X0302;
            }
            SkinManager.setViewTextColor(textView, i3);
        }
    }
}
