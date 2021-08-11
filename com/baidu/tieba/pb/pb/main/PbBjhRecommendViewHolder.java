package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.o0.s.q.q;
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
    public AbsPbActivity f54637a;

    /* renamed from: b  reason: collision with root package name */
    public q f54638b;

    /* renamed from: c  reason: collision with root package name */
    public String f54639c;
    public TextView contentView;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54640d;

    /* renamed from: e  reason: collision with root package name */
    public String f54641e;

    /* renamed from: f  reason: collision with root package name */
    public int f54642f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54643g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f54644h;
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
        public final /* synthetic */ PbBjhRecommendViewHolder f54645e;

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
            this.f54645e = pbBjhRecommendViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (this.f54645e.f54638b == null) {
                    return;
                }
                int i2 = 3;
                if (id == R.id.tail_more_video) {
                    VideoInfo o1 = this.f54645e.f54638b.o1();
                    if (o1 != null) {
                        if (o1.is_vertical.intValue() == 1) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(this.f54645e.f54638b);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(videoItemData);
                            if (this.f54645e.f54642f == 2) {
                                str2 = "index";
                            } else if (this.f54645e.f54642f == 1) {
                                str2 = "concern_tab";
                            } else {
                                str2 = this.f54645e.f54642f == 3 ? "frs" : "";
                            }
                            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f54645e.f54637a, arrayList, 0, null, "from_nani_video", "", "", str2);
                            videoPlayActivityConfig.setIsFromBjhPb(true);
                            q qVar = this.f54645e.f54638b;
                            qVar.getThreadData();
                            if (qVar != null && this.f54645e.f54638b.L() != null) {
                                videoPlayActivityConfig.setNid(this.f54645e.f54638b.L().oriUgcNid);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                        } else if (o1.is_vertical.intValue() == 0) {
                            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.f54645e.f54638b);
                            if (this.f54645e.f54642f == 2) {
                                str = "index";
                            } else if (this.f54645e.f54642f == 1) {
                                str = "concern_tab";
                            } else {
                                str = this.f54645e.f54642f == 3 ? "frs" : "";
                            }
                            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.f54645e.f54637a, str, this.f54645e.f54638b.q1(), "", "", videoSerializeVideoThreadInfo);
                            videoMiddlePageActivityConfig.setNid(this.f54645e.f54641e);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
                        }
                    }
                } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                    String q1 = this.f54645e.f54638b.q1();
                    if (this.f54645e.f54642f == 2) {
                        i2 = 1;
                    } else if (this.f54645e.f54642f == 1) {
                        i2 = 2;
                    } else if (this.f54645e.f54642f != 3) {
                        i2 = 4;
                    }
                    if (i2 != 0) {
                        if (this.f54645e.f54638b.a0 == 40) {
                            StatisticItem.make("c13535").param("tid", q1).param("fid", this.f54645e.f54638b.T()).param("obj_source", i2).param("obj_locate", this.f54645e.f54638b.D4()).param("obj_id", this.f54645e.f54639c).param("obj_type", this.f54645e.f54638b.O1() ? 1 : 0).eventStat();
                        } else {
                            StatisticItem.make("c13534").param("tid", q1).param("fid", this.f54645e.f54638b.T()).param("obj_source", i2).param("obj_locate", this.f54645e.f54638b.D4()).param("obj_id", this.f54645e.f54639c).eventStat();
                        }
                    }
                    if (this.f54645e.f54640d) {
                        StatisticItem statisticItem = new StatisticItem("c13589");
                        statisticItem.param("tid", this.f54645e.f54638b.q1());
                        if (this.f54645e.f54638b.Y() != null) {
                            statisticItem.param("fid", this.f54645e.f54638b.Y().getForumId());
                        }
                        statisticItem.param("obj_param1", this.f54645e.f54638b.V0);
                        statisticItem.param("obj_source", this.f54645e.f54638b.U0);
                        statisticItem.param("obj_id", this.f54645e.f54639c);
                        statisticItem.param("obj_locate", this.f54645e.f54638b.D4());
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        q qVar2 = this.f54645e.f54638b;
                        qVar2.getThreadData();
                        if (qVar2.L() != null) {
                            q qVar3 = this.f54645e.f54638b;
                            qVar3.getThreadData();
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, qVar3.L().oriUgcNid);
                            q qVar4 = this.f54645e.f54638b;
                            qVar4.getThreadData();
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, qVar4.L().oriUgcVid);
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, this.f54645e.f54638b.z1());
                        statisticItem.param("ab_tag", this.f54645e.f54638b.W0);
                        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, this.f54645e.f54638b.o1().is_vertical.intValue());
                        statisticItem.param("extra", this.f54645e.f54638b.X0);
                        TiebaStatic.log(statisticItem);
                    }
                    if (this.f54645e.f54643g) {
                        ((VideoPbViewModel) ViewModelProviders.of(this.f54645e.f54637a).get(VideoPbViewModel.class)).loadTargetVideo(this.f54645e.f54638b);
                        return;
                    }
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f54645e.f54637a);
                    pbActivityConfig.createNormalCfg(q1, null, "pb");
                    pbActivityConfig.setBjhFrom(this.f54645e.f54642f);
                    pbActivityConfig.setLastTid(this.f54645e.f54639c);
                    pbActivityConfig.setStartFrom(20);
                    pbActivityConfig.setThreadData(this.f54645e.f54638b);
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
        this.f54644h = new a(this);
        this.f54637a = absPbActivity;
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
            this.f54638b = qVar;
            this.mHeadView.setVisibility(qVar.E4() ? 0 : 8);
            this.mTailPadding.setVisibility(qVar.G4() ? 0 : 8);
            this.mMainContent.setVisibility(qVar.F4() ? 8 : 0);
            this.mTailContainer.setVisibility(qVar.F4() ? 0 : 8);
            this.mMoreVideoTv.setOnClickListener(this.f54644h);
            this.mVideoMaskIv.setOnClickListener(this.f54644h);
            this.mImageView.setOnClickListener(this.f54644h);
            this.mImageView.setConrers(15);
            this.mImageView.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            this.mImageView.setDrawCorner(true);
            this.mImageView.setPlaceHolder(2);
            if (qVar.o1() != null) {
                this.contentView.setText(qVar.getTitle());
                this.mImageView.startLoad(qVar.o1().thumbnail_url, 10, false);
                this.mVideoMaskIv.setVisibility(0);
                this.mVideoMaskIv.setAlpha(0.5f);
                this.videoLogoContainer.setVisibility(0);
                this.videoDuringTv.setText(StringUtils.translateSecondsToString(qVar.o1().video_duration.intValue()));
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
                this.mVideoInfoTv.setText(String.format(this.f54637a.getResources().getString(R.string.bjh_pb_recommend_video_tip), StringHelper.numFormatOverWan(qVar.o1().play_count.intValue())));
            } else {
                this.videoLogoContainer.setVisibility(8);
                this.mVideoMaskIv.setVisibility(8);
                this.mImageView.startLoad(qVar.H(), 10, false);
                this.contentView.setText(qVar.getTitle());
            }
            this.mMainView.setOnClickListener(this.f54644h);
        }
    }

    public void setBjhFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f54642f = i2;
        }
    }

    public void setNid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f54641e = str;
        }
    }

    public void setOriginIsVideoThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f54640d = z;
        }
    }

    public void setOriginTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f54639c = str;
        }
    }

    public void setRefreshCurrentPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f54643g = z;
        }
    }
}
