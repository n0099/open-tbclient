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
/* loaded from: classes9.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View hsM;
    private NewUserGuideModel lMR;
    private Button lNA;
    private NewUserGuideActivity lNj;
    private TbImageView lNq;
    private TbImageView lNr;
    private TbImageView lNs;
    private TbImageView lNt;
    private TbImageView lNu;
    private TbImageView lNv;
    private TbImageView lNw;
    private TbImageView lNx;
    private TbImageView lNy;
    private TbImageView lNz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> lNp = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean lNB = false;
    private boolean lNC = true;
    private final View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.lNA) {
                    if (NewUserGuideMainFragment.this.lNj.dkv()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.lNj.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.lNj.finish();
                }
            } else if (NewUserGuideMainFragment.this.lNC) {
                NewUserGuideMainFragment.this.lNC = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.lNj, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dkC() {
                        NewUserGuideMainFragment.this.hsM.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.hsM.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.lNC = true;
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void dkC();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.lNB = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lNj = (NewUserGuideActivity) getBaseFragmentActivity();
        this.lMR = this.lNj.dkx();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.lMR != null && !this.lNB) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.lNj.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.lMR.dkE());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.lNp.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.hsM = this.mRoot.findViewById(R.id.root_main_view_cover);
            this.lNq = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.lNr = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.lNs = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.lNt = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.lNu = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.lNv = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.lNw = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.lNx = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.lNy = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.lNz = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.lNA = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.lNp.put(1, this.lNq);
            this.lNp.put(2, this.lNr);
            this.lNp.put(3, this.lNs);
            this.lNp.put(4, this.lNt);
            this.lNp.put(5, this.lNu);
            this.lNp.put(6, this.lNv);
            this.lNp.put(7, this.lNw);
            this.lNp.put(8, this.lNx);
            this.lNp.put(9, this.lNy);
            this.lNp.put(10, this.lNz);
            this.lNA.setOnClickListener(this.eoP);
            this.lNq.setOnClickListener(this.eoP);
            this.lNr.setOnClickListener(this.eoP);
            this.lNs.setOnClickListener(this.eoP);
            this.lNt.setOnClickListener(this.eoP);
            this.lNu.setOnClickListener(this.eoP);
            this.lNv.setOnClickListener(this.eoP);
            this.lNw.setOnClickListener(this.eoP);
            this.lNx.setOnClickListener(this.eoP);
            this.lNy.setOnClickListener(this.eoP);
            this.lNy.setOnClickListener(this.eoP);
            this.lNz.setOnClickListener(this.eoP);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.lNj.dkz();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
