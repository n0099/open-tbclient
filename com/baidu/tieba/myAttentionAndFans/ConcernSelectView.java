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
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes9.dex */
public class ConcernSelectView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51648e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f51649f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f51650g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51651h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51652i;
    public TextView j;
    public View k;
    public Animation l;
    public Animation m;
    public LinearLayout mMenuList;
    public boolean n;
    public g o;
    public int p;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f51653e;

        public a(ConcernSelectView concernSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51653e = concernSelectView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "1"));
                int i2 = this.f51653e.mMenuList.getVisibility() == 0 ? 1 : 0;
                ConcernSelectView concernSelectView = this.f51653e;
                concernSelectView.g(concernSelectView.mMenuList, i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f51654e;

        public b(ConcernSelectView concernSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51654e = concernSelectView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "2"));
                SkinManager.setViewTextColor(this.f51654e.f51652i, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f51654e.j, R.color.CAM_X0107);
                if (FollowListSwitch.isOn()) {
                    this.f51654e.f51651h.setText(R.string.self_attention);
                } else {
                    this.f51654e.f51651h.setText(R.string.all_concerned);
                }
                if (this.f51654e.o != null) {
                    this.f51654e.o.onSelected(0);
                }
                ConcernSelectView concernSelectView = this.f51654e;
                concernSelectView.g(concernSelectView.mMenuList, 1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f51655e;

        public c(ConcernSelectView concernSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51655e = concernSelectView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "3"));
                SkinManager.setViewTextColor(this.f51655e.f51652i, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f51655e.j, R.color.CAM_X0105);
                this.f51655e.f51651h.setText(R.string.each_concerned);
                if (this.f51655e.o != null) {
                    this.f51655e.o.onSelected(1);
                }
                ConcernSelectView concernSelectView = this.f51655e;
                concernSelectView.g(concernSelectView.mMenuList, 1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f51656a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f51657b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f51658c;

        public d(ConcernSelectView concernSelectView, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView, Integer.valueOf(i2), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51658c = concernSelectView;
            this.f51656a = i2;
            this.f51657b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                boolean z = this.f51656a == 0;
                if (z && (view = this.f51657b) != null && (view.getParent() instanceof ListView)) {
                    ListView listView = (ListView) this.f51657b.getParent();
                    int bottom = this.f51657b.getBottom();
                    Rect rect = new Rect();
                    boolean globalVisibleRect = this.f51657b.getGlobalVisibleRect(rect);
                    Rect rect2 = new Rect();
                    listView.getGlobalVisibleRect(rect2);
                    if (!globalVisibleRect) {
                        listView.smoothScrollBy(bottom, 260);
                    } else if (rect2.bottom == rect.bottom) {
                        listView.smoothScrollBy(bottom, 260);
                    }
                }
                if (this.f51658c.o != null) {
                    this.f51658c.o.onExpand(z);
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

    /* loaded from: classes9.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f51659a;

        public e(ConcernSelectView concernSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51659a = concernSelectView;
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
                this.f51659a.n = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f51660a;

        public f(ConcernSelectView concernSelectView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {concernSelectView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51660a = concernSelectView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f51660a.n = true;
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

    /* loaded from: classes9.dex */
    public interface g {
        void onExpand(boolean z);

        void onSelected(int i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = 3;
        this.f51648e = context;
        j();
    }

    public void closeView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mMenuList.getVisibility() == 0) {
                g(this.mMenuList, 1);
            }
        }
    }

    public void expandView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mMenuList.getVisibility() == 0) {
                return;
            }
            g(this.mMenuList, 0);
        }
    }

    public final void g(View view, int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) || view == null || view.getAnimation() != null || (linearLayout = this.mMenuList) == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        if (childCount < 0) {
            childCount = 0;
        }
        b.a.r0.c2.a aVar = new b.a.r0.c2.a(view, i2, (((int) this.f51648e.getResources().getDimension(R.dimen.tbds80)) + ((int) this.f51648e.getResources().getDimension(R.dimen.ds1))) * childCount);
        if (i2 == 0 && view.getVisibility() != 0) {
            view.setVisibility(0);
        }
        aVar.setDuration(260L);
        aVar.setAnimationListener(new d(this, i2, view));
        view.startAnimation(aVar);
        ImageView imageView = this.f51650g;
        if (imageView != null) {
            if (imageView.getAnimation() == null || this.f51650g.getAnimation().hasEnded()) {
                if (i2 == 0) {
                    if (this.l == null) {
                        i();
                    }
                    Animation animation = this.m;
                    if (animation != null) {
                        animation.cancel();
                    }
                    this.f51650g.startAnimation(this.l);
                    return;
                }
                if (this.m == null) {
                    h();
                }
                Animation animation2 = this.l;
                if (animation2 != null) {
                    animation2.cancel();
                }
                this.f51650g.startAnimation(this.m);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f51648e, R.anim.rotate_collapse);
            this.m = loadAnimation;
            loadAnimation.setAnimationListener(new e(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f51648e, R.anim.rotate_expand);
            this.l = loadAnimation;
            loadAnimation.setAnimationListener(new f(this));
        }
    }

    public boolean isExpand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mMenuList.getVisibility() == 0 : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LayoutInflater.from(this.f51648e).inflate(R.layout.concern_select_layout, this);
            this.f51649f = (LinearLayout) findViewById(R.id.expandable_area);
            this.f51650g = (ImageView) findViewById(R.id.expandable_btn);
            this.mMenuList = (LinearLayout) findViewById(R.id.menu_list);
            this.f51651h = (TextView) findViewById(R.id.menu_title);
            this.f51652i = (TextView) findViewById(R.id.all_concerned_item);
            if (FollowListSwitch.isOn()) {
                this.f51651h.setText(R.string.self_attention);
                this.f51652i.setText(R.string.self_attention);
            }
            this.j = (TextView) findViewById(R.id.each_concerned_item);
            this.k = findViewById(R.id.item_divider_line);
            this.f51649f.setOnClickListener(new a(this));
            this.f51652i.setOnClickListener(new b(this));
            this.j.setOnClickListener(new c(this));
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.p == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f51650g, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f51651h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f51652i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107);
        SkinManager.setBackgroundResource(this.mMenuList, R.drawable.concern_item_bg);
        SkinManager.setBackgroundResource(this.f51651h, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f51652i, R.drawable.concern_item_menu_select_bg);
        SkinManager.setBackgroundResource(this.j, R.drawable.concern_item_menu_select_bg);
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0204);
    }

    public void setOnExpandListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
            this.o = gVar;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = 3;
        this.f51648e = context;
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernSelectView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = 3;
        this.f51648e = context;
        j();
    }
}
