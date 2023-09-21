package com.baidu.tieba.view.headcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.uya;
import com.baidu.tieba.xya;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class MatchCardView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public EMTextView b;
    public HeadImageView c;
    public EMTextView d;
    public HeadImageView e;
    public EMTextView f;
    public EMTextView g;
    public View h;
    public ImageView i;
    public uya j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xya a;
        public final /* synthetic */ MatchCardView b;

        public a(MatchCardView matchCardView, xya xyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {matchCardView, xyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = matchCardView;
            this.a = xyaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.c().e())) {
                BrowserHelper.startWebActivity(this.b.getContext(), this.a.c().e());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
                statisticItem.param("obj_type", 3);
                this.b.b(statisticItem, this.a);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MatchCardView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(StatisticItem statisticItem, xya xyaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, statisticItem, xyaVar) != null) || xyaVar == null) {
            return;
        }
        int i = 0;
        if (xyaVar.c() != null && xyaVar.c().g() != null) {
            i = xyaVar.c().g().intValue();
        }
        int d = xyaVar.d();
        String a2 = xyaVar.a();
        String b = xyaVar.b();
        statisticItem.addParam("obj_locate", i);
        statisticItem.addParam("obj_source", d);
        statisticItem.addParam("fid", a2);
        statisticItem.addParam("fname", b);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchCardView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MatchCardView(TbPageContext tbPageContext) {
        this(tbPageContext.getPageActivity(), null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMManager from = EMManager.from(this.b);
            int i = R.dimen.T_X12;
            from.setTextSize(R.dimen.T_X12).setTextColor(R.color.CAM_X0107);
            EMManager.from(this.d).setTextSize(R.dimen.T_X12).setTextColor(R.color.CAM_X0107);
            this.c.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.e.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            EMManager.from(this.f).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0108);
            WebPManager.setPureDrawable(this.i, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0108, WebPManager.ResourceStateType.NORMAL);
            uya uyaVar = this.j;
            if (uyaVar == null || uyaVar.g().intValue() != 1) {
                i = R.dimen.T_X04;
            }
            EMManager.from(this.g).setTextStyle(R.string.F_X02).setTextSize(i).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.h).setBackGroundColor(R.color.CAM_X0203);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = LayoutInflater.from(getContext()).inflate(R.layout.recommend_match_card, (ViewGroup) this, true);
            setOrientation(1);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.bottomMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds4);
            setLayoutParams(marginLayoutParams);
            this.b = (EMTextView) findViewById(R.id.team_name_a);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.team_icon_a);
            this.c = headImageView;
            headImageView.setIsRound(true);
            this.c.setDefaultResource(R.drawable.pic_head_topic);
            this.d = (EMTextView) findViewById(R.id.team_name_b);
            HeadImageView headImageView2 = (HeadImageView) findViewById(R.id.team_icon_b);
            this.e = headImageView2;
            headImageView2.setIsRound(true);
            this.e.setDefaultResource(R.drawable.pic_head_topic);
            this.f = (EMTextView) findViewById(R.id.match_name);
            this.i = (ImageView) findViewById(R.id.arrow_img);
            this.g = (EMTextView) findViewById(R.id.match_score);
            this.h = findViewById(R.id.bottom_divider);
        }
    }

    public void setData(xya xyaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xyaVar) == null) && xyaVar != null && xyaVar.c() != null) {
            this.j = xyaVar.c();
            this.b.setText(xyaVar.c().j());
            this.c.startLoad(xyaVar.c().h(), 12, false);
            this.d.setText(xyaVar.c().k());
            this.e.startLoad(xyaVar.c().i(), 12, false);
            this.f.setText(xyaVar.c().d());
            this.f.setOnClickListener(new a(this, xyaVar));
            int intValue = this.j.g().intValue();
            if (intValue != 2) {
                if (intValue != 3) {
                    this.g.setText(xyaVar.c().f());
                } else {
                    this.g.setText(String.format("%d - %d", xyaVar.c().m(), xyaVar.c().n()));
                }
            } else {
                this.g.setText(String.format("%d - %d", xyaVar.c().m(), xyaVar.c().n()));
            }
            if (ListUtils.isNotEmpty(xyaVar.c().l())) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
            }
            c();
        }
    }
}
