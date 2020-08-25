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
    private View hLN;
    private ViewGroup mRoot;
    private NewUserGuideModel mlT;
    private TbImageView mmA;
    private TbImageView mmB;
    private Button mmC;
    private NewUserGuideActivity mml;
    private TbImageView mms;
    private TbImageView mmt;
    private TbImageView mmu;
    private TbImageView mmv;
    private TbImageView mmw;
    private TbImageView mmx;
    private TbImageView mmy;
    private TbImageView mmz;
    private final Hashtable<Integer, TbImageView> mmr = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean mmD = false;
    private boolean mmE = true;
    private final View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.mmC) {
                    if (NewUserGuideMainFragment.this.mml.dza()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.mml.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.mml.finish();
                }
            } else if (NewUserGuideMainFragment.this.mmE) {
                NewUserGuideMainFragment.this.mmE = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.mml, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dzh() {
                        NewUserGuideMainFragment.this.hLN.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.hLN.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.mmE = true;
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void dzh();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.mmD = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mml = (NewUserGuideActivity) getBaseFragmentActivity();
        this.mlT = this.mml.dzc();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.mlT != null && !this.mmD) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.mml.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.mlT.dzj());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.mmr.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.hLN = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.mms = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.mmt = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.mmu = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.mmv = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.mmw = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.mmx = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.mmy = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.mmz = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.mmA = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.mmB = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.mmC = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.mmr.put(1, this.mms);
            this.mmr.put(2, this.mmt);
            this.mmr.put(3, this.mmu);
            this.mmr.put(4, this.mmv);
            this.mmr.put(5, this.mmw);
            this.mmr.put(6, this.mmx);
            this.mmr.put(7, this.mmy);
            this.mmr.put(8, this.mmz);
            this.mmr.put(9, this.mmA);
            this.mmr.put(10, this.mmB);
            this.mmC.setOnClickListener(this.eFC);
            this.mms.setOnClickListener(this.eFC);
            this.mmt.setOnClickListener(this.eFC);
            this.mmu.setOnClickListener(this.eFC);
            this.mmv.setOnClickListener(this.eFC);
            this.mmw.setOnClickListener(this.eFC);
            this.mmx.setOnClickListener(this.eFC);
            this.mmy.setOnClickListener(this.eFC);
            this.mmz.setOnClickListener(this.eFC);
            this.mmA.setOnClickListener(this.eFC);
            this.mmA.setOnClickListener(this.eFC);
            this.mmB.setOnClickListener(this.eFC);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.mml.dze();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
