package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialFeedItemBottom;
import com.baidu.tieba.im.chat.officialBar.OfficialFeedItemImage;
import com.baidu.tieba.xe8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes8.dex */
public class xc8 extends i9<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View b;
    public BarImageView c;
    public TextView d;
    public TextView e;
    public LinearLayout f;
    public RelativeLayout g;
    public OfficialFeedItemImage h;
    public OfficialFeedItemBottom i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe8.a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ xc8 c;

        public a(xc8 xc8Var, xe8.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc8Var, aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xc8Var;
            this.a = aVar;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.j != null) {
                this.c.j.d(this.c.g, this.a, this.b, 0L);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xc8(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0743);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((l9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = z;
        C();
    }

    public void E(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = (BarImageView) x(R.id.obfuscated_res_0x7f090347);
            this.d = (TextView) x(R.id.obfuscated_res_0x7f090355);
            this.e = (TextView) x(R.id.obfuscated_res_0x7f091742);
            this.f = (LinearLayout) x(R.id.obfuscated_res_0x7f091181);
            this.g = (RelativeLayout) x(R.id.obfuscated_res_0x7f0919a0);
            View x = x(R.id.obfuscated_res_0x7f0919a1);
            this.b = x;
            if (this.k) {
                x.setVisibility(8);
            }
        }
    }

    public void D(Context context, xe8.a aVar, ie8 ie8Var, le8 le8Var, int i, boolean z, int i2) {
        String formatTimeForJustNow;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, aVar, ie8Var, le8Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) != null) || aVar == null) {
            return;
        }
        if (this.k) {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setTextSize(0, yi.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.e.setLayoutParams(layoutParams);
            int g = yi.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g2 = yi.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g3 = yi.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.g.setPadding(0, yi.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            LinearLayout linearLayout = this.f;
            if (StringUtils.isNull(aVar.b)) {
                i3 = 0;
            } else {
                i3 = g3 + g;
            }
            linearLayout.setPadding(g, g2, g, i3);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.topMargin = yi.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f.setLayoutParams(layoutParams2);
        } else {
            this.c.setShowOval(true);
            this.c.setAutoChangeStyle(true);
            this.c.setStrokeWith(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.c.setStrokeColorResId(R.color.CAM_X0401);
            this.c.setPlaceHolder(1);
        }
        if (!this.k && ie8Var != null) {
            this.c.N(ie8Var.c(), 10, false);
            this.d.setText(String.format("%s%s", ie8Var.a(), context.getString(R.string.obfuscated_res_0x7f0f0773)));
        }
        long j = aVar.m * 1000;
        if (this.k) {
            formatTimeForJustNow = xi.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.e.setText(formatTimeForJustNow);
        this.i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g4 = yi.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.i.setPadding(g4, 0, g4, 0);
        }
        this.i.setData(aVar, z);
        this.f.removeAllViews();
        this.g.setOnClickListener(new a(this, aVar, i2));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.i.a(yi.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f.addView(this.h);
            this.f.addView(this.i);
            this.h.setData(aVar, i, le8Var);
        } else {
            if (this.k) {
                int g5 = yi.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g6 = yi.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g7 = yi.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f.setPadding(g5, g6 + g7, g5, g7 + g5);
                this.i.a(yi.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f.addView(this.i);
        }
        a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            OfficialFeedItemImage officialFeedItemImage = this.h;
            if (officialFeedItemImage != null) {
                officialFeedItemImage.c();
            }
            OfficialFeedItemBottom officialFeedItemBottom = this.i;
            if (officialFeedItemBottom != null) {
                officialFeedItemBottom.c();
            }
            if (this.k) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(yi.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(yi.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(yi.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(yi.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(yi.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(yi.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.b);
            }
        }
    }
}
