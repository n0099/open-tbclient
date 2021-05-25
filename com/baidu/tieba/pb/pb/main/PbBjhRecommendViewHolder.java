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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.q.p;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class PbBjhRecommendViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f18866a;

    /* renamed from: b  reason: collision with root package name */
    public PbActivity f18867b;

    /* renamed from: c  reason: collision with root package name */
    public p f18868c;

    /* renamed from: d  reason: collision with root package name */
    public String f18869d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18870e;

    /* renamed from: f  reason: collision with root package name */
    public String f18871f;

    /* renamed from: g  reason: collision with root package name */
    public int f18872g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18873h;

    /* renamed from: i  reason: collision with root package name */
    public View f18874i;
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
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            int id = view.getId();
            if (PbBjhRecommendViewHolder.this.f18868c == null) {
                return;
            }
            int i2 = 3;
            if (id == R.id.tail_more_video) {
                VideoInfo w1 = PbBjhRecommendViewHolder.this.f18868c.w1();
                if (w1 != null) {
                    if (w1.is_vertical.intValue() == 1) {
                        VideoItemData videoItemData = new VideoItemData();
                        videoItemData.buildWithThreadData(PbBjhRecommendViewHolder.this.f18868c);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(videoItemData);
                        if (PbBjhRecommendViewHolder.this.f18872g == 2) {
                            str2 = "index";
                        } else if (PbBjhRecommendViewHolder.this.f18872g == 1) {
                            str2 = "concern_tab";
                        } else {
                            str2 = PbBjhRecommendViewHolder.this.f18872g == 3 ? "frs" : "";
                        }
                        VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(PbBjhRecommendViewHolder.this.f18867b, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str2);
                        videoPlayActivityConfig.setIsFromBjhPb(true);
                        p pVar = PbBjhRecommendViewHolder.this.f18868c;
                        pVar.m();
                        if (pVar != null && PbBjhRecommendViewHolder.this.f18868c.V() != null) {
                            videoPlayActivityConfig.setNid(PbBjhRecommendViewHolder.this.f18868c.V().oriUgcNid);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                    } else if (w1.is_vertical.intValue() == 0) {
                        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                        videoSerializeVideoThreadInfo.copyFromThreadInfo(PbBjhRecommendViewHolder.this.f18868c);
                        if (PbBjhRecommendViewHolder.this.f18872g == 2) {
                            str = "index";
                        } else if (PbBjhRecommendViewHolder.this.f18872g == 1) {
                            str = "concern_tab";
                        } else {
                            str = PbBjhRecommendViewHolder.this.f18872g == 3 ? "frs" : "";
                        }
                        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(PbBjhRecommendViewHolder.this.f18867b, str, PbBjhRecommendViewHolder.this.f18868c.y1(), "", "", videoSerializeVideoThreadInfo);
                        videoMiddlePageActivityConfig.setNid(PbBjhRecommendViewHolder.this.f18871f);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
                    }
                }
            } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                String y1 = PbBjhRecommendViewHolder.this.f18868c.y1();
                if (PbBjhRecommendViewHolder.this.f18872g == 2) {
                    i2 = 1;
                } else if (PbBjhRecommendViewHolder.this.f18872g == 1) {
                    i2 = 2;
                } else if (PbBjhRecommendViewHolder.this.f18872g != 3) {
                    i2 = 4;
                }
                if (i2 != 0) {
                    if (PbBjhRecommendViewHolder.this.f18868c.Z == 40) {
                        StatisticItem.make("c13535").param("tid", y1).param("fid", PbBjhRecommendViewHolder.this.f18868c.c0()).param("obj_source", i2).param("obj_locate", PbBjhRecommendViewHolder.this.f18868c.C4()).param("obj_id", PbBjhRecommendViewHolder.this.f18869d).param("obj_type", PbBjhRecommendViewHolder.this.f18868c.V1() ? 1 : 0).eventStat();
                    } else {
                        StatisticItem.make("c13534").param("tid", y1).param("fid", PbBjhRecommendViewHolder.this.f18868c.c0()).param("obj_source", i2).param("obj_locate", PbBjhRecommendViewHolder.this.f18868c.C4()).param("obj_id", PbBjhRecommendViewHolder.this.f18869d).eventStat();
                    }
                }
                if (PbBjhRecommendViewHolder.this.f18870e) {
                    StatisticItem statisticItem = new StatisticItem("c13589");
                    statisticItem.param("tid", PbBjhRecommendViewHolder.this.f18868c.y1());
                    if (PbBjhRecommendViewHolder.this.f18868c.h0() != null) {
                        statisticItem.param("fid", PbBjhRecommendViewHolder.this.f18868c.h0().h());
                    }
                    statisticItem.param("obj_param1", PbBjhRecommendViewHolder.this.f18868c.T0);
                    statisticItem.param("obj_source", PbBjhRecommendViewHolder.this.f18868c.S0);
                    statisticItem.param("obj_id", PbBjhRecommendViewHolder.this.f18869d);
                    statisticItem.param("obj_locate", PbBjhRecommendViewHolder.this.f18868c.C4());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    p pVar2 = PbBjhRecommendViewHolder.this.f18868c;
                    pVar2.m();
                    if (pVar2.V() != null) {
                        p pVar3 = PbBjhRecommendViewHolder.this.f18868c;
                        pVar3.m();
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, pVar3.V().oriUgcNid);
                        p pVar4 = PbBjhRecommendViewHolder.this.f18868c;
                        pVar4.m();
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, pVar4.V().oriUgcVid);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, PbBjhRecommendViewHolder.this.f18868c.H1());
                    statisticItem.param("ab_tag", PbBjhRecommendViewHolder.this.f18868c.U0);
                    statisticItem.param(TiebaStatic.Params.IS_VERTICAL, PbBjhRecommendViewHolder.this.f18868c.w1().is_vertical.intValue());
                    statisticItem.param("extra", PbBjhRecommendViewHolder.this.f18868c.V0);
                    TiebaStatic.log(statisticItem);
                }
                if (PbBjhRecommendViewHolder.this.f18873h) {
                    ((VideoPbViewModel) ViewModelProviders.of(PbBjhRecommendViewHolder.this.f18867b).get(VideoPbViewModel.class)).q(PbBjhRecommendViewHolder.this.f18868c);
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(PbBjhRecommendViewHolder.this.f18867b);
                pbActivityConfig.createNormalCfg(y1, null, "pb");
                pbActivityConfig.setBjhFrom(PbBjhRecommendViewHolder.this.f18872g);
                pbActivityConfig.setLastTid(PbBjhRecommendViewHolder.this.f18869d);
                pbActivityConfig.setStartFrom(20);
                pbActivityConfig.setThreadData(PbBjhRecommendViewHolder.this.f18868c);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        }
    }

    public PbBjhRecommendViewHolder(View view, PbActivity pbActivity) {
        super(view);
        this.f18866a = 3;
        this.z = new a();
        this.f18867b = pbActivity;
        this.f18874i = view.findViewById(R.id.main_view);
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

    public void i(p pVar) {
        this.f18868c = pVar;
        this.j.setVisibility(pVar.D4() ? 0 : 8);
        this.u.setVisibility(pVar.F4() ? 0 : 8);
        this.k.setVisibility(pVar.E4() ? 8 : 0);
        this.s.setVisibility(pVar.E4() ? 0 : 8);
        this.v.setOnClickListener(this.z);
        this.n.setOnClickListener(this.z);
        this.m.setOnClickListener(this.z);
        this.m.setConrers(15);
        this.m.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.m.setDrawCorner(true);
        this.m.setPlaceHolder(2);
        if (pVar.w1() != null) {
            this.o.setText(pVar.z1());
            this.m.V(pVar.w1().thumbnail_url, 10, false);
            this.n.setVisibility(0);
            this.n.setAlpha(0.5f);
            this.p.setVisibility(0);
            this.r.setText(StringUtils.translateSecondsToString(pVar.w1().video_duration.intValue()));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.x.getLayoutParams();
            if (pVar.T() != null && !k.isEmpty(pVar.T().getName_show())) {
                this.w.setText(pVar.T().getName_show());
                this.w.setVisibility(0);
                layoutParams.leftMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.w.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.x.setLayoutParams(layoutParams);
            this.x.setText(String.format(this.f18867b.getResources().getString(R.string.bjh_pb_recommend_video_tip), StringHelper.numFormatOverWan(pVar.w1().play_count.intValue())));
        } else {
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            this.m.V(pVar.R(), 10, false);
            this.o.setText(pVar.z1());
        }
        this.f18874i.setOnClickListener(this.z);
    }

    public void j(int i2) {
        this.f18872g = i2;
    }

    public void k(String str) {
        this.f18871f = str;
    }

    public void l(boolean z) {
        this.f18870e = z;
    }

    public void m(String str) {
        this.f18869d = str;
    }

    public void n(boolean z) {
        this.f18873h = z;
    }
}
