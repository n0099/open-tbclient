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
    private View cRv;
    private NewUserGuideModel gBK;
    private NewUserGuideActivity gCf;
    private TbImageView gCm;
    private TbImageView gCn;
    private TbImageView gCo;
    private TbImageView gCp;
    private TbImageView gCq;
    private TbImageView gCr;
    private TbImageView gCs;
    private TbImageView gCt;
    private TbImageView gCu;
    private TbImageView gCv;
    private Button gCw;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> gCl = new Hashtable<>();
    private boolean gBM = false;
    private boolean gCx = false;
    private boolean gCy = true;
    private final View.OnClickListener axG = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getTag() == null || !(view2.getTag() instanceof InterestFrsData.Tag)) {
                if (view2 == NewUserGuideMainFragment.this.gCw) {
                    if (NewUserGuideMainFragment.this.gCf.buf()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.gCf.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.gBM)));
                    NewUserGuideMainFragment.this.gCf.finish();
                }
            } else if (NewUserGuideMainFragment.this.gCy) {
                NewUserGuideMainFragment.this.gCy = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.gCf, (InterestFrsData.Tag) view2.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bun() {
                        NewUserGuideMainFragment.this.cRv.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.cRv.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.gCy = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bun();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.gCx = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCf = (NewUserGuideActivity) getBaseFragmentActivity();
        this.gBK = this.gCf.buh();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.gBK != null && !this.gCx) {
            if (bundle != null) {
                this.gBM = bundle.getBoolean("is_new_user");
            } else {
                this.gBM = this.gCf.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.gBK.bup());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.gCl.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.cRv = this.mRoot.findViewById(d.g.root_main_view_cover);
            this.gCm = (TbImageView) this.mRoot.findViewById(d.g.icon_1);
            this.gCn = (TbImageView) this.mRoot.findViewById(d.g.icon_2);
            this.gCo = (TbImageView) this.mRoot.findViewById(d.g.icon_3);
            this.gCp = (TbImageView) this.mRoot.findViewById(d.g.icon_4);
            this.gCq = (TbImageView) this.mRoot.findViewById(d.g.icon_5);
            this.gCr = (TbImageView) this.mRoot.findViewById(d.g.icon_6);
            this.gCs = (TbImageView) this.mRoot.findViewById(d.g.icon_7);
            this.gCt = (TbImageView) this.mRoot.findViewById(d.g.icon_8);
            this.gCu = (TbImageView) this.mRoot.findViewById(d.g.icon_9);
            this.gCv = (TbImageView) this.mRoot.findViewById(d.g.icon_10);
            this.gCw = (Button) this.mRoot.findViewById(d.g.btn_next);
            this.gCl.put(1, this.gCm);
            this.gCl.put(2, this.gCn);
            this.gCl.put(3, this.gCo);
            this.gCl.put(4, this.gCp);
            this.gCl.put(5, this.gCq);
            this.gCl.put(6, this.gCr);
            this.gCl.put(7, this.gCs);
            this.gCl.put(8, this.gCt);
            this.gCl.put(9, this.gCu);
            this.gCl.put(10, this.gCv);
            this.gCw.setOnClickListener(this.axG);
            this.gCm.setOnClickListener(this.axG);
            this.gCn.setOnClickListener(this.axG);
            this.gCo.setOnClickListener(this.axG);
            this.gCp.setOnClickListener(this.axG);
            this.gCq.setOnClickListener(this.axG);
            this.gCr.setOnClickListener(this.axG);
            this.gCs.setOnClickListener(this.axG);
            this.gCt.setOnClickListener(this.axG);
            this.gCu.setOnClickListener(this.axG);
            this.gCu.setOnClickListener(this.axG);
            this.gCv.setOnClickListener(this.axG);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.gCf.buj();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
