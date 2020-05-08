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
    private View gRG;
    private NewUserGuideActivity kZF;
    private TbImageView kZM;
    private TbImageView kZN;
    private TbImageView kZO;
    private TbImageView kZP;
    private TbImageView kZQ;
    private TbImageView kZR;
    private TbImageView kZS;
    private TbImageView kZT;
    private TbImageView kZU;
    private TbImageView kZV;
    private Button kZW;
    private NewUserGuideModel kZn;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> kZL = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean kZX = false;
    private boolean kZY = true;
    private final View.OnClickListener dRK = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.kZW) {
                    if (NewUserGuideMainFragment.this.kZF.cYF()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.kZF.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.kZF.finish();
                }
            } else if (NewUserGuideMainFragment.this.kZY) {
                NewUserGuideMainFragment.this.kZY = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.kZF, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cYM() {
                        NewUserGuideMainFragment.this.gRG.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.gRG.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.kZY = true;
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void cYM();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.kZX = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kZF = (NewUserGuideActivity) getBaseFragmentActivity();
        this.kZn = this.kZF.cYH();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.kZn != null && !this.kZX) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.kZF.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.kZn.cYO());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.kZL.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.gRG = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.kZM = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.kZN = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.kZO = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.kZP = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.kZQ = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.kZR = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.kZS = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.kZT = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.kZU = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.kZV = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.kZW = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.kZL.put(1, this.kZM);
            this.kZL.put(2, this.kZN);
            this.kZL.put(3, this.kZO);
            this.kZL.put(4, this.kZP);
            this.kZL.put(5, this.kZQ);
            this.kZL.put(6, this.kZR);
            this.kZL.put(7, this.kZS);
            this.kZL.put(8, this.kZT);
            this.kZL.put(9, this.kZU);
            this.kZL.put(10, this.kZV);
            this.kZW.setOnClickListener(this.dRK);
            this.kZM.setOnClickListener(this.dRK);
            this.kZN.setOnClickListener(this.dRK);
            this.kZO.setOnClickListener(this.dRK);
            this.kZP.setOnClickListener(this.dRK);
            this.kZQ.setOnClickListener(this.dRK);
            this.kZR.setOnClickListener(this.dRK);
            this.kZS.setOnClickListener(this.dRK);
            this.kZT.setOnClickListener(this.dRK);
            this.kZU.setOnClickListener(this.dRK);
            this.kZU.setOnClickListener(this.dRK);
            this.kZV.setOnClickListener(this.dRK);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.kZF.cYJ();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
