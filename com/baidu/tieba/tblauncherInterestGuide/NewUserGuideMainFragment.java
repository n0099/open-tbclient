package com.baidu.tieba.tblauncherInterestGuide;

import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import d.a.j0.h3.f;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes5.dex */
public class NewUserGuideMainFragment extends BaseFragment {

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f21840f;

    /* renamed from: g  reason: collision with root package name */
    public View f21841g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f21842h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f21843i;
    public TbImageView j;
    public TbImageView k;
    public TbImageView l;
    public TbImageView m;
    public TbImageView n;
    public TbImageView o;
    public TbImageView p;
    public TbImageView q;
    public NewUserGuideActivity r;
    public NewUserGuideModel s;
    public Button t;

    /* renamed from: e  reason: collision with root package name */
    public final Hashtable<Integer, TbImageView> f21839e = new Hashtable<>();
    public boolean u = false;
    public boolean v = false;
    public boolean w = true;
    public final View.OnClickListener x = new a();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0223a implements b {
            public C0223a() {
            }

            @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.b
            public void a() {
                NewUserGuideMainFragment.this.f21841g.setVisibility(8);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.t) {
                    if (NewUserGuideMainFragment.this.r.getIsChanged()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.r.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.u)));
                    NewUserGuideMainFragment.this.r.finish();
                }
            } else if (NewUserGuideMainFragment.this.w) {
                NewUserGuideMainFragment.this.w = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.r, (InterestFrsData.Tag) view.getTag(), new C0223a());
                NewUserGuideMainFragment.this.f21841g.setVisibility(0);
                fVar.d();
                NewUserGuideMainFragment.this.w = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public final void K0(Bundle bundle) {
        if (this.s == null || this.v) {
            return;
        }
        if (bundle != null) {
            this.u = bundle.getBoolean("is_new_user");
        } else {
            this.u = this.r.getIntent().getBooleanExtra("is_new_user", false);
        }
        L0(this.s.u());
    }

    public final void L0(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData == null || (tag_list = interestFrsData.getTag_list()) == null || tag_list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < tag_list.size(); i2++) {
            InterestFrsData.Tag tag = tag_list.get(i2);
            if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.f21839e.get(Integer.valueOf(tag.getBid()))) != null) {
                tbImageView.setTag(tag);
                tbImageView.V(tag.getBicon(), 21, false);
            }
        }
    }

    public void M0(InterestFrsData interestFrsData) {
        L0(interestFrsData);
        this.v = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NewUserGuideActivity newUserGuideActivity = (NewUserGuideActivity) getBaseFragmentActivity();
        this.r = newUserGuideActivity;
        this.s = newUserGuideActivity.getNewUserGuideModel();
        K0(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.f21840f = viewGroup2;
            this.f21841g = viewGroup2.findViewById(R.id.root_main_view_cover);
            this.f21842h = (TbImageView) this.f21840f.findViewById(R.id.icon_1);
            this.f21843i = (TbImageView) this.f21840f.findViewById(R.id.icon_2);
            this.j = (TbImageView) this.f21840f.findViewById(R.id.icon_3);
            this.k = (TbImageView) this.f21840f.findViewById(R.id.icon_4);
            this.l = (TbImageView) this.f21840f.findViewById(R.id.icon_5);
            this.m = (TbImageView) this.f21840f.findViewById(R.id.icon_6);
            this.n = (TbImageView) this.f21840f.findViewById(R.id.icon_7);
            this.o = (TbImageView) this.f21840f.findViewById(R.id.icon_8);
            this.p = (TbImageView) this.f21840f.findViewById(R.id.icon_9);
            this.q = (TbImageView) this.f21840f.findViewById(R.id.icon_10);
            this.t = (Button) this.f21840f.findViewById(R.id.btn_next);
            this.f21839e.put(1, this.f21842h);
            this.f21839e.put(2, this.f21843i);
            this.f21839e.put(3, this.j);
            this.f21839e.put(4, this.k);
            this.f21839e.put(5, this.l);
            this.f21839e.put(6, this.m);
            this.f21839e.put(7, this.n);
            this.f21839e.put(8, this.o);
            this.f21839e.put(9, this.p);
            this.f21839e.put(10, this.q);
            this.t.setOnClickListener(this.x);
            this.f21842h.setOnClickListener(this.x);
            this.f21843i.setOnClickListener(this.x);
            this.j.setOnClickListener(this.x);
            this.k.setOnClickListener(this.x);
            this.l.setOnClickListener(this.x);
            this.m.setOnClickListener(this.x);
            this.n.setOnClickListener(this.x);
            this.o.setOnClickListener(this.x);
            this.p.setOnClickListener(this.x);
            this.p.setOnClickListener(this.x);
            this.q.setOnClickListener(this.x);
            return this.f21840f;
        } catch (InflateException e2) {
            if (!TbadkApplication.getInst().isDebugMode()) {
                BdLog.e(e2);
                this.r.startMainTabEnterFourm();
                TbadkApplication.getInst().onAppMemoryLow();
                return new FrameLayout(layoutInflater.getContext());
            }
            throw e2;
        }
    }
}
