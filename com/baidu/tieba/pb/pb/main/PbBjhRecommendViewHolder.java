package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.r.q;
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
/* loaded from: classes5.dex */
public class PbBjhRecommendViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public AbsPbActivity f34860b;

    /* renamed from: c  reason: collision with root package name */
    public q f34861c;

    /* renamed from: d  reason: collision with root package name */
    public String f34862d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34863e;

    /* renamed from: f  reason: collision with root package name */
    public String f34864f;

    /* renamed from: g  reason: collision with root package name */
    public int f34865g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34866h;
    public View i;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbBjhRecommendViewHolder a;

        public a(PbBjhRecommendViewHolder pbBjhRecommendViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbBjhRecommendViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbBjhRecommendViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (this.a.f34861c == null) {
                    return;
                }
                int i = 3;
                if (id == R.id.obfuscated_res_0x7f091ee5) {
                    VideoInfo threadVideoInfo = this.a.f34861c.getThreadVideoInfo();
                    if (threadVideoInfo != null) {
                        if (threadVideoInfo.is_vertical.intValue() == 1) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(this.a.f34861c);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(videoItemData);
                            if (this.a.f34865g == 2) {
                                str2 = "index";
                            } else if (this.a.f34865g == 1) {
                                str2 = "concern_tab";
                            } else {
                                str2 = this.a.f34865g == 3 ? "frs" : "";
                            }
                            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.a.f34860b, arrayList, 0, null, "from_nani_video", "", "", str2);
                            videoPlayActivityConfig.setIsFromBjhPb(true);
                            if (this.a.f34861c.getThreadData() != null && this.a.f34861c.getBaijiahaoData() != null) {
                                videoPlayActivityConfig.setNid(this.a.f34861c.getBaijiahaoData().oriUgcNid);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                        } else if (threadVideoInfo.is_vertical.intValue() == 0) {
                            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                            videoSerializeVideoThreadInfo.copyFromThreadInfo(this.a.f34861c);
                            if (this.a.f34865g == 2) {
                                str = "index";
                            } else if (this.a.f34865g == 1) {
                                str = "concern_tab";
                            } else {
                                str = this.a.f34865g == 3 ? "frs" : "";
                            }
                            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.a.f34860b, str, this.a.f34861c.getTid(), "", "", videoSerializeVideoThreadInfo);
                            videoMiddlePageActivityConfig.setNid(this.a.f34864f);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
                        }
                    }
                } else if (id == R.id.obfuscated_res_0x7f091380 || id == R.id.obfuscated_res_0x7f090376 || id == R.id.obfuscated_res_0x7f090375) {
                    String tid = this.a.f34861c.getTid();
                    if (this.a.f34865g == 2) {
                        i = 1;
                    } else if (this.a.f34865g == 1) {
                        i = 2;
                    } else if (this.a.f34865g != 3) {
                        i = 4;
                    }
                    if (i != 0) {
                        if (this.a.f34861c.threadType == 40) {
                            StatisticItem.make("c13535").param("tid", tid).param("fid", this.a.f34861c.getFid()).param("obj_source", i).param("obj_locate", this.a.f34861c.e()).param("obj_id", this.a.f34862d).param("obj_type", this.a.f34861c.isBjhDynamicThread() ? 1 : 0).eventStat();
                        } else {
                            StatisticItem.make("c13534").param("tid", tid).param("fid", this.a.f34861c.getFid()).param("obj_source", i).param("obj_locate", this.a.f34861c.e()).param("obj_id", this.a.f34862d).eventStat();
                        }
                    }
                    if (this.a.f34863e) {
                        StatisticItem statisticItem = new StatisticItem("c13589");
                        statisticItem.param("tid", this.a.f34861c.getTid());
                        if (this.a.f34861c.getForumData() != null) {
                            statisticItem.param("fid", this.a.f34861c.getForumData().c());
                        }
                        statisticItem.param("obj_param1", this.a.f34861c.mRecomWeight);
                        statisticItem.param("obj_source", this.a.f34861c.mRecomSource);
                        statisticItem.param("obj_id", this.a.f34862d);
                        statisticItem.param("obj_locate", this.a.f34861c.e());
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        if (this.a.f34861c.getThreadData().getBaijiahaoData() != null) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.a.f34861c.getThreadData().getBaijiahaoData().oriUgcNid);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.a.f34861c.getThreadData().getBaijiahaoData().oriUgcVid);
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, this.a.f34861c.getVideoRecStaticticType());
                        statisticItem.param("ab_tag", this.a.f34861c.mRecomAbTag);
                        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, this.a.f34861c.getThreadVideoInfo().is_vertical.intValue());
                        statisticItem.param("extra", this.a.f34861c.mRecomExtra);
                        TiebaStatic.log(statisticItem);
                    }
                    if (this.a.f34866h) {
                        ((VideoPbViewModel) ViewModelProviders.of(this.a.f34860b).get(VideoPbViewModel.class)).q(this.a.f34861c);
                        return;
                    }
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.f34860b);
                    pbActivityConfig.createNormalCfg(tid, null, "pb");
                    pbActivityConfig.setBjhFrom(this.a.f34865g);
                    pbActivityConfig.setLastTid(this.a.f34862d);
                    pbActivityConfig.setStartFrom(20);
                    pbActivityConfig.setThreadData(this.a.f34861c);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.z = new a(this);
        this.f34860b = absPbActivity;
        this.i = view.findViewById(R.id.obfuscated_res_0x7f091380);
        this.j = view.findViewById(R.id.obfuscated_res_0x7f09099d);
        this.k = view.findViewById(R.id.obfuscated_res_0x7f090378);
        this.l = view.findViewById(R.id.obfuscated_res_0x7f090373);
        this.m = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090376);
        this.n = view.findViewById(R.id.obfuscated_res_0x7f090375);
        this.o = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090374);
        this.p = view.findViewById(R.id.obfuscated_res_0x7f09037a);
        this.q = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09037d);
        this.r = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09037b);
        this.s = view.findViewById(R.id.obfuscated_res_0x7f0911ab);
        this.v = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091ee5);
        this.t = view.findViewById(R.id.obfuscated_res_0x7f0911a9);
        this.u = view.findViewById(R.id.obfuscated_res_0x7f0911aa);
        this.w = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090379);
        this.x = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09037c);
        this.y = view.findViewById(R.id.obfuscated_res_0x7f090377);
    }

    public void j(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) {
            this.f34861c = qVar;
            this.j.setVisibility(qVar.g() ? 0 : 8);
            this.u.setVisibility(qVar.k() ? 0 : 8);
            this.k.setVisibility(qVar.i() ? 8 : 0);
            this.s.setVisibility(qVar.i() ? 0 : 8);
            this.v.setOnClickListener(this.z);
            this.n.setOnClickListener(this.z);
            this.m.setOnClickListener(this.z);
            this.m.setConrers(15);
            this.m.setRadius(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            this.m.setDrawCorner(true);
            this.m.setPlaceHolder(2);
            if (qVar.getThreadVideoInfo() != null) {
                this.o.setText(qVar.getTitle());
                this.m.J(qVar.getThreadVideoInfo().thumbnail_url, 10, false);
                this.n.setVisibility(0);
                this.n.setAlpha(0.5f);
                this.p.setVisibility(0);
                this.r.setText(StringUtils.translateSecondsToString(qVar.getThreadVideoInfo().video_duration.intValue()));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.x.getLayoutParams();
                if (qVar.getAuthor() != null && !m.isEmpty(qVar.getAuthor().getName_show())) {
                    this.w.setText(qVar.getAuthor().getName_show());
                    this.w.setVisibility(0);
                    layoutParams.leftMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
                } else {
                    this.w.setVisibility(8);
                    layoutParams.leftMargin = 0;
                }
                this.x.setLayoutParams(layoutParams);
                this.x.setText(String.format(this.f34860b.getResources().getString(R.string.obfuscated_res_0x7f0f0302), StringHelper.numFormatOverWan(qVar.getThreadVideoInfo().play_count.intValue())));
            } else {
                this.p.setVisibility(8);
                this.n.setVisibility(8);
                this.m.J(qVar.getArticeCover(), 10, false);
                this.o.setText(qVar.getTitle());
            }
            this.i.setOnClickListener(this.z);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f34865g = i;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f34864f = str;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f34863e = z;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f34862d = str;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f34866h = z;
        }
    }
}
