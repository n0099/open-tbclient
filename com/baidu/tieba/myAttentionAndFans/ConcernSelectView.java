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
/* loaded from: classes4.dex */
public class ConcernSelectView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f18693e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18694f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f18695g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18696h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18697i;
    public TextView j;
    public View k;
    public LinearLayout l;
    public Animation m;
    public Animation n;
    public boolean o;
    public g p;
    public int q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f18698e;

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
            this.f18698e = concernSelectView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "1"));
                int i2 = this.f18698e.l.getVisibility() == 0 ? 1 : 0;
                ConcernSelectView concernSelectView = this.f18698e;
                concernSelectView.g(concernSelectView.l, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f18699e;

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
            this.f18699e = concernSelectView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "2"));
                SkinManager.setViewTextColor(this.f18699e.f18697i, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f18699e.j, R.color.CAM_X0107);
                if (FollowListSwitch.isOn()) {
                    this.f18699e.f18696h.setText(R.string.self_attention);
                } else {
                    this.f18699e.f18696h.setText(R.string.all_concerned);
                }
                if (this.f18699e.p != null) {
                    this.f18699e.p.a(0);
                }
                ConcernSelectView concernSelectView = this.f18699e;
                concernSelectView.g(concernSelectView.l, 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f18700e;

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
            this.f18700e = concernSelectView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12774").param("obj_locate", "3"));
                SkinManager.setViewTextColor(this.f18700e.f18697i, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f18700e.j, R.color.CAM_X0105);
                this.f18700e.f18696h.setText(R.string.each_concerned);
                if (this.f18700e.p != null) {
                    this.f18700e.p.a(1);
                }
                ConcernSelectView concernSelectView = this.f18700e;
                concernSelectView.g(concernSelectView.l, 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f18701a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f18702b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f18703c;

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
            this.f18703c = concernSelectView;
            this.f18701a = i2;
            this.f18702b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                boolean z = this.f18701a == 0;
                if (z && (view = this.f18702b) != null && (view.getParent() instanceof ListView)) {
                    ListView listView = (ListView) this.f18702b.getParent();
                    int bottom = this.f18702b.getBottom();
                    Rect rect = new Rect();
                    boolean globalVisibleRect = this.f18702b.getGlobalVisibleRect(rect);
                    Rect rect2 = new Rect();
                    listView.getGlobalVisibleRect(rect2);
                    if (!globalVisibleRect) {
                        listView.smoothScrollBy(bottom, 260);
                    } else if (rect2.bottom == rect.bottom) {
                        listView.smoothScrollBy(bottom, 260);
                    }
                }
                if (this.f18703c.p != null) {
                    this.f18703c.p.onExpand(z);
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

    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f18704a;

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
            this.f18704a = concernSelectView;
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
                this.f18704a.o = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConcernSelectView f18705a;

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
            this.f18705a = concernSelectView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f18705a.o = true;
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

    /* loaded from: classes4.dex */
    public interface g {
        void a(int i2);

        void onExpand(boolean z);
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
        this.q = 3;
        this.f18693e = context;
        k();
    }

    public final void g(View view, int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) || view == null || view.getAnimation() != null || (linearLayout = this.l) == null) {
            return;
        }
        int childCount = linearLayout.getChildCount();
        if (childCount < 0) {
            childCount = 0;
        }
        d.a.p0.z1.a aVar = new d.a.p0.z1.a(view, i2, (((int) this.f18693e.getResources().getDimension(R.dimen.tbds80)) + ((int) this.f18693e.getResources().getDimension(R.dimen.ds1))) * childCount);
        if (i2 == 0 && view.getVisibility() != 0) {
            view.setVisibility(0);
        }
        aVar.setDuration(260L);
        aVar.setAnimationListener(new d(this, i2, view));
        view.startAnimation(aVar);
        ImageView imageView = this.f18695g;
        if (imageView != null) {
            if (imageView.getAnimation() == null || this.f18695g.getAnimation().hasEnded()) {
                if (i2 == 0) {
                    if (this.m == null) {
                        j();
                    }
                    Animation animation = this.n;
                    if (animation != null) {
                        animation.cancel();
                    }
                    this.f18695g.startAnimation(this.m);
                    return;
                }
                if (this.n == null) {
                    i();
                }
                Animation animation2 = this.m;
                if (animation2 != null) {
                    animation2.cancel();
                }
                this.f18695g.startAnimation(this.n);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.l.getVisibility() == 0) {
                g(this.l, 1);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f18693e, R.anim.rotate_collapse);
            this.n = loadAnimation;
            loadAnimation.setAnimationListener(new e(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f18693e, R.anim.rotate_expand);
            this.m = loadAnimation;
            loadAnimation.setAnimationListener(new f(this));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LayoutInflater.from(this.f18693e).inflate(R.layout.concern_select_layout, this);
            this.f18694f = (LinearLayout) findViewById(R.id.expandable_area);
            this.f18695g = (ImageView) findViewById(R.id.expandable_btn);
            this.l = (LinearLayout) findViewById(R.id.menu_list);
            this.f18696h = (TextView) findViewById(R.id.menu_title);
            this.f18697i = (TextView) findViewById(R.id.all_concerned_item);
            if (FollowListSwitch.isOn()) {
                this.f18696h.setText(R.string.self_attention);
                this.f18697i.setText(R.string.self_attention);
            }
            this.j = (TextView) findViewById(R.id.each_concerned_item);
            this.k = findViewById(R.id.item_divider_line);
            this.f18694f.setOnClickListener(new a(this));
            this.f18697i.setOnClickListener(new b(this));
            this.j.setOnClickListener(new c(this));
            m(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.q == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f18695g, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f18696h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f18697i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107);
        SkinManager.setBackgroundResource(this.l, R.drawable.concern_item_bg);
        SkinManager.setBackgroundResource(this.f18696h, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.f18697i, R.drawable.concern_item_menu_select_bg);
        SkinManager.setBackgroundResource(this.j, R.drawable.concern_item_menu_select_bg);
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0204);
    }

    public void setOnExpandListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.p = gVar;
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
        this.q = 3;
        this.f18693e = context;
        k();
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
        this.q = 3;
        this.f18693e = context;
        k();
    }
}
