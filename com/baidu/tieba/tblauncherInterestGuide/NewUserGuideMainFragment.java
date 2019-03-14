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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes4.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View eOM;
    private NewUserGuideModel iMR;
    private TbImageView iNA;
    private TbImageView iNB;
    private TbImageView iNC;
    private Button iND;
    private NewUserGuideActivity iNm;
    private TbImageView iNt;
    private TbImageView iNu;
    private TbImageView iNv;
    private TbImageView iNw;
    private TbImageView iNx;
    private TbImageView iNy;
    private TbImageView iNz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> iNs = new Hashtable<>();
    private boolean iMT = false;
    private boolean iNE = false;
    private boolean iNF = true;
    private final View.OnClickListener ccA = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.iND) {
                    if (NewUserGuideMainFragment.this.iNm.cgV()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.iNm.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.iMT)));
                    NewUserGuideMainFragment.this.iNm.finish();
                }
            } else if (NewUserGuideMainFragment.this.iNF) {
                NewUserGuideMainFragment.this.iNF = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.iNm, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void chd() {
                        NewUserGuideMainFragment.this.eOM.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.eOM.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.iNF = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void chd();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.iNE = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iNm = (NewUserGuideActivity) getBaseFragmentActivity();
        this.iMR = this.iNm.cgX();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.iMR != null && !this.iNE) {
            if (bundle != null) {
                this.iMT = bundle.getBoolean("is_new_user");
            } else {
                this.iMT = this.iNm.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.iMR.chf());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.iNs.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(d.h.guide_main, (ViewGroup) null);
            this.eOM = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.iNt = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.iNu = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.iNv = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.iNw = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.iNx = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.iNy = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.iNz = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.iNA = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.iNB = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.iNC = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.iND = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.iNs.put(1, this.iNt);
            this.iNs.put(2, this.iNu);
            this.iNs.put(3, this.iNv);
            this.iNs.put(4, this.iNw);
            this.iNs.put(5, this.iNx);
            this.iNs.put(6, this.iNy);
            this.iNs.put(7, this.iNz);
            this.iNs.put(8, this.iNA);
            this.iNs.put(9, this.iNB);
            this.iNs.put(10, this.iNC);
            this.iND.setOnClickListener(this.ccA);
            this.iNt.setOnClickListener(this.ccA);
            this.iNu.setOnClickListener(this.ccA);
            this.iNv.setOnClickListener(this.ccA);
            this.iNw.setOnClickListener(this.ccA);
            this.iNx.setOnClickListener(this.ccA);
            this.iNy.setOnClickListener(this.ccA);
            this.iNz.setOnClickListener(this.ccA);
            this.iNA.setOnClickListener(this.ccA);
            this.iNB.setOnClickListener(this.ccA);
            this.iNB.setOnClickListener(this.ccA);
            this.iNC.setOnClickListener(this.ccA);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.iNm.cgZ();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
