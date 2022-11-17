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
public class p36 extends m36<e96> {
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
    public e96 s;

    @Override // com.baidu.tieba.m36
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0188 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p36(TbPageContext<?> tbPageContext) {
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
        r(k());
    }

    public final void x(ThreadData threadData) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) && (textView = this.p) != null && threadData != null) {
            textView.setVisibility(0);
            if (!StringUtils.isNull(threadData.getAuthor().getName_show())) {
                this.p.setText(t(threadData.getAuthor().getName_show()));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && e() != null) {
            e().a(k(), this.s);
        }
    }

    public String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
        }
        return (String) invokeL.objValue;
    }

    public void u(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (view2 = this.r) != null) {
            view2.setVisibility(i);
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.o.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.m36
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(k(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.r, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1);
                nq8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
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

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09053f);
            this.j = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09053e);
            this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f3e);
            this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f2a);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090547);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090548);
            this.o = (ClickableHeaderImageView) view2.findViewById(R.id.obfuscated_res_0x7f090545);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090527);
            this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090526);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f09051f);
            this.k.setDefaultBgResource(R.drawable.obfuscated_res_0x7f08089f);
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
            k().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m36
    /* renamed from: s */
    public void l(e96 e96Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, e96Var) == null) && e96Var != null && e96Var.getThreadData() != null) {
            this.s = e96Var;
            String str = null;
            if (e96Var.getThreadData().isVideoThreadType()) {
                this.l.setVisibility(0);
                this.m.setVisibility(0);
                if (e96Var.getThreadData().getThreadVideoInfo() != null) {
                    this.m.setText(StringHelper.stringForVideoTime(e96Var.getThreadData().getThreadVideoInfo().video_duration.intValue() * 1000));
                    str = e96Var.getThreadData().getThreadVideoInfo().thumbnail_url;
                }
            } else {
                this.l.setVisibility(8);
                this.m.setVisibility(8);
                if (e96Var.getThreadData().getMedias() != null && e96Var.getThreadData().getMedias().size() >= 1) {
                    str = e96Var.getThreadData().getMedias().get(0).origin_pic;
                }
            }
            this.k.K(str, 10, false);
            this.n.setText(e96Var.getThreadData().getTitle());
            nq8 readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(e96Var.getThreadData().getId())) {
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
            }
            this.o.setData(e96Var.getThreadData(), false);
            this.q.setText(StringHelper.getFormatTimeShort(e96Var.getThreadData().getAuditTime()));
            if ("news".equals(e96Var.getThreadData().getGameInformationSource())) {
                this.o.setVisibility(8);
                this.p.setText(this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0eba, StringHelper.numberUniformFormat(e96Var.getThreadData().getView_num())));
                return;
            }
            this.o.setVisibility(0);
            x(e96Var.getThreadData());
        }
    }

    public void v(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) && (linearLayout = this.i) != null) {
            linearLayout.setPadding(i, i2, i3, i4);
        }
    }
}
