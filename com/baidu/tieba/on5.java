package com.baidu.tieba;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.view.SplashAdView;
import com.baidu.tieba.advert.sdk.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class on5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;
    public String b;
    public WeakReference<SplashAdView> c;

    /* loaded from: classes5.dex */
    public class a implements CustomMessageTask.CustomRunnable<yx4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ on5 a;

        public a(on5 on5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = on5Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<yx4> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getCmd() == 2016310) {
                    try {
                        return new CustomResponsedMessage<>(2016310, this.a.f(customMessage.getData()));
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements vn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SplashAdView a;
        public final /* synthetic */ on5 b;

        public b(on5 on5Var, SplashAdView splashAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on5Var, splashAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = on5Var;
            this.a = splashAdView;
        }

        @Override // com.baidu.tieba.vn5
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, str));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_ADVERTSDK_CLICK);
                statisticItem.param("obj_source", str);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.vn5
        public void b(rn5 rn5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rn5Var) == null) {
            }
        }

        @Override // com.baidu.tieba.vn5
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.vn5
        public void d() {
            sn5 entryInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SplashAdView splashAdView = (SplashAdView) this.b.c.get();
                if (splashAdView != null) {
                    this.b.b = this.a.g();
                    on5 on5Var = this.b;
                    on5Var.h(on5Var.b);
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_ADVERTSDK_SHOW);
                if (splashAdView != null && (entryInfoData = splashAdView.getEntryInfoData()) != null) {
                    if (entryInfoData.d()) {
                        statisticItem.param("obj_source", entryInfoData.e);
                    } else {
                        statisticItem.param("obj_source", entryInfoData.b);
                    }
                }
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.vn5
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(on5 on5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements CountDownTextView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(on5 on5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.d
        public void onTimeout(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://timeout"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<CountDownTextView> a;

        public /* synthetic */ e(CountDownTextView countDownTextView, a aVar) {
            this(countDownTextView);
        }

        public void a(String str) {
            CountDownTextView countDownTextView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (countDownTextView = this.a.get()) == null) {
                return;
            }
            countDownTextView.d(str, 0);
        }

        public e(CountDownTextView countDownTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {countDownTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(countDownTextView);
        }
    }

    public on5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
    }

    public final View f(yx4 yx4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, yx4Var)) == null) {
            if (yx4Var == null || !yx4Var.c()) {
                return null;
            }
            Activity pageActivity = yx4Var.getContext().getPageActivity();
            int a2 = yx4Var.a();
            int b2 = yx4Var.b();
            SplashAdView splashAdView = new SplashAdView(yx4Var.getContext(), "1481698145541", AdType.SPLASH, a2, b2, RedirectType.APPMANAGE);
            splashAdView.setLayoutParams(new RelativeLayout.LayoutParams(b2, a2));
            this.c = new WeakReference<>(splashAdView);
            splashAdView.setBCAdCallBack(new b(this, splashAdView));
            try {
                z = splashAdView.f();
            } catch (Throwable unused) {
                z = false;
            }
            if (z) {
                try {
                    int dimension = (int) pageActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070279);
                    int dimension2 = (int) pageActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070215);
                    Activity pageActivity2 = yx4Var.getContext().getPageActivity();
                    if (UtilHelper.isNotchScreen(pageActivity2) || UtilHelper.isCutoutScreen(pageActivity2)) {
                        dimension2 += ri.s(pageActivity2);
                    }
                    int dimension3 = (int) pageActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070207);
                    int dimension4 = (int) pageActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070232);
                    int dimension5 = (int) pageActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f0702d7);
                    CountDownTextView countDownTextView = new CountDownTextView(pageActivity);
                    this.a = new e(countDownTextView, null);
                    String str = this.b;
                    if (TextUtils.isEmpty(str)) {
                        str = pageActivity.getResources().getString(R.string.obfuscated_res_0x7f0f11a4);
                    }
                    if (splashAdView.n) {
                        countDownTextView.d(str, 6);
                    } else {
                        countDownTextView.d(str, 3);
                    }
                    splashAdView.setTag(Boolean.valueOf(splashAdView.n));
                    float f = dimension;
                    countDownTextView.setTextSize(0, f);
                    countDownTextView.setTextColor(Color.parseColor("#ffffff"));
                    countDownTextView.setGravity(17);
                    countDownTextView.setAlpha(0.5f);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(Color.parseColor("#000000"));
                    gradientDrawable.setCornerRadius(pageActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070224));
                    gradientDrawable.setStroke(1, Color.parseColor("#000000"));
                    countDownTextView.setBackgroundDrawable(gradientDrawable);
                    countDownTextView.setOnClickListener(new c(this));
                    countDownTextView.setTimeoutListener(new d(this));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimension4, dimension5);
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    layoutParams.setMargins(0, dimension2, dimension3, 0);
                    int f2 = ri.f(pageActivity, R.dimen.obfuscated_res_0x7f070307);
                    countDownTextView.setPadding(f2, f2, f2, f2);
                    splashAdView.addView(countDownTextView, layoutParams);
                    int dimension6 = (int) pageActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f9);
                    TextView textView = new TextView(pageActivity);
                    textView.setText(R.string.obfuscated_res_0x7f0f00dd);
                    textView.setTextSize(0, f);
                    textView.setAlpha(0.5f);
                    textView.setIncludeFontPadding(false);
                    textView.setGravity(17);
                    textView.setBackgroundDrawable(gradientDrawable.getConstantState().newDrawable());
                    int f3 = ri.f(pageActivity, R.dimen.obfuscated_res_0x7f0701d4);
                    textView.setPadding(f3, f3, f3, f3);
                    SkinManager.setViewTextColor(textView, (int) R.color.common_color_10013);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) pageActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070261), (int) pageActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070225));
                    layoutParams2.setMargins(dimension6, 0, 0, dimension6);
                    layoutParams2.addRule(9);
                    layoutParams2.addRule(12);
                    splashAdView.addView(textView, layoutParams2);
                } catch (Exception unused2) {
                }
                return splashAdView;
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016310, new a(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.a(str);
    }
}
