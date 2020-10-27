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
/* loaded from: classes22.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View iur;
    private ViewGroup mRoot;
    private TbImageView mYC;
    private TbImageView mYD;
    private TbImageView mYE;
    private TbImageView mYF;
    private TbImageView mYG;
    private TbImageView mYH;
    private TbImageView mYI;
    private TbImageView mYJ;
    private TbImageView mYK;
    private TbImageView mYL;
    private Button mYM;
    private NewUserGuideModel mYd;
    private NewUserGuideActivity mYv;
    private final Hashtable<Integer, TbImageView> mYB = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean mYN = false;
    private boolean mYO = true;
    private final View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.mYM) {
                    if (NewUserGuideMainFragment.this.mYv.dJX()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.mYv.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.mYv.finish();
                }
            } else if (NewUserGuideMainFragment.this.mYO) {
                NewUserGuideMainFragment.this.mYO = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.mYv, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dKe() {
                        NewUserGuideMainFragment.this.iur.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.iur.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.mYO = true;
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void dKe();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.mYN = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mYv = (NewUserGuideActivity) getBaseFragmentActivity();
        this.mYd = this.mYv.dJZ();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.mYd != null && !this.mYN) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.mYv.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.mYd.dKg());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.mYB.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.iur = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.mYC = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.mYD = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.mYE = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.mYF = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.mYG = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.mYH = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.mYI = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.mYJ = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.mYK = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.mYL = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.mYM = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.mYB.put(1, this.mYC);
            this.mYB.put(2, this.mYD);
            this.mYB.put(3, this.mYE);
            this.mYB.put(4, this.mYF);
            this.mYB.put(5, this.mYG);
            this.mYB.put(6, this.mYH);
            this.mYB.put(7, this.mYI);
            this.mYB.put(8, this.mYJ);
            this.mYB.put(9, this.mYK);
            this.mYB.put(10, this.mYL);
            this.mYM.setOnClickListener(this.fcr);
            this.mYC.setOnClickListener(this.fcr);
            this.mYD.setOnClickListener(this.fcr);
            this.mYE.setOnClickListener(this.fcr);
            this.mYF.setOnClickListener(this.fcr);
            this.mYG.setOnClickListener(this.fcr);
            this.mYH.setOnClickListener(this.fcr);
            this.mYI.setOnClickListener(this.fcr);
            this.mYJ.setOnClickListener(this.fcr);
            this.mYK.setOnClickListener(this.fcr);
            this.mYK.setOnClickListener(this.fcr);
            this.mYL.setOnClickListener(this.fcr);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.mYv.dKb();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
