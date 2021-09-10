package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.q.q;
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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class PbBjhRecommendViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ST_TYPE = "pb";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AbsPbActivity f54950a;

    /* renamed from: b  reason: collision with root package name */
    public q f54951b;

    /* renamed from: c  reason: collision with root package name */
    public String f54952c;
    public TextView contentView;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54953d;

    /* renamed from: e  reason: collision with root package name */
    public String f54954e;

    /* renamed from: f  reason: collision with root package name */
    public int f54955f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54956g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f54957h;
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbBjhRecommendViewHolder f54958e;

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
            this.f54958e = pbBjhRecommendViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (this.f54958e.f54951b == null) {
                    return;
                }
                int i2 = 3;
                if (id == R.id.tail_more_video) {
                    VideoInfo q1 = this.f54958e.f54951b.q1();
                    if (q1 != null) {
                        if (q1.is_vertical.intValue() == 1) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(this.f54958e.f54951b);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(videoItemData);
                            if (this.f54958e.f54955f == 2) {
                                str2 = "index";
                            } else if (this.f54958e.f54955f == 1) {
                                str2 = "concern_tab";
                            } else {
                                str2 = this.f54958e.f54955f == 3 ? "frs" : "";
                            }
                            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f54958e.f54950a, arrayList, 0, null, "from_nani_video", "", "", str2);
                            videoPlayActivityConfig.setIsFromBjhPb(true);
                            q qVar = this.f54958e.f54951b;
                            qVar.getThreadData();
                            if (qVar != null && this.f54958e.f54951b.L() != null) {
                                videoPlayActivityConfig.setNid(this.f54958e.f54951b.L().oriUgcNid);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                        } else if (q1.is_vertical.intValue() == 0) {
                            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.f54958e.f54951b);
                            if (this.f54958e.f54955f == 2) {
                                str = "index";
                            } else if (this.f54958e.f54955f == 1) {
                                str = "concern_tab";
                            } else {
                                str = this.f54958e.f54955f == 3 ? "frs" : "";
                            }
                            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.f54958e.f54950a, str, this.f54958e.f54951b.s1(), "", "", videoSerializeVideoThreadInfo);
                            videoMiddlePageActivityConfig.setNid(this.f54958e.f54954e);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
                        }
                    }
                } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                    String s1 = this.f54958e.f54951b.s1();
                    if (this.f54958e.f54955f == 2) {
                        i2 = 1;
                    } else if (this.f54958e.f54955f == 1) {
                        i2 = 2;
                    } else if (this.f54958e.f54955f != 3) {
                        i2 = 4;
                    }
                    if (i2 != 0) {
                        if (this.f54958e.f54951b.c0 == 40) {
                            StatisticItem.make("c13535").param("tid", s1).param("fid", this.f54958e.f54951b.T()).param("obj_source", i2).param("obj_locate", this.f54958e.f54951b.O4()).param("obj_id", this.f54958e.f54952c).param("obj_type", this.f54958e.f54951b.R1() ? 1 : 0).eventStat();
                        } else {
                            StatisticItem.make("c13534").param("tid", s1).param("fid", this.f54958e.f54951b.T()).param("obj_source", i2).param("obj_locate", this.f54958e.f54951b.O4()).param("obj_id", this.f54958e.f54952c).eventStat();
                        }
                    }
                    if (this.f54958e.f54953d) {
                        StatisticItem statisticItem = new StatisticItem("c13589");
                        statisticItem.param("tid", this.f54958e.f54951b.s1());
                        if (this.f54958e.f54951b.Y() != null) {
                            statisticItem.param("fid", this.f54958e.f54951b.Y().getForumId());
                        }
                        statisticItem.param("obj_param1", this.f54958e.f54951b.X0);
                        statisticItem.param("obj_source", this.f54958e.f54951b.W0);
                        statisticItem.param("obj_id", this.f54958e.f54952c);
                        statisticItem.param("obj_locate", this.f54958e.f54951b.O4());
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        q qVar2 = this.f54958e.f54951b;
                        qVar2.getThreadData();
                        if (qVar2.L() != null) {
                            q qVar3 = this.f54958e.f54951b;
                            qVar3.getThreadData();
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, qVar3.L().oriUgcNid);
                            q qVar4 = this.f54958e.f54951b;
                            qVar4.getThreadData();
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, qVar4.L().oriUgcVid);
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, this.f54958e.f54951b.B1());
                        statisticItem.param("ab_tag", this.f54958e.f54951b.Y0);
                        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, this.f54958e.f54951b.q1().is_vertical.intValue());
                        statisticItem.param("extra", this.f54958e.f54951b.Z0);
                        TiebaStatic.log(statisticItem);
                    }
                    if (this.f54958e.f54956g) {
                        ((VideoPbViewModel) ViewModelProviders.of(this.f54958e.f54950a).get(VideoPbViewModel.class)).loadTargetVideo(this.f54958e.f54951b);
                        return;
                    }
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f54958e.f54950a);
                    pbActivityConfig.createNormalCfg(s1, null, "pb");
                    pbActivityConfig.setBjhFrom(this.f54958e.f54955f);
                    pbActivityConfig.setLastTid(this.f54958e.f54952c);
                    pbActivityConfig.setStartFrom(20);
                    pbActivityConfig.setThreadData(this.f54958e.f54951b);
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
        this.f54957h = new a(this);
        this.f54950a = absPbActivity;
        this.mMainView = view.findViewById(R.id.main_view);
        this.mHeadView = view.findViewById(R.id.first_head_divider_line);
        this.mMainContent = view.findViewById(R.id.bjh_main_content);
        this.mClickContainer = view.findViewById(R.id.bjh_click_container);
        this.mImageView = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.mVideoMaskIv = view.findViewById(R.id.bjh_gradient_cover);
        this.contentView = (TextView) view.findViewById(R.id.bjh_content);
        this.videoLogoContainer = view.findViewById(R.id.bjh_video_during_container);
        this.videoPlayIcon = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.videoDuringTv = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.mTailContainer = view.findViewById(R.id.last_video_tail);
        this.mMoreVideoTv = (TextView) view.findViewById(R.id.tail_more_video);
        this.mTailDividerLine = view.findViewById(R.id.last_tail_divider_line);
        this.mTailPadding = view.findViewById(R.id.last_tail_padding);
        this.mUserInfoTv = (TextView) view.findViewById(R.id.bjh_user_info);
        this.mVideoInfoTv = (TextView) view.findViewById(R.id.bjh_video_info);
        this.mCrossLine = view.findViewById(R.id.bjh_item_cross_line);
    }

    public void bindData(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) {
            this.f54951b = qVar;
            this.mHeadView.setVisibility(qVar.P4() ? 0 : 8);
            this.mTailPadding.setVisibility(qVar.R4() ? 0 : 8);
            this.mMainContent.setVisibility(qVar.Q4() ? 8 : 0);
            this.mTailContainer.setVisibility(qVar.Q4() ? 0 : 8);
            this.mMoreVideoTv.setOnClickListener(this.f54957h);
            this.mVideoMaskIv.setOnClickListener(this.f54957h);
            this.mImageView.setOnClickListener(this.f54957h);
            this.mImageView.setConrers(15);
            this.mImageView.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            this.mImageView.setDrawCorner(true);
            this.mImageView.setPlaceHolder(2);
            if (qVar.q1() != null) {
                this.contentView.setText(qVar.getTitle());
                this.mImageView.startLoad(qVar.q1().thumbnail_url, 10, false);
                this.mVideoMaskIv.setVisibility(0);
                this.mVideoMaskIv.setAlpha(0.5f);
                this.videoLogoContainer.setVisibility(0);
                this.videoDuringTv.setText(StringUtils.translateSecondsToString(qVar.q1().video_duration.intValue()));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mVideoInfoTv.getLayoutParams();
                if (qVar.J() != null && !k.isEmpty(qVar.J().getName_show())) {
                    this.mUserInfoTv.setText(qVar.J().getName_show());
                    this.mUserInfoTv.setVisibility(0);
                    layoutParams.leftMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
                } else {
                    this.mUserInfoTv.setVisibility(8);
                    layoutParams.leftMargin = 0;
                }
                this.mVideoInfoTv.setLayoutParams(layoutParams);
                this.mVideoInfoTv.setText(String.format(this.f54950a.getResources().getString(R.string.bjh_pb_recommend_video_tip), StringHelper.numFormatOverWan(qVar.q1().play_count.intValue())));
            } else {
                this.videoLogoContainer.setVisibility(8);
                this.mVideoMaskIv.setVisibility(8);
                this.mImageView.startLoad(qVar.H(), 10, false);
                this.contentView.setText(qVar.getTitle());
            }
            this.mMainView.setOnClickListener(this.f54957h);
        }
    }

    public void setBjhFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f54955f = i2;
        }
    }

    public void setNid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f54954e = str;
        }
    }

    public void setOriginIsVideoThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f54953d = z;
        }
    }

    public void setOriginTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f54952c = str;
        }
    }

    public void setRefreshCurrentPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f54956g = z;
        }
    }
}
