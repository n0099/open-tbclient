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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.is4;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.wi;
import com.baidu.tieba.xi;
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
    public AbsPbActivity b;
    public is4 c;
    public String d;
    public boolean e;
    public int f;
    public boolean g;
    public View h;
    public View i;
    public View j;
    public View k;
    public TbImageView l;
    public View m;
    public TextView n;
    public View o;
    public ImageView p;
    public TextView q;
    public View r;
    public View s;
    public View t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public View.OnClickListener y;

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

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
                if (id == R.id.obfuscated_res_0x7f09210c) {
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
                } else if (id == R.id.obfuscated_res_0x7f0914c3 || id == R.id.obfuscated_res_0x7f0903b2 || id == R.id.obfuscated_res_0x7f0903b1) {
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
                    if (this.a.g) {
                        ((VideoPbViewModel) ViewModelProviders.of(this.a.b).get(VideoPbViewModel.class)).r(this.a.c);
                        return;
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
        this.y = new a(this);
        this.b = absPbActivity;
        this.h = view2.findViewById(R.id.obfuscated_res_0x7f0914c3);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f0909df);
        this.j = view2.findViewById(R.id.obfuscated_res_0x7f0903b4);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f0903af);
        this.l = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0903b2);
        this.m = view2.findViewById(R.id.obfuscated_res_0x7f0903b1);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903b0);
        this.o = view2.findViewById(R.id.obfuscated_res_0x7f0903b6);
        this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0903b9);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903b7);
        this.r = view2.findViewById(R.id.obfuscated_res_0x7f09128a);
        this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09210c);
        this.s = view2.findViewById(R.id.obfuscated_res_0x7f091288);
        this.t = view2.findViewById(R.id.obfuscated_res_0x7f091289);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903b5);
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903b8);
        this.x = view2.findViewById(R.id.obfuscated_res_0x7f0903b3);
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f = i;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.e = z;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.g = z;
        }
    }

    public void g(is4 is4Var) {
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, is4Var) == null) {
            this.c = is4Var;
            View view2 = this.i;
            if (is4Var.f()) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
            View view3 = this.t;
            if (is4Var.j()) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view3.setVisibility(i2);
            View view4 = this.j;
            if (is4Var.h()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            view4.setVisibility(i3);
            View view5 = this.r;
            if (is4Var.h()) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            view5.setVisibility(i4);
            this.u.setOnClickListener(this.y);
            this.m.setOnClickListener(this.y);
            this.l.setOnClickListener(this.y);
            this.l.setConrers(15);
            this.l.setRadius(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            this.l.setDrawCorner(true);
            this.l.setPlaceHolder(2);
            if (is4Var.getThreadVideoInfo() != null) {
                this.n.setText(is4Var.getTitle());
                this.l.K(is4Var.getThreadVideoInfo().thumbnail_url, 10, false);
                this.m.setVisibility(0);
                this.m.setAlpha(0.5f);
                this.o.setVisibility(0);
                this.q.setText(StringUtils.translateSecondsToString(is4Var.getThreadVideoInfo().video_duration.intValue()));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.w.getLayoutParams();
                if (is4Var.getAuthor() != null && !wi.isEmpty(is4Var.getAuthor().getName_show())) {
                    this.v.setText(is4Var.getAuthor().getName_show());
                    this.v.setVisibility(0);
                    layoutParams.leftMargin = xi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
                } else {
                    this.v.setVisibility(8);
                    layoutParams.leftMargin = 0;
                }
                this.w.setLayoutParams(layoutParams);
                this.w.setText(String.format(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0317), StringHelper.numFormatOverWan(is4Var.getThreadVideoInfo().play_count.intValue())));
            } else {
                this.o.setVisibility(8);
                this.m.setVisibility(8);
                this.l.K(is4Var.getArticeCover(), 10, false);
                this.n.setText(is4Var.getTitle());
            }
            this.h.setOnClickListener(this.y);
        }
    }
}
