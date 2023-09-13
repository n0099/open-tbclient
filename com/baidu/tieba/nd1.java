package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.er0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class nd1 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* loaded from: classes7.dex */
    public interface d {
        void a(List<er0.a> list);
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ AdBaseModel b;
        public final /* synthetic */ nd1 c;

        public a(nd1 nd1Var, List list, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var, list, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nd1Var;
            this.a = list;
            this.b = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.a != null) {
                    this.c.a.a(this.a);
                }
                this.c.g(this.b, this.a);
                this.c.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ nd1 b;

        public b(nd1 nd1Var, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nd1Var;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.dismiss();
                cj0.c(this.a.g.c, this.b.getContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er0.a a;
        public final /* synthetic */ List b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ nd1 e;

        public c(nd1 nd1Var, er0.a aVar, List list, TextView textView, TextView textView2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nd1Var, aVar, list, textView, textView2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = nd1Var;
            this.a = aVar;
            this.b = list;
            this.c = textView;
            this.d = textView2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.c()) {
                    this.a.f(false);
                    if (this.b.contains(this.a)) {
                        h31.j(this.b, this.a);
                    }
                    if (this.b.size() == 0) {
                        this.c.setText(view2.getContext().getResources().getText(R.string.nad_dislike_dislike));
                    }
                    this.d.setTextColor(view2.getContext().getResources().getColor(R.color.NAD_FC1));
                    return;
                }
                this.a.f(true);
                if (!this.b.contains(this.a)) {
                    h31.b(this.b, this.a);
                }
                this.d.setTextColor(view2.getContext().getResources().getColor(R.color.NAD_FC13));
                this.c.setText(view2.getContext().getResources().getText(R.string.nad_dislike_done));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nd1(Context context, @NonNull AdBaseModel adBaseModel) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adBaseModel};
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
        f(adBaseModel);
    }

    public final void g(AdBaseModel adBaseModel, List<er0.a> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, adBaseModel, list) != null) || adBaseModel == null) {
            return;
        }
        x31.e(new b41().e(e(list)).g(adBaseModel.f.d).f(tj0.a().g()));
    }

    public final List<er0.a> d(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        er0 er0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel)) == null) {
            if (adBaseModel != null && (er0Var = adBaseModel.g) != null) {
                return er0Var.b;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void h(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.a = dVar;
        }
    }

    public final void c(AdBaseModel adBaseModel) {
        int i;
        er0 er0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            ArrayList arrayList = new ArrayList();
            ViewGroup viewGroup = null;
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_dialog_menu_new_dislike, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_bottom);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091534);
            textView.setText(getContext().getString(R.string.nad_dislike_dislike));
            textView.setOnClickListener(new a(this, arrayList, adBaseModel));
            inflate.setBackground(inflate.getContext().getResources().getDrawable(R.drawable.nad_bg_bottom_popup_ffffff));
            Resources resources = inflate.getContext().getResources();
            int i2 = R.color.NAD_FC1;
            textView.setTextColor(resources.getColor(R.color.NAD_FC1));
            findViewById.setBackgroundColor(inflate.getContext().getResources().getColor(R.color.NAD_FC96));
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.layout_enum);
            LayoutInflater from = LayoutInflater.from(inflate.getContext());
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_why_show_ad);
            if (adBaseModel != null && (er0Var = adBaseModel.g) != null && !TextUtils.isEmpty(er0Var.c)) {
                if (!TextUtils.isEmpty(adBaseModel.g.a)) {
                    textView2.setText(adBaseModel.g.a);
                }
                textView2.setVisibility(0);
                textView2.setOnClickListener(new b(this, adBaseModel));
            } else {
                textView2.setVisibility(8);
            }
            List<er0.a> d2 = d(adBaseModel);
            if (d2 == null) {
                linearLayout.setVisibility(8);
                return;
            }
            int min = Math.min(d2.size(), 7);
            int i3 = 0;
            while (i3 < min) {
                er0.a aVar = (er0.a) h31.d(d2, i3);
                if (aVar != null && !TextUtils.isEmpty(aVar.a())) {
                    View inflate2 = from.inflate(R.layout.nad_item_menu_new_dislike, viewGroup);
                    TextView textView3 = (TextView) inflate2.findViewById(R.id.tv_enum);
                    textView3.setText(aVar.a());
                    textView3.setTextColor(inflate.getContext().getResources().getColor(i2));
                    i = i3;
                    inflate2.setOnClickListener(new c(this, aVar, arrayList, textView, textView3));
                    linearLayout.addView(inflate2);
                } else {
                    i = i3;
                }
                i3 = i + 1;
                viewGroup = null;
                i2 = R.color.NAD_FC1;
            }
            setContentView(inflate);
        }
    }

    public String e(List<er0.a> list) {
        InterceptResult invokeL;
        er0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list == null) {
                return "{}";
            }
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                if (((er0.a) h31.d(list, i)) != null) {
                    if (!TextUtils.isEmpty(str)) {
                        str = str + "," + aVar.b();
                    } else {
                        str = str + aVar.b();
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                return "{}";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void f(@NonNull AdBaseModel adBaseModel) {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, adBaseModel) != null) || (window = getWindow()) == null) {
            return;
        }
        window.requestFeature(1);
        c(adBaseModel);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.windowAnimations = R.style.obfuscated_res_0x7f1003e9;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Window window = getWindow();
            if (window == null) {
                i61.b(this);
                return;
            }
            window.setFlags(8, 8);
            i61.b(this);
            j71.a(window);
            window.clearFlags(8);
        }
    }
}
