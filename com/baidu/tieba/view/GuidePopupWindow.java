package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.view.GuideScrollView;
import d.a.c.e.p.l;
import d.a.n0.e3.h0.m;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class GuidePopupWindow extends Dialog {
    public TBSpecificationBtn A;
    public GuideScrollView B;
    public View C;
    public HeadBorder D;
    public ForegroundColorSpan E;
    public ForegroundColorSpan F;
    public String G;
    public String H;
    public boolean I;
    public View.OnClickListener J;
    public View.OnClickListener K;
    public View.OnClickListener L;
    public View.OnClickListener M;
    public View.OnClickListener N;
    public View.OnClickListener O;
    public GuideScrollView.a P;

    /* renamed from: e  reason: collision with root package name */
    public Context f21728e;

    /* renamed from: f  reason: collision with root package name */
    public View f21729f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantView f21730g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21731h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21732i;
    public TextView j;
    public TextView k;
    public View l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public RelativeLayout v;
    public RelativeLayout w;
    public RelativeLayout x;
    public RelativeLayout y;
    public TBSpecificationBtn z;

    /* loaded from: classes5.dex */
    public static class HeadBorder extends View {

        /* renamed from: e  reason: collision with root package name */
        public Paint f21733e;

        /* renamed from: f  reason: collision with root package name */
        public int f21734f;

        public HeadBorder(Context context) {
            this(context, null);
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f21734f, this.f21733e);
        }

        public void setBorderColor(int i2) {
            this.f21733e.setColor(i2);
        }

        public void setBorderWidth(float f2) {
            this.f21733e.setStrokeWidth(f2);
        }

        public void setRedio(int i2) {
            this.f21734f = i2;
        }

        public HeadBorder(Context context, @Nullable AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public HeadBorder(Context context, @Nullable AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            Paint paint = new Paint();
            this.f21733e = paint;
            paint.setAntiAlias(true);
            this.f21733e.setStyle(Paint.Style.STROKE);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put(ForumBroadcastHelper.KEY_PARMARS_FORUM_ID, GuidePopupWindow.this.G);
            hashMap.put("forumName", GuidePopupWindow.this.H);
            hashMap.put("obj_source", "5");
            hashMap.put("swipeback", Boolean.FALSE);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.f21728e, "BarBroadcastEdit", hashMap)));
            StatisticItem statisticItem = new StatisticItem("c13887");
            if (d.a.m0.z.b.a() != null && d.a.m0.z.b.a().b() != null) {
                statisticItem.param("uid", d.a.m0.z.b.a().b().getUserId());
            }
            statisticItem.param("fid", GuidePopupWindow.this.G);
            statisticItem.param("obj_locate", 1);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", GuidePopupWindow.this.G);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.f21728e, "RecommendHistoryPage", hashMap)));
            StatisticItem statisticItem = new StatisticItem("c13887");
            if (d.a.m0.z.b.a() != null && d.a.m0.z.b.a().b() != null) {
                statisticItem.param("uid", d.a.m0.z.b.a().b().getUserId());
            }
            statisticItem.param("fid", GuidePopupWindow.this.G);
            statisticItem.param("obj_locate", 4);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", GuidePopupWindow.this.G);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.f21728e, "DataCenterPage", hashMap)));
            StatisticItem statisticItem = new StatisticItem("c13887");
            if (d.a.m0.z.b.a() != null && d.a.m0.z.b.a().b() != null) {
                statisticItem.param("uid", d.a.m0.z.b.a().b().getUserId());
            }
            statisticItem.param("fid", GuidePopupWindow.this.G);
            statisticItem.param("obj_locate", 3);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", GuidePopupWindow.this.G);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.f21728e, "ForumSectionPage", hashMap)));
            StatisticItem statisticItem = new StatisticItem("c13887");
            if (d.a.m0.z.b.a() != null && d.a.m0.z.b.a().b() != null) {
                statisticItem.param("uid", d.a.m0.z.b.a().b().getUserId());
            }
            statisticItem.param("fid", GuidePopupWindow.this.G);
            statisticItem.param("obj_locate", 2);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", GuidePopupWindow.this.G);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.f21728e, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
            StatisticItem statisticItem = new StatisticItem("c13887");
            if (d.a.m0.z.b.a() != null && d.a.m0.z.b.a().b() != null) {
                statisticItem.param("uid", d.a.m0.z.b.a().b().getUserId());
            }
            statisticItem.param("fid", GuidePopupWindow.this.G);
            statisticItem.param("obj_locate", 6);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GuidePopupWindow.this.dismiss();
            StatisticItem statisticItem = new StatisticItem("c13887");
            if (d.a.m0.z.b.a() != null && d.a.m0.z.b.a().b() != null) {
                statisticItem.param("uid", d.a.m0.z.b.a().b().getUserId());
            }
            statisticItem.param("fid", GuidePopupWindow.this.G);
            statisticItem.param("obj_locate", 5);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f21741e;

        public g(List list) {
            this.f21741e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            GuidePopupWindow.this.j.setText(GuidePopupWindow.this.h(this.f21741e));
        }
    }

    /* loaded from: classes5.dex */
    public class h implements GuideScrollView.a {
        public h() {
        }

        @Override // com.baidu.tieba.view.GuideScrollView.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            GuidePopupWindow.this.C.setAlpha(GuidePopupWindow.this.B.getScrollY() / 150.0f);
        }
    }

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.J = new a();
        this.K = new b();
        this.L = new c();
        this.M = new d();
        this.N = new e();
        this.O = new f();
        this.P = new h();
        this.f21728e = context;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.guide_popup_window, (ViewGroup) null);
        this.f21729f = inflate;
        inflate.setSystemUiVisibility(SDKLogTypeConstants.EXPTYPE_LITEINC_INSTALL);
        getWindow().setDimAmount(0.0f);
        i();
        j();
    }

    public final String h(List<String> list) {
        String w = w(list, 0, true);
        if (v(w) < this.j.getWidth()) {
            return w;
        }
        for (int i2 = 5; 1 < i2; i2--) {
            String w2 = w(list, i2, false);
            if (v(w2) < this.j.getWidth()) {
                return w2;
            }
        }
        return null;
    }

    public final void i() {
        GuideScrollView guideScrollView = (GuideScrollView) this.f21729f.findViewById(R.id.guid_popup_window_container);
        this.B = guideScrollView;
        guideScrollView.setScrollChangedListener(this.P);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.f21729f.startAnimation(alphaAnimation);
        HeadPendantView headPendantView = (HeadPendantView) this.f21729f.findViewById(R.id.user_head);
        this.f21730g = headPendantView;
        headPendantView.setHasPendantStyle();
        this.f21730g.setDefalutResid(R.drawable.default_head);
        this.f21730g.getHeadView().setIsRound(true);
        this.f21730g.getHeadView().setDrawBorder(true);
        this.f21730g.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f21730g.setShowSimpleIcon(true);
        this.f21731h = (ImageView) this.f21729f.findViewById(R.id.user_leavel);
        this.f21732i = (TextView) this.f21729f.findViewById(R.id.user_name);
        this.j = (TextView) this.f21729f.findViewById(R.id.user_tb_list);
        this.k = (TextView) this.f21729f.findViewById(R.id.user_tb_concern_info);
        this.l = this.f21729f.findViewById(R.id.guid_popup_window_line);
        this.m = (TextView) this.f21729f.findViewById(R.id.function_desc);
        this.v = (RelativeLayout) this.f21729f.findViewById(R.id.personalba_broadcast);
        this.n = (TextView) this.f21729f.findViewById(R.id.personalba_broadcast_name);
        this.o = (TextView) this.f21729f.findViewById(R.id.personalba_broadcast_digest);
        this.w = (RelativeLayout) this.f21729f.findViewById(R.id.personalba_recommend);
        this.p = (TextView) this.f21729f.findViewById(R.id.personalba_recommend_name);
        this.q = (TextView) this.f21729f.findViewById(R.id.personalba_recommend_digest);
        this.x = (RelativeLayout) this.f21729f.findViewById(R.id.personalba_data);
        this.r = (TextView) this.f21729f.findViewById(R.id.personalba_data_name);
        this.s = (TextView) this.f21729f.findViewById(R.id.personalba_data_digest);
        this.y = (RelativeLayout) this.f21729f.findViewById(R.id.personalba_partition);
        this.t = (TextView) this.f21729f.findViewById(R.id.personalba_partition_name);
        this.u = (TextView) this.f21729f.findViewById(R.id.personalba_partition_digest);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f21729f.findViewById(R.id.btn_go_away);
        this.z = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds42);
        d.a.m0.r.f0.m.c cVar = new d.a.m0.r.f0.m.c();
        cVar.o(R.color.CAM_X0302);
        this.z.setConfig(cVar);
        this.z.setText(this.f21728e.getResources().getString(R.string.guide_popup_window_go_away));
        this.A = (TBSpecificationBtn) this.f21729f.findViewById(R.id.btn_known);
        d.a.m0.r.f0.m.c cVar2 = new d.a.m0.r.f0.m.c();
        cVar2.o(R.color.CAM_X0618);
        this.A.setConfig(cVar2);
        this.A.setTextSize(R.dimen.tbds42);
        this.A.setText(this.f21728e.getResources().getString(R.string.guide_popup_window_known));
        View findViewById = this.f21729f.findViewById(R.id.shadow_top);
        this.C = findViewById;
        findViewById.setAlpha(0.0f);
        HeadBorder headBorder = (HeadBorder) this.f21729f.findViewById(R.id.head_border);
        this.D = headBorder;
        headBorder.setBorderColor(SkinManager.getColor(R.color.CAM_X0614));
        this.D.setBorderWidth(this.f21728e.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.D.setRedio(l.g(this.f21728e, R.dimen.tbds119));
        n();
    }

    public void j() {
        this.E = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302));
        this.F = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302));
        SkinManager.setBackgroundResource(this.f21729f, R.color.CAM_X0609);
        SkinManager.setViewTextColor(this.f21732i, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.l, R.color.CAM_X0616);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.A, R.color.cp_cont_a_alpha20);
        int g2 = l.g(this.f21728e, R.dimen.tbds60);
        TBSpecificationBtn tBSpecificationBtn = this.z;
        int i2 = R.color.CAM_X0611;
        int i3 = R.color.CAM_X0302;
        SkinManager.setBackgroundShapeDrawable(tBSpecificationBtn, g2, i2, i2, i3, i3, 1);
        TBSpecificationBtn tBSpecificationBtn2 = this.A;
        int i4 = R.color.CAM_X0611;
        int i5 = R.color.CAM_X0618;
        SkinManager.setBackgroundShapeDrawable(tBSpecificationBtn2, g2, i4, i4, i5, i5, 1);
    }

    public void k(String str) {
        TextView textView = this.j;
        textView.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void l(List<String> list) {
        if (list == null) {
            return;
        }
        List<String> list2 = null;
        if (list.size() > 3) {
            this.I = true;
            list2 = list.subList(0, 3);
        }
        if (list2 != null) {
            list = list2;
        }
        m(list);
    }

    public final void m(List<String> list) {
        this.j.post(new g(list));
    }

    public final void n() {
        this.v.setOnClickListener(this.J);
        this.w.setOnClickListener(this.K);
        this.x.setOnClickListener(this.L);
        this.y.setOnClickListener(this.M);
        this.z.setOnClickListener(this.N);
        this.A.setOnClickListener(this.O);
    }

    public void o(int i2) {
        this.G = String.valueOf(i2);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f21729f);
        getWindow().setLayout(-1, -1);
        d.a.n0.q3.c.b(1, getWindow().getAttributes(), getWindow());
    }

    public void p(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f21728e.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = StringHelper.numberUniformFormatExtraWithRoundFloat(j).length();
        spannableStringBuilder.append((CharSequence) StringHelper.numberUniformFormatExtraWithRoundFloat(j));
        spannableStringBuilder.append((CharSequence) this.f21728e.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = StringHelper.numberUniformFormatExtraWithRoundFloat(j2).length();
        spannableStringBuilder.append((CharSequence) StringHelper.numberUniformFormatExtraWithRoundFloat(j2));
        spannableStringBuilder.append((CharSequence) this.f21728e.getResources().getString(R.string.guide_popup_window_concern_desc3));
        int i2 = length + 14;
        spannableStringBuilder.setSpan(this.E, 14, i2, 18);
        spannableStringBuilder.setSpan(this.F, i2 + 8, length + 22 + length2, 18);
        this.k.setText(spannableStringBuilder);
    }

    public void q() {
        if (d.a.m0.z.b.a() == null || d.a.m0.z.b.a().b() == null) {
            return;
        }
        this.f21730g.m(d.a.m0.z.b.a().b());
    }

    public void r(UserData userData) {
        if (userData != null) {
            this.f21730g.m(userData);
        }
    }

    public void s(String str) {
        this.f21730g.setIsclearmode(true);
        this.f21731h.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    public void t() {
        if (d.a.m0.z.b.a() == null || d.a.m0.z.b.a().b() == null) {
            return;
        }
        this.f21732i.setText(d.a.m0.z.b.a().b().getName_show());
    }

    public void u(String str) {
        this.H = str;
    }

    public final int v(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.j.getLetterSpacing());
        }
        return ((str.length() - 1) * ((int) (valueOf.floatValue() + 0.5f))) + ((int) (this.j.getPaint().measureText(str) + 0.5f));
    }

    public final String w(List<String> list, int i2, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("认证：");
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str2 = list.get(i3);
            if (z) {
                str = str2 + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner);
            } else if (str2.length() > i2) {
                str = str2.substring(0, i2 - 1) + getContext().getResources().getString(R.string.guide_popup_window_join_field_bars_owner);
            } else {
                str = str2 + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner);
            }
            sb.append(str + "    ");
        }
        if (this.I) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }
}
