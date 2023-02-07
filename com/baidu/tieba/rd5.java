package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ TBAlertBuilder b;

        public a(c cVar, TBAlertBuilder tBAlertBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, tBAlertBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            this.b = tBAlertBuilder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                c cVar = this.a;
                if (cVar != null) {
                    cVar.a();
                }
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;

        public b(TBAlertBuilder tBAlertBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tBAlertBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBAlertBuilder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                rd5.b();
                this.a.dismiss();
            }
        }
    }

    public static void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 4) {
                    str = "&skin=dart";
                } else if (skinType == 1) {
                    str = "&skin=night";
                } else {
                    str = "";
                }
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity instanceof TbPageContextSupport) {
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{TbConfig.VIRTUAL_IMAGE_MAIN_URL + str});
                }
            } catch (Exception e) {
                BdLog.e("openPageByUrl fail:" + e.toString());
            }
        }
    }

    public static void c(c cVar) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, cVar) != null) || (context = TbadkCoreApplication.getInst().getContext()) == null) {
            return;
        }
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkApplication.getInst().getCurrentActivity());
        View inflate = LayoutInflater.from(context).inflate(R.layout.pb_virtual_image_setting_post, (ViewGroup) null);
        p15 d = p15.d(inflate.findViewById(R.id.virtual_image_setting_layout));
        d.n(R.string.J_X06);
        d.f(R.color.CAM_X0201);
        TextView textView = (TextView) inflate.findViewById(R.id.virtual_image_setting_confirm_cancel_btn);
        p15 d2 = p15.d(textView);
        d2.A(R.string.F_X01);
        d2.z(R.dimen.T_X07);
        d2.v(R.color.CAM_X0105);
        d2.n(R.string.J_X07);
        d2.l(R.dimen.L_X02);
        d2.k(R.color.CAM_X0105);
        d2.j(R.string.A_X07);
        textView.setOnClickListener(new a(cVar, tBAlertBuilder));
        TextView textView2 = (TextView) inflate.findViewById(R.id.virtual_image_setting_confirm_btn);
        p15 d3 = p15.d(textView2);
        d3.A(R.string.F_X01);
        d3.z(R.dimen.T_X07);
        d3.v(R.color.CAM_X0304);
        d3.n(R.string.J_X07);
        d3.l(R.dimen.L_X02);
        d3.k(R.color.CAM_X0304);
        d3.j(R.string.A_X07);
        textView2.setOnClickListener(new b(tBAlertBuilder));
        tBAlertBuilder.r(true);
        tBAlertBuilder.k(inflate);
        tBAlertBuilder.z();
    }
}
