package com.baidu.tieba.videoplay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.m;
import c.a.s0.s.u.c;
import c.a.t0.m4.b;
import c.a.t0.m4.d;
import c.a.t0.m4.f;
import c.a.t0.m4.g;
import c.a.t0.m4.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class VideoAttentionReccomendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<VideoItemData> f48840b;

    /* renamed from: c  reason: collision with root package name */
    public View f48841c;

    /* renamed from: d  reason: collision with root package name */
    public String f48842d;
    public boolean isNaniVideo;

    /* loaded from: classes12.dex */
    public static class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View mMaskView;
        public TbImageView mPlayItem;
        public EMTextView mPlayNumber;
        public TbImageView mPlayNumberImage;
        public EMTextView mPlayTime;
        public View mRootView;
        public EMTextView mTextTitle;
        public TbImageView mVideoCover;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForumViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.mRootView = view;
            this.mVideoCover = (TbImageView) view.findViewById(f.img_video_cover);
            this.mPlayItem = (TbImageView) view.findViewById(f.play_item);
            this.mPlayTime = (EMTextView) view.findViewById(f.play_time);
            this.mPlayNumber = (EMTextView) view.findViewById(f.text_play_number);
            this.mTextTitle = (EMTextView) view.findViewById(f.text_title);
            this.mPlayNumberImage = (TbImageView) view.findViewById(f.img_play_number);
            this.mMaskView = view.findViewById(f.img_mask);
            this.mVideoCover.setRadiusById(i.J_X05);
            this.mVideoCover.setConrers(3);
            c.d(this.mMaskView).s(b.Mask_X003);
            c d2 = c.d(view);
            d2.n(i.J_X05);
            d2.f(c.a.t0.m4.c.CAM_X0613);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) || (view = this.mRootView) == null) {
                return;
            }
            view.setOnClickListener(onClickListener);
        }
    }

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48843e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoItemData f48844f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionReccomendListAdapter f48845g;

        public a(VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter, int i2, VideoItemData videoItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionReccomendListAdapter, Integer.valueOf(i2), videoItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48845g = videoAttentionReccomendListAdapter;
            this.f48843e = i2;
            this.f48844f = videoItemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this.f48845g.a, this.f48845g.f48840b, 0, null, "video_attention_tab", "", "", "");
                videoRecommentPlayActivityConfig.setVideoShowIndex(this.f48843e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
                this.f48845g.f48842d = this.f48844f.thread_id;
                this.f48845g.attentionListPageClick(4);
            }
        }
    }

    public VideoAttentionReccomendListAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isNaniVideo = false;
        this.f48840b = new ArrayList();
        this.a = context;
    }

    public void attentionListPageClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_PAGE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.f48842d);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void d(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.mPlayNumber.setText(StringHelper.numberUniformFormatExtra(videoItemData.play_count));
        c d2 = c.d(forumViewHolder.mPlayNumber);
        d2.z(d.T_X09);
        d2.v(c.a.t0.m4.c.CAM_X0101);
    }

    public final void e(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = videoItemData.video_duration;
        int i3 = i2 / 3600;
        int i4 = (i2 % 3600) / 60;
        int i5 = (i2 % 3600) % 60;
        if (i3 > 0) {
            if (i3 < 10) {
                sb.append("0");
            }
            sb.append(i3);
            sb.append(":");
        }
        if (i4 > 0) {
            if (i4 < 10) {
                sb.append("0");
            }
            sb.append(i4);
            sb.append(":");
        } else {
            sb.append("00");
            sb.append(":");
        }
        if (i5 > 0) {
            if (i5 < 10) {
                sb.append("0");
            }
            sb.append(i5);
        } else {
            sb.append("00");
        }
        c d2 = c.d(forumViewHolder.mPlayTime);
        d2.z(d.T_X09);
        d2.v(c.a.t0.m4.c.CAM_X0101);
        forumViewHolder.mPlayTime.setText(sb.toString());
    }

    public final void f(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        if (!m.isEmpty(videoItemData.title)) {
            forumViewHolder.mTextTitle.setText(videoItemData.title);
        } else if (!m.isEmpty(videoItemData.abstext)) {
            forumViewHolder.mTextTitle.setText(videoItemData.abstext);
        } else {
            forumViewHolder.mTextTitle.setText(TbadkCoreApplication.getInst().getString(i.original_recommend_video_attention_txt));
        }
    }

    public final void g(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.mVideoCover.startLoad(videoItemData.thumbnail_url, 10, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<VideoItemData> list = this.f48840b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    public void setData(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f48840b.clear();
            this.f48840b.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i2) {
        List<VideoItemData> list;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, forumViewHolder, i2) == null) || forumViewHolder == null || (list = this.f48840b) == null || (videoItemData = list.get(i2)) == null) {
            return;
        }
        g(videoItemData, forumViewHolder);
        e(videoItemData, forumViewHolder);
        d(videoItemData, forumViewHolder);
        f(videoItemData, forumViewHolder);
        forumViewHolder.setOnClickListener(new a(this, i2, videoItemData));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i2)) == null) {
            this.f48841c = LayoutInflater.from(this.a).inflate(g.video_attention_list_cover_view, viewGroup, false);
            return new ForumViewHolder(this.f48841c);
        }
        return (ForumViewHolder) invokeLI.objValue;
    }
}
