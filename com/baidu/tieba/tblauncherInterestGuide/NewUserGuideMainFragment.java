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
/* loaded from: classes21.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View iBd;
    private ViewGroup mRoot;
    private TbImageView nfA;
    private TbImageView nfB;
    private TbImageView nfC;
    private TbImageView nfD;
    private TbImageView nfE;
    private TbImageView nfF;
    private TbImageView nfG;
    private TbImageView nfH;
    private TbImageView nfI;
    private Button nfJ;
    private NewUserGuideModel nfa;
    private NewUserGuideActivity nfs;
    private TbImageView nfz;
    private final Hashtable<Integer, TbImageView> nfy = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean nfK = false;
    private boolean nfL = true;
    private final View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.nfJ) {
                    if (NewUserGuideMainFragment.this.nfs.dMy()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.nfs.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.nfs.finish();
                }
            } else if (NewUserGuideMainFragment.this.nfL) {
                NewUserGuideMainFragment.this.nfL = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.nfs, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dMF() {
                        NewUserGuideMainFragment.this.iBd.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.iBd.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.nfL = true;
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void dMF();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.nfK = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nfs = (NewUserGuideActivity) getBaseFragmentActivity();
        this.nfa = this.nfs.dMA();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.nfa != null && !this.nfK) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.nfs.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.nfa.dMH());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.nfy.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.iBd = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.nfz = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.nfA = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.nfB = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.nfC = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.nfD = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.nfE = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.nfF = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.nfG = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.nfH = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.nfI = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.nfJ = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.nfy.put(1, this.nfz);
            this.nfy.put(2, this.nfA);
            this.nfy.put(3, this.nfB);
            this.nfy.put(4, this.nfC);
            this.nfy.put(5, this.nfD);
            this.nfy.put(6, this.nfE);
            this.nfy.put(7, this.nfF);
            this.nfy.put(8, this.nfG);
            this.nfy.put(9, this.nfH);
            this.nfy.put(10, this.nfI);
            this.nfJ.setOnClickListener(this.fhp);
            this.nfz.setOnClickListener(this.fhp);
            this.nfA.setOnClickListener(this.fhp);
            this.nfB.setOnClickListener(this.fhp);
            this.nfC.setOnClickListener(this.fhp);
            this.nfD.setOnClickListener(this.fhp);
            this.nfE.setOnClickListener(this.fhp);
            this.nfF.setOnClickListener(this.fhp);
            this.nfG.setOnClickListener(this.fhp);
            this.nfH.setOnClickListener(this.fhp);
            this.nfH.setOnClickListener(this.fhp);
            this.nfI.setOnClickListener(this.fhp);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.nfs.dMC();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
