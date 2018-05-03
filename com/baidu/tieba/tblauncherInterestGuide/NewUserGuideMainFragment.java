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
/* loaded from: classes3.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View cRs;
    private NewUserGuideModel gBH;
    private NewUserGuideActivity gCc;
    private TbImageView gCj;
    private TbImageView gCk;
    private TbImageView gCl;
    private TbImageView gCm;
    private TbImageView gCn;
    private TbImageView gCo;
    private TbImageView gCp;
    private TbImageView gCq;
    private TbImageView gCr;
    private TbImageView gCs;
    private Button gCt;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> gCi = new Hashtable<>();
    private boolean gBJ = false;
    private boolean gCu = false;
    private boolean gCv = true;
    private final View.OnClickListener axG = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getTag() == null || !(view2.getTag() instanceof InterestFrsData.Tag)) {
                if (view2 == NewUserGuideMainFragment.this.gCt) {
                    if (NewUserGuideMainFragment.this.gCc.buf()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.gCc.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.gBJ)));
                    NewUserGuideMainFragment.this.gCc.finish();
                }
            } else if (NewUserGuideMainFragment.this.gCv) {
                NewUserGuideMainFragment.this.gCv = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.gCc, (InterestFrsData.Tag) view2.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bun() {
                        NewUserGuideMainFragment.this.cRs.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.cRs.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.gCv = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bun();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.gCu = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCc = (NewUserGuideActivity) getBaseFragmentActivity();
        this.gBH = this.gCc.buh();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.gBH != null && !this.gCu) {
            if (bundle != null) {
                this.gBJ = bundle.getBoolean("is_new_user");
            } else {
                this.gBJ = this.gCc.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.gBH.bup());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.gCi.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(d.i.guide_main, (ViewGroup) null);
            this.cRs = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.gCj = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.gCk = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.gCl = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.gCm = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.gCn = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.gCo = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.gCp = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.gCq = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.gCr = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.gCs = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.gCt = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.gCi.put(1, this.gCj);
            this.gCi.put(2, this.gCk);
            this.gCi.put(3, this.gCl);
            this.gCi.put(4, this.gCm);
            this.gCi.put(5, this.gCn);
            this.gCi.put(6, this.gCo);
            this.gCi.put(7, this.gCp);
            this.gCi.put(8, this.gCq);
            this.gCi.put(9, this.gCr);
            this.gCi.put(10, this.gCs);
            this.gCt.setOnClickListener(this.axG);
            this.gCj.setOnClickListener(this.axG);
            this.gCk.setOnClickListener(this.axG);
            this.gCl.setOnClickListener(this.axG);
            this.gCm.setOnClickListener(this.axG);
            this.gCn.setOnClickListener(this.axG);
            this.gCo.setOnClickListener(this.axG);
            this.gCp.setOnClickListener(this.axG);
            this.gCq.setOnClickListener(this.axG);
            this.gCr.setOnClickListener(this.axG);
            this.gCr.setOnClickListener(this.axG);
            this.gCs.setOnClickListener(this.axG);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.gCc.buj();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
