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
    private View dAM;
    private TbImageView hvC;
    private TbImageView hvD;
    private TbImageView hvE;
    private TbImageView hvF;
    private TbImageView hvG;
    private TbImageView hvH;
    private TbImageView hvI;
    private TbImageView hvJ;
    private TbImageView hvK;
    private TbImageView hvL;
    private Button hvM;
    private NewUserGuideModel hva;
    private NewUserGuideActivity hvv;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hvB = new Hashtable<>();
    private boolean hvc = false;
    private boolean hvN = false;
    private boolean hvO = true;
    private final View.OnClickListener aTa = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.hvM) {
                    if (NewUserGuideMainFragment.this.hvv.bGH()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.hvv.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.hvc)));
                    NewUserGuideMainFragment.this.hvv.finish();
                }
            } else if (NewUserGuideMainFragment.this.hvO) {
                NewUserGuideMainFragment.this.hvO = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.hvv, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bGP() {
                        NewUserGuideMainFragment.this.dAM.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.dAM.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.hvO = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bGP();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hvN = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hvv = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hva = this.hvv.bGJ();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hva != null && !this.hvN) {
            if (bundle != null) {
                this.hvc = bundle.getBoolean("is_new_user");
            } else {
                this.hvc = this.hvv.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hva.bGR());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hvB.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.dAM = this.mRoot.findViewById(e.g.root_main_view_cover);
            this.hvC = (TbImageView) this.mRoot.findViewById(e.g.icon_1);
            this.hvD = (TbImageView) this.mRoot.findViewById(e.g.icon_2);
            this.hvE = (TbImageView) this.mRoot.findViewById(e.g.icon_3);
            this.hvF = (TbImageView) this.mRoot.findViewById(e.g.icon_4);
            this.hvG = (TbImageView) this.mRoot.findViewById(e.g.icon_5);
            this.hvH = (TbImageView) this.mRoot.findViewById(e.g.icon_6);
            this.hvI = (TbImageView) this.mRoot.findViewById(e.g.icon_7);
            this.hvJ = (TbImageView) this.mRoot.findViewById(e.g.icon_8);
            this.hvK = (TbImageView) this.mRoot.findViewById(e.g.icon_9);
            this.hvL = (TbImageView) this.mRoot.findViewById(e.g.icon_10);
            this.hvM = (Button) this.mRoot.findViewById(e.g.btn_next);
            this.hvB.put(1, this.hvC);
            this.hvB.put(2, this.hvD);
            this.hvB.put(3, this.hvE);
            this.hvB.put(4, this.hvF);
            this.hvB.put(5, this.hvG);
            this.hvB.put(6, this.hvH);
            this.hvB.put(7, this.hvI);
            this.hvB.put(8, this.hvJ);
            this.hvB.put(9, this.hvK);
            this.hvB.put(10, this.hvL);
            this.hvM.setOnClickListener(this.aTa);
            this.hvC.setOnClickListener(this.aTa);
            this.hvD.setOnClickListener(this.aTa);
            this.hvE.setOnClickListener(this.aTa);
            this.hvF.setOnClickListener(this.aTa);
            this.hvG.setOnClickListener(this.aTa);
            this.hvH.setOnClickListener(this.aTa);
            this.hvI.setOnClickListener(this.aTa);
            this.hvJ.setOnClickListener(this.aTa);
            this.hvK.setOnClickListener(this.aTa);
            this.hvK.setOnClickListener(this.aTa);
            this.hvL.setOnClickListener(this.aTa);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hvv.bGL();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
