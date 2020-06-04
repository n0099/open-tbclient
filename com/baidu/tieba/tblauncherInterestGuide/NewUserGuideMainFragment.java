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
    private View hgC;
    private TbImageView ltG;
    private TbImageView ltH;
    private TbImageView ltI;
    private TbImageView ltJ;
    private TbImageView ltK;
    private TbImageView ltL;
    private TbImageView ltM;
    private TbImageView ltN;
    private TbImageView ltO;
    private TbImageView ltP;
    private Button ltQ;
    private NewUserGuideModel ltg;
    private NewUserGuideActivity ltz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> ltF = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean ltR = false;
    private boolean ltS = true;
    private final View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.ltQ) {
                    if (NewUserGuideMainFragment.this.ltz.dgj()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.ltz.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.ltz.finish();
                }
            } else if (NewUserGuideMainFragment.this.ltS) {
                NewUserGuideMainFragment.this.ltS = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.ltz, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dgq() {
                        NewUserGuideMainFragment.this.hgC.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.hgC.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.ltS = true;
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void dgq();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.ltR = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ltz = (NewUserGuideActivity) getBaseFragmentActivity();
        this.ltg = this.ltz.dgl();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.ltg != null && !this.ltR) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.ltz.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.ltg.dgs());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.ltF.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.hgC = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.ltG = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.ltH = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.ltI = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.ltJ = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.ltK = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.ltL = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.ltM = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.ltN = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.ltO = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.ltP = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.ltQ = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.ltF.put(1, this.ltG);
            this.ltF.put(2, this.ltH);
            this.ltF.put(3, this.ltI);
            this.ltF.put(4, this.ltJ);
            this.ltF.put(5, this.ltK);
            this.ltF.put(6, this.ltL);
            this.ltF.put(7, this.ltM);
            this.ltF.put(8, this.ltN);
            this.ltF.put(9, this.ltO);
            this.ltF.put(10, this.ltP);
            this.ltQ.setOnClickListener(this.ege);
            this.ltG.setOnClickListener(this.ege);
            this.ltH.setOnClickListener(this.ege);
            this.ltI.setOnClickListener(this.ege);
            this.ltJ.setOnClickListener(this.ege);
            this.ltK.setOnClickListener(this.ege);
            this.ltL.setOnClickListener(this.ege);
            this.ltM.setOnClickListener(this.ege);
            this.ltN.setOnClickListener(this.ege);
            this.ltO.setOnClickListener(this.ege);
            this.ltO.setOnClickListener(this.ege);
            this.ltP.setOnClickListener(this.ege);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.ltz.dgn();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
