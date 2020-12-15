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
    private View iLX;
    private ViewGroup mRoot;
    private TbImageView ntF;
    private TbImageView ntG;
    private TbImageView ntH;
    private TbImageView ntI;
    private TbImageView ntJ;
    private TbImageView ntK;
    private TbImageView ntL;
    private TbImageView ntM;
    private TbImageView ntN;
    private TbImageView ntO;
    private Button ntP;
    private NewUserGuideModel ntg;
    private NewUserGuideActivity nty;
    private final Hashtable<Integer, TbImageView> ntE = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean ntQ = false;
    private boolean ntR = true;
    private final View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.ntP) {
                    if (NewUserGuideMainFragment.this.nty.dRR()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.nty.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.nty.finish();
                }
            } else if (NewUserGuideMainFragment.this.ntR) {
                NewUserGuideMainFragment.this.ntR = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.nty, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dRY() {
                        NewUserGuideMainFragment.this.iLX.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.iLX.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.ntR = true;
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void dRY();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.ntQ = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nty = (NewUserGuideActivity) getBaseFragmentActivity();
        this.ntg = this.nty.dRT();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.ntg != null && !this.ntQ) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.nty.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.ntg.dSa());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.ntE.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.iLX = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.ntF = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.ntG = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.ntH = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.ntI = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.ntJ = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.ntK = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.ntL = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.ntM = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.ntN = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.ntO = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.ntP = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.ntE.put(1, this.ntF);
            this.ntE.put(2, this.ntG);
            this.ntE.put(3, this.ntH);
            this.ntE.put(4, this.ntI);
            this.ntE.put(5, this.ntJ);
            this.ntE.put(6, this.ntK);
            this.ntE.put(7, this.ntL);
            this.ntE.put(8, this.ntM);
            this.ntE.put(9, this.ntN);
            this.ntE.put(10, this.ntO);
            this.ntP.setOnClickListener(this.foP);
            this.ntF.setOnClickListener(this.foP);
            this.ntG.setOnClickListener(this.foP);
            this.ntH.setOnClickListener(this.foP);
            this.ntI.setOnClickListener(this.foP);
            this.ntJ.setOnClickListener(this.foP);
            this.ntK.setOnClickListener(this.foP);
            this.ntL.setOnClickListener(this.foP);
            this.ntM.setOnClickListener(this.foP);
            this.ntN.setOnClickListener(this.foP);
            this.ntN.setOnClickListener(this.foP);
            this.ntO.setOnClickListener(this.foP);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.nty.dRV();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
