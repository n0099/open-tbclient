package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.tieba.i33;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class zg2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i, List<ah2> list);
    }

    /* loaded from: classes7.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ Resources c;

        public a(List list, TextView textView, Resources resources) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, textView, resources};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = textView;
            this.c = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.size() > 0) {
                    this.b.setBackground(this.c.getDrawable(R.drawable.obfuscated_res_0x7f0811ab));
                } else {
                    this.b.setBackground(this.c.getDrawable(R.drawable.obfuscated_res_0x7f0811aa));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ List b;
        public final /* synthetic */ i33 c;

        public b(f fVar, List list, i33 i33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, list, i33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.b = list;
            this.c = i33Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) && this.a.a(dialogInterface, i, this.b)) {
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i33 a;
        public final /* synthetic */ DialogInterface.OnClickListener b;

        public c(i33 i33Var, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i33Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i33Var;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e(-1);
                this.b.onClick(this.a, -1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i33 a;
        public final /* synthetic */ DialogInterface.OnClickListener b;

        public d(i33 i33Var, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i33Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i33Var;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e(-2);
                this.b.onClick(this.a, -2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ Drawable c;
        public final /* synthetic */ Drawable d;
        public final /* synthetic */ int e;
        public final /* synthetic */ List f;
        public final /* synthetic */ ah2 g;
        public final /* synthetic */ View.OnClickListener h;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i, List list, ah2 ah2Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textView, drawable, drawable2, Integer.valueOf(i), list, ah2Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = textView;
            this.c = drawable;
            this.d = drawable2;
            this.e = i;
            this.f = list;
            this.g = ah2Var;
            this.h = onClickListener;
            this.a = true;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !this.a;
                this.a = z;
                TextView textView = this.b;
                if (z) {
                    drawable = this.c;
                } else {
                    drawable = this.d;
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                this.b.setCompoundDrawablePadding(this.e);
                if (this.a) {
                    this.f.add(this.g);
                } else {
                    this.f.remove(this.g);
                }
                this.h.onClick(view2);
            }
        }
    }

    @UiThread
    public static i33 a(@NonNull Activity activity, @NonNull e43 e43Var, @Nullable String str, @NonNull List<ah2> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{activity, e43Var, str, list, fVar, onCancelListener})) == null) {
            View inflate = View.inflate(activity, R.layout.obfuscated_res_0x7f0d084c, null);
            SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092089);
            Resources resources = activity.getResources();
            if (swanAppRoundedImageView != null) {
                swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, yh3.i(e43Var.W(), "SwanSubscribeMsgDialog", false)));
                swanAppRoundedImageView.setBorderColor(resources.getColor(R.color.obfuscated_res_0x7f060a69));
            }
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902ff);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090300);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09208b)).setText(e43Var.Z());
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922d1)).setText(str);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0921c0);
            ArrayList arrayList = new ArrayList(list);
            if (list.size() > 0) {
                for (ah2 ah2Var : list) {
                    linearLayout.addView(b(activity, ah2Var, arrayList, new a(arrayList, textView2, resources)));
                }
            }
            i33.a aVar = new i33.a(activity);
            aVar.f(true);
            aVar.W(inflate);
            aVar.n(new mj3());
            aVar.p(R.drawable.obfuscated_res_0x7f080125);
            aVar.k(false);
            aVar.j();
            aVar.t(false);
            i33 c2 = aVar.c();
            b bVar = new b(fVar, arrayList, c2);
            textView2.setOnClickListener(new c(c2, bVar));
            textView.setOnClickListener(new d(c2, bVar));
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(vh3.s(activity), -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f10039d);
            }
            return c2;
        }
        return (i33) invokeCommon.objValue;
    }

    public static View b(@NonNull Activity activity, @NonNull ah2 ah2Var, List<ah2> list, View.OnClickListener onClickListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, activity, ah2Var, list, onClickListener)) == null) {
            Resources resources = activity.getResources();
            int dimension = (int) resources.getDimension(R.dimen.obfuscated_res_0x7f070662);
            TextView textView = new TextView(activity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 16, 0, 16);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(hi4.b(activity, R.color.obfuscated_res_0x7f060a82));
            textView.setText(ah2Var.b);
            Drawable drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c2);
            Drawable drawable2 = resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c1);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(dimension);
            textView.setTextSize(18.0f);
            textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, ah2Var, onClickListener));
            return textView;
        }
        return (View) invokeLLLL.objValue;
    }
}
