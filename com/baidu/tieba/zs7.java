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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes9.dex */
public class zs7 implements ys7, xs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TbClipImageView e;
    public zga f;
    public ImageView g;
    public ImageOverlayView h;
    public FrsViewData i;
    public View.OnClickListener j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zs7 a;

        public a(zs7 zs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zs7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null && "tiebaclient://accelerator".equals(this.a.f.d)) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new hk7(3));
                    CustomMessage customMessage = new CustomMessage(2921662);
                    customMessage.setTag(this.a.i.getFrsFragmentTag());
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (TextUtils.equals(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a31), this.a.f.b) && this.a.i != null && this.a.i.getForum() != null && !TextUtils.isEmpty(this.a.i.getForum().getId())) {
                    HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                    hotUserRankActivityConfig.setForumId(Long.valueOf(JavaTypesHelper.toLong(this.a.i.getForum().getId(), 0L)));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                    StatisticItem statisticItem = new StatisticItem("c13666");
                    statisticItem.param("fid", this.a.i.getForum().getId());
                    TiebaStatic.log(statisticItem);
                    return;
                }
                if (this.a.f != null && this.a.f.f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.f.g).param("obj_source", "frs_card").param("obj_id", this.a.f.f.b).param("obj_name", this.a.f.f.a).param("obj_param1", this.a.f.f.d.intValue()));
                }
                if (this.a.f != null && !"tiebaclient://accelerator".equals(this.a.f.d)) {
                    at7.b(view2.getContext(), this.a.f);
                }
                at7.c(this.a.f);
            }
        }
    }

    public zs7(Context context) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d039b, (ViewGroup) null);
        this.a = inflate;
        this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090d67);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090d69);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090d6b);
        TbClipImageView tbClipImageView = (TbClipImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d6a);
        this.e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.e.setIsRound(true);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.a.findViewById(R.id.obfuscated_res_0x7f091097);
        this.h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.h.setStrokeStyle(1);
        this.h.setLoadImageType(12);
        this.a.setOnClickListener(this.j);
        this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090d68);
    }

    @Override // com.baidu.tieba.ys7
    public void a(yga ygaVar, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, ygaVar, frsViewData) == null) && ygaVar != null && !ListUtils.isEmpty(ygaVar.b)) {
            this.i = frsViewData;
            zga zgaVar = ygaVar.b.get(0);
            if (zgaVar == null) {
                return;
            }
            this.f = zgaVar;
            if (!TextUtils.equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a31), this.f.b)) {
                this.c.setText(this.a.getContext().getString(R.string.forum_exclusive));
            } else {
                this.c.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0875));
                this.b.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0a04));
            }
            this.d.setText(StringHelper.cutStringWithEllipsisStrict(zgaVar.c, 20));
            if (TextUtils.equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a31), zgaVar.b)) {
                this.h.setVisibility(0);
                this.e.setVisibility(8);
                f(frsViewData);
            } else {
                this.e.startLoad(zgaVar.b, 10, false);
                this.e.setVisibility(0);
                this.h.setVisibility(8);
            }
            at7.d(zgaVar);
        }
    }

    @Override // com.baidu.tieba.xs7
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(BdUtilHelper.getDimens(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i).into(this.b);
        }
    }

    @Override // com.baidu.tieba.ys7
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

    public final boolean f(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData)) == null) {
            if (frsViewData.getHotUserRankData() != null && frsViewData.getHotUserRankData().hot_user != null && frsViewData.getHotUserRankData().hot_user.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (ShortUserInfo shortUserInfo : frsViewData.getHotUserRankData().hot_user) {
                    if (shortUserInfo != null) {
                        arrayList.add(shortUserInfo.portrait);
                    }
                }
                this.h.setData(arrayList);
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ys7
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }
}
