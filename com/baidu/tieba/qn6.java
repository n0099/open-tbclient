package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.callfans.CallFansResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public String b;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        public a(qn6 qn6Var, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn6Var, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Drawable maskDrawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(Boolean.valueOf(!((Boolean) view2.getTag()).booleanValue()));
                ImageView imageView = this.a;
                if (((Boolean) view2.getTag()).booleanValue()) {
                    maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_complete16_svg, null);
                } else {
                    maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null);
                }
                imageView.setImageDrawable(maskDrawable);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ qn6 b;

        public b(qn6 qn6Var, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qn6Var, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qn6Var;
            this.a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                r95.p().A("key_call_fans_no_tip_again", !((Boolean) this.a.getTag()).booleanValue());
                this.b.c();
            }
        }
    }

    public qn6(TbPageContext tbPageContext) {
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
        this.a = tbPageContext;
        e();
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TbSingleton.getInstance().mCanCallFans) {
                this.a.showToast(R.string.have_used_call_fans_this_week);
            } else if (r95.p().l("key_call_fans_no_tip_again", false)) {
                c();
            } else {
                TbPageContext tbPageContext = this.a;
                if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                    Activity pageActivity = this.a.getPageActivity();
                    LinearLayout linearLayout = new LinearLayout(pageActivity);
                    linearLayout.setOrientation(0);
                    linearLayout.setGravity(16);
                    linearLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012), UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), UtilHelper.getDimenPixelSize(R.dimen.M_W_X012), 0);
                    ImageView imageView = new ImageView(pageActivity);
                    imageView.setImageDrawable(SvgManager.getInstance().getMaskDrawable(R.drawable.ic_icon_mask_use_check16_svg, null));
                    linearLayout.addView(imageView, new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds39), UtilHelper.getDimenPixelSize(R.dimen.tbds39)));
                    TextView textView = new TextView(pageActivity);
                    textView.setText(R.string.no_tip_again);
                    textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, 0, 0);
                    s75 d = s75.d(textView);
                    d.C(R.dimen.T_X07);
                    d.x(R.color.CAM_X0108);
                    d.D(R.string.F_X01);
                    linearLayout.addView(textView);
                    imageView.setTag(Boolean.FALSE);
                    imageView.setOnClickListener(new a(this, imageView));
                    TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(pageActivity);
                    tBAlertBuilder.w(R.string.confirm_to_call_fans);
                    tBAlertBuilder.m(R.string.call_fans_intro);
                    tBAlertBuilder.n(3);
                    tBAlertBuilder.o(true);
                    tBAlertBuilder.k(linearLayout);
                    tBAlertBuilder.u(new TBAlertConfig.a((int) R.string.next_time, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.call_fans, TBAlertConfig.OperateBtnStyle.MAIN, new b(this, imageView)));
                    tBAlertBuilder.i();
                    tBAlertBuilder.z();
                }
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_CALL_FANS);
            httpMessage.addParam("thread_id", this.b);
            MessageManager.getInstance().sendMessage(httpMessage);
            this.a.showToast(R.string.your_thread_is_recommended_to_fans);
            TbSingleton.getInstance().mCallFansTid = this.b;
            TbSingleton.getInstance().mCanCallFans = false;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CALL_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_CALL_FANS);
            tbHttpMessageTask.setResponsedClass(CallFansResMsg.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void d(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str) == null) {
            TiebaStatic.log(new StatisticItem("c13847").param("obj_source", i).param("obj_type", i2).param("tid", str).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
