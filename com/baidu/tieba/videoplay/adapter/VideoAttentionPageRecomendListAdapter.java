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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.R;
import com.baidu.tieba.fj;
import com.baidu.tieba.nv4;
import com.baidu.tieba.ti5;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.tieba.view.UserLikeInAttentionButton;
import com.baidu.tieba.wz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoAttentionPageRecomendListAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public Context b;
    public List c;
    public View d;
    public View e;

    /* loaded from: classes6.dex */
    public class RecomendViewHolder extends RecyclerView.ViewHolder {
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
        public wz4 i;

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
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view2.findViewById(R.id.obfuscated_res_0x7f090d4b);
            this.f = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.f.getHeadView().setIsRound(true);
            this.f.getHeadView().setDrawBorder(true);
            this.f.getHeadView().setBorderWidth(fj.f(context, R.dimen.L_X01));
            this.f.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f.getHeadView().setPlaceHolder(1);
            this.f.setBigVDimenSize(R.dimen.tbds36);
            this.a = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0925d7);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924a7);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09039f);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909a0);
            this.e = (UserLikeInAttentionButton) view2.findViewById(R.id.obfuscated_res_0x7f0906cd);
            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f09217c);
            this.g = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
            VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter = new VideoAttentionReccomendListAdapter(context);
            this.h = videoAttentionReccomendListAdapter;
            this.g.setAdapter(videoAttentionReccomendListAdapter);
            wz4 wz4Var = new wz4(this.f.getTbPageContext(), this.e);
            this.i = wz4Var;
            wz4Var.k(true);
        }

        public void a(View.OnClickListener onClickListener) {
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

    /* loaded from: classes6.dex */
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
                if (view2.getId() == R.id.obfuscated_res_0x7f090d4b || view2.getId() == R.id.obfuscated_res_0x7f0925d7 || view2.getId() == R.id.obfuscated_res_0x7f0924a7 || view2.getId() == R.id.obfuscated_res_0x7f09039f || view2.getId() == R.id.obfuscated_res_0x7f0909a0) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.b.b, this.a.getUserData().getUserId(), this.a.getUserData().getName_show());
                    personInfoActivityConfig.setIsVideoThread(true);
                    if (this.b.a != 3 && this.b.a != 4) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
                    } else {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    this.b.f(1);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.b.f(3);
            } else {
                this.b.f(2);
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
    /* renamed from: h */
    public RecomendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d08ca, viewGroup, false);
            this.d = inflate;
            this.e = inflate.findViewById(R.id.obfuscated_res_0x7f092584);
            return new RecomendViewHolder(this.b, this.d);
        }
        return (RecomendViewHolder) invokeLI.objValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_PAGE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public void setData(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.c.clear();
            this.c.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(RecomendViewHolder recomendViewHolder, int i) {
        List list;
        VideoAttentionPersonListData videoAttentionPersonListData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recomendViewHolder, i) == null) && recomendViewHolder != null && (list = this.c) != null && (videoAttentionPersonListData = (VideoAttentionPersonListData) list.get(i)) != null && videoAttentionPersonListData.getUserData().getName_show() != null && videoAttentionPersonListData.getUserData().getUserId() != null) {
            k(videoAttentionPersonListData, recomendViewHolder);
            n(videoAttentionPersonListData, recomendViewHolder);
            m(videoAttentionPersonListData, recomendViewHolder);
            j(videoAttentionPersonListData, recomendViewHolder);
            l(videoAttentionPersonListData.getVideoItemDatas(), recomendViewHolder);
            i(videoAttentionPersonListData, recomendViewHolder);
            nv4 d = nv4.d(this.e);
            d.n(R.string.J_X05);
            d.g(SkinManager.getColor(0, (int) R.color.CAM_X0105));
            recomendViewHolder.a(new a(this, videoAttentionPersonListData));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final void i(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        wz4 wz4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, videoAttentionPersonListData, recomendViewHolder) == null) {
            recomendViewHolder.e.setOnClickEvent(new b(this, videoAttentionPersonListData));
            if (videoAttentionPersonListData != null && recomendViewHolder != null && (wz4Var = recomendViewHolder.i) != null) {
                wz4Var.n(videoAttentionPersonListData.getUserData());
            }
        }
    }

    public final void l(ArrayList arrayList, RecomendViewHolder recomendViewHolder) {
        VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, arrayList, recomendViewHolder) == null) && arrayList != null && recomendViewHolder != null && (videoAttentionReccomendListAdapter = recomendViewHolder.h) != null) {
            videoAttentionReccomendListAdapter.setData(arrayList);
        }
    }

    public final void j(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, videoAttentionPersonListData, recomendViewHolder) == null) && videoAttentionPersonListData != null && recomendViewHolder != null) {
            String numberUniformFormatExtraWithRound = StringHelper.numberUniformFormatExtraWithRound(videoAttentionPersonListData.getUserData().getFansNum());
            TextView textView = recomendViewHolder.d;
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f061a) + numberUniformFormatExtraWithRound);
            if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().isNewGod()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recomendViewHolder.d.getLayoutParams();
                layoutParams.setMargins(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                recomendViewHolder.c.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getNewGodData().getFieldName() + ti5.c(videoAttentionPersonListData.getUserData().getNewGodData().isVideoGod()), 16, StringHelper.STRING_MORE));
                recomendViewHolder.c.setVisibility(0);
            } else if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().showBazhuGrade()) {
                recomendViewHolder.c.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
                recomendViewHolder.c.setVisibility(0);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) recomendViewHolder.d.getLayoutParams();
                layoutParams2.setMargins(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                recomendViewHolder.c.setVisibility(8);
            }
        }
    }

    public final void k(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, videoAttentionPersonListData, recomendViewHolder) == null) && videoAttentionPersonListData != null && recomendViewHolder != null) {
            recomendViewHolder.f.getHeadView().setUserId(videoAttentionPersonListData.getUserData().getUserId());
            recomendViewHolder.f.getHeadView().setUserName(videoAttentionPersonListData.getUserData().getUserName());
            recomendViewHolder.f.j(videoAttentionPersonListData.getUserData(), 4);
            recomendViewHolder.f.n(videoAttentionPersonListData.getUserData());
        }
    }

    public final void m(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoAttentionPersonListData, recomendViewHolder) == null) && videoAttentionPersonListData != null && recomendViewHolder != null) {
            recomendViewHolder.b.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getName_show(), 16, StringHelper.STRING_MORE));
            recomendViewHolder.b.setTag(R.id.obfuscated_res_0x7f092091, videoAttentionPersonListData.getUserData().getUserId());
            recomendViewHolder.b.setTag(R.id.obfuscated_res_0x7f092099, videoAttentionPersonListData.getUserData().getName_show());
        }
    }

    public final void n(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, videoAttentionPersonListData, recomendViewHolder) == null) && videoAttentionPersonListData != null && recomendViewHolder != null) {
            ArrayList tShowInfoNew = videoAttentionPersonListData.getUserData().getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                recomendViewHolder.a.setTag(((IconData) tShowInfoNew.get(0)).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recomendViewHolder.b.getLayoutParams();
                layoutParams.setMargins(fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) recomendViewHolder.b.getLayoutParams();
                layoutParams2.setMargins(fj.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            recomendViewHolder.a.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }
}
