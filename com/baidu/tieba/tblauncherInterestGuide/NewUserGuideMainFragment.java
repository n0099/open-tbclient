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
    private View ghx;
    private NewUserGuideActivity knF;
    private TbImageView knM;
    private TbImageView knN;
    private TbImageView knO;
    private TbImageView knP;
    private TbImageView knQ;
    private TbImageView knR;
    private TbImageView knS;
    private TbImageView knT;
    private TbImageView knU;
    private TbImageView knV;
    private Button knW;
    private NewUserGuideModel knn;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> knL = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean knX = false;
    private boolean knY = true;
    private final View.OnClickListener dri = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.knW) {
                    if (NewUserGuideMainFragment.this.knF.cNq()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.knF.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.knF.finish();
                }
            } else if (NewUserGuideMainFragment.this.knY) {
                NewUserGuideMainFragment.this.knY = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.knF, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cNx() {
                        NewUserGuideMainFragment.this.ghx.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.ghx.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.knY = true;
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void cNx();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.knX = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.knF = (NewUserGuideActivity) getBaseFragmentActivity();
        this.knn = this.knF.cNs();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.knn != null && !this.knX) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.knF.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.knn.cNz());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.knL.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.ghx = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.knM = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.knN = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.knO = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.knP = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.knQ = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.knR = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.knS = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.knT = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.knU = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.knV = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.knW = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.knL.put(1, this.knM);
            this.knL.put(2, this.knN);
            this.knL.put(3, this.knO);
            this.knL.put(4, this.knP);
            this.knL.put(5, this.knQ);
            this.knL.put(6, this.knR);
            this.knL.put(7, this.knS);
            this.knL.put(8, this.knT);
            this.knL.put(9, this.knU);
            this.knL.put(10, this.knV);
            this.knW.setOnClickListener(this.dri);
            this.knM.setOnClickListener(this.dri);
            this.knN.setOnClickListener(this.dri);
            this.knO.setOnClickListener(this.dri);
            this.knP.setOnClickListener(this.dri);
            this.knQ.setOnClickListener(this.dri);
            this.knR.setOnClickListener(this.dri);
            this.knS.setOnClickListener(this.dri);
            this.knT.setOnClickListener(this.dri);
            this.knU.setOnClickListener(this.dri);
            this.knU.setOnClickListener(this.dri);
            this.knV.setOnClickListener(this.dri);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.knF.cNu();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
