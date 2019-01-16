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
    private View dBv;
    private NewUserGuideActivity hwC;
    private TbImageView hwJ;
    private TbImageView hwK;
    private TbImageView hwL;
    private TbImageView hwM;
    private TbImageView hwN;
    private TbImageView hwO;
    private TbImageView hwP;
    private TbImageView hwQ;
    private TbImageView hwR;
    private TbImageView hwS;
    private Button hwT;
    private NewUserGuideModel hwi;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hwI = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean hwU = false;
    private boolean hwV = true;
    private final View.OnClickListener aTI = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.hwT) {
                    if (NewUserGuideMainFragment.this.hwC.bHq()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.hwC.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.hwC.finish();
                }
            } else if (NewUserGuideMainFragment.this.hwV) {
                NewUserGuideMainFragment.this.hwV = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.hwC, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bHy() {
                        NewUserGuideMainFragment.this.dBv.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.dBv.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.hwV = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bHy();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hwU = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hwC = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hwi = this.hwC.bHs();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hwi != null && !this.hwU) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.hwC.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hwi.bHA());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hwI.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.dBv = this.mRoot.findViewById(e.g.root_main_view_cover);
            this.hwJ = (TbImageView) this.mRoot.findViewById(e.g.icon_1);
            this.hwK = (TbImageView) this.mRoot.findViewById(e.g.icon_2);
            this.hwL = (TbImageView) this.mRoot.findViewById(e.g.icon_3);
            this.hwM = (TbImageView) this.mRoot.findViewById(e.g.icon_4);
            this.hwN = (TbImageView) this.mRoot.findViewById(e.g.icon_5);
            this.hwO = (TbImageView) this.mRoot.findViewById(e.g.icon_6);
            this.hwP = (TbImageView) this.mRoot.findViewById(e.g.icon_7);
            this.hwQ = (TbImageView) this.mRoot.findViewById(e.g.icon_8);
            this.hwR = (TbImageView) this.mRoot.findViewById(e.g.icon_9);
            this.hwS = (TbImageView) this.mRoot.findViewById(e.g.icon_10);
            this.hwT = (Button) this.mRoot.findViewById(e.g.btn_next);
            this.hwI.put(1, this.hwJ);
            this.hwI.put(2, this.hwK);
            this.hwI.put(3, this.hwL);
            this.hwI.put(4, this.hwM);
            this.hwI.put(5, this.hwN);
            this.hwI.put(6, this.hwO);
            this.hwI.put(7, this.hwP);
            this.hwI.put(8, this.hwQ);
            this.hwI.put(9, this.hwR);
            this.hwI.put(10, this.hwS);
            this.hwT.setOnClickListener(this.aTI);
            this.hwJ.setOnClickListener(this.aTI);
            this.hwK.setOnClickListener(this.aTI);
            this.hwL.setOnClickListener(this.aTI);
            this.hwM.setOnClickListener(this.aTI);
            this.hwN.setOnClickListener(this.aTI);
            this.hwO.setOnClickListener(this.aTI);
            this.hwP.setOnClickListener(this.aTI);
            this.hwQ.setOnClickListener(this.aTI);
            this.hwR.setOnClickListener(this.aTI);
            this.hwR.setOnClickListener(this.aTI);
            this.hwS.setOnClickListener(this.aTI);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hwC.bHu();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
