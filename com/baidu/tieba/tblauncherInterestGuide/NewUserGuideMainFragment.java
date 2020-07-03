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
    private NewUserGuideModel lMO;
    private NewUserGuideActivity lNg;
    private TbImageView lNn;
    private TbImageView lNo;
    private TbImageView lNp;
    private TbImageView lNq;
    private TbImageView lNr;
    private TbImageView lNs;
    private TbImageView lNt;
    private TbImageView lNu;
    private TbImageView lNv;
    private TbImageView lNw;
    private Button lNx;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> lNm = new Hashtable<>();
    private boolean mIsNewUser = false;
    private boolean lNy = false;
    private boolean lNz = true;
    private final View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.lNx) {
                    if (NewUserGuideMainFragment.this.lNg.dkr()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(NewUserGuideMainFragment.this.lNg.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.mIsNewUser)));
                    NewUserGuideMainFragment.this.lNg.finish();
                }
            } else if (NewUserGuideMainFragment.this.lNz) {
                NewUserGuideMainFragment.this.lNz = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.lNg, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void dky() {
                        NewUserGuideMainFragment.this.hsM.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.hsM.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.lNz = true;
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void dky();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.lNy = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lNg = (NewUserGuideActivity) getBaseFragmentActivity();
        this.lMO = this.lNg.dkt();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.lMO != null && !this.lNy) {
            if (bundle != null) {
                this.mIsNewUser = bundle.getBoolean("is_new_user");
            } else {
                this.mIsNewUser = this.lNg.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.lMO.dkA());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.lNm.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.lNn = (TbImageView) this.mRoot.findViewById(R.id.icon_1);
            this.lNo = (TbImageView) this.mRoot.findViewById(R.id.icon_2);
            this.lNp = (TbImageView) this.mRoot.findViewById(R.id.icon_3);
            this.lNq = (TbImageView) this.mRoot.findViewById(R.id.icon_4);
            this.lNr = (TbImageView) this.mRoot.findViewById(R.id.icon_5);
            this.lNs = (TbImageView) this.mRoot.findViewById(R.id.icon_6);
            this.lNt = (TbImageView) this.mRoot.findViewById(R.id.icon_7);
            this.lNu = (TbImageView) this.mRoot.findViewById(R.id.icon_8);
            this.lNv = (TbImageView) this.mRoot.findViewById(R.id.icon_9);
            this.lNw = (TbImageView) this.mRoot.findViewById(R.id.icon_10);
            this.lNx = (Button) this.mRoot.findViewById(R.id.btn_next);
            this.lNm.put(1, this.lNn);
            this.lNm.put(2, this.lNo);
            this.lNm.put(3, this.lNp);
            this.lNm.put(4, this.lNq);
            this.lNm.put(5, this.lNr);
            this.lNm.put(6, this.lNs);
            this.lNm.put(7, this.lNt);
            this.lNm.put(8, this.lNu);
            this.lNm.put(9, this.lNv);
            this.lNm.put(10, this.lNw);
            this.lNx.setOnClickListener(this.eoP);
            this.lNn.setOnClickListener(this.eoP);
            this.lNo.setOnClickListener(this.eoP);
            this.lNp.setOnClickListener(this.eoP);
            this.lNq.setOnClickListener(this.eoP);
            this.lNr.setOnClickListener(this.eoP);
            this.lNs.setOnClickListener(this.eoP);
            this.lNt.setOnClickListener(this.eoP);
            this.lNu.setOnClickListener(this.eoP);
            this.lNv.setOnClickListener(this.eoP);
            this.lNv.setOnClickListener(this.eoP);
            this.lNw.setOnClickListener(this.eoP);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.lNg.dkv();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
