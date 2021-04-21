package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.PlayPicInfoCard;
import com.baidu.tieba.lego.view.BannerFlowView;
import com.baidu.tieba.lego.view.CommonImageButton;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i0.r.f0.r.b;
import d.b.j0.d3.v;
import d.b.j0.j1.i;
import d.b.j0.j1.t.a;
import d.b.j0.x.t;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class PlayPicInfoCardView extends BaseCardView<PlayPicInfoCard> {
    public TextView A;
    public TbImageView B;
    public TextView C;
    public CommonImageButton D;
    public BannerFlowView r;
    public View s;
    public TextView t;
    public LinearLayout u;
    public TextView v;
    public TextView w;
    public IndicatorView x;
    public TbImageView y;
    public RelativeLayout z;

    /* loaded from: classes4.dex */
    public class a implements b.a<d.b.i0.r.f0.r.d.a, a.C1387a> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f18347a;

        public a(PlayPicInfoCard playPicInfoCard) {
            this.f18347a = playPicInfoCard;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.r.f0.r.b.a
        /* renamed from: b */
        public void a(a.C1387a c1387a, d.b.i0.r.f0.r.d.a aVar) {
            if (aVar.e() instanceof PlayPicInfoCard.b) {
                PlayPicInfoCard.b bVar = (PlayPicInfoCard.b) aVar.e();
                if (TextUtils.isEmpty(bVar.f18312c)) {
                    return;
                }
                t.b().d(true);
                d.b.j0.j1.e f2 = i.f(bVar.i, bVar.f18316g, this.f18347a.getCardType(), this.f18347a.getItemId());
                f2.a("obj_id", bVar.f18310a);
                f2.a(TiebaStatic.Params.OBJ_URL, bVar.f18312c);
                f2.c("obj_locate", PlayPicInfoCardView.this.getStatPosition());
                f2.b(this.f18347a);
                v.c(PlayPicInfoCardView.this.m, bVar.f18312c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BannerFlowView.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f18349a;

        public b(PlayPicInfoCard playPicInfoCard) {
            this.f18349a = playPicInfoCard;
        }

        @Override // d.b.j0.j1.o.l.l
        public void a(int i) {
            if (this.f18349a.getDescOnPic() == 1) {
                return;
            }
            PlayPicInfoCardView.this.x.setCount(i);
        }

        @Override // d.b.j0.j1.o.l.l
        public void b(float f2) {
            if (this.f18349a.getDescOnPic() == 1) {
                return;
            }
            PlayPicInfoCardView.this.x.setPosition(f2);
        }

        @Override // com.baidu.tieba.lego.view.BannerFlowView.c
        public void onPageSelected(int i) {
            List<PlayPicInfoCard.b> imageResList = this.f18349a.getImageResList();
            if (imageResList == null || imageResList.size() <= i) {
                return;
            }
            if (this.f18349a.getDescOnPic() != 1) {
                PlayPicInfoCardView.this.w.setVisibility(8);
                if (!TextUtils.isEmpty(imageResList.get(i).f18313d)) {
                    PlayPicInfoCardView.this.v.setText(imageResList.get(i).f18313d);
                    return;
                } else {
                    PlayPicInfoCardView.this.u.setVisibility(8);
                    return;
                }
            }
            if (!TextUtils.isEmpty(imageResList.get(i).f18313d)) {
                PlayPicInfoCardView.this.w.setText(imageResList.get(i).f18313d);
                PlayPicInfoCardView.this.P(imageResList.get(i));
                PlayPicInfoCardView.this.w.setVisibility(0);
            } else {
                PlayPicInfoCardView.this.w.setVisibility(8);
            }
            BannerFlowView bannerFlowView = PlayPicInfoCardView.this.r;
            if (bannerFlowView != null) {
                bannerFlowView.setDescOnPic(true, !TextUtils.isEmpty(imageResList.get(i).f18313d));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard f18351e;

        public c(PlayPicInfoCard playPicInfoCard) {
            this.f18351e = playPicInfoCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f18351e.getImageResList().get(0) != null) {
                v.c(PlayPicInfoCardView.this.m, this.f18351e.getImageResList().get(0).f18312c);
                t.b().d(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard.a f18353e;

        public d(PlayPicInfoCard.a aVar) {
            this.f18353e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f18353e.f18307b)) {
                return;
            }
            v.c(PlayPicInfoCardView.this.m, this.f18353e.f18307b);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PlayPicInfoCard.a f18355e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.j1.o.j.a f18356f;

        public e(PlayPicInfoCard.a aVar, d.b.j0.j1.o.j.a aVar2) {
            this.f18355e = aVar;
            this.f18356f = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(PlayPicInfoCardView.this.m.getPageActivity())) {
                d.b.j0.j1.m.b a2 = d.b.j0.j1.m.b.a();
                d.b.j0.j1.o.j.a aVar = this.f18355e.f18309d;
                a2.d(aVar, aVar.b());
                ((CommonImageButton) view).b(this.f18356f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.b.i0.r.f0.r.d.a {

        /* renamed from: f  reason: collision with root package name */
        public String f18358f;

        /* renamed from: g  reason: collision with root package name */
        public PlayPicInfoCard.b f18359g;

        public f() {
        }

        @Override // d.b.i0.r.f0.r.d.a
        public String a() {
            return this.f18358f;
        }

        @Override // d.b.i0.r.f0.r.d.a
        public Object e() {
            return this.f18359g;
        }

        public void f(PlayPicInfoCard.b bVar) {
            this.f18358f = bVar.f18311b;
            this.f18359g = bVar;
        }
    }

    public PlayPicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    private void setIndicatorViewPosition(PlayPicInfoCard playPicInfoCard) {
        int showDot = playPicInfoCard.getShowDot();
        if (showDot == 0) {
            this.x.setVisibility(8);
        } else if (showDot == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.x.getLayoutParams();
            layoutParams.gravity = 85;
            this.x.setLayoutParams(layoutParams);
            this.x.setVisibility(0);
        } else if (showDot != 2) {
            this.x.setVisibility(8);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.x.getLayoutParams();
            layoutParams2.gravity = 81;
            this.x.setLayoutParams(layoutParams2);
            this.x.setVisibility(0);
        }
    }

    public final void P(PlayPicInfoCard.b bVar) {
        if (bVar == null) {
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0101);
        } else {
            F(this.w, bVar.f18314e, bVar.f18315f, R.color.CAM_X0101);
        }
    }

    public final List<n> Q(PlayPicInfoCard playPicInfoCard) {
        ArrayList arrayList = new ArrayList();
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() != 0) {
            int size = playPicInfoCard.getImageResList().size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.f(playPicInfoCard.getImageResList().get(i));
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    public final void R(TextView textView, TbImageView tbImageView, d.b.j0.j1.o.j.b bVar) {
        String str = w() ? bVar.f57807b : bVar.f57806a;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.W(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(d.b.j0.j1.o.f.a(bVar.f57808c)), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setText(bVar.f57809d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: S */
    public void y(PlayPicInfoCard playPicInfoCard, int i) {
        d.b.i0.s0.a.a(this.m, getRootView());
        SkinManager.setBackgroundResource(this.s, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0105);
        this.x.setSelector(SkinManager.getDrawable(R.drawable.dot_live_s));
        this.x.setDrawable(SkinManager.getDrawable(R.drawable.dot_live_n));
        SkinManager.setViewTextColor(this.A, R.color.CAM_X0111);
        SkinManager.setBackgroundResource(this.A, R.drawable.label_bg_tie_n);
        SkinManager.setViewTextColor(this.C, R.color.CAM_X0110);
        P(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: T */
    public void z(PlayPicInfoCard playPicInfoCard) {
        this.t.setMaxLines(playPicInfoCard.getMaxLineForToptitle());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        if (playPicInfoCard.getRatio() > 0.0d) {
            int ratio = (int) (playPicInfoCard.getRatio() * l.k(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.r.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((l.k(getContext()) * 0.5f) + 0.5f);
            this.r.setLayoutParams(layoutParams);
        }
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
            this.r.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, !TextUtils.isEmpty(playPicInfoCard.getImageResList().get(0).f18313d));
        } else {
            this.r.setDescOnPic(playPicInfoCard.getDescOnPic() == 1, false);
        }
        if (playPicInfoCard.getDuration() >= 5000) {
            this.r.setAutoScrollIntervalTime(playPicInfoCard.getDuration());
        } else {
            this.r.setAutoScrollIntervalTime(5000L);
        }
        this.r.setData(Q(playPicInfoCard));
        if (playPicInfoCard.getDescOnPic() != 1) {
            this.w.setVisibility(8);
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 1) {
                this.v.setMaxWidth(((l.k(getContext()) - l.g(getContext(), R.dimen.ds24)) - l.g(getContext(), R.dimen.ds20)) - (l.g(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                this.v.setText(playPicInfoCard.getImageResList().get(0).f18313d);
                this.x.setVisibility(0);
                this.x.setCount(playPicInfoCard.getImageResList().size());
                setIndicatorViewPosition(playPicInfoCard);
                this.u.setVisibility(0);
                this.t.setVisibility(8);
            } else if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
                if (playPicInfoCard.getDescOnPic() == 2) {
                    this.t.setText(playPicInfoCard.getImageResList().get(0).f18313d);
                    this.t.setVisibility(0);
                    this.u.setVisibility(8);
                } else {
                    this.u.setVisibility(0);
                    this.v.setMaxWidth(l.k(getContext()) - l.g(getContext(), R.dimen.ds24));
                    this.v.setText(playPicInfoCard.getImageResList().get(0).f18313d);
                    this.t.setVisibility(8);
                    this.x.setVisibility(8);
                }
            }
        } else {
            if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() > 0) {
                this.w.setVisibility(0);
                if (playPicInfoCard.getImageResList().size() > 1) {
                    this.w.setMaxWidth(((l.k(getContext()) - l.g(getContext(), R.dimen.ds24)) - l.g(getContext(), R.dimen.ds20)) - (l.g(getContext(), R.dimen.ds24) * playPicInfoCard.getImageResList().size()));
                } else {
                    this.w.setMaxWidth(l.k(getContext()) - l.g(getContext(), R.dimen.ds24));
                }
                this.w.setText(playPicInfoCard.getImageResList().get(0).f18313d);
                P(playPicInfoCard.getImageResList().get(0));
            } else {
                this.w.setVisibility(8);
            }
            this.t.setVisibility(8);
            this.u.setVisibility(8);
        }
        this.r.setOnItemClickListener(new a(playPicInfoCard));
        this.r.setOnPageSelected(new b(playPicInfoCard));
        if (playPicInfoCard.getImageResList() != null && playPicInfoCard.getImageResList().size() == 1) {
            setCardOnClickListener(new c(playPicInfoCard));
        } else {
            setCardOnClickListener(null);
        }
        U(playPicInfoCard);
        V(playPicInfoCard);
        this.r.setIndicatorViewPosition(playPicInfoCard.getShowDot());
    }

    public final void U(PlayPicInfoCard playPicInfoCard) {
        PlayPicInfoCard.a bottomInfo = playPicInfoCard.getBottomInfo();
        if (bottomInfo != null && bottomInfo.b()) {
            this.z.setVisibility(0);
            if (TextUtils.isEmpty(bottomInfo.f18306a)) {
                this.A.setVisibility(8);
            } else {
                this.A.setVisibility(0);
                this.A.setText(bottomInfo.f18306a);
                this.A.setOnClickListener(new d(bottomInfo));
            }
            d.b.j0.j1.o.j.b bVar = bottomInfo.f18308c;
            if (bVar != null) {
                R(this.C, this.B, bVar);
            }
            if (bottomInfo.f18309d != null) {
                this.D.setVisibility(0);
                l.c(this.m.getPageActivity(), this.D, 20, 20, 20, 20);
                d.b.j0.j1.o.j.a aVar = bottomInfo.f18309d;
                this.D.b(aVar);
                this.D.setOnClickListener(new e(bottomInfo, aVar));
                return;
            }
            this.D.setVisibility(8);
            return;
        }
        this.z.setVisibility(8);
    }

    public final void V(PlayPicInfoCard playPicInfoCard) {
        PlayPicInfoCard.c waterMark = playPicInfoCard.getWaterMark();
        if (waterMark == null) {
            this.y.setVisibility(8);
            return;
        }
        this.y.setVisibility(0);
        String str = w() ? waterMark.f18319b : waterMark.f18318a;
        ((RelativeLayout.LayoutParams) this.y.getLayoutParams()).setMargins(l.e(this.m.getPageActivity(), waterMark.f18320c), l.e(this.m.getPageActivity(), waterMark.f18321d), 0, 0);
        this.y.W(str, 10, false);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View v() {
        View inflate = LayoutInflater.from(this.m.getPageActivity()).inflate(R.layout.card_play_pic_info, (ViewGroup) null);
        this.s = inflate;
        this.r = (BannerFlowView) o(inflate, R.id.banner);
        if (this.m.getOrignalPage() instanceof SwipeBackLayout.c) {
            this.r.setSwipeControlInterface((SwipeBackLayout.c) this.m.getOrignalPage());
        }
        this.r.setDisableParentEvent(false);
        this.r.setMaxScrollCountLimit(100);
        this.y = (TbImageView) o(this.s, R.id.float_icon);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams.height = (int) ((l.k(getContext()) * 0.5f) + 0.5f);
        this.r.setLayoutParams(layoutParams);
        this.v = (TextView) o(this.s, R.id.title_bottom);
        this.u = (LinearLayout) o(this.s, R.id.ll_bottom);
        this.w = (TextView) o(this.s, R.id.title_on);
        this.x = (IndicatorView) o(this.s, R.id.indicator);
        this.t = (TextView) o(this.s, R.id.title_top);
        RelativeLayout relativeLayout = (RelativeLayout) o(this.s, R.id.bottom_relative_layout);
        this.z = relativeLayout;
        this.A = (TextView) o(relativeLayout, R.id.forum_name);
        this.B = (TbImageView) o(this.z, R.id.icon);
        this.C = (TextView) o(this.z, R.id.text);
        this.D = (CommonImageButton) o(this.z, R.id.notice_button);
        return this.s;
    }
}
