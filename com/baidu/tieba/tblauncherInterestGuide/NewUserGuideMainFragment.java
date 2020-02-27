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
    private View ghv;
    private NewUserGuideActivity knD;
    private TbImageView knK;
    private TbImageView knL;
    private TbImageView knM;
    private TbImageView knN;
    private TbImageView knO;
    private TbImageView knP;
    private TbImageView knQ;
    private TbImageView knR;
    private TbImageView knS;
    private TbImageView knT;
    private Button knU;
    private NewUserGuideModel knl;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> knJ = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean knV = false;
    private boolean knW = true;
    private final View.OnClickListener drh = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.knU) {
                    if (NewUserGuideMainFragment.this.knD.cNo()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.knD.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.knD.finish();
                }
            } else if (NewUserGuideMainFragment.this.knW) {
                NewUserGuideMainFragment.this.knW = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.knD, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cNv() {
                        NewUserGuideMainFragment.this.ghv.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.ghv.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.knW = true;
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void cNv();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.knV = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.knD = (NewUserGuideActivity) getBaseFragmentActivity();
        this.knl = this.knD.cNq();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.knl != null && !this.knV) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.knD.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.knl.cNx());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.knJ.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.ghv = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.knK = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.knL = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.knM = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.knN = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.knO = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.knP = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.knQ = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.knR = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.knS = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.knT = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.knU = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.knJ.put(1, this.knK);
            this.knJ.put(2, this.knL);
            this.knJ.put(3, this.knM);
            this.knJ.put(4, this.knN);
            this.knJ.put(5, this.knO);
            this.knJ.put(6, this.knP);
            this.knJ.put(7, this.knQ);
            this.knJ.put(8, this.knR);
            this.knJ.put(9, this.knS);
            this.knJ.put(10, this.knT);
            this.knU.setOnClickListener(this.drh);
            this.knK.setOnClickListener(this.drh);
            this.knL.setOnClickListener(this.drh);
            this.knM.setOnClickListener(this.drh);
            this.knN.setOnClickListener(this.drh);
            this.knO.setOnClickListener(this.drh);
            this.knP.setOnClickListener(this.drh);
            this.knQ.setOnClickListener(this.drh);
            this.knR.setOnClickListener(this.drh);
            this.knS.setOnClickListener(this.drh);
            this.knS.setOnClickListener(this.drh);
            this.knT.setOnClickListener(this.drh);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.knD.cNs();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
