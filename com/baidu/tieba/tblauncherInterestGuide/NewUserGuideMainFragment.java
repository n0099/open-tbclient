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
/* loaded from: classes7.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View gfv;
    private NewUserGuideActivity kmG;
    private TbImageView kmN;
    private TbImageView kmO;
    private TbImageView kmP;
    private TbImageView kmQ;
    private TbImageView kmR;
    private TbImageView kmS;
    private TbImageView kmT;
    private TbImageView kmU;
    private TbImageView kmV;
    private TbImageView kmW;
    private Button kmX;
    private NewUserGuideModel kmo;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> kmM = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean kmY = false;
    private boolean kmZ = true;
    private final View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.kmX) {
                    if (NewUserGuideMainFragment.this.kmG.cLT()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.kmG.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.kmG.finish();
                }
            } else if (NewUserGuideMainFragment.this.kmZ) {
                NewUserGuideMainFragment.this.kmZ = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.kmG, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cMa() {
                        NewUserGuideMainFragment.this.gfv.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.gfv.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.kmZ = true;
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void cMa();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.kmY = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kmG = (NewUserGuideActivity) getBaseFragmentActivity();
        this.kmo = this.kmG.cLV();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.kmo != null && !this.kmY) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.kmG.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.kmo.cMc());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.kmM.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.gfv = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.kmN = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.kmO = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.kmP = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.kmQ = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.kmR = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.kmS = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.kmT = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.kmU = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.kmV = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.kmW = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.kmX = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.kmM.put(1, this.kmN);
            this.kmM.put(2, this.kmO);
            this.kmM.put(3, this.kmP);
            this.kmM.put(4, this.kmQ);
            this.kmM.put(5, this.kmR);
            this.kmM.put(6, this.kmS);
            this.kmM.put(7, this.kmT);
            this.kmM.put(8, this.kmU);
            this.kmM.put(9, this.kmV);
            this.kmM.put(10, this.kmW);
            this.kmX.setOnClickListener(this.dmY);
            this.kmN.setOnClickListener(this.dmY);
            this.kmO.setOnClickListener(this.dmY);
            this.kmP.setOnClickListener(this.dmY);
            this.kmQ.setOnClickListener(this.dmY);
            this.kmR.setOnClickListener(this.dmY);
            this.kmS.setOnClickListener(this.dmY);
            this.kmT.setOnClickListener(this.dmY);
            this.kmU.setOnClickListener(this.dmY);
            this.kmV.setOnClickListener(this.dmY);
            this.kmV.setOnClickListener(this.dmY);
            this.kmW.setOnClickListener(this.dmY);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.kmG.cLX();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
