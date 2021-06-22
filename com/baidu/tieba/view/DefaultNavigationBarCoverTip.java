package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
import d.a.n0.m.g;
/* loaded from: classes5.dex */
public class DefaultNavigationBarCoverTip extends NavigationBarCoverTip {
    public Activity l;
    public View m;
    public String n;
    public View.OnClickListener o;
    public final g p;
    public NavigationBarCoverTip.e q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> tbPageContext;
            DefaultNavigationBarCoverTip.this.e();
            if (DefaultNavigationBarCoverTip.this.l == null || TextUtils.isEmpty(DefaultNavigationBarCoverTip.this.n) || (tbPageContext = UtilHelper.getTbPageContext(DefaultNavigationBarCoverTip.this.l)) == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{DefaultNavigationBarCoverTip.this.n});
        }
    }

    /* loaded from: classes5.dex */
    public class b extends g {
        public b() {
        }

        @Override // d.a.n0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity == DefaultNavigationBarCoverTip.this.l) {
                DefaultNavigationBarCoverTip.this.setCoverTipListener(null);
                DefaultNavigationBarCoverTip.this.r();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements NavigationBarCoverTip.e {
        public c() {
        }

        @Override // com.baidu.tieba.view.NavigationBarCoverTip.e
        public void a() {
            DefaultNavigationBarCoverTip.this.r();
        }

        @Override // com.baidu.tieba.view.NavigationBarCoverTip.e
        public void onShow() {
        }
    }

    public DefaultNavigationBarCoverTip(Activity activity) {
        super(activity);
        this.o = new a();
        this.p = new b();
        this.q = new c();
        this.l = activity;
        t();
        setCoverTipListener(this.q);
    }

    public static DefaultNavigationBarCoverTip s(Activity activity, String str, String str2) {
        if (activity == null) {
            activity = TbadkCoreApplication.getInst().getCurrentActivity();
        }
        DefaultNavigationBarCoverTip defaultNavigationBarCoverTip = new DefaultNavigationBarCoverTip(activity);
        defaultNavigationBarCoverTip.q(str, str2);
        return defaultNavigationBarCoverTip;
    }

    public final DefaultNavigationBarCoverTip q(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        Context context = getContext();
        this.n = str2;
        View inflate = View.inflate(context, R.layout.write_thread_share_guide, null);
        this.m = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.m.findViewById(R.id.share_icon);
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        d.a.n0.r.f0.m.c cVar = new d.a.n0.r.f0.m.c();
        cVar.r();
        tBSpecificationBtn.setConfig(cVar);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(str);
        tBSpecificationBtn.setOnClickListener(this.o);
        if (TextUtils.isEmpty(str2)) {
            tBSpecificationBtn.setVisibility(8);
        } else {
            tBSpecificationBtn.setVisibility(0);
            tBSpecificationBtn.setText(context.getString(R.string.jump_link));
        }
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
        tBSpecificationBtn.k();
        SkinManager.setBackgroundColor(this, R.color.CAM_X0302);
        return this;
    }

    public final void r() {
        i();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    public final void t() {
        try {
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.p);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void u() {
        ViewGroup viewGroup;
        Activity activity = this.l;
        if (activity == null || this.m == null || (viewGroup = (ViewGroup) activity.findViewById(16908290)) == null) {
            return;
        }
        viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -2));
        l(this.l, this.m);
    }
}
