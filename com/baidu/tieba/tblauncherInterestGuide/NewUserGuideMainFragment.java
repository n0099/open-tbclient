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
import com.baidu.tieba.e;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes3.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View drz;
    private NewUserGuideModel hkC;
    private NewUserGuideActivity hkX;
    private TbImageView hle;
    private TbImageView hlf;
    private TbImageView hlg;
    private TbImageView hlh;
    private TbImageView hli;
    private TbImageView hlj;
    private TbImageView hlk;
    private TbImageView hll;
    private TbImageView hlm;
    private TbImageView hln;
    private Button hlo;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hld = new Hashtable<>();
    private boolean hkE = false;
    private boolean hlp = false;
    private boolean hlq = true;
    private final View.OnClickListener aPz = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.hlo) {
                    if (NewUserGuideMainFragment.this.hkX.bDO()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.hkX.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.hkE)));
                    NewUserGuideMainFragment.this.hkX.finish();
                }
            } else if (NewUserGuideMainFragment.this.hlq) {
                NewUserGuideMainFragment.this.hlq = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.hkX, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bDW() {
                        NewUserGuideMainFragment.this.drz.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.drz.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.hlq = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bDW();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hlp = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hkX = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hkC = this.hkX.bDQ();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hkC != null && !this.hlp) {
            if (bundle != null) {
                this.hkE = bundle.getBoolean("is_new_user");
            } else {
                this.hkE = this.hkX.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hkC.bDY());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hld.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(e.h.guide_main, (ViewGroup) null);
            this.drz = this.mRoot.findViewById(e.g.root_main_view_cover);
            this.hle = (TbImageView) this.mRoot.findViewById(e.g.icon_1);
            this.hlf = (TbImageView) this.mRoot.findViewById(e.g.icon_2);
            this.hlg = (TbImageView) this.mRoot.findViewById(e.g.icon_3);
            this.hlh = (TbImageView) this.mRoot.findViewById(e.g.icon_4);
            this.hli = (TbImageView) this.mRoot.findViewById(e.g.icon_5);
            this.hlj = (TbImageView) this.mRoot.findViewById(e.g.icon_6);
            this.hlk = (TbImageView) this.mRoot.findViewById(e.g.icon_7);
            this.hll = (TbImageView) this.mRoot.findViewById(e.g.icon_8);
            this.hlm = (TbImageView) this.mRoot.findViewById(e.g.icon_9);
            this.hln = (TbImageView) this.mRoot.findViewById(e.g.icon_10);
            this.hlo = (Button) this.mRoot.findViewById(e.g.btn_next);
            this.hld.put(1, this.hle);
            this.hld.put(2, this.hlf);
            this.hld.put(3, this.hlg);
            this.hld.put(4, this.hlh);
            this.hld.put(5, this.hli);
            this.hld.put(6, this.hlj);
            this.hld.put(7, this.hlk);
            this.hld.put(8, this.hll);
            this.hld.put(9, this.hlm);
            this.hld.put(10, this.hln);
            this.hlo.setOnClickListener(this.aPz);
            this.hle.setOnClickListener(this.aPz);
            this.hlf.setOnClickListener(this.aPz);
            this.hlg.setOnClickListener(this.aPz);
            this.hlh.setOnClickListener(this.aPz);
            this.hli.setOnClickListener(this.aPz);
            this.hlj.setOnClickListener(this.aPz);
            this.hlk.setOnClickListener(this.aPz);
            this.hll.setOnClickListener(this.aPz);
            this.hlm.setOnClickListener(this.aPz);
            this.hlm.setOnClickListener(this.aPz);
            this.hln.setOnClickListener(this.aPz);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hkX.bDS();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
