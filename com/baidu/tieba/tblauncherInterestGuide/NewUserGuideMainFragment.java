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
    private View eOy;
    private NewUserGuideModel iMF;
    private NewUserGuideActivity iNa;
    private TbImageView iNh;
    private TbImageView iNi;
    private TbImageView iNj;
    private TbImageView iNk;
    private TbImageView iNl;
    private TbImageView iNm;
    private TbImageView iNn;
    private TbImageView iNo;
    private TbImageView iNp;
    private TbImageView iNq;
    private Button iNr;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> iNg = new Hashtable<>();
    private boolean iMH = false;
    private boolean iNs = false;
    private boolean iNt = true;
    private final View.OnClickListener ccC = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.iNr) {
                    if (NewUserGuideMainFragment.this.iNa.cgT()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.iNa.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.iMH)));
                    NewUserGuideMainFragment.this.iNa.finish();
                }
            } else if (NewUserGuideMainFragment.this.iNt) {
                NewUserGuideMainFragment.this.iNt = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.iNa, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void chb() {
                        NewUserGuideMainFragment.this.eOy.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.eOy.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.iNt = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void chb();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.iNs = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iNa = (NewUserGuideActivity) getBaseFragmentActivity();
        this.iMF = this.iNa.cgV();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.iMF != null && !this.iNs) {
            if (bundle != null) {
                this.iMH = bundle.getBoolean("is_new_user");
            } else {
                this.iMH = this.iNa.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.iMF.chd());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.iNg.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.eOy = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.iNh = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.iNi = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.iNj = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.iNk = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.iNl = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.iNm = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.iNn = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.iNo = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.iNp = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.iNq = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.iNr = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.iNg.put(1, this.iNh);
            this.iNg.put(2, this.iNi);
            this.iNg.put(3, this.iNj);
            this.iNg.put(4, this.iNk);
            this.iNg.put(5, this.iNl);
            this.iNg.put(6, this.iNm);
            this.iNg.put(7, this.iNn);
            this.iNg.put(8, this.iNo);
            this.iNg.put(9, this.iNp);
            this.iNg.put(10, this.iNq);
            this.iNr.setOnClickListener(this.ccC);
            this.iNh.setOnClickListener(this.ccC);
            this.iNi.setOnClickListener(this.ccC);
            this.iNj.setOnClickListener(this.ccC);
            this.iNk.setOnClickListener(this.ccC);
            this.iNl.setOnClickListener(this.ccC);
            this.iNm.setOnClickListener(this.ccC);
            this.iNn.setOnClickListener(this.ccC);
            this.iNo.setOnClickListener(this.ccC);
            this.iNp.setOnClickListener(this.ccC);
            this.iNp.setOnClickListener(this.ccC);
            this.iNq.setOnClickListener(this.ccC);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.iNa.cgX();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
