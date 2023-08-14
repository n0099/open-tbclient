package com.baidu.tieba.videoplay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.tieba.view.UserLikeInAttentionButton;
import com.baidu.tieba.xw5;
import com.baidu.tieba.za5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoAttentionPageRecomendListAdapter extends RecyclerView.Adapter<RecomendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public Context b;
    public List<VideoAttentionPersonListData> c;
    public View d;
    public View e;

    /* loaded from: classes8.dex */
    public static class RecomendViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public UserIconBox a;
        public TextView b;
        public TextView c;
        public TextView d;
        public UserLikeInAttentionButton e;
        public HeadPendantClickableView f;
        public RecyclerView g;
        public VideoAttentionReccomendListAdapter h;
        public za5 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecomendViewHolder(Context context, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.obfuscated_res_0x7f090f08);
            this.f = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.f.getHeadView().setIsRound(true);
            this.f.getHeadView().setDrawBorder(true);
            this.f.getHeadView().setBorderWidth(BdUtilHelper.getDimens(context, R.dimen.L_X01));
            this.f.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f.getHeadView().setPlaceHolder(1);
            this.f.setBigVDimenSize(R.dimen.tbds36);
            this.a = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f09297b);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092838);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903f5);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ae6);
            this.e = (UserLikeInAttentionButton) view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.thread_card_list);
            this.g = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
            VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter = new VideoAttentionReccomendListAdapter(context);
            this.h = videoAttentionReccomendListAdapter;
            this.g.setAdapter(videoAttentionReccomendListAdapter);
            za5 za5Var = new za5(this.f.getTbPageContext(), this.e);
            this.i = za5Var;
            za5Var.i(true);
        }

        public void b(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                this.f.setOnClickListener(onClickListener);
                this.a.setOnClickListener(onClickListener);
                this.b.setOnClickListener(onClickListener);
                this.c.setOnClickListener(onClickListener);
                this.d.setOnClickListener(onClickListener);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPersonListData a;
        public final /* synthetic */ VideoAttentionPageRecomendListAdapter b;

        public a(VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter, VideoAttentionPersonListData videoAttentionPersonListData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageRecomendListAdapter, videoAttentionPersonListData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoAttentionPageRecomendListAdapter;
            this.a = videoAttentionPersonListData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090f08 || view2.getId() == R.id.obfuscated_res_0x7f09297b || view2.getId() == R.id.obfuscated_res_0x7f092838 || view2.getId() == R.id.obfuscated_res_0x7f0903f5 || view2.getId() == R.id.obfuscated_res_0x7f090ae6) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.b.b, this.a.getUserData().getUserId(), this.a.getUserData().getName_show());
                    personInfoActivityConfig.setIsVideoThread(true);
                    if (this.b.a != 3 && this.b.a != 4) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
                    } else {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    this.b.n(1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements UserLikeInAttentionButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPersonListData a;
        public final /* synthetic */ VideoAttentionPageRecomendListAdapter b;

        public b(VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter, VideoAttentionPersonListData videoAttentionPersonListData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageRecomendListAdapter, videoAttentionPersonListData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoAttentionPageRecomendListAdapter;
            this.a = videoAttentionPersonListData;
        }

        @Override // com.baidu.tieba.view.UserLikeInAttentionButton.a
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.getUserData() == null) {
                return;
            }
            if (this.a.getUserData().getIsLike()) {
                this.b.n(3);
            } else {
                this.b.n(2);
            }
        }
    }

    public VideoAttentionPageRecomendListAdapter(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        this.a = i;
        this.c = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public RecomendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d09cf, viewGroup, false);
            this.d = inflate;
            this.e = inflate.findViewById(R.id.obfuscated_res_0x7f092924);
            return new RecomendViewHolder(this.b, this.d);
        }
        return (RecomendViewHolder) invokeLI.objValue;
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_PAGE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public void setData(List<VideoAttentionPersonListData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.c.clear();
            this.c.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<VideoAttentionPersonListData> list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(RecomendViewHolder recomendViewHolder, int i) {
        List<VideoAttentionPersonListData> list;
        VideoAttentionPersonListData videoAttentionPersonListData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, recomendViewHolder, i) == null) && recomendViewHolder != null && (list = this.c) != null && (videoAttentionPersonListData = list.get(i)) != null && videoAttentionPersonListData.getUserData().getName_show() != null && videoAttentionPersonListData.getUserData().getUserId() != null) {
            s(videoAttentionPersonListData, recomendViewHolder);
            x(videoAttentionPersonListData, recomendViewHolder);
            u(videoAttentionPersonListData, recomendViewHolder);
            r(videoAttentionPersonListData, recomendViewHolder);
            t(videoAttentionPersonListData.getVideoItemDatas(), recomendViewHolder);
            q(videoAttentionPersonListData, recomendViewHolder);
            EMManager.from(this.e).setCorner(R.string.J_X05).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0105));
            recomendViewHolder.b(new a(this, videoAttentionPersonListData));
        }
    }

    public final void q(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        za5 za5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, videoAttentionPersonListData, recomendViewHolder) == null) {
            recomendViewHolder.e.setOnClickEvent(new b(this, videoAttentionPersonListData));
            if (videoAttentionPersonListData != null && recomendViewHolder != null && (za5Var = recomendViewHolder.i) != null) {
                za5Var.l(videoAttentionPersonListData.getUserData());
            }
        }
    }

    public final void t(ArrayList<VideoItemData> arrayList, RecomendViewHolder recomendViewHolder) {
        VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, arrayList, recomendViewHolder) == null) && arrayList != null && recomendViewHolder != null && (videoAttentionReccomendListAdapter = recomendViewHolder.h) != null) {
            videoAttentionReccomendListAdapter.setData(arrayList);
        }
    }

    public final void r(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, videoAttentionPersonListData, recomendViewHolder) == null) && videoAttentionPersonListData != null && recomendViewHolder != null) {
            String numberUniformFormatExtraWithRound = StringHelper.numberUniformFormatExtraWithRound(videoAttentionPersonListData.getUserData().getFansNum());
            TextView textView = recomendViewHolder.d;
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.fans_default_name) + numberUniformFormatExtraWithRound);
            if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().isNewGod()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recomendViewHolder.d.getLayoutParams();
                layoutParams.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                recomendViewHolder.c.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getNewGodData().getFieldName() + xw5.c(videoAttentionPersonListData.getUserData().getNewGodData().isVideoGod()), 16, "..."));
                recomendViewHolder.c.setVisibility(0);
            } else if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().showBazhuGrade()) {
                recomendViewHolder.c.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getBazhuGradeData().getDesc(), 16, "..."));
                recomendViewHolder.c.setVisibility(0);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) recomendViewHolder.d.getLayoutParams();
                layoutParams2.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                recomendViewHolder.c.setVisibility(8);
            }
        }
    }

    public final void s(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoAttentionPersonListData, recomendViewHolder) == null) && videoAttentionPersonListData != null && recomendViewHolder != null) {
            recomendViewHolder.f.getHeadView().setUserId(videoAttentionPersonListData.getUserData().getUserId());
            recomendViewHolder.f.getHeadView().setUserName(videoAttentionPersonListData.getUserData().getUserName());
            recomendViewHolder.f.i(videoAttentionPersonListData.getUserData());
            recomendViewHolder.f.o(videoAttentionPersonListData.getUserData());
        }
    }

    public final void u(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, videoAttentionPersonListData, recomendViewHolder) == null) && videoAttentionPersonListData != null && recomendViewHolder != null) {
            recomendViewHolder.b.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getName_show(), 16, "..."));
            recomendViewHolder.b.setTag(R.id.tag_user_id, videoAttentionPersonListData.getUserData().getUserId());
            recomendViewHolder.b.setTag(R.id.tag_user_name, videoAttentionPersonListData.getUserData().getName_show());
        }
    }

    public final void x(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, videoAttentionPersonListData, recomendViewHolder) == null) && videoAttentionPersonListData != null && recomendViewHolder != null) {
            ArrayList<IconData> tShowInfoNew = videoAttentionPersonListData.getUserData().getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                recomendViewHolder.a.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recomendViewHolder.b.getLayoutParams();
                layoutParams.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) recomendViewHolder.b.getLayoutParams();
                layoutParams2.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            recomendViewHolder.a.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }
}
