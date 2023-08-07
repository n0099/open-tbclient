package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.w95;
import com.baidu.tieba.za5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PersonalFollowTipLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public HeadImageView c;
    public TextView d;
    public ImageView e;
    public FollowUserButton f;
    public za5 g;
    public UserData h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalFollowTipLayout a;

        public a(PersonalFollowTipLayout personalFollowTipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalFollowTipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalFollowTipLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b();
                if (this.a.h != null) {
                    SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                    sharedPrefHelper.putLong("im_personal_follow_tip_close_last_time_" + this.a.h.getUserId(), System.currentTimeMillis());
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_IM_PERSON_FOLLOW_TIP_CLOSE_BTN_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements FollowUserButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalFollowTipLayout a;

        public b(PersonalFollowTipLayout personalFollowTipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalFollowTipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalFollowTipLayout;
        }

        @Override // com.baidu.tbadk.core.view.FollowUserButton.a
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h != null) {
                StatisticItem addParam = new StatisticItem(TbadkCoreStatisticKey.KEY_IM_PERSON_FOLLOW_TIP_FOLLOW_BTN_CLICK).addParam("uid", TbadkCoreApplication.getCurrentAccount());
                if (this.a.h.getRelation() == 0) {
                    i = 1;
                } else {
                    i = 2;
                }
                TiebaStatic.log(addParam.addParam("obj_type", i));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalFollowTipLayout a;

        public c(PersonalFollowTipLayout personalFollowTipLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalFollowTipLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalFollowTipLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalFollowTipLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalFollowTipLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalFollowTipLayout(Context context, AttributeSet attributeSet, int i) {
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
        d();
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                postDelayed(new c(this), 1000L);
            } else {
                setVisibility(8);
            }
        }
    }

    public void f(BdPageContext<MsglistActivity<?>> bdPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdPageContext) == null) && (bdPageContext instanceof TbPageContext)) {
            za5 za5Var = new za5((TbPageContext) bdPageContext, this.f);
            this.g = za5Var;
            za5Var.i(true);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.layout_personal_follow_tip, this);
            this.a = findViewById(R.id.person_follow_tip_bg);
            this.b = findViewById(R.id.person_follow_tip_mask);
            this.c = (HeadImageView) findViewById(R.id.user_head_portrait);
            this.d = (TextView) findViewById(R.id.person_follow_tip);
            ImageView imageView = (ImageView) findViewById(R.id.follow_close_btn);
            this.e = imageView;
            imageView.setOnClickListener(new a(this));
            FollowUserButton followUserButton = (FollowUserButton) findViewById(R.id.personal_follow_btn);
            this.f = followUserButton;
            followUserButton.setClickableUnLike(false);
            this.f.setOnClickEvent(new b(this));
            this.c.setAutoChangeStyle(false);
            this.c.setDrawerType(1);
            this.c.setRadius(BdUtilHelper.getDimens(getContext(), R.dimen.tbds83));
            this.c.setConrers(15);
            this.c.setPlaceHolder(1);
            this.c.setDefaultResource(R.drawable.obfuscated_res_0x7f081199);
            h();
        }
    }

    public void e(@NonNull UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, userData) == null) {
            if (userData.getRelation() != 1 && userData.getRelation() != 2 && !userData.isBlocked()) {
                this.h = userData;
                if (i()) {
                    userData.setIsLike(false);
                    this.g.l(userData);
                    j(userData);
                    this.c.startLoad(userData.getPortrait(), 12, false);
                    return;
                }
                return;
            }
            this.h = null;
            b();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.h == null) {
                return false;
            }
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            long j = sharedPrefHelper.getLong("im_personal_follow_tip_close_last_time_" + this.h.getUserId(), 0L);
            if (j != 0 && System.currentTimeMillis() - j <= 86400000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            EMManager.from(this.d).setTextSize(R.dimen.T_X12).setTextColor(R.color.CAM_X0107).setTextStyle(R.string.F_X01);
            WebPManager.setPureDrawable(this.e, R.drawable.icon_pure_im_pobing_close18, R.color.CAM_X0111, null);
            EMManager.from(this).setBackGroundColor(R.color.CAM_X0204);
            EMManager.from(this.a).setGradientColor(new int[]{R.color.msg_navitation_bar_start, R.color.msg_navitation_bar_end}, Direction.LEFT);
            EMManager.from(this.b).setAlpha(R.string.A_X07).setBackGroundColor(R.color.CAM_X0208);
            this.f.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (g()) {
                setVisibility(0);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_IM_PERSON_FOLLOW_TIP_SHOW).addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                return true;
            }
            b();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j(@NonNull UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, userData) == null) {
            w95 w95Var = new w95();
            w95Var.j(R.drawable.icon_pure_follow26, 0, TBSpecificationButtonConfig.IconType.WEBP);
            w95Var.i(R.color.CAM_X0101);
            w95Var.h(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24));
            w95Var.g(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002));
            this.f.setConfig(w95Var);
            this.f.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (userData.getRelation() == 0) {
                this.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e8));
            } else {
                this.f.setText(TbadkCoreApplication.getInst().getString(R.string.back_attention));
            }
        }
    }
}
