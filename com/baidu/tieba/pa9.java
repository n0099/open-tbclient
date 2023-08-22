package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TailManagementActivityConfig;
import com.baidu.tbadk.core.data.SmallTailThemeData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes7.dex */
public class pa9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdListView a;
    public LinearLayout b;
    public LinearLayout c;
    public TextView d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public final Context h;
    public SimpleDraweeView i;
    public final View.OnClickListener j;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa9 a;

        public a(pa9 pa9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pa9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pa9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.b) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TailManagementActivityConfig(view2.getContext())));
                } else if (view2 == this.a.c) {
                    UserData e = zk5.d().e();
                    if (e == null || e.getSmallTailThemeData() == null) {
                        str = "";
                    } else {
                        str = e.getSmallTailThemeData().getPropsId();
                    }
                    String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                    String string2 = SharedPrefHelper.getInstance().getString("tail_link", "");
                    if (!StringUtils.isNull(string2)) {
                        Context context = view2.getContext();
                        BrowserHelper.startWebActivity(context, string, UtilHelper.urlAddParam(string2, "page_from=4&tailSkinId=" + str), true, true, true);
                    }
                }
            }
        }
    }

    public pa9(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.h = viewGroup.getContext();
        this.a = (BdListView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092444);
        this.i = (SimpleDraweeView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092445);
        this.b = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09243e);
        this.d = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09243f);
        this.e = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092440);
        this.c = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09243b);
        this.f = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09243d);
        this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09243c);
        this.b.setOnClickListener(this.j);
        this.c.setOnClickListener(this.j);
    }

    public void d(ka9 ka9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ka9Var) == null) {
            this.a.setAdapter((ListAdapter) ka9Var);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            EMManager.from(this.d).setTextColor(R.color.CAM_X0304).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X06);
            EMManager.from(this.b).setCorner(R.string.J_X01).setAlpha(R.string.A_X11).setBackGroundColor(R.color.CAM_X0302);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X06);
            EMManager.from(this.c).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
            WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f080bde, R.color.CAM_X0304, null);
            WebPManager.setPureDrawable(this.f, R.drawable.obfuscated_res_0x7f080b56, R.color.CAM_X0101, null);
        }
    }

    public void e(SmallTailThemeData smallTailThemeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, smallTailThemeData) == null) {
            if (smallTailThemeData != null && !TextUtils.isEmpty(smallTailThemeData.getTail())) {
                this.i.setVisibility(0);
                this.i.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(smallTailThemeData.getTail())).setAutoPlayAnimations(true).build());
                this.i.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
                return;
            }
            this.i.setVisibility(4);
        }
    }
}
