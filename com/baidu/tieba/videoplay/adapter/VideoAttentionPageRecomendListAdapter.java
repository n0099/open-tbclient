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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.r.f0.s.c;
import d.a.r0.z0.n0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoAttentionPageRecomendListAdapter extends RecyclerView.Adapter<RecomendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f21811a;

    /* renamed from: b  reason: collision with root package name */
    public List<VideoAttentionPersonListData> f21812b;

    /* renamed from: c  reason: collision with root package name */
    public View f21813c;

    /* renamed from: d  reason: collision with root package name */
    public View f21814d;

    /* loaded from: classes5.dex */
    public static class RecomendViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public UserIconBox f21815a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f21816b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f21817c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f21818d;

        /* renamed from: e  reason: collision with root package name */
        public UserLikeInAttentionButton f21819e;

        /* renamed from: f  reason: collision with root package name */
        public HeadPendantClickableView f21820f;

        /* renamed from: g  reason: collision with root package name */
        public RecyclerView f21821g;

        /* renamed from: h  reason: collision with root package name */
        public VideoAttentionReccomendListAdapter f21822h;

        /* renamed from: i  reason: collision with root package name */
        public c f21823i;

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
            this.f21820f = headPendantClickableView;
            headPendantClickableView.setHasPendantStyle();
            this.f21820f.getHeadView().setIsRound(true);
            this.f21820f.getHeadView().setDrawBorder(true);
            this.f21820f.getHeadView().setBorderWidth(l.g(context, R.dimen.L_X01));
            this.f21820f.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f21820f.getHeadView().setPlaceHolder(1);
            this.f21820f.setBigVDimenSize(R.dimen.tbds27);
            this.f21815a = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
            this.f21816b = (TextView) view.findViewById(R.id.user_name_video_info_item);
            this.f21817c = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
            this.f21818d = (TextView) view.findViewById(R.id.fans_count_video_info_item);
            this.f21819e = (UserLikeInAttentionButton) view.findViewById(R.id.concern_video_info_item);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.thread_card_list);
            this.f21821g = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
            VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter = new VideoAttentionReccomendListAdapter(context);
            this.f21822h = videoAttentionReccomendListAdapter;
            this.f21821g.setAdapter(videoAttentionReccomendListAdapter);
            c cVar = new c(this.f21820f.getTbPageContext(), this.f21819e);
            this.f21823i = cVar;
            cVar.k(true);
        }

        public void a(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                this.f21820f.setOnClickListener(onClickListener);
                this.f21815a.setOnClickListener(onClickListener);
                this.f21816b.setOnClickListener(onClickListener);
                this.f21817c.setOnClickListener(onClickListener);
                this.f21818d.setOnClickListener(onClickListener);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPersonListData f21824e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionPageRecomendListAdapter f21825f;

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
            this.f21825f = videoAttentionPageRecomendListAdapter;
            this.f21824e = videoAttentionPersonListData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() != R.id.head_view_video_info_item && view.getId() != R.id.vip_icon_video_info_item) {
                    if (view.getId() == R.id.user_name_video_info_item || view.getId() == R.id.bjh_author_auth_video_info_item || view.getId() == R.id.fans_count_video_info_item) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f21825f.f21811a, this.f21824e.getUserData().getUserId(), this.f21824e.getUserData().getName_show())));
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f21825f.f21811a, this.f21824e.getUserData().getUserId(), this.f21824e.getUserData().getName_show())));
            }
        }
    }

    public VideoAttentionPageRecomendListAdapter(Context context) {
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
        this.f21811a = context;
        this.f21812b = new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(RecomendViewHolder recomendViewHolder, int i2) {
        List<VideoAttentionPersonListData> list;
        VideoAttentionPersonListData videoAttentionPersonListData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, recomendViewHolder, i2) == null) || recomendViewHolder == null || (list = this.f21812b) == null || (videoAttentionPersonListData = list.get(i2)) == null || videoAttentionPersonListData.getUserData().getName_show() == null || videoAttentionPersonListData.getUserData().getUserId() == null) {
            return;
        }
        i(videoAttentionPersonListData, recomendViewHolder);
        l(videoAttentionPersonListData, recomendViewHolder);
        k(videoAttentionPersonListData, recomendViewHolder);
        h(videoAttentionPersonListData, recomendViewHolder);
        j(videoAttentionPersonListData.getVideoItemDatas(), recomendViewHolder);
        g(videoAttentionPersonListData, recomendViewHolder);
        d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.f21814d);
        d2.n(R.string.J_X05);
        d2.g(SkinManager.getColor(0, R.color.CAM_X0105));
        recomendViewHolder.a(new a(this, videoAttentionPersonListData));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public RecomendViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
            View inflate = LayoutInflater.from(this.f21811a).inflate(R.layout.video_attention_recomend_list_view, viewGroup, false);
            this.f21813c = inflate;
            this.f21814d = inflate.findViewById(R.id.viedo_attention_list_view);
            return new RecomendViewHolder(this.f21811a, this.f21813c);
        }
        return (RecomendViewHolder) invokeLI.objValue;
    }

    public final void g(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null || (cVar = recomendViewHolder.f21823i) == null) {
            return;
        }
        cVar.n(videoAttentionPersonListData.getUserData());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<VideoAttentionPersonListData> list = this.f21812b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public final void h(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(videoAttentionPersonListData.getUserData().getFansNum());
        TextView textView = recomendViewHolder.f21818d;
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.fans_default_name) + numberUniformFormatExtra);
        if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recomendViewHolder.f21818d.getLayoutParams();
            layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            recomendViewHolder.f21817c.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getNewGodData().getFieldName() + n0.d(videoAttentionPersonListData.getUserData().getNewGodData().isVideoGod()), 16, StringHelper.STRING_MORE));
            recomendViewHolder.f21817c.setVisibility(0);
        } else if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().showBazhuGrade()) {
            recomendViewHolder.f21817c.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE));
            recomendViewHolder.f21817c.setVisibility(0);
        } else if (videoAttentionPersonListData.getUserData() != null && videoAttentionPersonListData.getUserData().getBaijiahaoInfo() != null && !k.isEmpty(videoAttentionPersonListData.getUserData().getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) recomendViewHolder.f21818d.getLayoutParams();
            layoutParams2.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            recomendViewHolder.f21817c.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getBaijiahaoInfo().auth_desc, 16, StringHelper.STRING_MORE));
            recomendViewHolder.f21817c.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) recomendViewHolder.f21818d.getLayoutParams();
            layoutParams3.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            recomendViewHolder.f21817c.setVisibility(8);
        }
    }

    public final void i(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        recomendViewHolder.f21820f.getHeadView().setUserId(videoAttentionPersonListData.getUserData().getUserId());
        recomendViewHolder.f21820f.getHeadView().setUserName(videoAttentionPersonListData.getUserData().getUserName());
        recomendViewHolder.f21820f.i(videoAttentionPersonListData.getUserData(), 4);
        recomendViewHolder.f21820f.m(videoAttentionPersonListData.getUserData());
    }

    public final void j(ArrayList<VideoItemData> arrayList, RecomendViewHolder recomendViewHolder) {
        VideoAttentionReccomendListAdapter videoAttentionReccomendListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, arrayList, recomendViewHolder) == null) || arrayList == null || recomendViewHolder == null || (videoAttentionReccomendListAdapter = recomendViewHolder.f21822h) == null) {
            return;
        }
        videoAttentionReccomendListAdapter.setData(arrayList);
    }

    public final void k(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        recomendViewHolder.f21816b.setText(StringHelper.cutChineseAndEnglishWithEmoji(videoAttentionPersonListData.getUserData().getName_show(), 16, StringHelper.STRING_MORE));
        recomendViewHolder.f21816b.setTag(R.id.tag_user_id, videoAttentionPersonListData.getUserData().getUserId());
        recomendViewHolder.f21816b.setTag(R.id.tag_user_name, videoAttentionPersonListData.getUserData().getName_show());
    }

    public final void l(VideoAttentionPersonListData videoAttentionPersonListData, RecomendViewHolder recomendViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoAttentionPersonListData, recomendViewHolder) == null) || videoAttentionPersonListData == null || recomendViewHolder == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = videoAttentionPersonListData.getUserData().getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            recomendViewHolder.f21815a.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) recomendViewHolder.f21816b.getLayoutParams();
            layoutParams.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) recomendViewHolder.f21816b.getLayoutParams();
            layoutParams2.setMargins(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        recomendViewHolder.f21815a.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    public void setData(List<VideoAttentionPersonListData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.f21812b.clear();
            this.f21812b.addAll(list);
            notifyDataSetChanged();
        }
    }
}
