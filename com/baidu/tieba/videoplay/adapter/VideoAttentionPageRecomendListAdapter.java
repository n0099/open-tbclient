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
import c.a.d.f.p.n;
import c.a.o0.c1.s0;
import c.a.o0.r.l0.t.c;
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
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.tieba.view.UserLikeInAttentionButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoAttentionPageRecomendListAdapter extends RecyclerView.Adapter<RecomendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public Context f36634b;

    /* renamed from: c  reason: collision with root package name */
    public List<VideoAttentionPersonListData> f36635c;

    /* renamed from: d  reason: collision with root package name */
    public View f36636d;

    /* renamed from: e  reason: collision with root package name */
    public View f36637e;

    /* loaded from: classes6.dex */
    public static class RecomendViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public UserIconBox a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f36638b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f36639c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f36640d;

        /* renamed from: e  reason: collision with root package name */
        public UserLikeInAttentionButton f36641e;

        /* renamed from: f  reason: collision with root package name */
        public HeadPendantClickableView f36642f;

        /* renamed from: g  reason: collision with root package name */
        public RecyclerView f36643g;

        /* renamed from: h  reason: collision with root package name */
        public VideoAttentionReccomendListAdapter f36644h;
        public c i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecomendViewHolder(Context context, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view};
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
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.obfuscated_res_0x7f090d2e);
            this.f36642f = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.f36642f.getHeadView().setIsRound(true);
            this.f36642f.getHeadView().setDrawBorder(true);
            this.f36642f.getHeadView().setBorderWidth(n.f(context, R.dimen.L_X01));
            this.f36642f.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f36642f.getHeadView().setPlaceHolder(1);
            this.f36642f.setBigVDimenSize(R.dimen.tbds36);
            this.a = (UserIconBox) view.findViewById(R.id.obfuscated_res_0x7f0923f7);
            this.f36638b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922c1);
            this.f36639c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090372);
            this.f36640d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09096f);
            this.f36641e = (UserLikeInAttentionButton) view.findViewById(R.id.obfuscated_res_0x7f0906b9);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.obfuscated_res_0x7f091f99);
            this.f36643g = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
            VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter = new VideoAttentionReccomendListAdapter(context);
            this.f36644h = videoAttentionReccomendListAdapter;
            this.f36643g.setAdapter(videoAttentionReccomendListAdapter);
            c cVar = new c(this.f36642f.getTbPageContext(), this.f36641e);
            this.i = cVar;
            cVar.k(true);
        }

        public void a(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                this.f36642f.setOnClickListener(onClickListener);
                this.a.setOnClickListener(onClickListener);
                this.f36638b.setOnClickListener(onClickListener);
                this.f36639c.setOnClickListener(onClickListener);
                this.f36640d.setOnClickListener(onClickListener);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPersonListData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageRecomendListAdapter f36645b;

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
            this.f36645b = videoAttentionPageRecomendListAdapter;
            this.a = videoAttentionPersonListData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f090d2e || view.getId() == R.id.obfuscated_res_0x7f0923f7 || view.getId() == R.id.obfuscated_res_0x7f0922c1 || view.getId() == R.id.obfuscated_res_0x7f090372 || view.getId() == R.id.obfuscated_res_0x7f09096f) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f36645b.f36634b, this.a.getUserData().getUserId(), this.a.getUserData().getName_show());
                    personInfoActivityConfig.setIsVideoThread(true);
                    if (this.f36645b.a != 3 && this.f36645b.a != 4) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
                    } else {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    this.f36645b.f(1);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements UserLikeInAttentionButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionPersonListData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageRecomendListAdapter f36646b;

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
            this.f36646b = videoAttentionPageRecomendListAdapter;
            this.a = videoAttentionPersonListData;
        }

        @Override // com.baidu.tieba.view.UserLikeInAttentionButton.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.getUserData() == null) {
                return;
            }
            if (this.a.getUserData().getIsLike()) {
                this.f36646b.f(3);
            } else {
                this.f36646b.f(2);
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
        this.f36634b = context;
        this.a = i;
        this.f36635c = new ArrayList();
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(RecomendViewHolder recomendViewHolder, int i) {
        List<VideoAttentionPersonListData> list;
        VideoAttentionPersonListData videoAttentionPersonListData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recomendViewHolder, i) == null) || recomendViewHolder == null || (list = this.f36635c) == null || (videoAttentionPersonListData = list.get(i)) == null || videoAttentionPersonListData.getUserData().getName_show() == null || videoAttentionPersonListData.getUserData().getUserId() == null) {
            return;
        }
        k(videoAttentionPersonListData, recomendViewHolder);
        n(videoAttentionPersonListData, recomendViewHolder);
        m(videoAttentionPersonListData, recomendViewHolder);
        j(videoAttentionPersonListData, recomendViewHolder);
        l(videoAttentionPersonListData.getVideoItemDatas(), recomendViewHolder);
        i(videoAttentionPersonListData, recomendViewHolder);
        c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f36637e);
        d2.n(R.string.J_X05);
        d2.g(SkinManager.getColor(0, (int) R.color.CAM_X0105));
        recomendViewHolder.a(new a(this, videoAttentionPersonListData));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<VideoAttentionPersonListData> list = this.f36635c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public RecomendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            View inflate = LayoutInflater.from(this.f36634b).inflate(R.layout.obfuscated_res_0x7f0d0874, viewGroup, false);
            this.f36636d = inflate;
            this.f36637e = inflate.findViewById(R.id.obfuscated_res_0x7f0923a2);
            return new RecomendViewHolder(this.f36634b, this.f36636d);
        }
        return (RecomendViewHolder) invokeLI.objValue;
    }

    public final void i(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, videoAttentionPersonListData, recomendViewHolder) == null) {
            recomendViewHolder.f36641e.setOnClickEvent(new b(this, videoAttentionPersonListData));
            if (videoAttentionPersonListData == null || recomendViewHolder == null || (cVar = recomendViewHolder.i) == null) {
                return;
            }
            cVar.n(videoAttentionPersonListData.getUserData());
        }
    }

    public final void j(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(videoAttentionPersonListData.getUserData().getFansNum());
        TextView textView = recomendViewHolder.f36640d;
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f05e7) + numberUniformFormatExtra);
        if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recomendViewHolder.f36640d.getLayoutParams();
            layoutParams.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            recomendViewHolder.f36639c.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getNewGodData().getFieldName() + s0.c(videoAttentionPersonListData.getUserData().getNewGodData().isVideoGod()), 16, StringHelper.STRING_MORE));
            recomendViewHolder.f36639c.setVisibility(0);
        } else if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().showBazhuGrade()) {
            recomendViewHolder.f36639c.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
            recomendViewHolder.f36639c.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) recomendViewHolder.f36640d.getLayoutParams();
            layoutParams2.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            recomendViewHolder.f36639c.setVisibility(8);
        }
    }

    public final void k(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        recomendViewHolder.f36642f.getHeadView().setUserId(videoAttentionPersonListData.getUserData().getUserId());
        recomendViewHolder.f36642f.getHeadView().setUserName(videoAttentionPersonListData.getUserData().getUserName());
        recomendViewHolder.f36642f.j(videoAttentionPersonListData.getUserData(), 4);
        recomendViewHolder.f36642f.n(videoAttentionPersonListData.getUserData());
    }

    public final void l(ArrayList<VideoItemData> arrayList, RecomendViewHolder recomendViewHolder) {
        VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, arrayList, recomendViewHolder) == null) || arrayList == null || recomendViewHolder == null || (videoAttentionReccomendListAdapter = recomendViewHolder.f36644h) == null) {
            return;
        }
        videoAttentionReccomendListAdapter.setData(arrayList);
    }

    public final void m(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        recomendViewHolder.f36638b.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getName_show(), 16, StringHelper.STRING_MORE));
        recomendViewHolder.f36638b.setTag(R.id.obfuscated_res_0x7f091eb7, videoAttentionPersonListData.getUserData().getUserId());
        recomendViewHolder.f36638b.setTag(R.id.obfuscated_res_0x7f091ebf, videoAttentionPersonListData.getUserData().getName_show());
    }

    public final void n(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = videoAttentionPersonListData.getUserData().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            recomendViewHolder.a.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recomendViewHolder.f36638b.getLayoutParams();
            layoutParams.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) recomendViewHolder.f36638b.getLayoutParams();
            layoutParams2.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        recomendViewHolder.a.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    public void setData(List<VideoAttentionPersonListData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f36635c.clear();
            this.f36635c.addAll(list);
            notifyDataSetChanged();
        }
    }
}
