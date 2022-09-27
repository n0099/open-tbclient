package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.module.pb.BarManageResultListener;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ox7 implements z95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public TbPageContext a;
    @NonNull
    public ForumManageModel b;
    @NonNull
    public final q9 c;
    public List<CustomBlueCheckRadioButton> d;
    public Dialog e;
    public View f;
    public LinearLayout g;
    public CompoundButton.OnCheckedChangeListener h;
    public TextView i;
    public TextView j;
    public String k;
    public ScrollView l;
    public String m;
    public String n;
    public String o;

    /* loaded from: classes5.dex */
    public class a extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox7 a;

        public a(ox7 ox7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ox7Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.a.a.getPageActivity().isDestroyed()) {
                return;
            }
            int loadDataMode = this.a.b.getLoadDataMode();
            if (loadDataMode != 2 && loadDataMode != 3 && loadDataMode != 4 && loadDataMode != 5) {
                if (loadDataMode != 6) {
                    return;
                }
                this.a.m(((ForumManageModel.g) obj).c);
                return;
            }
            ForumManageModel.g gVar = (ForumManageModel.g) obj;
            if (TextUtils.isEmpty(gVar.b)) {
                gVar.b = this.a.a.getString(gVar.a ? R.string.obfuscated_res_0x7f0f0d23 : R.string.obfuscated_res_0x7f0f0d22);
            }
            BarManageResultListener.k(this.a.b.Q(this.a.b.getLoadDataMode(), gVar));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox7 a;

        public b(ox7 ox7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ox7Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.k = (String) compoundButton.getTag();
                if (this.a.d != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.d) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.k != null && !str.equals(this.a.k)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox7 a;

        public c(ox7 ox7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ox7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.e instanceof Dialog)) {
                ih.b(this.a.e, this.a.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ox7 a;

        public d(ox7 ox7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ox7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ox7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.b.W(this.a.m, this.a.n, this.a.o, 2, this.a.k);
                if (this.a.e instanceof Dialog) {
                    ih.b(this.a.e, this.a.a);
                }
            }
        }
    }

    public ox7(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this);
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.a = tbPageContext;
        ForumManageModel forumManageModel = new ForumManageModel(tbPageContext);
        this.b = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.c);
    }

    @Override // com.baidu.tieba.z95
    public void a(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.b.S()) {
            return;
        }
        this.m = str;
        this.n = str2;
        this.o = str3;
        this.b.W(str, str2, str3, z ? 3 : 6, null);
    }

    @Override // com.baidu.tieba.z95
    public void b(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) || this.b.S()) {
            return;
        }
        this.b.W(str, str2, str3, z ? 5 : 4, null);
    }

    public final CustomBlueCheckRadioButton l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, ej.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.h);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public final void m(ArrayList<ls4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            if (this.f == null) {
                this.f = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e6, (ViewGroup) null);
            }
            if (this.e == null) {
                Dialog dialog = new Dialog(this.a.getPageActivity());
                this.e = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.e.setCancelable(true);
                this.l = (ScrollView) this.f.findViewById(R.id.obfuscated_res_0x7f090cde);
                this.e.setContentView(this.f);
                WindowManager.LayoutParams attributes = this.e.getWindow().getAttributes();
                attributes.width = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.e.getWindow().setAttributes(attributes);
                this.h = new b(this);
                this.g = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090cdd);
                TextView textView = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0907b8);
                this.j = textView;
                textView.setOnClickListener(new c(this));
                TextView textView2 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0907b9);
                this.i = textView2;
                textView2.setOnClickListener(new d(this));
            }
            this.g.removeAllViews();
            this.d = new ArrayList();
            CustomBlueCheckRadioButton l = l("0", this.a.getString(R.string.obfuscated_res_0x7f0f13eb));
            this.d.add(l);
            l.setChecked(true);
            this.g.addView(l);
            if (arrayList != null) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ls4 ls4Var = arrayList.get(i);
                    if (ls4Var != null && !TextUtils.isEmpty(ls4Var.b()) && ls4Var.a() > 0) {
                        CustomBlueCheckRadioButton l2 = l(String.valueOf(ls4Var.a()), ls4Var.b());
                        this.d.add(l2);
                        View view2 = new View(this.a.getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.g.addView(view2);
                        this.g.addView(l2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = ej.d(this.a.getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = ej.d(this.a.getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = ej.d(this.a.getPageActivity(), 186.0f);
                }
                this.l.setLayoutParams(layoutParams2);
                this.l.removeAllViews();
                LinearLayout linearLayout = this.g;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l.addView(this.g);
                }
            }
            ih.j(this.e, this.a);
        }
    }
}
