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
/* loaded from: classes4.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private ViewGroup Zo;
    private View foF;
    private NewUserGuideActivity jpD;
    private TbImageView jpK;
    private TbImageView jpL;
    private TbImageView jpM;
    private TbImageView jpN;
    private TbImageView jpO;
    private TbImageView jpP;
    private TbImageView jpQ;
    private TbImageView jpR;
    private TbImageView jpS;
    private TbImageView jpT;
    private Button jpU;
    private NewUserGuideModel jpl;
    private final Hashtable<Integer, TbImageView> jpJ = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean jpV = false;
    private boolean jpW = true;
    private final View.OnClickListener czV = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.jpU) {
                    if (NewUserGuideMainFragment.this.jpD.cqJ()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.jpD.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.jpD.finish();
                }
            } else if (NewUserGuideMainFragment.this.jpW) {
                NewUserGuideMainFragment.this.jpW = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.jpD, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void cqQ() {
                        NewUserGuideMainFragment.this.foF.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.foF.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.jpW = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void cqQ();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.jpV = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jpD = (NewUserGuideActivity) getBaseFragmentActivity();
        this.jpl = this.jpD.cqL();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.jpl != null && !this.jpV) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.jpD.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.jpl.cqS());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.jpJ.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.Zo = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.foF = this.Zo.findViewById(R.id.root_main_view_cover);
            this.jpK = (TbImageView) this.Zo.findViewById(R.id.icon_1);
            this.jpL = (TbImageView) this.Zo.findViewById(R.id.icon_2);
            this.jpM = (TbImageView) this.Zo.findViewById(R.id.icon_3);
            this.jpN = (TbImageView) this.Zo.findViewById(R.id.icon_4);
            this.jpO = (TbImageView) this.Zo.findViewById(R.id.icon_5);
            this.jpP = (TbImageView) this.Zo.findViewById(R.id.icon_6);
            this.jpQ = (TbImageView) this.Zo.findViewById(R.id.icon_7);
            this.jpR = (TbImageView) this.Zo.findViewById(R.id.icon_8);
            this.jpS = (TbImageView) this.Zo.findViewById(R.id.icon_9);
            this.jpT = (TbImageView) this.Zo.findViewById(R.id.icon_10);
            this.jpU = (Button) this.Zo.findViewById(R.id.btn_next);
            this.jpJ.put(1, this.jpK);
            this.jpJ.put(2, this.jpL);
            this.jpJ.put(3, this.jpM);
            this.jpJ.put(4, this.jpN);
            this.jpJ.put(5, this.jpO);
            this.jpJ.put(6, this.jpP);
            this.jpJ.put(7, this.jpQ);
            this.jpJ.put(8, this.jpR);
            this.jpJ.put(9, this.jpS);
            this.jpJ.put(10, this.jpT);
            this.jpU.setOnClickListener(this.czV);
            this.jpK.setOnClickListener(this.czV);
            this.jpL.setOnClickListener(this.czV);
            this.jpM.setOnClickListener(this.czV);
            this.jpN.setOnClickListener(this.czV);
            this.jpO.setOnClickListener(this.czV);
            this.jpP.setOnClickListener(this.czV);
            this.jpQ.setOnClickListener(this.czV);
            this.jpR.setOnClickListener(this.czV);
            this.jpS.setOnClickListener(this.czV);
            this.jpS.setOnClickListener(this.czV);
            this.jpT.setOnClickListener(this.czV);
            return this.Zo;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.jpD.cqN();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
