package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mz5 extends jz5<z46> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public RelativeLayout j;
    public TbImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public ClickableHeaderImageView o;
    public TextView p;
    public TextView q;
    public View r;
    public z46 s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mz5(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        r(h());
    }

    @Override // com.baidu.tieba.jz5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0184 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.jz5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.r, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1);
                km8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && readThreadHistory.d(this.s.getThreadData().getId())) {
                    SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0108);
                } else {
                    SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
                }
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0109, 1);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || e() == null) {
            return;
        }
        e().a(h(), this.s);
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090519);
            this.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090518);
            this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ef2);
            this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090edf);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090521);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090522);
            this.o = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f09051f);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090501);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090500);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f0904f9);
            this.k.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080874);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds326);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = (dimensionPixelSize * 9) / 16;
            this.j.setLayoutParams(layoutParams);
            this.o.setDefaultResource(17170445);
            this.o.setDefaultBgResource(R.color.CAM_X0205);
            this.o.setIsRound(true);
            this.o.setDrawBorder(true);
            this.o.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.o.setBorderWidth(this.c.getResources().getDimensionPixelSize(R.dimen.tbds1));
            h().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jz5
    /* renamed from: s */
    public void i(z46 z46Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, z46Var) == null) || z46Var == null || z46Var.getThreadData() == null) {
            return;
        }
        this.s = z46Var;
        String str = null;
        if (z46Var.getThreadData().isVideoThreadType()) {
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            if (z46Var.getThreadData().getThreadVideoInfo() != null) {
                this.m.setText(StringHelper.stringForVideoTime(z46Var.getThreadData().getThreadVideoInfo().video_duration.intValue() * 1000));
                str = z46Var.getThreadData().getThreadVideoInfo().thumbnail_url;
            }
        } else {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            if (z46Var.getThreadData().getMedias() != null && z46Var.getThreadData().getMedias().size() >= 1) {
                str = z46Var.getThreadData().getMedias().get(0).origin_pic;
            }
        }
        this.k.K(str, 10, false);
        this.n.setText(z46Var.getThreadData().getTitle());
        km8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(z46Var.getThreadData().getId())) {
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
        }
        this.o.setData(z46Var.getThreadData(), false);
        this.q.setText(StringHelper.getFormatTimeShort(z46Var.getThreadData().getAuditTime()));
        if ("news".equals(z46Var.getThreadData().getGameInformationSource())) {
            this.o.setVisibility(8);
            this.p.setText(this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0e70, StringHelper.numberUniformFormat(z46Var.getThreadData().getView_num())));
            return;
        }
        this.o.setVisibility(0);
        x(z46Var.getThreadData());
    }

    public String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE) : (String) invokeL.objValue;
    }

    public void u(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (view2 = this.r) == null) {
            return;
        }
        view2.setVisibility(i);
    }

    public void v(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) || (linearLayout = this.i) == null) {
            return;
        }
        linearLayout.setPadding(i, i2, i3, i4);
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.o.setVisibility(i);
        }
    }

    public final void x(ThreadData threadData) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) || (textView = this.p) == null || threadData == null) {
            return;
        }
        textView.setVisibility(0);
        if (StringUtils.isNull(threadData.getAuthor().getName_show())) {
            return;
        }
        this.p.setText(t(threadData.getAuthor().getName_show()));
    }
}
