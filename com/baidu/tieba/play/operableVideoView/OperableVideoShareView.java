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
import d.a.c.e.p.k;
import d.a.i0.r.q.a2;
import d.a.i0.z0.l;
import d.a.j0.j2.q.d;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class OperableVideoShareView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public d f20757e;

    /* renamed from: f  reason: collision with root package name */
    public View f20758f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20759g;

    /* renamed from: h  reason: collision with root package name */
    public View f20760h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f20761i;
    public View j;
    public ImageView k;
    public View l;
    public View m;
    public ImageView n;
    public a2 o;
    public int p;
    public View.OnClickListener q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.a()) {
                return;
            }
            if (view == OperableVideoShareView.this.f20758f) {
                OperableVideoShareView.this.i(3);
            } else if (view == OperableVideoShareView.this.f20760h) {
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f20760h.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f20758f.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.l.getLayoutParams();
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        if (z2 && !z) {
            g2 = d.a.c.e.p.l.g(getContext(), R.dimen.tbds72);
            g3 = d.a.c.e.p.l.g(getContext(), R.dimen.tbds52);
        } else {
            g2 = d.a.c.e.p.l.g(getContext(), R.dimen.tbds36);
            g3 = d.a.c.e.p.l.g(getContext(), R.dimen.tbds26);
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
        for (int i2 = 0; i2 < size; i2++) {
            MediaData mediaData = K0.get(i2);
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
            if (a2Var.o2()) {
                return 4;
            }
            if (a2Var.s0() == 1) {
                return 3;
            }
            return a2Var.p2() ? 2 : 1;
        }
        return 0;
    }

    public int getLayoutR() {
        return R.layout.operable_video_share_view;
    }

    public final void h() {
        LinearLayout.inflate(getContext(), getLayoutR(), this);
        this.f20758f = findViewById(R.id.share_weixin);
        this.f20759g = (ImageView) findViewById(R.id.share_weixin_img);
        this.f20760h = findViewById(R.id.share_weixin_timeline);
        this.f20761i = (ImageView) findViewById(R.id.share_weixin_timeline_img);
        this.j = findViewById(R.id.share_qq);
        this.k = (ImageView) findViewById(R.id.share_qq_img);
        this.l = findViewById(R.id.divider_line);
        this.m = findViewById(R.id.video_replay);
        this.n = (ImageView) findViewById(R.id.replay_img);
        this.f20758f.setOnClickListener(this.q);
        this.f20760h.setOnClickListener(this.q);
        this.j.setOnClickListener(this.q);
        setOnClickListener(this.q);
        this.f20759g.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_wechat40_svg, 1, false));
        this.f20761i.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_circle40_svg, 1, false));
        this.k.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.icon_mask_share_qq40_svg, 1, false));
        this.n.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_replay44_svg, R.color.CAM_X0105, null, false));
        this.n.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(getContext(), R.dimen.tbds52), getResources().getColor(R.color.CAM_X0622)));
    }

    public final void i(int i2) {
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
        if (!this.o.y2() && this.o.p2() && this.o.u1() != null) {
            shareItem.R = this.o.u1().play_count.intValue();
        }
        shareItem.D = C;
        shareItem.t = str;
        shareItem.o = this.p;
        shareItem.q = w1;
        shareItem.F = 3;
        shareItem.G = 1;
        if (i2 == 3) {
            shareItem.H = 1;
        } else if (i2 == 2) {
            shareItem.H = 2;
        } else if (i2 == 8) {
            shareItem.H = 3;
        } else {
            shareItem.H = 0;
        }
        shareItem.J = valueOf;
        shareItem.p = i0;
        shareItem.K = w1;
        shareItem.L = this.o.L0();
        shareItem.f13358h = true;
        shareItem.E = 3;
        shareItem.M = g(this.o);
        if (parse != null) {
            shareItem.v = parse;
        }
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(this.o);
        shareItem.U = ShareItem.ForwardInfo.generateForwardInfo(this.o);
        shareItem.I = 1;
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        shareItem.e0 = this.o.e1();
        Bundle bundle = new Bundle();
        bundle.putString("tid", shareItem.K);
        bundle.putString("fid", shareItem.J);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt(TiebaStatic.Params.OBJ_PARAM2, shareItem.G);
        bundle.putInt(TiebaStatic.Params.OBJ_PARAM3, shareItem.H);
        bundle.putInt("obj_source", shareItem.o);
        bundle.putInt("obj_locate", shareItem.I);
        shareItem.k(bundle);
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem.param("tid", shareItem.K);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("fid", shareItem.J);
        statisticItem.param("obj_locate", this.p);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, shareItem.H);
        statisticItem.param("nid", shareItem.L);
        if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(getContext(), i2, shareItem, true));
    }

    public void setShareData(a2 a2Var) {
        this.o = a2Var;
        if (a2Var != null && !a2Var.y2()) {
            this.j.setVisibility(0);
            this.f20758f.setVisibility(0);
            this.f20760h.setVisibility(0);
            this.l.setVisibility(0);
            return;
        }
        this.j.setVisibility(8);
        this.f20758f.setVisibility(8);
        this.f20760h.setVisibility(8);
        this.l.setVisibility(8);
    }

    public void setShareFrom(int i2) {
        this.p = i2;
    }

    public void setVideoContainer(d dVar) {
        this.f20757e = dVar;
        this.m.setOnClickListener(dVar);
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 3;
        this.q = new a();
        h();
    }

    public OperableVideoShareView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = 3;
        this.q = new a();
        h();
    }
}
