package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.FollowListSwitch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gm7;
/* loaded from: classes3.dex */
public class ConcernSelectView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public LinearLayout b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public LinearLayout h;
    public Animation i;
    public Animation j;
    public boolean k;
    public g l;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernSelectView a;

        public a(ConcernSelectView concernSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernSelectView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "1"));
                int i = this.a.h.getVisibility() == 0 ? 1 : 0;
                ConcernSelectView concernSelectView = this.a;
                concernSelectView.g(concernSelectView.h, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernSelectView a;

        public b(ConcernSelectView concernSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernSelectView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "2"));
                SkinManager.setViewTextColor(this.a.e, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.a.f, (int) R.color.CAM_X0107);
                if (FollowListSwitch.isOn()) {
                    this.a.d.setText(R.string.obfuscated_res_0x7f0f10f8);
                } else {
                    this.a.d.setText(R.string.obfuscated_res_0x7f0f0264);
                }
                if (this.a.l != null) {
                    this.a.l.a(0);
                }
                ConcernSelectView concernSelectView = this.a;
                concernSelectView.g(concernSelectView.h, 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernSelectView a;

        public c(ConcernSelectView concernSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernSelectView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "3"));
                SkinManager.setViewTextColor(this.a.e, (int) R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.a.f, (int) R.color.CAM_X0105);
                this.a.d.setText(R.string.obfuscated_res_0x7f0f0514);
                if (this.a.l != null) {
                    this.a.l.a(1);
                }
                ConcernSelectView concernSelectView = this.a;
                concernSelectView.g(concernSelectView.h, 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ View b;
        public final /* synthetic */ ConcernSelectView c;

        public d(ConcernSelectView concernSelectView, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView, Integer.valueOf(i), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = concernSelectView;
            this.a = i;
            this.b = view2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                boolean z = this.a == 0;
                if (z && (view2 = this.b) != null && (view2.getParent() instanceof ListView)) {
                    ListView listView = (ListView) this.b.getParent();
                    int bottom = this.b.getBottom();
                    Rect rect = new Rect();
                    boolean globalVisibleRect = this.b.getGlobalVisibleRect(rect);
                    Rect rect2 = new Rect();
                    listView.getGlobalVisibleRect(rect2);
                    if (!globalVisibleRect) {
                        listView.smoothScrollBy(bottom, 260);
                    } else if (rect2.bottom == rect.bottom) {
                        listView.smoothScrollBy(bottom, 260);
                    }
                }
                if (this.c.l != null) {
                    this.c.l.b(z);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernSelectView a;

        public e(ConcernSelectView concernSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernSelectView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                this.a.k = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConcernSelectView a;

        public f(ConcernSelectView concernSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = concernSelectView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.k = true;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(int i);

        void b(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernSelectView(Context context) {
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
        this.m = 3;
        this.a = context;
        k();
    }

    public final void g(View view2, int i) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) || view2 == null || view2.getAnimation() != null || (linearLayout = this.h) == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        if (childCount < 0) {
            childCount = 0;
        }
        gm7 gm7Var = new gm7(view2, i, (((int) this.a.getResources().getDimension(R.dimen.tbds80)) + ((int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070198))) * childCount);
        if (i == 0 && view2.getVisibility() != 0) {
            view2.setVisibility(0);
        }
        gm7Var.setDuration(260L);
        gm7Var.setAnimationListener(new d(this, i, view2));
        view2.startAnimation(gm7Var);
        ImageView imageView = this.c;
        if (imageView != null) {
            if (imageView.getAnimation() == null || this.c.getAnimation().hasEnded()) {
                if (i == 0) {
                    if (this.i == null) {
                        j();
                    }
                    Animation animation = this.j;
                    if (animation != null) {
                        animation.cancel();
                    }
                    this.c.startAnimation(this.i);
                    return;
                }
                if (this.j == null) {
                    i();
                }
                Animation animation2 = this.i;
                if (animation2 != null) {
                    animation2.cancel();
                }
                this.c.startAnimation(this.j);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.h.getVisibility() == 0) {
                g(this.h, 1);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010100);
            this.j = loadAnimation;
            loadAnimation.setAnimationListener(new e(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f010101);
            this.i = loadAnimation;
            loadAnimation.setAnimationListener(new f(this));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d01f6, this);
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090936);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090937);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091400);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091409);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09025b);
            if (FollowListSwitch.isOn()) {
                this.d.setText(R.string.obfuscated_res_0x7f0f10f8);
                this.e.setText(R.string.obfuscated_res_0x7f0f10f8);
            }
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090847);
            this.g = findViewById(R.id.obfuscated_res_0x7f090f71);
            this.b.setOnClickListener(new a(this));
            this.e.setOnClickListener(new b(this));
            this.f.setOnClickListener(new c(this));
            m(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.m == i) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundResource(this.h, R.drawable.concern_item_bg);
        SkinManager.setBackgroundResource(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.e, R.drawable.concern_item_menu_select_bg);
        SkinManager.setBackgroundResource(this.f, R.drawable.concern_item_menu_select_bg);
        SkinManager.setBackgroundResource(this.g, R.color.CAM_X0204);
    }

    public void setOnExpandListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.l = gVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernSelectView(Context context, AttributeSet attributeSet) {
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
        this.m = 3;
        this.a = context;
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernSelectView(Context context, AttributeSet attributeSet, int i) {
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
        this.m = 3;
        this.a = context;
        k();
    }
}
