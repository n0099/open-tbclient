package com.baidu.tieba.videoplay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.p0.s.u.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoAttentionReccomendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f22012a;

    /* renamed from: b  reason: collision with root package name */
    public List<VideoItemData> f22013b;

    /* renamed from: c  reason: collision with root package name */
    public View f22014c;

    /* renamed from: d  reason: collision with root package name */
    public String f22015d;

    /* loaded from: classes4.dex */
    public static class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f22016a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f22017b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f22018c;

        /* renamed from: d  reason: collision with root package name */
        public EMTextView f22019d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f22020e;

        /* renamed from: f  reason: collision with root package name */
        public EMTextView f22021f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f22022g;

        /* renamed from: h  reason: collision with root package name */
        public View f22023h;

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
            this.f22016a = view;
            this.f22017b = (TbImageView) view.findViewById(R.id.img_video_cover);
            this.f22018c = (TbImageView) view.findViewById(R.id.play_item);
            this.f22019d = (EMTextView) view.findViewById(R.id.play_time);
            this.f22020e = (EMTextView) view.findViewById(R.id.text_play_number);
            this.f22021f = (EMTextView) view.findViewById(R.id.text_title);
            this.f22022g = (TbImageView) view.findViewById(R.id.img_play_number);
            this.f22023h = view.findViewById(R.id.img_mask);
            this.f22017b.setRadiusById(R.string.J_X05);
            this.f22017b.setConrers(3);
            c.d(this.f22023h).r(R.array.Mask_X003);
            c d2 = c.d(view);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0613);
        }

        public void a(View.OnClickListener onClickListener) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) || (view = this.f22016a) == null) {
                return;
            }
            view.setOnClickListener(onClickListener);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22024e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoItemData f22025f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionReccomendListAdapter f22026g;

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
            this.f22026g = videoAttentionReccomendListAdapter;
            this.f22024e = i2;
            this.f22025f = videoItemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this.f22026g.f22012a, this.f22026g.f22013b, 0, null, "video_attention_tab", "", "", "");
                videoRecommentPlayActivityConfig.setVideoShowIndex(this.f22024e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
                this.f22026g.f22015d = this.f22025f.thread_id;
                this.f22026g.g(4);
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
        this.f22013b = new ArrayList();
        this.f22012a = context;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_PAGE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.f22015d);
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<VideoItemData> list = this.f22013b;
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
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i2) {
        List<VideoItemData> list;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, forumViewHolder, i2) == null) || forumViewHolder == null || (list = this.f22013b) == null || (videoItemData = list.get(i2)) == null) {
            return;
        }
        m(videoItemData, forumViewHolder);
        k(videoItemData, forumViewHolder);
        j(videoItemData, forumViewHolder);
        l(videoItemData, forumViewHolder);
        forumViewHolder.a(new a(this, i2, videoItemData));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
            this.f22014c = LayoutInflater.from(this.f22012a).inflate(R.layout.video_attention_list_cover_view, viewGroup, false);
            return new ForumViewHolder(this.f22014c);
        }
        return (ForumViewHolder) invokeLI.objValue;
    }

    public final void j(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f22020e.setText(StringHelper.numberUniformFormatExtra(videoItemData.play_count));
        c d2 = c.d(forumViewHolder.f22020e);
        d2.x(R.dimen.T_X09);
        d2.t(R.color.CAM_X0101);
    }

    public final void k(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
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
        c d2 = c.d(forumViewHolder.f22019d);
        d2.x(R.dimen.T_X09);
        d2.t(R.color.CAM_X0101);
        forumViewHolder.f22019d.setText(sb.toString());
    }

    public final void l(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        if (!k.isEmpty(videoItemData.title)) {
            forumViewHolder.f22021f.setText(videoItemData.title);
        } else if (!k.isEmpty(videoItemData.abstext)) {
            forumViewHolder.f22021f.setText(videoItemData.abstext);
        } else {
            forumViewHolder.f22021f.setText(TbadkCoreApplication.getInst().getString(R.string.original_recommend_video_attention_txt));
        }
    }

    public final void m(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f22017b.M(videoItemData.thumbnail_url, 10, false);
    }

    public void setData(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.f22013b.clear();
            this.f22013b.addAll(list);
            notifyDataSetChanged();
        }
    }
}
