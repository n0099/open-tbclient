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
    private View iLV;
    private ViewGroup mRoot;
    private TbImageView ntD;
    private TbImageView ntE;
    private TbImageView ntF;
    private TbImageView ntG;
    private TbImageView ntH;
    private TbImageView ntI;
    private TbImageView ntJ;
    private TbImageView ntK;
    private TbImageView ntL;
    private TbImageView ntM;
    private Button ntN;
    private NewUserGuideModel nte;
    private NewUserGuideActivity ntw;
    private final Hashtable<Integer, TbImageView> ntC = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean ntO = false;
    private boolean ntP = true;
    private final View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.ntN) {
                    if (NewUserGuideMainFragment.this.ntw.dRQ()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.ntw.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.ntw.finish();
                }
            } else if (NewUserGuideMainFragment.this.ntP) {
                NewUserGuideMainFragment.this.ntP = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.ntw, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dRX() {
                        NewUserGuideMainFragment.this.iLV.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.iLV.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.ntP = true;
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void dRX();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.ntO = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ntw = (NewUserGuideActivity) getBaseFragmentActivity();
        this.nte = this.ntw.dRS();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.nte != null && !this.ntO) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.ntw.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.nte.dRZ());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.ntC.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.iLV = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.ntD = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.ntE = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.ntF = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.ntG = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.ntH = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.ntI = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.ntJ = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.ntK = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.ntL = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.ntM = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.ntN = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.ntC.put(1, this.ntD);
            this.ntC.put(2, this.ntE);
            this.ntC.put(3, this.ntF);
            this.ntC.put(4, this.ntG);
            this.ntC.put(5, this.ntH);
            this.ntC.put(6, this.ntI);
            this.ntC.put(7, this.ntJ);
            this.ntC.put(8, this.ntK);
            this.ntC.put(9, this.ntL);
            this.ntC.put(10, this.ntM);
            this.ntN.setOnClickListener(this.foP);
            this.ntD.setOnClickListener(this.foP);
            this.ntE.setOnClickListener(this.foP);
            this.ntF.setOnClickListener(this.foP);
            this.ntG.setOnClickListener(this.foP);
            this.ntH.setOnClickListener(this.foP);
            this.ntI.setOnClickListener(this.foP);
            this.ntJ.setOnClickListener(this.foP);
            this.ntK.setOnClickListener(this.foP);
            this.ntL.setOnClickListener(this.foP);
            this.ntL.setOnClickListener(this.foP);
            this.ntM.setOnClickListener(this.foP);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.ntw.dRU();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
