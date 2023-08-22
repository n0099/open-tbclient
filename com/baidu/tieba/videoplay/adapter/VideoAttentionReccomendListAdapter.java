package com.baidu.tieba.videoplay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.di;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoAttentionReccomendListAdapter extends RecyclerView.Adapter<ForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<VideoItemData> b;
    public View c;
    public String d;

    /* loaded from: classes8.dex */
    public static class ForumViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TbImageView b;
        public TbImageView c;
        public EMTextView d;
        public EMTextView e;
        public EMTextView f;
        public TbImageView g;
        public View h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForumViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.a = view2;
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09111f);
            this.c = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cc5);
            this.d = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091cc7);
            this.e = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0924b7);
            this.f = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0924c2);
            this.g = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091107);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f0910f6);
            this.b.setRadiusById(R.string.J_X05);
            this.b.setConrers(3);
            EMManager.from(this.h).setMaskBackGround(R.array.Mask_X003);
            EMManager.from(view2).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0613);
        }

        public void b(View.OnClickListener onClickListener) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && (view2 = this.a) != null) {
                view2.setOnClickListener(onClickListener);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ VideoItemData b;
        public final /* synthetic */ VideoAttentionReccomendListAdapter c;

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
            this.c = videoAttentionReccomendListAdapter;
            this.a = i;
            this.b = videoItemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(this.c.a, this.c.b, 0, null, "video_attention_tab", "", "", "");
                videoRecommentPlayActivityConfig.setVideoShowIndex(this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
                this.c.d = this.b.thread_id;
                this.c.o(4);
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
        this.b = new ArrayList();
        this.a = context;
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_PAGE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.d);
            statisticItem.param("obj_locate", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public void setData(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public ForumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i)) == null) {
            this.c = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d09d2, viewGroup, false);
            return new ForumViewHolder(this.c);
        }
        return (ForumViewHolder) invokeLI.objValue;
    }

    public final void u(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, videoItemData, forumViewHolder) == null) && videoItemData != null && forumViewHolder != null) {
            forumViewHolder.b.startLoad(videoItemData.thumbnail_url, 10, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<VideoItemData> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(ForumViewHolder forumViewHolder, int i) {
        List<VideoItemData> list;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048580, this, forumViewHolder, i) != null) || forumViewHolder == null || (list = this.b) == null || (videoItemData = list.get(i)) == null) {
            return;
        }
        u(videoItemData, forumViewHolder);
        s(videoItemData, forumViewHolder);
        r(videoItemData, forumViewHolder);
        t(videoItemData, forumViewHolder);
        forumViewHolder.b(new a(this, i, videoItemData));
    }

    public final void r(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, videoItemData, forumViewHolder) == null) && videoItemData != null && forumViewHolder != null) {
            forumViewHolder.e.setText(StringHelper.numberUniformFormatExtra(videoItemData.play_count));
            EMManager.from(forumViewHolder.e).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0101);
        }
    }

    public final void t(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, videoItemData, forumViewHolder) == null) && videoItemData != null && forumViewHolder != null) {
            if (!di.isEmpty(videoItemData.title)) {
                forumViewHolder.f.setText(videoItemData.title);
            } else if (!di.isEmpty(videoItemData.abstext)) {
                forumViewHolder.f.setText(videoItemData.abstext);
            } else {
                forumViewHolder.f.setText(TbadkCoreApplication.getInst().getString(R.string.original_recommend_video_attention_txt));
            }
        }
    }

    public final void s(VideoItemData videoItemData, ForumViewHolder forumViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, videoItemData, forumViewHolder) == null) && videoItemData != null && forumViewHolder != null) {
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
            EMManager.from(forumViewHolder.d).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0101);
            forumViewHolder.d.setText(sb.toString());
        }
    }
}
