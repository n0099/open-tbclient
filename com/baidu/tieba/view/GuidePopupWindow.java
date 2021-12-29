package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.w3.j0.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.view.GuideScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes12.dex */
public class GuidePopupWindow extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn A;
    public GuideScrollView B;
    public View C;
    public HeadBorder D;
    public ForegroundColorSpan E;
    public ForegroundColorSpan F;
    public String G;
    public String H;
    public boolean I;
    public View.OnClickListener J;
    public View.OnClickListener K;
    public View.OnClickListener L;
    public View.OnClickListener M;
    public View.OnClickListener N;
    public View.OnClickListener O;
    public GuideScrollView.a P;

    /* renamed from: e  reason: collision with root package name */
    public Context f51048e;

    /* renamed from: f  reason: collision with root package name */
    public View f51049f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantView f51050g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f51051h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51052i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f51053j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f51054k;
    public View l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public RelativeLayout v;
    public RelativeLayout w;
    public RelativeLayout x;
    public RelativeLayout y;
    public TBSpecificationBtn z;

    /* loaded from: classes12.dex */
    public static class HeadBorder extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Paint f51055e;

        /* renamed from: f  reason: collision with root package name */
        public int f51056f;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public HeadBorder(Context context) {
            this(context, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f51056f, this.f51055e);
            }
        }

        public void setBorderColor(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f51055e.setColor(i2);
            }
        }

        public void setBorderWidth(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                this.f51055e.setStrokeWidth(f2);
            }
        }

        public void setRedio(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.f51056f = i2;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public HeadBorder(Context context, @Nullable AttributeSet attributeSet) {
            this(context, attributeSet, 0);
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
                    this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeadBorder(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
            Paint paint = new Paint();
            this.f51055e = paint;
            paint.setAntiAlias(true);
            this.f51055e.setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuidePopupWindow f51057e;

        public a(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51057e = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(ForumBroadcastHelper.KEY_PARMARS_FORUM_ID, this.f51057e.G);
                hashMap.put("forumName", this.f51057e.H);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", Boolean.FALSE);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f51057e.f51048e, "BarBroadcastEditPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.s0.a0.b.a() != null && c.a.s0.a0.b.a().b() != null) {
                    statisticItem.param("uid", c.a.s0.a0.b.a().b().getUserId());
                }
                statisticItem.param("fid", this.f51057e.G);
                statisticItem.param("obj_locate", 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuidePopupWindow f51058e;

        public b(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51058e = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.f51058e.G);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f51058e.f51048e, "RecommendHistoryPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.s0.a0.b.a() != null && c.a.s0.a0.b.a().b() != null) {
                    statisticItem.param("uid", c.a.s0.a0.b.a().b().getUserId());
                }
                statisticItem.param("fid", this.f51058e.G);
                statisticItem.param("obj_locate", 4);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuidePopupWindow f51059e;

        public c(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51059e = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.f51059e.G);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f51059e.f51048e, "DataCenterPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.s0.a0.b.a() != null && c.a.s0.a0.b.a().b() != null) {
                    statisticItem.param("uid", c.a.s0.a0.b.a().b().getUserId());
                }
                statisticItem.param("fid", this.f51059e.G);
                statisticItem.param("obj_locate", 3);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuidePopupWindow f51060e;

        public d(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51060e = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.f51060e.G);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f51060e.f51048e, "ForumSectionPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.s0.a0.b.a() != null && c.a.s0.a0.b.a().b() != null) {
                    statisticItem.param("uid", c.a.s0.a0.b.a().b().getUserId());
                }
                statisticItem.param("fid", this.f51060e.G);
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuidePopupWindow f51061e;

        public e(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51061e = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.f51061e.G);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f51061e.f51048e, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.s0.a0.b.a() != null && c.a.s0.a0.b.a().b() != null) {
                    statisticItem.param("uid", c.a.s0.a0.b.a().b().getUserId());
                }
                statisticItem.param("fid", this.f51061e.G);
                statisticItem.param("obj_locate", 6);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GuidePopupWindow f51062e;

        public f(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51062e = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51062e.dismiss();
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.s0.a0.b.a() != null && c.a.s0.a0.b.a().b() != null) {
                    statisticItem.param("uid", c.a.s0.a0.b.a().b().getUserId());
                }
                statisticItem.param("fid", this.f51062e.G);
                statisticItem.param("obj_locate", 5);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f51063e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GuidePopupWindow f51064f;

        public g(GuidePopupWindow guidePopupWindow, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51064f = guidePopupWindow;
            this.f51063e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51064f.f51053j.setText(this.f51064f.h(this.f51063e));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h implements GuideScrollView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuidePopupWindow a;

        public h(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guidePopupWindow;
        }

        @Override // com.baidu.tieba.view.GuideScrollView.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.a.C.setAlpha(this.a.B.getScrollY() / 150.0f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.J = new a(this);
        this.K = new b(this);
        this.L = new c(this);
        this.M = new d(this);
        this.N = new e(this);
        this.O = new f(this);
        this.P = new h(this);
        this.f51048e = context;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.guide_popup_window, (ViewGroup) null);
        this.f51049f = inflate;
        inflate.setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
        getWindow().setDimAmount(0.0f);
        i();
        onChangeSkinType();
    }

    public final String h(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            String m = m(list, 0, true);
            if (l(m) < this.f51053j.getWidth()) {
                return m;
            }
            for (int i2 = 5; 1 < i2; i2--) {
                String m2 = m(list, i2, false);
                if (l(m2) < this.f51053j.getWidth()) {
                    return m2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            GuideScrollView guideScrollView = (GuideScrollView) this.f51049f.findViewById(R.id.guid_popup_window_container);
            this.B = guideScrollView;
            guideScrollView.setScrollChangedListener(this.P);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(1000L);
            this.f51049f.startAnimation(alphaAnimation);
            HeadPendantView headPendantView = (HeadPendantView) this.f51049f.findViewById(R.id.user_head);
            this.f51050g = headPendantView;
            headPendantView.setHasPendantStyle();
            this.f51050g.setDefalutResid(R.drawable.default_head);
            this.f51050g.getHeadView().setIsRound(true);
            this.f51050g.getHeadView().setDrawBorder(true);
            this.f51050g.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f51050g.setShowSimpleIcon(true);
            this.f51051h = (ImageView) this.f51049f.findViewById(R.id.user_leavel);
            this.f51052i = (TextView) this.f51049f.findViewById(R.id.user_name);
            this.f51053j = (TextView) this.f51049f.findViewById(R.id.user_tb_list);
            this.f51054k = (TextView) this.f51049f.findViewById(R.id.user_tb_concern_info);
            this.l = this.f51049f.findViewById(R.id.guid_popup_window_line);
            this.m = (TextView) this.f51049f.findViewById(R.id.function_desc);
            this.v = (RelativeLayout) this.f51049f.findViewById(R.id.personalba_broadcast);
            this.n = (TextView) this.f51049f.findViewById(R.id.personalba_broadcast_name);
            this.o = (TextView) this.f51049f.findViewById(R.id.personalba_broadcast_digest);
            this.w = (RelativeLayout) this.f51049f.findViewById(R.id.personalba_recommend);
            this.p = (TextView) this.f51049f.findViewById(R.id.personalba_recommend_name);
            this.q = (TextView) this.f51049f.findViewById(R.id.personalba_recommend_digest);
            this.x = (RelativeLayout) this.f51049f.findViewById(R.id.personalba_data);
            this.r = (TextView) this.f51049f.findViewById(R.id.personalba_data_name);
            this.s = (TextView) this.f51049f.findViewById(R.id.personalba_data_digest);
            this.y = (RelativeLayout) this.f51049f.findViewById(R.id.personalba_partition);
            this.t = (TextView) this.f51049f.findViewById(R.id.personalba_partition_name);
            this.u = (TextView) this.f51049f.findViewById(R.id.personalba_partition_digest);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f51049f.findViewById(R.id.btn_go_away);
            this.z = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds42);
            c.a.s0.s.i0.n.c cVar = new c.a.s0.s.i0.n.c();
            cVar.p(R.color.CAM_X0302);
            this.z.setConfig(cVar);
            this.z.setText(this.f51048e.getResources().getString(R.string.guide_popup_window_go_away));
            this.A = (TBSpecificationBtn) this.f51049f.findViewById(R.id.btn_known);
            c.a.s0.s.i0.n.c cVar2 = new c.a.s0.s.i0.n.c();
            cVar2.p(R.color.CAM_X0618);
            this.A.setConfig(cVar2);
            this.A.setTextSize(R.dimen.tbds42);
            this.A.setText(this.f51048e.getResources().getString(R.string.guide_popup_window_known));
            View findViewById = this.f51049f.findViewById(R.id.shadow_top);
            this.C = findViewById;
            findViewById.setAlpha(0.0f);
            HeadBorder headBorder = (HeadBorder) this.f51049f.findViewById(R.id.head_border);
            this.D = headBorder;
            headBorder.setBorderColor(SkinManager.getColor(R.color.CAM_X0614));
            this.D.setBorderWidth(this.f51048e.getResources().getDimensionPixelSize(R.dimen.tbds10));
            this.D.setRedio(c.a.d.f.p.n.f(this.f51048e, R.dimen.tbds119));
            k();
        }
    }

    public final void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f51053j.post(new g(this, list));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.v.setOnClickListener(this.J);
            this.w.setOnClickListener(this.K);
            this.x.setOnClickListener(this.L);
            this.y.setOnClickListener(this.M);
            this.z.setOnClickListener(this.N);
            this.A.setOnClickListener(this.O);
        }
    }

    public final int l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Float valueOf = Float.valueOf(0.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                valueOf = Float.valueOf(this.f51053j.getLetterSpacing());
            }
            return ((str.length() - 1) * ((int) (valueOf.floatValue() + 0.5f))) + ((int) (this.f51053j.getPaint().measureText(str) + 0.5f));
        }
        return invokeL.intValue;
    }

    public final String m(List<String> list, int i2, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{list, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("认证：");
            for (int i3 = 0; i3 < list.size(); i3++) {
                String str2 = list.get(i3);
                if (z) {
                    str = str2 + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner);
                } else if (str2.length() > i2) {
                    str = str2.substring(0, i2 - 1) + getContext().getResources().getString(R.string.guide_popup_window_join_field_bars_owner);
                } else {
                    str = str2 + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner);
                }
                sb.append(str + "    ");
            }
            if (this.I) {
                return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
            }
            return sb.toString().substring(0, sb.toString().length() - 4);
        }
        return (String) invokeCommon.objValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.E = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302));
            this.F = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302));
            SkinManager.setBackgroundResource(this.f51049f, R.color.CAM_X0609);
            SkinManager.setViewTextColor(this.f51052i, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f51054k, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.l, R.color.CAM_X0616);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f51053j, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.A, R.color.cp_cont_a_alpha20);
            int f2 = c.a.d.f.p.n.f(this.f51048e, R.dimen.tbds60);
            TBSpecificationBtn tBSpecificationBtn = this.z;
            int i2 = R.color.CAM_X0611;
            int i3 = R.color.CAM_X0302;
            SkinManager.setBackgroundShapeDrawable(tBSpecificationBtn, f2, i2, i2, i3, i3, 1);
            TBSpecificationBtn tBSpecificationBtn2 = this.A;
            int i4 = R.color.CAM_X0611;
            int i5 = R.color.CAM_X0618;
            SkinManager.setBackgroundShapeDrawable(tBSpecificationBtn2, f2, i4, i4, i5, i5, 1);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(this.f51049f);
            getWindow().setLayout(-1, -1);
            c.a.t0.i4.d.b(1, getWindow().getAttributes(), getWindow());
        }
    }

    public void setBaName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            TextView textView = this.f51053j;
            textView.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
        }
    }

    public void setForumId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.G = String.valueOf(i2);
        }
    }

    public void setNumber(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f51048e.getResources().getString(R.string.guide_popup_window_concern_desc1));
            int length = StringHelper.numberUniformFormatExtraWithRoundFloat(j2).length();
            spannableStringBuilder.append((CharSequence) StringHelper.numberUniformFormatExtraWithRoundFloat(j2));
            spannableStringBuilder.append((CharSequence) this.f51048e.getResources().getString(R.string.guide_popup_window_concern_desc2));
            int length2 = StringHelper.numberUniformFormatExtraWithRoundFloat(j3).length();
            spannableStringBuilder.append((CharSequence) StringHelper.numberUniformFormatExtraWithRoundFloat(j3));
            spannableStringBuilder.append((CharSequence) this.f51048e.getResources().getString(R.string.guide_popup_window_concern_desc3));
            int i2 = length + 14;
            spannableStringBuilder.setSpan(this.E, 14, i2, 18);
            spannableStringBuilder.setSpan(this.F, i2 + 8, length + 22 + length2, 18);
            this.f51054k.setText(spannableStringBuilder);
        }
    }

    public void setUserHeadImg() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || c.a.s0.a0.b.a() == null || c.a.s0.a0.b.a().b() == null) {
            return;
        }
        this.f51050g.startLoadWithPendantAndBigV(c.a.s0.a0.b.a().b());
    }

    public void setUserLeavel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.f51050g.setIsclearmode(true);
            this.f51051h.setImageResource(UtilHelper.getBazhuIconId(str, false));
        }
    }

    public void setUserNickName() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || c.a.s0.a0.b.a() == null || c.a.s0.a0.b.a().b() == null) {
            return;
        }
        this.f51052i.setText(c.a.s0.a0.b.a().b().getName_show());
    }

    public void setmForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.H = str;
        }
    }

    public void setBaName(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        List<String> list2 = null;
        if (list.size() > 3) {
            this.I = true;
            list2 = list.subList(0, 3);
        }
        if (list2 != null) {
            list = list2;
        }
        j(list);
    }

    public void setUserHeadImg(UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, userData) == null) || userData == null) {
            return;
        }
        this.f51050g.startLoadWithPendantAndBigV(userData);
    }
}
