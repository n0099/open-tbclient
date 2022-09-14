package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes5.dex */
public class rq6 implements qq6, pq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TbClipImageView e;
    public bm8 f;
    public ImageView g;
    public ImageOverlayView h;
    public FrsViewData i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq6 a;

        public a(rq6 rq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null && "tiebaclient://accelerator".equals(this.a.f.d)) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new ri6(3));
                    CustomMessage customMessage = new CustomMessage(2921662);
                    customMessage.setTag(this.a.i.getFrsFragmentTag());
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (!TextUtils.equals(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f08b1), this.a.f.b) || this.a.i == null || this.a.i.getForum() == null || TextUtils.isEmpty(this.a.i.getForum().getId())) {
                    if (this.a.f != null && this.a.f.f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.f.g).param("obj_source", "frs_card").param("obj_id", this.a.f.f.b).param("obj_name", this.a.f.f.a).param("obj_param1", this.a.f.f.d.intValue()));
                    }
                    if (this.a.f != null && !"tiebaclient://accelerator".equals(this.a.f.d)) {
                        sq6.b(view2.getContext(), this.a.f);
                    }
                    sq6.c(this.a.f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(dh.g(this.a.i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.a.i.getForum().getId());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public rq6(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0341, (ViewGroup) null);
        this.a = inflate;
        this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090bec);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bee);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090bf0);
        TbClipImageView tbClipImageView = (TbClipImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090bef);
        this.e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.e.setIsRound(true);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.a.findViewById(R.id.obfuscated_res_0x7f090e9e);
        this.h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.h.setStrokeStyle(1);
        this.h.setLoadImageType(12);
        this.a.setOnClickListener(this.j);
        this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090bed);
    }

    @Override // com.baidu.tieba.qq6
    public void a(am8 am8Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, am8Var, frsViewData) == null) || am8Var == null || ListUtils.isEmpty(am8Var.b)) {
            return;
        }
        this.i = frsViewData;
        bm8 bm8Var = am8Var.b.get(0);
        if (bm8Var == null) {
            return;
        }
        this.f = bm8Var;
        if (!TextUtils.equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f08b1), this.f.b)) {
            this.c.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f068b));
        } else {
            this.c.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f075e));
            this.b.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0884));
        }
        this.d.setText(StringHelper.cutStringWithEllipsisStrict(bm8Var.c, 20));
        if (TextUtils.equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f08b1), bm8Var.b)) {
            this.h.setVisibility(0);
            this.e.setVisibility(8);
            f(frsViewData);
        } else {
            this.e.K(bm8Var.b, 10, false);
            this.e.setVisibility(0);
            this.h.setVisibility(8);
        }
        sq6.d(bm8Var);
    }

    @Override // com.baidu.tieba.pq6
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(ej.f(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i).into(this.b);
        }
    }

    public final boolean f(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData)) == null) {
            if (frsViewData.getHotUserRankData() == null || frsViewData.getHotUserRankData().hot_user == null || frsViewData.getHotUserRankData().hot_user.size() <= 0) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (ShortUserInfo shortUserInfo : frsViewData.getHotUserRankData().hot_user) {
                if (shortUserInfo != null) {
                    arrayList.add(shortUserInfo.portrait);
                }
            }
            this.h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qq6
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qq6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.h.d();
        }
    }
}
