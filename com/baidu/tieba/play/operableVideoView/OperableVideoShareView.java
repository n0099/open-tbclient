package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import d.b.b.e.p.k;
import d.b.h0.r.q.a2;
import d.b.h0.z0.l;
import d.b.i0.i2.q.d;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class OperableVideoShareView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public d f20529e;

    /* renamed from: f  reason: collision with root package name */
    public View f20530f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20531g;

    /* renamed from: h  reason: collision with root package name */
    public View f20532h;
    public ImageView i;
    public View j;
    public ImageView k;
    public View l;
    public View m;
    public ImageView n;
    public a2 o;
    public int p;
    public View.OnClickListener q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.a()) {
                return;
            }
            if (view == OperableVideoShareView.this.f20530f) {
                OperableVideoShareView.this.i(3);
            } else if (view == OperableVideoShareView.this.f20532h) {
                OperableVideoShareView.this.i(2);
            } else if (view == OperableVideoShareView.this.j) {
                OperableVideoShareView.this.i(8);
            }
        }
    }

    public OperableVideoShareView(Context context) {
        super(context);
        this.p = 3;
        this.q = new a();
        h();
    }

    public void e(boolean z, boolean z2) {
        int g2;
        int g3;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f20532h.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f20530f.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.l.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        if (z2 && !z) {
            g2 = d.b.b.e.p.l.g(getContext(), R.dimen.tbds72);
            g3 = d.b.b.e.p.l.g(getContext(), R.dimen.tbds52);
        } else {
            g2 = d.b.b.e.p.l.g(getContext(), R.dimen.tbds36);
            g3 = d.b.b.e.p.l.g(getContext(), R.dimen.tbds26);
        }
        layoutParams4.rightMargin = g3;
        layoutParams4.leftMargin = g3;
        layoutParams5.rightMargin = g2;
        layoutParams5.leftMargin = g2;
        layoutParams3.rightMargin = g2;
        layoutParams3.leftMargin = g2;
        layoutParams2.rightMargin = g2;
        layoutParams2.leftMargin = g2;
        layoutParams.rightMargin = g2;
        layoutParams.leftMargin = g2;
    }

    public final String f(a2 a2Var) {
        if (a2Var == null || a2Var.K0() == null) {
            return null;
        }
        ArrayList<MediaData> K0 = a2Var.K0();
        int size = K0.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = K0.get(i);
            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    return mediaData.getThumbnails_url();
                }
                if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    return mediaData.getPicUrl();
                }
            }
        }
        return null;
    }

    public final int g(a2 a2Var) {
        if (a2Var != null) {
            if (a2Var.n2()) {
                return 4;
            }
            if (a2Var.s0() == 1) {
                return 3;
            }
            return a2Var.o2() ? 2 : 1;
        }
        return 0;
    }

    public int getLayoutR() {
        return R.layout.operable_video_share_view;
    }

    public final void h() {
        LinearLayout.inflate(getContext(), getLayoutR(), this);
        this.f20530f = findViewById(R.id.share_weixin);
        this.f20531g = (ImageView) findViewById(R.id.share_weixin_img);
        this.f20532h = findViewById(R.id.share_weixin_timeline);
        this.i = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.j = findViewById(R.id.share_qq);
        this.k = (ImageView) findViewById(R.id.share_qq_img);
        this.l = findViewById(R.id.divider_line);
        this.m = findViewById(R.id.video_replay);
        this.n = (ImageView) findViewById(R.id.replay_img);
        this.f20530f.setOnClickListener(this.q);
        this.f20532h.setOnClickListener(this.q);
        this.j.setOnClickListener(this.q);
        setOnClickListener(this.q);
        this.f20531g.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.i.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.k.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.n.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, null, false));
        this.n.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.b.e.p.l.g(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
    }

    public final void i(int i) {
        a2 a2Var = this.o;
        if (a2Var == null) {
            return;
        }
        String valueOf = String.valueOf(a2Var.c0());
        String i0 = this.o.i0();
        OriginalForumInfo originalForumInfo = this.o.C1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            i0 = originalForumInfo.ori_fname;
        }
        String x1 = this.o.x1();
        String w1 = this.o.w1();
        String str = "http://tieba.baidu.com/p/" + w1 + "?share=9105&fr=share";
        String f2 = f(this.o);
        Uri parse = f2 == null ? null : Uri.parse(f2);
        String C = this.o.C();
        String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), x1, C);
        ShareItem shareItem = new ShareItem();
        shareItem.r = x1;
        shareItem.s = format;
        if (!this.o.x2() && this.o.o2() && this.o.u1() != null) {
            shareItem.Q = this.o.u1().play_count.intValue();
        }
        shareItem.C = C;
        shareItem.t = str;
        shareItem.o = this.p;
        shareItem.q = w1;
        shareItem.E = 3;
        shareItem.F = 1;
        if (i == 3) {
            shareItem.G = 1;
        } else if (i == 2) {
            shareItem.G = 2;
        } else if (i == 8) {
            shareItem.G = 3;
        } else {
            shareItem.G = 0;
        }
        shareItem.I = valueOf;
        shareItem.p = i0;
        shareItem.J = w1;
        shareItem.K = this.o.L0();
        shareItem.f13719h = true;
        shareItem.D = 3;
        shareItem.L = g(this.o);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.S = OriginalThreadInfo.ShareInfo.generateShareInfo(this.o);
        shareItem.T = ShareItem.ForwardInfo.generateForwardInfo(this.o);
        shareItem.H = 1;
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.c0 = this.o.e1();
        Bundle bundle = new Bundle();
        bundle.putString("tid", shareItem.J);
        bundle.putString("fid", shareItem.I);
        bundle.putInt("obj_type", shareItem.L);
        bundle.putInt("obj_param1", shareItem.E);
        bundle.putInt(TiebaStatic.Params.OBJ_PARAM2, shareItem.F);
        bundle.putInt(TiebaStatic.Params.OBJ_PARAM3, shareItem.G);
        bundle.putInt("obj_source", shareItem.o);
        bundle.putInt("obj_locate", shareItem.H);
        shareItem.i(bundle);
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", shareItem.J);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", shareItem.I);
        statisticItem.param("obj_locate", this.p);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, shareItem.G);
        statisticItem.param("nid", shareItem.K);
        if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i, shareItem, true));
    }

    public void setShareData(a2 a2Var) {
        this.o = a2Var;
        if (a2Var != null && !a2Var.x2()) {
            this.j.setVisibility(0);
            this.f20530f.setVisibility(0);
            this.f20532h.setVisibility(0);
            this.l.setVisibility(0);
            return;
        }
        this.j.setVisibility(8);
        this.f20530f.setVisibility(8);
        this.f20532h.setVisibility(8);
        this.l.setVisibility(8);
    }

    public void setShareFrom(int i) {
        this.p = i;
    }

    public void setVideoContainer(d dVar) {
        this.f20529e = dVar;
        this.m.setOnClickListener(dVar);
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 3;
        this.q = new a();
        h();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = 3;
        this.q = new a();
        h();
    }
}
