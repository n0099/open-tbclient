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
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.k6a;
import com.baidu.tieba.ma5;
import com.baidu.tieba.sk5;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.GuideScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class GuidePopupWindow extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GridLayout A;
    public ImageView B;
    public ImageView C;
    public ImageView D;
    public ImageView E;
    public ForegroundColorSpan F;
    public ForegroundColorSpan G;
    public String H;
    public String I;
    public boolean J;
    public View.OnClickListener K;
    public View.OnClickListener L;
    public View.OnClickListener M;
    public View.OnClickListener N;
    public View.OnClickListener O;
    public View.OnClickListener P;
    public GuideScrollView.a Q;
    public Context a;
    public View b;
    public HeadPendantView c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
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

    /* loaded from: classes8.dex */
    public static class HeadBorder extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Paint a;
        public int b;

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

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.b, this.a);
            }
        }

        public void setBorderColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.setColor(i);
            }
        }

        public void setBorderWidth(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
                this.a.setStrokeWidth(f);
            }
        }

        public void setRedio(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.b = i;
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(ForumBroadcastHelper.KEY_PARMARS_FORUM_ID, this.a.H);
                hashMap.put("forumName", this.a.I);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", Boolean.FALSE);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a, "BarBroadcastEditPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (sk5.d() != null && sk5.d().e() != null) {
                    statisticItem.param("uid", sk5.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.H);
                statisticItem.param("obj_locate", 1);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.a.H);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a, "RecommendHistoryPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (sk5.d() != null && sk5.d().e() != null) {
                    statisticItem.param("uid", sk5.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.H);
                statisticItem.param("obj_locate", 4);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.a.H);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a, "DataCenterPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (sk5.d() != null && sk5.d().e() != null) {
                    statisticItem.param("uid", sk5.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.H);
                statisticItem.param("obj_locate", 3);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.a.H);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a, "ForumSectionPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (sk5.d() != null && sk5.d().e() != null) {
                    statisticItem.param("uid", sk5.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.H);
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", this.a.H);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a, "ForumDetailPage", hashMap)));
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (sk5.d() != null && sk5.d().e() != null) {
                    statisticItem.param("uid", sk5.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.H);
                statisticItem.param("obj_locate", 6);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                StatisticItem statisticItem = new StatisticItem("c13887");
                if (sk5.d() != null && sk5.d().e() != null) {
                    statisticItem.param("uid", sk5.d().e().getUserId());
                }
                statisticItem.param("fid", this.a.H);
                statisticItem.param("obj_locate", 5);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ GuidePopupWindow b;

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
            this.b = guidePopupWindow;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.f.setText(this.b.h(this.a));
            }
        }
    }

    /* loaded from: classes8.dex */
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
        super(context, R.style.obfuscated_res_0x7f1003c3);
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
        this.K = new a(this);
        this.L = new b(this);
        this.M = new c(this);
        this.N = new d(this);
        this.O = new e(this);
        this.P = new f(this);
        this.Q = new h(this);
        this.a = context;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.guide_popup_window, (ViewGroup) null);
        this.b = inflate;
        inflate.setSystemUiVisibility(1028);
        getWindow().setDimAmount(0.0f);
        i();
        j();
    }

    public void n(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || list == null) {
            return;
        }
        List<String> list2 = null;
        if (list.size() > 3) {
            this.J = true;
            list2 = list.subList(0, 3);
        }
        if (list2 != null) {
            list = list2;
        }
        o(list);
    }

    public final void o(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f.post(new g(this, list));
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.H = String.valueOf(i);
        }
    }

    public void t(UserData userData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, userData) == null) && userData != null) {
            this.c.o(userData);
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.c.setIsclearmode(true);
            this.d.setImageResource(UtilHelper.getBazhuIconId(str, false));
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.I = str;
        }
    }

    public final String h(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            String z = z(list, 0, true);
            if (y(z) < this.f.getWidth()) {
                return z;
            }
            for (int i = 5; 1 < i; i--) {
                String z2 = z(list, i, false);
                if (y(z2) < this.f.getWidth()) {
                    return z2;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            TextView textView = this.f;
            textView.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(this.b);
            getWindow().setLayout(-1, -1);
            k6a.b(1, getWindow().getAttributes(), getWindow());
            GreyUtil.grey(this);
        }
    }

    public final int y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            Float valueOf = Float.valueOf(0.0f);
            if (Build.VERSION.SDK_INT >= 21) {
                valueOf = Float.valueOf(this.f.getLetterSpacing());
            }
            return ((str.length() - 1) * ((int) (valueOf.floatValue() + 0.5f))) + ((int) (this.f.getPaint().measureText(str) + 0.5f));
        }
        return invokeL.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            GuideScrollView guideScrollView = (GuideScrollView) this.b.findViewById(R.id.guid_popup_window_container);
            this.x = guideScrollView;
            guideScrollView.setScrollChangedListener(this.Q);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(1000L);
            this.b.startAnimation(alphaAnimation);
            HeadPendantView headPendantView = (HeadPendantView) this.b.findViewById(R.id.user_head);
            this.c = headPendantView;
            headPendantView.setHasPendantStyle();
            this.c.setDefalutResid(R.drawable.default_head);
            this.c.getHeadView().setIsRound(true);
            this.c.getHeadView().setDrawBorder(true);
            this.c.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.setShowSimpleIcon(true);
            this.d = (ImageView) this.b.findViewById(R.id.user_leavel);
            this.e = (TextView) this.b.findViewById(R.id.user_name);
            this.f = (TextView) this.b.findViewById(R.id.user_tb_list);
            this.g = (TextView) this.b.findViewById(R.id.user_tb_concern_info);
            this.h = this.b.findViewById(R.id.guid_popup_window_line);
            this.i = (TextView) this.b.findViewById(R.id.function_desc);
            this.r = (RelativeLayout) this.b.findViewById(R.id.personalba_broadcast);
            this.j = (TextView) this.b.findViewById(R.id.personalba_broadcast_name);
            this.k = (TextView) this.b.findViewById(R.id.personalba_broadcast_digest);
            this.s = (RelativeLayout) this.b.findViewById(R.id.personalba_recommend);
            this.l = (TextView) this.b.findViewById(R.id.personalba_recommend_name);
            this.m = (TextView) this.b.findViewById(R.id.personalba_recommend_digest);
            this.t = (RelativeLayout) this.b.findViewById(R.id.personalba_data);
            this.n = (TextView) this.b.findViewById(R.id.personalba_data_name);
            this.o = (TextView) this.b.findViewById(R.id.personalba_data_digest);
            this.u = (RelativeLayout) this.b.findViewById(R.id.personalba_partition);
            this.p = (TextView) this.b.findViewById(R.id.personalba_partition_name);
            this.q = (TextView) this.b.findViewById(R.id.personalba_partition_digest);
            this.A = (GridLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090d9c);
            this.B = (ImageView) this.b.findViewById(R.id.personalba_broadcast_img);
            this.D = (ImageView) this.b.findViewById(R.id.personalba_recommend_img);
            this.C = (ImageView) this.b.findViewById(R.id.personalba_partition_img);
            this.E = (ImageView) this.b.findViewById(R.id.personalba_data_img);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.b.findViewById(R.id.btn_go_away);
            this.v = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds42);
            ma5 ma5Var = new ma5();
            ma5Var.q(R.color.CAM_X0302);
            this.v.setConfig(ma5Var);
            this.v.setText(this.a.getResources().getString(R.string.guide_popup_window_go_away));
            this.w = (TBSpecificationBtn) this.b.findViewById(R.id.btn_known);
            ma5 ma5Var2 = new ma5();
            ma5Var2.q(R.color.CAM_X0618);
            this.w.setConfig(ma5Var2);
            this.w.setTextSize(R.dimen.tbds42);
            this.w.setText(this.a.getResources().getString(R.string.guide_popup_window_known));
            View findViewById = this.b.findViewById(R.id.shadow_top);
            this.y = findViewById;
            findViewById.setAlpha(0.0f);
            HeadBorder headBorder = (HeadBorder) this.b.findViewById(R.id.head_border);
            this.z = headBorder;
            headBorder.setBorderColor(SkinManager.getColor(R.color.CAM_X0614));
            this.z.setBorderWidth(this.a.getResources().getDimensionPixelSize(R.dimen.tbds10));
            this.z.setRedio(vi.g(this.a, R.dimen.tbds119));
            p();
            l();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.F = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302));
            this.G = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302));
            SkinManager.setBackgroundResource(this.b, R.color.CAM_X0609);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.h, R.color.CAM_X0616);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.w, (int) R.color.cp_cont_a_alpha20);
            int g2 = vi.g(this.a, R.dimen.tbds60);
            SkinManager.setBackgroundShapeDrawable(this.v, g2, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0302, R.color.CAM_X0302, 1);
            SkinManager.setBackgroundShapeDrawable(this.w, g2, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0618, R.color.CAM_X0618, 1);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && sk5.d() != null && sk5.d().e() != null) {
            this.c.o(sk5.d().e());
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && sk5.d() != null && sk5.d().e() != null) {
            this.e.setText(sk5.d().e().getName_show());
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int l = vi.l(TbadkCoreApplication.getInst());
            int i = (int) (l * 0.04f);
            int i2 = l - (i * 2);
            GuideScrollView guideScrollView = this.x;
            if (guideScrollView != null && (guideScrollView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.x.getLayoutParams();
                layoutParams.setMargins(i, layoutParams.topMargin, i, layoutParams.bottomMargin);
            }
            w(this.w, 0.45f, i2);
            w(this.v, 0.45f, i2);
            w(this.A, 0.94f, i2);
            w(this.r, 0.47f, i2);
            w(this.s, 0.47f, i2);
            w(this.t, 0.47f, i2);
            w(this.u, 0.47f, i2);
            w(this.B, 0.23f, i2);
            w(this.C, 0.23f, i2);
            w(this.D, 0.23f, i2);
            w(this.E, 0.23f, i2);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.r.setOnClickListener(this.K);
            this.s.setOnClickListener(this.L);
            this.t.setOnClickListener(this.M);
            this.u.setOnClickListener(this.N);
            this.v.setOnClickListener(this.O);
            this.w.setOnClickListener(this.P);
        }
    }

    public void r(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.a.getResources().getString(R.string.guide_popup_window_concern_desc1));
            int length = StringHelper.numberUniformFormatExtraWithRoundFloat(j).length();
            spannableStringBuilder.append((CharSequence) StringHelper.numberUniformFormatExtraWithRoundFloat(j));
            spannableStringBuilder.append((CharSequence) this.a.getResources().getString(R.string.guide_popup_window_concern_desc2));
            int length2 = StringHelper.numberUniformFormatExtraWithRoundFloat(j2).length();
            spannableStringBuilder.append((CharSequence) StringHelper.numberUniformFormatExtraWithRoundFloat(j2));
            spannableStringBuilder.append((CharSequence) this.a.getResources().getString(R.string.guide_popup_window_concern_desc3));
            int i = length + 14;
            spannableStringBuilder.setSpan(this.F, 14, i, 18);
            spannableStringBuilder.setSpan(this.G, i + 8, length + 22 + length2, 18);
            this.g.setText(spannableStringBuilder);
        }
    }

    public final void w(View view2, float f2, int i) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{view2, Float.valueOf(f2), Integer.valueOf(i)}) == null) && view2 != null && i > 0 && f2 > 0.0f && (layoutParams = view2.getLayoutParams()) != null) {
            layoutParams.width = (int) (f2 * i);
            view2.setLayoutParams(layoutParams);
        }
    }

    public final String z(List<String> list, int i, boolean z) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("认证：");
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str2 = list.get(i2);
                if (z) {
                    str = str2 + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner);
                } else if (str2.length() > i) {
                    str = str2.substring(0, i - 1) + getContext().getResources().getString(R.string.guide_popup_window_join_field_bars_owner);
                } else {
                    str = str2 + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner);
                }
                sb.append(str + "    ");
            }
            if (this.J) {
                return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
            }
            return sb.toString().substring(0, sb.toString().length() - 4);
        }
        return (String) invokeCommon.objValue;
    }
}
