package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes8.dex */
public class se9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public HeadImageView c;
    public TextView d;
    public e e;
    public TextView f;
    public BarImageView g;
    public TextView h;
    public TextView i;
    public LinearLayout j;

    /* loaded from: classes8.dex */
    public interface e {
        void a(String str);

        void b(String str, String str2);

        void c();
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ se9 a;

        public a(se9 se9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = se9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e != null) {
                this.a.e.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserInfo a;
        public final /* synthetic */ se9 b;

        public b(se9 se9Var, UserInfo userInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se9Var, userInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = se9Var;
            this.a = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.e(this.a.id.longValue(), this.a.name);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserInfo a;
        public final /* synthetic */ se9 b;

        public c(se9 se9Var, UserInfo userInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se9Var, userInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = se9Var;
            this.a = userInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.e(this.a.id.longValue(), this.a.name);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ se9 b;

        public d(se9 se9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {se9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = se9Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.e != null) {
                this.b.e.a(this.a);
            }
        }
    }

    public se9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0204, (ViewGroup) null);
        this.a = inflate;
        this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09071e);
        this.c = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090716);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090717);
        this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09070a);
        this.c.setRadius(BdUtilHelper.dip2px(context, 2.0f));
        this.g = (BarImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09070b);
        this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090708);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090707);
        this.i = textView;
        textView.setOnClickListener(new a(this));
        this.j = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090709);
    }

    public void d(String str) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !StringUtils.isNull(str) && (headImageView = this.c) != null) {
            headImageView.startLoad(str, 12, false);
        }
    }

    public void g(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.e = eVar;
        }
    }

    public void h(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || (textView = this.d) == null) {
            return;
        }
        textView.setText(str);
    }

    public void j(UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, userInfo) != null) || userInfo == null) {
            return;
        }
        h(userInfo.name);
        d(userInfo.portrait);
        this.c.setOnClickListener(new b(this, userInfo));
        this.d.setOnClickListener(new c(this, userInfo));
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public final void e(long j, String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, str) == null) && (eVar = this.e) != null) {
            eVar.b(String.valueOf(j), str);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.i.setText(R.string.relate_forum_is_followed);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1);
                this.i.setEnabled(false);
                return;
            }
            this.i.setText(R.string.obfuscated_res_0x7f0f02ec);
            this.i.setEnabled(true);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0111, 1);
        }
    }

    public final void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, context, str) == null) && this.f != null) {
            if (StringUtils.isNull(str)) {
                this.f.setVisibility(4);
                return;
            }
            this.f.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.f.setOnClickListener(new d(this, str));
            this.f.setVisibility(0);
        }
    }

    public void k(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        TextView textView;
        Integer num;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, excellentPbThreadInfo) != null) || excellentPbThreadInfo == null || (textView = this.b) == null) {
            return;
        }
        textView.setText(excellentPbThreadInfo.title);
        if (!StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) && excellentPbThreadInfo.forum.forum_id != null && excellentPbThreadInfo.excid.longValue() > 0) {
            uu4.c().h(excellentPbThreadInfo.forum.forum_name);
            this.j.setVisibility(0);
            i(context, excellentPbThreadInfo.forum.forum_name);
            BarImageView barImageView = this.g;
            if (barImageView != null) {
                barImageView.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.g.setOnClickListener(new d(this, excellentPbThreadInfo.forum.forum_name));
            }
            TextView textView2 = this.h;
            if (textView2 != null && (num = excellentPbThreadInfo.forum.member_count) != null) {
                textView2.setText(StringHelper.numFormatOver10000(num.intValue()));
            }
            Integer num2 = excellentPbThreadInfo.forum.is_like;
            if (num2 != null && num2.intValue() == 1) {
                f(true);
                return;
            } else {
                f(false);
                return;
            }
        }
        this.j.setVisibility(8);
    }
}
