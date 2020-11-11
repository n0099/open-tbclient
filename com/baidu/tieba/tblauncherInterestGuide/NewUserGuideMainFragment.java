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
    private View iAo;
    private ViewGroup mRoot;
    private NewUserGuideModel ndY;
    private TbImageView neA;
    private TbImageView neB;
    private TbImageView neC;
    private TbImageView neD;
    private TbImageView neE;
    private TbImageView neF;
    private TbImageView neG;
    private TbImageView neH;
    private Button neI;
    private NewUserGuideActivity neq;
    private TbImageView ney;
    private TbImageView nez;
    private final Hashtable<Integer, TbImageView> nex = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean neJ = false;
    private boolean neK = true;
    private final View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.neI) {
                    if (NewUserGuideMainFragment.this.neq.dMz()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.neq.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.neq.finish();
                }
            } else if (NewUserGuideMainFragment.this.neK) {
                NewUserGuideMainFragment.this.neK = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.neq, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dMG() {
                        NewUserGuideMainFragment.this.iAo.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.iAo.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.neK = true;
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void dMG();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.neJ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.neq = (NewUserGuideActivity) getBaseFragmentActivity();
        this.ndY = this.neq.dMB();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.ndY != null && !this.neJ) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.neq.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.ndY.dMI());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.nex.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.iAo = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.ney = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.nez = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.neA = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.neB = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.neC = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.neD = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.neE = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.neF = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.neG = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.neH = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.neI = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.nex.put(1, this.ney);
            this.nex.put(2, this.nez);
            this.nex.put(3, this.neA);
            this.nex.put(4, this.neB);
            this.nex.put(5, this.neC);
            this.nex.put(6, this.neD);
            this.nex.put(7, this.neE);
            this.nex.put(8, this.neF);
            this.nex.put(9, this.neG);
            this.nex.put(10, this.neH);
            this.neI.setOnClickListener(this.fii);
            this.ney.setOnClickListener(this.fii);
            this.nez.setOnClickListener(this.fii);
            this.neA.setOnClickListener(this.fii);
            this.neB.setOnClickListener(this.fii);
            this.neC.setOnClickListener(this.fii);
            this.neD.setOnClickListener(this.fii);
            this.neE.setOnClickListener(this.fii);
            this.neF.setOnClickListener(this.fii);
            this.neG.setOnClickListener(this.fii);
            this.neG.setOnClickListener(this.fii);
            this.neH.setOnClickListener(this.fii);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.neq.dMD();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
