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
import com.baidu.tieba.e;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.model.NewUserGuideModel;
import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes3.dex */
public class NewUserGuideMainFragment extends BaseFragment {
    private View dir;
    private NewUserGuideModel hbA;
    private NewUserGuideActivity hbV;
    private TbImageView hcc;
    private TbImageView hcd;
    private TbImageView hce;
    private TbImageView hcf;
    private TbImageView hcg;
    private TbImageView hch;
    private TbImageView hci;
    private TbImageView hcj;
    private TbImageView hck;
    private TbImageView hcl;
    private Button hcm;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hcb = new Hashtable<>();
    private boolean hbC = false;
    private boolean hcn = false;
    private boolean hco = true;
    private final View.OnClickListener aKh = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.hcm) {
                    if (NewUserGuideMainFragment.this.hbV.bBb()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.hbV.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.hbC)));
                    NewUserGuideMainFragment.this.hbV.finish();
                }
            } else if (NewUserGuideMainFragment.this.hco) {
                NewUserGuideMainFragment.this.hco = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.hbV, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bBj() {
                        NewUserGuideMainFragment.this.dir.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.dir.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.hco = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bBj();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hcn = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbV = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hbA = this.hbV.bBd();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hbA != null && !this.hcn) {
            if (bundle != null) {
                this.hbC = bundle.getBoolean("is_new_user");
            } else {
                this.hbC = this.hbV.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hbA.bBl());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hcb.get(Integer.valueOf(tag.getBid()))) != null) {
                    tbImageView.setTag(tag);
                    tbImageView.startLoad(tag.getBicon(), 21, false);
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            this.mRoot = (ViewGroup) LayoutInflater.from(layoutInflater.getContext()).inflate(e.h.guide_main, (ViewGroup) null);
            this.dir = this.mRoot.findViewById(e.g.root_main_view_cover);
            this.hcc = (TbImageView) this.mRoot.findViewById(e.g.icon_1);
            this.hcd = (TbImageView) this.mRoot.findViewById(e.g.icon_2);
            this.hce = (TbImageView) this.mRoot.findViewById(e.g.icon_3);
            this.hcf = (TbImageView) this.mRoot.findViewById(e.g.icon_4);
            this.hcg = (TbImageView) this.mRoot.findViewById(e.g.icon_5);
            this.hch = (TbImageView) this.mRoot.findViewById(e.g.icon_6);
            this.hci = (TbImageView) this.mRoot.findViewById(e.g.icon_7);
            this.hcj = (TbImageView) this.mRoot.findViewById(e.g.icon_8);
            this.hck = (TbImageView) this.mRoot.findViewById(e.g.icon_9);
            this.hcl = (TbImageView) this.mRoot.findViewById(e.g.icon_10);
            this.hcm = (Button) this.mRoot.findViewById(e.g.btn_next);
            this.hcb.put(1, this.hcc);
            this.hcb.put(2, this.hcd);
            this.hcb.put(3, this.hce);
            this.hcb.put(4, this.hcf);
            this.hcb.put(5, this.hcg);
            this.hcb.put(6, this.hch);
            this.hcb.put(7, this.hci);
            this.hcb.put(8, this.hcj);
            this.hcb.put(9, this.hck);
            this.hcb.put(10, this.hcl);
            this.hcm.setOnClickListener(this.aKh);
            this.hcc.setOnClickListener(this.aKh);
            this.hcd.setOnClickListener(this.aKh);
            this.hce.setOnClickListener(this.aKh);
            this.hcf.setOnClickListener(this.aKh);
            this.hcg.setOnClickListener(this.aKh);
            this.hch.setOnClickListener(this.aKh);
            this.hci.setOnClickListener(this.aKh);
            this.hcj.setOnClickListener(this.aKh);
            this.hck.setOnClickListener(this.aKh);
            this.hck.setOnClickListener(this.aKh);
            this.hcl.setOnClickListener(this.aKh);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hbV.bBf();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
