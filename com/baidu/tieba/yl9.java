package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatEnterForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yl9 extends lm<oe9, VideoTabPbFloatEnterForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public boolean b;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yl9 a;

        public a(yl9 yl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yl9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.a instanceof VideoPbCommentFloatFragment)) {
                VideoPbCommentFloatFragment videoPbCommentFloatFragment = (VideoPbCommentFloatFragment) this.a.a;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", videoPbCommentFloatFragment.R().getForumId());
                statisticItem.param("tid", videoPbCommentFloatFragment.R().M1());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", videoPbCommentFloatFragment.R().Q0());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 16);
                statisticItem.param("obj_locate", videoPbCommentFloatFragment.s3());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yl9(Context context, BdUniqueId bdUniqueId, BaseFragment baseFragment) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, baseFragment};
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
        this.a = baseFragment;
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.b = z;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.lm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, oe9 oe9Var, VideoTabPbFloatEnterForumViewHolder videoTabPbFloatEnterForumViewHolder) {
        u(i, view2, viewGroup, oe9Var, videoTabPbFloatEnterForumViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: t */
    public VideoTabPbFloatEnterForumViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            FlowLabelLayout flowLabelLayout = new FlowLabelLayout(this.mContext);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds156);
            layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_H_X003);
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.M_H_X005);
            frameLayout.addView(flowLabelLayout, layoutParams);
            View view2 = new View(this.mContext);
            view2.setId(R.id.obfuscated_res_0x7f090b70);
            view2.setAlpha(0.5f);
            frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, -1));
            return new VideoTabPbFloatEnterForumViewHolder(this.mContext, frameLayout);
        }
        return (VideoTabPbFloatEnterForumViewHolder) invokeL.objValue;
    }

    public View u(int i, View view2, ViewGroup viewGroup, oe9 oe9Var, VideoTabPbFloatEnterForumViewHolder videoTabPbFloatEnterForumViewHolder) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, oe9Var, videoTabPbFloatEnterForumViewHolder})) == null) {
            if (oe9Var != null) {
                videoTabPbFloatEnterForumViewHolder.setData(oe9Var.a);
                videoTabPbFloatEnterForumViewHolder.c(new a(this));
            }
            if (this.b) {
                videoTabPbFloatEnterForumViewHolder.d.setVisibility(0);
            } else {
                videoTabPbFloatEnterForumViewHolder.d.setVisibility(8);
            }
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
            View view3 = videoTabPbFloatEnterForumViewHolder.d;
            if (this.b) {
                i2 = R.color.CAM_X0201;
            } else {
                i2 = R.color.transparent;
            }
            SkinManager.setBackgroundColor(view3, i2);
            videoTabPbFloatEnterForumViewHolder.b();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
