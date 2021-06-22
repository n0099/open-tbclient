package com.baidu.tieba.write.editor;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
import com.baidu.tieba.write.write.TransmitPostEditActivity;
import d.a.c.e.p.l;
import d.a.n0.r.s.a;
import d.a.n0.w.n;
import d.a.o0.w3.m.a;
/* loaded from: classes5.dex */
public class EditorInfoContainer extends RelativeLayout implements n {

    /* renamed from: e  reason: collision with root package name */
    public LocationInfoView f22004e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f22005f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f22006g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f22007h;

    /* renamed from: i  reason: collision with root package name */
    public int f22008i;
    public boolean j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AnimatorSet f22009e;

        public a(AnimatorSet animatorSet) {
            this.f22009e = animatorSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((d.a.n0.r.f0.m.b) EditorInfoContainer.this.f22006g.getStyleConfig()).q(R.color.CAM_X0302);
            EditorInfoContainer.this.f22006g.getStyleConfig().h(R.color.CAM_X0302);
            ((d.a.n0.r.f0.m.b) EditorInfoContainer.this.f22004e.getLocationBtn().getStyleConfig()).q(R.color.CAM_X0302);
            EditorInfoContainer.this.f22004e.getLocationBtn().getStyleConfig().h(R.color.CAM_X0302);
            this.f22009e.start();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public int f22011e = 0;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AnimatorSet f22012f;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((d.a.n0.r.f0.m.b) EditorInfoContainer.this.f22006g.getStyleConfig()).r(R.color.CAM_X0105);
                EditorInfoContainer.this.f22006g.getStyleConfig().h(R.color.CAM_X0110);
                ((d.a.n0.r.f0.m.b) EditorInfoContainer.this.f22004e.getLocationBtn().getStyleConfig()).r(R.color.CAM_X0105);
                EditorInfoContainer.this.f22004e.getLocationBtn().getStyleConfig().h(R.color.CAM_X0110);
            }
        }

        /* renamed from: com.baidu.tieba.write.editor.EditorInfoContainer$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0222b implements Runnable {
            public RunnableC0222b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f22012f.start();
            }
        }

        public b(AnimatorSet animatorSet) {
            this.f22012f = animatorSet;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i2 = this.f22011e + 1;
            this.f22011e = i2;
            if (i2 > 1) {
                EditorInfoContainer.this.postDelayed(new a(), 0L);
            } else {
                EditorInfoContainer.this.postDelayed(new RunnableC0222b(), 1500L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f22016e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f22017f;

        public c(i iVar, d.a.n0.r.s.a aVar) {
            this.f22016e = iVar;
            this.f22017f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f22016e != null) {
                TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 2));
                this.f22016e.a(true);
            }
            this.f22017f.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f22019e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f22020f;

        public d(i iVar, d.a.n0.r.s.a aVar) {
            this.f22019e = iVar;
            this.f22020f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f22019e != null) {
                TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 1));
                this.f22019e.a(false);
            }
            this.f22020f.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements LocationInfoView.a {
        public e() {
        }

        @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
        public void a() {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 3));
            EditorInfoContainer.this.d(new d.a.n0.w.a(18, -1, null));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditorInfoContainer.this.d(new d.a.n0.w.a(43, -1, null));
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f22024e;

        /* loaded from: classes5.dex */
        public class a implements i {
            public a() {
            }

            @Override // com.baidu.tieba.write.editor.EditorInfoContainer.i
            public void a(boolean z) {
                if (TransmitPostEditActivity.FROM_SHARE_WRITE.equals(EditorInfoContainer.this.l)) {
                    if (!"1".equals(EditorInfoContainer.this.k)) {
                        if ("2".equals(EditorInfoContainer.this.k)) {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 5));
                        }
                    } else {
                        TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 6));
                    }
                }
                if (z) {
                    int i2 = ((Integer) EditorInfoContainer.this.f22005f.f12617e).intValue() == 0 ? 1 : 0;
                    EditorInfoContainer.this.x(i2);
                    if ("2".equals(EditorInfoContainer.this.k)) {
                        d.a.o0.w3.m.a.b(EditorInfoContainer.this.m, i2);
                    }
                }
            }
        }

        public g(Context context) {
            this.f22024e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", ((Integer) EditorInfoContainer.this.f22005f.f12617e).intValue() == 0 ? 11 : 12));
            EditorInfoContainer editorInfoContainer = EditorInfoContainer.this;
            editorInfoContainer.w(this.f22024e, ((Integer) editorInfoContainer.f22005f.f12617e).intValue(), new a());
        }
    }

    /* loaded from: classes5.dex */
    public class h implements a.c {
        public h() {
        }

        @Override // d.a.o0.w3.m.a.c
        public void a(int i2) {
            EditorInfoContainer.this.x(i2);
        }
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a(boolean z);
    }

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    @Override // d.a.n0.w.n
    public void b() {
        if (this.j) {
            this.j = false;
            d(new d.a.n0.w.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // d.a.n0.w.n
    public void d(d.a.n0.w.a aVar) {
        EditorTools editorTools = this.f22007h;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.n0.w.n
    public int getToolId() {
        return this.f22008i;
    }

    @Override // d.a.n0.w.n
    public void hide() {
        l();
        setVisibility(8);
    }

    @Override // d.a.n0.w.n
    public void init() {
    }

    public void l() {
    }

    public void m() {
    }

    public final void n(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds62));
        layoutParams.addRule(1, R.id.editor_id_location);
        d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
        bVar.o(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.h(R.color.CAM_X0110);
        bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.l(l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_W_X004));
        bVar.m(l.g(getContext(), R.dimen.M_H_X002));
        bVar.i(R.drawable.ic_icon_pure_post_topic12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
        this.f22006g = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(bVar);
        this.f22006g.setTextSize(R.dimen.T_X09);
        this.f22006g.setText(getContext().getString(R.string.add_topic));
        this.f22006g.setOnClickListener(new f());
        addView(this.f22006g, layoutParams);
    }

    public final void o(Context context) {
        LocationInfoView locationInfoView = new LocationInfoView(context);
        this.f22004e = locationInfoView;
        locationInfoView.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        this.f22004e.setLocationClickListener(new e());
        addView(this.f22004e, layoutParams);
    }

    @Override // d.a.n0.w.b
    public void onAction(d.a.n0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f54625a;
        if (i2 == 19) {
            LocationInfoView locationInfoView = this.f22004e;
            if (locationInfoView == null) {
                return;
            }
            Object obj = aVar.f54627c;
            if (obj instanceof d.a.n0.w.u.a) {
                d.a.n0.w.u.a aVar2 = (d.a.n0.w.u.a) obj;
                locationInfoView.setState(aVar2.f54651a, aVar2.f54652b);
                return;
            }
            locationInfoView.setState(0, null);
        } else if (i2 == 20) {
            LocationInfoView locationInfoView2 = this.f22004e;
            if (locationInfoView2 == null) {
                return;
            }
            locationInfoView2.setState(0, null);
        } else if (i2 == 54) {
            d(new d.a.n0.w.a(55, -1, Boolean.valueOf(t())));
        } else if (i2 != 57) {
        } else {
            d(new d.a.n0.w.a(58, -1, Boolean.FALSE));
        }
    }

    @Override // d.a.n0.w.n
    public void onChangeSkinType(int i2) {
        LocationInfoView locationInfoView = this.f22004e;
        if (locationInfoView != null) {
            locationInfoView.b(i2);
        }
        TBSpecificationBtn tBSpecificationBtn = this.f22005f;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.k();
        }
        TBSpecificationBtn tBSpecificationBtn2 = this.f22006g;
        if (tBSpecificationBtn2 != null) {
            tBSpecificationBtn2.k();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public final void p(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds62));
        layoutParams.addRule(11);
        d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
        bVar.o(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.h(R.color.CAM_X0302);
        bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.l(l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_W_X004));
        bVar.m(l.g(getContext(), R.dimen.M_H_X002));
        bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
        this.f22005f = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(bVar);
        this.f22005f.setTextSize(R.dimen.T_X09);
        x(0);
        this.f22005f.setLayoutParams(layoutParams);
        this.f22005f.setOnClickListener(new g(context));
        addView(this.f22005f);
    }

    public void q(String str, int i2) {
        if ("2".equals(this.k)) {
            this.m = str;
            d.a.o0.w3.m.a.a(str, i2, new h());
        }
    }

    public void r(int i2) {
        if ("2".equals(this.k)) {
            x(i2);
        }
    }

    public void s(boolean z) {
    }

    @Override // d.a.n0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f22007h = editorTools;
    }

    public void setFrom(String str) {
        this.l = str;
    }

    @Override // d.a.n0.w.n
    public void setToolId(int i2) {
        this.f22008i = i2;
    }

    public boolean t() {
        TBSpecificationBtn tBSpecificationBtn;
        TBSpecificationBtn tBSpecificationBtn2 = this.f22005f;
        return (tBSpecificationBtn2 == null || ((Integer) tBSpecificationBtn2.f12617e).intValue() != 0) && (tBSpecificationBtn = this.f22005f) != null && ((Integer) tBSpecificationBtn.f12617e).intValue() == 1;
    }

    public void u(long j) {
        int left = this.f22004e.getLeft() + 10;
        float f2 = left + 10;
        float f3 = left - 10;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22004e, "translationX", f2, f3, f2, f3);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f22006g, "translationX", f2, f3, f2, f3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat2, ofFloat);
        animatorSet.setDuration(j / 4);
        postDelayed(new a(animatorSet), 1000L);
        animatorSet.addListener(new b(animatorSet));
    }

    public void v(boolean z) {
        TBSpecificationBtn tBSpecificationBtn = this.f22006g;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setVisibility(z ? 0 : 8);
        }
    }

    public final void w(Context context, int i2, i iVar) {
        boolean g2 = d.a.n0.r.d0.b.j().g("show_privacy_dialog", false);
        if (i2 == 1 || g2) {
            if (iVar != null) {
                iVar.a(true);
                return;
            }
            return;
        }
        d.a.n0.r.d0.b.j().t("show_privacy_dialog", true);
        BaseActivity baseActivity = (BaseActivity) context;
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(baseActivity);
        aVar.setCancelable(false);
        aVar.setPositiveButton((String) null, (a.e) null);
        aVar.setNegativeButton((String) null, (a.e) null);
        aVar.setContentViewSize(6);
        CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
        customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.write_privacy_dialog_title));
        customPrivacyDialogView.setMessageTextViewColor(SkinManager.getColor(R.color.CAM_X0107));
        customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.write_privacy_dialog_close));
        customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.write_privacy_dialog_open));
        customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new c(iVar, aVar));
        customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new d(iVar, aVar));
        aVar.setContentView(customPrivacyDialogView);
        aVar.create(baseActivity.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c13804"));
    }

    public final void x(int i2) {
        this.f22005f.setText(getResources().getString(R.string.public_to_all));
        this.f22005f.getStyleConfig().i(i2 == 0 ? R.drawable.icon_pure_post_chosen12 : R.drawable.icon_pure_post_chose12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.f22005f.getStyleConfig().h(i2 == 0 ? R.color.CAM_X0302 : R.color.CAM_X0110);
        this.f22005f.f12617e = Integer.valueOf(i2);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(R.dimen.M_H_X004), 0, (int) context.getResources().getDimension(R.dimen.M_H_X003));
        setGravity(16);
        this.k = str;
        o(context);
        n(context);
        p(context);
    }
}
