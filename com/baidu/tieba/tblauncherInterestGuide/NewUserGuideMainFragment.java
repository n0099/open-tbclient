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
    private View dxZ;
    private NewUserGuideModel hrO;
    private Button hsA;
    private NewUserGuideActivity hsj;
    private TbImageView hsq;
    private TbImageView hsr;
    private TbImageView hss;
    private TbImageView hst;
    private TbImageView hsu;
    private TbImageView hsv;
    private TbImageView hsw;
    private TbImageView hsx;
    private TbImageView hsy;
    private TbImageView hsz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hsp = new Hashtable<>();
    private boolean hrQ = false;
    private boolean hsB = false;
    private boolean hsC = true;
    private final View.OnClickListener aSY = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.hsA) {
                    if (NewUserGuideMainFragment.this.hsj.bFR()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.hsj.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.hrQ)));
                    NewUserGuideMainFragment.this.hsj.finish();
                }
            } else if (NewUserGuideMainFragment.this.hsC) {
                NewUserGuideMainFragment.this.hsC = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.hsj, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bFZ() {
                        NewUserGuideMainFragment.this.dxZ.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.dxZ.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.hsC = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bFZ();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hsB = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hsj = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hrO = this.hsj.bFT();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hrO != null && !this.hsB) {
            if (bundle != null) {
                this.hrQ = bundle.getBoolean("is_new_user");
            } else {
                this.hrQ = this.hsj.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hrO.bGb());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hsp.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.dxZ = this.mRoot.findViewById(e.g.root_main_view_cover);
            this.hsq = (TbImageView) this.mRoot.findViewById(e.g.icon_1);
            this.hsr = (TbImageView) this.mRoot.findViewById(e.g.icon_2);
            this.hss = (TbImageView) this.mRoot.findViewById(e.g.icon_3);
            this.hst = (TbImageView) this.mRoot.findViewById(e.g.icon_4);
            this.hsu = (TbImageView) this.mRoot.findViewById(e.g.icon_5);
            this.hsv = (TbImageView) this.mRoot.findViewById(e.g.icon_6);
            this.hsw = (TbImageView) this.mRoot.findViewById(e.g.icon_7);
            this.hsx = (TbImageView) this.mRoot.findViewById(e.g.icon_8);
            this.hsy = (TbImageView) this.mRoot.findViewById(e.g.icon_9);
            this.hsz = (TbImageView) this.mRoot.findViewById(e.g.icon_10);
            this.hsA = (Button) this.mRoot.findViewById(e.g.btn_next);
            this.hsp.put(1, this.hsq);
            this.hsp.put(2, this.hsr);
            this.hsp.put(3, this.hss);
            this.hsp.put(4, this.hst);
            this.hsp.put(5, this.hsu);
            this.hsp.put(6, this.hsv);
            this.hsp.put(7, this.hsw);
            this.hsp.put(8, this.hsx);
            this.hsp.put(9, this.hsy);
            this.hsp.put(10, this.hsz);
            this.hsA.setOnClickListener(this.aSY);
            this.hsq.setOnClickListener(this.aSY);
            this.hsr.setOnClickListener(this.aSY);
            this.hss.setOnClickListener(this.aSY);
            this.hst.setOnClickListener(this.aSY);
            this.hsu.setOnClickListener(this.aSY);
            this.hsv.setOnClickListener(this.aSY);
            this.hsw.setOnClickListener(this.aSY);
            this.hsx.setOnClickListener(this.aSY);
            this.hsy.setOnClickListener(this.aSY);
            this.hsy.setOnClickListener(this.aSY);
            this.hsz.setOnClickListener(this.aSY);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hsj.bFV();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
