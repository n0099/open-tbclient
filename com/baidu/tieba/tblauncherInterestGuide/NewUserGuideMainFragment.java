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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes9.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View git;
    private TbImageView kpC;
    private TbImageView kpD;
    private TbImageView kpE;
    private TbImageView kpF;
    private TbImageView kpG;
    private TbImageView kpH;
    private TbImageView kpI;
    private TbImageView kpJ;
    private TbImageView kpK;
    private TbImageView kpL;
    private Button kpM;
    private NewUserGuideModel kpd;
    private NewUserGuideActivity kpv;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> kpB = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean kpN = false;
    private boolean kpO = true;
    private final View.OnClickListener drJ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.kpM) {
                    if (NewUserGuideMainFragment.this.kpv.cNL()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.kpv.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.kpv.finish();
                }
            } else if (NewUserGuideMainFragment.this.kpO) {
                NewUserGuideMainFragment.this.kpO = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.kpv, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cNS() {
                        NewUserGuideMainFragment.this.git.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.git.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.kpO = true;
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void cNS();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.kpN = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kpv = (NewUserGuideActivity) getBaseFragmentActivity();
        this.kpd = this.kpv.cNN();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.kpd != null && !this.kpN) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.kpv.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.kpd.cNU());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.kpB.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.git = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.kpC = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.kpD = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.kpE = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.kpF = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.kpG = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.kpH = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.kpI = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.kpJ = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.kpK = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.kpL = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.kpM = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.kpB.put(1, this.kpC);
            this.kpB.put(2, this.kpD);
            this.kpB.put(3, this.kpE);
            this.kpB.put(4, this.kpF);
            this.kpB.put(5, this.kpG);
            this.kpB.put(6, this.kpH);
            this.kpB.put(7, this.kpI);
            this.kpB.put(8, this.kpJ);
            this.kpB.put(9, this.kpK);
            this.kpB.put(10, this.kpL);
            this.kpM.setOnClickListener(this.drJ);
            this.kpC.setOnClickListener(this.drJ);
            this.kpD.setOnClickListener(this.drJ);
            this.kpE.setOnClickListener(this.drJ);
            this.kpF.setOnClickListener(this.drJ);
            this.kpG.setOnClickListener(this.drJ);
            this.kpH.setOnClickListener(this.drJ);
            this.kpI.setOnClickListener(this.drJ);
            this.kpJ.setOnClickListener(this.drJ);
            this.kpK.setOnClickListener(this.drJ);
            this.kpK.setOnClickListener(this.drJ);
            this.kpL.setOnClickListener(this.drJ);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.kpv.cNP();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
