package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.q.q;
import c.a.t0.s2.g;
import c.a.t0.s2.i;
import c.a.t0.s2.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes12.dex */
public class PbBjhRecommendViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ST_TYPE = "pb";
    public transient /* synthetic */ FieldHolder $fh;
    public AbsPbActivity a;

    /* renamed from: b  reason: collision with root package name */
    public q f46440b;

    /* renamed from: c  reason: collision with root package name */
    public String f46441c;
    public TextView contentView;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46442d;

    /* renamed from: e  reason: collision with root package name */
    public String f46443e;

    /* renamed from: f  reason: collision with root package name */
    public int f46444f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46445g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f46446h;
    public View mClickContainer;
    public View mCrossLine;
    public View mHeadView;
    public TbImageView mImageView;
    public View mMainContent;
    public View mMainView;
    public TextView mMoreVideoTv;
    public int mSkinType;
    public View mTailContainer;
    public View mTailDividerLine;
    public View mTailPadding;
    public TextView mUserInfoTv;
    public TextView mVideoInfoTv;
    public View mVideoMaskIv;
    public TextView videoDuringTv;
    public View videoLogoContainer;
    public ImageView videoPlayIcon;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbBjhRecommendViewHolder f46447e;

        public a(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbBjhRecommendViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46447e = pbBjhRecommendViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (this.f46447e.f46440b == null) {
                    return;
                }
                int i2 = 3;
                if (id == i.tail_more_video) {
                    VideoInfo t1 = this.f46447e.f46440b.t1();
                    if (t1 != null) {
                        if (t1.is_vertical.intValue() == 1) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(this.f46447e.f46440b);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(videoItemData);
                            if (this.f46447e.f46444f == 2) {
                                str2 = "index";
                            } else if (this.f46447e.f46444f == 1) {
                                str2 = "concern_tab";
                            } else {
                                str2 = this.f46447e.f46444f == 3 ? "frs" : "";
                            }
                            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f46447e.a, arrayList, 0, null, "from_nani_video", "", "", str2);
                            videoPlayActivityConfig.setIsFromBjhPb(true);
                            if (this.f46447e.f46440b.getThreadData() != null && this.f46447e.f46440b.L() != null) {
                                videoPlayActivityConfig.setNid(this.f46447e.f46440b.L().oriUgcNid);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                        } else if (t1.is_vertical.intValue() == 0) {
                            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.f46447e.f46440b);
                            if (this.f46447e.f46444f == 2) {
                                str = "index";
                            } else if (this.f46447e.f46444f == 1) {
                                str = "concern_tab";
                            } else {
                                str = this.f46447e.f46444f == 3 ? "frs" : "";
                            }
                            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.f46447e.a, str, this.f46447e.f46440b.v1(), "", "", videoSerializeVideoThreadInfo);
                            videoMiddlePageActivityConfig.setNid(this.f46447e.f46443e);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
                        }
                    }
                } else if (id == i.main_view || id == i.bjh_imageView || id == i.bjh_gradient_cover) {
                    String v1 = this.f46447e.f46440b.v1();
                    if (this.f46447e.f46444f == 2) {
                        i2 = 1;
                    } else if (this.f46447e.f46444f == 1) {
                        i2 = 2;
                    } else if (this.f46447e.f46444f != 3) {
                        i2 = 4;
                    }
                    if (i2 != 0) {
                        if (this.f46447e.f46440b.d0 == 40) {
                            StatisticItem.make("c13535").param("tid", v1).param("fid", this.f46447e.f46440b.U()).param("obj_source", i2).param("obj_locate", this.f46447e.f46440b.T4()).param("obj_id", this.f46447e.f46441c).param("obj_type", this.f46447e.f46440b.U1() ? 1 : 0).eventStat();
                        } else {
                            StatisticItem.make("c13534").param("tid", v1).param("fid", this.f46447e.f46440b.U()).param("obj_source", i2).param("obj_locate", this.f46447e.f46440b.T4()).param("obj_id", this.f46447e.f46441c).eventStat();
                        }
                    }
                    if (this.f46447e.f46442d) {
                        StatisticItem statisticItem = new StatisticItem("c13589");
                        statisticItem.param("tid", this.f46447e.f46440b.v1());
                        if (this.f46447e.f46440b.Z() != null) {
                            statisticItem.param("fid", this.f46447e.f46440b.Z().getForumId());
                        }
                        statisticItem.param("obj_param1", this.f46447e.f46440b.a1);
                        statisticItem.param("obj_source", this.f46447e.f46440b.Z0);
                        statisticItem.param("obj_id", this.f46447e.f46441c);
                        statisticItem.param("obj_locate", this.f46447e.f46440b.T4());
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        if (this.f46447e.f46440b.getThreadData().L() != null) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.f46447e.f46440b.getThreadData().L().oriUgcNid);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.f46447e.f46440b.getThreadData().L().oriUgcVid);
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, this.f46447e.f46440b.D1());
                        statisticItem.param("ab_tag", this.f46447e.f46440b.b1);
                        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, this.f46447e.f46440b.t1().is_vertical.intValue());
                        statisticItem.param("extra", this.f46447e.f46440b.c1);
                        TiebaStatic.log(statisticItem);
                    }
                    if (this.f46447e.f46445g) {
                        ((VideoPbViewModel) ViewModelProviders.of(this.f46447e.a).get(VideoPbViewModel.class)).loadTargetVideo(this.f46447e.f46440b);
                        return;
                    }
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f46447e.a);
                    pbActivityConfig.createNormalCfg(v1, null, "pb");
                    pbActivityConfig.setBjhFrom(this.f46447e.f46444f);
                    pbActivityConfig.setLastTid(this.f46447e.f46441c);
                    pbActivityConfig.setStartFrom(20);
                    pbActivityConfig.setThreadData(this.f46447e.f46440b);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbBjhRecommendViewHolder(View view, AbsPbActivity absPbActivity) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, absPbActivity};
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
        this.mSkinType = 3;
        this.f46446h = new a(this);
        this.a = absPbActivity;
        this.mMainView = view.findViewById(i.main_view);
        this.mHeadView = view.findViewById(i.first_head_divider_line);
        this.mMainContent = view.findViewById(i.bjh_main_content);
        this.mClickContainer = view.findViewById(i.bjh_click_container);
        this.mImageView = (TbImageView) view.findViewById(i.bjh_imageView);
        this.mVideoMaskIv = view.findViewById(i.bjh_gradient_cover);
        this.contentView = (TextView) view.findViewById(i.bjh_content);
        this.videoLogoContainer = view.findViewById(i.bjh_video_during_container);
        this.videoPlayIcon = (ImageView) view.findViewById(i.bjh_vidoe_play_iv);
        this.videoDuringTv = (TextView) view.findViewById(i.bjh_video_during_tv);
        this.mTailContainer = view.findViewById(i.last_video_tail);
        this.mMoreVideoTv = (TextView) view.findViewById(i.tail_more_video);
        this.mTailDividerLine = view.findViewById(i.last_tail_divider_line);
        this.mTailPadding = view.findViewById(i.last_tail_padding);
        this.mUserInfoTv = (TextView) view.findViewById(i.bjh_user_info);
        this.mVideoInfoTv = (TextView) view.findViewById(i.bjh_video_info);
        this.mCrossLine = view.findViewById(i.bjh_item_cross_line);
    }

    public void bindData(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) {
            this.f46440b = qVar;
            this.mHeadView.setVisibility(qVar.U4() ? 0 : 8);
            this.mTailPadding.setVisibility(qVar.W4() ? 0 : 8);
            this.mMainContent.setVisibility(qVar.V4() ? 8 : 0);
            this.mTailContainer.setVisibility(qVar.V4() ? 0 : 8);
            this.mMoreVideoTv.setOnClickListener(this.f46446h);
            this.mVideoMaskIv.setOnClickListener(this.f46446h);
            this.mImageView.setOnClickListener(this.f46446h);
            this.mImageView.setConrers(15);
            this.mImageView.setRadius(n.f(TbadkCoreApplication.getInst(), g.tbds21));
            this.mImageView.setDrawCorner(true);
            this.mImageView.setPlaceHolder(2);
            if (qVar.t1() != null) {
                this.contentView.setText(qVar.getTitle());
                this.mImageView.startLoad(qVar.t1().thumbnail_url, 10, false);
                this.mVideoMaskIv.setVisibility(0);
                this.mVideoMaskIv.setAlpha(0.5f);
                this.videoLogoContainer.setVisibility(0);
                this.videoDuringTv.setText(StringUtils.translateSecondsToString(qVar.t1().video_duration.intValue()));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mVideoInfoTv.getLayoutParams();
                if (qVar.J() != null && !m.isEmpty(qVar.J().getName_show())) {
                    this.mUserInfoTv.setText(qVar.J().getName_show());
                    this.mUserInfoTv.setVisibility(0);
                    layoutParams.leftMargin = n.f(TbadkCoreApplication.getInst(), g.M_W_X004);
                } else {
                    this.mUserInfoTv.setVisibility(8);
                    layoutParams.leftMargin = 0;
                }
                this.mVideoInfoTv.setLayoutParams(layoutParams);
                this.mVideoInfoTv.setText(String.format(this.a.getResources().getString(l.bjh_pb_recommend_video_tip), StringHelper.numFormatOverWan(qVar.t1().play_count.intValue())));
            } else {
                this.videoLogoContainer.setVisibility(8);
                this.mVideoMaskIv.setVisibility(8);
                this.mImageView.startLoad(qVar.H(), 10, false);
                this.contentView.setText(qVar.getTitle());
            }
            this.mMainView.setOnClickListener(this.f46446h);
        }
    }

    public void setBjhFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f46444f = i2;
        }
    }

    public void setNid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f46443e = str;
        }
    }

    public void setOriginIsVideoThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f46442d = z;
        }
    }

    public void setOriginTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f46441c = str;
        }
    }

    public void setRefreshCurrentPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f46445g = z;
        }
    }
}
