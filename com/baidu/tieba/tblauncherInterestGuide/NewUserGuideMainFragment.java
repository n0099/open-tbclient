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
/* loaded from: classes16.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View hLT;
    private ViewGroup mRoot;
    private NewUserGuideActivity mmD;
    private TbImageView mmK;
    private TbImageView mmL;
    private TbImageView mmM;
    private TbImageView mmN;
    private TbImageView mmO;
    private TbImageView mmP;
    private TbImageView mmQ;
    private TbImageView mmR;
    private TbImageView mmS;
    private TbImageView mmT;
    private Button mmU;
    private NewUserGuideModel mml;
    private final Hashtable<Integer, TbImageView> mmJ = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean mmV = false;
    private boolean mmW = true;
    private final View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.mmU) {
                    if (NewUserGuideMainFragment.this.mmD.dzj()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.mmD.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.mmD.finish();
                }
            } else if (NewUserGuideMainFragment.this.mmW) {
                NewUserGuideMainFragment.this.mmW = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.mmD, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dzq() {
                        NewUserGuideMainFragment.this.hLT.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.hLT.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.mmW = true;
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void dzq();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.mmV = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mmD = (NewUserGuideActivity) getBaseFragmentActivity();
        this.mml = this.mmD.dzl();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.mml != null && !this.mmV) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.mmD.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.mml.dzs());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.mmJ.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.hLT = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.mmK = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.mmL = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.mmM = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.mmN = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.mmO = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.mmP = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.mmQ = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.mmR = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.mmS = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.mmT = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.mmU = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.mmJ.put(1, this.mmK);
            this.mmJ.put(2, this.mmL);
            this.mmJ.put(3, this.mmM);
            this.mmJ.put(4, this.mmN);
            this.mmJ.put(5, this.mmO);
            this.mmJ.put(6, this.mmP);
            this.mmJ.put(7, this.mmQ);
            this.mmJ.put(8, this.mmR);
            this.mmJ.put(9, this.mmS);
            this.mmJ.put(10, this.mmT);
            this.mmU.setOnClickListener(this.eFG);
            this.mmK.setOnClickListener(this.eFG);
            this.mmL.setOnClickListener(this.eFG);
            this.mmM.setOnClickListener(this.eFG);
            this.mmN.setOnClickListener(this.eFG);
            this.mmO.setOnClickListener(this.eFG);
            this.mmP.setOnClickListener(this.eFG);
            this.mmQ.setOnClickListener(this.eFG);
            this.mmR.setOnClickListener(this.eFG);
            this.mmS.setOnClickListener(this.eFG);
            this.mmS.setOnClickListener(this.eFG);
            this.mmT.setOnClickListener(this.eFG);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.mmD.dzn();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
