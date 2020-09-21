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
/* loaded from: classes21.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View hSU;
    private ViewGroup mRoot;
    private NewUserGuideModel mvK;
    private NewUserGuideActivity mwc;
    private TbImageView mwj;
    private TbImageView mwk;
    private TbImageView mwl;
    private TbImageView mwm;
    private TbImageView mwn;
    private TbImageView mwo;
    private TbImageView mwp;
    private TbImageView mwq;
    private TbImageView mwr;
    private TbImageView mws;
    private Button mwt;
    private final Hashtable<Integer, TbImageView> mwi = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean mwu = false;
    private boolean mwv = true;
    private final View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.mwt) {
                    if (NewUserGuideMainFragment.this.mwc.dDd()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.mwc.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.mwc.finish();
                }
            } else if (NewUserGuideMainFragment.this.mwv) {
                NewUserGuideMainFragment.this.mwv = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.mwc, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dDk() {
                        NewUserGuideMainFragment.this.hSU.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.hSU.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.mwv = true;
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void dDk();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.mwu = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mwc = (NewUserGuideActivity) getBaseFragmentActivity();
        this.mvK = this.mwc.dDf();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.mvK != null && !this.mwu) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.mwc.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.mvK.dDm());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.mwi.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.hSU = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.mwj = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.mwk = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.mwl = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.mwm = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.mwn = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.mwo = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.mwp = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.mwq = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.mwr = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.mws = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.mwt = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.mwi.put(1, this.mwj);
            this.mwi.put(2, this.mwk);
            this.mwi.put(3, this.mwl);
            this.mwi.put(4, this.mwm);
            this.mwi.put(5, this.mwn);
            this.mwi.put(6, this.mwo);
            this.mwi.put(7, this.mwp);
            this.mwi.put(8, this.mwq);
            this.mwi.put(9, this.mwr);
            this.mwi.put(10, this.mws);
            this.mwt.setOnClickListener(this.eHN);
            this.mwj.setOnClickListener(this.eHN);
            this.mwk.setOnClickListener(this.eHN);
            this.mwl.setOnClickListener(this.eHN);
            this.mwm.setOnClickListener(this.eHN);
            this.mwn.setOnClickListener(this.eHN);
            this.mwo.setOnClickListener(this.eHN);
            this.mwp.setOnClickListener(this.eHN);
            this.mwq.setOnClickListener(this.eHN);
            this.mwr.setOnClickListener(this.eHN);
            this.mwr.setOnClickListener(this.eHN);
            this.mws.setOnClickListener(this.eHN);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.mwc.dDh();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
