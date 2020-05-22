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
    private View hgr;
    private NewUserGuideModel lrX;
    private TbImageView lsA;
    private TbImageView lsB;
    private TbImageView lsC;
    private TbImageView lsD;
    private TbImageView lsE;
    private TbImageView lsF;
    private Button lsG;
    private NewUserGuideActivity lsp;
    private TbImageView lsw;
    private TbImageView lsx;
    private TbImageView lsy;
    private TbImageView lsz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> lsv = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean lsH = false;
    private boolean lsI = true;
    private final View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.lsG) {
                    if (NewUserGuideMainFragment.this.lsp.dfU()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.lsp.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.lsp.finish();
                }
            } else if (NewUserGuideMainFragment.this.lsI) {
                NewUserGuideMainFragment.this.lsI = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.lsp, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dgb() {
                        NewUserGuideMainFragment.this.hgr.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.hgr.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.lsI = true;
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void dgb();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.lsH = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lsp = (NewUserGuideActivity) getBaseFragmentActivity();
        this.lrX = this.lsp.dfW();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.lrX != null && !this.lsH) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.lsp.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.lrX.dgd());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.lsv.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.hgr = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.lsw = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.lsx = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.lsy = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.lsz = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.lsA = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.lsB = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.lsC = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.lsD = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.lsE = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.lsF = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.lsG = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.lsv.put(1, this.lsw);
            this.lsv.put(2, this.lsx);
            this.lsv.put(3, this.lsy);
            this.lsv.put(4, this.lsz);
            this.lsv.put(5, this.lsA);
            this.lsv.put(6, this.lsB);
            this.lsv.put(7, this.lsC);
            this.lsv.put(8, this.lsD);
            this.lsv.put(9, this.lsE);
            this.lsv.put(10, this.lsF);
            this.lsG.setOnClickListener(this.ege);
            this.lsw.setOnClickListener(this.ege);
            this.lsx.setOnClickListener(this.ege);
            this.lsy.setOnClickListener(this.ege);
            this.lsz.setOnClickListener(this.ege);
            this.lsA.setOnClickListener(this.ege);
            this.lsB.setOnClickListener(this.ege);
            this.lsC.setOnClickListener(this.ege);
            this.lsD.setOnClickListener(this.ege);
            this.lsE.setOnClickListener(this.ege);
            this.lsE.setOnClickListener(this.ege);
            this.lsF.setOnClickListener(this.ege);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.lsp.dfY();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
