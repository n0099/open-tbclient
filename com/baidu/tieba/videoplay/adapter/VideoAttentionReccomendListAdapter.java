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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.r0.r.u.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoAttentionReccomendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f21826a;

    /* renamed from: b  reason: collision with root package name */
    public List<VideoItemData> f21827b;

    /* renamed from: c  reason: collision with root package name */
    public View f21828c;

    /* loaded from: classes5.dex */
    public static class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f21829a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f21830b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f21831c;

        /* renamed from: d  reason: collision with root package name */
        public EMTextView f21832d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f21833e;

        /* renamed from: f  reason: collision with root package name */
        public EMTextView f21834f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f21835g;

        /* renamed from: h  reason: collision with root package name */
        public View f21836h;

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
            this.f21829a = view;
            this.f21830b = (TbImageView) view.findViewById(R.id.img_video_cover);
            this.f21831c = (TbImageView) view.findViewById(R.id.play_item);
            this.f21832d = (EMTextView) view.findViewById(R.id.play_time);
            this.f21833e = (EMTextView) view.findViewById(R.id.text_play_number);
            this.f21834f = (EMTextView) view.findViewById(R.id.text_title);
            this.f21835g = (TbImageView) view.findViewById(R.id.img_play_number);
            this.f21836h = view.findViewById(R.id.img_mask);
            this.f21830b.setRadiusById(R.string.J_X05);
            this.f21830b.setConrers(3);
            c.d(this.f21836h).r(R.array.Mask_X003);
            c d2 = c.d(view);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0613);
        }

        public void a(View.OnClickListener onClickListener) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) || (view = this.f21829a) == null) {
                return;
            }
            view.setOnClickListener(onClickListener);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21837e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionReccomendListAdapter f21838f;

        public a(VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionReccomendListAdapter, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21838f = videoAttentionReccomendListAdapter;
            this.f21837e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f21838f.f21826a, this.f21838f.f21827b, 0, null, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_ATTENTION_TAB, "", "", "");
                videoPlayActivityConfig.setVideoShowIndex(this.f21837e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
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
        this.f21827b = new ArrayList();
        this.f21826a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i2) {
        List<VideoItemData> list;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, forumViewHolder, i2) == null) || forumViewHolder == null || (list = this.f21827b) == null || (videoItemData = list.get(i2)) == null) {
            return;
        }
        k(videoItemData, forumViewHolder);
        i(videoItemData, forumViewHolder);
        h(videoItemData, forumViewHolder);
        j(videoItemData, forumViewHolder);
        forumViewHolder.a(new a(this, i2));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
            this.f21828c = LayoutInflater.from(this.f21826a).inflate(R.layout.video_attention_list_cover_view, viewGroup, false);
            return new ForumViewHolder(this.f21828c);
        }
        return (ForumViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<VideoItemData> list = this.f21827b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final void h(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f21833e.setText(StringHelper.numberUniformFormatExtra(videoItemData.play_count));
        c d2 = c.d(forumViewHolder.f21833e);
        d2.x(R.dimen.T_X09);
        d2.t(R.color.CAM_X0101);
    }

    public final void i(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
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
        c d2 = c.d(forumViewHolder.f21832d);
        d2.x(R.dimen.T_X09);
        d2.t(R.color.CAM_X0101);
        forumViewHolder.f21832d.setText(sb.toString());
    }

    public final void j(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        if (!k.isEmpty(videoItemData.title)) {
            forumViewHolder.f21834f.setText(videoItemData.title);
        } else if (!k.isEmpty(videoItemData.abstext)) {
            forumViewHolder.f21834f.setText(videoItemData.abstext);
        } else {
            forumViewHolder.f21834f.setText(TbadkCoreApplication.getInst().getString(R.string.original_recommend_video_attention_txt));
        }
    }

    public final void k(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f21830b.M(videoItemData.thumbnail_url, 10, false);
    }

    public void setData(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f21827b.clear();
            this.f21827b.addAll(list);
            notifyDataSetChanged();
        }
    }
}
