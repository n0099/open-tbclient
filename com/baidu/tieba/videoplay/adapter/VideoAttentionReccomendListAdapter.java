package com.baidu.tieba.videoplay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.m;
import c.a.o0.r.v.c;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoAttentionReccomendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<VideoItemData> f36647b;

    /* renamed from: c  reason: collision with root package name */
    public View f36648c;

    /* renamed from: d  reason: collision with root package name */
    public String f36649d;

    /* loaded from: classes6.dex */
    public static class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f36650b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f36651c;

        /* renamed from: d  reason: collision with root package name */
        public EMTextView f36652d;

        /* renamed from: e  reason: collision with root package name */
        public EMTextView f36653e;

        /* renamed from: f  reason: collision with root package name */
        public EMTextView f36654f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f36655g;

        /* renamed from: h  reason: collision with root package name */
        public View f36656h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForumViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.a = view;
            this.f36650b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090ee0);
            this.f36651c = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f09185e);
            this.f36652d = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f091860);
            this.f36653e = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f091f47);
            this.f36654f = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f091f51);
            this.f36655g = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090ecb);
            this.f36656h = view.findViewById(R.id.obfuscated_res_0x7f090ebe);
            this.f36650b.setRadiusById(R.string.J_X05);
            this.f36650b.setConrers(3);
            c.d(this.f36656h).s(R.array.Mask_X003);
            c d2 = c.d(view);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0613);
        }

        public void a(View.OnClickListener onClickListener) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) || (view = this.a) == null) {
                return;
            }
            view.setOnClickListener(onClickListener);
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoItemData f36657b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionReccomendListAdapter f36658c;

        public a(VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter, int i, VideoItemData videoItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionReccomendListAdapter, Integer.valueOf(i), videoItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36658c = videoAttentionReccomendListAdapter;
            this.a = i;
            this.f36657b = videoItemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this.f36658c.a, this.f36658c.f36647b, 0, null, "video_attention_tab", "", "", "");
                videoRecommentPlayActivityConfig.setVideoShowIndex(this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
                this.f36658c.f36649d = this.f36657b.thread_id;
                this.f36658c.g(4);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36647b = new ArrayList();
        this.a = context;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_PAGE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.f36649d);
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<VideoItemData> list = this.f36647b;
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
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        List<VideoItemData> list;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, forumViewHolder, i) == null) || forumViewHolder == null || (list = this.f36647b) == null || (videoItemData = list.get(i)) == null) {
            return;
        }
        m(videoItemData, forumViewHolder);
        k(videoItemData, forumViewHolder);
        j(videoItemData, forumViewHolder);
        l(videoItemData, forumViewHolder);
        forumViewHolder.a(new a(this, i, videoItemData));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            this.f36648c = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d086f, viewGroup, false);
            return new ForumViewHolder(this.f36648c);
        }
        return (ForumViewHolder) invokeLI.objValue;
    }

    public final void j(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f36653e.setText(StringHelper.numberUniformFormatExtra(videoItemData.play_count));
        c d2 = c.d(forumViewHolder.f36653e);
        d2.z(R.dimen.T_X09);
        d2.v(R.color.CAM_X0101);
    }

    public final void k(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = videoItemData.video_duration;
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = (i % 3600) % 60;
        if (i2 > 0) {
            if (i2 < 10) {
                sb.append("0");
            }
            sb.append(i2);
            sb.append(":");
        }
        if (i3 > 0) {
            if (i3 < 10) {
                sb.append("0");
            }
            sb.append(i3);
            sb.append(":");
        } else {
            sb.append("00");
            sb.append(":");
        }
        if (i4 > 0) {
            if (i4 < 10) {
                sb.append("0");
            }
            sb.append(i4);
        } else {
            sb.append("00");
        }
        c d2 = c.d(forumViewHolder.f36652d);
        d2.z(R.dimen.T_X09);
        d2.v(R.color.CAM_X0101);
        forumViewHolder.f36652d.setText(sb.toString());
    }

    public final void l(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        if (!m.isEmpty(videoItemData.title)) {
            forumViewHolder.f36654f.setText(videoItemData.title);
        } else if (!m.isEmpty(videoItemData.abstext)) {
            forumViewHolder.f36654f.setText(videoItemData.abstext);
        } else {
            forumViewHolder.f36654f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ce9));
        }
    }

    public final void m(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, videoItemData, forumViewHolder) == null) || videoItemData == null || forumViewHolder == null) {
            return;
        }
        forumViewHolder.f36650b.J(videoItemData.thumbnail_url, 10, false);
    }

    public void setData(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.f36647b.clear();
            this.f36647b.addAll(list);
            notifyDataSetChanged();
        }
    }
}
