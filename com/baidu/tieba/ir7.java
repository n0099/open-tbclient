package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ir7 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public TbPageContext c;
    public View d;
    public PopupWindow e;
    public Handler f;
    public Runnable g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir7 a;

        /* renamed from: com.baidu.tieba.ir7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0363a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0363a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.e != null) {
                    this.a.a.j();
                }
            }
        }

        public a(ir7 ir7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null && this.a.d != null) {
                Activity pageActivity = this.a.c.getPageActivity();
                int g = vi.g(pageActivity, R.dimen.obfuscated_res_0x7f070258);
                ir7 ir7Var = this.a;
                View h = ir7Var.h(pageActivity, ir7Var.a);
                int[] iArr = new int[2];
                this.a.d.getLocationInWindow(iArr);
                int g2 = vi.g(pageActivity, R.dimen.obfuscated_res_0x7f070207);
                int g3 = (iArr[1] - g) + vi.g(pageActivity, R.dimen.obfuscated_res_0x7f0701be);
                this.a.e = new PopupWindow(h, -2, g);
                GreyUtil.grey(this.a.e);
                this.a.e.showAtLocation(this.a.d, 53, g2, g3);
                this.a.f.postDelayed(new RunnableC0363a(this), 3000L);
            }
        }
    }

    public ir7(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = R.string.obfuscated_res_0x7f0f02f3;
        this.f = new Handler();
        this.g = new a(this);
        this.c = tbPageContext;
        this.b = z;
    }

    public final View h(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, activity, i)) == null) {
            TextView textView = new TextView(activity);
            int g = vi.g(activity, R.dimen.obfuscated_res_0x7f0701d5);
            textView.setPadding(g, 0 - activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07035d), g, 0);
            textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07026f));
            textView.setGravity(17);
            textView.setTextSize(0, vi.g(activity, R.dimen.obfuscated_res_0x7f0702b5));
            textView.setText(i);
            textView.setOnClickListener(this);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_tip_blue_left);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            textView.setOnClickListener(this);
            return textView;
        }
        return (View) invokeLI.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            j();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.removeCallbacksAndMessages(null);
            j();
        }
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (popupWindow = this.e) != null) {
            popupWindow.dismiss();
            this.e = null;
        }
    }

    public void k(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.c != null && view2 != null && !StringUtils.isNull(currentAccount)) {
                this.d = view2;
                if (this.b) {
                    this.a = R.string.obfuscated_res_0x7f0f02f3;
                    String str = currentAccount + "frs_god_new_post_tip_count";
                    int n = n95.m().n(str, 0);
                    if (n >= 3) {
                        this.b = false;
                        return;
                    }
                    n95.m().z(str, n + 1);
                    this.b = false;
                    this.f.postDelayed(this.g, 500L);
                }
            }
        }
    }
}
