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
    private View eOz;
    private NewUserGuideModel iMG;
    private NewUserGuideActivity iNb;
    private TbImageView iNi;
    private TbImageView iNj;
    private TbImageView iNk;
    private TbImageView iNl;
    private TbImageView iNm;
    private TbImageView iNn;
    private TbImageView iNo;
    private TbImageView iNp;
    private TbImageView iNq;
    private TbImageView iNr;
    private Button iNs;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> iNh = new Hashtable<>();
    private boolean iMI = false;
    private boolean iNt = false;
    private boolean iNu = true;
    private final View.OnClickListener ccD = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.iNs) {
                    if (NewUserGuideMainFragment.this.iNb.cgT()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.iNb.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.iMI)));
                    NewUserGuideMainFragment.this.iNb.finish();
                }
            } else if (NewUserGuideMainFragment.this.iNu) {
                NewUserGuideMainFragment.this.iNu = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.iNb, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void chb() {
                        NewUserGuideMainFragment.this.eOz.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.eOz.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.iNu = true;
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void chb();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.iNt = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iNb = (NewUserGuideActivity) getBaseFragmentActivity();
        this.iMG = this.iNb.cgV();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.iMG != null && !this.iNt) {
            if (bundle != null) {
                this.iMI = bundle.getBoolean("is_new_user");
            } else {
                this.iMI = this.iNb.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.iMG.chd());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.iNh.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.eOz = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.iNi = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.iNj = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.iNk = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.iNl = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.iNm = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.iNn = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.iNo = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.iNp = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.iNq = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.iNr = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.iNs = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.iNh.put(1, this.iNi);
            this.iNh.put(2, this.iNj);
            this.iNh.put(3, this.iNk);
            this.iNh.put(4, this.iNl);
            this.iNh.put(5, this.iNm);
            this.iNh.put(6, this.iNn);
            this.iNh.put(7, this.iNo);
            this.iNh.put(8, this.iNp);
            this.iNh.put(9, this.iNq);
            this.iNh.put(10, this.iNr);
            this.iNs.setOnClickListener(this.ccD);
            this.iNi.setOnClickListener(this.ccD);
            this.iNj.setOnClickListener(this.ccD);
            this.iNk.setOnClickListener(this.ccD);
            this.iNl.setOnClickListener(this.ccD);
            this.iNm.setOnClickListener(this.ccD);
            this.iNn.setOnClickListener(this.ccD);
            this.iNo.setOnClickListener(this.ccD);
            this.iNp.setOnClickListener(this.ccD);
            this.iNq.setOnClickListener(this.ccD);
            this.iNq.setOnClickListener(this.ccD);
            this.iNr.setOnClickListener(this.ccD);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.iNb.cgX();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
