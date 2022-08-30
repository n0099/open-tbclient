package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class jy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public View.OnClickListener b;
    public RelativeLayout c;
    public HeadImageView d;
    public TextView e;
    public TextView f;
    public ImageView g;

    public jy7(PbFragment pbFragment, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = pbFragment;
        this.b = onClickListener;
        b();
    }

    public void a(BdTypeListView bdTypeListView, int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bdTypeListView, i) == null) || bdTypeListView == null || (relativeLayout = this.c) == null) {
            return;
        }
        bdTypeListView.x(relativeLayout, i);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06d6, (ViewGroup) null);
            this.c = relativeLayout;
            HeadImageView headImageView = (HeadImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091003);
            this.d = headImageView;
            headImageView.setIsRound(true);
            this.d.setPlaceHolder(1);
            this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092386);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092385);
            this.g = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091002);
            this.c.setOnClickListener(this.b);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            RelativeLayout relativeLayout = this.c;
            if (relativeLayout != null) {
                SkinManager.setBackgroundColor(relativeLayout, R.color.CAM_X0204);
            }
            HeadImageView headImageView = this.d;
            if (headImageView != null) {
                headImageView.setSkinType(i);
            }
            TextView textView = this.e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            }
            ImageView imageView = this.g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.icon_common_arrow16_right_n);
            }
        }
    }

    public void d(BdTypeListView bdTypeListView) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null || (relativeLayout = this.c) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(relativeLayout);
    }

    public void e(mt7 mt7Var, BdTypeListView bdTypeListView) {
        String charSequence;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, mt7Var, bdTypeListView) == null) || mt7Var == null || bdTypeListView == null) {
            return;
        }
        if (mt7Var.O().isVideoThreadType() && mt7Var.O().getSmartApp() != null) {
            SmartApp smartApp = mt7Var.O().getSmartApp();
            this.c.setVisibility(0);
            d(bdTypeListView);
            a(bdTypeListView, 1);
            if (!qi.isEmpty(smartApp.avatar)) {
                this.d.L(smartApp.avatar, 10, false, false);
            }
            if (!qi.isEmpty(smartApp.name)) {
                charSequence = smartApp.name + " " + ((Object) this.a.getText(R.string.obfuscated_res_0x7f0f11ac));
            } else {
                charSequence = this.a.getText(R.string.obfuscated_res_0x7f0f090b).toString();
            }
            this.e.setText(charSequence);
            if (!qi.isEmpty(smartApp._abstract)) {
                this.f.setText(smartApp._abstract);
            } else {
                this.f.setText(this.a.getText(R.string.obfuscated_res_0x7f0f11ab));
            }
            this.c.setTag(smartApp);
            return;
        }
        this.c.setVisibility(8);
        d(bdTypeListView);
    }
}
