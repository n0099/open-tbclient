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
    private View gRA;
    private NewUserGuideActivity kZB;
    private TbImageView kZI;
    private TbImageView kZJ;
    private TbImageView kZK;
    private TbImageView kZL;
    private TbImageView kZM;
    private TbImageView kZN;
    private TbImageView kZO;
    private TbImageView kZP;
    private TbImageView kZQ;
    private TbImageView kZR;
    private Button kZS;
    private NewUserGuideModel kZj;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> kZH = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean kZT = false;
    private boolean kZU = true;
    private final View.OnClickListener dRF = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.kZS) {
                    if (NewUserGuideMainFragment.this.kZB.cYI()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.kZB.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.kZB.finish();
                }
            } else if (NewUserGuideMainFragment.this.kZU) {
                NewUserGuideMainFragment.this.kZU = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.kZB, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cYP() {
                        NewUserGuideMainFragment.this.gRA.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.gRA.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.kZU = true;
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void cYP();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.kZT = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kZB = (NewUserGuideActivity) getBaseFragmentActivity();
        this.kZj = this.kZB.cYK();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.kZj != null && !this.kZT) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.kZB.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.kZj.cYR());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.kZH.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.gRA = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.kZI = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.kZJ = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.kZK = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.kZL = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.kZM = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.kZN = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.kZO = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.kZP = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.kZQ = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.kZR = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.kZS = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.kZH.put(1, this.kZI);
            this.kZH.put(2, this.kZJ);
            this.kZH.put(3, this.kZK);
            this.kZH.put(4, this.kZL);
            this.kZH.put(5, this.kZM);
            this.kZH.put(6, this.kZN);
            this.kZH.put(7, this.kZO);
            this.kZH.put(8, this.kZP);
            this.kZH.put(9, this.kZQ);
            this.kZH.put(10, this.kZR);
            this.kZS.setOnClickListener(this.dRF);
            this.kZI.setOnClickListener(this.dRF);
            this.kZJ.setOnClickListener(this.dRF);
            this.kZK.setOnClickListener(this.dRF);
            this.kZL.setOnClickListener(this.dRF);
            this.kZM.setOnClickListener(this.dRF);
            this.kZN.setOnClickListener(this.dRF);
            this.kZO.setOnClickListener(this.dRF);
            this.kZP.setOnClickListener(this.dRF);
            this.kZQ.setOnClickListener(this.dRF);
            this.kZQ.setOnClickListener(this.dRF);
            this.kZR.setOnClickListener(this.dRF);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.kZB.cYM();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
