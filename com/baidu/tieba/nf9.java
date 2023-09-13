package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
/* loaded from: classes7.dex */
public class nf9 extends pm<wf9, InterestedForumStyleAForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eg9 a;

    /* loaded from: classes7.dex */
    public class a implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf9 a;

        public a(nf9 nf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf9Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(cnVar instanceof wf9)) {
                return;
            }
            wf9 wf9Var = (wf9) cnVar;
            wf9Var.s(!wf9Var.h());
            InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder = (InterestedForumStyleAForumViewHolder) view2.getTag();
            if (interestedForumStyleAForumViewHolder != null) {
                this.a.D(interestedForumStyleAForumViewHolder.h, wf9Var.h());
            }
            if (this.a.a != null) {
                this.a.a.a();
            }
            if (!wf9Var.h()) {
                return;
            }
            this.a.x(wf9Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nf9(Context context, BdUniqueId bdUniqueId) {
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

    public void B(eg9 eg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eg9Var) == null) {
            this.a = eg9Var;
        }
    }

    public final void x(wf9 wf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wf9Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", wf9Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: y */
    public InterestedForumStyleAForumViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            return new InterestedForumStyleAForumViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0470, viewGroup, false));
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

    public final void A(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder, wf9 wf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, interestedForumStyleAForumViewHolder, wf9Var) == null) {
            interestedForumStyleAForumViewHolder.b.setShowOval(true);
            interestedForumStyleAForumViewHolder.b.setAutoChangeStyle(true);
            interestedForumStyleAForumViewHolder.b.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            interestedForumStyleAForumViewHolder.b.setStrokeColorResId(R.color.CAM_X0401);
            interestedForumStyleAForumViewHolder.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            interestedForumStyleAForumViewHolder.b.setPlaceHolder(1);
            interestedForumStyleAForumViewHolder.b.startLoad(wf9Var.a(), 10, false);
            interestedForumStyleAForumViewHolder.c.setText(wf9Var.d() + this.mContext.getString(R.string.obfuscated_res_0x7f0f077f));
            if (!StringUtils.isNull(wf9Var.f())) {
                interestedForumStyleAForumViewHolder.d.setText(this.mContext.getString(R.string.obfuscated_res_0x7f0f0ae3, wf9Var.f()));
            } else {
                interestedForumStyleAForumViewHolder.d.setText(this.mContext.getString(R.string.obfuscated_res_0x7f0f0ae7));
            }
            interestedForumStyleAForumViewHolder.e.setText(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f04b8), StringHelper.numberUniformFormatExtraWithRoundInt(wf9Var.e())));
            interestedForumStyleAForumViewHolder.f.setText(String.format(this.mContext.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(wf9Var.g())));
            D(interestedForumStyleAForumViewHolder.h, wf9Var.h());
        }
    }

    public final void C(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interestedForumStyleAForumViewHolder) == null) {
            EMManager.from(interestedForumStyleAForumViewHolder.c).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X06);
            EMManager.from(interestedForumStyleAForumViewHolder.d).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X09);
            EMManager.from(interestedForumStyleAForumViewHolder.e).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X09);
            EMManager.from(interestedForumStyleAForumViewHolder.f).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(interestedForumStyleAForumViewHolder.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, wf9 wf9Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        z(i, view2, viewGroup, wf9Var, interestedForumStyleAForumViewHolder);
        return view2;
    }

    public View z(int i, View view2, ViewGroup viewGroup, wf9 wf9Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wf9Var, interestedForumStyleAForumViewHolder})) == null) {
            if (wf9Var == null) {
                return view2;
            }
            C(interestedForumStyleAForumViewHolder);
            A(interestedForumStyleAForumViewHolder, wf9Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
