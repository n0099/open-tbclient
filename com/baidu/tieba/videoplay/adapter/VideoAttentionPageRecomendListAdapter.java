package com.baidu.tieba.videoplay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.q0.c1.s0;
import c.a.q0.r.l0.t.c;
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
    public Context f47438b;

    /* renamed from: c  reason: collision with root package name */
    public List<VideoAttentionPersonListData> f47439c;

    /* renamed from: d  reason: collision with root package name */
    public View f47440d;

    /* renamed from: e  reason: collision with root package name */
    public View f47441e;

    /* loaded from: classes6.dex */
    public static class RecomendViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public UserLikeInAttentionButton mAttentionBtn;
        public TextView mBjhAuthorAuth;
        public TextView mFansCount;
        public HeadPendantClickableView mHeadView;
        public VideoAttentionReccomendListAdapter mHorizontalAdapter;
        public RecyclerView mHorizontalList;
        public c mUserLikePresenter;
        public TextView mUserName;
        public UserIconBox mVipIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecomendViewHolder(Context context, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
            this.mHeadView = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.mHeadView.getHeadView().setIsRound(true);
            this.mHeadView.getHeadView().setDrawBorder(true);
            this.mHeadView.getHeadView().setBorderWidth(n.f(context, R.dimen.L_X01));
            this.mHeadView.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.mHeadView.getHeadView().setPlaceHolder(1);
            this.mHeadView.setBigVDimenSize(R.dimen.tbds36);
            this.mVipIcon = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
            this.mUserName = (TextView) view.findViewById(R.id.user_name_video_info_item);
            this.mBjhAuthorAuth = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
            this.mFansCount = (TextView) view.findViewById(R.id.fans_count_video_info_item);
            this.mAttentionBtn = (UserLikeInAttentionButton) view.findViewById(R.id.concern_video_info_item);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.thread_card_list);
            this.mHorizontalList = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
            VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter = new VideoAttentionReccomendListAdapter(context);
            this.mHorizontalAdapter = videoAttentionReccomendListAdapter;
            this.mHorizontalList.setAdapter(videoAttentionReccomendListAdapter);
            c cVar = new c(this.mHeadView.getTbPageContext(), this.mAttentionBtn);
            this.mUserLikePresenter = cVar;
            cVar.k(true);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                this.mHeadView.setOnClickListener(onClickListener);
                this.mVipIcon.setOnClickListener(onClickListener);
                this.mUserName.setOnClickListener(onClickListener);
                this.mBjhAuthorAuth.setOnClickListener(onClickListener);
                this.mFansCount.setOnClickListener(onClickListener);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPersonListData f47442e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageRecomendListAdapter f47443f;

        public a(VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter, VideoAttentionPersonListData videoAttentionPersonListData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageRecomendListAdapter, videoAttentionPersonListData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47443f = videoAttentionPageRecomendListAdapter;
            this.f47442e = videoAttentionPersonListData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.head_view_video_info_item || view.getId() == R.id.vip_icon_video_info_item || view.getId() == R.id.user_name_video_info_item || view.getId() == R.id.bjh_author_auth_video_info_item || view.getId() == R.id.fans_count_video_info_item) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f47443f.f47438b, this.f47442e.getUserData().getUserId(), this.f47442e.getUserData().getName_show());
                    personInfoActivityConfig.setIsVideoThread(true);
                    if (this.f47443f.a != 3 && this.f47443f.a != 4) {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
                    } else {
                        personInfoActivityConfig.setVideoPersonFrom(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    this.f47443f.attentionListPageClick(1);
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
        public final /* synthetic */ VideoAttentionPageRecomendListAdapter f47444b;

        public b(VideoAttentionPageRecomendListAdapter videoAttentionPageRecomendListAdapter, VideoAttentionPersonListData videoAttentionPersonListData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionPageRecomendListAdapter, videoAttentionPersonListData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47444b = videoAttentionPageRecomendListAdapter;
            this.a = videoAttentionPersonListData;
        }

        @Override // com.baidu.tieba.view.UserLikeInAttentionButton.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.getUserData() == null) {
                return;
            }
            if (this.a.getUserData().getIsLike()) {
                this.f47444b.attentionListPageClick(3);
            } else {
                this.f47444b.attentionListPageClick(2);
            }
        }
    }

    public VideoAttentionPageRecomendListAdapter(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47438b = context;
        this.a = i2;
        this.f47439c = new ArrayList();
    }

    public void attentionListPageClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_PAGE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void c(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoAttentionPersonListData, recomendViewHolder) == null) {
            recomendViewHolder.mAttentionBtn.setOnClickEvent(new b(this, videoAttentionPersonListData));
            if (videoAttentionPersonListData == null || recomendViewHolder == null || (cVar = recomendViewHolder.mUserLikePresenter) == null) {
                return;
            }
            cVar.n(videoAttentionPersonListData.getUserData());
        }
    }

    public final void d(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(videoAttentionPersonListData.getUserData().getFansNum());
        TextView textView = recomendViewHolder.mFansCount;
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.fans_default_name) + numberUniformFormatExtra);
        if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recomendViewHolder.mFansCount.getLayoutParams();
            layoutParams.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            recomendViewHolder.mBjhAuthorAuth.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getNewGodData().getFieldName() + s0.c(videoAttentionPersonListData.getUserData().getNewGodData().isVideoGod()), 16, "..."));
            recomendViewHolder.mBjhAuthorAuth.setVisibility(0);
        } else if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().showBazhuGrade()) {
            recomendViewHolder.mBjhAuthorAuth.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getBazhuGradeData().getDesc(), 16, "..."));
            recomendViewHolder.mBjhAuthorAuth.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) recomendViewHolder.mFansCount.getLayoutParams();
            layoutParams2.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            recomendViewHolder.mBjhAuthorAuth.setVisibility(8);
        }
    }

    public final void e(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        recomendViewHolder.mHeadView.getHeadView().setUserId(videoAttentionPersonListData.getUserData().getUserId());
        recomendViewHolder.mHeadView.getHeadView().setUserName(videoAttentionPersonListData.getUserData().getUserName());
        recomendViewHolder.mHeadView.showHeadPendantAndBigV(videoAttentionPersonListData.getUserData(), 4);
        recomendViewHolder.mHeadView.startLoadWithPendantAndBigV(videoAttentionPersonListData.getUserData());
    }

    public final void f(ArrayList<VideoItemData> arrayList, RecomendViewHolder recomendViewHolder) {
        VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, arrayList, recomendViewHolder) == null) || arrayList == null || recomendViewHolder == null || (videoAttentionReccomendListAdapter = recomendViewHolder.mHorizontalAdapter) == null) {
            return;
        }
        videoAttentionReccomendListAdapter.setData(arrayList);
    }

    public final void g(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        recomendViewHolder.mUserName.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getName_show(), 16, "..."));
        recomendViewHolder.mUserName.setTag(R.id.tag_user_id, videoAttentionPersonListData.getUserData().getUserId());
        recomendViewHolder.mUserName.setTag(R.id.tag_user_name, videoAttentionPersonListData.getUserData().getName_show());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<VideoAttentionPersonListData> list = this.f47439c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final void h(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = videoAttentionPersonListData.getUserData().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            recomendViewHolder.mVipIcon.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recomendViewHolder.mUserName.getLayoutParams();
            layoutParams.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) recomendViewHolder.mUserName.getLayoutParams();
            layoutParams2.setMargins(n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        recomendViewHolder.mVipIcon.loadIcon(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    public void setData(List<VideoAttentionPersonListData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.f47439c.clear();
            this.f47439c.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecomendViewHolder recomendViewHolder, int i2) {
        List<VideoAttentionPersonListData> list;
        VideoAttentionPersonListData videoAttentionPersonListData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, recomendViewHolder, i2) == null) || recomendViewHolder == null || (list = this.f47439c) == null || (videoAttentionPersonListData = list.get(i2)) == null || videoAttentionPersonListData.getUserData().getName_show() == null || videoAttentionPersonListData.getUserData().getUserId() == null) {
            return;
        }
        e(videoAttentionPersonListData, recomendViewHolder);
        h(videoAttentionPersonListData, recomendViewHolder);
        g(videoAttentionPersonListData, recomendViewHolder);
        d(videoAttentionPersonListData, recomendViewHolder);
        f(videoAttentionPersonListData.getVideoItemDatas(), recomendViewHolder);
        c(videoAttentionPersonListData, recomendViewHolder);
        c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.f47441e);
        d2.n(R.string.J_X05);
        d2.g(SkinManager.getColor(0, (int) R.color.CAM_X0105));
        recomendViewHolder.setOnClickListener(new a(this, videoAttentionPersonListData));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecomendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i2)) == null) {
            View inflate = LayoutInflater.from(this.f47438b).inflate(R.layout.video_attention_recomend_list_view, viewGroup, false);
            this.f47440d = inflate;
            this.f47441e = inflate.findViewById(R.id.viedo_attention_list_view);
            return new RecomendViewHolder(this.f47438b, this.f47440d);
        }
        return (RecomendViewHolder) invokeLI.objValue;
    }
}
