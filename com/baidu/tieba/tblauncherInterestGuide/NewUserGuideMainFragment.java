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
/* loaded from: classes2.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private ViewGroup bbd;
    private View iZi;
    private NewUserGuideActivity nEA;
    private TbImageView nEH;
    private TbImageView nEI;
    private TbImageView nEJ;
    private TbImageView nEK;
    private TbImageView nEL;
    private TbImageView nEM;
    private TbImageView nEN;
    private TbImageView nEO;
    private TbImageView nEP;
    private TbImageView nEQ;
    private Button nER;
    private NewUserGuideModel nEk;
    private final Hashtable<Integer, TbImageView> nEG = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean nES = false;
    private boolean nET = true;
    private final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.nER) {
                    if (NewUserGuideMainFragment.this.nEA.dQw()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.nEA.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.nEA.finish();
                }
            } else if (NewUserGuideMainFragment.this.nET) {
                NewUserGuideMainFragment.this.nET = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.nEA, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dQD() {
                        NewUserGuideMainFragment.this.iZi.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.iZi.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.nET = true;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void dQD();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.nES = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nEA = (NewUserGuideActivity) getBaseFragmentActivity();
        this.nEk = this.nEA.dQy();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.nEk != null && !this.nES) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.nEA.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.nEk.dQF());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.nEG.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.bbd = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(R.layout.guide_main, (ViewGroup) null);
            this.iZi = this.bbd.findViewById(R.id.root_main_view_cover);
            this.nEH = (TbImageView) this.bbd.findViewById(R.id.icon_1);
            this.nEI = (TbImageView) this.bbd.findViewById(R.id.icon_2);
            this.nEJ = (TbImageView) this.bbd.findViewById(R.id.icon_3);
            this.nEK = (TbImageView) this.bbd.findViewById(R.id.icon_4);
            this.nEL = (TbImageView) this.bbd.findViewById(R.id.icon_5);
            this.nEM = (TbImageView) this.bbd.findViewById(R.id.icon_6);
            this.nEN = (TbImageView) this.bbd.findViewById(R.id.icon_7);
            this.nEO = (TbImageView) this.bbd.findViewById(R.id.icon_8);
            this.nEP = (TbImageView) this.bbd.findViewById(R.id.icon_9);
            this.nEQ = (TbImageView) this.bbd.findViewById(R.id.icon_10);
            this.nER = (Button) this.bbd.findViewById(R.id.btn_next);
            this.nEG.put(1, this.nEH);
            this.nEG.put(2, this.nEI);
            this.nEG.put(3, this.nEJ);
            this.nEG.put(4, this.nEK);
            this.nEG.put(5, this.nEL);
            this.nEG.put(6, this.nEM);
            this.nEG.put(7, this.nEN);
            this.nEG.put(8, this.nEO);
            this.nEG.put(9, this.nEP);
            this.nEG.put(10, this.nEQ);
            this.nER.setOnClickListener(this.onClickListener);
            this.nEH.setOnClickListener(this.onClickListener);
            this.nEI.setOnClickListener(this.onClickListener);
            this.nEJ.setOnClickListener(this.onClickListener);
            this.nEK.setOnClickListener(this.onClickListener);
            this.nEL.setOnClickListener(this.onClickListener);
            this.nEM.setOnClickListener(this.onClickListener);
            this.nEN.setOnClickListener(this.onClickListener);
            this.nEO.setOnClickListener(this.onClickListener);
            this.nEP.setOnClickListener(this.onClickListener);
            this.nEP.setOnClickListener(this.onClickListener);
            this.nEQ.setOnClickListener(this.onClickListener);
            return this.bbd;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.nEA.dQA();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
