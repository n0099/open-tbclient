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
import c.a.d.f.p.n;
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
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.GuideScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class GuidePopupWindow extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForegroundColorSpan A;
    public ForegroundColorSpan B;
    public String C;
    public String D;
    public boolean E;
    public View.OnClickListener F;
    public View.OnClickListener G;
    public View.OnClickListener H;
    public View.OnClickListener I;
    public View.OnClickListener J;
    public View.OnClickListener K;
    public GuideScrollView.a L;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f36886b;

    /* renamed from: c  reason: collision with root package name */
    public HeadPendantView f36887c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36888d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36889e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f36890f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f36891g;

    /* renamed from: h  reason: collision with root package name */
    public View f36892h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public RelativeLayout r;
    public RelativeLayout s;
    public RelativeLayout t;
    public RelativeLayout u;
    public TBSpecificationBtn v;
    public TBSpecificationBtn w;
    public GuideScrollView x;
    public View y;
    public HeadBorder z;

    /* loaded from: classes6.dex */
    public static class HeadBorder extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Paint a;

        /* renamed from: b  reason: collision with root package name */
        public int f36893b;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public HeadBorder(Context context) {
            this(context, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f36893b, this.a);
            }
        }

        public void setBorderColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.setColor(i);
            }
        }

        public void setBorderWidth(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                this.a.setStrokeWidth(f2);
            }
        }

        public void setRedio(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.f36893b = i;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeadBorder(Context context, @Nullable AttributeSet attributeSet, int i) {
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
            Paint paint = new Paint();
            this.a = paint;
            paint.setAntiAlias(true);
            this.a.setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuidePopupWindow a;

        public a(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(ForumBroadcastHelper.KEY_PARMARS_FORUM_ID, this.a.C);
                hashMap.put("forumName", this.a.D);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", Boolean.FALSE);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a, "BarBroadcastEditPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.o0.z.b.d() != null && c.a.o0.z.b.d().e() != null) {
                    statisticItem.param("uid", c.a.o0.z.b.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.C);
                statisticItem.param("obj_locate", 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuidePopupWindow a;

        public b(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.a.C);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a, "RecommendHistoryPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.o0.z.b.d() != null && c.a.o0.z.b.d().e() != null) {
                    statisticItem.param("uid", c.a.o0.z.b.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.C);
                statisticItem.param("obj_locate", 4);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuidePopupWindow a;

        public c(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.a.C);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a, "DataCenterPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.o0.z.b.d() != null && c.a.o0.z.b.d().e() != null) {
                    statisticItem.param("uid", c.a.o0.z.b.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.C);
                statisticItem.param("obj_locate", 3);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuidePopupWindow a;

        public d(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.a.C);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a, "ForumSectionPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.o0.z.b.d() != null && c.a.o0.z.b.d().e() != null) {
                    statisticItem.param("uid", c.a.o0.z.b.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.C);
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuidePopupWindow a;

        public e(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.a.C);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a, "ForumDetailPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.o0.z.b.d() != null && c.a.o0.z.b.d().e() != null) {
                    statisticItem.param("uid", c.a.o0.z.b.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.C);
                statisticItem.param("obj_locate", 6);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GuidePopupWindow a;

        public f(GuidePopupWindow guidePopupWindow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guidePopupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.dismiss();
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (c.a.o0.z.b.d() != null && c.a.o0.z.b.d().e() != null) {
                    statisticItem.param("uid", c.a.o0.z.b.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.C);
                statisticItem.param("obj_locate", 5);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GuidePopupWindow f36894b;

        public g(GuidePopupWindow guidePopupWindow, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {guidePopupWindow, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36894b = guidePopupWindow;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36894b.f36890f.setText(this.f36894b.h(this.a));
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = guidePopupWindow;
        }

        @Override // com.baidu.tieba.view.GuideScrollView.a
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a.y.setAlpha(this.a.x.getScrollY() / 150.0f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuidePopupWindow(Context context) {
        super(context, R.style.obfuscated_res_0x7f1003a2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = new a(this);
        this.G = new b(this);
        this.H = new c(this);
        this.I = new d(this);
        this.J = new e(this);
        this.K = new f(this);
        this.L = new h(this);
        this.a = context;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0395, (ViewGroup) null);
        this.f36886b = inflate;
        inflate.setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
        getWindow().setDimAmount(0.0f);
        i();
        j();
    }

    public final String h(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            String w = w(list, 0, true);
            if (v(w) < this.f36890f.getWidth()) {
                return w;
            }
            for (int i = 5; 1 < i; i--) {
                String w2 = w(list, i, false);
                if (v(w2) < this.f36890f.getWidth()) {
                    return w2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            GuideScrollView guideScrollView = (GuideScrollView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f090cfd);
            this.x = guideScrollView;
            guideScrollView.setScrollChangedListener(this.L);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(1000L);
            this.f36886b.startAnimation(alphaAnimation);
            HeadPendantView headPendantView = (HeadPendantView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f0922a1);
            this.f36887c = headPendantView;
            headPendantView.setHasPendantStyle();
            this.f36887c.setDefalutResid(R.drawable.obfuscated_res_0x7f080481);
            this.f36887c.getHeadView().setIsRound(true);
            this.f36887c.getHeadView().setDrawBorder(true);
            this.f36887c.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f36887c.setShowSimpleIcon(true);
            this.f36888d = (ImageView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f0922b7);
            this.f36889e = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f0922bb);
            this.f36890f = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f0922d8);
            this.f36891g = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f0922d7);
            this.f36892h = this.f36886b.findViewById(R.id.obfuscated_res_0x7f090cfe);
            this.i = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f090c27);
            this.r = (RelativeLayout) this.f36886b.findViewById(R.id.obfuscated_res_0x7f09180c);
            this.j = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f09180f);
            this.k = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f09180d);
            this.s = (RelativeLayout) this.f36886b.findViewById(R.id.obfuscated_res_0x7f091818);
            this.l = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f09181b);
            this.m = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f091819);
            this.t = (RelativeLayout) this.f36886b.findViewById(R.id.obfuscated_res_0x7f091810);
            this.n = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f091813);
            this.o = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f091811);
            this.u = (RelativeLayout) this.f36886b.findViewById(R.id.obfuscated_res_0x7f091814);
            this.p = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f091817);
            this.q = (TextView) this.f36886b.findViewById(R.id.obfuscated_res_0x7f091815);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f36886b.findViewById(R.id.obfuscated_res_0x7f090414);
            this.v = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds42);
            c.a.o0.r.l0.n.c cVar = new c.a.o0.r.l0.n.c();
            cVar.p(R.color.CAM_X0302);
            this.v.setConfig(cVar);
            this.v.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07eb));
            this.w = (TBSpecificationBtn) this.f36886b.findViewById(R.id.obfuscated_res_0x7f090419);
            c.a.o0.r.l0.n.c cVar2 = new c.a.o0.r.l0.n.c();
            cVar2.p(R.color.CAM_X0618);
            this.w.setConfig(cVar2);
            this.w.setTextSize(R.dimen.tbds42);
            this.w.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07ef));
            View findViewById = this.f36886b.findViewById(R.id.obfuscated_res_0x7f091cb5);
            this.y = findViewById;
            findViewById.setAlpha(0.0f);
            HeadBorder headBorder = (HeadBorder) this.f36886b.findViewById(R.id.obfuscated_res_0x7f090d1c);
            this.z = headBorder;
            headBorder.setBorderColor(SkinManager.getColor(R.color.CAM_X0614));
            this.z.setBorderWidth(this.a.getResources().getDimensionPixelSize(R.dimen.tbds10));
            this.z.setRedio(n.f(this.a, R.dimen.tbds119));
            n();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.A = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302));
            this.B = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302));
            SkinManager.setBackgroundResource(this.f36886b, R.color.CAM_X0609);
            SkinManager.setViewTextColor(this.f36889e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f36891g, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f36892h, R.color.CAM_X0616);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f36890f, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.w, (int) R.color.cp_cont_a_alpha20);
            int f2 = n.f(this.a, R.dimen.tbds60);
            SkinManager.setBackgroundShapeDrawable(this.v, f2, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0302, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundShapeDrawable(this.w, f2, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0618, R.color.CAM_X0618, 1);
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            TextView textView = this.f36890f;
            textView.setText("认证：" + str + getContext().getResources().getString(R.string.obfuscated_res_0x7f0f07ec));
        }
    }

    public void l(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        List<String> list2 = null;
        if (list.size() > 3) {
            this.E = true;
            list2 = list.subList(0, 3);
        }
        if (list2 != null) {
            list = list2;
        }
        m(list);
    }

    public final void m(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f36890f.post(new g(this, list));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.r.setOnClickListener(this.F);
            this.s.setOnClickListener(this.G);
            this.t.setOnClickListener(this.H);
            this.u.setOnClickListener(this.I);
            this.v.setOnClickListener(this.J);
            this.w.setOnClickListener(this.K);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.C = String.valueOf(i);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(this.f36886b);
            getWindow().setLayout(-1, -1);
            c.a.p0.l4.e.b(1, getWindow().getAttributes(), getWindow());
        }
    }

    public void p(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07e8));
            int length = StringHelper.numberUniformFormatExtraWithRoundFloat(j).length();
            spannableStringBuilder.append((CharSequence) StringHelper.numberUniformFormatExtraWithRoundFloat(j));
            spannableStringBuilder.append((CharSequence) this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07e9));
            int length2 = StringHelper.numberUniformFormatExtraWithRoundFloat(j2).length();
            spannableStringBuilder.append((CharSequence) StringHelper.numberUniformFormatExtraWithRoundFloat(j2));
            spannableStringBuilder.append((CharSequence) this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07ea));
            int i = length + 14;
            spannableStringBuilder.setSpan(this.A, 14, i, 18);
            spannableStringBuilder.setSpan(this.B, i + 8, length + 22 + length2, 18);
            this.f36891g.setText(spannableStringBuilder);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || c.a.o0.z.b.d() == null || c.a.o0.z.b.d().e() == null) {
            return;
        }
        this.f36887c.n(c.a.o0.z.b.d().e());
    }

    public void r(UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, userData) == null) || userData == null) {
            return;
        }
        this.f36887c.n(userData);
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f36887c.setIsclearmode(true);
            this.f36888d.setImageResource(UtilHelper.getBazhuIconId(str, false));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || c.a.o0.z.b.d() == null || c.a.o0.z.b.d().e() == null) {
            return;
        }
        this.f36889e.setText(c.a.o0.z.b.d().e().getName_show());
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.D = str;
        }
    }

    public final int v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            Float valueOf = Float.valueOf(0.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                valueOf = Float.valueOf(this.f36890f.getLetterSpacing());
            }
            return ((str.length() - 1) * ((int) (valueOf.floatValue() + 0.5f))) + ((int) (this.f36890f.getPaint().measureText(str) + 0.5f));
        }
        return invokeL.intValue;
    }

    public final String w(List<String> list, int i, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("认证：");
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str2 = list.get(i2);
                if (z) {
                    str = str2 + getContext().getResources().getString(R.string.obfuscated_res_0x7f0f07ec);
                } else if (str2.length() > i) {
                    str = str2.substring(0, i - 1) + getContext().getResources().getString(R.string.obfuscated_res_0x7f0f07ed);
                } else {
                    str = str2 + getContext().getResources().getString(R.string.obfuscated_res_0x7f0f07ec);
                }
                sb.append(str + "    ");
            }
            if (this.E) {
                return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.obfuscated_res_0x7f0f07ee);
            }
            return sb.toString().substring(0, sb.toString().length() - 4);
        }
        return (String) invokeCommon.objValue;
    }
}
