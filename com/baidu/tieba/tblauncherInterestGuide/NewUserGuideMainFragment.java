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
    private View dBw;
    private NewUserGuideActivity hwD;
    private TbImageView hwK;
    private TbImageView hwL;
    private TbImageView hwM;
    private TbImageView hwN;
    private TbImageView hwO;
    private TbImageView hwP;
    private TbImageView hwQ;
    private TbImageView hwR;
    private TbImageView hwS;
    private TbImageView hwT;
    private Button hwU;
    private NewUserGuideModel hwj;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hwJ = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean hwV = false;
    private boolean hwW = true;
    private final View.OnClickListener aTJ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.hwU) {
                    if (NewUserGuideMainFragment.this.hwD.bHq()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.hwD.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.hwD.finish();
                }
            } else if (NewUserGuideMainFragment.this.hwW) {
                NewUserGuideMainFragment.this.hwW = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.hwD, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bHy() {
                        NewUserGuideMainFragment.this.dBw.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.dBw.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.hwW = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bHy();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hwV = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hwD = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hwj = this.hwD.bHs();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hwj != null && !this.hwV) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.hwD.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hwj.bHA());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hwJ.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.dBw = this.mRoot.findViewById(e.g.root_main_view_cover);
            this.hwK = (TbImageView) this.mRoot.findViewById(e.g.icon_1);
            this.hwL = (TbImageView) this.mRoot.findViewById(e.g.icon_2);
            this.hwM = (TbImageView) this.mRoot.findViewById(e.g.icon_3);
            this.hwN = (TbImageView) this.mRoot.findViewById(e.g.icon_4);
            this.hwO = (TbImageView) this.mRoot.findViewById(e.g.icon_5);
            this.hwP = (TbImageView) this.mRoot.findViewById(e.g.icon_6);
            this.hwQ = (TbImageView) this.mRoot.findViewById(e.g.icon_7);
            this.hwR = (TbImageView) this.mRoot.findViewById(e.g.icon_8);
            this.hwS = (TbImageView) this.mRoot.findViewById(e.g.icon_9);
            this.hwT = (TbImageView) this.mRoot.findViewById(e.g.icon_10);
            this.hwU = (Button) this.mRoot.findViewById(e.g.btn_next);
            this.hwJ.put(1, this.hwK);
            this.hwJ.put(2, this.hwL);
            this.hwJ.put(3, this.hwM);
            this.hwJ.put(4, this.hwN);
            this.hwJ.put(5, this.hwO);
            this.hwJ.put(6, this.hwP);
            this.hwJ.put(7, this.hwQ);
            this.hwJ.put(8, this.hwR);
            this.hwJ.put(9, this.hwS);
            this.hwJ.put(10, this.hwT);
            this.hwU.setOnClickListener(this.aTJ);
            this.hwK.setOnClickListener(this.aTJ);
            this.hwL.setOnClickListener(this.aTJ);
            this.hwM.setOnClickListener(this.aTJ);
            this.hwN.setOnClickListener(this.aTJ);
            this.hwO.setOnClickListener(this.aTJ);
            this.hwP.setOnClickListener(this.aTJ);
            this.hwQ.setOnClickListener(this.aTJ);
            this.hwR.setOnClickListener(this.aTJ);
            this.hwS.setOnClickListener(this.aTJ);
            this.hwS.setOnClickListener(this.aTJ);
            this.hwT.setOnClickListener(this.aTJ);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hwD.bHu();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
