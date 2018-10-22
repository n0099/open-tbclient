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
    private View dqv;
    private NewUserGuideModel hiS;
    private TbImageView hjA;
    private TbImageView hjB;
    private TbImageView hjC;
    private TbImageView hjD;
    private Button hjE;
    private NewUserGuideActivity hjn;
    private TbImageView hju;
    private TbImageView hjv;
    private TbImageView hjw;
    private TbImageView hjx;
    private TbImageView hjy;
    private TbImageView hjz;
    private ViewGroup mRoot;
    private final Hashtable<Integer, TbImageView> hjt = new Hashtable<>();
    private boolean hiU = false;
    private boolean hjF = false;
    private boolean hjG = true;
    private final View.OnClickListener aOJ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
                if (view == NewUserGuideMainFragment.this.hjE) {
                    if (NewUserGuideMainFragment.this.hjn.bEp()) {
                        TbadkApplication.getInst().setLikeBarChanged(true);
                    }
                    NewUserGuideMainFragment.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(NewUserGuideMainFragment.this.hjn.getPageContext().getPageActivity()).createNewUserCfg(1, NewUserGuideMainFragment.this.hiU)));
                    NewUserGuideMainFragment.this.hjn.finish();
                }
            } else if (NewUserGuideMainFragment.this.hjG) {
                NewUserGuideMainFragment.this.hjG = false;
                TiebaStatic.log("newUserInterestSelect");
                f fVar = new f(NewUserGuideMainFragment.this.hjn, (InterestFrsData.Tag) view.getTag(), new a() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.1.1
                    @Override // com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment.a
                    public void bEx() {
                        NewUserGuideMainFragment.this.dqv.setVisibility(8);
                    }
                });
                NewUserGuideMainFragment.this.dqv.setVisibility(0);
                fVar.show();
                NewUserGuideMainFragment.this.hjG = true;
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void bEx();
    }

    public void c(InterestFrsData interestFrsData) {
        d(interestFrsData);
        this.hjF = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hjn = (NewUserGuideActivity) getBaseFragmentActivity();
        this.hiS = this.hjn.bEr();
        initData(bundle);
    }

    private void initData(Bundle bundle) {
        if (this.hiS != null && !this.hjF) {
            if (bundle != null) {
                this.hiU = bundle.getBoolean("is_new_user");
            } else {
                this.hiU = this.hjn.getIntent().getBooleanExtra("is_new_user", false);
            }
            d(this.hiS.bEz());
        }
    }

    private void d(InterestFrsData interestFrsData) {
        ArrayList<InterestFrsData.Tag> tag_list;
        TbImageView tbImageView;
        if (interestFrsData != null && (tag_list = interestFrsData.getTag_list()) != null && tag_list.size() != 0) {
            for (int i = 0; i < tag_list.size(); i++) {
                InterestFrsData.Tag tag = tag_list.get(i);
                if (tag.getBid() >= 1 && tag.getBid() <= 10 && (tbImageView = this.hjt.get(Integer.valueOf(tag.getBid()))) != null) {
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
            this.dqv = this.mRoot.findViewById(e.g.root_main_view_cover);
            this.hju = (TbImageView) this.mRoot.findViewById(e.g.icon_1);
            this.hjv = (TbImageView) this.mRoot.findViewById(e.g.icon_2);
            this.hjw = (TbImageView) this.mRoot.findViewById(e.g.icon_3);
            this.hjx = (TbImageView) this.mRoot.findViewById(e.g.icon_4);
            this.hjy = (TbImageView) this.mRoot.findViewById(e.g.icon_5);
            this.hjz = (TbImageView) this.mRoot.findViewById(e.g.icon_6);
            this.hjA = (TbImageView) this.mRoot.findViewById(e.g.icon_7);
            this.hjB = (TbImageView) this.mRoot.findViewById(e.g.icon_8);
            this.hjC = (TbImageView) this.mRoot.findViewById(e.g.icon_9);
            this.hjD = (TbImageView) this.mRoot.findViewById(e.g.icon_10);
            this.hjE = (Button) this.mRoot.findViewById(e.g.btn_next);
            this.hjt.put(1, this.hju);
            this.hjt.put(2, this.hjv);
            this.hjt.put(3, this.hjw);
            this.hjt.put(4, this.hjx);
            this.hjt.put(5, this.hjy);
            this.hjt.put(6, this.hjz);
            this.hjt.put(7, this.hjA);
            this.hjt.put(8, this.hjB);
            this.hjt.put(9, this.hjC);
            this.hjt.put(10, this.hjD);
            this.hjE.setOnClickListener(this.aOJ);
            this.hju.setOnClickListener(this.aOJ);
            this.hjv.setOnClickListener(this.aOJ);
            this.hjw.setOnClickListener(this.aOJ);
            this.hjx.setOnClickListener(this.aOJ);
            this.hjy.setOnClickListener(this.aOJ);
            this.hjz.setOnClickListener(this.aOJ);
            this.hjA.setOnClickListener(this.aOJ);
            this.hjB.setOnClickListener(this.aOJ);
            this.hjC.setOnClickListener(this.aOJ);
            this.hjC.setOnClickListener(this.aOJ);
            this.hjD.setOnClickListener(this.aOJ);
            return this.mRoot;
        } catch (InflateException e) {
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.hjn.bEt();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }
}
