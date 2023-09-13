package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.sh8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes7.dex */
public class oe8 extends h9<OfficialBarFeedActivity> {
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sh8.a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ oe8 c;

        public a(oe8 oe8Var, sh8.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oe8Var, aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oe8Var;
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
    public oe8(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0763);
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
                super((BdPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = z;
        z();
    }

    public void D(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void C(Context context, sh8.a aVar, yf8 yf8Var, bg8 bg8Var, int i, boolean z, int i2) {
        String formatTimeForJustNow;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{context, aVar, yf8Var, bg8Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) != null) || aVar == null) {
            return;
        }
        if (this.k) {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setTextSize(0, BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.e.setLayoutParams(layoutParams);
            int dimens = BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
            int dimens2 = BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
            int dimens3 = BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.g.setPadding(0, BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            LinearLayout linearLayout = this.f;
            if (StringUtils.isNull(aVar.b)) {
                i3 = 0;
            } else {
                i3 = dimens3 + dimens;
            }
            linearLayout.setPadding(dimens, dimens2, dimens, i3);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.topMargin = BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f.setLayoutParams(layoutParams2);
        } else {
            this.c.setShowOval(true);
            this.c.setAutoChangeStyle(true);
            this.c.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.c.setStrokeColorResId(R.color.CAM_X0401);
            this.c.setPlaceHolder(1);
        }
        if (!this.k && yf8Var != null) {
            this.c.startLoad(yf8Var.c(), 10, false);
            this.d.setText(String.format("%s%s", yf8Var.a(), context.getString(R.string.obfuscated_res_0x7f0f077f)));
        }
        long j = aVar.m * 1000;
        if (this.k) {
            formatTimeForJustNow = ei.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.e.setText(formatTimeForJustNow);
        this.i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int dimens4 = BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.i.setPadding(dimens4, 0, dimens4, 0);
        }
        this.i.setData(aVar, z);
        this.f.removeAllViews();
        this.g.setOnClickListener(new a(this, aVar, i2));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.i.a(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f.addView(this.h);
            this.f.addView(this.i);
            this.h.setData(aVar, i, bg8Var);
        } else {
            if (this.k) {
                int dimens5 = BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10);
                int dimens6 = BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5);
                int dimens7 = BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f.setPadding(dimens5, dimens6 + dimens7, dimens5, dimens7 + dimens5);
                this.i.a(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f.addView(this.i);
        }
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(BdUtilHelper.getDimens(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.b);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = (BarImageView) t(R.id.obfuscated_res_0x7f09034e);
            this.d = (TextView) t(R.id.obfuscated_res_0x7f09035c);
            this.e = (TextView) t(R.id.obfuscated_res_0x7f091776);
            this.f = (LinearLayout) t(R.id.obfuscated_res_0x7f0911ae);
            this.g = (RelativeLayout) t(R.id.obfuscated_res_0x7f0919f7);
            View t = t(R.id.obfuscated_res_0x7f0919f8);
            this.b = t;
            if (this.k) {
                t.setVisibility(8);
            }
        }
    }
}
