package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
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
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.s.q.q;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class PbBjhRecommendViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f19272a;

    /* renamed from: b  reason: collision with root package name */
    public AbsPbActivity f19273b;

    /* renamed from: c  reason: collision with root package name */
    public q f19274c;

    /* renamed from: d  reason: collision with root package name */
    public String f19275d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19276e;

    /* renamed from: f  reason: collision with root package name */
    public String f19277f;

    /* renamed from: g  reason: collision with root package name */
    public int f19278g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19279h;

    /* renamed from: i  reason: collision with root package name */
    public View f19280i;
    public View j;
    public View k;
    public View l;
    public TbImageView m;
    public View n;
    public TextView o;
    public View p;
    public ImageView q;
    public TextView r;
    public View s;
    public View t;
    public View u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View.OnClickListener z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbBjhRecommendViewHolder f19281e;

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
            this.f19281e = pbBjhRecommendViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (this.f19281e.f19274c == null) {
                    return;
                }
                int i2 = 3;
                if (id == R.id.tail_more_video) {
                    VideoInfo m1 = this.f19281e.f19274c.m1();
                    if (m1 != null) {
                        if (m1.is_vertical.intValue() == 1) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(this.f19281e.f19274c);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(videoItemData);
                            if (this.f19281e.f19278g == 2) {
                                str2 = "index";
                            } else if (this.f19281e.f19278g == 1) {
                                str2 = "concern_tab";
                            } else {
                                str2 = this.f19281e.f19278g == 3 ? "frs" : "";
                            }
                            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.f19281e.f19273b, arrayList, 0, null, "from_nani_video", "", "", str2);
                            videoPlayActivityConfig.setIsFromBjhPb(true);
                            q qVar = this.f19281e.f19274c;
                            qVar.getThreadData();
                            if (qVar != null && this.f19281e.f19274c.J() != null) {
                                videoPlayActivityConfig.setNid(this.f19281e.f19274c.J().oriUgcNid);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                        } else if (m1.is_vertical.intValue() == 0) {
                            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.f19281e.f19274c);
                            if (this.f19281e.f19278g == 2) {
                                str = "index";
                            } else if (this.f19281e.f19278g == 1) {
                                str = "concern_tab";
                            } else {
                                str = this.f19281e.f19278g == 3 ? "frs" : "";
                            }
                            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.f19281e.f19273b, str, this.f19281e.f19274c.o1(), "", "", videoSerializeVideoThreadInfo);
                            videoMiddlePageActivityConfig.setNid(this.f19281e.f19277f);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
                        }
                    }
                } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                    String o1 = this.f19281e.f19274c.o1();
                    if (this.f19281e.f19278g == 2) {
                        i2 = 1;
                    } else if (this.f19281e.f19278g == 1) {
                        i2 = 2;
                    } else if (this.f19281e.f19278g != 3) {
                        i2 = 4;
                    }
                    if (i2 != 0) {
                        if (this.f19281e.f19274c.Z == 40) {
                            StatisticItem.make("c13535").param("tid", o1).param("fid", this.f19281e.f19274c.R()).param("obj_source", i2).param("obj_locate", this.f19281e.f19274c.u4()).param("obj_id", this.f19281e.f19275d).param("obj_type", this.f19281e.f19274c.K1() ? 1 : 0).eventStat();
                        } else {
                            StatisticItem.make("c13534").param("tid", o1).param("fid", this.f19281e.f19274c.R()).param("obj_source", i2).param("obj_locate", this.f19281e.f19274c.u4()).param("obj_id", this.f19281e.f19275d).eventStat();
                        }
                    }
                    if (this.f19281e.f19276e) {
                        StatisticItem statisticItem = new StatisticItem("c13589");
                        statisticItem.param("tid", this.f19281e.f19274c.o1());
                        if (this.f19281e.f19274c.W() != null) {
                            statisticItem.param("fid", this.f19281e.f19274c.W().h());
                        }
                        statisticItem.param("obj_param1", this.f19281e.f19274c.U0);
                        statisticItem.param("obj_source", this.f19281e.f19274c.T0);
                        statisticItem.param("obj_id", this.f19281e.f19275d);
                        statisticItem.param("obj_locate", this.f19281e.f19274c.u4());
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        q qVar2 = this.f19281e.f19274c;
                        qVar2.getThreadData();
                        if (qVar2.J() != null) {
                            q qVar3 = this.f19281e.f19274c;
                            qVar3.getThreadData();
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, qVar3.J().oriUgcNid);
                            q qVar4 = this.f19281e.f19274c;
                            qVar4.getThreadData();
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, qVar4.J().oriUgcVid);
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, this.f19281e.f19274c.w1());
                        statisticItem.param("ab_tag", this.f19281e.f19274c.V0);
                        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, this.f19281e.f19274c.m1().is_vertical.intValue());
                        statisticItem.param("extra", this.f19281e.f19274c.W0);
                        TiebaStatic.log(statisticItem);
                    }
                    if (this.f19281e.f19279h) {
                        ((VideoPbViewModel) ViewModelProviders.of(this.f19281e.f19273b).get(VideoPbViewModel.class)).q(this.f19281e.f19274c);
                        return;
                    }
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f19281e.f19273b);
                    pbActivityConfig.createNormalCfg(o1, null, "pb");
                    pbActivityConfig.setBjhFrom(this.f19281e.f19278g);
                    pbActivityConfig.setLastTid(this.f19281e.f19275d);
                    pbActivityConfig.setStartFrom(20);
                    pbActivityConfig.setThreadData(this.f19281e.f19274c);
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
        this.f19272a = 3;
        this.z = new a(this);
        this.f19273b = absPbActivity;
        this.f19280i = view.findViewById(R.id.main_view);
        this.j = view.findViewById(R.id.first_head_divider_line);
        this.k = view.findViewById(R.id.bjh_main_content);
        this.l = view.findViewById(R.id.bjh_click_container);
        this.m = (TbImageView) view.findViewById(R.id.bjh_imageView);
        this.n = view.findViewById(R.id.bjh_gradient_cover);
        this.o = (TextView) view.findViewById(R.id.bjh_content);
        this.p = view.findViewById(R.id.bjh_video_during_container);
        this.q = (ImageView) view.findViewById(R.id.bjh_vidoe_play_iv);
        this.r = (TextView) view.findViewById(R.id.bjh_video_during_tv);
        this.s = view.findViewById(R.id.last_video_tail);
        this.v = (TextView) view.findViewById(R.id.tail_more_video);
        this.t = view.findViewById(R.id.last_tail_divider_line);
        this.u = view.findViewById(R.id.last_tail_padding);
        this.w = (TextView) view.findViewById(R.id.bjh_user_info);
        this.x = (TextView) view.findViewById(R.id.bjh_video_info);
        this.y = view.findViewById(R.id.bjh_item_cross_line);
    }

    public void i(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) {
            this.f19274c = qVar;
            this.j.setVisibility(qVar.v4() ? 0 : 8);
            this.u.setVisibility(qVar.x4() ? 0 : 8);
            this.k.setVisibility(qVar.w4() ? 8 : 0);
            this.s.setVisibility(qVar.w4() ? 0 : 8);
            this.v.setOnClickListener(this.z);
            this.n.setOnClickListener(this.z);
            this.m.setOnClickListener(this.z);
            this.m.setConrers(15);
            this.m.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            this.m.setDrawCorner(true);
            this.m.setPlaceHolder(2);
            if (qVar.m1() != null) {
                this.o.setText(qVar.getTitle());
                this.m.M(qVar.m1().thumbnail_url, 10, false);
                this.n.setVisibility(0);
                this.n.setAlpha(0.5f);
                this.p.setVisibility(0);
                this.r.setText(StringUtils.translateSecondsToString(qVar.m1().video_duration.intValue()));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.x.getLayoutParams();
                if (qVar.H() != null && !k.isEmpty(qVar.H().getName_show())) {
                    this.w.setText(qVar.H().getName_show());
                    this.w.setVisibility(0);
                    layoutParams.leftMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
                } else {
                    this.w.setVisibility(8);
                    layoutParams.leftMargin = 0;
                }
                this.x.setLayoutParams(layoutParams);
                this.x.setText(String.format(this.f19273b.getResources().getString(R.string.bjh_pb_recommend_video_tip), StringHelper.numFormatOverWan(qVar.m1().play_count.intValue())));
            } else {
                this.p.setVisibility(8);
                this.n.setVisibility(8);
                this.m.M(qVar.F(), 10, false);
                this.o.setText(qVar.getTitle());
            }
            this.f19280i.setOnClickListener(this.z);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f19278g = i2;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f19277f = str;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f19276e = z;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f19275d = str;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f19279h = z;
        }
    }
}
