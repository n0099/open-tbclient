package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class lq8 extends um<uq8, InterestedForumStyleAForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cr8 a;

    /* loaded from: classes5.dex */
    public class a implements rn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq8 a;

        public a(lq8 lq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lq8Var;
        }

        @Override // com.baidu.tieba.rn
        public void b(View view2, hn hnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, hnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(hnVar instanceof uq8)) {
                return;
            }
            uq8 uq8Var = (uq8) hnVar;
            uq8Var.r(!uq8Var.i());
            InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder = (InterestedForumStyleAForumViewHolder) view2.getTag();
            if (interestedForumStyleAForumViewHolder != null) {
                this.a.D(interestedForumStyleAForumViewHolder.h, uq8Var.i());
            }
            if (this.a.a != null) {
                this.a.a.a();
            }
            if (!uq8Var.i()) {
                return;
            }
            this.a.x(uq8Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lq8(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mType = bdUniqueId;
        setOnAdapterItemClickListener(new a(this));
    }

    public void B(cr8 cr8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cr8Var) == null) {
            this.a = cr8Var;
        }
    }

    public final void x(uq8 uq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uq8Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", uq8Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: y */
    public InterestedForumStyleAForumViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            return new InterestedForumStyleAForumViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0425, viewGroup, false));
        }
        return (InterestedForumStyleAForumViewHolder) invokeL.objValue;
    }

    public final void D(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, imageView, z) == null) {
            if (z) {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_checked);
            } else {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_unchecked);
            }
        }
    }

    public final void A(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder, uq8 uq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, interestedForumStyleAForumViewHolder, uq8Var) == null) {
            interestedForumStyleAForumViewHolder.b.setShowOval(true);
            interestedForumStyleAForumViewHolder.b.setAutoChangeStyle(true);
            interestedForumStyleAForumViewHolder.b.setStrokeWith(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            interestedForumStyleAForumViewHolder.b.setStrokeColorResId(R.color.CAM_X0401);
            interestedForumStyleAForumViewHolder.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            interestedForumStyleAForumViewHolder.b.setPlaceHolder(1);
            interestedForumStyleAForumViewHolder.b.N(uq8Var.a(), 10, false);
            interestedForumStyleAForumViewHolder.c.setText(uq8Var.d() + this.mContext.getString(R.string.obfuscated_res_0x7f0f06b5));
            if (!StringUtils.isNull(uq8Var.f())) {
                interestedForumStyleAForumViewHolder.d.setText(this.mContext.getString(R.string.obfuscated_res_0x7f0f09f6, uq8Var.f()));
            } else {
                interestedForumStyleAForumViewHolder.d.setText(this.mContext.getString(R.string.obfuscated_res_0x7f0f09fa));
            }
            interestedForumStyleAForumViewHolder.e.setText(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0451), StringHelper.numberUniformFormatExtraWithRoundInt(uq8Var.e())));
            interestedForumStyleAForumViewHolder.f.setText(String.format(this.mContext.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(uq8Var.h())));
            D(interestedForumStyleAForumViewHolder.h, uq8Var.i());
        }
    }

    public final void C(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interestedForumStyleAForumViewHolder) == null) {
            q25 d = q25.d(interestedForumStyleAForumViewHolder.c);
            d.w(R.color.CAM_X0105);
            d.B(R.dimen.T_X06);
            q25 d2 = q25.d(interestedForumStyleAForumViewHolder.d);
            d2.w(R.color.CAM_X0109);
            d2.B(R.dimen.T_X09);
            q25 d3 = q25.d(interestedForumStyleAForumViewHolder.e);
            d3.w(R.color.CAM_X0109);
            d3.B(R.dimen.T_X09);
            q25 d4 = q25.d(interestedForumStyleAForumViewHolder.f);
            d4.w(R.color.CAM_X0109);
            d4.B(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(interestedForumStyleAForumViewHolder.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.um
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, uq8 uq8Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        z(i, view2, viewGroup, uq8Var, interestedForumStyleAForumViewHolder);
        return view2;
    }

    public View z(int i, View view2, ViewGroup viewGroup, uq8 uq8Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uq8Var, interestedForumStyleAForumViewHolder})) == null) {
            if (uq8Var == null) {
                return view2;
            }
            C(interestedForumStyleAForumViewHolder);
            A(interestedForumStyleAForumViewHolder, uq8Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
