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
import d.a.i0.r.q.p;
import java.util.ArrayList;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class PbBjhRecommendViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f19664a;

    /* renamed from: b  reason: collision with root package name */
    public PbActivity f19665b;

    /* renamed from: c  reason: collision with root package name */
    public p f19666c;

    /* renamed from: d  reason: collision with root package name */
    public String f19667d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19668e;

    /* renamed from: f  reason: collision with root package name */
    public String f19669f;

    /* renamed from: g  reason: collision with root package name */
    public int f19670g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19671h;

    /* renamed from: i  reason: collision with root package name */
    public View f19672i;
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            int id = view.getId();
            if (PbBjhRecommendViewHolder.this.f19666c == null) {
                return;
            }
            int i2 = 3;
            if (id == R.id.tail_more_video) {
                VideoInfo u1 = PbBjhRecommendViewHolder.this.f19666c.u1();
                if (u1 != null) {
                    if (u1.is_vertical.intValue() == 1) {
                        VideoItemData videoItemData = new VideoItemData();
                        videoItemData.buildWithThreadData(PbBjhRecommendViewHolder.this.f19666c);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(videoItemData);
                        if (PbBjhRecommendViewHolder.this.f19670g == 2) {
                            str2 = "index";
                        } else if (PbBjhRecommendViewHolder.this.f19670g == 1) {
                            str2 = "concern_tab";
                        } else {
                            str2 = PbBjhRecommendViewHolder.this.f19670g == 3 ? "frs" : "";
                        }
                        VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(PbBjhRecommendViewHolder.this.f19665b, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "", "", str2);
                        videoPlayActivityConfig.setIsFromBjhPb(true);
                        p pVar = PbBjhRecommendViewHolder.this.f19666c;
                        pVar.m();
                        if (pVar != null && PbBjhRecommendViewHolder.this.f19666c.V() != null) {
                            videoPlayActivityConfig.setNid(PbBjhRecommendViewHolder.this.f19666c.V().oriUgcNid);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
                    } else if (u1.is_vertical.intValue() == 0) {
                        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
                        videoSerializeVideoThreadInfo.copyFromThreadInfo(PbBjhRecommendViewHolder.this.f19666c);
                        if (PbBjhRecommendViewHolder.this.f19670g == 2) {
                            str = "index";
                        } else if (PbBjhRecommendViewHolder.this.f19670g == 1) {
                            str = "concern_tab";
                        } else {
                            str = PbBjhRecommendViewHolder.this.f19670g == 3 ? "frs" : "";
                        }
                        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(PbBjhRecommendViewHolder.this.f19665b, str, PbBjhRecommendViewHolder.this.f19666c.w1(), "", "", videoSerializeVideoThreadInfo);
                        videoMiddlePageActivityConfig.setNid(PbBjhRecommendViewHolder.this.f19669f);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
                    }
                }
            } else if (id == R.id.main_view || id == R.id.bjh_imageView || id == R.id.bjh_gradient_cover) {
                String w1 = PbBjhRecommendViewHolder.this.f19666c.w1();
                if (PbBjhRecommendViewHolder.this.f19670g == 2) {
                    i2 = 1;
                } else if (PbBjhRecommendViewHolder.this.f19670g == 1) {
                    i2 = 2;
                } else if (PbBjhRecommendViewHolder.this.f19670g != 3) {
                    i2 = 4;
                }
                if (i2 != 0) {
                    if (PbBjhRecommendViewHolder.this.f19666c.Z == 40) {
                        StatisticItem.make("c13535").param("tid", w1).param("fid", PbBjhRecommendViewHolder.this.f19666c.c0()).param("obj_source", i2).param("obj_locate", PbBjhRecommendViewHolder.this.f19666c.z4()).param("obj_id", PbBjhRecommendViewHolder.this.f19667d).param("obj_type", PbBjhRecommendViewHolder.this.f19666c.T1() ? 1 : 0).eventStat();
                    } else {
                        StatisticItem.make("c13534").param("tid", w1).param("fid", PbBjhRecommendViewHolder.this.f19666c.c0()).param("obj_source", i2).param("obj_locate", PbBjhRecommendViewHolder.this.f19666c.z4()).param("obj_id", PbBjhRecommendViewHolder.this.f19667d).eventStat();
                    }
                }
                if (PbBjhRecommendViewHolder.this.f19668e) {
                    StatisticItem statisticItem = new StatisticItem("c13589");
                    statisticItem.param("tid", PbBjhRecommendViewHolder.this.f19666c.w1());
                    if (PbBjhRecommendViewHolder.this.f19666c.h0() != null) {
                        statisticItem.param("fid", PbBjhRecommendViewHolder.this.f19666c.h0().h());
                    }
                    statisticItem.param("obj_param1", PbBjhRecommendViewHolder.this.f19666c.S0);
                    statisticItem.param("obj_source", PbBjhRecommendViewHolder.this.f19666c.R0);
                    statisticItem.param("obj_id", PbBjhRecommendViewHolder.this.f19667d);
                    statisticItem.param("obj_locate", PbBjhRecommendViewHolder.this.f19666c.z4());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    p pVar2 = PbBjhRecommendViewHolder.this.f19666c;
                    pVar2.m();
                    if (pVar2.V() != null) {
                        p pVar3 = PbBjhRecommendViewHolder.this.f19666c;
                        pVar3.m();
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, pVar3.V().oriUgcNid);
                        p pVar4 = PbBjhRecommendViewHolder.this.f19666c;
                        pVar4.m();
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, pVar4.V().oriUgcVid);
                    }
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, PbBjhRecommendViewHolder.this.f19666c.F1());
                    statisticItem.param("ab_tag", PbBjhRecommendViewHolder.this.f19666c.T0);
                    statisticItem.param(TiebaStatic.Params.IS_VERTICAL, PbBjhRecommendViewHolder.this.f19666c.u1().is_vertical.intValue());
                    statisticItem.param("extra", PbBjhRecommendViewHolder.this.f19666c.U0);
                    TiebaStatic.log(statisticItem);
                }
                if (PbBjhRecommendViewHolder.this.f19671h) {
                    ((VideoPbViewModel) ViewModelProviders.of(PbBjhRecommendViewHolder.this.f19665b).get(VideoPbViewModel.class)).q(PbBjhRecommendViewHolder.this.f19666c);
                    return;
                }
                PbActivityConfig pbActivityConfig = new PbActivityConfig(PbBjhRecommendViewHolder.this.f19665b);
                pbActivityConfig.createNormalCfg(w1, null, "pb");
                pbActivityConfig.setBjhFrom(PbBjhRecommendViewHolder.this.f19670g);
                pbActivityConfig.setLastTid(PbBjhRecommendViewHolder.this.f19667d);
                pbActivityConfig.setStartFrom(20);
                pbActivityConfig.setThreadData(PbBjhRecommendViewHolder.this.f19666c);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        }
    }

    public PbBjhRecommendViewHolder(View view, PbActivity pbActivity) {
        super(view);
        this.f19664a = 3;
        this.z = new a();
        this.f19665b = pbActivity;
        this.f19672i = view.findViewById(R.id.main_view);
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
        this.f19666c = pVar;
        this.j.setVisibility(pVar.A4() ? 0 : 8);
        this.u.setVisibility(pVar.C4() ? 0 : 8);
        this.k.setVisibility(pVar.B4() ? 8 : 0);
        this.s.setVisibility(pVar.B4() ? 0 : 8);
        this.v.setOnClickListener(this.z);
        this.n.setOnClickListener(this.z);
        this.m.setOnClickListener(this.z);
        this.m.setConrers(15);
        this.m.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.m.setDrawCorner(true);
        this.m.setPlaceHolder(2);
        if (pVar.u1() != null) {
            this.o.setText(pVar.x1());
            this.m.V(pVar.u1().thumbnail_url, 10, false);
            this.n.setVisibility(0);
            this.n.setAlpha(0.5f);
            this.p.setVisibility(0);
            this.r.setText(StringUtils.translateSecondsToString(pVar.u1().video_duration.intValue()));
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
            this.x.setText(String.format(this.f19665b.getResources().getString(R.string.bjh_pb_recommend_video_tip), StringHelper.numFormatOverWan(pVar.u1().play_count.intValue())));
        } else {
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            this.m.V(pVar.R(), 10, false);
            this.o.setText(pVar.x1());
        }
        this.f19672i.setOnClickListener(this.z);
    }

    public void j(int i2) {
        this.f19670g = i2;
    }

    public void k(String str) {
        this.f19669f = str;
    }

    public void l(boolean z) {
        this.f19668e = z;
    }

    public void m(String str) {
        this.f19667d = str;
    }

    public void n(boolean z) {
        this.f19671h = z;
    }
}
