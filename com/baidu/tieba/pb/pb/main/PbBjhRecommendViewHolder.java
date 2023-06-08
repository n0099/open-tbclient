package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ui;
import com.baidu.tieba.vi;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.y15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class PbBjhRecommendViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public AbsPbActivity b;
    public y15 c;
    public String d;
    public boolean e;
    public int f;
    public View g;
    public View h;
    public View i;
    public TbImageView j;
    public View k;
    public TextView l;
    public View m;
    public ImageView n;
    public TextView o;
    public View p;
    public View q;
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public View v;
    public View.OnClickListener w;

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
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
        public void onClick(View view2) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (this.a.c == null) {
                    return;
                }
                int i = 3;
                if (id == R.id.obfuscated_res_0x7f09234f) {
                    VideoInfo threadVideoInfo = this.a.c.getThreadVideoInfo();
                    if (threadVideoInfo != null) {
                        if (threadVideoInfo.is_vertical.intValue() == 1) {
                            VideoItemData videoItemData = new VideoItemData();
                            videoItemData.buildWithThreadData(this.a.c);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(videoItemData);
                            if (this.a.f == 2) {
                                str2 = "index";
                            } else if (this.a.f == 1) {
                                str2 = "concern_tab";
                            } else if (this.a.f == 3) {
                                str2 = "frs";
                            } else {
                                str2 = "";
                            }
                            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(this.a.b, arrayList, 0, null, "from_nani_video", "", "", str2);
                            videoPlayActivityConfig.setIsFromBjhPb(true);
                            if (this.a.c.getThreadData() != null && this.a.c.getBaijiahaoData() != null) {
                                videoPlayActivityConfig.setNid(this.a.c.getBaijiahaoData().oriUgcNid);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                        } else if (threadVideoInfo.is_vertical.intValue() == 0) {
                            VideoItemData videoItemData2 = new VideoItemData();
                            videoItemData2.buildWithThreadData(this.a.c);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(videoItemData2);
                            if (this.a.f == 2) {
                                str = "index";
                            } else if (this.a.f == 1) {
                                str = "concern_tab";
                            } else if (this.a.f == 3) {
                                str = "frs";
                            } else {
                                str = "";
                            }
                            VideoPlayActivityConfig videoPlayActivityConfig2 = new VideoPlayActivityConfig(this.a.b, arrayList2, 0, null, "from_nani_video", "", "", str);
                            videoPlayActivityConfig2.setIsFromBjhPb(true);
                            if (this.a.c.getThreadData() != null && this.a.c.getBaijiahaoData() != null) {
                                videoPlayActivityConfig2.setNid(this.a.c.getBaijiahaoData().oriUgcNid);
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig2));
                        }
                    }
                } else if (id == R.id.main_view || id == R.id.obfuscated_res_0x7f0903fa || id == R.id.obfuscated_res_0x7f0903f9) {
                    String tid = this.a.c.getTid();
                    if (this.a.f == 2) {
                        i = 1;
                    } else if (this.a.f == 1) {
                        i = 2;
                    } else if (this.a.f != 3) {
                        i = 4;
                    }
                    if (i != 0) {
                        if (this.a.c.threadType == 40) {
                            StatisticItem.make("c13535").param("tid", tid).param("fid", this.a.c.getFid()).param("obj_source", i).param("obj_locate", this.a.c.c()).param("obj_id", this.a.d).param("obj_type", this.a.c.isBjhDynamicThread() ? 1 : 0).eventStat();
                        } else {
                            StatisticItem.make("c13534").param("tid", tid).param("fid", this.a.c.getFid()).param("obj_source", i).param("obj_locate", this.a.c.c()).param("obj_id", this.a.d).eventStat();
                        }
                    }
                    if (this.a.e) {
                        StatisticItem statisticItem = new StatisticItem("c13589");
                        statisticItem.param("tid", this.a.c.getTid());
                        if (this.a.c.getForumData() != null) {
                            statisticItem.param("fid", this.a.c.getForumData().b());
                        }
                        statisticItem.param("obj_param1", this.a.c.mRecomWeight);
                        statisticItem.param("obj_source", this.a.c.mRecomSource);
                        statisticItem.param("obj_id", this.a.d);
                        statisticItem.param("obj_locate", this.a.c.c());
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        if (this.a.c.getThreadData().getBaijiahaoData() != null) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, this.a.c.getThreadData().getBaijiahaoData().oriUgcNid);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.a.c.getThreadData().getBaijiahaoData().oriUgcVid);
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, this.a.c.getVideoRecStaticticType());
                        statisticItem.param("ab_tag", this.a.c.mRecomAbTag);
                        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, this.a.c.getThreadVideoInfo().is_vertical.intValue());
                        statisticItem.param("extra", this.a.c.mRecomExtra);
                        TiebaStatic.log(statisticItem);
                    }
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.b);
                    pbActivityConfig.createNormalCfg(tid, null, "pb");
                    pbActivityConfig.setBjhFrom(this.a.f);
                    pbActivityConfig.setLastTid(this.a.d);
                    pbActivityConfig.setStartFrom(20);
                    pbActivityConfig.setThreadData(this.a.c);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbBjhRecommendViewHolder(View view2, AbsPbActivity absPbActivity) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, absPbActivity};
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
        this.w = new a(this);
        this.b = absPbActivity;
        this.g = view2.findViewById(R.id.main_view);
        this.h = view2.findViewById(R.id.obfuscated_res_0x7f090afd);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f0903fc);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0903fa);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f0903f9);
        this.l = (TextView) view2.findViewById(R.id.bjh_content);
        this.m = view2.findViewById(R.id.obfuscated_res_0x7f0903fe);
        this.n = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090401);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903ff);
        this.p = view2.findViewById(R.id.obfuscated_res_0x7f091429);
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09234f);
        this.q = view2.findViewById(R.id.obfuscated_res_0x7f091427);
        this.r = view2.findViewById(R.id.obfuscated_res_0x7f091428);
        this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903fd);
        this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090400);
        this.v = view2.findViewById(R.id.obfuscated_res_0x7f0903fb);
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f = i;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.e = z;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    public void f(y15 y15Var) {
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, y15Var) == null) {
            this.c = y15Var;
            View view2 = this.h;
            if (y15Var.d()) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
            View view3 = this.r;
            if (y15Var.f()) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view3.setVisibility(i2);
            View view4 = this.i;
            if (y15Var.e()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view4.setVisibility(i3);
            View view5 = this.p;
            if (y15Var.e()) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            view5.setVisibility(i4);
            this.s.setOnClickListener(this.w);
            this.k.setOnClickListener(this.w);
            this.j.setOnClickListener(this.w);
            this.j.setConrers(15);
            this.j.setRadius(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            this.j.setDrawCorner(true);
            this.j.setPlaceHolder(2);
            if (y15Var.getThreadVideoInfo() != null) {
                this.l.setText(y15Var.getTitle());
                this.j.N(y15Var.getThreadVideoInfo().thumbnail_url, 10, false);
                this.k.setVisibility(0);
                this.k.setAlpha(0.5f);
                this.m.setVisibility(0);
                this.o.setText(StringUtils.translateSecondsToString(y15Var.getThreadVideoInfo().video_duration.intValue()));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.u.getLayoutParams();
                if (y15Var.getAuthor() != null && !ui.isEmpty(y15Var.getAuthor().getName_show())) {
                    this.t.setText(y15Var.getAuthor().getName_show());
                    this.t.setVisibility(0);
                    layoutParams.leftMargin = vi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
                } else {
                    this.t.setVisibility(8);
                    layoutParams.leftMargin = 0;
                }
                this.u.setLayoutParams(layoutParams);
                this.u.setText(String.format(this.b.getResources().getString(R.string.bjh_pb_recommend_video_tip), StringHelper.numFormatOverWan(y15Var.getThreadVideoInfo().play_count.intValue())));
            } else {
                this.m.setVisibility(8);
                this.k.setVisibility(8);
                this.j.N(y15Var.getArticeCover(), 10, false);
                this.l.setText(y15Var.getTitle());
            }
            this.g.setOnClickListener(this.w);
        }
    }
}
